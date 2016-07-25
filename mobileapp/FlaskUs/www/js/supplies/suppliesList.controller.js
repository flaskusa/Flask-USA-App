(function () {
    'use strict';
    angular.module('flaskApp')

    .controller('SuppliesListCtrl', SuppliesListCtrl);

    SuppliesListCtrl.$inject = ['$scope', '$stateParams', 'HttpService', 'ServerDataModel', '$ionicModal', '$ionicNavBarDelegate'];

    function SuppliesListCtrl($scope, $stateParams, HttpService, ServerDataModel, $ionicModal, $ionicNavBarDelegate) {
        /* jshint validthis: true */
        // putting our server data on scope to display
        $scope.dataModel = ServerDataModel;
        
        var currListName = $stateParams.listName

        $ionicNavBarDelegate.title(currListName);

        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });

        $scope.saveList2 = function (list) {
            console.log(list);
            HttpService.save2(list);
            $scope.modal.hide();
        };
    }
})();
