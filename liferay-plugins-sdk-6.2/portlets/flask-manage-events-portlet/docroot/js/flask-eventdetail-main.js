var eventDetailForm;
var dropZone;
var JsonObj;

function addClickHandlers(){
	eventDetailForm = $("#eventForm");
	/*	Initialize display elements*/
	$(".cssVdSave").click(function(){
		saveVenueDetails();
	});	
	
	$(".cssAddVenueDetails").click(function(){
		$("#venueDetailId").val(0);
		_eventModel.loadContentType('infoTypeCategoryId',1);
		$("#venueDetailsForm").show();
		$("#venueDetailsDataTable").hide();
	});	

	$(".cssVdCancel").click(function(){
		$("#venueDetailsForm").hide();
		$("#venueDetailsDataTable").show();
		$("#slides").html("");
		$("#displayImages").hide();
	});	
}

function loadVenueDetailsData(venueId,infoTypeId){
	var flaskRequest = new Request();
	params = {'venueId':venueId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_VENUE_DETAILS, params, 
	function(data){/*success handler*/
		if(infoTypeId>0){
		    var returnedData = $.grep(data, function(element, index){
		    	return element.infoTypeId == infoTypeId;
		    });
		    data = returnedData;
		}
		GRID_PARAM.updateGrid(data);
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function contextMenuHandlerDetails(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		editVenueDetail(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteVenueDetail(rowData.venueDetailId,rowData.venueId);
		}
		return false;			
	}
};
//

$(".infoTypeCat").click(function(){
	var InfoTypeCd = Number($(this).attr('data-value'));
	createTable({},_eventModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventModel.GRID_DATA_MODEL.VENUEDETAILS);
	loadVenueDetailsData($('#eventForm #venueId').val(),InfoTypeCd);
	
	var click = new Date();
	var lastClick = new Date();
	var lastRow = -1;
	$("#gridDetails").bind('rowclick', function (event) {
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

function initForm(){
	$("#venueDetailsContainer").hide();
	$("#displayImages").hide(); 

}

/* Dynamic content type generation logic [Start]*/
function fnRenderContentType(InfoTypeID){
	$("#infoTypeId").val(InfoTypeID);
	$("#venueDetailsContainer").show();
	//createTable({},_eventModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventModel.GRID_DATA_MODEL.VENUEDETAILS);
	//$("#eventForm").hide();
	$("#formContainer").hide();
}

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
                      
    $("#infoTypeCategoryId").change(function(){
        $(formArea).html("");
        var selectedContentType = $("option:selected", this).text().toLowerCase();
        fnRenderForm(selectedContentType);
    });
});

function fnRenderForm(contentType){
    var ObjJSON = fnSelectJSON(contentType)
    fnBuildHtml(ObjJSON);
    
    if($("#venueDetailId").val()>0){
    	fnShowSlider();
    }
       
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
	    var objVenueDetailId = $('<input/>',{'name':'_venueDetailId','id':'_venueDetailId','type':'hidden','value':'0'});
	    $(objVenueDetailId).appendTo(objForm);
	    var objEventId = $('<input/>',{'name':'_eventId','id':'_eventId','type':'hidden','value':$("#eventId").val()});
	    $(objEventId).appendTo(objForm);
	    var objInfoTypeId = $('<input/>',{'name':'_infoTypeId','id':'_infoTypeId','type':'hidden','value':$("#infoTypeId").val()});
	    $(objInfoTypeId).appendTo(objForm);
	    var objInfoTypeCategoryId = $('<input/>',{'name':'_infoTypeCategoryId','id':'_infoTypeCategoryId','type':'hidden','value':$("#infoTypeCategoryId").val()});
	    $(objInfoTypeCategoryId).appendTo(objForm);
	    dropZone = new Dropzone($(objForm).get(0),{
	    	autoProcessQueue: false
	    });	
}
/* Dynamic content type generation logic [End]*/
function saveVenueDetails(){
	params = _flaskLib.getFormData('venueDetailsForm',_eventModel.DATA_MODEL.VENUEDETAILS,
			function(formId, model, formData){
				$.each(model, function(i, item) {
					var ele = $('#'+ formId + ' #'+item.name);
					var val = $.trim(ele.val());
					if(item.type == 'long' && val ==''){
						val = Number(val)
					}
					formData[item.name] = val;	
				});
				formData.venueId=$('#eventForm #venueId').val();
				formData.eventId=$('#eventForm #eventId').val();
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
		if(params.venueDetailId == 0){
			url = _eventModel.SERVICE_ENDPOINTS.ADD_VENUE_DETAILS;
		}else{
			url =_eventModel.SERVICE_ENDPOINTS.UPDATE_VENUE_DETAILS;
		}
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.V_SAVE);
					//createTable({},_eventModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventModel.GRID_DATA_MODEL.VENUEDETAILS);
					//need to change logic here for active
					//console.log(data);
					loadVenueDetailsData(data.venueId,data.infoTypeId);
					if($('#venueImages').is(':visible')) {					
						fnSaveImages(data.venueDetailId);
					}
					wait(function(){
						$('#venueDetailsForm').hide();
						$('#venueDetailsDataTable').show();
						$("#venueDetailId").val(0);
						$("#infoTypeCategoryId").val(0);
						$("#infoTypeCategoryId").change();
					},2)					
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.V_ERROR);
				});
	$("#slides").html("");
	$("#displayImages").hide();
}

/* Delete Single Event */
function deleteVenueDetail(venueDetailId,venueId) {
		var param = {'venueDetailId': venueDetailId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_VENUE_DETAIL , param, 
			function (data){
					_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
					createTable({},_eventModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventModel.GRID_DATA_MODEL.VENUEDETAILS);
					//Change
					loadVenueDetailsData(venueId,1);
			} ,
			function (data){
					_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
			});
}

/* Delete Multiple Events */
function deleteMultipleVenueDetail(eventList) {
	var param = {'eventIds': eventList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_ALL_VENUE_DETAILS, param, 
		function (data){
				_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
				//loadVenueDetailsData(venueId);
		} ,
		function (data){
				_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
		});
}

/* Edit Event */
function editVenueDetail(rowData) {
		var repositoryId = $("#repositoryId").val();
		$('#venueDetailsForm #venueId').val($('#eventForm #venueId').val());
		$('#venueDetailId').val(rowData.venueDetailId);
		$('#_venueDetailId').val(rowData.venueDetailId);
		$('#venueDetailsForm').show();
		$('#venueDetailsDataTable').hide();
		_eventModel.loadContentType('infoTypeCategoryId',rowData.infoTypeCategoryId);
		setTimeout(
				  function() 
				  {
					  _flaskLib.loadDataToForm("venueDetailsForm",  _eventModel.DATA_MODEL.VENUEDETAILS, rowData, function(){});
				  }, 500);		
		
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
}

var wait = function(callback, seconds) {
	return window.setTimeout(callback, seconds * 1000);
}



function fnShowSlider(){
	var repositoryId = $("#repositoryId").val();
	var eventId = $('#eventForm #eventId').val();
	var infoTypeId = $("#infoTypeId").val();
	var infoTypeCategoryId = $("#infoTypeCategoryId").val();
	var venueDetailId = $("#venueDetailId").val();
	
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': 0, 'name': 'Event'};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			folderName = 'Event-'+eventId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild, 
				function (data){
					//data.folderId;
					var flaskRequestChild1 = new Request();
					paramsChild1= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': infoTypeId};
					flaskRequestChild1.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild1, 
						function (data){
							var flaskRequestChild2 = new Request();
							paramsChild2= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': infoTypeCategoryId};
							flaskRequestChild2.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild2, 
								function (data){
									folderId = data.folderId;
									var flaskRequestChild3 = new Request();
									paramsChild3= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': venueDetailId};
									flaskRequestChild3.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild3, 
										function (data){
											fnRenderSlider(data.folderId);
										} ,
										function (data){
											console.log("Error in getting Folder 5: " + data );
										});
									
								} ,
								function (data){
									console.log("Error in getting Folder 4: " + data );
								});
						} ,
						function (data){
							console.log("Error in getting Folder 3: " + data );
						});
				} ,
				function (data){
					console.log("Error in getting Folder 2: " + data );
			});
		} ,
		function (data){
			console.log("Error in getting Folder 1: " + data );
	});
}

function fnRenderSlider(folderId){
	var flaskRequest = new Request();
	params= {'repositoryId': $("#repositoryId").val(), 'folderId': folderId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FILES , params, 
		function (data){
			//data.folderId;
			if(typeof data=="object"){
		    	for(var iCount=0;iCount<data.length;iCount++){
		    		var imgURL = '/documents/'+data[iCount].groupId+'/'+data[iCount].folderId+'/'+data[iCount].title;
				    var objdiv = $('<div/>',{'class':'form-group'}).appendTo($("#slides"));
				    var objimg = $('<img/>',{'u':'image','src':imgURL}).appendTo(objdiv);
				    $("#displayImages").show();
		    	}
		    	//$("#slides")
		    	var options = {
		              $AutoPlay: false,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
		              $AutoPlaySteps: 4,                                  //[Optional] Steps to go for each navigation request (this options applys only when slideshow disabled), the default value is 1
		              $AutoPlayInterval: 4000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
		              $PauseOnHover: 1,                               //[Optional] Whether to pause when mouse over if a slider is auto playing, 0 no pause, 1 pause for desktop, 2 pause for touch device, 3 pause for desktop and touch device, 4 freeze for desktop, 8 freeze for touch device, 12 freeze for desktop and touch device, default value is 1
		              $ArrowKeyNavigation: true,   			            //[Optional] Allows keyboard (arrow key) navigation or not, default value is false
		              $SlideDuration: 160,                                //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
		              $MinDragOffsetToSlide: 20,                          //[Optional] Minimum drag offset to trigger slide , default value is 20
		              $SlideWidth: 200,                                   //[Optional] Width of every slide in pixels, default value is width of 'slides' container
		              //$SlideHeight: 150,                                //[Optional] Height of every slide in pixels, default value is height of 'slides' container
		              $SlideSpacing: 3, 					                //[Optional] Space between each slide in pixels, default value is 0
		              $DisplayPieces: 4,                                  //[Optional] Number of pieces to display (the slideshow would be disabled if the value is set to greater than 1), the default value is 1
		              $ParkingPosition: 0,                              //[Optional] The offset position to park slide (this options applys only when slideshow disabled), default value is 0.
		              $UISearchMode: 1,                                   //[Optional] The way (0 parellel, 1 recursive, default value is 1) to search UI components (slides container, loading screen, navigator container, arrow navigator container, thumbnail navigator container etc).
		              $PlayOrientation: 1,                                //[Optional] Orientation to play slide (for auto play, navigation), 1 horizental, 2 vertical, 5 horizental reverse, 6 vertical reverse, default value is 1
		              $DragOrientation: 1,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)
	
		              $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
		                  $Class: $JssorBulletNavigator$,                       //[Required] Class to create navigator instance
		                  $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
		                  $AutoCenter: 0,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
		                  $Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
		                  $Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
		                  $SpacingX: 0,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
		                  $SpacingY: 0,                                   //[Optional] Vertical space between each item in pixel, default value is 0
		                  $Orientation: 1                                 //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
		              },
	
		              $ArrowNavigatorOptions: {
		                  $Class: $JssorArrowNavigator$,              //[Requried] Class to create arrow navigator instance
		                  $ChanceToShow: 1,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
		                  $AutoCenter: 2,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
		                  $Steps: 4                                       //[Optional] Steps to go for each navigation request, default value is 1
		              }
		          };
	
		          var jssor_slider1 = new $JssorSlider$("slider1_container", options);
	
		          //responsive code begin
		          //you can remove responsive code if you don't want the slider scales while window resizes
		          function ScaleSlider() {
		              var bodyWidth = document.body.clientWidth;
		              if (bodyWidth)
		                  jssor_slider1.$ScaleWidth(Math.min(bodyWidth, 809));
		              else
		                  window.setTimeout(ScaleSlider, 30);
		          }
		          ScaleSlider();
	
		          $(window).bind("load", ScaleSlider);
		          $(window).bind("resize", ScaleSlider);
		          $(window).bind("orientationchange", ScaleSlider);   		    	
		    }		
		} ,
		function (data){
			console.log("Error in getting Folder: " + data );
		});	
			 
}