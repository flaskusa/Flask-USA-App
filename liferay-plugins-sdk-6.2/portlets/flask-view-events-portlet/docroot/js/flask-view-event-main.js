var alllist = [];

function fnLoadList() {
 var params = "";
 var request = new Request();
 request.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_EVENTS, params,
   function(data) {
    if (data.responseStatus == 1) {
     alllist = data.responseJson;
     fnlist(alllist);
    } else {
     alert("MESSAGES.ERRORR_REGISTER_USER");
    }
   });
}

function fnlist(tdata) {
	 var source = {
	  localdata : tdata,
	  datatype : "json",
	  datafields : DATA_SOURCE.GET_FLASK_EVENT_LIST,
	 };
	 
	 function formatUnixToTime(tdate)
		{
			var date = new Date(tdate);
			var hours = date.getHours();
			var minutes = "0" + date.getMinutes();

			var ampm = hours >= 12 ? 'PM' : 'AM';
			hours = hours % 12;
			return hours + ':' + minutes.substr(-2) + ' ' + ampm;
		}
	 
	 var divRow = $('#placeholder');
	 for(var i in tdata)
		{
		    var st = formatUnixToTime(tdata[i].startTime);
		    var divRowItem = $('<div/>',{'class':'row-fluid','title':tdata[i].eventName,'data-id':tdata[i].eventId});
		    var divCol3 = $('<div/>',{'class':'span3'});
		    var divCol9 = $('<div/>',{'class':'span9'});
		    var divCol9_lbl = $('<div/>',{'class':'lbldiv'});
		    var eventName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(eventName_lbl).html(tdata[i].eventName);
		    var venue_lbl = $('<label/>',{'class':'control-label-nocolor'});
		    $(venue_lbl).html(st + ' at ');
		    $(eventName_lbl).appendTo($(divCol9_lbl));
		    $(venue_lbl).appendTo($(divCol9_lbl));
		    $(divCol9_lbl).appendTo($(divCol9));
		 	$(divCol3).appendTo($(divRowItem));
		 	$(divCol9).appendTo($(divRowItem));
		 	$(divRowItem).appendTo($(divRow));
		 	
		    fnGetVenueName(venue_lbl,tdata[i].venueId);
		 	fnShowEventLogo($("#repositoryId").val(),tdata[i].eventId,divCol3)
		 	
		 	$(divRowItem).click(function(){
		 		$('#one').hide();
		 		$("#spinningSquaresG").show(); 
		 		wait(function()
		 		{
					$("#spinningSquaresG").hide();	
				 	$('#two').show();	
		 		},3);
		 		//fnRenderEvents($("#repositoryId").val(),0,'Events',$(this).attr('title'));
		 		fnShowSlider($(this).attr('data-id'),"",2);
		 		fnShowSlider($(this).attr('data-id'),"",3);
		 		fnShowSlider($(this).attr('data-id'),"",4);
		 	});
	    }
	 	$(divRow).appendTo($("#placeholder"));
}

$(document).ready(function(){
	fnLoadList();
	$(".cssback").click(function(){
		$('#one').show();
		$('#two').hide();
	});
});

function fnRenderEvents(repositoryId,parentFolderId,folderName,eventName){
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
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
		flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
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

function fnRenderSliders(repositoryId,parentFolderId,folderName,Count){
	var folderId = 0;
	var ws_images = "#ws_images"+Count;
	var wowslider_container = "#wowslider-container"+Count;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
			function (data){
				folderId = data.responseJson.folderId;
				displayImages(repositoryId, folderId, ws_images, wowslider_container)
			} ,
			function (data){
				folderId = 0;
			});
		
		return folderId;
}

function displayImages(repositoryId, folderId, ws_images, wowslider_container,ulObj)
{
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'folderId': folderId};
	flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_IMAGES, params, 
    function(obj) {
	  obj = obj.responseJson;
      if(typeof obj=="object" && obj.length > 0)
      {
			var temp_html;
			temp_html = "";
			var imageUrl;
			var uploadedby;
			for(var i=0;i<obj.length;i++)
			{
				var liObj = $("<li/>");				
				imageUrl = "/documents/"+repositoryId+"/"+folderId+"/"+obj[i].title;
				uploadedby = "uploaded by " + obj[i].userName;
				$(liObj).html("<img src="+imageUrl+" alt='"+uploadedby+"' title='"+uploadedby+"' id='wows1_0'/>");
				$(liObj).appendTo(ulObj);
			}
      }
      else
      {
    	  	var temp_html;
			var imageUrl;
			imageUrl = "/flask-view-events-portlet/img/NoData.png";
			var liObj = $("<li/>");				
			uploadedby = "No data";
			$(liObj).html("<img src="+imageUrl+" alt='"+uploadedby+"' title='"+uploadedby+"' id='wows1_0'/>");
			$(liObj).appendTo(ulObj);
      }
      $(ulObj).appendTo($(ws_images))      
      $(wowslider_container).wowSlider();
 });
}

function fnShowEventLogo(_repositoryId,_eventId,_container){
	///LOGO START
	var LogoURL = "";
	var flaskRequest = new Request();
	params= {'repositoryId': _repositoryId, 'parentFolderId': 0, 'name': 'Event'};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			folderName = 'Event-'+_eventId;
			folderId = data.responseJson.folderId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': _repositoryId, 'parentFolderId': folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER, paramsChild, 
				function (data){
					var _folderId = data.responseJson.folderId;
					var flaskRequestChild0 = new Request();
					paramsChild0= {'groupId': _repositoryId, 'folderId':_folderId, 'title': 'EventLogo'};
					flaskRequestChild0.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILE_BY_TITLE , paramsChild0, 
						function (data){
							LogoURL = "/documents/"+_repositoryId+"/"+_folderId+"/EventLogo";
						    var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+LogoURL+')','data-folderId':_folderId,'data-title':'EventLogo'});
							$(_container).append(objdiv);
						} ,
						function (data){
							//console.log('test-0');
					});				
				} ,
				function (data){
					//console.log('test-1');
			});
		} ,
		function (data){
			//console.log('test-2');
	});
	//LOGO END
}

function fnGetVenueName(_container,_venueId){
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_ALL_VENUES, "", 
		function (data){
			var dataJson = data.responseJson;
			var returnedData = $.grep(dataJson, function(element, index){
		    	return element.venueId == _venueId;
		    });
			var dataFilterJson =returnedData; 
		    var t = $("<span/>");
		    $(t).html(dataFilterJson[0].venueName);
		    $(t).appendTo($(_container));
	},
		function (data){
			console.log(data);
	});
}


function fnShowSlider(_eventId,_divObj,_infoTypeId){
	console.log(_eventId);
	var ws_images = "#ws_images"+_infoTypeId;
	var wowslider_container = "#wowslider-container"+_infoTypeId;
	$(ws_images).html("");
	$(_divObj).html("");
	var repositoryId = $("#repositoryId").val();
	var eventId = _eventId;
	var infoTypeId = _infoTypeId;
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': 0, 'name': 'Event'};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			if(data.responseJson.exception!=""){
				fnBlankSlide(ws_images,wowslider_container);
			}
			folderName = 'Event-'+eventId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': repositoryId, 'parentFolderId': data.responseJson.folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild, 
				function (data){
					if(data.responseJson.exception!=""){
						fnBlankSlide(ws_images,wowslider_container);
					}
					var flaskRequestChild1 = new Request();
					paramsChild1= {'repositoryId': repositoryId, 'parentFolderId': data.responseJson.folderId, 'name': infoTypeId};
					flaskRequestChild1.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild1, 
						function (data){
							if(data.responseJson.exception!=""){
								fnBlankSlide(ws_images,wowslider_container);
							}
							var flaskRequestChild2 = new Request();
							paramsChild2= {'repositoryId': repositoryId, 'parentFolderId': data.responseJson.folderId};
							flaskRequestChild2.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDERS , paramsChild2,
								function (data){
									if(data.responseJson.exception!=""){
										fnBlankSlide(ws_images,wowslider_container);
									}
									var dataJson = data.responseJson;
									for(var iCount=0;iCount<dataJson.length;iCount++){
										folderId = dataJson[iCount].folderId;
										var flaskRequestChild3 = new Request();
										paramsChild2= {'repositoryId': repositoryId, 'parentFolderId': folderId};
										flaskRequestChild3.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDERS , paramsChild2, 
											function (data){
												if(data.responseJson.exception!=""){
													fnBlankSlide(ws_images,wowslider_container);
												}
												var _dataJson = data.responseJson;
												var tempHtml;
												var ulObj = $("<ul/>");
												for(var _iCount=0;_iCount<_dataJson.length;_iCount++){
													displayImages(repositoryId, _dataJson[_iCount].folderId, ws_images, wowslider_container,ulObj);
												}
											} ,
										function (data){
											fnBlankSlide(ws_images,wowslider_container)
										});
									}
								} ,
								function (data){
									fnBlankSlide(ws_images,wowslider_container)
								});
						} ,
						function (data){
							fnBlankSlide(ws_images,wowslider_container)
						});

				} ,
				function (data){
					fnBlankSlide(ws_images,wowslider_container)
				});
		} ,
		function (data){
			fnBlankSlide(ws_images,wowslider_container)
		});
}

function fnRenderSlider(folderId,_divObj){
	var flaskRequest = new Request();
	params= {'repositoryId': $("#repositoryId").val(), 'folderId': folderId};
	console.log(params);
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILES , params, 
		function (data){
			console.log(data);
			if(typeof data=="object"){
				console.log(data);
				var iSelected = false;
		    	for(var iCount=0;iCount<data.length;iCount++){
		    		var imgURL = '/documents/'+data[iCount].groupId+'/'+data[iCount].folderId+'/'+data[iCount].title;
				    var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-fileEntryId':data[iCount].fileEntryId});
				    $(objdiv).appendTo($(_divObj));
		    	}
		    }		
		} ,
		function (data){
			console.log("Error in getting Folder: " + data );
		});	
}

function fnBlankSlide(ws_images,wowslider_container){
  	var temp_html;
	var imageUrl;
	imageUrl = "/flask-view-events-portlet/img/NoData.png";
	var ulObj = $("<ul/>");
	var liObj = $("<li/>");				
	uploadedby = "No data";
	$(liObj).html("<img src="+imageUrl+" alt='"+uploadedby+"' title='"+uploadedby+"' id='wows1_0'/>");
	$(liObj).appendTo(ulObj);
	$(ulObj).appendTo($(ws_images))      
	$(wowslider_container).wowSlider();
}