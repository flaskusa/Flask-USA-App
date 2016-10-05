(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('account_settingsCtrl', account_settingsCtrl);
    account_settingsCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout', 'ionicDatePicker', '$filter', '$cookies', '$ionicLoading', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService'];

    /* @ngInject */
    function account_settingsCtrl($scope, UserService, $ionicPopup, $timeout, ionicDatePicker, $filter, $cookies, $ionicLoading, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService) {
        var gender = true;
        $scope.country = [];
        $scope.state = [];
        var countryArray;
        var stateArray;
        $scope.cId = [];
        $scope.sId = [];
        $scope.sport = [];
        $scope.level = [];
        $scope.concert = [];
        $scope.interest = [];
        var interestArray;
        $scope.isProfileSelectedToUpload = false;

        var usercookie = $cookies.getObject('CurrentUser');
        $scope.userid = usercookie.data.userId;

        getUser();
        getCountry();

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

        $scope.getState = function (data, country_Name) {
            $scope.cId = country_Name.countryId;
            UserService.getRegion($scope.cId).then(function (respData) {
                $scope.state = respData.data;
            });
        }

        $scope.getStateId = function (data, state_Name) {
            $scope.sId = state_Name.regionId;
        }

        function getUser(userId) {
            UserService.getUserById($scope.userid).then(function (respData) {
                $scope.userInfo = respData;
                $scope.user = {
                    firstName: $scope.userInfo.firstName,
                    middleName: $scope.userInfo.middleName,
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
                + '</div>'
            + '</div>';
            $scope.cameraPopup = $ionicPopup.show({
                template: customTemplate,
                title: 'Choose Picture',
                scope: $scope
            });
            IonicClosePopupService.register($scope.cameraPopup);
        };

        $scope.removePicture = function () {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Remove tailgate logo ?',
            });

            confirmPopup.then(function (res) {
                if (res) {
                    $scope.cameraPopup.close();
                    TailgateService.removeTailgateLogo().then(function (res) {
                        $scope.tailgateLogoId = 0;
                    }, function (err) {
                        // show alert can not delete logo
                    })
                } else {
                    $scope.cameraPopup.close();
                }
            });
            IonicClosePopupService.register(confirmPopup);
        }
        //camera plugin
        $scope.camera = function () {
            $scope.cameraPopup.close();
            $scope.checkPermission();
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
                correctOrientation: true,
            };

            $cordovaCamera.getPicture(options).then(function (imageURI) {
                $scope.setSelectedProfileURIToUpload(imageURI);
            }, function (err) {
                alert("error")
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
                saveToPhotoAlbum: true,
                correctOrientation: false
            };
            $cordovaCamera.getPicture(options).then(function (imageURI) {
                $scope.setSelectedProfileURIToUpload(imageURI);
            }, function (err) {

            });

        }
        $scope.setSelectedProfileURIToUpload = function (imageURI) {
            $scope.defaultProfileUrl = imageURI;
            $scope.isProfileSelectedToUpload = true;
            $scope.selectedProfileURIToUpload = imageURI;
        };
        $scope.reSetSelectedProfileURIToUpload = function () {
            $scope.isProfileSelectedToUpload = false;
            $scope.selectedProfileURIToUpload = '';
        }

        

        $scope.uploadFileToServer = function (fileURL) {
            var options = {};
            options.fileKey = "file";
            var params = {};
            params.userid = $scope.userid;           
            options.params = params;
            $cordovaFileTransfer.upload(encodeURI(SERVER.url + '/flask-rest-users-portlet.flaskadmin/upload-user-profile'), fileURL, options)
                  .then(function (r) {
                      $rootScope.$broadcast('loading:hide')
                      $scope.reSetSelectedProfileURIToUpload();
                      $scope.downloadProgress = 0;
                      var data = $.parseJSON(r.response);
                      var repositoryId = data.repositoryId;
                      var folderId = data.folderId;
                      var title = data.title;
                      $scope.setLogoImageUrl(repositoryId, folderId, title);
                  }, function (error) {
                      $scope.reSetSelectedProfileURIToUpload();
                      $rootScope.$broadcast('loading:hide')
                      alert("An error has occurred: Code = " + error.code);
                      console.log("upload error source " + error.source);
                      console.log("upload error target " + error.target);
                  }, function (progress) {
                      

                  });
        }
        $scope.setLogoImageUrl = function (repositoryId, folderId, title) {
            $scope.tailgateLogoUrl = SERVER.hostName + "documents/" + repositoryId + "/" + folderId + "/" + title;
        }

        $scope.updateUserInfo = function (user, userId) {
            if (user.isMale == 'male') {
                gender = true;
            }
            else { gender = false; }
            UserService.updateUser(user, $scope.userid, gender, $scope.cId, $scope.sId, interestArray).then(function (respData) {
                
                $scope.userInfo = respData.data;
                if ($scope.userInfo.message == "No JSON web service action associated with path /flaskadmin/update-flask-user and method GET for //flask-rest-users-portlet") {
                    $ionicLoading.show({ template: 'Please Fill All The Fields', noBackdrop: false, duration: 2000 });
                }
                else {
                    $ionicLoading.show({ template: 'User Updated Successfully!', noBackdrop: false, duration: 2000 });
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






