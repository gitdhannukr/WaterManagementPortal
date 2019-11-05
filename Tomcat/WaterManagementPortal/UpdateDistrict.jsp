<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<%@ page session="true"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html>

	<head>

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
		<br />

		<center>
			<b><h4>
					District Update Form
				</h4> </b>
		</center>


		<form
			action="<%=request.getContextPath() + "/UpdateDistrictAction.do"%>"
			method="post" name="updatedistrict">




			<table cellspacing=2 align="center" bgcolor="ashblue" width="325"
				height="60">

				<c:if test="${not empty district}">


					<tr>
						<td align='right'>
							<b>District ID :</b>
							<br>
						</td>
						<td>
							<input type=text name="districtid"
								value="${district.districtid }" readonly="readonly" />
							<br>
							<tr>
								<tr>
									<td align='right'>
										<b>District Name :</b>
										<br>
									</td>
									<td>
										<input type=text name="districtname"
											value="${district.districtname }" />
										<br>
									</td>
									<td>
										<br>
									</td>
								</tr>
				</c:if>
				<tr>
					<td colspan=2 align='center'>
						<input type=submit value="UPDATE" />
						<br>
					</td>
					<td>
						&nbsp;
						<br>
					</td>
				</tr>

			</table>



		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("updatedistrict");
frmvalidator.addValidation("districtid", "req", "District ID is required");
frmvalidator.addValidation("districtname", "req", "District Name is required");
frmvalidator.addValidation("districtname", "alpha",
		"District Name is Only Characters");
</script>

		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
