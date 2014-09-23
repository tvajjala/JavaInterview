<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<script type="text/javascript">
	function executeSuites() {

		var suiteArray = new Array();
		var configArray = new Array();

		var suteObj = document.getElementById("suite_name");
		var i;
		var count = 0;
		for (i = 0; i < suteObj.options.length; i++) {
			if (suteObj.options[i].selected) {
				if (suteObj.options[i].value != "") {
					suiteArray[count] = suteObj.options[i].value;
					count++;
				}
			}
		}

		var configObj = document.getElementById("config_name");
		var a;
		var c = 0;

		for (i = 0; i < configObj.options.length; i++) {
			if (configObj.options[i].selected) {
				if (configObj.options[i].value != "") {
					configArray[count] = configObj.options[i].value;
					count++;
				}
			}
		}

		var url = "runExectution.htm";
		var params = "cname=" + configArray + "&sname=" + suiteArray
				+ "&etype=" + document.getElementById("execution_type").value;
		retrieveVTRAJAXURL(url, responseMethod, params);
		document.getElementById("loadImg").style.display = "block";
	}

	function responseMethod(output) {

		document.getElementById("errormsg").innerHTML = output;
		document.getElementById("loadImg").style.display = "none";

	}

	function TestDataCheck() {
		return false;
	}
</script>


<div class="securemainbody">

	<div style="position:absolute;text-align: center; display: none; top:300px; left:820px" id="loadImg">
	<input type="image" src="/adtf/css/images/loading.gif"
		  width="50px"
		height="50px" />
		</div>
	<div class="gride900">

		<h2 >Test Execution</h2>

	</div>



	<form method="post" onsubmit="javascript:return false;">

		<div id="errormsg">${msg}</div>

		<div align="center">
			<table class="userform" style="width: 100%;">

				<tr>

					<th colspan="2" style="text-align: center; margin-bottom: 10px;">

						<p class="title4" style="text-align: center;">Select Execution
							Type</p> <select id="execution_type" name="execution_type" class="sb">
							<option value="P">Parallel</option>
							<option value="S">Sequential</option>
					</select> <input type="hidden" name="project_name" id="project_name"
						value="${PROJECT_NAME}" />


					</th>
				<tr>
				<tr>

					<th>

						<p class="title4" style="text-align: center;">Select
							Configuration</p> <select class="sb2" name="config_name"
						multiple="multiple" style="height: 120px;" id="config_name">
							<c:forEach var="c" items="${CONFIG_LIST}">
								<option value="${c.key}">${c.key} ${c.value}</option>
							</c:forEach>
					</select>
					</th>


					<th>
						<p class="title4" style="text-align: center;">Select Test
							Suite</p> <select class="sb2" name="suite_name" multiple="multiple"
						style="height: 120px;" id="suite_name">
							<c:forEach var="s" items="${SUITE_LIST}">
								<option value="${s}">${s}</option>
							</c:forEach>
					</select>
					</th>
				<tr>
			</table>
		</div>



		<div align="center" style="padding-top:20px;">
			<input type="submit" value="Execute" class="loginbtn"
				onclick="executeSuites()" />
		</div>
	</form>

</div>