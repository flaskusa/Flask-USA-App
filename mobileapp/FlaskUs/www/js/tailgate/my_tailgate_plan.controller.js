(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatePlanCtrl', mytailgatePlanCtrl);

    mytailgatePlanCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicModal'];

    /* @ngInject */
    function mytailgatePlanCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicModal) {
        $scope.myTailgaters = [];
        $scope.tailgateSupplyList = [], [];
        $scope.tailgateSupplyItemList = [];
        $scope.supplyListId = [];
        $scope.allMyTailgates = [];
        var supplyListstId;
        var supplyItemName;
        $scope.passItems = [];

        var tailGateId = $cookies.get('currtailGateId');
        getMyTailgate();
        getMySupplyList();
        getAllMyTailgates();
        getAllFriends();

        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.myTailgate = respData.data;
            });
        }

        function getMySupplyList(selected1) {
            console.log(selected1);
            TailgateService.getMySupplyLists().then(function (respData) {
                $scope.allSupplyList = respData.data;
                for (var i = 0; i < $scope.allSupplyList.length; i++) {
                    $scope.tailgateSupplyList.push({ supplyListName: $scope.allSupplyList[i].supplyListName, supplyListsId: $scope.allSupplyList[i].supplyListId });
                }
            });
        }

        $scope.getSupplyItem = function (selected) {
            console.log(selected);
            supplyListstId = selected.supplyListsId;
            TailgateService.getItemsbylistid(supplyListstId).then(function (respData) {
                $scope.supplyItemList = respData.data;
            });

        }

        $scope.addItemsInArray = function (selected_checkbox) {
            console.log(selected_checkbox);
           
            supplyItemName=selected_checkbox.supplyItemName;
            TailgateService.getItemsbylistid(supplyItemName).then(function (respData) {
                $scope.supplyItemName = respData.data;
                if (selected_checkbox == true) {
                    $scope.passItems.push({ supplyItemName: supplyItemName })
                }
            });
        }

        function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                $scope.myFriends = respData;
            })
        }

        $scope.getUserId = function (user_selected) {
            $scope.userId = user_selected.userId;
            console.log($scope.userId);
        }

        function getAllMyTailgates(userId) {
            TailgateService.getMyTailgates(userId).then(function (respData) {
                $scope.allMyTailgate = respData.data;
            });
        }

        $scope.addSupplyItems = function (supplyItemName, tailgateId, userId) {
            var checkedValue = document.querySelector('.supplyCheckbox:checked').value;
            console.log(checkedValue);
            TailgateService.addTailgateSupplyItems(supplyItemName, tailgateId, userId).then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
            });
        }

    }
})();

