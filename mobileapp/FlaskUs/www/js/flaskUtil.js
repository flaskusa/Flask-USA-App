(function () {
    'use strict';

    angular.module('flaskApp')
        .service('$flaskUtil', $flaskUtil);
        $flaskUtil.$inject = ['$ionicPopup']
    function $flaskUtil($ionicPopup) {
        return {
            alert:alert,
            confirm:confirm
        };
        
        function alert(message) {
            var options = {
                title: 'Alert', // String. The title of the popup.
                template: message,
                okText: 'OK', // String (default: 'OK'). The text of the OK button.
            };
            $ionicPopup.alert(options);
        }
    }
   
})();