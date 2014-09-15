<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">



	<form action="addProject.htm" method="post">
		<table class="userform">
			<tr>
				<th colspan="2">
					<div class="left gride900">
						<h2>Create Project</h2>
					</div>

					<div id="errormsg">${msg}
					project creation disabled 
					</div></th>
			</tr>


			<tr>
				<td width="200px;"> <span class="title"> Project Name </span></td>
				<td width="520px;"><input type="text" name="pname" id="pname"
					autocomplete="off" maxlength="20" class="textfield" size="25" />
				</td>
			<tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create" class="loginbtn" disabled="disabled" />
				</td>
			<tr>
		</table>
	</form>


</div>