<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="auth" uri="spring.security.taglib.tld"%>
<div class="header">
	<table id="bannerTable" width="100%">
		<tr>
			<td style="padding-left: 25px">
				<div class="left">
					<h1>SuteTouch</h1>
				</div>

				<div class="right">
					<form name='loginform'
						action="<c:url value='j_spring_security_check' />" method='POST'
						autocomplete="off">
						<table class="loginform">
							<tr>
								<td colspan="3" class="username" height="20px"><c:if
										test="${not empty error}">
										<div class="error">
											${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
									</c:if></td>
							</tr>
							<tr>

								<td class="username">Username:<input type='text'
									name='j_username' value='' class="textfield">
								</td>


								<td class="username">Password: <input type='password'
									name='j_password' class="textfield" /></td>

								<td width="30px"><input type="submit" name="login" value="Sign In" tabindex="3"
									style="margin-top: 20px; " />
								</td>

							</tr>

						</table>

					</form>
				</div></td>
		</tr>
	</table>
</div>





