(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('user_registrationCtrl', user_registrationCtrl);

    user_registrationCtrl.$inject = ['$scope', 'UserService'];

    /* @ngInject */
    function user_registrationCtrl($scope, UserService) {
        $scope.saveUser = function (user) {
            console.log(user);
            if (user.gender_male == "male") {
                var male = true;
                $scope.isMale = male;
            }
            console.log(male);
          UserService.saveUser(user);
        }
    }
})();

