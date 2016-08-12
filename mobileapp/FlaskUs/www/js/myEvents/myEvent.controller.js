(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_eventsCtrl', my_eventsCtrl);

    my_eventsCtrl.$inject = ['$scope', 'myEventService', '$state', '$cookies'];

    /* @ngInject */
    function my_eventsCtrl($scope, myEventService, $state, $cookies) {
        var self = this;
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
                    if (respData.data.length.Events == undefined) {
                    $scope.myNoEventError = true;
                }
                console.log(respData.data);
            });
        }

        $scope.searchBox = { showBox: false };
    }
})();

