function initSlider(){
	var adPlaceHolder = $(".adCarousel");
	generateAdSlides(adPlaceHolder);
	$(adPlaceHolder).owlCarousel();
}

$(document).ready(function(){
	initSlider();
})

function generateAdSlides(placeHolder){
	var adImages = ["https://www.maysalward.com/wp-content/uploads/2013/12/banner_dominos.jpg","http://www.itv.com/img/470x113/dominos-banner-718d06d9-a707-4aa8-bbbf-a78856420a6f.jpg","https://localmotors.com/wp-content/uploads/2012/08/DominosBanner.jpg"]
	//Get images in array logic here  
	for(var iCount=0;iCount<adImages.length;iCount++){
		var adSlide = $('<div/>',{'class':'adSlide','style':'background-image:url('+adImages[iCount]+')'});
		$(adSlide).appendTo($(placeHolder));
	}
}
