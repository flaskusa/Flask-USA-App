var _socialModel = {};

_socialModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
    GET_ALL_CONTACTS			:"/flask-social-portlet.entry/search-users-and-contacts",
    SEND_REQUEST				:"/flask-social-portlet.entry/request-social-relation",
    UNFRIEND					:"/flask-social-portlet.entry/delete-social-relation"    	
};

_socialModel.MESSAGES = {
		SEARCH_ERR 		:"No contacts found",
		SEND_REQ_ERR	:"Can not send friend request",
		UNFRIEND_ERR	:"Can not unfriend"
}
