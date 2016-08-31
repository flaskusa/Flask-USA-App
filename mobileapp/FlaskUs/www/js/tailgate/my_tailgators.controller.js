(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatorsCtrl', mytailgatorsCtrl);

    mytailgatorsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService','$cookies','$ionicModal','$flaskUtil'];

    /* @ngInject */
    function mytailgatorsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies,$ionicModal,$flaskUtil) {
        $scope.myTailgaters = [];
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
        var tailGateId = $cookies.get('tailGateId');
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        getTailgaters();

        function getTailgaters() {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgaters = respData.data;
            });
        }

    }
})();

