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
<div id="one">
    <div style="overflow: hidden;">
            <div style="border: none;" id="listbox">
            </div>
    </div>
  <table id="viewevent">
    <tbody>
		<tr>
		<td>
		 <div style="border: none;" id="listbox"></div>
		</td>
		</tr>
      <tr>
         <td class="gap"> <button type="button" class="button" >SEARCH FOR AN EVENT
   </button>
   </td>
      </tr>
		<tr>
	         <td class="gap">
				<input  type="text" placeholder="SEARCH:">
	         </td>
      	</tr>
		<tr>
        	 <td style="display:none;">
        	 <input type="text" placeholder="KEY WORDS:" >
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
 </div>
    
 <div id="two" style="display:none; width:100%; ">

  <div id="image1">
        <img id="banner" src="<%=request.getContextPath()%>/img/stripe.png" style=" height: 458px;" />
    </div>

    <div id="section"> 
    <div>
        <img src="<%=request.getContextPath()%>/img/Fotolia_81101979_Subscription_Monthly_M.jpg" class="imgside" />
    </div>
    <div>
        <img src="<%=request.getContextPath()%>/img/Fotolia_2932277_Subscription_Monthly_M.jpg" class="imgside" />
    </div>
    <div>
        <img src="<%=request.getContextPath()%>/img/Fotolia_20387372_Subscription_Monthly_M.jpg" class="imgside" />
    </div>
    </div>
    <input class="btn btn-info cssback" type="button" value="Back"/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
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