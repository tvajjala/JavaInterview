<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div class="securemainbody">




	<div class="left gride900">
						<h2>User Management</h2>
					</div>
	<table id="usertable" >
		<tr>
			<th>User ID</th>
			<th>Name</th>
			
			<th>Role</th>
			<th>Active</th>
			<th>Update</th>
			<th>Reset Password</th>
		</tr>

		<c:forEach var="u" items="${userlist}">
			<tr>
				<td>${u.username}</td>
				<td>${u.firstname} ${u.lastname}</td>
				<td>${u.roleName}</td>

				<td><c:if test='${u.enabled=="1"}'>true</c:if> <c:if
						test='${u.enabled=="0"}'>false</c:if></td>
				<td><a href="<%=request.getContextPath()%>/admin/updateUserInfo.htm?uid=${u.username}"> <img
						src="<%=request.getContextPath()%>/css/images/edit.png" width="13"
						height="13" alt="edit" />
				</a></td>
				<td><img src="<%=request.getContextPath()%>/css/images/reset.gif"
					onclick="resetApproverPass('${u.username}')" width="13" height="13"
					alt="reset" />
			</tr>
		</c:forEach>


	</table>






</div>