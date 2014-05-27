<html>

<%@include file="header.jsp"%>

<body class="left-sidebar">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Content -->
		<div id="content">
			<div id="content-inner">

				<div id="logo">
					<h1>REGISTRATION FORM</h1>
				</div>

				<form action="rest/empService/add" method="post">
					<p>
						Full Name : <input type="text" name="name" class="text"
							autocomplete="off" placeholder="name" />
					</p>
					<p>
						Designation : <input type="text" name="job" class="text"
							autocomplete="off" placeholder="designation" />
					</p>
					<p>
						Phone : <input type="text" name="phone" class="text"
							autocomplete="off" placeholder="phone" />
					</p>
					<input type="submit" value="Create User" />
				</form>


			</div>
		</div>


		<%@include file="sidebar.jsp"%>

	</div>


</body>
</html>