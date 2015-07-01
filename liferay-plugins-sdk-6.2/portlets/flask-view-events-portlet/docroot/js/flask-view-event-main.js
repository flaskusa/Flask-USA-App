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
	 var divRow = $('<table/>',{'class':'tableSize'});
	 for(var i in tdata)
		{
		    var divRowItem = $('<div/>',{'title':tdata[i].eventName});
		 	var tempHTML = '<tr><td style="width:20%;"><div class="imgdiv"><img src="'+ tdata[i].eventImagePath + '" ></div><div class="lbldiv"><label class="control-label-color">' + tdata[i].eventName + '</label><label class="control-label-nocolor">' + tdata[i].description + '</label></div></td></tr>';
		 	$(divRowItem).html(tempHTML);
		 	$(divRowItem).appendTo($(divRow));
		 	$(divRowItem).click(function(){
		 		 $('#one').hide();
		 		 $('#two').show();	
		 		 
		 		fnRenderEvents($("#repositoryId").val(),0,'Events',$(this).attr('title'));	 		
		 	});
	    }
	 	$(divRow).appendTo($("#placeholder"));
}

$(document).ready(function(){
	
	fnLoadList();
	$(".cssback").click(function(){
		$('#one').show();
		$('#two').hide();
	});
	 var targetUrl = $(this).attr('#one');
	  window.history.pushState({url: "" + targetUrl + ""}, null, targetUrl);
	  window.onpopstate = function(e) {
		    window.history.go(e.state ? e.state.url : null);
		};
});

function fnRenderEvents(repositoryId,parentFolderId,folderName,eventName){
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest('/api/jsonws/dlapp/get-folder', params, 
			function (data){
				folderId = data.responseJson.folderId;
				fnGetEventFolder(repositoryId,folderId,eventName);
			} ,
			function (data){
				folderId = 0;
				console.log("Error in getting Folder: " + data );
			});
		return folderId;
}

function fnGetEventFolder(repositoryId,parentFolderId,folderName){
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		console.log(params);
		flaskRequest.sendGETRequest('/api/jsonws/dlapp/get-folder', params, 
			function (data){
					folderId = data.responseJson.folderId;
					console.log(folderId);
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
    	
      if(typeof obj=="object" && obj.length > 0)
      {
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
      else
      {
    	  var temp_html;
			var imageUrl;
			var uploadedby;
			temp_html="<ul>";
				imageUrl = "/flask-view-events-portlet/img/NoData.png";
				uploadedby = "No data";
				temp_html=temp_html+"<li><img src='"+imageUrl+"' alt='"+uploadedby+"' title='"+uploadedby+"' id='wows1_0'/></li>";
			temp_html=temp_html+"</ul>";
			console.log(ws_images);
			console.log(wowslider_container);
			$(ws_images).html(temp_html);
			$(wowslider_container).wowSlider();
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