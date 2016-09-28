﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_registrationCtrl', user_registrationCtrl);
    user_registrationCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout', 'ionicDatePicker', '$filter', '$cookies', '$ionicLoading'];

    /* @ngInject */
    function user_registrationCtrl($scope, UserService, $ionicPopup, $timeout, ionicDatePicker, $filter, $cookies, $ionicLoading) {
        var gender = true;

        $scope.data1 = [
          {
              sport: "Basketball"
          },
          {
              sport: "Basebball"

          },
          {
              sport: "Football"
          },
          {
              sport: "Hockey"
          },
          {
              sport: "Soccer"
          },
          {
              sport: "Tennis"
          }
        ];

        $scope.data2 = [
            {
                concerts: "Country"
            },
            {
                concerts: "Pop"
            },
            {
                concerts: "Rock"
            },
            {
                concerts: "Rap"
            },
            {
                concerts: "Alternative"
            },
            {
                concerts: "Electronic"
            }
        ];

        $scope.data3 = [

            {
                special_events: "Comedy"
            }
        ];

        $scope.data4 = [

           {
               level: "Professional"
           },
           {
               level: "college"
           }
        ];

        $scope.saveUser = function (user) {
            if (user.isMale == 'male') {
                gender = true;
                //$scope.isMale = male;
            }
            else { gender = false; }
            console.log(gender);
            $scope.srcname = user.mobileNumber + user.firstName + user.lastName;
            UserService.saveUser(user, gender, $scope.srcname).then(function (respData) {
                // $scope.user = respData.data;
                if (respData.data.exception == "com.liferay.portal.DuplicateUserEmailAddressException" || respData.data.exception == "com.liferay.portal.DuplicateUserScreenNameException") {
                    console.log("User is already exist");
                    //$state.go("app.login");

                }
                else {
                    $ionicLoading.show({ template: 'User Registered Successfully!', noBackdrop: false, duration: 2000 });
                }
            });
            // document.register_user_form.reset();
        }

        $scope.checkUserByEmailId = function (user) {
            UserService.getUserbyEmail(user).then(function (respData) {
                if (respData.data == 1) {
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

        $scope.openDatePickerOne = function (val) {
            var ipObj1 = {
                callback: function (val) {  //Mandatory
                    var currDate = $filter('date')(val, 'MM-dd-yyyy');
                    $scope.user = { DOB: currDate };
                    //var date1 = new Date(val);
                    // $scope.user.DOB = $filter('date1')(date1, 'yyyy-MM-dd');
                },
                disabledDates: [
                  new Date("08-16-2016")

                ],
                from: new Date(1960, 1, 1),
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






