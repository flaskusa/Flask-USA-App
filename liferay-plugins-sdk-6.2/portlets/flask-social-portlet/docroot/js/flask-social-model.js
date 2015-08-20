var _socialModel = {};

_socialModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
    GET_ALL_CONTACTS			:"/flask-social-portlet.entry/search-users-and-contacts",
    SEND_REQUEST				:"/flask-social-portlet.entry/request-social-relation"
};

_socialModel.MESSAGES = {
		SEARCH_ERR :"No contacts found"
}

ContactList = [
        {
            "portraitId": "0",
            "lastName": "Bloggs",
            "connected": false,
            "block": false,
            "emailAddress": "test@liferay.com",
            "portalUser": true,
            "following": false,
            "contactId": "20200",
            "connectionRequested": false,
            "userId": "20198",
            "fullName": "Joe Bloggs",
            "uuid": "a1948340-554a-4aa5-9f8b-ba9d0982472d",
            "firstName": "Joe",
            "jobTitle": ""
          },
          {
            "portraitId": "0",
            "lastName": "DLC 1",
            "connected": true,
            "block": false,
            "emailAddress": "test.dlc.1@liferay.com",
            "portalUser": true,
            "following": false,
            "contactId": "20614",
            "connectionRequested": false,
            "userId": "20613",
            "fullName": "Test DLC 1",
            "uuid": "f712bb2d-1250-4b58-adc6-861451cc038e",
            "firstName": "Test",
            "jobTitle": ""
          },
          {
            "portraitId": "0",
            "lastName": "DLC 10",
            "connected": false,
            "block": false,
            "emailAddress": "test.dlc.10@liferay.com",
            "portalUser": true,
            "following": false,
            "contactId": "20677",
            "connectionRequested": false,
            "userId": "20676",
            "fullName": "Test DLC 10",
            "uuid": "e7835a87-6ddc-404a-8624-101f9706588f",
            "firstName": "Test",
            "jobTitle": ""
          }
        ];