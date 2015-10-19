    
var GridParam = function(){};

var GRID_PARAM_CAMPAIGN = new GridParam();


GRID_PARAM_CAMPAIGN.gridObj = {};
GRID_PARAM_CAMPAIGN.eventGridObj = {};
GRID_PARAM_CAMPAIGN.rowMenuDivId = {};
GRID_PARAM_CAMPAIGN.rowMenuColumnText = {};
GRID_PARAM_CAMPAIGN.rowDetailDivArr= {};
GRID_PARAM_CAMPAIGN._dataModel = {};
GRID_PARAM_CAMPAIGN._campaignContextMenuHandler = {};


GRID_PARAM_CAMPAIGN.source = function(model, data){
	return {
			localdata: data,
			datafields: model,
			datatype: "json"
	};	
}
GRID_PARAM_CAMPAIGN.updateGrid = function(data){
	var dataAdapter =  new $.jqx.dataAdapter(GRID_PARAM_CAMPAIGN.source(GRID_PARAM_CAMPAIGN._dataModel, data));
	GRID_PARAM_CAMPAIGN.gridObj.jqxGrid({ source: dataAdapter });
}
GRID_PARAM_CAMPAIGN.toggleSelectionMode= function(){
	if(GRID_PARAM_CAMPAIGN.gridObj.jqxGrid('selectionmode') == 'checkbox'){
		GRID_PARAM_CAMPAIGN.gridObj.jqxGrid({selectionmode:'singlerow'});
	}else{
		GRID_PARAM_CAMPAIGN.gridObj.jqxGrid({selectionmode:'checkbox'});
	}
	
}
GRID_PARAM_CAMPAIGN.toggleSearchBoxes = function(){
	GRID_PARAM_CAMPAIGN.gridObj.jqxGrid({
            showfilterrow: !(GRID_PARAM_CAMPAIGN.gridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}

GRID_PARAM_CAMPAIGN.getCheckedIdList= function(idDataAttribute){
    var rows = GRID_PARAM_CAMPAIGN.gridObj.jqxGrid('selectedrowindexes');
    var dataList="";
    $.each(rows, function(i, rowIndex){
    	var rowData = GRID_PARAM_CAMPAIGN.gridObj.jqxGrid('getrowdata', rowIndex);
    	dataList += eval('rowData.'+ idDataAttribute);
    	if(i !== rows.length - 1)
    		dataList += ", ";
    });
    return dataList;
}

GRID_PARAM_CAMPAIGN.getCheckedEventIdList = function(idDataAttribute){
	 var rows = eventGridObj.jqxGrid('selectedrowindexes');
	    var dataList="";
	    $.each(rows, function(i, rowIndex){
	    	var rowData = eventGridObj.jqxGrid('getrowdata', rowIndex);
	    	var id = eval('rowData.'+ idDataAttribute);
	    	if(i !== rows.length -1){
	    		dataList = dataList + id + ",";
	    	}else{
	    		dataList = dataList + id;
	    	}
	    });
	    return dataList;
}


GRID_PARAM_CAMPAIGN.getDeleteList = function(idDataAttribute){
	
}


GRID_PARAM_CAMPAIGN.onContextMenuItemClick =function (event) 
{
	var args = event.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = GRID_PARAM_CAMPAIGN.gridObj.jqxGrid('getselectedrowindex');
	var rowData = GRID_PARAM_CAMPAIGN.gridObj.jqxGrid('getrowdata', rowindex);
	GRID_PARAM_CAMPAIGN._campaignContextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM_CAMPAIGN.onRowClick =function (event) 
{
	var grid = GRID_PARAM_CAMPAIGN.gridObj;
	var args = event.args;
	// row's bound index.
	var boundIndex = args.rowindex;
	// row's visible index.
	var visibleIndex = args.visibleindex;
	// right click.
	
	

	if (args.column.text == GRID_PARAM_CAMPAIGN.rowMenuColumnText) {
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		editrow = event.args.rowindex;
		var rowsheight = grid.jqxGrid('rowsheight');
		var top = $(this).offset().top + (2 + editrow) * rowsheight;
		var left = ($(this).offset().left + parseInt($('#manageCampaignContainer').css('width'), 10)) - parseInt($('#' + GRID_PARAM_CAMPAIGN.rowMenuDivId).css('width'), 10) - 25;
		$('#' +GRID_PARAM_CAMPAIGN.rowMenuDivId).jqxMenu('open', left, top + 5 + scrollTop);
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




GRID_PARAM_CAMPAIGN.rowDetailTemplate = function(tabs, height)  
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

GRID_PARAM_CAMPAIGN.initrowdetails = function(index, parentElement, gridElement, datarecord){
	 var tabsdiv = null; 
  
    tabsdiv = $($(parentElement).children()[0]);
    if (tabsdiv != null) {
    	
		var campaignDiv = tabsdiv.find('.campaign');
		var imagesDiv = tabsdiv.find('.images');
    	var container = $('<div/>');
    	fnGetCampaignImages(datarecord.campaignId,container, false);
  	  	$(container).appendTo($(imagesDiv));
  	  	
		var container1 = $('<div class="row-fluid"></div>');
		
		var container2 = $('<div class="row-fluid"></div>');
		campaignDiv.append(container1);
		
		var leftcolumn = $('<div class="span5"></div>');
		var rightcolumn = $('<div class="span5"></div>');
		
		container1.append(leftcolumn);
		container1.append(rightcolumn);
	
		var campaign_Name = "<tr><td class='filledWidth'> <b>Campaign Name:</b></td><td> "
			+ datarecord.campaignName + "</td></tr>";
	    var customer_Name = "<tr><td class='filledWidth'><b>Customer Name:</b></td><td> "
			+ datarecord.customerName + "</td></tr>";
	  
		var display_At = "<tr><td class='filledWidth'><b>Display At:</b></td><td>"
				+ datarecord.adDisplayTime + "</td></tr>";
		var frequency = "<tr><td class='filledWidth1'><b>Frequency:</b></td><td> "
				+ datarecord.frequencyPerHour + " impressions per hour </td></tr>";
			
		$(leftcolumn).append("<table>");
		
		$(leftcolumn).append(campaign_Name);
		$(leftcolumn).append(customer_Name);
		$(leftcolumn).append(display_At);
		$(leftcolumn).append(frequency);
		$(leftcolumn).append("</table>");
		
		$(tabsdiv).jqxTabs({
			width : '100%',
			height : 350
		});
    }
}

/*
 *  This method creates grid
 */
function createCampaignTable(data, model, grid, menuDivId, actionColText,contextMenuHandler, detailDivArr){
		if(typeof grid == undefined){
			throw 'a valid grid div object must be provided';
		}
		if(typeof actionColText == undefined){
			throw 'a columnheader needs to be provided to be used for click action';
		}
		if(typeof menuDivId == undefined){
			throw 'a valid menu div needs to be provided to be used for click action';
		}
		if (typeof detailDivArr == undefined){
			throw 'a valid detailDivArr needs to be provided for row detail';
		}
		
		if (typeof model == undefined){
			throw 'a valid model needs to be provided';
		}
		
		GRID_PARAM_CAMPAIGN._dataModel = model;
		GRID_PARAM_CAMPAIGN.rowMenuDivId = menuDivId;
		GRID_PARAM_CAMPAIGN.rowMenuColumnText =actionColText;
		GRID_PARAM_CAMPAIGN.gridObj = grid;
		GRID_PARAM_CAMPAIGN.rowDetailDivArr = detailDivArr
		
    var actionRenderer = function(row, columnfield, value, defaulthtml, columnproperties) {
						return '<i class="icon-wrench" style="margin:3px;"></i>'
	}
    
    var campaignColumns = [{ text: 'Campaign Name', columntype: 'textbox',  datafield: 'campaignName'},
    	 { text: 'Customer Name', datafield: 'customerName', width: '20%'},
    	 { text: 'Display Times', datafield: 'adDisplayTime', width: '30%'},
    	 { text: 'Frequency per hour', datafield: 'frequencyPerHour', width: '10%'},
    	 { text: 'Edit',  datafield: 'campaignId', width: '34px', cellsalign: 'center', cellsrenderer: actionRenderer}];
    	
    
    
    grid.on('cellclick', GRID_PARAM_CAMPAIGN.onRowClick);
    //set menu item click
    GRID_PARAM_CAMPAIGN._campaignContextMenuHandler = contextMenuHandler
	$('#' + GRID_PARAM_CAMPAIGN.rowMenuDivId).on('itemclick',GRID_PARAM_CAMPAIGN.onContextMenuItemClick);
	
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

	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM_CAMPAIGN.source(model, data));
    grid.jqxGrid(
            {
                width: '100%',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
                pageable : true,
                pagermode : 'simple',
                rowdetails: true,
                showrowdetailscolumn:false,
                autoheight: true,
                rowdetailstemplate: GRID_PARAM_CAMPAIGN.rowDetailTemplate(GRID_PARAM_CAMPAIGN.rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM_CAMPAIGN.initrowdetails,
                columns: campaignColumns,
                pagesize: 20
            });
	}

/*
 *  This method creates grid
 */
function createEventsTable(data, grid, eventsIndex){
    var eventsColumns = [{ text: 'Event Name', columntype: 'textbox',  datafield: 'eventName' },
    	 { text: 'Event Date', datafield: 'eventDate',  width: '30%'}];
    var source = {
			 localdata:data,
			 datatype:'array',
			 datafields: [
			              	{name: 'eventId', type: 'string' },
			              	{name: 'eventName', type: 'string' },
		                    {name: 'description', type: 'string' },
		                    {name:'eventDate',type:'string'},
		                ],
		     id : 'eventId'           
	 };
    eventGridObj = grid;
	var dataAdapter = new $.jqx.dataAdapter(source);
    grid.jqxGrid(
            {
                width: '80%',
                height:'350px',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 20,
                theme:	'custom',
                pageable : true,
                pagermode : 'default',
                rowdetails: true,
                selectionmode: 'checkbox',
                showrowdetailscolumn:false,
                columns: eventsColumns
            });
    if(eventsIndex){
    	$.each(eventsIndex,function(index, eventIndex){
    		eventGridObj.jqxGrid("selectrow",eventIndex);
    	});
    }
    
	}

		