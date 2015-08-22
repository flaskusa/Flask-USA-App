var _startPos = 0;
var _endPos = 9;
function initContactList(startPos,endPos){
	if(startPos>0)
		$("#prev").show();
	var companyId = $("#CompanyId").val();
	var searchString = $(".search-query").val();
	var params = {companyId: companyId,keywords: searchString,start: startPos,end: endPos};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_ALL_CONTACTS , params, 
		function (data){
			renderContactList(data)
		} ,
		function (data){
			_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEARCH_ERR);
	});
}

function renderContactList(tdata) {
	 var divRow = $('#Friend_placeholder');
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
	 	$(divRow).appendTo($("#placeholder"));
}

function fnShowEventLogo(imageUUID, container ,editable){
	//var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID;
	var imgURL = "/webdav/flask/document_library/DefaultProfilePic";
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')'});
	$(objdiv).appendTo($(container));
}

function fnBuildMenu(obj){
	var IsFriend = obj.connected;
	var UserId = obj.userId;
	var IsRequested = obj.connectionRequested;
	var dropdown = $('<div/>',{'class':'dropdown'});
	var ul = $('<ul/>',{'class':'dropdown-menu'});
	if(IsFriend){
		var button = $('<button/>',{'class':'btn btn-primary dropdown-toggle','type':'button','data-toggle':'dropdown'})
		button.html('Friend&nbsp;<span class="caret"></span>');
		var li1 = $('<li/>');
		$(li1).html('<a href="#" onclick="fnBlock('+UserId+');">Block</a>');
		var li2 = $('<li/>');
		$(li2).html('<a href="#" onclick="fnUnFriend('+UserId+',this);">Unfriend</a>');
		$(li1).appendTo($(ul));
		$(li2).appendTo($(ul));
		$(ul).appendTo($(dropdown));		
	}
	else{
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

function fnBlock(UserId){
	alert("Block"+UserId);
}

function fnShowNextRecords(){
	_startPos = _startPos + 10;
	_endPos = _endPos + 10;
	initContactList(_startPos,_endPos);
}

function fnShowPrevRecords(){
	_startPos = _startPos - 10;
	_endPos = _endPos - 10;
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
		initContactList(_startPos,_endPos);
		$(obj).html("Request sent");
		$(obj).attr("disabled","disabled");
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

function initSearch(){
	$("#btnSubmit").click(function(){
		initContactList(_startPos,_endPos);		
	});
}