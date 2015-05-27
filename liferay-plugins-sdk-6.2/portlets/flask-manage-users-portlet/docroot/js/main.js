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
	$("#adminDataTable").show();
	$("#adminForm").hide();	
}

function fnDelete(AdminId) {
	Liferay.Service('/flask-rest-users-portlet.flaskadmin/delete-flask-admins',
			{
				userId : AdminId
			}, function(obj) {
				closeEvent.cancel = true
			});
}

function fnSave() {
	console.log('insave');
	console.log(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT);
	var params = {
		firstName : $("#firstName").val(),
		middleName : $("#middleName").val(),
		lastName : $("#lastName").val(),
		isMale : true,
		screenName : $("#screenName").val(),
		email : $("#email").val(),
		// DOB: '05-10-2015',
		DOB : $("#DOB").val(),
		streetName : $("#streetName").val(),
		aptNo : $("#aptNo").val(),
		areaCode : $("#areaCode").val(),
		city : $("#city").val(),
		stateId : $("#stateId").val(),
		countryId : $("#countryId").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val(),
		mobileNumber : $("#mobileNumber").val(),
		userInterests : "{sports: true}"
	};

	Liferay.Service(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT, params,
		function(obj) {
			console.log(typeof obj);
			if(typeof obj =='object')
			{
				$("#spinningSquaresG").show();
				$.wait(function() {
					fnLoadAdminUserList();
					$("#spinningSquaresG").hide();
				}, 3);	
			}
			else
			{
			  console.log(obj);
			  return false;
			}
			console.log('end insave');			
	});
}

function fnUpdate(uid) {
	var params = {
		userId : $("#userId").val(),
		firstName : $("#firstName").val(),
		middleName : $("#middleName").val(),
		lastName : $("#lastName").val(),
		isMale : true,
		screenName : $("#screenName").val(),
		email : $("#email").val(),
		DOB : $("#DOB").val(),
		streetName : $("#streetName").val(),
		aptNo : $("#aptNo").val(),
		areaCode : $("#areaCode").val(),
		city : $("#city").val(),
		stateId : $("#stateId").val(),
		countryId : $("#countryId").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val(),
		mobileNumber : $("#mobileNumber").val(),
		userInterests :  "{sports: true}"//fnGetCheckBoxSelected()
	};

	Liferay.Service(SERVICE_ENDPOINTS.UPDATE_FLASK_ADMIN_ENDPOINT, params,
			function(obj) {
				console.log(obj);
				console.log(params);
				if(typeof obj =='object')
				{
					console.log('inUpdate');
					$("#spinningSquaresG").show();
					$.wait(function() {
						fnLoadAdminUserList();
						$("#spinningSquaresG").hide();
					}, 3);	
				}
				else
				{
				  console.log(obj);
				  return false;
				}
				console.log('end Update');			
		});	
}

function fnShowForm(rowIndex) {
	$("#userId").val(GlobalJSON_Admin[rowIndex].userId);
	console.log(GlobalJSON_Admin[rowIndex].userId);
	$("#firstName").val(GlobalJSON_Admin[rowIndex].firstName);
	$("#middleName").val(GlobalJSON_Admin[rowIndex].middleName);
	$("#lastName").val(GlobalJSON_Admin[rowIndex].lastName);
	$("#email").val(GlobalJSON_Admin[rowIndex].email);
	$("#screenName").val(GlobalJSON_Admin[rowIndex].screenName);
	$("#password1").val("");//GlobalJSON_Admin[rowIndex].password1
	$("#password2").val("");//GlobalJSON_Admin[rowIndex].password2
	$("#city").val(GlobalJSON_Admin[rowIndex].city);
	$("#mobileNumber").val(GlobalJSON_Admin[rowIndex].mobileNumber);
	$("#country").val(GlobalJSON_Admin[rowIndex].countryId);
	$("#DOB").val(GlobalJSON_Admin[rowIndex].DOB);
	$("#streetName").val(GlobalJSON_Admin[rowIndex].streetName);
	$("#aptNo").val(GlobalJSON_Admin[rowIndex].aptNo);
	$("#areaCode").val(GlobalJSON_Admin[rowIndex].areaCode);
	$("#state").val(GlobalJSON_Admin[rowIndex].stateId);
	$("#adminDataTable").hide();
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

	// initrow creation
	var grid = $("#grid")
	var initrowdetails = function(index, parentElement, gridElement, datarecord) {
		var tabsdiv = null;
		var information = null;
		var notes = null;
		tabsdiv = $($(parentElement).children()[0]);
		if (tabsdiv != null) {
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
			var firstname = "<div style='margin: 10px;'><b>First Name:</b> "
					+ datarecord.firstName + "</div>";
			var middlename = "<div style='margin: 10px;'><b>Middle Name:</b> "
					+ datarecord.middleName + "</div>";
			var lastname = "<div style='margin: 10px;'><b>Last Name:</b> "
					+ datarecord.lastName + "</div>";
			var Email = "<div style='margin: 10px;'><b>Email:</b> "
					+ datarecord.email + "</div>";
			var screenname = "<div style='margin: 10px;'><b>Screen Name:</b> "
					+ datarecord.screenName + "</div>";
			var dob1 = "<div style='margin: 10px;'><b>Date Of Birth:</b> "
					+ datarecord.DOB + "</div>";
			var streetname = "<div style='margin: 10px;'><b>Street Name:</b> "
					+ datarecord.streetName + "</div>";
			var aptno = "<div style='margin: 10px;'><b>Appartment No:</b> "
					+ datarecord.aptNo + "</div>";
			var areacode = "<div style='margin: 10px;'><b>Area Code:</b> "
					+ datarecord.areaCode + "</div>";
			var City = "<div style='margin: 10px;'><b>City:</b> "
					+ datarecord.city + "</div>";
			var State = "<div style='margin: 10px;'><b>State:</b> "
					+ datarecord.stateName + "</div>";
			var Country = "<div style='margin: 10px;'><b>Country:</b> "
					+ datarecord.countryName + "</div>";
			var Mobileno = "<div style='margin: 10px;'><b>Mobile No:</b> "
					+ datarecord.mobileNumber + "</div>";
			var Intr = "<div style='margin: 10px;'><b>Interests :</b> "
				+ datarecord.userInterests + "</div>";
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
			$(rightcolumn1).append(Intr);
			$(tabsdiv).jqxTabs({
				width : '90%',
				height : 200
			});
		}
	}

	// end initrow
	var dataAdapter = new $.jqx.dataAdapter(source);
	console.log(source);
	var cellsrenderer = function(row, columnfield, value, defaulthtml,
			columnproperties) {
		return '<i class="icon-wrench" style="margin:3px;"></i>'
	}
		
	grid.jqxGrid({
				width : '98%',
				source : dataAdapter,
				theme : APP_CONFIG.JQX_THEME,
				columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
				// Pageing config
				autoheight : false,
				pageable : true,
				pagermode : 'default',
				// adding new row details to display data
				rowdetails : true,
				showrowdetailscolumn : false,
				rowdetailstemplate : {
					rowdetails : "<div style='margin: 10px;'><ul style='margin-left: 10px; height: 10px;'><li>Personal</li><li>Address</li></ul><div class='information'></div><div class='summary'></div></div>",
					rowdetailsheight : 200,
					rowdetailshidden: true,
				},
				initrowdetails : initrowdetails,
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
					dataField : 'email'
					//,width : '30%'
				}, {
					text : 'Edit',
					dataField : 'userId',
					cellsalign : 'center',
					width:'34px',
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
	grid.on('contextmenu', function() {
		return false;
	});

	grid.bind('cellclick', function(event) {
		var args = event.args;
		// row's bound index.
		var boundIndex = args.rowindex;
		// row's visible index.
		var visibleIndex = args.visibleindex;
		// right click.
		if (args.column.text == "Edit") {
			var scrollTop = $(window).scrollTop();
			var scrollLeft = $(window).scrollLeft();
			editrow = event.args.rowindex;
			var rowsheight = grid.jqxGrid('rowsheight');
			var top = $(this).offset().top + (2 + editrow) * rowsheight;
			var left = ($(this).offset().left + parseInt($('#GridContainer').css('width'), 10)) - parseInt($('#Menu').css('width'), 10) - 25;
			$("#Menu").jqxMenu('open', left, top + 5 + scrollTop);
		} else {
			// original event.
			var ev = args.originalEvent;
			grid.jqxGrid('selectrow', boundIndex);
			var details = grid.jqxGrid('getrowdetails', boundIndex);
			if (details.rowdetailshidden == true) {
				grid.jqxGrid('showrowdetails', boundIndex);
			} else {
				grid.jqxGrid('hiderowdetails', boundIndex);
			}
		}
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
			var a = window.confirm("Are you sure ?");
			if (a) {
				fnDelete(GlobalJSON_Admin[rowindex].userId);
				var rowid = $("#grid").jqxGrid('getrowid', rowindex);
				$("#grid").jqxGrid('deleterow', rowid);
			}
			$("#spinningSquaresG").hide();
			return false;			
		}
	});
	$("#grid").show();
}

$(document).ready(function() {
	$("#spinningSquaresG").show();
	fnLoadAdminUserList();
	$("#spinningSquaresG").hide();
});

$(document).ready(function () {
    var theme = prepareSimulator("validator");
    $('.clsSave').jqxButton({ theme: theme });
    $('.clsSave').on('click', function () {
    	if($('#adminForm').jqxValidator('validate'))
    	{
    		if($("#userId").val()=="0")
    			fnSave();
    		else
    			fnUpdate();
    		
    		console.log("fnSave called");
    		return false;
    	}	
    	else
    	{
    		console.log("test False");
    		return false;
    	}
	});
    // initialize validator.
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
    initSimulator("validator");
});

YUI().use('aui-tree-view',
		  function(Y) {
			  Y.TreeNode.ATTRS.cssClasses.value.file.iconLeaf = 'none';
		    new Y.TreeViewDD(
		      {
		        boundingBox: '#myTreeView',
		        children: [
		          
		          {
		            children: [
		              {label: 'Basketball', leaf: true, type: 'task'},
		              {label: 'Baseball', leaf: true, type: 'task'},
		              {label: 'Football', leaf: true,  type: 'task'},
		              {label: 'Hockey', leaf: true, type: 'task'},
		              {label: 'Soccer', leaf: true, type: 'task'},
		              {label: 'Tennis', leaf: true,  type: 'task'}
		            ],
		            expanded: true,
		            label: 'Sports',
		            type: 'task'
		          }
		        ]
		      }
		    ).render();
		  }
		);
YUI().use(
		  'aui-tree-view',
		  function(Y) {
			  Y.TreeNode.ATTRS.cssClasses.value.file.iconLeaf = 'none';
		    new Y.TreeViewDD(
		      {
		        boundingBox: '#myTreeView0',
		        children: [
		          {
			            children: [
			              {label: 'Professional', leaf: true, type: 'task'},
			              {label: 'College', leaf: true, type: 'task'}
			            ],
			            expanded: true,
			            label: 'Level',
			            type: 'task'
			          }
		        ]
		      }
		    ).render();
		  }
		);

YUI().use(
		  'aui-tree-view',
		  function(Y) {
			  Y.TreeNode.ATTRS.cssClasses.value.file.iconLeaf = 'none';
		    new Y.TreeViewDD(
		      {
		        boundingBox: '#myTreeView1',
		        children: [
			          {
				            children: [
				              {label: 'Country', leaf: true, type: 'task'},
				              {label: 'POP', leaf: true, type: 'task'},
				              {label: 'ROCK', leaf: true, type: 'task'},
				              {label: 'RAP', leaf: true, type: 'task'},
				              {label: 'Alternative', leaf: true, type: 'task'},
				              {label: 'Electronic', leaf: true, type: 'task'},
				            ],
				            expanded: true,
				            label: 'Music',
				            type: 'task'
				          }
		        ]
		      }
		    ).render();
		  }
		);
YUI().use(
		  'aui-tree-view',
		  function(Y) {
			  Y.TreeNode.ATTRS.cssClasses.value.file.iconLeaf = 'none';
		    new Y.TreeViewDD(
		      {
		        boundingBox: '#myTreeView2',
		        children: [
				          {
					            children: [
					              {label: 'Comedy', leaf: true, type: 'task'}
					            ],
					            expanded: true,
					            label: 'Special Events',
					            type: 'task'
					          }
		        ]
		      }
		    ).render();
		  }
		);

$.wait = function(callback, seconds) {
	console.log("start>>" + callback);
	return window.setTimeout(callback, seconds * 1000);
	console.log("finish>>" + callback);
}

$(document).ready(function() {
	$.wait(function(){
		$(".icon-folder-open").hide();
	},1);
});

function fnGetCheckBoxSelected() {
	/*var Items = $("#userInterests").jqxTree('getItems');
	var ItemArray = new Array();
	$.each(Items, function() {
		if (this.checked) {
			var tempid = "#" + this.id;
			ItemArray.push($(tempid).attr("id"));
		}
		;
	});
	console.log(ItemArray.join("#"));
	return ItemArray.join("#");*/
	return '{}';
}

function fnSetCheckBoxSelected(strCheckList) {
/*
	var tempArray = new Array();
	tempArray = strCheckList.split("#");
	var i;
	console.log("tempArray length = " + tempArray.length)
	for (i = 0; i < tempArray.length; i++) {
		var tempObj = "#" + tempArray[i];
		$("#userInterests").jqxTree('checkItem', $(tempObj)[0], true);
	}
	console.log("Working fine");*/
}

function fnGetCountry(countryId) {
	var params = 19;
	var request = new Request();
	request.sendGETRequest("/api/jsonws/country/get-country/country-id/19",
			params, function(data) {
				if (data.responseStatus == 1) {
					var countryObj = data.responseJson;
					var myDropDownList = $("#countryId");
					myDropDownList.append($("<option></option>").val(0).html(
							"-Select your country-"));
					console.log(countryObj);
					console.log("TEST");
					// Loop here
					myDropDownList.append($("<option></option>").val(
							countryObj.countryId).html(countryObj.nameCurrentValue));
					// End Loop here
				} else {
					alert("MESSAGES.ERRORR_REGISTER_USER");
				}
			});
}

function fnGetRegions(countryId) {
	var params = 19;
	var request = new Request();
	request.sendGETRequest("/api/jsonws/region/get-regions/country-id/"
			+ countryId, params, function(data) {
		if (data.responseStatus == 1) {
			var regionObj = data.responseJson;
			console.log(regionObj);
			var myStateList = $("#stateId");
			myStateList.empty();
			myStateList.append($("<option></option>").val(0).html(
					"-Select your region-"));
			for (var i = 0; i < regionObj.length; i++) {
				// console.log(regionObj[i].name);
				myStateList.append($("<option></option>").val(
						regionObj[i].regionId).html(regionObj[i].name));
			}
		} else {
			alert("MESSAGES.ERRORR_REGISTER_USER");
		}
	});
}

$(document).ready(
		function() {
		console.log('Start ');
		fnGetCountry(19);
		console.log('End ')
		$("#countryId").change(function() {
			console.log($(this).val());
			fnGetRegions($(this).val());
			return false;
		});
		var myStateList = $("#stateId");
		myStateList.empty();
		myStateList.append($("<option></option>").val(0).html("-Select your region-"));
		
		$(".portlet-icon-back").hide();
		$(".panel-page-menu").hide();		
		$(".cssAddUser").click(function(){
			$("#adminDataTable").hide();
			$("#adminForm").show();
		});
		
		$(".clsCancel").click(function(){
			$("#adminDataTable").show();
			$("#adminForm").hide();
		});
		
		$(".cssDelUser").click(function() {
			$("#grid").jqxGrid({selectionmode:'checkbox'});
        });
		
		$(".cssSearchUser").click(function() {
			$("#grid").jqxGrid({
                showfilterrow: true,
                filterable: true,
                filterrowheight: 34
			});
        });		
});
