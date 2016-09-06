(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('GroupService', GroupService);

    GroupService.$inject = ['$http','SERVER','$q','$cookies'];

    function GroupService($http, SERVER,$q,$cookies) {
        var services =  {
            getAllGroups:getAllGroups,
            createGroup:createGroup,
            saveGroup:saveGroup,
            getAllGroupMember:getAllGroupMember,
            getMyFriendList:getMyFriendList,
            addUserToGroup:addUserToGroup,
            deleteGroup:deleteGroup,
            addGroupOwner:addGroupOwner,
            removeGroupOwner:removeGroupOwner,
            updateGroup:updateGroup,
            deleteGroupUser:deleteGroupUser,
            searchGroupMember:searchGroupMember
        }
        var url = SERVER.url;
        this.groupMemberDetail={};
        this.groupDetail={};
        this.groupAdminDetail={};
        var companyId = SERVER.companyId;
        var getAllGroups = "/flask-manage-user-group-portlet.flaskgroup/get-all-my-groups";
        var createGroup="/flask-manage-user-group-portlet.flaskgroup/add-group";
        var saveGroup="flask-manage-user-group-portlet.flaskgroupusers/add-group-user";
        var getAllGroupMember="/flask-manage-user-group-portlet.flaskgroupusers/get-all-group-users";
        var deleteGroupUrl="/flask-manage-user-group-portlet.flaskgroup/delete-group";
        var searchMyFriendList="/flask-social-portlet.entry/search-my-friends";
        var addGroupMember="/flask-manage-user-group-portlet.flaskgroupusers/add-group-user";
        var addGroupOwnerUrl="/flask-manage-user-group-portlet.flaskgroupusers/add-group-owner";
        var removeGroupOwnerUrl="/flask-manage-user-group-portlet.flaskgroupusers/remove-group-owner";
        var updateGroupUrl="/flask-manage-user-group-portlet.flaskgroup/update-group";
        var DeleteGroupUserUrl="/flask-manage-user-group-portlet.flaskgroupusers/delete-group-user";
        var searchFriendUrl="/flask-social-portlet.entry/search-my-friends";



        function getAllGroups(userId) {
            return $http.get(url+getAllGroups,{params:{
            "userId":userId
            }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function createGroup(groupName,description,createdBy) {
            return $http.get(url+createGroup,{params:{"groupName":groupName,
                "groupDescription":description,
                "isDelete":0,
                "isActive":1,
                "createdBy":createdBy,
                "groupId":0,
                "createdDate":new Date()}})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function saveGroup(groupId,userId) {
            return $http.get(url+saveGroup,{params:{"groupId":groupId,
                "emailAddress":"test@liferay.com",
                "userId":userId,
                "userName":"Joe Bloggs",
                "isAdmin":1}})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getAllGroupMember(groupId){
            return $http.get(url+getAllGroupMember,{params:{"groupId":groupId}})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteGroup(groupId){
            return $http.get(url+deleteGroupUrl,{params:{"groupId":groupId}})
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });

        }
        function getMyFriendList(){
            return $http.get(url+searchMyFriendList,{params:{"companyId":companyId,"keywords":""}})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });

        }

        function addUserToGroup(groupId,emailAddress,userId,userName,isAdmin){
            return $http.get(url+addGroupMember,{
                params:{
                    "groupId":parseInt(groupId),
                    "emailAddress":emailAddress,
                    "userId":parseInt(userId),
                    "userName":userName,
                    "isAdmin":isAdmin
                }
                }).then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });

        }
        function addGroupOwner(groupId,userId){
            return $http.get(url+addGroupOwnerUrl,{
                params:{
                    "groupId":groupId,
                    "userId":userId
                }
            }).then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });

        }
        function removeGroupOwner(groupId,userId){
            return $http.get(url+removeGroupOwnerUrl,{
                params:{
                    "groupId":groupId,
                    "userId":userId
                }
            }).then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });

        }
        function updateGroup(groupName,groupDescription,isDelete,isActive,createdBy,groupId,createdDate){
            return $http.get(url+updateGroupUrl,{params:{
                "groupName":groupName,
                "groupDescription":groupDescription,
                "isDelete":isDelete,
                "isActive":isActive,
                "createdBy":createdBy,
                "groupId":groupId,
                "createdDate":createdDate
            }
            }).then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });

        }
        function deleteGroupUser(groupId,userId){
            return $http.get(url+DeleteGroupUserUrl,{
                params:{"groupId":groupId,
                    "userId":userId}
            }).then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });
        }
        function searchGroupMember(keywords){
            return $http.get(url+searchFriendUrl,{
                params:{"companyId":companyId,"keywords":keywords}
            }).then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });
        }

        return services;

    }
})();