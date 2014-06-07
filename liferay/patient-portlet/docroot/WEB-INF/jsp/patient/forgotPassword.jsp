<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"
	type="text/css" />

<script type="text/JavaScript"
	src="<%=request.getContextPath()%>/js/main.js"></script>


<portlet:defineObjects />



<div class="container">

	<form id="signup" action="#" method="post">

		<div class="header">
			<h3>Forgot Password</h3>
			<p>
				<liferay-ui:error key="login.fail" message="Invalid Credentials" />
			</p>

		</div>

		<div class="sep"></div>

		<div class="inputs">

			<input type="text" name="nh_mobile" placeholder="Enter Mobile"
				autofocus /> <input type="password" name="nh_email"
				placeholder="Email" /> <input type="submit" id="submit"
				value="Send Password" />

		</div>

	</form>

</div>


