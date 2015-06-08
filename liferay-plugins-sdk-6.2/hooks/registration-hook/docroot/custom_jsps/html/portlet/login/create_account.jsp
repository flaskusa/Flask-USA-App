
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/html/portlet/login/init.jsp" %>
<script type="text/javascript" src="/html/js/Flask-lib.js"></script>
<script type="text/javascript" src="/html/js/jqx-all.js"></script>
<script type="text/javascript">
var GlobalJSON_Admin = [];

function fnDelete(AdminId) {
	Liferay.Service('/flask-rest-users-portlet.flaskadmin/delete-flask-admins',
			{
				userId : AdminId
			}, function(obj) {
				closeEvent.cancel = true
			});
}

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
	console.log("fnUpdate called");
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
	console.log(params);
	Liferay.Service(SERVICE_ENDPOINTS.UPDATE_USER_ENDPOINT, params,
			function(obj) {
				console.log(obj);
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

function fnShowForm(userId) {
		Liferay.Service('/flask-rest-users-portlet.flaskadmin/get-user-by-id',{userId: userId},
		  function(obj) {
			    if(typeof obj =='object')
				{
					$("#userId").val(obj.userId);
					$("#firstName").val(obj.firstName);
					$("#middleName").val(obj.middleName);
					$("#lastName").val(obj.lastName);
					$("#email").val(obj.email);
					$("#screenName").val(obj.screenName);
					$("#password1").val("");//GlobalJSON_Admin[rowIndex].password1
					$("#password2").val("");//objUser.password2
					$("#city").val(obj.city);
					$("#mobileNumber").val(obj.mobileNumber);
					$("#countryId").val(obj.countryId);
					fnFillRegionList(obj.countryId,obj.stateId);
					var date = new Date(parseInt(obj.DOB))
					$('#DOB').jqxDateTimeInput('setDate', date);
					$("#streetName").val(obj.streetName);
					$("#aptNo").val(obj.aptNo);
					$("#areaCode").val(obj.areaCode);
					fnSetCheckBoxSelected(obj.userInterests);
					$("#adminForm").show();						
				}
				else
				{
				  console.log(obj);
				  return false;
				}		    
		  });				
}

function fnPasswordReset() {
	alert("fnPasswordReset");
}

$(document).ready(function () {
    $('.cssSave').on('click', function () {
    	if($('#adminForm').jqxValidator('validate'))
    	{
    		console.log($("#userId").val());
    		if(parseInt($("#userId").val())>0){
    			fnUpdate();
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

$.wait = function(callback, seconds) {
	console.log("start>>" + callback);
	return window.setTimeout(callback, seconds * 1000);
	console.log("finish>>" + callback);
}

function fnGetCheckBoxSelected() {
	var ItemArray = new Array();
	$(".userInterests").each(function(){
		var Items = $(this).jqxTree('getItems');
		$.each(Items, function() {
			if (this.checked) {
				var tempid = "#" + this.id;
				ItemArray.push($(tempid).attr("id"));
			};
		});
	});
	console.log(ItemArray.join("#"));
	return ItemArray.join("#");
}

function fnSetCheckBoxSelected(strCheckList) {
	var tempArray = new Array();
	tempArray = strCheckList.split("#");
	var i;
	for (i = 0; i < tempArray.length; i++) {
		var tempObj = "#" + tempArray[i];
		$(".userInterests").jqxTree('checkItem', $(tempObj)[0], true);
	}
}

function fnFillCountryList() {
	var params = "";
	var request = new Request();
	var myDropDownList = $("#countryId");
	myDropDownList.append($("<option></option>").val(0).html("-Select your country-"));
	$.each(ALLOWED_COUNTRIES, function(index, value) {
		if(value==DEFAULT_COUNTRY){
			
		}
		request.sendGETRequest("/api/jsonws/country/get-country-by-name/name/"+value,params, function(data) {
			if (data.responseStatus == 1) {
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
	request.sendGETRequest("/api/jsonws/region/get-regions/country-id/"+countryId, params, function(data) {
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

		$("#DOB").jqxDateTimeInput({ width: '250px', height: '25px', formatString: "MM-dd-yyyy" });
		$('.userInterests').jqxTree({ height: 'auto', hasThreeStates: true, checkboxes: true});	
	    console.log("Cal Done");    
		$(".jqx-checkbox").css("margin-top","6.5px");
		$.wait(function(){
			$(".icon-folder-open").hide();
		},1);
		
		if(parseInt($("#hdnUserId").val()) > 0)	{
			fnShowForm(parseInt($("#hdnUserId").val()));
		}		
});


</script>
<form id="adminForm">
  <div class="">
  <div class="">
   <div class="form-group">
     <label class="control-label" for="firstName">First Name:</label>
     <div class="controls">
       <input name="firstName" id="firstName" class="form-control" type="text">
     </div>
   </div>
   <div class="form-group">
     <label class="control-label" for="lastName">Last Name:</label>
     <div class="controls">
       <input name="lastName" id="lastName" class="form-control" type="text">
     </div>
   </div>
   
     <div class="">
   <div class="form-group">
     <label class="control-label" for="screenName">Screen Name:</label>
     <div class="controls">
       <input name="screenName" id="screenName" class="form-control" type="text">
     </div>
   </div>
 
   <div class="form-group">
     <label class="control-label" for="email">E-mail:</label>
     <div class="controls">
       <input name="email" id="email" class="form-control" type="text">
     </div>
   </div>
 
   <div class="form-group">
     <label class="control-label" for="password1">Password:</label>
     <div class="controls">
       <input name="password1" id="password1" class="form-control" type="password">
     </div>
   </div>
   
   <div class="form-group">
     <label class="control-label" for="password2">Confirm Password:</label>
     <div class="controls">
       <input name="password2" id="password2" class="form-control" type="password">
     </div>
   </div> 
   
  <div class="">
   <div class="form-group">
     <label class="control-label" for="streetName">Street:</label>
     <div class="controls">
       <input name="streetName" id="streetName" class="form-control" type="text">
     </div>
   </div>
   
   <div class="form-group">
     <label class="control-label" for="aptNo">Apartment#:</label>
     <div class="controls">
       <input name="aptNo" id="aptNo" class="form-control" type="text">
     </div>
   </div>  
   
    <div class="form-group">
     <label class="control-label" for="areaCode">Area Code:</label>
     <div class="controls">
       <input name="areaCode" id="areaCode" class="form-control" type="text">
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
  </div>
   <div class="form-group">
      <label class="control-label" for="gender">Gender:</label>
      <div class="controls">
        <input name="gender" type="radio" value="Male" checked>Male
     <input name="gender" type="radio" value="Female">Female
      </div>
  </div>
   
   <div class="form-group">
  <label class="control-label" for="DOB">Date of Birth:</label>
  <div class="controls">
   <div id="DOB"></div>
  </div>
   </div>  
  </div>
   
   <div class="form-group">
     <label class="control-label" for="mobileNumber">Mobile:</label>
     <div class="controls">
       <input name="mobileNumber" id="mobileNumber" class="form-control" type="text">
     </div>
   </div>    
  </div>
</div>
<div class="form-group">
    
 <div class="row-fluid">
 <h4><span>Preferences</span></h4>
 <div class="row-fluid">
 <div style="border: none;" class="userInterests span4">
  <ul>
         <li item-expanded='true' id="sports">Sports
           <ul>
           		   <li id="sports-pro-basketball">Basketball</li>
                   <li id="sports-pro-basebball">Basebball</li>
                   <li id="sports-pro-football">Football</li>
                   <li id="sports-pro-hockey">Hockey</li>
                   <li id="sports-pro-soccer">Soccer</li>
                   <li id="sports-pro-tennis">Tennis</li>
          </ul>
   </li>
  </ul>
 </div>
 <div style="border: none;" class="userInterests span4">
  <ul>
         <li item-expanded='true' id="sports">Level
           <ul>
                 <li id="sports-pro">Professional</li>
                 <li id="sports-col">College</li>
           </ul>
   </li>
  </ul>
 </div>
 </div>
 <div class="row-fluid">
 <div style="border: none;" class="userInterests span4">
  <ul>   
         <li item-expanded='true' id="concerts">Concerts
             <ul>
                 <li  id="concerts-country">Country</li>
                 <li id="concerts-pop">Pop</li>
                 <li id="concerts-rock">Rock</li>
                 <li id="concerts-rap">Rap</li>
                 <li id="concerts-alternative">Alternative</li>
                 <li id="concerts-electronic">Electronic</li>
             </ul>
         </li>
  </ul>
 </div>
 <div style="border: none;" class="userInterests span4">   
  <ul>         
         <li item-expanded='true' id="special-events">
          Special Events
          <ul><li id="special-events-comedy">Comedy</li></ul>
         </li>
     </ul>   
 </div> 
 </div>
 </div>
</div>
 
  <input class="btn btn-info cssSave" type="button" value="Save"/>
  <input class="btn btn-primary cssCancel" type="button" value="Cancel" >
  <input id="userId" type="hidden" value="0">
  <input name="middleName" id="middleName" type="hidden">
</form>

