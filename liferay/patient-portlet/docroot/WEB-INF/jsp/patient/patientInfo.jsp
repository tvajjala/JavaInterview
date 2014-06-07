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



<portlet:renderURL var="logoutURL">
	<portlet:param name="action" value="logout" />
</portlet:renderURL>




<div>

	<div style="float: left: top:;">
		<img src="<%=request.getContextPath()%>/img/napier.jpg"
			width="160px;" height="80px;" />
	</div>

<div style="float: right;">

     Welcome :   ${patientProfile.firstname}    &nbsp; &nbsp; &nbsp; &nbsp; <a href="${logoutURL}" >logout </a>

</div>
	<h2>Patient Information</h2>
	<div class="inputs">

		<div class="sep">
			 First name:   <b> ${patientProfile.firstname}</b>
		</div>

		<div class="sep">
			Last name : <b> ${patientProfile.lastname} </b>
		</div>

		<div class="sep">
			Practice ID : <b> ${patientProfile.practiceID}</b>
		</div>

		<div class="sep">
			INT MR Number : <b> ${patientProfile.intMR} </b>
		</div>

		<div class="sep">
			EXT MR Number :  <b> ${patientProfile.extMR}</b>
		</div>

	</div>

</div>






