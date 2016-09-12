(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('SupplyService', SupplyService);

    SupplyService.$inject = ['$http','SERVER','$q','$cookies'];

    function SupplyService($http, SERVER,$q,$cookies) {

    this.selectedList="";
    var services =  {
        getMySupplyList:getMySupplyList,
        getAllSupplyList:getAllSupplyList,
        addSupplies:addSupplies,
        addSupplyItem:addSupplyItem,
        getItemByListId:getItemByListId,
        deleteSupplyListById:deleteSupplyListById,
        updateSupplyList:updateSupplyList,
        updateSupplyItem:updateSupplyItem,
        deleteSupplyItemById:deleteSupplyItemById

    }
        this.selectedList={};
        this.addAsAdmin={};
        var url = SERVER.url;
        var getAllSupplyUrl="/flask-user-tailgate-portlet.supplylist/get-my-supply-lists"
        var getMySupplyUrl="/flask-user-tailgate-portlet.supplylist/get-my-supply-lists"
        var addSuppliesUrl="/flask-user-tailgate-portlet.supplylist/add-supply-list"
        var addSupplyItemUrl="/flask-user-tailgate-portlet.supplyitem/add-supply-item"
        var getItemByListId="/flask-user-tailgate-portlet.supplyitem/get-items-by-list-id"
        var deleteSupplyListUrl="/flask-user-tailgate-portlet.supplylist/delete-supply-list"
        var updateSupplyUrl="/flask-user-tailgate-portlet.supplylist/update-supply-list";
        var UpdateSupplyItemUrl="/flask-user-tailgate-portlet.supplyitem/update-supply-item";
        var deleteSupplyItemUrl="/flask-user-tailgate-portlet.supplyitem/delete-supply-item";
        function getMySupplyList() {
            return $http.get(url+getAllSupplyUrl,{params:{
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getAllSupplyList() {
            return $http.get(url+getMySupplyUrl,{params:{
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addSupplies(supplyListName,isSystem) {
            return $http.get(url+addSuppliesUrl,{params:{
                supplyListName: supplyListName,
                    isSystem: isSystem

            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addSupplyItem(supplyItemName,supplyListId) {
            return $http.get(url+addSupplyItemUrl,{params:{
                supplyItemName: supplyItemName,
                supplyListId: supplyListId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getItemByListId(supplyListId) {
            return $http.get(url+getItemByListId,{params:{
                supplyListId: supplyListId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteSupplyListById(supplyListId) {
            return $http.get(url+deleteSupplyListUrl,{params:{
                supplyListId: supplyListId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function updateSupplyList(supplyListId,supplyListName,isSystem) {
            return $http.get(url+updateSupplyUrl,{params:{
                supplyListId: supplyListId,
                supplyListName: supplyListName,
                isSystem: isSystem
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function updateSupplyItem(supplyListId,supplyItemId,supplyItemName) {
            return $http.get(url+UpdateSupplyItemUrl,{params:{
                supplyItemId: supplyItemId,
                supplyItemName: supplyItemName,
                supplyListId: supplyListId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteSupplyItemById(supplyItemId) {
            return $http.get(url+deleteSupplyItemUrl,{params:{
                supplyItemId: supplyItemId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
return services;updateSupplyItem
}
})();
