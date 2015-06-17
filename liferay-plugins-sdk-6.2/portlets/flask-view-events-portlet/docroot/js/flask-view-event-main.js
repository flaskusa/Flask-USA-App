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
    var updatePanel = function (index) {
        var container = $('<div style="margin: 5px;"></div>')
        var leftcolumn = $('<div style="float: left; width: 45%;"></div>');
        var rightcolumn = $('<div style="float: left; width: 40%;"></div>');
        container.append(leftcolumn);
        container.append(rightcolumn);
        var datarecord = tdata[index];
        var Eventname = "<div style='margin: 10px;'><b>Event Name:</b> " + datarecord.eventName + "</div>";
        var Description = "<div style='margin: 10px;'><b>Description:</b> " + datarecord.description + "</div>";
        var Image = "<div style='margin: 10px;'><b>Image:</b> <img height='50' width='40'src=" + datarecord.eventImagePath + "</div>";
        $(leftcolumn).append(Eventname);
        $(leftcolumn).append(Description);
        $(leftcolumn).append(Image);
        $("#ContentPanel").html(container.html());
    }
    $('#listbox').on('select', function (event) {
    		$('#one').hide();
    		$('#two').show();
    		
     updatePanel(event.args.index);
    });

    // Create jqxListBox
    $('#listbox').jqxListBox({   source: dataAdapter, displayMember: "Eventname", itemHeight: 70, height: '100%', width: '100%',
        renderer: function (index, label, value) {
            var datarecord = tdata[index];
            var imgurl = datarecord.eventImagePath;
            var img = '<img height="50" src="' + imgurl + '"/>';
            var table = '<table><tr><td style="width: 55px;" rowspan="2">' + img + '</td><td><label class="control-label-color">' + datarecord.eventName + '</label></td></tr><tr><td><label class="control-label-nocolor" >' + datarecord.description + '</label></td></tr></table>';
            return table;
        }
    });
    updatePanel();
}

$(document).ready(function() {
 
 fnLoadList();
});