(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('ForgotPasswordCtrl', ForgotPasswordCtrl);

    ForgotPasswordCtrl.$inject = ['$scope', '$state', '$http', 'SERVER', '$flaskUtil', '$ionicLoading', '$timeout', 'LoginService', '$cookies'];

    / @ngInject /
    function ForgotPasswordCtrl($scope, $state, $http, SERVER, $flaskUtil, $ionicLoading, $timeout, LoginService, $cookies) {
        $scope.user = {'email':''};
        $scope.sendForgotpasswordLink = function () {
            LoginService.forgotPasswordFunction($scope.user.email).then(function (response) {
                if (response == true) {
                    showToastMessage("Password reset link is sent to email");
                    $cookies.put("ForgotPasswordUserEmail", $scope.user.email);
                    $timeout(function () {
                        $state.go("app.reset_password");
                    }, 1000);
                }
                else {
                    showToastMessage("Email id not registered");
                }
            });
        }

        function showToastMessage(message) {
            if (message.length > 0) {
                $ionicLoading.show({ template: message, noBackdrop: true, duration: 2000 });
            }
        }
    

    }
})();
