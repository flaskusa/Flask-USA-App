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
            $scope.listValue.unshift({
                itemName: list
            });
            $scope.addNewSuppliesItem=false;
            list.itemName="";

        };
        $scope.addNewListItem=function(){
            $scope.addNewSuppliesItem=!$scope.addNewSuppliesItem
        }
        $scope.cancelAdding=function(){
            $scope.addNewSuppliesItem=false;
            $scope.listItemName="";
        }
        /*$scope.saveList2 = function (list) {
            HttpService.save2(list);
            $scope.modal.hide();
        };*/
    }
})();
