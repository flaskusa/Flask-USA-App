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


<portlet:actionURL  var="addImagesActionURL" name="addImages">
</portlet:actionURL>

<script type="text/javascript">

var bCreated;
Liferay.Portlet.ready(initialize);

function initialize(portletId, portlet){
	if(portletId == "flaskmanagevenue_WAR_flaskmanagevenueportlet") {
		$("#venueForm").hide();
		createTable({},_venueModel.DATA_MODEL.VENUE, $('#grid'), "actionMenu", "Edit", contextMenuHandler, ["Venue", "Images"]);
		loadData();
		addClickHandlers();
	}
}

</script>

<div id="action-msg" style="display:none">
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

<form id="venueForm" style="display:none">
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


  
 
  <input class="btn btn-info clsSave" type="button" value="Save"/>
  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
  <input id="venueId" type="hidden" value="0">
</form>

<div class="form-group">
    <label class="control-label" for="venueImage">Venue Pictures Form:</label>
    <form class="dropzone" id="venueImages" action="<%=addImagesActionURL %>">
   		 <input id="venueId" type="hidden" value="1001">
    </form>
  </div>