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
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<body class='default'>

<form id="EventForm">
  <div class="form-group">
    <div class="controls">
	     <label class="control-label" for="eventName">Event Name:</label>
	    <input name="eventName" id="eventName" class="form-control" type="text" ></div> 
	    <div id='Active'>Active</div>
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
	    <label class="control-label" for="venueCountryId">Venue:</label><div class="controls">
		      <select id="venueCountryId" name="venueCountryId" class="form-control-select"></select>
		     </div>
	    
    	<input id="AddVenue" class="btn btn-info" type="button" value="Add Venue"/>
   </div>
  <input class="btn btn-info clsDelete" type="button" value="Delete"/>
  <input id="Ok" class="btn btn-info clsSave" type="button" value="Ok"/>
  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
</form>
	<div id='jqxtabs'>
	    <ul style='margin-left: 20px;'>
	        <li>General</li>
	        <li>Pre Event</li>
	        <li>During Event</li>
	        <li>Post Event</li>
	    </ul>
	    <div>
	     <div class="flipster" style="overflow: hidden;">
       <input class="btn btn-info floatPosition" type="button" value="Add Content"/>
    	<ul style="margin-top:50px;">
		     <li>
		      <img src="<%=request.getContextPath()%>/images/Sport-1.jpeg">
		     </li>
		     <li>
		      <img src="<%=request.getContextPath()%>/images/Sport-2.jpeg">
		     </li>
		     <li>
		      <img src="<%=request.getContextPath()%>/images/Sport-3.jpeg">
		     </li>
		     <li>
		      <img src="<%=request.getContextPath()%>/images/Sport-4.jpeg">
		     </li>
		     <li>
		      <img src="<%=request.getContextPath()%>/images/Sport-7.jpeg">
		     </li>
		     <li>
		      <img src="<%=request.getContextPath()%>/images/Sport-5.jpeg">
		     </li>
		     <li>
		      <img src="<%=request.getContextPath()%>/images/Sport-6.jpeg">
		     </li>
		    </ul>
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
</body>