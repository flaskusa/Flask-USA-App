(function () {
    'use strict';
    angular.module('flaskApp')
    .controller('SuppliesCtrl', SuppliesCtrl);

    SuppliesCtrl.$inject = ['$scope', 'HttpService', 'ServerDataModel', '$ionicModal','$location'];

    /* @ngInject */
    function SuppliesCtrl($scope, HttpService, ServerDataModel, $ionicModal,$location) {
        // putting our server data on scope to display it for learning purposes
        $scope.dataModel = ServerDataModel;
        $scope.data = ServerDataModel.data;
        $scope.counter = 0;
        $scope.counterArr=[];
        $scope.userDataList=[];
        $scope.editList=false;

        $scope.List2count = ServerDataModel.data2.length;
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.saveList = function(list) {
            $scope.dataModel.data.push({
                listName: list.listName,
                isSystemProvided:0,
                listItem:[]
            });
            $scope.modal.hide();
            list.listName="";
        };
        /*$scope.saveList = function (list) {
            HttpService.save(list);
            $scope.dataModel.data.push(list);
            $scope.modal.hide();

        };*/

        // date field display options
        $scope.getSelectedLength=function(data,index){
            $scope.counter=0;
            angular.forEach(data.listItem, function (value, key) {
                console.log(key);
                if (value.checked == true)
                    $scope.counter++;
            });
            $scope.counterArr[index]=$scope.counter;
        }
        $scope.setListId=function(selectedList){
            ServerDataModel.selectedList=selectedList;

        }
        $scope.opened = {};
        $scope.open = function ($event, id) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.opened[id] = true;
        };
        $scope.copyList=function(list){
            var list=angular.copy(list);
            list.isSystemProvided=0;
            $scope.dataModel.data.push(list);
        };
        $scope.editSupplies=function(){
         $scope.editList=!$scope.editList;
        }
        $scope.saveSupplies=function(){
            $scope.editList=!$scope.editList;
        }

        $scope.deleteItem=function(index){
            $scope.deleteSuplies=true;
            $scope.data.splice(index,1);
        }
    }
})();
