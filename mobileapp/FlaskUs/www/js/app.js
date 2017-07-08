(function () {
    var app = angular.module('flaskApp'); 
    app.run(function ($ionicPlatform, $rootScope, $ionicLoading, $ionicPopup, $cookies, $localStorage, $state, LoginService, $http, SERVER, UserService, $cordovaPush, $cordovaAppVersion, $timeout) {
        $ionicPlatform.ready(function () {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            //  if (cordova.platformId === 'ios' && window.cordova && window.cordova.plugins.Keyboard) {
            //      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
            //      cordova.plugins.Keyboard.disableScroll(true);
            //For Push Notification
            var currentPlatform = ionic.Platform.platform();
            console.log(currentPlatform);
            var sendInfoData = {};
            var push = PushNotification.init({
                "android": {
                    "senderID": "843562154399",
                    "alert":"true",
                    "sound": "true",
                    "badge": "true",
                    "vibrate": "true",
                    "forceShow": "true"
                },
                browser: {
                    pushServiceURL: 'http://push.api.phonegap.com/v1/push'
                },
                "ios": {
                    "alert": "true",
                    "badge": "true",
                    "sound": "true",
                    "vibrate": "true",
                    "forceShow": "true",
                },
                windows: {}
            });

            push.on('registration', function (data) {
                $cookies.putObject('deviceToken', data.registrationId);
            });

            push.on('notification', function (data) {
                $cookies.remove('popupData');
                console.log(data);
                console.log(data.additionalData.infoData);
                sendInfoData = {
                    'infoType':data.additionalData.infoType,
                    'infoData': data.additionalData.infoData,
                    'coldstart':data.additionalData.coldstart,
                    'activeUsingPopup':true
                }
                var userdata = $cookies.getObject('CurrentUser');
                var currUserId = userdata.data.userId;
                $cookies.putObject('infoType', sendInfoData.infoType);

                if (currentPlatform == "ios" && data.additionalData.foreground == true) {
                    showConfirm(data);
                } else if (sendInfoData.coldstart == true) {
                    $cookies.putObject('coldstart', sendInfoData.coldstart);
                } else if (sendInfoData.coldstart != true) {
                    goToInfotype();
                }
            });

            // A confirm dialog for ios
            function showConfirm(data) {
                var confirmPopup = $ionicPopup.confirm({
                    title: data.title,
                    template: data.message
                });
                confirmPopup.then(function (res) {
                    if (res) {
                        goToInfotype();
                    } else {
                        console.log('You are not sure');
                    }
                });
            };

            push.setApplicationIconBadgeNumber(function () {
                console.log('success');
            }, function () {
                console.log('error');
            });

            push.finish(function () {
                console.log('success');
            }, function () {
                console.log('error');
            }, 'push-1');

            push.on('error', function (e) {
                // e.message
            });
            //End of Push Notification
            //for getting App verion
            $cordovaAppVersion.getVersionNumber().then(function (version) {
                $rootScope.appVersion = version;
            });
            $cordovaAppVersion.getVersionCode().then(function (build) {
                $rootScope.appBuild = build;
            });
            //End of App version

            var profileUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
            
            $localStorage.$default({things:{}});
            //  }
            if (window.StatusBar) {
                // org.apache.cordova.statusbar required
                 StatusBar.styleBlackTranslucent();
                 StatusBar.styleLightContent();
            }
            $http.get(SERVER.url+'/flask-rest-users-portlet.flaskadmin/get-company-id'
            )
                .then(function success(response) {
                    SERVER.companyId= response.data;
                    rememberedUserLogin();
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
            function rememberedUserLogin(){
                if ($localStorage['RememberUser'] && $localStorage['RememberUser'].Email && $localStorage['RememberUser'].password) {
                    var user = $localStorage['RememberUser'];
                    LoginService.authenticateUser(user).then(function (respData) {
                        if (respData.data.message == "Authenticated access required") {
                            return;
                        }
                        else if (respData.data.emailAddress == "") {
                        }
                        else {
                            if(respData.data.portraitId>0) {
                               getUserProfile(respData.data.userId);
                            }else{
                                $rootScope.userProfileUrl='';
                            }
                            $http.get(SERVER.url+'/flask-rest-users-portlet.flaskadmin/is-add-content-access', { params:{ 'userId': respData.data.userId}}
                            )
                                .then(function success(response2) {
                                    respData.data.isContentAdmin= response2.data;
                                    $cookies.putObject('CurrentUser', respData);
                                    var usercookie = $cookies.getObject('CurrentUser');
                                    $rootScope.userName = respData.data.firstName + respData.data.lastName;
                                    $rootScope.userEmailId = respData.data.emailAddress;
                                    $rootScope.show_login = true;
                                    $state.go("app.user_navigation_menu");
                                    var isColdStart =  $cookies.getObject('coldstart');
                                    if (sendInfoData.coldstart == true) {
										setTimeout(function(){
                                            goToInfotype(),
                                            sendInfoData.coldstart == false;
											$cookies.putObject('coldstart',false);
                                        },2000);
                                    }
                                }, function failure(response) {
                                    return $q.$inject(response);
                                    //add errror handling
                                });
                        }
                    });
                }
            }

            function goToInfotype() {
                var currinfotype = $cookies.getObject('infoType');
                if(currinfotype == undefined){
                             currinfotype=sendInfoData.infoType;
                }
                switch (currinfotype) {
                     case "Friend_Message":
                        sendInfoData.user = 'user';
                        $cookies.putObject('popupData', sendInfoData);
                        setTimeout(
                            $state.go('app.messages'),
                        1000);
                        $cookies.remove('infoType');
                    break;
                    case "Group_Message":
                        sendInfoData.user = 'group';
                        $cookies.putObject('popupData', sendInfoData);
                        setTimeout(
                            $state.go('app.messages'),
                        1000);
                        $cookies.remove('infoType');
                    break;
                    case "Tailgate_invitation":
                        setTimeout(
                            $state.go("app.my_tailgateDetails.my_tailgate_event_details", { 'tailgateId': sendInfoData.infoData.tailgateId }),
                        1000);
                        $cookies.remove('infoType');
                    break;
                    case "Friend_Request":
                        setTimeout(
                            $state.go("app.notifications"),
                        1000);
                        $cookies.remove('infoType');
                        break;
                    case "Tailgate_Message":
                        setTimeout(
                            $state.go("app.my_tailgateDetails.my_tailgate_event_details", { 'tailgateId': sendInfoData.infoData.tailgateId }),
                        1000);
                        $cookies.remove('infoType');
                    }
            }

            function getUserProfile(userId) {
                UserService.getUserProfile(userId).then(function(res) {
                    if(res.data.fileEntryId != undefined) {

                        $rootScope.userProfileUrl = profileUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    }else {
                        $rootScope.userProfileUrl='';
                    }
                },function(err) {

                })
            }
                $rootScope.$on('loading:show', function () {
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' })
            })

            $rootScope.$on('loading:hide', function () {
                $ionicLoading.hide()
            })
             $rootScope.$on('catchAll:exception', function (event, data) { 
                 $ionicLoading.hide()
                 // if exception occurs the  redirect ro events page
                $state.go("app.events");
            })

            //user_location_data.push({ code: "stored" });
            // Gelocation On ionic ready
            var geooobj={"latitude":"","longitude":"","timestamp":""};
            navigator.geolocation.getCurrentPosition(
                function (position) {
                    //when Success
                    // save it

                    geooobj.latitude=position.coords.latitude;
                    geooobj.longitude=position.coords.longitude;
                    geooobj.timestamp=position.timestamp;
                    $localStorage["things"]=geooobj;
                    $rootScope.$broadcast("LocationOptionSelected");
                },
                function errorCallback(error) {
                    //when Error
                    $localStorage["things"]=geooobj;
                    $rootScope.$broadcast("LocationOptionSelected");
                    //$cookies.putObject('user_location_data', error);
                }
            );
            // Check for network connection
            if (window.Connection) {
                if (navigator.connection.type == Connection.NONE) {
                    $ionicPopup.alert({
                        title: 'No Internet Connection',
                        content: 'There is no internet connection. Only some part of aplication will work'
                    });
                }
            }

        }, false);
    });
})();
