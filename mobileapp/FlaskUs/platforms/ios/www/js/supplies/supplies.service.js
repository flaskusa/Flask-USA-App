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
        deleteSupplyItemById:deleteSupplyItemById,
        addSupplyItems:addSupplyItems

    }
        this.selectedList={};
        this.addAsAdmin={};
        var getAllSupplyUrl="/flask-user-tailgate-portlet.supplylist/get-my-supply-lists"
        var getMySupplyUrl="/flask-user-tailgate-portlet.supplylist/get-my-supply-lists"
        var addSuppliesUrl="/flask-user-tailgate-portlet.supplylist/add-supply-list"
        var addSupplyItemUrl="/flask-user-tailgate-portlet.supplyitem/add-supply-item"
        var getItemByListIdURL="/flask-user-tailgate-portlet.supplyitem/get-items-by-list-id"
        var deleteSupplyListUrl="/flask-user-tailgate-portlet.supplylist/delete-supply-list"
        var updateSupplyUrl="/flask-user-tailgate-portlet.supplylist/update-supply-list";
        var UpdateSupplyItemUrl="/flask-user-tailgate-portlet.supplyitem/update-supply-item";
        var deleteSupplyItemUrl="/flask-user-tailgate-portlet.supplyitem/delete-supply-item";
        var addSuppliesItemsUrl="/flask-user-tailgate-portlet.supplyitem/add-supply-items"
        function getMySupplyList() {
            return $http.get(SERVER.url+getAllSupplyUrl,{params:{
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getAllSupplyList() {
            return $http.get(SERVER.url+getMySupplyUrl,{params:{
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addSupplies(supplyListName,isSystem) {
            return $http.get(SERVER.url+addSuppliesUrl,{params:{
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
            return $http.get(SERVER.url+addSupplyItemUrl,{params:{
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
            return $http.get(SERVER.url+getItemByListIdURL,{params:{
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
            return $http.get(SERVER.url+deleteSupplyListUrl,{params:{
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
            return $http.get(SERVER.url+updateSupplyUrl,{params:{
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
            return $http.get(SERVER.url+UpdateSupplyItemUrl,{params:{
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
            return $http.get(SERVER.url+deleteSupplyItemUrl,{params:{
                supplyItemId: supplyItemId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addSupplyItems(supplyListId,supplyItemNames) {
            return $http.get(SERVER.url+addSuppliesItemsUrl,{params:{
                supplyItemNames: [supplyItemNames],
                supplyListId: supplyListId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
return services;
}
})();
