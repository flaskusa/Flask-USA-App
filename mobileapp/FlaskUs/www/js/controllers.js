angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal, $timeout, $cookies, LoginService, $rootScope, REST_API) {

    //controller for splash screen
    $scope.$on('$ionicView.afterEnter', function () {
        setTimeout(function () {
            document.getElementById("custom-overlay").style.display = "none";
        }, 1000);
    })

    $scope.doLogout = function () {
        window.location.reload();
    }
    $scope.imgUrl = REST_API.hostName;

})



.controller('my_tailgateCtrl', function ($scope) {
})

.controller('account_settingsCtrl', function ($scope) {
})


.controller('my_friendsCtrl', function ($scope) {
})

.controller('friend_detailsCtrl', function ($scope) {
})

.controller('ticketsCtrl', function ($scope, $state) {
});









