(function () {
    var flaskAppConfig = angular.module('flaskApp');

    flaskAppConfig.constant("SERVER", {
        "hostName": "http://146.148.83.30/",
        "url": "http://146.148.83.30/api/jsonws/",
        "googleApi": "http://maps.googleapis.com/maps/api/geocode/json?",
        "companyId":20154
    })

    flaskAppConfig.config(function ($httpProvider, $stateProvider, $urlRouterProvider) {
        $stateProvider
          .state('app', {
              url: '/app',
              abstract: true,
              templateUrl: 'templates/menu.html',
              controller: 'AppCtrl'
          })

        .state('app.search', {
            url: '/search',
            views: {
                'menuContent': {
                    templateUrl: 'templates/search.html'
                }
            }
        })

        .state('app.events', {
            url: '/events',
            views: {
                'menuContent': {
                    templateUrl: 'templates/events.html',
                    controller: 'EventsCtrl'
                }
            }
        })
        //pre post game page
        .state('app.pre_post_game', {
            url: '/pre_post_game/:eventName/:eventId/:venueId',
            views: {
                'menuContent': {
                    templateUrl: 'templates/pre_post_game.html',
                    controller: 'prePostGameCtrl'
                }
            }
        })

                //event map view
        .state('app.eventMapView', {
            url: '/eventMapView',
            views: {
                'menuContent': {
                    templateUrl: 'templates/event_map_view.html',
                    controller: 'eventMapViewCtrl'
                }
            }
        })
        .state('app.login', {
            url: '/login',
            views: {
                'menuContent': {
                    templateUrl: 'templates/login.html',
                    controller: 'LoginCtrl'
                }
            }
        })

        // Supplies
        .state('app.supplies', {
            url: '/supplies',
            views: {
                'menuContent': {
                    templateUrl: 'templates/supplies.html',
                    controller: 'SuppliesCtrl'
                }
            }
        })

        .state('app.suppliesList', {
            url: '/suppliesList/:listName',
            views: {
                'menuContent': {
                    templateUrl: 'templates/suppliesList.html',
                    controller: 'SuppliesListCtrl'
                }
            }
        })

        .state('app.user_navigation_menu', {
            url: '/user_navigation_menu',
            views: {
                'menuContent': {
                    templateUrl: 'templates/user_navigation_menu.html',
                    controller: 'user_navigation_menuCtrl'
                }
            }
        })

            /*My_events Controller*/
        .state('app.my_events', {
            url: '/my_events',
            views: {
                'menuContent': {
                    templateUrl: 'templates/my_events.html',
                    controller: 'my_eventsCtrl'
                }
            }
        })

         .state('app.addMyEvent', {
             url: '/addMyEvent',
             views: {
                 'menuContent': {
                     templateUrl: 'templates/addMyEvent.html',
                     controller: 'addMyEventCtrl'
                 }
             }
         })
            /*End My_events Controller*/

        .state('app.my_tailgate', {
            url: '/my_tailgate',
            views: {
                'menuContent': {
                    templateUrl: 'templates/my_tailgate.html',
                    controller: 'my_tailgateCtrl'
                }
            }
        })
        .state('app.my_friends', {
            url: '/my_friends',
            views: {
                'menuContent': {
                    templateUrl: 'templates/my_friends.html'
                }
            }
        })

        .state('app.user_registration', {
            url: '/user_registration',
            views: {
                'menuContent': {
                    templateUrl: 'templates/user_registration.html',
                    controller: 'user_registrationCtrl'
                }
            }
        })

        .state('app.forgot_password', {
            url: '/forgot_password',
            views: {
                'menuContent': {
                    templateUrl: 'templates/forgot_password.html'
                }
            }
        })

        .state('app.account_settings', {
            url: '/account_settings',
            views: {
                'menuContent': {
                    templateUrl: 'templates/account_settings.html'
                }
            }
        })

       .state('app.addMyTailgate', {
           url: '/addMyTailgate',
           views: {
               'menuContent': {
                   templateUrl: 'templates/addMyTailgate.html',
                   controller: 'addMyTailgateCtrl'
               }
           }
       }
       )

        //Http Interceptors for showing and hiding 
        $httpProvider.interceptors.push(function ($rootScope) {
            return {
            request: function (config) {
                $rootScope.$broadcast('loading:show')
                return config
            },
            response: function (response) {
                    $rootScope.$broadcast('loading:hide')
                return response
                }
            }
        })
        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/app/events');     
    })
})();