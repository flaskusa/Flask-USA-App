<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="jsp/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	long userId = user.getUserId();
    String userName = user.getFullName();
    String emailAddress = user.getEmailAddress();
    long scopGroupId = scopeGroupId;
    long themeUserId = themeDisplay.getUserId();
    boolean isSignedin = themeDisplay.isSignedIn();
%>
<script type="text/javascript">
	Liferay.Portlet.ready(initialize);
	function initialize(portletId, portlet){
		if(portletId == "flaskmanageusergroup_WAR_flaskmanageusergroupportlet") {
			//_flaskLib.init();
        $(document).ready(function () {
        	var userId = "<%=userId%>";
        	var emailAddress = "<%=emailAddress%>";
								setTimeout(function() {
									$("#loader").hide();
								}, 200);

								createMyGroupTable(
										{},
										_groupModel.DATA_MODEL.GROUP,
										$('#myGroupGrid'),
										"groupActionMenu",
										"Edit",
										myGroupContextMenuHandler,
										[ "Group","Members"],
										"myGroupGridContainer");
								loadGroupData(userId);
								groupClickHandlers();

							});
		}
	}
	// modal popup
</script>
<c:if test="<%= !isSignedin %>">
			<div id="action-msg1" class="alert alert-error">
				You are not signed-in to view this page.
			</div>
</c:if>
<c:if test="<%= isSignedin %>">
<div id="loader" class="se-pre-con"></div>
<!-- <div style="border: none; display: none;" id="tabs" class="container">
	<ul style="margin-left: 30px;">
		<li><a href="#myGroup">My Groups</a></li>
	</ul>
	<div style="overflow-x: hidden; border: none;" id="myGroup"> -->
		<div id="group-action-msg" style="display: none"></div>
		<div id="myGroupDataTable" class="table-condensed">
			<div class="cssGridMenu">
				<div class="cssAddUser">
					<div class="iconAddUser"></div>
				</div>
				<div class="cssSearchUser" id="cssSearchGroup">
					<div class="iconSearchUser">
						<i class="icon-search"></i>
					</div>
				</div>
				<div class="cssDelUser">
					<div class="iconDelUser">
						<i class="icon-list"></i>
					</div>
				</div>
				<div class="cssDelete">
					<div class="iconDelete">
						<i class="icon-trash"></i>
					</div>
				</div>
			</div>
			<div id="myGroupGridContainer" class="device-mobile-tablet">
				<div id="container" class="device-mobile-tablet-container">
					<div style="border: none;" id='myGroupGrid'></div>
				</div>
			</div>
		</div>
	<!-- </div>
</div>
 -->
 		<div id='groupActionMenu' style='display:none;'>
 		</div>
		<div id="myGroup-valid-msg" style="display: none"></div>

		<div id="addGroupUser-valid-msg" style="display: none"></div>
		<form id="addGroupUserForm" style="display: none;">
		<div class="form-group">
				<div class="pull-left">
				<h3>Add Group User</h3>
				</div>
			</div>
			<div class="form-group">
				<div class="cssGridMenu">
						<div class="cssSearchUser" id="cssSearchUser">
							<div class="iconSearchUser">
								<i class="icon-search"></i>
							</div>
						</div>
				</div>
				<div id="campaignJqxwidget">
					<div id="userDataGrid"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary pull-left clsBack">Back</button>
				<button type="button" class="btn btn-primary clsAddUserGroup">Add Friend</button>
				<button type="reset" class="btn btn-primary clsCancelGroup">Cancel</button>
			</div>
		</form>
		
		<div id="addGroupOwner-valid-msg" style="display: none"></div>
		<form id="addGroupOwnerForm" style="display: none;">
			<div class="form-group">
				<div class="pull-left">
				<h3>Add Group Owner</h3>
				</div>
			</div>
			<div class="form-group">
				<div class="cssGridMenu">
					<div class="cssSearchUser" id="cssSearchOwner">
						<div class="iconSearchUser">
							<i class="icon-search"></i>
						</div>
					</div>
				</div>
				<div id="campaignJqxwidget">
					<div id="userOwnerDataGrid"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary pull-left clsBack">Back</button>
				<button type="button" class="btn btn-primary clsAddOwnerGroup">Add Owner</button>
				<button type="reset" class="btn btn-primary clsCancelGroup">Cancel</button>
			</div>
			
		</form>
		<div id='formContainer'>
		<ul class="nav nav-tabs">
		  <li class="active"><a href="#GroupForm" data-toggle="tab" id="grpForm">Group Details</a></li>
		  <li><a href="#Friends" data-toggle="tab" id="frnds">My Friends</a></li>  
		</ul>
		<div class="tab-content">
		
		<div class="tab-pane active" id="GroupForm">
		<form id="myGroupForm">
		<input type="hidden" id="CompanyId" value="<%=themeDisplay.getCompanyId()%>">
			<div class="form-group">
				<div class="pull-left">
				<h3>Add Group</h3>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="form-group">
				<label class="control-label" for="groupName">Group Name:</label>
				<div class="controls">
					<input name="<portlet:namespace />groupName" id="groupName"
						class="form-control" type="text">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label" for="groupDescription">Group
					Description:</label>
				<div class="controls">
					<textarea rows="5" style="height:185px;" name="<portlet:namespace />groupDescription"
						id="groupDescription" class="form-control"></textarea>
				</div>
			</div>
			<input type="hidden" name="<portlet:namespace />userId" id="userId"
				value="<%=userId%>" /> <input type="hidden"
				name="<portlet:namespace />userName" id="userName"
				value="<%=userName%>" />
			<input type="hidden" name="<portlet:namespace />emailAddress" id="emailAddress"
				value="<%=emailAddress%>" />
			<div class="modal-footer">
			<!-- <button type="button" class="btn btn-primary pull-left clsBack">Back</button> -->
				<button type="button" class="btn btn-primary clsSaveGroup">Create</button>
				<button type="reset" class="btn btn-primary clsCancelGroup" >Cancel</button>
			</div>
		</form>
		<div class="form-group">
				<div class="pull-left">
				<h3>Group Members</h3>
				</div>
		</div><br>
		<div class="table-responsive" style="display: inline-block;">
				<div class="container-fluid fill" id="Group_placeholder"></div>
			</div>
			<div class="footerButtons">
				<ul class="pager">
				     <li class="previous more"><a href="#" onclick="fnShowNextFriends();">More..</a></li>
				</ul>
			</div>
		</div>
		
		
		  <div class="tab-pane" id="Friends">
			<div class="table-responsive">
				<div class="container-fluid fill" id="Menu_placeholder">
			    	<table class="searchtable">
			    		<tr>
			    			<td align="right">
			    				<input type="text" class="search-query" id='searchFriend' placeholder="Search">		
			    			</td>
			    			<td valign="top" align="left" style='width:100px;'>
			    				<a href="#" class="btnSubmit" id="btnSearchFriend"><i class="icon-search" style="color: black;"></i></a>
			    				<a href="#" class="cssMultUser btnSubmit"><i class="icon-list" style="color: black;"></i></a>
			    			</td>
			    		</tr>
			    	</table>		
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
			    				<a href="#" class="btnSubmit" id="btnSearchContact"><i class="icon-search" style="color: black;"></i></a>
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
		</div>
	</div>
</c:if>