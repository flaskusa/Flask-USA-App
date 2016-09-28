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
        $scope.EventTypeInfo=$stateParams.infoType;
        $scope.duringEventInfo = 'During-Event';
        $scope.preEventInfo = 'Pre-Event';
        $scope.postEventInfo="Post-Event";
        $scope.flaskUsDetails=[];
        $scope.flaskUsDetails1=[];
        $scope.flaskUsDetails2=[];
        $scope.flaskUsDetails3=[];
        $scope.editContent=false;
        $scope.content={infoTitle:"",infoDesc:""};

        $scope.infoTypeCategoryId=103;

        $scope.addContent=function(content,index) {
            if (content.eventDetailId <= 0 || content.eventDetailId == undefined) {
                EventsService.addContentDuringEvent(content.infoTitle, content.infoDesc, $scope.currEventId,$scope.infoTypeCategoryId,$scope.infoTypeId).then(function (response) {
                   if(response.data.eventDetailId) {
                       $scope.flaskUsDetails.push(response.data);
                       $scope.editContent = false;
                   }else{

                   }
                })
            }
            else if (content.eventDetailId > 0) {
                    EventsService.updateEventDetailDuringEvent(content.infoTitle, content.infoDesc, $scope.currEventId, content.eventDetailId,$scope.infoTypeCategoryId,$scope.infoTypeId).then(function (response) {
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

        $scope.getFlaskUsDetail = function () {
                var tempObject = {};
                $scope.flaskUsDetails1=[];
                $scope.flaskUsDetails2=[];
                $scope.flaskUsDetails3=[];
                angular.forEach($scope.eventDetails, function (value, index) {
                    tempObject = {};
                    value = angular.fromJson(value);
                    tempObject = angular.fromJson(value.Detail);
                    tempObject.id = index;
                    if ($scope.duringEventInfo == tempObject.infoTypeName) {
                        if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            $scope.flaskUsDetails1.push(tempObject);
                        }
                    }
                    else if($scope.preEventInfo==tempObject.infoTypeName){
                        if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            $scope.flaskUsDetails2.push(tempObject);
                        }
                    }
                    else if($scope.postEventInfo==tempObject.infoTypeName){
                        if ("Flask Us" == tempObject.infoTypeCategoryName) {
                            $scope.flaskUsDetails3.push(tempObject);
                        }
                    }

                });

            if($scope.EventTypeInfo==$scope.duringEventInfo){
                $scope.flaskUsDetails=$scope.flaskUsDetails1;
                $scope.infoTypeCategoryId=103;
                $scope.infoTypeId=2;
            }
            else if($scope.EventTypeInfo==$scope.preEventInfo){
                $scope.flaskUsDetails=$scope.flaskUsDetails2;
                $scope.infoTypeCategoryId=8;
                $scope.infoTypeId=1;
            }
            else if($scope.EventTypeInfo==$scope.postEventInfo){
                $scope.flaskUsDetails=$scope.flaskUsDetails3;
                $scope.infoTypeCategoryId=204;
                $scope.infoTypeId=3;
            }


        }

        $scope.getFlaskUsDetail();

    }
})();
