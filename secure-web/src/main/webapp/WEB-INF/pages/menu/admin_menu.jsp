<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>

<div class="securemainbody">

	<ul class="unorderlist">



		<li>Project Management
			<ol class="sublist">
				<li><a href="<%=request.getContextPath()%>/admin/createProject.htm"> Create Project</a></li>

				<li><a href="<%=request.getContextPath()%>/admin/createModules.htm"> Create Modules</a></li>
			</ol>
		</li>

		<li><a
			href="<%=request.getContextPath()%>/admin/showAllUsers.htm"> User
				Management</a>

			<ol class="sublist">
				<li><a
					href="<%=request.getContextPath()%>/admin/createUser.htm">
						Create User</a></li>
				<!-- <li><a href="#"> Assign to Project</a></li>
				<li><a href="#"> Assign to Organization</a></li> -->
			</ol></li>


		<li><a href="<%=request.getContextPath()%>/admin/updateInfo.htm">Personal
				Information</a></li>
	</ul>


</div>