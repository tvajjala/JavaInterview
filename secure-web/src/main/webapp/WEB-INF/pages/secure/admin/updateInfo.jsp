<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div class="securemainbody">

	<form:form commandName="adminInfoForm" action="updateAdmin.htm" method="POST" autocomplete="off">

		<table class="userform">
			<tr>
				<td colspan="4">
					<div class="left gride900">
						<h2 style="margin-right: 20px;">User Information</h2>
					</div>
				</td>
				
					<div id="errormsg">${msg}</div> <form:errors path="*"
						cssClass="error" element="div" />
				
			</tr>
			<tr>
				<td><span class="title">User ID</span></td>
				<td><form:hidden path="userid" />
					<form:input path="username" cssClass="textfield" /> <label
					id="mandatory">*</label></td>

				<td><span class="title">Active</span></td>
				<td><form:checkbox path="enabled" value="${isUserEnabled }"
						 /> <label id="menable"></label></td>
			</tr>

			<tr>
				<td><span class="title">First Name</span></td>
				<td><form:input path="firstname" autocomplete="off"
						cssClass="textfield" /> <label id="mandatory">*</label></td>
				<td><span class="title">Last Name</span></td>
				<td><form:input path="lastname" autocomplete="off"
						cssClass="textfield" /></td>
			</tr>

			<tr>
				<td><span class="title">Organization</span></td>


				<td><form:select path="organizationId"
						items="${organizationMap}" cssClass="selectbox1" /> <label
					id="mandatory">*</label></td>
				<td><span class="title">Role</span></td>
				<td>
				<form:select path="roleId" cssClass="selectbox1" items="${roleMap}" onchange="updateRoleName()"/>
				<input type="hidden" id="roleName" name="roleName" value="${UPDATE_USER_ROLE}"/>
				<label id="mandatory">*</label></td>
			</tr>

			<tr>
				<td colspan="4">
					<div class="left gride900">
						<h2 style="margin-right: 20px;">Other Details</h2>
					</div> <br>
				</td>
			</tr>
			<tr>

				
				<td><span class="title">Designation</span></td>
				<td><form:input path="designation" autocomplete="off"
						cssClass="textfield" /></td>
				<td><span class="title">E-Mail</span></td>
				<td><form:input path="email" autocomplete="off"
						cssClass="textfield" /><label id="mandatory">*</label></td>
			</tr>

			<tr>
				<td colspan="2">&nbsp;</td>
				<td><span class="title">Phone Number</span></td>
				<td><form:input path="phone" autocomplete="off" 
						cssClass="textfield" /> </td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>


			<tr>
				<td></td>
				<td><input type="submit" value="Update" class="loginbtn" /> <input
					type="reset" value="Reset" class="loginbtn" /></td>
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