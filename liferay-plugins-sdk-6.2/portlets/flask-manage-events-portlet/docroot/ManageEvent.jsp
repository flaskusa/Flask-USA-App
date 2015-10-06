<%--
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
--%>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ include file="init.jsp" %>
<portlet:actionURL name="addImages" var="addImagesActionURL" />

<%
long repositoryId = themeDisplay.getLayout().getGroupId();
themeDisplay.getLayout().getUuid();

boolean isAuthorised = renderRequest.isUserInRole("administrator") 
					|| renderRequest.isUserInRole("flask-admin") 
					|| renderRequest.isUserInRole("flask-content-manager");

%>

<aui:script>
var bCreated;
Liferay.Portlet.ready(initialize);
function initialize(portletId, portlet) {
	if (portletId == "flaskmanageevents_WAR_flaskmanageeventsportlet") {
		createTable({},_eventModel.DATA_MODEL.EVENT, $('#grid'), "actionMenu", "Edit", contextMenuHandler, ["Event"],_eventModel.GRID_DATA_MODEL.EVENT);
		loadData();
		addClickHandlers();
		initForm();
		$('#eventDate').datetimepicker({
			format: "MM-DD-YYYY",
			//pickTime: false
		});
		$("#startTime").datetimepicker({
			format: "LT"
			//pickDate: false,
			//pick12HourFormat: true
		});
		$("#endTime").datetimepicker({
			format: "LT"
			//pickDate: false,
			//pick12HourFormat: true
		});
	}
}

</aui:script>

<body class="default">


<c:if test="<%= !isAuthorised %>">
			<div id="action-msg1" class="alert alert-error">
				You are not authorize to view this page.
			</div>
</c:if>
<c:if test="<%= isAuthorised %>">

		<input id="repositoryId" type="hidden" value="<%= repositoryId %>" />
		<div id="action-msg-warning" style="display:none"></div>
		<div id="action-msg" style="display:none"></div>
		<div id="formContainer" style="display:none">
			<ul class="nav nav-tabs">
			  <li class="active"><a href="#events" data-toggle="tab">Manage Events</a></li>
			  <li><a href="#contents" data-toggle="tab" id="mcontents">Manage Content</a></li>
			</ul>
			<div class="tab-content">
			  <div class="tab-pane active" id="events">
				<form id="eventForm">
				  <div class="form-group">
				    <div class="controls">
					    <label class="control-label" for="eventName">Event Name:</label>
					    <input name="eventName" id="eventName" class="form-control" type="text" maxlength="100" onchange="$('#description').val($(this).val());" /> <div id='Active'>Active</div>
					    <input type="hidden" id="description" value="" />
					</div>
				  </div>
				   <div class="form-group">
					    <label class="control-label" for="eventTypeId">Event Type:</label>
						<div class="controls">
							<select class="form-control-select" id="eventTypeId" name="eventTypeId"></select>
						</div>
				   </div>
				    <div class="form-group">
				    	<label id="EventDate" class="control-label" for="eventDate">Event date:</label><div class="controls">
				    	<div class="controls">
				   				 <input type='text' class="form-control" id='eventDate' />
				   		</div>
					  	</div>
				   </div>
		
				   <div class="form-group">
				    <label id="StartTime" class="control-label" for="startTime">Start Time:</label>
				    <div class="controls">
				      <input type='text' class="form-control" id='startTime' />
				    </div>
				  </div>
		
					<div class="form-group">
					<label class="control-label" for="endTime" id="EndTime">End Time:</label>
				    	<div class="controls">
				    		 <input type='text' class="form-control" id='endTime' />
				    	</div>
				  </div>
				  <br />
				  <div class="form-group">
					    <label class="control-label" for="venueId">Venue:</label>
						<div class="controls">
							<select class="form-control-select" id="venueId" name="venueId"></select>
						</div>
				   </div>
				  <div class="form-group">
					    <label class="control-label" for="eventImage">Event Image:</label>
						<div class="controls">
							<div id="eventImage"></div>
						</div>
				   </div>
				  <input id="Ok" class="btn btn-info clsSave" type="button" value="Ok" />
				  <input class="btn btn-primary clsCancel" type="button" value="Cancel">
				  <input type="hidden" id="eventImageUUID" value="">
				  <input type="hidden" id="eventImageGroupId" value="0">
				  <input type="hidden" name="repositoryId" value="<%= repositoryId %>>">
				  <input id="eventId" type="hidden" value="0">
				</form>
			  </div>
			  <div class="tab-pane" id="contents">
				<div id="eventDetailsContainer">
					<h3><span class="title-text"></span></h3>
					<form id="eventDetailsForm" style="display:none">
					  <input type="hidden" id="imgActionUrl" value="<%= addImagesActionURL %>">
					  <input id="latitude" type="hidden" name="latitude" value="">
					  <input id="longitude" type="hidden" name="longitude" value="">
					  <div class="form-group">
						    <label class="control-label" for="infoTypeId">Info Type:</label>
							<div class="controls">
								<select class="form-control-select" id="infoTypeId" name="infoTypeId"></select>
							</div>
					  </div>
					  <div class="form-group">
						    <label class="control-label" for="infoTypeCategoryId">Content Type:</label>
							<div class="controls">
								<select class="form-control-select" id="infoTypeCategoryId" name="infoTypeCategoryId"></select>
							</div>
					   </div>
					   <div id="contentTypeForm">
					   		Please select content type.
					   </div>
					  <input id="infoTypeId" type="hidden" value="1">
					  <input id="eventDetailId" type="hidden" name="eventDetailId" value="0">
					  <input class="btn btn-info cssVdSave" type="button" value="Save" />
					  <input class="btn btn-primary cssVdCancel" type="button" value="Cancel">
					  <div id="eventDetailGallery"></div>
					</form>
		
					<div class="table-condensed" id="eventDetailsDataTable">
					  <input class="btn btn-info cssAddEventDetails" type="button" value="Add Event Details" />
					  <div id="gridDetails"></div>
					</div>
		
					<div id="actionMenuDetails" style="display:none">
						<ul>
							<li>Edit</li> <!--fnShowForm({value}); -->
							<li>Delete</li> <!--fnDelete({value}); -->
						</ul>
				  	</div>
				</div>
			  </div>
			</div>
		</div>
		
		<div class="table-condensed" id="eventDataTable">
			<div class="cssGridMenu">
				<div class="cssAddUser"><div class="iconAddEvent"><i class="icon-star-empty"></i></div></div>
				<div class="cssSearchUser"><div class="iconSearchUser"><i class="icon-search"></i></div></div>
				<div class="cssDelUser"><div class="iconDelUser"><i class="icon-list"></i></div></div>
				<div class="cssDelete"><div class="iconDelete"><i class="icon-trash"></i></div></div>
			</div>
		
			<div class="device-mobile-tablet" id="GridContainer">
			    <div id="container" class="device-mobile-tablet-container">
			        <div style="border: none;" id='grid'></div>
			    </div>
			</div>
		</div>
		
		<div id="actionMenu" style="display:none">
			<ul>
				<li>Edit</li> <!--fnShowForm({value}); -->
				<li>Delete</li> <!--fnDelete({value}); -->
			</ul>
		</div>
	</c:if>
	<div class="md-modal md-effect-14" id="modal-advertisement">
		<div class="md-content">
			<h3 id="myModalLabel">Flask Gallery</h3>
			<span class='md-closeBtn'>x</span>
			<div>
				<div class="imageContainer"></div>
			</div>
		</div>
	</div>
	<div class="md-overlay"></div>
	<button class="md-trigger" data-modal="modal-advertisement" style="display:none">3D</button>	
</body>
</html>