(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsMessageCtrl', FriendsMessageCtrl);

    FriendsMessageCtrl.$inject = ['$scope', '$http', '$ionicModal', 'FriendsNotificationService', '$flaskUtil', '$state','$ionicHistory'];

    /* @ngInject */
    function FriendsMessageCtrl($scope, $http, $ionicModal, FriendsNotificationService, $flaskUtil, $state,$ionicHistory) {
        $scope.allMessages=[];
    FriendsNotificationService.getMyAllMessages().then(function(response){
       $scope.allMessages=response;
        angular.forEach($scope.allMessages,function(value,key){
            $scope.messageDate=new Date(value.dateTime);
            var result=getTimeDifference();
            value.diffDate=result;
        });
    });
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }

   function getTimeDifference(){
       var todayDate=new Date();
       var differenceTravel = todayDate.getTime()-$scope.messageDate.getTime();
       var seconds = Math.floor((differenceTravel) / (1000));
       var days=parseInt((seconds/(3600*24) ));
       var hours=parseInt(seconds/3600);
       var minutes=parseInt(seconds/60);
       var months=parseInt(days/30);
       var year=parseInt(months/12);
       if(minutes<60){
           return minutes+'minutes ago';
       }else if(hours<24){
           return hours+" hours ago";
       }
       else if(days<31){
           return days+" days ago"
       }else if(months<12){
           return months+" month ago"

       }else {
           year+" year ago"
       }
   }
    $scope.deleteMessage=function(messageId,index){
    FriendsNotificationService.deleteMessageById(messageId).then(function(response){
        if(response){
            $scope.allMessages.splice(index,1);
        }

    })
    }

    }
})();