/**
 * Google Map Integration and Add/Remove marker for creating Tailgate Information
 */
var tailgateId;
var map;
var tailgateMarker = {};
var isNewMarker = true;
var isMarkerCreated = false;
function initializeMap(tgId, latitude, longitude) {
	tailgateId = tgId;
	if(tgId>0){
		 var flaskRequest = new Request();
			params = {tailgateId:tgId};
			flaskRequest.sendGETRequest(_tailgateMarkerModel.SERVICE_ENDPOINTS.GET_TAILGATE_MARKER, params, 
			function(data){/*success handler*/
				latitude = data.latitude;
				longitude = data.longitude;
				if(GRID_PARAM.locationMapId == undefined){
					GRID_PARAM.locationMapId = "google_map";
				}
				loadMap(latitude, longitude,GRID_PARAM.locationMapId);
				isMarkerCreated = true;
			} , function(error){ /*failure handler*/
				_flaskLib.showErrorMessage('action-msg',_tailgateModel.MESSAGES.GET_ERROR);
			});
	}
	else{
			tailgateId = 0;
			if(latitude==0)
				latitude = 42.48114;
			if(longitude==0)
				longitude = -83.49441;
			if(GRID_PARAM.locationMapId == undefined){
				GRID_PARAM.locationMapId = "google_map";
			}
			loadMap(latitude, longitude,GRID_PARAM.locationMapId);
	}

	
}

function loadMap(latitude, longitude, elementId){
	 var mapCenter = new google.maps.LatLng(latitude, longitude); //Google map Coordinates
	//Google map option
     var googleMapOptions = 
     { 
         center: mapCenter, // map center
         zoom: 16, //zoom level, 0 = earth view to higher value
         panControl: true, //enable pan Control
         zoomControl: true, //enable zoom control
         scaleControl: true, // enable scale control
         mapTypeId: google.maps.MapTypeId.ROADMAP // google map type
     };
     map = new google.maps.Map(document.getElementById(elementId), googleMapOptions);
     map.setOptions({disableDoubleClickZoom: true });
     addMapEventListener(map);
}

function addMapEventListener(map){
//##### drop a new marker on right click ######
	// Load markers from tailgatemarker table
	isMarkerCreated = false;
    var flaskRequest = new Request();
	params = {tailgateId:tailgateId};
	flaskRequest.sendGETRequest(_tailgateMarkerModel.SERVICE_ENDPOINTS.GET_TAILGATE_MARKER, params, 
	function(data){/*success handler*/
		isNewMarker = false;
		tailgateMarker["name"] = data.name;
		tailgateMarker["descirption"] = data.description;
		tailgateMarker["latitude"] = data.latitude;
		tailgateMarker["longitude"] = data.longitude;
		tailgateMarker["tailgateId"] = data.tailgateid;
		tailgateMarker["tailgateMarkerId"] = data.tailgatemarkerid;
        var point = new google.maps.LatLng(parseFloat(data.latitude),parseFloat(data.longitude));
        
        //call create_marker() function for xml loaded maker
        create_marker(point, tailgateMarker.name, tailgateMarker.descirption, false, false, false, "/flask-user-tailgate-portlet/img/new-blue-pin.png");
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_tailgateModel.MESSAGES.GET_ERROR);
	});
    //drop a new marker on right click
    google.maps.event.addListener(map, 'dblclick', function(event) {
    	if(!isMarkerCreated){
        //Edit form to be displayed with new marker
    	isMarkerCreated = true;
    	isNewMarker = true;
        var EditForm = '<p><div class="marker-edit">'+
        '<label for="pName"><span>Place Name : </span><input type="text" name="pName" id="pName" class="save-name" placeholder="Enter Title" maxlength="40" /></label>'+
        '<label for="pDesc"><span>Description : </span><textarea name="pDesc" id="pDesc" class="save-desc" placeholder="Enter Address" maxlength="150" style="height:60px; width:240px;"></textarea></label>'+
        '</div></p><button name="save-marker" id="save-marker" class="save-marker">Add</button>';
        //call create_marker() function
        create_marker(event.latLng, 'Tailgate Marker', EditForm, true, true, true, "/flask-user-tailgate-portlet/img/new-red-pin.png");
    	}else{
    		alert("Marker is already created for the tailgate");
    	}
    });
}

//############### Create Marker Function ##############
function create_marker(MapPos, MapTitle, MapDesc,  InfoOpenDefault, DragAble, Removable, iconPath)
{    console.log(MapPos);
    //new marker
    var marker = new google.maps.Marker({
        position: MapPos,
        map: map,
        draggable:DragAble,
        animation: google.maps.Animation.DROP,
        title: MapTitle,
        icon: iconPath
    });
    
    //Content structure of info Window for the Markers
    var contentString = $('<div class="marker-info-win">'+
    '<div class="marker-inner-win"><span class="info-content">'+
    '<h5 class="marker-heading">'+MapTitle+'</h5>'+
    MapDesc+ 
    '</span><button name="remove-marker" class="remove-marker" style="margin-left:10px;" title="Remove Marker">Remove</button>'+
    '</div></div>');    

    
    //Create an infoWindow
    var infowindow = new google.maps.InfoWindow();
    //set the content of infoWindow
    infowindow.setContent(contentString[0]);

    //Find remove button in infoWindow
    var removeBtn   = contentString.find('button.remove-marker')[0];

   //Find save button in infoWindow
    var saveBtn     = contentString.find('button.save-marker')[0];

    //add click listner to remove marker button
    google.maps.event.addDomListener(removeBtn, "click", function(event) {
        //call remove_marker function to remove the marker from the map
        remove_marker(marker);
    });
    
    if(typeof saveBtn !== 'undefined') //continue only when save button is present
    {
        //add click listner to save marker button
        google.maps.event.addDomListener(saveBtn, "click", function(event) {
            var mReplace = contentString.find('span.info-content'); //html to be replaced after success
            var mName = contentString.find('input.save-name')[0].value; //name input field value
            var mDesc  = contentString.find('textarea.save-desc')[0].value; //description input field value
            var mLatLang = marker.getPosition().toUrlValue(); //get marker position
            var lat = mLatLang.split(",")[0];
            var lng = mLatLang.split(",")[1];
            if(mName =='')
            {
                alert("Please enter Name!");
            }else{
                //call save_marker function and save the marker details
                save_marker(marker, mName, mDesc, lat, lng, mReplace);
            }
        });
    }
    
    //add click listner to save marker button        
    google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map,marker); // click on marker opens info window 
    });
      
    if(InfoOpenDefault) //whether info window should be open by default
    {
      infowindow.open(map,marker);
    }
}

//############### Remove Marker Function ##############
function remove_marker(Marker)
{
    /* determine whether marker is draggable 
    new markers are draggable and saved markers are fixed */
	
	isMarkerCreated = false;
    if(Marker.getDraggable()) 
    {
        Marker.setMap(null); //just remove new marker
    }else if(tailgateMarker.tailgateId == 0){
    	Marker.setMap(null); //just remove created but not saved marker
    }
    else
    {
        //Remove saved marker from DB and map using jQuery Ajax
        var mLatLang = Marker.getPosition().toUrlValue(); //get marker position
        var flaskRequest = new Request();
    	params = {tailgateId:tailgateMarker.tailgateId};
    	flaskRequest.sendGETRequest(_tailgateMarkerModel.SERVICE_ENDPOINTS.REMOVE_TAILGATE_MARKER, params, 
    	function(data){/*success handler*/
    		Marker.setMap(null);
    	} , function(error){ /*failure handler*/
    		_flaskLib.showErrorMessage('action-msg',_tailgateModel.MESSAGES.GET_ERROR);
    	});
    }
}

//############### Save Marker Function ##############
function save_marker(Marker, mName, mAddress, lat,lang, replaceWin)
{
    //Save new marker using jQuery Ajax
	var mLatLang = Marker.getPosition().toUrlValue(); //get marker position
	tailgateMarker["name"] = mName;
	tailgateMarker["description"] = mAddress;
	tailgateMarker["latitude"] = lat;
	tailgateMarker["longitude"] = lang;
	tailgateMarker["tailgateId"] = 0;
	var markerDesc = "<textarea style='border:none;width:240px;height:60px;background-color:white;margin:0px;' wrap='hard' readonly='true'>"
					+ mAddress + "</textarea><br>";
	var point = new google.maps.LatLng(parseFloat(lat),parseFloat(lang));
	create_marker(point, mName, markerDesc, false, false, false, "/flask-user-tailgate-portlet/img/new-blue-pin.png");
	Marker.setDraggable(true);
	remove_marker(Marker);
//	replaceWin.html(data); //replace info window with new html
//    Marker.setDraggable(false); //set marker to fixed
//    Marker.setIcon('/flask-user-tailgate-portlet/img/new-blue-pin.png'); //replace icon
}

function saveTailgateMarker(tailgateId){
		tailgateMarker["tailgateId"] = tailgateId;
		if(isNewMarker && tailgateMarker.latitude && tailgateMarker.longitude){
			var params = {name : tailgateMarker.name, description : tailgateMarker.description, latitude : tailgateMarker.latitude,
					longitude : tailgateMarker.longitude, tailgateId: tailgateMarker.tailgateId }; //post variables
		    var flaskRequest = new Request();
			flaskRequest.sendPOSTRequest(_tailgateMarkerModel.SERVICE_ENDPOINTS.ADD_TAILGATE_MARKER, params, 
			function(data){/*success handler*/
			} , function(error){ /*failure handler*/
				_flaskLib.showErrorMessage('action-msg',_tailgateModel.MESSAGES.GET_ERROR);
			});
		}
}
