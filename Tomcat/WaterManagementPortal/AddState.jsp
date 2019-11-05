<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<jsp:include page="./UserCheck.jsp"></jsp:include>

<html>

	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript"></script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<br />
		<center>
			<%
				if (request.getAttribute("status") != null) {
			%>
			<b><font color="red"><%=request.getAttribute("status")%></font> </b>
			<%
				}
			%>
		</center>
		<center>
			<b><h4>
					State Entry Form
				</h4> </b>
		</center>
		<form action="<%=request.getContextPath() + "/addStateAction.do"%>"
			name="login">
			<table cellspacing=2 align="center" bgcolor="#87CEEB" width="325"
				height="60">
				<tr>
					<td align='right'>
						<b>StateName :</b>
					</td>
					<td>
						<input type=text name="statename" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<input type=submit value=" AddState" />
					</td>
					<td>
						<input type=reset value="Clear" />
					</td>
				</tr>
			</table>
		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");

  frmvalidator.addValidation("sname","req","State Name is required");
    frmvalidator.addValidation("sname","alpha","State Name is Only Characters");

  </script>

		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
