(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('ticketsCtrl', ticketsCtrl);

    ticketsCtrl.$inject = ['$scope', '$stateParams', '$state', 'EventsService'];

    /* @ngInject */
    function ticketsCtrl($scope, $stateParams, $state, EventsService) {
        var self = this;
        $scope.ticket_detail = [];
        $scope.Details = [];
        $scope.currVenueName = $stateParams.venueName;
        $scope.currEventDate = $stateParams.eventDate;
        var currVenueId = $stateParams.venueId;
        //$scope.currEventName = $stateParams.eventName;

        //onClickTicket(ticketSite);
        getVenue_Details();

        function getVenue_Details() {
            EventsService.getVenueDetails(currVenueId).then(function (respData) {
                $scope.venue_detail = respData;
                for (var i = 0; i < $scope.venue_detail.length; i++) {
                    $scope.ticket_detail.push({ site: $scope.venue_detail[i].infoTitle, url: $scope.venue_detail[i].website })
                }
                console.log($scope.ticket_detail);
            })
        }

        //onClickTicket(ticketSite);

        function checkApp(scheme, siteName) {
            appAvailability.check(
                        scheme, // URI Scheme
                        function () {  // Success callback
                            window.open(siteName, '_system', 'location=no');
                            //if Application is available;
                        },
                        function () {  // Error callback
                            window.open(siteName, '_system', 'location=no');
                            //if Application is not available;
                        }
                    );
        }

        $scope.onClickTicket = function (ticketSite) {
            // Don't forget to add the org.apache.cordova.device plugin
            window.open('http://' + ticketSite, '_system', 'location=no');
            //checkApp(scheme, $scope.siteName);
        }

    }
})();

