(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('addMyEventCtrl', addMyEventCtrl);

    addMyEventCtrl.$inject = ['$scope', '$state', '$ionicSlideBoxDelegate'];

    /* @ngInject */
    function addMyEventCtrl($scope, $state, $ionicSlideBoxDelegate) {
        $scope.myActiveSlide = 0;

        $scope.backToPrev = function () {
            $state.go('app.addMyEvent');
        }
        $scope.next = function () {
            $ionicSlideBoxDelegate.next();
        };
        $scope.previous = function () {
            $ionicSlideBoxDelegate.previous();
        };

        // Called each time the slide changes
        $scope.slideChanged = function (index) {
            $scope.slideIndex = index;
        };
    }
})();

