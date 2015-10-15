var imageContainer = $("#eventImage");
var tailgateForm;
var dropZone;
var tailgateId;
var events = [];
var iSelected = false;
function addClickHandlers(){
	
	$(window).hashchange( function(){
		var hash = location.hash;
		switch(hash) {
	    case "#UserTailgate":
	    	$("#tailgateDataTable").show();
			$("#formContainer").hide();
			eventForm.hide();
			$("#addTailgateMembersForm").hide();
			$("#addTailgateGroupForm").hide();
			break;
	    case "#ManageTailgate":
	    	$("#mtailgate").click();
	        break;
	    case "#ManageTailgateContent":
	    	$("#mcontents").click();
	        break;	   
	    case "#ManageTailgateUser":
	    	$("#musers").click();
	        break;
	    case "#AddTailgateGroups":
		    	fetchTailgateGroupDetail(rowData.tailgateId);
		    	prepareTailgateGroupGrid();
		    	$("#tailgateDataTable").hide();
		    	$("#addTailgateGroupForm").show();
	        break;
	    case "#AddTailgateMembers":
	    	fetchTailgateMemberDetail(rowData.tailgateId);
	    	prepareTailgateMemberGrid();
	    	$("#tailgateDataTable").hide();
	    	$("#addTailgateMembersForm").show();
	    	$("#tailgateMemberDataGrid").show();
        break;
	    default:
	    	//alert("This is default");
		}		
	});
	
	$("#mtailgate").click(function(){
		window.location.hash = '#ManageTailgate';
	});
	$("#mcontents").click(function(){
		window.location.hash = '#ManageTailgateContent';
	});
	$("#musers").click(function(){
		window.location.hash = '#ManageTailgateUser';
	});
	eventForm = $("#tailgateForm");
	$(".cssDelete").hide();	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
		window.location.hash = '#ManageTailgate';
			$("#tailgateId").val(0);
			tailgateId = 0;
			eventForm.trigger('reset')
			$("#tailgateDataTable").hide();
			$("#formContainer").show();
			loadEvents('eventId');
			initializeMap(tailgateId,0,0);
			if(parseInt($("#tailgateId").val())==0){
				$("#mcontents").attr("data-toggle","");
				$("#mcontents").css("cursor","not-allowed");
			}
	});
	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		if($('#tailgateForm').jqxValidator('validate'))
			saveTailgate();
	});
	
	$("#eventId").change(function(){
		var eventId = $( "select#eventId option:selected").val();
		getSelectedtailgateDate(events, eventId,'tailgateDate');
	});
	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
		window.location.hash = '#UserTailgate';
		$("#tailgateDataTable").show();
		$("#formContainer").hide();
	});
	$(".clsCancelGroup").click(function(){
		$("#tailgateGroupDataGrid").jqxGrid('clearselection');
		$("#tailgateMemberDataGrid").jqxGrid('clearselection');
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
			var tailgateList = GRID_PARAM.getCheckedIdList();
			if(tailgateList.length > 0){
					deleteMultipleTailgates(tailgateList) ;	
			}
			 $(".cssDelete").hide();	
			 $(".cssDelUser").show();	
			 GRID_PARAM.toggleSelectionMode();
	    });
	
		/*	Toggle search boxes */
		$(".cssSearchUser").click(GRID_PARAM.toggleSearchBoxes);
		$(".clsAddTailgateMembers").click(
				function() {
					addTailgateMembers();
					$("#tailgateDataTable").show();
					$("#addTailgateMembersForm").hide();
				});
		$(".clsAddTailgateGroup").click(
				function() {
					addTailgateGroups();
					$("#tailgateDataTable").show();
					$("#addTailgateGroupForm").hide();
				});
		$(".clsBack").click(function() {
			$("#tailgateDataTable").show();
			eventForm.hide();
			$("#addTailgateMembersForm").hide();
			$("#addTailgateGroupForm").hide();
		});
		/* Toggle search boxes */
		$("#cssSearchTailgate").click(GRID_PARAM.toggleSearchBoxes);
		$("#cssSearchGroup").click(GRID_PARAM.toggleGroupSearchBoxes);
		$("#cssSearchUser").click(GRID_PARAM.toggleUserSearchBoxes);
		
		$("#mcontents").click(function(){
			var _tailgateId = parseInt($("#tailgateId").val());
			if(parseInt(_tailgateId)!=0){
				fnBuildEventUpload(imageContainer);			
				var container = $('#uploadedImages');
				container.html("");
				fnGetEventDetailImages(_tailgateId,container, true);
				$("#Upload").click(function(){
					fnSaveImages(_tailgateId);
				});
			}
		});
		$("#musers").click(function(){
			$("#tailgateMembersDataGridShow").show();
		});
}


function deleteMultipleTailgates(tailgateList){
	var strTailgateIdArray = tailgateList.split(",");
	for(var iCount=0;iCount<strTailgateIdArray.length;iCount++){
		var _tailgateId = parseInt(strTailgateIdArray[iCount]);
		deleteTailgate(_tailgateId);
	}
}

function loadData(){
	var flaskRequest = new Request();
	url = _tailgateModel.SERVICE_ENDPOINTS.GET_ALL_MY_TAILGATE;
	params = {userId:_tailgateModel.userId};
	flaskRequest.sendGETRequest(url, params, 
	function(data){/*success handler*/
		var tailgates = eval(data);
		$.each(tailgates, function(index, tailgate) {
			tailgate.tailgateDate = _flaskLib.formatDateInMillis(tailgate.tailgateDate);
			tailgate.startTime = _flaskLib.formatTimeInMillis(tailgate.startTime);
			tailgate.endTime  = _flaskLib.formatTimeInMillis(tailgate.endTime);

		});
		GRID_PARAM.updateGrid(tailgates);
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_tailgateModel.MESSAGES.GET_ERROR);
	});
}

var loadEvents = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	selectList.removeAttr("disabled");
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_tailgateModel.SERVICE_ENDPOINTS.GET_ALL_EVENTS , {}, 
		function (data){
			events = data.Events;
				selectList.empty();
				selectList.append('<option value="select">Select</option>');
				$.each(data.Events, function(key, event) {
					selectList.append('<option value='+event.eventId+'>'+event.eventName+'</option>');
				});
				selectList.val(selectedId);
		} ,
		function (data){
		});
};

var getSelectedtailgateDate = function(contentToIterate,eventId,element){
	if(eventId == "select"){
		$("#" + element).val("");
		return;
	}
	$.each(contentToIterate,function(key,event){
		if((event.eventId+"") == eventId){
			var flaskRequest = new Request();
			flaskRequest.sendGETRequest(_tailgateModel.SERVICE_ENDPOINTS.GET_VENUE , {venueId:event.venueId}, 
				function (venue){
				var lat = venue.latitude;
				var lng = venue.longitude;
				initializeMap(0,lat, lng);
			},function(error){
					
				});
			var date = new Date(event.eventDate);
			var formatDate = date.getMonth()+1+"-"+date.getDate()+"-"+date.getFullYear();
			$("#" + element).val(formatDate);
			
			var sTime = new Date(parseInt(event.startTime));
			$('#startTime').val(formatUnixToTime(sTime));
			var eTime = new Date(parseInt(event.endTime));
			$('#endTime').val(formatUnixToTime(eTime));
			$("#eventName").val(event.eventName);
			return false;
		}
	});
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
var loadTailgateDateAndTime = function(tailgate,element){
			var date = new Date(tailgate.tailgateDate);
			var formatDate = date.getMonth()+1+"-"+date.getDate()+"-"+date.getFullYear();
			$("#" + element).val(formatDate);
			var sTime = new Date(parseInt(tailgate.startTime));
			$('#startTime').val(formatUnixToTime(sTime));
			var eTime = new Date(parseInt(tailgate.endTime));
			$('#endTime').val(formatUnixToTime(eTime));
			$("#eventName").val(tailgate.eventName);
			$("#tailgateId").val(tailgate.tailgateId);
};

function contextMenuHandler(menuItemText, rowData){
	tailgateId = rowData.tailgateId;
	var args = event.args;
	if (menuItemText  == "Edit") {
		editTailgate(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteTailgate(rowData.tailgateId);
		}
		return false;			
	}else if(menuItemText == "Invite Group"){
		showAddTailgateGroupForm(rowData);
		return false;
	}else if(menuItemText == "Invite Friend"){
		showAddTailgateMembersForm(rowData);
		return false;
	}else if(menuItemText == "Leave Tailgate"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteTailgate(rowData.tailgateId);
		}
		return false;
	}
};

/* Delete Single Tailgate */
function deleteTailgate(tailgateId) {
		var param = {'tailgateId': tailgateId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_tailgateModel.SERVICE_ENDPOINTS.DELETE_TAILGATE , param, 
						function (data){
								_flaskLib.showSuccessMessage('action-msg', _tailgateModel.MESSAGES.DEL_SUCCESS);
								loadData();
						} ,
						function (data){
								_flaskLib.showErrorMessage('action-msg', _tailgateModel.MESSAGES.DEL_ERR);
						});
	
}

/* Delete Multiple Events */
function deleteMultipleTailgatess(tailgateList) {
	var param = {'eventIds': eventList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_tailgateModel.SERVICE_ENDPOINTS.DELETE_TAILGATES, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', _tailgateModel.MESSAGES.DEL_SUCCESS);
							loadData();
							$('#grid').jqxGrid('clearselection');
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _tailgateModel.MESSAGES.DEL_ERR);
					});	
}

/* Edit Event */
function editTailgate(rowData) {
	window.location.hash = '#ManageTailgate';
	_flaskLib.hideMessage('action-msg');
		var repositoryId = $("#repositoryId").val();
		_flaskLib.loadDataToForm("tailgateForm",  _tailgateModel.DATA_MODEL.TAILGATE, rowData, function(){});
		$("#tailgateDataTable").hide();
		prepareTailgateMembersGridShow(rowData.tailgateId);
		eventForm.show();
		$("#formContainer").show();
		GRID_PARAM.locationMapId = "google_map";
		loadEventAndTime('eventId',  rowData.tailgateId);
		initializeMap(rowData,0,0);
}
function loadEventAndTime(elementId,tailgateId){
	var request = new Request();
	var selectList = $('#' + elementId);
	selectList.attr("disabled","disabled");
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_tailgateModel.SERVICE_ENDPOINTS.GET_TAILGATE , {tailgateId : tailgateId}, 
		function (data){
				selectList.empty();
					selectList.append('<option value='+data.eventId+'>'+data.eventName+'</option>');
				loadTailgateDateAndTime(data, 'tailgateDate');
		} ,
		function (data){
		});
}


/* Save Event */
function saveTailgate(){
	var st=$("#startTime").val();
    var et=$("#endTime").val();
    var d= $("#tailgateDate").val();
    var sTime=Date.parse(d+" "+st);
    var eTime=Date.parse(d+" "+et);
		var isForUpdate = false;
		var tailgateDate=$("#tailgateDate").val();
		tailgateDate = new Date(tailgateDate);
		params = _flaskLib.getFormData('tailgateForm',_tailgateModel.DATA_MODEL.TAILGATE,
					function(formId, model, formData){
							formData.startTime= sTime;
							formData.endTime= eTime;		
		                    formData.tailgateDate = sTime;
							return formData;
					});
		var flaskRequest = new Request();
		var url = "";
		console.log(params);
			if(params.tailgateId == 0){
				url =_tailgateModel.SERVICE_ENDPOINTS.ADD_TAILGATE;
			}else{
				isForUpdate = true;
				url = _tailgateModel.SERVICE_ENDPOINTS.UPDATE_TAILGATE;
			}
		flaskRequest.sendGETRequest(url, params, 
					function (data){
						$("#tailgateDataTable").show();
						$("#formContainer").hide();
						saveTailgateMarker(data.tailgateId);
						_flaskLib.showSuccessMessage('action-msg', _tailgateModel.MESSAGES.SAVE);
						loadData();
					} ,
					function (data){
						_flaskLib.showErrorMessage('action-msg', _tailgateModel.MESSAGES.ERROR);
					});
}
function addTailgateMembers(){
	var selectedUserList = GRID_PARAM.getCheckedUsersList();
	for ( var i = 0 ; i < selectedUserList.length; i ++) {
		var user = selectedUserList[i];
		var userparams = {};
		userparams.groupId = 0;
		userparams.userId = user.userId;
		userparams.userName = user.firstName+" "+user.lastName;
		userparams.emailAddress = user.emailAddress;
		userparams.isAdmin = 0;
		userparams.tailgateId = tailgateId;
		userparams.isPaid = 0;
		userparams.paymentMode = "None"; 
		addTailgateMember(userparams);
	}
}
function addTailgateMember(params) {
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_tailgateModel.SERVICE_ENDPOINTS.ADD_TAILGATE_USER,
			params, function(data) {/* success handler */
				_flaskLib.showSuccessMessage('group-action-msg',_tailgateModel.MESSAGES.ADD_USER);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
			});
}

function leaveTailgateUser(tailgateId, userId) {
	var params = {
		tailgateId : tailgateId,
		userId : userId
	};
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(
			_tailgateModel.SERVICE_ENDPOINTS.DELETE_TAILGATE_USER, params, function(
					data) {
				_flaskLib.showSuccessMessage('group-action-msg',
						_tailgateModel.MESSAGES.DEL_SUCCESS_USER);
			}, function(error) {
				_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
			});
}

function initForm(){
		var repositoryId = $("#repositoryId").val();
		//$("#startTime").jqxDateTimeInput({ width: '100px', height: '23px', formatString: 'hh:mm tt', showTimeButton: true, showCalendarButton: false});
		//$("#endTime").jqxDateTimeInput({ width: '250px', height: '25px', formatString: 'hh:mm tt', showTimeButton: true, showCalendarButton: false});
}

function fnBuildEventUpload(imageContainer){
	$(imageContainer).html(""); 
  	var strSelected = "";
  	dropZone = "";
    var objForm = $('<form/>',{'class':'dropzone','id':'tailgateImage','action':$("#imgActionUrl").val()});
    $(objForm).appendTo(imageContainer);
    var objTailgateId = $('<input/>',{'name':'_tailgateId','id':'_tailgateId','type':'hidden','value':$("#tailgateId").val()});
    $(objTailgateId).appendTo(objForm);
    //var objIsLogo = $('<input/>',{'name':'_isLogo','id':'_isLogo','type':'hidden','value':'Y'});
    //$(objIsLogo).appendTo(objForm);
    
    dropZone = new Dropzone($(objForm).get(0),{
    	autoProcessQueue: false,
    	addRemoveLinks : true,
    	uploadMultiple : true
    });	
}

function fnDeleteFileByTitle(_repositoryId,_folderId,_title,_objDel){
	params= {repositoryId:_repositoryId ,folderId: _folderId,title:_title};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_FILE_BY_TITLE , params, 
		function (data){
			if(typeof data=="object"){
				
			}		
		},
		function (data){
			
		});	
}

$(document).ready(function(){
	window.location.hash = '#UserTailgate';
	$('#tailgateForm').jqxValidator
    ({
        hintType: 'label',
        animationDuration: 0,
        rules: [
	               { input: '#tailgateName', message: 'Tailgate name is required!', action: 'keyup, blur', rule: 'required' },
	               {
		                input: '#endTime', message: 'End time always greater than start time!', action: 'keyup, focus', rule: function (input, commit) {
		                	var st=$("#startTime").val();
		                	var et=$("#endTime").val();
		                	var d= $("#tailgateDate").val();
		                	var sTime=Date.parse(d+" "+st);
		                	var eTime=Date.parse(d+" "+et);
		                    if (sTime<eTime) {return true;}
		                    else{return true;}
		                }
		            },
		            {
		            	input:'#eventId', message:'Please select event',action:'keyup, focus', rule:function(input,commit){
		            	 var selectedEvent = $( "select#eventId option:selected").val();
		            	 if(selectedEvent === "select"){
		            		 return false;
		            	 }else{
		            		 return true;
		            	 }
		            	}
		            }
               ]
    });
	
	$('.md-closeBtn').click(function(){
		$('#modal-advertisement').removeClass('md-show');
	});	
});

// Tailgate Add Member/Group methods start here
function fetchTailgateMemberDetail(tailgateId) {
	var flaskRequest = new Request();
	params = {
		tailgateId : tailgateId
	};
	flaskRequest.sendGETRequest(
			_tailgateModel.SERVICE_ENDPOINTS.GET_TAILGATE_MEMBERS, params,
			function(data) {/* success handler */
				_tailgateModel.allMemberDetails = data;
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
			});
}

function fetchTailgateGroupDetail(tailgateId) {
	var flaskRequest = new Request();
	params = {
			tailgateId : tailgateId
	};
	flaskRequest.sendGETRequest(
			_tailgateModel.SERVICE_ENDPOINTS.GET_TAILGATE_MEMBERS, params,
			function(data) {/* success handler */
				_tailgateModel.allGroupDetails = data;
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
			});
}
function showAddTailgateMembersForm(rowData) {
	window.location.hash = '#AddTailgateMembers';
	fetchTailgateMemberDetail(rowData.tailgateId);
	prepareTailgateMemberGrid();
//	$("#tabs").hide();
	$("#tailgateDataTable").hide();
	$("#addTailgateMembersForm").show();
	$("#tailgateMemberDataGrid").show();
}

function prepareTailgateMemberGrid(){
		var flaskRequest = new Request();
		var _companyId = Liferay.ThemeDisplay.getCompanyId();
		var params = {companyId:_companyId,keywords:''};
		flaskRequest.sendGETRequest(
				_tailgateModel.SERVICE_ENDPOINTS.GET_ALL_USERS, params, function(data) {
					var gridData = prepareMemberData(data, _tailgateModel.allMemberDetails);
					createTailgateUserTable(gridData, $("#tailgateMemberDataGrid"));
				}, function(error) {
					_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
				});
}

function prepareTailgateMembersGridShow(tailgateId){
	var flaskRequest = new Request();
	var params = {tailgateId:tailgateId};
	flaskRequest.sendGETRequest(
			_tailgateModel.SERVICE_ENDPOINTS.GET_TAILGATE_MEMBERS, params, function(data) {
				var gridData = prepareMemberData(data, _tailgateModel.allMemberDetails);
				createTailgateMemberTable(gridData, $("#tailgateMembersDataGridShow"));
			}, function(error) {
				_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
			});
}

function showAddTailgateGroupForm(rowData) {
	window.location.hash = '#AddTailgateGroups';
	fetchTailgateGroupDetail(rowData.tailgateId);
	prepareTailgateGroupGrid();
	$("#tailgateDataTable").hide();
	$("#addTailgateGroupForm").show();
}
function prepareTailgateGroupGrid(){
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(
				_tailgateModel.SERVICE_ENDPOINTS.GET_ALL_GROUPS, {}, function(data) {
					var gridData = prepareGroupData(data, _tailgateModel.allGroupDetails);
					createTailgateGroupTable(gridData, $("#tailgateGroupDataGrid"));
				}, function(error) {
					_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
				});
}

function prepareGroupData(groupList, tailgateGroupList, forGroupOwner){
	var tempGroupList = [];
	var temptailgateGroupList = [];
	for(var i = 0;i<tailgateGroupList.length;i++){
		var tailgateGrp = tailgateGroupList[i];
		tempGroupList.push(tailgateGrp.groupId);
	}
	for(var j = 0; j < groupList.length; j++){
		var grp = groupList[j];
		var indexOf = tempGroupList.indexOf(grp.groupId);
		if(indexOf < 0)
			temptailgateGroupList.push(grp);
	}
	return temptailgateGroupList;
}
function prepareMemberData(memberList, tailgateUserList){
	var tempTailgateUserList = [];
	var tempUserList = [];
	for(var i = 0;i<tailgateUserList.length;i++){
		var tailgateUser = tailgateUserList[i];
		tempTailgateUserList.push(tailgateUser.userId);
	}
	for(var j = 0; j < memberList.length; j++){
		var usr = memberList[j];
		var indexOf = tempTailgateUserList.indexOf(usr.userId);
		if(indexOf < 0)
			tempUserList.push(usr);
	}
	return tempUserList;
}
function addTailgateGroups(){
	var flaskRequest = new Request();
	var selectedGroupList = GRID_PARAM.getCheckedGroupList();
	for ( var i = 0 ; i < selectedGroupList.length; i ++) {
		var group = selectedGroupList[i];
		var params = {groupId:group.groupId};
		flaskRequest.sendPOSTRequest(_tailgateModel.SERVICE_ENDPOINTS.GET_ALL_GROUP_USER,
				params, function(data) {/* success handler */
			$.each(data, function(index, grpUser) {
					var userrparams = {};
					userrparams.groupId = grpUser.groupId;
					userrparams.userId = grpUser.userId;
					userrparams.userName = grpUser.userName;
					userrparams.emailAddress = grpUser.emailAddress;
					userrparams.isAdmin = grpUser.isAdmin;
					userrparams.tailgateId = tailgateId;
					userrparams.isPaid = 0;
					userrparams.paymentMode = "None"; 
					addTailgateMember(userrparams);
			});
		}, function(error){
			_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
		});
	}
}
function addTailgateGroup(params){
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_tailgateModel.SERVICE_ENDPOINTS.ADD_TAILGATE_USER,
			params, function(data) {/* success handler */
		_flaskLib.showSuccessMessage('group-action-msg',
				_tailgateModel.MESSAGES.ADD_GRP_USER);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
			});
}

function fnSaveImages(tailgateId){
	$("#_tailgateId").val(tailgateId);
	dropZone.options.autoProcessQueue = true;
	dropZone.processQueue();
	dropZone.on("queuecomplete", function (file) {
    	wait(function(){
    		_flaskLib.showSuccessMessage('action-msg', _tailgateModel.MESSAGES.IMAGE_UPLOAD_SUCCESS);
    	},1)					
    });
}


function fnGetEventDetailImages(tailgateId,container, editable){
	params= {'tailgateId': tailgateId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_tailgateModel.SERVICE_ENDPOINTS.GET_ALL_TAILGATE_IMAGES , params, 
		function (data){
			$.each(data, function(idx, obj) {
				fnRenderImage(obj.imageUUID, obj.imageGroupId, container, obj.tailgateImageId, editable,obj.imageTitle,obj.imageDesc);
			});			
		},
		function (data){
			console.log(data);
		});	
}

function fnRenderImage(imageUUID, imageGroupId, container, tailgateImageId, editable,imageTitle,imageDescription){
	var imgURL ="/c/document_library/get_file?uuid="+imageUUID+"&groupId="+imageGroupId;
	if(editable){
		var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-uuid':imageUUID, 'data-tailgateImageId': tailgateImageId,'data-imageURL':imgURL});
		objdiv.appendTo(container);
		var objdivDropDown = $('<div/>',{'class':'dropdown'});
		var objAnchor = $('<a/>',{'class':'dropdown-toggle editIcon','data-toggle':'dropdown','href':'#'});
		objAnchor.html('<i class="icon-pencil"></i>');
		var objUL = $('<ul/>',{'class':'dropdown-menu imageMenu','role':'menu','aria-labelledby':'dLabel'});
		var objLI1 = $('<li/>',{'data-uuid':imageUUID, 'data-tailgateImageId': tailgateImageId,'data-imageURL':imgURL,'data-title':imageTitle,'data-description':imageDescription});
		var objLI2 = $('<li/>',{'data-tailgateImageId': tailgateImageId});
		objLI1.html('<a href="#" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i> Edit</a>');
		$(objLI1).click(function(){
			fnFillImageModal(this);
		});
		objLI2.html('<a href="#"><i class="icon-trash"></i> Remove</a>');
		$(objLI2).click(function(){
			fnDeleteImage(this);
		});
		
		objdivDropDown.appendTo(objdiv);
		objAnchor.appendTo(objdivDropDown);
		objUL.appendTo(objdivDropDown);
		objLI1.appendTo(objUL);
		objLI2.appendTo(objUL);	
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
	    					fnDeleteImage(this);
	    					$("#spinningSquaresG").hide();
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
	else{
		var objdiv = $('<div/>',{'class':'GridSlides','style':'background-image:url('+imgURL+')','data-uuid':imageUUID, 'data-venueDetailImageId': tailgateImageId,'data-imageURL':imgURL});
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

function fnFillImageModal(obj){
	$(".tailgateImageDetail").html("");
	var _obj = $(obj);
	var imgURL = _obj.attr("data-imageURL");
	var title = _obj.attr("data-title");
	var description = _obj.attr("data-description");
	var objImage = $('<div/>',{'class':'eventLogo eventImageLarge','style':'background-image:url('+imgURL+')'});
	objImage.appendTo($(".tailgateImageDetail"));
	var tailgateImageId = _obj.attr("data-tailgateImageId");
	$("#imageTitle").val(title);
	$("#imageDescription").val(description);
	$("#btnSaveImageDetails").click(function(){
		params= {'tailgateImageId': tailgateImageId,imageTitle:$("#imageTitle").val(),imageDesc:$("#imageDescription").val()};
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(_tailgateModel.SERVICE_ENDPOINTS.UPDATE_IMAGES_DETAIL , params, 
			function (data){
				_obj.attr("data-title",$("#imageTitle").val());
				_obj.attr("data-description",$("#imageDescription").val());
				$('#myModal').modal('hide');
			},
			function (data){
				console.log(data);
			});			
	});
}

function fnDeleteImage(obj){
	var _obj = $(obj);
	var _tailgateImageId = _obj.attr("data-tailgateImageId"); 
	params= {'tailgateImageId': _tailgateImageId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_tailgateModel.SERVICE_ENDPOINTS.DELETE_TAILGATE_IMAGE , params, 
		function (data){
			var $div = _obj.closest('div[class^="eventLogo"]');
			$div.hide('slow', function(){ $div.remove(); });
		},
		function (data){
			console.log(data);
		});		
}

function fnPayNow(tailgateId, tailgateName, tailgateAccount, amountToPay){
	var paymentUrl ="https://venmo.com/?txn=pay&amount=" + amountToPay + "&note= for tailgate " + tailgateName + 
	"&recipients=" + tailgateAccount ;
	window.open(paymentUrl,'_blank');
}	  
