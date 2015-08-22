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
		initSearch();
	});
</aui:script>

<body>
	<input type="hidden" id="CompanyId" value="<%=themeDisplay.getCompanyId()%>">
	<div id="action-msg" style="display:none"></div>
	<div id='formContainer'>
		<ul class="nav nav-tabs">
		  <li class="active"><a href="#Friends" data-toggle="tab">My friends</a></li>
		  <li><a href="#SearchNewFriends" data-toggle="tab" id="mcontents">Search friends</a></li>  
		</ul>
    	<table class="searchtable">
    		<tr>
    			<td align="right">
    				<input type="text" class="search-query" placeholder="Search">		
    			</td>
    			<td valign="top" align="left">
    				<button id="btnSubmit"><i class="icon-search"></i></button>		
    			</td>
    		</tr>
    	</table>		
		<div class="tab-content">
		  <div class="tab-pane active" id="Friends">
			<div class="table-responsive">  
				<div class="container-fluid fill" id="Friend_placeholder"></div>
				  <a href="#" onclick="fnShowPrevRecords();" id="prev">Prev</a>&nbsp;&nbsp;<a href="#" onclick="fnShowNextRecords();">Next</a>
			</div>
		  </div>
		  <div class="tab-pane" id="SearchNewFriends">
			<div class="table-responsive">
				<div class="container-fluid fill" id="Users_placeholder"></div>
				  <a href="#" onclick="fnShowPrevRecords();" id="prev">Prev</a>&nbsp;&nbsp;<a href="#" onclick="fnShowNextRecords();">Next</a>
			</div>
		  </div>
		</div>
	</div>	
</body>

