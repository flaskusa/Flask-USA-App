angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal, $timeout, $cookies, LoginService) {

    //controller for splash screen
    $scope.$on('$ionicView.afterEnter', function () {
        setTimeout(function () {
            document.getElementById("custom-overlay").style.display = "none";
        }, 1000);
    })

    $scope.doLogout = function () {
        var usercookie = $cookies.get('CurrentUser');
        console.log(usercookie);
        $cookies.remove('CurrentUser');
        console.log(usercookie);
    }
})

.controller('user_navigation_menuCtrl', function ($scope) {
})

.controller('my_eventsCtrl', function ($scope) {
})

.controller('my_tailgateCtrl', function ($scope) {
})

.controller('my_friendsCtrl', function ($scope) {
})

.controller('friend_detailsCtrl', function ($scope) {
})

.controller('ticketsCtrl', function ($scope, $state) {
});








