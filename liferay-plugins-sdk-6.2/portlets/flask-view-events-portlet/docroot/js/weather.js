var sample;
var latitude;
var longitude;
var condition;

function showForecastSmall(list)
{
	var forecast = [];
	forecast = list;
	var time_zone = 1000 * (new Date().getTimezoneOffset())*(-60);
 	var curdate = new Date( (new Date()).getTime()- 180 * 60 * 1000 );

	var html = ''

	var cnt=0;
	for(var i = 0; i <  6 ; i ++){

		var dt = new Date(forecast[i].dt * 1000);
	
		if( curdate  > dt )	continue;
		if(cnt > 10)		break;
		cnt++;

		var temp = Math.round(10*(forecast[i].main.temp - 273.15))/10 ;
		var tmin = Math.round(10*(forecast[i].main.temp_min)) / 10;
		var tmax = Math.round(10*(forecast[i].main.temp_max)) / 10 ;

		var text = forecast[i].weather[0].description;
		var gust = forecast[i].wind.speed;
		var pressure = forecast[i].main.pressure ;
		var cloud=forecast[i].clouds.all ;	
		var icon = forecast[i].weather[0].icon;
		var time = forecast[i].dt_txt;
		console.log(forecast[i]);

		var date = new Date(dt);
		console.log(date);
		var hours = date.getHours();
		//var minutes = "0" + date.getMinutes();
		var ampm = hours >= 12 ? 'PM' : 'AM';
		hours = hours % 12;
		if(hours== 0)
			hours=12;
		time = hours + ' ' + ampm;
		
		html=html+ '<div style="float: left; text-align: center; color: #fff;" >';
		html=html+ '<div class="small_val" title="time">'+time+'</div>\
		<img style="max-width: 85%;" alt="'+text+'" src="/flask-view-events-portlet/css/images/'+icon+'.png"/>\
		<div class="small_val" title="Temp">'+temp+'C</div>\
		</div>';
	}
	$("#forecast_small").html(html);

};

var w,
WeatherInfo = {
    settings: {
        tempIcon: $('#temp-icon'),
        weather: $('#weather'),
        weatherInfo: $('#weather-info'),
        location: $('#location'),
        weatherDescription: $('#weather-description'),
        tmp_icon: $('#tmp_icon'),
        temperature: $('#temperature'),
        tempNumber: '',
        fahrenheit: $('#fahrenheit'),
        celsius: $('#celsius'),
        wind: $('#wind'),
        celsiusButton: $('#celsius'),
        fahrenheitButton: $('#fahrenheit'),
        humidity: $('#humidity'),
        speedUnit: $('#speed-unit'),
        windSpeed: '',
        windDirection: $('#wind-direction'),
        windDegree: '',
        dayOrNight: '',
        closeAttribution: $('#close-attribution'),
        openAttribution: $('#noun-project'),
        attributionModal: $('#attribution-links')
    },

    init: function() {
        w = this.settings;
        this.bindUIActions();
        WeatherInfo.getWeatherData();
    },

    bindUIActions: function() {
        w.celsiusButton.on('click', function() {
            WeatherInfo.changeTempUnit('celsius');
        });

        w.fahrenheitButton.on('click', function() {
            WeatherInfo.changeTempUnit('fahrenheit');
        });

        w.closeAttribution.on('click', function() {
            WeatherInfo.closeAttributionModal();
        });

        w.openAttribution.on('click', function() {
            WeatherInfo.openAttributionModal();
        });
    },

    closeAttributionModal: function() {
        w.attributionModal.addClass('hide');
    },

    
    openAttributionModal: function() {
        w.attributionModal.removeClass('hide');
    },

    getWeatherData: function(searchQuery) {
    	w.searchQuery = 'http://api.openweathermap.org/data/2.5/weather?lat='+ latitude +'&lon='+ longitude +'';
        $.getJSON(w.searchQuery, function(data) {
            WeatherInfo.setWeatherData(data);
        });
        w.searchQuery1 = 'http://api.openweathermap.org/data/2.5/forecast?lat='+ latitude +'&lon='+ longitude +'&cnt=15';
        $.getJSON(w.searchQuery1, function(data) {
        	showForecastSmall(data.list);
        });
    },

    setWeatherData: function(data) {
        $('#front-page-description').addClass('hide');
        w.weather.removeClass('hide');
        w.location.text(data.name + ', ' + data.sys.country);
        w.humidity.text(data.main.humidity);
        w.weatherDescription.text(data.weather[0].description);
        img_icon = '<img id="w_icon" alt="" src="/flask-view-events-portlet/css/images/'+data.weather[0].icon+'1.png"/>';
        $(tmp_icon).html(img_icon);
        w.tempNumber = data.main.temp;
        w.windSpeed = data.wind.speed;
        w.windDegree = data.wind.deg;
        WeatherInfo.getWeatherDirection();
        WeatherInfo.changeTempUnit('celsius');
        var time = Date.now() / 1000;
        WeatherInfo.getDayOrNight(time, data.sys.sunrise, data.sys.sunset);
        condition = data.weather[0].main;
        $('#weather-background').removeClass();
        $('#weather-background').addClass(condition);
        $('#weather-background').addClass(w.dayOrNight);
    },

    getWeatherDirection: function() {
        if (w.windDegree > 337.5 || w.windDegree <= 22.5) {
            w.windDirection.text('N');
        } else if (22.5 < w.windDegree <= 67.5) {
            w.windDirection.text('NE');
        } else if (67.5 < w.windDegree <= 112.5) {
            w.windDirection.text('E');
        } else if (112.5 < w.windDegree <= 157.5) {
            w.windDirection.text('SE');
        } else if (157.5 < w.windDegree <= 202.5) {
            w.windDirection.text('S');
        } else if (202.5 < w.windDegree <= 247.5) {
            w.windDirection.text('SW');
        } else if (247.5 < w.windDegree <= 292.5) {
            w.windDirection.text('W');
        } else if (292.5 < w.windDegree <= 337.5) {
            w.windDirection.text('NW');
        }

    },

    isValid: function(weatherDataPiece) {
        if (typeof weatherDataPiece !== undefined) {
            return weatherDataPiece + ' ';
        } else {
            return '';
        }
    }, 

    changeTempUnit: function(unit) {
        var newTemp = w.tempNumber - 273.15;
        if (unit === 'celsius') {
            w.celsius.addClass('checked');
            w.fahrenheit.removeClass('checked');
            w.temperature.addClass('celsius-degree');
            w.temperature.removeClass('fahrenheit-degree');
            w.temperature.html(Math.round(newTemp));
            WeatherInfo.changeSpeedUnit('km');
        } else if (unit === 'fahrenheit') {
            w.temperature.html(Math.round(9/5 * newTemp + 32));
            w.celsius.removeClass('checked');
            w.fahrenheit.addClass('checked');
            w.temperature.removeClass('celsius-degree');
            w.temperature.addClass('fahrenheit-degree');
            WeatherInfo.changeSpeedUnit('m');
        }
    },

    changeSpeedUnit: function(unit) {
        if (unit === 'km') {
            w.wind.text('' + Math.round(w.windSpeed * 3.6));
            w.speedUnit.text('km/h');
        } else if (unit === 'm') {
            w.wind.text('' + Math.round(w.windSpeed * 2.23694185194));
            w.speedUnit.text('mph');
        }
    },

    getDayOrNight: function(time, sunrise, sunset) {

        if (time >= sunrise && time < sunset) {
            w.dayOrNight = 'daytime';
        } else if (time < sunrise) {
            if (time < sunset - 86400) {
                w.dayOrNight = 'daytime';
            } else {
                w.dayOrNight = 'nighttime';
            }
        } else if (time > sunset) {
            if (time < sunrise + 86400) {
                w.dayOrNight = 'nighttime';
            } else {
                w.dayOrNight = 'daytime';
            }
        }
    }
};

function callWeather(lat, lng) {
	latitude = lat;
	longitude = lng;
    WeatherInfo.init();
}