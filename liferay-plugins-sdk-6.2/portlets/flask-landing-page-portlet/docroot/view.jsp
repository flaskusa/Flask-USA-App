<!DOCTYPE html>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Flask Home</title>
</head>
<script type="text/javascript">

</script>
<body class="thumbnail">
    <div class="container ">
        <!-- Static navbar --><br />
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
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
                <div class="row row1">
                    <div class="col-sm-5">
                        <img class="img-responsive pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" style="height: 600px; width: 330px;" />
                    </div>
                    <div class="col-sm-6">
                        <div class="text-center" style="margin-top: 170px;">
                            <p>
                                <h2 class="flasktext">
                                    Your Game <br /> plan for Game Day
                                </h2>
                                <h4 >Your pocket companion for everything from pre-to post-event</h4>
                                <br />
                                <a href="/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Fcreate_account">
                                	<button class="btn btn-primary logIn" style="padding: 20px 40px;">Sign Up</button>
                                </a>
                                <a href="/web/flask/events">
                                	<button class="btn btn-primary myFlask" style="padding: 20px 40px;">My Flask</button>
                                </a>
                            </p>
                            <br /><br />
                            <p>
                            <a href="/flask-landing-page-portlet/features.jsp">
                                <button class="btn btn-primary">Whats In Your Flask?</button>
                            </a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="row row2">
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
               <div class="row row3">
            	<div class="col-sm-12">
                  	  <div id="main">
                        <div class="row">
                                <div class=" col-sm-5">
                                    <img class="img-responsive  fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" style="height: 600px; width: 330px;" />
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
                                    <img class="img-responsive  fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" style="height: 600px; width: 330px;" />
                                </div>
                                <div class="col-sm-6" style="margin-top: 150px;">
                                        <h2 class="flasktext">Tail Greater</h2>
                                        <h4 class="text-justify">
                                            Organize the greatest tailgate of the season by using Flask Features like inviting fellow revelers,
                                            requesting and accepting payments via Venmo, and planting a pin on Google Maps to make it easy for even your most clueless invitees to find the party.
                                        </h4>
                                </div>
                                <br />
                        </div>
                        <div class="row">
                                <div class=" col-sm-5">
                                    <img class="img-responsive  fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" style="height: 600px; width: 330px;" />
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
                                    <img class="img-responsive  fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" style="height: 600px; width: 330px;" />
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
                                    <img class="img-responsive  fadeInDown pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" style="height: 600px; width: 330px;" />
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
                 <div class="row row4">
	                    <div class="col-sm-9">
	                        <div class="row jumbotron">
	                            <h2 class="flasktext">
	                                Interested in becoming a contributor?
	                            </h2>
	                        </div>
	                    </div>
	                    <div class="col-sm-9">
	                        <blockquote>
	                            <p class="text-justify">
	                                We're always looking to expand our reach and help people just like us and you find their way in a new town. 
	                                Contact us with the form below and we'll get back to you as soon as possible.
	                            </p>
	                        </blockquote>
	                        <form id="contactForm">
							  <div class="form-group">
							    <div class="controls">
								    <label class="control-label" for="name">Name:</label>
								    <input name="name" id="name" class="form-control" type="text" />
								</div>
							  </div>
							   <div class="form-group">
								    <label class="control-label" for="eventTypeId">Email:</label>
									<input name="email" id="email" class="form-control" type="text" />
							   </div>
							  </form>
	                    </div>
                  </div>
                <hr>
                <div class="row">
		                <div class="col-sm-2" style="padding-left: 35px;">
				            <h4>Learn More</h4>
				              <a href="#" class="links" id="home">Home</a><br>
				              <a href="#" class="links" id="features">Features</a><br>
			            </div>
			            <div class="col-sm-2" style="padding-left: 35px;">
				            <h4>Company</h4>
				              <a href="#" class="links" id="aboutus">About Us</a><br>
			            </div>
			            <div class="col-sm-2" style="padding-left: 35px;">
				            <h4>Community</h4>
				              <a href="#" class="links" id="contactus">Contact Us</a><br>
			            </div>
		           </div><br>
            </div><br /><br /><br />  
        </div>
    </div>
</body>
</html>
