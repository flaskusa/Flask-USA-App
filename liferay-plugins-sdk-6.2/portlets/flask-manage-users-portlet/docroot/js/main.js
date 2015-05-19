var GlobalJSON_Admin;

function fnLoadAdminUserList() {
	$("spinningSquaresG").show();
	var params = "";
	var request = new Request();
	request.sendGETRequest(SERVICE_ENDPOINTS.GET_FLASK_ADMIN_ENDPOINT, params,
			function(data) {
				if (data.responseStatus == 1) {
					GlobalJSON_Admin = data.responseJson;
					$("#grid").show();
					fnRenderGrid(GlobalJSON_Admin);
					$("#adminForm").hide();
				} else {
					alert("MESSAGES.ERRORR_REGISTER_USER");
				}
			});
	$("spinningSquaresG").hide();
}

function fnDelete(AdminId) {
	Liferay.Service('/flask-rest-users-portlet.flaskadmin/delete-flask-admins',
			{
				userId : AdminId
			}, function(obj) {
				closeEvent.cancel = true
				alertify.success('Admin user deleted!');
			});
}

function fnSave(AdminId) {
	$("spinningSquaresG").show();
	var uri;
	if (AdminId > 0)
		uri = SERVICE_ENDPOINTS.UPDATE_FLASK_ADMIN_ENDPOINT;
	else
		uri = SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT;

	var params = [ {
		firstName : $("#firstName").val(),
		middleName : $("#middleName").val(),
		lastName : $("#lastName").val(),
		email : $("#email").val(),
		screenName : $("#screenName").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val()
	} ];
	var request = new Request();
	request.sendPOSTRequest(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT, params,
			function(data) {
				if (!data.responseJson.exception) {
					GlobalJSON_Admin = data.responseJson;
					fnRenderGrid(GlobalJSON_Admin);
					$("#adminForm").hide();
				} else {
					console.log(data.responseJson.exception + " - "
							+ data.responseJson.message);
					alert("Service failed [Lookout console for more details]");
				}
			});
	$("spinningSquaresG").hide();
	/*
	 * Liferay.Service(uri, { firstName: $("#firstName").val(), middleName:
	 * $("#middleName").val(), lastName: $("#lastName").val(), email:
	 * $("#email").val(), screenName: $("#screenName").val(), password1:
	 * $("#password1").val(), password2: $("#password2").val() }, function(obj) {
	 * console.log(obj); $("#grid").show(); LoadAdminUserList();
	 * $("#adminForm").hide(); return false; });
	 */
}

function fnShowForm(AdminId) {
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
			editrow = rowindex;
			fnShowForm(20897);
			return false;
		} else {
			var rowid = $("#grid").jqxGrid('getrowid', rowindex);
			$("#grid").jqxGrid('deleterow', rowid);
		}
	});
	$("#grid").show();
}

$(document).ready(function() {

	fnLoadAdminUserList();
	$(".btn").click(function() {
		$("spinningSquaresG").show();
		var btnType = $(this).val();
		switch (btnType) {
		case 'Add':
			$(this).hide();
			$("#grid").hide();
			$("#adminForm").show();
			break;
		case 'Save':
			return fnSave(0);
			break;
		case 'Cancel':
			// alert('Cancel Wins!');
			break;
		default:
			// alert('test');
		}
	});
	$("spinningSquaresG").hide();
});

YUI().use('aui-tree-view',function(Y) {
	var children = [{//We can have more child under this node
                  children: [{label: 'Professional' , leaf: true, type: 'task'},
                             {label: 'College' , leaf: true, type: 'task'},
                             {label: 'We can have more child under this node' , leaf: true, type: 'task'}],
                             expanded: true,
                             label: 'Sports',
                             type: 'task'
                	},{
                  children: [{label: 'COUNTRY' , leaf: true, type: 'task'},
                             {label: 'POP' , leaf: true, type: 'task'},
                             {label: 'ROCK' , leaf: true, type: 'task'},
                             {label: 'RAP' , leaf: true, type: 'task'},
                             {label: 'ALTERNATIVE' , leaf: true, type: 'task'},
                             {label: 'ELECTRONIC' , leaf: true, type: 'task'}],
                             expanded: true,
                             label: 'Concerts',
                             type: 'task'},{
                     children: [{label: 'Comedy' , leaf: true, type: 'task'}],
                                expanded: true,
                                label: 'Special Eevnts',
                                type: 'task'
                             }
                 ];
			
              // Create a TreeView Component
              new Y.TreeView(
                {
                  boundingBox: '#myTreeView',
                  children: children
                }
              ).render();
});
/*
 * YUI().use("aui-form-validator","aui-dropdown","aui-datepicker",function(Y) {
 * var rules = { name: { name:true, required: true }, scname: { scname:true,
 * required: true }, lname: { lname:true, required: true }, password: {
 * password: true, required: true }, passwordConfirmation: {
 * passwordConfirmation: true, equalTo: '#password', required: true } };
 * 
 * 
 * var fieldStrings = { name: { required: 'Please provide your name.' }, lname: {
 * required: 'Please enter your last name.' }, scname:{ required: 'Please enter
 * your screen name.' }, email: { required: 'Type your Email in this field.' },
 * password: { required: 'Type your password in this field.' },
 * passwordConfirmation: { required: 'Please re-enter your password.' } };
 * 
 * new Y.FormValidator({boundingBox: '#adminForm', fieldStrings: fieldStrings,
 * rules: rules, showAllMessages: true}); });
 */