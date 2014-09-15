<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">


	
	
	<form action="updateTestConfig.htm" method="post">

		

		<div align="center">
			<table class="userform" >
				<tr>
				<th colspan="4">
					<div class="left gride900">
						<h2>Create Test Configuration</h2>
					</div>

					<div id="errormsg">${msg}</div></th>
			</tr>
				<tr>
				<td>
				<table style="width:360px" align="center">
				
				<tr>
					<th style="width:180px"><span class="title">Select Project name</span></th>
					<th  style="width:180px"><select name="project_name" id="project_name"
						class="selectbox1">
							<c:forEach var="p" items="${PROJECT_LIST }">
								<option value="${p}" >${p}</option>
							</c:forEach>
					</select>
					</th>
				<tr>
				<tr>
					<th ><span class="title">Enter Configuration Name</span></th>
					<th ><input type="text" name="config_name"
						id="config_name" class="textfield" /></th>
				<tr>
				<tr>
					<th><span class="title">Host Name/IP Address</span></th>
					<th ><input type="text" name="host_name"
						id="host_name" size="40" maxlength="20" class="textfield" /></th>
				<tr>
				<tr>
					<th><span class="title">Browser Type</span></th>
					<th ><select class="selectbox1" name="browserType"
						id="browserType">
							<option value="">SELECT</option>
							<c:forEach var="b" items="${BROWSER_TYPES}">
								<option value="${b.key }">${b.value }</option>
							</c:forEach>
					</select>
					</th>
				<tr>
				<tr>
					<th><span class="title">Browser Version</span></th>
					<th ><input name="bversion" id="bversion" style="width:50px"
						class="textfield"/></th>
				<tr>
				<tr>
				<th></th>
				<th ><input type="submit" value="Create"
						class="loginbtn" /></th>
				</tr>
				
				</table>
				
				</td>
				
				</tr>
			</table>
		</div>


	</form>

</div>