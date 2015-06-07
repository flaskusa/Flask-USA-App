
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/html/portlet/login/init.jsp" %>
<script type="text/javascript" src="/html/js/validate1.js"></script>
<script type="text/javascript" src="/html/js/Flask-lib.js"></script>
<script type="text/javascript" src="/html/js/jqx-all.js"></script>

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
     <label class="control-label" for="middleName">Middle Name:</label>
     <div class="controls">
       <input name="middleName" id="middleName" class="form-control" type="text">
     </div>
   </div>
 
   <div class="form-group">
     <label class="control-label" for="lastName">Last Name:</label>
     <div class="controls">
       <input name="lastName" id="lastName" class="form-control" type="text">
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
   <div id="DOB"></div>
  </div>
   </div>  
  </div>
  <div class="">
   <div class="form-group">
     <label class="control-label" for="streetName">Street:</label>
     <div class="controls">
       <input name="streetName" id="streetName" class="form-control" type="text">
     </div>
   </div>
   
   <div class="form-group">
     <label class="control-label" for="aptNo">Apartment#:</label>
     <div class="controls">
       <input name="aptNo" id="aptNo" class="form-control" type="text">
     </div>
   </div>  
   
    <div class="form-group">
     <label class="control-label" for="areaCode">Area Code:</label>
     <div class="controls">
       <input name="areaCode" id="areaCode" class="form-control" type="text">
     </div>
   </div>
   
    <div class="form-group">
     <label class="control-label" for="city">City:</label>
     <div class="controls">
       <input name="city" id="city" class="form-control" type="text">
     </div>
   </div>  
   
    <div class="form-group">
     <label class="control-label" for="stateId">State:</label>
     <div class="controls">
       <select id="stateId" name="stateId" class="form-control"></select>
     </div>
   </div>  
     
   <div class="form-group">
     <label class="control-label" for="countryId">Country:</label>
     <div class="controls">
       <select id="countryId" name="countryId" class="form-control" ></select>
     </div>
   </div>  
  </div>
  <div class="">
   <div class="form-group">
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
   
   <div class="form-group">
     <label class="control-label" for="mobileNumber">Mobile:</label>
     <div class="controls">
       <input name="mobileNumber" id="mobileNumber" class="form-control" type="text">
     </div>
   </div>    
  </div>
</div>
<div class="form-group">
    
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
                 <li id="concerts-pop">POP</li>
                 <li id="concerts-rock">ROCK</li>
                 <li id="concerts-rap">RAP</li>
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
 
  <input class="btn btn-info clsSave" type="button" value="Save" onclick="fnSave()" onload="fnupdate(uid)" />
  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
  <input id="userId" type="hidden" value="0">
</form>

