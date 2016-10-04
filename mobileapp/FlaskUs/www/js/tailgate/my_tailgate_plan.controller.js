(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatePlanCtrl', mytailgatePlanCtrl);

    mytailgatePlanCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cookies', '$ionicModal'];

    /* @ngInject */
    function mytailgatePlanCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies, $ionicModal) {
        $scope.myTailgaters = [];
        var supplyItemName;
        $scope.itemUser = [], [];
        $scope.tailgateItems = [];
        $scope.myTailgateMember = [];
        $scope.tailgateSupplyItems = [];

        var tailGateId = $cookies.get('currtailGateId');
        getMyTailgate();
        getAllMyTailgates();
        getAllFriends();
        getTailgaters();
        displayUserName();
        getItems();
        $scope.userId = "";
        var itemArray;

        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        $scope.user = {
            supplyItemName: ['user']
        };

        function getTailgaters() {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                $scope.myTailgaters = respData.data;
                console.log("tailgaters");
                console.log($scope.myTailgaters);

                getAllFriends();
            });
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.myTailgate = respData.data;
            });
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
            console.log(user_selected);
            $scope.userId = data.itemAssignedUserId;
            TailgateService.updateTailgateSupplyItem(data.tailgateSupplyItemId, data.supplyListItemName, tailGateId, $scope.userId).then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
                console.log($scope.alltailgateSupplyItem);
                
            });
            $scope.selected_user = $scope.userId;
        }

        function displayUserName() {
            TailgateService.getItemsByTailgateId(tailGateId).then(function (respData) {
                $scope.tailgateItems = respData.data;
                
            });

            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                $scope.myTailgateMember = respData.data;
                for (var j = 0; j < $scope.tailgateItems.length;j++){
                    for (var i = 0; i < $scope.myTailgateMember.length; i++) {
                        if ($scope.myTailgateMember[i].userId == $scope.tailgateItems[j].itemAssignedUserId) {
                            $scope.itemUser.push({ itemName: $scope.tailgateItems[j].supplyListItemName, user: $scope.myTailgateMember[i].userName });
                        }
                    }   
                }
            });
            
            console.log($scope.itemUser);
        }

        //venmo Account pay now
        $scope.fnPayNow = function() {
            var tailgateId = $scope.myTailgate.tailgateId;
            var tailgateName = $scope.myTailgate.tailgateName;
            var tailgateAccount = $scope.myTailgate.venmoAccountId;
            var amountToPay = $scope.myTailgate.amountToPay;
            var paymentUrl = "https://venmo.com/?txn=pay&amount=" + amountToPay + "&note= for tailgate " + tailgateName +
            "&recipients=" + tailgateAccount;
            window.open(paymentUrl, '_system', 'location=yes'); // for inapp browser or system app
        }
    }
})();