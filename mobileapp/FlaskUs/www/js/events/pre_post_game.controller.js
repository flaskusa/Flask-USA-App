﻿(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('prePostGameCtrl', prePostGameCtrl);

    prePostGameCtrl.$inject = ['$scope', '$stateParams', '$state','EventsService', '$ionicSlideBoxDelegate', '$ionicScrollDelegate','$cookies','$timeout'];

    /* @ngInject */
    function prePostGameCtrl($scope, $stateParams, $state, EventsService, $ionicSlideBoxDelegate, $ionicScrollDelegate,$cookies,$timeout) {
        /* jshint validthis: true */
        var self = this;
        $scope.eventDetails = {};
        $scope.event={};
        $scope.Details = [];
        $scope.INFO_TYPE = [];
        $scope.INFO_TYPE_CATEGORY = [];
        $scope.Pre_Game = [];
        $scope.Post_Game = [];
        $scope.During_Game = [];
        $scope.currEventName = $stateParams.eventName;
        $scope.currEventId = $stateParams.eventId;
        var currEventId = $scope.currEventId;
        $scope.showAddv=false;
        var PRE_EVENT = "Pre-Event";
        var AT_EVENT = "During-Event";
        var POST_EVENT = "Post-Event";
        var userDetail=$cookies.getObject('CurrentUser');
        if(userDetail!=undefined) {
            var agreedToTermsOfUse = userDetail.data.agreedToTermsOfUse;
        }
        
        getEventVenueDatail();
        getCurrentEvent();
        $ionicSlideBoxDelegate.update();
       function getCurrentEvent() {
            EventsService.getEventByEventId($scope.currEventId).then(function (respData) {
                console.log(respData.data.eventDate);
                $scope.currVenueName = respData.data.venueName;
                $scope.currEventDate = respData.data.eventDate;
                $scope.currEventName = $stateParams.eventName;
            })
        }
       $scope.preEvent = function (pre) {
           if (pre == "Tickets") {
               $state.go("app.tickets", { venueName: $scope.currVenueName, eventDate: $scope.currEventDate, eventName: $scope.currEventName, infoType: PRE_EVENT, infoTypeCategory: pre });
           }
           else if(pre=="Game Day Needs"){
               $state.go("app.suppliesList",{listName:"Game Day Needs",supplyListId:84429});
           }
           else if(pre=="Add Content"){
               $state.go("app.manage_event_content", {eventDetails: $scope.eventDetails, infoType: PRE_EVENT, infoTypeCategory: pre,currEventName:$scope.currEventName ,currEventId:$scope.currEventId});
           }
           else {
               $state.go("app.event_map_view", { eventDetails: $scope.eventDetails, infoType: PRE_EVENT, infoTypeCategory: pre });
           }
        }
        $scope.atEvent = function(during){
            if(during=="Add Content"){
                $state.go("app.manage_event_content", {eventDetails: $scope.eventDetails, infoType: AT_EVENT, infoTypeCategory: during,currEventName:$scope.currEventName ,currEventId:$scope.currEventId});
            }
            else{
             $state.go("app.event_map_view", {eventDetails: $scope.eventDetails, infoType: AT_EVENT, infoTypeCategory: during });

            }
        }
        $scope.postEvent = function(post){
            if(post=="Add Content"){
                $state.go("app.manage_event_content", {eventDetails: $scope.eventDetails, infoType: POST_EVENT, infoTypeCategory: post,currEventName:$scope.currEventName ,currEventId:$scope.currEventId});
            }
            else{
                $state.go("app.event_map_view", {eventDetails: $scope.eventDetails, infoType: POST_EVENT, infoTypeCategory: post });
            }


            }



        function getEventVenueDatail() {
            EventsService.getEventVenueDatail(currEventId).then(function (respData) {
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
                    }else
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
               $ionicSlideBoxDelegate.update();
               $ionicScrollDelegate.resize();
                $timeout(function(){
                 $scope.showAddv=true;
                },10);


                if ($scope.Post_Game.length >=0) {
                    if(userDetail!=undefined && agreedToTermsOfUse==true) {
                        $scope.Post_Game.push("Add Content");
                    }
                }
                if ($scope.During_Game.length >= 0) {
                    if(userDetail!=undefined && agreedToTermsOfUse==true) {
                        $scope.During_Game.push("Add Content");
                    }
                }
                if ($scope.Pre_Game.length >= 0) {
                    $scope.Pre_Game.push("Tickets");
                    $scope.Pre_Game.push("Game Day Needs");
                    if(userDetail!=undefined && agreedToTermsOfUse==true) {
                        $scope.Pre_Game.push("Add Content");
                    }
                }
            });

            $scope.slidePrevious1 = function (slide) {
                $ionicSlideBoxDelegate.$getByHandle(slide).previous();
            }

            $scope.slideNext1 = function (slide) {
                $ionicSlideBoxDelegate.$getByHandle(slide).next();
            }

            $scope.getIncludeFile = function (imgName) {
                switch (imgName.toLowerCase()) {
                    case "tradition":
                        return 'Flask_Tradition';
                    case "parking":
                        return 'PRE_PARKING';
                    case "bar & restaurants":
                        return 'PRE_BAR_RESTAURANTS';
                    case "traffic":
                        return 'PRE_TRAFFIC';
                    case "supplies":
                        return 'Flask_Supplies';
                    case "getting home":
                        return 'flask_GettingHome';
                    case "nightlife":
                        return 'POST_NIGHTLIFE';
                    case "liquor store":
                        return 'flask_restaurantBar_post';
                    case "venue info":
                        return 'venue_info';
                    case "venue map":
                        return 'VENUE_MAP';
                    case "flask us":
                        return 'Flask_FlaskUs';
                    case "tickets":
                        return 'tickets';
                    case "game day needs":
                        return 'PRE_SUPPLIES';
                    case "add content":
                        return 'Add_Event_Content'
                    case "hotels":
                        return 'POST_HOTEL'
                    case "getting home":
                        return 'POST_GETTINGHOME'
                    default:
                        return 'Flask_Default_Image';
                }
            }
        }
    }
})(); 