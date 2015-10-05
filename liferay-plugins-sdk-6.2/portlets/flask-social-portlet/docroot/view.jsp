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
		var selectedUsers = [];
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
			$('#Friend_placeholder').html("");
			initFriendList(_startPos,_endPos);	
		});
		$("#mcontents").click(function(){
			$('#Users_placeholder').html("");
			initContactList(_startPos,_endPos);			
		});
		$("#notifications").click(function(){
			initNotifications();			
		});
		$("#jqxwindow").hide();
		$("#button_no").click(function () {
	        $("#jqxwindow").jqxWindow('close');
	    });
		$(".cssSendMsg").hide();
		$(".cssMultUser").show();
		$(".cssMultUser").click(function(){
			$(this).hide();
			$(".cssSendMsg").show();
			$(".chk").show();
		});
		$(".cssSendMsg").click(function(){
			$(this).hide();
			$(".cssMultUser").show();
			$(".chk").hide();
			$(".selected").each(function(){
				selectedUsers.push($(this).val());
			});
			fnSendMessage(selectedUsers);
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
    			<td align="left">
    				<div class="cssDelUser cssMultUser"><div class="iconDelUser"><i class="icon-list"></i></div></div>		
    			</td>
    			<td align="left">
    				<div class="cssDelUser cssSendMsg"><div class="iconDelUser"><i class="icon-share-alt"></i></div></div>		
    			</td>
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
				     <li class="previous more"><a href="#" onclick="fnShowNextFriends();">More..</a></li>
				</ul>
			</div>
		  </div>
		  <div class="tab-pane" id="SearchNewFriends">
			<div class="table-responsive">
				<div class="container-fluid fill" id="Users_placeholder"></div>
			</div>
			<div class="footerButtons">
				<ul class="pager">
				    <li class="previous"><a href="#" onclick="fnShowNextRecords();">More..</a></li>
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
	<div id='jqxwindow'>
	            <div>
	               Send Message
	            </div>
	            <div>
	                <textarea rows="8" cols="60" id="msg" name="message" style="width: 340px; height: 70px;"></textarea>
	                <div style="text-align: -webkit-center;">
		                <div id="y"><input type="button" value="Send" class="btn-primary" style="width: 98%" id="button_input"></div>
		                <div id="n"><input type="button" value="Cancel" class="btn-primary" id="button_no" /></div>
	               </div>
	            </div>
	</div>	
</body>

