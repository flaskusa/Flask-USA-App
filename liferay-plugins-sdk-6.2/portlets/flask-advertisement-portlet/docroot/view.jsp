<%@ include file="jsp/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%
boolean isAuthorised = renderRequest.isUserInRole("administrator") || 
						renderRequest.isUserInRole("flask-admin") || 
						renderRequest.isUserInRole("flask-content-manager");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="jsp/init.jsp"%>
<portlet:actionURL  var="addImagesActionURL" name="addImages"/>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
</head>
<c:if test="<%= !isAuthorised %>">
   <div id="action-msg1" class="alert alert-error">
    You are not authorize to view this page.
   </div>
</c:if>
<body>
<c:if test="<%= isAuthorised %>">
	<script type="text/javascript">
		Liferay.Portlet.ready(initialize);
		function initialize(portletId, portlet){
			console.log(portletId);
			if(portletId == "flaskadvertisement_WAR_flaskadvertisementportlet") {
				createCampaignTable({},_adCampaignModel.DATA_MODEL.CAMPAIGN, $('#campaignGrid'), "campaignActionMenu", "Edit", campaignContextMenuHandler, ["Campaign", "Images"]);
				loadCampaignData();
				adCampaignClickHandlers();
				loadEvents();
				
				  /// wait 3 seconds
			    setTimeout(function() {
					createCustomerTable({},_adCustomerModel.DATA_MODEL.CUSTOMER, $('#customerGrid'), "customerActionMenu", "Edit", customerContextMenuHandler, ["Customer"]);
					adCustomerClickHandlers();
					loadCustomerData();
			    }, 3000);
				  
			}
		}       
   </script>

<div id="campaign-action-msg" style="display:none"></div>
<div id='formContainer'>
	<ul class="nav nav-tabs">
	  <li class="active"><a href="#campaigns" data-toggle="tab">Manage Campaigns</a></li>
	  <li><a href="#customers" data-toggle="tab" id="mcontents">Manage Customers</a></li>  
	</ul>
	<div class="tab-content">
	  <div class="tab-pane active" id="campaigns">
		<div id="manageCampaignContainer">
			<div id="adCampaignDataTable" class="table-condensed">
			<div class="cssGridMenu">
				<div class="cssAddUser" id="addCampaign"><div class="iconAddVenue"></div></div>
				<div class="cssSearchUser" id="searchCampaign"><div class="iconSearchUser"><i class="icon-search"></i></div></div>
				<div class="cssDelUser" id="delCampaignList"><div class="iconDelUser"><i class="icon-list"></i></div></div>
				<div class="cssDelete" id="delCampaignTrash"><div class="iconDelete"><i class="icon-trash"></i></div></div>
			</div>
			  <div id="campaignGrid"></div>
			</div>
			<div id="adCampaignFormContainer" style="display:none;  height:100%; overflow-y: auto;">			  
				<form id="adCampaignForm">
				  <input type="hidden" id="imgActionUrl" value="<%=addImagesActionURL %>">
				   <div class="form-group">
				     <label class="control-label" for=campaignName>Campaign Name:</label>
				     <div class="controls">
				       <input name="campaignName" id="campaignName" class="form-control" type="text">
				     </div>
				   </div>
					<div class="form-group">
							<label class="control-label" for="customerId">Customer
										Name:</label>
							<div class="controls">
									<select name="customerId" id="customerId"
										class="form-control">
									</select>
							</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="frequencyPerHour">Frequency per hour:</label>
						<div class="controls">
							<input name="frequencyPerHour" id="frequencyPerHour" class="form-control" type="text">
						</div>
					</div>
					<div class="form-group" style="margin:15px 0">
					        <div class='displayAtChk'>
									<input type ='checkbox' checked='checked' name='showAlways' id = 'showAlways'/>
									Show Always
							</div>
					</div>
					<div id="optionalFields" style="display : none;">
					<div class="form-group">
						<label class="control-label" for="adDisplayTime">Display At</label>
						<div class="controls" id="adDisplayTime">
							<div class='displayAtChk'>
									<input type ='checkbox' checked='checked'  name='displayGeneral' id = 'displayGeneral'/>
									General
							</div>
							<div class='displayAtChk'>
									<input type ='checkbox' checked='checked'  name='displayPreEvent' id = 'displayPreEvent'/>
									Pre-Event
							</div>
							<div class='displayAtChk'>
									<input type ='checkbox' checked='checked'  name='displayDuringEvent' id = 'displayDuringEvent'/>
									During-Event
							</div>
							<div class='displayAtChk'>
									<input type ='checkbox' checked='checked'  name='displayPostEvent' id = 'displayPostEvent'/>
									Post-Event
							</div>
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label" for="eventTypeId">Event Type:</label>
						<div class="controls">
							<select name="eventTypeId" id="eventTypeId" class="form-control"
									onchange="filterData(this.value)">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="eventIds">Events</label>
						<div id="campaignJqxwidget">
									<div id="campaignEvents"></div>
						</div>
					</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="campainImagesUpload">Campaign Images</label>
						<div id="campainImagesUpload"></div>
					</div>
					<div class="form-group">
						<label class="control-label" for="campainImagesUpload">Uploaded Campaign Images</label>
						<div id="campaignDetailGallery" style="display: inline-flex;"></div>
					</div>
					<div class="form-group">
						<label class="control-label" for="eventIds">Campaign Full Screen Image</label>
						<div id="campainFullScreenImagesUpload"></div>
					</div>
					<div class="form-group">
						<label class="control-label" for="campaignFullScreenGallery">Uploaded Full Screen Image</label>
						<div id="campaignFullScreenGallery" style="display: inline-flex;"></div>
					</div>					
					
					<input class="btn btn-info clsSave" id="saveCampaign" type="button" value="Save"/>
					<input class="btn btn-primary clsCancel" id="cancelCampaign" type="button" value="Cancel" >
				</form>
			</div>
			<div id='campaignActionMenu' style="display:none">
				<ul>
					<li>Edit</li> 					<!--fnShowForm({value}); -->
					<li>Delete</li>					<!--fnDelete({value}); -->
				</ul>
		  	</div>
		</div>  
	  </div>
	  <div class="tab-pane" id="customers">
		<div id="manageCustomerContainer">
			<div id="customersDataTable" class="table-condensed">
			  <div class="cssGridMenu">
				<div class="cssAddUser" id="addCustomer"><div class="iconAddVenue"></div></div>
				<div class="cssSearchUser" id="searchCustomer"><div class="iconSearchUser"><i class="icon-search"></i></div></div>
				<div class="cssDelUser" id="delCustomerList"><div class="iconDelUser"><i class="icon-list"></i></div></div>
				<div class="cssDelete" id="delCustomerTrash"><div class="iconDelete"><i class="icon-trash"></i></div></div>
				</div>
				  <div id="customerGrid">
				  
				  </div>
			</div>
			<div id="addCustomerFormContainer" style="display:none;  height:100%; overflow-y: auto;">			  
				<form id="addCustomerForm">
						   <div class="form-group">
						     <label class="control-label" for=customerName>Customer Name:</label>
						     <div class="controls">
						       <input name="customerName" id="customerName" class="form-control" type="text">
						     </div>
						   </div>
						   <div class="form-group">
						     <label class="control-label" for="businessType">Business Type:</label>
						     <div class="controls">
						       <input name="businessType" id="businessType" class="form-control" type="text">
						     </div>
						   </div>
						
						   <div class="form-group">
						     <label class="control-label" for="businessPhoneNumber">Phone:</label>
						     <div class="controls">
						       <input name="businessPhoneNumber" id="businessPhoneNumber" class="form-control" type="text">
						     </div>
						   </div>    
			
						   <div class="form-group">
						     <label class="control-label" for="email">E-mail:</label>
						     <div class="controls">
						       <input name="email" id="email" class="form-control" type="text">
						     </div>
						   </div>
		
						   <div class="form-group">
						     <label class="control-label" for="websiteURL">Website:</label>
						     <div class="controls">
						       <input name="websiteURL" id="websiteURL" class="form-control" type="text">
						     </div>
						   </div>
						   
						   <div class="form-group">
						     <label class="control-label" for="contactPersonName">Contact name:</label>
						     <div class="controls">
						       <input name="contactPersonName" id="contactPersonName" class="form-control" type="text">
						     </div>
						   </div>
		
						   <div class="form-group">
						     <label class="control-label" for="contactPersonNumber">Contact Phone:</label>
						     <div class="controls">
						       <input name="contactPersonNumber" id="contactPersonNumber" class="form-control" type="text">
						     </div>
						   </div>
						
						   <div class="form-group">
						     <label class="control-label" for="addrLine1">Address Line 1:</label>
						     <div class="controls">
						       <input name="addrLine1" id="addrLine1" class="form-control" type="text">
						     </div>
						   </div>
		
						   <div class="form-group">
						     <label class="control-label" for="addrLine2">Address Line 2:</label>
						     <div class="controls">
						       <input name="addrLine2" id="addrLine2" class="form-control" type="text">
						     </div>
						   </div>
		
						   <div class="form-group">
						     <label class="control-label" for="zipCode">Zip Code:</label>
						     <div class="controls">
						       <input name="zipCode" id="zipCode" class="form-control" type="text">
						     </div>
						   </div>
						   
						   <div class="form-group">
						     <label class="control-label" for="city">City:</label>
						     <div class="controls">
						       <input name="city" id="city" class="form-control" type="text">
						     </div>
						   </div>  
						   
						    <div class="form-group">
						     <label class="control-label" for="stateId">State:</label>
						     <div class="controls">
						       <select id="stateId" name="stateId" class="form-control"></select>
						     </div>
						   </div>  
						     
						   <div class="form-group">
						     <label class="control-label" for="countryId">Country:</label>
						     <div class="controls">
						       <select id="countryId" name="countryId" class="form-control" ></select>
						     </div>
						   </div>  
						 
						  <input class="btn btn-info clsSave" id="customerSave" type="button" value="Save"/>
						  <input class="btn btn-primary clsCancel" id="customerCancel" type="button" value="Cancel" >
						
				</form>
			</div>  
			
			
			<div id='customerActionMenu' style="display:none">
				<ul>
					<li>Edit</li> 					<!--fnShowForm({value}); -->
					<li>Delete</li>					<!--fnDelete({value}); -->
				</ul>
		  	</div>
		</div>
		
	  </div>
	</div>
</div>

<div class="md-modal md-effect-14" id="modal-advertisement">
	<div class="md-content">
		<h3 id="myModalLabel"><span id='adTitle'>Modal Dialog</span><span class='md-closeBtn icon-remove-sign'></span></h3>
		<div>
			<div class="imageContainer"></div>
			<div class="footerInfo"></div>
		</div>
	</div>
</div>
<div class="md-overlay"></div>
<button class="md-trigger" data-modal="modal-advertisement" style="display:none"></button>
</c:if>
</body>
</html>