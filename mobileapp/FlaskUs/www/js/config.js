(function () {
    var flaskAppConfig = angular.module('flaskApp');

    flaskAppConfig.constant("REST_API", {
        "url": "http://146.148.83.30/api/jsonws/",
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
        .state('app.prePostGame', {
            url: '/prePostGame/:eventName/:eventId/:venueId',
            views: {
                'menuContent': {
                    templateUrl: 'templates/prePostGame.html',
                    controller: 'prePostGameCtrl'
                }
            }
        })

        .state('app.browse', {
            url: '/browse',
            views: {
                'menuContent': {
                    templateUrl: 'templates/browse.html'
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

        .state('app.playlists', {
            url: '/playlists',
            views: {
                'menuContent': {
                    templateUrl: 'templates/playlists.html',
                    controller: 'PlaylistsCtrl'
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
                    templateUrl: 'templates/user_navigation_menu.html'
                }
            }
        })

        .state('app.my_events', {
            url: '/my_events',
            views: {
                'menuContent': {
                    templateUrl: 'templates/my_events.html'
                }
            }
        })
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

        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/app/events');
        

    })


})();