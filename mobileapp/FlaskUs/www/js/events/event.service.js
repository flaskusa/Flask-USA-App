
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('EventsService', EventsService);

    EventsService.$inject = ['$http', 'SERVER', '$q','$flaskUtil','$state'];

    function EventsService($http, SERVER, $q, $flaskUtil, $state) {
        var allEventsURL = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var addEventURL = "flask-rest-events-portlet.event/add-event";
        var addEventDetailsURL = "flask-rest-events-portlet.event/add-event-detail";
        var getFilteredEvents = "flask-rest-events-portlet.event/get-simple-filtered-events";
        var getEvent_Venue_Details_with_Images = "flask-rest-events-portlet.event/get-event-venue-details-with-images";
        var getEventByIdURL = "flask-rest-events-portlet.event/get-event";
        var addContentDuringGameUrl="/flask-rest-events-portlet.event/add-event-detail";
        var updateEventDuringGame="/flask-rest-events-portlet.event/update-event-detail";
        var deleteEventDetailUrl = "/flask-rest-events-portlet.event/delete-event-detail";
        var getAllVenuesURL = "flask-rest-events-portlet.venue/get-all-venues";
        var getVenuesByIdURL = "flask-rest-events-portlet.venue/get-venue";
        var getAllEventDetailWithImageUrl = "/flask-rest-events-portlet.event/get-event-details-with-images";
        var getVenueDetailsURL = "/flask-rest-events-portlet.venue/get-venue-details";
        var getVenueDetailURL = "/flask-rest-events-portlet.venue/get-venue-detail";
        var getVenueDetailWithImageURL = "flask-rest-events-portlet.venue/get-venue-details-with-images";
        var deleteEventDetailImage = "/flask-rest-events-portlet.event/delete-event-detail-image";
        var getVenueDeviceImageURL = "/flask-rest-events-portlet.venue/get-venue-images-by-venue-id-and-device-type";
        var googleMapURL = SERVER.googleApi;

        var eventServices = {
            getAllEvents: getAllEvents,
            getlocation: getlocation,
            getZiplocation: getZiplocation,
            getEventVenueDatail: getEventVenueDatail,
            getEventByEventId: getEventByEventId,
            addContentDuringEvent:addContentDuringEvent,
            updateEventDetailDuringEvent:updateEventDetailDuringEvent,
            deleteEventDetailById: deleteEventDetailById,
            getAllEventDetailWithImage:getAllEventDetailWithImage,
            getAllVenues: getAllVenues,
            getVenueDetails:getVenueDetails,
            getVenueDetail: getVenueDetail,
            deleteEventDetailImageById: deleteEventDetailImageById,
            getVenueDetailWithImage: getVenueDetailWithImage,
            getVenueDeviceImage: getVenueDeviceImage,
            showStatusofAPIonFaliure: showStatusofAPIonFaliure
        }
        function getAllEvents(eventIds, sDate, eDate, sString, lat, long) {
            var deferred = $q.defer();
            $http.get(SERVER.url + allEventsURL, {
                params: {
                    eventTypeIds: eventIds,
                    startDate: sDate,
                    endDate: eDate,
                    searchString: sString,
                    latitude: lat,
                    longitude: long
                }
            })
            .then(function (response) {
                deferred.resolve(response);
            }, function (reason) {
                showStatusofAPIonFaliure(reason);
                if (reason.status) {
                    deferred.reject(reason);
                } else {
                    deferred.reject({ statusText: 'Call error', status: 500 });
                }
            });
            return deferred.promise;
        }
        function getlocation(addressVar, zipcode) {
            var deferred = $q.defer();
            $http.get(googleMapURL + addressVar + zipcode)
            .then(function (response) {
                deferred.resolve(response);
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
        function getZiplocation(latlongVar, lat, long, sensorVar) {
            var deferred = $q.defer();
            $http.get(googleMapURL + latlongVar + lat + ',' + long + sensorVar)
            .then(function (response) {
                deferred.resolve(response);
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
        function getEventVenueDatail(currEventId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getEvent_Venue_Details_with_Images, {
                params: { 'eventId': currEventId }
            })
            .then(function (resp) {
                deferred.resolve(resp);
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
        function getEventByEventId(eventId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getEventByIdURL, {
                params: { 'eventId': eventId }
            })
            .then(function (resp) {
                deferred.resolve(resp);
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
        function addContentDuringEvent(infoTitle, infoDesc, eventId, infoTypeCategoryId, infoTypeId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + addContentDuringGameUrl, {
                params: {
                    eventId: eventId,
                    infoTypeId: infoTypeId,
                    infoTypeCategoryId: infoTypeCategoryId,
                    infoTitle: infoTitle,
                    infoShortDesc: '',
                    infoDesc: infoDesc,
                    addrLine1: '',
                    addrLine2: '',
                    zipCode: '',
                    city: '',
                    stateId: 0,
                    countryId: 0,
                    latitude: '',
                    longitude: '',
                    phone: '',
                    mobileAppName: '',
                    website: '',
                    cost: 0.0,
                    hoursOfOperation: '',
                    showDescription: true,
                    premiumDisplayEnabled: false,
                    eventSubDetails: ''
                }
            })
            .then(function (resp) {
                deferred.resolve(resp);
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

        function updateEventDetailDuringEvent(infoTitle, infoDesc, eventId, infoTypeCategoryId, infoTypeId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + updateEventDuringGame, {
                params: {
                    eventDetailId: eventDetailId,
                    infoTypeId: infoTypeId,
                    infoTypeCategoryId: infoTypeCategoryId,
                    infoTitle: infoTitle,
                    infoShortDesc: '',
                    infoDesc: infoDesc,
                    addrLine1: '',
                    addrLine2: '',
                    zipCode: '',
                    city: '',
                    stateId: 0,
                    countryId: 0,
                    latitude: '',
                    longitude: '',
                    phone: '',
                    mobileAppName: '',
                    website: '',
                    cost: 0.0,
                    hoursOfOperation: '',
                    showDescription: true,
                    premiumDisplayEnabled: false,
                    eventSubDetails: ''
                }
            })
            .then(function (resp) {
                deferred.resolve(resp);
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
        function deleteEventDetailById(eventDetailId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteEventDetailUrl, {
                params: { "eventDetailId": eventDetailId }
            })
            .then(function (resp) {
                deferred.resolve(resp);
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
        function deleteEventDetailImageById(eventDetailImageId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + deleteEventDetailImage, {
                params: { "eventDetailImageId": eventDetailImageId }
            })
            .then(function (resp) {
                deferred.resolve(resp);
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

        // Get All venues for event details
        function getAllVenues() {
            var deferred = $q.defer();
            $http.get(SERVER.url + getAllVenuesURL)
            .then(function (resp) {
                deferred.resolve(resp.data);
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
        //get all event detail with image
        function getAllEventDetailWithImage(eventId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getAllEventDetailWithImageUrl, {
                params: { eventId: eventId }
            })
            .then(function (resp) {
                deferred.resolve(resp.data);
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
        // Get venue by id for event details
        function getVenueByid(vid) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getVenuesByIdURL, {
                params: { "venueId ": venueId }
            })
            .then(function (resp) {
                deferred.resolve(resp.data);
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
        function getVenueDetails(venueId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getVenueDetailsURL, {
                params: { "venueId": venueId }
            })
            .then(function (resp) {
                deferred.resolve(resp.data);
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
        function getVenueDetail(venueDetailId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getVenueDetailURL, {
                params: { "venueDetailId ": venueDetailId }
            })
            .then(function (resp) {
                deferred.resolve(resp.data);
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
        function getVenueDetailWithImage(venueId) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getVenueDetailWithImageURL, {
                params: { "venueId": venueId }
            })
            .then(function (resp) {
                deferred.resolve(resp);
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
        //get venue image as per device
        function getVenueDeviceImage(venueId, deviceType, aspectRatio) {
            var deferred = $q.defer();
            $http.get(SERVER.url + getVenueDeviceImageURL, {
                params: {
                    "venueId": venueId,
                    "deviceType": deviceType,
                    "aspectRatio": aspectRatio
                }
            })
            .then(function (resp) {
                deferred.resolve(resp.data);
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
                $flaskUtil.alert(" Please Check your Internet Connection and restart the App");     
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

        return eventServices;
    }
})();