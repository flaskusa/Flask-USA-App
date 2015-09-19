var _flaskAd = {};

_flaskAd.UTILITY = {
		AUTOPLAY		: 3000
}

_flaskAd.ShowAdByEventId = function(eventId){
	var flaskRequest = new Request();
	var param = {eventId: eventId};
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_EVENT_CAMPAIGNS , param, 
		function (data){
			var campaignIds = [];
			for(var iCount=0;iCount<data.length;iCount++){
				campaignIds.push(data[iCount].campaignId);
			}
			_flaskAd.GetAdImages(campaignIds)			
		} ,
		function (data){
			console.log("Error in getting ads: " + data );
	});
}

_flaskAd.GetAdImages = function(Obj){
	var adContainer = $("<div/>");
	adContainer.attr('id','fixedfooter');
	adContainer.owlCarousel({
		items:3,
		//navigation:true,
		navigationText:["<i class='icon-chevron-left icon-white'></i>","<i class='icon-chevron-right icon-white'></i>"],
		pagination:true,
		autoPlay : true,
		slideSpeed : 200
	});

	var imageUUIDArray = [];
	for(var iCount=0;iCount<Obj.length;iCount++){
		var campaignId = Obj[iCount];
		var flaskRequest = new Request();
		var param = {campaignId: campaignId};
		flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_CAMPAIGN_IMAGES , param, 
			function (data){
				var objCampaignImages = data.campaignImages
				for(var iCount=0;iCount<objCampaignImages.length;iCount++){
					var objCampaignImage = $.parseJSON(objCampaignImages[iCount].campaignImage);
					var imageURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + objCampaignImage.imageUUID + "&groupId="+objCampaignImage.imageGroupId;
					var adSlide = $('<div/>',{'class':'adSlide','style':'background-image:url('+imageURL+');background-size: inherit;min-height: 95px;'});					
					adContainer.data('owlCarousel').addItem(adSlide);
					$("body").append(adContainer);
				}
			} ,
			function (data){
				console.log("Error in getting ads: " + data );
		});		
	}
}
