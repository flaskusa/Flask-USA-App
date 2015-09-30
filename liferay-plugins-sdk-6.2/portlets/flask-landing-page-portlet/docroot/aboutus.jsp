<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title> Flask AboutUs</title>
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
                <div class="col-lg-10">
                    <br/>
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
                        <br />
                        <div class="row">
	                        <div class="col-sm-9">
	                            <div class="row jumbotron">
	                                <h2 class="flasktext">We've funneled a lot of top shelf information into Flask</h2>
	                            </div>
	                        </div>
	                        <div class="col-sm-9">
	                            <blockquote>
	                                <p class="text-justify">
	                                    Organize tailgates and parties by setting up an account, inviting people to the event via the Flask app, requesting and accepting Venmo payments, and pinning your location to make it easy for your invitees to find you. In the Tailgate event you set up, you can share all kinds of vital details like the drinks and food you'll be serving, and other important details like the food and drinks you'll be serving.
	                                </p>
	                            </blockquote>
	                            <blockquote>
	                                <p class="text-justify">
	                                    Download event details onto your phone by using the "Flask It" button, so you'll have access to the information even when your signal drops inside the venue.
	                                    Skim the data while you're in a new town to find what you're looking for
	                                </p>
	                            </blockquote>
	                            <blockquote>
	                                <p class="text-justify">
	                                    We will promote certain businesses that pertain to the day, time, and the event you're going to point you in the right direction.
	                                </p>
	                            </blockquote>
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
        </div>
    </body>
</html>
