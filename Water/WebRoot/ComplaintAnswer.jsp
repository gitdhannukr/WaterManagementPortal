<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
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
	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>

		<form name="complaint" action="./ComplaintAnswerAction.do">
			<table align="center" bgcolor="#ffddd">
				<tr>
					<td align="center" colspan="2" bgcolor="nabi">
						<font color="white"><b>Complaint Form</b> </font>
					</td>
				</tr>


				<tr>
					<td align='right'>
						<b>Complaint :</b>
					</td>
					<td>
						<input type='text' name="complaint"
							value="<%=request.getParameter("complaint")%>" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>Complaint Answer :</b>
					</td>
					<td>
						<textarea name="complaintsolution" value="">
</textarea>
					</td>
				</tr>
				<input type='hidden' name='cityidref' value='${sessionScope.cityid}' />
				<input type='hidden' name='complaintid'
					value='<%=request.getParameter("complaintid")%>' />
				<input type='hidden' name='complaintstatusstatus' value='Solved' />
				<tr>
					<td align='right'>
						<input type="submit" value="Post Complaint">
					</td>
					<td>
						<input type="reset" value="Cancel">
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("complaint");

frmvalidator.addValidation("complaint", "req", "Please enter Complaint");

frmvalidator.addValidation("complaintsolution", "req",
		"Please enter Complaint Solution");
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
