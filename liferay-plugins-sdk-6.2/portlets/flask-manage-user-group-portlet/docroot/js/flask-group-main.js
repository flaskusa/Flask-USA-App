var myGroupForm;
var groupId = "0";
var loggedInUserId = "0";
function groupClickHandlers() {
	window.location.hash = '#UserGroups';
	myGroupForm = $("#myGroupForm");
	/* Initialize display elements */

	$(window).hashchange( function(){
		var hash = location.hash;
		switch(hash) {
	    case "#UserGroups":
	    	$("#myGroupDataTable").show();
			$("#formContainer").hide();
			myGroupForm.hide();
			$("#addGroupUserForm").hide();
			$("#addGroupOwnerForm").hide();
			loadGroupData(loggedInUserId);
			break;
	    case "#EditGroup":
	    	$("#grpForm").click();
	        break;
	    case "#MyFriendsToAdd":
	    	$("#frnds").click();
	        break;	        
	    default:
	    	//alert("This is default");
		}		
	})
	
	$(".cssDelete").hide();

	/* Click handler for add user button */

	$(".cssAddUser").click(function() {
		  window.location.hash = '#EditGroup';
		  $(".clsSaveGroup").html('Create');
		  $("#formContainer").show();
		  $("#myGroupDataTable").hide();
		  document.getElementById("myGroupForm").reset();
		  $('#myGroupForm').jqxValidator('hide');
		  $("#group-member-list").hide();
		  myGroupForm.show();
		  myGroupForm.trigger('reset')
		//  $("#tabs").hide();
		  $("#myGroupDataTable").hide();
		  groupId = "0";
	});

	/* Click handler for save button */

	$(".clsSaveGroup").click(
			function() {
				if ($('#myGroupForm').jqxValidator('validate'))
					saveGroup();
//					$("#tabs").show();
					//$("#myGroupDataTable").show();
					//myGroupForm.hide();

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
		$("#formContainer").hide();
		myGroupForm.hide();
	});
	$(".clsBack").click(function() {
//		$("#tabs").show();
		$("#myGroupDataTable").show();
		$("#formContainer").hide();
		myGroupForm.hide();
		$("#addGroupUserForm").hide();
		$("#addGroupOwnerForm").hide();
	});
	
	$(".clsCancelGroup").click(function() {
		window.location.hash = '#UserGroups';
//		$("#tabs").show();
		$("#myGroupDataTable").show();
		$("#formContainer").hide();
		myGroupForm.hide();
		$("#addGroupUserForm").hide();
		$("#addGroupOwnerForm").hide();
		loadGroupData(loggedInUserId);
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

	$("#grpForm").click(function(){
		$("myGroupForm").show();
		if(window.location.hash != '#EditGroup'){
			window.location.hash = '#EditGroup';
			showOnlyGroupUsers();
		}
	});
	$("#frnds").click(function(){
		window.location.hash = '#MyFriendsToAdd';
		showAddGroupUsersForm();
	});
	/* Toggle search boxes */
	$("#cssSearchGroup").click(GRID_PARAM_GROUP.toggleSearchBoxes);
	$("#cssSearchUser").click(GRID_PARAM_GROUP.toggleUserSearchBoxes);
	$("#cssSearchOwner").click(GRID_PARAM_GROUP.toggleUserSearchBoxes);
	
	$('#myGroupForm').jqxValidator
	({
		hintType: 'label',
		animationDuration: 0,
		rules: [
		               { input: '#groupName', message: 'Group name is required!', action: 'keyup, blur', rule: 'required' },
		               { input: '#groupDescription', message: 'Group description is required!', action: 'keyup, blur', rule: 'required' }
			   ]
	});
	
	$("#btnSearchFriend").click(function(){
		  $(this).addClass('disabled');
		  showAddGroupUsersForm();
	});	
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
				$("#formContainer").hide();
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
	groupId = rowData.groupId;
	if (menuItemText == "Edit Group") {
		window.location.hash = '#EditGroup';
		editGroup(rowData);
		showOnlyGroupUsers();
	} /*else if (menuItemText == "Add Friend") {
		//groupId = rowData.groupId;
		showAddGroupUsersForm();
		//showOnlyGroupUsers();
	}*/ else if (menuItemText == "Delete Group") {
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteGroup(rowData.groupId);
		}
	} else if (menuItemText == "Leave Group") {
		var a = window.confirm("Are you sure to Leave ?");
		if (a) {
			leaveGroupUser(rowData.groupId, loggedInUserId);
			loadGroupData(loggedInUserId);
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
	$("#formContainer").show();
	$("#myGroupDataTable").hide();
	_flaskLib.loadDataToForm("myGroupForm", _groupModel.DATA_MODEL.GROUP,
			rowData, function() {
				
			});
	Liferay.Service(
			  '/flask-rest-users-portlet.flaskadmin/get-user-by-id',
			  {
			    userId: params.userId
			  },
			  function(obj) {
				  $("#emailAddress").val(obj.email);
			  }
			);
	$("#userId").val(Liferay.ThemeDisplay.getUserId());
	$("#userName").val(rowData.createdBy);
	//$("#emailAddress").val()
	console.log(rowData);
	$("#groupDescription").val(rowData.groupDescription);
	$("#myGroupDataTable").hide();
	$("#myGroupModal").modal('show');
	myGroupForm.show();
	$(".clsSaveGroup").html('Save');
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
	if(params.emailAddress == "")
		params.emailAddress = emailAddress.val();
	tempParam.groupName = params.groupName;
	tempParam.groupDescription = params.groupDescription;
	tempParam.isDelete = 0;
	tempParam.isActive = 1;
	tempParam.createdBy = params.userName;
	tempParam.groupId=groupId;
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
	if (params.groupId == "0") {
		var userrparams = {};
		userrparams.groupId = data.groupId;
		groupId = userrparams.groupId;
		userrparams.userId = params.userId;
		userrparams.userName = params.userName;
		userrparams.emailAddress = params.emailAddress;
		userrparams.isAdmin = 1;
		addGroupUser(userrparams, userrparams.isAdmin);
	}
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
function addGroupUser(userData, isAdmin) {
	var flaskRequest = new Request();
	if(userData.fullName== undefined)
		userData.fullName = userData.userName;
	if(groupId==0)
		groupId = userData.groupId;
	params = {groupId: groupId, emailAddress: userData.emailAddress, userId: userData.userId, userName: userData.fullName, isAdmin: isAdmin}
	flaskRequest.sendPOSTRequest(_groupModel.SERVICE_ENDPOINTS.ADD_GROUP_USER,
			params, function(data) {/* success handler */
		_flaskLib.showSuccessMessage('group-action-msg',_groupModel.MESSAGES.ADD_GRP_USER);
					//loadGroupData(loggedInUserId);
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
				//loadGroupData(loggedInUserId);
			}, function(error) {
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in deleting Group User : " + error);
			});
}

/************************************start***************************************/

function showAddGroupUsersForm() {
	$("#formContainer").show();
	$("#myGroupDataTable").hide();
	getMyFriends(false);
}

function showOnlyGroupUsers() {
	$("#formContainer").show();
	$("#myGroupDataTable").hide();
	/*
	fetchGroupDetail(groupId);
	prepareUserGrid();
//	$("#tabs").hide();
	$("#myGroupDataTable").hide();
	$("#addGroupUserForm").show();
	*/
	getMyFriends(true);
}


function getMyFriends(grpMember){
	var startPos= 0;
	var endPos = 500;
	var companyId = $("#CompanyId").val();
	var searchString =  $("#searchFriend").val();
	var params = {companyId: companyId,keywords: searchString};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_groupModel.SERVICE_ENDPOINTS.GET_MY_FRIENDS , params, 
		function (data){
			if(data.length<=(endPos-startPos)){
				$(".more").hide();
			}else{
				data.slice(startPos, endPos+1);
			}
			if(grpMember)
				renderGroupMembersList(data);
			else
				renderContactList(data);
		} ,
		function (data){
			_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEARCH_ERR);
	});
}

function renderContactList(tdata) {
	var divRow = $('#Friend_placeholder');
	$(divRow).html("");
	var strMsg = "You do not have any friends yet. Please search and add friends";

	 if(tdata.length == 0){
		$("<span class='control-label-nocolor'>"+strMsg+"</span>").appendTo($(divRow));
		$("#prev").hide();
		return;
	 }
	 for(var i=0; i < tdata.length; i++)
		{
		 	var flaskUser = tdata[i];
		 	createList(flaskUser, divRow);
	    }
	 $(".chk").show();
	 return false;
}

function renderGroupMembersList(tdata) {
	var divRow = $('#Group_placeholder');
	$(divRow).html("");
 	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(
		_groupModel.SERVICE_ENDPOINTS.GET_ALL_GROUP_USERS, {groupId: groupId}, 
		function(dt) {
			if(dt.length>1){
				for(var i=0; i < tdata.length; i++)
				{
					var flaskUser = tdata[i];
					for(var j = 0; j<dt.length; j++){
				    	if(dt[j].userId == flaskUser.userId){
				    		createList(flaskUser, divRow);
				    	}
					}
				}
				$('#group-member-list').show();
			}
			else{
				$('#group-member-list').hide();
			}
		}, function(error) {
			console.log("Error in get all group members : " + error);
	});
	 $(".chk").show();
	 return false;
}

function createList(flaskUser, divRow){
	var objTable = $('<table/>',{'class':'tblRow'});
	    var objTr = $('<tr/>');
	    $(objTr).appendTo($(objTable));
	    var objTd1 = $('<td/>',{'width':'50px'});
	    $(objTd1).appendTo($(objTr));
	    console.log(flaskUser);
	    fnShowEventLogo(flaskUser.portraitId, objTd1);
	    
	    var userName_lbl = $('<label/>',{'class':'control-label-color'});
	    $(userName_lbl).html(flaskUser.fullName);
	    var objTd2 = $('<td/>',{'data-id':flaskUser.userId,'data-uuid':flaskUser.uuid});
	    
	    $(userName_lbl).appendTo($(objTd2));
	    var venue_lbl = $('<label/>',{'class':'control-label-nocolor'}); 
	    $(venue_lbl).html(flaskUser.emailAddress);
	    $(venue_lbl).appendTo($(objTd2));
	    
	    $(objTd2).appendTo(objTr);
	    var objTd3 = $('<td/>',{'width':'140px'});
	    var div_heart = fnBuildMenu(flaskUser);
 	
	    $(div_heart).appendTo($(objTd3));
	    var objChkbx = $('<input/>', {'type':'checkbox','class':'selected', 'value':flaskUser.userId,'style':'display:none','id':flaskUser.userId});
	    var objlbl = $('<label/>',{'for':flaskUser.userId,'class':'selectedLabel'}) 
	    objlbl.html('Is admin?');
	    $(objChkbx).appendTo($(objTd3));
	    $(objlbl).appendTo($(objTd3));
	    $(objTd3).appendTo(objTr);

	    $(objTable).appendTo($(divRow)).show('slow');
	    var userrparams = {};
	    objChkbx.click(function(){
	        if($(this).is(':checked')){
	        	$(this).attr('checked', 'checked');
	        	userrparams.groupId = groupId;
	    		userrparams.userId = flaskUser.userId;
	    		addGroupOwner(userrparams, this);
	    		
	        } else {
	        	$(this).attr('checked', '');
	        	userrparams.groupId = groupId;
	    		userrparams.userId = flaskUser.userId;
	        	removeGroupOwner(userrparams);
	        }
	    });
	    $("#btnSearchFriend").removeClass('disabled');
}

function fnShowEventLogo(potraitID, container){
	var objdiv = $('<div/>',{'class':'eventLogo'});
	renderPhoto(potraitID,objdiv);
	$(objdiv).appendTo($(container));
}

function renderPhoto(FileId,objProfilePic){
	var imgURL = "/webdav/flask/document_library/DefaultProfilePic";
	if(FileId>0){
		 var params = {fileEntryId: FileId};
		 var flaskRequest = new Request();
		 flaskRequest.sendGETRequest('/flask-rest-users-portlet.flaskadmin/get-my-file-entry',params,
		    function (data){
		    	 imgURL = "/c/document_library/get_file?uuid="+data.uuid+"&groupId="+data.groupId;
		    	 $(objProfilePic).css("background-image","url('"+imgURL+"')");
		     } ,
		     function (data){
		    	 $(objProfilePic).css("background-image","url('"+imgURL+"')");
		 });		
	}
	else{
		$(objProfilePic).css("background-image","url('"+imgURL+"')");
	}
		
}

function fnBuildMenu(obj){
	var IsBlocked = obj.block;
	var UserId = obj.userId;
	var dropdown = $('<div/>',{'class':'dropdown'});
	if(!IsBlocked){
		var IsFriend = obj.connected;
		var ul = $('<ul/>',{'class':'dropdown-menu MyDDStyle'});
		if(IsFriend){
			var button = $('<button/>',{'class':'btn btn-primary dropdown-toggle','type':'button'});
			button.html('Add');
			button.closest('.tblRow').find('.selected').closest('.selectedLabel').hide();
			var flaskRequest = new Request();
			flaskRequest.sendGETRequest(
					_groupModel.SERVICE_ENDPOINTS.GET_ALL_GROUP_USERS, {groupId: groupId}, 
					function(dt) {
						for(var i = 0; i<dt.length; i++){
					    	if(dt[i].userId == UserId){
					    		button.html('');
					    		button.html('Remove');
					    		button.closest('.tblRow').find('.selected').closest('.selectedLabel').show();
					    		button.closest('.tblRow').find('.selected').removeAttr('disabled');
					    		if(dt[i].isAdmin==1){
					    			button.closest('.tblRow').find('.selected').attr('checked', 'checked');
					    		}
					    	}
						}
					}, function(error) {
						console.log("Error in get all group members : " + error);
					});
		}
		button.click(function(){
			if($(this).html() == 'Add'){
				$(this).html('');
				$(this).html('Remove');
				addGroupUser(obj, 0);
				$(this).closest('.tblRow').find('.selected').closest('.selectedLabel').show();
			}
			else{
				if($(this).parents('div#group-member-list').length>0){
					$(this).closest('.tblRow').remove();
				}
				$(this).html('');
				$(this).html('Add');
				leaveGroupUser(groupId, UserId);
				$(this).closest('.tblRow').find('.selected').closest('.selectedLabel').hide();
			}
		});
		$(button).appendTo($(dropdown));
		return $(dropdown);
	}
}

/*************************************end*************************************/
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
	console.log(rowData);
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
		addGroupOwner(userrparams);
	}
}
function addGroupOwner(params, objChkbx){
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_groupModel.SERVICE_ENDPOINTS.ADD_GROUP_OWNER,
			params, function(data) {
			}, function(data) {
				if(data>0){
					_flaskLib.showSuccessMessage('group-action-msg',"Group owner added successfully.");
				}
				else{
					_flaskLib.showErrorMessage('group-action-msg',"User is not member of group");
					$(objChkbx).removeAttr('checked');
				}
			});
}

function removeGroupOwner(params){
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_groupModel.SERVICE_ENDPOINTS.REMOVE_GROUP_OWNER,
			params, function(data) {/* success handler */
		_flaskLib.showSuccessMessage('group-action-msg',
				"Group owner removed successfully.");
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_groupModel.MESSAGES.GET_ERROR);
				console.log("Error in getting Group Detaill: " + error);
			});
}

function prepareMemberTable(container, grpId){
	var flaskRequest = new Request();
	var companyId = $("#CompanyId").val();
	var searchString =  $("#searchFriend").val();
	var params = {companyId: companyId,keywords: searchString};
	var flaskRequest = new Request();
		flaskRequest.sendGETRequest(_groupModel.SERVICE_ENDPOINTS.GET_ALL_GROUP_USERS, {groupId: grpId}, 
				function(obj){
							var memberTable = $('<table/>',{'width':'100%','class': 'aui'});
							var memberTr = $('<tr/>');
							var memberTh1 = $('<th/>');
							var memberTh2 = $('<th/>');
							var memberTh3 = $('<th/>');
							memberTable.append(memberTr);
							memberTr.append(memberTh1);
							memberTr.append(memberTh2);
							memberTr.append(memberTh3);
							memberTh1.html('');
							memberTh2.html('Name');
							memberTh3.html('Email');
								for(var j=0; j<obj.length; j++){
									var trNew = $('<tr/>');
									var tdFirstName = $('<td/>',{'width':'50px'});
									var tdLastName = $('<td/>');
									var tdEmail = $('<td/>');
									callUser(obj[j].userId, tdFirstName);
									tdLastName.html(obj[j].userName);
									console.log(j);
									tdEmail.html(obj[j].emailAddress);
									trNew.append(tdFirstName);
									trNew.append(tdLastName);
									trNew.append(tdEmail);
									memberTable.append(trNew);
								}
							$(container).append(memberTable);
	}, function(error){
		console.log(error);
	});
			
}

function callUser(userId, tdFirstName){
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_groupModel.SERVICE_ENDPOINTS.GET_USER_BY_ID, {userId: userId}, 
			function(data){
			var flaskUser = data;
		    fnShowEventLogo(flaskUser.portraitId, tdFirstName);
		},function(err){
			console.log(err);
		});
}