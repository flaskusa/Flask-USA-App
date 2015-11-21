var showAllEvents = false; // Make showAllEvents = false while releasing on server 
var alllist = [];
var map;
var lat_marker = [];
var lng_marker = [];
var addr_name = [];
var placeTitle = [];
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
		 		showAds($(this).attr('data-id'));
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
			console.log(objVenue);
			var distinctInfoTypeCategory1 = [];
			var distinctInfoTypeCategoryCount1 = [];
			var distinctInfoTypeCategory2 = [];
			var distinctInfoTypeCategoryCount2 = [];
			var distinctInfoTypeCategory3 = [];
			var distinctInfoTypeCategoryCount3 = [];
			var temp1 = [];
			var temp2 = [];
			var temp3 = [];
			
			getVenueData(objVenue);
			objEventDetails = data.Details;
			eventDetailJSON = $.extend(true, {}, objEventDetails);
			for(iCount=0;iCount<objEventDetails.length;iCount++){
				var objEventDetailTemp = $.parseJSON(objEventDetails[iCount].Detail);
				switch(parseInt(objEventDetailTemp.infoTypeId)) {
						case  _eventModel.INFO_TYPE.PreEvent: 
					    	_eventModel.GET_EVENT_DETAIL_TYPE_COUNT(objEventDetailTemp,distinctInfoTypeCategory1);
					        break;
					    case _eventModel.INFO_TYPE.DuringEvent:
					    	_eventModel.GET_EVENT_DETAIL_TYPE_COUNT(objEventDetailTemp,distinctInfoTypeCategory2);
					        break;
					    case _eventModel.INFO_TYPE.PostEvent:
					    	_eventModel.GET_EVENT_DETAIL_TYPE_COUNT(objEventDetailTemp,distinctInfoTypeCategory3);
					    	break;
				}		
			}
			
			$.each(objEventDetails, function(idx, obj) {
				objEventDetail = jQuery.parseJSON(obj.Detail);
				if(objEventDetail.latitude != ""){
						lat_marker.push([objEventDetail.latitude, objEventDetail.infoTypeId]);
						lng_marker.push(objEventDetail.longitude);
						addr_name.push(objEventDetail.addrLine1);
				}
				var imgURL = "";
				switch(parseInt(objEventDetail.infoTypeId)) {
					case  _eventModel.INFO_TYPE.PreEvent: 
				    	arrPreEvent = fnFillSlides(obj.DetailImages,obj.Detail,arrPreEvent,distinctInfoTypeCategory1,temp1)
				    	arrPreEventDetails.push(obj);
				        break;
				    case _eventModel.INFO_TYPE.DuringEvent:
				    	arrDurEvent = fnFillSlides(obj.DetailImages,obj.Detail,arrDurEvent,distinctInfoTypeCategory2,temp2)
				    	arrDurEventDetails.push(obj);
				        break;
				    case _eventModel.INFO_TYPE.PostEvent:
				    	arrPosEvent = fnFillSlides(obj.DetailImages,obj.Detail,arrPosEvent,distinctInfoTypeCategory3,temp3)
				    	arrPosEventDetails.push(obj);
				    	break;
				}				
			});
			
			//Weather slide commented as per (COB 10/30).
			/*var objWeatherDiv = $("<div/>",{'class':'WeatherSlide'});
		    $(objWeatherDiv).html($("#weather-background"));
		    var objContent = $("<div/>",{'class':'eventDetailBox'});
		    objContent.append(objWeatherDiv);
		    arrPreEvent.splice(1,0,objContent);*/
		    
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
	var infoTypeCategoryName = objEventDetails.infoTypeCategoryName.toLowerCase();
	var objFields =_eventModel.getObjectFields(infoTypeCategoryName);
	if(eventDetailImages.length>0){
		$.each(eventDetailImages, function(idx, objImg) {
			if(objEventDetails.showDescription){
				var imgURL = "";
				var objContent = $("<div/>",{'width':'100%'});
				$.each(objFields, function(idx, obj){
					//infoTypeCategoryName.toUpperCase() - > title
					var objContent = $("<div/>",{'class':'DetailedSlides'});
					$.each(obj,function(key,value){
						var evalue = eval("objEventDetails."+key);
						if(evalue!='' && evalue!=undefined){
							var caption = value;
							var captionObj = $('<div/>',{'width':'100%','font-size':'18px'}).html(caption);
							var divFormGroup = $('<div/>',{'class':'form-group'});
							var lblControlLabel = $('<label/>',{'class':'control-label','for':caption});
							lblControlLabel.append(captionObj);
							var divControls = $('<div/>',{'class':'controls','id':caption});
							switch(caption) {
								case  "Phone": 
									var objAnchor = $("<a/>",{'href':'tel:'+evalue});
									objAnchor.html(evalue);
									divControls.append(objAnchor);
							        break;
							    case "Website":
									var objAnchor = $("<a/>",{'href':'http://'+evalue,'target':'_blank'});
									objAnchor.html(evalue);
									divControls.append(objAnchor);							
							        break;
							    case "Title":
							    case "Name":
							    	captionObj.html(evalue);
							    	divControls.html('');
									var objImage = jQuery.parseJSON(objImg.DetailImage);
									if(objImage.imageUUID!=""){
										imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+objImage.imageUUID+"&groupId="+objImage.imageGroupId;
										var imgDiv = $('<img/>',{'src':imgURL,'height':'100%','width':'100%'});
										divControls.append(imgDiv);
										divControls.css('height','24vh !important');
									}
							    	break;
							    case "Description":
							    	var objTempDiv = $('<div/>');
							    	objTempDiv.html(evalue);
							    	var tempDesc = $.trim(objTempDiv.text());
							    	if(tempDesc=="" || (tempDesc.charCodeAt(0)==8203 && tempDesc.length==1)){
							    		captionObj.html('');
							    	}
							    	else{
								    	captionObj.html('<b>Flask Us</b>');
								    	divControls.html(evalue);	
										if(infoTypeCategoryName=='flask us'){
											var br = $('<br/>');
											var askUsLink = $('<a/>',{'href':'#','onclick':'showModal();','style':'float:right'});
											askUsLink.html('Ask Us');
											divControls.append(br);
											divControls.append(askUsLink);
										}
							    	}
							    	break;
							    default:
							    	divControls.html(evalue);				    	
							    	break;
							}		
							divFormGroup.append(lblControlLabel);
							divFormGroup.append(divControls);
							divFormGroup.appendTo($(objContent));							
						}
					});
					objArray.push(objContent);			
				});
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
			var objContent = $("<div/>",{'class':'DetailedSlides'});
			$.each(obj,function(key,value){
				var evalue = eval("objEventDetails."+key);
				if(evalue!='' && evalue!=undefined){				
					var caption = value;
					var captionObj = $('<div/>',{'width':'100%','font-size':'18px'}).html(caption);
					var divFormGroup = $('<div/>',{'class':'form-group'});
					var lblControlLabel = $('<label/>',{'class':'control-label','for':caption});
					lblControlLabel.append(captionObj);
					var divControls = $('<div/>',{'class':'controls','id':caption});
					switch(caption) {
						case  "Phone": 
							var objAnchor = $("<a/>",{'href':'tel:'+evalue});
							objAnchor.html(evalue);
							divControls.append(objAnchor);
					        break;
					    case "Website":
							var objAnchor = $("<a/>",{'href':'http://'+evalue,'target':'_blank'});
							objAnchor.html(evalue);
							divControls.append(objAnchor);							
					        break;
					    case "Title":
					    case "Name":
					    	captionObj.html(evalue);
					    	divControls.html('');
					    	break;
					    case "Description":
					    	var objTempDiv = $('<div/>');
					    	objTempDiv.html(evalue);
					    	var tempDesc = $.trim(objTempDiv.text());
					    	if(tempDesc=="" || (tempDesc.charCodeAt(0)==8203 && tempDesc.length==1)){
					    		captionObj.html('');
					    	}
					    	else{
						    	captionObj.html('<b>Flask Us</b>');
						    	divControls.html(evalue);	
								if(infoTypeCategoryName=='flask us'){
									var br = $('<br/>');
									var askUsLink = $('<a/>',{'href':'#','onclick':'showModal();','style':'float:right'});
									askUsLink.html('Ask Us');
									divControls.append(br);
									divControls.append(askUsLink);
								}				    	
					    	}
					    	break;				    	
					    default:
					    	divControls.html(evalue);				    	
					    	break;
					}		
					divFormGroup.append(lblControlLabel);
					divFormGroup.append(divControls);
					divFormGroup.appendTo($(objContent));
				}
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
	var objBlankSlide = $("<div/>",{'class':'InfoContentTypeDetailBox'});
	$(objBlankSlide).html(temp_html);
	$(objBlankSlide).appendTo(Slider);
}

$(document).ready(function(){
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
			showAds(0);
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
	        startdate = start.toDate();
	        enddate = end.toDate();
	        getEventsForLocation();
	    }
	    
	    cb(moment().startOf('day'),moment().add(14, 'days'),'Next 14 days');

	    $('#reportrange').daterangepicker({
	    	"autoApply": true,
	        ranges: {
	           'Today': [moment().startOf('day'), moment()],
	           'Next 7 days': [moment().startOf('day'),moment().startOf('day').add(7, 'days')],
	           'Next 14 days': [moment().startOf('day'),moment().startOf('day').add(14, 'days')],
	           'Next 30 days': [moment().startOf('day'), moment().startOf('day').add(30, 'days')],
	           'Next 60 days': [moment().startOf('day'),moment().startOf('day').add(60, 'days')]
	        },
	        "applyClass": "btn btn-info btn-calendar",
	        "cancelClass": "btn btn-info btn-calendar"
	    }, cb);
	    
	    $('#reportrange').data('daterangepicker').setStartDate(moment());
	    $('#reportrange').data('daterangepicker').setEndDate(moment().add(14, 'days'));		    	
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
	var _longitude = _eventModel.currentGeoLocation.longitude;

	if(showAllEvents){
		_latitude = "";
		_longitude = "";
		startdate = "";
		enddate = "";
	}
	var params = {eventTypeIds: '',startDate: startdate,endDate: enddate,searchString: 'a', latitude:_latitude, longitude: _longitude};//Make searchString: '' while releasing on server
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILTERED_EVENTS , params, 
		function (data){
			renderEventList(data);
			showAds(0);
		} ,
		function (data){
			console.log("Error in getting event list" + data );
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
						console.log("Error in saving user event" + data );
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
		var menuArray = [];
		var detailsJSONArray = [];
		var strFlaskUs = 'Flask Us';
		var ulObj = $("<ul/>");
		var addFlaskUsTab = false;
		for(var iCount=0;iCount<len;iCount++){
			var eachEventDetailJSON = $.parseJSON(objDetails[iCount].Detail);
			if($.inArray(eachEventDetailJSON.infoTypeCategoryName, menuArray) == -1 && eachEventDetailJSON.infoTypeCategoryName!=strFlaskUs){
				menuArray.push(eachEventDetailJSON.infoTypeCategoryName); 	//Push distinct menu here
				var liObj = $("<li/>");
				$(liObj).html(eachEventDetailJSON.infoTypeCategoryName);
				$(liObj).appendTo($(ulObj));
			}
			else{
				if($.inArray(eachEventDetailJSON.infoTypeCategoryName, menuArray) == -1 && eachEventDetailJSON.infoTypeCategoryName==strFlaskUs){
					addFlaskUsTab = true;
				}
			}
		}
		if(addFlaskUsTab){
			menuArray.push(strFlaskUs); 	//Push distinct menu here
			var liObjFlaskUs = $("<li/>");
			$(liObjFlaskUs).html(strFlaskUs);
			$(liObjFlaskUs).appendTo($(ulObj));
			addFlaskUsTab = false;
		}
		$(ulObj).appendTo(divTabs);
		var screenWidth = $(document).width();
		$.each(menuArray,function(a,b){
			var divObj = $("<div/>",{"class":b});
			var isMap = false;
			var objArray = [];
			$.each(objDetails, function(idx, obj) {
				objEventDetail = jQuery.parseJSON(obj.Detail);
				if(objEventDetail.infoTypeCategoryName==b){
					if(objEventDetail.latitude != "0")
					{
						isMap = true;
						lat_marker.push([objEventDetail.latitude, objEventDetail.infoTypeId]);
						lng_marker.push(objEventDetail.longitude);
						placeTitle.push(objEventDetail.infoTitle);
						addr_name.push(objEventDetail.addrLine1);
					}
					if(b==objEventDetail.infoTypeCategoryName){
						fnFillImageArray(obj.DetailImages,obj.Detail,objArray);					
					}
				}			
			});
			
			if($.inArray(b,_flaskMap.allowedContent)>-1){
				fnCreateSlider1(divObj,objArray);
			}
			$(divObj).appendTo(divTabs);
			$(divTabs).appendTo(menuContainer);					
		});
		
		$(divTabs).jqxTabs({ 
			width: '99%',
			height: '100%',
			scrollPosition: 'both'
		});	
	 	$('.jqx-tabs-arrow-left').addClass('icon-arrow-left');
	 	$('.jqx-tabs-arrow-right').addClass('icon-arrow-right');
		//callMarkers(menuArray[0].toLowerCase());
	}
	else{
		_flaskMap.findPlaces("");
		$(menuContainer).html("No data found");
		$(menuContainer).addClass("jqxNoDataFound");
	}
	
	$(divTabs).on('tabclick', function (event){
		var clickedItem = event.args.item;
		var text = $(this).jqxTabs('getTitleAt', clickedItem);
		if($.inArray(text, _flaskMap.allowedContent)==-1){
			$('#gmap_canvas').remove();
			$(this).jqxTabs('setContentAt', clickedItem,'<div id="gmap_canvas" style="height:100%;"></div>');
			setTimeout(function(){
				_flaskMap.initializeMap();
				callMarkers(text.toLowerCase());
			},300);
		}
	});
}

function callMarkers(place){
	_flaskMap.clearOverlays();
	_flaskMap.markerCalled = false;
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
	if(filterString==''){
		filterString='a';
	}
	var flaskRequest = new Request();
	params = {eventTypeIds: '', startDate: startdate, endDate: enddate,searchString: filterString, latitude: _eventModel.currentGeoLocation.latitude, longitude: _eventModel.currentGeoLocation.longitude};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILTERED_EVENTS, params, 
	function(data){
		renderEventList(data);
		showAds(0);
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
		pagination:true,
	    items : 5,
	    itemsCustom : false,
	    itemsDesktop : [1199,4],
	    itemsDesktopSmall : [980,3],
	    itemsTablet: [768,2],
	    itemsTabletSmall: false,
	    itemsMobile : [479,1],
	    singleItem : false,
	    itemsScaleUp : false,		
	});
	if(arrImage.length>0){
		var flaskUsSlide;
		$.each(arrImage, function( index, value ) {
			var objImg = value;
			/*if( objImg.find('#weather-background').length > 0){
				//"";
			}else{*/
			$(objImg).click(function(event){
		    	$("#spinningSquaresG").show();
		 		$('#one').hide();		 
		 		$('#two').hide();
		 		$('#three').show();
				marker_infoType = infoType;
				// map initialization
				initMenuList(objDetails);
		 		getSelectedTab($(this).attr('data-infoTypeCategory'));
		 		window.location.hash = '#Details';
		 		$("#spinningSquaresG").hide();
			});				
			//}
			if(objImg.hasClass('flaskus')){
				flaskUsSlide = objImg;
			}
			else{
				$(containerID).data('owlCarousel').addItem(objImg);				
			}
		});
		if(typeof(flaskUsSlide)=="object"){
			$(containerID).data('owlCarousel').addItem(flaskUsSlide);
		}
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
		pagination:true,
	    items : 5,
	    itemsCustom : false,
	    itemsDesktop : [1199,4],
	    itemsDesktopSmall : [980,3],
	    itemsTablet: [768,2],
	    itemsTabletSmall: false,
	    itemsMobile : [479,1],
	    singleItem : false,
	    itemsScaleUp : false,		
	});
	
	if(arrImage.length>0){
		$.each(arrImage, function( index, value ) {
			var objDiv = $("<div/>");
			var objImg = value;
			$(objImg).appendTo(objDiv);
			$(containerID).data('owlCarousel').addItem(objDiv);
		});
	}
	else{
		fnBlankSlide(containerID);
	}	
}

function showAds(eventId){
	var eventList = "0";
	if(eventId == 0){
		$(".eventList").each(function(){
			eventList = $(this).attr('data-id') + "," + eventList
		});
	}
	else{
		eventList = eventId
	}
	
	_flaskAd.HideAds();
	_flaskAd.ShowAdByEventIds(eventList);
	//below part will go to theme
	$('.md-closeBtn').click(function(){
		$('#modal-advertisement').removeClass('md-show');
	});	
}

function fnFillSlides(eventDetailImages,eventDetails,objArray,distinctInfoTypeCategory,temp){
	var objEventDetails = jQuery.parseJSON(eventDetails);
	var infoTypeCategoryName = objEventDetails.infoTypeCategoryName.toLowerCase();
	var objFields =_eventModel.getObjectFields(infoTypeCategoryName);
	var slideBackgroundImage = '/flask-view-events-portlet/img/'+_eventModel.getBackgroundImage(infoTypeCategoryName);
	$.each(distinctInfoTypeCategory,function(index,KeyVal){
		var elementPosition = $.inArray(KeyVal[0], temp);
		if(infoTypeCategoryName.toUpperCase()==KeyVal[0].toUpperCase() && elementPosition == -1){
			temp.push(KeyVal[0]);
			var flaskUs;
			$.each(objFields, function(idx, obj){
				var objContent = $("<div/>",{'class':'eventDetailBox','data-infoTypeCategory':objEventDetails.infoTypeCategoryName});
				objContent.css('background-image','url("'+slideBackgroundImage+'")');
				objContent.css('background-repeat','no-repeat');
				objContent.css('background-size','100% 100%');
				if(infoTypeCategoryName.toUpperCase()=='FLASK US'){
					objContent.addClass('flaskus');
				}
				
				if(infoTypeCategoryName.toUpperCase()=='PARKING'){
					objArray.unshift(objContent);
				}
				else{
					objArray.push(objContent);
				}
			});
		}
	});		
	return objArray;
}

function getSelectedTab(str){
	var iCount = 0;
	$('.jqx-tabs-titleContentWrapper').each(function(){
		if($(this).html().replace(/&amp;/g, '&')==str && $.inArray($(this).html().replace(/&amp;/g, '&'), _flaskMap.allowedContent)==-1){
			$('.jqx-tabs').jqxTabs('select', iCount);
			$('#gmap_canvas').remove();
			$(this).jqxTabs('setContentAt', iCount,'<div id="gmap_canvas" style="height:100%;"></div>');
			_flaskMap.initializeMap();
			callMarkers($(this).html().toLowerCase());
			return false;
		}
		else{
			if($(this).html().replace(/&amp;/g, '&')==str){
				$('.jqx-tabs').jqxTabs('select', iCount);
				return false;
			}
		}
		iCount = iCount + 1; 
	});
}

function showModal(){
	$('#adTitle').html("Ask Us");
	$('.imageContainer').html('');
	$('#modal-advertisement').addClass('md-effect-4');
	var emailId = '';
	$('.footerInfo').html('');
	$('.footerInfo').css('background','none');
	$('.footerInfo').css('text-align','right');
	if(Liferay.ThemeDisplay.isSignedIn()){
		/*var txtEmailId = CreateFormGroup('Email','txtEmail','text',254);
		txtEmailId.appendTo($('.imageContainer'));*/
		var txtSubject = CreateFormGroup('Title','txtSubject','text',254);
		txtSubject.appendTo($('.imageContainer'));
		
		var txtDescription = CreateFormGroup('Description','txtDescription','textarea',1000);
		txtDescription.appendTo($('.imageContainer'));
		
		var btnSend = $('<button/>',{'class':'md-send btn btn-primary','style':'display:inline-block;margin-left:3px !important;'});
		btnSend.html('Ok');
		btnSend.click(function(){
			var strEmailId = '';
			var flaskRequest   = new Request();
			var strSubject     = $('#txtSubject').val();
			var strDescription = $('#txtDescription').val();
			if(!Liferay.ThemeDisplay.isSignedIn())
				var strEmailId = $('#txtEmail').val();
			
			if(ValidateAskUsForm()){
				var params = {fromMail: strEmailId,subject:strSubject, description: strDescription};
				flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.SEND_MAIL, params, 
				function(data){
					console.log(data);
					var errContainer = $('<div/>',{'style':'margin: 20px;'});
					var errDiv = $('<div/>',{'class':'alert alert-success fade in'});
					errContainer.append(errDiv);
					errDiv.html('<strong>Email Sent!</strong>');
					errContainer.appendTo($('.imageContainer'));
					$('#modal-advertisement').removeClass('md-show').delay(2000);
				} , function(error){
					console.log(error);
				});			
			}
		});
		$('.footerInfo').append(btnSend);
		var errDiv = $('<div/>',{'id':'action-msg-warning','style':'display:none'});
		errDiv.appendTo($('.imageContainer'));
	}
	else{
		var errContainer = $('<div/>',{'style':'margin: 20px;'});
		var errDiv = $('<div/>',{'class':'alert alert-warning fade in'});
		errContainer.append(errDiv);
		errDiv.html('<strong>Note!</strong> You must be logged in to use this feature.');
		errContainer.appendTo($('.imageContainer'));
	}
	
	var btnCancel = $('<button/>',{'class':'md-cancel btn btn-primary','style':'display:inline-block;margin-left:3px !important;'});
	btnCancel.html('Cancel');
	btnCancel.click(function(){
		$('#adTitle').html('');
		$('.imageContainer').html('');
		$('.footerInfo').html('');	
		$('.footerInfo').css('background','rgba(0, 0, 0, 0.71)');
		$('.footerInfo').css('text-align','left');
		$('#modal-advertisement').removeClass('md-show');	
	});
	
	$('.footerInfo').append(btnCancel);
	$('.md-trigger').click();
	$('#modal-advertisement').removeClass('md-effect-4');
}


function CreateFormGroup(inputFieldLabel,inputFieldId,inputFieldType,maxLength){
	if(inputFieldType=='textarea')
		var txtField = $('<textarea/>',{'style':'width: 288px; margin: 0px 0px 10px; height: 120px;','id':inputFieldId});
	else
		var txtField = $('<input/>',{'type':inputFieldType,'maxlength':maxLength,'id':inputFieldId});
	
	var divControls = $('<div/>',{'class':'controls'});
	divControls.append(txtField);
	var lblControlLabel = $('<label/>',{'class':'control-label','for':inputFieldId});
	lblControlLabel.html(inputFieldLabel);
	var divFormGroup = $('<div/>',{'class':'form-group'});
	divFormGroup.append(lblControlLabel);
	divFormGroup.append(divControls);
	return divFormGroup;
}

function ValidateAskUsForm(){
	var errContainer = $('#action-msg-warning');
	var errMsg = '';
	errContainer.html('');
	if(Liferay.ThemeDisplay.isSignedIn()){
		/*var strEmailId = $('#txtEmail').val();
		if($.trim(strEmailId)==''){
			errMsg = errMsg + '<br/>Please enter your email id';
		}*/
		var strSubject     = $('#txtSubject').val();
		if($.trim(strSubject)==''){
			errMsg = errMsg + '<br/>Please enter title';
		}
		var strDescription = $('#txtDescription').val();
		if($.trim(strDescription)==''){
			errMsg = errMsg + '<br/>Please enter description';
		}
		if(errMsg!=''){
			_flaskLib.showWarningMessage('action-msg-warning', errMsg);
			return false;
		}
		else{
			return true;			
		}
	}
	else{
		return false;
	}
		
}