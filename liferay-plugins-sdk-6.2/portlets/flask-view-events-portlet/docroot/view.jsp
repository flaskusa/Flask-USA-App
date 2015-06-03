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

<portlet:defineObjects />
<link async href="http://fonts.googleapis.com/css?family=Average%20Sans" rel="stylesheet" type="text/css"/>
<link async href="http://fonts.googleapis.com/css?family=Gochi%20Hand" rel="stylesheet" type="text/css"/>
<body>
<div class="table-responsive">          

  <table id="viewevent">
    <tbody>
      <tr>
        <td><div class="imgdiv"><img src="<%=request.getContextPath()%>/img/lion.gif"  ></div>
        <div class="lbldiv">
        <label id="teamlbl" class="control-label">Detroit Liions vs. Chicago Bears</label>
        <label id="timelbl" class="control-label" >1:00 p.m. at Ford Field</label></div> </td>
      </tr>
      <tr>
       	<td><div class="imgdiv"><img src="<%=request.getContextPath()%>/img/d.gif" ></div>
	        <div class="lbldiv">
		        <label id="teamlbl1" class="control-label" >Detroit Tigers vs. Milwaukee Brewers</label>
		        <label id="timelbl1" class="control-label" >7:05 p.m. at Comerica Park</label>
	        </div> 
      	</td>
      </tr>
      <tr>
         <td class="gap"> <button type="button" class="button" >SEARCH FOR AN EVENT
   </button>
   </td>
      </tr>
		<tr>
	         <td class="gap">
				<input id="txt1" type="text" placeholder="TYPE:">
	         </td>
      	</tr>
		<tr>
         	<td >
         	<input id="txt2"   type="text" placeholder="DATE:">
         	</td>
      	</tr>
		<tr>
        	 <td >
        	 <input id="txt3"  type="text" placeholder="CITY:">
        	 </td>
     	 </tr>
		<tr>
        	 <td >
        	 <input id="txt4"  type="text" placeholder="KEY WORDS:">
        	 </td>
     	</tr>
    </tbody>
  </table>
<div id="fixedfooter">
<table >
            <tr>
                <td class="footertxt">
                    <img src="<%=request.getContextPath()%>/img/sym.png" class="footerimg" />
                </td>
                <td class="asans"><b>FREE PINT WITH WITH A BURGER</b>
                <span class="gochi" >BETWEEN 11:00 AM - 2:30 PM</span>
                <span class="gochi">ON GAMEDAY!</span>
                </td>
            </tr>
        </table>
</div>
  </div>
</body>