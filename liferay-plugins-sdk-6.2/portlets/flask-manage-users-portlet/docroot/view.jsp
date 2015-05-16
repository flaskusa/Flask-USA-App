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

<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/alertifyjs/alertify.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/alertifyjs/css/alertify.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/alertifyjs/css/themes/default.min.css" />
<script src="<%=request.getContextPath()%>/js/jquery.bootgrid.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.bootgrid.min.css" />

<portlet:defineObjects />
<body>
<div id="adminDataTable" class="table-condensed">
	<input class="btn btn-info" type="submit" value="Add">
</div>

<form id="adminForm">
  <div class="form-group">
    <label class="control-label" for="firstName">First Name:</label>
    <div class="controls">
      <input name="firstName" id="firstName" class="form-control field-required" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="middleName">Middle Name:</label>
    <div class="controls">
      <input name="middleName" id="middleName" class="form-control field-required" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="lastName">Last Name:</label>
    <div class="controls">
      <input name="lastName" id="lastName" class="form-control field-required" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="email">E-mail:</label>
    <div class="controls">
      <input name="email" id="email" class="form-control field-required field-email" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="screenName">Screen Name:</label>
    <div class="controls">
      <input name="screenName" id="screenName" class="form-control field-required" type="text">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="password1">Password:</label>
    <div class="controls">
      <input name="password1" id="password1" class="form-control field-required field-password-display-toggle" type="text">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="password2">Confirm Password:</label>
    <div class="controls">
      <input name="password2" id="password2" class="form-control field-required field-password-display-toggle" type="text">
    </div>
  </div>  

  <input class="btn btn-info" type="submit" value="Save">
  <input class="btn btn-primary" type="reset" value="Cancel">
</form>

<div id="AdminSettings">
    <div class="col-md-12">
        <a data-toggle="dropdown" href="#"><img src="<%=request.getContextPath()%>/css/Icons/Setting.png" height="28" width="28" /></a>
        <ul class="dropdown-menu">
            <li><a href="#" onclick="fnShowForm({value});">Edit</a></li>
            <li><a href="#" onclick="fnDelete({value});">Delete</a></li>
            <li><a href="#" onclick="fnPasswordReset({value});">Reset Password</a></li>
            <li><a href="#" onclick="fnChangeRole({value});">Change Role</a></li>
        </ul>
    </div>
</div>

<table id="grid-basic" class="table">
    <thead>
        <tr>
        	<th data-column-id="userId" data-identifier="true">Id</th>
            <th data-column-id="firstName">First Name</th>
            <th data-column-id="lastName">Last Name</th>
            <th data-column-id="link" data-formatter="link" data-sortable="false" data-width="75px"></th>
        </tr>
    </thead>
</table>
</body>