(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatePlanCtrl', mytailgatePlanCtrl);

    mytailgatePlanCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies'];

    /* @ngInject */
    function mytailgatePlanCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies) {
        $scope.myTailgaters = [];
        var tailGateId = $cookies.get('tailGateId');
        getMyTailgate();
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgate = respData.data;
            });
        }



    }
})();

