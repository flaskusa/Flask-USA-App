(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('account_settingsCtrl', account_settingsCtrl);
    account_settingsCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout', 'ionicDatePicker', '$filter', '$cookies', '$ionicLoading', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService','SERVER','$rootScope','$flaskUtil'];

    /* @ngInject */
    function account_settingsCtrl($scope, UserService, $ionicPopup, $timeout, ionicDatePicker, $filter, $cookies, $ionicLoading, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService,SERVER,$rootScope,$flaskUtil) {
        var gender = true;
        $scope.country = [];
        $scope.state = [];
        var countryArray;
        var stateArray;
        $scope.sport = [];
        $scope.level = [];
        $scope.concert = [];
        $scope.interest = [];
        $scope.userPassword = {'oldPassword' :'','newPassword1':'','newPassword2':''};
        var interestArray = "";
         $scope.userProfileUrl = "";
         $scope.profileUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.isMobile = {
            Android: function () {
                return ionic.Platform.isAndroid();
            },
            iOS: function () {
                return ionic.Platform.isIOS();
            },
            Windows: function () {
                return ionic.Platform.isWindowsPhone();
            }
        };

        $scope.isProfileSelectedToUpload = false;

        var usercookie = $cookies.getObject('CurrentUser');
        $scope.userid = usercookie.data.userId;

        getUser();
        getCountry();

        $scope.getUserProfile = function(userId) {
            UserService.getUserProfile(userId).then(function(res) {
                if(res.data.fileEntryId != undefined) {
                    $scope.fileEntryId =  res.data.fileEntryId;
                    $scope.userProfileUrl = $scope.profileUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                }else {
                     $scope.fileEntryId = 0;
                }
            },function(err) {

            })
        }

        $scope.getUserProfile($scope.userid);
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

        function getCountry() {
            UserService.getCountries().then(function (respData) {
                $scope.country = respData.data;
                
            });
        }

        $scope.getState = function (countryId) {
            UserService.getRegion(countryId).then(function (respData) {
                $scope.state = respData.data;
            });
        }

        $scope.getStateId = function (data, state_Name) {
            $scope.sId = state_Name.regionId;
        }

        function getUser() {
            UserService.getUserById($scope.userid).then(function (respData) {
                $scope.user = {
                    firstName: respData.firstName,
                    middleName: respData.middleName,
                    lastName: respData.lastName,
                    screenName: respData.screenName,
                    Email: respData.email,
                    password1: "",
                    password2: "",
                    DOB: $filter('date')(respData.DOB, 'MM-dd-yyyy'),
                    isMale: respData.isMale,
                    areaCode: respData.areaCode,
                    mobileNumber: parseInt(respData.mobileNumber),
                    streetName: respData.streetName,
                    aptNo: respData.aptNo,
                    city: respData.city,
                    countryId : "-1",
                    stateId : '-1'
                }
            });
        }

        $scope.addEventsInArray=function($index,data){
            console.log(data.special_events);
            $scope.interest.push(data.special_events);
            getInterests();
        }

        $scope.addConcertsInArray = function ($index, data) {
            console.log(data.concerts);
            $scope.interest.push(data.concerts);
            console.log($scope.interest);
            getInterests();
        }

        $scope.addlevelInArray = function ($index, data) {
            $scope.interest.push(data.level);
            console.log($scope.interest);
            getInterests();
        }

        $scope.addSportInArray = function ($index, data) {
            $scope.interest.push(data.sport);
            console.log($scope.interest);
            getInterests();
        }

        function getInterests() {
            console.log($scope.interest);
            interestArray = $scope.interest.toString();
            console.log(interestArray);
        }

        $scope.show = function () {
            // Show the action sheet
            $scope.loc = {};
            var customTemplate =
              '<div class="list">'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="camera();">'
                + 'Camera'
                + '</button>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="gallery();">'
                + 'Gallery'
                + '</button>'
                + "<button nav-clear class='button button-block button-positive pay_now_button' ng-click='removePicture();' ng-if= 'fileEntryId > 0'>"
                + 'Remove Picture'
                + '</button>'
                + '</div>'
            + '</div>';
            $scope.cameraPopup = $ionicPopup.show({
                template: customTemplate,
                cssClass : 'no-popup-header',
                scope: $scope
            });
            IonicClosePopupService.register($scope.cameraPopup);
        };

        $scope.removePicture = function () {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Remove profile picture ?',
            });

            confirmPopup.then(function (res) {
                if (res) {
                    $scope.cameraPopup.close();
                    UserService.removeProfilePicture($scope.userid).then(function (res) {
                        $scope.fileEntryId = 0;
                    }, function (err) {
                        // show alert can not delete logo
                    })
                } else {
                    $scope.cameraPopup.close();
                }
            });
            IonicClosePopupService.register(confirmPopup);
        }

        $scope.camera = function () {
            $scope.cameraPopup.close();
            if ($scope.isMobile.Android()) {
                $scope.checkPermission();
            } else if ($scope.isMobile.iOS()) {
                $scope.openCamera();
            }
        }
        $scope.openCamera = function () {
            var options = {
                quality: 50,
                destinationType: Camera.DestinationType.FILE_URI,
                sourceType: Camera.PictureSourceType.CAMERA,
                allowEdit: true,
                encodingType: Camera.EncodingType.JPEG,
                popoverOptions: CameraPopoverOptions,
                saveToPhotoAlbum: false,
                correctOrientation: true
            };

            $cordovaCamera.getPicture(options).then(function (imageURI) {
                $scope.uploadFileToServer(imageURI);
            }, function (err) {

            });
        };
        $scope.checkPermission = function () {
            var hasPermission = false;
            var permissions = cordova.plugins.permissions;
            permissions.hasPermission(permissions.READ_EXTERNAL_STORAGE, checkPermissionCallback, null);
            function checkPermissionCallback(status) {
                if (!status.hasPermission) {
                    var errorCallback = function () {
                        console.warn('READ_EXTERNAL_STORAGE permission is not turned on');
                    }

                    permissions.requestPermission(
                        permissions.READ_EXTERNAL_STORAGE,
                        function (status) {
                            if (!status.hasPermission) {
                                errorCallback();
                            } else {
                                $scope.openCamera();
                                hasPermission = status.hasPermission;
                            }
                        },
                        errorCallback);
                } else {
                    hasPermission = status.hasPermission;
                    $scope.openCamera();
                }
            }
            return hasPermission;
        };
        // for accessing gallery on mobile
        $scope.gallery = function () {
            $scope.cameraPopup.close();
            var options = {
                destinationType: Camera.DestinationType.FILE_URI,
                sourceType: Camera.PictureSourceType.PHOTOLIBRARY,
                allowEdit: true,
                popoverOptions: CameraPopoverOptions,
                saveToPhotoAlbum: false,
                correctOrientation: false
            };
            $cordovaCamera.getPicture(options).then(function (imageURI) {
                $scope.uploadFileToServer(imageURI);
            }, function (err) {

            });

        }

        $scope.uploadFileToServer = function (fileURL) {
             $rootScope.$broadcast('loading:show');
            var options = {};
            options.fileKey = "file";
            var authdata = $cookies.get("authData");
            var headers = {};
            headers.Authorization = 'Basic ' + authdata;
            options.headers = headers;
            $cordovaFileTransfer.upload(encodeURI(SERVER.url + '/flask-rest-users-portlet.flaskadmin/upload-user-profile'), fileURL, options)
                  .then(function (r) {
                      $rootScope.$broadcast('loading:hide')
                      var data = $.parseJSON(r.response);
                      $scope.fileEntryId =  data.fileEntryId;
                      $scope.setProfilePicture(data.groupId, data.uuid);
                      showToastMessage("Profile Picture updated");
                  }, function (error) {
                      $rootScope.$broadcast('loading:hide')
                      alert("An error has occurred");
                  }, function (progress) {
                  });
        }
        
        $scope.setProfilePicture = function (groupId, uuid) {
            $scope.userProfileUrl = $scope.profileUrl + uuid + "&groupId="+groupId;
        }

        $scope.updateUserInfo = function (user, userId) {
            UserService.updateUser(user, $scope.userid, interestArray).then(function (respData) {
                
                $scope.userInfo = respData.data;
                if (respData.data.userId == undefined) {
                    $flaskUtil.alert("Failed to update.");
                }
                else {
                    $ionicLoading.show({ template: 'User Updated Successfully!', noBackdrop: false, duration: 2000 });
                }
            });
        }

        $scope.openDatePickerOne = function (val) {
            var ipObj1 = {
                callback: function (val) { 
                    var currDate = $filter('date')(val, 'MM-dd-yyyy');
                    $scope.user.DOB = currDate;
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
        function showToastMessage(message) {
            if (message.length > 0) {
                $ionicLoading.show({ template: message, noBackdrop: true, duration: 2000 });
            }
        }
        $scope.updateUserPassword = function() {
            if($scope.userPassword.newPassword1 != $scope.userPassword.newPassword2) {
                $flaskUtil.alert("Confirm password did not match").
                return;
            }
            UserService.updatePasssword($scope.userid, $scope.userPassword).then(function (response) {
                if(response.data.message == "updated") {
                    $flaskUtil.alert("Password updated.")
                } else {
                     $flaskUtil.alert("Failed to update password.")
                }
               
            });
        }
    }
})();






