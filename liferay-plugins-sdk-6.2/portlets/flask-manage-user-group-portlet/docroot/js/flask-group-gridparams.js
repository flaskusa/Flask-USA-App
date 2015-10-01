    
var GRID_PARAM_GROUP = {};
var isAdmin = 0;
var gridContainerId;
var gridObj;
var userGridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel
var _contextMenuHandler;
GRID_PARAM_GROUP.source = function(model, data){
	return {
			localdata: data,
			datafields: model,
			datatype: "json"
	};	
}
GRID_PARAM_GROUP.updateGrid = function(data){
	var dataAdapter =  new $.jqx.dataAdapter(GRID_PARAM_GROUP.source(_dataModel, data));
	gridObj.jqxGrid({ source: dataAdapter });
}
GRID_PARAM_GROUP.toggleSelectionMode= function(){
	if(gridObj.jqxGrid('selectionmode') == 'checkbox'){
		gridObj.jqxGrid({selectionmode:'singlerow'});
	}else{
		gridObj.jqxGrid({selectionmode:'checkbox'});
	}
	
}
GRID_PARAM_GROUP.toggleSearchBoxes = function(){
	gridObj.jqxGrid({
            showfilterrow: !(gridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}
GRID_PARAM_GROUP.toggleUserSearchBoxes = function(){
	userGridObj.jqxGrid({
            showfilterrow: !(userGridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}

GRID_PARAM_GROUP.getCheckedIdList= function(idDataAttribute){
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

GRID_PARAM_GROUP.getCheckedUsersList = function(){
	 var rows = userGridObj.jqxGrid('selectedrowindexes');
	    var userList=[];
	    $.each(rows, function(i, rowIndex){
	    	var rowData = userGridObj.jqxGrid('getrowdata', rowIndex);
	    	userList.push(rowData);
	    });
	    return userList;
}

GRID_PARAM_GROUP.getDeleteList = function(idDataAttribute){
	
}


GRID_PARAM_GROUP.onContextMenuItemClick =function (event) 
{
	var args = event.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM_GROUP.onRowClick =function (event) 
{
	var grid = gridObj;
	var args = event.args;
	// row's bound index.
	var boundIndex = args.rowindex;
	// row's visible index.
	var visibleIndex = args.visibleindex;
	// right click.
	var rowData = gridObj.jqxGrid('getrowdata', boundIndex);
	isAdmin = rowData.isAdmin;

	if (args.column.text == rowMenuColumnText) {
//		$('#' + rowMenuDivId[isAdmin]).on('itemclick',GRID_PARAM_GROUP.onContextMenuItemClick);
		GRID_PARAM_GROUP.prepareContextMenu();
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
		editrow = event.args.rowindex;
		var rowsheight = grid.jqxGrid('rowsheight');
		var top = $(this).offset().top + (2 + editrow) * rowsheight;
		var left = ($(this).offset().left + parseInt($('#'+gridContainerId).css('width'), 10)) - parseInt($('#' + rowMenuDivId).css('width'), 10) - 25;
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

GRID_PARAM_GROUP.prepareContextMenu = function(){
//	$("#grpCtxtMenu").remove();
	var ulEle = "<div id='grpCtxtMenu'><ul>";
	if(isAdmin == 1){
		ulEle = ulEle + "<li>Add Friend</li>";
		ulEle = ulEle + "<li>Add Owner</li>";
		ulEle = ulEle + "<li>Delete Group</li>";
	}else{
		ulEle = ulEle + "<li>Leave Group</li>";
	}
	ulEle = ulEle + "</ul></div>";
	$("#groupActionMenu").append(ulEle);
	
};


GRID_PARAM_GROUP.rowDetailTemplate = function(tabs, height)  
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

GRID_PARAM_GROUP.initrowdetails = function(index, parentElement, gridElement, datarecord){
	 var tabsdiv = null; 
  
    tabsdiv = $($(parentElement).children()[0]);
    if (tabsdiv != null) {
    	
    	var rowindex = gridObj.jqxGrid('getselectedrowindex');
    	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
    	
		var groupInfoDiv = tabsdiv.find('.group');
		var memberInfoDiv = tabsdiv.find('.members');
		prepareMemberTable(memberInfoDiv);
//		var imagesDiv = tabsdiv.find('.images');
		
		var container1 = $('<div class="row-fluid" id="GroupDetailsId"></div>');
		
//		var container2 = $('<div  id="loaderDetail"><table><tr><td><img src = "/flask-manage-advertisement-portlet/img/Preloader_21.gif" /></td></tr></table></div>');
		groupInfoDiv.append(container1);
//		groupInfoDiv.append(container2);
		
		
		var leftcolumn = $('<div class="span5"></div>');
		var rightcolumn = $('<div class="span5"></div>');
		
		container1.append(leftcolumn);
		container1.append(rightcolumn);
	
		var group_Name = "<tr><td class='filledWidth'> <b>Group Name:</b></td><td> "
			+ datarecord.groupName + "</td></tr>";
	    var group_description = "<tr><td class='filledWidth'><b>Group Desc:</b></td><td><textarea style='border:none;width:240px;height:70px;background-color:white;margin:0px;' wrap='hard' readonly='true'>"
			+ datarecord.groupDescription + "</textarea></td></tr>";
	    var createdBy = "<tr><td class='filledWidth'><b>Created By:</b></td><td> "
			+ datarecord.createdBy + "</td></tr>";
		var createdDate = "<tr><td class='filledWidth'> <b>Created Date:</b></td><td>"
				+ datarecord.createdDate + "</td></tr>";
		//var groupMembers = "<tr><td class='filledWidth'> <b>Group Members:</b></td>" +"<td><a href='#' onclick='showAddGroupOwnerForm("+ datarecord +")'>Show group members</a></td></tr>";
		
		
		
		$(leftcolumn).append("<table class='table'>");
		
		$(leftcolumn).append(group_Name);
		$(leftcolumn).append(group_description);
		
		$(leftcolumn).append("</table>");
		
		$(rightcolumn).append("<table class='table'>");
		$(rightcolumn).append(createdBy);
		$(rightcolumn).append(createdDate);
		//$(rightcolumn).append(groupMembers);
		$(rightcolumn).append("</table>");
		$(tabsdiv).jqxTabs({
			width : '90%',
			height : 180
		});
    }
}

/*
 *  This method creates grid for My Group
 */
function createMyGroupTable(data, model, grid, menuDivId, actionColText,contextMenuHandler, detailDivArr, containerId){
	
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
		rowDetailDivArr = detailDivArr;
		gridContainerId = containerId;
		
    var actionRenderer = function(row, columnfield, value, defaulthtml, columnproperties) {
						return '<i class="icon-wrench" style="margin:3px;cursor:pointer"></i>';
	}
    
    var groupColumns = [{ text: 'Name', columntype: 'textbox',  datafield: 'groupName', width: '30%' },
    	 { text: 'Description', datafield: 'groupDescription'},
    	 { text: 'Role', datafield: 'isGroupAdmin', width: '20%'},
    	 { text: 'Edit',  datafield: 'groupId', width: '34px', cellsalign: 'center', cellsrenderer: actionRenderer}];
    
    grid.on('cellclick', GRID_PARAM_GROUP.onRowClick);
    //set menu item click
    _contextMenuHandler = contextMenuHandler
	$('#' + rowMenuDivId).on('itemclick',GRID_PARAM_GROUP.onContextMenuItemClick);
	
	grid.on('contextmenu', function() {
		return false;
	});

	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM_GROUP.source(model, data));
    grid.jqxGrid(
            {
                width: '100%',
                height : '350px',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
             // Pageing config
                pageable : false,
                pagermode : 'default',
                rowdetails: true,
                showrowdetailscolumn:false,
                rowdetailstemplate: GRID_PARAM_GROUP.rowDetailTemplate(rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM_GROUP.initrowdetails,
                columns: groupColumns
            });
    
	}

/*
 *  Create User Table
 */
function createUserTable(data, grid){
//	grid.jqxGrid("refresh");
    var eventsColumns = [{ text: 'First Name', columntype: 'textbox',  datafield: 'firstName', width: '30%' },
    	 { text: 'Last Name', datafield: 'lastName', width: '30%'},
    	 { text: 'Email', datafield: 'emailAddress',  width: '40%'}];
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
                pageable : true,
                pagermode : 'default',
                rowdetails: true,
                selectionmode: 'checkbox',
                showrowdetailscolumn:false,
                columns: eventsColumns
            });
    
	}


		