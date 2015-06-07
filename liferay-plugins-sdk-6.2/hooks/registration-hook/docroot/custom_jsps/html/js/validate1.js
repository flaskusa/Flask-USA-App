
function fnSave() {
	console.log('insave');
	console.log(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT);
	var params = {
		firstName : $("#firstName").val(),
		middleName : $("#middleName").val(),
		lastName : $("#lastName").val(),
		isMale : true,
		screenName : $("#screenName").val(),
		email : $("#email").val(),
		// DOB: '05-10-2015',
		DOB : $("#DOB").val(),
		streetName : $("#streetName").val(),
		aptNo : $("#aptNo").val(),
		areaCode : $("#areaCode").val(),
		city : $("#city").val(),
		stateId : $("#stateId").val(),
		countryId : $("#countryId").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val(),
		mobileNumber : $("#mobileNumber").val(),
		userInterests : fnGetCheckBoxSelected()//fnGet
	};

	Liferay.Service(SERVICE_ENDPOINTS.ADD_FLASK_ADMIN_ENDPOINT, params,
		function(obj) {
			console.log(typeof obj);
			if(typeof obj =='object')
			{
				$("#spinningSquaresG").show();
				$.wait(function() {
					$("#spinningSquaresG").hide();
				}, 3);	
			}
			else
			{
			  console.log(obj);
			  return false;
			}
			console.log('end insave');			
	});
}



function fnUpdate(uid) {
	var params = {
		userId : $("#userId").val(),
		firstName : $("#firstName").val(),
		middleName : $("#middleName").val(),
		lastName : $("#lastName").val(),
		isMale : true,
		screenName : $("#screenName").val(),
		email : $("#email").val(),
		DOB : $('#DOB').jqxDateTimeInput('getDate'),
		streetName : $("#streetName").val(),
		aptNo : $("#aptNo").val(),
		areaCode : $("#areaCode").val(),
		city : $("#city").val(),
		stateId : $("#stateId").val(),
		countryId : $("#countryId").val(),
		password1 : $("#password1").val(),
		password2 : $("#password2").val(),
		mobileNumber : $("#mobileNumber").val(),
		userInterests : fnGetCheckBoxSelected()
	};

	Liferay.Service(SERVICE_ENDPOINTS.UPDATE_FLASK_ADMIN_ENDPOINT, params,
			function(obj) {
				console.log(obj);
				console.log(params);
				if(typeof obj =='object')
				{
					console.log('inUpdate');
					$("#spinningSquaresG").show();
					$.wait(function() {
						$("#spinningSquaresG").hide();
					}, 3);	
				}
				else
				{
				  console.log(obj);
				  return false;
				}
				console.log('end Update');			
		});	
}


$(document).ready(function () {
	$('.clsSave').on('click', function () {
    	if($('#adminForm').jqxValidator('validate'))
    	{
    		
    		console.log($("#userId").val());
    		if($("#userId").val()>0){
    			console.log("fnUpdate called");
    			fnUpdate($("#userId").val());
    		}
    		else{
    			console.log("fnSave called");
    			fnSave();
    			var myStateList = $("#stateId");
    			myStateList.empty();
    			myStateList.append($("<option></option>").val(0).html("-Select your region-"));
    		}
    		return false;
    	}	
    	else
    	{
    		console.log("test False");
    		return false;
    	}
	});
    // initialize validator.
    $('#adminForm').jqxValidator
    ({
        hintType: 'label',
        animationDuration: 0,
        rules: [
               { input: '#firstName', message: 'First name is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#lastName', message: 'Last name is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#mobileNumber', message: 'Mobile number is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#screenName', message: 'Screen name is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#areaCode', message: 'Zip code is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#password1', message: 'Password is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#password2', message: 'Password is required!', action: 'keyup, blur', rule: 'required' },
               {
                   input: '#password2', message: 'Passwords doesn\'t match!', action: 'keyup, focus', rule: function (input, commit) {
                       // call commit with false, when you are doing server validation and you want to display a validation error on this field. 
                       if (input.val() === $('#password1').val()) {
                           return true;
                       }
                       return false;
                   }
               },
               { input: '#email', message: 'E-mail is required!', action: 'keyup, blur', rule: 'required' },
               { input: '#email', message: 'Invalid e-mail!', action: 'keyup', rule: 'email' }]
    });
    $(".jqx-checkbox").css("margin-top","6.5px");
});

function fnGetCheckBoxSelected() {
	var Items = $(".userInterests").jqxTree('getItems');

	var ItemArray = new Array();
	$.each(Items, function() {
		if (this.checked) {
			var tempid = "#" + this.id;
			ItemArray.push($(tempid).attr("id"));
		};
	});
	
	console.log(ItemArray.join("#"));
	return ItemArray.join("#");
	//return '{}';
}

function fnSetCheckBoxSelected(strCheckList) {
	var tempArray = new Array();
	tempArray = strCheckList.split("#");
	var i;
	console.log("tempArray length = " + tempArray.length)
	for (i = 0; i < tempArray.length; i++) {
		var tempObj = "#" + tempArray[i];
		$(".userInterests").jqxTree('checkItem', $(tempObj)[0], true);
	}
	console.log("Working fine");
}

function fnFillCountryList() {
	var params = "";
	var request = new Request();
	var myDropDownList = $("#countryId");
	myDropDownList.append($("<option></option>").val(0).html("-Select your country-"));
	$.each(ALLOWED_COUNTRIES, function(index, value) {
		if(value==DEFAULT_COUNTRY){
			
		}
		request.sendGETRequest("/api/jsonws/flask-rest-users-portlet.flaskadmin/get-country-by-name/name/"+value,params, function(data) {
			if (data.responseStatus >=0) {
				var countryObj = data.responseJson;
				myDropDownList.append($("<option></option>").val(countryObj.countryId).html(countryObj.nameCurrentValue));
			} else {
				alert("MESSAGES.ERRORR_REGISTER_USER");
			}
		});
	  
	});	
}

function fnFillRegionList(countryId,defStateId) {
	var params = "";
	var request = new Request();
	request.sendGETRequest("/api/jsonws/flask-rest-users-portlet.flaskadmin/get-region/country-id/"+countryId, params, function(data) {
		if (data.responseStatus == 1) {
			var regionObj = data.responseJson;
			console.log(regionObj);
			var myStateList = $("#stateId");
			myStateList.empty();
			
			myStateList.append($("<option></option>").val(0).html("-Select your region-"));
			for (var i = 0; i < regionObj.length; i++) {
				myStateList.append($("<option></option>").val(regionObj[i].regionId).html(regionObj[i].name));
			}
			myStateList.val(defStateId);
		} else {
			alert("MESSAGES.ERRORR_REGISTER_USER");
		}
	});
}



$(document).ready(function () {
	$("#DOB").jqxDateTimeInput({ width: '250px', height: '25px', formatString: "MM-dd-yyyy" });
	$('.userInterests').jqxTree({ height: 'auto', hasThreeStates: true, checkboxes: true});	
    console.log("Cal Done");    
	$(".jqx-checkbox").css("margin-top","6.5px");
});

$(document).ready(function() {
	fnFillCountryList();
	$("#countryId").change(function() {
		
		fnFillRegionList($(this).val(),0);
		return false;
	});
	console.log($("#countryId").val());
	if($("#countryId").val()=="0")
		{
			fnFillRegionList(0,0);
		}
});
