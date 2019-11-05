<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd"><%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<body bgcolor='white'>
		<form action="./DeleteWaterInfoAction.do" mehtod='post'>

			<jsp:include page="Header.jsp"></jsp:include>
			<br />
			<center>
				<h2>
					<font color='#B8B8B8 '><%=request.getAttribute("water")%>
						Information</font>
				</h2>
			</center>
			<center>
				<table border='0'>
					<c:if test="${not empty vWaterInfoPojos}">
						<c:forEach var="water" items="${vWaterInfoPojos}">

							<tr>
								<td>
									<%
										if (session.getAttribute("role").equals("subadmin")) {
									%>
									<input type="checkbox" name='ch' value="${water.id}">

									<%
										}
									%>
									<b><font color='skyblue'> ${water.header} </font> </b>
								</td>
							</tr>

							<tr>
								<td>
									<a href="${water.filepath}"><b>ViewFile</b> </a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="${water.url}"><b>SiteUrl</b> </a>
								</td>
							</tr>
							<tr>
								<td>
									<b> ${water.information} </b>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<%
						if (session.getAttribute("role").equals("subadmin")) {
					%>
					<tr>
						<td colspan="3">
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
