(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('addMyTailgateCtrl', addMyTailgateCtrl);

    addMyTailgateCtrl.$inject = ['$scope', '$state', '$ionicSlideBoxDelegate'];

    /* @ngInject */
    function addMyTailgateCtrl($scope, $state, $ionicSlideBoxDelegate) {
        $scope.myActiveSlide = 0;

        $scope.backToPrev = function () {
            $state.go('app.addMyTailgate');
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

