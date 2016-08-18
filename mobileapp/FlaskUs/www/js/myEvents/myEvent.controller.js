(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_eventsCtrl', my_eventsCtrl);

    my_eventsCtrl.$inject = ['$scope', 'myEventService', '$state', '$cookies', '$timeout','SERVER'];

    /* @ngInject */
    function my_eventsCtrl($scope, myEventService, $state, $cookies, $timeout, SERVER) {
        var self = this;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.myEvent = [];
        var userResponse = $cookies.get('CurrentUser');
        //var UserId = userResponse.data.userId;
        //console.log(UserId);
        getAllevents();

        function getAllevents() {
            myEventService.getMyEvents().then(function (respData) {
                $scope.myEvent = respData.data.Events;
                console.log(respData.data);
                if (respData.data.message == "Authenticated access required" )
                {
                    $scope.myEventError = true;
                } else
                    if (respData.data.Events == undefined) {
                    $scope.myNoEventError = true;
                }
                console.log(respData.data);
            });
        }

        $scope.removeEvent = function(eventId ,index) {
            myEventService.removeUserEvent(eventId).then(function (respData) {
                $scope.myEvent.splice(index, 1);
            });
        }
       
        $scope.searchBox = { showBox: false };
    }
})();

