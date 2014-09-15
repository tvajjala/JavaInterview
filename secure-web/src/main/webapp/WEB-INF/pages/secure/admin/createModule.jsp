<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">



	<form action="addCategory.htm" method="post">
		<table class="userform">
			<tr>
				<th colspan="2">
					<div class="left gride900">
						<h2>Create Project Module</h2>
					</div>

					<div id="errormsg">${msg}</div>
				</th>
			</tr>

			<tr>
				<td width="200px"><span class="title">Project Name </span></td>
				<td width="520px"><select id="pname" name="pname" class="selectbox1">
						<c:forEach var="item" items="${PROJECTS_LIST }">
							<option value="${item}">${item}</option>
						</c:forEach>

				</select></td>
			<tr>
			<tr>
				<td><span class="title">Project Module</span></td>
				<td><input type="text" name="pmodule" id="pmodule" maxlength="25"
					autocomplete="off" class="textfield" size="40" /></td>
			<tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create" class="loginbtn" /></td>
			<tr>
		</table>
	</form>


</div>