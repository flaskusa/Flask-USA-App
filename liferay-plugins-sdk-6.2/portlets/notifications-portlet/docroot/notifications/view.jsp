<%--
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
--%>


<%@page import="com.liferay.portlet.social.service.SocialRequestLocalServiceUtil"%>
<%@page import="com.liferay.portlet.social.model.SocialRequestConstants"%>
<%@ include file="/init.jsp" %>

<%
boolean actionable = ParamUtil.getBoolean(request, "actionable");
%>

<div class="clearfix user-notifications-container <%= actionable ? "actionable" : "non-actionable" %>">
	<aui:row>
		<aui:col cssClass="nav-bar user-notifications-sidebar" width="<%= 25 %>">
			<div class="nav">
				<a class="clearfix non-actionable <%= !actionable ? "selected" : "" %>" href="javascript:;">
					<span class="title"><liferay-ui:message key="notifications" /></span>

					<%
					int unreadNonActionableUserNotificationsCount = NotificationsUtil.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false, false);
					%>

					<span class="count"><%= unreadNonActionableUserNotificationsCount %></span>
				</a>
			</div>

			<div class="nav">
				<a class="actionable clearfix <%= actionable ? "selected" : "" %>" href="javascript:;">
					<span class="title"><liferay-ui:message key="requests" /></span>

					<%
					int unreadActionableUserNotificationsCount = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(themeDisplay.getUserId(), 3);
					
					
					%>

					<span class="count"><%= unreadActionableUserNotificationsCount %></span>
				</a>
			</div>

			<div class="nav" style="display:none;">
				<a class="clearfix manage" href="javascript:;">
					<span class="title"><liferay-ui:message key="notification-delivery" /></span>
				</a>
			</div>
		</aui:col>

		<aui:col cssClass="user-notifications-list-container" width="<%= 75 %>">
			<ul class="unstyled user-notifications-list">
				<li class="clearfix pagination top">
					<span class="hide left-nav previous"><a href="javascript:;"><liferay-ui:message key="previous" /></a></span>

					<span class="hide page-info"></span>

					<span class="hide next right-nav"><a href="javascript:;"><liferay-ui:message key="next" /></a></span>
				</li>

				<div class="mark-all-as-read"></div>

				<div class="user-notifications"><div id="Friend_placeholder"></div></div>

				<li class="bottom clearfix pagination">
					<span class="hide left-nav previous"><a href="javascript:;"><liferay-ui:message key="previous" /></a></span>

					<span class="hide page-info"></span>

					<span class="hide next right-nav"><a href="javascript:;"><liferay-ui:message key="next" /></a></span>
				</li>
			</ul>

			<div class="hide notifications-configurations"></div>
		</aui:col>
	</aui:row>
</div>

<aui:script use="aui-base,liferay-plugin-notifications">
	var notificationsCount = '.non-actionable .count';

	Liferay.Service(
			  '/flask-social-portlet.entry/get-requesting-users',
			  {
			    companyId: 20154,
			    keywords: ''
			  },
			  function(obj) {
			    console.log(obj);
			    renderContactList(obj);
			  }
			);
	
	
	function renderContactList(tdata) {
		 var divRow = $('#Friend_placeholder');
		 console.log(tdata);
		 $(divRow).html("");
		 //console.log(tdata.length);
		 if(tdata.length == 0){
			$("<span class='control-label-nocolor'>There are no users available</span>").appendTo($(divRow));
			return;
		 }
		 for(var i=0; i < tdata.length; i++)
			{
			 	var flaskUser = tdata[i];
			    var objTable = $('<table/>',{'class':'tblRow'});
			    var objTr = $('<tr/>');
			    $(objTr).appendTo($(objTable));
			    var objTd1 = $('<td/>',{'width':'70px','rowspan':'2'});
			    $(objTd1).appendTo($(objTr));
			    
			    fnShowEventLogo(flaskUser.uuid, objTd1,false);		    
			    var userName_lbl = $('<label/>',{'class':'control-label-color'});
			    $(userName_lbl).html(flaskUser.fullName);
			    var objTd2 = $('<td/>',{'data-id':flaskUser.userId,'data-uuid':flaskUser.uuid, 'style':'width: 250px;'});
			    
			    $(userName_lbl).appendTo($(objTd2));
			    $(objTd2).appendTo(objTr);
			    var objTd3 = $('<td/>',{'rowspan':'2','align':'right','valign':'top'});
			    console.log(flaskUser);
		    	var div_heart = fnBuildRequestMenu(flaskUser, objTable);
		    	
			    $(div_heart).appendTo($(objTd3));
			    $(objTd3).appendTo(objTr);

			    var objTr2 = $('<tr/>');
			    var objtd2_1 = $('<td/>');
			    var venue_lbl = $('<label/>',{'class':'control-label-nocolor'});
			    $(objtd2_1).appendTo(objTr2);
			    $(venue_lbl).html(flaskUser.emailAddress);
			    $(venue_lbl).appendTo($(objtd2_1));
			    $(objtd2_1).appendTo($(objTr2));
			    $(objTr2).appendTo($(objTable));
			    $(objTable).appendTo($(divRow));		    
		    }
		 	
	}
	function fnShowEventLogo(imageUUID, container ,editable){
		//var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID;
		var imgURL = "/webdav/guest/document_library/DefaultProfilePic";
		var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')'});
		$(objdiv).appendTo($(container));
	}
	function fnBuildRequestMenu(obj, htmlObject){
		 var IsBlocked = obj.block;
		 var UserId = obj.userId;
		 var dropdown = $('<div/>',{'class':'dropdown'});
		 if(!IsBlocked){
		  var IsFriend = obj.connected;
		  var ul = $('<ul/>',{'class':'dropdown-menu MyDDStyle'});
		  if(!IsFriend){
		   var buttonAccept = $('<button/>',{'class':'btn btn-primary','type':'button'})
		   buttonAccept.html('Confirm');
		   buttonAccept.click(function(){
		    acceptFriendRequest(UserId, htmlObject);
		   });
		   var buttonReject = $('<button/>',{'class':'btn btn-primary','type':'button','style':'margin-left: 10px;', 'onclick':'ignoreFriendRequest('+UserId+','+htmlObject+');'})
		   buttonReject.html('Ignore');
		  }
		  $(buttonAccept).appendTo($(dropdown));
		  $(buttonReject).appendTo($(dropdown));
		  return $(dropdown);
		 }
		}
	function acceptFriendRequest(UserId,obj){
		Liferay.Service(
				  '/flask-social-portlet.entry/add-social-relation',
				  {
				    receiverUserId: UserId
				  },
				  function(obj) {
					  $(obj).hide();
					  initFriendList(_startPos,_endPos);
					  
				  }
				);
		}
	function initFriendList(startPos,endPos){
		 if(startPos>0)
		  $("#prev").show();
		 var companyId = $("#CompanyId").val();
		 var searchString = $(".search-query").val();
		 var params = {companyId: companyId,keywords: searchString,start: startPos,end: endPos};
		 var flaskRequest = new Request();
		 flaskRequest.sendGETRequest(_socialModel.SERVICE_ENDPOINTS.GET_MY_FRIENDS , params, 
		  function (data){
		   renderContactList(data,true);
		  } ,
		  function (data){
		   _flaskLib.showErrorMessage('action-msg',_socialModel.MESSAGES.SEARCH_ERR);
		 });
		}
	
</aui:script>