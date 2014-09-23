<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>
<div class="header" id="bannerTable">

<div class="left">
					<img src="<%=request.getContextPath()%>/css/images/adtf-logo.png"
						 />
				</div>

				<div class="right">
					<form name='loginform'
						action="<c:url value='j_spring_security_check' />" method='POST'
						autocomplete="off">
						<table id="bannerTable">
							<tr>
								<td colspan="2" id="mailtext">
									<p align="right">
										Welcome :<span style="text-transform: lowercase;color: #99FFFFFF"> ${FIRSTNAME} ${LASTNAME}
										 [<a href="<c:url value="/j_spring_security_logout" />"
											class="maillinks">Logout</a>]</span>
									</p></td>
							</tr>
						</table>
					</form>
				</div>
	
</div>

