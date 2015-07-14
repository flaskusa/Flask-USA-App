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
	 
	 function formatUnixToTime(tdate)
		{
			var date = new Date(tdate);
			// hours part from the timestamp
			var hours = date.getHours();
			// minutes part from the timestamp
			var minutes = "0" + date.getMinutes();

			var ampm = hours >= 12 ? 'PM' : 'AM';
			hours = hours % 12;
			// will display time in 10:30 PM format
			return hours + ':' + minutes.substr(-2) + ' ' + ampm;
		}
	 
	 var divRow = $('<table/>',{'class':'tableSize'});
	 for(var i in tdata)
		{
		    var st = formatUnixToTime(tdata[i].startTime);
		    var divRowItem = $('<div/>',{'title':tdata[i].eventName, 'class':'rowHeight'});
		 	var tempHTML = '<tr><td style="width:20%;"><div class="imgdiv"><img src="'+ tdata[i].eventImagePath + '" ></div><div class="lbldiv"><label class="control-label-color">' + tdata[i].eventName + '</label><label class="control-label-nocolor">'+ st + ' at ' + tdata[i].venueId + '</label></div></td></tr>';
		 	$(divRowItem).html(tempHTML);
		 	$(divRowItem).appendTo($(divRow));
		 	$(divRowItem).click(function(){
		 		$('#one').hide();
		 		$("#spinningSquaresG").show(); 
		 		wait(function()
		 		{
					$("#spinningSquaresG").hide();	
				 	$('#two').show();	
		 		},3);
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
	 /*var targetUrl = $(this).attr('#one');
	  window.history.pushState({url: "" + targetUrl + ""}, null, targetUrl);
	  window.onpopstate = function(e) {
		    window.history.go(e.state ? e.state.url : null);
		};*/
});

function fnRenderEvents(repositoryId,parentFolderId,folderName,eventName){
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
			function (data){
				folderId = data.responseJson.folderId;
				fnGetEventFolder(repositoryId,folderId,eventName);
			} ,
			function (data){
				folderId = 0;
			});
		return folderId;
}

function fnGetEventFolder(repositoryId,parentFolderId,folderName){
	var folderId;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
			function (data){
					folderId = data.responseJson.folderId;
					fnRenderSliders(repositoryId,folderId,"Pre-Event",2);
					fnRenderSliders(repositoryId,folderId,"During-Event",3);
					fnRenderSliders(repositoryId,folderId,"Post-Event",4);
			} ,
			function (data){
				folderId = 0;
			});
		
		return folderId;
}

function fnRenderSliders(repositoryId,parentFolderId,folderName,Count){
	var folderId = 0;
	var ws_images = "#ws_images"+Count;
	var wowslider_container = "#wowslider-container"+Count;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_FOLDERS, params, 
			function (data){
				folderId = data.responseJson.folderId;
				displayImages(repositoryId, folderId, ws_images, wowslider_container)
			} ,
			function (data){
				folderId = 0;
			});
		
		return folderId;
}

function displayImages(repositoryId, folderId, ws_images, wowslider_container)
{
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'folderId': folderId};
	flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.GET_ALL_IMAGES, params, 
		
    function(obj) {
	  obj = obj.responseJson;
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
			$(ws_images).html(temp_html);
			$(wowslider_container).wowSlider();
		
      }
      
 });
}

