angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal, $state, $timeout, $cookies, LoginService, $rootScope, SERVER, $ionicLoading) {
    //controller for splash screen
 /*   $scope.$on('$ionicView.afterEnter', function () {
    })
    */
    $scope.doLogout = function () {
        $rootScope.show_login = false;       
        $cookies.remove('CurrentUser');
        $rootScope.userName ='';
        $rootScope.userEmailId ='';
        console.log($cookies.getObject('CurrentUser'));
        $state.go("app.events");
        $timeout(function(){
            SERVER.url = "http://www.flaskus.com/api/jsonws/";
            SERVER.hostName = "http://www.flaskus.com/";
        },2000) 
        
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
    $scope.scorebig = function () {
        var ref = window.open('http://scorebig.org', '_system', 'location=yes');
    }

    $scope.ticketsnow = function () {
        var ref = window.open('http://ticketsnow.org', '_system', 'location=yes');
    }
});









