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

<script type="text/javascript">

var bCreated;
Liferay.Portlet.ready(initialize);

function initialize(portletId, portlet){
	console.log(portletId);
	$("#venueForm").hide();
	
	createTable({},DATA_MODEL.VENUE, $('#grid'), "actionMenu", "Edit",["Venue", "Images"]);

	var flaskRequest = new Request();
	params = {};
	if(portletId == "flaskmanagevenue_WAR_flaskmanagevenueportlet") {
		addClickHandlers();
		flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_VENUE, params, 
				successHandler , failureHandler);
	}
}

function failureHandler(error){
	showErrorMessage("There was an error in getting data.");
	console.log("Error in getting data: " + error);
}

function successHandler(data){
	GRID_PARAM.updateGrid(data);
	console.log("Successfully set new data" );
}


</script>





<div id="action-msg" style="display:none">
		Hide the message field
</div>


<div id="venueDataTable" class="table-condensed">
	<div class="cssGridMenu">
		<div class="cssAddUser"><div class="iconAddUser"></div></div>
		<div class="cssSearchUser"><div class="iconSearchUser"><i class="icon-search"></i></div></div>
		<div class="cssDelUser"><div class="iconDelUser"><i class="icon-list"></i></div></div>
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
    <label class="control-label" for="city">City:</label>
    <div class="controls">
      <input name="venueCity" id="venueCity" class="form-control" type="text">
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
    <label class="control-label" for="venueImage">Venue Pictures:</label>
    <div class="controls">
        
    </div>
  </div>
 
  <input class="btn btn-info clsSave" type="button" value="Save"/>
  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
  <input id="venueId" type="hidden" value="0">
  
</form>
