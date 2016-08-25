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
        console.log("length of list item :" + ServerDataModel.data2.length);
        $scope.currListName = $stateParams.listName;

        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.saveList2 = function(list) {
            $scope.listValue.push({
                itemName: list.itemName
            });
            $scope.modal.hide();
            list.itemName="";
        };
        /*$scope.saveList2 = function (list) {
            HttpService.save2(list);
            $scope.modal.hide();
        };*/
    }
})();
