
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('LoginService', LoginService);

    LoginService.$inject = ['$http', 'SERVER', '$state', '$cookies', '$q'];

    function LoginService($http, SERVER, $state, $cookies, $q) {
        //        var baseURL = SERVER.url;
        var services = {
            forgotPasswordFunction: forgotPasswordFunction,
            resetPasswordFuntion: resetPasswordFuntion,
            authenticateUser: authenticateUser,
            getUserProfilePicture: getUserProfilePicture,
            getCompanyIdFunction: getCompanyIdFunction,
            registerDeviceFuntion: registerDeviceFuntion,
            logoutDeactivateUser: logoutDeactivateUser
        }
        var forgotPasswordURL = "/flask-rest-users-portlet.flaskadmin/forgot-password";
        var resetPasswordUrl = "/flask-rest-users-portlet.flaskadmin/reset-password";
        var regiterDeviceUrl = "/flask-social-portlet.flaskmessages/register-with-sns";
        var getCompanyIdUrl = "/flask-rest-users-portlet.flaskadmin/get-company-id";
        var logoutDeactivateUrl = "/flask-social-portlet.flaskuserdeviceregistration/deactivate-user-for-user-device";


        var companyId = SERVER.companyId;
        var getUserByEmailId = "user/get-user-by-email-address";
        var getUserProfilePic = "dlapp/get-file-entry";

        function forgotPasswordFunction(emailAddress) {
            return $http.get(SERVER.url + forgotPasswordURL, {
                params: {
                    "emailAddress": emailAddress
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getCompanyIdFunction() {
            return $http.get(SERVER.url + getCompanyIdUrl, {
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function logoutDeactivateUser(userId, deviceToken) {
            return $http.get(SERVER.url + logoutDeactivateUrl, {
                params: {
                    "userId":userId,
                    "deviceToken": deviceToken
                }
            }).then(function success(response) {
                return response.data;
            }), function failure(response) {
                return $q.$inject(response);
            }
        }

        function resetPasswordFuntion(emailAddress, password1, password2, otp) {
            return $http.get(SERVER.url + resetPasswordUrl, {
                params: {
                    "emailAddress": emailAddress,
                    "password1": password1,
                    "password2": password2,
                    "otp": otp
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function registerDeviceFuntion(userId, userEmail, devicePlatform, deviceDetails, deviceToken, registrationTime, active, lastNotificationTime, lastNotificationMsg) {
            return $http.get(SERVER.url + regiterDeviceUrl, {
                params: {
                    'userId': userId,
                    'userEmail': userEmail,
                    'devicePlatform': devicePlatform,
                    'deviceDetails': deviceDetails,
                    'deviceToken': deviceToken,
                    'registrationTime': registrationTime,
                    'active': active,
                    'lastNotificationTime': lastNotificationTime,
                    'lastNotificationMsg': lastNotificationMsg
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function authenticateUser (scope) {
            var authdata = Base64.encode(scope.Email + ':' + scope.password);
            $cookies.put("authData",authdata);
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
            return $http.get(SERVER.url + getUserByEmailId, { params: { 'companyId': SERVER.companyId, 'emailAddress': scope.Email } })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //console.log("failed");
                });
        }

        function getUserProfilePicture () {
            var userPic = $cookies.getObject('CurrentUser');
            return $http.get(SERVER.url + getUserProfilePic, { params: { 'fileEntryId': userPic.data.portraitId } })
            .then(function success(resp) {
                $cookies.putObject('CurrentUserPic', resp);
                return resp;
            });
        }
        return services;
    } 


    // Base64 encoding service used by AuthenticationService
    var Base64 = {
        keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',
        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output +
                    this.keyStr.charAt(enc1) +
                    this.keyStr.charAt(enc2) +
                    this.keyStr.charAt(enc3) +
                    this.keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        },

        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                window.alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            do {
                enc1 = this.keyStr.indexOf(input.charAt(i++));
                enc2 = this.keyStr.indexOf(input.charAt(i++));
                enc3 = this.keyStr.indexOf(input.charAt(i++));
                enc4 = this.keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";

            } while (i < input.length);

            return output;
        }
    };
})();