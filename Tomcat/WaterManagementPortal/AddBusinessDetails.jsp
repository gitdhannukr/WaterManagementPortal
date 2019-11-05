<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="UserExceptionHandler.jsp"%>
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

		<title>My JSP 'AddEnquiryDetails.jsp' starting page</title>

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

		<form name="business" action="./AddBusinessDetails.do">
			<table align="center" bgcolor="#ffddd">
				<tr>
					<td align="center" colspan="2" bgcolor="nabi">
						<font color="white"><b>Water Liters Form</b>
						</font>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b> Water Area :</b>
					</td>
					<td>
						<select name="businessfor">
							<option value="Industrial">
								Industrial
							</option>
							<option value="HomeBased">
								HomeBased
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b> Water In Liters :</b>
					</td>
					<td>
						<input type='text' name='waterliters' value='' />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b> Water Amout :</b>
					</td>
					<td>
						<input type='text' name='wateramount' value='' />
					</td>
				</tr>


				<tr>
					<td align='right'>
						<b>Water Description:</b>
					</td>
					<td>
						<textarea name="waterdesc" height="" width="">
</textarea>
					</td>
				</tr>
				<input type='hidden' name='cityidref' value='${sessionScope.cityid}' />
				<tr>
					<td align="right">
						<input type="submit" value="ADD">
					</td>
					<td>
						<input type="reset" value="Cancel">
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("business");
frmvalidator.addValidation("businessfor", "req", "Please enter Water Need For");
frmvalidator.addValidation("waterliters", "req", "Please enter water Quentity");
frmvalidator.addValidation("wateramount", "req", "Please enter water Amount");
frmvalidator
		.addValidation("waterdesc", "req", "Please enter water Description");
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
