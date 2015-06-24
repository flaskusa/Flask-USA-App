var alllist = [];

function fnLoadList() {
 var params = "";
 var request = new Request();
 request.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_EVENTS, params,
   function(data) {
	 console.log(data);
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
     var datarecord = tdata[index];
     var Eventname = "<div style='margin: 10px;'><b>Event Name:</b> <input id='eventName' type='text' value="+ datarecord.eventName +"></input></div>";
     var Description = "<div style='margin: 10px;'><b>Description:</b> " + datarecord.description + "</div>";
     var Image = "<div style='margin: 10px;'><b>Image:</b> <img height='50' width='40'src=" + datarecord.eventImagePath + "</div>";
     $(leftcolumn).append(Eventname);
     $(leftcolumn).append(Description);
     $(leftcolumn).append(Image);
     $("#ContentPanel").html(container.html());
 }
 
 
 
    $('#listbox').on('click', function (event) {
    		$('#one').hide();
    		$('#two').show();
    		fnRenderEvents($("#repositoryId").val(),0,"Events");
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
    updatePanel(0);
    $('#listbox').jqxListBox('refresh');
}

$(document).ready(function(){
		$('#listbox').jqxListBox('refresh');
		fnLoadList();
		$(".cssback").click(function(){
			$('#one').show();
			$('#two').hide();
		});
});

function fnRenderEvents(repositoryId,parentFolderId,folderName){
	//var folderId = 0;
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest('/api/jsonws/dlapp/get-folder', params, 
			function (data){
				folderId = data.responseJson.folderId;
				var eventFolderName = renderSliders();
				fnGetEventFolder(repositoryId,folderId,eventFolderName);
			} ,
			function (data){
				folderId = 0;
				console.log("Error in getting Folder: " + data );
			});
		return folderId;
}

function fnGetEventFolder(repositoryId,parentFolderId,folderName){
	var folderId;
	//var eventType = [{"General":1,"PreEvent":2,"DuringEvent":3,"PostEvent":4}];
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		console.log(params);
		flaskRequest.sendGETRequest('/api/jsonws/dlapp/get-folder', params, 
			function (data){
					folderId = data.responseJson.folderId;
					fnRenderSliders(repositoryId,folderId,"Pre-Event",2);
					fnRenderSliders(repositoryId,folderId,"During-Event",3);
					fnRenderSliders(repositoryId,folderId,"Post-Event",4);
			} ,
			function (data){
				folderId = 0;
				console.log("Error in getting Folder: " + data );
			});
		return folderId;
}

function fnRenderSliders(repositoryId,parentFolderId,folderName,Count){
	var folderId = 0;
	var ws_images = "#ws_images"+Count;
	var wowslider_container = "#wowslider-container"+Count;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest('/api/jsonws/dlapp/get-folder' , params, 
			function (data){
				folderId = data.responseJson.folderId;
				console.log("fnRenderSliders: "+folderId);
				displayImages(repositoryId, folderId, ws_images, wowslider_container)
			} ,
			function (data){
				folderId = 0;
				console.log("Error in getting Folder:"+data);
			});
		return folderId;
}

function displayImages(repositoryId, folderId, ws_images, wowslider_container)
{
 var images;
 Liferay.Service('/dlapp/get-file-entries',{
      repositoryId: repositoryId,
      folderId: folderId
    },
    function(obj) {
      if(typeof obj=="object" && obj.length > 0){
			var temp_html;
			var imageUrl;
			var uploadedby;
			temp_html="<ul>";
			for(var i=0;i<obj.length;i++)
			{
				imageUrl = "/documents/"+repositoryId+"/"+folderId+"/"+obj[i].title;
				uploadedby = "uploaded by " + obj[i].userName;
				temp_html=temp_html+"<li><img src="+imageUrl+" alt='"+uploadedby+"' title='"+uploadedby+"' id='wows1_0'/></li>";
			}
			temp_html=temp_html+"</ul>";
			console.log(ws_images);
			console.log(wowslider_container);
			$(ws_images).html(temp_html);
			$(wowslider_container).wowSlider();
      }
      else{
    	  //$(wowslider_container).html("No images found");
      }
 });
}

function renderSliders(){
	var items = $("#listbox").jqxListBox('getItems');
	// get selected indexes.
	var selectedIndexes = $("#listbox").jqxListBox('selectedIndexes');
	var selectedItems = [];
	// get selected items.
	for (var index in selectedIndexes) {
	    if (selectedIndexes[index] != -1) {
	        selectedItems[index] = items[index];
	        return selectedItems[index].originalItem.eventName;
	    }
	}	
}