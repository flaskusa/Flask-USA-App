<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%
  com.liferay.portal.theme.ThemeDisplay themeDisplay = (com.liferay.portal.theme.ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
  long repositoryId = themeDisplay.getLayout().getGroupId();
  themeDisplay.getLayout().getUuid();
%>
<portlet:defineObjects />

<aui:script use="array-extras">
	$(document).ready(function(){
		initContactList();
	});
</aui:script>

<body class='default'>
    <div id="demoContainer" class="device-mobile">
        <div id="container" class="device-mobile-container">
            <div style="border: none;" id="listbox"></div>
        </div>
    </div>
</body>

