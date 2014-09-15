<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">


	

	<form action="updateTestSuite.htm" method="post" autocomplete="off">

		

		<div align="center">
			<table class="userform" style="width: 100%;">
			<tr>
				<th colspan="4">
					<div class="left gride900">
						<h2>Test Suites Creation</h2>
					</div>

					<div id="errormsg">${msg}</div></th>
			</tr>
				<tr>
					<th>
					<table style="width:360px" align="center">
					<tr>
					<th style="width:180px">
					<span class="title">Select Project</span></th>
					<th style="width:180px"><select id="project_name" name="project_name"
						class="selectbox1">
							<c:forEach var="module" items="${PROJECT_LIST }">
								<option value="${module}"
									<c:if test="${module==PROJECT_NAME}"> selected="selected" </c:if>>
									${module}</option>
							</c:forEach>
					</select></th>
				</tr>
				<tr>
					<th><span class="title">Enter Suite Name</span></th>
					<th ><input type="text" name="testsuite_name"
						id="testsuite_name" size="40" maxlength="20" class="textfield" /></th>
				</tr>
				</table></th></tr>
			</table>
		</div>
		<div style="width: 100%; height: 250px;" align="center">
			<div
				style="width: 800px; height: 250px; overflow-x: scroll; overflow-y: scroll;">

				<table>
					<tr>

						<c:forEach var="module" items="${PROJECT_MODULES}">
							<td>
								<div style="width: 350px; margin: 10px;">
									<p>
										<span class="title"> Category:</span> <font class="title4">${module.key}</font>
									</p>
									<p>
										<span class="title">URL:</span> <input class="tf"
											value="http://192.168.60.108:8086" name="${module.key}_url"
											size="30" />
									</p>

									<p>
										<select class="sb2" multiple="multiple" style="height: 120px;"
											name="${module.key}_sb" size="10">
											<c:forEach var="a" items="${module.value}">
												<option value="${a}">${a}</option>
											</c:forEach>
										</select>
									</p>
								</div>
							</td>
						</c:forEach>


					</tr>

				</table>
			</div>
		</div>

		<div align="center" style="margin: 10px;">
			<input type="submit" value="Create" class="loginbtn" />
		</div>
	</form>

</div>