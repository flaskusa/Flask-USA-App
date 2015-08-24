var emailForm;
var isProper = true;
var EMAIL = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
var noOfInvitations = 5;
function addClickHandlers(){
	emailForm = $("#emailNotificationForm");
	/*	Initialize display elements*/
	
	$(".clsSave").click(function(){
//		if(emailForm.jqxValidator('validate'))
		saveAndSendNotifications();
	});
	
	$(".clsCancel").click(function(){
		emailForm.trigger('reset');
	});
	$(".clsAdd5More").click(function(){
		add5moreRows();
	});
	
}
function add5moreRows(){
	for(var i=noOfInvitations+1 ; i <= noOfInvitations+5;i++){
		var invitationDiv = '<div class="control-group">';
		invitationDiv = invitationDiv + '<label class="control-label" for="textinput">'+i+'</label>';
		invitationDiv = invitationDiv + '<div class="controls">';
		invitationDiv = invitationDiv + '<input id="name'+i+'" name="<portlet:namespace />textinput" type="text" placeholder="Enter Name" class="input-medium">';
		invitationDiv = invitationDiv + '<input id="email'+i+'" name="<portlet:namespace />textinput" type="text" placeholder="Enter Email Address" class="input-large">';
		invitationDiv = invitationDiv + "</div></div>";
		$(".divHeight").append(invitationDiv);
	}
	noOfInvitations +=5;
}
function saveAndSendNotifications(){
	prepareParam();
	if(isProper)
	emailForm.trigger('reset');
}

function prepareParam(){
	for(var i=1; i <=noOfInvitations; i++){
		var params = {};
		var name = $.trim($("#emailNotificationForm #name"+i).val());
		var email = $.trim($("#emailNotificationForm #email"+i).val());
		var description = $.trim($("#emailNotificationForm #description").val());
		var date = new Date();
		var invitedDate = date.getMonth()+"/"+date.getDate()+"/"+date.getFullYear();
		params["name"] = name;
		params["email"] = email;
		params["description"] = description;
		params["invitedDate"] = invitedDate;
		if(email != "" || email){
			if(EMAIL.test(email)){
				sendInvitation(params);
				isProper = true;
			}else{
				_flaskLib.showErrorMessage('invitation-msg', _invitationInfoModel.MESSAGES.INVALID_EMAIL);
				isProper = false;
			}
		} 
	}
}

/* Save and Send Invitation */
function sendInvitation(params){
		var flaskRequest = new Request();
		var url = "";
				url =_invitationInfoModel.SERVICE_ENDPOINTS.SEND_INVITATION;
		flaskRequest.sendGETRequest(url, params, 
					function (data){
						_flaskLib.showSuccessMessage('invitation-msg', _invitationInfoModel.MESSAGES.SEND);
					} ,
					function (data){
						_flaskLib.showErrorMessage('invitation-msg', _invitationInfoModel.MESSAGES.ERROR);
					});
}
