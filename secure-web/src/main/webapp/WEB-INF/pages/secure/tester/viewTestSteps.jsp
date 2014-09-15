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
															'<select name="new_comp'+counter+'" class="sb"><c:forEach var="o" items="${OBJ_NAMESET}">'
																	+ '<option value="${o}">${o}</option>'
																	+ '</c:forEach>'
																	+ '</select> <select name="new_action'+counter+'" class="sb">'
																	+ '<c:forEach var="a" items="${ACTION_SET}">'
																	+ '<option value="${a}">${a}</option>'
																	+ '</c:forEach>'
																	+ '</select> <select name="new_msg'+counter+'" class="sb">'
																	+ '<c:forEach var="m" items="${MSG_NAMESET}">'
																	+ '<option value="${m}">${m}</option>'
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
		document.forms["viewTestSteps"].submit();
	}
	function submitDataForm(opt, idx){
		document.forms["viewTestSteps"].choice.value=opt;
		document.forms["viewTestSteps"].position.value=idx;
		document.forms["viewTestSteps"].action="<%=request.getContextPath()%>/tester/arTestSteps.htm";
		document.forms["viewTestSteps"].submit();
	}
</script>

<div class="securemainbody">


	<div class="title3">TestSteps View Form</div>

	<form name="viewTestSteps" action="editTestSteps.htm" method="post">
		<center>
			<div id="errormsg">${msg}</div>

			
				<table class="userform" style="width: 100%;">

					<tr>
						<th>Select Module</th>
						<th colspan="2"><select id="project_module"
							onchange="submitModule()" name="project_module"
							class="selectbox2">
								<option value="">Select</option>
								<c:forEach var="module" items="${PROJECT_MODULES }">
									<option value="${module}"
										<c:if test="${module eq  moduleName}" > selected="selected"  </c:if>>
										${module}</option>
								</c:forEach>
						</select> <input type="hidden" name="project_name" id="project_name"
							value="${PROJECT_NAME }" />
						</th>
					</tr>
					<tr>
						<th>Step Name</th>
						<th colspan="2"><select id="teststep_name"
							onchange="submitModule()" name="teststep_name" class="selectbox2">
								<option value="">Select</option>
								<c:forEach var="step" items="${TESTSTEPS_LIST}">
									<option value="${step}"
										<c:if test="${step eq  selected_step}" > selected="selected"  </c:if>>
										${step}</option>
								</c:forEach>
						</select>
						</th>
					</tr>

				</table>


				<table class="userform" style="width: 100%;">

					<tr>
						
						<th>Repeat Count</th>
						<th colspan="2"><input type="text" name="repeat_count"
							id="repeat_count" size="4" maxlength="2" class="tf"
							value="${StepsData.count}" />
						</th>
					</tr>


					<tr>
						
						<th class="dynaLabel" style="text-align: center;">Component
							(ObjectName)</th>
						<th class="dynaLabel">Action To Perform</th>
						<th class="dynaLabel" style="text-align: center;">Expected/Input
							Message</th>
					</tr>

					<c:set var="scount" value="1" scope="page" />
					<c:forEach var="sdata" items="${StepsData.data}">
						<tr>
							
							<th class="dynaLabel" style="text-align: center;"><a href="#" onclick="javascript:submitDataForm('add',${scount})" class="dynaTxtLink" title="Insert Action">(+) </a> <select
								name="comp${scount}" class="sb">
								      <option value="">Select</option>
									<c:forEach var="o" items="${OBJ_NAMESET}">
										<option value="${o}"
											<c:if test="${o eq  sdata.componentName}" > selected="selected"  </c:if>>${o}</option>
									</c:forEach>
							</select>
							</th>
							<th class="dynaLabel"><select name="action${scount}"
								class="sb">
								<option value="">Select</option>
									<c:forEach var="a" items="${ACTION_SET}">
										<option value="${a}"
											<c:if test="${a eq  sdata.actionName}" > selected="selected"  </c:if>>${a}</option>
									</c:forEach>
							</select>
							</th>
							<th class="dynaLabel" style="text-align: center;"><select
								name="msg${scount}" class="sb">
								<option value="">Select</option>
									<c:forEach var="m" items="${MSG_NAMESET}">
										<option value="${m}"
											<c:if test="${m eq  sdata.messageName}" > selected="selected"  </c:if>>${m}</option>
									</c:forEach>
							</select><a href="#" onclick="javascript:submitDataForm('remove',${scount})" class="dynaTxtLink" title="Remove Action">(-) </a>
							</th>
						</tr>
						<c:set var="scount" value="${scount + 1}" scope="page" />
					</c:forEach>
					
				</table>
				<input type="hidden" value="none" name="choice" />
				<input type="hidden" value="0" name="position" />
				<div align="center">
					<input type="submit" value="Update" name="setSteps"
						class="loginbtn" />
				</div>
		</center>
	</form>
    
    <br/><br/>
     
    
</div>