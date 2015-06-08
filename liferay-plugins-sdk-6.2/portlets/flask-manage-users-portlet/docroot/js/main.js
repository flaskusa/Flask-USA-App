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
		userInterests : fnGetCheckBoxSelected()//fnGet
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
		DOB : $('#DOB').jqxDateTimeInput('getDate'),
		streetName : $("#streetName").val(),
		aptNo : $("#aptNo").val(),
		areaCode : $("#areaCode").val(),
		city : $("#city").val(),
		stateId : $("#stateId").val(),
		countryId : $("#countryId").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val(),
		mobileNumber : $("#mobileNumber").val(),
		userInterests : fnGetCheckBoxSelected()
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
	$("#firstName").val(GlobalJSON_Admin[rowIndex].firstName);
	$("#middleName").val(GlobalJSON_Admin[rowIndex].middleName);
	$("#lastName").val(GlobalJSON_Admin[rowIndex].lastName);
	$("#email").val(GlobalJSON_Admin[rowIndex].email);
	$("#screenName").val(GlobalJSON_Admin[rowIndex].screenName);
	$("#password1").val("");//GlobalJSON_Admin[rowIndex].password1
	$("#password2").val("");//GlobalJSON_Admin[rowIndex].password2
	$("#city").val(GlobalJSON_Admin[rowIndex].city);
	$("#mobileNumber").val(GlobalJSON_Admin[rowIndex].mobileNumber);
	$("#countryId").val(GlobalJSON_Admin[rowIndex].countryId);
	fnFillRegionList(GlobalJSON_Admin[rowIndex].countryId,GlobalJSON_Admin[rowIndex].stateId);
	var date = new Date(parseInt(GlobalJSON_Admin[rowIndex].DOB))
	$('#DOB').jqxDateTimeInput('setDate', date);
	$("#streetName").val(GlobalJSON_Admin[rowIndex].streetName);
	$("#aptNo").val(GlobalJSON_Admin[rowIndex].aptNo);
	$("#areaCode").val(GlobalJSON_Admin[rowIndex].areaCode);
	fnSetCheckBoxSelected(GlobalJSON_Admin[rowIndex].userInterests);
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
			var container = $('<div class="row-fluid"></div>');
			container.appendTo($(information));
			var photocolumn = $('<div class="span2"></div>');
			var leftcolumn = $('<div class="span5"></div>');
			var rightcolumn = $('<div class="span5"></div>');
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
		
			var firstname = "<tr><td class='filledWidth'> <b>First Name:</b></td><td> "
				+ datarecord.firstName + "</td></tr>";
		    var middlename = "<tr><td class='filledWidth'><b>Middle Name:</b></td><td> "
				+ datarecord.middleName + "</td></tr>";
		    var lastname = "<tr><td class='filledWidth'><b>Last Name:</b></td><td> "
				+ datarecord.lastName + "</td></tr>";
			
		    
			var Email = "<tr><td class='filledWidth'> <b>Email:</b></td><td>"
					+ datarecord.email + "</td></tr>";
			var screenname = "<tr><td class='filledWidth'><b>Screen Name:</b></td><td>"
					+ datarecord.screenName + "</td></tr>";
			var dob1 = "<tr><td class='filledWidth'><b>Date Of Birth:</b></td><td> "
					+ datarecord.DOB + "</td></tr>";
			var streetname = "<tr><td class='filledWidth'><b>Street Name:</b></td><td> "
					+ datarecord.streetName + "</td></tr>";
			var aptno = "<tr><td class='filledWidth'><b>Appartment No:</b></td><td> "
					+ datarecord.aptNo + "</td></tr>";
			var areacode = "<tr><td class='filledWidth'><b>Area Code:</b> </td><td>"
					+ datarecord.areaCode + "</td></tr>";
			var City = "<tr><td class='filledWidth1'><b>City:</b></td><td> "
					+ datarecord.city + "</td></tr>";
			var State = "<tr><td class='filledWidth1'><b>State:</b></td><td> "
					+ datarecord.stateName + "</td></tr>";
			var Country = "<tr><td class='filledWidth1'><b>Country:</b></td><td> "
					+ datarecord.countryName + "</td></tr>";
			var Mobileno = "<tr><td class='filledWidth'><b>Mobile No:</b></td><td> "
					+ datarecord.mobileNumber + "</td></tr>";
			var Intr = "<tr><td class='filledWidth1'><b>Interests :</b> </td><td>"
				+ datarecord.userInterests + "</td></tr>";
			
			$(leftcolumn).append("<table>");
			
			$(leftcolumn).append(firstname);
			$(leftcolumn).append(middlename);
			$(leftcolumn).append(lastname);
			
			$(leftcolumn).append("</table>");
			
			$(rightcolumn).append("<table>");
			
			$(rightcolumn).append(Email);
			$(rightcolumn).append(screenname);
			$(rightcolumn).append(dob1);
			$(rightcolumn).append(Mobileno);
			
			$(rightcolumn).append("</table>");
			
			
			var container1 = $('<div class="row-fluid"></div>')
			container1.appendTo($(summary));
			var leftcolumn1 = $('<div class="span6"></div>');
			var rightcolumn1 = $('<div class="span6"></div>');
			container1.append(leftcolumn1);
			container1.append(rightcolumn1);
			
			$(leftcolumn).append("<table>");
			$(leftcolumn1).append(streetname);
			$(leftcolumn1).append(aptno);
			$(leftcolumn1).append(areacode);
			$(leftcolumn).append("</table>");
			
			$(rightcolumn).append("<table>");
			$(rightcolumn1).append(City);
			$(rightcolumn1).append(State);
			$(rightcolumn1).append(Country);
			$(rightcolumn1).append(Intr);
			$(rightcolumn).append("</table>");
			
			
			$(tabsdiv).jqxTabs({
				width : '90%',
				height : 180
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
				width : '100%',
				source : dataAdapter,
				theme : APP_CONFIG.JQX_THEME,
				columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
				// Pageing config
				autoheight : true,
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
    $('.cssSave').on('click', function () {
    	if($('#adminForm').jqxValidator('validate'))
    	{
    		console.log($("#userId").val());
    		if(parseInt($("#userId").val())>0){
    			console.log("fnUpdate called");
    			fnUpdate();
    		}
    		else{
    			console.log("fnSave called");
    			fnSave();
    			var myStateList = $("#stateId");
    			myStateList.empty();
    			myStateList.append($("<option></option>").val(0).html("-Select your region-"));
    		}
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
    $(".jqx-checkbox").css("margin-top","6.5px");
});

$.wait = function(callback, seconds) {
	console.log("start>>" + callback);
	return window.setTimeout(callback, seconds * 1000);
	console.log("finish>>" + callback);
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

function fnFillCountryList() {
	var params = "";
	var request = new Request();
	var myDropDownList = $("#countryId");
	myDropDownList.append($("<option></option>").val(0).html("-Select your country-"));
	$.each(ALLOWED_COUNTRIES, function(index, value) {
		if(value==DEFAULT_COUNTRY){
			
		}
		request.sendGETRequest("/api/jsonws/country/get-country-by-name/name/"+value,params, function(data) {
			if (data.responseStatus == 1) {
				var countryObj = data.responseJson;
				myDropDownList.append($("<option></option>").val(countryObj.countryId).html(countryObj.nameCurrentValue));
			} else {
				alert("MESSAGES.ERRORR_REGISTER_USER");
			}
		});
	  
	});	
}

function fnFillRegionList(countryId,defStateId) {
	var params = "";
	var request = new Request();
	request.sendGETRequest("/api/jsonws/region/get-regions/country-id/"+countryId, params, function(data) {
		if (data.responseStatus == 1) {
			var regionObj = data.responseJson;
			console.log(regionObj);
			var myStateList = $("#stateId");
			myStateList.empty();
			
			myStateList.append($("<option></option>").val(0).html("-Select your region-"));
			for (var i = 0; i < regionObj.length; i++) {
				myStateList.append($("<option></option>").val(regionObj[i].regionId).html(regionObj[i].name));
			}
			myStateList.val(defStateId);
		} else {
			alert("MESSAGES.ERRORR_REGISTER_USER");
		}
	});
}

$(document).ready(function() {
		fnFillCountryList();
		$("#countryId").change(function() {
			
			fnFillRegionList($(this).val(),0);
			return false;
		});
		console.log($("#countryId").val());
		if($("#countryId").val()=="0")
			{
				fnFillRegionList(0,0);
			}
		
		$(".portlet-icon-back").hide();
		$(".panel-page-menu").hide();		
		$(".cssAddUser").click(function(){
			$("#adminDataTable").hide();
			$("#adminForm").show();
		});
		
		$(".cssCancel").click(function(){
			$("#adminDataTable").show();
			$("#adminForm").hide();
		});
		$(".cssDelete").hide();	
		$(".cssDelUser").click(function() {
			$("#grid").jqxGrid({selectionmode:'checkbox'});
			$(".jqx-checkbox-default").click(function(){
				var flag1=true;
				 if (flag1==true) {
					 $(".cssDelete").show();	
					 $(".cssDelUser").hide();	
    			}
    			else{
    				 $(".cssDelUser").show();
    			}
			}) ;
        });
		
		$(".cssDelete").click(function () {
	          var rows = $("#grid").jqxGrid('selectedrowindexes');
	          var clonerows = rows;

	             console.log(clonerows);
	             for (var m1 = 0; m1 <=clonerows.length+1; m1++) {
	            	 console.log(clonerows[m1]);
	            	 var row = $("#grid").jqxGrid('getrowdata', clonerows[m1]);
	            	console.log(clonerows[m1]);
	            	
	                fnDelete(row.userId);
	             }
	             
	            
	             console.log(rows);
	             console.log(rows.length);
	             for (var m = 0; m <= rows.length+1; m++) {
	           	console.log(m);
	           	console.log(rows[m]);
	            	var rowid = $("#grid").jqxGrid('getrowid',  rows[m]);
				 	$("#grid").jqxGrid('deleterow', rowid);
	             }
	          
	        });
		 var flag=true;
			
		$(".cssSearchUser").click(function() {
			$("#grid").jqxGrid({
                showfilterrow: flag,
                filterable: true,
                filterrowheight: 34
			});
			if(flag==true){
				flag=false;

			}
			else{
				flag=true;
				
			}
			$(".jqx-grid-cell-filter-row-custom:last").hide();
        
        });		
		
		$("#DOB").jqxDateTimeInput({ width: '250px', height: '25px', formatString: "MM-dd-yyyy" });
		$('.userInterests').jqxTree({ height: 'auto', hasThreeStates: true, checkboxes: true});	
	    console.log("Cal Done");    
		$(".jqx-checkbox").css("margin-top","6.5px");
		$.wait(function(){
			$(".icon-folder-open").hide();
		},1);		
});

