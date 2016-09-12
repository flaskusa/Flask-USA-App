(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_tailgateCtrl', my_tailgateCtrl);

    my_tailgateCtrl.$inject = ['$scope', 'TailgateService', '$state', '$ionicSlideBoxDelegate', '$cookies'];

    /* @ngInject */
    function my_tailgateCtrl($scope, TailgateService, $state, $ionicSlideBoxDelegate, $cookies) {
        var self = this;
        $scope.myTailgate = [];
        var userResponse = $cookies.getObject('CurrentUser');
        var UserId = userResponse.data.userId;
        getAlltailgates();
        $scope.goBack = function () {
            $state.go("app.user_navigation_menu");
        }

        function getAlltailgates() {
            TailgateService.getMyTailgates(UserId).then(function (respData) {
                $scope.allTailgate = respData.data;
                console.log(respData.data);
            });
        }
    }
})();

