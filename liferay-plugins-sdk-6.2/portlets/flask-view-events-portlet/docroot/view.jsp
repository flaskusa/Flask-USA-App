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

<body>
<div class="table-responsive">          

  <table id="viewevent">
    <tbody>
      <tr>
        <td><div class="imgalig"><img src="<%=request.getContextPath()%>/img/lion.gif" class="imga" ></div>
        <div class="txtalig">
        <label class="control-label labelcolor">Detroit Liions vs. Chicago Bears</label>
        <label class="control-label">1:00 p.m. at Ford Field</label></div> </td>
      </tr>
      <tr>
        <td><div class="imgalig"><img src="<%=request.getContextPath()%>/img/d.gif" class="imga" ></div>
        <div class="txtalig">
        <label class="control-label labelcolor">Detroit Tigers vs. Milwaukee Brewers</label>
        <label class="control-label">7:05 p.m. at Comerica Park</label></div> </td>
      </tr>
      <tr>
         <td> <button type="button" class="button" >SEARCH FOR AN EVENT
   </button>
   </td>
      </tr>
		<tr >
         <td  style="padding-top:10px;">
			<input id="textbx1" class="form-control input-lg" type="text" placeholder="TYPE:">
         </td>
      </tr>
		<tr>
         <td class="textb"> <input id="textbx2"  type="text" placeholder="DATE:"></td>
      </tr>
		<tr>
         <td class="textb">   <input id="textbx3" type="text" placeholder="CITY:"></td>
      </tr>
		<tr>
         <td class="textb">   <input id="textbx4" type="text" placeholder="KEY WORDS:"></td>
      </tr>
      <tr>
        <td>  </td>
      </tr>
    </tbody>
  </table>

  </div>
   <div id="fixedfooter"><img src="<%=request.getContextPath()%>/img/banner.jpg" /></div> 
</body>