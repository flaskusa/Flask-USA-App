  (function () {
    'use strict';
    angular.module('flaskApp')
        .controller('addMyEventCtrl', addMyEventCtrl);

    addMyEventCtrl.$inject = ['$scope', '$state', 'myEventService', '$timeout'];

    /* @ngInject */
    function addMyEventCtrl($scope, $state, myEventService, $timeout) {
        $scope.myEvent = [];
        console.log("Inside service");
        addEvent();
        function addEvent() {
            myEventService.getAllEvents().then(function (respData) {
                $scope.myEvent = respData.data.Events;
                console.log(respData.data.Events);
            });
        }
        
        $scope.addmyEvent = function (eventId, index) {
            myEventService.addUserEvent(eventId).then(function (respData) {
                //$scope.myEvent = respData.data.Events;
                $scope.myEvent.splice(index, 1);
                console.log(respData);
                $scope.AddedSuccess = true;
                $timeout(function () { $scope.AddedSuccess = false; }, 3000);
            });
        }
    }
})();

