<html>

<%@include file="header.jsp"%>


<body class="left-sidebar">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Content -->
		<div id="content">
			<div id="content-inner">

				<div id="logo">
					<h1>UPLOAD IMAGE</h1>
				</div>

				<form action="rest/imageService/save" method="post"
					enctype="multipart/form-data">
					
					<p align="center">
						select file: <input type="file" name="file" />
					</p>
					<input type="submit" value="UPLOAD IMAGE" />
				</form>
			</div>
		</div>
	</div>

	<%@include file="sidebar.jsp" %>
</body>
</html>