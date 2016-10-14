(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer','IonicClosePopupService','$rootScope'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicPopup, $cordovaCamera, $cordovaFileTransfer,IonicClosePopupService,$rootScope) {
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
        $scope.imgUrl = SERVER.hostName +"c/document_library/get_file?uuid=";
        $cookies.put('currtailGateId', tailGateId);
      
        get_message_list(tailGateId);
        $scope.isTailgateAdmin = false;
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
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
                $scope.myTailgaters = respData.data;
            });
        }
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
                console.log(respData);
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
            TailgateService.getAllUser(userId).then(function (respData) {
                console.log(respData.data);
                $scope.userFirstName.push(respData.data);
                $scope.messageUser.push({ message: userMessage, username: respData.data.firstName });
                console.log($scope.messageUser);
            });
        }

        $scope.checkTailgateId = function () {
            if (!tailGateId) {
                console.log("TAILGATE ID IS 0");
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
         $scope.removeTailgateImage = function(index, imageId) {
            TailgateService.deleteTailgateImageByImageId(imageId).then(function(res){
            $scope.myTailgateImages.splice(index,1);
            })
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
                title: 'Choose Picture from:-',
                scope: $scope
            });
            IonicClosePopupService.register($scope.cameraPopup);
        };

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
            };

            $cordovaCamera.getPicture(options).then(function (imageURI) {
                //var image = document.getElementById('myImage');
                //image.src = imageURI;
                $scope.uploadFileToServer(imageURI);
            }, function (err) {
                // error
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
                     data = $.parseJSON(data);
                    console.log("Image Dta is"+JSON.stringify(data));
                    $scope.myTailgateImages.push(data);
                }, function (error) {
                 $rootScope.$broadcast('loading:hide')
                    console.log("upload error source " + error.source);
                    console.log("upload error target " + error.target);
                }, function (progress) {
                });
        }

        $scope.setLogoImageUrl = function (repositoryId, folderId, title) {
            $scope.tailgateLogoUrl = SERVER.hostName + "documents/" + repositoryId + "/" + folderId + "/" + title;
        }
        $scope.isTailgateMember = function () {
            return true;
        }
          getMyTailgate();
    }
})();

