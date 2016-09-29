(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('AdvertisementCtrl', AdvertisementCtrl);

    AdvertisementCtrl.$inject = ['$scope', '$stateParams', '$state', 'EventsService', 'SERVER','$ionicPopup','$timeout'];
    function AdvertisementCtrl($scope, $stateParams, $state, EventsService, SERVER,$ionicPopup,$timeout) {

        $scope.showPopup = function() {
            $scope.data = {};

            // An elaborate, custom popup
            $scope.myPopup = $ionicPopup.show({
                cssClass: 'custom-class custom-popup',
                templateUrl: 'templates/advertisementPopup.html',
                scope: $scope


            });
            $scope.popupClose=function(){
                $scope.myPopup.close();
            }


            /*$timeout(function() {
                myPopup.close(); //close the popup after 3 seconds for some reason
            }, 5000);*/
        };

    }
})();