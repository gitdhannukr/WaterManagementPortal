

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>"
			type="text/javascript">
</script>

		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>
		<script language="JavaScript1.1" src="scripts/pass.js">

</script>
		<script type="text/javascript" src="scripts/image.js">
</script>
		<script type="text/javascript" src="scripts/general.js">
</script>
		<script type="text/javascript" src="scripts/adi.js">
</script>
		<script type="text/javascript" src="scripts/form_validation.js">
</script>
		<script language="JavaScript" src="images/javascripts.js">
</script>
		<script language="JavaScript" src="images/pop-closeup.js">
</script>
		<script>

//var x_win = window.self; 

function goOn() {
	var port = document.register.port.value;
	var host = document.register.host.value;
	var loginname = document.register.loginname.value;
	window.location.href = 'http://' + host + ':' + port
			+ '/Water/CheckUserAction.do?loginname=' + loginname;

}
</script>



		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>
		<body>
			<jsp:include page="Header.jsp"></jsp:include>
			<h3>
				<div align="center">
					<br>
					Water Supply Entry Form
				</div>
			</h3>
			<form action="./AddWaterSupplyDetailsAction.do" method="post"
				name="supply">
				<!--<table border="1"><tr><td></td></tr></table>-->
				<table border="0" align="center">
					<tr>
						<td align='right'>
							Name of the Colony/Locality
						</td>
						<td>
							<input type="text" name="colonyname" value="" />

						</td>
					</tr>
					<tr>
						<td align='right'>
							Name of Devision :
						</td>
						<td>
							<select name="division">
								<option value="select" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="I">
									<font size="3" face="Verdana">I</font>
								</option>
								<option value="II">
									<font size="3" face="Verdana">II</font>
								</option>
								<option value="III">
									<font size="3" face="Verdana">III</font>
								</option>
								<option value="IV">
									<font size="3" face="Verdana">IV</font>
								</option>
								<option value="V">
									<font size="3" face="Verdana">V</font>
								</option>
								<option value="VI">
									<font size="3" face="Verdana">VI</font>
								</option>
								<option value="VII">
									<font size="3" face="Verdana">VII</font>
								</option>
								<option value="VIII">
									<font size="3" face="Verdana">VIII</font>
								</option>
								<option value="IX">
									<font size="3" face="Verdana">IX</font>
								</option>
								<option value="X">
									<font size="3" face="Verdana">X</font>
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align='right'>
							Area Type :
						</td>
						<td>
							<select name="areatype">
								<option value="select" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="Slum">
									<font size="3" face="Verdana">Slum</font>
								</option>
								<option value="NonSlum">
									<font size="3" face="Verdana">NonSlum</font>
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align='right'>
							From Time :

						</td>
						<td>
							<input type="text" name="fromtime" value="" size="20" />(12:00AM/PM)
						</td>
					</tr>

					<tr>
						<td align='right'>

							To Time :

						</td>
						<td>
							<input type="text" name="totime" value="" size="20" />(12:00AM/PM)
						</td>
					</tr>
					<tr>
						<td align='right'>
							Supply Pattern :

						</td>
						<td>
							<select name="supplypattrn">
								<option value="-select-" selected="true">
									<font size="3" face="Verdana">--Select--</font>
								</option>
								<option value="Daily">
									<font size="3" face="Verdana">Daily</font>
								</option>
								<option value="AlternateDays">
									<font size="3" face="Verdana">AlternateDays</font>
								</option>
								<option value="Every 48hours">
									<font size="3" face="Verdana">Every 48hours</font>
								</option>
								<option value="Weekly">
									<font size="3" face="Verdana">Weekly</font>
								</option>
								<option value="Daily two times">
									<font size="3" face="Verdana">Daily two times</font>
								</option>
						</td>
					</tr>
					<tr>
						<td align='right'>
							LineMen Name :

						</td>
						<td>
							<input type="text" name="lineman" value="" size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Contact Address :
						</td>
						<td>
							<input type="text" name="contactaddresses" value="" size="20" />
							<input type='hidden' name='cityidref'
								value='${sessionScope.cityid}' />
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="center">
							<font size="3" face="Verdana"> <input type="submit"
									name="register" value="Submit" />&nbsp; <input type="reset"
									name="cancel" value="Cancel" /> </font>
						</td>
						<td align="center"></td>
					</tr>
				</table>
			</form>

			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("supply");

frmvalidator.addValidation("colonyname", "req", "Please enter Colony Name");
frmvalidator.addValidation("division", "dontselect=0");

frmvalidator.addValidation("colony", "req", "Please enter Password");

frmvalidator.addValidation("areatype", "dontselect=0");

frmvalidator.addValidation("fromtime", "req", "Please enter From Time");
frmvalidator.addValidation("totime", "req", "Please enter To time");
frmvalidator.addValidation("supplypattrn", "req", "Please enter To time");
frmvalidator.addValidation("lineman", "req", "Please enter To time");
frmvalidator.addValidation("contactaddresses", "req", "Please enter To time");
</script>
			<jsp:include page="Footer.jsp"></jsp:include>
		</body>
</html>
