<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>

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
			<c:if test='${requestScope.status != null}'>
				<b><font color="red">${requestScope.status}</font> </b>
			</c:if>
		</center>
		<center>
			<b><h4>
					District Entry Form
				</h4> </b>
		</center>


		<form action="<%=request.getContextPath() + "/addDistrictAction.do"%>"
			name="district">


			<table cellspacing=2 align="center" bgcolor="#87CEEB" width="325"
				height="60">

				<tr>
					<td align='right'>
						<b>StateName :</b>
					</td>
					<td>
						<select name="stateid" id="select">
							<option>
								--SELECT--
							</option>
							<c:if test="${not empty vStates}">
								<c:forEach var="State" items="${vStates}">
									<option value="${State.stateid}">
										${State.statename}
									</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>

				<tr>
					<td align='right'>
						<b>DistrictName :</b>
					</td>
					<td>
						<input type=text name="districtname" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<input type=submit value="District" />
					</td>
					<td>
						<input type=submit value=Clear />
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("district");
frmvalidator.addValidation("stateid", "dontselect=0");
frmvalidator.addValidation("districtname", "req", "District Name is required");
frmvalidator.addValidation("districtname", "alpha",
		"District Name is Only Characters");
</script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
