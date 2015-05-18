var GlobalJSON_Admin;

YUI().use("io-base","aui-form-validator","aui-dropdown","aui-datepicker",function(Y) {
	var uri = '/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins';
    Y.on('io:complete', complete, Y, []);
    var request = Y.io(uri);
    var rules = {
    		name: {
    				name:true,
	        		required: true
    	      		},
    	      	scname: {
    				scname:true,
	        		required: true
    	      		},
    	      	lname: {
    				lname:true,
	        		required: true
    	      		},
    	      	password: {
	        		password: true,
	        		required: true
    	      		},
    	      	passwordConfirmation: {
	        		passwordConfirmation: true,
	        		equalTo: '#password',
	        		required: true
    	      		},
    	      	email: {
	        		email: true,
	        		required: true
    	      		},
    			Gender :{
					boundingBox: '#myDropdown',
					trigger: '#myTrigger'
    				},
    			zipcode: {
    				zipcode: true,
    				required: true
				}
    	    };    
    

    var fieldStrings = {
    		name: {
    			required: 'Please provide your name.'
         	},
        	lname: {
        		required: 'Please enter your last name.'
        	},
        	scname:{
        		required: 'Please enter your screen name.'
        	},
         	email: {
         		required: 'Type your Email in this field.'
         	},
         	password: {
         		required: 'Type your password in this field.'
         	},
        	passwordConfirmation: {
        		required: 'Please re-enter your password.'
        	},
        	zipcode:{
        		required: 'Please enter your Zipcode'
        	}
    };
    
    new Y.FormValidator({boundingBox: '#adminForm',
        fieldStrings: fieldStrings,
        rules: rules,
        showAllMessages: true});
});

function complete(id, o, args) {
    var id = id; // Transaction ID.
    var data = o.responseText; // Response data.
    GlobalJSON_Admin = JSON.parse(data);
    console.log(GlobalJSON_Admin);
    
    var theme = prepareSimulator("grid");

    var data = GlobalJSON_Admin;
    console.log("data"+GlobalJSON_Admin);
    var source =
    {
        localdata: data,
        datatype: "json",
        datafields:
        [
            { name: 'firstName', type: 'string' },
            { name: 'lastName', type: 'string' },
            { name: 'email', type: 'string' }
        ]
    };
    console.log("source"+source);
    var dataAdapter = new $.jqx.dataAdapter(source);
    
    var cellsrenderer = function (row, columnfield, value, defaulthtml, columnproperties) {
    	return '<i class="icon-wrench"></i>'
	}
    
    $("#grid").jqxGrid(
    {
        width: '100%',
        height: '100%',
        source: dataAdapter,
        theme: theme,
        columnsheight: 40,
        columnsmenuwidth: 40,
        rowsheight: 34,
        columns: [
          { text: 'First Name', dataField: 'firstName', width: '30%' },
          { text: 'Last Name', dataField: 'lastName', width: '30%'},
          { text: 'Email', dataField: 'email', width: '30%'},
          { text: ' ', cellsrenderer:cellsrenderer}
        ]
    });
    initSimulator("grid");
    // create context menu
    var contextMenu = $("#Menu").jqxMenu({ width: 200, height: 116, autoOpenPopup: false, mode: 'popup'});
    $("#grid").on('contextmenu', function () {
        return false;
    });

    $("#grid").bind('cellclick', function (event) {
        if (event.args.columnindex == 3) {
            var scrollTop = $(window).scrollTop();
            var scrollLeft = $(window).scrollLeft();
            editrow = event.args.rowindex;
            var rowsheight = $("#grid").jqxGrid('rowsheight');
            var top = $("#grid").offset().top + (2 + editrow) * rowsheight;
            var left = $("#grid").offset().left;
            $("#Menu").jqxMenu('open',left, top + 5 + scrollTop);
        };
    });    
    
    $("#Menu").on('itemclick', function (event) {
        var args = event.args;
        var rowindex = $("#grid").jqxGrid('getselectedrowindex');
        if ($.trim($(args).text()) == "Edit") {
            editrow = rowindex;
            fnShowForm(20897);
            return false;
        }
        else {
            var rowid = $("#jqxgrid").jqxGrid('getrowid', rowindex);
            $("#jqxgrid").jqxGrid('deleterow', rowid);
        }
    });
    
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

