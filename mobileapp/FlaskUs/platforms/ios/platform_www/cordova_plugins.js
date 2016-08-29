cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "id": "cordova-plugin-calendar.Calendar",
        "file": "plugins/cordova-plugin-calendar/www/Calendar.js",
        "pluginId": "cordova-plugin-calendar",
        "clobbers": [
            "Calendar"
        ]
    },
    {
        "id": "cordova-plugin-calendar.tests",
        "file": "plugins/cordova-plugin-calendar/test/tests.js",
        "pluginId": "cordova-plugin-calendar"
    },
    {
        "id": "cordova-plugin-console.console",
        "file": "plugins/cordova-plugin-console/www/console-via-logger.js",
        "pluginId": "cordova-plugin-console",
        "clobbers": [
            "console"
        ]
    },
    {
        "id": "cordova-plugin-console.logger",
        "file": "plugins/cordova-plugin-console/www/logger.js",
        "pluginId": "cordova-plugin-console",
        "clobbers": [
            "cordova.logger"
        ]
    },
    {
        "id": "cordova-plugin-datepicker.DatePicker",
        "file": "plugins/cordova-plugin-datepicker/www/ios/DatePicker.js",
        "pluginId": "cordova-plugin-datepicker",
        "clobbers": [
            "datePicker"
        ]
    },
    {
        "id": "cordova-plugin-device.device",
        "file": "plugins/cordova-plugin-device/www/device.js",
        "pluginId": "cordova-plugin-device",
        "clobbers": [
            "device"
        ]
    },
    {
        "id": "cordova-plugin-statusbar.statusbar",
        "file": "plugins/cordova-plugin-statusbar/www/statusbar.js",
        "pluginId": "cordova-plugin-statusbar",
        "clobbers": [
            "window.StatusBar"
        ]
    },
    {
        "id": "ionic-plugin-keyboard.keyboard",
        "file": "plugins/ionic-plugin-keyboard/www/ios/keyboard.js",
        "pluginId": "ionic-plugin-keyboard",
        "clobbers": [
            "cordova.plugins.Keyboard"
        ],
        "runs": true
    },
    {
        "id": "cordova-plugin-geolocation.Coordinates",
        "file": "plugins/cordova-plugin-geolocation/www/Coordinates.js",
        "pluginId": "cordova-plugin-geolocation",
        "clobbers": [
            "Coordinates"
        ]
    },
    {
        "id": "cordova-plugin-geolocation.PositionError",
        "file": "plugins/cordova-plugin-geolocation/www/PositionError.js",
        "pluginId": "cordova-plugin-geolocation",
        "clobbers": [
            "PositionError"
        ]
    },
    {
        "id": "cordova-plugin-geolocation.Position",
        "file": "plugins/cordova-plugin-geolocation/www/Position.js",
        "pluginId": "cordova-plugin-geolocation",
        "clobbers": [
            "Position"
        ]
    },
    {
        "id": "cordova-plugin-geolocation.geolocation",
        "file": "plugins/cordova-plugin-geolocation/www/geolocation.js",
        "pluginId": "cordova-plugin-geolocation",
        "clobbers": [
            "navigator.geolocation"
        ]
    },
    {
        "id": "cordova-plugin-splashscreen.SplashScreen",
        "file": "plugins/cordova-plugin-splashscreen/www/splashscreen.js",
        "pluginId": "cordova-plugin-splashscreen",
        "clobbers": [
            "navigator.splashscreen"
        ]
    },
    {
        "id": "cordova-plugin-googlemaps.cordova-plugin-googlemaps",
        "file": "plugins/cordova-plugin-googlemaps/www/googlemaps-cdv-plugin.js",
        "pluginId": "cordova-plugin-googlemaps",
        "clobbers": [
            "cordova-plugin-googlemaps"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-calendar": "4.5.1",
    "cordova-plugin-console": "1.0.3",
    "cordova-plugin-datepicker": "0.9.2",
    "cordova-plugin-device": "1.1.2",
    "cordova-plugin-statusbar": "2.1.3",
    "cordova-plugin-whitelist": "1.2.2",
    "ionic-plugin-keyboard": "1.0.9",
    "cordova-plugin-compat": "1.0.0",
    "cordova-plugin-geolocation": "2.1.0",
    "cordova-plugin-splashscreen": "3.2.2",
    "com.googlemaps.ios": "1.13.0",
    "cordova-plugin-googlemaps": "1.3.9"
};
// BOTTOM OF METADATA
});