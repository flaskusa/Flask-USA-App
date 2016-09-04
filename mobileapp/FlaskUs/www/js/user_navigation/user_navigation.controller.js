(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_navigation_menuCtrl', user_navigation_menuCtrl);

    user_navigation_menuCtrl.$inject = ['$scope','$state'];

    /* @ngInject */
    function user_navigation_menuCtrl($scope, $state) {
        var self = this;
        $scope.myEvent = function ()
        {
            $state.go("app.my_events"); 
        }

        $scope.myTailgate = function ()
        {
            $state.go("app.my_tailgate");
        }

        $scope.myFriend = function ()
        {
            $state.go("app.my_friends_tab");
        }
    }
})();
