var RepositoryID;
var FolderId;
var adminForm;
var portraitURL = 0;
function addMyAccClickHandlers(){
	adminForm = $("#adminForm");
	/*	Initialize display elements*/
	
	
	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		if ($('#adminForm').jqxValidator('validate'))
			saveAccount();
	});

	$(".clsCancel").click(function(){
		window.location.assign("/web/flask/events");
	});
	
	$("#countryId").change(function() {
		_flaskLib.loadRegions('stateId', $("#countryId").val());
    });		
}

$(document).ready(function () {
	  // initialize validator.
	 $("#jqxwindow").jqxWindow({ height: 168, width: 370, theme: 'custom', isModal: true, autoOpen: false });
	    $("#popup").click(function () {
	        $("#jqxwindow").jqxWindow('open');
	    });
    fillFlaskRoles('roleId1');
});

function loadForm(){
	var userId = Liferay.ThemeDisplay.getUserId();
	 $('#adminForm').jqxValidator
	    ({
	        hintType: 'label',
	        animationDuration: 0,
	        rules: [
	               { input: '#firstName', message: 'First name is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#lastName', message: 'Last name is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#screenName', message: 'Screen name is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#areaCode', message: 'Zip code is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#password1', message: 'Password is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#password2', message: 'Password is required!', action: 'keyup, blur', rule: 'required' },
	               {
	                   input: '#password2', message: 'Passwords doesn\'t match!', action: 'keyup, focus', rule: function (input, commit) {
	                       // call commit with false, when you are doing server validation and you want to display a validation error on this field. 
	                       if (input.val() === $('#password1').val()) {
	                           return true;
	                       }
	                       return false;
	                   }
	               },
	               { input: '#email', message: 'E-mail is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#email', message: 'Invalid e-mail!', action: 'keyup', rule: 'email' }]
	    });
	
	var flaskRequest = new Request();
	params = { userId: userId };
	flaskRequest.sendGETRequest(_userModel.SERVICE_ENDPOINTS.GET_LOGGED_IN_USER, params, 
	function(data){/*success handler*/
		editUser(data);
		/*Upload file code*/
		RepositoryID = $("#repositoryId").val();
		FolderId = 0;
		var wrapper = $('<div/>').css({height:0,width:0,'overflow':'hidden'});
		var fileInput = $('#fileinput').wrap(wrapper);	
		$('#ProfilePic').click(function(){
		    fileInput.click();
		}).show();
		fileInput.change(function(){
			myAccFileUpload();
		});
		/*Upload File Code End*/
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage(_userModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
	
}

function editUser(rowData) {
	_flaskLib.loadDataToForm("adminForm",  _userModel.DATA_MODEL.ADMIN, rowData, function(){	
	});
	//$("#adminDataTable").hide();
	adminForm.show();
	_flaskLib.loadCountries('countryId', rowData.countryId);
	_flaskLib.loadUSARegions('stateId', rowData.stateId);
	var date = new Date(rowData.DOB);
	 var dd = date.getDate()
	   if ( dd < 10 ) dd = '0' + dd;
	   var mm = date.getMonth()+1;
	   if ( mm < 10 ) mm = '0' + mm;
	   var yy = date.getFullYear();
	//$('#DOB').val(mm+'-'+dd+'-'+yy);
	$('#DOB').combodate('setValue', mm+'-'+dd+'-'+yy);
	loadFlaskRoles('roleId', rowData.roleId);
	portraitURL = rowData.portraitURL;
	renderPhoto(rowData.userId);
	fnSetCheckBoxSelected(rowData.userInterests);
}

function fnGetCheckBoxSelected() {
	var ItemArray = new Array();
	$(".userInterests").each(function(){
		var Items = $(this).jqxTree('getItems');
		$.each(Items, function() {
			if (this.checked) {
				var tempid = "#" + this.id;
				ItemArray.push($(tempid).attr("id"));
			};
		});
	});
	console.log(ItemArray.join("#"));
	return ItemArray.join("#");
}

function fnSetCheckBoxSelected(strCheckList) {
	var tempArray = new Array();
	tempArray = strCheckList.split("#");
	var i;
	for (i = 0; i < tempArray.length; i++) {
		var tempObj = "#" + tempArray[i];
		$(".userInterests").jqxTree('checkItem', $(tempObj)[0], true);
	}
}

function saveAccount(){
	params = _flaskLib.getFormData('adminForm',_userModel.DATA_MODEL.ADMIN,
			function(formId, model, formData){
					if($(".gender").val()=="Male"){formData.isMale=true;}
					else{formData.isMale=false;}
					formData.userInterests= fnGetCheckBoxSelected();
					return formData;
			});
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_userModel.SERVICE_ENDPOINTS.UPDATE_USERS, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _userModel.MESSAGES.USER_SAVE);
					$("#fileEntryId").val(data.portraitId);
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _userModel.MESSAGES.USER_ERROR);
				});

}

function myAccFileUpload(){
    var input = document.getElementById('fileinput');
    var file;
	var reader = new FileReader();
	var markup, result, n, aByte;
	var data = new Object;
    var j = 0, k = input.files.length;
    for (var i = 0; i < k; i++) {
        var reader = new FileReader();
        reader.onloadend = function (evt) {
       	 markup=[];
            if (evt.target.readyState == FileReader.DONE) {
           	 for (n = 0; n < evt.target.result.length; ++n) {
		            aByte = evt.target.result.charCodeAt(n);
		            markup.push(aByte);
		        }			    	
		    	if(markup.length > 0){   
		    		var userId = $("#userId").val();
		    		Liferay.Service(
		    			     '/flask-rest-users-portlet.flaskadmin/delete-my-file-entry',
		    			     {
		    			    	 userId: parseInt(userId)
		    			     },
		    			     function(obj) {
		    			       console.log(obj);
		    			       Liferay.Service(
		    			    		'/flask-rest-users-portlet.flaskadmin/add-my-file-entry',
		   		       			  {
		   		        			userId : userId,
		   		       			    repositoryId: $("#repositoryId").val(),
		   		       			    folderId: 0,
		   		       			    sourceFileName: input.files[0].name,
		   		       			    mimeType: input.files[0].type,
		   		       			    title: userId+"_"+input.files[0].name,
		   		       			    description: userId+"_"+input.files[0].name,
		   		       			    changeLog: '1',
		   	       			    	bytes: markup
		   		       			  },
		   		       			  function(obj) {
		   			       				$("#ProfilePic").css("background-image","url('')");
		   			       				console.log("obj: ");
		   			       				console.log(obj);
		   			       			 	$("#fileEntryId").val(obj.fileEntryId);
		   				       			setTimeout(function(){
		   				       				renderPhoto(userId); //call back function
		   				       			}, 1500);
		   			       			    //
		   		       			  	}
		   		       			); 
		    			     }
		    			   );
	    				    		
		        }
             j++;
             if (j == k){
                 console.log('All files read');
             }
         }};
     reader.readAsBinaryString(input.files[i]);
 	}
}

/* Need to change below code as per standard  */

	function renderPhoto(userId){
		 Liferay.Service('/flask-rest-users-portlet.flaskadmin/get-my-file-entry',
		     {
		       userId: userId
		     },
		     function(obj) {
		      console.log(obj);
		      var url = "/documents/"+RepositoryID+"/0/"+obj.title;
		      $("#ProfilePic").css("background-image","url('')");
		      $("#ProfilePic").css("background-image","url('"+url+"')");
		      console.log(obj);
		     }
		 );
		}
	
	function loadFlaskRoles(elementId, selectedId){
			var param = {};
			var request = new Request();
			var selectList = $('#' + elementId);
			var flaskRequest = new Request();
			flaskRequest.sendGETRequest(_userModel.SERVICE_ENDPOINTS.GET_ROLES, param, 
							function (data){
									selectList.empty();
									$.each(data, function(key, role) {
										selectList.append($("<option/>", {
									        value: role.roleId,
									        text: role.roleName
									    }));
									});
									selectList.val(selectedId);
							} ,
							function (data){
								console.log("Error in getting role list: " + data );
							});
	
	}
	
	function fillFlaskRoles(elementId, selectedId){
		var param = {};
		var request = new Request();
		var selectList = $('#' + elementId);
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(_userModel.SERVICE_ENDPOINTS.GET_ROLES, param, 
						function (data){
								selectList.empty();
								//alert("List filled role");
								$.each(data, function(key, role) {
									selectList.append($("<option/>", {
								        value: role.roleId,
								        text: role.roleName
								    }));
								});
								selectList.val(selectedId);
								//alert(selectedId);
						} ,
						function (data){
							console.log("Error in getting role list: " + data );
						});

	}
	
	function setFlaskRoles(uId, selectedId){
		var param ={userId: uId, roleId: selectedId };
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(_userModel.SERVICE_ENDPOINTS.SET_ROLES, param, 
					function (data){
						console.log(data);
						} ,
						function (data){
							console.log("Error in setting role: " + data );
						});

	}