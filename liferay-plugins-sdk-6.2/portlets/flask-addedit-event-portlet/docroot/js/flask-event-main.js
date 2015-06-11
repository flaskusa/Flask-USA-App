
$(document).ready(function() {
	$("#eventDate").jqxDateTimeInput({width: '260px', height: '35px',formatString: "MM-dd-yyyy" });
	$("#Active").jqxCheckBox({ width: 120, height: 25 });
	//create jqxtabs.
	$('#jqxtabs').jqxTabs({width: '100%',height: 250});
	$("#startTime").jqxDateTimeInput({ formatString: 'hh:mm tt', showCalendarButton: false});
	$("#endTime").jqxDateTimeInput({ formatString: 'hh:mm tt', showCalendarButton: false});
	$('#jqxtabs').bind('selected', function (event) {
	    var item = event.args.item;
	    var title = $('#jqxtabs').jqxTabs('getTitleAt', item);
	});
	
	fnFillCountryList();
	
	 $(".flipster").flipster({
		   enableNav: true
	 });
});

function fnFillCountryList() {
	var params = "";
	var request = new Request();
	var myDropDownList = $("#venueCountryId");
	myDropDownList.append($("<option></option>").val(0).html("-Select your venue-"));
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