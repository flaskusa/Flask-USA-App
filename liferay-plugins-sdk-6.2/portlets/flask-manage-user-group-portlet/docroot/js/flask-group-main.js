var myGroupForm;
var groupId = "0";
var loggedInUserId = "0";
function groupClickHandlers() {
	myGroupForm = $("#myGroupForm");
	/* Initialize display elements */

	$(".cssDelete").hide();

	/* Click handler for add user button */

	$(".cssAddUser").click(function() {
		myGroupForm.trigger('reset')
//		$("#tabs").hide();
		$("#myGroupDataTable").hide();
		myGroupForm.show();
		groupId = "0";
	});

	/* Click handler for save button */

	$(".clsSaveGroup").click(
			function() {
				if (_flaskLib.validateFormData("myGroupForm",'myGroup-valid-msg', _groupModel.DATA_MODEL.GROUP)) {
					saveGroup();
//					$("#tabs").show();
					$("#myGroupDataTable").show();
					myGroupForm.hide();
				}
			});
	
	$(".clsAddUserGroup").click(
			function() {
				addGroupUsers();
//				$("#tabs").show();
				$("#myGroupDataTable").show();
				$("#addGroupUserForm").hide();
			});
	$(".clsAddOwnerGroup").click(
			function() {
				addGroupOwners();
//				$("#tabs").show();
				$("#myGroupDataTable").show();
				$("#addGroupOwnerForm").hide();
			});

	/* Click handler for cancel button */

	$(".clsGroupMembers").click(function() {
//		$("#tabs").show();
		$("#myGroupDataTable").show();
		myGroupForm.hide();
	});
	$(".clsBack").click(function() {
//		$("#tabs").show();
		$("#myGroupDataTable").show();
		myGroupForm.hide();
		$("#addGroupUserForm").hide();
		$("#addGroupOwnerForm").hide();
	});
	
	$(".clsCancelGroup").click(function() {
//		$("#tabs").show();
		$("#myGroupDataTable").show();
		myGroupForm.hide();
		$("#addGroupUserForm").hide();
		$("#addGroupOwnerForm").hide();
	});	

	$(".cssDelUser").click(function() {
		GRID_PARAM_GROUP.toggleSelectionMode();
		var flag1 = true;
		if (flag1 == true) {
			$(".cssDelete").show();
			$(".cssDelUser").hide();
		} else {
			$(".cssDelete").hide();
			$(".cssDelUser").show();
		}
	});

	$(".cssDelete").click(function() {
		var groupList = GRID_PARAM_GROUP.getCheckedIdList('groupId');
		if (groupList.length > 0) {
			deleteMultipleGroups(groupList);
		}
		$(".cssDelete").hide();
		$(".cssDelUser").show();
		GRID_PARAM_GROUP.toggleSelectionMode();
	});

	/* Toggle search boxes */
	$("#cssSearchGroup").click(GRID_PARAM_GROUP.toggleSearchBoxes);
	$("#cssSearchUser").click(GRID_PARAM_GROUP.toggleUserSearchBoxes);
	$("#cssSearchOwner").click(GRID_PARAM_GROUP.toggleUserSearchBoxes);
}
function loadGroupData(logginUserId) {
	loggedInUserId = logginUserId;
	var flaskRequest = new Request();
	params = {
		userId : logginUserId
	};
	flaskRequest.sendGETRequest(
			_groupModel.SERVICE_ENDPOINTS.GET_ALL_MY_GROUPS, params, function(
					data) {/* success handler */
				$.each(data, function(index, grpDetail) {
					if(grpDetail.isAdmin == "1")
						grpDetail["isGroupAdmin"] = "Admin";
					else
						grpDetail["isGroupAdmin"] = "Member";
				});
				GRID_PARAM_GROUP.updateGrid(data);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in getting data: " + error);
			});
}
function loadParticipantsGroupData(logginUserId) {
	loggedInUserId = logginUserId;
	var flaskRequest = new Request();
	params = {
		userId : logginUserId
	};
	flaskRequest.sendGETRequest(
			_groupModel.SERVICE_ENDPOINTS.GET_PARTICIPATING_GROUPS, params,
			function(data) {/* success handler */
				GRID_PARAM_GROUP.updateGrid(data);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in getting data: " + error);
			});
}

function myGroupContextMenuHandler(menuItemText, rowData) {
	if (menuItemText == "Add Member") {
		groupId = rowData.groupId;
		showAddGroupUsersForm(rowData);
	} else if (menuItemText == "Add Owner") {
		groupId = rowData.groupId;
		showAddGroupOwnerForm(rowData);
	} else if (menuItemText == "Delete Group") {
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteGroup(rowData.groupId);
		}
	} else if (menuItemText == "Leave Group") {
		var a = window.confirm("Are you sure to Leave ?");
		if (a) {
			leaveGroupUser(rowData.groupId, loggedInUserId);
		}
	}
};

function deleteGroup(groupId) {
	var param = {
		'groupId' : groupId
	};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_groupModel.SERVICE_ENDPOINTS.DELETE_GROUP,
			param, function(data) {
				_flaskLib.showSuccessMessage('group-action-msg',
						_groupModel.MESSAGES.DEL_SUCCESS_GROUP);
				loadGroupData(loggedInUserId);
			}, function(data) {
				_flaskLib.showErrorMessage('group-action-msg',
						_groupModel.MESSAGES.DEL_ERR_GROUP);
			});

}

function deleteMultipleGroups(groupList) {
	var param = {
		groupList : groupList
	};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_groupModel.SERVICE_ENDPOINTS.DELETE_GROUPS,
			param, function(data) {
				_flaskLib.showSuccessMessage('group-action-msg',
						_groupModel.MESSAGES.DEL_SUCCESS_GROUP);
				loadGroupData(loggedInUserId);
			}, function(data) {
				_flaskLib.showErrorMessage('group-action-msg',
						_groupModel.MESSAGES.DEL_ERR_GROUP);
			});

}

function editGroup(rowData) {
	_flaskLib.loadDataToForm("myGroupForm", _groupModel.DATA_MODEL.GROUP,
			rowData, function() {

			});
	$("#myGroupDataTable").hide();
	$("#myGroupModal").modal('show');
	myGroupForm.show();
	// _flaskLib.loadUSARegions('venueStateId', rowData.venueStateId);

}

function saveGroup() {
	params = _flaskLib.getFormData('myGroupForm', _groupModel.DATA_MODEL.GROUP,
			function(formId, model, formData) {
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
	var tempParam = {};
	tempParam.groupName = params.groupName;
	tempParam.groupDescription = params.groupDescription;
	tempParam.isDelete = 0;
	tempParam.isActive = 1;
	tempParam.createdBy = params.userName;
	var date = new Date();
	tempParam.createdDate = date.getMonth()+"/"+date.getDate()+"/"+date.getFullYear();
	params.groupId = groupId;

	if (params.groupId == "0") {
		url = _groupModel.SERVICE_ENDPOINTS.ADD_GROUP;
	} else {
		url = _groupModel.SERVICE_ENDPOINTS.UPDATE_GROUP;
	}
	flaskRequest.sendPOSTRequest(url, tempParam, function(data) {
		_flaskLib.showSuccessMessage('group-action-msg',
				_groupModel.MESSAGES.SAVE_GROUP);
		var userrparams = {};
		userrparams.groupId = data.groupId;
		userrparams.userId = params.userId;
		userrparams.userName = params.userName;
		userrparams.emailAddress = params.emailAddress;
		userrparams.isAdmin = 1;
		addGroupUser(userrparams)
	}, function(data) {
		_flaskLib.showErrorMessage('group-action-msg',
				_groupModel.MESSAGES.ERR_GROUP);
	});

}

function fetchGroupDetail(groupId) {
	var flaskRequest = new Request();
	params = {
		groupId : groupId
	};
	flaskRequest.sendGETRequest(
			_groupModel.SERVICE_ENDPOINTS.GET_ALL_GROUP_USERS, params,
			function(data) {/* success handler */
				_groupModel.groupDetail = data;
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in getting Group Detaill: " + error);
			});
}

function addGroupUsers(){
	var selectedUserList = GRID_PARAM_GROUP.getCheckedUsersList();
	for ( var i = 0 ; i < selectedUserList.length; i ++) {
		var user = selectedUserList[i];
		var userrparams = {};
		userrparams.groupId = groupId;
		userrparams.emailAddress = user.emailAddress;
		userrparams.userId = user.userId;
		userrparams.userName = user.firstName;
		userrparams.isAdmin = 0;
		addGroupUser(userrparams)
	}
}
function addGroupUser(params) {
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_groupModel.SERVICE_ENDPOINTS.ADD_GROUP_USER,
			params, function(data) {/* success handler */
		_flaskLib.showSuccessMessage('group-action-msg',
				_groupModel.MESSAGES.ADD_GRP_USER);
					loadGroupData(loggedInUserId);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in getting Group Detaill: " + error);
			});
}

function leaveGroupUser(groupId, userId) {
	var params = {
		groupId : groupId,
		userId : userId
	};
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(
			_groupModel.SERVICE_ENDPOINTS.DELETE_GROUP_USER, params, function(
					data) {
				_flaskLib.showSuccessMessage('group-action-msg',
						_groupModel.MESSAGES.DEL_SUCCESS_GRP_USER);
				loadGroupData(loggedInUserId);
			}, function(error) {
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in deleting Group User : " + error);
			});
}

function showAddGroupUsersForm(rowData) {
	fetchGroupDetail(groupId);
	prepareUserGrid();
//	$("#tabs").hide();
	$("#myGroupDataTable").hide();
	$("#addGroupUserForm").show();
}
function prepareUserGrid(){
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(
				_groupModel.SERVICE_ENDPOINTS.GET_ALL_USERS, {}, function(data) {
					var gridData = prepareData(data, _groupModel.groupDetail, false);
					createUserTable(gridData, $("#userDataGrid"));
				}, function(error) {
					_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
					console.log("Error in deleting Group User : " + error);
				});
}

function showAddGroupOwnerForm(rowData) {
	fetchGroupDetail(groupId);
	prepareUserOwnerGrid();
//	$("#tabs").hide();
	$("#myGroupDataTable").hide();
	$("#addGroupOwnerForm").show();
}
function prepareUserOwnerGrid(){
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(
				_groupModel.SERVICE_ENDPOINTS.GET_ALL_USERS, {}, function(data) {
					var gridData = prepareData(data, _groupModel.groupDetail, true);
					createUserTable(gridData, $("#userOwnerDataGrid"));
				}, function(error) {
					_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
					console.log("Error in deleting Group User : " + error);
				});
}

function prepareData(userList, groupUserList, forGroupOwner){
	var tempGroupUserList = [];
	var tempUserList = [];
	var grpAdminList = [];
	for(var i = 0;i<groupUserList.length;i++){
		var grpUser = groupUserList[i];
		tempGroupUserList.push(grpUser.userId);
		if(grpUser.isAdmin == "1")
			grpAdminList.push(grpUser.userId);
	}
	for(var j = 0; j < userList.length; j++){
		var usr = userList[j];
		var indexOf = tempGroupUserList.indexOf(usr.userId);
		var indexOfGrpAdmin = grpAdminList.indexOf(usr.userId);
		if(forGroupOwner && indexOf >= 0 && indexOfGrpAdmin < 0)
			tempUserList.push(usr);
		else if(!forGroupOwner && indexOf < 0)
			tempUserList.push(usr);
	}
	return tempUserList;
}
function addGroupOwners(){
	var selectedUserList = GRID_PARAM_GROUP.getCheckedUsersList();
	for ( var i = 0 ; i < selectedUserList.length; i ++) {
		var user = selectedUserList[i];
		var userrparams = {};
		userrparams.groupId = groupId;
		userrparams.userId = user.userId;
		userrparams.userName = user.firstName;
		userrparams.emailAddress = user.emailAddress;
		userrparams.isAdmin = 1;
		addGroupOwner(userrparams)
	}
}
function addGroupOwner(params){
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_groupModel.SERVICE_ENDPOINTS.ADD_GROUP_OWNER,
			params, function(data) {/* success handler */
		_flaskLib.showSuccessMessage('group-action-msg',
				_groupModel.MESSAGES.ADD_GRP_USER);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in getting Group Detaill: " + error);
			});
}