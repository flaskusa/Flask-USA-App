(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatePlanCtrl', mytailgatePlanCtrl);

    mytailgatePlanCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies'];

    /* @ngInject */
    function mytailgatePlanCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies) {
        $scope.myTailgaters = [];
        $scope.tailgateSupplyList = [];
        var tailGateId = $cookies.get('currtailGateId');
        getMyTailgate();
        getSupplyList();
       
        //addTailgateSupplyList();
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                console.log(respData);
                $scope.myTailgate = respData.data;
            });
        }

        function getSupplyList() {
            TailgateService.getMySupplyLists().then(function (respData) {
                console.log(respData);
                $scope.mySupplyList = respData.data;
                console.log($scope.mySupplyList.length);
                for (var i = 0; i < $scope.mySupplyList.length; i++) {
                    console.log($scope.mySupplyList[i].supplyListName);
                    $scope.tailgateSupplyList.push({ supplyListName: $scope.mySupplyList[i].supplyListName });

                }
                
            });
        }

        $scope.getSupplyItem=function(supplyListId) {
            TailgateService.getitemsbylistid(supplyListId).then(function (respData) {
                console.log(respData);
                //$scope.mySupplyList = respData.data;
                //console.log($scope.mySupplyList.length);
                //for (var i = 0; i < $scope.mySupplyList.length; i++) {
                //    console.log($scope.mySupplyList[i].supplyListName);
                //    $scope.tailgateSupplyList.push({ supplyListName: $scope.mySupplyList[i].supplyListName });
                //}
            });
        }

    }
})();

