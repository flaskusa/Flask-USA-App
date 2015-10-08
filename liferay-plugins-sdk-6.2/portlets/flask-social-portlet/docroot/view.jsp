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
<body>
	<input type="hidden" id="CompanyId" value="<%=themeDisplay.getCompanyId()%>">
	<div id="action-msg" style="display:none"></div>
	<div id='formContainer'>
		<ul class="nav nav-tabs">
		  <li class="active"><a href="#Friends" data-toggle="tab" id="frnds">My friends</a></li>
		  <li><a href="#SearchNewFriends" data-toggle="tab" id="mcontents">Search friends</a></li>
		  <li><a href="#Notifications" data-toggle="tab" id="notifications">Notifications</a></li>  
		</ul>
		<div class="tab-content">
		  <div class="tab-pane active" id="Friends">
			<div class="table-responsive">
				<div class="container-fluid fill" id="Menu_placeholder">
			    	<table class="searchtable">
			    		<tr>
			    			<td align="right">
			    				<input type="text" class="search-query" id='searchFriend' placeholder="Search">		
			    			</td>
			    			<td valign="top" align="left" style='width:100px;'>
			    				<button class="btnSubmit" id="btnSearchFriend"><i class="icon-search"></i></button>
			    				<button class="cssMultUser btnSubmit"><i class="icon-list"></i></button>
			    			</td>
			    		</tr>
			    	</table>		
				</div>  
				<div class="container-fluid fill" id="Message_placeholder">
					<div id='msgDiv'>
					   <div>
					      <h4>Send Message</h4>
					   </div>
					   <div>
					       <textarea rows="8" cols="60" id="msg" name="message" style="width: 48%;; height: 70px;"></textarea>
					       <br><input type="checkbox" id="sendEmail" checked />&nbsp;Send Email<br>
					       <div>
					        <div style="display: -webkit-inline-box;"><input type="button" value="Send" class="btn-primary" style="width: 98%" id="send_all"></div>
					        <div style="display: -webkit-inline-box;"><input type="button" value="Cancel" class="btn-primary" id="cancel_all" /></div>
					      </div>
					   </div>
					</div>				
				</div>				
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
				<div class="container-fluid fill" id="Menu_placeholder">
			    	<table class="searchtable">
			    		<tr>
			    			<td align="right">
			    				<input type="text" class="search-query"  id='searchContact' placeholder="Search">		
			    			</td>
			    			<td valign="top" align="left" style='width:100px;'>
			    				<button class="btnSubmit" id="btnSearchContact"><i class="icon-search"></i></button>
			    			</td>
			    		</tr>
			    	</table>		
				</div>			
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
				  <div class="panel-group">
				    <div class="panel panel-default" style="padding-bottom: 8px;">
				      <div class="panel-heading" id="frndsTopDiv">Friend Requests (<span id="RequestCount"></span>)</div>
				      <div class="panel-body" id="MyFriendRequests">No friend request found</div>
				    </div>
				    <div class="panel panel-default" style="padding-bottom: 8px;">
				      <div class="panel-heading" id="msgsTopDiv">Messages (<span id="MessageCount">0</span>)</div>
				      <div class="panel-body" id="MyMessages">No Messages found</div>
				    </div>
				    <div class="panel panel-default" style="padding-bottom: 8px;">
				      <div class="panel-heading" id="otherTopDiv">Other Notifications (0)</div>
				    </div>
				  </div>
				</div>					  
			</div>
		  </div>
		</div>
	</div>
	<div class="md-modal md-effect-14" id="modal-advertisement">
		<div class="md-content">
			<h3 id="myModalLabel">Send Message</h3>
			<span class='md-closeBtn'>x</span>
			<table width="75%" cellpadding='10px' cellspacing='10px'>
				<tr>
					<td colspan="2"><textarea rows="8" cols="60" id="iMsg" name="message" style="width: 100%;height: 70px;"></textarea></td>
				</tr>
				<tr>
					<td align='left'><input type="checkbox" id="sendEmailToSinglePerson" checked />&nbsp;Send Email</td>
					<td align='right'><button class="md-send">Send</button></td>
				</tr>				
			</table>
		</div>
	</div>
	<div class="md-overlay"></div>
	<button class="md-trigger" data-modal="modal-advertisement" style="display:none">3D</button>
</body>

