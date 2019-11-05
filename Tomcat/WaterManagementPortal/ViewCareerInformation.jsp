<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript">
</script>


	</head>

	<body>

		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<b><h4>
					Career Information
				</h4> </b>
		</center>
		<form
			action="<%=request.getContextPath() + "/DeleteCitiesAction.do"%>"
			name="city">
			<center>
				<table border='1'>
					<tr bgcolor="ashblue">
						<c:if test="${role == null}">
							<td></td>
						</c:if>
						<td>
							<b>Career Opertunity</b>
						</td>
						<td >
							<b>About Career</b>
						</td>
						<td >
							<b>More Info</b>
						</td>
						<td>
							<b>Site URL</b>
						</td>
					</tr>

					<c:if test="${not empty vEducations}">
						<c:forEach var="career" items="${vEducations}">
							<tr>
								<c:if test="${sessionScope.role == null}">
									<td align='center'>
										<input type="checkbox" name='ch'
											value="${career.educationid }">
									</td>
								</c:if>
								<td align="center">
									<b> ${career.educationname } </b>
								</td>
								<td align="center">
									<b> ${career.educationdescription } </b>
								</td>
								<td align="center">
									<b> <a href="${career.educationdocumentaion}">${career.educationname
											}</a> </b>

								</td>
								<td align="center">
									<b> <a href="${career.siteurl}">${career.siteurl}</a> </b>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${sessionScope.role == null}">
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
