(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('prePostGameCtrl', prePostGameCtrl);

    prePostGameCtrl.$inject = ['$scope', '$stateParams', '$state', 'EventsService', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$cookies', '$timeout','$localStorage','SERVER'];

    /* @ngInject */
    function prePostGameCtrl($scope, $stateParams, $state, EventsService, $ionicSlideBoxDelegate, $ionicScrollDelegate, $cookies, $timeout, $localStorage, SERVER) {
        /* jshint validthis: true */
        var self = this;
        $scope.eventDetails = {};
        $scope.event = {};
        $scope.Details = [];
        $scope.INFO_TYPE = [];
        $scope.INFO_TYPE_CATEGORY = [];
        $scope.Pre_Game = [];
        $scope.Post_Game = [];
        $scope.During_Game = [];
        $scope.currEventName = $stateParams.eventName;
        $scope.currEventId = $stateParams.eventId;
        var currEventId = $scope.currEventId;
        $scope.showAddv = false;
        var PRE_EVENT = "Pre-Event";
        var AT_EVENT = "During-Event";
        var POST_EVENT = "Post-Event";
        var userDetail = $cookies.getObject('CurrentUser');
        if (userDetail != undefined) {
            var agreedToTermsOfUse = userDetail.data.isContentAdmin;
        }
        if (angular.isUndefined($localStorage["CachedEvents"])) {
            $localStorage["CachedEvents"] =  {};
        }

        if ( $localStorage["CachedEvents"][currEventId] == undefined) {
            $localStorage["CachedEvents"][currEventId] = {};
            getEventVenueDatail();
            getCurrentEvent();
        } else if(checkExpiryTime($localStorage["CachedEvents"][currEventId].addeddTime)) {
            getEventVenueDatail();
            getCurrentEvent();
        }
         else {
            setEventVenueDatail($localStorage["CachedEvents"][currEventId].getEventVenueDatail);
            setCurrentEvent($localStorage["CachedEvents"][currEventId].getCurrentEvent);
        }
        function getCurrentEvent() {
            EventsService.getEventByEventId($scope.currEventId).then(function (respData) {
                $localStorage["CachedEvents"][currEventId].getCurrentEvent = respData;
                $localStorage["CachedEvents"][currEventId].addeddTime = new Date().getTime();
                setCurrentEvent(respData);
                setCurrentEvent(respData);
            })
        }
        function checkExpiryTime (dataAddedTime) {
            if (angular.isUndefined(dataAddedTime)) {
                return true;
            }
            var currTime = new Date().getTime();
            if(currTime-dataAddedTime > SERVER.cacheExpireTime) {
                return true;
            } else {
                return false;
            }
        }
        function setCurrentEvent(respData) {
            $scope.currVenueName = respData.data.venueName;
            $scope.currEventDate = respData.data.eventDate;
            $scope.currVenueId = respData.data.venueId;
            $scope.currEventName = $stateParams.eventName;
        }
       
        $scope.preEvent = function (pre) {
            if (pre == "Tickets") {
                $state.go("app.tickets", { venueName: $scope.currVenueName, eventDate: $scope.currEventDate, eventName: $scope.currEventName, infoType: PRE_EVENT, infoTypeCategory: pre, venueId: $scope.currVenueId });
            }
            else if (pre == "Game Day Needs" || pre == "Supplies") {
                $state.go("app.supplies", { myListName: "My Supply", currEventId: $scope.currEventId });
            }
            else if (pre == "Add Content") {
                $state.go("app.manage_event_content", { eventDetails: $scope.eventDetails, infoType: PRE_EVENT, infoTypeCategory: pre, currEventName: $scope.currEventName, currEventId: $scope.currEventId });
            }
            else {
                $state.go("app.event_map_view", { eventDetails: $scope.eventDetails, infoType: PRE_EVENT, infoTypeCategory: pre });
            }
        }
        $scope.atEvent = function (during) {
            if (during == "Add Content") {
                $state.go("app.manage_event_content", { eventDetails: $scope.eventDetails, infoType: AT_EVENT, infoTypeCategory: during, currEventName: $scope.currEventName, currEventId: $scope.currEventId });
            }
            else {
                $state.go("app.event_map_view", { eventDetails: $scope.eventDetails, infoType: AT_EVENT, infoTypeCategory: during });

            }
        }
        $scope.postEvent = function (post) {
            if (post == "Add Content") {
                $state.go("app.manage_event_content", { eventDetails: $scope.eventDetails, infoType: POST_EVENT, infoTypeCategory: post, currEventName: $scope.currEventName, currEventId: $scope.currEventId });
            }
            else {
                $state.go("app.event_map_view", { eventDetails: $scope.eventDetails, infoType: POST_EVENT, infoTypeCategory: post });
            }


        }



        function getEventVenueDatail() {
            EventsService.getEventVenueDatail(currEventId).then(function (respData) {
                 $localStorage["CachedEvents"][currEventId].getEventVenueDatail = respData;
                 setEventVenueDatail(respData);
            });
        }
        function setEventVenueDatail(respData) {
            $scope.eventDetails = respData.data;
                var len = respData.data.Details.length - 1;
                for (var i = 0; i <= len; i++) {
                    $scope.Details.push(angular.fromJson(respData.data.Details[i].Detail))
                    if ($scope.INFO_TYPE.indexOf($scope.Details[i].infoTypeName) == -1) {
                        $scope.INFO_TYPE.push($scope.Details[i].infoTypeName)
                    }
                }
                for (var i = 0; i <= len; i++) {
                    if ($scope.Details[i].infoTypeName == PRE_EVENT) {
                        if ($scope.Pre_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                            $scope.Pre_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    } else
                        if ($scope.Details[i].infoTypeName == AT_EVENT) {
                            if ($scope.During_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.During_Game.push($scope.Details[i].infoTypeCategoryName)
                            }
                        } else {
                            if ($scope.Post_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.Post_Game.push($scope.Details[i].infoTypeCategoryName)
                            }
                        }
                }
                $timeout(function () {
                    $ionicSlideBoxDelegate.$getByHandle('slide1').update();
                    $ionicSlideBoxDelegate.$getByHandle('slide2').update();
                    $ionicSlideBoxDelegate.$getByHandle('slide3').update();
                    $scope.showAddv = true;
                }, 100);
                $ionicScrollDelegate.resize();



                if ($scope.Post_Game.length >= 0) {
                    if (userDetail != undefined && agreedToTermsOfUse == true) {
                        $scope.Post_Game.push("Add Content");
                    }
                }
                if ($scope.During_Game.length >= 0) {
                    if (userDetail != undefined && agreedToTermsOfUse == true) {
                        $scope.During_Game.push("Add Content");
                    }
                }
                if ($scope.Pre_Game.length >= 0) {
                    $scope.Pre_Game.push("Game Day Needs");
                    if (userDetail != undefined && agreedToTermsOfUse == true) {
                        $scope.Pre_Game.push("Add Content");
                    }
                }
        }
        $scope.slidePrevious1 = function (slide) {
            $ionicSlideBoxDelegate.$getByHandle(slide).previous();
        }

        $scope.slideNext1 = function (slide) {
            $ionicSlideBoxDelegate.$getByHandle(slide).next();
        }

        $scope.getBackgroundImage = function (imgName, infotype) {
            var defaultExt = ".jpg";
            var fileName;
            switch (imgName.toLowerCase()) {
                case "tradition":
                    fileName = 'Flask_Tradition';
                    break;
                case "parking":
                    fileName = 'PRE_PARKING';
                    break;
                case "bar & restaurants":
                    fileName = 'PRE_BAR_RESTAURANTS';
                    break;
                case "traffic":
                    fileName = 'PRE_TRAFFIC';
                    break;
                case "supplies":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "getting home":
                    fileName = 'flask_GettingHome';
                    break;
                case "nightlife":
                    fileName = 'POST_NIGHTLIFE';
                    break;
                case "liquor store":
                    fileName = 'flask_restaurantBar_post';
                    break;
                case "venue info":
                    fileName = 'venue_info';
                    break;
                case "venue map":
                    fileName = 'VENUE_MAP';
                    break;
                case "flask us":
                    fileName = 'Flask_FlaskUs' + "_" + infotype;
                    break;
                case "tickets":
                    fileName = 'tickets';
                    break;
                case "game day needs":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "add content":
                    fileName = 'Add_Event_Content'
                    break;
                case "hotels":
                    fileName = 'POST_HOTEL'
                    break;
                case "getting home":
                    fileName = 'POST_GETTINGHOME'
                    break;
                default:
                    fileName = 'Flask_Default_Image';
            }
            fileName = fileName + defaultExt;
            return fileName;
        }

        $scope.getImageLabel = function (imgName, infotype) {

            var defaultExt = ".svg";
            var fileName
            switch (imgName.toLowerCase()) {
                case "tradition":
                    fileName = 'Flask_Tradition';
                    break;
                case "parking":
                    fileName = 'PRE_PARKING';
                    break;
                case "bar & restaurants":
                    fileName = 'PRE_BAR_RESTAURANTS';
                    break;
                case "traffic":
                    fileName = 'PRE_TRAFFIC';
                    break;
                case "supplies":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "getting home":
                    fileName = 'flask_GettingHome';
                    break;
                case "nightlife":
                    fileName = 'POST_NIGHTLIFE';
                    break;
                case "liquor store":
                    fileName = 'flask_restaurantBar_post';
                    break;
                case "venue info":
                    fileName = 'venue_info';
                    break;
                case "venue map":
                    fileName = 'VENUE_MAP';
                    break;
                case "flask us":
                    fileName = 'Flask_FlaskUs' + "_" + infotype;
                    break;
                case "tickets":
                    fileName = 'tickets';
                    break;
                case "game day needs":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "add content":
                    fileName = 'Add_Event_Content'
                    break;
                case "hotels":
                    fileName = 'POST_HOTEL'
                    break;
                case "getting home":
                    fileName = 'POST_GETTINGHOME'
                    break;
                default:
                    fileName = 'Flask_Default_Image';
            }
            fileName = fileName + defaultExt;
            return fileName;
        }

    }
})(); 