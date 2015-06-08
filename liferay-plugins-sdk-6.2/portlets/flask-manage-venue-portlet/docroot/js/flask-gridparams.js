    
var GRID_PARAM = {};

var gridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel
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

GRID_PARAM.contextMenuClick =  function (event){
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
};


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

GRID_PARAM.initrowdetails = function(index, parentElement, gridElement, datarecord){
	 var tabsdiv = null; 
  
    tabsdiv = $($(parentElement).children()[0]);
    if (tabsdiv != null) {
    	
		var venueDiv = tabsdiv.find('.venue');
		var imagesDiv = tabsdiv.find('.images');
		
		var container1 = $('<div class="row-fluid">The is venue div</div>');
		
		var container2 = $('<div class="row-fluid">The is image div</div>');
		venueDiv.append(container1);
		imagesDiv.append(container2);
		
    	$(tabsdiv).jqxTabs({
			width : '90%',
			height : 180
		});
    }
}

/*
 *  This method creates grid
 */
function createTable(data, model, grid, menuDivId, actionColText, detailDivArr){
	
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
    
    var vanueColumns = [{ text: 'Name', columntype: 'textbox',  datafield: 'venueName', width: '30%' },
    	 {
    	     text: 'Description', datafield: 'venueDescription', width: '30%'
    	 },
    	 { text: 'City', datafield: 'venueCity',  width: '20%'},
    	 { text: 'Metro Area', datafield: 'metroArea', width: '15%'},
    	 { text: 'Edit',  datafield: 'venueId', width: '5%', cellsalign: 'center', cellsrenderer: actionRenderer}];
    	
    
    
    grid.on('cellclick', GRID_PARAM.onRowClick);
    //set menu item click
	$('#' + rowMenuDivId).on('itemclick',GRID_PARAM.contextMenuClick);
	
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
                rowdetails: true,
                showrowdetailscolumn:false,
                rowdetailstemplate: GRID_PARAM.rowDetailTemplate(rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM.initrowdetails,
                columns: vanueColumns
            });
    
	}

		