var _repositoryId = $("#repositoryId").val();    
var GRID_PARAM = {};
var isAdmin =0;
var gridObj;
var groupGridObj;
var userGridObj;
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
	if(gridObj.jqxGrid('selectionmode') == 'singlerow'){
		gridObj.jqxGrid({selectionmode:'checkbox'});
	}else{
		gridObj.jqxGrid({selectionmode:'singlerow'});
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
GRID_PARAM.toggleGroupSearchBoxes = function(){
	groupGridObj.jqxGrid({
            showfilterrow: !(groupGridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}
GRID_PARAM.toggleUserSearchBoxes = function(){
	userGridObj.jqxGrid({
            showfilterrow: !(userGridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}
GRID_PARAM.getCheckedIdList= function(idDataAttribute){
    var rows = gridObj.jqxGrid('selectedrowindexes');
    var dataList=[];
    $.each(rows, function(i, rowIndex){
    	var rowData = gridObj.jqxGrid('getrowdata', rowIndex);
    	dataList[i] = rowData.eventId;
    });
    var temp= dataList.toString();
    return temp;
}

GRID_PARAM.getDeleteList = function(idDataAttribute){
	
}


GRID_PARAM.onContextMenuItemClick =function (venue) 
{
	var args = venue.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM.onRowClick =function (venue) 
{
	var grid = gridObj;
	var args = venue.args;
	// row's bound index.
	var boundIndex = args.rowindex;
	// row's visible index.
	var visibleIndex = args.visibleindex;
	// right click.
	var rowData = gridObj.jqxGrid('getrowdata', boundIndex);
	isAdmin = rowData.isAdmin;
	

	if (args.column.text == rowMenuColumnText) {
		GRID_PARAM.prepareContextMenu();
		var heightCTXMenu = isAdmin == 0 ? 35 : 87;
		// create context menu
		var contextMenu = $("#" + rowMenuDivId).jqxMenu({
			width : 160,
			height : heightCTXMenu,
			autoOpenPopup : false,
			mode : 'popup'
		});
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		editrow = venue.args.rowindex;
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
GRID_PARAM.prepareContextMenu = function(){
//	$("#grpCtxtMenu").remove();
	var ulEle = "<div id='grpCtxtMenu'><ul>";
	if(isAdmin == 1){
		ulEle = ulEle + "<li>Edit</li>";
		ulEle = ulEle + "<li>Invite Group</li>";
		ulEle = ulEle + "<li>Invite Friend</li>";
		ulEle = ulEle + "<li>Delete</li>";
	}else{
		ulEle = ulEle + "<li>Leave Tailgate</li>";
	}
	ulEle = ulEle + "</ul></div>";
	$("#tailgateActionMenu").append(ulEle);
	
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
		function formatUnixToTime(tdate)
		{
			var date = new Date(tdate);
			var hours = date.getHours();
			var minutes = "0" + date.getMinutes();
			var ampm = hours >= 12 ? 'PM' : 'AM';
			hours = hours % 12;
			return hours + ':' + minutes.substr(-2) + ' ' + ampm;
		}
		  var tabsdiv = null; 
		    tabsdiv = $($(parentElement).children()[0]);
		    if (tabsdiv != null) {
		  var eventDiv = tabsdiv.find('.event');
		  var container1 = $('<div class="row-fluid"></div>');
		  var leftcolumn = $('<div class="span3 GridLogo"></div>');
		  var rightcolumn = $('<div class="span9"></div>');
		  var d = new Date(datarecord.eventDate);
		  var d1 = formatUnixToTime(datarecord.startTime);
		  var d2 = formatUnixToTime(datarecord.endTime);
			container1.append(leftcolumn);
			container1.append(rightcolumn);
			
			$(rightcolumn).append("<table>");		
			var imgLogoURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+datarecord.eventImageUUID+"&groupId="+datarecord.eventImageGroupId;
			var objLogodiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgLogoURL+')'});
			
			objLogodiv.appendTo(leftcolumn);
			var venueId = "<tr><td class='filledWidth1'><b>Venue:</b></td><td> "
					+ datarecord.venueName + "</td></tr>";
			var EventDate = "<tr><td class='filledWidth1'><b>Event Date:</b></td><td> "
				+ GRID_PARAM.formatDate(d) + "</td></tr>";		
			var StartTime = "<tr><td class='filledWidth1'><b>Start Time:</b></td><td> "
				+ d1 + "</td></tr>";
			var EndTime = "<tr><td class='filledWidth1'><b>End Time:</b></td><td> "
				+ d2 + "</td></tr>";
			
			$(rightcolumn).append(venueId);
			$(rightcolumn).append(EventDate);
			$(rightcolumn).append(StartTime);
			$(rightcolumn).append(EndTime);
			$(rightcolumn).append("</table>");
			eventDiv.append(container1);
			
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
		//grid.jqxGrid('destroy');
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
			return '<i class="icon-wrench" style="margin:3px;"></i>';
		}
		
		var groupColumns = [{ text: 'Tailgate', columntype: 'textbox',  datafield: 'tailgateName', width: '15%' },
		{ text: 'Description', datafield: 'tailgateDescription', width: '30%'},
		{ text: 'Event Name', datafield: 'eventName', width: '10%'},
		{ text: 'Date', datafield: 'tailgateDate', width: '10%'},
		{ text: 'Start Time', datafield: 'startTime', width: '10%'},
		{ text: 'End Time', datafield: 'endTime', width: '10%'},
		{ text: 'Role', datafield: 'tailgateRole', width: '10%'},
		{ text: 'Edit',  datafield: 'tailgateId', width: '5%', cellsalign: 'center', cellsrenderer: actionRenderer}];
		
		grid.on('cellclick', GRID_PARAM.onRowClick);
		//set menu item click
		_contextMenuHandler = contextMenuHandler
		$('#' + rowMenuDivId).on('itemclick',GRID_PARAM.onContextMenuItemClick);
		
		grid.on('contextmenu', function() {
		return false;
		});

	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM.source(model, data));
    grid.jqxGrid(
            {
                width: '100%',
                height : '250',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
                autoheight: true,
                pageable : true,
                pagermode : 'default',
                rowdetails: true,
                showrowdetailscolumn:false,
                rowdetailstemplate: GRID_PARAM.rowDetailTemplate(rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM.initrowdetails,
                columns: groupColumns
            });
    
	}

function fnRenderLogo(imageUUID, imageGroupId,container ,editable){
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')'});
	$(objdiv).appendTo($(container));
	if(editable){
    	$(objdiv).click(function(){
	    	$(this).toggleClass("activeImage");
	    	if($(".activeImage").length>0){
	    		if(iSelected==false){
	    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
	    			$(objDel).appendTo($(container));
	    			iSelected = true;
	    			$(objDel).click(function(){
	    				$("#spinningSquaresG").show();
	    				$(".activeImage").each(function(){
	    					fnDeleteFileByEntryId($(this).attr("data-fileEntryId"),objDel);
	    					$(this).remove();
	    				});
	    				if($(".activeImage").length==0){
	    					$("#spinningSquaresG").hide();
	    					$(this).remove();
	    					iSelected = false;
	    				}
	    			});
	    		}
	    	}
	    	else{
	    		$(".cssDelImages").remove();
	    		iSelected = false;
	    	}
	    });	
    	
    }
}

GRID_PARAM.formatDate = function (dateVal){
	var dateObj = new Date(dateVal);
	return dateObj.toLocaleDateString(); 
}
/*
 *  Create User Table
 */
function createTailgateUserTable(data, grid){
//	grid.jqxGrid("refresh");
    var eventsColumns = [{ text: 'First Name', columntype: 'textbox',  datafield: 'firstName', width: '20%' },
    	 { text: 'Last Name', datafield: 'lastName', width: '20%'},
    	 { text: 'Screen Name', datafield: 'screenName',  width: '20%'},
    	 { text: 'Email', datafield: 'emailAddress',  width: '37.5%'}];
    var source = {
			 localdata:data,
			 datatype:'array',
			 datafields: [
			              	{name: 'firstName', type: 'string' },
			              	{name: 'lastName', type: 'string' },
		                    {name: 'screenName', type: 'string' },
		                    {name:'emailAddress',type:'string'},
		                    {name:'userId',type:'string'}
		                ],
		     id : 'userId'           
	 };
    userGridObj = grid;
	var dataAdapter = new $.jqx.dataAdapter(source);
    grid.jqxGrid(
            {
                width: '100%',
                height : '250',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
             // Pageing config
                pageable : true,
                pagermode : 'default',
                rowdetails: true,
                selectionmode: 'checkbox',
                showrowdetailscolumn:false,
//                rowdetailstemplate: GRID_PARAM_CAMPAIGN.rowDetailTemplate(rowDetailDivArr , 200),
//                initrowdetails: GRID_PARAM_CAMPAIGN.initrowdetails,
                columns: eventsColumns
            });
    
	}
/*
 *  Create Group Table
 */
function createTailgateGroupTable(data, grid){
//	grid.jqxGrid("refresh");
    var eventsColumns = [{ text: 'Group Name', columntype: 'textbox',  datafield: 'groupName', width: '25%' },
    	 { text: 'Description', datafield: 'groupDescription', width: '50%'},
    	 { text: 'Created By', datafield: 'createdBy',  width: '25%'}];
    var source = {
			 localdata:data,
			 datatype:'array',
			 datafields: [
			              	{name: 'groupName', type: 'string' },
			              	{name: 'groupDescription', type: 'string' },
		                    {name: 'createdBy', type: 'string' },
		                    {name:'groupId',type:'string'}
		                ],
		     id : 'groupId'           
	 };
    groupGridObj = grid;
	var dataAdapter = new $.jqx.dataAdapter(source);
    grid.jqxGrid(
            {
                width: '100%',
                height : '250',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
             // Pageing config
                pageable : true,
                pagermode : 'default',
                rowdetails: true,
                selectionmode: 'checkbox',
                showrowdetailscolumn:false,
//                rowdetailstemplate: GRID_PARAM_CAMPAIGN.rowDetailTemplate(rowDetailDivArr , 200),
//                initrowdetails: GRID_PARAM_CAMPAIGN.initrowdetails,
                columns: eventsColumns
            });
    
	}