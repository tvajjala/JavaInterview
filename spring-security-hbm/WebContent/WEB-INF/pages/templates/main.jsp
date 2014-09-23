<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css"
	rel="stylesheet" media="screen">
<script src="<%=request.getContextPath()%>/js/script.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/ajaxRequest.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/boxover.js"
	type="text/javascript"></script>
<title>${firstname} <tiles:getAsString name="title" /></title>
</head>

<body class="outertbl">


	<table border="0" width="100%" align="center" id="virtualform"
		cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<th colspan="2"><tiles:insertAttribute name="banner-content" />
				</th>
			</tr>


			<tr>
				<td colspan="2"><tiles:insertAttribute name="body-content" /></td>
			</tr>


			<tr>
				<td colspan="2"><tiles:insertAttribute name="footer-content" /></td>
			</tr>
		</tbody>
	</table>
</body>
</html>