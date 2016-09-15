(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatePlanCtrl', mytailgatePlanCtrl);

    mytailgatePlanCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicModal'];

    /* @ngInject */
    function mytailgatePlanCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicModal) {
        $scope.myTailgaters = [];
        $scope.tailgateSupplyList = [],[];
        $scope.tailgateSupplyItemList = [];
        $scope.supplyListId = [];
        //$ionicModal.fromTemplateUrl('templates/modal.html', {
        //    scope: $scope
        //}).then(function (modal) {
        //    $scope.modal = modal;
        //});
        //$scope.cancel = function () {
        //    $scope.modal.hide();
        //}
        var tailGateId = $cookies.get('currtailGateId');
        getMyTailgate();
        getMySupplyList();
       
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.myTailgate = respData.data;
            });
        }

       function getMySupplyList(selected1) {
            TailgateService.getMySupplyLists().then(function (respData) {
                $scope.allSupplyList = respData.data;
                for (var i = 0; i < $scope.allSupplyList.length; i++) {
                    $scope.tailgateSupplyList.push({ supplyListName: $scope.allSupplyList[i].supplyListName, supplyListsId: $scope.allSupplyList[i].supplyListId });
                }
            });
        }

        $scope.getSupplyItem = function (selected1) {
            var supplyListstId = selected1.supplyListsId;
            TailgateService.getItemsbylistid(supplyListstId).then(function (respData) {
                $scope.supplyItemList = respData.data;
            });
        }

    }
})();

