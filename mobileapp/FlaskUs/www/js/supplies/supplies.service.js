angular.module('flaskApp').service('ServerDataModel', function ServerDataModel() {
    this.data = [
        {
            listid: 1,
            listName: "GAME DAY NEEDS"
        },
        {
            listid: 2,
            listName: "TAILGATE SET-UP"
        },
        {
            listid: 3,
            listName: "TAILGATE SUPPLIES"
        },
        {
            listid: 4,
            listName: "FOOD/BEVERAGES"
        },
        {
            listid: 5,
            listName: "COOKING SUPPLIES"
        },
        {
            listid: 6,
            listName: "CLEANING SUPPLIES"
        },
        {
            listid: 7,
            listName: "ENTERTAINMENT"
        },
        {
            listid: 8,
            listName: "JUST IN CASE"
        }
    ];
    this.data2 = [
        {
            listid: 1,
            itemName: "TICKETS"
        },
        {
            listid: 2,
            itemName: "BLANKETS"
        },
        {
            listid: 3,
            itemName: "PARKING PASS"
        },
        {
            listid: 4,
            itemName: "CASH/WALLET"
        }
    ];

    this.getData = function () {
        return this.data;
    };

    this.setData = function (data) {
        this.data = data;
    };

    // add a new data item that does not exist already
    // must compute a new unique id and backfill in
    this.addOne = function (dataItem) {
        // must calculate a unique ID to add the new data
        var newId = this.newId();
        dataItem.listid = newId;
        this.data.push(dataItem);
        return dataItem;
    };

    // return an id to insert a new data item at
    this.newId = function () {
        // find all current ids
        var arr = this.data;
        var maxId = arr.length;
        console.log(maxId);
        // increment by one
        return maxId + 1;
    };

})

angular.module('flaskApp').factory('HttpService', function ($http) {
    var service = {
        query: function () {
            return $http.get('/suppliesList');

        },
        get: function (id) {
            return $http.get('/suppliesList/' + id);
        },
        // making save dual-function like default ngResource behavior (no separate update w/PUT)
        save: function (data) {
            if (angular.isDefined(data.listid)) {
                return $http.post('/suppliesList/' + data.listid, data);
            } else {
                return $http.post('/suppliesList', data);
            }
        },
        delete: function (id) {
            return $http.delete('/suppliesList/' + id);
        }
    };

    return service;
})