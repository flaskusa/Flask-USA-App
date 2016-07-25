(function () {
    var flaskAppConfig = angular.module('flaskApp');

    flaskAppConfig.config(function ($stateProvider, $urlRouterProvider) {
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

        .state('app.browse', {
            url: '/browse',
            views: {
                'menuContent': {
                    templateUrl: 'templates/browse.html'
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

        //.state('app', {
        //    url: '/playlists/:playlistId',
        //    views: {
        //        'menuContent': {
        //            templateUrl: 'templates/playlist.html',
        //            controller: 'PlaylistCtrl'
        //        }
        //    }
        //})

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
            url: '/suppliesList',
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

        .state('app.my_events', {
            url: '/my_events',
            views: {
                'menuContent': {
                    templateUrl: 'templates/my_events.html',
                    controller: 'my_eventsCtrl'
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

        .state('app.add_tailgate', {
            url: '/add_tailgate',
            views: {
                'menuContent': {
                    templateUrl: 'templates/add_tailgate.html',
                    controller: 'add_tailgateCtrl'
                }
            }
        })

        .state('app.my_friends', {
            url: '/my_friends',
            views: {
                'menuContent': {
                    templateUrl: 'templates/my_friends.html',
                    controller: 'my_friendsCtrl'
                }
            }
        })

        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/app/playlists');
    });
})();