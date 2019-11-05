<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
		</script>
		<script type="text/javascript">

function StateChange() {

	var stateid = document.getElementById('stateid').value;
	var statename = document.getElementById('statename').value;
<!--alert(state);-->
		
		window.location.href="./ViewRegistrationCityViewDistrictAction.do?stateid="+stateid+"&statename="+statename;

		}
		

	</script>
		<script type="text/javascript">

function DistrictChange() {

	var districtid = document.getElementById('districtid').value;
	var districtname = document.getElementById('districtname').value;
	var statename = document.getElementById('statename').value;
	var stateid = document.getElementById('stateid').value;
<!--alert(state);-->
		
		window.location.href="./ViewRegistrationCitiesAction.do?districtid="+districtid+"&districtname="+districtname+"&statename="+statename+"&stateid="+stateid;
}
		

	</script>

	</head>

	<body>

		<jsp:include page="Header.jsp"></jsp:include>

		<center> <b><h4>
				Contact Details
			</h4> </b> </center>

		<form action="./UserRegisterAction.do" method='post' name="address">
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
						</select>

					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>DistrictName :</b>
					</td>
					<td>
						<select name="districtid" id="select"
							onchange=" return DistrictChange();">
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
									<option value="${District.districtid},${District.districtname}">
										${District.districtname}

									</option>
								</c:forEach>
							</c:if>
						</select>
						<input type="hidden" value="${District.districtname}"
							name="districtname" />
						<input type="hidden" value="${requestScope.statename }"
							name="statename">
							<input type="hidden" value="${requestScope.stateid }"
								name="stateid">
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>City Name :</b>
					</td>
					<td>

						<select name="cityid" id="select">
							<c:choose>
								<c:when test="${requestScope.cityname ne null}">
									<option value="${requestScope.cityid}">
										${requestScope.cityname}
									</option>
								</c:when>
								<c:otherwise>
									<option value="">
										--SELECT--
									</option>
								</c:otherwise>
							</c:choose>
							<c:if test="${not empty vCities}">
								<c:forEach var="City" items="${vCities}">
									<option value="${City.cityid}">
										${City.cityname}

									</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>

				<tr>
					<td align='right'>

						<b> Country :</b>

					</td>
					<td>
						<input type="text" name="country" value="INDIA" size="20" readonly />
					</td>
				</tr>


				<tr>
					<td align='right'>

						<b>Address Type :</b>

					</td>
					<td>
						<select name="addresstype" onChange="cleartext()">
							<option value="select" selected="true">
								<font size="3" face="Verdana">Select </font>
							</option>
							<option value="home">
								<font size="3" face="Verdana">Home</font>
							</option>
							<option value="office">
								<font size="3" face="Verdana">Office</font>
							</option>
							<option value="personal">
								<font size="3" face="Verdana">Personal</font>
							</option>
						</select>
					</td>
				</tr>
				<tr>

					<td align='right'>

						<b>House No :</b>

					</td>
					<td>
						<input type="text" name="houseno" value="" size="20" />
					</td>
				</tr>
				<tr>
					<td align='right'>

						<b>Street :</b>

					</td>
					<td>
						<input type="text" name="street" value="" size="20" />
					</td>
				</tr>

				<tr>
					<td align='right'>

						<b>Pin :</b>

					</td>
					<td>
						<input type="text" name="pincode" value="" size="20"
							onChange="showStatus()" />
					</td>
				</tr>
				<tr>
					<td align='right'>

						<b>Phone Type :</b>

					</td>
					<td>
						<select name="phonetype">
							<option value="select" selected="true">
								<font size="3" face="Verdana">Select</font>
							</option>
							<option value="home">
								<font size="3" face="Verdana">Home</font>
							</option>
							<option value="office">
								<font size="3" face="Verdana">Office</font>
							</option>
							<option value="mobile">
								<font size="3" face="Verdana">Mobile</font>
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align='right'>

						<b>Phone No :</b>

					</td>
					<td>
						<input type="text" name="phoneno" value="" size="20"
							onBlur="ValidateForm()" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<input type='submit' value='Register' />
					</td>
					<td>
						<input type="reset" value="clear" />
					</td>
				</tr>
			</table>
		</form>

		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("address");

frmvalidator.addValidation("country", "req", "Please enter Country");

frmvalidator.addValidation("addresstype", "dontselect=0");
frmvalidator.addValidation("houseno", "req", "Please enter House No");
frmvalidator.addValidation("street", "req", "Please enter Street Name");
frmvalidator.addValidation("pincode", "req", "Please enter PinCode");

frmvalidator.addValidation("pincode", "req", "Please enter PinCode");

frmvalidator.addValidation("phonetype", "dontselect=0");
frmvalidator.addValidation("phoneno", "req");

frmvalidator.addValidation("phoneno", "maxlen=50");
frmvalidator.addValidation("phoneno", "numeric");
frmvalidator.addValidation("phoneno", "Phone");
</script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
