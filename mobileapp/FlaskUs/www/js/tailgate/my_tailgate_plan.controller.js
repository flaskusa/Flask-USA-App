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
        $scope.items = [];

        var tailGateId = $cookies.get('currtailGateId');
        getMyTailgate();
        getMySupplyList();
        getAllMyTailgates();
        getAllFriends();

        var itemArray;

        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        $scope.user = {
            supplyItemName: ['user']
        };

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.myTailgate = respData.data;
            });
        }

        //list of supplies
        function getMySupplyList(selected1) {
            TailgateService.getMySupplyLists().then(function (respData) {
                $scope.allSupplyList = respData.data;
                for (var i = 0; i < $scope.allSupplyList.length; i++) {
                    $scope.tailgateSupplyList.push({ supplyListName: $scope.allSupplyList[i].supplyListName, supplyListsId: $scope.allSupplyList[i].supplyListId });
                }
            });
        }

        //getting supply items
        $scope.getSupplyItem = function (selected) {
            supplyListstId = selected.supplyListsId;
            TailgateService.getItemsbylistid(supplyListstId).then(function (respData) {
                $scope.supplyItemList = respData.data;
            });

        }

        $scope.addItemsInArray = function (selected_checkbox,id,data) {
            $scope.passItems.push(data.supplyItemName);
        }

        function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                $scope.myFriends = respData;
            })
        }

        $scope.getUserId = function (user_selected) {
            $scope.userId = user_selected.userId;
        }

        function getAllMyTailgates(userId) {
            TailgateService.getMyTailgates(userId).then(function (respData) {
                $scope.allMyTailgate = respData.data;
            });
        }

        //Adding supply items to tailgate
        $scope.addSupplyItems = function () {
            itemArray = $scope.passItems.toString();
            TailgateService.addTailgateSupplyItems(itemArray, tailGateId, $scope.userId).then(function (respData) {
               $scope.alltailgateSupplyItem = respData.data;
            });  
        }

    }
})();

