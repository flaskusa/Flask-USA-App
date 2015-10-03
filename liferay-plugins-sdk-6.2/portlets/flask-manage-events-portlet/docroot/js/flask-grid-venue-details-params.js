var GRID_PARAM_DETAILS = {};

var gridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel;
var _contextMenuHandler;
GRID_PARAM_DETAILS.source = function(model, data) {
	return {
			localdata: data,
			datafields: model,
			datatype: "json"
	};
}
GRID_PARAM_DETAILS.updateGrid = function(data) {
	var dataAdapter =  new $.jqx.dataAdapter(GRID_PARAM_DETAILS.source(_dataModel, data));
	gridObj.jqxGrid({ source: dataAdapter });
	gridObj.jqxGrid('addgroup', 'infoTypeId');

}
GRID_PARAM_DETAILS.toggleSelectionMode= function() {
	if (gridObj.jqxGrid('selectionmode') == 'checkbox') {
		gridObj.jqxGrid({selectionmode:'singlerow'});
	}else {
		gridObj.jqxGrid({selectionmode:'checkbox'});
	}

}
GRID_PARAM_DETAILS.toggleSearchBoxes = function() {
	gridObj.jqxGrid({
			showfilterrow: !(gridObj.jqxGrid('showfilterrow')),
			filterable: true,
			filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}

GRID_PARAM_DETAILS.getCheckedIdList= function(idDataAttribute) {
	var rows = gridObj.jqxGrid('selectedrowindexes');
	var dataList=[];
	$.each(rows, function(i, rowIndex) {
		var rowData = gridObj.jqxGrid('getrowdata', rowIndex);
		dataList[i] = rowData.venueId;
	});
	var temp= dataList.toString();
	console.log(temp);
	return temp;
}

GRID_PARAM_DETAILS.getDeleteList = function(idDataAttribute) {

}


GRID_PARAM_DETAILS.onContextMenuItemClick =function(venue)
{
	var args = venue.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM_DETAILS.onRowClick =function(venue)
{
	var grid = gridObj;
	var args = venue.args;
	// row's bound index.
	var boundIndex = args.rowindex;
	// row's visible index.
	var visibleIndex = args.visibleindex;
	// right click.
	if (args.column.text == rowMenuColumnText) {
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		editrow = venue.args.rowindex;
		var rowsheight = grid.jqxGrid('rowsheight');
		var top = $(this).offset().top + (2 + editrow) * rowsheight;
		var left = ($(this).offset().left + parseInt($('.jqx-grid').css('width'), 10)) - parseInt($('#' + rowMenuDivId).css('width'), 10) - 25;
		$('#' +rowMenuDivId).jqxMenu('open', left, top + 5 + scrollTop);
	} else {
		// original venue.
		var ev = args.originalVenue;
		grid.jqxGrid('selectrow', boundIndex);
		var details = grid.jqxGrid('getrowdetails', boundIndex);
		if (details.rowdetailshidden == true) {
			grid.jqxGrid('showrowdetails', boundIndex);
		} else {
			grid.jqxGrid('hiderowdetails', boundIndex);
		}
	}
}




GRID_PARAM_DETAILS.rowDetailTemplate = function(tabs, height)
{
	var rowDetailTemplate = "<div style='margin: 2px;'> <ul style='margin-left: 30px;'> "
		if ($.isArray(tabs)) {
			$.each(tabs, function(index, tab) {
				rowDetailTemplate = rowDetailTemplate + "<li>" + tab + "</li>";
			});
			rowDetailTemplate = rowDetailTemplate + "</ul>";
			$.each(tabs, function(index, tab) {
				rowDetailTemplate = rowDetailTemplate + "<div class='"+ tab.toLowerCase() +"'></div>";
			});
			rowDetailTemplate = rowDetailTemplate +   "</div>";
		}
	 return { rowdetails: rowDetailTemplate, rowdetailsheight: height };
}



GRID_PARAM_DETAILS.initrowdetails = function(index, parentElement, gridElement, datarecord) {
	var tabsdiv = null;
	tabsdiv = $($(parentElement).children()[0]);
	    if (tabsdiv != null) {
	    	var venueDiv = tabsdiv.find('.images');
	    	var container = $('<div/>');
	    	fnGetVenueDetailImages(datarecord.venueDetailId,container,false);
	  	  	$(container).appendTo($(venueDiv));
			$(tabsdiv).jqxTabs({
				width : '100%',
				height : 200
			});
	}
}

function createDetailsTable(data, model, grid, menuDivId, actionColText,contextMenuHandler, detailDivArr, Columns) {

		if (typeof gridId == undefined) {
			throw 'a valid grid div object must be provided';
		}
		if (typeof rowMenuColumnText == undefined) {
			throw 'a columnheader needs to be provided to be used for click action';
		}
		if (typeof rowMenuDivId == undefined) {
			throw 'a valid menu div needs to be provided to be used for click action';
		}
		if (typeof detailDivArr == undefined) {
			throw 'a valid detailDivArr needs to be provided for row detail';
		}

		if (typeof model == undefined) {
			throw 'a valid model needs to be provided';
		}

		_dataModel = model;
		rowMenuDivId = menuDivId;
		rowMenuColumnText =actionColText;
		gridObj = grid;
		rowDetailDivArr = detailDivArr

	grid.on('cellclick', GRID_PARAM_DETAILS.onRowClick);
	//set menu item click
	_contextMenuHandler = contextMenuHandler
	$('#' + rowMenuDivId).on('itemclick',GRID_PARAM_DETAILS.onContextMenuItemClick);
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

	var groupsrenderer = function(text, group, expanded, data) {
		return '<div style="padding: 5px; float: left; font-weight: bold;">' + data.subItems[0].infoTypeName + '</div>';
	}
	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM_DETAILS.source(model, data));
	grid.jqxGrid(
			{
				width: '100%',
				source: dataAdapter,
				columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
				theme:	'custom',
				autoheight: true,
				pageable : true,
				pagermode : 'simple',
				rowdetails: true,
				groupable: true,
				showgroupmenuitems: false,
				showgroupsheader: false,
				showrowdetailscolumn:false,
				groupsrenderer: groupsrenderer,
				rowdetailstemplate: GRID_PARAM_DETAILS.rowDetailTemplate(rowDetailDivArr , 200),
				initrowdetails: GRID_PARAM_DETAILS.initrowdetails,
				columns: Columns,
				groups: ['infoTypeId'],
				groupsexpandedbydefault:true,
				pagesize: 20
			});

	}