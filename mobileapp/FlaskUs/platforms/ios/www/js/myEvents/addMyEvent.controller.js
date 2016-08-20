  (function () {
    'use strict';
    angular.module('flaskApp')
        .controller('addMyEventCtrl', addMyEventCtrl);

    addMyEventCtrl.$inject = ['$scope', '$state', 'myEventService', '$timeout'];

    /* @ngInject */
    function addMyEventCtrl($scope, $state, myEventService, $timeout) {
        $scope.myEvent = [];
        $scope.myFilteredEvent = [];
        addEvent();
        function addEvent() {
            myEventService.getAllEvents().then(function (respData) {
                $scope.myEvent = respData.data.Events;
                console.log(respData.data.Events);

                for (var i = 0; i<=$scope.myEvent.length; i++){
                    if ($scope.myEvent[i].userEvent == "0") {
                        $scope.myFilteredEvent.push($scope.myEvent[i]);
                    }
                }
            });
        }
        
        $scope.searchBox = { showBox: false };

        $scope.addmyEvent = function (eventId, index) {
            myEventService.addUserEvent(eventId).then(function (respData) {
                //$scope.myEvent = respData.data.Events;
                $scope.myFilteredEvent.splice(index, 1);
                $scope.AddedSuccess = true;
                $timeout(function () { $scope.AddedSuccess = false; }, 3000);
            });
        }
    }
})();

