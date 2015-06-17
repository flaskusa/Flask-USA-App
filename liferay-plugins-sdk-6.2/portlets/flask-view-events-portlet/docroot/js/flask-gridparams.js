    
var GRID_PARAM = {};

var gridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel
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




GRID_PARAM.onContextMenuItemClick =function (event) 
{
	var args = event.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}


GRID_PARAM.initrowdetails = function(index, parentElement, gridElement, datarecord){
	 var tabsdiv = null; 
  
    tabsdiv = $($(parentElement).children()[0]);
    if (tabsdiv != null) {
    	
		var venueDiv = tabsdiv.find('.venue');
		var imagesDiv = tabsdiv.find('.images');
		
		var container1 = $('<div class="row-fluid"></div>');
		
		var container2 = $('<div class="row-fluid"></div>');
		venueDiv.append(container1);
		
		var leftcolumn = $('<div class="span5"></div>');
		var rightcolumn = $('<div class="span5"></div>');
		
		container1.append(leftcolumn);
		container1.append(rightcolumn);
	
		var venue_Name = "<tr><td class='filledWidth'> <b>venue Name:</b></td><td> "
			+ datarecord.venueName + "</td></tr>";
	    var venue_Description = "<tr><td class='filledWidth'><b>venue Description:</b></td><td> "
			+ datarecord.venueDescription + "</td></tr>";
	    var addrLine_1 = "<tr><td class='filledWidth'><b>AddrLine 1:</b></td><td> "
			+ datarecord.addrLine1 + "</td></tr>";
		var addrLine_2 = "<tr><td class='filledWidth'> <b>addrLine 2:</b></td><td>"
				+ datarecord.addrLine2 + "</td></tr>";
		var venue_ZipCode = "<tr><td class='filledWidth'><b>ZipCode:</b></td><td>"
				+ datarecord.venueZipCode + "</td></tr>";
		var City = "<tr><td class='filledWidth1'><b>City:</b></td><td> "
				+ datarecord.venueCity + "</td></tr>";
		var Metro = "<tr><td class='filledWidth1'><b>Metro Area:</b></td><td> "
			+ datarecord.venueMetroArea + "</td></tr>";	
		var State = "<tr><td class='filledWidth1'><b>State:</b></td><td> "
				+ datarecord.stateName + "</td></tr>";
		var Country = "<tr><td class='filledWidth1'><b>Country:</b></td><td> "
				+ datarecord.countryName + "</td></tr>";		
		$(leftcolumn).append("<table>");
		
		$(leftcolumn).append(venue_Name);
		$(leftcolumn).append(venue_Description);
		$(leftcolumn).append(addrLine_1);
		$(leftcolumn).append(addrLine_2);
		$(leftcolumn).append(venue_ZipCode);
		$(leftcolumn).append("</table>");
		
		$(rightcolumn).append("<table>");
		
		
		$(rightcolumn).append(City);
		$(rightcolumn).append(Metro);
		$(rightcolumn).append(State);
		$(rightcolumn).append(Country);
		
		$(rightcolumn).append("</table>");		
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
    
    var vanueColumns = [{ text: 'Name', columntype: 'textbox',  datafield: 'venueName', width: '30%' },
    	 {
    	     text: 'Description', datafield: 'venueDescription', width: '30%'
    	 },
    	 { text: 'City', datafield: 'venueCity',  width: '20%'},
    	 { text: 'Metro Area', datafield: 'venueMetroArea', width: '15%'},
    	 { text: 'Edit',  datafield: 'venueId', width: '5%', cellsalign: 'center', cellsrenderer: actionRenderer}];
    	
    
    
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
                pagesize : 3,
                pagermode : 'simple',
                rowdetails: true,
                showrowdetailscolumn:false,
                rowdetailstemplate: GRID_PARAM.rowDetailTemplate(rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM.initrowdetails,
                columns: vanueColumns
            });
    
	}

		