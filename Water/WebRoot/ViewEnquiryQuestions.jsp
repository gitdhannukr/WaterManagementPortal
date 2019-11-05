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
		<form action="./DeleteEnquiryQuestionAction.do" mehtod='post'>

			<jsp:include page="Header.jsp"></jsp:include>
			<br />
			<center>
				<table border='0'>
					<caption>
						<h3>
							Citizen Enquiry Questions
						</h3>
					</caption>


					<tr bgcolor="ashblue">
						<%
							if (session.getAttribute("role").equals("subadmin")) {
						%>
						<td>
							<br>
							<br>
						</td>
						<%
							}
						%>
						<td>
							<b>Enquiry From</b>
						</td>
						<td>
							<b>Enquiry Question</b>
						</td>
						<td>
							<b>Enquiry Reply</b>
						</td>
						<td>
							<b>Enquiry status</b>
						</td>
					</tr>
					<c:if test="${not empty vEnquiries}">
						<c:forEach var="enquiry" items="${vEnquiries}">
							<tr>
								<%
									if (session.getAttribute("role").equals("subadmin")) {
								%>
								<td align='right'>
									<input type="checkbox" name='ch' value="${enquiry.enquiryid }">
								</td>
								<%
									}
								%>
								<td align="center">
									<b> ${enquiry.enquiryarea} </b>
								</td>
								<td align="center">
									<b> ${enquiry.enquiry} </b>
								</td>
								<td align="center">
									<b> ${enquiry.enquiryreply} </b>
								</td>

								<td align="center">
									<%
										if (session.getAttribute("role").equals("subadmin")) {
									%>
									<b><a
										href="./EnquiryAnswer.jsp?enquiryid=${enquiry.enquiryid }&enquiry=${enquiry.enquiry}">
											${enquiry.enquirystatus} 
									</b></a>
									<%
										} else {
									%>${enquiry.enquirystatus}<%
										}
									%>
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
