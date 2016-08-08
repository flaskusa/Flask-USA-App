(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout', '$rootScope'];
    

    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout, $rootScope) {
        
        /* jshint validthis: true */
        var self = this;
        $scope.doLogin = function ($scope) {
            LoginService.authenticateUser($scope).then(function (respData) {
                console.log(respData);
                // $scope.user = respData.data;
                if (respData.data.message == "Authenticated access required") {
                    console.log("Authentication failed");
                    
                    var myPopup = $ionicPopup.show({
                        title: '<p class="login_error">Incorrect Username or Password</p>',  
                    });

                    $timeout(function () {
                        myPopup.close();
                        
                    }, 3000);
                    document.login_form.reset();
                }

                else if (respData.data.emailAddress == "") {
                    var myPopup = $ionicPopup.show({
                        title: '<p class="login_error">Username or Password is empty</p>',
                    });

                    $timeout(function () {
                        myPopup.close();
                        
                    }, 3000);
                   
                }

                else {
                    $state.go("app.events");
                    $scope.Email = "";
                    $scope.password = "";
                    document.login_form.reset();
                }
            });
        }
    };
})();

