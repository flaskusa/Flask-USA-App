//Class Resposne 
function Response(){
	this.responseStatus = 0;
	this.responseJson;
}
// Methods of response
Response.prototype.setResponseStatus = function(statusCode){
	this.responseStatus = statusCode;
}
Response.prototype.setResponseJson = function(json){
	this.responseJson = json;
}
Response.prototype.getResponseStatus = function(){
	return this.responseStatus;
}
Response.prototype.getResponseJson = function(){
	return this.responseJson;
}
//Class Request
function Request(){
}

Request.prototype.sendGETRequest = function(url, params, succcessHandler, failureHandler){
	var resObj = new Response();
	var headerData = {};
	resObj.responseJson = "";
	try{
		Liferay.Service(url, params,function(obj) {
			if(typeof obj != "object"){
				if(failureHandler){
					failureHandler(obj);
				}else{
					console.log("sendGETRequest faliled:" + obj);
				}
				
			}else{
				 if(typeof succcessHandler != undefined){
					 succcessHandler(obj)
				 }else{
					 console.log("sendGETRequest success:" + obj);
				 }
				
			}	
		});
	}catch(ex){
		console.log(ex.message);
	}

	
}
Request.prototype.sendPOSTRequest = function(url, params, succcessHandler, failureHandler){
	var resObj = new Response();
	resObj.responseJson = "";
	try{
		Liferay.Service(url, params,function(obj) {
			if(typeof obj != "object"){
				if(failureHandler){
					failureHandler(obj);
				}else{
					console.log("sendGETRequest faliled:" + obj);
				}
				
			}else{
				 if(typeof succcessHandler != undefined){
					 succcessHandler(obj)
				 }else{
					 console.log("sendGETRequest success:" + obj);
				 }
				
			}	
		});
	}catch(ex){
		console.log(ex.message);
	}

}

function responseHandler(msg){
	console.log(msg);
	return false;
}