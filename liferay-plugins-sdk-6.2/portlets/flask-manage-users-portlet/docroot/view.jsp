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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Flask-lib.js"></script>

<!-- JQX Plugin Includes [start]-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/simulator.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/generatedata.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jqx-all.js"></script>
<!-- JQX Plugin Includes [End]-->

<portlet:defineObjects />
<body>
<div id="adminDataTable" class="table-condensed">
	<input class="btn btn-info" type="submit" value="Add">
</div>

<form id="adminForm">
  <div class="form-group">
    <label class="control-label" for="firstName">First Name:</label>
    <div class="controls">
      <input name="firstName" id="firstName" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="middleName">Middle Name:</label>
    <div class="controls">
      <input name="middleName" id="middleName" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="lastName">Last Name:</label>
    <div class="controls">
      <input name="lastName" id="lastName" class="form-control" type="text">
    </div>
  </div>
  
	<div class="form-group">
	    <label class="control-label" for="gender">Gender:</label>
	    <div class="controls">
	      <input name="gender" type="radio" value="Male">Male
		  <input name="gender" type="radio" value="Female">Female
	    </div>
	</div>
  
  <div class="form-group">
	<label class="control-label" for="DOB">Date of Birth:</label>
	<div class="controls">
		<input size="50" id="DOB" type="date"/>
	</div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="streetName">Street:</label>
    <div class="controls">
      <input name="streetName" id="streetName" class="form-control" type="text">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="aptNo">Apartment#:</label>
    <div class="controls">
      <input name="aptNo" id="aptNo" class="form-control" type="text">
    </div>
  </div>  
  
   <div class="form-group">
    <label class="control-label" for="areaCode">Area Code:</label>
    <div class="controls">
      <input name="areaCode" id="areaCode" class="form-control" type="text">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label" for="city">City:</label>
    <div class="controls">
      <input name="city" id="city" class="form-control" type="text">
    </div>
  </div>  
  
   <div class="form-group">
    <label class="control-label" for="state">State:</label>
    <div class="controls">
      <input name="state" id="state" class="form-control" type="text">
    </div>
  </div>  
    
  <div class="form-group">
    <label class="control-label" for="country">Country:</label>
    <div class="controls">
      <input name="country" id="country" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="screenName">Screen Name:</label>
    <div class="controls">
      <input name="screenName" id="screenName" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="email">E-mail:</label>
    <div class="controls">
      <input name="email" id="email" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="password1">Password:</label>
    <div class="controls">
      <input name="password1" id="password1" class="form-control" type="password">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="password2">Confirm Password:</label>
    <div class="controls">
      <input name="password2" id="password2" class="form-control" type="password">
    </div>
  </div>  
  
  <div class="form-group">
    <label class="control-label" for="mobileNo">Mobile:</label>
    <div class="controls">
      <input name="mobileNo" id="mobileNo" class="form-control" type="text">
    </div>
  </div>  

  <div class="form-group">
    <label class="control-label" for="pref">Preferences:</label>
    <div class="form-group" style="padding:10px;">
	  <div style="border: none;" id="userInterests">
		<ul>
	        <li item-expanded='true' id="sports">Sports
		         <ul>
	                <li item-expanded='true' id="sports-pro">Professional
	                	<ul>
	                		<li id="sports-pro-basketball">Basketball</li>
	                		<li id="sports-pro-baseball">Baseball</li>
	                		<li id="sports-pro-football">Football</li>
	                		<li id="sports-pro-hockey">Hockey</li>
	                		<li id="sports-pro-soccer">Soccer</li>
	                		<li id="sports-pro-tennis">Tennis</li>
	                	</ul>
	                </li>
	                <li item-expanded='true' id="sports-col">College
	                	<ul>
	                		<li id="sports-col-basketball">Basketball</li>
	                		<li id="sports-col-baseball">Baseball</li>
	                		<li id="sports-col-football">Football</li>
	                		<li id="sports-col-hockey">Hockey</li>
	                		<li id="sports-col-soccer">Soccer</li>
	                		<li id="sports-col-tennis">Tennis</li>	                	
	                	</ul>	                
	                </li>
	            </ul>
			</li>
	        <li item-expanded='true' id="concerts">Concerts
	            <ul>
	                <li id="concerts-country">Country</li>
	                <li id="concerts-pop">POP</li>
	                <li id="concerts-rock">ROCK</li>
	                <li id="concerts-rap">RAP</li>
	                <li id="concerts-alternative">Alternative</li>
	                <li id="concerts-electronic">Electronic</li>
	            </ul>
	        </li>
	        <li item-expanded='true' id="special-events">
	        	Special Events
	        	<ul><li id="special-events-comedy">Comedy</li></ul>
	        </li>
	    </ul>	  
	  </div>      
    </div>
  </div>

  <input class="btn btn-info clsSave" type="button" value="Save" onclick="fnSave()" />
  <input class="btn btn-primary" type="reset" value="Cancel">
</form>

<div id="demoContainer" class="device-mobile-tablet">
    <div id="container" class="device-mobile-tablet-container">
        <div style="border: none;" id='grid'></div>
    </div>
</div>
		<div id='Menu'>
	        <ul>
				<li>Edit</li> 					<!--fnShowForm({value}); -->
            	<li>Delete</li>					<!--fnDelete({value}); -->
            	<li>Reset Password</li>			<!--fnPasswordReset({value}); -->
            	<li>Change Role</li>	        <!--fnChangeRole({value}); -->
			</ul>
       </div>

<div id="spinningSquaresG">
	<div class="ball"></div>
	<div class="ball1"></div>
</div>
</body>