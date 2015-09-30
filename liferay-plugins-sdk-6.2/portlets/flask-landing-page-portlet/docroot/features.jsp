<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title> Flask Feature</title>
<link rel="shortcut icon" type="image/png" href="/FlaskTheme-theme/images/favicon.ico"/>
</head>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<portlet:renderURL var="aboutusURL">
    <portlet:param name="jspPage" value="/aboutus.jsp" />
</portlet:renderURL>
<portlet:renderURL var="featuresURL">
    <portlet:param name="jspPage" value="/features.jsp" />
</portlet:renderURL>
<portlet:renderURL var="contactusURL">
    <portlet:param name="jspPage" value="/contactus.jsp" />
</portlet:renderURL>
<body class="thumbnail">
    <div class="container">
            <div class="col-lg-1"></div>
            <div class="col-lg-10"><br/>
                <nav class="navbar">
		                <div class="container-fluid">
		                    <div class="navbar-header">
		                        <a class="navbar-brand" href="/web/flask/flaskus">
		                            <img class="img-responsive logo" src="/flask-landing-page-portlet/Images/flasklogo.png" style="height: 37px;width: 150px; margin-top: -18px" />
		                        </a>
		                         <a href="/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin">
		                        	 <button class="btn btn-primary logIn" style="float: right;">Sign In <i class="icon-lock" ></i></button>
		                         </a>
		                         <a href="/web/flask/events">
		                        	 <button class="btn btn-primary myFlask" style="float: right;">My Flask </button>
		                         </a>
		                    </div>
		                </div><!--/.container-fluid -->
		        </nav>

        <div class="container">
			 <div class="row">
            	<div class="col-sm-12">
                  	  <div id="main">
                        <div class="row">
                                <div class=" col-sm-5">
                                    <img class="img-responsive mob fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" />
                                </div>
                                <div class="col-sm-6" style="margin-top: 150px;">
                                        <h2 class="flasktext">Your Gameplan for Game Day</h2>
                                        <h4 class="text-justify">
                                            Whether it's a sporting event, concert, or family barbecue, Flask will help you organize, amplify, simplify everything from planning to the partying.
                                        </h4>
                                </div>
                                <br />
                        </div>
                        <div class="row">
                                <div class="col-sm-5">
                                    <img class="img-responsive mob fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" />
                                </div>
                                <div class="col-sm-6" style="margin-top: 150px;">
                                        <h2 class="flasktext">Tailgater</h2>
                                        <h4 class="text-justify">
                                            Organize the greatest tailgate of the season by using Flask Features like inviting fellow revelers,
                                            requesting and accepting payments via Venmo, and planting a pin on Google Maps to make it easy for even your most clueless invitees to find the party.
                                        </h4>
                                </div>
                                <br />
                        </div>
                        <div class="row">
                                <div class=" col-sm-5">
                                    <img class="img-responsive mob fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" />
                                </div>
                                <div class="col-sm-6" style="margin-top: 150px;">
                                        <h2 class="flasktext">Pre Game</h2>
                                        <h4 class="text-justify">
                                            We've all been there. You arrive at an event, maybe in another city, 
                                            and find yourself lost and wondering if you should've gotten off on the last exit. 
                                            With Flask: plan ahead and know the best place to park, find the friendliest bars, locate the cheapest stores and finest restaurants to hit up before the event.
                                        </h4>
                                </div>
                                <br />
                        </div>
                        <div class="row">
                                <div class=" col-sm-5">
                                    <img class="img-responsive mob fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" />
                                </div>
                                <div class="col-sm-6" style="margin-top: 150px;">
                                    <h2 class="flasktext">Mid Game</h2>
                                    <h4 class="text-justify">
                                        What's the best entrance? Are there any bathrooms to avoid in the stadium? 
                                        Are the hot dogs all beef or all question marks? If you're wearing the opponents colors on game day, a local may not be the best source for this information. 
                                        That's why you should always carry Flask in your pocket.
                                    </h4>
                                </div>
                                <br />
                        </div>
                        <div class="row">
                                <div class=" col-sm-5">
                                    <img class="img-responsive mob fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" />
                                </div>
                                <div class="col-sm-6" style="margin-top: 150px;">
                                    <h2 class="flasktext">Post Game</h2>
                                    <h4 class="text-justify">
                                        Not all bars are created equal, and Flask is here to help you find the Buckeye bar in Ann Arbor, 
                                        the place that packs in the Packer fans in Chicago, a safe haven for Raiders fans in San Fransisco, and the quickest way out of of the Bronx for Red Sox fans.
                                    </h4>
                                </div>
                                <br />
                        </div>
                    </div>
                <div class="col-lg-1"></div>
            </div>
		</div>
		<hr>
		 <div class="row">
		                <div class="col-sm-2" style="padding-left: 35px;">
				            <h4>Learn More</h4>
				              <a href="/web/flask/flaskus" class="links" id="home">Home</a><br>
				              <a href="<%= featuresURL %>" class="links" id="features">Features</a><br>
			            </div>
			            <div class="col-sm-2" style="padding-left: 35px;">
				            <h4>Company</h4>
				              <a href="<%= aboutusURL %>" class="links" id="aboutus">About Us</a><br>
			            </div>
			            <div class="col-sm-2" style="padding-left: 35px;">
				            <h4>Community</h4>
				              <a href="<%= contactusURL %>" class="links" id="contactus">Contact Us</a><br>
			            </div>
		  </div><br>
        </div>
        </div>
        <div class="col-lg-1"></div>
    </div>
 <script src="css/wow.js"></script>
    <script type="text/javascript">
        wow = new WOW(
            {
                animateClass: 'animated',
                offset: 100,
                callback: function (box) {
                    console.log("WOW: animating <" + box.tagName.toLowerCase() + ">");
                }
            }
        );
        wow.init();
        document.getElementById('moar').onclick = function () {
            var section = document.createElement('section');
            section.className = 'section--purple wow fadeInDown';
            this.parentNode.insertBefore(section, this);
        };
   </script>
</body>
</html>
