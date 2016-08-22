  (function () {
    'use strict';
    angular.module('flaskApp')
        .controller('addMyEventCtrl', addMyEventCtrl);

    addMyEventCtrl.$inject = ['$scope', '$state', 'myEventService', '$timeout', 'SERVER', '$filter', '$ionicLoading'];

    /* @ngInject */
    function addMyEventCtrl($scope, $state, myEventService, $timeout, SERVER, $filter,$ionicLoading) {
        /* jshint validthis: true */
        var self = this;
        $scope.allEvents = [];
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        var currentDate = new Date();/*Today's Date*/
        $scope.startDate = $filter('date')(new Date(), 'yyyy-MM-dd h:mm');
        currentDate.setDate(currentDate.getDate() - 1); /*adding days to today's date*/
        $scope.startDate = $filter('date')(currentDate, 'yyyy-MM-dd h:mm');
        $scope.eventTypeIds = '';
        $scope.searchString = 'a';
        $scope.latitude = '42.34';
        $scope.longitude = '83.0456';
        currentDate.setDate(currentDate.getDate() + 60); /*adding days to today's date*/
        $scope.endDate = $filter('date')(currentDate, 'yyyy-MM-dd h:mm');

        $scope.myEvent = [];
        $scope.myFilteredEvent = [];
        showEvents();
        function showEvents() {
            myEventService.getAllEvents($scope.eventTypeIds, $scope.startDate, $scope.endDate, $scope.searchString, $scope.latitude, $scope.longitude).then(function (respData) {
                $scope.myEvent = respData.data.Events;
                console.log(respData.data.Events);

                for (var i = 0; i<=$scope.myEvent.length; i++){
                    if ($scope.myEvent[i].userEvent == "0") {
                        $scope.myFilteredEvent.push($scope.myEvent[i]);
                    }
                    if( $scope.myFilteredEvent.length=="0")
                    {
                        $scope.Add_Event_Error = true;
                    }
                    else {
                        $scope.Add_Event_Error = false;
                    }
                }
            });
        }
        
        $scope.searchBox = { showBox: false };

        $scope.addmyEvent = function (eventId, index) {
            myEventService.addUserEvent(eventId).then(function (respData) {
                //$scope.myEvent = respData.data.Events;
                $scope.myFilteredEvent.splice(index, 1);
             //   $scope.AddedSuccess = true;
                //    $timeout(function () { $scope.AddedSuccess = false; }, 3000);
                $ionicLoading.show({ template: 'Event Successfully Added!', noBackdrop: false, duration: 2000 });
            });
        }
    }
})();

