<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title> Flask Contact-Us</title>
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
                    <br />
                     <div class="row">
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
							   	<div class="controls">
								    <label class="control-label" for="eventTypeId">Email:</label>
									<input name="email" id="email" class="form-control" type="text" />
								</div>
							   </div>
							   <div class="form-group">
							    <div class="controls">
								    <label class="control-label" for="mobile">Mobile:</label>
								    <input name="mobile" id="mobile" class="form-control" type="text" />
								</div>
							  </div>
							  <div class="form-group">
								    <label class="control-label" for="comment">Comment:</label>
								    <textarea rows="5" name="comment" id="comment" class="form-control"></textarea>
							  </div>
							  <input id="Ok" class="btn btn-info clsSave" type="button" value="Ok" />
		 					  <input class="btn btn-primary clsCancel" type="reset" value="Cancel">
							  </form>
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
</body>
</html>
