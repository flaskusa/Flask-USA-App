(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout', '$rootScope', '$cookies'];
    
    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout, $rootScope, $cookies) {
        /* jshint validthis: true */
        var self = this;
        $scope.Email = '';
        $scope.password = '';
       
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
                    console.log(usercookie);
                    $rootScope.userName = respData.data.firstName + respData.data.lastName;
                    $rootScope.userEmailId = respData.data.emailAddress;
                    $rootScope.show_login = true;
                    document.login_form.reset();
                    $state.go("app.events");
                }
            });
       }
    };
})();

