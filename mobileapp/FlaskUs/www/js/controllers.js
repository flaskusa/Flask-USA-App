angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal, $timeout, $cookies, LoginService) {

    //controller for splash screen
    $scope.$on('$ionicView.afterEnter', function () {
        setTimeout(function () {
            document.getElementById("custom-overlay").style.display = "none";
        }, 1000);
    })

    var UserCookie = $cookies.get('CurrentUser');
    if (UserCookie == undefined) {
        $scope.userName = "Guest";
        $scope.userEmailId = "Guest";  
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

.controller('loginCtrl', function ($scope, $state) {
})
.controller('ticketsCtrl', function ($scope, $state) {
})

    .directive('searchBar', [function () {
        return {
            scope: {
                ngModel: '='
            },
            require: ['^ionNavBar', '?ngModel'],
            restrict: 'E',
            replace: true,
            template: '<ion-nav-buttons side="right">' +
                            '<div class="searchBar">' +
                                '<div class="searchTxt" ng-show="ngModel.show">' +
                                    '<div class="bgdiv"></div>' +
                                    '<div class="bgtxt">' +
                                        '<input type="text" placeholder="Enter your search item..." ng-model="ngModel.txt">' +
                                    '</div>' +
                                '</div>' +
                                '<i class="icon placeholder-icon" ng-click="ngModel.txt=\'\';ngModel.show=!ngModel.show"></i>' +
                            '</div>' +
                        '</ion-nav-buttons>',

            compile: function (element, attrs) {
                var icon = attrs.icon
                        || (ionic.Platform.isAndroid() && 'ion-android-search')
                        || (ionic.Platform.isIOS() && 'ion-ios7-search')
                        || 'ion-search';
                angular.element(element[0].querySelector('.icon')).addClass(icon);

                return function ($scope, $element, $attrs, ctrls) {
                    var navBarCtrl = ctrls[0];
                    $scope.navElement = $attrs.side === 'right' ? navBarCtrl.rightButtonsElement : navBarCtrl.leftButtonsElement;

                };
            }
        }
    }]);









