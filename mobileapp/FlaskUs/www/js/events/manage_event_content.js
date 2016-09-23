(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('ManageEventCtrl', ManageEventCtrl);

    ManageEventCtrl.$inject = ['$scope', '$stateParams', '$state', 'EventsService', 'SERVER'];

    /* @ngInject */
    function ManageEventCtrl($scope, $stateParams, $state, EventsService, SERVER) {
        $scope.eventDetails = $stateParams.eventDetails.Details;
        $scope.eventName=$stateParams.currEventName;
        $scope.currEventId=$stateParams.currEventId;
        $scope.infoTypeName = 'During-Event';
        $scope.flaskUsDetails=[];
        $scope.editContent=false;
        $scope.content={infoTitle:"",infoDesc:""};

        $scope.addContent=function(content,index) {
            if (content.eventDetailId <= 0 || content.eventDetailId == undefined) {
                EventsService.addContentDuringEvent(content.infoTitle, content.infoDesc, $scope.currEventId).then(function (response) {
                   if(response.data.eventDetailId) {
                       $scope.flaskUsDetails.push(response.data);
                       $scope.editContent = false;
                   }else{

                   }
                })
            }
            else if (content.eventDetailId > 0) {
                    EventsService.updateEventDetailDuringEvent(content.infoTitle, content.infoDesc, $scope.currEventId, content.eventDetailId).then(function (response) {
                        if (response.data.eventDetailId > 0) {
                            $scope.editContent = false;
                        }
                    });
                }


        }
        $scope.cancelEdit=function(){
            $scope.editContent = false;
        }
        $scope.addNewContent=function(){
            $scope.content={infoTitle:"",infoDesc:""};
            $scope.editContent = true;
        }
        $scope.editContents=function(content,index){
            $scope.content=content;
            $scope.editContent=true;
        }
        $scope.deleteEventDetail=function(eventDetailId,index){
            EventsService.deleteEventDetailById(eventDetailId).then(function(response){
                if(response.data){
                    $scope.flaskUsDetails.splice(index,1);
                }

            });

        }

        $scope.setMarkers = function () {
                var tempObject = {};
                $scope.flaskUsDetails=[];
                angular.forEach($scope.eventDetails, function (value, index) {
                    tempObject = {};
                    value = angular.fromJson(value);
                    tempObject = angular.fromJson(value.Detail);
                    tempObject.id = index;
                    if ($scope.infoTypeName == tempObject.infoTypeName) {
                        if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            $scope.flaskUsDetails.push(tempObject);
                        }
                    }
                });


        }
        $scope.setMarkers();

    }
})();
