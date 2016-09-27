(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('UserService', UserService);

    UserService.$inject = ['$http','$state','SERVER'];

    function UserService($http, $state,SERVER) {
        var baseURL = SERVER.url;
        var addUserURL = "/flask-rest-users-portlet.flaskadmin/sign-up";
        var getUserByEmailId = "/flask-rest-users-portlet.flaskadmin/get-user-for-email";
        var updateUserURL = "flask-rest-users-portlet.flaskadmin/update-flask-user";
        var getUserByIdURL = "flask-rest-users-portlet.flaskadmin/get-user-by-id";
        var getCountriesURL = "flask-rest-users-portlet.flaskadmin/get-countries";
        var getRegionURL = "flask-rest-users-portlet.flaskadmin/get-region";
        

        var userServices = {
            saveUser: saveUser,
            getUserbyEmail: getUserbyEmail,
            getUserById: getUserById,
            updateUser: updateUser,
            getCountries: getCountries,
            getRegion: getRegion
        }

        function saveUser(user, gender, srcname) {
            
            console.log(user);
            var params= {
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.Email,
                screenName: srcname,
                password1: user.password1,
                password2: user.password2,
                DOB: user.DOB,
                isMale: gender,
                areaCode: user.areaCode,
                mobileNumber: user.mobileNumber
            };
            return $http.get(baseURL + addUserURL, {
                params
            }
            )
            .then(function success(response) {               
                    return response;
                },  function failure(response) {
                    //add errror handling 
                    console.log("failed");
                });
        }

        function getUserbyEmail(email) {
            return $http.get(baseURL + getUserByEmailId, { params: { 'emailAddress': email.Email } })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    console.log("failed");
                });
        }

        function getUserById(userId) {
            return $http.get(baseURL + getUserByIdURL, {
                params: {
                    'userId': userId
                }
            })
               .then(function success(response) {
                   return response.data;
               }, function failure(response) {
                   console.log("failed");
               });
        }

        function updateUser(userId,user,sId,cId) {
            var params = {
                userId:userId,
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.Email,
                screenName: user.srcname,
                password1: user.password1,
                password2: user.password2,
                DOB: user.DOB,
                isMale: '0',
                streetName: user.streetName,
                aptNo:user.aptNo,
                areaCode: user.areaCode,
                city: user.city,
                stateId: sId,
                countryId: cId,
                mobileNumber: user.mobileNumber,
                userInterests:"658HHQ2fl34YyxEkOn6dIa7rez9hASadSDR09h0dn44ZULT+kQS+z0qMwIrsnFq6"

            };

            return $http.get(baseURL + updateUserURL, {
                params
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
                console.log("failed");
            });
        }

        function getCountries() {
            return $http.get(baseURL + getCountriesURL)
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   console.log("failed");
               });
        }

        function getRegion(countryId) {
            return $http.get(baseURL + getRegionURL, {
                params: {
                    'countryId': countryId
                }
            })
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   console.log("failed");
               });
        }

        return userServices;
    }
})();


