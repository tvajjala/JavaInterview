<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>


<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var counter = 2;

						$("#addButton")
								.click(
										function() {

											//if (counter > 5) {
											//	alert("Only 5 textboxes allow");
											//	return false;
											//}

											var newTextBoxDiv = $(
													document
															.createElement('div'))
													.attr(
															"id",
															'TextBoxDiv'
																	+ counter);
											newTextBoxDiv.attr("style",
													'height: 30px');

											newTextBoxDiv
													.after()
													.html(
															'<select name="tsteps'+counter+'" class="sb2"><c:forEach var="o" items="${TESTSTEPS_LIST}">'
																	+ '<option value="${o}">${o}</option>'
																	+ '</c:forEach>'
																	+ '</select>');

											newTextBoxDiv
													.appendTo("#TextBoxesGroup");

											counter++;
										});

						$("#removeButton").click(function() {
							if (counter == 2) {
								//alert("No more textbox to remove");
								return false;
							}

							counter--;

							$("#TextBoxDiv" + counter).remove();

						});

					});

	function onModuleChange() {
		var pm = document.getElementById("project_module").value;
		if(pm != "") window.location = "createTestCases.htm?module_name=" + pm;
	}
</script>

<div class="securemainbody">


	

	<form action="updateTestCases.htm" method="post">

		

		<div align="center">
			<table class="userform" style="width: 100%;">
			<tr>
				<td colspan="4">
					<div class="left gride900">
						<h2>TestCases Creation</h2>
					</div>
				</td>
				<div id="errormsg">${msg}</div> 
			</tr>
				<tr>
					<th align="center" colspan="4">
					<table style="width:360px" align="center">
					<tr>
					<th style="width:180px"><span class="title">Select Category</span></th>
					<th style="width:180px"><select id="project_module"
						onchange="onModuleChange()" name="project_module"
						class="selectbox1">
						<option value="">Select</option>
							<c:forEach var="module" items="${PROJECT_MODULES }">
								<option value="${module}"
									<c:if test="${module==SELECTED_MODULE}"> selected="selected" </c:if>>
									${module}</option>
							</c:forEach>
					</select> <input type="hidden" name="project_name" id="project_name"
						value="${PROJECT_NAME }" /></th>
				<tr>
				<tr>
					<th><span class="title">TestCase Name</span></th>
					<th ><input type="text" name="testcase_name"
						id="testStep_name" size="40" maxlength="50" class="textfield" /></th>
				</tr>
					
					
					</table>
					</th>
					
				
				<tr>
					<td class="dynaLabel" style="text-align: center;"><a href="#"
						id="addButton" class="dynaTxtLink">(+) </a>
						</td>
					<td class="dynaLabel" style="text-align: center;"><span class="title">Test Steps Information</span></td>
					<td class="dynaLabel" style="text-align: center;"> <a href="#" id="removeButton"
						class="dynaTxtLink"> (-)</a>
					</td>
				</tr>
			</table>
		</div>


		<div id='TextBoxesGroup' style="width: 100%; text-align: center;">
			<div id="TextBoxDiv1" style="height: 30px">

				<select name="tsteps1" class="sb2">
					<c:forEach var="o" items="${TESTSTEPS_LIST}">
						<option value="${o}">${o}</option>
					</c:forEach>
				</select>


			</div>
		</div>

		<div align="center">
			<input type="submit" value="CREATE" class="loginbtn" />
		</div>
	</form>

</div>