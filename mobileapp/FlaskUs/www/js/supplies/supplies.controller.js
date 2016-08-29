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
        $scope.addNewSupplies=false;
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.addNewSuppliesList=function(){
            $scope.addNewSupplies=!$scope.addNewSupplies;
        }
        $scope.saveList = function(list) {
            $scope.dataModel.data.unshift({
                listName: list,
                isSystemProvided:0,
                listItem:[]
            });
            $scope.getSelectedLength();
            $scope.addNewSupplies=false;
            $scope.getUserSupplieslength();
        };
        $scope.editSupply=function(data){
            data.edit=true;
            setTimeout(setFocus, 1000);
     function setFocus(){
    document.getElementById("editBox").focus();
        }
    }
        $scope.cancelAdding=function(){
            $scope.addNewSupplies=false;
            $scope.suppliesName="";
        }
        $scope.saveSupply=function(data){
            data.edit=false;
        }
        /*$scope.saveList = function (list) {
            HttpService.save(list);
            $scope.dataModel.data.push(list);
            $scope.modal.hide();

        };*/

        // date field display options

        $scope.getSelectedLength=function(){
            $scope.thirdCounter=0;
            $scope.index=-1;
            angular.forEach($scope.dataModel.data,function (value1, key){
                $scope.index++;
           if(value1.isSystemProvided==0) {
               $scope.counter = 0;
               angular.forEach(value1.listItem, function (value2, key) {
                   if (value2.checked == true)
                       $scope.counter++;
               });
               $scope.counterArr[$scope.index] = $scope.counter;
               $scope.thirdCounter++;
           }
           })
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
            $scope.dataModel.data.unshift(list);
            $scope.getSelectedLength($scope.dataModel.data[0],0);
            $scope.getUserSupplieslength();
        };
        $scope.editSupplies=function(){
         $scope.editList=!$scope.editList;
        }
        $scope.saveSupplies=function(){
            $scope.editList=!$scope.editList;
        }
        $scope.getUserSupplieslength=function(){
            $scope.secondCounter=0;
            angular.forEach($scope.data, function (value, key) {
                if (value.isSystemProvided == 0)
                    $scope.secondCounter++;
            });
        }
        $scope.getUserSupplieslength();
        $scope.deleteItem=function(index){
            $scope.deleteSuplies=true;
            $scope.data.splice(index,1);
            $scope.getUserSupplieslength();
            $scope.getSelectedLength();
        }
    }
})();
