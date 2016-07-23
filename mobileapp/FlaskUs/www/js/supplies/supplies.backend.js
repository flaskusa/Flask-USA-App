// We will be using backend-less development
// $http uses $httpBackend to make its calls to the server
// $resource uses $http, so it uses $httpBackend too
// We will mock $httpBackend, capturing routes and returning data
(function () {
    'use strict';
    angular.module('flaskApp')
        .run(run);

    run.$inject = ['$httpBackend', 'ServerDataModel'];

    /* @ngInject */
    function run($httpBackend, ServerDataModel) {
        $httpBackend.whenGET('/suppliesList').respond(function (method, url, data) {
            var games = ServerDataModel.findAll();
            return [200, games, {}];
        });

        $httpBackend.whenGET(/\/suppliesList\/\d+/).respond(function (method, url, data) {
            // parse the matching URL to pull out the id (/suppliesList/:id)
            var listid = url.split('/')[2];

            var game = ServerDataModel.findOne(listid);

            return [200, game, {}];
        });

        // this is the creation of a new resource
        $httpBackend.whenPOST('/suppliesList').respond(function (method, url, data) {
            var params = angular.fromJson(data);

            var game = ServerDataModel.addOne(params);

            // get the id of the new resource to populate the Location field
            var listid = game.listid;

            return [201, game, { Location: '/suppliesList/' + listid }];
        });

        $httpBackend.whenGET(/templates\//).passThrough();
    }
})();
