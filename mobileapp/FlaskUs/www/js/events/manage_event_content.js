(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('ManageEventCtrl', ManageEventCtrl);

    ManageEventCtrl.$inject = ['$scope', '$stateParams', '$state', 'EventsService', 'SERVER','$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService', '$rootScope','$cookies'];

    /* @ngInject */
    function ManageEventCtrl($scope, $stateParams, $state, EventsService, SERVER,$ionicPopup, $cordovaCamera, $cordovaFileTransfer,IonicClosePopupService,$rootScope,$cookies) {
        $scope.eventDetails = [];
        var test=$stateParams.eventDetails
        $scope.eventName=$stateParams.currEventName;
        $scope.currEventId=$stateParams.currEventId;
        $scope.EventTypeInfo=$stateParams.infoType;
        $scope.duringEventInfo = 'During-Event';
        $scope.preEventInfo = 'Pre-Event';
        $scope.postEventInfo="Post-Event";
        $scope.flaskUsDetails=[];
        $scope.flaskUsDetails1=[];
        $scope.flaskUsDetails2=[];
        $scope.flaskUsDetails3=[];
        $scope.editContent=false;
        $scope.content={infoTitle:"",infoDesc:""};
        var baseImagePath = SERVER.hostName+"c/document_library/get_file";

        $scope.infoTypeCategoryId=103;
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
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="removePicture();" ng-if="isTailgateAdmin && tailgateLogoId > 0">'
                + 'Remove Picture'
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
                correctOrientation: true
            };

            $cordovaCamera.getPicture(options).then(function (imageURI) {
                $scope.setSelectedImageURIToUpload(imageURI);
            }, function (err) {
                alert("error")
            });
        };
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
                $scope.setSelectedImageURIToUpload(imageURI);
            }, function (err) {

            });

        }
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
        $scope.setSelectedImageURIToUpload = function (imageURI) {
            $scope.defaultImageUrl = imageURI;
            $scope.isImageSelectedToUpload = true;
            $scope.selectedImageURIToUpload = imageURI;
        };
        $scope.reSetSelectedImageURIToUpload = function () {
            $scope.isImageSelectedToUpload = false;
            $scope.selectedImageURIToUpload = '';
        }
        $scope.uploadFileToServer = function (fileURL, eventId,eventDetailId) {
            $rootScope.$broadcast('loading:show');
            var options = {};
            options.fileKey = "file";
            var params = {};
            params.eventId = eventId;
            params.eventDetailId=eventDetailId;
            var authdata = $cookies.get("authData");
            options.params = params;
            var headers = {};
            headers.Authorization = 'Basic ' + authdata;
            options.headers = headers;
            $cordovaFileTransfer.upload(encodeURI(SERVER.url + '/flask-rest-events-portlet.event/upload-detail-image'), fileURL, options)
                .then(function (r) {
                    $rootScope.$broadcast('loading:hide')
                    $scope.reSetSelectedImageURIToUpload();
                    $scope.downloadProgress = 0;
                    var data = $.parseJSON(r.response);
                    var eventDetailId = data.eventDetailId;
                    var imageUUID = data.imageUUID;
                    var imageGroupId = data.imageGroupId;
                    $scope.setEventDetailUrl(eventDetailId, imageUUID, imageGroupId);
                }, function (error) {
                    $scope.reSetSelectedImageURIToUpload();
                    $rootScope.$broadcast('loading:hide')
                    alert("An error has occurred: Code = " + error.code);
                    console.log("upload error source " + error.source);
                    console.log("upload error target " + error.target);
                }, function (progress) {
                    //                    $scope.downloadProgress = (progress.loaded / progress.total) * 100;
                });
        }
        $scope.setEventDetailUrl = function (eventDetailId, imageUUID, imageGroupId) {
            $scope.eventDetailImageURL = baseImagePath + "?uuid=" + imageUUID + "&groupId=" + imageGroupId;


            $scope.EventDetailImageUrl = encodeURI($scope.tailgateLogoUrl);
        }

        $scope.addContent=function(content,index) {
            if (content.eventDetailId <= 0 || content.eventDetailId == undefined) {
                EventsService.addContentDuringEvent(content.infoTitle, content.infoDesc, $scope.currEventId,$scope.infoTypeCategoryId,$scope.infoTypeId).then(function (response) {
                    if(response.data.eventDetailId) {
                        $scope.flaskUsDetails.push(response.data);
                        $scope.uploadFileToServer($scope.selectedImageURIToUpload,response.data.eventId,response.data.eventDetailId);
                        $scope.editContent = false;
                    }else{

                    }
                })
            }
            else if (content.eventDetailId > 0) {
                EventsService.updateEventDetailDuringEvent(content.infoTitle, content.infoDesc, $scope.currEventId, content.eventDetailId,$scope.infoTypeCategoryId,$scope.infoTypeId).then(function (response) {
                    if (response.data.eventDetailId > 0) {
                        $scope.editContent = false;
                    }
                });
            }


        }
        $scope.cancelEdit=function(){
            $scope.editContent = false;
        }
        $scope.addNewContent=function(){
            $scope.content={infoTitle:"",infoDesc:""};
            $scope.editContent = true;
        }
        $scope.editContents=function(content,index){
            $scope.content=content;
            $scope.editContent=true;
        }
        $scope.deleteEventDetail=function(eventDetailId,index){
            EventsService.deleteEventDetailById(eventDetailId).then(function(response){
                if(response.data){
                    $scope.flaskUsDetails.splice(index,1);
                }

            });

        }
        EventsService.getAllEventDetailWithImage($scope.currEventId).then(function(response){
            $scope.eventDetails=response.Details;
            $scope.getFlaskUsDetail();
        });

        $scope.getFlaskUsDetail = function () {
            var tempObject = {};
            var ImgObj=[]
            $scope.flaskUsDetails1=[];
            $scope.flaskUsDetails2=[];
            $scope.flaskUsDetails3=[];
            angular.forEach($scope.eventDetails, function (value, index) {
                tempObject = {};
                ImgObj=[]
                ImgObj = angular.fromJson(value.DetailImages);
                tempObject = angular.fromJson(value.Detail);
                tempObject.id = index;
                if ($scope.duringEventInfo == tempObject.infoTypeName) {
                    if ("Flask Us" == tempObject.infoTypeCategoryName) {
                        if(ImgObj.length!=0){
                            tempObject.imageUrl=baseImagePath + "?uuid=" + angular.fromJson(ImgObj[0].DetailImage).imageUUID + "&groupId=" + angular.fromJson(ImgObj[0].DetailImage).imageGroupId;
                        }
                        $scope.flaskUsDetails1.push(tempObject);

                    }
                }
                else if($scope.preEventInfo==tempObject.infoTypeName){
                    if ("Flask Us" == tempObject.infoTypeCategoryName) {
                        if(ImgObj.DetailImages.length!=0){
                            tempObject.imageUrl=baseImagePath + "?uuid=" + angular.fromJson(ImgObj[0].DetailImage).imageUUID + "&groupId=" + angular.fromJson(ImgObj[0].DetailImage).imageGroupId;
                        }
                        $scope.flaskUsDetails2.push(tempObject);
                    }
                }
                else if($scope.postEventInfo==tempObject.infoTypeName){
                    if ("Flask Us" == tempObject.infoTypeCategoryName) {
                        if(ImgObj.DetailImages.length!=0){
                            tempObject.imageUrl=baseImagePath + "?uuid=" + angular.fromJson(ImgObj[0].DetailImage).imageUUID + "&groupId=" + angular.fromJson(ImgObj[0].DetailImage).imageGroupId;
                        }
                        $scope.flaskUsDetails3.push(tempObject);
                    }
                }

            });

            if($scope.EventTypeInfo==$scope.duringEventInfo){
                $scope.flaskUsDetails=$scope.flaskUsDetails1;
                $scope.infoTypeCategoryId=103;
                $scope.infoTypeId=2;
            }
            else if($scope.EventTypeInfo==$scope.preEventInfo){
                $scope.flaskUsDetails=$scope.flaskUsDetails2;
                $scope.infoTypeCategoryId=8;
                $scope.infoTypeId=1;
            }
            else if($scope.EventTypeInfo==$scope.postEventInfo){
                $scope.flaskUsDetails=$scope.flaskUsDetails3;
                $scope.infoTypeCategoryId=204;
                $scope.infoTypeId=3;
            }


        }



    }
})();
