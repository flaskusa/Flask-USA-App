(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('prePostGameCtrl', prePostGameCtrl);

    prePostGameCtrl.$inject = ['$scope', '$stateParams', '$state','EventsService', '$ionicSlideBoxDelegate', '$ionicScrollDelegate'];

    /* @ngInject */
    function prePostGameCtrl($scope, $stateParams, $state, EventsService, $ionicSlideBoxDelegate, $ionicScrollDelegate) {
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
        var PRE_EVENT = "Pre-Event";
        var AT_EVENT = "During-Event";
        var POST_EVENT = "Post-Event";
        
        getEventVenueDatail();
        getCurrentEvent();
        $ionicSlideBoxDelegate.update();
       function getCurrentEvent() {
            EventsService.getEventByEventId($scope.currEventId).then(function (respData) {
                console.log(respData.data.eventDate);
                $scope.currVenueName = respData.data.venueName;
                $scope.currEventDate = respData.data.eventDate;
				
            })
        }
		$scope.passParams=function(){
				$state.go("app.tickets", { venueName: $scope.currVenueName, eventDate: $scope.currEventDate });
		}
        $scope.preEvent = function(){
            $state.go("app.event_map_view", {eventDetails: $scope.eventDetails, infoType: PRE_EVENT, infoTypeCategory: 1 });
        }
        $scope.atEvent = function(){
            $state.go("app.event_map_view", {eventDetails: $scope.eventDetails, infoType: AT_EVENT, infoTypeCategory: 1 });
        }
        $scope.postEvent = function(){
            $state.go("app.event_map_view", {eventDetails: $scope.eventDetails, infoType: POST_EVENT, infoTypeCategory: 1 });
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
                $ionicScrollDelegate.resize()

                if ($scope.Post_Game.length ==0) {
                    $scope.Post_Game.push("No_Event");
                }
                if ($scope.During_Game.length == 0) {
                    $scope.During_Game.push("No_Event");
                }
                if ($scope.Pre_Game.length == 0) {
                    $scope.Pre_Game.push("No_Event");
                }
            });

            $scope.slidePrevious1 = function (slide) {
                $ionicSlideBoxDelegate.$getByHandle(slide).previous();
            }

            $scope.slideNext1 = function (slide) {
                $ionicSlideBoxDelegate.$getByHandle(slide).next();
            }

            $scope.getIncludeFile = function (imgName) {
                switch (imgName) {
                    case "Tradition":
                        return 'Flask_Tradition.jpg';
                    case "Parking":
                        return 'Flask_Parking.jpg';
                    case "Bar & Restaurants":
                        return 'Flask_Bars.jpg';
                    case "Traffic":
                        return 'Flask_Traffic.jpg';
                    case "Supplies":
                        return 'Flask_Supplies.jpg';
                    case "Getting Home":
                        return 'flask_GettingHome.jpg';
                    case "Nightlife":
                        return 'Flask_Nightlife.jpg';
                    case "Liquor store":
                        return 'flask_restaurantBar_post.jpg';
                    case "Venue info":
                        return 'venue_info.jpg'
                    case "Venue map":
                        return 'Venue_map.jpg'
                    case "Flask Us":
                        return 'Flask_FlaskUs.jpg'
                    default:
                        return 'Flask_Default_Image.jpg';
                }
            }
        }
    }
})(); 