var venueForm;
function addClickHandlers(){
	venueForm = $("#venueForm");
	/*	Initialize display elements*/
	
	$(".cssDelete").hide();	
	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
		venueForm.trigger('reset')
		$("#venueDataTable").hide();
		venueForm.show();
		_flaskLib.loadCountries('venueCountryId');
		_flaskLib.loadUSARegions('venueStateId');
	});

	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		saveVenue();
		saveVenueDetails();
	});


	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
		$("#venueDataTable").show();
		venueForm.hide();
	});
	
	$(".cssDelUser").click(function() {
		GRID_PARAM.toggleSelectionMode();
		var flag1=true;
		 if (flag1==true) {
			 $(".cssDelete").show();	
			 $(".cssDelUser").hide();	
		}
		else{
			 $(".cssDelete").hide();	
			 $(".cssDelUser").show();	
		}
    });
	
	$(".cssDelete").click(function () {
		var venueList = GRID_PARAM.getCheckedIdList();
		if(venueList.length > 0){
			deleteMultipleVenues(venueList) ;	
		}
		 $(".cssDelete").hide();	
		 $(".cssDelUser").show();	
		 GRID_PARAM.toggleSelectionMode();
    });

	/*	Toggle search boxes */
	$(".cssSearchUser").click(GRID_PARAM.toggleSearchBoxes);			
	
	$("#venueCountryId").change(function() {
		_flaskLib.loadRegions('venueStateId', $("#venueCountryId").val());
    });		
}


function loadData(){
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_VENUE, params, 
	function(data){/*success handler*/
		GRID_PARAM.updateGrid(data);
	} , function(error){ /*failure handler*/
		showErrorMessage(_venueModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}



function contextMenuHandler(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		editVenue(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteVenue(rowData.venueId);
		}
		return false;			
	}
};

function deleteVenue(venueId) {
	var param = {'venueId': venueId};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUE, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
							loadData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
					});
	
}

function deleteMultipleVenues(venueList) {
	var param = {'venueList': venueList};
	console.log(param);
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUES, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
							loadData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
					});
	
}

function editVenue(rowData) {
		_venueModel.loadContentType('InfoTypeCategoryId');
		$("#venueDetailsForm").show();		
		_flaskLib.loadDataToForm("venueForm",  _venueModel.DATA_MODEL.VENUE, rowData, function(){
	});
	$("#venueDataTable").hide();
	venueForm.show();
	_flaskLib.loadCountries('venueCountryId', rowData.venueCountryId);
	_flaskLib.loadUSARegions('venueStateId', rowData.venueStateId);
	
}


function saveVenue(){
	params = _flaskLib.getFormData('venueForm',_venueModel.DATA_MODEL.VENUE,
				function(formId, model, formData){
						formData.venueStateName = $('#venueStateId').children(':selected').text();
						formData.venueCountryName=$('#venueCountryId').children(':selected').text();;
						return formData;
				});
	var flaskRequest = new Request();
	var url = ""
		if(params.venueId == 0){
			url = _venueModel.SERVICE_ENDPOINTS.ADD_VENUE;
		}else{
			url =_venueModel.SERVICE_ENDPOINTS.UPDATE_VENUE
		}
	
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.SAVE);
					loadData();
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.ERROR);
				});

}

function saveVenueDetails(){
	params = _flaskLib.getFormData('venueDetailsForm',_venueModel.DATA_MODEL.VENUEDETAILS,
			function(formId, model, formData){
				$.each(model, function(i, item) {
					var ele = $('#'+ formId + ' #'+item.name);
					var val = $.trim(ele.val());
					if(item.type == 'long' && val ==''){
						val = Number(val)
					}
					formData[item.name] = val;		
				});
				return formData;
			});
	//console.log(params);
	var flaskRequest = new Request();
	var url = ""
		
		if(params.infoTypeId == 0){
			url = _venueModel.SERVICE_ENDPOINTS.ADD_VENUE_DETAILS;
		}else{
			url =_venueModel.SERVICE_ENDPOINTS.UPDATE_VENUE_DETAILS;
		}
		
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.SAVE);
					loadData();
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.ERROR);
				});

}

/* Dynamic content type generation logic [Start]*/
var formArea;
var JsonObj;
$(document).ready(function(){
    formArea = $("#contentTypeForm"); // Parent Div        
    JsonObj = [{                    // JSON Field List, Content Type Wise
            "general":[{
                    "type":"text",
                    "attr":[{ 
                        "caption":"Title",
                        "id":"infoTitle",
                        "value":"",
                        "placeholder":"Enter title here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Description",
                        "id":"infoDesc",
                        "value":"",
                        "placeholder":"Enter description here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"upload",
                    "attr":[{ 
                    	"caption":"Upload Pictures",
                        "action":$("#imgActionUrl").val(),
                        "id":"venueId",
                    	"value":$("#venueId").val(),
                        "Class":""
                        }]
                    }],
            "tradition":[{
                    "type":"text",
                    "attr":[{ 
                        "caption":"Name",
                        "id":"infoTitle",
                        "value":"",
                        "placeholder":"Enter title here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Description",
                        "id":"infoDesc",
                        "value":"",
                        "placeholder":"Enter description here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Comment",
                        "id":"Comment",
                        "value":"",
                        "placeholder":"Enter Comment here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    }],
            "parking":[{
                    "type":"text",
                    "attr":[{ 
                        "caption":"Name",
                        "id":"Title",
                        "value":"",
                        "placeholder":"Enter Name here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Address",
                        "id":"Description",
                        "value":"",
                        "placeholder":"Enter Address here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Cost",
                        "id":"Cost",
                        "value":"",
                        "placeholder":"Enter Cost here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"boolean",
                    "attr":[{ 
                        "id":"IsAvailable",
                        "name":"IsAvailable",
                        "caption":"Is Available?",
                        "value":"Yes",
                        "items":["Yes","No"]
                        }]
                    }]                            
            }];
                      
    $("#InfoTypeCategoryId").change(function(){
        $(formArea).html("");
        var selectedContentType = $("option:selected", this).text().toLowerCase();;
        fnRenderForm(selectedContentType);
    });
});

function fnRenderForm(contentType){
    var ObjJSON = fnSelectJSON(contentType)
    console.log(eval("JsonObj[0]."+contentType));
    fnBuildHtml(ObjJSON);
}

function fnSelectJSON(cType){
    switch(cType) {
        case "general":
            return JsonObj[0].general;
            break;
        case "tradition":
            return JsonObj[0].tradition;
            break;
        case "parking":
            return JsonObj[0].parking;
            break;
        default:
            console.log("Nothing selected");
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
        console.log(Obj[0].items[iCount].value);
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
	    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
	    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].caption}).appendTo(objFormGroup);
	    $(objControlLable).html(Obj[0].caption);
	    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
	    var objForm = $('<form/>',{'class':'dropzone','id':'venueImages','action':Obj[0].action}).appendTo(objFormGroup);
	    $(objForm).appendTo(objControls);
	    var objHiddenId = $('<input/>',{'id':Obj[0].id,'type':'hidden','value':'24490'}).appendTo($(formArea));
	    $(objHiddenId).appendTo(objForm);
	    var dropZone = new Dropzone($(objForm).get(0),{});	
	    dropZone.on("addedfile", function(file) {
	        //alert("Do you wish to add information about images?");
	    });	    
}
/* Dynamic content type generation logic [End]*/
