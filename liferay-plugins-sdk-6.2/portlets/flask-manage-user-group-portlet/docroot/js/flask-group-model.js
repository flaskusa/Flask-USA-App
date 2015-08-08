var _groupModel = {};

_groupModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_ALL_GROUPS 				: "/flask-manage-user-group-portlet.flaskgroup/get-all-groups",
	GET_PARTICIPATING_GROUPS 	: "/flask-manage-user-group-portlet.flaskgroup/get-participating-groups",
	GET_ALL_MY_GROUPS 			: "/flask-manage-user-group-portlet.flaskgroup/get-all-my-groups",
	GET_MY_GROUPS 				: "/flask-manage-user-group-portlet.flaskgroup/get-my-groups",
	GET_GROUP 					: "/flask-manage-user-group-portlet.flaskgroup/get-group",
	ADD_GROUP 					: "/flask-manage-user-group-portlet.flaskgroup/add-group",
	UPDATE_GROUP				: "/flask-manage-user-group-portlet.flaskgroup/update-group",
	DELETE_GROUP				: "/flask-manage-user-group-portlet.flaskgroup/delete-group",
	DELETE_GROUPS				: "/flask-manage-user-group-portlet.flaskgroup/delete-groups",
	ADD_GROUP_USER				: "/flask-manage-user-group-portlet.flaskgroupusers/add-group-user",
	ADD_GROUP_OWNER				: "/flask-manage-user-group-portlet.flaskgroupusers/add-group-owner",
	DELETE_GROUP_USER			: "/flask-manage-user-group-portlet.flaskgroupusers/delete-group-user",
	DELETE_GROUP_USERS			: "/flask-manage-user-group-portlet.flaskgroupusers/delete-group-users",
	GET_ALL_GROUP_USERS			: "/flask-manage-user-group-portlet.flaskgroupusers/get-all-group-users",
	UPDATE_GROUP_USER			: "/flask-manage-user-group-portlet.flaskgroupusers/update-group-user",
	GET_ALL_USERS				: "/flask-rest-users-portlet.flaskadmin/get-flask-admins"
};

_groupModel.DATA_MODEL= {
	GROUP: 
		[
             { name: 'groupId', type: 'long', fieldName : 'Group Id' },
			 { name: 'groupName', type: 'string', fieldName : 'Group Name' },
			 { name: 'groupDescription', type: 'string', fieldName : 'Group Description' },
			 { name: 'createdBy', type: 'string', fieldName : 'Group Created By' },
			 { name: 'createdDate', type: 'string', fieldName : 'Group Created Date' },
			 { name: 'isActive', type: 'int', fieldName : 'Is Group Activated' },
			 { name: 'isDelete', type: 'int', fieldName : 'Is Group Deleted' },
			 { name: 'isAdmin', type: 'int', fieldName : 'Is User Admin' },
			 { name: 'isGroupAdmin', type: 'int', fieldName : 'Is User Admin' },
			 { name: 'userId', type: 'int', fieldName : 'User Id' },
			 { name: 'userName', type: 'string', fieldName : 'User Name' }
			 
		],
		GROUP_USERS: 
			[
			    { name: 'groupOwnerId', type: 'long', fieldName : 'Group User Id' },
				 { name: 'groupId', type: 'string', fieldName : 'Group Id' },
				 { name: 'userId', type: 'string', fieldName : 'User Id' },
				 { name: 'userName', type: 'string', fieldName : 'User Name' },
				 { name: 'isAdmin', type: 'int', fieldName : 'Is User Admin' }
			]
	};




_groupModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD_GROUP: "Group successfully added",
		SAVE_GROUP: "Group successfully saved",
		ERR_GROUP: "There was an error in saving group",
		DEL_SUCCESS_GROUP: "Group successfully deleted",
		DEL_ERR_GROUP: "Error in deleting group",
		ADD_GRP_USER: "Group user successfully added",
		SAVE_GRP_USER: "Group user successfully saved",
		ERR_GRP_USER: "There was an error in saving group user",
		DEL_SUCCESS_GRP_USER: "Group user successfully deleted",
		DEL_ERR_GRP_USER: "Error in deleting group user"
 };
_groupModel.groupDetail = [];