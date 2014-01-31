<html>
<body>
	<h1>JAX-RS IMAGE UPLOADING</h1>

	<form action="rest/imageService/save" method="post"
		enctype="multipart/form-data">
		<p>
			select file : <input type="file" name="file" />
		</p>
		<input type="submit" value="SAVE IMAGE" />
	</form>

</body>
</html>