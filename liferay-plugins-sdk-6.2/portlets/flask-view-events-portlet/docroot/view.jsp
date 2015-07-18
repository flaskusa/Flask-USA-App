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
<link async href="http://fonts.googleapis.com/css?family=Average%20Sans" rel="stylesheet" type="text/css"/>
<link async href="http://fonts.googleapis.com/css?family=Gochi%20Hand" rel="stylesheet" type="text/css"/>

<body>
<div class="table-responsive">          
<div id="one">
  <table id="viewevent">
    <tbody>
		<tr>
	         <td class="gap">
				<input  type="text" placeholder="SEARCH:" id="txtSearch">
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
 <div style="overflow: hidden; display:none" id="ContentPanel"></div>

<table>
<tr>
  <td style="background-color: #231F20;">
           <img class="SliderCaption" src="<%=request.getContextPath()%>/img/Pre.png"/>
  </td>
  <td>
          <div id="wowslider-container2" class="wowslider-container">
		  <div class="ws_images" id="ws_images2"></div>
		  </div>
  </td>
</tr>
    
<tr>
  <td style="background-color: #231F20;">
       <img class="SliderCaption" src="<%=request.getContextPath()%>/img/at.png"/>
  </td>
  <td> 
       <div id="wowslider-container3" class="wowslider-container">
	   <div class="ws_images" id="ws_images3"></div>
	   </div>
  </td>
</tr> 
<tr>
  <td style="background-color: #231F20;">
       <img class="SliderCaption" src="<%=request.getContextPath()%>/img/Post.png"/>
  </td>
  <td>   
    	<div id="wowslider-container4" class="wowslider-container">
		<div class="ws_images" id="ws_images4"></div>
		</div>
  </td>
</tr>
</table>

	<input class="btn btn-info cssback" type="button" value="Back"/>
	</br></br></br></br>
</div>	

	<input id="repositoryId" type="hidden" value="<%=repositoryId%>">
    <div id="fixedfooter">
	    <table>
            <tr>
                <td class="footertxt">
                    <img src="<%=request.getContextPath()%>/img/sym.png" class="footerimg" />
                </td>
                <td class="asans"><b>FREE PINT WITH WITH A BURGER</b>
                <br/>
                <span class="gochi" >BETWEEN 11:00 AM - 2:30 PM</span>
                <br/>
                <span class="gochi">ON GAMEDAY!</span>
                </td>
            </tr>
        </table>
	</div>
</body>