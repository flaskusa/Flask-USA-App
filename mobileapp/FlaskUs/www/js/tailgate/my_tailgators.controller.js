(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatorsCtrl', mytailgatorsCtrl);

    mytailgatorsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService','$cookies','$ionicModal','$flaskUtil'];

    /* @ngInject */
    function mytailgatorsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies,$ionicModal,$flaskUtil) {
        $scope.myTailgaters = [];
        $scope.myFriends = [];
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
        var tailGateId = $cookies.get('currtailGateId');
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        

        function getTailgaters() {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {

                $scope.myTailgaters = respData.data;
                getAllFriends();
            });
        }
        function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                $scope.myFriends = respData;
            })
        }
        $scope.addTailgateMembers = function(currUserData,index) {
            var addUserparams = {};
            addUserparams.groupId = 0;
            addUserparams.userId = currUserData.userId;
            addUserparams.userName = currUserData.firstName + " " + currUserData.lastName;
            addUserparams.emailAddress = currUserData.emailAddress;
            addUserparams.isAdmin = 0;
            addUserparams.tailgateId = tailGateId;
            addUserparams.isPaid = 0;
            addUserparams.paymentMode = "None";
            TailgateService.addcurrentUser(addUserparams).then(function (respData) {
                $scope.myFriends.splice(index, 1);
            })           
        };

        getTailgaters();

    }
})();

