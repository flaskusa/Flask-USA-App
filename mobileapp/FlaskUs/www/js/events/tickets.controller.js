(function () {
    'use strict';
    angular.module('flaskApp')
            .controller('ticketsCtrl', ticketsCtrl);

    ticketsCtrl.$inject = ['$scope', '$stateParams', '$state', 'EventsService', 'SERVER'];

    /* @ngInject */
    function ticketsCtrl($scope, $stateParams, $state, EventsService, SERVER) {
        var self = this;
        $scope.Details = [];
        $scope.currVenueName = $stateParams.venueName;
        $scope.currEventDate = $stateParams.eventDate;
        //$scope.currEventName = $stateParams.eventName;
      
        //onClickTicket(ticketSite);

        function checkApp(scheme,siteName) {
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
            $scope.siteId = ticketSite - 1;
            $scope.ticketSiteName = [{ id: 1, site: 'stubhub' }, { id: 2, site: 'tickpick' }, { id: 3, site: 'seetgeek' }, { id: 4, site: 'scorebig' }, { id: 5, site: 'ticketsnow' }, { id: 6, site: 'ticketmaster' }];


            var scheme;
            // Don't forget to add the org.apache.cordova.device plugin!
            if (device.platform === 'iOS') {
                scheme = 'http://' + $scope.ticketSiteName[$scope.siteId].site;
            }
            else if (device.platform === 'Android') {
                scheme = 'www.' + $scope.ticketSiteName[$scope.siteId].site + '.com';
            }
            
         
            switch (ticketSite) {
                case $scope.ticketSiteName[0].id:
                    $scope.siteName = 'http://stubhub.com/find/s/?q=' + $scope.currVenueName;
                    checkApp(scheme, $scope.siteName);
                    break;
                case $scope.ticketSiteName[1].id:
                    $scope.siteName = 'http://tickpick.com/search/' + $scope.currVenueName;
                    checkApp(scheme, $scope.siteName);
                    break;
                case $scope.ticketSiteName[2].id:
                    $scope.siteName = 'http://seetgeek.com/search?search=' + $scope.currVenueName;
                    checkApp(scheme, $scope.siteName);
                    break;
                case $scope.ticketSiteName[3].id:
                    $scope.siteName = 'http://scorebig.com/'+ $scope.currVenueName+'-tickets?int_src=search&Sch=' + $scope.currVenueName;
                    checkApp(scheme, $scope.siteName);
                    break;
                case $scope.ticketSiteName[4].id:
                    $scope.siteName = 'http://ticketsnow.com/InventoryBrowse/-Tickets-at-'+$scope.currVenueName+'-in-Detroit-' + $scope.currVenueName;
                    checkApp(scheme, $scope.siteName);
                    break;
                case $scope.ticketSiteName[5].id:
                    $scope.siteName = 'http://ticketmaster.com/search?tm_link=tm_homeA_header_search&user_input='+ $scope.currVenueName+'&q=' + $scope.currVenueName;
                    checkApp(scheme, $scope.siteName);
                    break;
            }
        }

    }
})();

