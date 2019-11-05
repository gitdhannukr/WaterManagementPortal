<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.water.pojo.Addresses,com.water.pojo.UserDetails;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<jsp:include page="./UserCheck.jsp"></jsp:include>
<%
	String path;
	String usertype;
	UserDetails userdetails;
	Addresses address;
	String s;
	Vector c;
%>

<head>
	<script language="JavaScript"
		src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
		type="text/javascript">
</script>
</head>
<body>
	&nbsp;
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<center>

		<form name='deleteuser' action='./DeleteUserAction.do'>
			<table border='1'>
				<tr bgcolor='#12345'>
					<%
						if (session.getAttribute("role").equals("admin")) {
					%><td>
						&nbsp
					</td>
					<%
						}
					%>
					<td align='center'>
						<b>Sno</b>
					</td>
					<td align='center'>
						<b>Name </b>
					</td>
					<td align='center'>
						<b>Gender </b>
					</td>
					<td align='center'>
						<b>Contact </b>
					</td>
					<td align='center'>
						<b>Address </b>
					</td>
					<td align='center'>
						<b>Photo </b>
					</td>

					<td align='center'>
						<b>Status</b>
					</td>
					<%
						c = (Vector) request.getAttribute("vUserDetails");
						Iterator it = c.listIterator();
						int count = 1;
						while (it.hasNext()) {
							userdetails = (UserDetails) it.next();
							address = userdetails.getAddresses();
							path = request.getRealPath("/images");
							s = userdetails.getPhotograph();
							System.out.println(s);
					%>


				</tr>


				<tr>
					<%
						if (session.getAttribute("role").equals("admin")) {
					%>
					<td>
						<input name="ch" type="checkbox" id="checkbox2" onClick="check1()"
							value="<%=userdetails.getUserid()%>">
					</td>
					<%
						}
					%><td>
						<b><%=count++%></b>
					</td>
					<td>
						<b><%=userdetails.getFirstname()%></b>
					</td>
					<td>
						<b><%=userdetails.getGender()%></b>
					</td>
					<td>
						<b>mail :<%=userdetails.getEmailid()%></b>
						<br>
						<b>Ph :<%=address.getPhoneno()%></b>
						<br>

					</td>
					<td>
						<b>Hno :<%=address.getHouseno()%>,<%=address.getStreet()%>
							street</b>
						<br>
						<b><%=address.getCityid()%>,<%=address.getDistrictname()%>(District)</b>
						<br>
						<b><%=address.getStatename()%>,<%=address.getCountry()%><br>
							<b>pin :</b><%=address.getPincode()%></b>
					</td>
					<td>
						<img src="<%=userdetails.getPhotograph()%>" height='100'
							width='100'>
					</td>
					
					<%}
						if (session.getAttribute("role").equals("admin")) {
					%>

					<tr>
						<td align='center' colspan='8'>
							<input type="submit" value="Delete" />
						</td>
					</tr>
					<%
						}
					%>
				
			</table>
	</center>
	<jsp:include page="/Footer.jsp"></jsp:include>
</body>
