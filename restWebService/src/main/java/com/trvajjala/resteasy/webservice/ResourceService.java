package com.trvajjala.resteasy.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/imageService")
public class ResourceService {

	// this will save image as well as return image

	// http://localhost:8080/restWebService/upload.jsp

	@POST
	@Path("/save")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	// what service consumes
	@Produces("image/jpeg")
	// what service produces
	public Response uploadAndShow(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws Exception {

		writeToDisk(uploadedInputStream, fileDetail.getFileName());

		File f = new File(ResourceService.class.getClassLoader()
				.getResource("noImage.jpg").getFile());

		try {

			f = new File(fileDetail.getFileName());
			System.out.println("File reading from location "
					+ f.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}

		InputStream is = new FileInputStream(f);

		String mt = new MimetypesFileTypeMap().getContentType(f);

		System.out.println(" content type :  " + mt);

		return Response.ok(is, "image/jpeg").build();

	}

	// this will read image based on name
	// http://localhost:8080/restWebService/rest/imageService/1.jpg
	@GET
	@Path("/{image}")
	@Produces("image/*")
	public Response getImage(@PathParam("image") String image) throws Exception {

		File f = new File(ResourceService.class.getClassLoader()
				.getResource("noImage.jpg").getFile());

		try {
			f = new File(ResourceService.class.getClassLoader()
					.getResource(image).getFile());
		} catch (Exception e) {

		}

		InputStream is = new FileInputStream(f);

		// String mt = new MimetypesFileTypeMap().getContentType(f);

		return Response.ok(is, "image/jpeg").build();
	}

	// this will writes into disk
	private void writeToDisk(InputStream uploadedInputStream, String name) {

		try {
			OutputStream out = new FileOutputStream(new File(name));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();

			System.out.println("file saved at : "
					+ new File(name).getAbsolutePath());
		} catch (IOException e) {

			// e.printStackTrace();
		}

	}

}
