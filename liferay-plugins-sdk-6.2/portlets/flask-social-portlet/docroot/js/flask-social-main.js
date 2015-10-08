var _startPosFriends = 0; 
var _endPosFriends = 99;

var _startPos = 0; 
var _endPos = 9;
function initContactList(startPos,endPos){
	if(startPos>0)
		$("#prev").show();
	var companyId = $("#CompanyId").val();
	var searchString = $("#searchContact").val();
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
}

function initFriendList(startPos,endPos){
	/*if(startPos>0)
		$("#prev").show();*/
	var companyId = $("#CompanyId").val();
	var searchString =  $("#searchFriend").val();
	var params = {companyId: companyId,keywords: searchString};
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
}

function renderContactList(tdata,IsFriendList) {
	var divRow;
	if(IsFriendList){
		divRow = $('#Friend_placeholder');
		var strMsg = "You do not have any friends yet. Please search and add friends";
	}else{
		divRow = $('#Users_placeholder');
		var strMsg = "There are no users available";
	}
		

	 //console.log(tdata.length);
	 if(tdata.length == 0){
		$("<span class='control-label-nocolor'>"+strMsg+"</span>").appendTo($(divRow));
		$("#prev").hide();
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
		    var objTd1 = $('<td/>',{'width':'50px','rowspan':'2'});
		    $(objTd1).appendTo($(objTr));
		    console.log(flaskUser);
		    fnShowEventLogo(flaskUser.portraitId, objTd1);
		    
		    var userName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(userName_lbl).html(flaskUser.fullName);
		    var objTd2 = $('<td/>',{'data-id':flaskUser.userId,'data-uuid':flaskUser.uuid});
		    
		    $(userName_lbl).appendTo($(objTd2));
		    $(objTd2).appendTo(objTr);
		    var objTd3 = $('<td/>',{'width':'140px'});
	    	var div_heart = fnBuildMenu(flaskUser);
	    	
		    $(div_heart).appendTo($(objTd3));
		    $(objTd3).appendTo(objTr);

		    var objTr2 = $('<tr/>');
		    var objtd2_1 = $('<td/>',{'colspan':'2'});
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

function fnShowEventLogo(potraitID, container){
	var objdiv = $('<div/>',{'class':'eventLogo'});
	renderPhoto(potraitID,objdiv);
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
	_startPosFriends = _startPosFriends + 100;
	_endPosFriends = _endPosFriends + 100;
	initFriendList(_startPosFriends,_endPosFriends);
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
		initFriendList(_startPosFriends,_endPosFriends);
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
		initFriendList(_startPosFriends,_endPosFriends);
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
	$("#btnSearchContact").click(function(){
		$('#Users_placeholder').html('');
		initContactList(_startPos,_endPos);		
	});
	
	$("#btnSearchFriend").click(function(){
		$('#Friend_placeholder').html('');
		initFriendList(_startPosFriends,_endPosFriends);		
	});
}

function initNotifications(){
	getRequestCount();
	//getUnreadMessages();
	getMyAllMessages();
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
	$("#iMsg").val("");
	$('.md-trigger').click();
	$('#md-send').click(function(){
		$('#md-send').unbind()
		$('#spinningSquaresG').show();
		var selectedFriend = userId;
		var message = $('#iMsg').val();
		var isSendEmail = $('#sendEmailToSinglePerson').is(':checked');
		sendMessage(selectedFriend, message, isSendEmail);
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
		    console.log(flaskUser);
		    fnShowEventLogo(flaskUser.portraitId, objTd1);
		    
		    var userName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(userName_lbl).html(flaskUser.firstName + " " + flaskUser.lastName);
		    var objTd2 = $('<td/>',{'data-id':flaskUser.userId,'data-uuid':flaskUser.uuid});
		    
		    $(userName_lbl).appendTo($(objTd2));
		    $(objTd2).appendTo(objTr);
		    var objTd3 = $('<td/>',{'align':'right','valign':'top'});
		    console.log(flaskUser);
	    	var div_heart = fnBuildRequestMenu(flaskUser,objTable);
	    	
		    $(div_heart).appendTo($(objTd3));
		    $(objTd3).appendTo(objTr);

		    var objTr2 = $('<tr/>');
		    var objtd2_1 = $('<td/>',{'colspan':'2'});
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

$(document).ready(function(){
	  //window.location.hash = '#Friends';
	  var selectedUsers = [];
	  var k=GetParameterValues('notifications');
	  if(k==1){
		  $("#notifications").click();
		  initNotifications();
	  }
	  $("#prev").hide();
	  initSearch();
	  $(window).hashchange( function(){
			var hash = location.hash;
			switch(hash) {
		    case "#Friends":
		    	$("#frnds").click();
		    	 $("#prev").hide();
				  $('#Friend_placeholder').html("");
				  initFriendList(_startPosFriends,_endPosFriends); 
				break;
		    case "#SearchNewFriends":
		    	$("#mcontents").click();
		    	$("#prev").hide();
				  $('#Users_placeholder').html("");
				  initContactList(_startPos,_endPos);   
		        break;
		    case "#Notifications":
		    	$("#notifications").click();
		    	initNotifications();   
		        break;	        
		    default:
		    	//alert("This is default");
			}		
		})
	  $("#frnds").click(function(){
		 // $("#prev").hide();
		 // $('#Friend_placeholder').html("");
		 // initFriendList(_startPosFriends,_endPosFriends); 
		  window.location.hash = '#Friends';
	  });
	  
	  $("#mcontents").click(function(){
		 // $("#prev").hide();
		 // $('#Users_placeholder').html("");
		 // initContactList(_startPos,_endPos);   
		  window.location.hash = '#SearchNewFriends';
	  });
	  
	  $("#notifications").click(function(){
		 // initNotifications();   
		  window.location.hash = '#Notifications';
	  });
	  
	  $("#jqxwindow").hide();
	  $("#button_no").click(function () {
	         $("#jqxwindow").jqxWindow('close');
	     });
	  $(".cssSendMsg").hide();
	  $(".cssMultUser").show();
	  $("#msgDiv").hide();
	  
	  $(".cssMultUser").click(function(){
		   $(this).hide();
		   $("#msgDiv").show();
		   $(".chk").show();
	  });
	  $("#cancel_all").click(function () {
		   $("#msgDiv").hide();
		   $(".chk").hide();
		   $(".cssMultUser").show();
		   $(".selected").attr("checked", false);
	  });
	  
	$('#send_all').click(function(){
		$('#spinningSquaresG').show();
		var selectedFriends = 0;
		var message = $('#msg').val();
		var isSendEmail = $('#sendEmail').is(':checked');
		$('.selected').each(function(){
			selectedFriends = selectedFriends + "," + $(this).val(); 
		});
		sendMessage(selectedFriends, message, isSendEmail);
	});  
	
	$('.md-closeBtn').click(function(){
		$('#modal-advertisement').removeClass('md-show');
	});	
	
	$("#frndsTopDiv").click(function(){
		$("#MyFriendRequests").toggle("slow");
	});
	$("#msgsTopDiv").click(function(){
		$("#MyMessages").toggle("slow");
	});
	$("#refresh").click(function(){
		getMyAllMessages();
	});
});

function sendMessage(recipients, message, sendEmail){
	 var params ={recipients: recipients, message: message, sendEmail: sendEmail };
	 var flaskRequest = new Request();
	 flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.SEND_MESSAGE, params, 
	    function (data){
		   $("#msgDiv").hide();
		   $(".chk").hide();
		   $(".cssMultUser").show();
		   $(".selected").attr("checked", false);
	      	_flaskLib.showSuccessMessage('action-msg','Message sent');
	     } ,
	     function (data){
	    	 console.log("Error in sending message: " + data );
	      	_flaskLib.showErrorMessage('action-msg',"Error in sending message");
	     });
	 $('#spinningSquaresG').hide();
	 $('#modal-advertisement').removeClass('md-show');
}

function getMyAllMessages(){
	 var flaskRequest = new Request();
	 flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_My_ALL_MESSAGES,
	    function (data){
	      	renderMessageList(data);
	     } ,
	     function (data){
	    	 console.log("Error in getting Messages: " + data );
	 });
}


/*function getUnreadMessages(msg_lbl){
 var flaskRequest = new Request();
 flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_UNREAD_MESSAGES,
    function (data){
      	$(msg_lbl).addClass("unRdMsg");
     } ,
     function (data){
    	 console.log("Error in getting Messages: " + data );
     });
}*/

function setRead(messageId){
	var flaskRequest = new Request();
	var params = {messageId:messageId};
	flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.SET_READ, params, 
	function(data){},
	function(data){});		
}

function renderMessageList(obj){
	$('#MessageCount').html(obj.length);
	var divRow = "#MyMessages";
	var maxLength = 30;
	$(divRow).html("");
	$.each(obj,function(index,node){
	    var objTable = $('<table/>',{'class':'tblRow'});
	    var objTrMain = $('<tr/>');
	    var objTdPhoto = $('<td/>',{'style':'width:45px'});
	    var objTdContent = $('<td/>');
	    $(objTrMain).appendTo($(objTable));
	    $(objTdPhoto).appendTo($(objTrMain));
	    $(objTdContent).appendTo($(objTrMain));
		var objdiv = $('<div/>',{'class':'eventLogo'});
		//console.log(node.portraitId);
		renderPhoto(node.portraitId,objdiv);
		$(objdiv).appendTo($(objTdPhoto));
	    
	    var objTableText = $('<table/>',{'class':'tblContent','style':'width:100%'});
	    $(objTableText).appendTo($(objTdContent));
	    var objTr = $('<tr/>');
	    $(objTr).appendTo($(objTableText));
	    var userName_lbl = $('<label/>',{'class':'control-label-color','style':'margin-left:0px !important'});
	    $(userName_lbl).html(node.senderName);
	    var objTd1 = $('<td/>',{'data-id':node.messageId});
	    $(userName_lbl).appendTo($(objTd1));
	    $(objTd1).appendTo(objTr);
	    
	    var objTd3 = $('<td/>',{'align':'left','valign':'top','style':'font-size:12px;width: 100px;'});
	    var messageDate = moment(node.dateTime).toNow(true);
	    objTd3.html(messageDate+' ago')
	    $(objTd3).appendTo(objTr);
	    
	    var objTr2 = $('<tr/>');
	    $(objTr2).appendTo($(objTableText));
	    var objTd2 = $('<td/>',{'align':'left','valign':'top'});
	    var msg_lbl = $('<label/>', {'class':'unRdMsg'});
	    if(node.message.length>maxLength){
	    	$(msg_lbl).html(node.message.slice(0, maxLength)+"...");
	    }else{
	    	$(msg_lbl).html(node.message);
	    }
	    $(msg_lbl).appendTo($(objTd2));
	    $(objTd2).appendTo(objTr2);
	    var objTd4 = $('<td/>',{'class':'rplyBtn','align':'left','valign':'inherit', 'style':'text-align: -webkit-center; display: none;'});
	    var rplyBtn = $('<button/>', {'class':'reply-btn', 'style':'display: inline-block;'});
	    var iCon = $('<i/>', {'class':'icon-reply'});
	    $(iCon).appendTo($(rplyBtn));
	    $(rplyBtn).appendTo($(objTd4));
	    $(objTd4).appendTo(objTr2);
	    $(objTableText).appendTo($(objTdContent));
	    $(objTable).appendTo($(divRow));
	    if(node.read){
	    	$(msg_lbl).removeClass("unRdMsg");
	    }
	    $(objTable).click(function(){
	    	if(!node.read){
	    		var rwMsgId = $(objTd1).attr("data-id");
		    	setRead(rwMsgId);
		    	$(msg_lbl).removeClass("unRdMsg");
	    	}
	    	if($(msg_lbl).html().length<=(maxLength+3)){
	    		$(msg_lbl).html("");
	    		$(msg_lbl).html(node.message);
	    	}else{
	    		$(msg_lbl).html("");
	    		$(msg_lbl).html(node.message.slice(0, maxLength)+"...");
	    	}
	    	$('.rplyBtn').hide();
	    	$(objTd4).toggle("slow");
	    });
	    $(objTd4).click(function(){
	    	fnSendMessage(node.senderUserId);
	    });
	});
}

function renderPhoto(FileId,objProfilePic){
	var imgURL = "/webdav/flask/document_library/DefaultProfilePic";
	if(FileId>0){
		 var params = {fileEntryId: FileId};
		 var flaskRequest = new Request();
		 flaskRequest.sendGETRequest('/flask-rest-users-portlet.flaskadmin/get-my-file-entry',params,
		    function (data){
		    	 imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+data.uuid+"&groupId="+data.groupId;
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

Liferay.Portlet.ready(function(portletId, node) {
	if(portletId=='flasksocial_WAR_flasksocialportlet'){
		initFriendList(0,99);		
	}
});