var _adCustomerModel = {};

_adCustomerModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_ALL_CUSTOMER 			: "/flask-advertisement-portlet.adcustomer/get-all-customer",
	GET_CUSTOMER 				: "/flask-advertisement-portlet.adcustomer/get-customer",
	ADD_CUSTOMER 				: "/flask-advertisement-portlet.adcustomer/add-customer",
	UPDATE_CUSTOMER				: "/flask-advertisement-portlet.adcustomer/update-customer",
	DELETE_CUSTOMER				: "/flask-advertisement-portlet.adcustomer/delete-customer",
	DELETE_CUSTOMERS			: "/flask-advertisement-portlet.adcustomer/delete-customers",
};

_adCustomerModel.DATA_MODEL= {
	CUSTOMER: 
		[
             { name: 'customerId', type: 'long', fieldName : 'Customer Id' },
			 { name: 'customerName', type: 'string', fieldName : 'Customer Name' },
			 { name: 'businessType', type: 'string', fieldName : 'Business Type' },
			 { name: 'addrLine1', type: 'string', fieldName : 'Address Line 1' },
			 { name: 'addrLine2', type: 'string', fieldName : 'Address Line 2' },
			 { name: 'city', type: 'string', fieldName : 'City' },
			 { name: 'zipCode', type: 'string', fieldName : 'Zip code' },
			 { name: 'stateId', type: 'long', fieldName : 'State Id' },
			 { name: 'stateName', type: 'string', fieldName : 'State' },
			 { name: 'countryId', type: 'long', fieldName : 'CountryId' },
			 { name: 'countryName', type: 'string', fieldName : 'Country' },
			 { name: 'email', type: 'email', fieldName : 'Email' },
			 { name: 'websiteURL', type:'url', fieldName : 'Website URL' },
			 { name: 'businessPhoneNumber', type:'phonenumber', fieldName : 'Business Phone Number' },
			 { name: 'contactPersonName', type:'string', fieldName : 'Primary Contact Person' },
			 { name: 'contactPersonNumber', type:'phonenumber', fieldName : 'Primary Contact Person Number' },
		]
	};


_adCustomerModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Customer successfully added",
		SAVE: "Customer successfully saved",
		ERROR: "There was an error in saving customer",
		DEL_SUCCESS: "Customer successfully deleted",
		DEL_ERR: "Error in deleting customer",
 };