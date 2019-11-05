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

		<title>My JSP 'ViewEnquiryQuestions.jsp' starting page</title>

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
		<form action="./DeleteComplaintsAction.do" mehtod='post'>

			<jsp:include page="Header.jsp"></jsp:include>
			<br />
			<center>
				<table border='0'>
					<caption>
						<h3>
							Citizens Complaints
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
							<b>Complaint From</b>
						</td>

						<td>
							<b>Citizen Name</b>
						</td>

						<td>
							<b>Complaint Question</b>
						</td>
						<td>
							<b>Complaint Reply</b>
						</td>
						<td>
							<b>Complaint status</b>
						</td>
					</tr>
					<c:if test="${not empty vComplaints}">
						<c:forEach var="complaints" items="${vComplaints}">
							<tr>
								<%
									if (session.getAttribute("role").equals("admin")) {
								%>
								<td align='right'>
									<input type="checkbox" name='ch'
										value="${complaints.complaintid }">
								</td>
								<%
									}
								%>
								<td align="center">
									<b> ${complaints.complaintarea} </b>
								</td>
								<td align="center">
									<b> ${complaints.complaintername} </b>
								</td>
								<td align="center">
									<b> ${complaints.complaint} </b>
								</td>
								<td align="center">
									<b> ${complaints.complaintsolution} </b>
								</td>

								<td align="center">
									<%
										if (session.getAttribute("role").equals("admin") || session.getAttribute("role").equals("subadmin")) {
									%>
									<b><a
										href="./ComplaintAnswer.jsp?complaintid=${complaints.complaintid }&complaint=${complaints.complaint}">
											${complaints.complaintstatusstatus} 
									</b></a>
									<%
										} else {
									%>${complaints.complaintstatusstatus}<%
										}
									%>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<%
						if (session.getAttribute("role").equals("admin")) {
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
