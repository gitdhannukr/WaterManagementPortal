<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<jsp:include page="./UserCheck.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">

			<title>My JSP 'ViewFeedBacks.jsp' starting page</title>

			<meta http-equiv="pragma" content="no-cache">
				<meta http-equiv="cache-control" content="no-cache">
					<meta http-equiv="expires" content="0">
						<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
							<meta http-equiv="description" content="This is my page">
								<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<form action="./DeletewaterCostAction.do" mehtod='post'>

			<jsp:include page="Header.jsp"></jsp:include>
			<br />
			<center>
			<table border='0'>
				<caption>
					<h3>
						Water Cost Inforamtion
					</h3>
				</caption>


				<tr bgcolor="ashblue">
					<%
						if (session.getAttribute("role").equals("admin")) {
					%>
					<td>
						<br>
							<br>
					</td>
					<%
						}
					%>
					<td>
						<b>Water Cost Type </b>
					</td>
					<td>
						<b>Liters </b>
					</td>
					<td>
						<b>Amount</b>
					</td>
					<td>
						<b>Water Description </b>
					</td>
				</tr>
				<c:if test="${not empty vWaterBusinesses}">
					<c:forEach var="cost" items="${vWaterBusinesses}">
						<tr>
							<%
								if (session.getAttribute("role").equals("admin")) {
							%>
							<td align='right'>
								<input type="checkbox" name='ch' value="${cost.businessid }">
							</td>
							<%
								}
							%>
							<td align="center">
								<b><a
									href='./UpdateViewWaterCostDetailsAction.do?businessid=${cost.businessid}'>
										${cost.businessfor}</a> </b>
							</td>
							<td align="center">
								<b> ${cost.waterliters} </b>
							</td>
							<td align="center">
								<b> ${cost.wateramount} </b>

							</td>
							<td align="center">
								<b> ${cost.waterdesc} </b>

							</td>
						</tr>
					</c:forEach>
				</c:if>
				<%
					if (session.getAttribute("role").equals("admin")) {
				%>
				<tr>
					<td colspan="3">
						<center> <input type="submit" value='Delete'></center>
					</td>
				</tr>
				<%
					}
				%>
			</table>
			</center>
		</form>
	</body>

	<br />
	<jsp:include page="./Footer.jsp"></jsp:include>

</html>
