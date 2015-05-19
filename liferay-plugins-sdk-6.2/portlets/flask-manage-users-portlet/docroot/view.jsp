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

<script src="<%=request.getContextPath()%>/js/alertifyjs/alertify.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/alertifyjs/css/alertify.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/alertifyjs/css/themes/default.min.css" />

<!-- JQX Plugin Includes [start]-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/simulator.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/generatedata.js"></script>
<!-- JQX Plugin Includes [End]-->
<script type="text/javascript">
        $(document).ready(function () {
            // prepares the simulator. 
        });
</script>

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
    <label class="control-label" for="email">E-mail:</label>
    <div class="controls">
      <input name="email" id="email" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="screenName">Screen Name:</label>
    <div class="controls">
      <input name="screenName" id="screenName" class="form-control" type="text">
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

  <input class="btn btn-info" type="submit" value="Save">
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
</body>