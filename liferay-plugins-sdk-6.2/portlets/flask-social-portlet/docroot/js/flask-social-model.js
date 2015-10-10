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
    GET_USER_DETAILS			:"/flask-social-portlet.entry/get-user-by-id",
    ACCEPT_REQUEST				:"/flask-social-portlet.entry/add-social-relation",
    DELETE_REQUEST				:"/flask-social-portlet.entry/delete-request",
    SEND_MESSAGE    			:"/flask-social-portlet.flaskmessages/send-flask-message",
    GET_UNREAD_MESSAGES   		:"/flask-social-portlet.flaskmessages/get-my-unread-flask-messages",
    GET_My_ALL_MESSAGES   		:"/flask-social-portlet.flaskmessages/get-all-my-flask-messages",
    SET_READ					:"/flask-social-portlet.flaskrecipients/set-read",
    DELETE_MESSAGE				:"/flask-social-portlet.flaskmessages/delete-message"
};

_socialModel.MESSAGES = {
		SEARCH_ERR 		:"No contacts found",
		SEND_REQ_ERR	:"Can not send friend request",
		UNFRIEND_ERR	:"Can not unfriend"
}
