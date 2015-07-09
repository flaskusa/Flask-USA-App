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
<%@include file="init.jsp"%>

<portlet:actionURL  var="addImagesActionURL" name="addImages"/>
<%
  long repositoryId = themeDisplay.getLayout().getGroupId();
  themeDisplay.getLayout().getUuid();
%>

<aui:script>
var bCreated;
Liferay.Portlet.ready(initialize);
function initialize(portletId, portlet){
	if(portletId == "flaskmanageevents_WAR_flaskmanageeventsportlet") {
		createTable({},_eventModel.DATA_MODEL.EVENT, $('#grid'), "actionMenu", "Edit", contextMenuHandler, ["Event"],_eventModel.GRID_DATA_MODEL.EVENT);
		loadData();
		addClickHandlers();
		initForm();
	}
}

</aui:script>

<body class='default'>
<input type="hidden" id="repositoryId" value="<%=repositoryId%>"/>
<div id="action-msg" style="display:none">
</div>
<div id='formContainer' style="display:none">
	<ul class="nav nav-tabs">
	  <li><a href="#events" data-toggle="tab">Manage Events</a></li>
	  <li class="dropdown">
	  	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Content<b class="caret"></b></a>
	    <ul class="dropdown-menu">
	    	<li class=""><a href="#contents" data-toggle="tab" class="infoTypeCat" data-value="1">General</a></li>
	    	<li class=""><a href="#contents" data-toggle="tab" class="infoTypeCat" data-value="2">Pre-Event</a></li>
	    	<li class=""><a href="#contents" data-toggle="tab" class="infoTypeCat" data-value="3">During-Event</a></li>
	    	<li class=""><a href="#contents" data-toggle="tab" class="infoTypeCat" data-value="4">Post-Event</a></li>
	    </ul>
	  </li>  
	</ul>
	<div class="tab-content">
	  <div class="tab-pane active" id="events">
		<form id="eventForm">
		  <div class="form-group">
		    <div class="controls">
			    <label class="control-label" for="eventName">Event Name:</label>
			    <input name="eventName" id="eventName" class="form-control" type="text" onchange="$('#description').val($(this).val());"/> <div id='Active'>Active</div>
			    <input type="hidden" id="description" value=""/>
			</div> 
		  </div>
		   <div class="form-group">
			    <label class="control-label" for="eventTypeId">Event Type:</label>
				<div class="controls">
					<select id="eventTypeId" name="eventTypeId" class="form-control-select"></select>
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
			    <label class="control-label" for="venueId">Venue:</label>
				<div class="controls">
					<select id="venueId" name="venueId" class="form-control-select"></select>
				</div>
		   </div>
		  <div class="form-group">
			    <label class="control-label" for="eventImage">Event Image:</label>
				<div class="controls">
					<div id="eventImage"></div>
				</div>
		   </div>		   
		  <input id="Ok" class="btn btn-info clsSave" type="button" value="Ok"/>
		  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
		  <input type="hidden" id="eventImagePath" value="">	
		  <input type="hidden" name="repositoryId" value="<%= repositoryId %>>">
		  <input id="eventId" type="hidden" value="0">
		</form>  
	  </div>
	  <div class="tab-pane" id="contents">
		<div id="eventDetailsContainer">
			<h3><span class="title-text"></span></h3>
			<form id="eventDetailsForm" style="display:none">
			  <input type="hidden" id="imgActionUrl" value="<%=addImagesActionURL %>">
			  <div class="form-group">
				    <label class="control-label" for="infoTypeCategoryId">Content Type:</label>
					<div class="controls">
						<select id="infoTypeCategoryId" name="infoTypeCategoryId" class="form-control-select"></select>
					</div>
			   </div>   
			   <div id="contentTypeForm">
			   		Please select content type.
			   </div>
			  
			  <input id="eventId" type="hidden" value="0">
			  <input id="infoTypeId" type="hidden" value="1">
			  <input id="eventDetailId" type="hidden" name="eventDetailId" value="0">
			  <input class="btn btn-info cssVdSave" type="button" value="Save"/>
			  <input class="btn btn-primary cssVdCancel" type="button" value="Cancel" >
			  <div id="eventDetailGallery"></div>
			</form>
			
			<div id="eventDetailsDataTable" class="table-condensed">
			  <input class="btn btn-info cssAddEventDetails" type="button" value="Add Event Details"/>
			  <div id="gridDetails"></div>
			</div>
			
			<div id='actionMenuDetails' style="display:none">
				<ul>
					<li>Edit</li> 					<!--fnShowForm({value}); -->
					<li>Delete</li>					<!--fnDelete({value}); -->
				</ul>
		  	</div>
		</div>  
	  </div>
	</div>
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
</body>
</html>
