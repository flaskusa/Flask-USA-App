<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.liferay.portlet.social.service.SocialRequestLocalServiceUtil"%>
<%@page import="com.liferay.portlet.social.model.SocialRequestConstants"%>
<%
  com.liferay.portal.theme.ThemeDisplay themeDisplay = (com.liferay.portal.theme.ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
  long repositoryId = themeDisplay.getLayout().getGroupId();
  themeDisplay.getLayout().getUuid();
  int unreadActionableUserNotificationsCount = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(themeDisplay.getUserId(), 3);
%>

<portlet:defineObjects />

<aui:script use="array-extras">
	$(document).ready(function(){
		var k=GetParameterValues('notifications');
		if(k==1){
			$("#notifications").click();
			initNotifications();
		}
		$("#prev").hide();
		initSearch();
		initFriendList(_startPos,_endPos);
		$("#frnds").click(function(){
			$("#prev").hide();
			initSearch();
			initFriendList(_startPos,_endPos);	
		});
		$("#mcontents").click(function(){
			initContactList(_startPos,_endPos);			
		});
		$("#notifications").click(function(){
			initNotifications();			
		});
	});
</aui:script>

<body>
	<input type="hidden" id="CompanyId" value="<%=themeDisplay.getCompanyId()%>">
	<div id="action-msg" style="display:none"></div>
	<div id='formContainer'>
		<ul class="nav nav-tabs">
		  <li class="active"><a href="#Friends" data-toggle="tab" id="frnds">My friends</a></li>
		  <li><a href="#SearchNewFriends" data-toggle="tab" id="mcontents">Search friends</a></li>
		  <li><a href="#Notifications" data-toggle="tab" id="notifications">Notifications</a></li>  
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
			</div>
			<div class="footerButtons">
				<ul class="pager">
				    <li class="previous"><a href="#" onclick="fnShowPrevRecords();">Previous</a></li>
				    <li class="next"><a href="#" onclick="fnShowNextRecords();">Next</a></li>
				</ul>
			</div>
		  </div>
		  <div class="tab-pane" id="SearchNewFriends">
			<div class="table-responsive">
				<div class="container-fluid fill" id="Users_placeholder"></div>
			</div>
			<div class="footerButtons">
				<ul class="pager">
				    <li class="previous"><a href="#" onclick="fnShowPrevRecords();">Previous</a></li>
				    <li class="next"><a href="#" onclick="fnShowNextRecords();">Next</a></li>
				</ul>
			</div>
		  </div>
		  <div class="tab-pane" id="Notifications">
			<div class="table-responsive">
				<div class="container-fluid fill">
					<div class="container">
					  <div class="panel-group">
					    <div class="panel panel-default" style="padding-bottom: 8px;">
					      <div class="panel-heading">Friend Requests (<span id="RequestCount"></span>)</div>
					      <div class="panel-body" id="MyFriendRequests">No friend request found</div>
					    </div>
					    <div class="panel panel-default" style="padding-bottom: 8px;">
					      <div class="panel-heading">Messages (0)</div>
					    </div>
					    <div class="panel panel-default" style="padding-bottom: 8px;">
					      <div class="panel-heading">Other Notifications (0)</div>
					    </div>
					  </div>
					</div>					  
				</div>
			</div>
		  </div>
		</div>
	</div>
	
	<div class="yui3-skin-sam">
    	<div id="modal"></div>
	</div>	
</body>

