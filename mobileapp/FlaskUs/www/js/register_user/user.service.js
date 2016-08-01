(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('UserService', UserService);

    UserService.$inject = ['$http'];

    function UserService($http) {
        var baseURL = "http://192.168.1.136:8080/api/jsonws";
        var addUserURL = "/flask-rest-users-portlet.flaskadmin/sign-up";

        this.saveUser = saveUser

        function saveUser(user) {
            
            console.log(user);
            var params= {
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.email,
                screenName: user.screenName,
                password1: user.password1,
                password2: user.password2,
                DOB: '25-1-1991',
                isMale: true,
                areaCode: user.areaCode,
                mobileNumber: '67676676767'
            };
            return $http.get(baseURL + addUserURL, {
                params
            }
            )
            .then(function success(response) {
                    console.log(response);
                    return response;
                }, function failure(response) {
                    //add errror handling 
                });
        }
    }
})();


