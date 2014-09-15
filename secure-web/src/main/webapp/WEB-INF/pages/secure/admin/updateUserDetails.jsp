<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="securemainbody">

	<form:form commandName="userInfoForm" action="processUserData.htm"
		method="POST" autocomplete="off">

		<table class="userform">
			<tr>
				<td colspan="2">
					<div class="title3">Update User Information</div>
				</td>
				<td colspan="2">
					<div id="errormsg">${msg}</div> <form:errors path="*"
						cssClass="error" element="div" />
				</td>
			</tr>
			<tr>
				<td>User ID</td>
				<td><form:hidden path="userid" /> <form:input path="username"
						cssClass="textfield" /> <label id="mandatory">*</label></td>

				<td>Active</td>
				<td><form:checkbox path="enabled" value="${isUserEnabled }"
						cssClass="textfield" /> <label id="menable"></label></td>
			</tr>

			<tr>
				<td>First Name</td>
				<td><form:input path="firstname" autocomplete="off"
						cssClass="textfield" /> <label id="mandatory">*</label></td>
				<td>Last Name</td>
				<td><form:input path="lastname" autocomplete="off"
						cssClass="textfield" /></td>
			</tr>

			<tr>
				<td>Organization</td>


				<td><form:select path="organizationId"
						items="${organizationMap}" cssClass="selectbox1" /> <label
					id="mandatory">*</label></td>
				<td>Role</td>
				<td><form:select path="roleId" cssClass="selectbox1"
						id="roleId" items="${roleMap}" onchange="updateRoleName()"/> <label
					id="mandatory">*</label>
					
					<input type="hidden" id="roleName" name="roleName" value="${UPDATE_USER_ROLE}"/>
					</td>
			</tr>

			<tr>
				<td colspan="4">
					<div class="title3">Other Details</div> <br>
				</td>
			</tr>
			<tr>

				<td colspan="2">&nbsp;</td>
				<td>E-Mail</td>
				<td><form:input path="email" autocomplete="off"
						cssClass="textfield" /><label id="mandatory">*</label></td>
			</tr>

			<tr>
				<td>Designation</td>
				<td><form:input path="designation" autocomplete="off"
						cssClass="textfield" /></td>
				<td>Phone Number</td>
				<td><form:input path="phone" autocomplete="off"
						cssClass="textfield" /> </td>
			</tr>



			<tr>
				<td></td>
				<td><input type="submit" value="UPDATE" class="loginbtn" /> <input
					type="reset" value="RESET" class="loginbtn" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form:form>



<script type="text/javascript">
	function setValues() {
		document.getElementById("roleId").value ='${UPDATE_USER_ROLE}';
	}
	setValues();
	
	function updateRoleName(){
		document.getElementById("roleName").value=document.getElementById("roleId").value;
	}
</script>

</div>