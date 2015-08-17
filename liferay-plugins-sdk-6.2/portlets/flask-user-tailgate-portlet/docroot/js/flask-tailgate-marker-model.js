/**
 * 
 */
var _tailgateMarkerModel = {};
var events = [];

_tailgateMarkerModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_TAILGATE_MARKER			:"/flask-user-tailgate-portlet.tailgatemarker/get-tailgate-marker",
	REMOVE_TAILGATE_MARKER		:"/flask-user-tailgate-portlet.tailgatemarker/delete-tailgate-marker",
	ADD_TAILGATE_MARKER			:"/flask-user-tailgate-portlet.tailgatemarker/add-tailgate-marker",
};

_tailgateMarkerModel.DATA_MODEL= {
	TAILGATE: 
		[
		 	 { name: 'tailgatemmarkerid', type: 'long' },
		 	 { name: 'tailgateid', type: 'long' },
		 	 { name: 'description', type: 'string' },
		 	 { name: 'name', type: 'long' },
		 	 { name: 'latitude', type:'string'},
		 	 { name: 'longitude', type: 'string' },
		]
	};
