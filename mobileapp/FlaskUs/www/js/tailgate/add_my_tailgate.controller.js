﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter', '$ionicModal', '$flaskUtil', '$cookies', 'ionicDatePicker', 'ionicTimePicker', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer'];

    / @ngInject /
    function add_mytailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter, $ionicModal, $flaskUtil, $cookies, ionicDatePicker, ionicTimePicker, $ionicPopup, $cordovaCamera, $cordovaFileTransfer) {
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
        $scope.tailgateSupplyList = [], [];
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

        getMySupplyList();

        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
        $scope.initialize = function () {
            var tailgateId = $cookies.get("currtailGateId");
            if (tailgateId != undefined && tailgateId > 0) {
                $scope.getTailGateLogo(tailgateId);
                $scope.isUserTailgateAdmin(tailgateId);
            } else {
                $scope.isTailgateAdmin = true;
            }

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
            amountToPay: ''
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
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="clearMArkersOnMap();">'
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
                amountToPay: tailgateDetails.amountToPay
            }
            $scope.tailgateDate = $filter('date')(tailgateDetails.tailgateDate, 'MM-dd-yyyy');
            $scope.selectedtime1 = $filter('date')(tailgateDetails.startTime, 'hh:mm a');
            $scope.selectedtime2 = $filter('date')(tailgateDetails.endTime, 'hh:mm a');

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
            console.log($scope.editData);
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
        //camera plugin
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
            var tailgateId = $cookies.get("currtailGateId");
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
                    $scope.downloadProgress = 0;
                    var data = $.parseJSON(r.response);
                    var repositoryId = data.repositoryId;
                    var folderId = data.folderId;
                    var title = data.title;
                    $scope.setLogoImageUrl(repositoryId, folderId, title);
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
        //add new tailgate
        $scope.addmyTailgate = function (tailgatedata) {
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
                    console.log(respdata);
                });
            }
            else {
                TailgateService.addTailgate(tailgatedata).then(function (respData) {
                    console.log(respData.data);
                    $cookies.put('newtailgateId', respData.data.tailgateId);
                    $cookies.putObject('newtailgatedata', respData.data);
                    $scope.newtailgatesId = respData.data.tailgateId;
                    console.log($scope.newtailgatesId);
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
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });

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

            for (var i = 0; i < $scope.supplyItemList.length; i++) {
                $scope.items.push($scope.supplyItemList[i].supplyItemName)
            }
            itemArray = $scope.items.toString();
            TailgateService.addTailgateSupplyItems(itemArray, $scope.newtailgatesId, UserId).then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
            });

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
        $scope.initialize();

    }
})();
