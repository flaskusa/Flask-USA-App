var adCustomerForm;
var customerId = "0";
function adCustomerClickHandlers(){
	adCustomerForm = $("#addCustomerForm");
	/*	Initialize display elements*/
	
	$("#delCustomerTrash").hide();	
	
	/* Click handler for add user button*/
	
	$("#addCustomer").click(function(){

		$("#customerId").val(0);
		adCustomerForm.trigger('reset')
		$("#customersDataTable").hide();
		adCustomerForm.show();
		$("#addCustomerFormContainer").show();
		_flaskLib.loadCountries('countryId');
		_flaskLib.loadUSARegions('stateId');
	});

	/* Click handler for save button*/
	
	$("#customerSave").click(function(){

		if($('#addCustomerForm').jqxValidator('validate')){
			saveAdCustomer();
		}else{
			_flaskLib.showErrorMessage('customer-action-msg', 'Validation failed');
		}
	});


	/* Click handler for cancel button*/

	$("#customerCancel").click(function(){
		$("#customersDataTable").show();
		$("#addCustomerFormContainer").hide();
	});
	
	$("#delCustomerList").click(function() {
		GRID_PARAM_CUSTOMER.toggleSelectionMode();
		var flag1=true;
		 if (flag1==true) {
			 $("#delCustomerTrash").show();	
			 $("#delCustomerList").hide();	
		}
		else{
			 $("#delCustomerTrash").hide();	
			 $("#delCustomerList").show();	
		}
    });
	
	$("#delCustomerListTrash").click(function () {
		var customerList = GRID_PARAM_CUSTOMER.getCheckedIdList('customerId');
		if(customerList.length > 0){
			deleteMultipleCustomers(customerList) ;	
		}
		 $("#delCustomerTrash").hide();	
		 $("#delCustomerList").show();	
		 GRID_PARAM_CUSTOMER.toggleSelectionMode();
    });
	
	addValidators();

	/*	Toggle search boxes */
	$("#searchCustomer").click(GRID_PARAM_CUSTOMER.toggleSearchBoxes);			
	
}

function addValidators(){
	$('#addCustomerForm').jqxValidator
    ({
        hintType: 'label',
        animationDuration: 0,
        rules: [
	               { input: '#customerName', message: 'Customer name is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#businessType', message: 'Business type is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#addrLine1', message: 'Address is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#city', message: 'City is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#zipCode', message: 'Zipcode is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#businessPhoneNumber', message: 'Business phone is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#email', message: 'Please enter valid email', action: 'keyup, blur', rule: 'email' }
	           ]
    });
}

function loadCustomerData(){
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_adCustomerModel.SERVICE_ENDPOINTS.GET_ALL_CUSTOMER, params, 
	function(data){/*success handler*/
		GRID_PARAM_CUSTOMER.updateGrid(data);
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage(_adCustomerModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function customerContextMenuHandler(menuItemText, rowData){
	customerId = rowData.customerId;
	var args = event.args;
	if (menuItemText  == "Edit") {
		editCustomer(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteCustomer(rowData.customerId);
		}
		return false;			
	}
};

function deleteCustomer(customerId) {
	var param = {'customerId': customerId};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_adCustomerModel.SERVICE_ENDPOINTS.DELETE_CUSTOMER, param, 
					function (data){
							_flaskLib.showSuccessMessage('customer-action-msg', _adCustomerModel.MESSAGES.DEL_SUCCESS);
							loadCustomerData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('customer-action-msg', _adCustomerModel.MESSAGES.DEL_ERR);
					});
	
}

function deleteMultipleCustomers(customerList) {
	var param = {customerList: customerList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_adCustomerModel.SERVICE_ENDPOINTS.DELETE_CUSTOMERS, param, 
					function (data){
							_flaskLib.showSuccessMessage('customer-action-msg', _adCustomerModel.MESSAGES.DEL_SUCCESS);
							loadCustomerData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('customer-action-msg', _adCustomerModel.MESSAGES.DEL_ERR);
					});
	
}

function editCustomer(rowData) {

	adCustomerForm.trigger('reset')
	_flaskLib.loadDataToForm("addCustomerForm",  _adCustomerModel.DATA_MODEL.CUSTOMER, rowData, function(){
		
	});
	$("#customersDataTable").hide();
	adCustomerForm.show();
	$("#addCustomerFormContainer").show();
	_flaskLib.loadCountries('countryId',rowData.countryId);
	_flaskLib.loadUSARegions('stateId',rowData.stateId);
}

function saveAdCustomer(){
	var params = _flaskLib.getFormData('addCustomerForm',_adCustomerModel.DATA_MODEL.CUSTOMER,
				function(formId, model, formData){
						return formData;
				});
	var flaskRequest = new Request();
	var url = ""
		params.customerId = customerId;
		if(params.customerId == "0"){
			url = _adCustomerModel.SERVICE_ENDPOINTS.ADD_CUSTOMER;
		}else{
			url =_adCustomerModel.SERVICE_ENDPOINTS.UPDATE_CUSTOMER;
		}
	flaskRequest.sendPOSTRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('customer-action-msg', _adCustomerModel.MESSAGES.SAVE);
					$("#customersDataTable").show();
					$("#addCustomerFormContainer").hide();
					loadCustomerData();
				} ,
				function (data){
					_flaskLib.showErrorMessage('customer-action-msg', _adCustomerModel.MESSAGES.ERROR);
				});

}
