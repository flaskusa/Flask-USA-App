var _adminModel = {};

_adminModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_ADMIN 					: "/flask-rest-users-portlet.flaskadmin/get-flask-admins",
	GET_ROLES 					: "/flask-rest-users-portlet.flaskrole/get-flask-roles",
	ADD_ADMIN 					: "/flask-rest-users-portlet.flaskadmin/add-flask-admin",
	UPDATE_ADMIN				: "/flask-rest-users-portlet.flaskadmin/update-flask-admin",
	DELETE_ADMIN				: "/flask-rest-users-portlet.flaskadmin/delete-flask-admins",

	TERMS_AND_CONDITION         : "http://www.rumbasolutions.com", 
	SERVICE_TIMEOUT 			: 30000	
};

_adminModel.DATA_MODEL= {
	ADMIN: 
		[
         { name: 'userId', type: 'string' },
		 { name: 'firstName', type: 'string' },
		 { name: 'middleName', type: 'string' },
		 { name: 'lastName', type: 'string' },
		 { name: 'email', type: 'string' },
		 { name: 'mobileNumber', type: 'string' },
		 { name: 'screenName', type: 'string' },
		 { name: 'password1', type: 'string' },
		 { name: 'password2', type: 'string' },
		 { name: 'DOB', type: 'date' },
		 { name: 'roleId', type: 'long' },
		 { name: 'roleName', type: 'string' },
		 { name: 'streetName', type: 'string' },
		 { name: 'aptNo', type: 'string' },
		 { name: 'areaCode', type: 'string' },
		 { name: 'city', type: 'string' },
		 { name: 'stateId', type: 'string' },
		 { name: 'stateName', type: 'string' },
		 { name: 'countryId', type: 'string' },
		 { name: 'countryName', type: 'string' },
		 { name: 'userInterests', type: 'string' }
		]
	};


_adminModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Admin successfully added",
		SAVE: "Admin successfully saved",
		ERROR: "There was an error in saving Admin",
		DEL_SUCCESS: "Admin successfully deleted",
		DEL_ERR: "Error in deleting Admin",
 };