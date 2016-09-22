(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_registrationCtrl', user_registrationCtrl);
    user_registrationCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout', 'ionicDatePicker', '$filter', '$cookies'];

    /* @ngInject */
    function user_registrationCtrl($scope, UserService, $ionicPopup, $timeout, ionicDatePicker, $filter, $cookies) {
        var gender = true;

        var usercookie = $cookies.getObject('CurrentUser');
        console.log(usercookie.data.userId);
        var userid = usercookie.data.userId;

        getUser();

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
                $scope.AddedSuccess = true;
                $timeout(function () { $scope.AddedSuccess = false; }, 3000);
            });
            // document.register_user_form.reset();
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

        function getUser(userId) {
            UserService.getUserById(userid).then(function (respData) {
                $scope.userInfo = respData;
                console.log($scope.userInfo);
                $scope.user = {
                    firstName: $scope.userInfo.firstName,
                    lastName: $scope.userInfo.lastName,
                    screenName: $scope.userInfo.screenName,
                    Email: $scope.userInfo.email,
                    password1: "",
                    password2: "",
                    DOB: $filter('date')($scope.userInfo.DOB, 'MM-dd-yyyy'),
                    isMale: gender,
                    areaCode: $scope.userInfo.areaCode,
                    mobileNumber: $scope.userInfo.mobileNumber,
                    streetName: $scope.userInfo.streetName,
                    aptNo: $scope.userInfo.aptNo,
                    city: $scope.userInfo.city
                }
            });
        }

        $scope.updateUserInfo = function(){
            UserService.updateUser().then(function (respData) {
                $scope.userInfo = respData.data;
            });
        }
      
        $scope.openDatePickerOne = function (val) {
            var ipObj1 = {
                callback: function (val) {  //Mandatory
                    console.log('Return value from the datepicker popup is : ' + val, new Date(val), 'yyyy-MM-dd h:mm');
                    var currDate = $filter('date')(val, 'MM-dd-yyyy');
                    console.log(currDate);
                    $scope.user={DOB : currDate};
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






