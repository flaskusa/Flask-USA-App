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
        $scope.user={Email:"",password:"",isChecked:true}
        $scope.rememberUser=true;
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
        $scope.goBack=function(){
            $state.go("app.events");
        }
       
        $scope.doLogin = function (user) {
            if(SERVER.companyId!=undefined) {
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
                        if (respData.data.portraitId > 0) {
                            $scope.getUserProfile(respData.data.userId);
                        } else {
                            $rootScope.userProfileUrl = '';
                        }
                        if ($scope.rememberUser == true) {
                            $localStorage['RememberUser'] = "";
                            $localStorage['RememberUser'] = user;
                        }
                        $http.get(SERVER.url + '/flask-rest-users-portlet.flaskadmin/is-add-content-access', { params: { 'userId': respData.data.userId}}
                        )
                            .then(function success(response2) {
                                respData.data.isContentAdmin = response2.data;
                                $cookies.putObject('CurrentUser', respData);
                                $rootScope.userName = respData.data.firstName + respData.data.lastName;
                                $rootScope.userEmailId = respData.data.emailAddress;
                                $rootScope.show_login = true;
                                document.login_form.reset();
                                $scope.usercookie = $cookies.getObject('CurrentUser');
                                $scope.addDeviceDetails($scope.usercookie);
                                $state.go("app.user_navigation_menu");
                            }, function failure(response) {
                                return $q.$inject(response);
                                //add errror handling
                            });
                    }
                });
            }else{
                getCompanyId(user);
            }
        }
        
        $scope.addDeviceDetails = function (userdata) {
            var currDeviceToken = $cookies.getObject('deviceToken');
            LoginService.registerDeviceFuntion(userdata.data.userId, userdata.data.emailAddress, $scope.deviceDetails.platform, $scope.deviceDetails.model, $scope.deviceDetails.uuid, $scope.regiDate, true, $scope.regiDate,'').then(function (response) {
                console.log("response" + response);
            });
        }

        function getCompanyId(user) {
            LoginService.registerDeviceFuntion().then(function (response) {
                SERVER.companyId = response.data;
                $scope.doLogin(user);
            });
        }


        if($localStorage['RememberUser'] &&  $localStorage['RememberUser'].Email &&  $localStorage['RememberUser'].password){
            $scope.user=$localStorage['RememberUser'];
        }
        $scope.getUserProfile = function(userId) {
            UserService.getUserProfile(userId).then(function(res) {
                if(res.data.fileEntryId != undefined) {

                    $rootScope.userProfileUrl = $scope.profileUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                }else {
                    $rootScope.userProfileUrl="";
                }
            },function(err) {

            })
        }


        $scope.remembered = function (user) {
            if (user.isChecked) {
                if(user && !user.Email=="" && !user.password==""){

                    $scope.rememberUser=true;
                }
                else {
                    $scope.rememberUser=false;
                    $scope.user.isChecked=false;
                    $ionicLoading.show({ template: 'Email and password should not be empty!', noBackdrop: false, duration: 2000 });
                }
            }else{
                $scope.rememberUser=false;
                $localStorage['RememberUser']="";
            }
        }
    
    };
})();

