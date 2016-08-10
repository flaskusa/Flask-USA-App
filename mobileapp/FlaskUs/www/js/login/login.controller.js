(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout', '$rootScope', '$cookieStore'];
    
    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout, $rootScope, $cookieStore) {
        /* jshint validthis: true */
        var self = this;
        $scope.Email = '';
        $scope.password = '';
       
        $scope.doLogin = function (user) {
            LoginService.authenticateUser(user).then(function (respData) {
                //document.login_form.reset();
               
                console.log(respData);
                // $scope.user = respData.data;
                if (respData.data.message == "Authenticated access required") {
                    showAlert();
                }
                else if (respData.data.emailAddress == "") {
                }
                else {
                    $cookieStore.put('CurrentUser', respData);
                    var usercookie = $cookieStore.get('CurrentUser');
                    console.log(usercookie);
                    $rootScope.userName = respData.data.firstName + respData.data.lastName;
                    $rootScope.userEmailId = respData.data.emailAddress;
                    $rootScope.show_login = true;
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
                document.login_form.reset();     
           });
       };
    };
})();

