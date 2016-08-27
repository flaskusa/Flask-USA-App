(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', 'TailgateService', '$cordovaDatePicker', '$timeout'];

    /* @ngInject */
    function add_mytailgateCtrl($scope, TailgateService, $cordovaDatePicker, $timeout) {
        //for adding tailgate
        $scope.addmyTailgate = function (tailgatedata) {
            console.log(tailgatedata);
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data.exception);
                //$scope.AddedSuccess = true;
                //$timeout(function () { $scope.AddedSuccess = false; }, 3000);
            });
        }
        $scope.getvenuefromSelect = function (tailgatedata) {
            console.log(tailgatedata);
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
                console.log(respData.data.exception);
                //$scope.AddedSuccess = true;
                //$timeout(function () { $scope.AddedSuccess = false; }, 3000);
            });
        }
        
    }
})();

