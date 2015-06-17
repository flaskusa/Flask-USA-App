$(document).ready(function(){
	var GlobalJSON_event;
	var params = "";
	var request = new Request();
	var data1;

	$.getJSON("/api/jsonws/flask-rest-events-portlet.event/get-all-events", function(json) {
	    $('#listbox').jqxListBox({
            selectedIndex: 0, theme: "custom", source: json, displayMember: "firstname", valueMember: "notes", itemHeight: 70, height: '100%', width: '100%',
            renderer: function (index, label, value) {
                var datarecord = json[index];
                var imgurl = datarecord.eventImagePath;
                var img = '<img height="50" src="' + imgurl + '"/>';
                var table = '<table><tr><td style="width: 55px;" rowspan="2">' + img + '</td><td>' + datarecord.eventName + '</td></tr><tr><td>' + datarecord.description + '</td></tr></table>';
                return table;
            }
        });	    
	});	
});