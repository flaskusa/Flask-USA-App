(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('TailgateService', TailgateService);

    TailgateService.$inject = ['$http', 'SERVER', '$q'];

    function TailgateService($http, SERVER, $q) {
        var baseURL = SERVER.url;
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
            getAllUser: getAllUser
        }

        function getvenueDetails(venueId) {
            return $http.get(baseURL + getVenuebyVenueIdURL, {
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
            return $http.get(baseURL + allTailgateURL, {
                params: currTailgateparams
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }
        function getUserFrends() {
            return $http.get(baseURL + inviteFriendsTailgateURL, {
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
            return $http.get(baseURL + geteventURL, {
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
            return $http.get(baseURL + getmapMarkersURL, {
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
            return $http.get(baseURL + getAllEventsURL
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }
        function addcurrentUser(user) {
            return $http.get(baseURL + addtailgateUserURL, {
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
            return $http.get(baseURL + allTailgateURL)
            .then(function success(response) {
                return response;
            }, function failure(response) {
                return $q.$inject(response);
                //add errror handling 
            });
        }

        function getMyTailgates(uId) {
            return $http.get(baseURL + myTailgatesURL, {
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
            return $http.get(baseURL + getTailGateURL, {
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
            return $http.get(baseURL + getTailgateImagesURL, {
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
            return $http.get(baseURL + getTalgetUsersURL, {
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
            return $http.get(baseURL + addTialgateMarkerURL, {
                params: {
                    'tailgateId': param.tailgateId,
                    'latitude': param.lattitude,
                    'longitude': param.longitude,
                    'name': param.name,
                    'description': param.description
                }
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
            return $http.get(baseURL + getmessageBoardsByTailgateIdURL, {
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
            return $http.get(baseURL + addMessageBoardURL, {
                params: {
                    'messageText': msgtxt,
                    'tailgateId':tailgateId
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
            return $http.get(baseURL + getUserByIdURL, {
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

        return tailgateServices;
    }


    //angular.module('flaskApp').service('ServerDataModel', function ServerDataModel() {
    //    this.selectedList = "";
    //    this.data = [
    //        {
    //            listid: 1,
    //            listName: "GAME DAY NEEDS",
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }, {
    //                listItemId: 4,
    //                itemName: "CASH/WALLET",
    //                checked: true
    //            },
    //                {
    //                    listItemId: 5,
    //                    itemName: "UMBRELLA",
    //                    checked: true
    //                }],
    //            isSystemProvided: 1
    //        },
    //        {
    //            listid: 2,
    //            listName: "TAILGATE SET-UP",
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }, {
    //                listItemId: 2,
    //                itemName: "BLANKETS",
    //                checked: true
    //            },
    //                {
    //                    listItemId: 3,
    //                    itemName: "PARKING PASS",
    //                    checked: false
    //                },
    //                {
    //                    listItemId: 4,
    //                    itemName: "CASH/WALLET",
    //                    checked: true
    //                }],
    //            isSystemProvided: 1
    //        },
    //        {
    //            listid: 3,
    //            listName: "TAILGATE SUPPLIES",
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }],
    //            isSystemProvided: 1
    //        },
    //        {
    //            listid: 4,
    //            listName: "FOOD/BEVERAGES",
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }],
    //            isSystemProvided: 1
    //        },
    //        {
    //            listid: 5,
    //            listName: "COOKING SUPPLIES",
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }, {
    //                listItemId: 2,
    //                itemName: "BLANKETS",
    //                checked: true
    //            }, {
    //                listItemId: 3,
    //                itemName: "PARKING PASS",
    //                checked: false
    //            },
    //                {
    //                    listItemId: 4,
    //                    itemName: "CASH/WALLET",
    //                    checked: true
    //                },
    //                {
    //                    listItemId: 5,
    //                    itemName: "UMBRELLA",
    //                    checked: true
    //                }],
    //            isSystemProvided: 1
    //        },
    //        {
    //            listid: 6,
    //            listName: "CLEANING SUPPLIES",
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }],
    //            isSystemProvided: 1
    //        },
    //        {
    //            listid: 7,
    //            listName: "ENTERTAINMENT",
    //            selectedListItem: [1, 3, 5],
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }],
    //            isSystemProvided: 1
    //        },
    //        {
    //            listid: 8,
    //            listName: "JUST IN CASE",
    //            listItem: [{
    //                listItemId: 1,
    //                itemName: "TICKETS",
    //                checked: false
    //            }],
    //            isSystemProvided: 1
    //        }
    //    ];


    //    this.getData = function () {
    //        return this.data;
    //    };

    //    this.setData = function (data) {
    //        this.data = data;
    //    };

    //    // add a new data item that does not exist already
    //    // must compute a new unique id and backfill in
    //    this.addOne = function (dataItem) {
    //        // must calculate a unique ID to add the new data
    //        var newId = this.newId();
    //        dataItem.listid = newId;
    //        this.data.push(dataItem);
    //        return dataItem;
    //    };

    //    // return an id to insert a new data item at
    //    this.newId = function () {
    //        // find all current ids
    //        var arr = this.data;
    //        var maxId = arr.length;
    //        console.log(maxId);
    //        // increment by one
    //        return maxId + 1;
    //    };
    //    // for supplies list items


    //    // add a new data item that does not exist already
    //    // must compute a new unique id and backfill in
    //    this.addOne1 = function (dataItem1) {
    //        // must calculate a unique ID to add the new data
    //        var newId1 = this.newId();
    //        dataItem1.listid1 = newId1;
    //        this.data2.push(dataItem1);
    //        return dataItem1;
    //    };

    //    // return an id to insert a new data item at
    //    this.newId1 = function () {
    //        // find all current ids
    //        var arr1 = this.data2;
    //        var maxId1 = arr1.length;
    //        console.log(maxId1);
    //        // increment by one
    //        return maxId1 + 1;
    //    };

    //})

    //angular.module('flaskApp').factory('HttpService', function ($http) {
    //    var service = {
    //        query: function () {
    //            return $http.get('/suppliesList');

    //        },
    //        get: function (id) {
    //            return $http.get('/suppliesList/' + id);
    //        },
    //        get2: function (id) {
    //            return $http.get('/suppliesList1/' + id);
    //        },
    //        // making save data1
    //        save: function (data) {
    //            console.log(data);
    //            if (angular.isDefined(data.listid)) {
    //                return $http.post('/suppliesList/' + data.listid, data);
    //            } else {

    //                return $http.post('/suppliesList', data);
    //            }
    //        },
    //        // making save for data2
    //        save2: function (data2) {
    //            console.log(data2);
    //            if (angular.isDefined(data2.listid)) {
    //                return $http.post('/suppliesList1/' + data2.listid, data2);
    //            } else {
    //                return $http.post('/suppliesList1', data2);
    //            }
    //        },
    //        delete: function (id) {
    //            return $http.delete('/suppliesList/' + id);
    //        }
    //    };
    //})
})();


