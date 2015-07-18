var venueDetailForm;
var dropZone;
var JsonObj;

function addDetailsClickHandlers(){
	venueDetailForm = $("#venueDetailsForm");
	/*	Initialize display elements*/
	$(".cssVdSave").click(function(){
		if($('#venueDetailsForm').jqxValidator('validate'))
		saveVenueDetails();
	});	
	
	$(".cssAddVenueDetails").click(function(){
		$("#venueDetailId").val(0);
		_venueDetailModel.loadContentType('infoTypeCategoryId',1);
		$("#venueDetailsForm").show();
		$("#venueDetailsDataTable").hide();
	});	

	$(".cssVdCancel").click(function(){
		$("#venueDetailsForm").hide();
		$("#venueDetailsDataTable").show();
		loadVenueDetailsData($('#venueForm #venueId').val(),$("#infoTypeId").val());
		$("#slides").html("");
	});	
}

function loadVenueDetailsData(venueId,infoTypeId){
	var flaskRequest = new Request();
	venueId = $("#_venueId").val();
	params = {'venueId':venueId};
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_VENUE_DETAILS, params, 
	function(data){/*success handler*/
		console.log(data);
		/*if(infoTypeId>0){
		    var returnedData = $.grep(data, function(element, index){
		    	return element.infoTypeId == infoTypeId;
		    });
		    data = returnedData;
		}*/
		GRID_PARAM_DETAILS.updateGrid(data);
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_venueDetailModel.MESSAGES.DETAIL_GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function contextMenuHandlerDetails(menuItemText, rowData){
	if (menuItemText  == "Edit") {
		editVenueDetail(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteVenueDetail(rowData.venueDetailId, rowData.venueId, rowData.infoTypeId);
			GRID_PARAM_DETAILS.updateGrid(data);
		}
		return false;			
	}
};
//

$(".infoTypeCat").click(function(){
	addDetailsClickHandlers();
	initDetailsForm();
	var InfoTypeCd = Number($(this).attr('data-value'));
	$("#infoTypeId").val(InfoTypeCd);
	createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
	loadVenueDetailsData($('#venueForm #venueId').val(),InfoTypeCd);
		
	var click = new Date();
	var lastClick = new Date();
	var lastRow = -1;
	$("#gridDetails").bind('rowclick', function (venue) {
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

function initDetailsForm(){
	$("#venueDetailsContainer").hide();
}

/* Dynamic content type generation logic [Start]*/
function fnRenderContentType(InfoTypeID){
	$("#infoTypeId").val(InfoTypeID);
	$("#venueDetailsContainer").show();
	$("#formContainer").hide();
}

$(document).ready(function(){
    formArea = $("#contentTypeForm"); // Parent Div        
    $("#infoTypeCategoryId").change(function(){
        $(formArea).html("");
        var selectedContentType = $("option:selected", this).text().toUpperCase().replace(/ /g,'');
        fnRenderForm(selectedContentType);
        $('#venueDetailsForm').jqxValidator
        ({
            hintType: 'label',
            animationDuration: 0,
            rules: [
                    	{ input: '#infoTitle', message: 'Info Title is required!', action: 'keyup, blur', rule: 'required' },
                    	//{ input: '#infoDesc', message: 'Info Description is required!', action: 'keyup, blur', rule: 'required' }
                   ]
        });    
    });
});

function fnRenderForm(contentType){
	var Obj = eval("_venueDetailModel.FORM_DATA_MODEL."+contentType);
    fnBuildHtml(Obj);
    if($("#venueDetailId").val()>0){
    	//fnShowSlider();
    }
}

function fnBuildHtml(Obj){
    var items = Obj.filter(function(item) {
        switch(item.type) {
            case "text":
                return fnBuildInput(item.attr);
                break;
            case "select":
                return fnBuildSelect(item.attr);
                break;
            case "boolean":
                return fnBuildBoolean(item.attr);
                break;
            case "upload":
                return fnBuildUpload(item.attr);
                break;
            default:
                console.log("Nothing selected");
        }        
    });      
}

function fnBuildInput(Obj){
    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].id}).appendTo(objFormGroup);
    $(objControlLable).html(Obj[0].caption);
    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
    $('<input/>', {
        'type': 'Text',
        'id':Obj[0].id,
        'value':Obj[0].value,
        'placeholder':Obj[0].placeholder,   
        'maxlength':Obj[0].maxlength
    }).appendTo(objControls);
}

function fnBuildBoolean(Obj){
    var strSelected = "";
    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].id}).appendTo(objFormGroup);
    $(objControlLable).html(Obj[0].caption);
    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
    for(var iCount=0;iCount<Obj[0].items.length;iCount++){
        if(Obj[0].items[0].value==Obj[0].value)
            strSelected = "selected"    
        else
            strSelected = ""                                            
            
         $('<input/>', {
            'type': 'Radio',
            'id':Obj[0].id,
            'name':Obj[0].name,
            'value':Obj[0].value,
            'Selected':strSelected
        }).appendTo(objControls);
        var objItemCaptionLable = $('<span/>',{'class':'control-label'}).appendTo(objControls);
        $(objItemCaptionLable).html(Obj[0].items[iCount]);
    }
}

function fnBuildUpload(Obj){
	  	var strSelected = "";
	  	dropZone = "";
	    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
	    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].caption}).appendTo(objFormGroup);
	    $(objControlLable).html(Obj[0].caption);
	    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
	    var objForm = $('<form/>',{'class':'dropzone','id':'venueImages','action':Obj[0].action}).appendTo(objFormGroup);
	    $(objForm).appendTo(objControls);
	    //return false;
	    var objvenueDetailId = $('<input/>',{'name':'_venueDetailId','id':'_venueDetailId','type':'hidden','value':'0'});
	    $(objvenueDetailId).appendTo(objForm);
	    var objVenueId = $('<input/>',{'name':'_venueId','id':'_venueId','type':'hidden','value':$("#venueId").val()});
	    $(objVenueId).appendTo(objForm);
	    var objInfoTypeId = $('<input/>',{'name':'_infoTypeId','id':'_infoTypeId','type':'hidden','value':$("#infoTypeId").val()});
	    $(objInfoTypeId).appendTo(objForm);
	    var objInfoTypeCategoryId = $('<input/>',{'name':'_infoTypeCategoryId','id':'_infoTypeCategoryId','type':'hidden','value':$("#infoTypeCategoryId").val()});
	    $(objInfoTypeCategoryId).appendTo(objForm);
	    var objIsLogo = $('<input/>',{'name':'_isLogo','id':'_isLogo','type':'hidden','value':'N'});
	    $(objIsLogo).appendTo(objForm);
	    dropZone = new Dropzone($(objForm).get(0),{
	    	autoProcessQueue: false
	    });	
}
/* Dynamic content type generation logic [End]*/
function saveVenueDetails(){
	params = _flaskLib.getFormData('venueDetailsForm',_venueDetailModel.DATA_MODEL.VENUEDETAILS,
			function(formId, model, formData){
				$.each(model, function(i, item) {
					var ele = $('#'+ formId + ' #'+item.name);
					var val = $.trim(ele.val());
					if(item.type == 'long' && val ==''){
						val = Number(val)
					}
					formData[item.name] = val;	
				});
				formData.venueId=$('#venueForm #venueId').val();
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
		if(params.venueDetailId == 0){
			url = _venueDetailModel.SERVICE_ENDPOINTS.ADD_VENUE_DETAILS;
		}else{
			url =_venueDetailModel.SERVICE_ENDPOINTS.UPDATE_VENUE_DETAILS;
		}
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_SAVE);
					loadVenueDetailsData(data.venueId,data.infoTypeId);
					if($('#venueImages').is(':visible')) {					
						fnSaveImages(data.venueDetailId);
					}
				} ,
				function (data){
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
			function (data){
					_flaskLib.showSuccessMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
					createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
					//Change
					loadVenueDetailsData(venueId,infoTypeId);
			} ,
			function (data){
					_flaskLib.showErrorMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_DEL_ERR);
			});
}

/* Delete Multiple Venues */
function deleteMultipleVenueDetail(venueList) {
	var param = {'venueIds': venueList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueDetailModel.SERVICE_ENDPOINTS.DELETE_ALL_VENUE_DETAILS, param, 
		function (data){
				_flaskLib.showSuccessMessage('action-msg', _venueDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
		} ,
		function (data){
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
		_venueDetailModel.loadContentType('infoTypeCategoryId',rowData.infoTypeCategoryId);
		setTimeout(function(){
			_flaskLib.loadDataToForm("venueDetailsForm",  _venueDetailModel.DATA_MODEL.VENUEDETAILS, rowData, function(){});
		}, 500);
    	fnShowSlider($('#venueForm #venueId').val(),container,rowData.venueDetailId,rowData.infoTypeId,rowData.infoTypeCategoryId);	
}

function formatUnixToTime(tdate){var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var seconds = "0" + date.getSeconds();
	return hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
}

function fnSaveImages(venueDetailId){
	$("#_venueDetailId").val(venueDetailId);
	dropZone.options.autoProcessQueue = true;
	dropZone.processQueue();
	dropZone.on("queuecomplete", function (file) {
    	wait(function(){
    		$('#venueDetailsForm').hide();
    		$('#venueDetailsDataTable').show();
    		$("#venueDetailId").val(0);
    		$("#infoTypeCategoryId").val(0);
    		$("#infoTypeCategoryId").change();
    	},1)					
    });	
}

var wait = function(callback, seconds) {
	return window.setTimeout(callback, seconds * 1000);
}



function fnShowSlider(_venueId,_divObj,_venueDetailId,_infoTypeId,_infoTypeCategoryId){
	var repositoryId = $("#repositoryId").val();
	var venueId = _venueId;
	var infoTypeId = _infoTypeId;
	var infoTypeCategoryId = _infoTypeCategoryId;
	var venueDetailId = _venueDetailId;
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': 0, 'name': 'Venue'};
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			folderName = 'Venue-'+_venueId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild, 
				function (data){
					//data.folderId;
					var flaskRequestChild1 = new Request();
					paramsChild1= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': infoTypeId};
					flaskRequestChild1.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild1, 
						function (data){
							var flaskRequestChild2 = new Request();
							paramsChild2= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': infoTypeCategoryId};
							flaskRequestChild2.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild2, 
								function (data){
									folderId = data.folderId;
									var flaskRequestChild3 = new Request();
									paramsChild3= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': venueDetailId};
									flaskRequestChild3.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild3, 
										function (data){
											fnRenderSlider(data.folderId,_divObj);
										} ,
										function (data){console.log(5);});
								} ,
								function (data){console.log(4);});
						} ,
						function (data){console.log(3);});
				} ,
				function (data){console.log(2);});
		} ,
		function (data){console.log(1);});
}

function fnRenderSlider(folderId,_divObj){
	$(_divObj).html("");
	$(".venueLogo").removeClass("activeImage");
	var flaskRequest = new Request();
	params= {'repositoryId': $("#repositoryId").val(), 'folderId': folderId};
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FILES , params, 
		function (data){
			if(typeof data=="object"){
				var iSelected = false;
		    	for(var iCount=0;iCount<data.length;iCount++){
		    		var imgURL = '/documents/'+data[iCount].groupId+'/'+data[iCount].folderId+'/'+data[iCount].title;
				    var objdiv = $('<div/>',{'class':'venueLogo','style':'background-image:url('+imgURL+')','data-fileEntryId':data[iCount].fileEntryId});
				    $(objdiv).appendTo($(_divObj));
				    $(objdiv).click(function(){
				    	$(this).toggleClass("activeImage");
				    	if($(".activeImage").length>0){
				    		if(iSelected==false){
				    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
				    			$(objDel).appendTo($(_divObj));
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
		} ,
		function (data){
			console.log("Error in getting Folder: " + data );
		});	
}

function fnDeleteFileByEntryId(fileEntryId,objDel){
	params= {'fileEntryId': fileEntryId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.DELETE_FILES , params, 
		function (data){
			if(typeof data=="object"){
				
			}		
		},
		function (data){$("#spinningSquaresG").hide();});	
}
