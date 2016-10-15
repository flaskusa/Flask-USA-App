(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout', '$rootScope', '$cookies', '$ionicLoading', '$ionicPlatform', '$cordovaTouchID','SERVER'];
    
    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout, $rootScope, $cookies, $ionicLoading, $ionicPlatform, $cordovaTouchID,SERVER) {
        /* jshint validthis: true */
        var self = this;
        $scope.Email = '';
        $scope.password = '';
     
        $scope.checkTouch = function (enableChecked) {
            if (enableChecked) {
                $cordovaTouchID.checkSupport().then(function () {
                    $cordovaTouchID.authenticate("You must authenticate").then(function () {
                        alert("The authentication was successful");
                    }, function (error) {
                        console.log(JSON.stringify(error));
                    });
                }, function (error) {
                console.log(JSON.stringify(error));
             });
           }
        }
       
        $scope.doLogin = function (user) {
            LoginService.authenticateUser(user).then(function (respData) {
                if (respData.data.message == "Authenticated access required") {
                    $scope.Error = true;
                    $timeout(function () { $scope.Error = false; }, 3000);
                }
                else if (respData.data.emailAddress == "") {
                }
                else {
                    $cookies.putObject('CurrentUser', respData);
                    var usercookie = $cookies.getObject('CurrentUser');
                    $rootScope.userName = respData.data.firstName + respData.data.lastName;
                    $rootScope.userEmailId = respData.data.emailAddress;
                    $rootScope.show_login = true;
                    document.login_form.reset();
                    $state.go("app.user_navigation_menu");
                }
            });
        }

        $scope.remembered = function (isChecked, user) { 
            if (isChecked) {
                if(!user.Email=="" && !user.password==""){
                    $cookies.putObject('RememberUser', user);
                    var rcookie = $cookies.getObject('RememberUser');
                }
                else {
                    $ionicLoading.show({ template: 'Email and password should not be empty!', noBackdrop: false, duration: 2000 });
                }
            }
        }
    
    };
})();

