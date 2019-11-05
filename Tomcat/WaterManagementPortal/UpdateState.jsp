<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
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

	</head>

	<body>


		<jsp:include page="Header.jsp"></jsp:include>
		<br />

		<center>
			<b><h4>
					StateUpdate Form
				</h4> </b>
		</center>


		<form action="./updateState.do" method="post" name="stateupdate">



			<table cellspacing=2 align="center" bgcolor="ashblue" width="325"
				height="60">

				<c:if test="${not empty state}">


					<tr>
						<td align='right'>
							<b>StateID :</b>
							<br>
						</td>
						<td>
							<input type=text name="stateid" value="${state.stateid }"
								readonly="readonly" />
							<br>
							<tr>
								<td align='right'>
									<b>State Name :</b>
									<br>
								</td>
								<td>
									<input type=text name="statename" value="${state.statename }" />
									<br>
								</td>
								<td>
									<br>
								</td>
							</tr>
				</c:if>
				<tr>
					<td align='right'>
						<input type=submit value="UPDATE" />
						<br>
					</td>
					<td>
						&nbsp;
						<input type=submit value=cancel />
						<br>
					</td>
				</tr>

			</table>



		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("stateupdate");

frmvalidator.addValidation("stateid", "req", "State ID is required");
frmvalidator.addValidation("statename", "req", "State Name is required");
frmvalidator.addValidation("statename", "alpha",
		"State Name is Only Characters");
frmvalidator.addValidation("statename", "alpha",
		"State Name is Only Characters");
</script>

		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
