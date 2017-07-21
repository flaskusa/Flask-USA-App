angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal, $state, $timeout, $cookies, LoginService, $rootScope, SERVER, $ionicLoading,$localStorage) {
    //controller for splash screen
 /*   $scope.$on('$ionicView.afterEnter', function () {
    })
    */

    $scope.doLogout = function () {
        $rootScope.show_login = false;
        $rootScope.totalMessageNotification = 0;
        $rootScope.totalRequestNotification = 0;        
        $rootScope.userName ='';
        $rootScope.userEmailId ='';
        $rootScope.userProfileUrl='';
        //console.log($cookies.getObject('CurrentUser'));
        var userdata = $cookies.getObject('CurrentUser');
        var currUserId = userdata.data.userId;
        var currDeviceToken = $cookies.getObject('deviceToken');
        $state.go("app.events");
        deactivateUser(currUserId,currDeviceToken);
    }

    function deactivateUser(userId,currDeviceToken) {
        LoginService.logoutDeactivateUser(userId, currDeviceToken).then(function (response) {
           //console.log("response" + response);
           $cookies.remove('CurrentUser');
       });
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









