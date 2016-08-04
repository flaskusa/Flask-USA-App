(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_registrationCtrl', user_registrationCtrl);
    user_registrationCtrl.$inject = ['$scope', 'UserService'];    
    /* @ngInject */
    function user_registrationCtrl($scope, UserService) {
        var gender = true;
        $scope.saveUser = function (user) {
            console.log(user);
            if (user.isMale == 'male') {
                gender = true;
                //$scope.isMale = male;
            }
            else { gender = false; }
            console.log(gender);
            $scope.srcname = user.firstName + user.lastName + user.mobileNumber;
            console.log($scope.srcname);
            UserService.saveUser(user, gender).then(function (respData) {
                console.log(respData.data.exception);
                // $scope.user = respData.data;
                if (respData.data.exception == "com.liferay.portal.DuplicateUserEmailAddressException" || respData.data.exception == "com.liferay.portal.DuplicateUserScreenNameException") {
                    console.log("User is already exist");
                   // $state.go("app.login");
                }
            });
            //document.register_user_form.reset();
        }

        $scope.checkUserByEmailId = function (user) {
            UserService.getUserbyEmail(user).then(function (respData) {
                console.log(respData.data.emailAddress);
                if (respData.data.emailAddress == user.email) {
                    console.log("User is already exist");
                    // $state.go("app.login");
                }
            });
        }
    }
})();

