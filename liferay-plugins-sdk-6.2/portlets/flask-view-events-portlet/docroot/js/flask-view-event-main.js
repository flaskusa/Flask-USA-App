var alllist = [];
var map;

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
		    var st = formatUnixToTime(flaskEvent.startTime);
		    var divRowItem = $('<div/>',{'class':'row-fluid'});
		    var divCol3 = $('<div/>',{'class':'span3','style':'width:60px;'});
		    if(flaskEvent.userEvent == 1){
		    	var div_heart = $('<div/>',{'class':'heart-shape-userevent','data-eventId':flaskEvent.eventId,'data-userEvent':flaskEvent.userEvent});
		    }else{
		    	var div_heart = $('<div/>',{'class':'heart-shape','data-eventId':flaskEvent.eventId,'data-userEvent':flaskEvent.userEvent});
		    	
		    }
		   
		    var divCol9 = $('<div/>',{'class':'span9'});
		    var divCol9_lbl = $('<div/>',{'class':'lbldiv','data-id':flaskEvent.eventId});
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
		 	fnShowEventLogo(flaskEvent.eventImageUUID, flaskEvent.eventImageGroupId, divCol3,false);
		 	$(divCol9_lbl).click(function(){
		 		$("#spinningSquaresG").show();
		 		$('#one').hide();		 		
		 		fnGetEventImages($(this).attr("data-id"));
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

function fnShowEventLogo(imageUUID, imageGroupId,container ,editable){
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')'});
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

function fnFillImageArray(eventDetailImages,eventDetails,objArray){
	var objEventDetails = jQuery.parseJSON(eventDetails);
	var infoTypeCategoryName = objEventDetails.infoTypeCategoryName.toUpperCase()
	var objFields = eval("_eventModel.DETAIL_DATA_MODEL."+infoTypeCategoryName);
	if(eventDetailImages.length>0){
		$.each(eventDetailImages, function(idx, objImg) {
			var objtbl = $("<table/>",{'width':'100%','class':'eventDetailBox'});
			$.each(objFields, function(idx, obj){
				var objtrHead = $("<tr/>");
				$.each(obj,function(key,value){
					var objtr = $("<tr/>");
					var valueTd = $("<td/>",{'align':'left','style':'padding:10px','width':'100%'});				
					var evalue = eval("objEventDetails."+key);
					var caption = value;
					$(valueTd).html(evalue);
					$(valueTd).appendTo($(objtr));
					$(objtr).appendTo($(objtbl));
				});
			});
			
			var imgURL = "";
			var objMainTable = $("<table/>",{'width':'100%','class':'eventDetailBoxWithImages'});
			var objMainTrHead = $("<tr/>");
			/*Commented header part*/
			//var objth = $("<th/>",{'colspan':'2'});
			//$(objth).html(infoTypeCategoryName);
			//$(objth).appendTo($(objMainTrHead));
			$(objMainTrHead).appendTo($(objMainTable));
			var objMainTr = $("<tr/>");
			var imageTd = $("<td/>",{'align':'left','valign':'top','style':'padding-top:10px;padding-bottom:10px','width':'60%'});
			var textDataTd = $("<td/>",{'align':'left','valign':'top','style':'padding-top:10px;padding-bottom:10px','width':'40%'});
			var objContent = $("<div/>",{'width':'100%','height':'245px'});

			objImage = jQuery.parseJSON(objImg.EventDetailImage);
			imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+objImage.imageUUID+"&groupId="+objImage.imageGroupId;
			$(objContent).attr("style","background:url('"+imgURL+"');background-size: cover;width: 100%;height: 200px;");
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
			var objContent = $("<div/>",{'width':'100%','height':'100%','class':'eventDetailBox'});
			var objtbl = $("<table/>",{'width':'100%'});
			var objtrHead = $("<tr/>");
			var objth = $("<th/>",{'colspan':'2'});
			$(objth).html(infoTypeCategoryName);
			$(objth).appendTo($(objtbl));
			$.each(obj,function(key,value){
				var objtr = $("<tr/>");
				var captionObj = $("<td/>",{'align':'left','style':'padding:10px','width':'30%'});
				var valueObj = $("<td/>",{'align':'left','style':'padding:10px','width':'70%'});				
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

function fnSlider(infoType,arrImage){
	var Slider = "#wowslider-container"+infoType;
	if(arrImage.length>0){
		$.each(arrImage, function( index, value ) {
			var objDiv = $("<div/>",{'class':'photo'});
			var objImg = value;
			$(objImg).appendTo(objDiv);
			$(objDiv).appendTo($(Slider));			
		});
	}
	else{
		fnBlankSlide(Slider);
	}
	$(Slider).jqxScrollView({ 
			height: 245,
		    showButtons:true
		});	
}

function fnBlankSlide(Slider){
  	var temp_html;
	var imageUrl;
	imageUrl = "/flask-view-events-portlet/img/NoData.png";
	var objDiv = $("<div/>");				
	$(objDiv).html("<img src="+imageUrl+"></img>");
	$(objDiv).appendTo($(Slider));
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
	var request = new Request();
	var param = {};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT , param, 
					function (data){
						renderEventList(data);
					} ,
					function (data){
						console.log("Error ins getting event list" + data );
					});
}

function addUserEvent(eventId){
	var request = new Request();
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
	var request = new Request();
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
