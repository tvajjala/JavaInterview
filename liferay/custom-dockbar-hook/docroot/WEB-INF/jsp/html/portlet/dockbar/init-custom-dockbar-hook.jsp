<%@ page import="com.liferay.portal.model.GroupConstants"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>

<%@ page import="com.liferay.portlet.blogs.service.permission.BlogsPermission"%>
<%@ page import="com.liferay.portlet.documentlibrary.service.permission.DLPermission" %>
<%@ page import="com.liferay.portlet.journal.service.permission.JournalPermission"%>

<%@ include file="/html/portlet/dockbar/init.jsp"%>

<%
	final String ADD_EVENT = "ADD_EVENT";

	long groupId = themeDisplay.getScopeGroupIdOrLiveGroupId();
%>