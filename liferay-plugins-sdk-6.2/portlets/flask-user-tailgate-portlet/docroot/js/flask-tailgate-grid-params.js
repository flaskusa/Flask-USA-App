var _repositoryId = $("#repositoryId").val();    
var GRID_PARAM = {};
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
GRID_PARAM.getCheckedUsersList = function(){
	 var rows = userGridObj.jqxGrid('selectedrowindexes');
	    var userList=[];
	    $.each(rows, function(i, rowIndex){
	    	var rowData = userGridObj.jqxGrid('getrowdata', rowIndex);
	    	userList.push(rowData);
	    });
	    return userList;
}
GRID_PARAM.getCheckedGroupList = function(){
	 var rows = groupGridObj.jqxGrid('selectedrowindexes');
	    var groupList=[];
	    $.each(rows, function(i, rowIndex){
	    	var rowData = groupGridObj.jqxGrid('getrowdata', rowIndex);
	    	groupList.push(rowData);
	    });
	    return groupList;
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
	

	if (args.column.text == rowMenuColumnText) {
		GRID_PARAM.prepareContextMenu();
		var heightCTXMenu = isAdmin == 0 ? 35 : 110;
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


function formatUnixToTime(tdate)
{
	var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var ampm = hours >= 12 ? 'PM' : 'AM';
	hours = hours % 12;
	return hours + ':' + minutes.substr(-2) + ' ' + ampm;
}

GRID_PARAM.initrowdetails = function(index, parentElement, gridElement, datarecord){
	var tabsdiv = null; 
    tabsdiv = $($(parentElement).children()[0]);
    if (tabsdiv != null) {
    	
		var venueDiv = tabsdiv.find('.tailgate');
		var imagesDiv = tabsdiv.find('.images');
		
		var container1 = $('<div class="row-fluid"></div>');
		
		var container2 = $('<div class="row-fluid"></div>');
		venueDiv.append(container1);
		
		var leftcolumn = $('<div class="span5"></div>');
		var rightcolumn = $('<div class="span5"></div>');
		var rightButtoncolumn = $('<div class="span2" style="padding:20px"></div>');
		var d = new Date(datarecord.tailgateDate);
		var d1 = formatUnixToTime(datarecord.startTime);
		var d2 = formatUnixToTime(datarecord.endTime);
		container1.append(leftcolumn);
		container1.append(rightcolumn);
		container1.append(rightButtoncolumn);
	
		var tailgate_Name = "<tr><td class='filledWidth'> <b>Name:</b></td><td> "
			+ datarecord.tailgateName + "</td></tr>";
		var tailgate_Description = "<tr><td class='filledWidth'><b>Group Desc:</b></td><td><textarea style='border:none;width:240px;height:70px;background-color:white;margin:0px;' wrap='hard' readonly='true'>"
			+ datarecord.tailgateDescription + "</textarea></td></tr>";
	    var eventName = "<tr><td class='filledWidth'><b>Event Name :</b></td><td> "
			+ datarecord.eventName + "</td></tr>";
	    var eventDate = "<tr><td class='filledWidth'><b>Tailgate Date :</b></td><td> "
			+ GRID_PARAM.formatDate(d) + "</td></tr>";
		var startTime = "<tr><td class='filledWidth'> <b>Start Time:</b></td><td>"
			+ d1 + "</td></tr>";
		var endTime = "<tr><td class='filledWidth'><b>End Time:</b></td><td>"
			+ d2 + "</td></tr>";
		var table1= $("<table/>")
		$(table1).append(tailgate_Name);
		$(table1).append(tailgate_Description);
		table1.appendTo(leftcolumn);
		
		var table2= $("<table/>")
		$(table2).append(eventName);
		$(table2).append(eventDate);
		$(table2).append(startTime);
		$(table2).append(endTime);
		table2.appendTo(rightcolumn);	

		var table3= $("<table/>")
		var amountToPay = "<tr><td class='filledWidth'><b>Fees:</b></td><td>$"+datarecord.amountToPay + "</td></tr>";
		var ButtonToPay = "<tr><td class='filledWidth' colspan='2'><a href='#' class='btnPay' onclick='fnPayNow("+datarecord.tailgateId+")'>Pay Now</a></td></tr>";
		$(table3).append(amountToPay);
		$(table3).append(ButtonToPay);
		$(rightButtoncolumn).append(table3);		
		var container = $('<div/>');
		fnGetEventDetailImages(datarecord.tailgateId,imagesDiv, false);		
  	  	$(container).appendTo($(imagesDiv));
		
		$(tabsdiv).jqxTabs({
			width : '98%',
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
		
		var cellsrenderer = function(row, column, value, defaultHtml, columnSettings, rowData) {
			return formatUnixToTime(value);
		}		
		
		var datecellsrenderer = function(row, column, value, defaultHtml, columnSettings, rowData) {
			return GRID_PARAM.formatDate(value);
		}
		
		var groupColumns = [{ text: 'Tailgate', columntype: 'textbox',  datafield: 'tailgateName'},
		{ text: 'Event Name', datafield: 'eventName', width: '20%'},
		{ text: 'Date', datafield: 'tailgateDate', width: '20%',cellsrenderer:datecellsrenderer},
		{ text: 'Start Time', datafield: 'startTime', width: '15%',cellsrenderer:cellsrenderer},
		{ text: 'Edit',  datafield: 'tailgateId', width: '34px', cellsalign: 'center', cellsrenderer: actionRenderer}];
		
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
                height : '350px',
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
	console.log(data);
    var eventsColumns = [{ text: 'First Name', columntype: 'textbox',  datafield: 'firstName', width: '30%' },
    	 { text: 'Last Name', datafield: 'lastName', width: '30%'},
    	 { text: 'Email', datafield: 'emailAddress',  width: '37.5%'}];
    var source = {
			 localdata:data,
			 datatype:'array',
			 datafields: [
			              	{name: 'firstName', type: 'string' },
			              	{name: 'lastName', type: 'string' },
			              	{name: 'lastName', type: 'string' },
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
                //rowdetailstemplate: GRID_PARAM_CAMPAIGN.rowDetailTemplate(rowDetailDivArr , 200),
                //initrowdetails: GRID_PARAM_CAMPAIGN.initrowdetails,
                columns: eventsColumns
            });
    
	}

function createTailgateMemberTable(data, grid){
//	grid.jqxGrid("refresh");
	 var datecellsrenderer = function(row, column, value, defaultHtml, columnSettings, rowData) {
		  if(value == 1)
			  return "Yes";
		  else
			  return "No";
	 }
	 
	 var recordcellsrenderer = function(row, column, value, defaultHtml, columnSettings, rowData) {
		 console.log(rowData);
		  if(value == 1)
			  return "Yes []";
		  else
			  return "No";
	 }
	 //recordcellsrenderer
	 if(isAdmin == 1){
	 var eventsColumns = [{ text: 'User Name', columntype: 'textbox',  datafield: 'userName', width: '33.33%' },
	                      { text: 'Email', datafield: 'emailAddress', width: '33.33%'},
	                      { text: 'Is Paid?', datafield: 'isPaid', width: '33.33%', cellsrenderer: datecellsrenderer}];
	 //,{ text: 'Payment Mode', datafield: 'paymentMode', width: '16.66%'}
	 }else{
		 var eventsColumns = [{ text: 'User Name', columntype: 'textbox',  datafield: 'userName', width: '50%' },
		                      { text: 'Email', datafield: 'emailAddress', width: '50%'}];
	 }
	 var source = {
			 localdata:data,
			 datatype:'array',
			 datafields: [
			              {name: 'userName', type: 'string' },
			              {name: 'emailAddress', type: 'string' },
			              {name: 'isAdmin',type:'string'},
			              {name: 'isPaid',type:'string'},
			              {name: 'paymentMode',type:'string'},
			              {name: 'userId',type:'string'}
			              ],
			              id : 'userId'};
	 
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
                //selectionmode: 'checkbox',
                showrowdetailscolumn:false,
                //rowdetailstemplate: GRID_PARAM_CAMPAIGN.rowDetailTemplate(rowDetailDivArr , 200),
                //initrowdetails: GRID_PARAM_CAMPAIGN.initrowdetails,
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
    	 { text: 'Created By', datafield: 'createdBy',  width: '22.5%'}];
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
GRID_PARAM.formatDate = function (dateVal){
	var dateObj = new Date(dateVal);
	return dateObj.toLocaleDateString(); 
}
