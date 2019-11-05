<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<jsp:include page="./UserCheck.jsp"></jsp:include><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html>

	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>"
			type="text/javascript">
		</script>


	</head>

	<body>

		<jsp:include page="Header.jsp"></jsp:include>
		<br />

		<center>
		<b><h4>
				Water Cost Update Form
			</h4> </b>
		</center>


		<form
			action="<%=request.getContextPath() + "/UpdateWaterCostAction.do"%>"
			method="post" name="updatedistrict">

			<table cellspacing=2 align="center" bgcolor="ashblue" width="325"
				height="60">

				<c:if test="${not empty waterBusiness}">


					<tr>
						<td align='right'>
							<b>Water Type :</b>
							<br>
						</td>
						<td>
							<input type=text name="businessfor"
								value="${waterBusiness.businessfor }" readonly />
							<br>
						</td>
					</tr>
					<tr>
						<td align='right'>
							&nbsp;
							<b>Water Liters:</b>
							<br>
						</td>
						<td>
							<input type=text name="waterliters"
								value="${waterBusiness.waterliters}" />
							<br>
						</td>
						<td>
							<br>
						</td>
					</tr>

					<tr>
						<td align='center'>
							&nbsp;
							<b>Water Cost:</b>

						</td>
						<td>
							<input type='text' name="wateramount"
								value="${waterBusiness.wateramount }" height="100" width="200" />
						</td>
					</tr>
					<tr>
						<td align='center'>
							&nbsp;
							<b>Water Description:</b>

						</td>
						<td>
							<input type='text' name="waterdesc"
								value="${waterBusiness.waterdesc }" height="100" width="200" />
							<input type='hidden' name="businessid"
								value="${waterBusiness.businessid }" />
						</td>
					</tr>
					<tr>

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

frmvalidator.addValidation("districtname", "req", "District Name is required");
frmvalidator.addValidation("districtname", "alpha",
		"District Name is Only Characters");
</script>

		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
