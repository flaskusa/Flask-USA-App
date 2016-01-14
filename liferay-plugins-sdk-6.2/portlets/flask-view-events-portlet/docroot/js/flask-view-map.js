var _flaskMap = {};

_flaskMap.geocoder;
_flaskMap.map;
_flaskMap.latitude;
_flaskMap.longitude;
_flaskMap.placeType;
_flaskMap.searchControl;
_flaskMap.markerCalled = false;
_flaskMap.markerTitles = Array();
_flaskMap.markers = Array();
_flaskMap.flaskMarkers = Array();
_flaskMap.searchMarkers = Array();
_flaskMap.infos = Array();
_flaskMap.allowedContent = ["Getting home","Traffic","Supplies","Tradition","Flask Us","Venue Map","Venue Info"];

var isMobile = {
    Android: function() {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function() {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function() {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function() {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function() {
        return navigator.userAgent.match(/IEMobile/i);
    },
    any: function() {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};

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
	     
	     // Create the search box and link it to the UI element.
	     var inputDiv = document.createElement('div');
	     inputDiv.className = "inputDivCls";
	     _flaskMap.searchControl = document.createElement('input');
	     _flaskMap.searchControl.id = 'tags';
	     _flaskMap.searchControl.className = "SearchControl";
	     var inputButton = document.createElement('button');
	     inputButton.className = 'searchClear';
	     inputButton.id = 'searchClear';
	     inputButton.style.display = 'none';
	     inputDiv.appendChild( _flaskMap.searchControl);
	     inputDiv.appendChild(inputButton);
	     
	     _flaskMap.map.controls[google.maps.ControlPosition.TOP_LEFT].push(inputDiv);
	     
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
	if(places!='bar &amp; restaurants'){
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
	        icon: '/flask-view-events-portlet/img/flag-marker.png'
	    });
    	var infowindow = new google.maps.InfoWindow();
    	google.maps.event.addListener(venue_mark, 'click', (function(venue_mark) {
        	return function() {
        		_flaskMap.clearInfos();
        		var findUsOnMap = _flaskMap.createMapLink(venueAddr);
                var content= '<div style="display: inline-flex;height:100px;"><font style="color:#000;"><b>' + venueName + 
                '</b><br /><br />' + findUsOnMap + '</font></div>';
                infowindow.setContent(content);
                infowindow.open(_flaskMap.map,venue_mark);
        	}
        })(venue_mark));
    	if(!_flaskMap.markerCalled){
    		_flaskMap.markers.push(venue_mark);
    		_flaskMap.infos.push(infowindow);
            _flaskMap.myMarkers();
    	}
        
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
            google.maps.event.addListener(_flaskMap.map, 'click', function(map) {
        		_flaskMap.clearInfos();
        	});
            google.maps.event.addListener(mark, 'click', (function(mark, i) {
            	return function() {
            		_flaskMap.clearInfos();
            		service.getDetails({
            		    placeId: results[i].place_id
            		  }, function(place, status) {
            		    if (status === google.maps.places.PlacesServiceStatus.OK) {
            		    	var content= '<div style="display: inline-flex;"><img src="' + results[i].icon + '" style="width:30px;height:30px;"/><font style="color:#000;">&nbsp;&nbsp;<b>'+results[i].name+'</b><br/></div>';
            		    	if(place.formatted_address!="" && place.formatted_address!=undefined){
		        				var objAddress= $('<div/>');
		        				var findUsOnMap = _flaskMap.createMapLink(place.formatted_address);
		        				objAddress.html('<div class="adAddress"><table width="100%"><tr><td width="38px" valign="top"><span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-address"></span></td><td>'+findUsOnMap+'</td><tr/></table></div>');
		        				content = content + objAddress.html();
		        			}
            		    	if(place.international_phone_number!="" && place.international_phone_number!=undefined){
		        				var objPhone= $('<div/>');
		        				objPhone.html('<div class="adPhone"><span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-phone"></span><a href="tel:'+place.international_phone_number+'">'+place.international_phone_number+'</a></div>');
		        				content = content + objPhone.html();
		        			}
            		    	if(place.website!="" && place.website!=undefined){
		        				var objWebSite = $('<div/>');
		        				objWebSite.html('<div class="adWebSite"><span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-website"></span><a href="'+_flaskLib.fixURL(place.website)+'" target="_blank">'+place.website+'</a></div>');
		        				content = content + objWebSite.html();
		        			}
            		      infowindow.setContent(content);
      	                  infowindow.open(_flaskMap.map, mark);
            		    }
            		  });	                
	                
            	}
            })(mark, i));
            _flaskMap.infos.push(infowindow);   
        }
    } else if (status == google.maps.places.PlacesServiceStatus.ZERO_RESULTS) {
//        alert('Sorry, nothing is found');
    }
}

_flaskMap.myMarkers = function(){
	_flaskMap.markerCalled = true;
	_flaskMap.flaskMarkers = [];
	_flaskMap.markerTitles = [];
	 $(".searchClear").addClass('icon-remove');
     $(".searchClear").click(function(){
    	 $("#tags").val("");
    	 $("#tags").keyup();
    	 document.getElementById('searchClear').style.display = 'none';
     });
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

		if(obj.latitude!= "" && _flaskMap.placeType == obj.infoTypeCategoryName.toLowerCase()){
			var mark;
			var myLatlng = new google.maps.LatLng(obj.latitude, obj.longitude);
				if(_flaskMap.placeType=="bar & restaurants"){
	    			icon_url = '/flask-view-events-portlet/img/icon_bar.png';
	    		}
	    		if(_flaskMap.placeType=="parking"){
	    			icon_url = '/flask-view-events-portlet/img/flask_map_icon_11.png';//icon_parking.png';
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
				_flaskMap.markerTitles.push(mark.title+", "+obj.addrLine1);
				_flaskMap.flaskMarkers.push(mark);
				_flaskMap.markers.push(mark);
				 
				 var infowindow = new google.maps.InfoWindow();
		            google.maps.event.addListener(mark, 'click', (function(mark, i) {
		            	return function() {
		            		_flaskMap.clearInfos();
		            		var findUsOnMap = _flaskMap.createMapLink(obj.addrLine1);
		            		var content= '<div style="display: inline-flex;"><img src="/flask-view-events-portlet/img/FlaskRed.png" style="width:30px;height:30px;"/><font style="color:#000;">&nbsp;&nbsp;<b>'+obj.infoTitle+'</b><br/></div>';
		        			if(obj.phone!=""){
		        				var objPhone= $('<div/>');
		        				objPhone.html('<div class="adPhone"><span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-phone"></span><a href="tel:'+obj.phone+'">'+obj.phone+'</a></div>');
		        				content = content + objPhone.html();
		        			}
		        			
		        			if(obj.website!=""){
		        				var objWebSite = $('<div/>');
		        				objWebSite.html('<div class="adWebSite"><span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-website"></span><a href="'+_flaskLib.fixURL(obj.website)+'" target="_blank">'+obj.website+'</a></div>');
		        				content = content + objWebSite.html();
		        			}
		        			
		        			if(obj.addrLine1!=""){
		        				var objAddress= $('<div/>');
		        				var findUsOnMap = _flaskMap.createMapLink(obj.addrLine1);
		        				objAddress.html('<div class="adAddress"><table width="100%"><tr><td width="38px" valign="top"><span aria-label="Address" role="img" class="widget-pane-section-info-icon widget-pane-section-info-address"></span></td><td>'+findUsOnMap+'</td><tr/></table></div>');
		        				content = content + objAddress.html();
		        			}		            		
		        			
		        			if(obj.infoDesc!=""){
		        				var objInfoDesc= $('<div/>');
		        				objInfoDesc.html('<div class="adDescription"><b>Flask us:</b><br/>'+obj.infoDesc+'</div>');
		        				content = content + objInfoDesc.html();
		        			}		            		

			                infowindow.setContent(content);
			                infowindow.open(_flaskMap.map, mark);
		            	}
		            })(mark, i));
		            _flaskMap.infos.push(infowindow);	
		}
	});
	var curMarker=null;
	$(_flaskMap.searchControl).keyup(function() {
		if($("#tags").val()==""){
			document.getElementById('searchClear').style.display = 'none';
			for(var i=0; i<_flaskMap.flaskMarkers.length; i++){
				if(_flaskMap.flaskMarkers[i].icon=="/flask-view-events-portlet/img/bar_selected.png"){
 					_flaskMap.flaskMarkers[i].setIcon("/flask-view-events-portlet/img/icon_bar.png");
 					_flaskMap.flaskMarkers[i].setAnimation(google.maps.Animation.DROP);
	    		}
	    		if(_flaskMap.flaskMarkers[i].icon=="/flask-view-events-portlet/img/parking_selected.png"){
	    			_flaskMap.flaskMarkers[i].setIcon("/flask-view-events-portlet/img/flask_map_icon_11.png");
	    			_flaskMap.flaskMarkers[i].setAnimation(google.maps.Animation.DROP);
	    		}
	    		if(_flaskMap.placeType=="nightlife"){
	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
	    		}
	    		if(_flaskMap.placeType=="liquor_store"){
	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
	    		}
			}
		}else{
			document.getElementById('searchClear').style.display = 'block';
		}
	});
	$(_flaskMap.searchControl).autocomplete({
     	source: _flaskMap.markerTitles,
     	select: function( event, ui ) {
     		document.getElementById('searchClear').style.display = 'block';
     		for(var i=0; i<_flaskMap.flaskMarkers.length; i++){
     			if(ui.item.value==_flaskMap.markerTitles[i]){
     				curMarker = _flaskMap.flaskMarkers[i];
     				if(_flaskMap.placeType=="bar & restaurants"){
     					_flaskMap.flaskMarkers[i].icon = "/flask-view-events-portlet/img/bar_selected.png";
         				_flaskMap.flaskMarkers[i].setAnimation(google.maps.Animation.DROP);
    	    		}
    	    		if(_flaskMap.placeType=="parking"){
    	    			_flaskMap.flaskMarkers[i].icon = "/flask-view-events-portlet/img/parking_selected.png";
         				_flaskMap.flaskMarkers[i].setAnimation(google.maps.Animation.DROP);
    	    		}
    	    		if(_flaskMap.placeType=="nightlife"){
    	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
    	    		}
    	    		if(_flaskMap.placeType=="liquor_store"){
    	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
    	    		}
     				/*setTimeout(function(){
     					for(var j=0; j<_flaskMap.flaskMarkers.length; j++){
     						_flaskMap.flaskMarkers[j].setAnimation(null);
     					}
     				}, 3000000);*/
     					
     			}else{
     				_flaskMap.flaskMarkers[i].setAnimation(null);
     			}
     		}
     	},
     	search: function( event, ui ) {
     		document.getElementById('searchClear').style.display = 'block';
     		if(ui.item==null){
     			for(var i=0; i<_flaskMap.flaskMarkers.length; i++){
     				if(_flaskMap.flaskMarkers[i].icon=="/flask-view-events-portlet/img/bar_selected.png"){
     					_flaskMap.flaskMarkers[i].setIcon("/flask-view-events-portlet/img/icon_bar.png");
     					_flaskMap.flaskMarkers[i].setAnimation(google.maps.Animation.DROP);
    	    		}
    	    		if(_flaskMap.flaskMarkers[i].icon=="/flask-view-events-portlet/img/parking_selected.png"){
    	    			_flaskMap.flaskMarkers[i].setIcon("/flask-view-events-portlet/img/flask_map_icon_11.png");
    	    			_flaskMap.flaskMarkers[i].setAnimation(google.maps.Animation.DROP);
    	    		}
    	    		if(_flaskMap.placeType=="nightlife"){
    	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
    	    		}
    	    		if(_flaskMap.placeType=="liquor_store"){
    	    			icon_url = '/flask-view-events-portlet/img/icon_liquor.png';
    	    		}
    			}
     		}
     	},
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

_flaskMap.createMapLink = function(address1){
	var findUs = '';
	if(isMobile.Android()=="Android"){
		findUs = '<a href="geo:'+address1+'" class="addressLink">'+address1+'</a>'
	}
	else if(isMobile.BlackBerry()=="BlackBerry"){
		findUs = '<a href="http://maps.google.com/?saddr=Current%20Location&daddr='+address1+'">'+address1+'</a>';
	}
	else if(isMobile.iOS()=="iPhone" || isMobile.iOS()=="iPad" || isMobile.iOS()=="iPod"){
		findUs = '<a href="http://maps.apple.com/?saddr=Current%20Location&daddr='+address1+'">'+address1+'</a>';
	}
	else if(isMobile.Windows()=="IEMobile"){
		findUs = '<a href="maps:'+address1+'">'+address1+'</a>'
	}
	else{
		findUs = '<a href="http://maps.google.com/?saddr=Current%20Location&daddr='+address1+'">'+address1+'</a>';
	}
	return findUs;
}