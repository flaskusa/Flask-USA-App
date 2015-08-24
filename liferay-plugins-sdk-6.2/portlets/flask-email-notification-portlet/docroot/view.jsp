
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
<%@include file="init.jsp"%>
<aui:script>
	var bCreated;
	Liferay.Portlet.ready(initialize);
	function initialize(portletId, portlet) {
		if (portletId == "flaskemailnotification_WAR_flaskemailnotificationportlet") {
			addClickHandlers();
		}
	}
</aui:script>
<body class='default'>
<div id="invitation-msg" style="display: none"></div>
<div id='formContainer'>
<h3 style="text-align: center;">Enter Email to Send Invitation</h3>
<form class="form-horizontal" id="emailNotificationForm">
<!-- Text input-->
<div class="control-group">
  <div class="controls">
    <input id="Add5More" class="btn btn-info clsAdd5More" type="button" value="Add 5 More" />
  </div>
</div>
<div class="divHeight">
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">1 </label>
  <div class="controls">
    <input id="name1" name="<portlet:namespace />textinput" type="text" placeholder="Enter Name" class="input-medium">
    <input id="email1" name="<portlet:namespace />textinput" type="text" placeholder="Enter Email Address" class="input-large">
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">2 </label>
  <div class="controls">
    <input id="name2" name="<portlet:namespace />textinput" type="text" placeholder="Enter Name" class="input-medium">
    <input id="email2" name="<portlet:namespace />textinput" type="text" placeholder="Enter Email Address" class="input-large">
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">3 </label>
  <div class="controls">
    <input id="name3" name="<portlet:namespace />textinput" type="text" placeholder="Enter Name" class="input-medium">
    <input id="email3" name="<portlet:namespace />textinput" type="text" placeholder="Enter Email Address" class="input-large">
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">4 </label>
  <div class="controls">
    <input id="name4" name="<portlet:namespace />textinput" type="text" placeholder="Enter Name" class="input-medium">
    <input id="email4" name="<portlet:namespace />textinput" type="text" placeholder="Enter Email Address" class="input-large">
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">5 </label>
  <div class="controls">
    <input id="name5" name="<portlet:namespace />textinput" type="text" placeholder="Enter Name" class="input-medium">
    <input id="email5" name="<portlet:namespace />textinput" type="text" placeholder="Enter Email Address" class="input-large">
  </div>
</div>
</div>
<div class="control-group">
	<label class="control-label" for="tailgateName">Description </label>
		<div class="controls">
			<textarea
					style='width: 450px; height: 70px; background-color: white; margin: 0px;'
					wrap='hard' name="description" id="description"></textarea>
		</div>
</div>
<div class="control-group">
	<div class="controls">
		<input id="Ok" class="btn btn-info clsSave" type="button" value="Ok" />
		<input class="btn btn-primary clsCancel" type="button" value="Cancel">
	</div>
</div>
</form>
</div>
</body>