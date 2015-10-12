
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/html/portlet/login/init.jsp" %>
<script type="text/javascript" src="/html/js/moment-with-locales.js"></script>
<script type="text/javascript" src="/html/js/jqxcore.js"></script>
<script type="text/javascript" src="/html/js/flask-registration-main.js"></script>
<script type="text/javascript" src="/html/js/combodate.js"></script>
<script type="text/javascript" src="/html/js/jqxvalidator.js"></script>
<script type="text/javascript" src="/html/js/jqxtree.js"></script>
<script type="text/javascript" src="/html/js/jqxcheckbox.js"></script>

<script type="text/javascript">


	// ************************************ APIS FOR FLASK
	// **************************************


</script>
<style>
<!--
.clearfix{*zoom:1}.clearfix:before,.clearfix:after{display:table;content:"";line-height:0}.clearfix:after{clear:both}.hide-text{font:0/0 a;color:transparent;text-shadow:none;background-color:transparent;border:0}.input-block-level{display:block;width:100%;min-height:30px;-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}.bootstrap-datetimepicker-widget{top:0;left:0;width:250px;padding:4px;margin-top:1px;z-index:3000;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}.bootstrap-datetimepicker-widget:before{content:'';display:inline-block;border-left:7px solid transparent;border-right:7px solid transparent;border-bottom:7px solid #ccc;border-bottom-color:rgba(0,0,0,0.2);position:absolute;top:-7px;left:6px}.bootstrap-datetimepicker-widget:after{content:'';display:inline-block;border-left:6px solid transparent;border-right:6px solid transparent;border-bottom:6px solid #fff;position:absolute;top:-6px;left:7px}.bootstrap-datetimepicker-widget.pull-right:before{left:auto;right:6px}.bootstrap-datetimepicker-widget.pull-right:after{left:auto;right:7px}.bootstrap-datetimepicker-widget>ul{list-style-type:none;margin:0}.bootstrap-datetimepicker-widget .timepicker-hour,.bootstrap-datetimepicker-widget .timepicker-minute,.bootstrap-datetimepicker-widget .timepicker-second{width:100%;font-weight:bold;font-size:1.2em}.bootstrap-datetimepicker-widget table[data-hour-format="12"] .separator{width:4px;padding:0;margin:0}.bootstrap-datetimepicker-widget .datepicker>div{display:none}.bootstrap-datetimepicker-widget .picker-switch{text-align:center}.bootstrap-datetimepicker-widget table{width:100%;margin:0}.bootstrap-datetimepicker-widget td,.bootstrap-datetimepicker-widget th{text-align:center;width:20px;height:20px;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}.bootstrap-datetimepicker-widget td.day:hover,.bootstrap-datetimepicker-widget td.hour:hover,.bootstrap-datetimepicker-widget td.minute:hover,.bootstrap-datetimepicker-widget td.second:hover{background:#eee;cursor:pointer}.bootstrap-datetimepicker-widget td.old,.bootstrap-datetimepicker-widget td.new{color:#999}.bootstrap-datetimepicker-widget td.active,.bootstrap-datetimepicker-widget td.active:hover{color:#fff;background-color:#F79634;background-image:-moz-linear-gradient(top,#F79634,#F79634);background-image:-webkit-gradient(linear,0 0,0 100%,from(#F79634),to(#F79634));background-image:-webkit-linear-gradient(top,#F79634,#F79634);background-image:-o-linear-gradient(top,#F79634,#F79634);background-image:linear-gradient(to bottom,#F79634,#F79634);background-repeat:repeat-x;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff0088cc',endColorstr='#F79634',GradientType=0);border-color:#F79634 #F79634 #002a80;border-color:rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);*background-color:#F79634;filter:progid:DXImageTransform.Microsoft.gradient(enabled = false);color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,0.25)}.bootstrap-datetimepicker-widget td.active:hover,.bootstrap-datetimepicker-widget td.active:hover:hover,.bootstrap-datetimepicker-widget td.active:active,.bootstrap-datetimepicker-widget td.active:hover:active,.bootstrap-datetimepicker-widget td.active.active,.bootstrap-datetimepicker-widget td.active:hover.active,.bootstrap-datetimepicker-widget td.active.disabled,.bootstrap-datetimepicker-widget td.active:hover.disabled,.bootstrap-datetimepicker-widget td.active[disabled],.bootstrap-datetimepicker-widget td.active:hover[disabled]{color:#fff;background-color:#F79634;*background-color:#003bb3}.bootstrap-datetimepicker-widget td.active:active,.bootstrap-datetimepicker-widget td.active:hover:active,.bootstrap-datetimepicker-widget td.active.active,.bootstrap-datetimepicker-widget td.active:hover.active{background-color:#039 \9}.bootstrap-datetimepicker-widget td.disabled,.bootstrap-datetimepicker-widget td.disabled:hover{background:0;color:#999;cursor:not-allowed}.bootstrap-datetimepicker-widget td span{display:block;width:47px;height:54px;line-height:54px;float:left;margin:2px;cursor:pointer;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}.bootstrap-datetimepicker-widget td span:hover{background:#eee}.bootstrap-datetimepicker-widget td span.active{color:#fff;background-color:#006dcc;background-image:-moz-linear-gradient(top,#F79634,#F79634);background-image:-webkit-gradient(linear,0 0,0 100%,from(#F79634),to(#F79634));background-image:-webkit-linear-gradient(top,#F79634,#F79634);background-image:-o-linear-gradient(top,#F79634,#F79634);background-image:linear-gradient(to bottom,#F79634,#F79634);background-repeat:repeat-x;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff0088cc',endColorstr='#ff0044cc',GradientType=0);border-color:#F79634 #F79634 #002a80;border-color:rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);*background-color:#F79634;filter:progid:DXImageTransform.Microsoft.gradient(enabled = false);color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,0.25)}.bootstrap-datetimepicker-widget td span.active:hover,.bootstrap-datetimepicker-widget td span.active:active,.bootstrap-datetimepicker-widget td span.active.active,.bootstrap-datetimepicker-widget td span.active.disabled,.bootstrap-datetimepicker-widget td span.active[disabled]{color:#fff;background-color:#F79634;*background-color:#003bb3}.bootstrap-datetimepicker-widget td span.active:active,.bootstrap-datetimepicker-widget td span.active.active{background-color:#039 \9}.bootstrap-datetimepicker-widget td span.old{color:#999}.bootstrap-datetimepicker-widget td span.disabled,.bootstrap-datetimepicker-widget td span.disabled:hover{background:0;color:#999;cursor:not-allowed}.bootstrap-datetimepicker-widget th.switch{width:145px}.bootstrap-datetimepicker-widget th.next,.bootstrap-datetimepicker-widget th.prev{font-size:21px}.bootstrap-datetimepicker-widget th.disabled,.bootstrap-datetimepicker-widget th.disabled:hover{background:0;color:#999;cursor:not-allowed}.bootstrap-datetimepicker-widget thead tr:first-child th{cursor:pointer}.bootstrap-datetimepicker-widget thead tr:first-child th:hover{background:#eee}.input-append.date .add-on i,.input-prepend.date .add-on i{display:block;cursor:pointer;width:16px;height:16px}.bootstrap-datetimepicker-widget.left-oriented:before{left:auto;right:6px}.bootstrap-datetimepicker-widget.left-oriented:after{left:auto;right:7px}
-->
</style>
<form id="adminForm">
  <div class="">
  <div class="">
   <div class="form-group">
     <label class="control-label" for="firstName">First Name:</label>
     <div class="controls">
       <input name="firstName" id="firstName" class="form-control" type="text">
     </div>
   </div>
   <div class="form-group">
     <label class="control-label" for="lastName">Last Name:</label>
     <div class="controls">
       <input name="lastName" id="lastName" class="form-control" type="text">
     </div>
   </div>
   
     <div class="">
   <div class="form-group update">
     <label class="control-label" for="screenName">Screen Name:</label>
     <div class="controls">
       <input name="screenName" id="screenName" class="form-control" type="text">
     </div>
   </div>
 
   <div class="form-group">
     <label class="control-label" for="email">E-mail:</label>
     <div class="controls">
       <input name="email" id="email" class="form-control" type="text">
     </div>
   </div>
 
   <div class="form-group">
     <label class="control-label" for="password1">Password:</label>
     <div class="controls">
       <input name="password1" id="password1" class="form-control" type="password">
     </div>
   </div>
   
   <div class="form-group">
     <label class="control-label" for="password2">Confirm Password:</label>
     <div class="controls">
       <input name="password2" id="password2" class="form-control" type="password">
     </div>
   </div> 
   
  <div class="">
   <div class="form-group update">
     <label class="control-label" for="streetName">Street:</label>
     <div class="controls">
       <input name="streetName" id="streetName" class="form-control" type="text">
     </div>
   </div>
   
   <div class="form-group update">
     <label class="control-label" for="aptNo">Apartment#:</label>
     <div class="controls">
       <input name="aptNo" id="aptNo" class="form-control" type="text">
     </div>
   </div>  
   
    <div class="form-group">
     <label class="control-label" for="areaCode">Zip Code:</label>
     <div class="controls">
       <input name="areaCode" id="areaCode" class="form-control" type="text">
     </div>
   </div>
   
    <div class="form-group update">
     <label class="control-label" for="city">City:</label>
     <div class="controls">
       <input name="city" id="city" class="form-control" type="text">
     </div>
   </div>  
   
    <div class="form-group update">
     <label class="control-label" for="stateId">State:</label>
     <div class="controls">
       <select id="stateId" name="stateId" class="form-control-select"></select>
     </div>
   </div>  
     
   <div class="form-group update">
     <label class="control-label" for="countryId">Country:</label>
     <div class="controls">
       <select id="countryId" name="countryId" class="form-control-select" ></select>
     </div>
   </div>  
  </div>
   <div class="form-group">
      <label class="control-label" for="gender">Gender:</label>
      <div class="controls">
        <input name="gender" type="radio" value="Male" checked>Male
     <input name="gender" type="radio" value="Female">Female
      </div>
  </div>
   
   <div class="form-group">
  <label class="control-label" for="DOB">Date of Birth:</label>
  <div class="controls">
   <input name="DOB" id="DOB" type="hidden" class="form-control" value="" data-format="MM-DD-YYYY" data-template="MMM D YYYY">
  </div>
   </div>  
  </div>
   
   <div class="form-group">
     <label class="control-label" for="mobileNumber">Mobile:</label>
     <div class="controls">
       <input name="mobileNumber" id="mobileNumber" class="form-control" type="text">
     </div>
   </div>    
  </div>
</div>
<div class="form-group update">
    
 <div class="row-fluid">
 <h4><span>Preferences</span></h4>
 <div class="row-fluid">
 <div style="border: none;" class="userInterests span4">
  <ul>
         <li item-expanded='true' id="sports">Sports
           <ul>
           		   <li id="sports-pro-basketball">Basketball</li>
                   <li id="sports-pro-basebball">Basebball</li>
                   <li id="sports-pro-football">Football</li>
                   <li id="sports-pro-hockey">Hockey</li>
                   <li id="sports-pro-soccer">Soccer</li>
                   <li id="sports-pro-tennis">Tennis</li>
          </ul>
   </li>
  </ul>
 </div>
 <div style="border: none;" class="userInterests span4">
  <ul>
         <li item-expanded='true' id="sports">Level
           <ul>
                 <li id="sports-pro">Professional</li>
                 <li id="sports-col">College</li>
           </ul>
   </li>
  </ul>
 </div>
 </div>
 <div class="row-fluid">
 <div style="border: none;" class="userInterests span4">
  <ul>   
         <li item-expanded='true' id="concerts">Concerts
             <ul>
                 <li  id="concerts-country">Country</li>
                 <li id="concerts-pop">Pop</li>
                 <li id="concerts-rock">Rock</li>
                 <li id="concerts-rap">Rap</li>
                 <li id="concerts-alternative">Alternative</li>
                 <li id="concerts-electronic">Electronic</li>
             </ul>
         </li>
  </ul>
 </div>
 <div style="border: none;" class="userInterests span4">   
  <ul>         
         <li item-expanded='true' id="special-events">
          Special Events
          <ul><li id="special-events-comedy">Comedy</li></ul>
         </li>
     </ul>   
 </div> 
 </div>
 </div>
</div>
 
  <input class="btn btn-info cssSave" type="button" value="Save"/>
  <input class="btn btn-primary cssCancel" type="button" value="Cancel" >
  <input id="userId" type="hidden" value="0">
  <input name="middleName" id="middleName" type="hidden">
</form>

