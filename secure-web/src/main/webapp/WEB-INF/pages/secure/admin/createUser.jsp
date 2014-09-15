<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>




<div class="securemainbody">

	<form method="POST" action="saveUser.htm">
		<table class="userform" >
			<tr>
				<td colspan="4">
					<div class="left gride900">
						<h2>User Information</h2>
					</div>
					<div id="errormsg">${msg}</div>
				</td>

			</tr>
			<tr>
				<td>UserName</td>
				<td><input name="username" id="username" class="textfield" />
					<label id="mandatory">*</label></td>
				<td>Active</td>
				<td><input type="checkbox" name="enabled" id="enabled" value="on" />
					<label id="menable"></label></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input name="firstname" autocomplete="off"
					class="textfield" /> <label id="mandatory">*</label></td>
				<td>Last Name</td>
				<td><input name="lastname" autocomplete="off" class="textfield" /></td>
			</tr>
			<tr>
				<td>Organization</td>
				<td><select name="organizationId" class="selectbox1">
						<c:forEach var="o" items="${ORGANIZATION_LIST}">
							<option value="${o.orgId}">${o.organization}</option>
						</c:forEach>
				</select> <label id="mandatory">*</label></td>
				<td>Role</td>
				<td><select name="roleId" class="selectbox1">
						<c:forEach var="o" items="${AUTHORITIES_LIST}">
							<option value="${o.authority}">${o.roleName}</option>
						</c:forEach>
				</select> <label id="mandatory">*</label></td>
			</tr>

			<tr>
				<td>Designation</td>
				<td><input name="designation" autocomplete="off"
					class="textfield" /></td>
				<td>E-Mail</td>
				<td><input name="email" autocomplete="off" class="textfield" /><label
					id="mandatory">*</label></td>
			</tr>
			<tr>
				
				<td>Phone Number</td>
				<td><input name="phone" autocomplete="off" class="textfield" /></td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" class="loginbtn" /> <input
					type="reset" value="Reset" class="loginbtn" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>