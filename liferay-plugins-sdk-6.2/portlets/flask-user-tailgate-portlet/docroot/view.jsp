<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@include file="init.jsp"%>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:actionURL  var="addImagesActionURL" name="addImages"/>
<%
long userId = user.getUserId();
String userName = user.getFullName();
 long repositoryId = themeDisplay.getLayout().getGroupId();
 boolean isSignedin = themeDisplay.isSignedIn();
%>
<c:if test="<%= !isSignedin %>">
			<div id="action-msg1" class="alert alert-error">
				You are not signed-in to view this page.
			</div>
</c:if>
<aui:script>
var bCreated;
Liferay.Portlet.ready(initialize);
function initialize(portletId, portlet){
	if(portletId == "flaskusertailgate_WAR_flaskusertailgateportlet") {
		_tailgateModel.userId = "<%=userId%>";
		_tailgateModel.userName ="<%=userName%>";
		createTable({},_tailgateModel.DATA_MODEL.TAILGATE, $('#grid'), "tailgateActionMenu", "Edit", contextMenuHandler, ["Tailgate","Location","Images"]);
		loadData();
		addClickHandlers();
		initForm();
		$("#startTime").datetimepicker({
			format: "LT"
			//pickDate: false,  
			//pick12HourFormat: true
		});
		$("#endTime").datetimepicker({
			format: "LT"
			//pickDate: false, 
			//pick12HourFormat: true
		});
	}
}
</aui:script>
<body class='default'>
<c:if test="<%= isSignedin %>">
<input type="hidden" id="repositoryId" value="<%=repositoryId%>"/>
<div id="action-msg-warning" style="display:none"></div>
<div id="action-msg" style="display:none"></div>


<div id="tailgateDataTable" class="table-condensed">
	<div class="cssGridMenu">
		<div class="cssAddUser"><div class="iconAddTailgate"><i class="icon-glass"></i></div></div>
		<div class="cssSearchUser"><div class="iconSearchUser"><i class="icon-search"></i></div></div>
		<div class="cssDelUser"><div class="iconDelUser"><i class="icon-list"></i></div></div>
		<div class="cssDelete"><div class="iconDelete"><i class="icon-trash"></i></div></div>
	</div>
	<!-- <div id="eventDetailsDataTable" class="table-condensed">
	  <input class="btn btn-info cssAddUserTailgate" type="button" value="Add Tailgate"/>
	</div> -->
	<br/><br/>

	<div id="GridContainer" class="device-mobile-tablet"> 
	    <div id="container" class="device-mobile-tablet-container">
	        <div style="border: none;" id='grid'></div>
	    </div>
	</div>
</div>
<div id='formContainer' style="display:none">
	<ul class="nav nav-tabs">
	  <li class="active"><a href="#tailgates" data-toggle="tab">Manage Tailgate</a></li>
	  <li><a href="#contents" data-toggle="tab" id="mcontents">Upload Pictures</a></li>  
	  <li><a href="#users" data-toggle="tab" id="musers">Attendees</a></li>  
	</ul>
	
	<div class="tab-content">
	  	<div class="tab-pane active" id="tailgates">
			<div id='tailgateActionMenu' style='display:none;'></div>
		
			<form id="tailgateForm">
			<input type="hidden" id="imgActionUrl" value="<%=addImagesActionURL %>">
			  <div class="form-group">
			    <div class="controls">
				    <label class="control-label" for="tailgateName">Tailgate Name:</label>
				    <input name="<portlet:namespace />tailgateName" id="tailgateName" class="form-control" type="text" onchange="$('#description').val($(this).val());"/>
				</div> 
			  </div>
			  <div class="form-group">
			    <div class="controls">
				    <label class="control-label" for="tailgateDescription">Description:</label>
				    <input name="<portlet:namespace />tailgateDescription" id="tailgateDescription" class="form-control" type="text" onchange="$('#description').val($(this).val());"/> 
				</div> 
			  </div>
			   <div class="form-group">
				    <label class="control-label" for="eventId">Event:</label>
					<div class="controls">
						<select id="eventId" name="<portlet:namespace />eventId" class="form-control-select" ></select>
					</div>
			   </div>
			    <div class="form-group">
				    <div class="controls">
				    	<label  class="control-label" for="tailgateDate">Event date:</label>
				    	<input type="text" class="form-control" id = "tailgateDate" readonly>
				  	</div>
			   </div> 
			
			   <div class="form-group">
			    <label class="control-label" for="startTime">Start Time:</label>
			    <div class="controls">
			      <input type='text' class="form-control" id='startTime' />
			    </div>
			  </div>
			
			  <div class="form-group">
				<label class="control-label" for="endTime">End Time:</label>
			    	<div class="controls">
			    		 <input type='text' class="form-control" id='endTime' />
			    	</div>
			  </div>
			  
			  <div class="form-group">
				<label class="control-label" for="venmoAccountId">Venmo Account:</label>
			    	<div class="controls">
			    		 <input type='text' class="form-control" id='venmoAccountId' />
			    	</div>
			  </div>

			  <div class="form-group">
				<label class="control-label" for="amountToPay">Amount:</label>
			    	<div class="controls">
			    		 <input type='text' class="form-control" id='amountToPay' />
			    	</div>
			  </div>
			  
			  <br/>
			  <input type="hidden" id="eventName" value="">	
			  <input type="hidden" name="<portlet:namespace />repositoryId" value="<%= repositoryId %>>">
			  <input id="tailgateId" type="hidden" value="0">
			</form>
			   <div class="form-gorup">
			   <div align="center">Double Click to Drop a New Marker</div>
			   <div id="google_map"></div>
			   </div>
			  <input id="Ok" class="btn btn-info clsSave" type="button" value="Ok"/>
			  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >

	</div>	
	<div class="tab-pane" id="contents">
		<div class="form-group">
		    <label class="control-label" for="eventImage">Tailgate Image:</label>
			<div class="controls">
				<div id="eventImage"></div>
			</div>
			<input id="Upload" class="btn btn-info clsUpload" type="button" value="Upload"/>
	   </div>
	   
		<div class="form-group">
		    <label class="control-label" for="eventImage">Uploaded Images:</label>
			<div class="controls">
				<div id="uploadedImages"></div>
			</div>
	   </div>		   
	</div>
	<div class="tab-pane" id="users">
			<div class="form-group">
					<div id="campaignJqxwidget">
						<div id="tailgateMembersDataGridShow"></div>
					</div>
			</div>
	</div>	
	
</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Image details</h4>
      </div>
      <div class="modal-body">
  <div class="tailgateImageDetail"></div>        
  <div class="form-group">
      <div class="controls controlsInline">
       <label class="control-label" for="imageTitle">Title:</label>
       <input name="<portlet:namespace />imageTitle" id="imageTitle" class="form-control" type="text"/>
   </div> 
    </div>
    <div class="form-group">
      <div class="controls controlsInline">
       <label class="control-label" for="imageDescription">Description:</label>
       <input name="<portlet:namespace />imageDescription" id="imageDescription" class="form-control" type="text"/> 
   </div> 
    </div>
   </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" id="btnClose">Close</button>
        <button type="button" class="btn btn-primary" id="btnSaveImageDetails">Save</button>
      </div>
    </div>
  </div>
</div>		
		  <!-- Add Group Start here -->
		  	<div id="addTailgateMembers-valid-msg" style="display: none"></div>
			<form id="addTailgateMembersForm" style="display: none;">
			<div class="form-group">
					<div class="pull-left">
					<h3>Add Members</h3>
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
						<div id="tailgateMemberDataGrid"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary pull-left clsBack">Back</button>
					<button type="button" class="btn btn-primary clsAddTailgateMembers">Add Members</button>
					<button type="reset" class="btn btn-primary clsCancelGroup">Cancel</button>
				</div>
			</form>
			<div id="addTailgateGroup-valid-msg" style="display: none"></div>
			<form id="addTailgateGroupForm" style="display: none;">
				<div class="form-group">
					<div class="pull-left">
					<h3>Add Group</h3>
					</div>
				</div>
				<div class="form-group">
					<div class="cssGridMenu">
						<div class="cssSearchUser" id="cssSearchGroup">
							<div class="iconSearchUser">
								<i class="icon-search"></i>
							</div>
						</div>
					</div>
					<div id="campaignJqxwidget">
						<div id="tailgateGroupDataGrid"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary pull-left clsBack">Back</button>
					<button type="button" class="btn btn-primary clsAddTailgateGroup">Add Group</button>
					<button type="reset" class="btn btn-primary clsCancelGroup">Cancel</button>
				</div>
			</form>
			
	<div class="md-modal md-effect-14" id="modal-advertisement">
		<div class="md-content">
			<h3 id="myModalLabel">Flask Gallery</h3>
			<span class='md-closeBtn'>x</span>
			<div>
				<div class="imageContainer"></div>
			</div>
		</div>
	</div>
	<div class="md-overlay"></div>
	<button class="md-trigger" data-modal="modal-advertisement" style="display:none">&nbsp;</button>			
</c:if>
</body>
</html>
