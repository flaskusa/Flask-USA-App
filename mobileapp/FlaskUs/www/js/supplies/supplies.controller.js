(function () {
    'use strict';
    angular.module('flaskApp')
    .controller('SuppliesCtrl', SuppliesCtrl);

    SuppliesCtrl.$inject = ['$scope', 'HttpService', 'ServerDataModel', '$ionicModal'];

    /* @ngInject */
    function SuppliesCtrl($scope, HttpService, ServerDataModel, $ionicModal) {
        // putting our server data on scope to display it for learning purposes
        $scope.dataModel = ServerDataModel;
        console.log("length of list item :"+ServerDataModel.data2.length);

        $scope.data = ServerDataModel.data2;
        $scope.counter = 0;
        angular.forEach($scope.data, function (value, key) {
            console.log(key);
            if (value.checked == true)
                $scope.counter++;
        });

        $scope.List2count = ServerDataModel.data2.length;

        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });

        $scope.saveList = function (list) {
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
