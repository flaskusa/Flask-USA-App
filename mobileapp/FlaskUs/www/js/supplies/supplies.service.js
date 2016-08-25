angular.module('flaskApp').service('ServerDataModel', function ServerDataModel() {
    this.selectedList="";
    this.data = [
        {
            listid: 1,
            listName: "GAME DAY NEEDS",
            listItem:[{
                listItemId: 1,
                itemName: "TICKETS",
                checked : false
            },{
                    listItemId: 4,
                    itemName: "CASH/WALLET",
                    checked: true
                },
                {
                    listItemId: 5,
                    itemName: "UMBRELLA",
                    checked: true
                }],
            isSystemProvided:1
        },
        {
            listid: 2,
            listName: "TAILGATE SET-UP",
            listItem:[{
            listItemId: 1,
            itemName: "TICKETS",
            checked : false
            },{
                listItemId: 2,
                itemName: "BLANKETS",
                checked: true
            },
                {
                    listItemId: 3,
                    itemName: "PARKING PASS",
                    checked: false
                },
                {
                    listItemId: 4,
                    itemName: "CASH/WALLET",
                    checked: true
                }],
           isSystemProvided:1
        },
        {
            listid: 3,
            listName: "TAILGATE SUPPLIES",
            listItem:[{
                listItemId: 1,
                itemName: "TICKETS",
                checked : false
            }],
            isSystemProvided:1
        },
        {
            listid: 4,
            listName: "FOOD/BEVERAGES",
            listItem:[{
                listItemId: 1,
                itemName: "TICKETS",
                checked : false
            }],
            isSystemProvided:1
        },
        {
            listid: 5,
            listName: "COOKING SUPPLIES",
            listItem:[{
                listItemId: 1,
                itemName: "TICKETS",
                checked : false
            },{
                listItemId: 2,
                itemName: "BLANKETS",
                checked: true
        },  {
                    listItemId: 3,
                    itemName: "PARKING PASS",
                    checked: false
            },
                {
                    listItemId: 4,
                    itemName: "CASH/WALLET",
                    checked: true
                },
                {
                    listItemId: 5,
                    itemName: "UMBRELLA",
                    checked: true
                }],
            isSystemProvided:0
        },
        {
            listid: 6,
            listName: "CLEANING SUPPLIES",
            listItem:[{
                listItemId: 1,
                itemName: "TICKETS",
                checked : false
            }],
            isSystemProvided:0
        },
        {
            listid: 7,
            listName: "ENTERTAINMENT",
            selectedListItem:[1,3,5],
            listItem:[{
                listItemId: 1,
                itemName: "TICKETS",
                checked : false
            }],
            isSystemProvided:1
        },
        {
            listid: 8,
            listName: "JUST IN CASE",
            listItem:[{
                listItemId: 1,
                itemName: "TICKETS",
                checked : false
            }],
            isSystemProvided:1
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
    // for supplies list items


    // add a new data item that does not exist already
    // must compute a new unique id and backfill in
    this.addOne1 = function (dataItem1) {
        // must calculate a unique ID to add the new data
        var newId1 = this.newId();
        dataItem1.listid1 = newId1;
        this.data2.push(dataItem1);
        return dataItem1;
    };

    // return an id to insert a new data item at
    this.newId1 = function () {
        // find all current ids
        var arr1 = this.data2;
        var maxId1 = arr1.length;
        console.log(maxId1);
        // increment by one
        return maxId1 + 1;
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
        get2: function (id) {
            return $http.get('/suppliesList1/' + id);
        },
        // making save data1
        save: function (data) {
            console.log(data);
            if (angular.isDefined(data.listid)) {               
                return $http.post('/suppliesList/' + data.listid, data);
            } else {

                return $http.post('/suppliesList', data);
            }
        },
        // making save for data2
        save2: function (data2) {
            console.log(data2);
            if (angular.isDefined(data2.listid)) {
                return $http.post('/suppliesList1/' + data2.listid, data2);
            } else {
                return $http.post('/suppliesList1', data2);
            }
        },
        delete: function (id) {
            return $http.delete('/suppliesList/' + id);
        }
    };

    return service;
})
