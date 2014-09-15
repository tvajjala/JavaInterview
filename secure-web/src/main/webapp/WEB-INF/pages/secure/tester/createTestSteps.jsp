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
															'<select name="comp'+counter+'" class="sb"><c:forEach var="o" items="${OBJ_NAMESET}">'
																	+ '<option value="${o}">${o}</option>'
																	+ '</c:forEach>'
																	+ '</select> <select name="action'+counter+'" class="sb">'
																	+ '<c:forEach var="a" items="${ACTION_SET}">'
																	+ '<option value="${a}">${a}</option>'
																	+ '</c:forEach>'
																	+ '</select> <select name="msg'+counter+'" class="sb">'
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

	function onModuleChange() {
		var pm = document.getElementById("project_module").value;
		if(pm != "") window.location = "createTestSteps.htm?module_name=" + pm;
	}
</script>

<div class="securemainbody">


	

	<form action="updateTestSteps.htm" method="post">
		
		
		
		<div align="center">
			<table class="userform" style="width: 100%;">
			<tr>
				<td colspan="4">
					<div class="left gride900">
						<h2>TestSteps Creation Form</h2>
					</div>
				</td>
				<div id="errormsg">${msg}</div> 
			</tr>
				<tr>
				<th align="center" colspan="4">
					<table style="width:360px" align="center">
					<tr>
					<th style="width:180px"><!-- <span class="title">Select Category</span> --></th>
					<th style="width:180px">
					<%-- <select id="project_module"
						onchange="onModuleChange()" name="project_module"
						class="selectbox1">
						<option value="">Select</option>
							<c:forEach var="module" items="${PROJECT_MODULES }">
								<option value="${module}"
									<c:if test="${module==SELECTED_MODULE}"> selected="selected" </c:if>>
									${module}</option>
							</c:forEach>
					</select> --%> <input type="hidden" name="project_name" id="project_name"
						value="${PROJECT_NAME }" /></th>
				<tr>
				<tr>
					<th><span class="title">Step Name</span></th>
					<th ><input type="text" name="teststep_name"
						id="testStep_name" size="40" maxlength="50" class="textfield" /></th>
				<tr>
				<tr>
					<th><span class="title">Repeat Count</span></th>
					<th ><input type="text" name="repeat_count"
						id="repeat_count" style="width:50px;" maxlength="2" class="textfield" value="1" /></th>
				</tr>
				</table>
				</th></tr>
				<tr>
					<td class="dynaLabel" style="text-align: center;"><a href="#"
						id="addButton" class="dynaTxtLink">(+) </a>
						&nbsp;&nbsp;&nbsp;&nbsp; <span class="title">Component (ObjectName)</span></td>
					<td class="dynaLabel" style="text-align: center;"><span class="title">Action To Perform</span></td>
					<td class="dynaLabel" style="text-align: center;"><span class="title">Expected/Input
						Message</span> &nbsp;&nbsp;&nbsp;&nbsp; <a href="#" id="removeButton"
						class="dynaTxtLink"> (-)</a>
					</td>
				</tr>
			</table>
		</div>


		<div id='TextBoxesGroup' style="width: 100%; text-align: center;">
			<div id="TextBoxDiv1" style="height: 30px">

				<select name="comp1" class="sb">
					<c:forEach var="o" items="${OBJ_NAMESET}">
						<option value="${o}">${o}</option>
					</c:forEach>
				</select> <select name="action1" class="sb">
					<c:forEach var="a" items="${ACTION_SET}">
						<option value="${a}">${a}</option>
					</c:forEach>
				</select> <select name="msg1" class="sb">
					<c:forEach var="m" items="${MSG_NAMESET}">
						<option value="${m}">${m}</option>
					</c:forEach>
				</select>



			</div>
		</div>

		<div align="center">
			<input type="submit" value="CREATE" class="loginbtn" />
		</div>
	</form>

</div>