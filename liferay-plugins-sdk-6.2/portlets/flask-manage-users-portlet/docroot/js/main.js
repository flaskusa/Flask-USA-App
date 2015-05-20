var GlobalJSON_Admin = [];

function fnLoadAdminUserList() {
	var params = "";
	var request = new Request();
	request.sendGETRequest(SERVICE_ENDPOINTS.GET_FLASK_ADMIN_ENDPOINT, params,
			function(data) {
				if (data.responseStatus == 1) {
					GlobalJSON_Admin = data.responseJson;
					fnRenderGrid(GlobalJSON_Admin);
					$("#adminForm").hide();
				} else {
					alert("MESSAGES.ERRORR_REGISTER_USER");
				}
			});
}

function fnDelete(AdminId) {
	Liferay.Service('/flask-rest-users-portlet.flaskadmin/delete-flask-admins',
			{
				userId : AdminId
			}, function(obj) {
				closeEvent.cancel = true
			});
}

function fnSave(){
	var params =  {
		firstName : $("#firstName").val(),
		middleName : $("#middleName").val(),
		lastName : $("#lastName").val(),
		isMale: true,
		screenName : $("#screenName").val(),
		email : $("#email").val(),
		DOB:  '05-10-2015',
		streetName: $("#streetName").val(),
		aptNo: $("#aptNo").val(),
		areaCode: $("#areaCode").val(),
		city: $("#city").val(),
		state: $("#state").val(),
		country: $("#country").val(),
		password1 : $("#password").val(),
		password2 : $("#passwordConfirmation").val(),
		mobileNo: $("#mobileNo").val(),
		userInterests: "{sports: true}"		
	};
	alert("Show Spin");
	$("#spinningSquaresG").show();	
	console.log('insave');
	console.log(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT);
	Liferay.Service(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT,params,
	 function(obj) {
	   console.log(obj);
	 });
	console.log('end insave');
	$.wait( function(){ fnLoadAdminUserList(); $("#spinningSquaresG").hide();}, 3);	
	
	alert("Hide Spin");
}

function fnShowForm(rowIndex) {
	var objTemp;
	console.log(GlobalJSON_Admin);
	$("#firstName").val(GlobalJSON_Admin[rowIndex].firstName);
	$("#middleName").val(GlobalJSON_Admin[rowIndex].middleName);
	$("#lastName").val(GlobalJSON_Admin[rowIndex].lastName);
	$("#email").val(GlobalJSON_Admin[rowIndex].email);
	$("#screenName").val(GlobalJSON_Admin[rowIndex].screenName);
	$("#password").val(GlobalJSON_Admin[rowIndex].password1);
	$("#passwordConfirmation").val(GlobalJSON_Admin[rowIndex].password2);
	
	$("#grid").hide();
	$("#adminForm").show();
}

function fnPasswordReset() {
	alert("fnPasswordReset");
}

function fnRenderGrid(tdata) {
	var source = {
		localdata : tdata,
		datatype : "json",
		datafields : DATA_SOURCE.GET_FLASK_ADMIN_GRID
	};

	var dataAdapter = new $.jqx.dataAdapter(source);
	console.log(source);
	var cellsrenderer = function(row, columnfield, value, defaulthtml,
			columnproperties) {
		return '<i class="icon-wrench"></i>'
	}

	$("#grid").jqxGrid({
		width : '100%',
		height : '100%',
		source : dataAdapter,
		theme : APP_CONFIG.JQX_THEME,
		columnsheight : 40,
		columnsmenuwidth : 40,
		rowsheight : 34,
		columns : [ {
			text : 'First Name',
			dataField : 'firstName',
			width : '33%'
		}, {
			text : 'Last Name',
			dataField : 'lastName',
			width : '33%'
		}, {
			text : 'Email',
			dataField : 'email',
			width : '30%'
		}, {
			text : ' ',
			cellsrenderer : cellsrenderer
		} ]
	});
	// create context menu
	var contextMenu = $("#Menu").jqxMenu({
		width : 200,
		height : 116,
		autoOpenPopup : false,
		mode : 'popup'
	});
	$("#grid").on('contextmenu', function() {
		return false;
	});

	$("#grid").bind('cellclick', function(event) {
		if (event.args.columnindex == 3) {
			var scrollTop = $(window).scrollTop();
			var scrollLeft = $(window).scrollLeft();
			editrow = event.args.rowindex;
			var rowsheight = $("#grid").jqxGrid('rowsheight');
			var top = $("#grid").offset().top + (2 + editrow) * rowsheight;
			var left = $("#grid").offset().left;
			$("#Menu").jqxMenu('open', left, top + 5 + scrollTop);
		}
		;
	});

	$("#Menu").on('itemclick', function(event) {
		var args = event.args;
		var rowindex = $("#grid").jqxGrid('getselectedrowindex');
		if ($.trim($(args).text()) == "Edit") {
			fnShowForm(rowindex);
			return false;
		} else {
			var rowid = $("#grid").jqxGrid('getrowid', rowindex);
			$("#grid").jqxGrid('deleterow', rowid);
		}
	});
	$("#grid").show();
}

$(document).ready(function() {
	$("#spinningSquaresG").show();
	fnLoadAdminUserList();
	$(".btn").click(function() {
		var btnType = $(this).val();
		switch (btnType) {
		case 'Add':
			$(this).hide();
			$("#grid").hide();
			$("#adminForm").show();
			break;
		case 'Cancel':
			// alert('Cancel Wins!');
			break;
		default:
			// alert('test');
		}
	});
	$("#spinningSquaresG").hide();
});

YUI().use("aui-form-validator","aui-dropdown","aui-datepicker","aui-tree-view",function(Y) {
	  var rules = { firstName: { firstName:true, required: true }, screenName: { screenName:true,
	  required: true }, lastName: { lastName:true, required: true }, password1: {password1: true, required: true }, email: {email: true, required: true},
	  password2: { password2: true, equalTo: '#password1', required: true }, gender:{ gender:true, required: true }, mobileNo: {mobileNo: true, required: true, digits: true},
	  areaCode: { areaCode: true,required: true} };
	  
	  
	  var fieldStrings = { firstName: { required: 'Please provide your name.' }, lastName: {
	  required: 'Please enter your last name.' }, screenName:{ required: 'Please enter  your screen name.' }, 
	  gender:{ required: 'Please Select your gender.' },
	  email: { required: 'Type your Email in this field.' },
	  password1: { required: 'Type your password in this field.' },
	  password2: { required: 'Please re-enter your password.' },
	  areaCode: {required: 'Please enter your Zipcode'},
	  mobileNo: {required: 'Please enter your Mobile Number'}};
	  
	 new Y.FormValidator({boundingBox: '#adminForm', fieldStrings: fieldStrings,
	 rules: rules, showAllMessages: true});
});

$.wait = function( callback, seconds){
	console.log("start>>"+callback);
	return window.setTimeout( callback, seconds * 1000 );
	console.log("finish>>"+callback)
}

$(document).ready(function () {
     $(document).ready(function () {
         // Create jqxTree
         $('#userInterests').jqxTree({theme:"base",hasThreeStates:true, checkboxes:true, height: '300px', width: '100%' });
         $("#userInterests").on('change',function(event){
        	 var Items = $("#userInterests").jqxTree('getItems');
        	 var ItemArray = new Array();
        	 $.each(Items, function () {
                 if (this.checked) {
                	 var tempid = "#"+this.id;
                	 ItemArray.push($(tempid).attr("data-id"));
                 };
             });
        	 console.log(ItemArray);
         });
     });     
});