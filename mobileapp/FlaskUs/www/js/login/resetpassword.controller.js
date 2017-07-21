(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('resetPasswordCtrl', resetPasswordCtrl);

    resetPasswordCtrl.$inject = ['$scope', '$state', '$http', 'SERVER', '$flaskUtil', '$ionicLoading', '$timeout', 'LoginService', '$cookies'];

    / @ngInject /
    function resetPasswordCtrl($scope, $state, $http, SERVER, $flaskUtil, $ionicLoading, $timeout, LoginService, $cookies) {
        $scope.resetPassword = { 'email': '', 'newPassword': '', 'confirmNewPassword': '', 'otp': '' };
        $scope.resetPassword.email = $cookies.get("ForgotPasswordUserEmail");
        $scope.resetPasswordLink = function () {
            //console.log($scope.resetPassword);
            LoginService.resetPasswordFuntion($scope.resetPassword.email, $scope.resetPassword.newPassword, $scope.resetPassword.confirmNewPassword, $scope.resetPassword.otp).then(function (response) {
                    if (response == true) {
                        showToastMessage("Password reset Successfully !!");
                        $timeout(function () {
                            $state.go("app.login");
                        }, 2000)
                    } else {
                        if (response.exception == "com.liferay.portal.NoSuchUserException") {
                            showToastMessage("No User exists with Email" + $scope.resetPassword.email );
                        } else {
                            showToastMessage(response.message);
                        }                     
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
