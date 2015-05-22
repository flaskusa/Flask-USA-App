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
		//DOB:  '05-10-2015',
		DOB : $("#DOB").val(),
		streetName: $("#streetName").val(),
		aptNo: $("#aptNo").val(),
		areaCode: $("#areaCode").val(),
		city: $("#city").val(),
		state: $("#state").val(),
		country: $("#country").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val(),
		mobileNo: $("#mobileNo").val(),
		userInterests: "{sports: true}"		
	};

	$("#spinningSquaresG").show();	
	console.log('insave');
	console.log(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT);
	Liferay.Service(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT,params,
	 function(obj) {
	   console.log(obj);
	 });
	console.log('end insave');
	$.wait( function(){ fnLoadAdminUserList(); $("#spinningSquaresG").hide();}, 3);
	$(".clsSave").attr("onclick","fnSave()");
}

function fnUpdate(uid){
	alert("I'm in update");
	var params =  {
        userId:uid,			
		firstName : $("#firstName").val(),
		middleName : $("#middleName").val(),
		lastName : $("#lastName").val(),
		isMale: true,
		screenName : $("#screenName").val(),
		email : $("#email").val(),
		//DOB:  '05-10-2015',
		DOB : $("#DOB").val(),
		streetName: $("#streetName").val(),
		aptNo: $("#aptNo").val(),
		areaCode: $("#areaCode").val(),
		city: $("#city").val(),
		state: $("#state").val(),
		country: $("#country").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val(),
		mobileNo: $("#mobileNo").val(),
		userInterests: fnGetCheckBoxSelected()
	};

	$("#spinningSquaresG").show();	
	//console.log('insave');
	console.log(SERVICE_ENDPOINTS.UPDATE_FLASK_ADMIN_ENDPOINT);
	Liferay.Service(SERVICE_ENDPOINTS.UPDATE_FLASK_ADMIN_ENDPOINT,params,
	 function(obj) {
	   console.log(obj);
	 });
	//console.log('end insave');
	$.wait( function(){ fnLoadAdminUserList(); $("#spinningSquaresG").hide();}, 3);	
}

function fnShowForm(rowIndex) {
	$(".clsSave").attr("onclick","fnUpdate(" +GlobalJSON_Admin[rowIndex].userId+ ")");
	var objTemp;
	console.log(GlobalJSON_Admin);
	$("#firstName").val(GlobalJSON_Admin[rowIndex].firstName);
	$("#middleName").val(GlobalJSON_Admin[rowIndex].middleName);
	$("#lastName").val(GlobalJSON_Admin[rowIndex].lastName);
	$("#email").val(GlobalJSON_Admin[rowIndex].email);
	$("#screenName").val(GlobalJSON_Admin[rowIndex].screenName);
	$("#password1").val(GlobalJSON_Admin[rowIndex].password1);
	$("#password2").val(GlobalJSON_Admin[rowIndex].password2);
	$("#city").val(GlobalJSON_Admin[rowIndex].city);
	$("#mobileNo").val(GlobalJSON_Admin[rowIndex].mobileNo);
	$("#country").val(GlobalJSON_Admin[rowIndex].country);
	$("#DOB").val(GlobalJSON_Admin[rowIndex].DOB);
	$("#streetName").val(GlobalJSON_Admin[rowIndex].streetName);
	$("#aptNo").val(GlobalJSON_Admin[rowIndex].aptNo);
	$("#areaCode").val(GlobalJSON_Admin[rowIndex].areaCode);
	$("#state").val(GlobalJSON_Admin[rowIndex].state);
	
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

	//initrow creation
	
	var initrowdetails = function (index, parentElement, gridElement, datarecord) 
	{
	        var tabsdiv = null;
	        var information = null;
	        var notes = null;
	        tabsdiv = $($(parentElement).children()[0]);
	        if (tabsdiv != null) 
	        {
	            information = tabsdiv.find('.information');
	            summary = tabsdiv.find('.summary');
	            var title = tabsdiv.find('.title');
	            var container = $('<div style="margin: 5px;"></div>')
	            container.appendTo($(information));
	            var photocolumn = $('<div style="float: left; width: 15%;"></div>');
	            var leftcolumn = $('<div style="float: left; width: 45%;"></div>');
	            var rightcolumn = $('<div style="float: left; width: 40%;"></div>');
	            container.append(photocolumn);
	            container.append(leftcolumn);
	            container.append(rightcolumn);
	            var photo = $("<div class='jqx-rc-all' style='margin: 10px;'><b>Photo:</b></div>");
	            var image = $("<div style='margin-top: 10px;'></div>");
	            var imgurl = '' + datarecord.firstName.toLowerCase() + '.png';
	            var img = $('<img height="60" src="' + imgurl + '"/>');
	            image.append(img);
	            image.appendTo(photo);
	            photocolumn.append(photo);
	            var firstname = "<div style='margin: 10px;'><b>First Name:</b> " + datarecord.firstName + "</div>";
	            var middlename = "<div style='margin: 10px;'><b>Middle Name:</b> " + datarecord.middleName + "</div>";
	            var lastname = "<div style='margin: 10px;'><b>Last Name:</b> " + datarecord.lastName + "</div>";
	            var Email = "<div style='margin: 10px;'><b>Email:</b> " + datarecord.email + "</div>";
	            var screenname = "<div style='margin: 10px;'><b>Screen Name:</b> " + datarecord.screenName + "</div>";
	            var dob1 = "<div style='margin: 10px;'><b>Date Of Birth:</b> " + datarecord.DOB + "</div>";
	            var streetname = "<div style='margin: 10px;'><b>Street Name:</b> " + datarecord.streetName + "</div>";
	            var aptno = "<div style='margin: 10px;'><b>Appartment No:</b> " + datarecord.aptNo + "</div>";
	            var areacode = "<div style='margin: 10px;'><b>Area Code:</b> " + datarecord.areaCode + "</div>";
	            var City = "<div style='margin: 10px;'><b>City:</b> " + datarecord.city + "</div>";
	            var State = "<div style='margin: 10px;'><b>State:</b> " + datarecord.state + "</div>";
	            var Country = "<div style='margin: 10px;'><b>Country:</b> " + datarecord.country + "</div>";
	            var Mobileno = "<div style='margin: 10px;'><b>Mobile No:</b> " + datarecord.mobileNo + "</div>";
	            $(leftcolumn).append(firstname);
	            $(leftcolumn).append(middlename);
	            $(leftcolumn).append(lastname);
	            $(rightcolumn).append(Email);
	            $(rightcolumn).append(screenname);
	            $(rightcolumn).append(dob1);
	            $(rightcolumn).append(Mobileno);
	            var container1 = $('<div style="margin: 5px;"></div>')
	            container1.appendTo($(summary));
	            var leftcolumn1 = $('<div style="float: left; width: 45%;"></div>');
	            var rightcolumn1 = $('<div style="float: left; width: 40%;"></div>');
	            container1.append(leftcolumn1);
	            container1.append(rightcolumn1);
	            $(leftcolumn1).append(streetname);
	            $(leftcolumn1).append(aptno);
	            $(leftcolumn1).append(areacode);
	            $(rightcolumn1).append(City);
	            $(rightcolumn1).append(State);
	            $(rightcolumn1).append(Country);
	            $(tabsdiv).jqxTabs({ width: '100%', height: '100%'});
	        }
	 }
	
	//end initrow
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
		
		//adding new row details to display data
		rowdetails: true,
        rowdetailstemplate: { rowdetails: "<div style='margin: 10px;'><ul style='margin-left: 10px; height: 10px;'><li>Personal</li><li>Address</li></ul><div class='information'></div><div class='summary'></div></div>", rowdetailsheight: 200 },
        ready: function () 
        {
           // $("#grid").jqxGrid('showrowdetails', 0);
           // $("#grid").jqxGrid('showrowdetails', 1);
        },
        
        initrowdetails: initrowdetails,
        
		columns : [ 
		            { text : 'First Name', dataField : 'firstName', width : '33%' }, 
		            { text : 'Last Name', dataField : 'lastName', width : '33%'	}, 
		            { text : 'Email', dataField : 'email', 	width : '30%' }, 
		            { text : ' ', cellsrenderer : cellsrenderer	} 
		         ]
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
		if (event.args.columnindex == 4) {
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
		$("#spinningSquaresG").show();
		var args = event.args;
		var rowindex = $("#grid").jqxGrid('getselectedrowindex');
		
		if ($.trim($(args).text()) == "Edit") {
			fnShowForm(rowindex);
			$("#spinningSquaresG").hide();
			return false;
		} 
		
		if ($.trim($(args).text()) == "Delete") {
			var a  = window.confirm("Are you sure ?");
			if (a){
				fnDelete(GlobalJSON_Admin[rowindex].userId);
				var rowid = $("#grid").jqxGrid('getrowid', rowindex);
				$("#grid").jqxGrid('deleterow', rowid);
				$("#spinningSquaresG").hide();
				return false;
				}
			else
				{
				return false;
				}
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
     $('#userInterests').jqxTree({theme:"base",hasThreeStates:true, checkboxes:true, height: '300px', width: '100%' });
     //fnGetCheckBoxSelected();
});

function fnGetCheckBoxSelected(){
	 var Items = $("#userInterests").jqxTree('getItems');
	 var ItemArray = new Array();
	 $.each(Items, function () {
         if (this.checked) {
        	 var tempid = "#"+this.id;
        	 ItemArray.push($(tempid).attr("id"));
         };
     });
	 console.log(ItemArray.join("#"));
	 return ItemArray.join("#");
}

function fnSetCheckBoxSelected(strCheckList){
	
	var tempArray = new Array(); 
	tempArray = strCheckList.split("#");
    var i;
    console.log("tempArray length = "+tempArray.length)
    for (i = 0; i < tempArray.length; i++) { 
   	    var tempObj = "#"+tempArray[i];
   	    $("#userInterests").jqxTree('checkItem', $(tempObj)[0], true);
    }
    console.log("Working fine");
}