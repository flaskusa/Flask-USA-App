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
        $scope.userInfo = [],[];

        var tailGateId = $cookies.get('currtailGateId');
        getMyTailgate();
        getAllMyTailgates();
        getAllFriends();
        getItems();

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

        $scope.addItemsInArray = function (selected_checkbox,id,data) {
            $scope.passItems.push(data.supplyItemName);
        }

        function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                $scope.myFriends = respData;
            })
        }

        function getAllMyTailgates(userId) {
            TailgateService.getMyTailgates(userId).then(function (respData) {
                $scope.allMyTailgate = respData.data;
            });
        }

        function getItems() {
            TailgateService.getItemsByTailgateId(tailGateId).then(function (respData) {
                $scope.allMyTailgateItems = respData.data;
            });
        }

        //Adding supply items to tailgate
        $scope.updateSupplyItems = function (data, user_selected) {
            $scope.userId = user_selected.userId;
            $scope.userName = user_selected.fullName;
            TailgateService.updateTailgateSupplyItem(data.tailgateSupplyItemId, data.supplyListItemName, tailGateId, $scope.userId).then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
            });
        }
        //venmo Account pay now
        $scope.fnPayNow = function() {
            var tailgateId = $scope.myTailgate.tailgateId;
            var tailgateName = $scope.myTailgate.tailgateName;
            var tailgateAccount = $scope.myTailgate.venmoAccountId;
            var amountToPay = $scope.myTailgate.amountToPay;
            var paymentUrl = "https://venmo.com/?txn=pay&amount=" + amountToPay + "&note= for tailgate " + tailgateName +
            "&recipients=" + tailgateAccount;
            window.open(paymentUrl, '_blank');
        }
    }
})();