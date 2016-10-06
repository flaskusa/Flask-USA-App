(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter', '$ionicModal', '$flaskUtil', '$cookies', 'ionicDatePicker', 'ionicTimePicker', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService', '$rootScope', '$sce'];

    / @ngInject /
    function add_mytailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter, $ionicModal, $flaskUtil, $cookies, ionicDatePicker, ionicTimePicker, $ionicPopup, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService, $rootScope, $sce) {
        //for adding tailgate
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
        $scope.defaultImageUrl = "img/default-profilepic-copy.png";
        $scope.hideItem = false;
        $scope.selectedSupplyListItems = [];
        $scope.allMyTailgateItems = [];

        getMySupplyList();

        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
        var tailgateId = $cookies.get("currtailGateId");
        $scope.initialize = function () {
            if (tailgateId != undefined && tailgateId > 0 && $scope.tailgateLogoId > 0) {
                $scope.getTailGateLogo(tailgateId);

                $scope.isUserTailgateAdmin(tailgateId);
            } else {
                $scope.isTailgateAdmin = true;
            }
            if (tailgateId != undefined && tailgateId > 0) {
                getItems();
            }
            getTailgaters();

        }

        $scope.user = {
            supplyItemName: ['user']
        };

        $scope.addTailgateParams = {
            tailgateName: '',
            tailgateDescription: '',
            eventId: '',
            eventName: '',
            venmoAccountId: '',
            amountToPay: '',
            tailgateId: ''
        }
        callMap($scope.latitude, $scope.longitude);
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
        }
        $scope.windowOptions = {
            show: true
        };
        function currMarker(loc) {
            var markerData = {};
            console.log(loc, $scope.map.markers[0].coords);
            markerData.tailgateId = newtailGateId;
            markerData.latitude = $scope.map.markers[0].coords.latitude;
            markerData.longitude = $scope.map.markers[0].coords.longitude;
            markerData.name = loc.name;
            markerData.description = loc.description;
            saveMaker(markerData);
        }
        function saveMaker(markerData) {
            TailgateService.addTailgateMarkers(markerData).then(function (respData) {
            });
        }
        //call on marker click
        $scope.onClick = function (data) {
            $scope.loc = {};
            var customTemplate =
                '<form><div class="list">'
                + '        <label class="item item-input item-floating-label">'
                + '         <span class="input-label">Place Name</span>'
                + '           <input type="text" placeholder="Place Name" ng-model="loc.name">'
                + '        </label>'
                + '         <label class="item item-input item-floating-label">'
                + '      <span class="input-label">Description</span>'
                + '        <input type="text" placeholder="Description" ng-model="loc.description">'
                + '       </label>                 '
                + '    </div>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="currMarker($scope.loc);">'
                + 'Save'
                + '</button>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="clearMArkersOnMap();" >'
                + 'Remove'
                + '</button>'
                + ' </div>'
                + '</form>';

            var locationPopup = $ionicPopup.show({
                template: customTemplate,
                title: 'Enter Location Details',
                scope: $scope,
                buttons: [
                    //{
                    //  text: '<b>Save</b>',
                    //  type: 'button-positive',
                    //  onTap: function(e) {

                    //   }
                    //  },{
                    //    text: '<b>Remove</b>',
                    //    //type: 'button-positive',
                    //    onTap: function(e) {

                    //     }
                    //   },
                    {
                        text: '<b>Cancel</b>',
                        //type: 'button-positive',
                        onTap: function (e) {
                            locationPopup.close();
                        }
                    }]
            });
        };
        $scope.clearMArkersOnMap = function () {
            $scope.map.markers.pop();
        }
        getallEventnames();

        // invoke on type search box
        $scope.loadeventData = function () {
            var EventId = 0;
            var shownVal = document.getElementById("envtName").value;
            var EventCol = document.querySelector("#EventNameList option[value='" + shownVal + "']");
            if (EventCol == null) {
                EventId = 0;
            } else {
                EventId = EventCol.getAttribute("data_Id");
            }
            $scope.addTailgateParams.eventId = EventId;
            getEventDetails(EventId);
        }
        //get event and venue details in select box
        function getEventDetails(eventId) {
            TailgateService.getEvent(eventId).then(function (respData) {
                $scope.CurrEvent = respData.data;
                var venueID = $scope.CurrEvent.venueId;
                var currStartTime = $filter('date')($scope.CurrEvent.startTime, 'hh:mm a');
                var currEndTime = $filter('date')($scope.CurrEvent.endTime, 'hh:mm a');
                var currDate = $filter('date')($scope.CurrEvent.eventDate, 'MM-dd-yyyy');

                $scope.addTailgateParams.startTime = currStartTime;
                $scope.selectedtime1 = currStartTime;
                $scope.selectedtime2 = currEndTime;
                $scope.addTailgateParams.endTime = currEndTime;
                $scope.tailgateDate = currDate;
                TailgateService.getvenueDetails(venueID).then(function (VENUEData) {
                    console.log(VENUEData);
                    callMap(VENUEData.latitude, VENUEData.longitude);
                });
            });

            $scope.register = function () {
                console.log('Clicked');
            }
        }

        // to hide and show tabs
        $scope.enableTab = {
            condition: false
        };
        checkTailgateId();
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
            console.log(tailgateDetails);
            $scope.addTailgateParams = {
                tailgateName: tailgateDetails.tailgateName,
                tailgateDescription: tailgateDetails.tailgateDescription,
                eventId: tailgateDetails.eventId,
                eventName: tailgateDetails.eventName,
                venmoAccountId: tailgateDetails.venmoAccountId,
                amountToPay: tailgateDetails.amountToPay,
                tailgateId: tailgateDetails.tailgateId
            }
            $scope.tailgateDate = $filter('date')(tailgateDetails.tailgateDate, 'MM-dd-yyyy');
            $scope.selectedtime1 = $filter('date')(tailgateDetails.startTime, 'hh:mm a');
            $scope.selectedtime2 = $filter('date')(tailgateDetails.endTime, 'hh:mm a');
            $scope.tailgateLogoId = tailgateDetails.logoId;
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
                endTime: tailgateDetails.endTime,
                logoId: tailgateDetails.logoId
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
                $scope.setSelectedImageURIToUpload(imageURI);
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
                $scope.setSelectedImageURIToUpload(imageURI);
            }, function (err) {

            });

        }
        $scope.setSelectedImageURIToUpload = function (imageURI) {
            $scope.defaultImageUrl = imageURI;
            $scope.isImageSelectedToUpload = true;
            $scope.selectedImageURIToUpload = imageURI;
        };
        $scope.reSetSelectedImageURIToUpload = function () {
            $scope.isImageSelectedToUpload = false;
            $scope.selectedImageURIToUpload = '';
        }

        $scope.uploadFileToServer = function (fileURL, tailgateId) {
            $rootScope.$broadcast('loading:show');
            var options = {};
            options.fileKey = "file";
            var params = {};
            params.tailgateId = tailgateId;
            var authdata = $cookies.get("authData");
            options.params = params;
            var headers = {};
            headers.Authorization = 'Basic ' + authdata;
            options.headers = headers;
            $cordovaFileTransfer.upload(encodeURI(SERVER.url + '/flask-user-tailgate-portlet.tailgateimages/upload-tailgate-logo'), fileURL, options)
                .then(function (r) {
                    $rootScope.$broadcast('loading:hide')
                    $scope.reSetSelectedImageURIToUpload();
                    $scope.downloadProgress = 0;
                    var data = $.parseJSON(r.response);
                    var repositoryId = data.repositoryId;
                    var folderId = data.folderId;
                    var title = data.title;
                    $scope.setLogoImageUrl(repositoryId, folderId, title);
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

        $scope.setLogoImageUrl = function (repositoryId, folderId, title) {
            $scope.tailgateLogoUrl = SERVER.hostName + "documents/" + repositoryId + "/" + folderId + "/" + title;
            $scope.tailgateLogoUrl = encodeURI($scope.tailgateLogoUrl);
        }
        //add new tailgate
        $scope.addmyTailgate = function (tailgatedata) {
            if (tailgatedata.eventName.trim() == '' || !tailgatedata.eventId > 0) {
                return;
            }
            var startTime = Date.parse($scope.tailgateDate + " " + $scope.selectedtime1); // Your timezone!
            var endTime = Date.parse($scope.tailgateDate + " " + $scope.selectedtime2);
            tailgatedata.tailgateDate = new Date($scope.tailgateDate).getTime();
            tailgatedata.endTime = endTime;
            tailgatedata.startTime = startTime;
            tailgatedata.venmoAccountId = "";
            tailgatedata.amountToPay = 0;
            tailgatedata.logoId = 0;
            tailgatedata.eventId = angular.isString(tailgatedata.eventId) ? parseInt(tailgatedata.eventId) : tailgatedata.eventId;
            if (tailgatedata.tailgateId && tailgatedata.tailgateId > 0) {
                TailgateService.updateTailgateInfo(tailgatedata).then(function (respdata) {
                    if ($scope.isImageSelectedToUpload) {
                        $scope.uploadFileToServer($scope.selectedImageURIToUpload, tailgatedata.tailgateId);
                    }
                });
            }
            else {
                TailgateService.addTailgate(tailgatedata).then(function (respData) {
                    if ($scope.isImageSelectedToUpload) {
                        $scope.uploadFileToServer($scope.selectedImageURIToUpload, respData.data.tailgateId);
                    }
                    $cookies.put('newtailgateId', respData.data.tailgateId);
                    $cookies.putObject('newtailgatedata', respData.data);
                    $scope.newtailgatesId = respData.data.tailgateId;
                    $cookies.put("")
                    $scope.enableTab = {
                        condition: true
                    };
                    newtailGateId = $cookies.get('newtailgateId');
                    getTailgaters(newtailGateId);
                });
            }
        }
        //update tailgate
        $scope.updatetailgate = function (newUpdate) {
            var updateData = $cookies.getObject("newtailgatedata");
            updateData.venmoAccountId = newUpdate.venmoAccountId;
            updateData.amountToPay = newUpdate.amountToPay;
            console.log(updateData);
            TailgateService.updateTailgateInfo(updateData).then(function (respdata) {
                console.log(respdata);
            });
            fnPayNow();
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
        //to add date popup in form
        $scope.selectedtime1;
        var ipObj1 = {
            callback: function (val) {
                if (typeof (val) === 'undefined') {
                    console.log('Time not selected');
                } else {
                    var selectedTime = new Date(val * 1000);
                    console.log('Selected epoch is : ', val, 'and the time is ', selectedTime.getUTCHours(), 'Hrs :', selectedTime.getUTCMinutes(), 'Min');
                    var currentHrs = selectedTime.getUTCHours();
                    if (currentHrs > 12) {
                        $scope.selectedtime1 = (selectedTime.getUTCHours()) - 12 + ' :' + selectedTime.getUTCMinutes() + " PM";
                        console.log($scope.selectedtime1 + " PM");
                    } else {
                        $scope.selectedtime1 = (selectedTime.getUTCHours()) + ' :' + selectedTime.getUTCMinutes() + " AM";
                        console.log($scope.selectedtime1 + " AM");
                    }
                }
            },
            inputTime: (((new Date()).getHours() * 60 * 60) + ((new Date()).getMinutes() * 60)),
            format: 12,
            step: 5,
            setLabel: 'Set'
        };
        var ipObj2 = {
            callback: function (val) {
                if (typeof (val) === 'undefined') {
                    console.log('Time not selected');
                } else {
                    var selectedTime = new Date(val * 1000);
                    console.log('Selected epoch is : ', val, 'and the time is ', selectedTime.getUTCHours(), 'Hrs :', selectedTime.getUTCMinutes(), 'Min');
                    var currentHrs = selectedTime.getUTCHours();
                    if (currentHrs > 12) {
                        $scope.selectedtime2 = (selectedTime.getUTCHours()) - 12 + ' :' + selectedTime.getUTCMinutes() + " PM";
                    } else {
                        $scope.selectedtime2 = (selectedTime.getUTCHours()) + ' :' + selectedTime.getUTCMinutes() + " AM";
                    }
                }
            },
            inputTime: (((new Date()).getHours() * 60 * 60) + ((new Date()).getMinutes() * 60)),
            format: 12,
            step: 5,
            setLabel: 'Set'
        };
        $scope.openTimePicker1 = function () {
            ionicTimePicker.openTimePicker(ipObj1);//for start timepicker
        };
        $scope.openTimePicker2 = function () {
            ionicTimePicker.openTimePicker(ipObj2);// for end timepicker
        };

        //for adding attendees in new tailgate
        $scope.myTailgaters = [];
        $scope.active = true; // define the tab in add group and add friend section
        $scope.active1 = true;
        $scope.myFriends = [];
        // $ionicModal.fromTemplateUrl('templates/modal.html', {
        //     scope: $scope
        // }).then(function (modal) {
        //     $scope.modal = modal;
        // });

        function getTailgaters(newtailgateId) {
            TailgateService.getMyTailgateUsers(newtailgateId).then(function (respData) {
                $scope.myTailgaters = respData.data;
            });
        }
        function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                $scope.myFriends = respData;
            })
        }
        //add single member to the tailgate
        $scope.addTailgateMembers = function (currUserData, index) {
            var addUserparams = {};
            addUserparams.groupId = 0;
            addUserparams.userId = currUserData.userId;
            addUserparams.userName = currUserData.firstName + " " + currUserData.lastName;
            addUserparams.emailAddress = currUserData.emailAddress;
            addUserparams.isAdmin = 0;
            addUserparams.tailgateId = newtailGateId;
            addUserparams.isPaid = 0;
            addUserparams.paymentMode = "None";
            $scope.myFriends.splice(index, 1);
            addUsertoTailgate(addUserparams);
            $scope.myTailgaters;
        }
        //get all groups either created by user or is a member of particular group.
        function getAllGroups() {
            userResponse = $cookies.getObject('CurrentUser');
            UserId = userResponse.data.userId;
            console.log(UserId);
            TailgateService.getGroupbyId(UserId).then(function (respData) {
                $scope.allGroups = respData;
            });
        }
        //add user info to current tailgate
        function addUsertoTailgate(userparams) {
            TailgateService.addcurrentUser(userparams).then(function (respData) {
            });
        }
        $scope.getUseData = [];
        //get all the members of the group
        $scope.getusersofGroup = function (groupId) {
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
                console.log($scope.getUseData)
                $scope.groupUserDetails = respData;
            });
        }

        //list of supplies
        function getMySupplyList(selected1) {
            TailgateService.getMySupplyLists().then(function (respData) {
                $scope.allSupplyList = respData.data;
                for (var i = 0; i < $scope.allSupplyList.length; i++) {
                    $scope.tailgateSupplyList.push({ supplyListName: $scope.allSupplyList[i].supplyListName, supplyListsId: $scope.allSupplyList[i].supplyListId });
                }
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
        function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                $scope.myFriends = respData;
            })
        }

        //Get tailgates of particular user
        function getAllMyTailgates(userId) {
            TailgateService.getMyTailgates(userId).then(function (respData) {
                $scope.allMyTailgate = respData.data;
            });
        }

        //Adding supply items to tailgate
        $scope.addSupplyItems = function () {
            angular.forEach($scope.selectedSupplyListItems, function (val, idx) {
                $scope.items.push(val.supplyItemName)
            })
            itemArray = $scope.items.toString();
            var tailgateId = $cookies.get("currtailGateId");
            TailgateService.addTailgateSupplyItems(itemArray, tailgateId, UserId).then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
                $scope.associateUserWithSupplyItem();
            });

        }


        $scope.associateUserWithSupplyItem = function () {
            angular.forEach($scope.selectedSupplyListItems, function (val, idx) {
                if (val.itemAssignedUserId > 0) {
                    $scope.updateSupplyItems(val);
                }

            })
        }


        //venmo Account pay now
        function fnPayNow() {
            var tailgateId = newtailGateId;
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
                $scope.setLogoImageUrl($scope.tailgateLogoInfo.repositoryId, $scope.tailgateLogoInfo.folderId, $scope.tailgateLogoInfo.title);
            });
        };

        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
                console.log("Admin User " + $scope.isTailgateAdmin);
            });
        };
        $scope.toggleItem = function () {
            $scope.hideItem = !$scope.hideItem;
            $("#FlaskUsListdiv").slideToggle("slow", function () {
            });
        }
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
        function getTailgaters() {
            var tailgateId = $cookies.get("currtailGateId");
            TailgateService.getMyTailgateUsers(tailgateId).then(function (respData) {
                $scope.myTailgaters = respData.data;
            });
        }
        $scope.updateSupplyItems = function (data) {
            TailgateService.updateTailgateSupplyItem(data.supplyItemId, data.supplyItemName, tailgateId, data.itemAssignedUserId).then(function (respData) {
            });
        }
        function getItems() {
            TailgateService.getItemsByTailgateId(tailgateId).then(function (respData) {
                $scope.setSelectedSupplyItemArray(respData.data);
                $scope.toggleItem();
            });
        }
        $scope.setSelectedSupplyItemArray = function (data) {
            var tempItem = {};
            angular.forEach(data, function (object, idx) {
                tempItem = {};
                tempItem.createdDate = object.createdDate;
                tempItem.modifiedDate = object.modifiedDate;
                tempItem.supplyItemId = object.tailgateSupplyItemId;
                tempItem.supplyItemName = object.supplyListItemName;
                tempItem.itemAssignedUserId = object.itemAssignedUserId + "";
                $scope.selectedSupplyListItems.push(tempItem)
            })
        };

        $scope.initialize();

    }
})();
