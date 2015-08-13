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

<body>
<div id="fixedfooter">
		<div class="container-fluid">
		<div class="row-fluid fullwidth">
		  <div id="col1" class="span2 SliderCaption" style="background-image: url(<%=request.getContextPath()%>/img/Pre.png);"></div>
		  <div id="col2" class="span10 col2">
				<div id="wowslider-advertisements" class="Carousel">
					<div>
					 <table>
		            		<tr>
				                <td class="footertxt">
				                    <img src="<%=request.getContextPath()%>/img/sym.png" class="footerimg" />
				                </td>
				                <td class="asans"><b>FREE PINT WITH A BURGER</b>
				                <br/>
				                <span class="gochi" >BETWEEN 11:00 AM - 2:30 PM</span>
				                <br/>
				                <span class="gochi">This is image 1!</span>
				                </td>
				            </tr>
		        	</table>
		        	</div>	
		        	<div>
						 <table>
			            		<tr>
					                <td class="footertxt">
					                    <img src="<%=request.getContextPath()%>/img/sym.png" class="footerimg" />
					                </td>
					                <td class="asans"><b>FREE PINT WITH A BURGER</b>
					                <br/>
					                <span class="gochi" >BETWEEN 11:00 AM - 2:30 PM</span>
					                <br/>
					                <span class="gochi">This is image 2!</span>
					                </td>
					            </tr>
			        	</table>
		        	</div>	
		        </div>
		  </div>
		</div>
	</div>
 </div>
  
</body>

