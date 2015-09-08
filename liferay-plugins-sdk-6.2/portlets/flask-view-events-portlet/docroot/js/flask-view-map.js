var _flaskMap = {};

_flaskMap.geocoder;
_flaskMap.map;
_flaskMap.markers = Array();
_flaskMap.infos = Array();
_flaskMap.cur_location;
_flaskMap.initializeMap = function() {
	try{
	    _flaskMap.geocoder = new google.maps.Geocoder();
	    var myLatlng = new google.maps.LatLng(latitude,longitude);
	    var myOptions = {
	        zoom: 14,
	        center: myLatlng,
	        mapTypeId: google.maps.MapTypeId.ROADMAP
	    };
	    _flaskMap.map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
	    _flaskMap.findPlaces();
	}catch(ex){
		Console.log("Error in loading google map");
		_flaskLib.showErrorMessage('action-msg',ex.message);
	}

}
_flaskMap.clearOverlays = function() {
    if (_flaskMap.markers) {
        for (i in _flaskMap.markers) {
            _flaskMap.markers[i].setMap(null);
        }
        _flaskMap.markers = [];
        _flaskMap.infos= [];
    }
}
_flaskMap.clearInfos = function() {
    if (_flaskMap.infos) {
        for (i in _flaskMap.infos) {
            if (_flaskMap.infos[i].getMap()) {
            	_flaskMap.infos[i].close();
            }
        }
    }
}
_flaskMap.findPlaces = function () {
    var radius = 2000;
    var lat = latitude;
    var lng = longitude;
    _flaskMap.cur_location = new google.maps.LatLng(lat, lng);
    var request = {
        location: _flaskMap.cur_location,
        radius: radius,
        types: ['food', 'bar', 'store']
    };
    service = new google.maps.places.PlacesService(_flaskMap.map);
    service.search(request, _flaskMap.createMarkers);
    
}
_flaskMap.createMarkers = function (results, status) {
    if (status == google.maps.places.PlacesServiceStatus.OK) {
    	_flaskMap.clearOverlays();
    	venue_mark = new google.maps.Marker({
	        position: _flaskMap.cur_location,
	        map: _flaskMap.map,
	        animation:  google.maps.Animation.DROP,
	        icon: '/flask-view-events-portlet/img/flag-marker.png',
	    });
    	_flaskMap.markers.push(venue_mark);

    	var infowindow = new google.maps.InfoWindow();
    	google.maps.event.addListener(venue_mark, 'click', (function(venue_mark) {
        	return function() {
        		_flaskMap.clearInfos();
                var content= '<div style="display: inline-flex;"><font style="color:#000; "><b>' + venueName + 
                '</b><br /><br />' + venueAddr + '</font></div>';
                infowindow.setContent(content);
                infowindow.open(_flaskMap.map,venue_mark);
        	}
        })(venue_mark));
        _flaskMap.infos.push(infowindow);
        for (var i = 0; i < results.length; i++) {
        	var mark;
            if(_flaskMap.createMarker(results[i])){
            	console.log(results[i].geometry.location);
            	mark = new google.maps.Marker({
			        position: results[i].geometry.location,
			        map: _flaskMap.map,
			        animation:  google.maps.Animation.DROP,
			        title: results[i].name,
			        icon: '/flask-view-events-portlet/img/flask-marker.png'
			    });
            }
            else{
				mark = new google.maps.Marker({
			        position: results[i].geometry.location,
			        map: _flaskMap.map,
			        title: results[i].name,
			    });
            }
            _flaskMap.markers.push(mark);
            var infowindow = new google.maps.InfoWindow();
            google.maps.event.addListener(mark, 'click', (function(mark, i) {
            	return function() {
            		_flaskMap.clearInfos();
	                var content= '<div style="display: inline-flex;"><img src="' + results[i].icon + '" style="width:20%;"/><font style="color:#000; "><b>' + results[i].name + 
	                '</b><br /><br />Vicinity: ' + results[i].vicinity + '</font></div>';
	                infowindow.setContent(content);
	                infowindow.open(_flaskMap.map, mark);
            	}
            })(mark, i));
            _flaskMap.infos.push(infowindow);        
        }
    } else if (status == google.maps.places.PlacesServiceStatus.ZERO_RESULTS) {
//        alert('Sorry, nothing is found');
    }
}
_flaskMap.createMarker = function (obj) {
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
