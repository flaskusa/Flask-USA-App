var RepositoryID;
var FolderId;    
var GRID_PARAM = {};

var gridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel;
var _contextMenuHandler;
GRID_PARAM.source = function(model, data){
	return {
			localdata: data,
			datafields: model,
			datatype: "json"
	};	
}
GRID_PARAM.updateGrid = function(data){
	var dataAdapter =  new $.jqx.dataAdapter(GRID_PARAM.source(_dataModel, data));
	gridObj.jqxGrid({ source: dataAdapter });
}
GRID_PARAM.toggleSelectionMode= function(){
	if(gridObj.jqxGrid('selectionmode') == 'checkbox'){
		gridObj.jqxGrid({selectionmode:'singlerow'});
	}else{
		gridObj.jqxGrid({selectionmode:'checkbox'});
	}
	
}
GRID_PARAM.toggleSearchBoxes = function(){
	gridObj.jqxGrid({
            showfilterrow: !(gridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}

GRID_PARAM.getCheckedIdList= function(idDataAttribute){
    var rows = gridObj.jqxGrid('selectedrowindexes');
    var dataList =[];
    $.each(rows, function(i, rowIndex){
    	var rowData = gridObj.jqxGrid('getrowdata', rowIndex);
    	dataList[i]=rowData;
    });
    return dataList;
}


GRID_PARAM.getDeleteList = function(idDataAttribute){
	
}


GRID_PARAM.onContextMenuItemClick =function (event) 
{
	var args = event.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM.onRowClick =function (event) 
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
		var left = ($(this).offset().left + parseInt($('#GridContainer').css('width'), 10)) - parseInt($('#' + rowMenuDivId).css('width'), 10) - 25;
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

GRID_PARAM.rowDetailTemplate = function(tabs, height)  
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

GRID_PARAM.initrowdetails = function(index, parentElement, gridElement, datarecord) {
	console.log("I am in initrowdetails"+datarecord.firstName);
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
		var img = $('<img style="max-height: 96px;" src="/documents/'+RepositoryID+'/0/' + datarecord.userId + '"/>');
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

/*
 *  This method creates grid
 */
function createTable(data, model, grid, menuDivId, actionColText,contextMenuHandler, detailDivArr){
	
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
    
    var adminColumns = [ {
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
		cellsrenderer : actionRenderer
	} ];
    	
   
    grid.on('cellclick', GRID_PARAM.onRowClick);
    //set menu item click
    _contextMenuHandler = contextMenuHandler
	$('#' + rowMenuDivId).on('itemclick',GRID_PARAM.onContextMenuItemClick);
	
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

	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM.source(model, data));
    grid.jqxGrid(
            {
                width: '100%',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
                autoheight: true,
             // Pageing config
                pageable : true,
                pagermode : 'default',
                rowdetails: true,
                showrowdetailscolumn:false,
                //rowdetailstemplate: GRID_PARAM.rowDetailTemplate(rowDetailDivArr , 200),
                rowdetailstemplate : {
					rowdetails : "<div style='margin: 2px;'><ul style='margin-left: 10px; height: 10px;'><li>Personal</li><li>Address</li></ul><div class='information'></div><div class='summary'></div></div>",
					rowdetailsheight : 200,
					rowdetailshidden: true,
				},
                initrowdetails: GRID_PARAM.initrowdetails,
                columns: adminColumns
            });
    
	}

		