(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgateDetailsCtrl', mytailgateDetailsCtrl);

    mytailgateDetailsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer'];

    /* @ngInject */
    function mytailgateDetailsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicPopup, $cordovaCamera, $cordovaFileTransfer) {
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
        $cookies.put('currtailGateId', tailGateId);
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        getMyTailgate();
        get_message_list(tailGateId);
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
                title: 'Choose the Profile Picture from:-',
                scope: $scope,
                buttons: [{
                    text: '<b>Cancel</b>',
                    type: 'button-positive',
                    onTap: function (e) {
                        $scope.cameraPopup.close();
                    }
                }]
            });
        };
        $scope.camera = function () {
            var options = {
                quality: 50,
                destinationType: Camera.DestinationType.FILE_URI,
                sourceType: Camera.PictureSourceType.CAMERA,
                allowEdit: true,
                encodingType: Camera.EncodingType.JPEG,
                targetWidth: 100,
                targetHeight: 100,
                popoverOptions: CameraPopoverOptions,
                saveToPhotoAlbum: false,
                correctOrientation: true
            };

            $cordovaCamera.getPicture(options).then(function (imageData) {
                var image = document.getElementById('myImage');
                image.src = "data:image/jpeg;base64," + imageData;
            }, function (err) {
                // error
            });
        }
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
                    $scope.downloadProgress = 0;
                    var data = $.parseJSON(r.response);
                    $scope.myTailgateImages.push(data);
                    //                  var repositoryId  = data.repositoryId;
                    //                  var folderId = data.folderId;
                    //                  var title = data.title;
                    //                  $scope.setLogoImageUrl(repositoryId,folderId,title);
                }, function (error) {
                    alert("An error has occurred: Code = " + error.code);
                    console.log("upload error source " + error.source);
                    console.log("upload error target " + error.target);
                }, function (progress) {
                    $scope.downloadProgress = (progress.loaded / progress.total) * 100;
                });
        }

        $scope.setLogoImageUrl = function (repositoryId, folderId, title) {
            $scope.tailgateLogoUrl = SERVER.hostName + "documents/" + repositoryId + "/" + folderId + "/" + title;
        }
        $scope.isTailgateMember = function () {
            return true;
        }
    }
})();

