var RepositoryID;
var FolderId;
var adminForm;
var portraitURL = 0;
function addClickHandlers(){
	adminForm = $("#adminForm");
	/*	Initialize display elements*/
	
	$(".cssDelete").hide();	
	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
		adminForm.trigger('reset')
		$("#adminDataTable").hide();
		adminForm.show();
		_flaskLib.loadCountries('countryId');
		_flaskLib.loadUSARegions('stateId');
		loadFlaskRoles('roleId');
	});

	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		if(portletId == "myaccount_WAR_flaskmanageusersportlet"){
			saveAccount();
		}else{
			saveAdmin();
		}
	});


	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
		$("#adminDataTable").show();
		adminForm.hide();
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
		var adminList = GRID_PARAM.getCheckedIdList();
		if(adminList.length > 0){
			deleteMultipleAdmins(adminList) ;	
		}
		 $(".cssDelete").hide();	
		 $(".cssDelUser").show();	
		 GRID_PARAM.toggleSelectionMode();
    });

	/*	Toggle search boxes */
	$(".cssSearchUser").click(GRID_PARAM.toggleSearchBoxes);			
	
	$("#countryId").change(function() {
		_flaskLib.loadRegions('stateId', $("#countryId").val());
    });		
}

$(document).ready(function () {
	  // initialize validator.
    $("#jqxwindow").jqxWindow({ height: 175, width: 370, theme: 'custom', isModal: true, autoOpen: false });
    $("#popup").click(function () {
        $("#jqxwindow").jqxWindow('open');
    });
    fillFlaskRoles('roleId1');
});

function loadData(){
	
	 $('#adminForm').jqxValidator
	    ({
	        hintType: 'label',
	        animationDuration: 0,
	        rules: [
	               { input: '#firstName', message: 'First name is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#lastName', message: 'Last name is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#mobileNumber', message: 'Mobile number is required!', action: 'keyup, blur', rule: 'required' },
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
	params = {};
	flaskRequest.sendGETRequest(_adminModel.SERVICE_ENDPOINTS.GET_ADMIN, params, 
	function(data){/*success handler*/
		GRID_PARAM.updateGrid(data);
		/*Upload file code*/
		RepositoryID = $("#repositoryId").val();
		FolderId = 0;
		var wrapper = $('<div/>').css({height:0,width:0,'overflow':'hidden'});
		var fileInput = $('#fileinput').wrap(wrapper);	
		$('#ProfilePic').click(function(){
		    fileInput.click();
		}).show();
		fileInput.change(function(){
			fnDeleteFileEntry(portraitURL);
			fileUpload();
		});
		
		/*Upload File Code End*/
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage(_adminModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
	
}

function fileUpload(){

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
		    		/*Service call [Start]*/
		        	Liferay.Service(
		       			  '/flask-rest-users-portlet.flaskadmin/add-my-file-entry',
		       			  {
		       			    repositoryId: $("#repositoryId").val(),
		       			    folderId: 0,
		       			    sourceFileName: input.files[j].name,
		       			    mimeType: input.files[j].type,
		       			    title: input.files[j].name,
		       			    description: input.files[j].name,
		       			    changeLog: '1',
	       			    	bytes: markup
		       			  },
		       			  function(obj) {
		       			    if(typeof obj =='object')
		       			 		$("#fileEntryId").val(obj.fileEntryId);
		       			    	renderPhoto(obj.fileEntryId); //call back function
		       			  	}
		       			); 
		        	/*Service call [End]*/			    		
		        }
             j++;
             if (j == k){
                 console.log('All files read');
             }
         }};
     reader.readAsBinaryString(input.files[i]);
 	}
}

function contextMenuHandler(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		editAdmin(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteAdmin(rowData.userId);
		}
		return false;			
	}else if(menuItemText == "Change Role"){
		fillFlaskRoles('roleId1', rowData.roleId);
		pop_window(rowData.userId,rowData.roleId);
		console.log(rowData.userId);
		return false;
	}
};

function pop_window(uid,rid) {
	console.log(rid);
	console.log(roleId1);
    $("#button_input").click(function () {
    	setFlaskRoles(uid,$('#roleId1').val());
    	//alert($('#userId').val());
    	//alert($('#roleId1').val());
        $("#jqxwindow").jqxWindow('close');
    });
    $("#button_no").click(function () {
        $("#jqxwindow").jqxWindow('close');
    });
}

function deleteAdmin(adminId) {
	var param = {'userId': adminId};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_adminModel.SERVICE_ENDPOINTS.DELETE_ADMIN, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', _adminModel.MESSAGES.DEL_SUCCESS);
							loadData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _adminModel.MESSAGES.DEL_ERR);
					});
	
}

function deleteMultipleAdmins(adminList) {
	for(var i=0;i<adminList.length;i++)
	{
		var temp = adminList[i].userId;
		deleteAdmin(temp);
	}	
}

function editAdmin(rowData) {
	_flaskLib.loadDataToForm("adminForm",  _adminModel.DATA_MODEL.ADMIN, rowData, function(){	
	});
	$("#adminDataTable").hide();
	adminForm.show();
	_flaskLib.loadCountries('countryId', rowData.countryId);
	_flaskLib.loadUSARegions('stateId', rowData.stateId);
	loadFlaskRoles('roleId', rowData.roleId);
	portraitURL = rowData.portraitURL;
	renderPhoto(rowData.portraitURL);
	fnSetCheckBoxSelected(rowData.userInterests);
	renderPhotoEditMode(rowData.userId);
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
	console.log(strCheckList);
	tempArray = strCheckList.split("#");
	var i;
	for (i = 0; i < tempArray.length; i++) {
		var tempObj = "#" + tempArray[i];
		$(".userInterests").jqxTree('checkItem', $(tempObj)[0], true);
	}
}

function saveAdmin(){
	params = _flaskLib.getFormData('adminForm',_adminModel.DATA_MODEL.ADMIN,
				function(formId, model, formData){
						if($(".gender").val()=="Male"){formData.isMale=true;}
						else{formData.isMale=false;}
						formData.userInterests= fnGetCheckBoxSelected();
						return formData;
				});
	var flaskRequest = new Request();
	var url = ""
		if(params.userId == 0){
			url = _adminModel.SERVICE_ENDPOINTS.ADD_ADMIN;
		}else{
			url =_adminModel.SERVICE_ENDPOINTS.UPDATE_ADMIN;
		}
	//console.log(params);
	//console.log(params.isMale);
	//console.log(params.userInterests);
	console.log(params.userId);
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _adminModel.MESSAGES.SAVE);
					loadData();
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _adminModel.MESSAGES.ERROR);
				});

}

/* Need to change below code as per standard  */
function fnUpdateProfilePic(uid){
	console.log("i m in upload");
	 Liferay.Service(
	    '/flask-rest-users-portlet.flaskadmin/get-my-file-entry',
	    {
	      fileEntryId: $("#fileEntryId").val()
	    },
	    function(objFile) {
	    	if(objFile.fileEntryId==0){
	    		fileUpload();
	    	}
	    	else{
	    		Liferay.Service(
		       			  '/flask-rest-users-portlet.flaskadmin/delete-my-file-entry',
		       			  {
		       				fileEntryId: $("#fileEntryId").val()
		       			  },
		       			  function(obj) {
		       			  	}
		       			); 
	    		Liferay.Service(
		       			  '/flask-rest-users-portlet.flaskadmin/add-my-file-entry',
		       			  {
		       			    repositoryId: $("#repositoryId").val(),
		       			    folderId: 0,
		       			    sourceFileName: input.files[j].name,
		       			    mimeType: input.files[j].type,
		       			    title: input.files[j].name,
		       			    description: input.files[j].name,
		       			    changeLog: '1',
	       			    	bytes: markup
		       			  },
		       			  function(obj) {
		       				  console.log(obj);
		       			    if(typeof obj =='object')
		       			 		$("#fileEntryId").val(obj.fileEntryId);
		       			    	renderPhoto(obj.fileEntryId); //call back function
		       			  	}
		       			); 
	    	}
       
	    }
	 ); 
	}

function fnDeleteFileEntry(portraitURL){
	Liferay.Service(
 			  '/flask-rest-users-portlet.flaskadmin/delete-my-file-entry',
 			  {
 				fileEntryId: portraitURL
 			  },
 			  function(obj) {
 			  	}
 			); 
}

function renderPhoto(FileId){
	 Liferay.Service('/flask-rest-users-portlet.flaskadmin/get-my-file-entry',
	     {
	       fileEntryId: FileId
	     },
	     function(obj) {
	      var url = "/documents/"+RepositoryID+"/0/"+obj.title;
	      $("#ProfilePic").css("background-image","url('"+url+"')");
	     }
	 );
	}
	function renderPhotoEditMode(FileId){
	   var url = "/documents/"+RepositoryID+"/0/"+FileId;
	   $("#ProfilePic").css("background-image","url('"+url+"')")
	}
	
	function loadFlaskRoles(elementId, selectedId){
			var param = {};
			var request = new Request();
			var selectList = $('#' + elementId);
			var flaskRequest = new Request();
			flaskRequest.sendGETRequest(_adminModel.SERVICE_ENDPOINTS.GET_ROLES, param, 
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
		flaskRequest.sendGETRequest(_adminModel.SERVICE_ENDPOINTS.GET_ROLES, param, 
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
		console.log(uId);
		var param ={userId: uId, roleId: selectedId };
		var flaskRequest = new Request();
		console.log(param.userId);
		flaskRequest.sendGETRequest(_adminModel.SERVICE_ENDPOINTS.SET_ROLES, param, 
					function (data){
						console.log(data);
						} ,
						function (data){
							console.log("Error in setting role: " + data );
						});

	}
	