var _infoTypeRenderer = {};
var ids = ["default","Galaxy_s7","iphone_7"];
var aspectRatios = ["3:4","9:16","9:16"];
var pIds = ["parking"];
var pAspectRatios = ["2:3"];
_infoTypeRenderer.getRenderer = function(type) {
	type = type.toLowerCase();
	var renderer;
	switch (type) {
	case "tradition":
		renderer = _infoTypeRenderer.INFO_RENDERER.TRADITION;
		break;
	case "parking":
		renderer = _infoTypeRenderer.INFO_RENDERER.PARKING;
		break;
	case "bar & restaurants":
	case "hotels":
		renderer = _infoTypeRenderer.INFO_RENDERER.BAR_AND_RESTO;
		break;
	case "nightlife":
		renderer = _infoTypeRenderer.INFO_RENDERER.FOOD;
		break;
	case "safety":
		renderer = _infoTypeRenderer.INFO_RENDERER.SAFETY;
		break;
	case "liquor store":
		renderer = _infoTypeRenderer.INFO_RENDERER.LIQUOR;
		break;
	case "getting home":
		renderer = _infoTypeRenderer.INFO_RENDERER.GETTING_HOME;
		break;
	case "tickets":
		renderer = _infoTypeRenderer.INFO_RENDERER.TICKETS;
		break;
	case "traffic":
		renderer = _infoTypeRenderer.INFO_RENDERER.TRAFFIC;
		break;
	case "venue info":
		renderer = _infoTypeRenderer.INFO_RENDERER.VENUE_INFO;
		break;
	case "venue map":
		renderer = _infoTypeRenderer.INFO_RENDERER.VENUE_MAP;
		break;
	case "supplies":
	case "flask us":
	default:
		renderer = _infoTypeRenderer.INFO_RENDERER.GENERAL;
		break;
	}
	return renderer;
}

_infoTypeRenderer.fnRenderForm = function(contentType, Type) {
	var obj = _infoTypeRenderer.getRenderer(contentType);
	_infoTypeRenderer.fnBuildHtml(obj, Type, contentType);
	if ($("#eventDetailId").val() > 0) {

	}
	$("#premiumDisplayEnabled").on('click',function() {
	    if ($(this).is(':checked')) {
	        $("#premiumDisplayEnabled").val("1");
	        $("#uploadMapLogo").attr("style","display:block;");
	    } else {
	        $("#premiumDisplayEnabled").val("0");
	        $("#uploadMapLogo").attr("style","display:none;");
	    }
	});
}

_infoTypeRenderer.fnBuildHtml = function(Obj, Type, contentType) {
	var items = Obj.filter(function(item) {
		switch (item.type) {
		case "text":
			return _infoTypeRenderer.fnBuildInput(item.attr);
			break;
		case "select":
			return _infoTypeRenderer.fnBuildSelect(item.attr);
			break;
		case "boolean":
			return _infoTypeRenderer.fnBuildBoolean(item.attr);
			break;
		case "checkbox":
			return _infoTypeRenderer.fnBuildChecked(item.attr);
			break;
		case "editor":
			return _infoTypeRenderer.fnBuildEditor(item.attr);
			break;
		case "subdetails":
			return _infoTypeRenderer.fnBuildSubDetails(item.attr, contentType);
			break;
		case "upload":
			return _infoTypeRenderer.fnBuildUpload(item.attr, Type);
			break;
		default:
			console.log("Nothing selected");
		}
	});
}

_infoTypeRenderer.fnBuildInput = function(Obj) {
	var objFormGroup = $('<div/>', {
		'class' : 'form-group'
	}).appendTo($(formArea));
	var objControlLable = $('<label/>', {
		'class' : 'control-label',
		'for' : Obj[0].id
	}).appendTo(objFormGroup);
	$(objControlLable).html(Obj[0].caption);
	var objControls = $('<div/>', {
		'class' : 'controls'
	}).appendTo(objFormGroup);
	$('<input/>', {
		'type' : 'Text',
		'id' : Obj[0].id,
		'value' : Obj[0].value,
		'placeholder' : Obj[0].placeholder,
		'maxlength' : Obj[0].maxlength
	}).appendTo(objControls);
}

_infoTypeRenderer.fnBuildBoolean = function(Obj) {
	var strSelected = "";
	var objFormGroup = $('<div/>', {
		'class' : 'form-group'
	}).appendTo($(formArea));
	var objControlLable = $('<label/>', {
		'class' : 'control-label',
		'for' : Obj[0].id
	}).appendTo(objFormGroup);
	$(objControlLable).html(Obj[0].caption);
	var objControls = $('<div/>', {
		'class' : 'controls'
	}).appendTo(objFormGroup);
	for (var iCount = 0; iCount < Obj[0].items.length; iCount++) {
		if (Obj[0].items[0].value == Obj[0].value)
			strSelected = "selected"
		else
			strSelected = ""

		$('<input/>', {
			'type' : 'radio',
			'id' : Obj[0].id,
			'name' : Obj[0].name,
			'value' : Obj[0].value,
			'Selected' : strSelected
		}).appendTo(objControls);
		var objItemCaptionLable = $('<span/>', {
			'class' : 'control-label'
		}).appendTo(objControls);
		$(objItemCaptionLable).html(Obj[0].items[iCount]);
	}
}

_infoTypeRenderer.fnBuildChecked = function(Obj) {
	var strSelected = "";
	var objFormGroup = $('<div/>', {
		'class' : 'form-group'
	}).appendTo($(formArea));
	var objControlLable = $('<label/>', {
		'class' : 'control-label',
		'for' : Obj[0].id
	}).appendTo(objFormGroup);
	$(objControlLable).html(Obj[0].caption);
	var objControls = $('<div/>', {
		'class' : 'controls'
	}).appendTo(objFormGroup);
	$('<input/>', {
		'type' : 'checkbox',
		'id' : Obj[0].id,
		'name' : Obj[0].name,
		'value' : Obj[0].value,
		'checked' : Obj[0].checked
	}).appendTo(objControls);
	var objItemCaptionLable = $('<span/>', {
		'class' : 'control-label'
	}).appendTo(objControls);
}

_infoTypeRenderer.fnBuildUpload = function(Obj, Type) {
	var dropLength = 1;
	var strSelected = "";
	var venuImageId ="";
	var deviceTypeId ="";
	var aspectRatioId ="";
	dropZone = "";
	dropZone0 = "";
	dropZone1 = "";
	dropZone2 = "";
	var myclass = "form-group " +Obj[0].Class+ " uploader";
	if(Obj[0].caption == "Upload Pictures" || Obj[0].caption == "Upload Logo"){
		dropLength = 1;
	}else{
		dropLength = Obj[0].caption.length;
	}
	for(var i = 0; i < dropLength; i++){
		var action = "";
		var caption = "";
		var id = "";
		var aspectRatio = "";
		if(dropLength == 1 || Obj[0].caption == "Upload Logo"){
			caption = Obj[0].caption;
			if(Obj[0].aspectRatio != "Upload Logo"){
				var urlid = $("#imgActionUrl_"+Obj[0].caption);
				action = urlid.val();
				id = Obj[0].id;
				aspectRatio = Obj[0].aspectRatio;
				venuImageId ='venueImages'+i;
				caption = "Upload map logo";
			}else{
				action = $("#imgActionUrl").val();
				id = "";
				aspectRatio = "";
				venuImageId ='venueImages';
			}
			venueDetailId = '_venueDetailId';
			deviceTypeId = '_deviceType';
			aspectRatioId = '_aspectRatio';
		}else{
			action = $("#imgActionUrl_"+Obj[0].caption[i]).val();
			caption = Obj[0].caption[i];
			id = Obj[0].id[i];
			aspectRatio = Obj[0].aspectRatio[i];
			venuImageId ='venueImages'+i;
			venueDetailId = '_venueDetailId';
			deviceTypeId = '_deviceType';
			aspectRatioId = '_aspectRatio';
		}
		if(Obj[0].caption == "Upload Logo"){
			var objFormGroup = $('<div/>', {
				'class' : myclass,
				id: 'uploadMapLogo',
				style: 'display:none;'
			}).appendTo($(formArea));
		}else{
			var objFormGroup = $('<div/>', {
				'class' : myclass,
				id: 'uploader'
			}).appendTo($(formArea));
		}		
		var objControlLable = $('<label/>', {
			'class' : 'control-label',
			'for' : caption
		}).appendTo(objFormGroup);
		$(objControlLable).html(caption);
		var objControls = $('<div/>', {
			'class' : 'controls'
		}).appendTo(objFormGroup);
		switch (Type) {
		case "event":
			var objForm = $('<form/>', {
				'class' : 'dropzone',
				'id' : 'eventImages',
				'action' : action
			}).appendTo(objFormGroup);
			$(objForm).appendTo(objControls);
			var objEventDetailId = $('<input/>', {
				'name' : '_eventDetailId',
				'id' : '_eventDetailId',
				'type' : 'hidden',
				'value' : '0'
			});
			$(objEventDetailId).appendTo(objForm);
			var objEventId = $('<input/>', {
				'name' : '_eventId',
				'id' : '_eventId',
				'type' : 'hidden',
				'value' : $("#eventId").val()
			});
			$(objEventId).appendTo(objForm);
			var objAspectRatio = $('<input/>', {
				'name' : aspectRatioId,
				'id' : aspectRatioId,
				'type' : 'hidden',
				'class':'aspectRatioMapLogo',
				'value' : aspectRatio
			});
			$(objAspectRatio).appendTo(objForm);
			break;
		case "venue":
			var objForm = $('<form/>', {
				'class' : 'dropzone',
				'id' : venuImageId,
				'action' : action
			}).appendTo(objControls);
			var objvenueDetailId = $('<input/>', {
				'name' : venueDetailId,
				'id' : venueDetailId,
				'class' : venueDetailId,
				'type' : 'hidden',
				'value' : $("#venueDetailId").val()
			});
			$(objvenueDetailId).appendTo(objForm);
			var objVenueId = $('<input/>', {
				'name' : '_venueId',
				'id' : '_venueId',
				'type' : 'hidden',
				'value' : $("#venueId").val()
			});
			$(objVenueId).appendTo(objForm);
			var objDeviceType = $('<input/>', {
				'name' : deviceTypeId,
				'id' : deviceTypeId,
				'type' : 'hidden',
				'class':'deviceType',
				'value' : id
			});
			$(objDeviceType).appendTo(objForm);
			var objAspectRatio = $('<input/>', {
				'name' : aspectRatioId,
				'id' : aspectRatioId,
				'type' : 'hidden',
				'class':'aspectRatio',
				'value' : aspectRatio
			});
			$(objAspectRatio).appendTo(objForm);
			var objDynamicDiv = $('<span/>', {
				'id' : id+"Gallery",
			}).appendTo(objFormGroup);
			$(objDynamicDiv).appendTo(objControls);
			break;
		default:
			var objForm = $('<form/>', {
				'class' : 'dropzone',
				'id' : 'eventImages',
				'action' : action
			}).appendTo(objFormGroup);
			$(objForm).appendTo(objControls);
			var objEventDetailId = $('<input/>', {
				'name' : '_eventDetailId',
				'id' : '_eventDetailId',
				'type' : 'hidden',
				'value' : '0'
			});
			$(objEventDetailId).appendTo(objForm);
			var objEventId = $('<input/>', {
				'name' : '_eventId',
				'id' : '_eventId',
				'type' : 'hidden',
				'value' : $("#eventId").val()
			});
			$(objEventId).appendTo(objForm);
			break;
		}
		var objInfoTypeId = $('<input/>', {
			'name' : '_infoTypeId',
			'id' : '_infoTypeId',
			'type' : 'hidden',
			'value' : $("#infoTypeId").val()
		});
		$(objInfoTypeId).appendTo(objForm);
		var objInfoTypeCategoryId = $('<input/>', {
			'name' : '_infoTypeCategoryId',
			'id' : '_infoTypeCategoryId',
			'type' : 'hidden',
			'value' : $("#infoTypeCategoryId").val()
		});
		$(objInfoTypeCategoryId).appendTo(objForm);
		var objIsLogo = $('<input/>', {
			'name' : '_isLogo',
			'id' : '_isLogo',
			'type' : 'hidden',
			'value' : 'N'
		});
		if(venuImageId == "venueImages0"){
			if(aspectRatio[0] == "3:4"){
				dropZone0 = new Dropzone($(objForm).get(0), {
					dictDefaultMessage: "Drop files here to upload (width : height = "+aspectRatio+")",
					maxFiles: 1,
					autoProcessQueue : false,
					init: function() {
					    this.on("thumbnail", function(file) {
					      var height = (file.height/file.width) * 3;
					      if (Math.round(height) != 4) {
					        file.rejectDimensions()
					      }
					      else {
					        file.acceptDimensions();
					      }
					    });
					  },
					  accept: function(file, done) {
					    file.acceptDimensions = done;
					    file.rejectDimensions = function() { done("Invalid image resolution."); };
					  }
				});
			}else{
				dropZone0 = new Dropzone($(objForm).get(0), {
					dictDefaultMessage: "Drop files here to upload (width : height = "+aspectRatio+")",
					maxFiles: 1,
					autoProcessQueue : false,
					init: function() {
					    this.on("thumbnail", function(file) {
					      var height = (file.height/file.width) * 2;
					      if (Math.round(height) != 3) {
					        file.rejectDimensions()
					      }
					      else {
					        file.acceptDimensions();
					      }
					    });
					  },
					  accept: function(file, done) {
					    file.acceptDimensions = done;
					    file.rejectDimensions = function() { done("Invalid image resolution."); };
					  }
				});
			}
			
		}else if(venuImageId == "venueImages1"){
			dropZone1 = new Dropzone($(objForm).get(0), {
				dictDefaultMessage: "Drop files here to upload (width : height = "+aspectRatio+")",
				maxFiles: 1,
				autoProcessQueue : false,
				init: function() {
				    this.on("thumbnail", function(file) {
				    	var height = (file.height/file.width) * 9;
				      if (Math.round(height) != 16) {
				        file.rejectDimensions()
				      }
				      else {
				        file.acceptDimensions();
				      }
				    });
				  },
				  accept: function(file, done) {
				    file.acceptDimensions = done;
				    file.rejectDimensions = function() { done("Invalid image resolution."); };
				  }
			});
		}else if(venuImageId == "venueImages2"){
			dropZone2 = new Dropzone($(objForm).get(0), {
				dictDefaultMessage: "Drop files here to upload (width : height = "+aspectRatio+")",
				maxFiles: 1,
				autoProcessQueue : false,
				init: function() {
				    this.on("thumbnail", function(file) {
				    	var height = (file.height/file.width) * 9;
				      if (Math.round(height) != 16) {
				        file.rejectDimensions()
				      }
				      else {
				        file.acceptDimensions();
				      }
				    });
				  },
				  accept: function(file, done) {
				    file.acceptDimensions = done;
				    file.rejectDimensions = function() { done("Invalid image resolution."); };
				  }
			});
		}else{
			dropZone = new Dropzone($(objForm).get(0), {
				autoProcessQueue : false
			});
		}
	}
}

_infoTypeRenderer.fnBuildEditor = function(Obj) {

	var strSelected = "";
	var editor = "";
	var objFormGroup = $('<div/>', {
		'class' : 'form-group'
	}).appendTo($(formArea));
	var objControlLable = $('<label/>', {
		'class' : 'control-label',
		'for' : Obj[0].caption
	}).appendTo(objFormGroup);
	$(objControlLable).html(Obj[0].caption);
	var objControls = $('<div id="jqxEditor"/>', {
		'class' : 'controls'
	}).appendTo(objFormGroup);
	objControls
			.jqxEditor({
				height : "300px",
				width : '90%',
				theme : 'custom',
				tools : "bold italic underline | format size | left center right | outdent indent | ul ol "
			});
}

_infoTypeRenderer.fnBuildSubDetails = function(Obj, contentType) {
	contentType = contentType.charAt(0).toUpperCase() + contentType.slice(1);
	var label = contentType + Obj[0].caption;
	var objFormHeight = $('<div/>', {
		'class' : 'divHeight'
	}).appendTo($(formArea));
	var objControlLable = $('<label/>', {
		'class' : 'control-label',
	}).appendTo(objFormHeight);
	$(objControlLable).html(label);
	for(var i=1; i<=5; i++){
		var objFormGroup = $('<div/>', {
			'class' : 'control-group'
		}).appendTo($(objFormHeight));
		var objControls = $('<div/>', {
			'class' : 'controls'
		}).appendTo(objFormGroup);
		$('<input/>', {
			'type' : 'Text',
			'id' : Obj[0].id+i,
			'placeholder' : Obj[0].placeholder,
			'maxlength' : Obj[0].maxlength,
			'class' : 'input-medium sub-detail-text-box'
		}).appendTo(objControls);
		$('<textarea/>', {
			'id' : Obj[0].id1+i,
			'placeholder' : Obj[0].placeholder1,
			'maxlength' : Obj[0].maxlength1,
			'class' : 'Text-Area'
		}).appendTo(objControls);
	}
	$('<input/>', {
		'type' : 'button',
		'id' : 'Add5More',
		'value' : 'Add Rows',
		'class' : 'btn btn-info clsAdd5More'
	}).appendTo($(formArea));
}
/* Dynamic content type generation logic [End] */
_infoTypeRenderer.INFO_RENDERER = {
	GENERAL : [ {// GENERAL
		"type" : "text",
		"attr" : [ {
			"caption" : "Title",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter title here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "checkbox",
		"attr" : [ {
			"id" : "showDescription",
			"name" : "showDescription",
			"caption" : "Show Desciptions",
			"value" : "1",
			"checked" : "checked"
		} ]
	}, /*{
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}, */{
		"type" : "upload",
		"attr" : [ {
			"caption" : "Upload Pictures",
			"action" : $("#imgActionUrl").val(),
			"id" : "eventId",
			"value" : $("#eventId").val(),
			"Class" : ""
		} ]
	} ],
	TRADITION : [ {// TRADITION
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter title here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}, {
		"type" : "upload",
		"attr" : [ {
			"caption" : "Upload Pictures",
			"action" : $("#imgActionUrl").val(),
			"id" : "eventId",
			"value" : $("#eventId").val(),
			"Class" : ""
		} ]
	} ],
	WEATHER : [ {// WEATHER
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Description",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter description here",
			"maxlength" : "255",
			"Class" : ""
		} ]
	} ],
	PARKING : [ {// PARKING
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Walk time to stadium",
			"id" : "infoShortDesc",
			"value" : "",
			"placeholder" : "Walk time to stadium and tips",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Address",
			"id" : "addrLine1",
			"value" : "",
			"placeholder" : "Enter Address here",
			"maxlength" : "100",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Cost",
			"id" : "cost",
			"value" : "",
			"placeholder" : "Enter Cost here",
			"maxlength" : "10",
			"Class" : ""
		} ]
	}, {
		"type" : "boolean",
		"attr" : [ {
			"id" : "hoursOfOperation",
			"name" : "IsAvailable",
			"caption" : "Is Available?",
			"value" : "Yes",
			"items" : [ "Yes", "No" ]
		} ]
	},{
		"type" : "checkbox",
		"attr" : [ {
			"id" : "premiumDisplayEnabled",
			"name" : "premiumDisplayEnabled",
			"caption" : "Enable premium display on Map",
			"value":"0"
		} ]
	},{
		"type" : "upload",
		"attr" : [ {
			"caption" : pIds,
			"action" : pIds,
			"id" : pIds,
			"aspectRatio" : pAspectRatios,
			"value" : $("#eventId").val(),
			"Class" : ""
		} ]
	}, {
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	} ],
	TRAFFIC : [ {// TRAFFIC
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	},{
		"type" : "subdetails",
		"attr" : [ {
			"caption" : " Details",
			"id" : "subDetailTitle",
			"placeholder" : "Enter Title",
			"maxlength" : "70",
			"id1" : "subDetailDesc",
			"placeholder1" : "Enter Description",
			"maxlength1" : "255",
			/*"Class" : "input-medium sub-detail-text-box"*/
		} ]
	}/*, {
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}*/ ],
	VENUE_INFO : [ {//VENUE_INFO
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter title here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	},{
		"type" : "checkbox",
		"attr" : [ {
			"id" : "showDescription",
			"name" : "showDescription",
			"caption" : "Show Desciptions",
			"value" : "1",
			"checked" : "checked"
		} ]
	}, {
		"type" : "upload",
		"attr" : [ {
			"caption" : "Upload Pictures",
			"action" : $("#imgActionUrl").val(),
			"id" : "eventId",
			"value" : $("#eventId").val(),
			"Class" : ""
		} ]
	},{
		"type" : "subdetails",
		"attr" : [ {
			"caption" : " Details",
			"id" : "subDetailTitle",
			"placeholder" : "Enter Title",
			"maxlength" : "70",
			"id1" : "subDetailDesc",
			"placeholder1" : "Enter Description",
			"maxlength1" : "255",
			/*"Class" : "input-medium sub-detail-text-box"*/
		} ]
	}],
	VENUE_MAP : [ {//VENUE_MAP
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter title here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	},{
		"type" : "checkbox",
		"attr" : [ {
			"id" : "showDescription",
			"name" : "showDescription",
			"caption" : "Show Desciptions",
			"value" : "1",
			"checked" : "checked"
		} ]
	},{
		"type" : "upload",
		"attr" : [ {
			"caption" : ids,
			"action" : ids,
			"id" : ids,
			"aspectRatio" : aspectRatios,
			"value" : $("#eventId").val(),
			"Class" : ""
		} ]
	}],
	FOOD : [ {// FOOD
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Address",
			"id" : "addrLine1",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "100",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Phone",
			"id" : "phone",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "10",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Website",
			"id" : "website",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}/*, {
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}*/ ],
	BAR_AND_RESTO : [ {// FOOD
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Address",
			"id" : "addrLine1",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "100",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Phone",
			"id" : "phone",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "10",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Website",
			"id" : "website",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}, {
		"type" : "checkbox",
		"attr" : [ {
			"id" : "showDescription",
			"name" : "showDescription",
			"caption" : "Show Desciptions",
			"value" : "1",
			"checked" : "checked"
		} ]
	},{
		"type" : "checkbox",
		"attr" : [ {
			"id" : "premiumDisplayEnabled",
			"name" : "premiumDisplayEnabled",
			"caption" : "Enable premium display on Map",
			"value":"0"
		} ]
	},,{
		"type" : "upload",
		"attr" : [ {
			"caption" : "Upload Logo",
			"action" : $("#imgActionUrl").val(),
			"id" : "eventId",
			"value" : $("#eventId").val(),
			"Class" : ""
		} ]
	},{
		"type" : "upload",
		"attr" : [ {
			"caption" : "Upload Pictures",
			"action" : $("#imgActionUrl").val(),
			"id" : "eventId",
			"value" : $("#eventId").val(),
			"Class" : ""
		} ]
	},{
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	} ],
	LIQUOR : [ {// LIQUOR
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Address",
			"id" : "addrLine1",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "100",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Phone",
			"id" : "phone",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "10",
			"Class" : ""
		} ]
	}, {
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	} ],
	SAFETY : [ {
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Address",
			"id" : "addrLine1",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "100",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Phone",
			"id" : "phone",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "10",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Website",
			"id" : "website",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}, {
		"type" : "editor",
		"attr" : [ {
			"caption" : "Local Knowledge",
			"id" : "infoDesc",
			"value" : "",
			"placeholder" : "Enter local knowledge",
			"maxlength" : "255",
			"Class" : ""
		} ]
	} ],
	GETTING_HOME : [ {
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter Name here",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Mobile App Name",
			"id" : "mobileAppName",
			"value" : "",
			"placeholder" : "App name to open on click (optional)",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Website",
			"id" : "website",
			"value" : "",
			"placeholder" : "Link to website (optional)",
			"maxlength" : "255",
			"Class" : ""
		} ]
	}, {
		"type" : "text",
		"attr" : [ {
			"caption" : "Phone",
			"id" : "phone",
			"value" : "",
			"placeholder" : "",
			"maxlength" : "10",
			"Class" : ""
		} ]
	} ],
	TICKETS : [ {
		"type" : "text",
		"attr" : [ {
			"caption" : "Name",
			"id" : "infoTitle",
			"value" : "",
			"placeholder" : "Enter name of website",
			"maxlength" : "70",
			"Class" : ""
		} ]
	}, 
	 {
		"type" : "text",
		"attr" : [ {
			"caption" : "Website",
			"id" : "infoShortDesc",
			"value" : "",
			"placeholder" : "Add base URL for website",
			"maxlength" : "255",
			"Class" : ""
		}]
	},
	  {
		"type" : "text",
		"attr" : [ {
			"caption" : "Event Link",
			"id" : "website",
			"value" : "",
			"placeholder" : "Add link for the event",
			"maxlength" : "255",
			"Class" : ""
		} 
		]
	} ]
}