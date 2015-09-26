<!DOCTYPE html>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Flask Home</title>
</head>
<script type="text/javascript">
$(".navbar-inner").hide();
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
                            <img class="img-responsive" src="/flask-landing-page-portlet/Images/flasklogo.png" style="height: 37px;width: 150px; margin-top: -18px" />
                        </a>
                         <a href="/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin">
                        	 <button class="btn btn-primary" style="margin-left: 62%;">Sign In <i class="icon-lock" ></i></button>
                         </a>
                    </div>
                   
                </div><!--/.container-fluid -->
            </nav>
            <div class="container">
                <br />
                <div class="row">
                    <div class="col-lg-4">
                        <img class="img-responsive pull-left" src="/flask-landing-page-portlet/Images/Flask_home_image.png" alt="Flask App Welcome" style="height: 600px; width: 330px;" />
                    </div>
                    <div class="col-lg-5">
                        <div class="text-center" style="margin-top: 170px;">
                            <p>
                                <h2 class="flasktext">
                                    Your Game <br /> plan for Game Day
                                </h2>
                                <h4 style="color: #F69533;">Your pocket companion for everything from pre-to post-event</h4>
                                <br />
                                <a href="/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Fcreate_account">
                                	<button class="btn btn-primary" style="padding: 20px 40px;">Sign Up</button>
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
                <hr>
                <div class="row">
	                <div class="col-sm-2" style="padding-left: 35px;">
			            <h4>Learn More</h4>
			              <a href="/web/flask/flaskus" class="links">Home</a><br>
			              <a href="/flask-landing-page-portlet/features.jsp" class="links">Features</a><br>
			              <a href="#" class="links">Security</a><br>
		            </div>
		            <div class="col-sm-2">
			            <h4>Company</h4>
			              <a href="/flask-landing-page-portlet/aboutus.jsp" class="links">About Us</a><br>
			              <a href="#" class="links">Our Team</a><br>
			              <a href="#" class="links">Developer</a><br>
		            </div>
		            <div class="col-sm-2">
			            <h4>Community</h4>
			              <a href="/flask-landing-page-portlet/contactus.jsp" class="links">Contact Us</a><br>
			              <a href="#" class="links">Help Center</a><br>
			              <a href="#" class="links">Blog</a><br>
		            </div>
		            <div class="col-sm-2">
			            <h4>Terms</h4>
			              <a href="#" class="links">Legal</a><br>
			              <a href="#" class="links">Privacy</a><br>
		            </div>
	           </div><br>
            </div><br /><br /><br />  
        </div>
    </div>
</body>
</html>
