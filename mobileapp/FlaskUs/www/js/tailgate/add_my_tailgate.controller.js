(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter', '$ionicModal', '$flaskUtil', '$cookies', 'ionicDatePicker', 'ionicTimePicker', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService', '$rootScope', '$ionicTabsDelegate', '$ionicLoading','$localStorage','UserService'];

    / @ngInject /
    function add_mytailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter, $ionicModal, $flaskUtil, $cookies, ionicDatePicker, ionicTimePicker, $ionicPopup, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService, $rootScope, $ionicTabsDelegate, $ionicLoading,$localStorage,UserService) {
        //for adding tailgate
        var tailgateId = $cookies.get("currtailGateId");
        $scope.copytTailgateId = tailgateId;
        var self = this;
        var newtailGateId;
        getAllFriends();
        getAllGroups();
        $scope.allGroups = [];
        $scope.CurrEvent = [];
        $scope.Details = [];
        $scope.eventDetails = [];
        $scope.eventNames = [];
        $scope.groupUserDetails = [];
        var currentDate = new Date();/*Today's Date*/
        $scope.startDate = $filter('date')(new Date(), 'yyyy-MM-dd h:mm');
        currentDate.setDate(currentDate.getDate() - 1); /*adding days to today's date*/
        $scope.startDate = $filter('date')(currentDate, 'yyyy-MM-dd h:mm');
        $scope.eventTypeIds = '';
        $scope.searchString = 'a';
        $scope.showSavedMarker = false;
        $scope.taligateMarkers = "";
        $scope.latitude = '42.34';
        $scope.longitude = '-83.0456';
        

        currentDate.setDate(currentDate.getDate() + 60); /*adding days to today's date*/
        $scope.endDate = $filter('date')(currentDate, 'yyyy-MM-dd h:mm');
        $scope.tailgateSupplyList = [];
        $scope.supplyList = { 'selectedSupplyList': '' };
        var supplyListstId;
        var supplyItemName;
        $scope.items = [];
        var userResponse;
        var UserId;
        var itemArray;
        $scope.supplyItemList = [];
        $scope.downloadProgress = 0;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.tailgateLogoUrl = "";
        $scope.tailgateLogoInfo = {};
        $scope.isTailgateAdmin = false;
        $scope.selectedImageURIToUpload = "";
        $scope.isImageSelectedToUpload = false;
        $scope.tailgateLogoId = 0;
        $scope.defaultImageUrl = "img/flask_images/Fotolia_20387372_Subscription_Monthly_M.jpg";
        $scope.hideItem = false;
        $scope.hideSupplyItem = false;
        $scope.selectedSupplyListItems = [];
        $scope.allMyTailgateItems = [];
        $scope.newUpdate = { 'amountToPay': '', 'venmoAccountId': '' };

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
getTailgateMarkers(tailgateId);
        getMySupplyList();

        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        function getTailgateMarkers(tailGateId) {
            if(tailGateId != undefined && tailGateId > 0) {
                TailgateService.getMapMarkers(tailGateId).then(function (respData) {
                    $scope.taligateMarkers = respData.data;
                    if ($scope.taligateMarkers != undefined && $scope.taligateMarkers.tailgatemarkerid != undefined) {
                        $scope.latitude = $scope.taligateMarkers.latitude;
                        $scope.longitude = $scope.taligateMarkers.longitude
                        $scope.showSavedMarker = true;
                    } else {
                        $scope.latitude = '42.34';
                        $scope.longitude = '-83.0456';
                    }
                    getallEventnames();
                    callMap($scope.latitude, $scope.longitude);
                });
            }else {
                getallEventnames();
                callMap($scope.latitude, $scope.longitude);
            }
           
        }

        $scope.initialize = function () {
            var x = new Date();
            var hour = x.getHours();
            var minute = x.getMinutes();
            var year = x.getYear() + 1900;
            var month = x.getMonth();
            var day = x.getDate();

            $scope.addTailgateParams = {
                tailgateName: '',
                tailgateDescription: '',
                eventId: '',
                eventName: '',
                venmoAccountId: '',
                amountToPay: '',
                tailgateId: '',
                startTime: new Date(year, month, day, hour, minute, 0),
                endTime: new Date(year, month, day, hour, minute, 0)
            }
            checkTailgateId();
            if (tailgateId != undefined && tailgateId > 0) {
                $scope.isUserTailgateAdmin(tailgateId);
                getTailgaters(tailgateId);
                if ($scope.tailgateLogoId > 0) {
                    $scope.getTailGateLogo(tailgateId);
                }
            } else {
                $scope.isTailgateAdmin = true;
            }

        }
        $scope.selectTab = function (index) {
            $ionicTabsDelegate.select(index);
            if (tailgateId != undefined && tailgateId > 0) {
                getItems();
            }
        }
        $scope.user = {
            supplyItemName: ['user']
        };



        //calling map on load and on events change
        function callMap(currlatitude, currlongitude) {
            angular.extend($scope, {
                map: {
                    center: {
                        latitude: currlatitude,
                        longitude: currlongitude
                    },
                    zoom: 19,
                    markers: [],
                    events: {
                        click: function (map, eventName, originalEventArgs) {
                            var e = originalEventArgs[0];
                            var lat = e.latLng.lat(), lon = e.latLng.lng();
                            var marker = {
                                id: 1,
                                coords: {
                                    latitude: lat,
                                    longitude: lon
                                },
                                showWindow: true
                            };
                            $scope.map.markers.push(marker);
                            if ($scope.map.markers.length > 1) {
                                $scope.map.markers.shift();
                            }
                            //$scope.map.markers.pop();
                            console.log($scope.map.markers);
                            $scope.$apply();
                        }
                    }
                }
            });
            if ($scope.showSavedMarker) {
                var marker = {
                    id: 2,
                    coords: {
                        latitude: currlatitude,
                        longitude: currlongitude
                    },
                    showWindow: true,
                    name: $scope.taligateMarkers.name,
                    description: $scope.taligateMarkers.description
                }

                $scope.map.markers.push(marker);
            }

        }
        $scope.windowOptions = {
            show: true
        };
        $scope.currMarker = function (loc) {
            var markerData = {};
            console.log(loc, $scope.map.markers[0].coords);
            markerData.tailgateId = tailgateId;
            markerData.latitude = $scope.map.markers[0].coords.latitude;
            markerData.longitude = $scope.map.markers[0].coords.longitude;
            markerData.name = loc.name;
            markerData.description = loc.description == undefined ? '' : loc.description;
            saveMaker(markerData);
        }
        function saveMaker(markerData) {
            $scope.locationPopup.close();
            if ($scope.taligateMarkers != undefined && $scope.taligateMarkers.tailgatemarkerid > 0) {
                TailgateService.deleteTailgateMarker(tailgateId).then(function (response) {
                    saveTailgateMarker(markerData);
                })
            } else {
                saveTailgateMarker(markerData);
            }

        }
        function saveTailgateMarker(markerData) {
            TailgateService.addTailgateMarkers(markerData).then(function (respData) {
                $scope.taligateMarkers = respData.data;
                $scope.map.markers[0].name = markerData.name;
                $scope.map.markers[0].description = markerData.description;
            });
        }
        //call on marker click
        $scope.onClick = function (marker, eventName, model) {
            $scope.loc = { 'name': marker.name, 'description': marker.description };
            var customTemplate =
                '<form novalidate name="markerPOpup"><div class="list">'
                + '        <label class="item item-input item-floating-label">'
                + '         <span class="input-label">Place Name</span>'
                + '           <input type="text" placeholder="Place Name" ng-model="loc.name" required="true" name="locationName">'
                +'<div ng-show="(markerPOpup.$submitted || markerPOpup.locationName.$touched) && markerPOpup.locationName.$error.required"  style="color:red">Enter location.</div>'
                + '        </label>'
                + '         <label class="item item-input item-floating-label">'
                + '      <span class="input-label">Description</span>'
                + '        <input type="text" placeholder="Description" ng-model="loc.description">'
                + '       </label>                 '
                + '    </div>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="markerPOpup.$valid && currMarker(loc);">'
                + 'Save'
                + '</button>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="clearMArkersOnMap();" >'
                + 'Remove'
                + '</button>'
                + ' </div>'
                + '</form>';

            $scope.locationPopup = $ionicPopup.show({
                template: customTemplate,
                title: 'Enter Location Details',
                scope: $scope
            });
            IonicClosePopupService.register($scope.locationPopup);


        };
        $scope.clearMArkersOnMap = function (addMarker) {
            TailgateService.deleteTailgateMarker(tailgateId).then(function (res) {
                $scope.map.markers.pop();
                $scope.locationPopup.close();
            });
        }
      

        // invoke on type search box
        $scope.loadeventData = function (eventId) {
            if(eventId > 0) {
                $scope.addTailgateParams.eventName=$( "#EventNameList option:selected" ).text();
                getEventDetails(eventId);
            }
        }
        //get event and venue details in select box
        function getEventDetails(eventId) {
            TailgateService.getEvent(eventId).then(function (respData) {
                $scope.CurrEvent = respData.data;
                var venueID = $scope.CurrEvent.venueId;
                var currStartTime = getTailgateTime($scope.CurrEvent.startTime);
                var currEndTime = getTailgateTime($scope.CurrEvent.endTime);
                var currDate = $filter('date')($scope.CurrEvent.eventDate, 'MM-dd-yyyy');

                $scope.addTailgateParams.startTime = currStartTime;
                $scope.addTailgateParams.endTime = currEndTime;
                $scope.tailgateDate = currDate;
                TailgateService.getvenueDetails(venueID).then(function (VENUEData) {
                    callMap(VENUEData.latitude, VENUEData.longitude);
                });
            });
        }

        function checkTailgateId() {
            var tailgateDetails = $cookies.getObject("editUserTailgate");
            if (!tailgateDetails) {

            } else {
                editTailgateData(tailgateDetails);
            }
        }
        //edit tailgate data
        function editTailgateData(tailgateDetails) {
            $cookies.remove('newtailgatedata');
            $scope.newUpdate = { 'amountToPay': tailgateDetails.amountToPay, 'venmoAccountId': tailgateDetails.venmoAccountId };
            $scope.tailgateDate = $filter('date')(tailgateDetails.tailgateDate, 'MM-dd-yyyy');
            var startTimeInword = $filter('date')(tailgateDetails.startTime, "hh:mm a")
            var startTimeInMilis = Date.parse($scope.tailgateDate + " " + startTimeInword)
            var endTimeInword = $filter('date')(tailgateDetails.endTime, "hh:mm a")
            var endTimeInMilis = Date.parse($scope.tailgateDate + " " + endTimeInword)
            $scope.selectedtime1 = getTailgateTime(new Date(startTimeInMilis));
            $scope.selectedtime2 = getTailgateTime(new Date(endTimeInMilis));
            $scope.tailgateLogoId = tailgateDetails.logoId;
            $scope.addTailgateParams.eventId=tailgateDetails.eventId+"";
            $scope.addTailgateParams = {
                tailgateName: tailgateDetails.tailgateName,
                tailgateDescription: tailgateDetails.tailgateDescription,
                eventId: tailgateDetails.eventId + "",
                eventName: tailgateDetails.eventName,
                venmoAccountId: tailgateDetails.venmoAccountId,
                amountToPay: tailgateDetails.amountToPay,
                tailgateId: tailgateDetails.tailgateId,
                startTime: $scope.selectedtime1,
                endTime: $scope.selectedtime2,
                logoId : tailgateDetails.logoId
            }
            $scope.editData = {
                tailgateId: tailgateDetails.tailgateId,
                tailgateName: tailgateDetails.tailgateName,
                tailgateDescription: tailgateDetails.tailgateDescription,
                eventId: tailgateDetails.eventId,
                eventName: tailgateDetails.eventName,
                venmoAccountId: tailgateDetails.venmoAccountId,
                amountToPay: tailgateDetails.amountToPay,
                tailgateDate: tailgateDetails.tailgateDate,
                startTime: tailgateDetails.startTime,
                endTime: tailgateDetails.endTime

            }
            $cookies.putObject('newtailgatedata', $scope.editData);
        };
        //show actin sheet on picture click
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
                cssClass: 'no-popup-header',
                scope: $scope
            });
            IonicClosePopupService.register($scope.cameraPopup);
        };

        $scope.removePicture = function () {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Remove tailgate logo ?'
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
                correctOrientation: true,
            };

            $cordovaCamera.getPicture(options).then(function (imageURI) {
                if (tailgateId && tailgateId > 0) {
                    $scope.uploadFileToServer(imageURI, tailgateId, "Image Uploaded");
                } else {
                    $("#myImage").attr("src", imageURI);
                    $scope.setSelectedImageURIToUpload(imageURI);
                }
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
                if (tailgateId && tailgateId > 0) {
                    $scope.uploadFileToServer(imageURI, tailgateId, "Image Uploaded");
                } else {
                    $("#myImage").attr("src", imageURI);
                    $scope.setSelectedImageURIToUpload(imageURI);
                }
            }, function (err) {

            });

        }
        $scope.setSelectedImageURIToUpload = function (imageURI) {
            // $scope.defaultImageUrl = imageURI;
            $scope.isImageSelectedToUpload = true;
            $scope.selectedImageURIToUpload = imageURI;
        };
        $scope.reSetSelectedImageURIToUpload = function () {
            $scope.isImageSelectedToUpload = false;
            $scope.selectedImageURIToUpload = '';
        }

        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };
        $scope.uploadFileToServer = function (fileURL, tailgateId, message) {
            $rootScope.$broadcast('loading:show');
            var options = {};
            options.fileKey = "file";
            var params = {};
            params.tailgateId = tailgateId;
            options.params = params;
            var authdata = $cookies.get("authData");
            var headers = {};
            headers.Authorization = 'Basic ' + authdata;
            options.headers = headers;
            $cordovaFileTransfer.upload(encodeURI(SERVER.url + '/flask-user-tailgate-portlet.tailgateimages/upload-tailgate-logo'), fileURL, options)
                .then(function (r) {
                    $rootScope.$broadcast('loading:hide')
                    $scope.reSetSelectedImageURIToUpload();
                    var data = $.parseJSON(r.response);
                    var uuid = data.uuid;
                    $scope.addTailgateParams.logoId  = data.fileEntryId;
                    var groupId = data.groupId;
                    $scope.tailgateLogoId = 1;
                    // var title = data.title;
                    $scope.setLogoImageUrl(groupId, uuid);
                    showToastMessage(message);
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

        $scope.setLogoImageUrl = function (groupId, uuid) {
            $scope.tailgateLogoUrl = SERVER.hostName + "c/document_library/get_file?uuid=" + uuid + "&groupId=" + groupId;
        }
        //add new tailgate
        $scope.addmyTailgate = function (tailgatedata) {
            if (!(tailgatedata.eventId > 0)) {
                $flaskUtil.alert("Please select event");
                return;
            }
            if (!validateTailgate(tailgatedata)) {
                console.log("Invalid date");
            }
            tailgatedata = angular.copy(tailgatedata);

            var startTime = Date.parse(tailgatedata.startTime); // Your timezone!
            var endTime = Date.parse(tailgatedata.endTime);
            tailgatedata.tailgateDate = new Date($scope.tailgateDate).getTime();
            tailgatedata.endTime = endTime;
            tailgatedata.startTime = startTime;
            tailgatedata.venmoAccountId = "";
            tailgatedata.amountToPay = 0;
            tailgatedata.eventId = angular.isString(tailgatedata.eventId) ? parseInt(tailgatedata.eventId) : tailgatedata.eventId;
            if (tailgatedata.tailgateId && tailgatedata.tailgateId > 0) {
                TailgateService.updateTailgateInfo(tailgatedata).then(function (respdata) {
                    $cookies.putObject('newtailgatedata', respdata);
                    showToastMessage('Tailgate updated successfully');
                });
            }
            else {
                tailgatedata.logoId = 0;
                TailgateService.addTailgate(tailgatedata).then(function (respData) {
                    if ($scope.isImageSelectedToUpload) {
                        $scope.uploadFileToServer($scope.selectedImageURIToUpload, respData.data.tailgateId, 'Tailgate created successfully');
                    } else {
                        showToastMessage('Tailgate created. Tap next tab to add location');
                    }
                    tailgateId = respData.data.tailgateId;
                    $scope.copytTailgateId=tailgateId;
                    $scope.addTailgateParams.tailgateId = respData.data.tailgateId;
                    $scope.addTailgateParams.logoId = respData.data.logoId;
                    $cookies.putObject('newtailgatedata', respData.data);
                });
            }
        }

        function showToastMessage(message) {
            if (message.length > 0) {
                $ionicLoading.show({ template: message, noBackdrop: true, duration: 2000 });
            }
        }

        function validateTailgate(data) {
            return true;
        }
        //update tailgate
        $scope.updatetailgate = function (newUpdate) {
            var updateData = $cookies.getObject("newtailgatedata");
            updateData.venmoAccountId = newUpdate.venmoAccountId;
            updateData.amountToPay = parseFloat(newUpdate.amountToPay);
            console.log(updateData);
            TailgateService.updateTailgateInfo(updateData).then(function (respdata) {
                showToastMessage('Payment details saved');
            });
            //fnPayNow();
        }
        // get selected venue details
        $scope.getvenuefromSelect = function (tailgatedata) {
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
            });
        }
        // to get all filtered event list in the select box.
        function getallEventnames() {
            $scope.tailgateParams = {
                eventTypeIds: $scope.eventTypeIds,
                startDate: $scope.startDate,
                endDate: $scope.endDate,
                searchString: $scope.searchString,
                latitude: $scope.latitude,
                longitude: $scope.longitude
            }
            TailgateService.getallFilteredEvents($scope.tailgateParams).then(function (respData) {
                $scope.eventDetails = respData.Events;
            });
        }

        //for adding attendees in new tailgate
        $scope.myTailgaters = [];
        $scope.active = true; // define the tab in add group and add friend section
        $scope.active1 = true;
        $scope.myFriends = [];


        function getTailgaters(newtailgateId) {
            TailgateService.getMyTailgateUsers(newtailgateId).then(function (respData) {
                $scope.myTailgaters = respData.data;
            });
        }
        function getAllFriends() {
            TailgateService.getUserFrends().then(function (response) {
                if($localStorage["myFriendDetail"].length==response.length){
                    $scope.myFriends=$localStorage["myFriendDetail"];
                }
                else{
                    angular.forEach(response,function(value,key){
                        if(value.portraitId>0) {
                            $scope.getUserProfile(value);
                        }else{
                            $scope.myFriends.push(value);
                            if(userExistInLocal(value)==false){
                                $localStorage["myFriendDetail"].push(value)
                            }
                        }
                    })

                }
            })}
        $scope.getUserProfile = function(UserDetail) {
            UserService.getUserProfile(UserDetail.userId).then(function(res) {
                    if (res.data.fileEntryId != undefined) {
                        UserDetail.friendProfilePicUrl = $scope.imgUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                        $scope.myFriends.push(UserDetail);

                        if (userExistInLocal(UserDetail) == false) {
                            $localStorage["myFriendDetail"].push(UserDetail);
                        }
                    }


            },function(err) {
            })
        };
        function userExistInLocal(userDetail){
            var exist=false;
            angular.forEach($localStorage["myFriendDetail"],function(value,key){
                if(value.userId==userDetail.userId){
                    exist=true
                }
            })
            return exist;
        }

        //add single member to the tailgate
        $scope.addTailgateMembers = function (currUserData, index) {
            var addUserparams = {};
            addUserparams.groupId = 0;
            addUserparams.userId = currUserData.userId;
            addUserparams.userName = currUserData.firstName + " " + currUserData.lastName;
            addUserparams.emailAddress = currUserData.emailAddress;
            addUserparams.isAdmin = 0;
            addUserparams.tailgateId = tailgateId;
            addUserparams.isPaid = 0;
            addUserparams.paymentMode = "None";
            addUsertoTailgate(addUserparams, index);

        }
        //get all groups either created by user or is a member of particular group.
        function getAllGroups() {
            userResponse = $cookies.getObject('CurrentUser');
            UserId = userResponse.data.userId;
            TailgateService.getGroupbyId(UserId).then(function (respData) {
                $scope.allGroups = respData;
            });
        }
        //add user info to current tailgate
        function addUsertoTailgate(userparams, index) {
            TailgateService.addcurrentUser(userparams).then(function (respData) {
                if (index != undefined) {
                    $scope.myFriends.splice(index, 1);
                }
                getTailgaters(tailgateId);
            });
        }
        $scope.getUseData = [];
        //get all the members of the group
        $scope.getusersofGroup = function (groupId, index) {
            TailgateService.getGroupUsers(groupId).then(function (respData) { //get data of group from group id
                for (var i = 0; i < respData.length; i++) {
                    $scope.getUseData.push(respData[i]); //to get users of particular group
                    var adduser = {};
                    adduser.groupId = $scope.getUseData[i].groupId;
                    adduser.userId = $scope.getUseData[i].userId;
                    adduser.userName = $scope.getUseData[i].userName;
                    adduser.emailAddress = $scope.getUseData[i].emailAddress;
                    adduser.isAdmin = $scope.getUseData[i].isAdmin;
                    adduser.tailgateId = newtailGateId;
                    adduser.isPaid = 0;
                    adduser.paymentMode = "None";
                    addUsertoTailgate(adduser);
                }
                $scope.allGroups.splice(index, 1);
                console.log($scope.getUseData)
                $scope.groupUserDetails = respData;
            });
        }

        //list of supplies
        function getMySupplyList(selected1) {
            TailgateService.getMySupplyLists().then(function (respData) {
                $scope.allSupplyList = respData.data;
                // for (var i = 0; i < $scope.allSupplyList.length; i++) {
                //     $scope.tailgateSupplyList.push({ supplyListName: $scope.allSupplyList[i].supplyListName, supplyListsId: $scope.allSupplyList[i].supplyListId });
                // }
            });
        }

        //getting supply items
        $scope.getSupplyItem = function (selected) {
            supplyListstId = selected.supplyListsId;
            TailgateService.getItemsbylistid(supplyListstId).then(function (respData) {
                $scope.supplyItemList = respData.data;
            });

        }

        //Get tailgators
       /* function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                $scope.myFriends = respData;
            })
        }*/

        //Get tailgates of particular user
        // function getAllMyTailgates(userId) {
        //     TailgateService.getMyTailgates(userId).then(function (respData) {
        //         $scope.allMyTailgate = respData.data;
        //     });
        // }

        //Adding supply items to tailgate
        $scope.addSupplyItems = function () {
            $scope.items = [];
            angular.forEach($scope.selectedSupplyListItems, function (val, idx) {

                var tempItemName;
                if (val.itemAssignedUserId > 0) {
                    tempItemName = val.supplyItemName;
                    if (tempItemName.indexOf("/") > -1) {
                        tempItemName = encodeURIComponent(tempItemName);
                    }
                    $scope.items.push(tempItemName);
                }
            })
            itemArray = $scope.items.toString();
            // var tailgateId = $cookies.get("currtailGateId");
            TailgateService.addTailgateSupplyItems(itemArray, tailgateId, "-1").then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
                $scope.associateUserWithSupplyItem();
            });

        }


        $scope.associateUserWithSupplyItem = function () {
            angular.forEach($scope.alltailgateSupplyItem, function (value, index) {
                value.itemAssignedUserId = getAssigenUserId(decodeURIComponent(value.supplyListItemName));
                $scope.updateSupplyItems(value);
            })



        };

        function getAssigenUserId(supplyItemName) {
            var userId;
            angular.forEach($scope.selectedSupplyListItems, function (value, idx) {
                if (value.itemAssignedUserId > 0 && supplyItemName == value.supplyItemName) {
                    userId = value.itemAssignedUserId;
                    return;
                    // $scope.updateSupplyItems(val);
                }
            })
            return userId;
        }

        //venmo Account pay now
        function fnPayNow() {
            $scope.newdata = $cookies.getObject("newtailgatedata");
            var tailgateName = $scope.newdata.tailgateName;
            var tailgateAccount = $scope.newdata.venmoAccountId;
            var amountToPay = $scope.newdata.amountToPay;
            var paymentUrl = "https://venmo.com/?txn=pay&amount=" + amountToPay + "&note= for tailgate " + tailgateName +
                "&recipients=" + tailgateAccount;
            window.open(paymentUrl, '_system', 'location=yes'); // for inapp browser or system app
        }

        $scope.getTailGateLogo = function (tailgateId) {
            TailgateService.getTailgateLogo(tailgateId).then(function (respData) {
                $scope.tailgateLogoInfo = respData.data;
                $scope.setLogoImageUrl($scope.tailgateLogoInfo.groupId, $scope.tailgateLogoInfo.uuid);
            });
        };


        $scope.toggleItem = function () {
            var supplyItem = $("#supplyItemDiv");
            $scope.hideItem = !$scope.hideItem;
            $("#FlaskUsListdiv").slideToggle("slow", function () {
                $ionicScrollDelegate.resize();
                if ($scope.hideItem && supplyItem.is(":visible") === false) {
                    $scope.hideSupplyItem = !$scope.hideSupplyItem;
                    supplyItem.slideToggle("slow", function () {
                        $ionicScrollDelegate.resize();
                    });
                }
            });

        }
        $scope.toggleSupplyItem = function () {
            $scope.hideSupplyItem = !$scope.hideSupplyItem;
            $("#supplyItemDiv").slideToggle("slow", function () {
                $ionicScrollDelegate.resize();
            });
        };
        $scope.copyForMyGameDaySupply = function (supplyObject) {
            $scope.MyGameDaysSupply = [];
            angular.forEach($scope.allSupplyList, function (value, key) {
                if (value.supplyListId == supplyObject.supplyListId) {
                    value.checked = true;

                } else {
                    value.checked = false;
                }
            });
            TailgateService.getItemsbylistid(supplyObject.supplyListId).then(function (response) {
                $scope.selectedSupplyListItems = response.data;
                if ($scope.hideItem == false) {
                    $scope.toggleItem();
                }
            });

        }
        $scope.removeSelectedSupply = function (list) {
            $scope.selectedSupplyListItems = [];
        }
        $scope.selectGameDaySupply = function (list, checked) {
            if (checked == true) {
                $scope.copyForMyGameDaySupply(list);
            } else {
                $scope.removeSelectedSupply(list);
            }
        }
        // function getTailgaters() {
        //     var tailgateId = $cookies.get("currtailGateId");
        //     TailgateService.getMyTailgateUsers(tailgateId).then(function (respData) {
        //         $scope.myTailgaters = respData.data;
        //     });
        // }
        $scope.updateSupplyItems = function (data) {
            // if(data.supplyListItemName.indexOf("/") > -1) {
            //     data.supplyListItemName = decodeURIComponent(data.supplyListItemName);
            // }
            TailgateService.updateTailgateSupplyItem(data.tailgateSupplyItemId, data.supplyListItemName, data.tailgateId, data.itemAssignedUserId).then(function (respData) {
            });
        }
        function getItems() {
            TailgateService.getItemsByTailgateId(tailgateId).then(function (respData) {
                $scope.setSelectedSupplyItemArray(respData.data);
                $scope.toggleItem();
            });
        }
        $scope.setSelectedSupplyItemArray = function (data) {
            $scope.selectedSupplyListItems = [];
            var tempItem = {};
            angular.forEach(data, function (object, idx) {
                tempItem = {};
                tempItem.createdDate = object.createdDate;
                tempItem.modifiedDate = object.modifiedDate;
                tempItem.supplyItemId = object.tailgateSupplyItemId;
                tempItem.supplyItemName = decodeURIComponent(object.supplyListItemName);
                tempItem.itemAssignedUserId = object.itemAssignedUserId + "";
                $scope.selectedSupplyListItems.push(tempItem)
            })
        };
        function getTailgateTime(date) {
            var x = new Date(date);
            var hour = x.getHours();
            var minute = x.getMinutes();
            var seconds = x.getSeconds();
            var year = x.getYear() + 1900;
            var month = x.getMonth();
            var day = x.getDate();
            return new Date(year, month, day, hour, minute, 0);
        }
        $scope.initialize();

    }
})();
