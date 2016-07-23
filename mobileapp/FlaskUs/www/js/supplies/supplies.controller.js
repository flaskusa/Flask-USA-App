(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('SuppliesCtrl', SuppliesCtrl);

    SuppliesCtrl.$inject = ['$scope', 'HttpService', 'ServerDataModel', '$ionicModal'];

    /* @ngInject */
    function SuppliesCtrl($scope, HttpService, ServerDataModel, $ionicModal) {
        /* jshint validthis: true */
        // putting our server data on scope to display it for learning purposes
        $scope.dataModel = ServerDataModel;

        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });

        $scope.saveList = function (list) {
            console.log(list);
            HttpService.save(list);
            $scope.modal.hide();
        };

        // date field display options
        $scope.opened = {};
        $scope.open = function ($event, id) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.opened[id] = true;
        };
    }
})();
