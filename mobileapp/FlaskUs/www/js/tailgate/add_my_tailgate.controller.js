(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter', '$ionicModal', '$flaskUtil', '$cookies', 'ionicDatePicker', 'ionicTimePicker','$ionicPopup'];

    / @ngInject /
    function add_mytailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter, $ionicModal, $flaskUtil, $cookies, ionicDatePicker, ionicTimePicker,$ionicPopup) {
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

        $scope.addTailgateParams = {
            tailgateName: '',
            tailgateDescription: '',
            eventId: '',
            eventName: '',
            venmoAccountId: '',
            amountToPay: ''
        }
        callMap($scope.latitude,$scope.longitude);
        //calling map on load and on events change
        function callMap( currlatitude,currlongitude){
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
                            if($scope.map.markers.length>1){
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
        function currMarker(loc){
            var markerData = {};
            console.log(loc,$scope.map.markers[0].coords);
            markerData.tailgateId =newtailGateId;
            markerData.latitude=$scope.map.markers[0].coords.latitude;
            markerData.longitude=$scope.map.markers[0].coords.longitude;
            markerData.name=loc.name;
            markerData.description=loc.description;
            saveMaker(markerData);
        }
        function saveMaker(markerData){
            TailgateService.addTailgateMarkers(markerData).then(function (respData) {
            });
        }
        //call on marker click
        $scope.onClick = function (data) {
          $scope.loc = {};
            var customTemplate =
              '<form><div class="list">'
              +'        <label class="item item-input item-floating-label">'
              +'         <span class="input-label">Place Name</span>'
             +'           <input type="text" placeholder="Place Name" ng-model="loc.name">'
              +'        </label>'
             +'         <label class="item item-input item-floating-label">'
              +'      <span class="input-label">Description</span>'
               +'        <input type="text" placeholder="Description" ng-model="loc.description">'
               +'       </label>                 '
                +'    </div>'
                   +' </div>'
                +'</form>';

            $ionicPopup.show({
              template: customTemplate,
              title: 'Enter Location Details',
              scope: $scope,
              buttons: [ {
                text: '<b>Save</b>',
                type: 'button-positive',
                onTap: function(e) {
                  currMarker($scope.loc);
                }
              },{
                text: '<b>Remove</b>',
                //type: 'button-positive',
                onTap: function(e) {
                    $scope.map.markers.pop();
                }
              }]
            });
        };
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
                    callMap(VENUEData.latitude,VENUEData.longitude);
                });               
            });

            $scope.register = function () {
                console.log('Clicked');
            }
        }

        // to hide and show tabs
        $scope.enableTab = {
            condition:false
        };
        checkTailgateId();
        function checkTailgateId() {
            var tailgateDetails = $cookies.getObject("editUserTailgate");
            if (!tailgateDetails) {

            } else {
                editTailgateData(tailgateDetails);
            }
        }
        function editTailgateData(tailgateDetails) {
            console.log(tailgateDetails);
            $scope.addTailgateParams = {
                tailgateName: tailgateDetails.tailgateName,
                tailgateDescription: tailgateDetails.tailgateDescription,
                eventId: tailgateDetails.eventId,
                eventName: tailgateDetails.eventName,
                venmoAccountId: tailgateDetails.venmoAccountId,
                amountToPay: tailgateDetails.amountToPay
            }
            $scope.tailgateDate = $filter('date')(tailgateDetails.tailgateDate, 'hh:mm a');
            $scope.selectedtime1 = $filter('date')(tailgateDetails.startTime, 'hh:mm a');
            $scope.selectedtime2 = $filter('date')(tailgateDetails.endTime, 'MM-dd-yyyy');
        };
        //add new tailgate
        $scope.addmyTailgate = function (tailgatedata) {
            var startTime = Date.parse($scope.tailgateDate + " " + $scope.selectedtime1); // Your timezone!
            var endTime = Date.parse($scope.tailgateDate + " " + $scope.selectedtime2);
            tailgatedata.tailgateDate = new Date($scope.tailgateDate).getTime();
            tailgatedata.endTime = endTime;
            tailgatedata.startTime = startTime;
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data);
                $cookies.put('newtailgateId', respData.data.tailgateId);
                $scope.enableTab = {
                    condition: true
                };
                newtailGateId = $cookies.get('newtailgateId');
                getTailgaters(newtailGateId);
            });
        }
        // get selected venue details
        $scope.getvenuefromSelect = function (tailgatedata) {
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
            });
        }
        // to get all filtered event list in the select box.
        function getallEventnames() {
            $scope.tailgateParams = {
                eventTypeIds:$scope.eventTypeIds,
                startDate:$scope.startDate,
                endDate: $scope.endDate,
                searchString:  $scope.searchString,
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
                    } else
                    {
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
        
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";        

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
        $scope.addTailgateMembers = function(currUserData,index) {
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
            var userResponse = $cookies.getObject('CurrentUser');
            var UserId = userResponse.data.userId;
            console.log(UserId);
            TailgateService.getGroupbyId(UserId).then(function (respData) {
                $scope.allGroups = respData;
            });
        }
        //add user info to current tailgate
        function addUsertoTailgate(userparams) {
            TailgateService.addcurrentUser(userparams).then(function (respData) {
                console.log(respData);
            });
        }
        $scope.getUseData = [];
        //get all the members of the group
        $scope.getusersofGroup=function(groupId) {
            TailgateService.getGroupUsers(groupId).then(function (respData) { //get data of group from group id     
                for(var i=0;i<respData.length;i++){
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
                console.log( $scope.getUseData)
                $scope.groupUserDetails = respData;
            });
        }
    }
})();