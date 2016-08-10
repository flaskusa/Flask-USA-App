(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout', '$rootScope'];
    
    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout, $rootScope) {        
        /* jshint validthis: true */
        var self = this;
        $scope.Email = '';
        $scope.password = '';
        var showme = true;
        $scope.doLogin = function (user) {
            LoginService.authenticateUser(user).then(function (respData) {
                console.log(respData);
                // $scope.user = respData.data;
                if (respData.data.message == "Authenticated access required") {
                    console.log("Authentication failed");
                    showAlert();
                    $timeout(function () {
                        showAlert.close();
                    }, 3000);
                    document.login_form.reset();
                }
                else if (respData.data.emailAddress == "") {
                    showAlert();

                    $timeout(function () {
                        showAlert.close();
                    }, 2000);
                }
                else {
                    document.login_form.reset();
                    $state.go("app.events");
                }
            });
       }

       function showAlert() {
           var alertPopup = $ionicPopup.alert({
               title: 'Alert',
               template: 'Authentication failed ! Please Check Username and password'
           });

           alertPopup.then(function (res) {
               // Custom functionality....
               // getAllEvents();
           });
       };
    };
})();

