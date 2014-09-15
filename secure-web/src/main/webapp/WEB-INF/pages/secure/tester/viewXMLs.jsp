<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<script type="text/javascript">
	function openPage(url) {
		window
				.open(url, "mywindow",
						"menubar=0,location=0,toolbar=0,status=0,resizable=1,width=450,height=350");
	}
	function submitViewFile(file,place) {
		document.forms["editxmls"].fname.value = file;
		document.forms["editxmls"].filePlace.value = place; 
		document.forms["editxmls"].submit();
	}
	function updateFile() {
		var lbl = document.forms["editxmls"].fileaction.value;
		
		if (lbl == "Save") {
			document.forms["editxmls"].fileAct.value = "Save";
			document.forms["editxmls"].submit();
		}else{
			document.getElementById("fileArea").readOnly = false;
			document.forms["editxmls"].fileaction.value = "Save";
		}
	}
</script>

<div class="securemainbody">
	<form action="editXMLs.htm" method="post" class="white" name="editxmls">
		<div class="left mb15" style="width: 100%; text-align: center;">
			<span class="title">Select Category :</span> &nbsp; <select
				id="project_module" name="project_module" class="selectbox2"
				onchange="submit()">
				<option value="">Select</option>
				<c:forEach var="module" items="${PROJECT_MODULES }">
					<option value="${module}"
						<c:if test="${module==SELECTED_MODULE}"> selected="selected" </c:if>>${module}</option>
				</c:forEach>
			</select> <input type="hidden" name="project_name" id="project_name"
				value="${PROJECT_NAME }" /> <br />
			<div id="errormsg">${msg}</div>
			<br />


			<!-- <tr>
					<th style="width: 320px;">XML File Name</th>
					<th>View</th>
					<th>Edit</th>
				</tr> -->

			<table id="usertable">
				<tr>
					<c:set var="fcount" value="1" scope="page" />
					<c:forEach var="fname" items="${PROJECT_FILES}">
						<td><a href="#"
							onclick="javascript:submitViewFile('${fname}','prj')"
							class="dynaTxtLink" title="Click to View File Content ">${fname}
						</a></td>
						<c:if test="${fcount % 5 == 0}"></tr><tr></c:if>
					    <c:set var="fcount" value="${fcount + 1}" scope="page" />
					</c:forEach>
				</tr>
				<tr>	
					<c:set var="fcount" value="1" scope="page" />
					<c:forEach var="mfname" items="${MODULE_FILES}">
						<td><a href="#"
							onclick="javascript:submitViewFile('${mfname}','mod')"
							class="dynaTxtLink" title="Click to View File Content ">${mfname}
						</a></td>
						<c:if test="${fcount % 5 == 0}"></tr><tr></c:if>
					    <c:set var="fcount" value="${fcount + 1}" scope="page" />
					</c:forEach>
					
				</tr>
			</table>
			<br/>
			<input type="hidden" name="filePlace" value="${FILE_PLACE}"> 
			<input type="hidden" name="fileAct" value=""> <input
				type="hidden" name="fname" value="${SelFileName}">
			<c:if test="${FileAreaDisplay}">
				<table width="100%">
					<tr>
						<td align="center"><textarea rows="15" cols="80"
								id="fileArea" name="fileArea" readonly="readonly">${SEL_FILE}</textarea>
						</td>
					</tr>
					<tr>
						<td align="center"><input type="button" name="fileaction"
							onclick="updateFile()" value="Edit" /></td>
					</tr>
				</table>
			</c:if>

		</div>
	</form>
</div>