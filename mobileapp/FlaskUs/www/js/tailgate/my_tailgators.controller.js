(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatorsCtrl', mytailgatorsCtrl);

    mytailgatorsCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService','$cookies','$ionicModal','$flaskUtil'];

    /* @ngInject */
    function mytailgatorsCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cookies,$ionicModal,$flaskUtil) {
        $scope.myTailgaters = [];

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
                console.log(respData);
                $scope.myTailgaters = respData.data;
                getAllFriends();
            });
        }
       // getAllFriends();
        function getAllFriends() {
            TailgateService.getUserFrends().then(function (respData) {
                console.log(respData);
                $scope.myFriends = respData;
            })
        }

    }
})();

