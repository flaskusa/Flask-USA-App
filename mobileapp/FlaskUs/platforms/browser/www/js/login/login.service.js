
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('LoginService', LoginService);

    LoginService.$inject = ['$http', 'SERVER', '$state', '$cookies', '$q', '$flaskUtil'];

    function LoginService($http, SERVER, $state, $cookies, $q, $flaskUtil) {
        //        var baseURL = SERVER.url;
        var services = {
            forgotPasswordFunction: forgotPasswordFunction,
            resetPasswordFuntion: resetPasswordFuntion,
            authenticateUser: authenticateUser,
            getUserProfilePicture: getUserProfilePicture,
            getCompanyIdFunction: getCompanyIdFunction,
            registerDeviceFuntion: registerDeviceFuntion,
            logoutDeactivateUser: logoutDeactivateUser,
            showStatusofAPIonFaliure: showStatusofAPIonFaliure
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
            var deferred = $q.defer();
            $http.get(SERVER.url + forgotPasswordURL, {
                params: {
                    "emailAddress": emailAddress
                }
            })
                .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function getCompanyIdFunction() {
            var deferred = $q.defer();
            $http.get(SERVER.url + getCompanyIdUrl, {
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function logoutDeactivateUser(userId, deviceToken) {
            var deferred = $q.defer();
            $http.get(SERVER.url + logoutDeactivateUrl, {
                params: {
                    "userId":userId,
                    "deviceToken": deviceToken
                }
            }).then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function resetPasswordFuntion(emailAddress, password1, password2, otp) {
            var deferred = $q.defer();
            $http.get(SERVER.url + resetPasswordUrl, {
                params: {
                    "emailAddress": emailAddress,
                    "password1": password1,
                    "password2": password2,
                    "otp": otp
                }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function registerDeviceFuntion(userId, userEmail, devicePlatform, deviceDetails, deviceToken, registrationTime, active, lastNotificationTime, lastNotificationMsg) {
            var deferred = $q.defer();
            $http.get(SERVER.url + regiterDeviceUrl, {
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
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function authenticateUser (scope) {
            var authdata = Base64.encode(scope.Email + ':' + scope.password);
            $cookies.put("authData",authdata);
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;

            var deferred = $q.defer();
            $http.get(SERVER.url + getUserByEmailId, { 
            params: { 
                'companyId': SERVER.companyId, 
                'emailAddress': scope.Email } 
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function getUserProfilePicture () {
            var userPic = $cookies.getObject('CurrentUser');
            var deferred = $q.defer();
            $http.get(SERVER.url + getUserProfilePic, { params: { 'fileEntryId': userPic.data.portraitId } })
            .then(function (resp) {
                $cookies.putObject('CurrentUserPic', resp);
                deferred.resolve(resp);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function showStatusofAPIonFaliure(err){
            if(err.status == 400){
                $flaskUtil.alert('Bad Request from server');
            }else if(err.status == 401){
                $flaskUtil.alert('Please check if your username and password are correct.');}
            else if(err.status == 403){
                $flaskUtil.alert('Too many connections on server');
            }else if(err.status == 500){
                $flaskUtil.alert('Something wrong with server');
                $state.go("app.events");
            }else if(err.status == -1){
                $flaskUtil.alert(" Please Check your Internet Connection and restart App again");                
            }else if(err.status == 503){
                $flaskUtil.alert("Server is currently Unavailable, please try after sometime");
                $state.go("app.events");
            }else if(err.status == 404){
                $flaskUtil.alert("Requested data not found on server");
            }else if(err.status == 502){
                $flaskUtil.alert("Invalid response from server");
                $state.go("app.events");
            }else if(err.status == 504){
                $flaskUtil.alert("Server response timeout");
                $state.go("app.events");
            }else{
                $state.go("app.events");
            }
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