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
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%
  com.liferay.portal.theme.ThemeDisplay themeDisplay = (com.liferay.portal.theme.ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
  long repositoryId = themeDisplay.getLayout().getGroupId();
  themeDisplay.getLayout().getUuid();
%>
<portlet:defineObjects />

<aui:script use="array-extras">
	$(document).ready(function(){
		Liferay.Service(_eventModel.SERVICE_ENDPOINTS.GET_USER_EVENT,
		  function(obj) {
			renderEventList(obj);
		  }
		);
	});
</aui:script>
<body>
<div id="viewEvents">
<div class="table-responsive">          
<div id="one">
  <table id="viewevent">
    <tbody>
		<tr>
	         <td class="gap">
				<input  type="text" placeholder="SEARCH:" id="txtSearch">
	         </td>
	         <td>
				<div id="reportrange" class="pull-right">
				    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>&nbsp;
				    <span></span> <b class="caret"></b>
				</div>	         
	         </td>
      	</tr>
    </tbody>
  </table>
    <div id="container1">
		<div class="container-fluid fill" id="placeholder">
		</div>
    </div>
  </div>
 </div>
    
 <div id="two" style="display:none; width:100%;">
	<div class="container-fluid">
		<div class="row-fluid fullwidth">
		  <div id="col1" class="span2 SliderCaption" style="background-image: url(<%=request.getContextPath()%>/img/Pre.png);"></div>
		  <div id="col2" class="span10 col2">
				<div id="wowslider-container2" class="Carousel"></div>
		  </div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid fullwidth">
		  <div id="col1" class="span2 SliderCaption" style="background-image: url(<%=request.getContextPath()%>/img/at.png);"></div>
		  <div id="col2" class="span10 col2">
				<div id="wowslider-container3" class="Carousel"></div>
		  </div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid fullwidth">
		  <div class="span2 SliderCaption" style="background-image: url(<%=request.getContextPath()%>/img/Post.png);"></div>
		  <div class="span10 col2">
				<div id="wowslider-container4" class="Carousel"></div>
		  </div>
		</div>
	</div>
	<input class="btn btn-info cssback" type="button" value="Back"/>
</div>	

<div id="three" style="display:none; width:100%;">
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places" type="text/javascript"></script>
	<div id="gmap_canvas"></div>
	<div id='jqxWidget'></div>
</div>

<input id="repositoryId" type="hidden" value="<%=repositoryId%>">

</div>
<div class="hide">
<div id="weather-background" class="default-weather">
<div class="page-wrap">
<div id="geo-error-message" class="geo-error-message hide">
  <button id='close-error' class='fa fa-times close-error'></button>
  Uh oh! It looks like we can't find your location.</div>
<div id="front-page-description" class="front-page-description middle">
</div>
<div id="weather" class="weather middle hide">
  <div class="location" id="location"></div>
  <div class="weather-container">
    <div id="temperature-info" class="temperature-info">
    <div id="tmp_icon"></div>
      <div class="temperature" id="temperature"></div>
      <div class="weather-description" id="weather-description"></div>
    </div>
    <div class="weather-box">
      <ul class="weather-info" id="weather-info">
        <li class="weather-item humidity">Humidity: <span id="humidity"></span>%</li>
        <!-- -->
        <li class="weather-item wind">Wind: <span id="wind-direction"></span> <span id="wind"></span> <span id="speed-unit"></span></li>
      </ul>
    </div>
    <div style="align: center;">
   		<div id="forecast_small" style="font-size: 14px; text-align:center; display: inline-block;"></div>
   	</div>
  </div>
</div>
</div>
</div>
</div>
</body>