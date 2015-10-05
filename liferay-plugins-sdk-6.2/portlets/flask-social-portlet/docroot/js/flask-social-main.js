var _startPos = 0;
var _endPos = 9;
function initContactList(startPos,endPos){
	if(startPos>0)
		$("#prev").show();
	var companyId = $("#CompanyId").val();
	var searchString = $(".search-query").val();
	_startPos = startPos;
	var params = {companyId: companyId,keywords: searchString,start: startPos,end: endPos};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_ALL_CONTACTS , params, 
		function (data){
			renderContactList(data,false);
		} ,
		function (data){
			_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEARCH_ERR);
	});
	$("html, body").animate({ scrollTop: $(document).height()+$(window).height()+$('#Users_placeholder').height() }, "slow");
	return false;
}

function initFriendList(startPos,endPos){
	if(startPos>0)
		$("#prev").show();
	var companyId = $("#CompanyId").val();
	var searchString = $(".search-query").val();
	var params = {companyId: companyId,keywords: searchString,start: startPos,end: endPos+1};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_MY_FRIENDS , params, 
		function (data){
			if(data.length<=(endPos-startPos)){
				$(".more").hide();
			}else{
				data.slice(startPos, endPos+1);
			}
			renderContactList(data,true);
		} ,
		function (data){
			_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEARCH_ERR);
	});
	$("html, body").animate({ scrollTop: $(document).height()+$(window).height()+$('#Friend_placeholder').height() }, "slow");
	return false;
}

function renderContactList(tdata,IsFriendList) {
	var divRow;
	if(IsFriendList)
		divRow = $('#Friend_placeholder');	
	else
		divRow = $('#Users_placeholder');

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
		    var objTdc = $('<td/>',{'width':'25px','rowspan':'2', 'class':'chk'});
		    var objChkbx = $('<input/>', {'type':'checkbox', 'class':'selected', 'value':flaskUser.userId});
		    $(objChkbx).appendTo($(objTdc));
		    $(objTdc).appendTo($(objTr));
		    var objTd1 = $('<td/>',{'width':'70px','rowspan':'2'});
		    $(objTd1).appendTo($(objTr));
		    
		    
		    fnShowEventLogo(flaskUser.uuid, objTd1,false);		    
		    var userName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(userName_lbl).html(flaskUser.fullName);
		    var objTd2 = $('<td/>',{'data-id':flaskUser.userId,'data-uuid':flaskUser.uuid});
		    
		    $(userName_lbl).appendTo($(objTd2));
		    $(objTd2).appendTo(objTr);
		    var objTd3 = $('<td/>',{'rowspan':'2','align':'right','valign':'top', 'width':'126px'});
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
		    $(objTable).appendTo($(divRow)).show('slow');
	    }
	 $(".chk").hide();
	 return false;
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
			$(li1).html('<a href="#" onclick="fnBlock('+UserId+',this);">Block</a>');
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
	initContactList(_startPos,_endPos);
}

function fnShowNextFriends(){
	_startPos = _startPos + 10;
	_endPos = _endPos + 10;
	initFriendList(_startPos,_endPos);
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
		$(obj).hide();
		getRequestCount();
		initFriendList(_startPos,_endPos);
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEND_REQ_ERR);
	});		
}

function ignoreFriendRequest(UserId,obj){
	console.log("m in ignore");
	var flaskRequest = new Request();
	var params = {receiverUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.DELETE_REQUEST, params, 
	function(data){
		$(obj).hide();
		getRequestCount();
		initFriendList(_startPos,_endPos);
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEND_REQ_ERR);
	});		
}

function fnUnFriend(UserId,obj){
	var flaskRequest = new Request();
	var params = {receiverUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.UNFRIEND, params, 
	function(data){
		
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.UNFRIEND_ERR);
	});		
	initContactList(_startPos,_endPos);
	var hide_div = $(obj).closest(".tblRow");
	$(hide_div).fadeOut( "slow" );	
}


function fnBlock(UserId,obj){
	var flaskRequest = new Request();
	var params = {blockUserId: UserId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.BLOCKPERSON, params, 
	function(data){
		
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.UNFRIEND_ERR);
	});
	var hide_div = $(obj).closest(".tblRow");
	$(hide_div).fadeOut( "slow" );	
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
	getRequestCount();
	getRequestList();
}

function getRequestCount(){
	var cnt = "#RequestCount";
	  $(cnt).html("");
	Liferay.Service(
			  '/flask-social-portlet.entry/get-requests-count',
			  function(obj) {
				  var divCnt = $('<div style="display: initial;">'+obj+'</div>');
				  $(divCnt).appendTo($(cnt));
			  }
			);
}

function fnSendMessage(userId){
	//$("#jqxwindow").hide();
	$("#jqxwindow").jqxWindow({ height: 175, width: 370, theme: 'custom', isModal: true, autoOpen: false });
        $("#jqxwindow").jqxWindow('open');
	
}

function fnSendMessage(userIdList){
	//$("#jqxwindow").hide();
	$("#jqxwindow").jqxWindow({ height: 175, width: 370, theme: 'custom', isModal: true, autoOpen: false });
        $("#jqxwindow").jqxWindow('open');
	
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
			var buttonReject = $('<button/>',{'class':'btn btn-primary','type':'button','style':'margin-left: 10px !important;'})
			buttonReject.html('Ignore');
			buttonReject.click(function(){
				ignoreFriendRequest(UserId,htmlObject);
			});
		}
		$(buttonAccept).appendTo($(dropdown));
		$(buttonReject).appendTo($(dropdown));
		return $(dropdown);
	}
}

function GetParameterValues(param) {  
    var url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');  
    for (var i = 0; i < url.length; i++) {  
        var urlparam = url[i].split('=');  
        if (urlparam[0] == param) {
            var urlparamFinal = urlparam[1].split('#');
            return urlparamFinal[0];  
        }  
    }  
}