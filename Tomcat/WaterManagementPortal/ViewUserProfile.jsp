<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@  page import="com.water.pojo.Addresses,com.water.pojo.UserDetails;"%>

<jsp:include page="./UserCheck.jsp"></jsp:include>
<head>
	<%
		UserDetails userdetails;
		Addresses addresses;
		String path;
		String s;
	%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<form method='post' action="./UpdateUserProfileAction.do"
		name="register" onsubmit="return validate()">
		<!--<table border="1"><tr><td></td></tr></table>-->
		<input type="hidden" name="port" value="<%=request.getLocalPort()%>" />
		<input type="hidden" name="host" value="<%=request.getServerName()%>" />
		<br />

		<table border='0' align="center">
			<th colspan="6" bgcolor="#999933">
				Personal Details
			</th>
			<%
				userdetails = (UserDetails) request.getAttribute("userDetails");
				addresses = (Addresses) request.getAttribute("addresses");
				path = request.getRealPath("/images");
				s = path + "\\" + userdetails.getPhotograph();
				System.out.println(s);
			%>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align='right'>
					First Name :
				</td>
				<td>
					<input type="text" name="firstname"
						value="<%=userdetails.getFirstname()%>" readonly />
				</td>
				<td align='right'>
					Browse Photo :
				</td>
				<td>
					<input type="file" name="photograph1" class="textfield"
						onChange="preview(this)" />
					<input type="hidden" name="photograph"
						value='<%=userdetails.getPhotograph()%>'>
					<input type="hidden" name="userid"
						value='<%=request.getParameter("userid")%>'>
					<input type="hidden" name="path"
						value='<%=request.getRealPath("./images")%>'>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td border="0" align="left" rowspan="5" colspan='2'>
					<img alt="See Photo Here" id="previewField"
						src="<%=userdetails.getPhotograph()%>" height="150" width="120" />
				</td>
			</tr>
			<tr>
				<td align='right'>
					Last Name :
				</td>
				<td>
					<input type="text" name="lastname"
						value="<%=userdetails.getLastname()%>" size="20" />
				</td>
				<td align='right'>

				</td>
				<td>

				</td>
			</tr>
			<tr>
				<td align='right'>
					Birth Date :
				</td>
				<td width='256'>
					<input type="text" name="birthDate"
						value="<%=userdetails.getBirthDate()%>" size="20" ="" />
					<a
						href="javascript:show_calendar('document.register.birthDate', document.register.birthDate.value);">
						<img src="images/cal.gif" alt="a" width="18" height="18"
							border="0" /> </a>
				</td>
				<td align='right'>
				</td>
				<td>

				</td>
			</tr>
			<tr>
				<td align='right'>
					Email :
				</td>
				<td>
					<input type="text" name="emailid"
						value="<%=userdetails.getEmailid()%>" size="20" />
				</td>
				<td>
					<input type="hidden" name="addressid"
						value="<%=addresses.getAddressid()%>" />
				</td>
				<td></td>
			</tr>
			<tr>

				<td align='right'>
					Gender :
				</td>

				<td align='left'>
					<select name="gender">
						<option value="<%=userdetails.getGender()%>" selected="true">
							<font size="3" face="Verdana"><%=userdetails.getGender()%></font>
						</option>
						<option value="Male">
							<font size="3" face="Verdana">Male
							</font>
						</option>
						<option value="Female">
							<font size="3" face="Verdana">Female
							</font>
						</option>
					</select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<th colspan="6" bgcolor="#999933">
				<center>
				Contact Details
				</center>
			</th>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align='right'>
					Address Type :
				</td>
				<font size="3" face="Verdana">
				<td width="276">
					<select name="addresstype" onChange="cleartext()">
						<option value="<%=addresses.getAddresstype()%>">
							<%=addresses.getAddresstype()%></font>
						</option>
						<option value="home">
							Home

						</option>
						<option value="office">
							Office

						</option>
						<option value="personal">
							Personal

						</option>
					</select>
				</td>
				</font>
			</tr>
			<tr>
				<td align='right'>
					House No :
				</td>
				<td>
					<input type="text" name="houseno"
						value="<%=addresses.getHouseno()%>" size="20" />
				</td>

				<td width="120" align='right'>
					District :
				</td>
				<td width="273">
					<input type="text" name="district"
						value="<%=addresses.getDistrictname()%>" size="20" readonly />
				</td>
			</tr>
			<tr>
				<td align='right'>
					Street :
				</td>
				<td>
					<input type="text" name="street" value="<%=addresses.getStreet()%>"
						size="20" />
				</td>
				<td align='right'>
					State :
				</td>
				<td>
					<input type="text" name="state"
						value="<%=addresses.getStatename()%>" size="20" readonly />
				</td>
			</tr>
			<tr>
				<td width="120" align='right'>
					City :
				</td>
				<td width="273">
					<input type="text" name="cityid" value="<%=addresses.getCityid()%>"
						size="20" readonly />
				</td>

				<td align='right'>
					Country :
				</td>
				<td>
					<input type="text" name="country"
						value="<%=addresses.getCountry()%>" size="20" />
				</td>
			</tr>
			<tr>
				<td align='right'>
					Phone No :
				</td>
				<td>
					<input type="text" name="phoneno"
						value="<%=addresses.getPhoneno()%>" size="20" />
				</td>
				<td align='right'>
					Pin :
				</td>
				<td>
					<input type="text" name="pincode"
						value="<%=addresses.getPincode()%>" size="20" />
				</td>
			</tr>

			<tr></tr>
			<tr></tr>

		</table>

		<jsp:include page="Footer.jsp"></jsp:include>
</body>
