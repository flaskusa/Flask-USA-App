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
<%@	page import="com.liferay.portal.model.Address" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places" type="text/javascript"></script>
<%
  com.liferay.portal.theme.ThemeDisplay themeDisplay = (com.liferay.portal.theme.ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
  long repositoryId = themeDisplay.getLayout().getGroupId();
  themeDisplay.getLayout().getUuid();
  String userZipCode =  "";
  if(themeDisplay.isSignedIn() && themeDisplay.getRealUser().getAddresses().size() > 0){
	  Address addr =themeDisplay.getRealUser().getAddresses().get(0); 
	  if(addr != null){
		  userZipCode = addr.getZip();
	  }
  }
%>
<portlet:defineObjects />

<aui:script use="array-extras">
	$(document).ready(function(){
		initEventList();
	  	//$("#owl-example").owlCarousel();
	});
</aui:script>

<body>
<input  type="hidden"  id="userZipCode" value ="<%= userZipCode %>" >

<div id="action-msg" style="display:none">
</div>

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
  <img id="eventImg" alt="" src="" style="display: none;">
    <div id="container1">
		<div class="container-fluid fill" id="placeholder">
		</div>
    </div>
  </div>
 </div>
    
 <div id="two" style="display:none; width:100%;">
 	<table class='SliderTable' width='100%'>
 		<tr class='SliderRow'>
 			<td class="SliderCaption"><div class='CaptionImageDiv' style="background-image: url(<%=request.getContextPath()%>/img/Pre.png);"></div></td>
 			<td class='SliderCell'><div id="wowslider-container1" class="Carousel"></div></td>
		</tr>
 		<tr class='SliderRow'>
 			<td class="SliderCaption"><div class='CaptionImageDiv' style="background-image: url(<%=request.getContextPath()%>/img/at.png);"></div></td>
 			<td class='SliderCell'><div id="wowslider-container2" class="Carousel"></div></td>
		</tr>
 		<tr class='SliderRow'>
 			<td class="SliderCaption"><div class='CaptionImageDiv' style="background-image: url(<%=request.getContextPath()%>/img/Post.png);"></div></td>
 			<td class='SliderCell'><div id="wowslider-container3" class="Carousel"></div></td>
		</tr>
 	</table>
</div>	

<div id="three" style="display:none; width:100%; height:100%">
	<div id='jqxWidget'></div>
</div>

<input id="repositoryId" type="hidden" value="<%=repositoryId%>">

</div>
<div class="hide">
<div id="weather-background" class="default-weather">
<div class="page-wrap">
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

<div class="md-modal md-effect-14" id="modal-advertisement">
	<div class="md-content">
		<h3 id="myModalLabel">Modal Dialog</h3>
		<span class='md-closeBtn'>x</span>
		<div>
			<div class="imageContainer"></div>
		</div>
	</div>
</div>
<div class="md-overlay"></div>
<button class="md-trigger" data-modal="modal-advertisement" style="display:none"></button>
</body>

