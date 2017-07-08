(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_registrationCtrl', user_registrationCtrl);
    user_registrationCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout', 'ionicDatePicker', '$filter', '$cookies', '$ionicLoading','$state','$flaskUtil'];

    /* @ngInject */
    function user_registrationCtrl($scope, UserService, $ionicPopup, $timeout, ionicDatePicker, $filter, $cookies, $ionicLoading,$state,$flaskUtil) {
        $scope.user={firstName:"",lastName:"",Email:"",password1:"",password2:"",DOB:"",isMale:true,areaCode:"",mobileNumber:""}
        $scope.saveUser = function (user) {
            var srcname = user.mobileNumber.replace(/\s/g,'') + user.firstName.replace(/\s/g,'') + user.lastName.replace(/\s/g,'');
            UserService.saveUser(user, srcname).then(function (respData) {
                // $scope.user = respData.data;
                if (respData.data.exception == "com.liferay.portal.DuplicateUserEmailAddressException" || respData.data.exception=="com.liferay.portal.UserScreenNameException") {
                    $flaskUtil.alert("User already exist");
                }
                else if (respData.data.message == "com.liferay.portal.UserPasswordException") {
                    $ionicLoading.show({ template: "Password and confirm password did not match", noBackdrop: false, duration: 3000 });
                }
                else if (respData.data.message == "No JSON web service action associated with path /flaskadmin/sign-up and method GET for //flask-rest-users-portlet") {
                    $ionicLoading.show({ template: "Please fill all the fields", noBackdrop: false, duration: 2000 });
                }
                else {
                    $ionicLoading.show({ template: "User registered successfully!", noBackdrop: false, duration: 2000 });
                    $timeout(function () {
                        $state.go("app.login");
                    },2200);
                }
            });
            // document.register_user_form.reset();
        }

        $scope.checkUserByEmailId = function (emailId) {
            UserService.getUserbyEmail(emailId).then(function (respData) {
                if (respData.data == 1) {
                    var myPopup = $ionicPopup.show({
                        title: '<p class="login_error">Email Address is already exist.</p>'
                    });

                    $timeout(function () {
                        myPopup.close(); //close the popup after 3 seconds for some reason
                    }, 3000);

                }
            });
        }

        $scope.openDatePickerOne = function (val) {
            var ipObj1 = {
                callback: function (val) {  //Mandatory
                    var currDate = $filter('date')(val, 'MM-dd-yyyy');
                    $scope.user.DOB=currDate;
                    //var date1 = new Date(val);
                    // $scope.user.DOB = $filter('date1')(date1, 'yyyy-MM-dd');
                },
                from: new Date(1940, 1, 1),
                to: new Date(),
                inputDate: new Date(),
                mondayFirst: true,
                disableWeekdays: [],
                closeOnSelect: false,
                templateType: 'popup'
            };
            ionicDatePicker.openDatePicker(ipObj1);
        };

    }
})();






