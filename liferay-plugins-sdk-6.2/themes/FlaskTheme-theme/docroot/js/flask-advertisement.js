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

_flaskAd.ShowAdByEventIds = function(eventIds){
	var flaskRequest = new Request();
	var param = {eventIdList: eventIds};
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_EVENT_CAMPAIGN_IMAGES , param, 
		function (data){
			_flaskAd.GetAdImagesForMultipleEvents(data);
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
		flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_CAMPAIGN_WITH_IMAGES , param, 
			function (data){
				var adCampaign = $.parseJSON(data.AdCampaign);
				var imageFullScreenGrpId = adCampaign.imageGroupId;
				var imageFullScreenUUId = adCampaign.imageUUID;
				var imageFullScreenTitle = adCampaign.campaignName;
				var campaignImages = data.campaignImages;
				for(var iCount=0;iCount<campaignImages.length;iCount++){
					campaignImage = $.parseJSON(campaignImages[iCount].campaignImage);
					var imageURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + campaignImage.imageUUID + "&groupId="+campaignImage.imageGroupId;
					var imageFullScreenURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + imageFullScreenUUId + "&groupId="+imageFullScreenGrpId;
					var adSlide = $('<div/>',{'class':'adSlide','data-fullImageURL':imageFullScreenURL,'data-title':imageFullScreenTitle});
					var adSlideImage = $('<img/>',{'src':imageURL});
					adSlide.append(adSlideImage);
					adContainer.data('owlCarousel').addItem(adSlide);
					adSlide.click(function(){
						var fullImageURL = $(this).attr('data-fullImageURL');
						var campaignTitle = $(this).attr('data-title');
						var objImage = $('<img/>',{'src':fullImageURL});
						var imgContainer = $('.imageContainer');
						$('#myModalLabel').html("");
						$('#myModalLabel').html(campaignTitle);						
						imgContainer.html("");
						imgContainer.append(objImage);
						$('#myModal').modal('show');
					});
					$("body").append(adContainer);
				}
			} ,
			function (data){
				console.log("Error in getting ads: " + data );
		});		
	}
}

_flaskAd.GetAdImagesForMultipleEvents = function(Obj){
	var adContainer = $("<div/>");
	adContainer.attr('id','fixedfooter');
	adContainer.owlCarousel({
		items:3,
		navigationText:["<i class='icon-chevron-left icon-white'></i>","<i class='icon-chevron-right icon-white'></i>"],
		pagination:true,
		autoPlay : true,
		slideSpeed : 200
	});

	var imageUUIDArray = [];
	var objImage = Obj.Images;
	for(var iCount=0;iCount<objImage.length;iCount++){
		objImage[iCount].imageGroupId
		var imageURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + objImage[iCount].imageUUID + "&groupId="+objImage[iCount].imageGroupId;
		var imageFullScreenURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + objImage[iCount].fullScreenUUID + "&groupId="+objImage[iCount].fullScreenGroupId;
		var adSlide = $('<div/>',{'class':'adSlide','data-fullImageURL':imageFullScreenURL,'data-title':objImage[iCount].campaignName});
		var adSlideImage = $('<img/>',{'src':imageURL});
		adSlide.append(adSlideImage);
		adContainer.data('owlCarousel').addItem(adSlide);
		adSlide.click(function(){
			var fullImageURL = $(this).attr('data-fullImageURL');
			var campaignTitle = $(this).attr('data-title');
			var objImage = $('<img/>',{'src':fullImageURL});
			var imgContainer = $('.imageContainer');
			$('#myModalLabel').html("");
			$('#myModalLabel').html(campaignTitle);						
			imgContainer.html("");
			imgContainer.append(objImage);
			$('#myModal').modal('show');
		});
		$("body").append(adContainer);
	}
}

_flaskAd.HideAds = function(){
	$('#fixedfooter').hide();
}