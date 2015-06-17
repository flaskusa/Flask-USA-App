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
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%
  com.liferay.portal.theme.ThemeDisplay themeDisplay = (com.liferay.portal.theme.ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
  long repositoryId = themeDisplay.getLayout().getGroupId();
  themeDisplay.getLayout().getUuid();
%>

<aui:script>
var bCreated;
Liferay.Portlet.ready(initialize);
function initialize(portletId, portlet){
	if(portletId == "flaskmanageevents_WAR_flaskmanageeventsportlet") {
		$("#eventForm").hide();
		createTable({},_eventModel.DATA_MODEL.EVENT, $('#grid'), "actionMenu", "Edit", contextMenuHandler, ["Event"]);
		loadData();
		addClickHandlers();
		initForm();
		displayImages(<%=repositoryId%>,29655);
	}
}

function createFolder(repositoryId,parentFolderId,folderName,folderDesc){
	 Liferay.Service(
	   '/dlapp/add-folder',
	   {
	     repositoryId: repositoryId,
	     parentFolderId: parentFolderId,
	     name: folderName,
	     description: folderDesc
	   },
	   function(obj) {
	    if(obj=="com.liferay.portlet.documentlibrary.DuplicateFolderNameException")
	    {
		     Liferay.Service(
		       '/dlapp/get-folder',
		       {
			         repositoryId: repositoryId,
			         parentFolderId: parentFolderId,
			         name: folderName
		       },
		       function(obj) {
		        	 console.log(obj);
		       });
	    }
	    else
	    {
	    	 return obj.folderId;
	    }
	   }
	 );
}

function displayImages(repositoryId, folderId)
{
	var images;
	Liferay.Service('/dlapp/get-file-entries',{
		    repositoryId: 20182,
		    folderId: 29655
		  },
		  function(obj) {
		    console.log(obj);
		    var temp_html;
		    temp_html="<ul>";
		    var imageurl;
		    var uploadedby;
		    for(var i=0;i<obj.length;i++)
				{
		    		console.log(obj[i].title);
		    		imageurl = "/documents/"+repositoryId+"/"+folderId+"/"+obj[i].title;
		    		uploadedby = "uploaded by " + obj[i].userName;
		    		temp_html=temp_html+"<li><img src="+imageurl+" alt='"+uploadedby+"' title='"+uploadedby+"' id='wows1_0'/></li>";
		    	}
		    temp_html=temp_html+"</ul>";
			$("#ws_images").html(temp_html);
			$("#wowslider-container1").wowSlider();
	});
}

</aui:script>

<body class='default'>
<input type="hidden" id="repositoryId" value="<%=repositoryId%>"/>
<div id="action-msg" style="display:none">
</div>


<div id="eventDataTable" class="table-condensed">
	<div class="cssGridMenu">
		<div class="cssAddUser"><div class="iconAddVenue"></div></div>
		<div class="cssSearchUser"><div class="iconSearchUser"><i class="icon-search"></i></div></div>
		<div class="cssDelUser"><div class="iconDelUser"><i class="icon-list"></i></div></div>
		<div class="cssDelete"><div class="iconDelete"><i class="icon-trash"></i></div></div>
	</div>

	<div id="GridContainer" class="device-mobile-tablet"> 
	    <div id="container" class="device-mobile-tablet-container">
	        <div style="border: none;" id='grid'></div>
	    </div>
	</div>
</div>

<div id='actionMenu' style="display:none">
    <ul>
		<li>Edit</li> 					<!--fnShowForm({value}); -->
		<li>Delete</li>					<!--fnDelete({value}); -->
	</ul>
</div>

<form id="eventForm" style="display:none">
  <div class="form-group">
    <div class="controls">
	     <label class="control-label" for="eventName">Event Name:</label>
	    <input name="eventName" id="eventName" class="form-control" type="text" > <div id='Active'>Active</div>
	</div> 
	   
    </div>

    <div class="form-group">
    	<label id="EventDate" class="control-label" for="eventDate">Event date:</label><div class="controls">
	   			<div id="eventDate"></div>
	  	</div>
   </div> 

   <div class="form-group">
    <label id="StartTime" class="control-label" for="startTime">Start Time:</label>
    <div class="controls">
      <div id="startTime"></div>
    </div>
  </div>

	<div class="form-group">
	<label  id="EndTime" class="control-label" for="endTime">End Time:</label>
    	<div class="controls">
    		 <div id="endTime"></div>
    	</div>
  </div>
  <br/>
  <div class="form-group">
	    <label class="control-label" for="eventVenueId">Venue:</label>
		<div class="controls">
			<select id="eventVenueId" name="eventVenueId" class="form-control-select"></select>
			<input id="AddVenue" class="btn btn-info" type="button" value="Add Venue"/>
		</div>
   </div>
   <div class="form-group">
		<div id='jqxtabs'>
		    <ul style='margin-left: 20px;'>
		        <li>General</li>
		        <li>Pre Event</li>
		        <li>During Event</li>
		        <li>Post Event</li>
		    </ul>
		    <div>
		<div style="height: 45px;">
			<input class="btn btn-info floatPosition" type="button" value="Add Content" />
		</div>
		<div>    
		<div id="wowslider-container1">
		<div class="ws_images" id="ws_images">
			<!-- <ul>
					<li><img src="http://localhost:8080/documents/20182/29655/daisetsuzan_national_park_japan-wallpaper-1920x1080.jpg" alt="seagull" title="seagull" id="wows1_0" /></li>
			</ul> -->
		</div>
		<div class="ws_shadow"></div>
		</div>
		</div>
		</div>
		    <div>
		    	<input class="btn btn-info floatPosition" type="button" value="Add Content"/>
		    </div>
		    <div>
		    	<input class="btn btn-info floatPosition" type="button" value="Add Content"/>
		    </div>
		    <div>
		    	<input class="btn btn-info floatPosition" type="button" value="Add Content"/>
		    </div>
		</div>
	</div>
<input type="hidden" name="repositoryId" value="<%= repositoryId %>>">
  <input class="btn btn-info clsDelete" type="button" value="Delete"/>
  <input id="Ok" class="btn btn-info clsSave" type="button" value="Ok"/>
  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
</form>
</body>
</html>