var _startPos = 0;
var _endPos = 9;
function initContactList(startPos,endPos){
	var companyId = $("#CompanyId").val();
	var searchString = $(".search-query").val();
	var params = {companyId: companyId,keywords: searchString,start: startPos,end: endPos};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_ALL_CONTACTS , params, 
		function (data){
			if(data.length>0)
				renderContactList(data,false);
		} ,
		function (data){
			_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEARCH_ERR);
	});
}

function initFriendList(startPos,endPos){
	var companyId = $("#CompanyId").val();
	var searchString = $(".search-query").val();
	var params = {companyId: companyId,keywords: searchString,start: startPos,end: endPos};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_MY_FRIENDS , params, 
		function (data){
			if(data.length>0)
				renderContactList(data,true);
			else{
			}
		} ,
		function (data){
			_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEARCH_ERR);
	});
}

function renderContactList(tdata,IsFriendList) {
	var divRow;
	if(IsFriendList)
		divRow = $('#Friend_placeholder');	
	else
		divRow = $('#Users_placeholder');
	
	 $(divRow).html("");
	 //console.log(tdata.length);
	 if(tdata.length == 0){
		$("<span class='control-label-nocolor'>There are no users available</span>").appendTo($(divRow));
		return;
	 }
	 for(var i=0; i < tdata.length; i++)
		{
		 	var flaskUser = tdata[i];
		    var objTable = $('<table/>',{'class':'tblRow'});
		    var objTr = $('<tr/>');
		    $(objTr).appendTo($(objTable));
		    var objTd1 = $('<td/>',{'width':'70px','rowspan':'2'});
		    $(objTd1).appendTo($(objTr));
		    
		    fnShowEventLogo(flaskUser.uuid, objTd1,false);		    
		    var userName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(userName_lbl).html(flaskUser.fullName);
		    var objTd2 = $('<td/>',{'data-id':flaskUser.userId,'data-uuid':flaskUser.uuid});
		    
		    $(userName_lbl).appendTo($(objTd2));
		    $(objTd2).appendTo(objTr);
		    var objTd3 = $('<td/>',{'rowspan':'2','align':'right','valign':'top'});
		    console.log(flaskUser);
	    	var div_heart = fnBuildMenu(flaskUser);
	    	
		    $(div_heart).appendTo($(objTd3));
		    $(objTd3).appendTo(objTr);

		    var objTr2 = $('<tr/>');
		    var objtd2_1 = $('<td/>');
		    var venue_lbl = $('<label/>',{'class':'control-label-nocolor'});
		    $(objtd2_1).appendTo(objTr2);
		    $(venue_lbl).html(flaskUser.emailAddress);
		    $(venue_lbl).appendTo($(objtd2_1));
		    $(objtd2_1).appendTo($(objTr2));
		    $(objTr2).appendTo($(objTable));
		    $(objTable).appendTo($(divRow));		    
	    }
}

function fnShowEventLogo(imageUUID, container ,editable){
	//var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID;
	var imgURL = "/webdav/flask/document_library/DefaultProfilePic";
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')'});
	$(objdiv).appendTo($(container));
}

function fnBuildMenu(obj){
	var IsBlocked = obj.block;
	var UserId = obj.userId;
	var dropdown = $('<div/>',{'class':'dropdown'});
	if(!IsBlocked){
		var IsFriend = obj.connected;
		var ul = $('<ul/>',{'class':'dropdown-menu MyDDStyle'});
		if(IsFriend){
			var button = $('<button/>',{'class':'btn btn-primary dropdown-toggle','type':'button','data-toggle':'dropdown'})
			button.html('Friend&nbsp;<span class="caret"></span>');
			var li1 = $('<li/>');
			$(li1).html('<a href="#" onclick="fnBlock('+UserId+','+button+');">Block</a>');
			var li2 = $('<li/>');
			$(li2).html('<a href="#" onclick="fnUnFriend('+UserId+',this);">Unfriend</a>');
			var li3 = $('<li/>');
			$(li3).html('<a href="#" onclick="fnSendMessage('+UserId+');">Send Message</a>');
			$(li1).appendTo($(ul));
			$(li2).appendTo($(ul));
			$(li3).appendTo($(ul));
			$(ul).appendTo($(dropdown));		
		}
		else{
			var IsRequested = obj.connectionRequested;
			if(!IsRequested){
				var button = $('<button/>',{'class':'btn btn-primary','type':'button','onclick':'sendFriendRequest('+UserId+',this);'})
				button.html('Add Friend');
			}
			else{
				var button = $('<button/>',{'class':'btn btn-primary','type':'button','disabled':'disabled'})
				button.html('Request sent');
			}
		}
		$(button).appendTo($(dropdown));
		return $(dropdown);
	}
	else{
		var button = $('<button/>',{'class':'btn btn-primary dropdown-toggle','type':'button','data-toggle':'dropdown','onclick':'fnUnBlock('+UserId+',this);'})
		button.html('Unblock');
		$(button).click(function(){
			button.html('Add Friend');
			$(this).click(function(){
				sendFriendRequest(UserId,this);
			});
		})
		$(button).appendTo($(dropdown));
		return $(dropdown);
	}
}

function fnShowNextRecords(){
	_startPos = _startPos + 10;
	_endPos = _endPos + 10;
	if($(".active").attr("id")=="Friends")
		initFriendList(_startPos,_endPos);
	else
		initContactList(_startPos,_endPos);
}

function fnShowPrevRecords(){
	_startPos = _startPos - 10;
	_endPos = _endPos - 10;
	if($(".active").attr("id")=="Friends")
		initFriendList(_startPos,_endPos);
	else
		initContactList(_startPos,_endPos);
}


function getUserVCard(data){
	alert("Show user details here");
}

function sendFriendRequest(UserId,obj){
	var flaskRequest = new Request();
	var params = {receiverUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.SEND_REQUEST, params, 
	function(data){
		//initContactList(_startPos,_endPos);
		$(obj).html("Request sent");
		$(obj).attr("disabled","disabled");
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEND_REQ_ERR);
	});		
}

function acceptFriendRequest(UserId,obj){
	var flaskRequest = new Request();
	var params = {receiverUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.ACCEPT_REQUEST, params, 
	function(data){
		initFriendList(_startPos,_endPos);
		$(obj).hide();
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEND_REQ_ERR);
	});		
}

function ignoreFriendRequest(UserId,obj){
	var flaskRequest = new Request();
	var params = {receiverUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.ACCEPT_REQUEST, params, 
	function(data){
		initFriendList(_startPos,_endPos);
		$(obj).hide();
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEND_REQ_ERR);
	});		
}

function fnUnFriend(UserId,obj){
	var flaskRequest = new Request();
	var params = {receiverUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.UNFRIEND, params, 
	function(data){
		initContactList(_startPos,_endPos);
		$(obj).click(function(){
			sendFriendRequest(UserId,obj);
		})		
		$(obj).html('Add Friend');
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.UNFRIEND_ERR);
	});		
}


function fnBlock(UserId,obj){
	var flaskRequest = new Request();
	var params = {blockUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.BLOCKPERSON, params, 
	function(data){
		initContactList(_startPos,_endPos);
		$(obj).click(function(){
			sendFriendRequest(UserId,obj);
		})		
		$(obj).html('Unblock');
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.UNFRIEND_ERR);
	});
}

function fnUnBlock(UserId,obj){
	var flaskRequest = new Request();
	var params = {unblockUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.UNBLOCKPERSON, params, 
	function(data){
		initContactList(_startPos,_endPos);
		$(obj).click(function(){
			sendFriendRequest(UserId,obj);
		})		
		$(obj).html('Add Friend');
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.UNFRIEND_ERR);
	});
}

function initSearch(){
	$("#btnSubmit").click(function(){
		initContactList(_startPos,_endPos);		
	});
}

function initNotifications(){
	getRequestList();
}

function fnSendMessage(userId){
	YUI().use('aui-modal',function(Y) {
		var modal = new Y.Modal(
		  {
			bodyContent: '<aui:input type="textarea" name="message"/>',
			centered: true,
			destroyOnHide: false,
			headerContent: '<h3>Send message</h3>',
			modal: true,
			render: '#modal',
			resizable: {
			  handles: 'b, r'
			},
			visible: true,
			width: 300
		  }
		).render();

		modal.addToolbar(
		  [
			{
			  label: 'Cancel',
			  on: {
				click: function() {
				  modal.hide();
				}
			  }
			},
			{
			  label: 'Okay',
			  on: {
				click: function() {
				  alert('Just an example, there will be no printing here.');
				}
			  }
			}
		  ]
		);
        modal.show();
	});	
}

function getRequestList(){
	var requestJSON;
	var flaskRequest = new Request();
	var params = {};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_REQUESTS, params, 
	function(data){
		var requestJSON = $.extend(true, {}, data);
		renderRequestList(requestJSON);
	} , function(error){
		//_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEND_REQ_ERR);
	});		
}

function renderRequestList(obj){
	console.log(obj);
	var divRow = "#MyFriendRequests";
	$(divRow).html("");
	$.each(obj,function(index,node){
		var flaskRequest = new Request();
		var params = {userId:node.userId};
		flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_USER_DETAILS, params, 
		function(data){
			var flaskUser = data;
		    var objTable = $('<table/>',{'class':'tblRow'});
		    var objTr = $('<tr/>');
		    $(objTr).appendTo($(objTable));
		    var objTd1 = $('<td/>',{'width':'70px','rowspan':'2'});
		    $(objTd1).appendTo($(objTr));
		    
		    fnShowEventLogo(flaskUser.uuid, objTd1,false);		    
		    var userName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(userName_lbl).html(flaskUser.firstName + " " + flaskUser.lastName);
		    var objTd2 = $('<td/>',{'data-id':flaskUser.userId,'data-uuid':flaskUser.uuid});
		    
		    $(userName_lbl).appendTo($(objTd2));
		    $(objTd2).appendTo(objTr);
		    var objTd3 = $('<td/>',{'rowspan':'2','align':'right','valign':'top'});
		    console.log(flaskUser);
	    	var div_heart = fnBuildRequestMenu(flaskUser,objTable);
	    	
		    $(div_heart).appendTo($(objTd3));
		    $(objTd3).appendTo(objTr);

		    var objTr2 = $('<tr/>');
		    var objtd2_1 = $('<td/>');
		    var venue_lbl = $('<label/>',{'class':'control-label-nocolor'});
		    $(objtd2_1).appendTo(objTr2);
		    $(venue_lbl).html(flaskUser.emailAddress);
		    $(venue_lbl).appendTo($(objtd2_1));
		    $(objtd2_1).appendTo($(objTr2));
		    $(objTr2).appendTo($(objTable));
		    $(objTable).appendTo($(divRow));	
		} , function(error){
			//_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEND_REQ_ERR);
		});	
	});
}

function fnBuildRequestMenu(obj,htmlObject){
	var IsBlocked = obj.block;
	var UserId = obj.userId;
	var dropdown = $('<div/>',{'class':'dropdown'});
	if(!IsBlocked){
		var IsFriend = obj.connected;
		var ul = $('<ul/>',{'class':'dropdown-menu MyDDStyle'});
		if(!IsFriend){
			var buttonAccept = $('<button/>',{'class':'btn btn-primary','type':'button'})
			buttonAccept.html('Confirm');
			buttonAccept.click(function(){
				acceptFriendRequest(UserId,htmlObject);
			});
			var buttonReject = $('<button/>',{'class':'btn btn-primary','type':'button','onclick':'ignoreFriendRequest('+UserId+','+htmlObject+');'})
			buttonReject.html('Ignore');
		}
		$(buttonAccept).appendTo($(dropdown));
		$(buttonReject).appendTo($(dropdown));
		return $(dropdown);
	}
}