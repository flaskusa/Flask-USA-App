var geocoder;
var map;
var markers = Array();
var infos = Array();

function initialize() {
    // prepare Geocoder
    geocoder = new google.maps.Geocoder();

    // set initial position (New York)
    var myLatlng = new google.maps.LatLng(latitude,longitude);

    var myOptions = { // default map options
        zoom: 16,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
    findPlaces();
}

// clear overlays function
function clearOverlays() {
    if (markers) {
        for (i in markers) {
            markers[i].setMap(null);
        }
        markers = [];
        infos = [];
    }
}

// clear infos function
function clearInfos() {
    if (infos) {
        for (i in infos) {
            if (infos[i].getMap()) {
                infos[i].close();
            }
        }
    }
}

// find custom places function
function findPlaces() {

    // prepare variables (filter)
    var radius = 500;

    var lat = latitude;
    var lng = longitude;
    var cur_location = new google.maps.LatLng(lat, lng);

    // prepare request to Places
    var request = {
        location: cur_location,
        radius: radius,
        types: ['food', 'bar', 'store']
    };
    // send request
    service = new google.maps.places.PlacesService(map);
    service.search(request, createMarkers);
}

// create markers (from 'findPlaces' function)
function createMarkers(results, status) {
    if (status == google.maps.places.PlacesServiceStatus.OK) {
    	clearOverlays();
        // and create new markers by search result
        for (var i = 0; i < results.length; i++) {
            if(createMarker(results[i])){
            	var mark = new google.maps.Marker({
			        position: results[i].geometry.location,
			        map: map,
			        title: results[i].name,
			        icon: '/flask-view-events-portlet/img/flask-marker.png'
			    });
            }
            else{
				var mark = new google.maps.Marker({
			        position: results[i].geometry.location,
			        map: map,
			        title: results[i].name,
			    });
            }
            markers.push(mark);
            var infowindow = new google.maps.InfoWindow({
                content: '<img src="' + results[i].icon + '" /><font style="color:#000;">' + results[i].name + 
                '<br />Rating: ' + results[i].rating + '<br />Vicinity: ' + results[i].vicinity + '</font>'
            });

            // add event handler to current marker
            google.maps.event.addListener(mark, 'click', function() {
                clearInfos();
                infowindow.open(map,mark);
            });
            infos.push(infowindow);        
        }
        // prepare info window
    } else if (status == google.maps.places.PlacesServiceStatus.ZERO_RESULTS) {
        alert('Sorry, nothing is found');
    }
}

// creare single marker function
function createMarker(obj) {
	var isSubscribed = false;
	var coords = new google.maps.LatLng(
			obj['geometry']['location'].lat(),
			obj['geometry']['location'].lng()
		);
	for(var i=0; i<lat_marker.length; i++)
		{
			console.log((parseFloat(lat_marker[i]).toFixed(2) == parseFloat(coords.lat()).toFixed(2))&&(parseFloat(lng_marker[i]).toFixed(2) == parseFloat(coords.lng()).toFixed(2))&&(obj.name==addr_name[i]));
			if((parseFloat(lat_marker[i]).toFixed(2) == parseFloat(coords.lat()).toFixed(2))&&(parseFloat(lng_marker[i]).toFixed(2) == parseFloat(coords.lng()).toFixed(2))&&(obj.name==addr_name[i]))
			{
				isSubscribed = true;
			}
		}
	return isSubscribed;
}
