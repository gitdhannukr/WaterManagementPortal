<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'AddEducationDetails.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>

		<form name="education" action="./AddCareerInfoAction.do" method='post'>
			<table align="center" bgcolor="#ffddd">
				<tr>
					<td align="center" colspan="2" bgcolor="nabi">
						&nbsp;
						<font color="white"><b>Education Form</b> </font>
					</td>
				</tr>

				<tr>
					<td align='right'>
						&nbsp;
						<b>Career Name :</b>
					</td>
					<td>
						<input type='text' name='educationname' value='' />
					</td>
				</tr>

				<tr>
					<td align='right'>
						<b>Career Information</b><b>:</b>
					</td>
					<td>
						<textarea name="educationdescription" height="" width="">
</textarea>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>File(only pdf):</b>
					</td>
					<td>
						<input type='file' name='educationdocumentaion' value='' />
					</td>

				</tr>
				<tr>
					<td align='right'>
						<b>Site URL:</b>
					</td>
					<td>
						<input type='text' name='siteurl' value='' />
					</td>

				</tr>
				<tr>
					<td align='right'>
						<input type="submit" value="Add">
					</td>
					<td>
						<input type="reset" value="Cancel">
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("education");

frmvalidator.addValidation("educationname", "req", "Please enter Career Name");

frmvalidator.addValidation("educationdescription", "req",
		"Please enter Career Information");
</script>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
