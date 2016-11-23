(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_navigation_menuCtrl', user_navigation_menuCtrl);

    user_navigation_menuCtrl.$inject = ['$scope','$state','$localStorage'];

    /* @ngInject */
    function user_navigation_menuCtrl($scope, $state,$localStorage) {
        var self = this;
        $localStorage["myFriendDetail"] = [];
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
