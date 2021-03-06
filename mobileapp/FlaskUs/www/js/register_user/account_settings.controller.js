﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('account_settingsCtrl', account_settingsCtrl);
    account_settingsCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout', 'ionicDatePicker', '$filter', '$cookies', '$ionicLoading', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService','SERVER','$rootScope','$flaskUtil','$http','$localStorage'];

    /* @ngInject */
    function account_settingsCtrl($scope, UserService, $ionicPopup, $timeout, ionicDatePicker, $filter, $cookies, $ionicLoading, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService,SERVER,$rootScope,$flaskUtil,$http,$localStorage) {
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
                $ionicLoading.show({ template: 'Unable to get user profile from server.', noBackdrop: false, duration: 2000 });
            })
        }

        $scope.getUserProfile($scope.userid);
        $scope.data1 = [
          {
              sport: "Basketball",checked:false
          },
          {
              sport: "Baseball",checked:false

          },
          {
              sport: "Football",checked:false
          },
          {
              sport: "Hockey",checked:false
          },
          {
              sport: "Soccer",checked:false
          },
          {
              sport: "Tennis",checked:false
          }
        ];

        $scope.data2 = [
            {
                concerts: "Country",checked:false
            },
            {
                concerts: "Pop",checked:false
            },
            {
                concerts: "Rock",checked:false
            },
            {
                concerts: "Rap",checked:false
            },
            {
                concerts: "Alternative",checked:false
            },
            {
                concerts: "Electronic",checked:false
            }
        ];

        $scope.data3 = [

            {
                special_events: "Comedy",checked:false
            }
        ];

        $scope.data4 = [

           {
               level: "Professional",checked:false
           },
           {
               level: "College",checked:false
           }
        ];

        function getCountry() {
            UserService.getCountries().then(function (respData) {
                $scope.country = respData.data;
            });
        }

        $scope.getState = function (countryId) {
            if(countryId > 0) {
            UserService.getRegion(countryId).then(function (respData) {
                $scope.state = respData.data;
            });
            } else {
                $scope.state = [];
            }
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
                    countryId : respData.countryId,
                    stateId : respData.stateId
                }
                if(respData.userInterests.length > 1) {
                    $scope.interest = respData.userInterests.split(",");
                    setInterest($scope.interest);
                }
                if($scope.user.countryId !=undefined && $scope.user.countryId > 0) {
                    $scope.getState($scope.user.countryId);
                } else {
                    $scope.user.countryId = 0;
                    $scope.user.stateId = 0;
                }
            });
        }

        function setInterest(interest) {
           angular.forEach(interest,function(object,index) {
              if(object == "Basketball") {
                  setData1(object);
              } else if("Baseball" == object) {
                   setData1(object);
              }else if("Football" == object) {
                    setData1(object);
              }else if("Hockey" == object) {
                  setData1(object);
              }else if("Soccer" == object) {
                   setData1(object);
              }else if("Tennis" == object) {
                   setData1(object);
              }else if("Country" == object) {
                  setData2(object);
              }else if("Pop" == object) {
                  setData2(object);
              }else if("Rock" == object) {
                  setData2(object);
              }else if("Rap" == object) {
                  setData2(object);
              }else if("Alternative" == object) {
                  setData2(object);
              }else if("Electronic" == object) {
                  setData2(object);
              }else if("Comedy" == object) {
                 setData3(object);
              }else if("Professional" == object) {
                  setData4(object);
              }else if("College" == object) {
                  setData4(object);
              }
           })
        }

        function setData1(object) {
            angular.forEach($scope.data1, function(value,index) {
                if(value.sport == object){
                    value.checked = true;
                }
            })
        }
         function setData2(object) {
             angular.forEach($scope.data2, function(value,index) {
                if(value.concerts == object){
                    value.checked = true;
                }
            })
        }
         function setData3(object) {
             angular.forEach($scope.data3, function(value,index) {
                if(value.special_events == object){
                    value.checked = true;
                }
            })
        }
         function setData4(object) {
             angular.forEach($scope.data4, function(value,index) {
                if(value.level == object){
                    value.checked = true;
                }
            })
        }


        $scope.addEventsInArray=function($index,data){
            $scope.interest.push(data.special_events);
            getInterests();
        }

        $scope.addConcertsInArray = function ($index, data) {
            $scope.interest.push(data.concerts);
            getInterests();
        }

        $scope.addlevelInArray = function ($index, data) {
            $scope.interest.push(data.level);
            getInterests();
        }

        $scope.addSportInArray = function ($index, data) {
            $scope.interest.push(data.sport);
            getInterests();
        }

        function getInterests() {
            interestArray = $scope.interest.toString();
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
                title: 'Remove profile picture ?'
            });

            confirmPopup.then(function (res) {
                if (res) {
                    $scope.cameraPopup.close();
                    UserService.removeProfilePicture($scope.userid).then(function (res) {

                        $scope.fileEntryId = 0;
                        $rootScope.userProfileUrl="";
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
            // var options = {
            //     quality: 50,
            //     destinationType: Camera.DestinationType.FILE_URI,
            //     sourceType: Camera.PictureSourceType.CAMERA,
            //     allowEdit: true,
            //     encodingType: Camera.EncodingType.JPEG,
            //     popoverOptions: CameraPopoverOptions,
            //     saveToPhotoAlbum: false,
            //     correctOrientation: true
            // };

            // $cordovaCamera.getPicture(options).then(function (imageURI) {
            //     $scope.uploadFileToServer(imageURI);
            // }, function (err) {
            //         $ionicLoading.show({ template: '<div style="text-transform: capitalize;">'+err+'</div>', noBackdrop: false, duration: 2000 });
            // });
            navigator.camera.getPicture(onSuccess, onFail, { 
                quality: 50,
                allowEdit: true,
                encodingType: Camera.EncodingType.JPEG,
                popoverOptions: CameraPopoverOptions,
                saveToPhotoAlbum: false,
                correctOrientation: true,
                destinationType: Camera.DestinationType.NATIVE_URI,
                targetWidth: 760,
                targetHeight: 760 
            });
        };

        function onSuccess(imageURI) {
            $scope.uploadFileToServer(imageURI);
        }

        function onFail(message) {
            $ionicLoading.show({ template: '<div style="text-transform: capitalize;">'+message+'</div>', noBackdrop: false, duration: 2000 });
        }

        $scope.checkPermission = function () {
            var hasPermission = false;
            var permissions = cordova.plugins.permissions;
            permissions.hasPermission(permissions.READ_EXTERNAL_STORAGE, checkPermissionCallback, null);
            function checkPermissionCallback(status) {
                if (!status.hasPermission) {
                    var errorCallback = function () {
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
                if(err=='has no access to assets'){
                    $ionicLoading.show({ template: '<div style="text-transform: capitalize;"> Please provide permission to Access Gallery</div>', noBackdrop: false, duration: 2000 });
                }else{
                    $ionicLoading.show({ template: '<div style="text-transform: capitalize;">'+err+'</div>', noBackdrop: false, duration: 2000 });
                }
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
                      $ionicLoading.show({ template: error, noBackdrop: false, duration: 2000 });
                  }, function (progress) {
                  });
        }
        
        $scope.setProfilePicture = function (groupId, uuid) {
            $scope.userProfileUrl = $scope.profileUrl + uuid + "&groupId="+groupId;
            $rootScope.userProfileUrl=$scope.userProfileUrl;
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
        function showToastMessage(message) {
            if (message.length > 0) {
                $ionicLoading.show({ template: message, noBackdrop: true, duration: 2000 });
            }
        }
        $scope.updateUserPassword = function(psform) {
            if($scope.userPassword.newPassword1 != $scope.userPassword.newPassword2) {
                $flaskUtil.alert("Confirm password did not match");
                return;
            }

            UserService.updatePasssword($scope.userid, $scope.userPassword).then(function (response) {
                if(response.data.message == "OK") {
                    $flaskUtil.alert("Password updated")
                    var userDetail=$cookies.getObject('CurrentUser');
                    var userEmail=userDetail.data.emailAddress;
                    var authdata = Base64.encode(userEmail + ':' + $scope.userPassword.newPassword1);
                    $cookies.put("authData",authdata);
                    $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
                    $localStorage['RememberUser'].password=$scope.userPassword.newPassword1;
                    $scope.userPassword = {'oldPassword' :'','newPassword1':'','newPassword2':''};
                    psform.$submitted=false;
                    psform.newPassword2.$touched=false;
                    psform.newPassword1.$touched=false




                } else if(response.data.message == "ConfirmPasswordError"){
                     $flaskUtil.alert("Confirm Password did not match");
                }
               
            });
        }
        var Base64 = {
            keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',
            encode: function (input) {
                var output = "";
                var chr1, chr2, chr3 = "";
                var enc1, enc2, enc3, enc4 = "";
                var i = 0;

                do {
                    chr1 = input.charCodeAt(i++);
                    chr2 = input.charCodeAt(i++);
                    chr3 = input.charCodeAt(i++);

                    enc1 = chr1 >> 2;
                    enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                    enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                    enc4 = chr3 & 63;

                    if (isNaN(chr2)) {
                        enc3 = enc4 = 64;
                    } else if (isNaN(chr3)) {
                        enc4 = 64;
                    }

                    output = output +
                        this.keyStr.charAt(enc1) +
                        this.keyStr.charAt(enc2) +
                        this.keyStr.charAt(enc3) +
                        this.keyStr.charAt(enc4);
                    chr1 = chr2 = chr3 = "";
                    enc1 = enc2 = enc3 = enc4 = "";
                } while (i < input.length);

                return output;
            },

            decode: function (input) {
                var output = "";
                var chr1, chr2, chr3 = "";
                var enc1, enc2, enc3, enc4 = "";
                var i = 0;

                // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
                var base64test = /[^A-Za-z0-9\+\/\=]/g;
                if (base64test.exec(input)) {
                    window.alert("There were invalid base64 characters in the input text.\n" +
                        "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                        "Expect errors in decoding.");
                }
                input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

                do {
                    enc1 = this.keyStr.indexOf(input.charAt(i++));
                    enc2 = this.keyStr.indexOf(input.charAt(i++));
                    enc3 = this.keyStr.indexOf(input.charAt(i++));
                    enc4 = this.keyStr.indexOf(input.charAt(i++));

                    chr1 = (enc1 << 2) | (enc2 >> 4);
                    chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                    chr3 = ((enc3 & 3) << 6) | enc4;

                    output = output + String.fromCharCode(chr1);

                    if (enc3 != 64) {
                        output = output + String.fromCharCode(chr2);
                    }
                    if (enc4 != 64) {
                        output = output + String.fromCharCode(chr3);
                    }

                    chr1 = chr2 = chr3 = "";
                    enc1 = enc2 = enc3 = enc4 = "";

                } while (i < input.length);

                return output;
            }
        };
    }
})();






