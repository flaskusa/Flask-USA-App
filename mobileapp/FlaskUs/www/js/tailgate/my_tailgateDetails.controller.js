﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService', '$rootScope','$ionicSlideBoxDelegate','$localStorage','UserService','$q','$http'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicPopup, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService, $rootScope,$ionicSlideBoxDelegate,$localStorage,UserService,$q,$http) {
        $cookies.remove("currtailGateMakers");
        $scope.myTailgaters = [];
        $scope.allMessages = [];
        $scope.userFirstName = [];
        $scope.messageUser = [];
        var userResponse = $cookies.getObject('CurrentUser');
        var tailGateId = $stateParams.tailgateId;
        var userId = [];
        var userMessage = [];
        $scope.uploadTailgateImagesUrl = SERVER.url + '/flask-user-tailgate-portlet.tailgateimages/upload-tailgate-image';
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        var geteventURL = "flask-rest-events-portlet.event/get-event";
        var getTailgateImagesURL = "flask-user-tailgate-portlet.tailgateimages/get-tailgate-images";
        var getTalgetUsersURL = "flask-user-tailgate-portlet.tailgateusers/get-tailgate-members";
        var getmapMarkersURL = "flask-user-tailgate-portlet.tailgatemarker/get-tailgate-marker";
        var getTailgateLogoURL = 'flask-user-tailgate-portlet.tailgateinfo/get-tailgate-logo';

        $scope.tailgateLogoUrl = "";
        $scope.usersMessages={message:""}
       
        $cookies.put('currtailGateId', tailGateId);


        $scope.isTailgateAdmin = false;
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
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
        $scope.showPopup = function (index) {
             $scope.data = {};
            $scope.currentIndex=index;
            $scope.myPopup = $ionicPopup.show({
                cssClass: 'custom-class custom-popup',
                templateUrl: 'templates/tailgateDetailImageSlider.html',
                scope: $scope
            });
            IonicClosePopupService.register($scope.myPopup);

            $scope.popupClose = function () {
                $scope.myPopup.close();
            }

        };
        $scope.slidePrevious1 = function (tailgateImageViewer) {
            $ionicSlideBoxDelegate.$getByHandle(tailgateImageViewer).previous();
        }

        $scope.slideNext1 = function (tailgateImageViewer) {
            $ionicSlideBoxDelegate.$getByHandle(tailgateImageViewer).next();
        }


        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.myTailgate = respData.data;
                var  getEvent= $http.get(SERVER.url +geteventURL, { params:{'eventId': $scope.myTailgate.eventId} });
                var getTailgateImages= $http.get(SERVER.url +getTailgateImagesURL, { params:{'tailgateId': tailGateId} });
                var getTalgetUsers= $http.get(SERVER.url +getTalgetUsersURL, { params:{'tailgateId': tailGateId }});
                var getmapMarkers = $http.get(SERVER.url +getmapMarkersURL,{ params:{'tailgateId': tailGateId} });
                var getTailgateLogo= $http.get(SERVER.url +getTailgateLogoURL,{ params:{'tailgateId': tailGateId} });

                $q.all([getEvent, getTailgateImages,getTalgetUsers,getmapMarkers,getTailgateLogo]).then(function(values) {
                    /*$scope.results = MyService.doCalculation(values[0], values[1]);*/

                    getlocationName(values[0]);
                    getMyTailgateImages(values[1]);
                    getTailgaters(values[2]);
                    getTailgateMarkers(values[3]);
                    $scope.getTailGateLogo(values[4]);
                });

            });
        }
        $scope.getTailGateLogo = function (respData) {

                var groupId = respData.data.groupId;
                if (groupId != undefined && groupId > 0) {
                    $scope.tailgateLogoId = 1;
                    $scope.setLogoImageUrl(groupId, respData.data.uuid);
                } else {
                     $scope.tailgateLogoId = 0;
                }

        };
        function getlocationName(respData) {

                $scope.myeventLocation = respData.data;

        }
        function getMyTailgateImages(respData) {

                $scope.myTailgateImages = respData.data;

        }
        function getTailgaters(respData) {

                $scope.myTailgaters=[]
                $scope.allTailgatersLength=respData.data.length;

                angular.forEach(respData.data,function(value,key){

                    $scope.getUserProfile(value)
                })

        }

        $scope.getUserProfile = function(UserDetail) {
            UserService.getUserProfile(UserDetail.userId).then(function(res) {
               if(res.data.fileEntryId != undefined) {
                    UserDetail.friendProfilePicUrl = $scope.imgUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    $scope.myTailgaters.push(UserDetail);
                   if($scope.allTailgatersLength==$scope.myTailgaters.length){
                       get_message_list(tailGateId)

                   }


                }else{
                    $scope.myTailgaters.push(UserDetail);
                   if($scope.allTailgatersLength==$scope.myTailgaters.length){
                       get_message_list(tailGateId)

                   }
                }


            },function(err) {
            })
        };
        function getTailgateMarkers(respData) {

                $cookies.putObject('currtailGateMakers', respData.data);

        }

        //save message Function
        $scope.saveMessage = function (msg) {
            console.log(msg);
            $scope.tailgateDetailId = tailGateId;
            console.log($scope.tailgateDetailId);
            TailgateService.saveMessage(msg, tailGateId).then(function (respData) {
                $scope.messageUser=[]
                get_message_list(tailGateId);
                $scope.usersMessages.message="";
            });
        }

        function get_message_list(tailGateId) {
            TailgateService.getAllMessages(tailGateId).then(function (respData) {
                console.log(respData.data.length);
                $scope.allMessages = respData.data;
                for (var i = 0; i < $scope.allMessages.length; i++) {
                    userId = respData.data[i].userId;
                    userMessage = respData.data[i].messageText;
                    console.log(userId);
                    getTailgateUser(userId, userMessage);
                }
            });
        }

        function getTailgateUser(userId, userMessage) {
            angular.forEach($scope.myTailgaters,function(value,key){
                if(value.userId==userId) {
                    $scope.userFirstName.push(value);
                    $scope.messageUser.push({ message: userMessage, username: value.userName,userPicUrl:value.friendProfilePicUrl});
                }
            });

        }

        $scope.checkTailgateId = function () {
            if (!tailGateId) {
            }
            else {
                editTailgate(tailGateId);
            }
        }

        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };

        $scope.isUserTailgateAdmin(tailGateId);
        $scope.removeTailgateImage = function (index, imageId,imageUUID) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Image ?'
            });
            confirmPopup.then(function(res) {
                if(res) {
                    if(imageId!=undefined) {
                        deleteTailgateImage(imageId,index);
                    }else{
                        TailgateService.getMyTailgateImages(tailGateId).then(function (respData) {
                            $scope.myTailgateImages = respData.data;
                            if($scope.myTailgateImages[index].imageUUID==imageUUID){
                                deleteTailgateImage($scope.myTailgateImages[index].tailgateImageId,index)
                            }
                        });
                        }


                } else {
                }
            });

        }
        function deleteTailgateImage(imageId,index){
            TailgateService.deleteTailgateImageByImageId(imageId).then(function (res) {
                $scope.myTailgateImages.splice(index, 1);
            });
        }
        function editTailgate(tailGateId) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $cookies.putObject("editUserTailgate", respData.data);
                $state.go("app.add_my_tailgate");
            });
        }

        $scope.showPictureChooser = function () {
            if (!$scope.isTailgateMember()) {
                return;
            }
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
                 cssClass : 'no-popup-header',
                scope: $scope
            });
            IonicClosePopupService.register($scope.cameraPopup);
        };

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
            var params = {};
            params.tailgateId = tailGateId;
            var authdata = $cookies.get("authData");
            options.params = params;
            var headers = {};
            headers.Authorization = 'Basic ' + authdata;
            options.headers = headers;
            $cordovaFileTransfer.upload(encodeURI($scope.uploadTailgateImagesUrl), fileURL, options)
                .then(function (r) {
                    var data = $.parseJSON(r.response);
                    $rootScope.$broadcast('loading:hide')
                    var tempData = {};
                    tempData.imageGroupId = data.groupId;
                    tempData.imageTitle = data.title;
                    tempData.tailgateId = tailGateId;
                    tempData.tailgateImageId = data.tailgateImageId;
                    tempData.userId = data.userId;
                    tempData.imageUUID = data.uuid;
                    $scope.myTailgateImages.push(tempData);
                }, function (error) {
                    $rootScope.$broadcast('loading:hide')
                    console.log("upload error source " + error.source);
                    console.log("upload error target " + error.target);
                }, function (progress) {
                });
        }


        $scope.setLogoImageUrl = function (groupId, uuid) {
            $scope.tailgateLogoUrl = $scope.imgUrl + uuid + "&groupId=" + groupId;
        }
        $scope.isTailgateMember = function () {
            return true;
        }

        getMyTailgate();
    }
})();

