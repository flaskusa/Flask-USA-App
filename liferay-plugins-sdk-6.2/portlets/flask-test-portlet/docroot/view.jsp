
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />



<script>

var bCreated;

Liferay.Portlet.ready( initializeGrid);


function initializeGrid(portletId, portlet){
	
	console.log('initialize');
	
	if(portletId != null && portletId.indexOf('flask') >= 0) //this is a hack need better solution
		getData();
}

function createTable(jsonData){
	
	console.log('create table');
	if(bCreated == true)
		return;
	
	bCreated =true;
	
	YUI().use('datatable', function (Y) {
		// Columns must match data object property names
		var table = new Y.DataTable({
		    columns: [{key: "firstName", label: "First Name", sortable: true },
		              {key: "middleName", label: "Middle Name", sortable: true  },
		              {key: "lastName", label: "Last Name", sortable: true  },
		              {key: "email", label: "Email", sortable: true  },
		              {key: "screenName", label: "Screen Name", sortable: true  },
		              {key: "userId", label: "Action", sortable: false, allowHTML: true }
		              ],
		    data: jsonData
		});
		table.render("#adminDataTable");
		setTimeout(getData, 30000);
	})
}

function getData(){
	var adminDataUrl= '/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins';
	var jqxhr = $.ajax( {
		  url: adminDataUrl,
		  method: "GET",
		  dataType: "json",
		  cache : false
		} )
	  .done(function(data) {
		  if(bCreated){
			  updateTable();
		  }else{
			  createTable(data);
		  }
	  })
	  .fail(function(jqXHR, textStatus ) {
	   	console.log('Data request failed' + textStatus);
	    //TODO add logic for error display
	  })
}

function updateTable(){
	
}

</script>


<div id="adminDataTable" ></div>
