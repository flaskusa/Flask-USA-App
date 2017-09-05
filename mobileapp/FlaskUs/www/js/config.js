(function () {
    var flaskAppConfig = angular.module('flaskApp');
    var getMessageUrlSubString="/flask-social-portlet.flaskmessages";
    var getmessageBoardsByTailgateIdURL = "/get-message-boards-by-tailgate-id";
    var getUserProfileUrl = "/get-my-file-entry";
    var getMyNotificationCountUrl="/get-requests-count"
    var getMessageCountUrl="/get-my-flask-messages-count"
    var setMessageReadUrl = "/set-read";
    var errorLog = [];
    //production server settings
    flaskAppConfig.value("SERVER", {
         "hostName": "https://www.flask-usa.com/",
         "url": "https://www.flask-usa.com/api/jsonws/",
        //"hostName": "http://52.54.164.161/", //production ip
        //"url": "http://52.54.164.161/api/jsonws/",
        "googleApi": "http://maps.googleapis.com/maps/api/geocode/json?",
		"cacheExpireTime":1000
    })
 
    //test server settings
    //flaskAppConfig.value("SERVER", {
    //  "hostName": "http://52.44.202.166/",
    //  "url": "http://52.44.202.166/api/jsonws/",
    //  "googleApi": "http://maps.googleapis.com/maps/api/geocode/json?",
    //  "cacheExpireTime":1000
    //})
    flaskAppConfig.config(function ($provide) {
            $provide.decorator("$exceptionHandler", function ($delegate, $injector) {
                return function (exception, cause) {
                    var $rootScope = $injector.get("$rootScope");
                    var $state = $injector.get("$state");
                    var $timeout = $injector.get("$timeout");
                    $rootScope.$broadcast("catchAll:exception",{exception:exception}); // This represents a custom method that exists within $rootScope
                    $delegate(exception, cause);
                    $rootScope.$broadcast('loading:show');
                    $timeout(function () {
                        $state.go("app.events");
                        $rootScope.$broadcast('loading:hide');
                    }, 500);
            };
        });
    });

    flaskAppConfig.config(function ($httpProvider, $stateProvider, $urlRouterProvider, $ionicConfigProvider,uiGmapGoogleMapApiProvider) {
        $stateProvider
          .state('app', {
              url: '/app',
              abstract: true,
              templateUrl: "./templates/menu.html",
              controller: 'AppCtrl'
          })

        .state('app.search', {
            url: '/search',
            views: {
                'menuContent': {
                    templateUrl: "./templates/search.html"
                }
            }
        })

        .state('app.events', {
            url: '/events',
            views: {
                'menuContent': {
                    templateUrl: "./templates/events.html",
                    controller: 'EventsCtrl'
                }
            }
        })

        .state('app.venueList', {
            url: '/venueList',
            views: {
                'menuContent': {
                    templateUrl: "./templates/venue_List.html",
                    controller: 'VenueCtrl'
                }
            }
        })

        //pre post game page
        .state('app.pre_post_game', {
            url: '/pre_post_game/:eventName/:eventId/:venueId',
            views: {
                'menuContent': {
                    templateUrl: "./templates/pre_post_game.html",
                    controller: 'prePostGameCtrl'
                }
            }
        })

        //event map view
        .state('app.event_map_view', {
            url: '/event_map_view',
            params: {eventDetails: null, infoType: null, infoTypeCategory: null },
            views: {
                'menuContent': {
                    templateUrl: "./templates/event_map_view.html",
                    controller: 'eventMapViewCtrl'
                }
            }
        })
        .state('app.login', {
            url: '/login',
            views: {
                'menuContent': {
                    templateUrl: "./templates/login.html",
                    controller: 'LoginCtrl'
                }
            }
        })

        // Supplies
        .state('app.supplies', {
            url: '/supplies/:myListName/:currEventId',
            views: {
                'menuContent': {
                    templateUrl: "./templates/supplies.html",
                    controller: 'SuppliesCtrl'
                }
            }
        })
            .state('app.createSupplies', {
                url: '/createSupplies',
                views: {
                    'menuContent': {
                        templateUrl: "./templates/createSupplies.html",
                        controller: 'SuppliesCtrl'
                    }
                }
            })

        .state('app.suppliesList', {
            url: '/suppliesList/:listName/:supplyListId',
            views: {
                'menuContent': {
                    templateUrl: "./templates/supplies_list.html",
                    controller: 'SuppliesListCtrl'
                }
            }
        })

        .state('app.user_navigation_menu', {
            url: '/user_navigation_menu',
            views: {
                'menuContent': {
                    templateUrl: "./templates/user_navigation_menu.html",
                    controller: 'user_navigation_menuCtrl'
                }
            }
        })

       /*My_events Controller*/
        .state('app.my_events', {
            url: '/my_events',
            views: {
                'menuContent': {
                    templateUrl: "./templates/my_events.html",
                    controller: 'my_eventsCtrl'
                }
            }
        })
           
         .state('app.add_my_event', {
             url: '/add_my_event',
             views: {
                 'menuContent': {
                     templateUrl: "./templates/add_my_event.html",
                     controller: 'addMyEventCtrl'
                 }
             }
         })


        /*End My_events Controller*/
        // My TailGate Section
        .state('app.my_tailgate', {
            url: '/my_tailgate',
            views: {
                'menuContent': {
                    templateUrl: "./templates/my_tailgate.html",
                    controller: 'my_tailgateCtrl'
                }
            }
        })
       
        .state('app.my_tailgateDetails', {
            url: '/my_tailgateDetails',
            views: {
                'menuContent': {
                    templateUrl: "./templates/my_tailgateDetails.html"
                }
            }
            
        })

        .state('app.add_my_tailgate', {
            url: '/add_my_tailgate',
            views: {
                'menuContent': {
                    templateUrl: "./templates/add_my_tailgate.html",
                    controller: 'add_mytailgateCtrl'
                }
            }
        })


        .state('app.my_tailgateDetails.my_tailgate_event_details', {
            url: "/my_tailgate_event_details/:tailgateId",
            views: {
                'evnts-tab': {
                    templateUrl: "./templates/my_tailgate_event_details.html",
                    controller: 'mytailgateDetailsCtrl'
                }
            }
        })

        .state('app.my_tailgateDetails.my_tailgate_view_location', {
            url: "/my_tailgate_view_location",
            views: {
                'location-tab': {
                    templateUrl: "./templates/my_tailgate_view_location.html",
                    controller: 'mytailgatelocationCtrl'
                }
            }
        })

        .state('app.my_tailgateDetails.my_tailgate_view_tailgaters', {
            url: "/my_tailgate_view_tailgaters",
            views: {
                'tailgaters-tab': {
                    templateUrl: "./templates/my_tailgate_view_tailgaters.html",
                    controller: 'mytailgatorsCtrl'
                }
            }
        })
        .state('app.my_tailgateDetails.my_tailgate_view_plan', {
            url: "/my_tailgate_view_plan",
            views: {
                'plan-tab': {
                    templateUrl: "./templates/my_tailgate_view_plan.html",
                    controller: 'mytailgatePlanCtrl'
                }
            }
        })
    // End of My TailGate Section

        .state('app.my_friends_tab', {
            url: '/my_friends_tab',
            views: {
                'menuContent': {
                        templateUrl: "./templates/my_friends_tab.html",
                        controller: "FriendsCtrl"
                    }
                }
        })

        .state('app.my_friends_tab.my_friends', {
                url: '/my_friends',
                views: {
                        'myFriend_tab': {
                            templateUrl: "./templates/my_friends.html",
                            controller: "FriendsCtrl"
                        }
                    }
            })
        .state('app.my_friendDetail', {
            url: '/my_friendDetail:friendId',
            views: {
                'menuContent': {
                    templateUrl: "./templates/friendDetail.html",
                    controller:"FriendDetailCtrl"
                }
            }
        })
        .state('app.user_registration', {
            url: '/user_registration',
            views: {
                'menuContent': {
                    templateUrl: "./templates/user_registration.html",
                    controller: 'user_registrationCtrl'
                }
            }
        })

        .state('app.forgot_password', {
            url: '/forgot_password',
            views: {
                'menuContent': {
                    templateUrl: "./templates/forgot_password.html",
                    controller: 'ForgotPasswordCtrl'
                }
            }
        })

        .state('app.reset_password', {
            url: '/reset_password',
            views: {
                'menuContent': {
                    templateUrl: "./templates/reset_password.html",
                    controller: 'resetPasswordCtrl'
                }
            }
        })

        .state('app.account_settings', {
            url: '/account_settings',
            views: {
                'menuContent': {
                    templateUrl: "./templates/account_settings.html",
                    controller: 'account_settingsCtrl'
                }
            }
        })

        .state('app.tickets', {
            url: '/tickets',
            params: {eventDetails: null},

            views: {
                'menuContent': {
                    templateUrl: "./templates/tickets.html",
                    controller: 'ticketsCtrl'
                }
            }
        })
        .state('app.my_friends_tab.friendsGroup', {
            url: '/friends_group/:userId',
            views: {
                'myGroup_tab': {
                    templateUrl: "./templates/friends_group.html",
                    controller: 'FriendsGroupCtrl'
                }
            }
        })
            .state('app.my_friends_tab.notification', {
                url: '/notification_tab',
                views: {
                    'notification_tab': {
                        templateUrl: "./templates/notification.html",
                        controller:'FriendsNotificationCtrl'
                    }
                }
            })
            .state('app.createGroup', {
                url: '/create_group',
                views: {
                    'menuContent': {
                        templateUrl: "./templates/create_group.html",
                        controller: 'CreateGroupCtrl'
                    }
                }
            })
            .state('app.groupDetail', {
                url: '/group_detail/:groupName',
                views: {
                    'menuContent': {
                        templateUrl: "./templates/group_detail.html",
                        controller: 'FriendsGroupDetailCtrl'
                    }
                }
            })

            .state('app.groupMemberDetail', {
                url: '/group_member_detail',
                views: {
                    'menuContent': {
                        templateUrl: "./templates/group_member_detail.html",
                        controller: 'FriendsGroupMemberDetailCtrl'
                    }
                }
            })
            .state('app.messages', {
                url: '/message_detail',
                views: {
                    'menuContent': {
                        templateUrl: "./templates/friend-group-messages.html",
                        controller: 'FriendsMessageCtrl'
                    }
                }
            })
            .state('app.notifications', {
                url: '/notification_detail',
                views: {
                    'menuContent': {
                        templateUrl: "./templates/friend-group-notifications.html",
                        controller: 'FriendsNotificationCtrl'
                    }
                }
            })
            .state('app.manage_event_content', {
                url: '/manage-event-content',
                params: {eventDetails: null, infoType: null, infoTypeCategory: null,currEventName:null,currEventId:null },
                views: {
                    'menuContent': {
                        templateUrl: "./templates/manage-event-content.html",
                        controller: 'ManageEventCtrl'
                    }
                }
            });

            function loaderHide(url){
                var hide=false;
                if(url.includes(getMessageUrlSubString) || url.includes(getmessageBoardsByTailgateIdURL) || url.includes(getMyNotificationCountUrl) || url.includes(getMessageCountUrl) ||url.includes(setMessageReadUrl)){
                         hide=true;
                }
                return hide;
            }

            /* if none of the above states are matched, use this as the fallback */
             $urlRouterProvider.otherwise('/app/events');
             $ionicConfigProvider.tabs.position('bottom');
             $ionicConfigProvider.views.swipeBackEnabled(false);

            // remove back button text completely
             $ionicConfigProvider.backButton.previousTitleText(false).text(' ');

            // Http Interceptors for showing and hiding 
            $httpProvider.interceptors.push(function ($rootScope) {
                return {
                request: function (config) {
                    if(!loaderHide(config.url)) {
                        $rootScope.$broadcast('loading:show');
                    }
                    return config;
                },
                response: function (response) {
                        $rootScope.$broadcast('loading:hide');
                    return response;
                    }
                }
            })
             uiGmapGoogleMapApiProvider.configure({
              key: 'AIzaSyDAFZx0f0rc-vCyx-GHMqy2O9m06Dc-p8Y',
            libraries: 'weather,geometry,visualization,places'
        });
    })
})();
