<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery &amp; canvas based weather web app</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/weather.css">
</head>
<script type="text/javascript">

</script>
<body>
<div id="weather-background" class="default-weather">
<canvas id="rain-canvas"> </canvas>
<canvas id="cloud-canvas"> </canvas>
<canvas id="weather-canvas"> </canvas>
<canvas id="time-canvas"> </canvas>
<canvas id="lightning-canvas"> </canvas>
<div class="page-wrap">
<!-- <header class="search-bar">
  <p class="search-text"><span class="search-location-text">
    <input id="search-location-input" class="search-location-input" type="text" placeholder="City" value="pune"></span></p>
  <div class="search-location-button-group">
    <button id="search-location-button" class="fa fa-search search-location-button search-button"></button>
    <button id="geo-button" class="geo-button fa fa-location-arrow search-button"></button>
  </div>
</header> -->
<div id="geo-error-message" class="geo-error-message hide">
  <button id='close-error' class='fa fa-times close-error'></button>
  Uh oh! It looks like we can't find your location. Please type your city into the search box above!</div>
<div id="front-page-description" class="front-page-description middle">
</div>
<div id="weather" class="weather middle hide">
  <div class="location" id="location"></div>
  <div class="weather-container">
    <div id="temperature-info" class="temperature-info">
      <div class="temperature" id="temperature"></div>
      <div class="weather-description" id="weather-description"></div>
    </div>
    <div class="weather-box">
      <ul class="weather-info" id="weather-info">
        <li class="weather-item humidity">Humidity: <span id="humidity"></span>%</li>
        <!-- -->
        <li class="weather-item wind">Wind: <span id="wind-direction"></span> <span id="wind"></span> <span id="speed-unit"></span></li>
      </ul>
    </div>
    <div class="temp-change">
      <button id="celsius" class="temp-change-button celsius">&deg;C</button>
      <button id="fahrenheit" class="temp-change-button fahrenheit">&deg;F</button>
    </div>
    <div style="align: center;">
   		<div id="forecast_small" style="font-size: 14px; text-align:center; display: inline-block; padding-top: 25px;"></div>
   	</div>
  </div>
</div>
</div>

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/weather.js"></script>
</div>
</body>
</html>