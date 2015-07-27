var alllist = [];

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
	 if(tdata.Events.length == 0){
		$("<span class='control-label-nocolor'>There there are no events</span>").appendTo($("#placeholder"));
		return;
	 }
	 for(var i=0; i < tdata.Events.length; i++)
		{
		 	var flaskEvent = tdata.Events[i];
		    var st = formatUnixToTime(flaskEvent.startTime);
		    var divRowItem = $('<div/>',{'class':'row-fluid','data-id':flaskEvent.eventId});
		    var divCol3 = $('<div/>',{'class':'span3','style':'width:60px;'});
		    if(flaskEvent.userEvent == 1){
		    	var div_heart = $('<div/>',{'class':'heart-shape-userevent'});
		    }else{
		    	var div_heart = $('<div/>',{'class':'heart-shape'});
		    }
		    
		    var divCol9 = $('<div/>',{'class':'span9'});
		    var divCol9_lbl = $('<div/>',{'class':'lbldiv'});
		    var eventName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(eventName_lbl).html(flaskEvent.eventName);
		    var venue_lbl = $('<label/>',{'class':'control-label-nocolor'});
		    $(venue_lbl).html(st + ' at ' + flaskEvent.venueName);
		    $(eventName_lbl).appendTo($(divCol9_lbl));
		    $(venue_lbl).appendTo($(divCol9_lbl));
		    $(divCol9_lbl).appendTo($(divCol9));
		 	$(divCol3).appendTo($(divRowItem));
		 	$(divCol9).appendTo($(divRowItem));
		 	$(div_heart).appendTo($(divCol9));		 	
		 	$(divRowItem).appendTo($(divRow));
		 	fnShowEventLogo($("#repositoryId").val(), flaskEvent.eventId, divCol3)
		 	$(divCol9_lbl).click(function(){
		 		$("#spinningSquaresG").show();
		 		$('#one').hide();		 		
		 		fnGetEventImages($(this).attr("data-id"));
		 	});
		 	if(Liferay.ThemeDisplay.isSignedIn()){
			 	$(div_heart).click(function(){
			 		setMyEvent(flaskEvent, event);
			 	});
		 	}else{
		 		$(div_heart).attr("title", "You need to be signed in to save events.");
		 	}
		 	
	    }
	 	$(divRow).appendTo($("#placeholder"));
}

function fnRenderEvents(repositoryId,parentFolderId,folderName,eventName){
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
			function (data){
				folderId = data.responseJson.folderId;
				fnGetEventFolder(repositoryId,folderId,eventName);
			} ,
			function (data){
				folderId = 0;
			});
		return folderId;
}

function fnGetEventFolder(repositoryId,parentFolderId,folderName){
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
			function (data){
					folderId = data.responseJson.folderId;
					fnRenderSliders(repositoryId,folderId,"Pre-Event",2);
					fnRenderSliders(repositoryId,folderId,"During-Event",3);
					fnRenderSliders(repositoryId,folderId,"Post-Event",4);
			} ,
			function (data){
				folderId = 0;
			});
		
		return folderId;
}

function fnShowEventLogo(_repositoryId,_eventId,_container){
	var LogoURL = "";
	var flaskRequest = new Request();
	params= {'repositoryId': _repositoryId, 'parentFolderId': 0, 'name': 'Event'};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			folderName = 'Event-'+_eventId;
			folderId = data.folderId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': _repositoryId, 'parentFolderId': folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER, paramsChild, 
				function (data){
					var _folderId = data.folderId;
					var flaskRequestChild0 = new Request();
					paramsChild0= {'groupId': _repositoryId, 'folderId':_folderId, 'title': 'EventLogo'};
					flaskRequestChild0.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILE_BY_TITLE , paramsChild0, 
						function (data){
							LogoURL = "/documents/"+_repositoryId+"/"+_folderId+"/EventLogo";
						    var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+LogoURL+')','data-folderId':_folderId,'data-title':'EventLogo'});
							$(_container).append(objdiv);
						} ,
						function (data){
					});				
				} ,
				function (data){
			});
		} ,
		function (data){
	});
}

function fnGetEventImages(eventId){
	var flaskRequest = new Request();
	params= {'eventId': eventId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENTDETAIL_WITH_IMAGES , params, 
		function(data){
			var arrPreEvent = [];
			var arrDurEvent = [];
			var arrPosEvent = [];
			objEventDetails = data.EventDetails;
			$.each(objEventDetails, function(idx, obj) {
				objEventDetail = jQuery.parseJSON(obj.EventDetail);
				var imgURL = "";
				switch(parseInt(objEventDetail.infoTypeId)) {
			    case 2:
			    	fnFillImageArray(obj.EventDetailImages,arrPreEvent)
			        break;
			    case 3:
			    	fnFillImageArray(obj.EventDetailImages,arrDurEvent)
			        break;
			    case 4:
			    	fnFillImageArray(obj.EventDetailImages,arrPosEvent)
			        break;
				}				
			});				
			fnSlider(2,arrPreEvent);
			fnSlider(3,arrDurEvent);
			fnSlider(4,arrPosEvent);
			fnStopProgress();
		},
		function (data){
			console.log("Error in getting Folder: " + data );
			fnStopProgress();
		});	
}

function fnFillImageArray(eventDetailImages,objArray){
	$.each(eventDetailImages, function(idx, objImg) {
		objImage = jQuery.parseJSON(objImg.EventDetailImage);
		imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+objImage.imageUUID+"&groupId="+objImage.imageGroupId;
		objArray.push(imgURL);
		imgURL = "";
	});
	return objArray;
}

function fnSlider(infoType,arrImage){
	var ws_images = "#ws_images"+infoType;
	var wowslider_container = "#wowslider-container"+infoType;
	$(ws_images).html("");
	if(arrImage.length>0){
		var objUl = $("<ul/>");
		$.each(arrImage, function( index, value ) {
			var objli = $("<li/>");
			var objImg = $("<img/>",{'src':value});
			$(objImg).appendTo(objli);
			$(objli).appendTo(objUl);
		});
	    $(objUl).appendTo($(ws_images));
	}
	else{
		fnBlankSlide(ws_images,wowslider_container);
	}
    $(wowslider_container).wowSlider();
}

function fnBlankSlide(ws_images,wowslider_container){
  	var temp_html;
	var imageUrl;
	imageUrl = "/flask-view-events-portlet/img/NoData.png";
	var ulObj = $("<ul/>");
	var liObj = $("<li/>");				
	uploadedby = "No data";
	$(liObj).html("<img src="+imageUrl+"></img>");
	$(liObj).appendTo(ulObj);
	$(ulObj).appendTo($(ws_images))      
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
});

function fnStopProgress(){
	$("#spinningSquaresG").hide();	
 	$('#two').show();	
 	$(".ws_controls").hide();
}

function setMyEvent(flaskEvent, event){
	var eventId = flaskEvent.eventId;
	var myEvent = flaskEvent.userEvent;
	if(myEvent == 0 ){
		addUserEvent(eventId);
		$(event.target).attr('class','heart-shape-userevent');
	}else{
		removeUserEvent(eventId);
		$(event.target).attr('class','heart-shape')
	}
}

function addUserEvent(eventId){
	var request = new Request();
	var param = {eventId: eventId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.ADD_USER_EVENT , param, 
					function (data){
					} ,
					function (data){
						console.log("Error ins saving user event" + data );
					});
}
function removeUserEvent(eventId){
	var request = new Request();
	var param = {eventId: eventId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.REMOVE_USER_EVENT , param, 
					function (data){
					} ,
					function (data){
						console.log("Error in removing user event" + data );
					});
}
