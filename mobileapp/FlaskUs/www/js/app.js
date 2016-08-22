(function () {
    var app = angular.module('flaskApp'); 
    app.run(function ($ionicPlatform, $rootScope, $ionicLoading, $ionicPopup) {
        $ionicPlatform.ready(function () {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            if (cordova.platformId === 'ios' && window.cordova && window.cordova.plugins.Keyboard) {
                cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
                cordova.plugins.Keyboard.disableScroll(true);
            }
            if (window.StatusBar) {
                // org.apache.cordova.statusbar required
                StatusBar.styleDefault();
            }


            $rootScope.$on('loading:show', function () {
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' })
            })

            $rootScope.$on('loading:hide', function () {
                $ionicLoading.hide()
            })
            
        });
        document.addEventListener("deviceready", function () {

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
  
        
    })
})();