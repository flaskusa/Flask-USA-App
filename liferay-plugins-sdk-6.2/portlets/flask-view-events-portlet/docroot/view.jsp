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
<div style="border: none;" id="listbox"></div>  
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