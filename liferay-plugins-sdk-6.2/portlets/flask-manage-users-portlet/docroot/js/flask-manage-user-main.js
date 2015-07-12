var RepositoryID;
var FolderId;
var adminForm;
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
		saveAdmin();
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
				    	console.log(markup);
				    	if(markup.length > 0){   
				    		/*Service call [Start]*/
				        	Liferay.Service(
				       			  '/dlapp/add-file-entry',
				       			  {
				       			    repositoryId: RepositoryID,
				       			    folderId: FolderId,
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
				        	/*Service call [End]*/			    		
				        }
				     console.log(j);
	                 j++;
	                 if (j == k){
	                     console.log('All files read');
	                 }
	             }};
	         reader.readAsBinaryString(input.files[i]);
	     	}			
		})		
		/*Upload File Code End*/
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage(_adminModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
	
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
	}
};

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
	fnUpdateProfilePic(rowData.userId);
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
					fnUpdateProfilePic(data.userId);
					loadData();
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _adminModel.MESSAGES.ERROR);
				});

}

/* Need to change below code as per standard  */
function fnUpdateProfilePic(uid){
	 Liferay.Service(
	    '/dlapp/get-file-entry',
	    {
	      fileEntryId: $("#fileEntryId").val()
	    },
	    function(objFile) {
		   Liferay.Service(
		       '/dlapp/update-file-entry',
		       {
		         fileEntryId: objFile.fileEntryId,
		         sourceFileName:uid,
		         mimeType:objFile.mimeType,
		         title: uid,
		         description:uid,
		         changeLog: objFile.createDate,
		         majorVersion: false,
		         bytes: null
		       },
		       function(obj) {
		         console.log(obj);
		         console.log(objFile);
		       }
		    );       
	    }
	 ); 
	}

	function fnDeleteFileEntry(uid){
	 Liferay.Service(
	     '/dlapp/delete-file-entry',
	     {
	       fileEntryId: uid
	     },
	     function(obj) {
	       console.log(obj);
	     }
	   );
	}

	function renderPhoto(FileId){
	 Liferay.Service('/dlapp/get-file-entry',
	     {
	       fileEntryId: FileId
	     },
	     function(obj) {
	      console.log(obj);
	      var url = "/documents/"+RepositoryID+"/0/"+obj.title;
	      $("#ProfilePic").css("background-image","url('"+url+"')")
	      console.log(obj);
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