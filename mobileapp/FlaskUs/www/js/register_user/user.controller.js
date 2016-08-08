(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_registrationCtrl', user_registrationCtrl);
    user_registrationCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout'];
    /* @ngInject */
    function user_registrationCtrl($scope, UserService, $ionicPopup, $timeout) {
        var gender = true;
        $scope.saveUser = function (user) {
            console.log(user);
            if (user.isMale == 'male') {
                gender = true;
                //$scope.isMale = male;
            }
            else { gender = false; }
            console.log(gender);
            $scope.srcname = user.mobileNumber + user.firstName + user.lastName;
            console.log($scope.srcname);
            UserService.saveUser(user, gender, $scope.srcname).then(function (respData) {
                console.log(respData.data.exception);
                // $scope.user = respData.data;
                if (respData.data.exception == "com.liferay.portal.DuplicateUserEmailAddressException" || respData.data.exception == "com.liferay.portal.DuplicateUserScreenNameException") {
                    console.log("User is already exist");
                    //$state.go("app.login");
                    
                }
            });
            document.register_user_form.reset();
        }

        $scope.checkUserByEmailId = function (user) {
            UserService.getUserbyEmail(user).then(function (respData) {
                console.log(respData.data);
                if (respData.data == 1) {
                    console.log("User is already exist");
                    var myPopup = $ionicPopup.show({
                        title: '<p class="login_error">Email Address is already exist.</p>'
                    });

                    $timeout(function () {
                        myPopup.close(); //close the popup after 3 seconds for some reason
                    }, 3000);
                    document.register_user_form.reset();
                }
            });
        }
    }
})();

