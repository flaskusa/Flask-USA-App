(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_registrationCtrl', user_registrationCtrl);

    user_registrationCtrl.$inject = ['$scope', 'UserService'];
    
    /* @ngInject */
    function user_registrationCtrl($scope, UserService) {
        var gender = true;
        $scope.saveUser = function (user) {
            console.log(user);
            if (user.isMale == 'male') {
                gender = true;
                //$scope.isMale = male;
            }
            else { gender = false;}
            console.log(gender);
            UserService.saveUser(user, gender);
            document.register_user_form.reset();
        }
    }
})();

