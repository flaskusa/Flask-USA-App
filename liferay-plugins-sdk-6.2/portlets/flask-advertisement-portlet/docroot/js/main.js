/*
// Local Data for Campaign
var _campaignData = [];
for(var i = 0; i < 6; i++){
	var campiagn = {};
	campiagn.campaignId = ""+i;
	campiagn.campaignName = "Campaign-"+i;
	campiagn.customerName = "Customer-"+i;
	if(i%2 == 0){
		campiagn.eventType = "Marriage Anniversery";
		campiagn.campaignEvents = i+"- Marriage Anniversery";
		campiagn.displayAt = "Pre Event, Others";
		campiagn.frequency = "400";
	}else{
		campiagn.eventType = "Birthday Party";
		campiagn.campaignEvents = i+"- BirthDay Party";
		campiagn.displayAt = "Post Event, During Event";
		campiagn.frequency = "300";
	}
	_campaignData.push(campiagn);
}
var events = 	[{name : "Rajesh Marriage",eventType:"1",address :"New Ranip",id :"1"},
              	{name : "Tejas Birthday",eventType:"2",address :"New Ranip",id :"2"},
              	{name : "Swara Anniversary",eventType:"3",address :"New Ranip",id :"3"},
              	{name : "Rajesh BirthDay",eventType:"2",address :"New Ranip",id :"4"},
              	{name : "arti Aniversary",eventType:"3",address :"New Ranip",id :"5"},
              	{name : "sapan Marriage",eventType:"1",address :"New Ranip",id :"6"},
              	{name : "Yogesh BirthDay",eventType:"2",address :"New Ranip",id :"7"}
 				];
 var eventType = [{name : "Marraige",value : "1"},{name : "Birthday",value : "2"},{name : "Anniversary",value : "3"}];
 var customers = [{name:"Rajesh",custId:"1"},
                  {name:"Ramesh",custId:"2"},
                  {name:"Umesh",custId:"3"},
                  {name:"Rakesh",custId:"4"},
                  {name:"Shankar",custId:"5"},
                  {name:"Preet",custId:"6"},
                  {name:"Deepak",custId:"7"},
                  {name:"Santosh",custId:"8"},
                  ];
 for(var  i = 0; i < customers.length ; i++){
 	$("#customerName").append("<option value="+customers[i].custId+">"+customers[i].name+"</option>");
 }
 for(var  i = 0; i < eventType.length ; i++){
 	$("#eventType").append("<option value="+eventType[i].value+">"+eventType[i].name+"</option>");
 }
 var eventGrid = "";
 function filterEventsGrid (eventType){
	var filteredEvents = filterData(eventType);
	 var source = {
			 localdata:filteredEvents,
			 datatype:'array',
			 datafields: [
			              	{name: 'status', type: 'bool' },
		                    {name: 'name', type: 'string' },
		                    {name:'eventTypeDisplay',type:'string'},
		                    {name:'address',type:'string'},
		                    {name:'id',type:'number'}
		                ],
		     id : 'id'           
	 };
	 eventGrid = $("#campaignEvents"); 
	 var dataAdapter = new $.jqx.dataAdapter(source);
	  $("#campaignEvents").jqxGrid({
		 width:520,
		 height : 300,
		 source :dataAdapter,
		 pageable : true,
		 selectionmode: 'checkbox',
		 enabletooltips : true,
		 editable : false,
		 columns: [
	                  { text: 'Event Name', columngroup: 'Events', datafield: 'name', width: 200 },
	                  {text:'Event Type', columngroup : 'Events',datafield : 'eventTypeDisplay', width:200},
	                  {text:'Address', columngroup : 'Events',datafield : 'address',width : 100},
	                  
	                ],
	                columngroups: [
	                    { text: 'Events', align: 'center', name: 'Events' }
	                ]
	 })
	 
 }
 
 function getCheckedEventIdList(idDataAttribute){
	 var rows = eventGrid.jqxGrid('selectedrowindexes');
	    var dataList="";
	    $.each(rows, function(i, rowIndex){
	    	var rowData = eventGrid.jqxGrid('getrowdata', rowIndex);
	    	var id = eval('rowData.'+ idDataAttribute);
	    	if(i !== rows.length -1){
	    		dataList = dataList + id + ",";
	    	}else{
	    		dataList = dataList + id;
	    	}
	    });
	    return dataList;
 }
 
  function filterData (evenType){
	  var filterdData = [];
	  for(var i=0 ; i< events.length ; i++){
		  if(events[i].eventType == evenType){
			  if(evenType == "1"){
				  events[i].eventTypeDisplay = "Marriage";
			  } else if (evenType == "2"){
				  events[i].eventTypeDisplay = "Birthday";
			  } else {
				  events[i].eventTypeDisplay = "Anniversary";
			  }
			  
			 filterdData.push(events[i]);
		  }
		  
	  }
	  return filterdData;
  }
 
  filterEventsGrid("1");
*/