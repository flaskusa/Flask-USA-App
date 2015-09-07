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
	 if(tdata.Events.length == 0){
		$("<span class='control-label-nocolor'>There are no events</span>").appendTo($("#placeholder"));
		return;
	 }
	 for(var i=0; i < tdata.Events.length; i++)
		{
		 	var flaskEvent = tdata.Events[i];
		 	console.log(flaskEvent);
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
		    var objTd2 = $('<td/>',{'data-id':flaskEvent.eventId,'data-venueId':flaskEvent.venueId});
		    
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
		 		window.location.hash = '#Gallery';
		 	});
		 	if(Liferay.ThemeDisplay.isSignedIn()){
			 	$(div_heart).click(function(){
			 		setMyEvent($(this).attr("data-eventId"),$(this).attr("data-userEvent"));
			 	});
		 	}else{
		 		$(div_heart).attr("title", "You need to be signed in to save events.");
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
	getVenueData(venueId);
	var flaskRequest = new Request();
	params= {'eventId': eventId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENTDETAIL_WITH_IMAGES , params, 
		function(data){
			var arrPreEvent = [];
			var arrDurEvent = [];
			var arrPosEvent = [];
			var objWeatherDiv = $("<div/>",{'class':'WeatherSlide'});
		    $(objWeatherDiv).html($("#weather-background"));
		    arrPreEvent.push(objWeatherDiv);	
			objEventDetails = data.EventDetails;
			eventDetailJSON = $.extend(true, {}, objEventDetails);
			$.each(objEventDetails, function(idx, obj) {
				objEventDetail = jQuery.parseJSON(obj.EventDetail);
				if(objEventDetail.latitude != "")
					{
						lat_marker.push([objEventDetail.latitude, objEventDetail.infoTypeId]);
						lng_marker.push(objEventDetail.longitude);
						addr_name.push(objEventDetail.infoTitle);
					}
				var imgURL = "";
				switch(parseInt(objEventDetail.infoTypeId)) {
				case  1: case 2:
			    	arrPreEvent = fnFillImageArray(obj.EventDetailImages,obj.EventDetail,arrPreEvent)
			        break;
			    case 3:
			    	arrDurEvent = fnFillImageArray(obj.EventDetailImages,obj.EventDetail,arrDurEvent)
			        break;
			    case 4:
			    	arrPosEvent = fnFillImageArray(obj.EventDetailImages,obj.EventDetail,arrPosEvent)
			        break;
				}				
			});				
			fnSlider(2,arrPreEvent,eventId,venueId);
			fnSlider(3,arrDurEvent,eventId,venueId);
			fnSlider(4,arrPosEvent,eventId,venueId);
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
			var objtbl = $("<table/>",{'cellpadding':'5px'});
			$.each(objFields, function(idx, obj){
				var objtrHead = $("<tr/>");
				$.each(obj,function(key,value){
					var objtr = $("<tr/>");
					var valueTd = $("<td/>",{'align':'left','width':'100%'});				
					var evalue = eval("objEventDetails."+key);
					var caption = value;
					$(valueTd).html(evalue);
					$(valueTd).appendTo($(objtr));
					$(objtr).appendTo($(objtbl));
				});
			});
			
			var imgURL = "";
			var objMainTable = $("<table/>",{'class':'eventDetailBoxWithImages'});
			var objMainTr = $("<tr/>");
			var imageTd = $("<td/>",{'align':'left','valign':'top'});
			var textDataTd = $("<td/>",{'align':'left','valign':'top'});
			var objContent = $("<div/>",{'width':'100%'});

			objImage = jQuery.parseJSON(objImg.EventDetailImage);
			imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+objImage.imageUUID+"&groupId="+objImage.imageGroupId;
			$(objContent).attr("style","background:url('"+imgURL+"');");
			$(objContent).addClass("slideImage");
			$(objContent).appendTo(imageTd);
			
			$(imageTd).appendTo($(objMainTr));
			$(objtbl).appendTo($(textDataTd));
			$(textDataTd).appendTo($(objMainTr));
			$(objMainTr).appendTo($(objMainTable));

			objArray.push($(objMainTable));
		});
	}
	else{
		$.each(objFields, function(idx, obj){
			var objContent = $("<div/>",{'class':'eventDetailBox'});
			var objtbl = $("<table/>",{'cellpadding':'5px'});
			var objtrHead = $("<tr/>");
			var objth = $("<th/>",{'colspan':'2'});
			$(objth).html(infoTypeCategoryName);
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

function fnSlider(infoType,arrImage,eventId,venueId){
	var Slider = "#wowslider-container"+infoType;
	$(Slider).html("");
	$(Slider).attr("class","Carousel");
	$(Slider).attr('data-eventId',eventId);
	$(Slider).attr('data-venueId',venueId);
	$(Slider).owlCarousel({
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
				initializeMap();
		 		initMenuList();	 		
		 		window.location.hash = '#Details';
		 		$("#spinningSquaresG").hide();
			});
			$(Slider).data('owlCarousel').addItem(objDiv);
		});
	}
	else{
		fnBlankSlide(Slider);
	}
	
	/*$(Slider).owlCarousel({
		items:3,
		navigation:true,
		navigationText:["<i class='icon-chevron-left icon-white'></i>","<i class='icon-chevron-right icon-white'></i>"],
		pagination:true
	});*/
	var click = new Date();
	var lastClick = new Date();
	var lastRow = -1;
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
		$('#one').show();
		$('#two').hide();
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
	if(showAllEvents){
		startdate = "";
		enddate = "";
	}
	var params = {eventTypeIds: '',startDate: startdate,endDate: enddate,searchString: '', latitude: _eventModel.currentGeoLocation.latitude, longitude: _eventModel.currentGeoLocation.longitude};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILTERED_EVENTS , params, 
		function (data){
			renderEventList(data);
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


function getVenueData(venueId){
	var flaskRequest = new Request();
	params = {venueId:venueId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_VENUE, params, 
	function(data){
		venueName = data.venueName;
		venueAddr = data.addrLine1;
		callWeather(data.latitude, data.longitude);
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
	});
}

function initMenuList(){
	var arr = [], len;
	var menuContainer = $("#jqxWidget");
	menuContainer.html("");
	var divTabs = $("<div/>",{'style':'width:100%;height:100%'});
	for(key in eventDetailJSON) {
		arr.push(key); // get JSON array length
	}
	len = arr.length;
	if(len>0){
		//var menuContainer = $("#jqxWidget"); //tab main div
		var menuArray = [];
		var detailsJSONArray = [];
		var ulObj = $("<ul/>");
		for(var iCount=0;iCount<len;iCount++){
			var eachEventDetailJSON = $.parseJSON(eventDetailJSON[iCount].EventDetail);
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
			console.log(a);
			console.log(b);
			var divObj = $("<div/>",{"class":b + " Carousel"});
			var divSlider = $("<div/>",{"class":"MainSlider"});
			$(divSlider).owlCarousel();
			$.each(eventDetailJSON,function(x,y){
				var EventDetailJSON = $.parseJSON(y.EventDetail);
				if(EventDetailJSON.infoTypeCategoryName == b){
					var divSlideObj = $("<div/>",{"class":"photo"});
					var objFields = _eventModel.getObjectFields(EventDetailJSON.infoTypeCategoryName.toLowerCase());
					var objtbl = $("<table/>",{'cellpadding':'5px','width':screenWidth + 'px'});
					$.each(objFields, function(idx, obj){
						$.each(obj,function(key,value){
							var objtr = $("<tr/>");
							var valueTd = $("<td/>",{'align':'left','width':'100%'});				
							var evalue = eval("EventDetailJSON."+key);
							var caption = value;
							$(valueTd).html(evalue);
							$(valueTd).appendTo($(objtr));
							$(objtr).appendTo($(objtbl));
						});
						$(objtbl).appendTo($(divSlideObj));							
						$(divSlider).data('owlCarousel').addItem(divSlideObj);
					});	
					$(divSlider).appendTo($(divObj));														
				}
			});
			$(divObj).appendTo(divTabs);
			$(divTabs).appendTo(menuContainer);					
		});
		
		$(divTabs).jqxTabs({ 
			width: '100%',
			height: '100%',
			scrollPosition: 'both'
		});	
	}
	else{
		$(menuContainer).html("No data found");
		$(menuContainer).addClass("jqxNoDataFound");
		//_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
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
