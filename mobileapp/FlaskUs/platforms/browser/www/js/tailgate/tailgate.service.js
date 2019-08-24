(function () {
    'use strict';

    angular
        .module('flaskApp')
        .service('TailgateService', TailgateService);
    angular
        .module('flaskApp').directive('validNumber', function () {
            return {
                require: '?ngModel',
                link: function (scope, element, attrs, ngModelCtrl) {
                    if (!ngModelCtrl) {
                        return;
                    }

                    ngModelCtrl.$parsers.push(function (val) {
                        if (angular.isUndefined(val)) {
                            var val = '';
                        }

                        var clean = val.replace(/[^-0-9\.]/g, '');
                        var negativeCheck = clean.split('-');
                        var decimalCheck = clean.split('.');
                        if (!angular.isUndefined(negativeCheck[1])) {
                            negativeCheck[1] = negativeCheck[1].slice(0, negativeCheck[1].length);
                            clean = negativeCheck[0] + '-' + negativeCheck[1];
                            if (negativeCheck[0].length > 0) {
                                clean = negativeCheck[0];
                            }

                        }

                        if (!angular.isUndefined(decimalCheck[1])) {
                            decimalCheck[1] = decimalCheck[1].slice(0, 2);
                            clean = decimalCheck[0] + '.' + decimalCheck[1];
                        }

                        if (val !== clean) {
                            ngModelCtrl.$setViewValue(clean);
                            ngModelCtrl.$render();
                        }
                        return clean;
                    });

                    element.bind('keypress', function (event) {
                        if (event.keyCode === 32) {
                            event.preventDefault();
                        }
                    });
                }
            };
        });
    
    TailgateService.$inject = ['$http', 'SERVER', '$q','$flaskUtil', '$state'];
    function TailgateService($http, SERVER, $q, $flaskUtil, $state) {
        var allTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/add-tailgate-info";
        var myTailgatesURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-my-tailgate";
        var getTailgateImagesURL = "flask-user-tailgate-portlet.tailgateimages/get-tailgate-images";
        var getTailGateURL = "flask-user-tailgate-portlet.tailgateinfo/get-tailgate";
        var geteventURL = "flask-rest-events-portlet.event/get-event";
        var getTalgetUsersURL = "flask-user-tailgate-portlet.tailgateusers/get-tailgate-members";
        var addtailgateUserURL = "flask-user-tailgate-portlet.tailgateusers/add-tailgate-user";
        var getVenuebyVenueIdURL = "flask-rest-events-portlet.venue/get-venue";
        var getAllEventsURL = "flask-rest-events-portlet.event/get-all-events";
        var getmapMarkersURL = "flask-user-tailgate-portlet.tailgatemarker/get-tailgate-marker";
        var addTialgateMarkerURL = "flask-user-tailgate-portlet.tailgatemarker/add-tailgate-marker";
        var inviteFriendsTailgateURL = "flask-social-portlet.entry/search-my-friends";
        var addMessageBoardURL = "flask-user-tailgate-portlet.tailgatemessageboard/add-message-board";
        var getmessageBoardsByTailgateIdURL = "flask-user-tailgate-portlet.tailgatemessageboard/get-message-boards-by-tailgate-id";
        var getUserByIdURL = "flask-rest-users-portlet.flaskadmin/get-user-by-id";
        var getFilteredEventsURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var deleteTailgateInfoURL = "flask-user-tailgate-portlet.tailgateinfo/delete-tailgate-info";
        var deleteTailgateMarkerURL = "flask-user-tailgate-portlet.tailgatemarker/delete-tailgate-marker";
        var deleteTailgateUserIdURL = "flask-user-tailgate-portlet.tailgateusers/delete-tailgate-user";
        /*Supply List Services*/
        var getMySupplyListsURL = "flask-user-tailgate-portlet.supplylist/get-my-supply-lists";
        var getItemsbylistidURL = "flask-user-tailgate-portlet.supplyitem/get-items-by-list-id";
        var getSupplyListURL = "flask-user-tailgate-portlet.supplylist/get-supply-list";
        /*User group services*/
        var getGroupListURL = "flask-manage-user-group-portlet.flaskgroup/get-all-groups";
        var getGroupUsersURL = "flask-manage-user-group-portlet.flaskgroupusers/get-all-group-users";
        var getGroupByUserIdURL = "flask-manage-user-group-portlet.flaskgroup/get-my-groups";
        /*Get My Tailgate Service*/
        //var getAllTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-tailgate";
        var addTailgateSupplyItemsURL = "flask-user-tailgate-portlet.tailgatesupplyitem/add-tailgate-supply-items";
        var addTailgateSupplyItemURL = "flask-user-tailgate-portlet.tailgatesupplyitem/add-tailgate-supply-item";
        var updateTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/update-tailgate-info";
        /*Add Supply List*/
        var addSupplyListURL = "flask-user-tailgate-portlet.supplylist/add-supply-list";
        var getItemsByTailgateIdURL = "flask-user-tailgate-portlet.tailgatesupplyitem/get-items-by-tailgate-id";
        var updateTailgateSupplyItemURL = "flask-user-tailgate-portlet.tailgatesupplyitem/update-tailgate-supply-item";
        //var checkTailgateUserExist = '/flask-user-tailgate-portlet.tailgateusers/check-tailgate-user-exist';
        var isTailgateAdminURL = 'flask-user-tailgate-portlet.tailgateusers/is-tailgate-admin';
        var getTailgateLogoURL = 'flask-user-tailgate-portlet.tailgateinfo/get-tailgate-logo';
        var removeTailgateLogoURL = 'flask-user-tailgate-portlet.tailgateinfo/delete-tailgate-logo';
        var deleteTailgateImageURL = '/flask-user-tailgate-portlet.tailgateimages/delete-tailgate-image-by-tailgate-image-id';
        var deleteTailgateUserUrl = '/flask-user-tailgate-portlet.tailgateusers/delete-tailgate-user';
        var copyTailgateURL = 'flask-user-tailgate-portlet.tailgateinfo/copy-tailgate';
        var addTailgateAdminURL = 'flask-user-tailgate-portlet.tailgateusers/update-tailgate-user-role';
        var deleteTailgateSupplyItemURL = "/flask-user-tailgate-portlet.tailgatesupplyitem/delete-tailgate-supply-item";
        var addSupplyItemUrl = "/flask-user-tailgate-portlet.supplyitem/add-supply-item";
        //get current tailgate all details
        var getallDataofCurrentTailgateUrl = "/flask-user-tailgate-portlet.tailgateinfo/get-tailget-details";

        var tailgateServices = {
            getEvent: getEvent,
            getAllTailgate: getAllTailgate,
            getMyTailgates: getMyTailgates,
            getTailgate: getTailgate,
            getMyTailgateImages: getMyTailgateImages,
            getMyTailgateUsers: getMyTailgateUsers,
            addTailgate: addTailgate,
            getallEvents: getallEvents,
            getMapMarkers: getMapMarkers,
            addTailgateMarkers: addTailgateMarkers,
            getUserFrends: getUserFrends,
            addcurrentUser: addcurrentUser,
            getvenueDetails: getvenueDetails,
            saveMessage: saveMessage,
            getAllMessages: getAllMessages,
            getAllUser: getAllUser,
            getallFilteredEvents: getallFilteredEvents,
            deleteMapMarkers: deleteMapMarkers,
            deleteTailgate: deleteTailgate,
            getMySupplyLists: getMySupplyLists,
            getSupplyList: getSupplyList,
            getItemsbylistid: getItemsbylistid,
            getGroupList: getGroupList,
            getGroupUsers: getGroupUsers,
            addTailgateSupplyItems: addTailgateSupplyItems,
            getGroupbyId: getGroupbyId,
            getItemsByTailgateId: getItemsByTailgateId,
            updateTailgateSupplyItem: updateTailgateSupplyItem,
            updateTailgateInfo: updateTailgateInfo,
            getTailgateLogo: getTailgateLogo,
            isUserTailgateAdmin: isUserTailgateAdmin,
            removeTailgateLogo: removeTailgateLogo,
            deleteTailgateImageByImageId: deleteTailgateImageByImageId,
            deleteTailgateMarker: deleteTailgateMarker,
            deleteTailgateUser: deleteTailgateUser,
            copyTailgate: copyTailgate,
            addTailgateAdmin: addTailgateAdmin,
            deleteTailgateSupplyItem: deleteTailgateSupplyItem,
            addSupplyItem: addSupplyItem,
            addTailgateSupplyItem: addTailgateSupplyItem,
            showStatusofAPIonFaliure: showStatusofAPIonFaliure,
            getallDataofCurrentTailgate: getallDataofCurrentTailgate
        }
        function getallFilteredEvents(tailgateParams) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getFilteredEventsURL, {params: tailgateParams})
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        //Get all data of current tailgate
        function getallDataofCurrentTailgate(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getallDataofCurrentTailgateUrl, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }


        function deleteTailgateImageByImageId(imageId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteTailgateImageURL, {
                params: { 'tailgateImageId': imageId }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function deleteTailgateMarker(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteTailgateMarkerURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function deleteTailgateUser(tailgateId, userId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteTailgateUserUrl, {
                params: { 'tailgateId': tailgateId, 'userId': userId }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        //update tailgate
        function updateTailgateInfo(tailgateParams) {
            var deferred = $q.defer();
            $http.get(SERVER.url + updateTailgateURL, {
                params: tailgateParams
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        //get all groups
        function getallFilteredEvents(tailgateParams) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getFilteredEventsURL, {
                params: tailgateParams
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        //get all groups
        function getGroupList() {
            var deferred = $q.defer();
            $http.get(SERVER.url + getGroupListURL)
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        //get all group users by group id
        function getGroupUsers(groupId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getGroupUsersURL, {
                params: {
                    'groupId': groupId
                }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        //GET Group by userId
        function getGroupbyId(userid) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getGroupByUserIdURL, {
                params: {
                    'userId': userid
                }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function getvenueDetails(venueId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getVenuebyVenueIdURL, {
                params: { 'venueId': venueId }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function addTailgate(currTailgateparams) {
            var deferred = $q.defer();
            $http.get(SERVER.url + allTailgateURL, { params: currTailgateparams })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function deleteTailgate(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteTailgateInfoURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getUserFrends() {
            var deferred = $q.defer();
            $http.get(SERVER.url + inviteFriendsTailgateURL, {
                params: {
                    companyId: SERVER.companyId,
                    keywords: ''
                }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function getEvent(eventId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + geteventURL, {
                params: { 'eventId': eventId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getMapMarkers(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getmapMarkersURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function deleteMapMarkers(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteTailgateUserIdURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function getallEvents() {
            var deferred = $q.defer();
            $http.get(SERVER.url + getAllEventsURL)
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function addcurrentUser(user) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addtailgateUserURL, {
                params: user
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getAllTailgate() {
            var deferred = $q.defer();
            $http.get(SERVER.url + allTailgateURL)
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getMyTailgates(uId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + myTailgatesURL, {
                params: { 'userId': uId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getTailgate(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getTailGateURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getMyTailgateImages(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getTailgateImagesURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getMyTailgateUsers(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getTalgetUsersURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function addTailgateMarkers(param) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addTialgateMarkerURL, {
                params: param
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getAllMessages(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getmessageBoardsByTailgateIdURL, {
                params: { 'tailgateId': tailgateId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function saveMessage(msgtxt, tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addMessageBoardURL, {
                params: {
                    'messageText': msgtxt,
                    'tailgateId': tailgateId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getAllUser(userId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getUserByIdURL, {
                params: { 'userId': userId }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getMySupplyLists() {
            var deferred = $q.defer();
            $http.get(SERVER.url + getMySupplyListsURL)
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getSupplyList(supplyListId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getSupplyListURL, {
                params: {
                    'supplyListId': supplyListId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        //get Items By TailgateId
        function getItemsByTailgateId(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getItemsByTailgateIdURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function getItemsbylistid(supplyListId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getItemsbylistidURL, {
                params: {
                    'supplyListId': supplyListId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function addTailgateSupplyItems(supplyListItemNames, tailgateId, itemAssignedUserId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addTailgateSupplyItemsURL, {
                params: {
                    'supplyListItemNames': supplyListItemNames,
                    'tailgateId': tailgateId,
                    'itemAssignedUserId': itemAssignedUserId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function updateTailgateSupplyItem(tailgateSupplyItemId, supplyListItemName, tailgateId, itemAssignedUserId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + updateTailgateSupplyItemURL, {
                params: {
                    'tailgateSupplyItemId': tailgateSupplyItemId,
                    'supplyListItemName': supplyListItemName,
                    'tailgateId': tailgateId,
                    'itemAssignedUserId': itemAssignedUserId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        //        function checkTailgateUserExist(userId, tailgateId) {
        //         return $http.get(SERVER.url + checkTailgateUserExist, {
        //            params: {
        //                'userId':userId,
        //                'tailgateId': tailgateId,
        //            }
        //        })
        //        .then(function success(response) {
        //            return response;
        //        }, function failure(response) {
        //            return $q.$inject(response);
        //            //add errror handling
        //        });
        //        }

        function isUserTailgateAdmin(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + isTailgateAdminURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function getTailgateLogo(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getTailgateLogoURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function removeTailgateLogo(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + removeTailgateLogoURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function copyTailgate(tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + copyTailgateURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function addTailgateAdmin(userId, tailgateId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addTailgateAdminURL, {
                params: {
                    'userId': userId,
                    'tailgateId': tailgateId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function deleteTailgateSupplyItem(supplyItemId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteTailgateSupplyItemURL, {
                params: {
                    'tailgateSupplyItemId': supplyItemId
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        //add supply item
        function addSupplyItem(supplyItemName, supplyListId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addSupplyItemUrl, {
                params: {
                    'supplyItemName': supplyItemName,
                    'supplyListId': supplyListId
                }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function addTailgateSupplyItem(supplyListItemName, tailgateId, itemAssignedUserId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addTailgateSupplyItemURL, {
                params: {
                    'supplyListItemName': supplyListItemName,
                    'tailgateId': tailgateId,
                    'itemAssignedUserId': itemAssignedUserId
                }
            })
            .then(function (response) {
                deferred.resolve(response.data);
            }, function (reason) {showStatusofAPIonFaliure(reason);
                showStatusofAPIonFaliure(reason);
                if (reason.statusText) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }

        function showStatusofAPIonFaliure(err){
            if(err.status == 400){
                $flaskUtil.alert('Bad Request from server');
            }else if(err.status == 401){
                $flaskUtil.alert('Please check if your username and password are correct.');}
            else if(err.status == 403){
                $flaskUtil.alert('Too many connections on server');
            }else if(err.status == 500){
                $flaskUtil.alert('Something wrong with server');
                $state.go("app.events");
            }else if(err.status == -1){
                $flaskUtil.alert(" Please Check your Internet Connection and restart App again");                
            }else if(err.status == 503){
                $flaskUtil.alert("Server is currently Unavailable, please try after sometime");
                $state.go("app.events");
            }else if(err.status == 404){
                $flaskUtil.alert("Requested data not found on server");
            }else if(err.status == 502){
                $flaskUtil.alert("Invalid response from server");
                $state.go("app.events");
            }else if(err.status == 504){
                $flaskUtil.alert("Server response timeout");
                $state.go("app.events");
            }else{
                $state.go("app.events");
            }
        }

        return tailgateServices;
    }

})();


