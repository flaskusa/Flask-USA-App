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
YUI().use("io-base",function(Y) {
	var uri = '/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins';

    // Define a function to handle the response data.
    function complete(id, o, args) {
        var id = id; // Transaction ID.
        var data = o.responseText; // Response data.
        //var args = args[1]; // 'ipsum'.
        //var json = JSON.parse(e.responseText);
        //console.log(json); 
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
			            	  formatter: '<a href="#" onclick="deleteAdmin({value});" class="imgDeleteIcon"></a><!--<a href="#" onclick="deleteAdmin({value});" class="imgEditIcon"></a>-->'
							}
			              ],
	            data: JSON.parse(data),
	            caption: "Admin users",
	            summary: ""
	            
	        });
	        table.render("#adminDataTable");
		});        
    };
	
    // Subscribe to event "io:complete", and pass an array
    // as an argument to the event handler "complete", since
    // "complete" is global.   At this point in the transaction
    // lifecycle, success or failure is not yet known.
    //Y.on('io:complete', complete, Y, ['lorem', 'ipsum']);
    Y.on('io:complete', complete, Y, []);
    // Make an HTTP request to 'get.php'.
    // NOTE: This transaction does not use a configuration object.
    var request = Y.io(uri);
});

function deleteAdmin(AdminId){
	alert(AdminId);
}
</script>

<div id="adminDataTable" ></div>