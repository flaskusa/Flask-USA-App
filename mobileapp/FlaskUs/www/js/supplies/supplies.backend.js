// We will be using backend-less development
// $http uses $httpBackend to make its calls to the server
// $resource uses $http, so it uses $httpBackend too
// We will mock $httpBackend, capturing routes and returning data
(function () {
    'use strict';
    angular.module('flaskApp')
        .run(runList,'runList');

    runList.$inject = ['$httpBackend', 'ServerDataModel'];

    /* @ngInject */
    function runList($httpBackend, ServerDataModel) {
        $httpBackend.whenGET('/suppliesList').respond(function (method, url, data) {
            var lists = ServerDataModel.findAll();
            return [200, lists, {}];
        });

        // this is the creation of a new resource
        $httpBackend.whenPOST('/suppliesList').respond(function (method, url, data) {
            var params = angular.fromJson(data);

            var list = ServerDataModel.addOne(params);

            // get the id of the new resource to populate the Location field
            var listid = list.listid;

            return [201, list, { Location: '/suppliesList/' + listid }];
        });

        $httpBackend.whenGET(/templates\//).passThrough();
    }
})();
