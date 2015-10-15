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

<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>

<%@ include file="init.jsp" %>

<portlet:actionURL name="addImages" var="addImagesActionURL" />

<%
long repositoryId = themeDisplay.getLayout().getGroupId();
themeDisplay.getLayout().getUuid();
boolean isAuthorised = renderRequest.isUserInRole("administrator") || 
						renderRequest.isUserInRole("flask-admin") 
						|| renderRequest.isUserInRole("flask-content-manager");
%>


<body class="default">

<c:if test="<%= !isAuthorised %>">
			<div id="action-msg1" class="alert alert-error">
				You are not authorize to view this page.
			</div>
</c:if>


<c:if test="<%= isAuthorised %>">

	<input id="repositoryId" type="hidden" value="<%= repositoryId %>" />
	<div id="action-msg-warning" style="display:none"></div>
	<div id="action-msg" style="display:none">
	</div>
	<div id="formContainer" style="display:none">
		<ul class="nav nav-tabs">
		  <li class="active"><a href="#venues" id="mvenues" data-toggle="tab">Manage Venue</a></li>
		  <li><a href="#contents" data-toggle="tab" id="mvcontents">Manage Content</a></li>
		</ul>
		<div class="tab-content">
		  <div class="tab-pane active" id="venues">
			<form id="venueForm">
			<input id="imgActionUrl" type="hidden" value="<%= addImagesActionURL %>">
			  <div class="form-group">
			    <label class="control-label" for="venuName">Name:</label>
			    <div class="controls">
			      <input name="venueName" id="venueName" class="form-control" maxlength="100" type="text">
			    </div>
			  </div>
	
			  <div class="form-group">
			    <label class="control-label" for="venueDescription">Description:</label>
			    <div class="controls">
			      <input name="venueDescription" id="venueDescription" class="form-control" maxlength="255" type="text">
			    </div>
			  </div>
	
			  <div class="form-group">
			    <label class="control-label" for="addrLine1">Address:</label>
			    <div class="controls">
			      <input name="addrLine1" id="addrLine1" class="form-control" maxlength="100" type="text">
			    </div>
			  </div>
	
			   <div class="form-group">
			    <label class="control-label" for="addrLine2">Address:</label>
			    <div class="controls">
			      <input name="addrLine2" id="addrLine2" class="form-control" maxlength="100" type="text">
			    </div>
			  </div>
	
			   <div class="form-group">
			    <label class="control-label" for="venueZipCode">Zip Code:</label>
			    <div class="controls">
			      <input name="venueZipCode" id="venueZipCode" class="form-control" maxlength="20" type="text">
			    </div>
			  </div>
	
			   <div class="form-group">
			    <label class="control-label" for="venueCity">City:</label>
			    <div class="controls">
			      <input name="venueCity" id="venueCity" class="form-control" maxlength="20" type="text">
			    </div>
			  </div>
	
			  <div class="form-group">
			    <label class="control-label" for="venueMetroArea">Metro Area:</label>
			    <div class="controls">
			      <input name="venueMetroArea" id="venueMetroArea" class="form-control" type="text">
			    </div>
			  </div>
	
			   <div class="form-group">
			    <label class="control-label" for="venueStateId">State:</label>
			    <div class="controls">
			      <select id="venueStateId" name="venueStateId" class="form-control"></select>
			    </div>
			  </div>
	
			  <div class="form-group">
			    <label class="control-label" for="venueCountryId">Country:</label>
			    <div class="controls">
			      <select id="venueCountryId" name="venueCountryId" class="form-control"></select>
			    </div>
			  </div>
			  <div class="form-group">
				    <label class="control-label" for="venueImage">Venue Image:</label>
					<div class="controls">
						<div id="venueImage"></div>
					</div>
			   </div>
			  <input class="btn btn-info clsSave" type="button" value="Save" />
			  <input class="btn btn-primary clsCancel" type="button" value="Cancel">
			  <div id="venueGallery"></div>
			  <input id="venueId" type="hidden" value="0">
			  <input id="latitude" type="hidden" maxlength="20" value="0">
			  <input id="longitude" type="hidden" maxlength="20" value="0">
			</form>
		  </div>
		  <div class="tab-pane" id="contents">
			<div id="venueDetailsContainer">
				<h3><span class="title-text"></span></h3>
				<form id="venueDetailsForm" style="display:none">
				  <input type="hidden" id="imgActionUrl" value="<%= addImagesActionURL %>">
				  <input id="lat" type="hidden" name="lat" maxlength="20" value="">
			      <input id="lng" type="hidden" name="lng" maxlength="20" value="">
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
				   </div>
				  <input id="venueId" type="hidden" value="0">
				  <input id="infoTypeId" type="hidden" value="1">
				  <input id="venueDetailId" type="hidden" name="venueDetailId" value="0">
				  <input class="btn btn-info cssVdSave" type="button" value="Save" />
				  <input class="btn btn-primary cssVdCancel" type="button" value="Cancel">
				  <div id="venueDetailGallery"></div>
				</form>
	
				<div class="table-condensed" id="venueDetailsDataTable">
				  <input class="btn btn-info cssAddVenueDetails" type="button" value="Add Venue Details" />
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
	
	<div class="table-condensed" id="venueDataTable">
		<div class="cssGridMenu">
			<div class="cssAddUser"><div class="iconAddVenue"></div></div>
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

<script type="text/javascript">
var bCreated;
Liferay.Portlet.ready(initialize);

function initialize(portletId, portlet) {
	if (portletId == "flaskmanagevenue_WAR_flaskmanageeventsportlet") {
		createTable({},_venueModel.DATA_MODEL.VENUE, $('#grid'), "actionMenu", "Edit", contextMenuHandler, ["Venue", "Images"]);
		loadData();
		addClickHandlers();
		initForm();
	}
}
</script>
</c:if> <!-- check if authorized -->  
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
<button class="md-trigger" data-modal="modal-advertisement" style="display:none">3D Rotate Bottom</button>
</body>

</html>