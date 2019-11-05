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
		<script type="text/javascript">

function StateChange() {

	var stateid = document.getElementById('stateid').value;
	var statename = document.getElementById('statename').value;
<!--alert(state);-->
		
		window.location.href="./CityDistrictAction.do?stateid="+stateid+"&statename="+statename;

		}
		

	</script>

	</head>

	<body>

		<jsp:include page="Header.jsp"></jsp:include>
		<center> <b><h4>
				Add City Form
			</h4> </b> </center>
		<form action="<%=request.getContextPath() + "/AddCityAction.do"%>"
			name="city" method='post'>
			<center>
			<table>
				<tr>
					<td align='right'>
						<b>StateName :</b>
					</td>
					<td>
						<select name="stateid" id="select"
							onchange=" return StateChange();">
							<c:choose>
								<c:when test="${requestScope.statename ne null}">
									<option value="${requestScope.stateid}">
										${requestScope.statename}
									</option>
								</c:when>
								<c:otherwise>
									<option value="">
										--SELECT--
									</option>
									<c:if test="${not empty vStates}">
										<c:forEach var="State" items="${vStates}">
											<option value="${State.stateid},${State.statename}">
												${State.statename}
											</option>
										</c:forEach>
									</c:if>
								</c:otherwise>
							</c:choose>
							<input type="hidden" value="${requestScope.statename }"
								name="statename">
								<input type="hidden" value="${requestScope.vStates }"
									name="vStates">
						</select>

					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>DistrictName :</b>
					</td>
					<td>
						<select name="districtid" id="select">
							<c:choose>
								<c:when test="${requestScope.districtname ne null}">
									<option value="${requestScope.districtid}">
										${requestScope.districtname}
									</option>
								</c:when>
								<c:otherwise>
									<option value="">
										--SELECT--
									</option>
								</c:otherwise>
							</c:choose>
							<c:if test="${not empty vDistricts}">
								<c:forEach var="District" items="${vDistricts}">
									<option value="${District.districtid}">
										${District.districtname}
									</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>


				<tr>
					<td align='right'>
						<b>CityName :</b>
					</td>
					<td>
						<input type=text name="cityname" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>CityDescription :</b>
					</td>
					<td>
						<textarea rows="" cols="" name="citydescription"></textarea>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>CityMAP :</b>
					</td>
					<td>
						<input type='file' name="imagepath" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<input type=submit value=ADD CITY>
					</td>
					<td>
						<input type=reset value=Clear>
					</td>
				</tr>
			</table>
			</center>
		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("city");

frmvalidator.addValidation("districtid", "dontselect=0");
frmvalidator.addValidation("cityname", "req", "City Name is required");
frmvalidator.addValidation("cityname", "alpha", "City Name is Only Characters");
frmvalidator.addValidation("citydescription", "req", "City Name is required");
</script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
