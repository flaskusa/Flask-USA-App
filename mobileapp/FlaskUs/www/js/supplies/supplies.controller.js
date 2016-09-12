(function () {
    'use strict';
    angular.module('flaskApp')
    .controller('SuppliesCtrl', SuppliesCtrl);

    SuppliesCtrl.$inject = ['$scope', 'SupplyService', '$ionicModal','$location','$flaskUtil','$cookies','$state','$timeout'];

    /* @ngInject */
    function SuppliesCtrl($scope,  SupplyService, $ionicModal,$location,$flaskUtil,$cookies,$state,$timeout ) {

        $scope.counter = 0;
        $scope.counterArr=[];
        $scope.userDataList=[];
        $scope.supplies=[];
        if(SupplyService.addAsAdmin!=undefined){
            $scope.addAsAdmin=SupplyService.addAsAdmin;
        }else{
            $scope.addAsAdmin=false;
        }

        $scope.editList=false;
        $scope.addNewSupplies=false;
        $scope.islistCreated = false;
        $scope.deleteSuplies=false;
        $scope.editSuply=false;
        var userDetail=$cookies.getObject('CurrentUser');
        var userId=userDetail.data.userId;
        $scope.agreedToTermsOfUse=userDetail.data.agreedToTermsOfUse;
        $scope.addSupplyAsAdmin=function(){
            SupplyService.addAsAdmin=true;
            $scope.addAsAdmin=true;
        }
        $scope.addSupplyAsUser=function(){
            SupplyService.addAsAdmin=false;
            $scope.addAsAdmin=false;
        }
        SupplyService.getMySupplyList().then(function(response){
            $scope.supplies=response;
            $scope.getUserSupplieslength();
        });
        $scope.addNewSuppliesList=function(){
            setTimeout(setFocus, 50);
            function setFocus(){
                document.getElementById("supplyEdit").focus();
            }
        }
        $scope.saveList = function(list) {
            // $scope.listItem.unshift( $scope.createdListItem.data);

            if ($scope.islistCreated != true) {
                SupplyService.addSupplies(list,$scope.addAsAdmin).then(function(response){
                    if(response.userId>0) {

                    }else{
                        $flaskUtil.alert("failed to save");
                    }
                });
        }
            $scope.getSelectedLength();
            $scope.addNewSupplies=false;
            $scope.getUserSupplieslength();
        };
        $scope.goTOList=function(selectedList){
            if($scope.agreedToTermsOfUse==true && $scope.deleteSuplies==false &&  $scope.editSuply==false) {
                SupplyService.selectedList=selectedList;
                $state.go('app.suppliesList', {listName: selectedList.supplyListName})
            }
            $timeout(function () {  $scope.deleteSuplies=false;
            },1000);

        }
        $scope.editSupply=function(data){
            data.edit=true;
            $scope.deleteSuplies=true;
            $scope.editSuply=true;
            setTimeout(setFocus, 50);
     function setFocus(){
         if(data.isSystem==false){
    document.getElementById("editBox").focus();
        }else{
             document.getElementById("systemEditBox").focus();
         }
     }
    }
        $scope.editSupplyItem=function(data){
            data.editItem=true;
            setTimeout(setFocus, 50);
            function setFocus(){
                document.getElementById("supplyEdit").blur();
                document.getElementById("ItemEditBox").focus();
            }
        }

        $scope.cancelAdding=function(){
            $scope.addNewSupplies=false;
            document.getElementById("ItemEditBox").blur();
            $scope.suppliesName="";
        }
        $scope.saveSupply=function(data){
            if(data.listName!="") {
                $scope.deleteSuplies=false;
                $scope.editSuply=false;
                SupplyService.updateSupplyList(data.supplyListId,data.supplyListName,data.isSystem).then(function(response){
                    if(response.supplyListId>0){
                    data.edit = false;
                    }else{
                        $flaskUtil.alert("failed to update")
                    }
                });
            }else{
                if(data.isSystem==false) {
                    document.getElementById("editBox").focus();
                }else{
                    document.getElementById("systemEditBox").focus();
                }
            }
        }
        $scope.saveSupplyItem=function(data){
            if(data.itemName!="" && !data.supplyItemId) {
                document.getElementById("ItemEditBox").blur();
                SupplyService.addSupplyItem(data.itemName,$scope.createdListId).then(function(response){
                    if(response.supplyListId>0){
                        data.editItem = false;
                        data.supplyItemId=response.supplyItemId;
                        setTimeout(setFocusOnItemBox, 50);
                    }
                    else{
                        $flaskUtil.alert("failed to save Item");
                    }
                });

            }
            else if(data.itemName!="" && data.supplyItemId!=undefined) {
                SupplyService.updateSupplyItem($scope.createdListId,data.supplyItemId,data.itemName).then(function(response){
                    data.itemName=response.supplyItemName;
                    data.editItem = false;
                })
            }
            else{
                document.getElementById("ItemEditBox").focus();
            }
        }
        $scope.createdListItem={"data":
            []
        };
        $scope.deleteCreatedItem=function(index,id){
            SupplyService.deleteSupplyItemById(id).then(function(response){
                if(response){
                    $scope.createdListItem.data.splice(index,1);
                }
            });

        }
        var listItemEmpty={itemName: "",editItem:true}
        $scope.addItem=function(listName,data){
            if (listName == undefined || listName == "") {
                setTimeout(setFocus, 50);
            }else {
                SupplyService.addSupplies(listName, $scope.addAsAdmin).then(function (response) {
                    if (response.supplyListId > 0) {
                        $scope.islistCreated = true;
                        $scope.createdListId = response.supplyListId;
                        $scope.createItem(listName, data);
                    } else {
                        $flaskUtil.alert("failed to save");
                    }
                });
            }

            }
        $scope.createItem = function (listName,data) {
                if (listName == undefined || listName == "") {
                    setTimeout(setFocus, 50);
                }
                else if (data != undefined && data.itemName == "") {
                    setTimeout(setFocusOnItemBox, 50);
                }
                else {
                    $scope.createdListItem.data.push(angular.copy(listItemEmpty));

                }
        }

        function setFocusOnItemBox(){
            document.getElementById("ItemEditBox").focus();
        }
        function setFocus(){
            document.getElementById("supplyEdit").focus();
        };
        /*$scope.saveList = function (list) {
            HttpService.save(list);
            $scope.supplies.push(list);
            $scope.modal.hide();

        };*/

        // date field display options

        $scope.getSelectedLength=function(){
            $scope.thirdCounter=0;
            $scope.index=-1;
            angular.forEach($scope.supplies,function (value1, key){
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
            SupplyService.selectedList=selectedList;

        }
        $scope.opened = {};
        $scope.open = function ($event, id) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.opened[id] = true;
        };
        $scope.copyList=function(list){
            var list=angular.copy(list);
            list.isSystem=false;
            SupplyService.getItemByListId(list.supplyListId).then(function(response){
                $scope.itemValue=response;
            });
            SupplyService.addSupplies(list.supplyListName,list.isSystem).then(function(response1){
                if(response1.userId>0) {

                    var failed=false;
                    angular.forEach($scope.itemValue,function(value,key){
                        SupplyService.addSupplyItem(value.itemName,response1.supplyListId).then(function(response2){
                            if(response2.supplyListId<0){
                                failed=true;
                            }
                        });
                    });
                    if(failed==true){
                        $flaskUtil.alert("failed to copy")
                    }else{
                        $scope.supplies.push(list);
                    }
                    $scope.getSelectedLength($scope.supplies[0], 0);
                    $scope.getUserSupplieslength();
                }else{
                    $flaskUtil.alert("failed to copy");
                }
            });

        };
        $scope.editSupplies=function(){

         $scope.editList=!$scope.editList;
        }
        $scope.saveSupplies=function(){
            $scope.editList=!$scope.editList;
        }
        $scope.getUserSupplieslength=function(){
            $scope.secondCounter=0;
            angular.forEach( $scope.supplies, function (value, key) {
                if (value.isSystem == false)
                    $scope.secondCounter++;
            });
        }
        $scope.getUserSupplieslength();
        $scope.deleteItem=function(index,supplyId){
            $scope.deleteSuplies=true;
            SupplyService.deleteSupplyListById(supplyId).then(function(response){
                if(response){
                    $scope.supplies.splice(index,1);
                    $scope.getUserSupplieslength();
                    $scope.getSelectedLength();
                }
            })

        }
    }
})();
