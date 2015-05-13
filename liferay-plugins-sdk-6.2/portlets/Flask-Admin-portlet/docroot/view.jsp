<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<script>
//Create a YUI instance using io-base module.
YUI().use("io-base","aui-form-validator",function(Y) {
	var uri = '/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins';
    Y.on('io:complete', complete, Y, []);
    var request = Y.io(uri);
    new Y.FormValidator({boundingBox: '#adminForm'});
});

function complete(id, o, args) {
    var id = id; // Transaction ID.
    var data = o.responseText; // Response data.
	YUI().use('datatable', function (Y) {
        var table = new Y.DataTable({
		    columns: [{key: "firstName", label: "First Name", sortable: true },
		              {key: "lastName", label: "Last Name", sortable: true  },
		              {key: "email", label: "Email", sortable: true  },
		              	{
		            	  key: "userId", 
		            	  label: "Action", 
		            	  sortable: false, 
		            	  allowHTML: true,
		            	  formatter: '<a href="#" onclick="fnDelete({value});" class="imgDeleteIcon"></a>'
						}
		              ],
            data: JSON.parse(data),
            caption: "Admin users",
            summary: ""
        });
        table.render("#adminDataTable");
	});        
};

function fnDelete(AdminId){
	var a = window.confirm("Delete?");
	if(a){
	  	Liferay.Service(
		  '/flask-rest-users-portlet.flaskadmin/delete-flask-admins',
		  {
		    userId: AdminId
		  },
		  function(obj) {
		    console.log(obj);
		  }
		);
	}
	else
		{
		return false;
		}
}

function fnSave(){
	alert("In fnSave");		
	Liferay.Service(
	  '/flask-rest-users-portlet.flaskadmin/add-flask-admin',
	  {
	    firstName: $("#firstName").val(),
	    middleName: $("#middleName").val(),
	    lastName: $("#lastName").val(),
	    email: $("#email").val(),
	    screenName: $("#screenName").val(),
	    password1: $("#password1").val(),
	    password2: $("#password2").val()
	  },
	  function(obj) {
	    switch(obj.responseText){
	    	case "com.liferay.portal.UserPasswordExeption":
	    		alert("Password does no matched");
	    		return false;
	    	default:
	    		//Show success msg here.
				$("#adminDataTable").show();
				$("#adminForm").hide();
				return false;	    			
	    }
	    return false;
	  });    	
}


$(document).ready(function(){
	$(".btn").click(function(){
		var btnType = $(this).val();
		switch (btnType) { 
		    case 'Add': 
		        $("#adminDataTable").hide();
		        $("#adminForm").show();
		        break;
		    case 'Save': 
		        return fnSave();
		        break;
		    case 'Cancel': 
		        //alert('Cancel Wins!');
		        break;      
		    default:
		        //alert('test');
			}	
		});
});
</script>
<div id="adminDataTable" >
	<input class="btn btn-info" type="submit" value="Add">
</div>

<form id="adminForm">
  <div class="form-group">
    <label class="control-label" for="firstName">First Name:</label>
    <div class="controls">
      <input name="firstName" id="firstName" class="form-control field-required" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="middleName">Middle Name:</label>
    <div class="controls">
      <input name="middleName" id="middleName" class="form-control field-required" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="lastName">Last Name:</label>
    <div class="controls">
      <input name="lastName" id="lastName" class="form-control field-required" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="email">E-mail:</label>
    <div class="controls">
      <input name="email" id="email" class="form-control field-required field-email" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="screenName">Screen Name:</label>
    <div class="controls">
      <input name="screenName" id="screenName" class="form-control field-required" type="text">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="password1">Password:</label>
    <div class="controls">
      <input name="password1" id="password1" class="form-control field-required field-password-display-toggle" type="text">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label" for="password2">Confirm Password:</label>
    <div class="controls">
      <input name="password2" id="password2" class="form-control field-required field-password-display-toggle" type="text">
    </div>
  </div>  

  <input class="btn btn-info" type="submit" value="Save">
  <input class="btn btn-primary" type="reset" value="Cancel">
</form>
