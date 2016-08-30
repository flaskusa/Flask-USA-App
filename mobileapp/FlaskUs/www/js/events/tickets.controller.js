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
        console.log($stateParams);
        console.log($scope.imgUrl);
        //onClickTicket(ticketSite);

        $scope.onClickTicket=function(ticketSite) {
            var scheme;
            // Don't forget to add the org.apache.cordova.device plugin!
            if (device.platform === 'iOS') {
                scheme = ticketSite;
            }
            else if (device.platform === 'Android') {
                scheme = 'www.' + ticketSite + '.com';
            }
            switch (ticketSite) {
                case "stubhub":
                    $scope.siteName = 'http://stubhub.com/find/s/?q='+$scope.currVenueName;
                    return $scope.siteName;
                case "tickpick":
                    $scope.siteName = 'http://tickpick.com/search/{{currVenueName}}';
                    return $scope.siteName;
                case "seetgeek":
                    $scope.siteName = 'http://seetgeek.com/search?search={{currVenueName}}';
                    return $scope.siteName;
                case "scorebig":
                    $scope.siteName = 'http://scorebig.com/{{currVenueName}}-tickets?int_src=search&Sch={{currVenueName}}';
                    return $scope.siteName;
                case "ticketsnow":
                    $scope.siteName = 'http://ticketsnow.com/InventoryBrowse/-Tickets-at-{{currVenueName}}-in-Detroit-{{currEventDate}}';
                    return $scope.siteName;
                case "ticketmaster":
                    $scope.siteName = 'http://ticketmaster.com/search?tm_link=tm_homeA_header_search&user_input={{currVenueName}}&q={{currVenueName}}';
                    return $scope.siteName;
            }

            


            appAvailability.check(
                scheme, // URI Scheme
                function () {  // Success callback
                    window.open($scope.siteName, '_system', 'location=no');
                    //$scope.twitterlink = 'Application is available';
                },
                function () {  // Error callback
                    window.open($scope.siteName, '_system', 'location=no');
                    //$scope.twitterlink = 'Application is not available';
                }
            );
        }

    }
})();

