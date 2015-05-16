var GlobalJSON_Admin;

YUI().use("io-base","aui-form-validator",function(Y) {
	var uri = '/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins';
    Y.on('io:complete', complete, Y, []);
    var request = Y.io(uri);
    new Y.FormValidator({boundingBox: '#adminForm'});
});

function complete(id, o, args) {
    var id = id; // Transaction ID.
    var data = o.responseText; // Response data.
    init();    
    $("#grid-basic").bootgrid("append",JSON.parse(data));	
};

function fnDelete(AdminId){
	alertify.confirm('Do you wish to delete this admin user?').set('onok', function(closeEvent){ 
	  	Liferay.Service('/flask-rest-users-portlet.flaskadmin/delete-flask-admins',
  		  {
  		    userId: AdminId
  		  },
  		  function(obj) {
  		    console.log(obj);
  		    closeEvent.cancel = true
  		    alertify.success('Admin user deleted!');
  		  }
  		);
	},""); 	
}

function fnSave(AdminId){
	var uri;
	if(AdminId > 0)
		uri = '/flask-rest-users-portlet.flaskadmin/update-flask-admin';
	else
		uri = '/flask-rest-users-portlet.flaskadmin/add-flask-admin'
		
	Liferay.Service(uri,
	  {
	    firstName: $("#firstName").val(),
	    middleName: $("#middleName").val(),
	    lastName: $("#lastName").val(),
	    email: $("#email").val(),
	    screenName: $("#screenName").val(),
	    password1: $("#password1").val(),
	    password2: $("#password2").val()
	  },
	  function(obj) {
	    switch(obj.responseText){
	    	case "com.liferay.portal.UserPasswordExeption":
	    		alert("Password does no matched");
	    		return false;
	    	default:
				$("#adminDataTable").show();
				$("#adminForm").hide();
				return false;	    			
	    }
	    return false;
	  });    	
}

function fnShowForm(AdminId){
	var objTemp;	
	console.log(GlobalJSON_Admin);
	 for (var i = 0; i < GlobalJSON_Admin.length; i++) {
         if (GlobalJSON_Admin[i].userId == AdminId) {
     	    $("#firstName").val(GlobalJSON_Admin[i].firstName);
    	    $("#middleName").val(GlobalJSON_Admin[i].middleName);
    	    $("#lastName").val(GlobalJSON_Admin[i].lastName);
    	    $("#email").val(GlobalJSON_Admin[i].email);
    	    $("#screenName").val(GlobalJSON_Admin[i].screenName);
    	    $("#password1").val(GlobalJSON_Admin[i].password1);
    	    $("#password2").val(GlobalJSON_Admin[i].password2);        	 
         }
    }
	$("#adminDataTable").hide();
	$("#adminForm").show();
}

$(document).ready(function(){
	$(".btn").click(function(){
		var btnType = $(this).val();
		switch (btnType) { 
		    case 'Add': 
		        $("#adminDataTable").hide();
		        $("#adminForm").show();
		        break;
		    case 'Save': 
		        return fnSave(0);
		        break;
		    case 'Cancel': 
		        //alert('Cancel Wins!');
		        break;      
		    default:
		        //alert('test');
			}	
		});
});

function init()
{
	$("#grid-basic").bootgrid({
        rowCount: [-1, 25, 50, 75]
    });
}


function fnPasswordReset(){
  alertify.confirm("Reset password?", function (e) {
    if (e) {
        secondconfirm();
    } else {
    	return false;
    }
  });
}

function secondconfirm() {
    setTimeout(function () {
        alertify.confirm("Password is changed<br>Mail it to the user?", function (e) {
            if (e) {
                //Done
                alertify.success("Password reset and mailed to user.");
            } else {
                // user clicked "cancel"
                alertify.success("Password reset.");
            }
        });
    }, 1000); // I went as low as 300 ms, but higher value is safer :)
    return true;
}

