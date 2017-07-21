(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('UserService', UserService);

    UserService.$inject = ['$http', '$state', 'SERVER'];

    function UserService($http, $state, SERVER) {
        var addUserURL = "/flask-rest-users-portlet.flaskadmin/sign-up";
        var getUserByEmailIdUrl = "/flask-rest-users-portlet.flaskadmin/get-user-for-email";
        var updateUserURL = "flask-rest-users-portlet.flaskadmin/update-flask-user";
        var getUserByIdURL = "flask-rest-users-portlet.flaskadmin/get-user-by-id";
        var getCountriesURL = "flask-rest-users-portlet.flaskadmin/get-countries";
        var getRegionURL = "flask-rest-users-portlet.flaskadmin/get-region";
        var uploadUserProfileURL = "flask-rest-users-portlet.flaskadmin/upload-user-profile";
        var getUserProfileUrl = "/flask-rest-users-portlet.flaskadmin/get-my-file-entry";
        var removeProfilePictureUrl = "/flask-rest-users-portlet.flaskadmin/delete-my-file-entry";
        var updatePassswordUrl = '/flask-rest-users-portlet.flaskadmin/update-password';

        var userServices = {
            saveUser: saveUser,
            getUserbyEmail: getUserbyEmail,
            getUserById: getUserById,
            updateUser: updateUser,
            getCountries: getCountries,
            getRegion: getRegion,
            uploadProfile: uploadProfile,
            getUserProfile : getUserProfile,
            removeProfilePicture :removeProfilePicture ,
            updatePasssword:updatePasssword
           
        }

        function saveUser(user, srcname) {

            //console.log(user);
            var params = {
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.Email,
                screenName: srcname,
                password1: user.password1,
                password2: user.password2,
                DOB: user.DOB,
                isMale: user.isMale,
                areaCode: user.areaCode,
                mobileNumber: user.mobileNumber
            };
            return $http.get(SERVER.url + addUserURL, {
                params:params
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
                //console.log("failed");
            });
        }

        function updatePasssword (userId, userPassword) {
            return $http.get(SERVER.url + updatePassswordUrl, { params: { 'userId': userId,'oldPassword':userPassword.oldPassword,'password1':userPassword.newPassword1,'password2':userPassword.newPassword2 } })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //console.log("failed");
                });
        }

        function getUserProfile(userId) {
            return $http.get(SERVER.url + getUserProfileUrl, { params: { 'userId': userId } })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //console.log("failed");
                });
        }
        function removeProfilePicture (userId) {
             return $http.get(SERVER.url + removeProfilePictureUrl, { params: { 'userId': userId } })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //console.log("failed");
                });
        }

        function getUserbyEmail(email) {
            return $http.get(SERVER.url + getUserByEmailIdUrl, { params: { 'emailAddress': email} })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //console.log("failed");
                });
        }

        function getUserById(userId) {
            return $http.get(SERVER.url + getUserByIdURL, {
                params: {
                    'userId': userId
                }
            })
               .then(function success(response) {
                   return response.data;
               }, function failure(response) {
                   //console.log("failed");
               });
        }

        function updateUser(user, userId, interestArray) {
            var params = {
                userId: userId,
                firstName: user.firstName,
                middleName: user.middleName,
                lastName: user.lastName,
                email: user.Email,
                screenName: user.screenName,
                password1: user.password1,
                password2: user.password2,
                DOB: user.DOB,
                isMale: user.isMale,
                streetName: user.streetName,
                aptNo: user.aptNo,
                areaCode: user.areaCode,
                city: user.city,
                stateId: user.stateId,
                countryId: user.countryId,
                mobileNumber: user.mobileNumber,
                userInterests: interestArray
            };

            return $http.get(SERVER.url + updateUserURL, {
                params:params
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
                //console.log("failed");
            });
        }

        function getCountries() {
            return $http.get(SERVER.url + getCountriesURL)
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   //console.log("failed");
               });
        }

        function getRegion(countryId) {
            return $http.get(SERVER.url + getRegionURL, {
                params: {
                    'countryId': countryId
                }
            })
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   //console.log("failed");
               });
        }

        function uploadProfile() {
            return $http.get(SERVER.url + uploadUserProfileURL)
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   //console.log("failed");
               });
        }

        return userServices;
    }
})();


