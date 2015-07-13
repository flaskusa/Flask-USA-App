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

<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>

<%@ include file="init.jsp" %>


<portlet:actionURL  var="addImagesActionURL" name="addImages"/>
<%
  long repositoryId = themeDisplay.getLayout().getGroupId();
  themeDisplay.getLayout().getUuid();
%>

<script type="text/javascript">

var bCreated;
Liferay.Portlet.ready(initialize);

function initialize(portletId, portlet){
	if(portletId == "flaskmanagevenue_WAR_flaskmanageeventsportlet") {
		createTable({},_venueModel.DATA_MODEL.VENUE, $('#grid'), "actionMenu", "Edit", contextMenuHandler, ["Venue", "Images"]);
		loadData();
		addClickHandlers();
	}
}

</script>

<body class='default'>
<input type="hidden" id="repositoryId" value="<%=repositoryId%>"/>
<div id="action-msg" style="display:none">
</div>
<div id='formContainer' style="display:none">
	<ul class="nav nav-tabs">
	  <li><a href="#venues" data-toggle="tab">Manage Venue</a></li>
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
	  <div class="tab-pane active" id="venues">
		<form id="venueForm">
		<input type="hidden" id="imgActionUrl" value="<%=addImagesActionURL %>">
		  <div class="form-group">
		    <label class="control-label" for="venuName">Name:</label>
		    <div class="controls">
		      <input name="venueName" id="venueName" class="form-control" type="text">
		    </div>
		  </div>
		
		  <div class="form-group">
		    <label class="control-label" for="venueDescription">Description:</label>
		    <div class="controls">
		      <input name="venueDescription" id="venueDescription" class="form-control" type="text">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label" for="addrLine1">Address:</label>
		    <div class="controls">
		      <input name="addrLine1" id="addrLine1" class="form-control" type="text">
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label" for="addrLine2">Address:</label>
		    <div class="controls">
		      <input name="addrLine2" id="addrLine2" class="form-control" type="text">
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label" for="venueZipCode">Zip Code:</label>
		    <div class="controls">
		      <input name="venueZipCode" id="venueZipCode" class="form-control" type="text">
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label" for="venueCity">City:</label>
		    <div class="controls">
		      <input name="venueCity" id="venueCity" class="form-control" type="text">
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
		      <select id="venueCountryId" name="venueCountryId" class="form-control" ></select>
		    </div>
		  </div>
		  <div class="form-group">
			    <label class="control-label" for="venueImage">Venue Image:</label>
				<div class="controls">
					<div id="venueImage"></div>
				</div>
		   </div>		   
		  <input class="btn btn-info clsSave" type="button" value="Save"/>
		  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
		  <input id="venueId" type="hidden" value="0">
		</form>		
	  </div>
	  <div class="tab-pane" id="contents">
		<div id="venueDetailsContainer">
			<h3><span class="title-text"></span></h3>
			<form id="venueDetailsForm" style="display:none">
			  <input type="hidden" id="imgActionUrl" value="<%=addImagesActionURL %>">
			  <div class="form-group">
				    <label class="control-label" for="infoTypeCategoryId">Content Type:</label>
					<div class="controls">
						<select id="infoTypeCategoryId" name="infoTypeCategoryId" class="form-control-select"></select>
					</div>
			   </div>   
			   <div id="contentTypeForm">
			   		This is content type form.
			   </div>
			  <input id="venueId" type="hidden" value="0">
			  <input id="infoTypeId" type="hidden" value="1">
			  <input id="venueDetailId" type="hidden" name="venueDetailId" value="0">
			  <input class="btn btn-info cssVdSave" type="button" value="Save"/>
			  <input class="btn btn-primary cssVdCancel" type="button" value="Cancel" >
			  <div id="venueDetailGallery"></div>
			</form>
			
			<div id="venueDetailsDataTable" class="table-condensed">
			  <input class="btn btn-info cssAddVenueDetails" type="button" value="Add Venue Details"/>
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


<div id="venueDataTable" class="table-condensed">
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
