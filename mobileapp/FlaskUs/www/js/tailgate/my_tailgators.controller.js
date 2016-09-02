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
        getTailgaters();

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
        $scope.addTailgateMembers = function(index) {

            var currUserData = index;
            var userparams = {};
            userparams.groupId = 0;
            userparams.userId = currUserData.userId;
            userparams.userName = currUserData.firstName + " " + currUserData.lastName;
            userparams.emailAddress = currUserData.emailAddress;
            userparams.isAdmin = 0;
            userparams.tailgateId = tailGateId;
            userparams.isPaid = 0;
            userparams.paymentMode = "None";

            addTailgateMember(userparams);
        }
        function addTailgateMember(addUserparams) {
            TailgateService.addcurrentUser(addUserparams).then(function (respData) {
                console.log(respData);
            })
        }

    }
})();

