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

        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.saveList2 = function(list) {
            if(list!=undefined||list!=undefined) {
                $scope.listValue.unshift({
                    itemName: list
                });
                $scope.addNewSuppliesItem = false;
            }
            else{
                setTimeout(setFocus, 500);
            }
        };
        function setFocus(){
            document.getElementById("addItemBox").focus();
        }
        $scope.getListcount=function(data){
            $scope.saveSupplyItem(data);
            }
        $scope.editSupplyItem=function(data){
            data.edit=true;
            setTimeout(setFocus, 1000);
            function setFocus(){
                document.getElementById("editItemBox").focus();
            }
        }
        $scope.saveSupplyItem=function(data){
            if(data.itemName!="") {
                data.edit = false;
            }else{
                data.edit = true;
            }
        }
        $scope.addNewListItem=function(){
            $scope.addNewSuppliesItem=!$scope.addNewSuppliesItem
            if($scope.addNewSuppliesItem==true) {
                setTimeout(setFocus, 500);
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
