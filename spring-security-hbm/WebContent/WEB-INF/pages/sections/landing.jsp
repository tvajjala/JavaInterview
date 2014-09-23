<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">


	<auth:authorize access="hasRole('ROLE_TESTER')">
		<jsp:forward page="/tester/home.htm" />
	</auth:authorize>

	<auth:authorize access="hasRole('ROLE_ADMIN')">
		<jsp:forward page="/admin/home.htm" />
	</auth:authorize>
	
	<auth:authorize access="hasRole('ROLE_MANAGER')">
		NOT AVAILABLE
	</auth:authorize>

</div>