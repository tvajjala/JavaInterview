<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"/>

<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/main.js"></script>


<portlet:actionURL var="registerPatient">
	<portlet:param name="action" value="registerPatient"></portlet:param>
</portlet:actionURL>




<div class="container">

    <form id="signup" action="${registerPatient}" method="post">

        <div class="header">
            	<h3>Patient Portal Registration</h3>
            <p>
		<liferay-ui:error key="registration.failed" message="Registration Failed" />
		<liferay-ui:error key="profile.notfound" message="MR number not found in the Napier Database" />
		<liferay-ui:error key="profile.exists" message="Profile with this MR Number already registed in the portal" />
		
			</p>
            
        </div>
        
        <div class="sep"></div>

        <div class="inputs">
        
      	  	<select name="userType">
					<c:forEach var="u" items="${userTypes}">
						<option value="${u}">${u}</option>
					</c:forEach>
			</select>
			
             <input type="text" name="mrnumber" placeholder="MR Number" />
            
             <input type="text" name="name" placeholder="Patient Name" />
                
   			 <input type="text" name="phone" placeholder="phone" />
   			 
   			 <input type="text" name="email" placeholder="email" />
            
            <input type="submit" id="submit" value="Register"/>
        
        </div>

    </form>

</div>





















</body>
</html>
