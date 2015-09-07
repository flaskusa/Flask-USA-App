var venueDetailForm;
var dropZone;
var JsonObj;
var JsonEventDetails;
var iSelected;

function addDetailsClickHandlers() {
	venueDetailForm = $("#venueDetailsForm");
	/*	Initialize display elements*/
	$(".cssVdSave").click(function() {
		 if (fnCheckDuplicateTitle($("#infoTitle").val())) {
			   _flaskLib.showWarningMessage('action-msg-warning', _venueDetailModel.MESSAGES.DETAIL_DUPLICATE);
			  }
		if ($('#venueDetailsForm').jqxValidator('validate'))
		saveVenueDetails();
	});

	$(".cssAddVenueDetails").click(function() {
		$("#venueDetailId").val(0);
		_flaskDetailCommon.loadInfoType('infoTypeId',1);
		_flaskDetailCommon.loadContentType('infoTypeCategoryId',1);
		$("#venueDetailsForm").show();
		$("#venueDetailsDataTable").hide();
	});

	$(".cssVdCancel").click(function() {
		$("#venueDetailsForm").hide();
		$("#venueDetailsDataTable").show();
		loadVenueDetailsData($('#venueForm #venueId').val(),$("#infoTypeId").val());
		$("#slides").html("");
	});
	
	$("#infoTypeId").change(function() {
		_flaskDetailCommon.setContentType("infoTypeCategoryId",null, $("#infoTypeId").val(), _flaskDetailCommon.infoCategoryJSON);
	});
}

function loadVenueDetailsData(venueId) {
	var flaskRequest = new Request();
	//venueId = $("#_venueId").val();
	params = {'venueId':venueId};
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_VENUE_DETAILS, params,
	function(data){/*success handler*/
		JsonEventDetails = data;
		GRID_PARAM_DETAILS.updateGrid(data);
		iSelected = false;
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_venueDetailModel.MESSAGES.DETAIL_GET_ERROR);
		console.log("Error in getting data: " + error);
	});
	$("#action-msg-warning").hide();
}

function contextMenuHandlerDetails(menuItemText, rowData) {
	if (menuItemText  == "Edit") {
		editVenueDetail(rowData);
		return false;
	}else if (menuItemText == "Delete") {
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteVenueDetail(rowData.venueDetailId, rowData.venueId, rowData.infoTypeId);
		}
		return false;
	}
};
//

$(".infoTypeCat").click(function() {
	addDetailsClickHandlers();
	initDetailsForm();
	var InfoTypeCd = Number($(this).attr('data-value'));
	$("#infoTypeId").val(InfoTypeCd);
	createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
	loadVenueDetailsData($('#venueForm #venueId').val());

	var click = new Date();
	var lastClick = new Date();
	var lastRow = -1;
	$("#gridDetails").bind('rowclick', function(venue) {
	    click = new Date();
	    if (click - lastClick < 300) {
	        if (lastRow == venue.args.rowindex) {
	        	var row = venue.args.rowindex;
			 	var datarow = $(this).jqxGrid('getrowdata', row);
			 	editVenueDetail(datarow);
	        }
	    }
	    lastClick = new Date();
	    lastRow = venue.args.rowindex;
	});

	$("#venueDetailsContainer").show();
	switch($(this).attr('data-value')) {
	case "1":
		$('.title-text').html('General');
		break;
	case "2":
		$('.title-text').html('Pre-Event');
		break;
	case "3":
		$('.title-text').html('During-Event');
		break;
	case "4":
		$('.title-text').html('Post-Event');
		break;
	}
});

function initDetailsForm() {
	$("#venueDetailsContainer").hide();
}

/* Dynamic content type generation logic [Start]*/
function fnRenderContentType(InfoTypeID) {
	$("#infoTypeId").val(InfoTypeID);
	$("#venueDetailsContainer").show();
	$("#formContainer").hide();
}

$(document).ready(function() {
	formArea = $("#contentTypeForm"); // Parent Div
	$("#infoTypeCategoryId").change(function() {
		$(formArea).html("");
		var selectedContentType = $("option:selected", this).text().toUpperCase().replace(/ /g,'');
		_infoTypeRenderer.fnRenderForm(selectedContentType);
		$('#venueDetailsForm').jqxValidator
		({
			hintType: 'label',
			animationDuration: 0,
			rules: [
						{ input: '#infoTitle', message: 'Info Title is required!', action: 'keyup, blur', rule: 'required' }
						//{ input: '#infoDesc', message: 'Info Description is required!', action: 'keyup, blur', rule: 'required' }
				   ]
		});
	});
});

/* Dynamic content type generation logic [End]*/
function saveVenueDetails() {
	params = _flaskLib.getFormData('venueDetailsForm',_venueDetailModel.DATA_MODEL.VENUEDETAILS,
			function(formId, model, formData) {
				$.each(model, function(i, item) {
					var ele = $('#'+ formId + ' #'+item.name);
					var val = $.trim(ele.val());
					if (item.type == 'long' && val =='') {
						val = Number(val)
					}else if (item.type == 'boolean' && val =='') {
						val = 1;
					}
					formData[item.name] = val;
				});
				formData.venueId=$('#venueForm #venueId').val();
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
		if (params.venueDetailId == 0) {
			url = _venueDetailModel.SERVICE_ENDPOINTS.ADD_VENUE_DETAILS;
		}else {
			url =_venueDetailModel.SERVICE_ENDPOINTS.UPDATE_VENUE_DETAILS;
		}
	flaskRequest.sendGETRequest(url, params,
				function(data) {
					_flaskLib.showSuccessMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_SAVE);
					if ($('.dz-image').length > 0) {
						fnSaveImages(data.venueDetailId, data.infoType);
					}
					else {
						$('#venueDetailsForm').hide();
			    		$('#venueDetailsDataTable').show();
			    		$("#venueDetailId").val(0);
			    		$("#infoTypeCategoryId").val(0);
			    		//$("#infoTypeCategoryId").change();
			    		loadVenueDetailsData(data.venueId,data.infoTypeId);
					}
				} ,
				function(data) {
					_flaskLib.showErrorMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_ERROR);
				});
	$("#slides").html("");
}

/* Delete Single Venue */
function deleteVenueDetail(venueDetailId, venueId, infoTypeId) {
		var param = {'venueDetailId': venueDetailId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_venueDetailModel.SERVICE_ENDPOINTS.DELETE_VENUE_DETAIL , param,
			function(data) {
					_flaskLib.showSuccessMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
					loadVenueDetailsData(venueId,infoTypeId);
			} ,
			function(data) {
					_flaskLib.showErrorMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_DEL_ERR);
			});
}

/* Delete Multiple Venues */
function deleteMultipleVenueDetail(venueList) {
	var param = {'venueIds': venueList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueDetailModel.SERVICE_ENDPOINTS.DELETE_ALL_VENUE_DETAILS, param,
		function(data) {
				_flaskLib.showSuccessMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
		} ,
		function(data) {
				_flaskLib.showErrorMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_DEL_ERR);
		});
}

/* Edit Venue */
function editVenueDetail(rowData) {
		var container = $('#venueDetailGallery');
		container.html("");
		var repositoryId = $("#repositoryId").val();
		$('#venueDetailsForm #venueId').val($('#venueForm #venueId').val());
		$('#venueDetailId').val(rowData.venueDetailId);
		$('#_venueDetailId').val(rowData.venueDetailId);
		$('#venueDetailsForm').show();
		$('#venueDetailsDataTable').hide();
		_flaskDetailCommon.loadInfoType('infoTypeId',rowData.infoTypeId);
		_flaskDetailCommon.loadContentType("infoTypeCategoryId",rowData.infoTypeCategoryId, rowData.infoTypeId);
		setTimeout(function() {
			_flaskLib.loadDataToForm("venueDetailsForm",  _venueDetailModel.DATA_MODEL.VENUEDETAILS, rowData, function(){});
		}, 500);
		//fnShowSlider($('#venueForm #venueId').val(),container,rowData.venueDetailId,rowData.infoTypeId,rowData.infoTypeCategoryId);
		fnGetVenueDetailImages(rowData.venueDetailId,container,true);
}

function formatUnixToTime(tdate){var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var seconds = "0" + date.getSeconds();
	return hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
}

function fnSaveImages(venueDetailId, infoTypeId) {
	$("#_venueDetailId").val(venueDetailId);
	dropZone.options.autoProcessQueue = true;
	dropZone.processQueue();
	dropZone.on("queuecomplete", function(file) {
		wait(function() {
			$('#venueDetailsForm').hide();
			$('#venueDetailsDataTable').show();
			$("#venueDetailId").val(0);
			$("#infoTypeCategoryId").val(0);
			//$("#infoTypeCategoryId").change();
			loadVenueDetailsData($('#venueForm #venueId').val(),infoTypeId);
		},1)
	});
}

var wait = function(callback, seconds) {
	return window.setTimeout(callback, seconds * 1000);
}



function fnShowSlider(_venueId,_divObj,_venueDetailId,_infoTypeId,_infoTypeCategoryId) {
	var repositoryId = $("#repositoryId").val();
	var venueId = _venueId;
	var infoTypeId = _infoTypeId;
	var infoTypeCategoryId = _infoTypeCategoryId;
	var venueDetailId = _venueDetailId;
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': 0, 'name': 'Venue'};
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , params,
		function(data) {
			folderName = 'Venue-'+_venueId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild,
				function(data) {
					//data.folderId;
					var flaskRequestChild1 = new Request();
					paramsChild1= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': infoTypeId};
					flaskRequestChild1.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild1,
						function(data) {
							var flaskRequestChild2 = new Request();
							paramsChild2= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': infoTypeCategoryId};
							flaskRequestChild2.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild2,
								function(data) {
									folderId = data.folderId;
									var flaskRequestChild3 = new Request();
									paramsChild3= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': venueDetailId};
									flaskRequestChild3.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild3,
										function(data) {
											fnRenderSlider(data.folderId,_divObj);
										} ,
										function(data){ _flaskLib.showInformationMessage(_divObj, _venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO); });
								} ,
								function(data){ _flaskLib.showInformationMessage(_divObj, _venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO); });
						} ,
						function(data){ _flaskLib.showInformationMessage(_divObj, _venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO); });
				} ,
				function(data){ _flaskLib.showInformationMessage(_divObj, _venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO); });
		} ,
		function(data){ _flaskLib.showInformationMessage(_divObj, _venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO); });
}

function fnRenderSlider(folderId,_divObj) {
	$(_divObj).html("");
	$(".venueLogo").removeClass("activeImage");
	var flaskRequest = new Request();
	params= {'repositoryId': $("#repositoryId").val(), 'folderId': folderId};
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FILES , params,
		function(data) {
			if (typeof data=="object") {
				var iSelected = false;
		    	for (var iCount=0;iCount<data.length;iCount++) {
		    		var imgURL = '/documents/'+data[iCount].groupId+'/'+data[iCount].folderId+'/'+data[iCount].title;
				    var objdiv = $('<div/>',{'class':'venueLogo','style':'background-image:url('+imgURL+')','data-fileEntryId':data[iCount].fileEntryId});
				    $(objdiv).appendTo($(_divObj));
				    $(objdiv).click(function() {
				    	$(this).toggleClass("activeImage");
				    	if ($(".activeImage").length>0) {
				    		if (iSelected==false) {
				    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
				    			$(objDel).appendTo($(_divObj));
				    			iSelected = true;
				    			$(objDel).click(function() {
				    				$("#spinningSquaresG").show();
				    				$(".activeImage").each(function() {
				    					fnDeleteFileByEntryId($(this).attr("data-fileEntryId"),objDel);
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
		    }
		} ,
		function(data) {
			console.log("Error in getting Folder: " + data );
		});
}


$(document).ready(function() {
	$("#mcontents").click(function() {
		addDetailsClickHandlers();
		initDetailsForm();
		loadVenueDetailsData($('#venueForm #venueId').val());
		var click = new Date();
		var lastClick = new Date();
		var lastRow = -1;
		$("#gridDetails").bind('rowclick', function(event) {
		    click = new Date();
		    if (click - lastClick < 300) {
		        if (lastRow == event.args.rowindex) {
		        	var row = event.args.rowindex;
	        	 	var datarow = $(this).jqxGrid('getrowdata', row);
	        	 	editVenueDetail(datarow);
		        }
		    }
		    lastClick = new Date();
		    lastRow = event.args.rowindex;
		});
		$("#venueDetailsContainer").show();
	});
});

function fnCheckDuplicateTitle(_infoTitle) {
	 if (typeof JsonVenueDetails=="object") {
	  var Obj = JsonVenueDetails;
	  var iCount = 0;
	     var items = Obj.filter(function(item) {
		      if (item.infoTitle==_infoTitle) {
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

function fnDeleteVenueDetailImage(venueDetailImageId) {
	params= {'venueDetailImageId': venueDetailImageId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.DELETE_VENUEDETAIL_IMAGE , params,
		function(data) {
			console.log(data);
		},
		function(data) {
			console.log(data);
		});
}


function fnGetVenueDetailImages(venueDetailId,container,editable) {
	params= {'venueDetailId': venueDetailId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_VENUEDETAIL_IMAGES , params,
		function(data) {
			$.each(data, function(idx, obj) {
				fnRenderImage(obj.imageUUID,obj.imageGroupId, container, obj.venueDetailImageId, editable);
			});
		},
		function(data) {
			console.log(data);
		});
}

function fnRenderImage(imageUUID, imageGroupId, container, venueDetailImageId, editable) {
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-uuid':imageUUID, 'data-venueDetailImageId': venueDetailImageId});
	$(objdiv).appendTo($(container));
	if (editable) {
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
	    					fnDeleteVenueDetailImage($(this).attr("data-venueDetailImageId"));
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
}