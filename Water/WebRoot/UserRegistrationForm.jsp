

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>"
			type="text/javascript">
		</script>

		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>
		<script language="JavaScript1.1" src="scripts/pass.js">

</script>
		<script type="text/javascript" src="scripts/image.js">
</script>
		<script type="text/javascript" src="scripts/general.js">
</script>
		<script type="text/javascript" src="scripts/adi.js">
</script>
		<script type="text/javascript" src="scripts/form_validation.js">
</script>
		<script language="JavaScript" src="images/javascripts.js">
</script>
		<script language="JavaScript" src="images/pop-closeup.js">
</script>
		<script>

//var x_win = window.self; 

function goOn() {
	var port = document.register.port.value;
	var host = document.register.host.value;
	var loginname = document.register.loginname.value;
	window.location.href = 'http://' + host + ':' + port
			+ '/Water/CheckUserAction.do?loginname=' + loginname;

}
</script>



		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>
		<body>
			<jsp:include page="Header.jsp"></jsp:include>
			<h3>
				<div align="center">
					<br>
						Register Form 
				</div>
			</h3>
			<form action="./RegisterPersonalAction.do" method="post"
				name="register" onSubmit="return validate()">
				<!--<table border="1"><tr><td></td></tr></table>-->
				<input type="hidden" name="port" value="<%=request.getLocalPort()%>">
					<input type="hidden" name="host"
						value="<%=request.getServerName()%>">
						<br>

							<table border="0" align="center">
								<th colspan="6" bgcolor="#FFFFCC">
									Account Details
								</th>
								<tr>
									<td>

										User Name

									</td>
									<td width="303">
										<input type="text" name="loginname"
											value="<%if (request.getParameter("loginname") != null)
				out.print(request.getParameter("loginname"));%>"
											size="20" onBlur="goOn()" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font color='red'>
										<c:if test="${requestScope.status1!='null'}">
											<c:out value="${requestScope.status1}"></c:out>
										</c:if> </font>
									</td>
								</tr>
								<tr>
									<td>
										PassWord
									</td>
									<td>
										<input type="password" name="password"
											onkeyup="testPassword(document.forms.register.password.value);"
											onChange="Encrypt(document.forms.register.password.value);">
									</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<a id="Words"> Strength:</a>
									</td>
									<td>
										<table cellpadding=0 cellspacing=0>
											<tr>
												<td height=15 bgcolor=#dddddd></td>
											</tr>
										</table>
									</td>
								</tr>

								<tr>
									<td>

										Confirm


									</td>
									<td>
										<input type="password" name="conformpassword" value=""
											size="20" onBlur="checkconformpassword()" />
									</td>
								</tr>
								<tr>
									<td>

										UserType :

									</td>
									<td>
										<select name="logintype">
											<option value="select" selected="true">
												<font size="3" face="Verdana">Select</font>
											</option>
											<c:choose>
												<c:when test="${sessionScope.role eq 'admin'}">
													<option value="subadmin">
														<font size="3" face="Verdana">SubAdmin</font>
													</option>
												</c:when>
												<c:otherwise>
													<option value="citizen">
														<font size="3" face="Verdana">Citizen</font>
													</option>
												</c:otherwise>
											</c:choose>



										</select>
									</td>
								</tr>
								<tr>
									<td>

										SecurityQuestion

									</td>
									<td>
										<select name="forgotpwquestion">
											<option value="select" selected="true">
												<font size="3" face="Verdana">--Select One---</font>
											</option>
											<option value="What is your favorite pastime?">
												<font size="3" face="Verdana">What is your favorite
												pastime?</font>
											</option>
											<option value="Who your childhood hero?">
												<font size="3" face="Verdana">Who your childhood
												hero?</font>
											</option>
											<option value="What is the name of your first school?">
												<font size="3" face="Verdana">What is the name of
												your first school?</font>
											</option>
											<option value="Where did you meet your spouse?">
												<font size="3" face="Verdana">Where did you meet your
												spouse?</font>
											</option>
											<option value="What is your favorite sports team?">
												<font size="3" face="Verdana">What is your favorite
												sports team?</font>
											</option>
											<option value="What is your father middle name?">
												<font size="3" face="Verdana">What is your father
												middle name?</font>
											</option>
											<option value="What was your high school mascot?">
												<font size="3" face="Verdana">What was your high
												school mascot?</font>
											</option>
											<option value="What make was your first car or bike?">
												<font size="3" face="Verdana">What make was your
												first car or bike?</font>
											</option>
											<option value="What is your pet name?">
												<font size="3" face="Verdana">What is your pet name?</font>
											</option>
										</select>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<!--  <input type="checkbox" name="ch" value="1"
							onClick="check(register)" />
						Own Question-->

									</td>
								</tr>
								<tr>
									<td>
										<font size="3" face="verdana"></font>

									</td>
									<td>
										<!--	<input type="text" name="ownquest" disabled="disabled" size="37" /> -->
									</td>
								</tr>
								<tr>
									<td>

										Security Answer

									</td>
									<td>
										<input type="text" name="forgotpwanswer" value="" size="20" />
									</td>
								</tr>

								<tr></tr>
								<tr></tr>
								<th colspan="6" bgcolor="#FFFFCC">
									Personal Details
								</th>
								<tr></tr>
								<tr></tr>
								<tr>
									<td>

										First Name

									</td>
									<td width="276">
										<input type="text" name="firstname" value="">
									</td>
								</tr>
								<tr>
									<td width="139">

										Last Name

									</td>
									<td width="276">
										<input type="text" name="lastname" value="" size="20" />
									</td>
								</tr>
								<tr>
									<td>

										Birth Date

									</td>
									<td>
										<input type="text" name="birthDate" value="" size="20"
											readonly="readonly" />
										<a
											href="javascript:show_calendar('document.register.birthDate', document.register.birthDate.value);">
											<img src="images/cal.gif" alt="a" width="18" height="18"
												border="0" /> </a>
									</td>
								</tr>
								<tr>
									<td>

										Browse Photo

									</td>
									<td>
										<img alt="See Photo Here" id="previewField"
											src="images/flag.gif" height="150" width="120">
											<input type="file" name="photograph" class="textfield"
												onChange="preview(this)" />
								</tr>
								<tr>
									<td>

										Gender

									</td>
									<td>
										<select name="gender">
											<option value="select" selected="true">
												<font size="3" face="Verdana">Select </font>
											</option>
											<option value="Male">
												<font size="3" face="Verdana">Male</font>
											</option>
											<option value="Female">
												<font size="3" face="Verdana">Female</font>
											</option>
										</select>
									</td>
									<tr>
										<td>

											Email

										</td>
										<td>
											<input type="text" name="emailid" value="" size="20" />
										</td>
									</tr>
									<tr>
										<td>

											Fax No

										</td>
										<td>
											<input type="text" name="fax" value="" size="20" />
										</td>
									</tr>



									<tr>
										<td></td>
										<td align="center">
											<font size="3" face="Verdana"> <input type="submit"
												name="register" value="next" />&nbsp; <input type="reset"
												name="cancel" value="Cancel" /> </font>
										</td>
										<td align="center"></td>
									</tr>
							</table>
			</form>

			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("register");

frmvalidator.addValidation("loginname", "req", "Please enter LoginName");
frmvalidator.addValidation("loginname", "maxlen=20",
		"Max length for LoginName is 20");
frmvalidator.addValidation("password", "req", "Please enter Password");
frmvalidator.addValidation("password", "maxlen=20",
		"Max length for LoginName is 20");
frmvalidator.addValidation("logintype", "dontselect=0");
frmvalidator.addValidation("forgotpwquestion", "dontselect=0");

frmvalidator.addValidation("forgotpwanswer", "req",
		"Please enter Security Question Answer");
frmvalidator.addValidation("forgotpwanswer", "req",
		"Please enter Security Question Answer");

frmvalidator.addValidation("firstname", "req", "Please enter FirstName");
frmvalidator.addValidation("firstname", "maxlen=20",
		"Max length for FirstName is 20");
frmvalidator.addValidation("firstname", "alpha",
		" First Name Alphabetic chars only");
frmvalidator.addValidation("lastname", "req", "Please enter LastName");
frmvalidator.addValidation("lastname", "maxlen=20",
		"Max length for LastName is 20");
frmvalidator.addValidation("lastname", "alpha",
		" Last Name Alphabetic chars only");
frmvalidator.addValidation("birthDate", "req", "Please enter your DOB");
frmvalidator.addValidation("photograph", "req", "Please Load Your Photo");
frmvalidator.addValidation("gender", "dontselect=0");

frmvalidator.addValidation("emailid", "maxlen=50");
frmvalidator.addValidation("emailid", "req");
frmvalidator.addValidation("emailid", "email");

frmvalidator.addValidation("fax", "req", "Please enter Fax Number");
</script>
			<jsp:include page="Footer.jsp"></jsp:include>
		</body>
</html>
