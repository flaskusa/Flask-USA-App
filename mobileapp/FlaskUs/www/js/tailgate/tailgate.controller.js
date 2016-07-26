(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_tailgateCtrl', my_tailgateCtrl);

    my_tailgateCtrl.$inject = ['$scope', 'TailgateService'];

    /* @ngInject */
    function my_tailgateCtrl($scope, TailgateService) {
        var self = this;
        $scope.myTailgate = [];

        getAlltailgates();

        function getAlltailgates() {
            TailgateService.getMyTailgates().then(function (respData) {
                $scope.allTailgate = respData.data;
            });
        }
    }
})();

