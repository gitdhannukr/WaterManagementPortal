<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd"><%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<html>
	<head>
		<title>JSP for GeneralFormBean form</title>
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
		<html:form action="/AddTipsSuggestion.do" method='post'>
			<center>
				<h3>
					Post Your Suggessition Here
				</h3>
				<table>
					<input type="hidden" name="cityidref"
						value='${sessionScope.cityid}'>
					<tr>
						<td align='right'>
							<b>Citizen Name :</b>
						</td>
						<td>
							<html:text property="citizenname" />
							<html:errors property="citizenname" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>Suggestons Description :</b>
						</td>
						<td>
							<html:textarea property="suggestonsdescription" />
							<html:errors property="suggestonsdescription" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							<b>EmailId :</b>
						</td>
						<td>
							<html:text property="emailid" />
							<html:errors property="emailid" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							<html:submit />
						</td>
						<td align='left'>
							<input type="reset" value="cancel" />
						</td>
					</tr>
				</table>
			</center>
		</html:form>
		
	</body>
</html>

