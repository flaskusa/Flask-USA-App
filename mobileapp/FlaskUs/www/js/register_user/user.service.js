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
        var getUserByIdURL="flask-rest-users-portlet.flaskadmin/get-user-by-id";
        

        var userServices = {
            saveUser: saveUser,
            getUserbyEmail: getUserbyEmail,
            getUserById: getUserById,
            updateUser: updateUser
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

        function updateUser(user, gender, srcname) {
            var params = {
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
            }, function failure(response) {
                //add errror handling 
                console.log("failed");
            });
        }

        return userServices;
    }
})();


