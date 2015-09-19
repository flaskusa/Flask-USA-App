var _socialModel = {};

_socialModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
    GET_ALL_CONTACTS			:"/flask-social-portlet.entry/search-users-and-contacts",
    GET_MY_FRIENDS				:"/flask-social-portlet.entry/search-my-friends",
    SEND_REQUEST				:"/flask-social-portlet.entry/request-social-relation",
    UNFRIEND					:"/flask-social-portlet.entry/delete-social-relation",
    BLOCKPERSON					:"/flask-social-portlet.entry/block-user",
    UNBLOCKPERSON				:"/flask-social-portlet.entry/unblock-user",
    GET_REQUESTS				:"/flask-social-portlet.entry/get-requests-to-confirm",
    GET_USER_DETAILS			:"/flask-rest-users-portlet.flaskadmin/get-user-by-id",
    ACCEPT_REQUEST				:"/flask-social-portlet.entry/add-social-relation",
    DELETE_REQUEST				:"/flask-social-portlet.entry/delete-request"
};

_socialModel.MESSAGES = {
		SEARCH_ERR 		:"No contacts found",
		SEND_REQ_ERR	:"Can not send friend request",
		UNFRIEND_ERR	:"Can not unfriend"
}
