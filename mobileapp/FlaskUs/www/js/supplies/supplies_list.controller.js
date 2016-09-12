(function () {
    'use strict';
    angular.module('flaskApp')

    .controller('SuppliesListCtrl', SuppliesListCtrl);

    SuppliesListCtrl.$inject = ['$scope', '$stateParams',  'SupplyService', '$ionicModal', '$ionicNavBarDelegate'];

    function SuppliesListCtrl($scope, $stateParams, SupplyService, $ionicModal, $ionicNavBarDelegate) {
        /* jshint validthis: true */
        // putting our server data on scope to display
        $scope.listId=SupplyService.selectedList.supplyListId;
        $scope.listItemName="";
        $scope.edit=false
        $scope.initialize=function() {
            SupplyService.getItemByListId($scope.listId).then(function (response) {
                $scope.listValue = response;
            });
        }
        $scope.addNewSuppliesItem=false;
        $scope.currListName = $stateParams.listName;

        $scope.saveItem = function(list) {
            if(list!=undefined||list!=undefined) {
                SupplyService.addSupplyItem(list, $scope.listId).then(function(response){
                    if(response.supplyListId>0){

                        $scope.listValue.push({
                            supplyItemName: response.supplyItemName,
                            supplyItemId:response.supplyItemId
                        });
                        $scope.addNewSuppliesItem = false;
                    }
                });

            }else{
                setTimeout(setFocus, 50);
            }
        };
        function setFocusOnAdd(){
            document.getElementById("addItemBox").focus();
        }
        $scope.editSupplyItem=function(data){
            if(data.edit==false) {
                data.edit = true;
                setTimeout(setFocus, 20);
            }
        }
        function setFocus(){
            document.getElementById("editItemBox").focus();
        }
        $scope.saveSupplyItem=function(data){
            if(data.supplyItemName!="") {
                SupplyService.updateSupplyItem($scope.listId,data.supplyItemId,data.supplyItemName).then(function(response){
                    data.itemName=response.supplyItemName;
                    data.edit = false;
                });
            }else{
                data.edit = true;
                setTimeout(setFocus, 50);
            }
        }
        $scope.deleteSupplyItem=function(index,id){
            SupplyService.deleteSupplyItemById(id).then(function(response){
                if(response){
                    $scope.listValue.splice(index,1);
                }
            });

        }
        $scope.addNewListItem=function(){
            $scope.addNewSuppliesItem=!$scope.addNewSuppliesItem
            if($scope.addNewSuppliesItem==true) {
                setTimeout(setFocusOnAdd, 50);
            }
        }
        $scope.cancelAdding=function(){
            $scope.addNewSuppliesItem=false;
        }
    }
})();
