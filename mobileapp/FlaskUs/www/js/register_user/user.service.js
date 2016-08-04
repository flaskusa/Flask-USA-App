(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('UserService', UserService);

    UserService.$inject = ['$http','$state','REST_API'];

    function UserService($http, $state,REST_API) {
        var baseURL = REST_API.url;
        var addUserURL = "/flask-rest-users-portlet.flaskadmin/sign-up";
        var getUserByEmailId = "user/get-user-by-email-address";
        
        this.saveUser = saveUser
        function saveUser(user, gender) {
            
            console.log(user);
            var params= {
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.Email,
                screenName: user.screenName,
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

        this.getUserbyEmail = function (email) {
            return $http.get(baseURL + getUserByEmailId, { params: { 'companyId': REST_API.companyId, 'emailAddress': email.Email } })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    console.log("failed");
                });
        }
    }
})();


