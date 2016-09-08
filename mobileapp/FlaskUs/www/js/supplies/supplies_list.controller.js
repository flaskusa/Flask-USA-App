(function () {
    'use strict';
    angular.module('flaskApp')

    .controller('SuppliesListCtrl', SuppliesListCtrl);

    SuppliesListCtrl.$inject = ['$scope', '$stateParams', 'HttpService', 'ServerDataModel', '$ionicModal', '$ionicNavBarDelegate'];

    function SuppliesListCtrl($scope, $stateParams, HttpService, ServerDataModel, $ionicModal, $ionicNavBarDelegate) {
        /* jshint validthis: true */
        // putting our server data on scope to display
        $scope.dataModel = ServerDataModel;
        $scope.listValue=ServerDataModel.selectedList.listItem;
        $scope.addNewSuppliesItem=false;

        $scope.currListName = $stateParams.listName;

        $scope.saveList2 = function(list) {
            if(list!=undefined||list!=undefined) {
                $scope.listValue.unshift({
                    itemName: list
                });
                $scope.addNewSuppliesItem = false;
            }else{
                setTimeout(setFocus, 50);
            }
        };
        function setFocusOnAdd(){
            document.getElementById("addItemBox").focus();
        }
        $scope.getListCount=function(data,index){
            data.checked=!data.checked;
            if(data.edit==true) {
                $scope.saveSupplyItem(data);
            }
            }
        $scope.editSupplyItem=function(data){
            data.edit=true;
            setTimeout(setFocus, 50);

        }
        function setFocus(){
            document.getElementById("editItemBox").focus();
        }
        $scope.saveSupplyItem=function(data){
            if(data.itemName!="") {
                data.edit = false;
            }else{
                data.edit = true;
                setTimeout(setFocus, 50);
            }
        }
        $scope.deleteSupplyItem=function(index){
            $scope.listValue.splice(index,1);
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
        /*$scope.saveList2 = function (list) {
            HttpService.save2(list);
            $scope.modal.hide();
        };*/
    }
})();
