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
	<label class="control-label" for="dob">Date of Birth:</label>
	<div class="controls">
		<input type="text" size="50" id="dob" type="date"/>
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
    <label class="control-label" for="password">Password:</label>
    <div class="controls">
      <input name="password" id="password" class="form-control" type="text">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="passwordConfirmation">Confirm Password:</label>
    <div class="controls">
      <input name="passwordConfirmation" id="passwordConfirmation" class="form-control" type="text">
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
	        <li item-expanded='true' data-id="SPORTS">Sports
		         <ul>
	                <li data-id="SPORTS-PRO">Professional
	                	<ul>
	                		<li data-id="SPORTS-PRO-BASKETBALL">BASKETBALL</li>
	                		<li data-id="SPORTS-PRO-BASEBBALL">BASEBBALL</li>
	                		<li data-id="SPORTS-PRO-FOOTBALL">FOOTBALL</li>
	                		<li data-id="SPORTS-PRO-HOCKEY">HOCKEY</li>
	                		<li data-id="SPORTS-PRO-SOCCER">SOCCER</li>
	                		<li data-id="SPORTS-PRO-TENNIS">TENNIS</li>
	                	</ul>
	                </li>
	                <li data-id="SPORTS-COL">College
	                	<ul>
	                		<li data-id="SPORTS-COL-BASKETBALL">BASKETBALL</li>
	                		<li data-id="SPORTS-COL-BASEBBALL">BASEBBALL</li>
	                		<li data-id="SPORTS-COL-FOOTBALL">FOOTBALL</li>
	                		<li data-id="SPORTS-COL-HOCKEY">HOCKEY</li>
	                		<li data-id="SPORTS-COL-SOCCER">SOCCER</li>
	                		<li data-id="SPORTS-COL-TENNIS">TENNIS</li>
	                	</ul>	                
	                </li>
	            </ul>
			</li>
	        <li item-expanded='true' data-id="CONCERTS">Concerts
	            <ul>
	                <li data-id="CONCERTS-COUNTRY">Country</li>
	                <li data-id="CONCERTS-POP">POP</li>
	                <li data-id="CONCERTS-ROCK">ROCK</li>
	                <li data-id="CONCERTS-RAP">RAP</li>
	                <li data-id="CONCERTS-ALTERNATIVE">Alternative</li>
	                <li data-id="CONCERTS-ELECTRONIC">Electronic</li>
	            </ul>
	        </li>
	        <li item-expanded='true' data-id="SPECIAL-EVENTS">
	        	Special Events
	        	<ul><li data-id="SPECIAL-EVENTS-COMEDY">Comedy</li></ul>
	        </li>
	    </ul>	  
	  </div>      
    </div>
  </div>

  <input class="btn btn-info" type="button" value="Save" onclick="fnSave()" />
  <input class="btn btn-primary" type="reset" value="Cancel">
</form>

<div id="demoContainer" class="device-mobile-tablet">
    <div id="container" class="device-mobile-tablet-container">
        <div style="border: none;" id='grid'></div>
		<div id='Menu'>
	        <ul>
				<li>Edit</li> 					<!--fnShowForm({value}); -->
            	<li>Delete</li>					<!--fnDelete({value}); -->
            	<li>Reset Password</li>			<!--fnPasswordReset({value}); -->
            	<li>Change Role</li>	        <!--fnChangeRole({value}); -->
			</ul>
       </div>
        
    </div>
</div>

<div id="spinningSquaresG">
	<div class="ball"></div>
	<div class="ball1"></div>
</div>
</body>