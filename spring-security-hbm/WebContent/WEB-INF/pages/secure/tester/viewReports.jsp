<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<script type="text/javascript">
	function openPage(url) {
		window
				.open(url, "mywindow",
						"menubar=0,location=0,toolbar=0,status=0,resizable=1,width=450,height=350");
	}
</script>

<div class="securemainbody">
	<div class="left gride900">
		<h2 style="margin-right: 20px;">Test Reports Summary</h2>
	</div>



	<table id="usertable">
		<tr>
			<th style="width: 320px;">Suite Name</th>
			<th>TestNG</th>

			<th>iReport</th>
			<th>E-mail</th>
			<th>LogCat</th>

		</tr>
		<c:forEach var="r" items="${TESNGREPORTS}">
			<tr>
				<td>${r.suiteName}</td>
				<td><a href='javascript:openPage("${r.tNGReport}")'> view</a></td>
				<td><a href='javascript:openPage("${r.iReport}")'> view</a></td>
				<td><a href='javascript:openPage("${r.mailReport}")'> view</a></td>
				<td><a href='javascript:openPage("${r.logger}")'> view</a></td>
			</tr>
		</c:forEach>
	</table>


</div>