<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="jsp/init.jsp"%>
<%
	long userId = user.getUserId();
    String userName = user.getFullName();
    long scopGroupId = scopeGroupId;
    long themeUserId = themeDisplay.getUserId();
%>
<script type="text/javascript">
	Liferay.Portlet.ready(initialize);
	function initialize(portletId, portlet){
		if(portletId == "flaskmanageusergroup_WAR_flaskmanageusergroupportlet") {
			//_flaskLib.init();
        $(document).ready(function () {
        	var userId = "<%=userId%>";
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
		<form id="myGroupForm" style="display: none">
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
			<div class="modal-footer">
			<!-- <button type="button" class="btn btn-primary pull-left clsBack">Back</button> -->
				<button type="button" class="btn btn-primary clsSaveGroup">Create</button>
				<button type="reset" class="btn btn-primary clsCancelGroup" >Cancel</button>
			</div>
		</form>

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
