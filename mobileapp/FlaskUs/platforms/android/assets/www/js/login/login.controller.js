(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout'];


    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout) {
        /* jshint validthis: true */
        var self = this;

        $scope.doLogin = function ($scope) {
            LoginService.authenticateUser($scope).then(function (respData) {
                console.log(respData.data.message);
                // $scope.user = respData.data;
                if (respData.data.message == "Authenticated access required") {
                    console.log("Authentication failed");
                    $state.go("app.login");
                    var myPopup = $ionicPopup.show({
                        title: '<p class="login_error">Incorrect Username or Password</p>'
                    });

                    $timeout(function () {
                        myPopup.close(); //close the popup after 3 seconds for some reason
                    }, 3000);
                    document.login_form.reset();
                }

                else {
                    $state.go("app.events");
                    document.login_form.reset();
                }
            });
        }
    };
})();

