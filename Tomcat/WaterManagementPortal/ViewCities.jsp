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

	var State = document.getElementById('stateid').value;

<!--alert(state);-->
		
		window.location.href="./ViewCityViewDistrictAction.do?stateid="+State;

		}
		

	</script>
		<script type="text/javascript">

function DistrictChange() {

	var districtid = document.getElementById('districtid').value;
	var districtname = document.getElementById('districtname').value;
	var statename = document.getElementById('statename').value;
	var stateid = document.getElementById('stateid').value;
<!--alert(state);-->
		
		window.location.href="./ViewCitiesAction.do?districtid="+districtid+"&districtname="+districtname+"&statename="+statename+"&stateid="+stateid;
}
		

	</script>

	</head>

	<body>

		<jsp:include page="Header.jsp"></jsp:include>
		<center> <b><h4>
				View Cities
			</h4> </b> </center>
		<form
			action="<%=request.getContextPath() + "/DeleteCitiesAction.do"%>"
			name="city">
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
							<input type="hidden" value="${District.districtname}"
								name="districtname" />
							<input type="hidden" value="${requestScope.statename }"
								name="statename">
								<input type="hidden" value="${requestScope.stateid }"
									name="stateid">
						</select>
					</td>
				</tr>

			</table>
			</center>
			<center>
			<table>
				<tr bgcolor="ashblue">

					<c:if test="${sessionScope.role eq admin}">
						<td></td>
					</c:if>
					<td>
						<b>City Id</b>
					</td>
					<td>
						<b>City Name</b>
					</td>
					<td>
						<b>City Description</b>
					</td>
					<td>
						<b>City MAP</b>
					</td>
				</tr>

				<c:if test="${not empty vCities}">
					<c:forEach var="City" items="${vCities}">
						<tr>
							<c:if test="${sessionScope.role == null}">
								<td align='center'>
									<input type="checkbox" name='ch' value="${City.cityid }">
								</td>
							</c:if>
							<td align="center">
								<b> ${City.cityid } </b>
							</td>


							<c:choose>
								<c:when test="${sessionScope.role eq admin}">
									<td align="center">
										<b> <a href="./CityViewUpdation.do?cityid=${City.cityid }">${City.cityname
												}</a> </b>
									</td>
								</c:when>

								<c:otherwise>
									<td align="center">
										<b> ${City.cityname } </b>

									</td>

								</c:otherwise>
							</c:choose>
							<td align="center">
								<b> ${City.citydescription } </b>
							</td>
							<td align="center">
								<b> <img alt="" src="${City.imagepath }" height=50
										width=50 /> </b>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${sessionScope.role eq admin}}">
					<tr>
						<td colspan="3">
							<center> <input type="submit" value='Delete'></center>
						</td>
					</tr>
				</c:if>
			</table>
			</center>
		</form>
		<jsp:include page="./Footer.jsp"></jsp:include>
	</body>
</html>
