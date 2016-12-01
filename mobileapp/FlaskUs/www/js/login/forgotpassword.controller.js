(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('ForgotPasswordCtrl', ForgotPasswordCtrl);

    ForgotPasswordCtrl.$inject = ['$scope','$state','$http','SERVER','$flaskUtil', '$ionicLoading','$timeout'];

    / @ngInject /
    function ForgotPasswordCtrl($scope,$state, $http, SERVER, $flaskUtil,$ionicLoading,$timeout) {
        $scope.user = {'email':''};
        $scope.sendForgotpasswordLink = function() {
            $http.get(SERVER.url + "/flask-rest-users-portlet.flaskadmin/reset-password", { params: { 'email': $scope.user.email } })
                .then(function success(response) {
                    if(response.data.message == "OK"){
                        showToastMessage("Password reset link is sent to email");
                        $timeout(function() {
                            $state.go("app.login");
                        },2000)
                    }
                    else if(response.data.message == "EmailIdNotRegistered") {
                        $flaskUtil.alert("Email id not registered");
                    }else {
                         $state.go("app.login");
                    }
                }, function failure(response) {
                    console.log("failed");
                });
        }

        function showToastMessage(message) {
            if (message.length > 0) {
                $ionicLoading.show({ template: message, noBackdrop: true, duration: 2000 });
            }
        }
    

    }
})();
