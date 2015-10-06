    
var GRID_PARAM_CUSTOMER = {};

var gridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel
var _contextMenuHandler;
GRID_PARAM_CUSTOMER.source = function(model, data){
	return {
			localdata: data,
			datafields: model,
			datatype: "json"
	};	
}
GRID_PARAM_CUSTOMER.updateGrid = function(data){
	var dataAdapter =  new $.jqx.dataAdapter(GRID_PARAM_CUSTOMER.source(_dataModel, data));
	gridObj.jqxGrid({ source: dataAdapter });
}
GRID_PARAM_CUSTOMER.toggleSelectionMode= function(){
	if(gridObj.jqxGrid('selectionmode') == 'checkbox'){
		gridObj.jqxGrid({selectionmode:'singlerow'});
	}else{
		gridObj.jqxGrid({selectionmode:'checkbox'});
	}
	
}
GRID_PARAM_CUSTOMER.toggleSearchBoxes = function(){
	gridObj.jqxGrid({
            showfilterrow: !(gridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}

GRID_PARAM_CUSTOMER.getCheckedIdList= function(idDataAttribute){
	debugger;
    var rows = gridObj.jqxGrid('selectedrowindexes');
    var dataList="";
    $.each(rows, function(i, rowIndex){
    	var rowData = gridObj.jqxGrid('getrowdata', rowIndex);
    	dataList += eval('rowData.'+ idDataAttribute);
    	if(i !== rows.length -1)
    		dataList +=",";
    });
    return dataList;
}


GRID_PARAM_CUSTOMER.getDeleteList = function(idDataAttribute){
	
}


GRID_PARAM_CUSTOMER.onContextMenuItemClick =function (event) 
{
	var args = event.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM_CUSTOMER.onRowClick =function (event) 
{
	var grid = gridObj;
	var args = event.args;
	// row's bound index.
	var boundIndex = args.rowindex;
	// row's visible index.
	var visibleIndex = args.visibleindex;
	// right click.
	
	

	if (args.column.text == rowMenuColumnText) {
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		editrow = event.args.rowindex;
		var rowsheight = grid.jqxGrid('rowsheight');
		var top = $(this).offset().top + (2 + editrow) * rowsheight;
		var left = ($(this).offset().left + parseInt($('#manageCustomerContainer').css('width'), 10)) - parseInt($('#' + rowMenuDivId).css('width'), 10) - 25;
		$('#' +rowMenuDivId).jqxMenu('open', left, top + 5 + scrollTop);
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
}




GRID_PARAM_CUSTOMER.rowDetailTemplate = function(tabs, height)  
{
	var rowDetailTemplate = "<div style='margin: 2px;'> <ul style='margin-left: 30px;'> "
		if($.isArray(tabs)){
			$.each(tabs, function(index, tab){
				rowDetailTemplate = rowDetailTemplate + "<li>" + tab + "</li>";
			});
			rowDetailTemplate = rowDetailTemplate + "</ul>";
			$.each(tabs, function(index, tab){
				rowDetailTemplate = rowDetailTemplate + "<div class='"+ tab.toLowerCase() +"'></div>";
			});
			rowDetailTemplate = rowDetailTemplate +   "</div>";
		}
	 return { rowdetails: rowDetailTemplate, rowdetailsheight: height };
}

GRID_PARAM_CUSTOMER.initrowdetails = function(index, parentElement, gridElement, datarecord){
	 var tabsdiv = null; 
  
    tabsdiv = $($(parentElement).children()[0]);
    if (tabsdiv != null) {
    	
		var customerInfoDiv = tabsdiv.find('.customer');
//		var imagesDiv = tabsdiv.find('.images');
		
		var container1 = $('<div class="row-fluid"></div>');
		
		var container2 = $('<div class="row-fluid"></div>');
		customerInfoDiv.append(container1);
		
		var leftcolumn = $('<div class="span5"></div>');
		var rightcolumn = $('<div class="span5"></div>');
		
		container1.append(leftcolumn);
		container1.append(rightcolumn);
	
		var customer_Name = "<tr><td class='filledWidth'> <b>Customer Name:</b></td><td> "
			+ datarecord.customerName + "</td></tr>";
	    var business_Type = "<tr><td class='filledWidth'><b>Business Type:</b></td><td> "
			+ datarecord.businessType + "</td></tr>";
	    var addrLine_1 = "<tr><td class='filledWidth'><b>AddrLine 1:</b></td><td> "
			+ datarecord.addrLine1 + "</td></tr>";
		var addrLine_2 = "<tr><td class='filledWidth'> <b>AddrLine 2:</b></td><td>"
				+ datarecord.addrLine2 + "</td></tr>";
		
		var city = "<tr><td class='filledWidth'> <b>City:</b></td><td>"
			+ datarecord.city + "</td></tr>";
	
		var stateName = "<tr><td class='filledWidth'> <b>State:</b></td><td>"
			+ datarecord.stateName + "</td></tr>";

		
		var email = "<tr><td class='filledWidth'><b>Email:</b></td><td>"
				+ datarecord.email + "</td></tr>";
		var websiteUrl = "<tr><td class='filledWidth1'><b>Web Site:</b></td><td> "
				+ datarecord.websiteURL + "</td></tr>";
		var companyPhoneNo = "<tr><td class='filledWidth1'><b>Phone No:</b></td><td> "
			+ datarecord.businessPhoneNumber + "</td></tr>";	
		var primaryContactPerson = "<tr><td class='filledWidth1'><b>Primary Contact:</b></td><td> "
				+ datarecord.contactPersonName+ "</td></tr>";
		var primaryContactPersonNo = "<tr><td class='filledWidth1'><b>Primary Contact No:</b></td><td> "
				+ datarecord.contactPersonNumber + "</td></tr>";		
		$(leftcolumn).append("<table>");
		
		$(leftcolumn).append(customer_Name);
		$(leftcolumn).append(business_Type);
		$(leftcolumn).append(addrLine_1);
		$(leftcolumn).append(addrLine_2);
		$(leftcolumn).append(city);
		$(leftcolumn).append(stateName);
		$(leftcolumn).append("</table>");
		
		$(rightcolumn).append("<table>");
		
		
		$(rightcolumn).append(websiteUrl);
		$(rightcolumn).append(email);
		$(rightcolumn).append(companyPhoneNo);
		$(rightcolumn).append(primaryContactPerson);
		$(rightcolumn).append(primaryContactPersonNo);
		
		$(rightcolumn).append("</table>");		
		
		
		$(tabsdiv).jqxTabs({
			width : '100%',
			height : 350
		});
    }
}

/*
 *  This method creates grid
 */
function createCustomerTable(data, model, grid, menuDivId, actionColText,contextMenuHandler, detailDivArr){
	
		if(typeof gridId == undefined){
			throw 'a valid grid div object must be provided';
		}
		if(typeof rowMenuColumnText == undefined){
			throw 'a columnheader needs to be provided to be used for click action';
		}
		if(typeof rowMenuDivId == undefined){
			throw 'a valid menu div needs to be provided to be used for click action';
		}
		if (typeof detailDivArr == undefined){
			throw 'a valid detailDivArr needs to be provided for row detail';
		}
		
		if (typeof model == undefined){
			throw 'a valid model needs to be provided';
		}
		
		_dataModel = model;
		rowMenuDivId = menuDivId;
		rowMenuColumnText =actionColText;
		gridObj = grid;
		rowDetailDivArr = detailDivArr
		
    var actionRenderer = function(row, columnfield, value, defaulthtml, columnproperties) {
						return '<i class="icon-wrench" style="margin:3px;"></i>'
	}
    
    var adCustomerColumns = [{ text: 'Name', columntype: 'textbox',  datafield: 'customerName', width: '30%' },
    	 { text: 'Business', datafield: 'businessType', width: '15%'},
    	 { text: 'City', datafield: 'city', width: '15%'},
    	 { text: 'Phone Number', datafield: 'businessPhoneNumber', width: '15%'},
    	 { text: 'Email', datafield: 'email', width: '15%'},
    	 { text: 'Edit',  datafield: 'customerId', width: '10%', cellsalign: 'center', cellsrenderer: actionRenderer}];
    
    grid.on('cellclick', GRID_PARAM_CUSTOMER.onRowClick);
    //set menu item click
    _contextMenuHandler = contextMenuHandler
	$('#' + rowMenuDivId).on('itemclick',GRID_PARAM_CUSTOMER.onContextMenuItemClick);
	
	// create context menu
	var contextMenu = $("#" + menuDivId).jqxMenu({
		width : 160,
		height : 60,
		autoOpenPopup : false,
		mode : 'popup'
	});
	
	grid.on('contextmenu', function() {
		return false;
	});

	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM_CUSTOMER.source(model, data));
    grid.jqxGrid(
            {
                width: '100%',
                source: dataAdapter,
                height:'70%',
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
             // Pageing config
                pageable : true,
                pagermode : 'simple',
                rowdetails: true,
                showrowdetailscolumn:false,
                rowdetailstemplate: GRID_PARAM_CUSTOMER.rowDetailTemplate(rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM_CUSTOMER.initrowdetails,
                columns: adCustomerColumns,
                pagesize: 20,
                autoheight: true
            });
    
	}

		