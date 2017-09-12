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
 
$.post("contact.php", $("#contact-form").serialize(),  function(response) {
$('#success').fadeIn().html(response);
$('#success').delay(2000).fadeOut();
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
		
 
});