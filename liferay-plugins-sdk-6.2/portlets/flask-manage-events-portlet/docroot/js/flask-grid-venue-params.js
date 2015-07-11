    
var GRID_PARAM_VENUE = {};

var gridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel
var _contextMenuHandler;
GRID_PARAM_VENUE.source = function(model, data){
	return {
			localdata: data,
			datafields: model,
			datatype: "json"
	};	
}
GRID_PARAM_VENUE.updateGrid = function(data){
	var dataAdapter =  new $.jqx.dataAdapter(GRID_PARAM_VENUE.source(_dataModel, data));
	gridObj.jqxGrid({ source: dataAdapter });
}
GRID_PARAM_VENUE.toggleSelectionMode= function(){
	if(gridObj.jqxGrid('selectionmode') == 'checkbox'){
		gridObj.jqxGrid({selectionmode:'singlerow'});
	}else{
		gridObj.jqxGrid({selectionmode:'checkbox'});
	}
	
}
GRID_PARAM_VENUE.toggleSearchBoxes = function(){
	gridObj.jqxGrid({
            showfilterrow: !(gridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}



GRID_PARAM_VENUE.getCheckedIdList= function(idDataAttribute){
    var rows = gridObj.jqxGrid('selectedrowindexes');
    var dataList=[];
    $.each(rows, function(i, rowIndex){
    	var rowData = gridObj.jqxGrid('getrowdata', rowIndex);
    	dataList[i] = rowData.venueId;
    	
    });
    var temp= dataList.toString();
    return temp;
}


GRID_PARAM_VENUE.getDeleteList = function(idDataAttribute){
	
}


GRID_PARAM_VENUE.onContextMenuItemClick =function (event) 
{
	var args = event.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM_VENUE.onRowClick =function (event) 
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




GRID_PARAM_VENUE.rowDetailTemplate = function(tabs, height)  
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

GRID_PARAM_VENUE.initrowdetails = function(index, parentElement, gridElement, datarecord){
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
				+ datarecord.venueStateName + "</td></tr>";
		var Country = "<tr><td class='filledWidth1'><b>Country:</b></td><td> "
				+ datarecord.venueCountryName + "</td></tr>";		
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
    	
    
    
    grid.on('cellclick', GRID_PARAM_VENUE.onRowClick);
    //set menu item click
    _contextMenuHandler = contextMenuHandler
	$('#' + rowMenuDivId).on('itemclick',GRID_PARAM_VENUE.onContextMenuItemClick);
	
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

	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM_VENUE.source(model, data));
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
                rowdetailstemplate: GRID_PARAM_VENUE.rowDetailTemplate(rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM_VENUE.initrowdetails,
                columns: vanueColumns
            });
    
	}

		

function fnShowVenueLogo(_repositoryId,_eventId,_leftcolumn, _showUpload){
	///LOGO START
	var LogoURL = "";
	var flaskRequest = new Request();
	params= {'repositoryId': _repositoryId, 'parentFolderId': 0, 'name': 'Venue'};
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			folderName = 'Event-'+_eventId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': _repositoryId, 'parentFolderId': data.folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild, 
				function (data){
					//data.folderId;
					var _folderId = data.folderId;
					var flaskRequestChild0 = new Request();
					paramsChild0= {'groupId': _repositoryId, 'folderId':data.folderId, 'title': 'VenueLogo'};
					console.log(paramsChild0)
					console.log(_venueDetailModel.SERVICE_ENDPOINTS.GET_FILE_BY_TITLE);
					flaskRequestChild0.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_FILE_BY_TITLE , paramsChild0, 
						function (data){
							LogoURL = "/documents/"+_repositoryId+"/"+_folderId+"/EventLogo";
						    var objdiv = $('<div/>',{'class':'venueLogo','style':'background-image:url('+LogoURL+')','data-folderId':_folderId,'data-title':'VenueLogo'});
							$(_leftcolumn).append(objdiv);
							$(objdiv).click(function(){
								var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
						    	$(this).toggleClass("activeImage");
						    	if($(this).hasClass("activeImage")){
					    			$(objDel).appendTo($(_leftcolumn));
					    			$(objDel).click(function(){
				    					fnDeleteFileByTitle(_repositoryId,$(objdiv).attr("data-folderId"),$(objdiv).attr("data-title"));
				    					$(this).remove();
				    					$(objdiv).remove();
				    					if(_showUpload){
				    						fnBuildVenueUpload(_leftcolumn);
										}				    					
					    			});
						    	}
						    	else{
					    			$(objDel).remove();
						    	}
						    });					
						} ,
						function (data){
							if(_showUpload){
								fnBuildVenueUpload(_leftcolumn);
							}
					});				
				} ,
				function (data){
					if(_showUpload){
						fnBuildVenueUpload(_leftcolumn);
					}
			});
		} ,
		function (data){
			if(_showUpload){
				fnBuildVenueUpload(_leftcolumn);
			}
	});
	//LOGO END
}
