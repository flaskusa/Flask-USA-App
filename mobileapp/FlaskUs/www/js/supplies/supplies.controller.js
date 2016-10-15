(function () {
    'use strict';
    angular.module('flaskApp')
    .controller('SuppliesCtrl', SuppliesCtrl);

    SuppliesCtrl.$inject = ['$scope', 'SupplyService', '$ionicModal','$location','$flaskUtil','$cookies','$state','$timeout','$ionicListDelegate','$stateParams','$localStorage','$ionicHistory'];

    /* @ngInject */
    function SuppliesCtrl($scope,  SupplyService, $ionicModal,$location,$flaskUtil,$cookies,$state,$timeout,$ionicListDelegate,$stateParams,$localStorage,$ionicHistory ) {

        $scope.userDataList=[];
        $scope.supplies=[];
        $scope.supplyItemNames=[];
        $scope.MyGameDaysSupply=[];
        $scope.hideItem=false;
        $scope.curreentEventId=$stateParams.currEventId;
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        var userDetail=$cookies.getObject('CurrentUser');
        if(userDetail!=undefined) {
            $scope.userId = userDetail.data.userId;
            $scope.hideCheckBox=false;
            $scope.agreedToTermsOfUse = userDetail.data.agreedToTermsOfUse;
        }else{
            $scope.userId=0;
            $scope.hideCheckBox=true
            $scope.agreedToTermsOfUse=false;
        }
        $scope.currentEventSuppplyKey=$scope.curreentEventId+$scope.userId;





        $scope.hideMyItem=false;
        if($stateParams.myListName==""){
         $scope.MyGameDayList=false;
        }else{
            $scope.MyGameDayList=true;
        }
        if(SupplyService.addAsAdmin!=undefined){
            $scope.addAsAdmin=SupplyService.addAsAdmin;
        }else{
            $scope.addAsAdmin=false;
        }
        $scope.showSelectedGameDaySupply=function(selectedSupplyId){
           angular.forEach($scope.supplies,function(value,key){
               if(value.supplyListId==selectedSupplyId){
                   value.checked=true;

               }

           })
        }
        $scope.selectGameDaySupplyItem=function(data){
            $localStorage[$scope.currentEventSuppplyKey].checkedItemsId.push(data.supplyItemId)
        }
        $scope.showSelectedSupplyListItem=function(){
            if($localStorage[$scope.currentEventSuppplyKey].checkedItemsId.length>0){
                angular.forEach($localStorage[$scope.currentEventSuppplyKey].checkedItemsId,function(value,key){
                   angular.forEach($scope.MyGameDaysSupply,function(value2,key2){
                       if(value==value2.supplyItemId){
                           value2.checked=true;
                       }
                   })
                });
            }
        }

        if(!$localStorage[$scope.currentEventSuppplyKey]) {
            $localStorage[$scope.currentEventSuppplyKey] = {checkedList: "", checkedItemsId:[]};
        }else if($scope.MyGameDayList==true){
            $scope.selectedGameDaySupplyId=$localStorage[$scope.currentEventSuppplyKey].checkedList

        }


        $scope.onSwipeLeft=function(data,index){
            /*data.swiped=true;
            $ionicListDelegate.showDelete();*/

        }
        $scope.onSwipeRight=function(data){
            /*data.swiped=false;
          $ionicListDelegate.closeOptionButtons();*/
        }



        $scope.toggleItem=function(){
            if($scope.MyGameDayList==true) {
                $scope.hideItem = !$scope.hideItem;
                $("#FlaskUsListdiv").slideToggle("slow", function () {
                });
            }
        }
        $scope.toggleMyItem=function(){
            if($scope.MyGameDayList==true){
            $scope.hideMyItem=!$scope.hideMyItem;
            $( "#myListdiv" ).slideToggle( "slow", function() {});
                }

        }
        $scope.editList=false;
        $scope.addNewSupplies=false;
        $scope.islistCreated = false;
        $scope.deleteSuplies=false;
        $scope.editSuply=false;

        $scope.addSupplyAsAdmin=function(){
            SupplyService.addAsAdmin=true;
            $scope.addAsAdmin=true;
        }

        $scope.addSupplyAsUser=function(){
            SupplyService.addAsAdmin=false;
            $scope.addAsAdmin=false;
        }
        $scope.getSupplyItemBySupplyId=function(supplyId) {
            SupplyService.getItemByListId(supplyId).then(function (response) {
                $scope.MyGameDaysSupply = response;
                $scope.showSelectedSupplyListItem();

                if ($scope.hideMyItem == false) {
                    $scope.toggleMyItem();
                }
                if ($scope.hideItem == false) {
                    $scope.toggleItem();
                }
            });
        }
        $scope.initialize=function() {
            SupplyService.getMySupplyList().then(function (response) {
                $scope.supplies = response;
                if($scope.MyGameDayList==true && $scope.selectedGameDaySupplyId!="" &&  $scope.hideCheckBox==false &&  $scope.selectedGameDaySupplyId!=undefined){
                    $scope.showSelectedGameDaySupply($scope.selectedGameDaySupplyId);
                    $scope.getSupplyItemBySupplyId($scope.selectedGameDaySupplyId);
                    $scope.toggleMyItem();
                    $scope.toggleItem();

                }
            });
        }

        $scope.copyForMyGameDaySupply=function(list){
            $scope.MyGameDaysSupply=[];
            angular.forEach($scope.supplies,function(value,key){
                if(value.supplyListId==list.supplyListId){
                    value.checked=true;
                    $localStorage[$scope.currentEventSuppplyKey].checkedList=value.supplyListId;


                }else{
                    value.checked=false;
                }
            });
            $localStorage[$scope.currentEventSuppplyKey].checkedItemsId=[];
            $scope.getSupplyItemBySupplyId(list.supplyListId);



        }
        $scope.removeSelectedSupply=function(list){
                    $scope.MyGameDaysSupply=[];
            $localStorage[$scope.currentEventSuppplyKey] = {checkedList: "", checkedItemsId:[]};

        }
        $scope.selectGameDaySupply=function(list,checked){
         if(checked==true){
             $scope.copyForMyGameDaySupply(list);
         }else{
             $scope.removeSelectedSupply(list);
         }
        }
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

            $scope.addNewSupplies=false;
        };
        $scope.goTOList=function(selectedList){
            if($scope.MyGameDayList==false) {
                if ($scope.agreedToTermsOfUse == true && $scope.deleteSuplies == false && $scope.editSuply == false && selectedList.isSystem == true) {
                    SupplyService.selectedList = selectedList;
                    $state.go('app.suppliesList', {listName: selectedList.supplyListName})
                } else if (selectedList.isSystem == false && $scope.editSuply == false) {
                    SupplyService.selectedList = selectedList;
                    $state.go('app.suppliesList', {listName: selectedList.supplyListName})
                }
                $timeout(function () {
                    $scope.deleteSuplies = false;
                }, 1000);
            }

        }
        $scope.editSupply=function(data){
            data.edit=true;
            $scope.deleteSuplies=true;
            $scope.editSuply=true;
            $ionicListDelegate.closeOptionButtons();
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
        $scope.setFocusSupply=function(){
            setTimeout(setFocus,50);
        }
        $scope.saveSupplyItem=function(data){
            if(data.itemName!="" && !data.supplyItemId) {
                document.getElementById("ItemEditBox").blur();
                SupplyService.addSupplyItem(data.itemName,$scope.createdListId).then(function(response){
                    if(response.supplyListId>0){
                        data.editItem = false;
                        data.supplyItemId=response.supplyItemId;
                        if($scope.createdListItem.data[$scope.createdListItem.data.length-1].itemName=="") {
                            setTimeout(setFocusOnItemBox, 50);
                        }
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
            $scope.supplyItemNames=[];
            list.isSystem=false;
            SupplyService.getItemByListId(list.supplyListId).then(function(response){
                $scope.itemValue=response;
            });
            SupplyService.addSupplies(list.supplyListName,list.isSystem).then(function(response1){
                if(response1.userId>0) {

                    var failed=false;
                    angular.forEach($scope.itemValue,function(value,key){
                        $scope.supplyItemNames.push(value.supplyItemName);

                    });
                    SupplyService.addSupplyItems(response1.supplyListId,$scope.supplyItemNames).then(function(response2){
                        if(response2.supplyListId<0 || response2.supplyListId==undefined ){
                            failed=true;
                        }
                    });
                    if(failed==true){
                        $flaskUtil.alert("failed to copy");
                    }else{
                        $scope.supplies.push(list);
                    }

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

        $scope.deleteItem=function(index,supplyId){
            $scope.deleteSuplies=true;
            SupplyService.deleteSupplyListById(supplyId).then(function(response){
                if(response){
                    $ionicListDelegate.closeOptionButtons();
                    $scope.supplies.splice(index,1);

                }
            })

        }
    }

})();
