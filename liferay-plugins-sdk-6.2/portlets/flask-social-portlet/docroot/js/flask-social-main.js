function initContactList(){
	var theme = "base";
    var data = new Array();
    var firstNames = ["Nancy", "Andrew", "Janet", "Margaret", "Steven", "Michael", "Robert", "Laura", "Anne"];
    var lastNames = ["Davolio", "Fuller", "Leverling", "Peacock", "Buchanan", "Suyama", "King", "Callahan", "Dodsworth"];
    var titles = ["Sales Representative", "Vice President, Sales", "Sales Representative", "Sales Representative", "Sales Manager", "Sales Representative", "Sales Representative", "Inside Sales Coordinator", "Sales Representative"];
    var k = 0;
    for (var i = 0; i < firstNames.length; i++) {
        var row = {};
        row["firstname"] = firstNames[k];
        row["lastname"] = lastNames[k];
        row["title"] = titles[k];
        data[i] = row;
        k++;
    }
    var source =
    {
        localdata: data,
        datatype: "array"
    };
    var dataAdapter = new $.jqx.dataAdapter(source);
    // Create jqxListBox
    $('#listbox').jqxListBox({
        selectedIndex: 0, theme: theme, source: dataAdapter, displayMember: "firstname", valueMember: "notes", itemHeight: 70, height: '100%', width: '100%',
        renderer: function (index, label, value) {
            var datarecord = data[index];
            var imgURL = "/webdav/flask/document_library/DefaultProfilePic";//_flaskLib.UTILITY.DEFAULT_PROFILE_PIC;
            var img = '<img height="50" src="' + imgURL + '"/>';
            var table = '<table><tr><td style="width: 55px;" rowspan="2">' + img + '</td><td>' + datarecord.firstname + " " + datarecord.lastname + '</td></tr><tr><td>' + datarecord.title + '</td></tr></table>';
            return table;
        }
    });
    //initSimulator("listbox");
}