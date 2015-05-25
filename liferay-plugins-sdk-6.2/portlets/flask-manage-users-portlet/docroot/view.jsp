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
	      <input name="gender" type="radio" value="Male" checked>Male
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
    <label class="control-label" for="stateId">State:</label>
    <div class="controls">
      <input name="stateId" id="stateId" class="form-control" type="text">
    </div>
  </div>  
    
  <div class="form-group">
    <label class="control-label" for="countryId">Country:</label>
    <div class="controls">
      <input name="countryId" id="countryId" class="form-control" type="text">
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
    <label class="control-label" for="mobileNumber">Mobile:</label>
    <div class="controls">
      <input name="mobileNumber" id="mobileNumber" class="form-control" type="text">
    </div>
  </div>  

  <div >
    <label class="control-label" for="pref">Preferences:</label>

	  <div id="userInterests" style="overlow:hidden;">
		<ul>        
		<table style="width:100%; height:100%;">
		<tr>
		<td style="vertical-align:top">
            <li item-expanded='true' id="sports">Sports
	                	<ul>
	                		<li id="sports-basketball">Basketball</li>
	                		<li id="sports-baseball">Baseball</li>
	                		<li id="sports-football">Football</li>
	                		<li id="sports-hockey">Hockey</li>
	                		<li id="sports-soccer">Soccer</li>
	                		<li id="sports-tennis">Tennis</li>
	                	</ul>
	        </li>
</td>
<td style="vertical-align:top">
            <li item-expanded='true' id="level">Level
	                	<ul>
	                		<li id="level-basketball">Professional</li>
	                		<li id="level-baseball">College</li>               	
	                	</ul>	                
	        </li>
	        </td>
	        </tr>
	        <tr>
	        <td style="vertical-align:top">
	        <li item-expanded='true' id="music">Concerts
	            <ul>
	                <li id="music-country">Country</li>
	                <li id="music-pop">POP</li>
	                <li id="music-rock">ROCK</li>
	                <li id="music-rap">RAP</li>
	                <li id="music-alternative">Alternative</li>
	                <li id="music-electronic">Electronic</li>
	            </ul>
	        </li>
	        </td>
	        <td style="vertical-align:top">
	        <li item-expanded='true' id="special-events">
	        	Special Events
	        	<ul><li id="special-events-comedy">Comedy</li></ul>
	        </li>
	        </td>
	        </tr>
	       </table>
	    </ul>	  
	  </div>      

  </div>

  <input class="btn btn-info clsSave" type="button" value="Save" onclick="fnSave()" />
  <input class="btn btn-primary" type="button" value="Cancel" >
</form>

<div id="demoContainer" class="device-mobile-tablet">
    <div id="container" class="device-mobile-tablet-container">
        <div style="border: none;" id='grid'></div>
    </div>
</div>
		<div id='Menu' style="display:none">
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