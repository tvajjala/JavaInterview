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

											if (counter > 5) {
												alert("Only 5 textboxes allow");
												return false;
											}

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
															'<input class="tf" size="30" name="msgname'+counter +'" id="msgname'+counter+'"/>'
																	+ '&nbsp;&nbsp; <input class="tf" size="30" name="msgid' + counter + '" id="msgid' + counter + '" />');

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
</script>

<div class="securemainbody">
<br/>
	<div class="left gride900" ><h2>Message Creation</h2></div>
<br/>
	<form action="updateMessages.htm" method="post" class="white">
<div class="left mb15" style="width: 100%; text-align: center;">	
			<%-- <span class="title">Select Category :</span> &nbsp; <select id="project_module"
				name="project_module" class="selectbox2">
				<option value="">Select</option>
				<c:forEach var="module" items="${PROJECT_MODULES }">
					<option value="${module}">${module}</option>
				</c:forEach>
			</select> --%> <input type="hidden" name="project_name" id="project_name"
				value="${PROJECT_NAME }" />
				
		<div id="errormsg">${msg}</div>		
</div>	
		
<br/> <br/>
		
			<table class="dynaLabel" style="width: 500px;">
				<tr>
					<th class="dynaLabel" style="text-align:left;"><a href="#"
						id="addButton" class="dynaTxtLink">(+) </a>
						&nbsp;&nbsp;&nbsp;<span class="title"> Message Reference</span></th>
					<th class="dynaLabel" style="text-align:right;"><span class="title">Actual Message</span> 
						&nbsp;&nbsp;&nbsp;<a href="#" id="removeButton"
						class="dynaTxtLink"> (-)</a>
					</th>
				</tr>
			</table>
		


		<div id='TextBoxesGroup' style="width: 100%; text-align: center;">
			<div id="TextBoxDiv1" style="height: 30px">
				<input type="text" name="msgname1" id="msgname1" class="tf"
					size="30" /> &nbsp;&nbsp; <input type="text" id='msgid1'
					name="msgid1" class="tf" size="30" />
			</div>
		</div>

		<div align="center">
			<input type="submit" value="CREATE" class="loginbtn" />
		</div>
	</form>

</div>