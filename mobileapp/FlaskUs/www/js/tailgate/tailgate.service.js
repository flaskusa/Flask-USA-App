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
    
    TailgateService.$inject = ['$http', 'SERVER', '$q'];
    function TailgateService($http, SERVER, $q) {
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
        var addSupplyListURL = "flask-user-tailgate-portlet.supplylist/add-supply-list";
        var getItemsbylistidURL = "flask-user-tailgate-portlet.supplyitem/get-items-by-list-id";
        var getSupplyListURL = "flask-user-tailgate-portlet.supplylist/get-supply-list";
        /*User group services*/
        var getGroupListURL = "flask-manage-user-group-portlet.flaskgroup/get-all-groups";
        var getGroupUsersURL = "flask-manage-user-group-portlet.flaskgroupusers/get-all-group-users";
        var getGroupByUserIdURL = "flask-manage-user-group-portlet.flaskgroup/get-my-groups";
        /*Get My Tailgate Service*/
        //var getAllTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-tailgate";
        var addTailgateSupplyItemsURL = "flask-user-tailgate-portlet.tailgatesupplyitem/add-tailgate-supply-items";
        var updateTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/update-tailgate-info";
        /*Add Supply List*/
        var addSupplyListURL = "flask-user-tailgate-portlet.supplylist/add-supply-list";
        var getItemsByTailgateIdURL = "flask-user-tailgate-portlet.tailgatesupplyitem/get-items-by-tailgate-id";
        var updateTailgateSupplyItemURL = "flask-user-tailgate-portlet.tailgatesupplyitem/update-tailgate-supply-item";
        //        var checkTailgateUserExist = '/flask-user-tailgate-portlet.tailgateusers/check-tailgate-user-exist';
        var isTailgateAdminURL = 'flask-user-tailgate-portlet.tailgateusers/is-tailgate-admin';
        var getTailgateLogoURL = 'flask-user-tailgate-portlet.tailgateinfo/get-tailgate-logo';
        var removeTailgateLogoURL = 'flask-user-tailgate-portlet.tailgateinfo/delete-tailgate-logo';
        var deleteTailgateImageURL = '/flask-user-tailgate-portlet.tailgateimages/delete-tailgate-image-by-tailgate-image-id';
        var deleteTailgateUserUrl = '/flask-user-tailgate-portlet.tailgateusers/delete-tailgate-user';
        var copyTailgateURL = 'flask-user-tailgate-portlet.tailgateinfo/copy-tailgate';
        var addTailgateAdminURL = 'flask-user-tailgate-portlet.tailgateusers/update-tailgate-user-role';
        var deleteTailgateSupplyItemURL = "/flask-user-tailgate-portlet.supplyitem/delete-supply-item";
        var addSupplyItemUrl = "/flask-user-tailgate-portlet.supplyitem/add-supply-item";

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
            addSupplyItem: addSupplyItem
        }

        function getallFilteredEvents(tailgateParams) {
            return $http.get(SERVER.url + getFilteredEventsURL, {
                params: tailgateParams
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function deleteTailgateImageByImageId(imageId) {
            return $http.get(SERVER.url + deleteTailgateImageURL, {
                params: { 'tailgateImageId': imageId }
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteTailgateMarker(tailgateId) {
            return $http.get(SERVER.url + deleteTailgateMarkerURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteTailgateUser(tailgateId,userId) {
            return $http.get(SERVER.url + deleteTailgateUserUrl, {
                    params: { 'tailgateId': tailgateId,'userId':userId }
                }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //update tailgate
        function updateTailgateInfo(tailgateParams) {
            return $http.get(SERVER.url + updateTailgateURL, {
                params: tailgateParams
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get all groups
        function getallFilteredEvents(tailgateParams) {
            return $http.get(SERVER.url + getFilteredEventsURL, {
                params: tailgateParams
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get all groups
        function getGroupList() {
            return $http.get(SERVER.url + getGroupListURL
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //get all group users by group id
        function getGroupUsers(groupId) {
            return $http.get(SERVER.url + getGroupUsersURL, {
                params: {
                    'groupId': groupId
                }
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        //GET Group by userId
        function getGroupbyId(userid) {
            return $http.get(SERVER.url + getGroupByUserIdURL, {
                params: {
                    'userId': userid
                }
            }).then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });
        }
        function getvenueDetails(venueId) {
            return $http.get(SERVER.url + getVenuebyVenueIdURL, {
                params: { 'venueId': venueId }
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function addTailgate(currTailgateparams) {
            return $http.get(SERVER.url + allTailgateURL, { params: currTailgateparams })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling
                });
        }
        function deleteTailgate(tailgateId) {
            return $http.get(SERVER.url + deleteTailgateInfoURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    //add errror handling
                });
        }
        function getUserFrends() {
            return $http.get(SERVER.url + inviteFriendsTailgateURL, {
                params: {
                    companyId: SERVER.companyId,
                    keywords: ''
                }
            })
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getEvent(eventId) {
            return $http.get(SERVER.url + geteventURL, {
                params: { 'eventId': eventId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getMapMarkers(tailgateId) {
            return $http.get(SERVER.url + getmapMarkersURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function deleteMapMarkers(tailgateId) {
            return $http.get(SERVER.url + deleteTailgateUserIdURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getallEvents() {
            return $http.get(SERVER.url + getAllEventsURL
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function addcurrentUser(user) {
            return $http.get(SERVER.url + addtailgateUserURL, {
                params: user
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getAllTailgate() {
            return $http.get(SERVER.url + allTailgateURL)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getMyTailgates(uId) {
            return $http.get(SERVER.url + myTailgatesURL, {
                params: { 'userId': uId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function getTailgate(tailgateId) {
            return $http.get(SERVER.url + getTailGateURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getMyTailgateImages(tailgateId) {
            return $http.get(SERVER.url + getTailgateImagesURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getMyTailgateUsers(tailgateId) {
            return $http.get(SERVER.url + getTalgetUsersURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }


        function addTailgateMarkers(param) {
            return $http.get(SERVER.url + addTialgateMarkerURL, {
                params: param
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getAllMessages(tailgateId) {
            return $http.get(SERVER.url + getmessageBoardsByTailgateIdURL, {
                params: { 'tailgateId': tailgateId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    //add errror handling
                });
        }

        function saveMessage(msgtxt, tailgateId) {
            return $http.get(SERVER.url + addMessageBoardURL, {
                params: {
                    'messageText': msgtxt,
                    'tailgateId': tailgateId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getAllUser(userId) {
            return $http.get(SERVER.url + getUserByIdURL, {
                params: { 'userId': userId }
            }
            )
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getMySupplyLists() {
            return $http.get(SERVER.url + getMySupplyListsURL)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getSupplyList(supplyListId) {
            return $http.get(SERVER.url + getSupplyListURL, {
                params: {
                    'supplyListId': supplyListId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        //get Items By TailgateId
        function getItemsByTailgateId(tailgateId) {
            return $http.get(SERVER.url + getItemsByTailgateIdURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function getItemsbylistid(supplyListId) {
            return $http.get(SERVER.url + getItemsbylistidURL, {
                params: {
                    'supplyListId': supplyListId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function addTailgateSupplyItems(supplyListItemNames, tailgateId, itemAssignedUserId) {
            return $http.get(SERVER.url + addTailgateSupplyItemsURL, {
                params: {
                    'supplyListItemNames': supplyListItemNames,
                    'tailgateId': tailgateId,
                    'itemAssignedUserId': itemAssignedUserId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function updateTailgateSupplyItem(tailgateSupplyItemId, supplyListItemName, tailgateId, itemAssignedUserId) {
            return $http.get(SERVER.url + updateTailgateSupplyItemURL, {
                params: {
                    'tailgateSupplyItemId': tailgateSupplyItemId,
                    'supplyListItemName': supplyListItemName,
                    'tailgateId': tailgateId,
                    'itemAssignedUserId': itemAssignedUserId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
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
            return $http.get(SERVER.url + isTailgateAdminURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }


        function getTailgateLogo(tailgateId) {
            return $http.get(SERVER.url + getTailgateLogoURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function removeTailgateLogo(tailgateId) {
            return $http.get(SERVER.url + removeTailgateLogoURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        function copyTailgate(tailgateId) {
            return $http.get(SERVER.url + copyTailgateURL, {
                params: {
                    'tailgateId': tailgateId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function addTailgateAdmin(userId, tailgateId) {
            return $http.get(SERVER.url + addTailgateAdminURL, {
                params: {
                    'userId':userId,
                    'tailgateId': tailgateId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }

        function deleteTailgateSupplyItem(supplyItemId) {
            return $http.get(SERVER.url + deleteTailgateSupplyItemURL, {
                params: {
                    'supplyItemId': supplyItemId
                }
            })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling
                });
        }
        return tailgateServices;
    }

    //add supply item
    function addSupplyItem(supplyItemName, supplyListId) {
        return $http.get(SERVER.url + addSupplyItemUrl, {
            params: {
                "supplyItemName": supplyItemName,
                "supplyListId": supplyListId
            }
        })
            .then(function success(response) {
                return response.data;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling
            });
    }

})();


