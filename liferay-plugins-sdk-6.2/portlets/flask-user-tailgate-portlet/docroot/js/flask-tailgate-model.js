var _tailgateModel = {};


_tailgateModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_TAILGATE 				:"/flask-user-tailgate-portlet.tailgateinfo/get-tailgate",
	GET_ALL_MY_TAILGATE			:"/flask-user-tailgate-portlet.tailgateinfo/get-all-my-tailgate",
	ADD_TAILGATE 				:"/flask-user-tailgate-portlet.tailgateinfo/add-tailgate-info",
	ADD_EVENT_IMAGE				:"/flask-rest-events-portlet.event/add-event-image",
	UPDATE_TAILGATE				:"/flask-user-tailgate-portlet.tailgateinfo/update-tailgate-info",
	DELETE_TAILGATE				:"/flask-user-tailgate-portlet.tailgateinfo/delete-tailgate-info",
	GET_ALL_TAILGATES			:"/flask-user-tailgate-portlet.tailgateinfo/get-all-tailgate",
	GET_TAILGATE_GROUPS			:"/flask-user-tailgate-portlet.tailgateusers/get-tailgate-groups",
	GET_TAILGATE_MEMBERS	 	:"/flask-user-tailgate-portlet.tailgateusers/get-tailgate-members",
	ADD_TAILGATE_USER			:"/flask-user-tailgate-portlet.tailgateusers/add-tailgate-user",
	DELETE_TAILGATE_USER		:"/flask-user-tailgate-portlet.tailgateusers/delete-tailgate-user",
	GET_ALL_EVENTS              :"/flask-rest-events-portlet.event/get-all-events",
	GET_ALL_USERS				:"/flask-social-portlet.entry/search-my-friends",
	GET_ALL_GROUPS 				:"/flask-manage-user-group-portlet.flaskgroup/get-all-groups",
	GET_ALL_GROUP_USER			:"/flask-manage-user-group-portlet.flaskgroupusers/get-all-group-users",
	GET_VENUE					:"/flask-rest-events-portlet.venue/get-venue",
	GET_ALL_TAILGATE_IMAGES		:"/flask-user-tailgate-portlet.tailgateimages/get-tailgate-images",
	UPDATE_IMAGES_DETAIL		:"/flask-user-tailgate-portlet.tailgateimages/update-tailgate-image",
	DELETE_TAILGATE_IMAGE		:"/flask-user-tailgate-portlet.tailgateimages/delete-tailgate-image-by-tailgate-image-id"	
};

_tailgateModel.DATA_MODEL= {
	TAILGATE: 
		[
		 	 { name: 'tailgateId', type: 'long' },
		 	 { name: 'tailgateName', type: 'string' },
		 	 { name: 'tailgateDescription', type: 'string' },
		 	 { name: 'eventId', type: 'long' },
		 	 { name: 'eventName', type:'string'},
		 	 { name: 'tailgateDate', type: 'string' },
		 	 { name: 'startTime', type: 'string' },
		 	 { name: 'endTime', type: 'string' },
		 	 { name: 'eventImage', type: 'string' },
		 	 { name: 'tailgateRole', type: 'string' },
		 	 { name: 'isActive', type: 'int'},
			 { name: 'isDelete', type: 'int'},
			 { name: 'isAdmin', type: 'int'}
		]
	};

_tailgateModel.GRID_CONTEXT_MENU = {
		EVENT:function(row, columnfield, value, defaulthtml, columnproperties) {
			return '<i class="icon-wrench" style="margin:3px;"></i>'
		}
}

_tailgateModel.GRID_DATA_MODEL= {
		TAILGATE: 
			[{ text: 'Name', columntype: 'textbox',  datafield: 'tailgateName', width: '45%' },
      		 {text: 'Description', datafield: 'tailgateDescription', width: '45%'},
      		 { text: 'Edit',  datafield: 'eventId', width: '10%', cellsalign: 'center', cellsrenderer: _tailgateModel.GRID_CONTEXT_MENU.EVENT }]
		};

_tailgateModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Tailgate successfully added",
		SAVE: "Tailgate successfully saved",
		ERROR: "There was an error in saving User Tailgate",
		DEL_SUCCESS: "Tailgate successfully deleted",
		DEL_ERR: "Error in deleting Tailgate",
		ADD_EVENT_FIRST_ERR: "Please save Tailgate first",
		IMAGE_UPLOAD_SUCCESS: "Images uploaded successfully",
		IMAGE_UPLOAD_ERROR: "There was an error while saving images"
 };
_tailgateModel.allGroupDetails = [];
_tailgateModel.allMemberDetails = [];
_tailgateModel.userId;
_tailgateModel.userName;
