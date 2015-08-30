var geocoder;
var map;
var markers = Array();
var infos = Array();
var cur_location;
function initializeMap() {
	try{
	    geocoder = new google.maps.Geocoder();
	    var myLatlng = new google.maps.LatLng(latitude,longitude);
	    var myOptions = {
	        zoom: 16,
	        center: myLatlng,
	        mapTypeId: google.maps.MapTypeId.ROADMAP
	    };
	    map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
	    findPlaces();
	}catch(ex){
		Console.log("Error in loading google map");
		_flaskLib.showErrorMessage('action-msg',ex.message);
	}

}
function clearOverlays() {
    if (markers) {
        for (i in markers) {
            markers[i].setMap(null);
        }
        markers = [];
        infos = [];
    }
}
function clearInfos() {
    if (infos) {
        for (i in infos) {
            if (infos[i].getMap()) {
                infos[i].close();
            }
        }
    }
}
function findPlaces() {
    var radius = 500;
    var lat = latitude;
    var lng = longitude;
    cur_location = new google.maps.LatLng(lat, lng);
    var request = {
        location: cur_location,
        radius: radius,
        types: ['food', 'bar', 'store']
    };
    service = new google.maps.places.PlacesService(map);
    service.search(request, createMarkers);
    
}
function createMarkers(results, status) {
    if (status == google.maps.places.PlacesServiceStatus.OK) {
    	clearOverlays();
    	venue_mark = new google.maps.Marker({
	        position: cur_location,
	        map: map,
	        animation:  google.maps.Animation.DROP,
	        icon: '/flask-view-events-portlet/img/flag-marker.png',
	    });
    	markers.push(venue_mark);

    	var infowindow = new google.maps.InfoWindow();
    	google.maps.event.addListener(venue_mark, 'click', (function(venue_mark) {
        	return function() {
                clearInfos();
                var content= '<div style="display: inline-flex;"><font style="color:#000; "><b>' + venueName + 
                '</b><br /><br />' + venueAddr + '</font></div>';
                infowindow.setContent(content);
                infowindow.open(map,venue_mark);
        	}
        })(venue_mark));
        infos.push(infowindow);
        for (var i = 0; i < results.length; i++) {
        	var mark;
            if(createMarker(results[i])){
            	console.log(results[i].geometry.location);
            	mark = new google.maps.Marker({
			        position: results[i].geometry.location,
			        map: map,
			        animation:  google.maps.Animation.DROP,
			        title: results[i].name,
			        icon: '/flask-view-events-portlet/img/flask-marker.png'
			    });
            }
            else{
				mark = new google.maps.Marker({
			        position: results[i].geometry.location,
			        map: map,
			        title: results[i].name,
			    });
            }
            markers.push(mark);
            var infowindow = new google.maps.InfoWindow();
            google.maps.event.addListener(mark, 'click', (function(mark, i) {
            	return function() {
	                clearInfos();
	                var content= '<div style="display: inline-flex;"><img src="' + results[i].icon + '" style="width:20%;"/><font style="color:#000; "><b>' + results[i].name + 
	                '</b><br /><br />Vicinity: ' + results[i].vicinity + '</font></div>';
	                infowindow.setContent(content);
	                infowindow.open(map,mark);
            	}
            })(mark, i));
            infos.push(infowindow);        
        }
    } else if (status == google.maps.places.PlacesServiceStatus.ZERO_RESULTS) {
        alert('Sorry, nothing is found');
    }
}
function createMarker(obj) {
	var isSubscribed = false;
	var coords = new google.maps.LatLng(
			obj['geometry']['location'].lat(),
			obj['geometry']['location'].lng()
		);
	for(var i=0; i<lat_marker.length; i++)
		{
			if((parseFloat(lat_marker[i][0]).toFixed(2) == parseFloat(coords.lat()).toFixed(2))&&(parseFloat(lng_marker[i]).toFixed(2) == parseFloat(coords.lng()).toFixed(2))&&(obj.name==addr_name[i]))
			{
				if(lat_marker[i][1] == marker_infoType || lat_marker[i][1] == 1)
					isSubscribed = true;
				else
					isSubscribed = false;
			}
		}
	return isSubscribed;
}
