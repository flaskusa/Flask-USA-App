var venueDetailForm;
var dropZone;
var JsonObj;
var JsonEventDetails;
var iSelected;
var noOfInvitations = 5;
var noOfImages = 2

function addDetailsClickHandlers() {
	venueDetailForm = $("#venueDetailsForm");
	
	$(".clsAdd5More").click(function(){
		add5moreRows();
	});
	
	/* Initialize display elements */
	$(".cssVdSave")
			.click(
					function() {
						window.location.hash = "#ManageVenueContent";
						if (fnCheckDuplicateTitle($("#infoTitle").val())) {
							_flaskLib
									.showWarningMessage(
											'action-msg-warning',
											_venueDetailModel.MESSAGES.DETAIL_DUPLICATE);
						} else {
							if ($('#venueDetailsForm').jqxValidator('validate')) {
								if ($('#addrLine1').val() == undefined) {
									$('#lat').val(0);
									$('#lng').val(0);
									saveVenueDetails();
								} else {

									try {
										var geocoder = new google.maps.Geocoder();
										geocoder
												.geocode(
														{
															address : $(
																	'#addrLine1')
																	.val(),
															region : 'no'
														},
														function(results,
																status) {
															try {
																if (status
																		.toLowerCase() == 'ok') {
																	// Get
																	// center
																	var coords = new google.maps.LatLng(
																			results[0]['geometry']['location']
																					.lat(),
																			results[0]['geometry']['location']
																					.lng());

																	console
																			.log(coords
																					.lat());
																	$('#lat')
																			.val(
																					coords
																							.lat());
																	$('#lng')
																			.val(
																					coords
																							.lng());
																}
															} catch (ex) {
																_flaskLib
																.showErrorMessage(
																		'action-msg',
																		_eventDetailModel.MESSAGES.GOCODING_ERROR);
															} finally {
																saveVenueDetails();
															}
														});
									} catch (ex) {
										_flaskLib
												.showErrorMessage(
														'action-msg',
														_eventDetailModel.MESSAGES.CHECK_INTERNET_CONNECTION);
									}
								}

							}
						}
					});

	$(".cssAddVenueDetails").click(function() {
		if (window.location.hash != "#VenueDetail") {
			window.location.hash = "#VenueDetail";
		}
		$("#venueDetailId").val(0);
		_flaskDetailCommon.loadInfoType('infoTypeId', 1);
		_flaskDetailCommon.loadContentType('infoTypeCategoryId', 1);
	});

	$(".cssVdCancel").click(function() {
		if (window.location.hash != "#ManageVenueContent") {
			window.location.hash = "#ManageVenueContent";
		}
		$("#venueDetailsForm").hide();
		$("#venueDetailsDataTable").show();
		loadVenueDetailsData($('#venueForm #venueId').val());
		$("#slides").html("");
		$(".cssVdSave").removeAttr("disabled");
	});

	$("#infoTypeId").change(
			function() {
				_flaskDetailCommon.setContentType("infoTypeCategoryId", null,
						$("#infoTypeId").val(),
						_flaskDetailCommon.infoCategoryJSON);
			});

	$(".cssShowVenueList").click(function() {
		if (window.location.hash != "#ImportVenueDetail") {
			window.location.hash = "#ImportVenueDetail";
		}
		loadVenueData();
	});
}

function add5moreRows(){
	for(var i=noOfInvitations+1 ; i <= noOfInvitations+5;i++){
		var invitationDiv = '<div class="control-group">';
		invitationDiv = invitationDiv + '<div class="controls">';
		invitationDiv = invitationDiv + '<input id="subDetailTitle'+i+'" name="subDetailTitle'+i+'" type="text" placeholder="Enter Title" maxlength="70" class="input-medium sub-detail-text-box">';
		invitationDiv = invitationDiv + '<textarea id="subDetailDesc'+i+'" name="subDetailDesc'+i+'" placeholder="Enter Description" maxlength="255" class="Text-Area"></textarea>';
		invitationDiv = invitationDiv + "</div></div>";
		$(".divHeight").append(invitationDiv);
	}
	noOfInvitations +=5;
}

function loadVenueDetailsData(venueId) {
	var flaskRequest = new Request();
	// venueId = $("#_venueId").val();
	params = {
		'venueId' : venueId
	};
	flaskRequest.sendGETRequest(
			_venueDetailModel.SERVICE_ENDPOINTS.GET_VENUE_DETAILS, params,
			function(data) {/* success handler */
				JsonEventDetails = data;
				GRID_PARAM_DETAILS.updateGrid(data);
				iSelected = false;
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage('action-msg',
						_venueDetailModel.MESSAGES.DETAIL_GET_ERROR);
				console.log("Error in getting data: " + error);
			});
	$("#action-msg-warning").hide();
}

function contextMenuHandlerDetails(menuItemText, rowData) {
	if (menuItemText == "Edit") {
		editVenueDetail(rowData);
		return false;
	} else if (menuItemText == "Delete") {
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteVenueDetail(rowData.venueDetailId, $('#venueForm #venueId')
					.val(), rowData.infoTypeId);
		}
		return false;
	}
};
//

$(".infoTypeCat").click(
		function() {
			// addDetailsClickHandlers();
			initDetailsForm();
			var InfoTypeCd = Number($(this).attr('data-value'));
			$("#infoTypeId").val(InfoTypeCd);
			createDetailsTable({}, _venueDetailModel.DATA_MODEL.VENUEDETAILS,
					$('#gridDetails'), "actionMenuDetails", "Edit",
					contextMenuHandlerDetails, [ "Details", "Images" ],
					_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
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
			switch ($(this).attr('data-value')) {
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

/* Dynamic content type generation logic [Start] */
function fnRenderContentType(InfoTypeID) {
	$("#infoTypeId").val(InfoTypeID);
	$("#venueDetailsContainer").show();
	$("#formContainer").hide();
}

$(document).ready(
		function() {
			addDetailsClickHandlers();
			$(window).hashchange(function() {
				var hash = location.hash;
				switch (hash) {
				case "#VenueDetail":
					$("#venueDetailsForm").show();
					$("#venueDetailsDataTable").hide();
					$(".cssVdSave").removeAttr("disabled");
					break;
				case "#ManageVenueContent":
					$(".cssVdCancel").click();
					break;
				default:
					// alert("This is default");
				}
			});
			formArea = $("#contentTypeForm"); // Parent Div
			$("#infoTypeCategoryId").change(
					function() {
						$(formArea).html("");
						var selectedContentType = $("option:selected", this)
								.text().toLowerCase();
						_infoTypeRenderer.fnRenderForm(selectedContentType,
								"venue");
						$('#venueDetailsForm').jqxValidator({
							hintType : 'label',
							animationDuration : 0,
							rules : [ {
								input : '#infoTitle',
								message : 'Info Title is required!',
								action : 'keyup, blur',
								rule : 'required'
							}
							// { input: '#infoDesc', message: 'Info Description
							// is required!', action: 'keyup, blur', rule:
							// 'required' }
							]
						});
						$(".clsAdd5More").click(function(){
							add5moreRows();
						});
					});
		});

/* Dynamic content type generation logic [End] */
function saveVenueDetails() {
	
	params = _flaskLib.getFormData('venueDetailsForm',
			_venueDetailModel.DATA_MODEL.VENUEDETAILS, function(formId, model,
					formData) {
				$.each(model, function(i, item) {
					var ele = $('#' + formId + ' #' + item.name);
					var val = $.trim(ele.val());
					if (item.type == 'long' && val == '') {
						val = Number(val)
					} else if (item.type == 'boolean' && val == '') {
						val = 1;
					}
					formData[item.name] = val;
					console.log(item.name + '-' + formData[item.name]);
				});
				formData.infoDesc = $("#jqxEditor").val();
				if (formData.infoDesc == undefined) {
					formData.infoDesc = "";
				}
				formData.venueId = $('#venueForm #venueId').val();
				if ($('#addrLine1').val() == undefined) {
					formData.addrLine1 = "";
				}
				formData.latitude = $('#lat').val();
				formData.longitude = $('#lng').val();
				return formData;
			});
	params.venueSubDetails = [];
	params.infoDesc = "";
	for(var i=1; i <=noOfInvitations; i++){
		var record ={};
		var title ="";
		var desc ="";
		if($("#venueDetailsForm #subDetailTitle"+i).val() == "" || $("#venueDetailsForm #subDetailTitle"+i).val() == null){
			title = null;
		}else{
			title = $.trim($("#venueDetailsForm #subDetailTitle"+i).val());
		}
		if($("#venueDetailsForm #subDetailDesc"+i).val() == "" || $("#venueDetailsForm #subDetailDesc"+i).val() == null){
			desc = null;
		}else{
			desc = $.trim($("#venueDetailsForm #subDetailDesc"+i).val());
		}
		if((title == "" || title == null) && (desc == "" || desc == null)){
		}else{
			record["title"] = JSON.stringify(title);
			record["desc"] = JSON.stringify(desc);
			params.venueSubDetails.push(record);
		}
	}
	
	var flaskRequest = new Request();
	var url = ""
	if (params.venueDetailId == 0) {
		url = _venueDetailModel.SERVICE_ENDPOINTS.ADD_VENUE_DETAILS;
	} else {
		url = _venueDetailModel.SERVICE_ENDPOINTS.UPDATE_VENUE_DETAILS;
	}
	flaskRequest.sendGETRequest(url, params, function(data) {
		_flaskLib.showSuccessMessage('action-msg',
				_venueDetailModel.MESSAGES.DETAIL_SAVE);
		if ($('#venueImages').find('.dz-image').length > 0) {
				fnSaveImages(data.venueDetailId, data.infoType);
		}else{
		
			$('#venueDetailsForm').hide();
			$('#venueDetailsDataTable').show();
			$("#venueDetailId").val(0);
			$("#infoTypeCategoryId").val(0);
			loadVenueDetailsData(data.venueId);
			$('#jqxEditor').jqxEditor('destroy');
		}
	}, function(data) {
		_flaskLib.showErrorMessage('action-msg',
				_venueDetailModel.MESSAGES.DETAIL_ERROR);
	});
	$("#slides").html("");
}

/* Delete Single Venue */
function deleteVenueDetail(venueDetailId, venueId, infoTypeId) {
	var param = {
		'venueDetailId' : venueDetailId
	};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(
			_venueDetailModel.SERVICE_ENDPOINTS.DELETE_VENUE_DETAIL, param,
			function(data) {
				_flaskLib.showSuccessMessage('action-msg',
						_venueDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
				loadVenueDetailsData(venueId);
			}, function(data) {
				_flaskLib.showErrorMessage('action-msg',
						_venueDetailModel.MESSAGES.DETAIL_DEL_ERR);
			});
}

/* Delete Multiple Venues */
function deleteMultipleVenueDetail(venueList) {
	var param = {
		'venueIds' : venueList
	};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(
			_venueDetailModel.SERVICE_ENDPOINTS.DELETE_ALL_VENUE_DETAILS,
			param, function(data) {
				_flaskLib.showSuccessMessage('action-msg',
						_venueDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
			}, function(data) {
				_flaskLib.showErrorMessage('action-msg',
						_venueDetailModel.MESSAGES.DETAIL_DEL_ERR);
			});
}

/* Edit Venue */
function editVenueDetail(rowData) {
	window.location.hash = "#VenueDetail";
	var container = $('#venueDetailGallery');
	container.html("");
	var repositoryId = $("#repositoryId").val();
	$('#venueDetailsForm #venueId').val($('#venueForm #venueId').val());
	$('#venueDetailId').val(rowData.venueDetailId);
	$('#_venueDetailId').val(rowData.venueDetailId);
	_flaskDetailCommon.loadInfoType('infoTypeId', rowData.infoTypeId);
	_flaskDetailCommon.loadContentType("infoTypeCategoryId",
			rowData.infoTypeCategoryId, rowData.infoTypeId);
	setTimeout(function() {
		_flaskLib.loadDataToForm("venueDetailsForm",
				_venueDetailModel.DATA_MODEL.VENUEDETAILS, rowData, function() {
				});
		$('#addrLine1').val(rowData.addrLine1);
		$('#jqxEditor').val(rowData.infoDesc);
	}, 500);
	// fnShowSlider($('#venueForm
	// #venueId').val(),container,rowData.venueDetailId,rowData.infoTypeId,rowData.infoTypeCategoryId);
	getVenueSubDetails(rowData.venueDetailId);
	fnGetVenueDetailImages(rowData.venueDetailId, container, true);
}

function formatUnixToTime(tdate) {
	var date = new Date(tdate);
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
			// $("#infoTypeCategoryId").change();
			loadVenueDetailsData($('#venueForm #venueId').val());
		}, 1)
	});
}
var wait = function(callback, seconds) {
	return window.setTimeout(callback, seconds * 1000);
}

function fnShowSlider(_venueId, _divObj, _venueDetailId, _infoTypeId,
		_infoTypeCategoryId) {
	var repositoryId = $("#repositoryId").val();
	var venueId = _venueId;
	var infoTypeId = _infoTypeId;
	var infoTypeCategoryId = _infoTypeCategoryId;
	var venueDetailId = _venueDetailId;
	var flaskRequest = new Request();
	params = {
		'repositoryId' : repositoryId,
		'parentFolderId' : 0,
		'name' : 'Venue'
	};
	flaskRequest
			.sendGETRequest(
					_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER,
					params,
					function(data) {
						folderName = 'Venue-' + _venueId;
						var flaskRequestChild = new Request();
						paramsChild = {
							'repositoryId' : repositoryId,
							'parentFolderId' : data.folderId,
							'name' : folderName
						};
						flaskRequestChild
								.sendGETRequest(
										_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER,
										paramsChild,
										function(data) {
											// data.folderId;
											var flaskRequestChild1 = new Request();
											paramsChild1 = {
												'repositoryId' : repositoryId,
												'parentFolderId' : data.folderId,
												'name' : infoTypeId
											};
											flaskRequestChild1
													.sendGETRequest(
															_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER,
															paramsChild1,
															function(data) {
																var flaskRequestChild2 = new Request();
																paramsChild2 = {
																	'repositoryId' : repositoryId,
																	'parentFolderId' : data.folderId,
																	'name' : infoTypeCategoryId
																};
																flaskRequestChild2
																		.sendGETRequest(
																				_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER,
																				paramsChild2,
																				function(
																						data) {
																					folderId = data.folderId;
																					var flaskRequestChild3 = new Request();
																					paramsChild3 = {
																						'repositoryId' : repositoryId,
																						'parentFolderId' : data.folderId,
																						'name' : venueDetailId
																					};
																					flaskRequestChild3
																							.sendGETRequest(
																									_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER,
																									paramsChild3,
																									function(
																											data) {
																										fnRenderSlider(
																												data.folderId,
																												_divObj);
																									},
																									function(
																											data) {
																										_flaskLib
																												.showInformationMessage(
																														_divObj,
																														_venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO);
																									});
																				},
																				function(
																						data) {
																					_flaskLib
																							.showInformationMessage(
																									_divObj,
																									_venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO);
																				});
															},
															function(data) {
																_flaskLib
																		.showInformationMessage(
																				_divObj,
																				_venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO);
															});
										},
										function(data) {
											_flaskLib
													.showInformationMessage(
															_divObj,
															_venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO);
										});
					},
					function(data) {
						_flaskLib
								.showInformationMessage(
										_divObj,
										_venueDetailModel.MESSAGES.DETAIL_NO_IMAGES_INFO);
					});
}

function fnRenderSlider(folderId, _divObj) {
	$(_divObj).html("");
	$(".venueLogo").removeClass("activeImage");
	var flaskRequest = new Request();
	params = {
		'repositoryId' : $("#repositoryId").val(),
		'folderId' : folderId
	};
	flaskRequest
			.sendGETRequest(
					_venueDetailModel.SERVICE_ENDPOINTS.GET_FILES,
					params,
					function(data) {
						if (typeof data == "object") {
							var iSelected = false;
							for (var iCount = 0; iCount < data.length; iCount++) {
								var imgURL = '/documents/'
										+ data[iCount].groupId + '/'
										+ data[iCount].folderId + '/'
										+ data[iCount].title;
								var objdiv = $(
										'<div/>',
										{
											'class' : 'venueLogo',
											'style' : 'background-image:url('
													+ imgURL + ')',
											'data-fileEntryId' : data[iCount].fileEntryId
										});
								$(objdiv).appendTo($(_divObj));
								$(objdiv)
										.click(
												function() {
													$(this).toggleClass(
															"activeImage");
													if ($(".activeImage").length > 0) {
														if (iSelected == false) {
															var objDel = $(
																	'<input/>',
																	{
																		'class' : 'btn btn-info cssDelImages',
																		'type' : 'button',
																		'value' : 'Delete selected'
																	});
															$(objDel).appendTo(
																	$(_divObj));
															iSelected = true;
															$(objDel)
																	.click(
																			function() {
																				$(
																						"#spinningSquaresG")
																						.show();
																				$(
																						".activeImage")
																						.each(
																								function() {
																									fnDeleteFileByEntryId(
																											$(
																													this)
																													.attr(
																															"data-fileEntryId"),
																											objDel);
																									$(
																											this)
																											.remove();
																								});
																				if ($(".activeImage").length == 0) {
																					$(
																							"#spinningSquaresG")
																							.hide();
																					$(
																							this)
																							.remove();
																					iSelected = false;
																				}
																			});
														}
													} else {
														$(".cssDelImages")
																.remove();
														iSelected = false;
													}
												});
							}
						}
					}, function(data) {
						console.log("Error in getting Folder: " + data);
					});
}

$(document).ready(function() {
	$("#mvcontents").click(function() {
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

	$('.md-closeBtn').click(function() {
		$('#modal-advertisement').removeClass('md-show');
		$('#modal-venueImport').removeClass('md-show');
	});
});

function fnCheckDuplicateTitle(_infoTitle) {
	if (typeof JsonVenueDetails == "object") {
		var Obj = JsonVenueDetails;
		var iCount = 0;
		var items = Obj.filter(function(item) {
			if (item.infoTitle == _infoTitle) {
				iCount++;
			}
		});
		if (iCount > 0)
			return true;
		else
			return false;
	} else {
		return false;
	}
}

function fnDeleteVenueDetailImage(venueDetailImageId) {
	params = {
		'venueDetailImageId' : venueDetailImageId
	};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(
			_venueDetailModel.SERVICE_ENDPOINTS.DELETE_VENUEDETAIL_IMAGE,
			params, function(data) {
				console.log(data);
			}, function(data) {
				console.log(data);
			});
}

function fnGetVenueDetailImages(venueDetailId, container, editable) {
	params = {
		'venueDetailId' : venueDetailId
	};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(
			_venueDetailModel.SERVICE_ENDPOINTS.GET_VENUEDETAIL_IMAGES, params,
			function(data) {
				$.each(data, function(idx, obj) {
					fnRenderImage(obj.imageUUID, obj.imageGroupId, container,
							obj.venueDetailImageId, editable);
				});
			}, function(data) {
				console.log(data);
			});
}

function fnRenderImage(imageUUID, imageGroupId, container, venueDetailImageId,
		editable) {
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid=" + imageUUID
			+ "&groupId=" + imageGroupId;
	if (editable) {
		var objdiv = $('<div/>', {
			'class' : 'eventLogo',
			'style' : 'background-image:url(' + imgURL + ')',
			'data-uuid' : imageUUID,
			'data-venueDetailImageId' : venueDetailImageId,
			'data-imageURL' : imgURL
		});
		$(objdiv).appendTo($(container));
		$(objdiv)
				.click(
						function() {
							$(this).toggleClass("activeImage");
							if ($(".activeImage").length > 0) {
								if (iSelected == false) {
									var objDel = $('<input/>', {
										'class' : 'btn btn-info cssDelImages',
										'type' : 'button',
										'value' : 'Delete selected'
									});
									$(objDel).appendTo($(container));
									iSelected = true;
									$(objDel)
											.click(
													function() {
														$("#spinningSquaresG")
																.show();
														$(".activeImage")
																.each(
																		function() {
																			_flaskLib
																					.deleteImage(
																							$(
																									this)
																									.attr(
																											"data-uuid"),
																							imageGroupId,
																							objDel);
																			fnDeleteVenueDetailImage($(
																					this)
																					.attr(
																							"data-venueDetailImageId"));
																			$(
																					this)
																					.remove();
																		});
														if ($(".activeImage").length == 0) {
															$(
																	"#spinningSquaresG")
																	.hide();
															$(this).remove();
															iSelected = false;
														}
													});
								}
							} else {
								$(".cssDelImages").remove();
								iSelected = false;
							}
						});
	} else {
		var objdiv = $('<div/>', {
			'class' : 'GridSlides',
			'style' : 'background-image:url(' + imgURL + ')',
			'data-uuid' : imageUUID,
			'data-venueDetailImageId' : venueDetailImageId,
			'data-imageURL' : imgURL
		});
		$(container).owlCarousel(
				{
					items : 3,
					navigation : true,
					navigationText : [
							"<i class='icon-chevron-left icon-white'></i>",
							"<i class='icon-chevron-right icon-white'></i>" ],
					pagination : true,
					items : 5,
					itemsCustom : false,
					itemsDesktop : [ 1199, 4 ],
					itemsDesktopSmall : [ 980, 3 ],
					itemsTablet : [ 768, 2 ],
					itemsTabletSmall : false,
					itemsMobile : [ 479, 1 ],
					singleItem : false,
					itemsScaleUp : false,
				});
		$(container).data('owlCarousel').addItem(objdiv);
		$(objdiv).click(function() {
			var imgContainer = $('.imageContainer');
			imgContainer.html('');
			var objImage = $('<img/>', {
				'src' : $(this).attr('data-imageURL')
			});
			imgContainer.append(objImage);
			$('.md-trigger').click();
		});
	}
}


function getVenueSubDetails(venueDetailId) {
	params = {
		'venueDetailId' : venueDetailId
	};
	$(".divHeight").empty();
	noOfInvitations = 0;
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(
			_venueDetailModel.SERVICE_ENDPOINTS.GET_VENUE_SUB_DETAIL_BY_VENUE_DETAIL_ID, params,
			function(data) {
				$.each(data, function(idx, obj) {
					fnRenderVenueSubDetails(idx+1, obj.venueSubDetailTitle, obj.venueSubDetailDesc);
				});
			}, function(data) {
				console.log(data);
			});
} 

function fnRenderVenueSubDetails(idx, venueSubDetailTitle, venueSubDetailDesc){
	var titleid="#subDetailTitle"+idx;
	var descid="#subDetailDesc"+idx;
	if($(titleid).length > 0){
		$(titleid).val(venueSubDetailTitle);
		$(descid).text(venueSubDetailDesc);
	}else{
		var invitationDiv = '<div class="control-group">';
		invitationDiv = invitationDiv + '<div class="controls">';
		invitationDiv = invitationDiv + '<input id="subDetailTitle'+idx+'" name="subDetailTitle'+idx+'" type="text" value="'+venueSubDetailTitle+'" placeholder="Enter Title" maxlength="70" class="input-medium sub-detail-text-box">';
		invitationDiv = invitationDiv + '<textarea id="subDetailDesc'+idx+'" name="subDetailDesc'+idx+'" placeholder="Enter Description" maxlength="255" class="Text-Area">'+venueSubDetailDesc+'</textarea>';
		invitationDiv = invitationDiv + "</div></div>";
		$(".divHeight").append(invitationDiv);
	}
	if(idx <= 5){
		noOfInvitations = 5;
	}else{
		noOfInvitations = idx;
	}
	
}

function loadVenueData() {
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_VENUE,
			params, function(data) {/* success handler */
				fnFillVenueList(data);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage('action-msg',
						_venueModel.MESSAGES.GET_ERROR);
			});
}

function fnFillVenueList(data) {
	$('#VenueList').html('');
	$.each(data, function(i, item) {
		if ($('#venueId').val() != item.venueId) {
			$('#VenueList').append($('<option>', {
				value : item.venueId,
				text : item.venueName
			}));
		}
	});
	$(".VenueContainer").append($('#VenueList'));
	_flaskDetailCommon.loadInfoType('_infoTypeId', 1);
	$("#_infoTypeId option[value='0']").remove();
	_flaskDetailCommon.loadContentType('_infoTypeCategoryId', 1);
	$("#_infoTypeId").change(
			function() {
				_flaskDetailCommon.setContentType("_infoTypeCategoryId", null,
						$("#_infoTypeId").val(),
						_flaskDetailCommon.infoCategoryJSON);
			});
	$('.md-trigger1').click();

	$(".cssImportVenueDetails")
			.click(
					function() {
						var flaskRequest = new Request();
						var sourceVenueId = $('#VenueList').val();
						var destinationVenueId = $('#venueId').val();
						var infoTypeCategoryId = $('#_infoTypeCategoryId')
								.val();
						params = {
							'sourceVenueId' : sourceVenueId,
							'destinationVenueId' : destinationVenueId,
							'infoTypeCategoryId' : infoTypeCategoryId
						};
						flaskRequest
								.sendGETRequest(
										_venueDetailModel.SERVICE_ENDPOINTS.COPY_VENUEDETAILS_WITH_IMAGE,
										params,
										function(data) {/* success handler */
											loadVenueDetailsData($('#venueId')
													.val());
											$("#modal-venueImport")
													.removeClass('md-show');
											_flaskLib
													.showSuccessMessage(
															'action-msg',
															_venueDetailModel.MESSAGES.COPY_VENUEDETAIL_SUCCESS);
										},
										function(error) { /* failure handler */
											_flaskLib
													.showErrorMessage(
															'action-msg',
															_venueModel.MESSAGES.GET_ERROR);
										});
					});
}