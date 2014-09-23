<html>

<body>
	<h2>SureTouch RESTful WebService Interface</h2>
</body>

<h3>List of REST endPoints available</h3>


<ol>

	<li>/st_login : <b>Login URL(POST) </b>
	
		<ul>
			<li>PAYLOAD :  {"st_username":"admin","st_password":"1234"}</li>
			   <li>Content Type : application/json</li>
		</ul>
		
	</li>
	

	<li>/api/user/all  <b>GET ALL USERS</b>   </li>
	<li>/api/user/{username}  <b>GET User by username</b>   </li>
	
	
	
	<li>/api/clinic/all  <b>GET ALL USERS</b>   </li>
	<li>/api/clinic/{name}  <b>GET By Clinic Name</b>   </li>
	<li>/api/clinic/create  <b>POST</b>  
	         <span>PAYLOAD :   {"name":"CLINICNAME","active":true}</span>   
	 </li>
	<li>/api/clinic/delete/{clinicId}  <b>PUT</b>   </li>
	
	
	
	
	

</ol>



<span>install rest client from <a target="_blank" href="https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo">here</a>
</span>

</html>
