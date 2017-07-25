angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal, $state, $timeout, $cookies, LoginService, $rootScope, SERVER, $ionicLoading, $localStorage, $ionicHistory) {
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
        var userdata = $cookies.getObject('CurrentUser');
        var currUserId = userdata.data.userId;
        var currDeviceToken = $cookies.getObject('deviceToken');        
        if (currDeviceToken != undefined) {
            deactivateUser(currUserId, currDeviceToken);
        }        
        //To clear history on logout of the app.
        //$timeout(function () {
            $localStorage.$reset();
            $ionicHistory.clearHistory();
            // clear the cache before you navigate to a page
            $ionicHistory.clearCache().then(function () {
                $state.go("app.events");
            });
            $cookies.remove('CurrentUser');
            $cookies.put("userLoggedOut", "true");
            console.log($cookies.get("userLoggedOut"));
        //}, 200);
    }

    function deactivateUser(userId,currDeviceToken) {
        LoginService.logoutDeactivateUser(userId, currDeviceToken).then(function (response) {
           $cookies.remove('CurrentUser');
       });
    }
    $scope.imgUrl = SERVER.hostName;
});









