<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">

<html>



	<head>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<br />
		<form action="./DeleteDistrictAction.do " method='post'
			name='district'>
			<center>
				<h3>
					DISTRICTS INFORMATION
				</h3>
			</center>
			<center>
				<table>
					<tr>
						<td align='right'>
							<b>StateName :</b>
						</td>
						<td>
							<select name="stateid" id="select"
								onchange="javascript:if(document.district.stateid.value==''){alert('Select Any State');} else{ location.href='./viewSDistrictAction.do?stateid='+document.district.stateid.value;}">
								<c:choose>
									<c:when test="${requestScope.statename ne null}">
										<option value="${requestScope.statename}">
											${requestScope.statename}
										</option>
									</c:when>
									<c:otherwise>
										<option value="">
											--SELECT--
										</option>
										<c:if test="${not empty vStates}">
											<c:forEach var="State" items="${vStates}">
												<option value="${State.stateid}">
													${State.statename}
												</option>
											</c:forEach>
										</c:if>
									</c:otherwise>
								</c:choose>

							</select>
							<input type="hidden" value="${requestScope.statename }"
								name="statename">
							<tr>
				</table>
			</center>


			<center>
				<table border='0'>



					<tr bgcolor="ashblue">

						<c:if test="${sessionScope.role eq admin}">
							<td></td>
						</c:if>
						<td>
							<b>District Id</b>
						</td>
						<td>
							<b>District Name</b>
						</td>
					</tr>

					<c:if test="${not empty vDistricts}">
						<c:forEach var="District" items="${vDistricts}">
							<tr>
								<c:if test="${role == null}">
									<td align='right'>
										<input type="checkbox" name='ch'
											value="${District.districtid }">
									</td>
								</c:if>
								<td align="center">
									<b> ${District.districtid } </b>
								</td>


								<c:choose>
									<c:when test="${sessionScope.role eq admin}">
										<td align="center">
											<b> <a
												href="./districtViewUpdation.do?districtid=${District.districtid }">${District.districtname
													}</a> </b>

										</td>
									</c:when>

									<c:otherwise>
										<td align="center">
											<b> ${District.districtname } </b>

										</td>

									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${sessionScope.role eq admin}">
						<tr>
							<td colspan="3">
								<center>
									<input type="submit" value='Delete'>
								</center>
							</td>
						</tr>
					</c:if>
				</table>
			</center>
		</form>
		<jsp:include page="./Footer.jsp"></jsp:include>
	</body>
</html>
