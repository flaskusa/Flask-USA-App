(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_eventsCtrl', my_eventsCtrl);

    my_eventsCtrl.$inject = ['$scope', 'myEventService', '$state', '$cookies', '$timeout','SERVER','$ionicPopup','$filter'];

    /* @ngInject */
    function my_eventsCtrl($scope, myEventService, $state, $cookies, $timeout, SERVER,$ionicPopup,$filter) {
        var self = this;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.myEvent = [];
        $scope.tempMyEvent = [];
        var userResponse = $cookies.get('CurrentUser');
        //var UserId = userResponse.data.userId;
        //console.log(UserId);
        $scope.searchBox = { showBox: false };
        getAllevents();

        function getAllevents() {
            myEventService.getMyEvents().then(function (respData) {
                $scope.myEvent = respData.data.Events;
                $scope.tempMyEvent = respData.data.Events;
                if (respData.data.message == "Authenticated access required" )
                {
                    $scope.myEventError = true;
                } else
                    if ($scope.myEvent.length==0) {
                    $scope.myNoEventError = true;
                }                
            });
        }

        $scope.removeEvent = function(eventId ,index) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Event?'
            });
            confirmPopup.then(function(res) {
                if(res) {
                    myEventService.removeUserEvent(eventId).then(function (respData) {
                        $scope.myEvent.splice(index, 1);
                        if ($scope.myEvent.length==0) {
                            $scope.myNoEventError = true;
                        }
                    });
                }
            });

        }

        $scope.getVenueNameForVenueId  = function (venueId) {
            var venueCity = ""
            var venues = $cookies.getObject("eventVenues");
            if (venues == undefined) {
                return "";
            }
            for (var i = 0; i < venues.length; i++) {
                if( venues[i].venueId == venueId){
                    venueCity = venues[i].venueCity;
                    return venueCity;
                }
            }
            return venueCity;
        }

        $scope.searchMyEvents = function(searchText){
            if(searchText!=""){
                $scope.myEvent = $filter('filter')($scope.tempMyEvent, { eventName: searchText });
            }else{
                $scope.myEvent=$scope.tempMyEvent;
            }            
            $scope.searchBox={showBox:false};
        }
       

    }
})();

