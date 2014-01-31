<html>
<body>
	<h1>JAX-RS FORM SUBMISSION Jersey REST API</h1>

	<form action="rest/empService/add" method="post">
		<p>
			Name : <input type="text" name="name" />
		</p>
		<p>
			Designation : <input type="text" name="job" />
		</p>
		<p>
			Phone : <input type="text" name="phone" />
		</p>
		<input type="submit" value="Create User" />
	</form>

</body>
</html>