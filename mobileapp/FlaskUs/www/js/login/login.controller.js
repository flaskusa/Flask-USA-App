(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$filter', '$timeout', '$rootScope', '$cookies', '$ionicLoading', '$ionicPlatform', '$cordovaTouchID', 'SERVER', '$localStorage', '$http', 'UserService', '$ionicHistory', '$q'];

    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $filter, $timeout, $rootScope, $cookies, $ionicLoading, $ionicPlatform, $cordovaTouchID, SERVER, $localStorage, $http, UserService, $ionicHistory, $q) {
        /* jshint validthis: true */
        var self = this;
        $scope.Email = '';
        $scope.password = '';
        $scope.user = { Email: "", password: "", isChecked: true }
        $scope.rememberUser = true;
        $scope.profileUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.deviceDetails = ionic.Platform.device();
        var currentDate = new Date();/*Today's Date*/
        $scope.regiDate = $filter('date')(new Date(), 'yyyy-MM-dd hh:mm:ss');
        $scope.checkTouch = function (enableChecked) {
            if (enableChecked) {
                $cordovaTouchID.checkSupport().then(function () {
                    $cordovaTouchID.authenticate("You must authenticate").then(function () {
                        alert("The authentication was successful");
                    }, function (error) {
                        console.log(JSON.stringify(error));
                    });
                }, function (error) {
                    console.log(JSON.stringify(error));
                });
            }
        }
        $scope.goBack = function () {
            $state.go("app.events");
        }

        $scope.doLogin = function (user) {
            if (SERVER.companyId != undefined) {
                LoginService.authenticateUser(user).then(function (respData) {
                    if (respData.data.message == "Authenticated access required") {
                        $scope.Error = true;
                        $timeout(function () {
                            $scope.Error = false;
                        }, 3000);
                    }
                    else if (respData.data.emailAddress == "") {
                    }
                    else {
                        var deveiceRegToken = $cookies.getObject('deviceToken');
                        var stopWhileLoop = false;
                        setTimeout(function () { stopWhileLoop = true; }, 15000);
                        $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
                        var interval = setInterval(function () {
                            if (deveiceRegToken != undefined)
                                stopWhileLoop = true;
                            if (stopWhileLoop == true) {
                                clearInterval(interval);
                                $ionicLoading.hide();
                                if (deveiceRegToken == undefined) {
                                    var userAlert = $ionicPopup.alert({
                                        title: "Flask Alert",
                                        template: "Device Registration for app notification Failed, Please try logout and login after some time to recieve app notification."
                                    }).then(function (res) {
                                        GoForLogin(respData, deveiceRegToken, user);
                                    });
                                } else {
                                    GoForLogin(respData, deveiceRegToken, user);
                                }
                            }
                        }, 30)

                    }
                });
            } else {
                getCompanyId(user);
            }
        }

        function GoForLogin(respData, deveiceRegToken, user) {
            LoginService.registerDeviceFuntion(respData.data.userId, respData.data.emailAddress, $scope.deviceDetails.platform,
                $scope.deviceDetails.model, deveiceRegToken, $scope.regiDate, true, $scope.regiDate, '').then(function (response) {
                    if (response) {
                        if (respData.data.portraitId > 0) {
                            $scope.getUserProfile(respData.data.userId);
                        } else {
                            $rootScope.userProfileUrl = '';
                        }
                        if ($scope.rememberUser == true) {
                            $localStorage['RememberUser'] = "";
                            $localStorage['RememberUser'] = user;
                        }
                        $http.get(SERVER.url + '/flask-rest-users-portlet.flaskadmin/is-add-content-access', { params: { 'userId': respData.data.userId } }
                        ).then(function success(response2) {
                            respData.data.isContentAdmin = response2.data;
                            $cookies.putObject('CurrentUser', respData);
                            $rootScope.userName = respData.data.firstName + respData.data.lastName;
                            $rootScope.userEmailId = respData.data.emailAddress;
                            $rootScope.show_login = true;
                            document.login_form.reset();
                            $state.go("app.user_navigation_menu");
                        }, function failure(response) {
                            return $q.$inject(response);
                            //add errror handling
                        });
                    }
                });
        }

        function getCompanyId(user) {
            LoginService.getCompanyIdFunction().then(function (response) {
                SERVER.companyId = response;
                $scope.doLogin(user);
            });
        }


        if ($localStorage['RememberUser'] && $localStorage['RememberUser'].Email && $localStorage['RememberUser'].password) {
            $scope.user = $localStorage['RememberUser'];
        }
        $scope.getUserProfile = function (userId) {
            UserService.getUserProfile(userId).then(function (res) {
                if (res.data.fileEntryId != undefined) {

                    $rootScope.userProfileUrl = $scope.profileUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                } else {
                    $rootScope.userProfileUrl = "";
                }
            }, function (err) {

            })
        }


        $scope.remembered = function (user) {
            if (user.isChecked) {
                if (user && !user.Email == "" && !user.password == "") {

                    $scope.rememberUser = true;
                }
                else {
                    $scope.rememberUser = false;
                    $scope.user.isChecked = false;
                    $ionicLoading.show({ template: 'Email and password should not be empty!', noBackdrop: false, duration: 2000 });
                }
            } else {
                $scope.rememberUser = false;
                $localStorage['RememberUser'] = "";
            }
        }

    };
})();

