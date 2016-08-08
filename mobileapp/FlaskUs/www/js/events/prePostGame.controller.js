(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('prePostGameCtrl', prePostGameCtrl);

    prePostGameCtrl.$inject = ['$scope', '$stateParams', 'EventsService', '$ionicSlideBoxDelegate', '$ionicScrollDelegate'];

    /* @ngInject */
    function prePostGameCtrl($scope, $stateParams, EventsService, $ionicSlideBoxDelegate, $ionicScrollDelegate) {
        /* jshint validthis: true */
        var self = this;
        $scope.eventInfo = [];
        $scope.Details = [];
        $scope.INFO_TYPE = [];
        $scope.INFO_TYPE_CATEGORY = [];
        $scope.Pre_Game = [];
        $scope.Post_Game = [];
        $scope.During_Game = [];
        $scope.currEventName = $stateParams.eventName;
        $scope.currEventId = $stateParams.eventId;
        var currEventId = $scope.currEventId;
        getAllVenuImages();
        $ionicSlideBoxDelegate.update();
        function getAllVenuImages() {
            EventsService.getVenueImages(currEventId).then(function (respData) {
                var len = respData.data.Details.length - 1;
                for (var i = 0; i <= len; i++) {                    
                    $scope.Details.push(angular.fromJson(respData.data.Details[i].Detail))
                    if ($scope.INFO_TYPE.indexOf($scope.Details[i].infoTypeName) == -1) {
                        $scope.INFO_TYPE.push($scope.Details[i].infoTypeName)
                    }
                }
                for (var i = 0; i <= len; i++) {
                    if ($scope.Details[i].infoTypeName == "Pre-Event") {
                        if ($scope.Pre_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                            $scope.Pre_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    }else
                        if ($scope.Details[i].infoTypeName == "During-Event") {
                            if ($scope.During_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.During_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    } else {
                            if ($scope.Post_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.Post_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    }                    
                }
                console.log($scope.Pre_Game);
                console.log($scope.Post_Game);
                console.log($scope.During_Game);
                $ionicSlideBoxDelegate.update();
                $ionicScrollDelegate.resize()
            });

            $scope.getIncludeFile = function (imgName) {
                switch (imgName) {
                    case "Tradition":
                        return 'Flask_Tradition.jpg';
                        break;
                    case "Parking":
                        return 'Flask_Parking.jpg';
                        break;
                    case "Bar & Restaurants":
                        return 'Flask_Bars.jpg';
                        break;
                    case "Traffic":
                        return 'Flask_Traffic.jpg';
                        break;
                    case "Supplies":
                        return 'Flask_Supplies.jpg';
                        break;
                    case "Getting Home":
                        return 'flask_GettingHome.jpg';
                        break;
                    case "Nightlife":
                        return 'Flask_Nightlife.jpg';
                        break;
                    case "Liquor store":
                        return 'flask_restaurantBar_post.jpg';
                        break;
                    case "Venue info":
                        return 'venue_info.jpg'
                        break;
                    case "Venue map":
                        return 'Venue_map.jpg'
                        break;
                    case "Flask Us":
                        return 'Flask_FlaskUs.jpg'
                        break;
                    default:
                        return 'Flask_Default_Image.jpg';
                }
            }
        }
    }
})(); 