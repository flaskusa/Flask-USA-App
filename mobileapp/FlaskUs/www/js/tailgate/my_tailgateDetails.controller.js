(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService', '$rootScope','$ionicSlideBoxDelegate','$localStorage','UserService'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicPopup, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService, $rootScope,$ionicSlideBoxDelegate,$localStorage,UserService) {
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
                getlocationName($scope.myTailgate.eventId);
                getMyTailgateImages(tailGateId);
                getTailgaters(tailGateId);
                getTailgateMarkers(tailGateId);
            });
        }
        $scope.getTailGateLogo = function (tailgateId) {
            TailgateService.getTailgateLogo(tailgateId).then(function (respData) {
                var groupId = respData.data.groupId;
                if (groupId != undefined && groupId > 0) {
                    $scope.tailgateLogoId = 1;
                    $scope.setLogoImageUrl(groupId, respData.data.uuid);
                } else {
                     $scope.tailgateLogoId = 0;
                }
            });
        };
        function getlocationName(evntId) {
            TailgateService.getEvent(evntId).then(function (respData) {
                $scope.myeventLocation = respData.data;
            });
        }
        function getMyTailgateImages(tailGateId) {
            TailgateService.getMyTailgateImages(tailGateId).then(function (respData) {
                $scope.myTailgateImages = respData.data;
            });
        }
        function getTailgaters(tailGateId) {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                $scope.myTailgaters=[]
                $scope.allTailgatersLength=respData.data.length;

                angular.forEach(respData.data,function(value,key){

                    haveProfilePic(value)
                })
            });
        }
        function haveProfilePic(memberDetail){
            var PicExist=false
            angular.forEach($localStorage["myFriendDetail"],function(value,key){
                if(value.friendProfilePicUrl!=undefined){
                    PicExist=true
                    if(value.userId==memberDetail.userId){
                        memberDetail.friendProfilePicUrl=value.friendProfilePicUrl

                    }
                }



            });
            if(PicExist==false) {
                $scope.getUserProfile(memberDetail)

            }else{
                $scope.myTailgaters.push(memberDetail)
                if($scope.allTailgatersLength==$scope.myTailgaters.length){
                    get_message_list(tailGateId)

                }
            }
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
        function getTailgateMarkers(tailGateId) {
            TailgateService.getMapMarkers(tailGateId).then(function (respData) {
                $cookies.putObject('currtailGateMakers', respData.data);
            });
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
        $scope.removeTailgateImage = function (index, imageId) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Image ?'
            });
            confirmPopup.then(function(res) {
                if(res) {
                    TailgateService.deleteTailgateImageByImageId(imageId).then(function (res) {
                        $scope.myTailgateImages.splice(index, 1);
                    })

                } else {
                }
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
                    tempData.tailgateImageId = data.fileEntryId;
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
        $scope.getTailGateLogo(tailGateId);
        getMyTailgate();
    }
})();

