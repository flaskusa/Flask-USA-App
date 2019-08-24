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

        //$scope.currEventName = $stateParams.eventName;

         $scope.eventData = $stateParams.eventDetails.Details;



        //onClickTicket(ticketSite);
        getTicketDetails();

        function getTicketDetails() {
                for (var i = 0; i < $scope.eventData.length; i++) {
                     var detailObject = angular.fromJson($scope.eventData[i].Detail);

                    if ("Tickets" == detailObject.infoTypeCategoryName) {
                        if(detailObject.infoShortDesc ==""){
                            detailObject.infoShortDesc = detailObject.website;
                        }
                        $scope.ticket_detail.push({ siteName: detailObject.infoTitle, siteBaseUrl: detailObject.infoShortDesc, eventUrl: detailObject.website })
                    }
                }
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

            if(ticketSite.indexOf("http://") == -1 && ticketSite.indexOf("https://") == -1){
                ticketSite = "http://" +   ticketSite; 
            }
            window.open(ticketSite, '_system', 'location=no');
            //checkApp(scheme, $scope.siteName);
        }

    }
})();

