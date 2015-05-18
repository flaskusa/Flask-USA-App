<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>


<portlet:defineObjects />

<liferay-theme:defineObjects />

<script type="text/javascript">

var bCreated;

Liferay.Portlet.ready(initializeGrid);
		
function initializeGrid(portletId, portlet){
	console.log('initialize');
	
	if(portletId != null && portletId.indexOf('flask') >= 0) {//this is a hack need better solution
	
		console.log('getdata');
		getData();
	}
	
}

function createTable(data){
	var grid = $('#jqxgrid');
	
    var source =
    {
        showfilterrow: true,
        filterable: true,
        pageable: true,
        autoheight: true,
        localdata: data,
        datafields:
        [
            { name: 'firstName', type: 'string' },
            { name: 'lastName', type: 'string' },
            { name: 'email', type: 'string' },
            { name: 'screenName', type: 'string'},
            { name: 'userId', type: 'long'}
        ],
        datatype: "json"
    };

    var dataAdapter = new $.jqx.dataAdapter(source);
    
    var actionCellRenderer = function (value) {
    	return 	"<div id='AdminSettings'>"
		       +	"<a data-toggle='dropdown' href='#'><img src='${themeDisplay.pathThemeImages}/common/tool.png' height='16' width='16' /></a>"
		       +	"<ul class='dropdown-menu'>"
		       +	"<li><a href='#' onclick='fnShowForm({value});'>Edit</a></li>"
		       +	"<li><a href='#' onclick='fnDelete({value});'>Delete</a></li>"
		       +   	"<li><a href='#' onclick='fnPasswordReset({value});'>Reset Password</a></li>"
		       +    "<li><a href='#' onclick='fnChangeRole({value});'>Change Role</a></li>"
		       +    "</ul></div>"; 
	}
    
    var initrowdetails = function(index, parentElement, gridElement, datarecord){
    	 var tabsdiv = null;
         var information = null;
         var notes = null;
         tabsdiv = $($(parentElement).children()[0]);
         if (tabsdiv != null) {
             information = tabsdiv.find('.profile');
             notes = tabsdiv.find('.interests');
             var title = tabsdiv.find('.title');
             title.text(datarecord.firstName);
             
             var notescontainer = $('<div style="white-space: normal; margin: 5px;"><span>' + datarecord.email + '</span></div>');
             $(notes).append(notescontainer);
             $(tabsdiv).jqxTabs({ width: '95%', height: 250, theme: 'orange'});
             
         }
    	
    }
    
    grid.on('rowclick', function (event) 
    		{
    		    var args = event.args;
    		    // row's bound index.
    		    var boundIndex = args.rowindex;
    		    // row's visible index.
    		    var visibleIndex = args.visibleindex;
    		    // right click.
    		    var rightclick = args.rightclick; 
    		    // original event.
    		    var ev = args.originalEvent;    
    		    
    		    grid.jqxGrid('selectrow', boundIndex);
    		    
    		    var details = grid.jqxGrid('getrowdetails', boundIndex);
    		    if(details.rowdetailshidden ==true){
    		    	grid.jqxGrid('showrowdetails', boundIndex);	
    		    }else{
    		    	grid.jqxGrid('hiderowdetails', boundIndex);
    		    }
    		    
    		    
    		});
    
    
    var rodetailsTemplate = "<div style='margin: 2px;'> \
    						<ul style='margin-left: 30px;'> \
    							<li class='title'>Provile</li>\
    							<li>Interests</li></ul> \
    						<div class='profile'></div> \
    						<div class='interests'></div></div>";
	
    grid.jqxGrid(
            {
                width: '90%',
                height: '95%',
                source: dataAdapter,
                theme:	'orange',
                rowdetails: true,
                showrowdetailscolumn:false,
                rowdetailstemplate: { rowdetails: rodetailsTemplate, rowdetailsheight: 200 },
                initrowdetails: initrowdetails,
                columns: [
                  { text: 'First Name', columntype: 'textbox',  datafield: 'firstName', width: '20%' },
                  {
                      text: 'Last Name', datafield: 'lastName', width: '20%'
                  },
                  { text: 'Email', datafield: 'email',  width: '30%'},
                  { text: 'Screen Name', datafield: 'screenName', width: '20%'},
                  { text: 'Action',  datafield: 'userId', width: '10%', cellsalign: 'center', cellsrenderer: actionCellRenderer}
                  
                ]
                
            });
    
	}


function getData(){
	var adminDataUrl= '/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins';
	var jqxhr = $.ajax( {
		  url: adminDataUrl,
		  method: "GET",
		  dataType: "json",
		  cache : false
		} )
	  .done(function(data) {
		  if(bCreated){
			  updateTable();
		  }else{
			  createTable(data);
		  }
	  })
	  .fail(function(jqXHR, textStatus ) {
	   	console.log('Data request failed' + textStatus);
	    //TODO add logic for error display
	  })
}


</script>

 <div id="jqxgrid">

</div>