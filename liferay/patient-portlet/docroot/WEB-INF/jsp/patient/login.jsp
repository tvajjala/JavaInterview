<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"/>

<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/main.js"></script>




<portlet:defineObjects />

<portlet:actionURL var="loginFormURL">
	<portlet:param name="action" value="login"></portlet:param>
</portlet:actionURL>


<portlet:renderURL var="registrationURL">
	<portlet:param name="next" value="registration" />
</portlet:renderURL>

<portlet:renderURL var="forgotPassword">
	<portlet:param name="action" value="forgotPassword" />
</portlet:renderURL>



<div class="container">

    <form id="signup" action="${loginFormURL}" method="post">

        <div class="header">
            <h3>Patient Portal</h3>
            <p>
		<liferay-ui:error key="login.fail" message="Invalid Credentials" />
			</p>
            
        </div>
        
        <div class="sep"></div>

        <div class="inputs">
        
            <input type="text" name="nh_username" placeholder="Username(MR Number)" autofocus />
        
            <input type="password" name="nh_password" placeholder="Password" />
            
            <input type="submit" id="submit" value="SignIn"/>
     
     
     			<a href="${registrationURL}">  registration</a>   <br>
     			
     			<a href="${forgotPassword}">  forgot Password</a>   
        </div>

    </form>

</div>








