var imageContainer = $("#eventImage");
var tailgateForm;
var dropZoneLogo;
var tailgateId;
var events = [];
function addClickHandlers(){
	eventForm = $("#tailgateForm");
	$(".cssDelete").hide();	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
		
			$("#tailgateId").val(0);
			tailgateId = 0;
			eventForm.trigger('reset')
			$("#tailgateDataTable").hide();
			$("#formContainer").show();
			loadEvents('eventId');
			fnBuildEventUpload(imageContainer);		
			initializeMap(tailgateId);
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
			var eventList = GRID_PARAM.getCheckedIdList();
			if(eventList.length > 0){
					deleteMultipleEvents(eventList) ;	
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
		
}

function loadData(){
	var flaskRequest = new Request();
	params = {userId:_tailgateModel.userId};
	flaskRequest.sendGETRequest(_tailgateModel.SERVICE_ENDPOINTS.GET_ALL_MY_TAILGATE, params, 
	function(data){/*success handler*/
		var tailgates = eval(data);
		$.each(tailgates, function(index, tailgate) {
			if(tailgate.isAdmin == "1")
				tailgate["tailgateRole"] = "Admin";
			else
				tailgate["tailgateRole"] = "Member";
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
				initializeMap(tailgateId,lat, lng);
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
	console.log(rowData);
	_flaskLib.hideMessage('action-msg');
		var repositoryId = $("#repositoryId").val();
		_flaskLib.loadDataToForm("tailgateForm",  _tailgateModel.DATA_MODEL.TAILGATE, rowData, function(){});
		$("#tailgateDataTable").hide();
		eventForm.show();
		$("#formContainer").show();
		loadEventAndTime('eventId',  rowData.tailgateId);
		initializeMap(rowData.tailgateId);
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
						if(!isForUpdate){
							var userparams = {};
							userparams.tailgateId = data.tailgateId;
							userparams.userId = _tailgateModel.userId;
							userparams.userName = _tailgateModel.userName;
							userparams.isAdmin = 1;
							userparams.groupId = 0;
							addTailgateMember(userparams)
						}
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
		var userrparams = {};
		userrparams.groupId = 0;
		userrparams.userId = user.userId;
		userrparams.userName = user.firstName;
		userrparams.isAdmin = 0;
		userrparams.tailgateId = tailgateId;
		addTailgateMember(userrparams)
	}
}
function addTailgateMember(params) {
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_tailgateModel.SERVICE_ENDPOINTS.ADD_TAILGATE_USER,
			params, function(data) {/* success handler */
		_flaskLib.showSuccessMessage('group-action-msg',
				_tailgateModel.MESSAGES.ADD_USER);
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
  	dropZoneLogo = "";
    var objForm = $('<form/>',{'class':'dropzone','id':'eventLogoImage','action':$("#imgActionUrl").val()});
    $(objForm).appendTo(imageContainer);
    var objEventId = $('<input/>',{'name':'_tailgateIdId','id':'_tailgateIdId','type':'hidden','value':$("#tailgateId").val()});
    $(objEventId).appendTo(objForm);
    var objIsLogo = $('<input/>',{'name':'_isLogo','id':'_isLogo','type':'hidden','value':'Y'});
    $(objIsLogo).appendTo(objForm);
    
    dropZoneLogo = new Dropzone($(objForm).get(0),{
    	autoProcessQueue: false,
    	addRemoveLinks : true,
    	uploadMultiple : true
    });
}

function fnSaveEventLogo(eventId,IsNew){
	$("#_eventId").val(eventId);
	dropZoneLogo.options.autoProcessQueue = true;
	dropZoneLogo.processQueue();
//	dropZoneLogo.on("queuecomplete", function (file) {
//		if(IsNew){
//			var files = $("#imgActionUrl").val();
//			$('.nav-tabs > .active').next('li').find('a').trigger('click');
//			createDetailsTable({},_eventDetailModel.DATA_MODEL.EVENTDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventDetailModel.GRID_DATA_MODEL.EVENTDETAILS);
//			loadEventDetailsData(eventId);
//		}
//		else{
//			$("#eventImage").html(""); // Clear upload component
//			$("#eventDataTable").show();
//			$("#formContainer").hide();
//			loadData();
//		}		
//	});	
	dropZoneLogo.on('success',function(file,responsenew){
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
	$('#tailgateForm').jqxValidator
    ({
        hintType: 'label',
        animationDuration: 0,
        rules: [
	               { input: '#tailgateName', message: 'Tailgate name is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#tailgateDescription', message: 'Tailgate Description is required!', action: 'keyup, blur', rule: 'required' },
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
	fetchTailgateMemberDetail(rowData.tailgateId);
	prepareTailgateMemberGrid();
//	$("#tabs").hide();
	$("#tailgateDataTable").hide();
	$("#addTailgateMembersForm").show();
}
function prepareTailgateMemberGrid(){
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(
				_tailgateModel.SERVICE_ENDPOINTS.GET_ALL_USERS, {}, function(data) {
					var gridData = prepareMemberData(data, _tailgateModel.allMemberDetails);
					createTailgateUserTable(gridData, $("#tailgateMemberDataGrid"));
				}, function(error) {
					_flaskLib.showErrorMessage(_tailgateModel.MESSAGES.GET_ERROR);
				});
}

function showAddTailgateGroupForm(rowData) {
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
					userrparams.tailgateId = tailgateId;
					userrparams.userId = grpUser.userId;
					userrparams.userName = grpUser.userName;
					userrparams.isAdmin = 0;
					userrparams.groupId = grpUser.groupId;
					addTailgateGroup(userrparams)
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