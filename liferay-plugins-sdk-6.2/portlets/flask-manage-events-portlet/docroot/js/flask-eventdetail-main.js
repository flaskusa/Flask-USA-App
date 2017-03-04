var eventDetailForm;
var dropZone;
var JsonObj;
var JsonEventDetails;
var iSelected;
var noOfInvitations = 5;

$(document).ready(function() {
	formArea = $("#contentTypeForm"); // Parent Div
	$("#infoTypeCategoryId").change(function() {
		$(formArea).html("");
		var selectedContentType = $("option:selected", this).text().toLowerCase();
		_infoTypeRenderer.fnRenderForm(selectedContentType,"event");
		$('#eventDetailsForm').jqxValidator
	    ({
	        hintType: 'label',
	        animationDuration: 0,
	        rules: [
	                	{ input: '#infoTitle', message: 'Info Title is required!', action: 'keyup, blur', rule: 'required' }
	                	//,{ input: '#infoDesc', message: 'Info Description is required!', action: 'keyup, blur', rule: 'required' }
	               ]
	    });
		$(".clsAdd5More").click(function(){
			add5moreRows();
		});
	});
});

function addDetailsClickHandlers() {
	eventDetailForm = $("#eventForm");
	
	$(".clsAdd5More").click(function(){
		add5moreRows();
	});
	
	/*	Initialize display elements*/
	$(".cssVdSave").click(function() {
		$(this).attr("disabled","disabled");
		if (fnCheckDuplicateTitle($("#infoTitle").val())) {
			_flaskLib.showWarningMessage('action-msg-warning', _eventDetailModel.MESSAGES.DETAIL_DUPLICATE);
		}
		else{
			if ($('#eventDetailsForm').jqxValidator('validate'))
			{
				if ($('#addrLine1').val() == undefined) {
					$('#latitude').val(0);
					$('#longitude').val(0);
					saveEventDetails();
				}else {
					try{
						var geocoder = new google.maps.Geocoder();
						geocoder.geocode({
							address : $('#addrLine1').val(),
							region: 'no'
						},
					    function(results, status) {
							try{
								if (status.toLowerCase() == 'ok') {
									// Get center
									var coords = new google.maps.LatLng(
										results[0]['geometry']['location'].lat(),
										results[0]['geometry']['location'].lng()
									);
							
									$('#latitude').val(coords.lat());
									$('#longitude').val(coords.lng());
								}
							}
							catch(ex){
								console.log(ex);
							}
							finally{
								saveEventDetails();								
							}
					    });						
					}
					catch(ex){
						_flaskLib.showErrorMessage('action-msg', _eventDetailModel.MESSAGES.CHECK_INTERNET_CONNECTION);
					}
				}
				
			}			
		}
	});

	$(".cssAddEventDetails").click(function() {
		window.location.hash = '#EventDetail';
		$("#eventDetailId").val(0);
		_flaskDetailCommon.loadInfoType('infoTypeId',1);
		_flaskDetailCommon.loadContentType('infoTypeCategoryId',1);
		$("#eventDetailsForm").show();
		$("#eventDetailsDataTable").hide();
		$("#eventDetailGallery").html("");
		$(".cssVdSave").removeAttr("disabled");

	});

	$(".cssVdCancel").click(function() {
		window.location.hash = '#ManageEventContent';
		$("#eventDetailsForm").hide();
		$("#eventDetailsDataTable").show();
		$("#slides").html("");
		loadEventDetailsData($('#eventForm #eventId').val());
		$(".cssVdSave").removeAttr("disabled");
	});
	$("#infoTypeId").change(function() {
		_flaskDetailCommon.setContentType("infoTypeCategoryId",null, $("#infoTypeId").val(), _flaskDetailCommon.infoCategoryJSON);
	});
	$(window).hashchange( function(){
		var hash = location.hash;
		switch(hash) {
	    case "#EventDetail":
		    	$("#eventDetailId").val(0);
				_flaskDetailCommon.loadInfoType('infoTypeId',1);
				_flaskDetailCommon.loadContentType('infoTypeCategoryId',1);
				$("#eventDetailsForm").show();
				$("#eventDetailsDataTable").hide();
				$("#eventDetailGallery").html("");
				$(".cssVdSave").removeAttr("disabled");
	        break;
	    case "#ManageEventContent":
		    	$("#eventDetailsForm").hide();
				$("#eventDetailsDataTable").show();
				$("#slides").html("");
				loadEventDetailsData($('#eventForm #eventId').val());
				$(".cssVdSave").removeAttr("disabled");
	    default:
	    	//alert("This is default");
		}		
	});
}

function loadEventDetailsData(eventId) {
	var flaskRequest = new Request();
	params = {'eventId':eventId};
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_EVENT_DETAILS, params,
	function(data){/*success handler*/
		JsonEventDetails = data;
		GRID_PARAM_DETAILS.updateGrid(data);
		iSelected = false;
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_eventDetailModel.MESSAGES.DETAIL_GET_ERROR);
		console.log("Error in getting data: " + error);
	});
	$("#action-msg-warning").hide();
}

function add5moreRows(){
	for(var i=noOfInvitations+1 ; i <= noOfInvitations+5;i++){
		var invitationDiv = '<div class="control-group">';
		invitationDiv = invitationDiv + '<div class="controls">';
		invitationDiv = invitationDiv + '<input id="subDetailTitle'+i+'" name="subDetailTitle'+i+'" type="text" placeholder="Enter Title" class="input-medium sub-detail-text-box">';
		invitationDiv = invitationDiv + '<textarea id="subDetailDesc'+i+'" name="subDetailDesc'+i+'" placeholder="Enter Description" class="Text-Area"></textarea>';
		invitationDiv = invitationDiv + "</div></div>";
		$(".divHeight").append(invitationDiv);
	}
	noOfInvitations +=5;
}

function contextMenuHandlerDetails(menuItemText, rowData) {
	var args = event.args;
	if (menuItemText  == "Edit") {
		editEventDetail(rowData);
		return false;
	}else if (menuItemText == "Delete") {
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteEventDetail(rowData.eventDetailId,rowData.eventId);
		}
		return false;
	}
};
//

$(".infoTypeCat").click(function() {
	var InfoTypeCd = Number($(this).val());
	$("#infoTypeId").val(InfoTypeCd);
});

function initDetailsForm() {
	$("#eventDetailsContainer").hide();
}

/* Dynamic content type generation logic [Start]*/
function fnRenderContentType(InfoTypeID) {
	$("#infoTypeId").val(InfoTypeID);
	$("#eventDetailsContainer").show();
	$("#formContainer").hide();
}


function saveEventDetails() {
	params = _flaskLib.getFormData('eventDetailsForm',_eventDetailModel.DATA_MODEL.EVENTDETAILS,
			function(formId, model, formData) {
				$.each(model, function(i, item) {
					var ele = $('#'+ formId + ' #'+item.name);
					var val = $.trim(ele.val());
					if (item.type == 'long' && val =='') {
						val = Number(val)
					} else if (item.type == 'boolean' && val =='') {
						val = 1;
					}

					formData[item.name] = val;
				});
				formData.infoDesc = $("#jqxEditor").val();
				if (formData.infoDesc == undefined) {
					formData.infoDesc = "";
				}
				if ($('#addrLine1').val() == undefined) {
					formData.addrLine1 = "";
				}
				formData.latitude = $('#latitude').val();
				formData.longitude = $('#longitude').val();

				formData.eventId=$('#eventForm #eventId').val();
				
				return formData;
			});
	params.eventSubDetails = [];
	for(var i=1; i <=noOfInvitations; i++){
		var record ={};
		var title ="";
		var desc ="";
		if($("#eventDetailsForm #subDetailTitle"+i).val() == "" || $("#eventDetailsForm #subDetailTitle"+i).val() == null){
			title = null;
		}else{
			title = $.trim($("#eventDetailsForm #subDetailTitle"+i).val());
		}
		if($("#eventDetailsForm #subDetailDesc"+i).val() == "" || $("#eventDetailsForm #subDetailDesc"+i).val() == null){
			desc = null;
		}else{
			desc = $.trim($("#eventDetailsForm #subDetailDesc"+i).val());
		}
		if((title == "" || title == null) && (desc == "" || desc == null)){
		}else{
			record["title"] = title;
			record["desc"] = desc;
			params.eventSubDetails.push(record);
		}
	}
	var flaskRequest = new Request();
	var url = ""
		if (params.eventDetailId == 0) {
			url = _eventDetailModel.SERVICE_ENDPOINTS.ADD_EVENT_DETAILS;
		}else {
			url =_eventDetailModel.SERVICE_ENDPOINTS.UPDATE_EVENT_DETAILS;
		}
	flaskRequest.sendGETRequest(url, params,
				function(data) {
					if ($('#eventImages').find('.dz-image').length > 0) {
						fnSaveImages(data.eventDetailId,data.eventId);
					}
					else {		 
						$('#eventDetailsForm').hide();
						$('#eventDetailsDataTable').show();
			    		$("#eventDetailId").val(0);
			    		$("#infoTypeCategoryId").val(0);
			    		loadEventDetailsData(data.eventId);
			    		_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_SAVE);
			    		$(".cssVdSave").removeAttr("disabled");			    		
			    		destroyJQEditor();
					}

				} ,
				function(data) {
					_flaskLib.showErrorMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_ERROR);
				});
	$("#slides").html("");
}

function getEventSubDetails(eventDetailId) {
	params = {
		'eventDetailId' : eventDetailId
	};
	$( ".divHeight" ).empty();
	noOfInvitations = 0;
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(
			_eventDetailModel.SERVICE_ENDPOINTS.GET_EVENT_SUB_DETAIL_BY_EVENT_DETAIL_ID, params,
			function(data) {
				$.each(data, function(idx, obj) {
					fnRenderEventSubDetails(idx+1, obj.eventSubDetailTitle, obj.eventSubDetailDesc);
				});
			}, function(data) {
				console.log(data);
			});
} 

function fnRenderEventSubDetails(idx, eventSubDetailTitle, eventSubDetailDesc){
	var titleid="#subDetailTitle"+idx;
	var descid="#subDetailDesc"+idx;
	if($(titleid).length > 0){
		$(titleid).val(eventSubDetailTitle);
		$(descid).text(eventSubDetailDesc);
	}else{
		var invitationDiv = '<div class="control-group">';
		invitationDiv = invitationDiv + '<div class="controls">';
		invitationDiv = invitationDiv + '<input id="subDetailTitle'+idx+'" name="subDetailTitle'+idx+'" type="text" value="'+eventSubDetailTitle+'" placeholder="Enter Title" class="input-medium sub-detail-text-box">';
		invitationDiv = invitationDiv + '<textarea id="subDetailDesc'+idx+'" name="subDetailDesc'+idx+'" placeholder="Enter Description" class="Text-Area">'+eventSubDetailDesc+'</textarea>';
		invitationDiv = invitationDiv + "</div></div>";
		$(".divHeight").append(invitationDiv);
	}
	noOfInvitations = idx;
}

function destroyJQEditor(){
	try{
		$('#jqxEditor').jqxEditor('destroy'); 	
	}catch( ex){
		
	}
}

/* Delete Single Event */
function deleteEventDetail(eventDetailId,eventId) {
		var param = {'eventDetailId': eventDetailId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_EVENT_DETAIL , param,
			function(data) {
					_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
					loadEventDetailsData(eventId);
			} ,
			function(data) {
					_flaskLib.showErrorMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_ERR);
			});
}

/* Delete Multiple Events */
function deleteMultipleEventDetail(eventList) {
	var param = {'eventIds': eventList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_ALL_EVENT_DETAILS, param,
		function(data) {
				_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
				//loadEventDetailsData(eventId);
		} ,
		function(data) {
				_flaskLib.showErrorMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_ERR);
		});
}

/* Edit Event */
function editEventDetail(rowData) {
		$(".cssVdSave").removeAttr("disabled");
		var container = $('#eventDetailGallery');
		container.html("");
		var repositoryId = $("#repositoryId").val();
		$('#eventDetailsForm #eventId').val($('#eventForm #eventId').val());
		$('#eventDetailId').val(rowData.eventDetailId);
		$('#_eventDetailId').val(rowData.eventDetailId);
		$('#eventDetailsForm').show();
		$('#eventDetailsDataTable').hide();
		_flaskDetailCommon.loadInfoType('infoTypeId',rowData.infoTypeId);
		_flaskDetailCommon.loadContentType("infoTypeCategoryId",rowData.infoTypeCategoryId, rowData.infoTypeId);
		setTimeout(function() {
			_flaskLib.loadDataToForm("eventDetailsForm",_eventDetailModel.DATA_MODEL.EVENTDETAILS, rowData, function(){});
			$('#addrLine1').val(rowData.addrLine1);
			$('#jqxEditor').val(rowData.infoDesc);
		}, 500);
		getEventSubDetails(rowData.eventDetailId);
		fnGetEventDetailImages(rowData.eventDetailId,container, true);
}

function formatUnixToTime(tdate){var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var seconds = "0" + date.getSeconds();
	return hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
}

function fnSaveImages(eventDetailId,eventId) {
	$("#_eventDetailId").val(eventDetailId);
	dropZone.options.autoProcessQueue = true;
	dropZone.processQueue();
	dropZone.on("queuecomplete", function(file) {
		wait(function() {
			$('#eventDetailsForm').hide();
			$('#eventDetailsDataTable').show();
			$("#eventDetailId").val(0);
			$("#infoTypeCategoryId").val(0);
			loadEventDetailsData(eventId);
			_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_SAVE);
			$(".cssVdSave").removeAttr("disabled");
		},1)
	});
}

var wait = function(callback, seconds) {
	return window.setTimeout(callback, seconds * 1000);
}

$(document).ready(function() {
	//$("#mcontents").click(function() {
		addDetailsClickHandlers();
		initDetailsForm();
		loadEventDetailsData($('#eventForm #eventId').val());
		var click = new Date();
		var lastClick = new Date();
		var lastRow = -1;
		$("#gridDetails").bind('rowclick', function(event) {
		    click = new Date();
		    if (click - lastClick < 300) {
		        if (lastRow == event.args.rowindex) {
		        	var row = event.args.rowindex;
	        	 	var datarow = $(this).jqxGrid('getrowdata', row);
	        	 	editEventDetail(datarow);
		        }
		    }
		    lastClick = new Date();
		    lastRow = event.args.rowindex;
		});
		$("#eventDetailsContainer").show();
		
		$('.md-closeBtn').click(function(){
			$('#modal-advertisement').removeClass('md-show');
		});	
	//});
});

function fnCheckDuplicateTitle(_infoTitle) {
	if (typeof JsonEventDetails=="object") {
		var Obj = JsonEventDetails;
		var iCount = 0;
	    var items = Obj.filter(function(item) {
	    	if (item.infoTitle==_infoTitle && item.eventDetailId!=parseInt($('#eventDetailId').val())) {
	    		iCount++;
	    	}
	    });
	    if (iCount>0)
	    	return true;
	    else
	    	return false;
	}
	else {
		return false;
	}
}

function fnDeleteEventDetailImage(eventDetailImageId) {
	params= {'eventDetailImageId': eventDetailImageId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_EVENTDETAIL_IMAGE , params,
		function(data) {
			console.log(data);
		},
		function(data) {
			console.log(data);
		});
}

function fnGetEventDetailImages(eventDetailId,container, editable) {
	params= {'eventDetailId': eventDetailId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_EVENTDETAIL_IMAGES , params,
		function(data) {
			$.each(data, function(idx, obj) {
				fnRenderImage(obj.imageUUID, obj.imageGroupId, container, obj.eventDetailImageId, editable);
			});
		},
		function(data) {
			console.log(data);
		});
}

function fnRenderImage(imageUUID, imageGroupId, container, eventDetailImageId, editable) {
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	if (editable) {
		var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-uuid':imageUUID, 'data-eventDetailImageId': eventDetailImageId,'data-imageURL':imgURL});
		$(objdiv).appendTo($(container));
		$(objdiv).click(function() {
	    	$(this).toggleClass("activeImage");
	    	if ($(".activeImage").length>0) {
	    		if (iSelected==false) {
	    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
	    			$(objDel).appendTo($(container));
	    			iSelected = true;
	    			$(objDel).click(function() {
	    				$("#spinningSquaresG").show();
	    				$(".activeImage").each(function() {
	    					_flaskLib.deleteImage($(this).attr("data-uuid"), imageGroupId, objDel);
	    					fnDeleteEventDetailImage($(this).attr("data-eventDetailImageId"));
	    					$(this).remove();
	    				});
	    				if ($(".activeImage").length==0) {
	    					$("#spinningSquaresG").hide();
	    					$(this).remove();
	    					iSelected = false;
	    				}
	    			});
	    		}
	    	}
	    	else {
	    		$(".cssDelImages").remove();
	    		iSelected = false;
	    	}
	    });
	}
	else{
		var objdiv = $('<div/>',{'class':'GridSlides','style':'background-image:url('+imgURL+')','data-uuid':imageUUID, 'data-venueDetailImageId': eventDetailImageId,'data-imageURL':imgURL});
		$(container).owlCarousel({
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
		$(container).data('owlCarousel').addItem(objdiv);
		$(objdiv).click(function() {
			var imgContainer = $('.imageContainer');
			imgContainer.html('');
			var objImage = $('<img/>',{'src':$(this).attr('data-imageURL')});
			imgContainer.append(objImage);
	    	$('.md-trigger').click();
		});				
	}
}