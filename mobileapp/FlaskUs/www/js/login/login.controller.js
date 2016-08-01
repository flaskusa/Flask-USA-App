(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService'];


    /* @ngInject */
    function LoginCtrl($scope, LoginService) {
        /* jshint validthis: true */
        var self = this;
        $scope.user = [];
        $scope.doLogin = function ($scope) {
            LoginService.authenticateUser($scope).then(function (respData) {
                $scope.user = respData.data;
            });
        }
    }
})();

