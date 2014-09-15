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

	function submitModule() {
		document.forms["viewTestCases"].submit();
	}
	function submitDataForm(opt, idx){
		document.forms["viewTestCases"].choice.value=opt;
		document.forms["viewTestCases"].position.value=idx;
		document.forms["viewTestCases"].action="<%=request.getContextPath()%>/tester/arTestCase.htm";
		document.forms["viewTestCases"].submit();
	}
</script>

<div class="securemainbody">


	<div class="title3">TestCases Creation</div>

	<form action="editTestCases.htm" name="viewTestCases" method="post">
		<center>
			<div id="errormsg">${msg}</div>

			<div align="center">
				<table class="userform" style="width: 100%;">

					<tr>
						<th>Select Category</th>
						<th colspan="2"><select id="project_module"
							onchange="submitModule()" name="project_module"
							class="selectbox2">
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
						<th>TestCase Name</th>
						<th colspan="2"><select id="testStep_name"
							onchange="submitModule()" name="testcase_name" class="selectbox2">
								<option value="">Select</option>
								<c:forEach var="case_name" items="${TESTCASES}">
									<option value="${case_name}"
										<c:if test="${case_name eq SelTestCase}"> selected="selected" </c:if>>
										${case_name}</option>
								</c:forEach>
						</select>
						</th>
					<tr>
						<!-- <tr>
						<th class="dynaLabel" style="text-align: center;"><a href="#"
							id="addButton" class="dynaTxtLink">(+) </a></th>
						<th class="dynaLabel">Test Steps Information</th>
						<th class="dynaLabel" style="text-align: center;"><a href="#"
							id="removeButton" class="dynaTxtLink"> (-)</a></th>
					</tr> -->
					<tr>
						<th class="dynaLabel" style="text-align: center;"></th>
						<th class="dynaLabel">Test Steps Information</th>
						<th class="dynaLabel" style="text-align: center;"></th>
					</tr>

					<c:set var="scount" value="1" scope="page" />
					<c:forEach var="caseStep" items="${SelCaseSteps}">

						<tr>
							<th class="dynaLabel" style="text-align: center;" width="20px">
							</th>
							<th class="dynaLabel" >
								<div style="width: 100%; text-align: center; height: 30px">
									<!-- to be display selected testCase steps in dropdown  with same order  -->
									<a href="#" onclick="javascript:submitDataForm('add',${scount})" class="dynaTxtLink" title="Insert New Test Step at this Position">(+) </a><select name="tsteps${scount}" class="sb2">
									<option value="">Select</option>
										<c:forEach var="o" items="${TESTSTEPS_LIST}">
											<option value="${o}"
												<c:if test="${o eq caseStep}"> selected="selected" </c:if>>${o}</option>
										</c:forEach>
									</select><a href="#" onclick="javascript:submitDataForm('remove',${scount})" class="dynaTxtLink" title="Remove This Test Step">(-) </a> 
								</div></th>
							<th class="dynaLabel" style="text-align: center;" width="20px">
							</th>
						</tr>
						<c:set var="scount" value="${scount + 1}" scope="page" />
					</c:forEach>

				</table>
			</div>
			<input type="hidden" value="${scount}" name="scount" />
			<input type="hidden" name="choice" />
			<input type="hidden" name="position" />
			<div align="center">
			
				<input type="submit" value="Update" name="setCases" class="loginbtn" />
			</div>
		</center>
	</form>

</div>