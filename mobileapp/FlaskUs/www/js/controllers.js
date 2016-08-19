angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal,$state, $timeout, $cookies, LoginService, $rootScope, SERVER) {

    //controller for splash screen
    $scope.$on('$ionicView.afterEnter', function () {
        setTimeout(function () {
            document.getElementById("custom-overlay").style.display = "none";
        }, 1000);
    })
    $scope.doLogout = function () {
        $rootScope.show_login = false;       
        $cookies.remove('CurrentUser');
        $rootScope.userName ='';
        $rootScope.userEmailId ='';
        console.log($cookies.getObject('CurrentUser'));
        $state.go("app.events");
    }
    $scope.imgUrl = SERVER.hostName;

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









