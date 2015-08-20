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
		$("#prev").hide();
		initContactList(_startPos,_endPos);
	});
</aui:script>

<body>
	<input type="hidden" id="CompanyId" value="<%=themeDisplay.getCompanyId()%>">
	<div id="action-msg"></div>
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
		    <a href="#" onclick="fnShowNextRecords();">Next</a>|<a href="#" onclick="fnShowPrevRecords();" id="prev">Prev</a>
		  </div>
	</div>
</body>

