var showAllEvents = true;
var alllist = [];
var map;
var lat_marker = [];
var lng_marker = [];
var addr_name = [];
var eventDetailJSON = {};
var marker_infoType;
var venueName;
var venueAddr;
var startdate = "";
var enddate = "";

function formatUnixToTime(tdate)
{
	var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var ampm = hours >= 12 ? 'PM' : 'AM';
	hours = hours % 12;
	return hours + ':' + minutes.substr(-2) + ' ' + ampm;
}

function renderEventList(tdata) {
	 var divRow = $('#placeholder');
	 $(divRow).html("");
	 if(tdata.Events == null || tdata.Events.length == 0){
		$("<span class='control-label-nocolor'>There are no events</span>").appendTo($("#placeholder"));
		return;
	 }
	 for(var i=0; i < tdata.Events.length; i++)
		{
		 	var flaskEvent = tdata.Events[i];
		    var st = formatUnixToTime(flaskEvent.startTime);
		    var eventDate = formatDate(flaskEvent.eventDate)
		    var objTable = $('<table/>',{'class':'tblRow'});
		    var objTr = $('<tr/>');
		    $(objTr).appendTo($(objTable));
		    var objTd1 = $('<td/>',{'width':'34px'});
		    $(objTd1).appendTo($(objTr));
		    
		    fnShowEventLogo(flaskEvent.eventImageUUID, flaskEvent.eventImageGroupId, objTd1,false);		    
		    var eventName_lbl = $('<div/>',{'class':'control-label-color'});
		    $(eventName_lbl).html(flaskEvent.eventName);
		    var objTd2 = $('<td/>',{'data-id':flaskEvent.eventId,'data-venueId':flaskEvent.venueId,'class':'eventList'});
		    
		    var venue_lbl = $('<div/>',{'class':'control-label-nocolor'});
		    $(venue_lbl).html(eventDate +' '+ st + ' at ' + flaskEvent.venueName);
		    $(eventName_lbl).appendTo($(objTd2));
		    $(venue_lbl).appendTo($(objTd2));
		    $(objTd2).appendTo(objTr);
		    $(objTable).appendTo($(divRow));
		    var objTd3 = $('<td/>',{'width':'34px'});
		    if(flaskEvent.userEvent == 1){
		    	var div_heart = $('<div/>',{'class':'heart-shape-userevent miniLogo','data-eventId':flaskEvent.eventId,'data-userEvent':flaskEvent.userEvent});
		    }else{
		    	var div_heart = $('<div/>',{'class':'heart-shape miniLogo','data-eventId':flaskEvent.eventId,'data-userEvent':flaskEvent.userEvent});
		    }
		    $(div_heart).appendTo($(objTd3));
		    $(objTd3).appendTo(objTr);
		    
		 	$(objTd2).click(function(){
		 		$("#spinningSquaresG").show();
		 		$('#one').hide();
		 		$("#weather-background").show();
		 		fnGetEventImages($(this).attr("data-id"),$(this).attr("data-venueId"));
		 		showEventAds($(this).attr("data-id"));
		 		window.location.hash = '#Gallery';
		 	});
		 	if(Liferay.ThemeDisplay.isSignedIn()){
			 	$(div_heart).click(function(){
			 		setMyEvent($(this).attr("data-eventId"),$(this).attr("data-userEvent"));
			 	});
		 	}else{
		 		$(div_heart).attr("title", "You need to be signed in to save events.");
			 	$(div_heart).click(function(){
			 		alert("You need to be signed in to save events");
			 	});
		 	}
	    }
	 	$(divRow).appendTo($("#placeholder"));
}

function getEventsForLocation(){
	   if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(setLocationObject, locationError);
	    } else {
	        _flaskLib.showErrorMessage(_eventModel.LOCATION_ERROR);
	        locationError();
	    }
}

function setLocationObject(position){
	_eventModel.currentGeoLocation.latitude =  position.coords.latitude;
	_eventModel.currentGeoLocation.longitude = position.coords.longitude;
	getFilteredEvents();
}
function locationError(error){
	_flaskLib.showErrorMessage(_eventModel.LOCATION_ERROR);
	_eventModel.setDetroitAsGeoLocation()
	getFilteredEvents();
}

function fnShowEventLogo(imageUUID, imageGroupId,container ,editable){
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo miniLogo','style':'background-image:url('+imgURL+')'});
	$(objdiv).appendTo($(container));
	if(editable){
    	$(objdiv).click(function(){
	    	$(this).toggleClass("activeImage");
	    	if($(".activeImage").length>0){
	    		if(iSelected==false){
	    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
	    			$(objDel).appendTo($(container));
	    			iSelected = true;
	    			$(objDel).click(function(){
	    				$("#spinningSquaresG").show();
	    				$(".activeImage").each(function(){
	    					fnDeleteFileByEntryId($(this).attr("data-fileEntryId"),objDel);
	    					$(this).remove();
	    				});
	    				if($(".activeImage").length==0){
	    					$("#spinningSquaresG").hide();
	    					$(this).remove();
	    					iSelected = false;
	    				}
	    			});
	    		}
	    	}
	    	else{
	    		$(".cssDelImages").remove();
	    		iSelected = false;
	    	}
	    });	
    	
    }
}

function fnGetEventImages(eventId,venueId){
	var flaskRequest = new Request();
	params= {'eventId': eventId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT_VENUE_DETAIL_WITH_IMAGES , params, 
		function(data){
			var arrPreEvent = [];
			var arrDurEvent = [];
			var arrPosEvent = [];
			var arrPreEventDetails = [];
			var arrDurEventDetails = [];
			var arrPosEventDetails = [];
			var objVenue = jQuery.parseJSON(data.Venue);
			getVenueData(objVenue);
			objEventDetails = data.Details;
			eventDetailJSON = $.extend(true, {}, objEventDetails);
			$.each(objEventDetails, function(idx, obj) {
				objEventDetail = jQuery.parseJSON(obj.Detail);
				if(objEventDetail.latitude != "")
					{
						lat_marker.push([objEventDetail.latitude, objEventDetail.infoTypeId]);
						lng_marker.push(objEventDetail.longitude);
						addr_name.push(objEventDetail.infoTitle);
					}
				var imgURL = "";
				switch(parseInt(objEventDetail.infoTypeId)) {
					case  _eventModel.INFO_TYPE.PreEvent: 
				    	arrPreEvent = fnFillImageArray(obj.DetailImages,obj.Detail,arrPreEvent)
				    	arrPreEventDetails.push(obj);
				        break;
				    case _eventModel.INFO_TYPE.DuringEvent:
				    	arrDurEvent = fnFillImageArray(obj.DetailImages,obj.Detail,arrDurEvent)
				    	arrDurEventDetails.push(obj);
				        break;
				    case _eventModel.INFO_TYPE.PostEvent:
				    	arrPosEvent = fnFillImageArray(obj.DetailImages,obj.Detail,arrPosEvent)
				    	arrPosEventDetails.push(obj);
				    	break;
				}				
			});
			var objWeatherDiv = $("<div/>",{'class':'WeatherSlide'});
		    $(objWeatherDiv).html($("#weather-background"));
		    arrPreEvent.splice(1,0,objWeatherDiv);
		    
			fnSlider(_eventModel.INFO_TYPE.PreEvent, arrPreEvent,eventId,venueId,arrPreEventDetails);
			fnSlider(_eventModel.INFO_TYPE.DuringEvent, arrDurEvent,eventId,venueId,arrDurEventDetails);
			fnSlider(_eventModel.INFO_TYPE.PostEvent, arrPosEvent,eventId,venueId,arrPosEventDetails);
			fnStopProgress();
		},
		function (data){
			console.log("Error in getting Folder: " + data );
			fnStopProgress();
		});	
}

function fnFillImageArray(eventDetailImages,eventDetails,objArray){
	var objEventDetails = jQuery.parseJSON(eventDetails);
	var infoTypeCategoryName = objEventDetails.infoTypeCategoryName.toLowerCase()
	var objFields =_eventModel.getObjectFields(infoTypeCategoryName);
	if(eventDetailImages.length>0){
		$.each(eventDetailImages, function(idx, objImg) {
			if(objEventDetails.showDescription){
				var imgURL = "";
				var objMainTable = $("<table/>",{'class':'eventDetailBoxWithImages'});
				var objMainTr = $("<tr/>");
				var imageTd = $("<td/>",{'align':'left','valign':'top'});
				var textDataTd = $("<td/>",{'align':'left','valign':'top'});
				var objContent = $("<div/>",{'width':'100%'});
				
				var objtbl = $("<table/>",{'cellpadding':'5px'});
				$.each(objFields, function(idx, obj){
					var objtrHead = $("<tr/>");
					$.each(obj,function(key,value){
						var objtr = $("<tr/>");
						var valueTd = $("<td/>",{'align':'left','width':'100%'});				
						var evalue = eval("objEventDetails."+key);
						var caption = value;
						if(caption=="Phone"){
							var objAnchor = $("<a/>",{'href':'tel:'+evalue});
							objAnchor.html(evalue);
							$(valueTd).append(objAnchor);
						}
						else if(caption=="Website"){
							var objAnchor = $("<a/>",{'href':'http://'+evalue,'target':'_blank'});
							objAnchor.html(evalue);
							$(valueTd).append(objAnchor);							
						}
						else{
							$(valueTd).html(evalue);	
						}
						$(valueTd).appendTo($(objtr));
						$(objtr).appendTo($(objtbl));
					});
				});
				$(objtbl).appendTo($(textDataTd));
				objImage = jQuery.parseJSON(objImg.DetailImage);
				imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+objImage.imageUUID+"&groupId="+objImage.imageGroupId;
				$(objContent).attr("style","background:url('"+imgURL+"');");
				$(objContent).addClass("slideImage");
				$(objContent).appendTo(imageTd);
				
				$(imageTd).appendTo($(objMainTr));
				$(textDataTd).appendTo($(objMainTr));
				
				$(objMainTr).appendTo($(objMainTable));
				objArray.push($(objMainTable));
			}
			else{
				objImage = jQuery.parseJSON(objImg.DetailImage);
				imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+objImage.imageUUID+"&groupId="+objImage.imageGroupId;
				var imgObj = $("<img/>",{'src':imgURL,'height':'100%','width':'100%'});
				objArray.push(imgObj);
			}
		});
	}
	else{
		$.each(objFields, function(idx, obj){
			var objContent = $("<div/>",{'class':'eventDetailBox'});
			var objtbl = $("<table/>",{'cellpadding':'5px'});
			var objtrHead = $("<tr/>");
			var objth = $("<th/>",{'colspan':'2'});
			$(objth).html(infoTypeCategoryName.toUpperCase());
			$(objth).appendTo($(objtbl));
			$.each(obj,function(key,value){
				var objtr = $("<tr/>");
				var captionObj = $("<td/>",{'align':'left','width':'30%'});
				var valueObj = $("<td/>",{'align':'left','width':'70%'});				
				var evalue = eval("objEventDetails."+key);
				var caption = value;
				$(captionObj).html(caption);
				$(captionObj).appendTo($(objtr));
				$(valueObj).html(evalue);
				$(valueObj).appendTo($(objtr));
				$(objtr).appendTo($(objtbl));
				$(objtbl).appendTo($(objContent));
			});
			objArray.push(objContent);			
		});
	}
	return objArray;
}

function fnSlider(infoType,arrImage,eventId,venueId,objDetails){
	var Slider = "#wowslider-container"+infoType;
	fnCreateSlider(Slider,eventId,venueId,arrImage,infoType,objDetails);
}

function fnBlankSlide(Slider){
  	var temp_html = '<font color="white"><h4>NO DATA FOUND</h4></font>';
	var objBlankSlide1 = $("<div/>",{'class':'photo'});
	var objBlankSlide = $("<div/>",{'class':'eventDetailBox', 'style':'padding-top: 25% !important;'});
	$(objBlankSlide).appendTo(objBlankSlide1);
	$(objBlankSlide).html(temp_html);
	$(objBlankSlide1).appendTo(Slider);
}

$(document).ready(function(){
	//fnLoadList();
	$(".cssback").click(function(){
		window.history.back();
		//$('#one').show();
		//$('#two').hide();
	});
	//Search options
	jQuery.expr[':'].case_insensitive_contains = function(a, i, m) {
		return jQuery(a).text().toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
	};	
	
	$("#txtSearch").keyup(function(){
		$(".row-fluid .span9 .lbldiv:case_insensitive_contains("+$(this).val()+")").closest(".row-fluid").show(250, function() {});
		$(".row-fluid .span9 .lbldiv:not(:case_insensitive_contains("+$(this).val()+"))").closest(".row-fluid").hide(500, function() {});		
	});
	$("#sign-in").hide();
	window.location.hash = '#List';
	
	$(window).hashchange( function(){
		var hash = location.hash;
		switch(hash) {
	    case "#List":
			$('#one').show();
			$('#two').hide();
			$('#three').hide();
			showAds();
			break;
	    case "#Gallery":
			$('#one').hide();
			$('#two').show();
			$('#three').hide();
	        break;
	    case "#Details":
			$('#one').hide();
			$('#two').hide();
			$('#three').show();
	        break;	        
	    default:
	    	//alert("This is default");
		}		
	})
	
	$(function() {
	    function cb(start, end, label) {
	        $('#reportrange span').html(label);
	        startdate = start;
	        enddate = end;
	        getEventsForLocation();
	    }
	    
	    cb(moment(),moment().add(7, 'days'),'Next 7 days');

	    $('#reportrange').daterangepicker({
	    	"autoApply": true,
	        ranges: {
	           'Today': [moment(), moment()],
	           'Next 7 days': [moment(),moment().add(7, 'days')],
	           'Next 30 days': [moment(), moment().add(30, 'days')],
	           'Next 60 days': [moment(),moment().add(60, 'days')]
	        },
	        "applyClass": "btn btn-info btn-calendar",
	        "cancelClass": "btn btn-info btn-calendar"
	    }, cb);
	    
	    $('#reportrange').data('daterangepicker').setStartDate(moment());
	    $('#reportrange').data('daterangepicker').setEndDate(moment().add(7, 'days'));		    	
	});	
 	
 	$("#txtSearch").change(function(){
 		getFilteredEvents();
 	});	
});

function fnStopProgress(){
	$("#spinningSquaresG").hide();	
 	$('#two').show();	
 	$(".ws_controls").hide();
}

function setMyEvent(_eventId,_userEvent){
	var eventId = parseInt(_eventId);
	var myEvent = parseInt(_userEvent);
	if(myEvent == 0 ){
		addUserEvent(eventId);
	}else{
		removeUserEvent(eventId);
	}
}
function initEventList(){
	var _latitude = _eventModel.currentGeoLocation.latitude;
	var _longitude = _eventModel.currentGeoLocation.latitude;

	if(showAllEvents){
		startdate = "";
		enddate = "";
		_latitude = "";
		_longitude = "";
	}
	var params = {eventTypeIds: '',startDate: startdate,endDate: enddate,searchString: 'a', latitude:_latitude, longitude: _longitude};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILTERED_EVENTS , params, 
		function (data){
			renderEventList(data);
			showAds();
		} ,
		function (data){
			console.log("Error ins getting event list" + data );
	});
}

function addUserEvent(eventId){
	var param = {eventId: eventId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.ADD_USER_EVENT , param, 
					function (data){
						initEventList();
					} ,
					function (data){
						console.log("Error ins saving user event" + data );
					});
}

function removeUserEvent(eventId){
	var param = {eventId: eventId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.REMOVE_USER_EVENT , param, 
		function (data){
			initEventList();
		} ,
		function (data){
			console.log("Error in removing user event" + data );
		});
}


function getVenueData(data){
		venueName = data.venueName;
		venueAddr = data.addrLine1;
		callWeather(data.latitude, data.longitude);
}

function initMenuList(objDetails){
	var arr = [], len;
	var menuContainer = $("#jqxWidget");
	menuContainer.html("");
	var divTabs = $("<div/>",{'style':'width:100%;height:100%'});
	for(key in objDetails) {
		arr.push(key); // get JSON array length
	}
	len = arr.length;
	if(len>0){
		//var menuContainer = $("#jqxWidget"); //tab main div
		var menuArray = [];
		var detailsJSONArray = [];
		var ulObj = $("<ul/>");
		for(var iCount=0;iCount<len;iCount++){
			var eachEventDetailJSON = $.parseJSON(objDetails[iCount].Detail);
			if($.inArray(eachEventDetailJSON.infoTypeCategoryName, menuArray) == -1){
				menuArray.push(eachEventDetailJSON.infoTypeCategoryName); 	//Push distinct menu here
				var liObj = $("<li/>");
				$(liObj).html(eachEventDetailJSON.infoTypeCategoryName);
				$(liObj).appendTo($(ulObj));
			}
		}
		$(ulObj).appendTo(divTabs);
		var screenWidth = $(document).width();
		$.each(menuArray,function(a,b){
			var divObj = $("<div/>",{"class":b});
			var objArray = [];
			$.each(objDetails, function(idx, obj) {
				objEventDetail = jQuery.parseJSON(obj.Detail);
				if(objEventDetail.latitude != "")
				{
					lat_marker.push([objEventDetail.latitude, objEventDetail.infoTypeId]);
					lng_marker.push(objEventDetail.longitude);
					addr_name.push(objEventDetail.infoTitle);
				}
				if(b==objEventDetail.infoTypeCategoryName){
					fnFillImageArray(obj.DetailImages,obj.Detail,objArray);					
				}
			});			
			fnCreateSlider1(divObj,objArray);				
			$(divObj).appendTo(divTabs);
			$(divTabs).appendTo(menuContainer);					
		});
		
		$(divTabs).jqxTabs({ 
			width: '100%',
			height: '100%',
			scrollPosition: 'both'
		});	
		callMarkers(menuArray[0].toLowerCase());
		$("li").click(function(){
			var place = $(this).find('.jqx-tabs-titleContentWrapper').html().toLowerCase();
			callMarkers(place);
		});
	}
	else{
		_flaskMap.findPlaces("");
		$(menuContainer).html("No data found");
		$(menuContainer).addClass("jqxNoDataFound");
		//_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
	}
}

function callMarkers(place){
	_flaskMap.clearOverlays();
	if(place == 'bar &amp; restaurants'){
		_flaskMap.findPlaces('bar');
		_flaskMap.findPlaces('restaurant');
	}
	if(place == 'nightlife'){
		_flaskMap.findPlaces('bar');
		_flaskMap.findPlaces('restaurant');
		_flaskMap.findPlaces('night_club');
	}
	if(place == 'liquor store'){
		_flaskMap.findPlaces('liquor_store');
	}
	if(place == 'safety'){
		_flaskMap.findPlaces('police');
		_flaskMap.findPlaces('hospital');
	}
	else{
		_flaskMap.findPlaces(place);
	}
	
}

function getFilteredEvents(){
	var filterString = $("#txtSearch").val();
	var flaskRequest = new Request();
	params = {eventTypeIds: '', startDate: startdate, endDate: enddate,searchString: filterString, latitude: _eventModel.currentGeoLocation.latitude, longitude: _eventModel.currentGeoLocation.longitude};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILTERED_EVENTS, params, 
	function(data){
		renderEventList(data);
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.SEARCH_ERR);
	});	
}

function formatDate(dateVal){
	var dateObj = new Date(dateVal);
	return dateObj.toLocaleDateString(); 
}


function fnCreateSlider(containerID,eventId,venueId,arrImage,infoType,objDetails){
	$(containerID).html("");
	$(containerID).attr("class","Carousel");
	$(containerID).attr('data-eventId',eventId);
	$(containerID).attr('data-venueId',venueId);
	$(containerID).owlCarousel({
		items:3,
		navigation:true,
		navigationText:["<i class='icon-chevron-left icon-white'></i>","<i class='icon-chevron-right icon-white'></i>"],
		pagination:true
	});
	
	if(arrImage.length>0){
		$.each(arrImage, function( index, value ) {
			var objDiv = $("<div/>",{'class':'photo'});
			var objImg = value;
			$(objImg).appendTo(objDiv);
			$(objImg).click(function(event){
		    	$("#spinningSquaresG").show();
		 		$('#one').hide();		 
		 		$('#two').hide();
		 		$('#three').show();
				marker_infoType = infoType;
				// map initialization
				_flaskMap.initializeMap();
		 		initMenuList(objDetails);	 		
		 		window.location.hash = '#Details';
		 		$("#spinningSquaresG").hide();
			});
			$(containerID).data('owlCarousel').addItem(objDiv);
		});
	}
	else{
		fnBlankSlide(containerID);
	}	
}

function fnCreateSlider1(containerID,arrImage){
	$(containerID).html("");
	$(containerID).attr("class","Carousel col2");
	$(containerID).owlCarousel({
		items:3,
		navigation:true,
		navigationText:["<i class='icon-chevron-left icon-white'></i>","<i class='icon-chevron-right icon-white'></i>"],
		pagination:true
	});
	
	if(arrImage.length>0){
		$.each(arrImage, function( index, value ) {
			var objDiv = $("<div/>",{'class':'photo'});
			var objImg = value;
			$(objImg).appendTo(objDiv);
			$(containerID).data('owlCarousel').addItem(objDiv);
		});
	}
	else{
		fnBlankSlide(containerID);
	}	
}

function showAds(){
	var eventList = "0";
	$(".eventList").each(function(){
		eventList = $(this).attr('data-id') + "," + eventList
	});
	_flaskAd.HideAds();
	_flaskAd.ShowAdByEventIds(eventList);
}

function showEventAds(eventId){
	_flaskAd.HideAds();
	_flaskAd.ShowAdByEventId(eventId);
}