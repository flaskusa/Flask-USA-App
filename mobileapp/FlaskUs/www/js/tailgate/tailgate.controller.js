(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_tailgateCtrl', my_tailgateCtrl);

    my_tailgateCtrl.$inject = ['$scope', 'TailgateService', '$state', '$ionicSlideBoxDelegate', '$cookieStore'];

    /* @ngInject */
    function my_tailgateCtrl($scope, TailgateService, $state, $ionicSlideBoxDelegate, $cookieStore) {
        var self = this;
        $scope.myTailgate = [];
        var userResponse = $cookieStore.get('CurrentUser');
        var UserId = userResponse.data.userId;
        getAlltailgates();

        function getAlltailgates() {
            TailgateService.getMyTailgates(UserId).then(function (respData) {
                $scope.allTailgate = respData.data;
                console.log(respData.data);
            });
        }
    }
})();

