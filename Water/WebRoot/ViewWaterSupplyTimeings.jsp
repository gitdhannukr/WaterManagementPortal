<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ViewTipsSuggesitions.jsp' starting page</title>

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
		<form action="./DeleteWaterSupplyInfoAction.do" mehtod='post'>

			<jsp:include page="Header.jsp"></jsp:include>
			<br />
			<center>
				<table border='0'>
					<caption>
						<h3>
							City Water Supply Timeing Information
						</h3>
					</caption>


					<tr bgcolor="ashblue">
						<%
							if (session.getAttribute("role").equals("subadmin")) {
						%>
						<td></td>
						<%
							}
						%>
						<td>
							<b>Locality Name/Colony Name</b>
						</td>
						<td>
							<b>Devision</b>
						</td>
						<td>
							<b>Area Type</b>
						</td>
						<td>
							<b>From Time </b>
						</td>
						<td>
							<b>To Time</b>
						</td>
						<td>
							<b>Supply Pattern</b>
						</td>
						<td>
							<b>LineMen Name and Contact Address</b>
						</td>
					</tr>
					<c:if test="${not empty wSupplies}">
						<c:forEach var="supply" items="${wSupplies}">
							<tr>
								<%
									if (session.getAttribute("role").equals("subadmin")) {
								%>
								<td align='right'>
									<input type="checkbox" name='ch' value="${supply.supplyid }">
								</td>
								<%
									}
								%>
								<%
									if (session.getAttribute("role").equals("subadmin")) {
								%>
								<td align="center">
									<b> <a href='./UpdateWaterSupplyRecord.do?supplyid=${supply.supplyid }'>${supply.colonyname}
									</a>
									</b>
								</td>
								<%
									} else {
								%><td align="center">
									<b> ${supply.colonyname} </b>
								</td>
								<%
									}
								%>
								<td align="center">
									<b> ${supply.division} </b>

								</td>
								<td align="center">
									<b> ${supply.areatype} </b>

								</td>
								<td align="center">
									<b> ${supply.fromtime} </b>

								</td>
								<td align="center">
									<b> ${supply.totime} </b>

								</td>
								<td align="center">
									<b> ${supply.supplypattrn} </b>

								</td>
								<td align="center">
									<b> ${supply.lineman},${supply.contactaddresses} </b>

								</td>
							</tr>
						</c:forEach>
					</c:if>
					<%
						if (session.getAttribute("role").equals("subadmin")) {
					%>
					<tr>
						<td colspan="7">
							<center>
								<input type="submit" value='Delete'>
							</center>
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
