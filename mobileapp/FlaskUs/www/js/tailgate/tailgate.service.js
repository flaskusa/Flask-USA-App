(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('TailgateService', TailgateService);

    TailgateService.$inject = ['$http', 'SERVER'];

    function TailgateService($http, SERVER) {
        var baseURL = SERVER.url;
        var allTailgateURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-tailgate";
        var myTailgatesURL = "flask-user-tailgate-portlet.tailgateinfo/get-all-my-tailgate";
        var getTailgateImagesURL = "flask-user-tailgate-portlet.tailgateimages/get-tailgate-images";
        var getTailGateURL = "flask-user-tailgate-portlet.tailgateinfo/get-tailgate";
        var geteventURL = "flask-rest-events-portlet.event/get-event";
        var getTalgetUsersURL = "flask-user-tailgate-portlet.tailgateusers/get-tailgate-members";
        var addtailgateURL = "flask-user-tailgate-portlet.tailgateusers/get-tailgate-members";
        var getVenuebyVenueIdURL = "flask-rest-events-portlet.venue/get-venue";
        var getAllEventsURL = "flask-rest-events-portlet.event/get-all-events";
        var getmapMarkersURL = "flask-user-tailgate-portlet.tailgatemarker/get-tailgate-marker";
        var addTialgateMarkerURL = "flask-user-tailgate-portlet.tailgatemarker/add-tailgate-marker";

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
            addTailgateMarkers: addTailgateMarkers
        }

        function addTailgate(tailgateName,tailgateDescription,eventId, eventName,tailgateDate,startTime,endTime,venmoAccountId,amountToPay ) {
            return $http.get(baseURL + addtailgateURL, {
                params: {
                    tailgateName: tailgateName,
                    tailgateDescription: tailgateDescription,
                    eventId: eventId,
                    eventName: eventName,
                    tailgateDate: tailgateDate,
                    startTime: startTime,
                    endTime: endTime,
                    venmoAccountId: venmoAccountId,
                    amountToPay: amountToPay
                    }
                }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
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
                //add errror handling 
            });
        }

        function getallEvents() {
            return $http.get(baseURL + getAllEventsURL
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
            });
        }

        function getAllTailgate() {
            return $http.get(baseURL + allTailgateURL)
                .then(function success(response) {
                    return response;
                }, function failure(response) {
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
                //add errror handling 
            });
        }

        return tailgateServices;
    }
})();