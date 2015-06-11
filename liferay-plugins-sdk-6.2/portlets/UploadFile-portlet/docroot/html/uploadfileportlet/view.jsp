<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>
<%@ include file="/html/uploadfileportlet/init.jsp"%>
<liferay-theme:defineObjects/>

<portlet:actionURL var="uploadURL" name="UploadDocument">
</portlet:actionURL>
<%
long repositoryId = themeDisplay.getLayout().getGroupId();
themeDisplay.getLayout().getUuid();
%>
<aui:form action="<%=uploadURL%>" method="post"
	enctype="multipart/form-data">
	<aui:fieldset>
		<aui:input name="fileUpload" type="file"></aui:input>
		<aui:input name="title"></aui:input>
		<aui:input name="description" type="textarea"></aui:input>
		<aui:button type="submit" value="Upload"></aui:button>
		<aui:input name="repositoryId" type="hidden" value="<%=repositoryId %>"></aui:input>
	</aui:fieldset>

<liferay-ui:search-container emptyResultsMessage="there-are-no-products"
	delta="5">

	<liferay-ui:search-container-results>
		<%
			List<UploadFile> tempResults = UploadFileLocalServiceUtil.getAllFiles();
					results = ListUtil.subList(tempResults,
							searchContainer.getStart(),
							searchContainer.getEnd());
					total = tempResults.size();
					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>


	<liferay-ui:search-container-row
		className="com.fl.uploadfile.model.UploadFile"
		keyProperty="fileUpload" modelVar="fileUpload">
	<%
		long fileUploadId = fileUpload.getFileEntryId();
		FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileUploadId);
		FileVersion fileVersion = fileEntry.getFileVersion();
		%>

		<liferay-ui:search-container-column-text name="Id"
			property="fileUploadId" />

		<liferay-ui:search-container-column-text name="title" property="title" href="<%=DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, com.liferay.portal.kernel.util.StringPool.BLANK) %>" >
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="description"
			property="description" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container> 
</aui:form>