
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">

	<auth:authorize access="hasRole('ROLE_TESTER')">

		<div id="errormsg">Dear Tester, you are not authorized to view
			this page</div>

		<a href="<%=request.getContextPath()%>/tester/home.htm"
			id="linkdesc">Tester Home</a>
	</auth:authorize>
	<auth:authorize access="hasRole('ROLE_ADMIN')">

		<div id="errormsg">Dear Admin, you are not authorized to view
			this page</div>
		<a href="<%=request.getContextPath()%>/admin/home.htm"
			id="linkdesc">Admin Home</a>
	</auth:authorize>dd

</div>
