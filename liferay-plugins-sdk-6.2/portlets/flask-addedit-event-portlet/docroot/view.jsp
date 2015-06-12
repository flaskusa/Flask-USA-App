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
<body class='default'>

<form id="EventForm">
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
	<div style="height: 45px;">
		<input class="btn btn-info floatPosition" type="button" value="Add Content" />
	</div>
	<div>    
	<div id="wowslider-container1">
	<div class="ws_images"><ul>
		<li><img src="<%=request.getContextPath()%>/images/seagull.jpg" alt="seagull" title="seagull" id="wows1_0"/></li>
		<li><img src="<%=request.getContextPath()%>/images/solarpower.jpg" alt="solarpower" title="solarpower" id="wows1_1"/></li>
		<li><img src="<%=request.getContextPath()%>/images/attic.jpg" alt="attic" title="attic" id="wows1_2"/></li>
		<li><img src="<%=request.getContextPath()%>/images/aurora.jpg" alt="aurora" title="aurora" id="wows1_3"/></li>
		<li><img src="<%=request.getContextPath()%>/images/barbecue.jpg" alt="barbecue" title="barbecue" id="wows1_4"/></li>
		<li><img src="<%=request.getContextPath()%>/images/blackswan.jpg" alt="blackswan" title="blackswan" id="wows1_5"/></li>
		<li><img src="<%=request.getContextPath()%>/images/chess.jpg" alt="chess" title="chess" id="wows1_6"/></li>
		<li><img src="<%=request.getContextPath()%>/images/diveevo.jpg" alt="diveevo" title="diveevo" id="wows1_7"/></li>
		<li><img src="<%=request.getContextPath()%>/images/fire.jpg" alt="fire" title="fire" id="wows1_8"/></li>
		<li><img src="<%=request.getContextPath()%>/images/keyboard.jpg" alt="keyboard" title="keyboard" id="wows1_9"/></li>
		<li><img src="<%=request.getContextPath()%>/images/locomotive.jpg" alt="locomotive" title="locomotive" id="wows1_10"/></li>
		<li><img src="<%=request.getContextPath()%>/images/person.jpg" alt="carousel jquery" title="person" id="wows1_11"/></li>
		<li><img src="<%=request.getContextPath()%>/images/rose.jpg" alt="rose" title="rose" id="wows1_12"/></li>
	</ul>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/slide.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script> 
</body>
</html>