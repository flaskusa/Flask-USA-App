<!DOCTYPE html>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Flask Home</title>
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
    <div class="container ">
        <!-- Static navbar --><br />
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
        <div class="row">
            <nav class="navbar">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/web/flask/flaskus">
                            <img class="img-responsive logo" src="/flask-landing-page-portlet/Images/flasklogo.png" style="height: 37px;width: 150px; margin-top: -18px" />
                        </a>
                         <a href="/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin">
                        	 <button class="btn btn-primary logIn" style="float: right;">Sign In <i class="icon-lock" ></i></button>
                         </a>
                    </div>
                   
                </div><!--/.container-fluid -->
            </nav>
            </div>
            <div class="container">
                <br />
                <div class="row">
                    <div class="col-sm-5">
                        <img class="img-responsive mob pull-right" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" />
                    </div>
                    <div class="col-sm-6">
                        <div class="text-center">
                            <p>
                                <h2 class="flasktext">
                                    Your Game plan for Game Day
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
                            <a href="#">
                                <button class="btn btn-primary" id="whatIsInFlask">Whats In Your Flask?</button>
                            </a>
                            </p>
                        </div>
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
            </div><br /><br /><br />  
        </div>
    </div>
</body>
</html>
