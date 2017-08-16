(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatePlanCtrl', mytailgatePlanCtrl);

    mytailgatePlanCtrl.$inject = ['$scope', '$state', '$stateParams', 'TailgateService', '$cookies', '$ionicModal', '$ionicLoading', '$ionicPopup', '$timeout'];

    /* @ngInject */
    function mytailgatePlanCtrl($scope, $state, $stateParams, TailgateService, $cookies, $ionicModal, $ionicLoading, $ionicPopup, $timeout) {
        $scope.myTailgaters;
        var supplyItemName;
        $scope.tailgateItems = [];
        $scope.myTailgateMember = [];
        $scope.tailgateSupplyItems = [];
        $scope.isTailgateAdmin = false;
        var tailGateId = $cookies.get('currtailGateId');
        $scope.taigateSupplyList = [];
        var tailgateId = $cookies.get("currtailGateId");
        $scope.copytTailgateId = tailGateId;
        var userDetail = $cookies.getObject('CurrentUser');
        $scope.loggedInUserId = userDetail.data.userId;
        $scope.curritemAssignedUserName = userDetail.data.firstName + " " + userDetail.data.lastName;
        $scope.curritemAssignedUserId = JSON.stringify(userDetail.data.userId);
        $scope.currusercompanyId = userDetail.data.companyId;
        var itemArray;
        
        $scope.userId = "";
        $scope.goBack = function () {
            $timeout(function () {
                $state.go("app.my_tailgate");
            }, 1000);
        }

        $scope.user = {
            supplyItemName: ['user']
        };

        function getTailgaters() {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                $scope.myTailgaters = respData.data;
               getItems();
            });
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.myTailgate = respData.data;
            });
        }


        // function getAllMyTailgates(userId) {
        //     TailgateService.getMyTailgates(userId).then(function (respData) {
        //         $scope.allMyTailgate = respData.data;
        //     });
        // }

        function getItems() {
            TailgateService.getItemsByTailgateId(tailGateId).then(function (respData) {
                $scope.allMyTailgateItems = respData.data;
                setMyTailGateItems();
            });
        }
        function setMyTailGateItems(){
            angular.forEach($scope.allMyTailgateItems,function(val,index){
            val.itemAssignedUserId = val.itemAssignedUserId+"";
            val.supplyListItemName = decodeURIComponent(val.supplyListItemName);
            val.itemAssignedUserName = getUserNameById(val.itemAssignedUserId);
            })
        }

        $scope.isUserTailgateAdmin = function (tailGateId) {
            TailgateService.isUserTailgateAdmin(tailGateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };

        $scope.isUserTailgateAdmin(tailGateId);

        //for editing plan now page on tab
        $scope.goToPlanNowTab = function () {
            //add cookie data for editing particular page on tab.
            $cookies.putObject("tabtoEdit", [3,'planNowTab']);
            checkTailgateId();            
        }

        function checkTailgateId() {
            if (!tailGateId) {
            }
            else {
                //getting the data for editing the tailgate       
                editTailgate(tailGateId);         
            }
        }

        function editTailgate(tailGateId) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                //console.log("console.log(respData.data);");
                //console.log(respData.data);
                $cookies.putObject("editUserTailgate", respData.data);     
                $state.go("app.add_my_tailgate");
            });
        }

        function getUserNameById(userId) {
            var userName = "";
            angular.forEach($scope.myTailgaters,function(val,idx){
                if(val.userId == userId) {
                    userName = val.userName;
                    return false;
                }
                }
            )
            return userName;
        }
        //Adding supply items to tailgate
        $scope.updateSupplyItems = function (data, user_selected) {
            //console.log(user_selected);
            $scope.userId = user_selected;
            TailgateService.updateTailgateSupplyItem(data.tailgateSupplyItemId, data.supplyListItemName, tailGateId, $scope.userId).then(function (respData) {
            });
        };

        //venmo Account pay now
        $scope.fnPayNow = function() {
            var tailgateId = $scope.myTailgate.tailgateId;
            var tailgateName = $scope.myTailgate.tailgateName;
            var tailgateAccount = $scope.myTailgate.venmoAccountId;
            var amountToPay = $scope.myTailgate.amountToPay;
            var paymentUrl = "https://venmo.com/?txn=pay&amount=" + amountToPay + "&note= for tailgate " + tailgateName +
            "&recipients=" + tailgateAccount;
            window.open(paymentUrl, '_system', 'location=yes'); // for inapp browser or system app
        };

        //for editing tailgate on view screen
        $scope.selectedSupplyListItems = [];
        $scope.showEditForm = function () {
            $("#editSupplyListItems").show();
            $("#showSupplyListItems").hide()
        }

        $scope.selectGameDaySupply = function (list, checked) {
            if (checked == true) {
                $scope.collapsedItems = false;
                $scope.taigateSupplyList = list;
                $scope.copyForMyGameDaySupply(list);
                $scope.addNewTailgateSuppliesItem = true;
            } else {
                $scope.removeSelectedSupply(list);
            }
        }
        /*Save supply Item in selected supply List */
        var currSuppliedItemId;
        $scope.saveTailgateSupplyItem = function (listItemName) {
            if (listItemName != undefined && listItemName != "") {
                if ($scope.taigateSupplyList.supplyListId > 0) {
                    TailgateService.addSupplyItem(listItemName, $scope.taigateSupplyList.supplyListId).then(function (response) {
                        $scope.allMyTailgateItems.push({
                            supplyListItemName: response.supplyListItemName,
                            tailgateSupplyItemId: response.tailgateSupplyItemId
                        });
                        $scope.addNewSuppliesItem = false;
                    });
                }
                else {
                    TailgateService.addTailgateSupplyItem(listItemName, tailGateId, $scope.loggedInUserId).then(function (response) {
                        $scope.allMyTailgateItems.push({
                            supplyListItemName: response.supplyListItemName,
                            tailgateSupplyItemId: response.tailgateSupplyItemId
                        });
                        currSuppliedItemId=response.tailgateSupplyItemId;
                    });
                }
                $ionicLoading.show({ template: listItemName + ' Suppy item added', noBackdrop: false, duration: 2000 });
                setTimeout(function () {
                    TailgateService.updateTailgateSupplyItem(currSuppliedItemId, listItemName, tailGateId, $scope.loggedInUserId).then(function (respData) {
                        var currUserId = $scope.allMyTailgateItems.length-1;                        
                        $scope.allMyTailgateItems[currUserId].itemAssignedUserId = JSON.stringify(respData.data.itemAssignedUserId);
                        $scope.allMyTailgateItems[currUserId].itemAssignedUserName = $scope.curritemAssignedUserName
                        $ionicLoading.show({ template: '' + listItemName.toUpperCase()+ ' assigned to ' + $scope.curritemAssignedUserName + '', noBackdrop: false, duration: 3000 });
                        $("#addTailgateSupplyItemBox").val("");
                        $scope.showEditForm();
                });
                }, 2000);       
            }
            else {
                $ionicLoading.show({ template: 'Item name should not be empty', noBackdrop: false, duration: 2000 });
            }
        }

        /*on cancel of supply list on view tailgate page*/
        $scope.cancelTailgateSupplyItemAdding = function () {
            $scope.addNewSuppliesItem = false;
            $("#addTailgateSupplyItemBox").val("");
            $("#editSupplyListItems").hide();
            $("#showSupplyListItems").show()
        }

        /*on update of supply list on view tailgate page*/
        $scope.updateSupplyItemsUser = function (data, index) {
            TailgateService.updateTailgateSupplyItem(data.tailgateSupplyItemId, data.supplyListItemName, tailGateId, data.itemAssignedUserId).then(function (respData) {
                var assigneduserName='';
                for (var u = 0; u < $scope.myTailgaters.length; u++) {
                    if ($scope.myTailgaters[u].userId == respData.data.itemAssignedUserId)
                        assigneduserName = $scope.myTailgaters[u].userName;
                }
                $ionicLoading.show({ template: '' + data.supplyListItemName.toUpperCase() + ' assigned to ' + assigneduserName + '', noBackdrop: false, duration: 3000 });
            });
        }

        /*on delete of supply list item on view tailgate page*/
        $scope.leaveSupplyItem = function (supplyItemId, index) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Supply Item?'
            });
            confirmPopup.then(function (res) {
                if (res) {
                    TailgateService.deleteTailgateSupplyItem(supplyItemId).then(function (respData) {
                        $scope.allMyTailgateItems.splice(index, 1);
                    });

                } else {
                }
            });
        }

        //Adding supply items to tailgate
        $scope.addSupplyItems = function () {
            var str = [];
            var replaceStr;
            $scope.items = [];
            angular.forEach($scope.allMyTailgateItems, function (val, idx) {
                var tempItemName;
                tempItemName = val.supplyListItemName;
                $scope.items.push(tempItemName);
            })
            for (var i = 0; i < $scope.items.length; i++) { 
                    str.push($scope.items[i]);
            }
            itemArray = JSON.stringify(str);
            // var tailgateId = $cookies.get("currtailGateId");
            TailgateService.addTailgateSupplyItems(itemArray, tailGateId, "-1").then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
                $scope.associateUserWithSupplyItem();
            });

        }

        $scope.associateUserWithSupplyItem = function () {
            angular.forEach($scope.alltailgateSupplyItem, function (value, index) {
                //console.log(value.itemAssignedUserId);
                value.itemAssignedUserId = getAssigenUserId(decodeURIComponent(value.supplyListItemName));
                $scope.updateSupplyItems(value);
            })
            $("#editSupplyListItems").hide();
            $("#showSupplyListItems").show()
            getTailgaters();
        };

        function getAssigenUserId(supplyItemName) {
            var userId;
            angular.forEach($scope.selectedSupplyListItems, function (value, idx) {
                if (value.itemAssignedUserId > 0 && supplyItemName == value.supplyItemName) {
                    userId = value.itemAssignedUserId;
                    return;
                    // $scope.updateSupplyItems(val);
                }
            })
            return userId;
        }
        getMyTailgate();
        // getAllMyTailgates();
        getTailgaters();
    }
})();