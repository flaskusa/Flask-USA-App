  $(document).ready(function() {
    (function() {
		$(".logo").hide();
		$(".login_button").hide();
        [].slice.call(document.querySelectorAll('.tabs')).forEach(function(el) {
            new CBPFWTabs(el);
        });
    })();
	
    $('#main-nav').sidr();
    $('#fullpage').fullpage({
        'verticalCentered': true,
        'easing': 'easeInOutCirc',
        'css3': false,
        'scrollingSpeed': 1000,
        'slidesNavigation': true,
        'slidesNavPosition': 'bottom',
        'easingcss3': 'ease',
        'navigation': true,
        'anchors': ['Home', 'Features', 'About', 'Screenshots', 'Download', 'Contact', 'Map'],
        'navigationPosition': 'left'
    });
    $('.screenshots-content, .clients-content').css('height', $(window).height());

    // CONTACT FORM

  
       $(document).mouseup(function (e) {
    if ($(".sidr-open ")[0]){
    var container = $("#sidr");

    if (!container.is(e.target) // if the target of the click isn't the container...
        && container.has(e.target).length === 0) // ... nor a descendant of the container
    {
      $(".sidr-open #main-nav").click();
    }}
});
 
 
$('#submit').click(function(){
    alert("https://www.flask-usa.com/api/jsonws/flask-rest-users-portlet.flaskadmin/contact-us/name/"+$("#name").val()+"/email-address/"+$("#email").val()+"/phone-number/"+$("#phone").val()+"/subject/"+$("#subject").val()+"/message/"+$("#message").val());
    $.post("https://www.flask-usa.com/api/jsonws/flask-rest-users-portlet.flaskadmin/contact-us/name/"+$("#name").val()+"/email-address/"+$("#email").val()+"/phone-number/"+$("#phone").val()+"/subject/"+$("#subject").val()+"/message/"+$("#message").val(),  function(response) {
        if(response==true){
            //$('#success').attr('display','block');
            $('#success').show();
            //$('#success').fadeIn().html(response);
            //$('#success').delay(2000).fadeOut();
        }
    });
    return false; 
});


});
  
setTimeout(function(){  
    $('#preloader').fadeOut();
    $('.preloader_img').delay(150).fadeOut('slow');
	$(".logo").show();
	$(".login_button").show();
}, 2000);

function gotoFlask(){
	location.href = "/web/flask/events";
}
$(".downloadapp").click(function(){
	
var agent = navigator.userAgent;
if(agent.indexOf("iPhone") > -1) {
	location.href = "https://itunes.apple.com/us/app/flaskusa/id1268927425?ls=1&mt=8";
} else if(agent.indexOf("Android") > -1) {
	location.href = "https://play.google.com/store/apps/details?id=com.flaskusa.tailgate";
}
else{
location.href = "https://itunes.apple.com/us/app/flaskusa/id1268927425?ls=1&mt=8";
}	
		
 
});
$(".downloadandroidapp").click(function(){
	
var agent = navigator.userAgent;
if(agent.indexOf("iPhone") > -1) {
	location.href = "https://itunes.apple.com/us/app/flaskusa/id1268927425?ls=1&mt=8";
} else if(agent.indexOf("Android") > -1) {
	location.href = "https://play.google.com/store/apps/details?id=com.flaskusa.tailgate";
}
else{
location.href = "https://play.google.com/store/apps/details?id=com.flaskusa.tailgate";
}	

function sendMail() {
    $.ajax({
      type: 'POST',
      url: 'https://www.flask-usa.com/api/jsonws/flask-rest-users-portlet.flaskadmin/contact-us',
      data: {
        'key': 'YOUR API KEY HERE',
        'message': {
          'from_email': 'YOUR@EMAIL.HERE',
          'to': [
              {
                'email': 'RECIPIENT@EMAIL.HERE',
                'name': 'RECIPIENT NAME (OPTIONAL)',
                'type': 'to'
              }
            ],
          'autotext': 'true',
          'subject': 'YOUR SUBJECT HERE!',
          'html': 'YOUR EMAIL CONTENT HERE! YOU CAN USE HTML!'
        }
      }
     }).done(function(response) {
       console.log(response); // on success
     });
} 
});