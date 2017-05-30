(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout', '$rootScope', '$cookies', '$ionicLoading', '$ionicPlatform', '$cordovaTouchID','SERVER','$localStorage','$http','UserService','$ionicHistory'];
    
    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout, $rootScope, $cookies, $ionicLoading, $ionicPlatform, $cordovaTouchID,SERVER,$localStorage,$http,UserService,$ionicHistory) {
        /* jshint validthis: true */
        var self = this;
        $scope.Email = '';
        $scope.password = '';
        $scope.user={Email:"",password:"",isChecked:true}
        $scope.rememberUser=true;
        $scope.profileUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
     
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
                                var usercookie = $cookies.getObject('CurrentUser');
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
            }else{
                getCompanyId(user);
            }
        }
        function getCompanyId(user) {
            $http.get(SERVER.url + '/flask-rest-users-portlet.flaskadmin/get-company-id'
            )
                .then(function success(response) {
                    SERVER.companyId = response.data;
                    $scope.doLogin(user)
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
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

