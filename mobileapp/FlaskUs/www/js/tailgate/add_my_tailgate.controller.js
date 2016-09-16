(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter', '$ionicModal', '$flaskUtil', '$cookies', 'ionicDatePicker', 'ionicTimePicker'];

    / @ngInject /
    function add_mytailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter, $ionicModal, $flaskUtil, $cookies, ionicDatePicker, ionicTimePicker) {
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
        $scope.longitude = '83.0456';
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
        $scope.map = {
            draggable: true,
            center: { latitude: 43.4651, longitude: -80.5223 },
            zoom: 4
        };
        $scope.pageFlow = {
            disableOtherTabs: true
        }

        $scope.pageFlow.disableOtherTabs = false;

        getallEventnames();
        // invoke on type search box
        $scope.LoadSessionData = function () {
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
                    angular.extend($scope, {
                        map: {
                            center: {
                                latitude: VENUEData.latitude,
                                longitude: VENUEData.longitude
                            },
                            zoom: 11,
                            markers: [],
                            events: {
                                click: function (map, eventName, originalEventArgs) {
                                    var e = originalEventArgs[0];
                                    var lat = e.latLng.lat(), lon = e.latLng.lng();
                                    var marker = {
                                        id: Date.now(),
                                        icon: 'img/marker.png',
                                        coords: {
                                            latitude: lat,
                                            longitude: lon
                                        }
                                    };
                                    $scope.map.markers.push(marker);
                                    console.log($scope.map.markers);
                                    $scope.$apply();
                                }
                            }
                        }
                    });
                });
                $scope.isavail = true;
            });
        }

        $scope.isavail = false;
        // to hide and show tabs
        $scope.enableTab = {
            condition:false
        };
        //add new tailgate
        $scope.addmyTailgate = function (tailgatedata) {
            var startTime = Date.parse($scope.tailgateDate + " " + $scope.selectedtime1); // Your timezone!
            var endTime = Date.parse($scope.tailgateDate + " " + $scope.selectedtime2);
            tailgatedata.tailgateDate = new Date($scope.tailgateDate).getTime() / 1000;
            tailgatedata.endTime = endTime;
            tailgatedata.startTime = startTime;
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data);
                $cookies.put('newtailGateId', respData.data.tailgateId);
                $scope.enableTab = {
                    condition: true
                };
                newtailGateId = $cookies.get('newtailGateId');
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
                $scope.active = true;
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
            TailgateService.addcurrentUser(addUserparams).then(function (respData) {
                $scope.myFriends.splice(index, 1);
            })           
        }

        function getAllGroups() {
            TailgateService.getGroupList().then(function (respData) {
                $scope.allGroups = respData;
            });
        }
        $scope.getUseData = [];
        $scope.getusersofGroup=function(groupId) {
            TailgateService.getGroupUsers(groupId).then(function (respData) { //get data of group from group id
                console.log(respData);
               
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
                    TailgateService.addcurrentUser(adduser).then(function (respData) {
                        console.log(respData);
                    });
                }
                console.log( $scope.getUseData)
                $scope.groupUserDetails = respData;
            });
        }
    }
})();