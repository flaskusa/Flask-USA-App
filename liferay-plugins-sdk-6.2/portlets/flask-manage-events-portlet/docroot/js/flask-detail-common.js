var _flaskDetailCommon = {};

_flaskDetailCommon.SERVICE_ENDPOINTS = {
		API_PREFIX					:"/api/jsonws",
		GET_INFO_TYPES 				: "/flask-rest-events-portlet.infotype/get-info-types",
		GET_INFO_CATEGORY 			: "/flask-rest-events-portlet.infotypecategory/get-info-type-categories"
	};

_flaskDetailCommon.infoCategoryJSON = null;

_flaskDetailCommon.loadContentType = function(elementId,selectedId, selectedInfoType) {

	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskDetailCommon.SERVICE_ENDPOINTS.GET_INFO_CATEGORY , {},
					function(data) {
							_flaskDetailCommon.infoCategoryJSON = data;
							_flaskDetailCommon.setContentType(elementId,selectedId, selectedInfoType, data)
					} ,
					function(data) {
						console.log("Error in getting content types: " + data );
					});
}
_flaskDetailCommon.setContentType = function(elementId,selectedId, selectedInfoType, data) {
	var selectList = $('#' + elementId);
	selectList.empty();
	$.each(data, function(key, Content) {
		if ( Content.infoTypeId == selectedInfoType || (selectedInfoType == null && Content.infoTypeId == 1)) {
			selectList.append($("<option/>", {
				value: Content.infoTypeCategoryId,
				text: Content.infoTypeCategoryName
			}));
		}
	});
	if (selectedId != null) {
		selectList.val(selectedId);
	}
	selectList.change();
}


_flaskDetailCommon.loadInfoType = function(elementId,selectedId) {
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskDetailCommon.SERVICE_ENDPOINTS.GET_INFO_TYPES , {},
					function(data) {
							selectList.empty();
							selectList.append($("<option/>", {
								value: 0,
								text: '-Select content type-'
							}));
							$.each(data, function(key, Content) {
								selectList.append($("<option/>", {
									value: Content.infoTypeId,
									text: Content.infoTypeName
								}));
							});
							selectList.val(selectedId);
							selectList.change();
					} ,
					function(data) {
						console.log("Error in getting infotype types: " + data );
					});

}