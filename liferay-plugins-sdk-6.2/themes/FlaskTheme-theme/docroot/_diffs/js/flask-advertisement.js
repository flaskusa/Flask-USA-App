var _flaskAd = {};

_flaskAd.UTILITY = {
		AUTOPLAY	: 4000
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

_flaskAd.GetAdImagesForMultipleEvents = function(Obj){
	$('#fixedfooter').remove();
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
	var dispOrder = Obj.DisplayOrder;
	
	for(var iCount=0; iCount < 10 ; iCount++){
		var imageUUID = dispOrder[iCount];
		var imageObj = _flaskAd.getImageInfoFromUUID(imageUUID, Obj);
		var address = imageObj.addrLine1 + ", " + imageObj.city + ", " + imageObj.zipCode;
			
		var imageURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + imageObj.imageUUID + "&groupId="+imageObj.imageGroupId;
		var imageFullScreenURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + imageObj.fullScreenUUID + "&groupId="+imageObj.fullScreenGroupId;
		var adSlide = $('<div/>',{'class':'adSlide','data-fullImageURL':imageFullScreenURL,'data-title':imageObj.campaignName,
			'data-website': imageObj.url, 'data-phone': imageObj.phone, 'data-address': address } );
		var adSlideImage = $('<img/>',{'src':imageURL});
		adSlide.append(adSlideImage);
		adContainer.data('owlCarousel').addItem(adSlide);
		adSlide.click(function(){
			var fullImageURL = $(this).attr('data-fullImageURL');
			var campaignTitle = $(this).attr('data-title');
			var objImage = $('<img/>',{'src':fullImageURL});
			objImage.css('display','block');
			objImage.css('margin-left','auto');
			objImage.css('margin-right','auto');
			objImage.css('margin-top','1px');
			var imgContainer = $('.imageContainer');
			$('#adTitle').html("");
			$('#adTitle').html(campaignTitle);
			
			$('#modal-advertisement #website').html($(this).attr('data-website'));
			
			$('#modal-advertisement #phone').html($(this).attr('data-phone'));
			$('#modal-advertisement #address').html($(this).attr('data-address'));
			imgContainer.html("");
			imgContainer.append(objImage);
			
			if($(this).attr('data-phone')!=""){
				var objPhone= $('<div/>',{'class':'adPhone'});
				var objPhoneLink = $("<a/>",{'href':'tel:'+$(this).attr('data-phone')});
				objPhoneLink.html($(this).attr('data-phone'));
				objPhone.html('<span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-phone"></span>');
				objPhone.append(objPhoneLink);
			}
			
			if($(this).attr('data-website')!=""){
				var objWebSite= $('<div/>',{'class':'adWebSite'});
				var objWebSiteLink = $("<a/>",{'href':'http://'+$(this).attr('data-website'),'target':'_blank'});
				objWebSiteLink.html($(this).attr('data-website'))
				objWebSite.html('<span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-website"></span>');
				objWebSite.append(objWebSiteLink);
			}
			
			if($(this).attr('data-address')!=""){
				var objAddress= $('<div/>',{'class':'adAddress'});
				var findUsOnMap = _flaskMap.createMapLink($(this).attr('data-address'));
				objAddress.html('<span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-address"></span>'+findUsOnMap);
			}

			var infoContainer = $('.footerInfo');
			infoContainer.html('');
			infoContainer.append(objPhone);
			infoContainer.append(objWebSite);
			infoContainer.append(objAddress);
			
			$('.md-trigger').click();
		});
		$("body").append(adContainer);
	}
}

_flaskAd.HideAds = function(){
	$('#fixedfooter').hide();
}

_flaskAd.getImageInfoFromUUID = function(imageUUID, jsonObj){
	var campaignImages = jsonObj.Images;
	for(var iCount = 0 ; iCount < campaignImages.length ; iCount++){
		var image =campaignImages[iCount]; 
		if(image.imageUUID == imageUUID){
			return image;
		}
	}
}

_flaskAd.isMobile = {
	    Android: function() {
	        return navigator.userAgent.match(/Android/i);
	    },
	    BlackBerry: function() {
	        return navigator.userAgent.match(/BlackBerry/i);
	    },
	    iOS: function() {
	        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
	    },
	    Opera: function() {
	        return navigator.userAgent.match(/Opera Mini/i);
	    },
	    Windows: function() {
	        return navigator.userAgent.match(/IEMobile/i);
	    }
	};
	//if(isMobile.any())