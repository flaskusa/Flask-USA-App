var alllist = [];

function fnLoadList() {
 var params = "";
 var request = new Request();
 request.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_EVENTS, params,
   function(data) {
    if (data.responseStatus == 1) {
     alllist = data.responseJson;
     fnlist(alllist);
    } else {
     alert("MESSAGES.ERRORR_REGISTER_USER");
    }
   });
}

function fnlist(tdata) {
	
 var source = {
  localdata : tdata,
  datatype : "json",
  datafields : DATA_SOURCE.GET_FLASK_EVENT_LIST,

 };
 var dataAdapter = new $.jqx.dataAdapter(source);

    $('#listbox').on('click', function (event) {
    	
    		$('#one').hide();
    		$('#two').show();

    });

    // Create jqxListBox
    $('#listbox').jqxListBox({ source: dataAdapter, displayMember: "Eventname", itemHeight: 70, scrollBarSize: 0, height: '100%', width: '100%', 
        renderer: function (index, label, value) {
            var datarecord = tdata[index];
            var imgurl = datarecord.eventImagePath;
            var img = '<img height="50" src="' + imgurl + '"/>';
            var table = '<table><tr><td style="width: 55px;" rowspan="2">' + img + '</td><td><label class="control-label-color">' + datarecord.eventName + '</label></td></tr><tr><td><label class="control-label-nocolor" >' + datarecord.description + '</label></td></tr></table>';
            return table;
        }
    });
    $('#listbox').jqxListBox('refresh');
}

$(document).ready(function() 
		
{
	$('#listbox').jqxListBox('refresh');
		fnLoadList();
		 $(".cssback").click(function(){
			 
			$('#one').show();
			$('#two').hide();
		});
});