var _flaskMap = {};

_flaskMap.geocoder;
_flaskMap.map;
_flaskMap.latitude;
_flaskMap.longitude;
_flaskMap.placeType;
_flaskMap.markers = Array();
_flaskMap.infos = Array();
_flaskMap.cur_location;
_flaskMap.initializeMap = function() {
	try{
	    _flaskMap.geocoder = new google.maps.Geocoder();
	    var myLatlng = new google.maps.LatLng(_flaskMap.latitude,_flaskMap.longitude);
	    var myOptions = {
	        zoom: 15,
	        center: myLatlng,
	        mapTypeId: google.maps.MapTypeId.ROADMAP,
	        mapTypeControl:false
	    };
	    var mapDiv = document.getElementById('gmap_canvas');
	    if(document.getElementById('gmap_canvas')==null){
	    	var mapDiv = document.createElement('div');
	    	mapDiv.id = 'gmap_canvas';
	    	$('.jqx-tabs-content-element:visible').attr('id','temp');
	    	var containerDiv = document.getElementById('temp');
	    	containerDiv.appendChild(mapDiv); 
	    }
	    _flaskMap.map = new google.maps.Map(mapDiv, myOptions);
	    google.maps.event.trigger(_flaskMap.map, 'resize');
	    var centerControlDiv = document.createElement('div');
	    centerControlDiv.style.marginRight= '5px';
	    centerControlDiv.style.top = 15;
	    centerControlDiv.style.left = 15;
	    var centerControl = new CenterControl(centerControlDiv, _flaskMap.map);
	    var centerControl1 = new CenterControl1(centerControlDiv, _flaskMap.map);

	    centerControlDiv.index = 1;
	    _flaskMap.map.controls[google.maps.ControlPosition.RIGHT_CENTER].push(centerControlDiv);
	}catch(ex){
		console.log("Error in loading google map");
		_flaskLib.showErrorMessage('action-msg',ex.message);
	}

}


function CenterControl(controlDiv, map) {

	  // Set CSS for the control border.
	  var controlUI = document.createElement('div');
	  controlUI.style.backgroundColor = '#fff';
	  controlUI.style.border = '2px solid #fff';
	  controlUI.style.borderRadius = '3px';
	  controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
	  controlUI.style.cursor = 'pointer';
	  controlUI.style.marginBottom = '5px';
	  controlUI.style.textAlign = 'center';
	  controlUI.title = 'Select Type';
	  controlDiv.appendChild(controlUI);

	  // Set CSS for the control interior.
	  var controlText = document.createElement('div');
	  controlText.style.color = 'rgb(25,25,25)';
	  controlText.style.fontSize = '16px';
	  controlText.style.height = '32px';
	  controlText.style.padding = '5px';
	  controlText.innerHTML = "<div class='miniFlaskButton miniFlaskButton-checked' id='ch1'></div>";
	  controlUI.appendChild(controlText);
	  controlUI.click();
	  controlUI.addEventListener('click', function() {
			  var i;
			  if($("#ch1").hasClass('miniFlaskButton-checked')){
				  $("#ch1").removeClass('miniFlaskButton-checked');
				  for (i = 0; i < _flaskMap.markers.length; i++) {
		  	          if (_flaskMap.markers[i].get("class") == "flask_icons") {
		  	        	  _flaskMap.markers[i].setVisible(false);
		  	          }
		  	        }
			  }else{
				  $("#ch1").addClass('miniFlaskButton-checked');
				  for (i = 0; i < _flaskMap.markers.length; i++) {
			          if (_flaskMap.markers[i].get("class") == "flask_icons") {
			        	  _flaskMap.markers[i].setVisible(true);
			          }
			        }
			  }
	  });
	  
	  
	}

function CenterControl1(controlDiv, map){
	// Set CSS for the control border.
	  var controlUI = document.createElement('div');
	  controlUI.style.backgroundColor = '#fff';
	  controlUI.style.border = '2px solid #fff';
	  controlUI.style.borderRadius = '3px';
	  controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
	  controlUI.style.cursor = 'pointer';
	  controlUI.style.marginBottom = '22px';
	  controlUI.style.textAlign = 'center';
	  controlUI.title = 'Select Type';
	  controlDiv.appendChild(controlUI);

	  // Set CSS for the control interior.
	  var controlText = document.createElement('div');
	  controlText.style.color = 'rgb(25,25,25)';
	  controlText.style.fontFamily = 'Roboto,Arial,sans-serif';
	  controlText.style.fontSize = '16px';
	  controlText.style.height = '32px';
	  controlText.style.padding = '5px';
	  controlText.style.paddingRight = '5px';
	  controlText.innerHTML = "<div class='miniGoogleButton' id='ch2'></div>";
	  controlUI.appendChild(controlText);
	  controlUI.click();
	  controlUI.addEventListener('click', function() {
			  var i;
			  if($("#ch2").hasClass('miniGoogleButton-checked')){
				  $("#ch2").removeClass('miniGoogleButton-checked');
				  for (i = 0; i < _flaskMap.markers.length; i++) {
		  	          if (_flaskMap.markers[i].get("class") == "google_icons") {
		  	        	  _flaskMap.markers[i].setVisible(false);
		  	          }
		  	        }
			  }else{
				  $("#ch2").addClass('miniGoogleButton-checked');
				  for (i = 0; i < _flaskMap.markers.length; i++) {
			          if (_flaskMap.markers[i].get("class") == "google_icons") {
			        	  _flaskMap.markers[i].setVisible(true);
			          }
			        }
			  }
	  });
	  
	  
}

_flaskMap.clearOverlays = function() {

        for (i in _flaskMap.markers) {
            _flaskMap.markers[i].setMap(null);
        }
        _flaskMap.markers = [];
        _flaskMap.infos= [];

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
_flaskMap.findPlaces = function (places) {
	_flaskMap.placeType = places;
    var radius = 2000;
    var lat = _flaskMap.latitude;
    var lng = _flaskMap.longitude;
    _flaskMap.cur_location = new google.maps.LatLng(lat, lng);
    var request = {
        location: _flaskMap.cur_location,
        radius: radius,
        types: [places]
    };
    service = new google.maps.places.PlacesService(_flaskMap.map);
    service.search(request, _flaskMap.createMarkers);
}

_flaskMap.createMarkers = function (results, status) {
	if(!$("#ch1").hasClass('miniFlaskButton-checked')){
		$("#ch1").addClass('miniFlaskButton-checked');
	}
	if($("#ch2").hasClass('miniGoogleButton-checked')){
		  $("#ch2").removeClass('miniGoogleButton-checked');
	}
    if (status == google.maps.places.PlacesServiceStatus.OK) {
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
                var content= '<div style="display: inline-flex;height:100px;"><font style="color:#000; "><b>' + venueName + 
                '</b><br /><br />' + venueAddr + '</font></div>';
                infowindow.setContent(content);
                infowindow.open(_flaskMap.map,venue_mark);
        	}
        })(venue_mark));
        _flaskMap.infos.push(infowindow);
        _flaskMap.myMarkers();
        for (var i = 0; i < results.length; i++) {
        	var mark;
        	var icon_url;
            if(_flaskMap.createMarker(results[i])){
            	continue;
            }
            else{
				mark = new google.maps.Marker({
			        position: results[i].geometry.location,
			        map: _flaskMap.map,
			        title: results[i].name,
			        visible: false,
			        class: 'google_icons'
			    });
            }
            _flaskMap.markers.push(mark);
            var infowindow = new google.maps.InfoWindow();
            google.maps.event.addListener(mark, 'click', (function(mark, i) {
            	return function() {
            		_flaskMap.clearInfos();
	                var content= '<div style="display: inline-flex;height:100px;"><img src="' + results[i].icon + '" style="width:34px; height:34px;"/><font style="color:#000; "><b>' + results[i].name + 
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

_flaskMap.myMarkers = function(){
	$.each(eventDetailJSON, function(i, ob) {
		var obj=$.parseJSON(eventDetailJSON[i].Detail);
		var icon_url = "";
		if(_flaskMap.placeType == 'bar &amp; restaurants'){
			_flaskMap.placeType = "bar & restaurants";
		}
		if(_flaskMap.placeType == 'parking'){
			_flaskMap.placeType = "parking";
		}
		if(_flaskMap.placeType == 'nightlife'){
			_flaskMap.placeType = "nightlife";
		}
		if(_flaskMap.placeType == 'liquor store'){
			_flaskMap.placeType = "liquor_store";
		}
		console.log(obj.infoTypeCategoryName.toLowerCase()+": "+obj.latitude+" : "+obj.longitude);
		if(obj.latitude!= "" && _flaskMap.placeType == obj.infoTypeCategoryName.toLowerCase()){
			var mark;
			var myLatlng = new google.maps.LatLng(obj.latitude, obj.longitude);
				if(_flaskMap.placeType=="bar & restaurants"){
	    			icon_url = '/flask-view-events-portlet/img/icon_bar.png';
	    		}
	    		if(_flaskMap.placeType=="parking"){
	    			icon_url = '/flask-view-events-portlet/img/icon_parking.png';
	    		}
	    		if(_flaskMap.placeType=="nightlife"){
	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
	    		}
	    		if(_flaskMap.placeType=="liquor_store"){
	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
	    		}

				mark = new google.maps.Marker({
			        position: myLatlng,
			        map: _flaskMap.map,
			        animation:  google.maps.Animation.DROP,
			        title: obj.infoTitle,
			        icon: icon_url,
			        visible: true,
			        class: 'flask_icons'
			    });
				 _flaskMap.markers.push(mark);
				 var infowindow = new google.maps.InfoWindow();
		            google.maps.event.addListener(mark, 'click', (function(mark, i) {
		            	return function() {
		            		_flaskMap.clearInfos();
			                var content= '<div style="display: inline-flex;"><img src="/flask-view-events-portlet/img/FlaskRed.png" style="width:12%; height:12%;"/><font style="color:#000; "><b>' + obj.infoTitle + 
			                '</b><br /><br />' + obj.addrLine1 + '</font></div>';
			                infowindow.setContent(content);
			                infowindow.open(_flaskMap.map, mark);
		            	}
		            })(mark, i));
		            _flaskMap.infos.push(infowindow);	
		}
	});
}

_flaskMap.createMarker = function (obj) {
	var isSubscribed = false;
	var coords = new google.maps.LatLng(
			obj['geometry']['location'].lat(),
			obj['geometry']['location'].lng()
		);
	for(var i=0; i<lat_marker.length; i++)
		{
			if((parseFloat(lat_marker[i][0]).toFixed(2) == parseFloat(coords.lat()).toFixed(2))&&(parseFloat(lng_marker[i]).toFixed(2) == parseFloat(coords.lng()).toFixed(2))&&(obj.vicinity.slice(0,10)==addr_name[i].slice(0,10)))
			{
				if(lat_marker[i][1] == marker_infoType || lat_marker[i][1] == 1)
					isSubscribed = true;
				else
					isSubscribed = false;
			}
		}
	return isSubscribed;
}
