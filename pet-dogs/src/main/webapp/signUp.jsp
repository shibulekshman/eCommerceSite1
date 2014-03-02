<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>About Dog Website - free CSS template</title>
<meta name="keywords"
	content="free website template, CSS layout, 2 columns, Pets, Dogs, Dog Website, HTML CSS" />
<meta name="description"
	content="Dog Website Subpage - free CSS website template, Free HTML CSS Layout" />
<script type="text/javascript">
	function validateForm() {
		var email = document.getElementById("email");
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		if (!filter.test(email.value)) {
			alert('Please provide a valid email address');
			email.focus;
			return false;
		}
		var pass1 = document.getElementById("pass1").value;
		var pass2 = document.getElementById("pass2").value;
		if (pass1 != pass2) {
			alert("Passwords Do not match");
			document.getElementById("pass1").style.borderColor = "#E34234";
			document.getElementById("pass2").style.borderColor = "#E34234";
			return false;
		}
		var fname = document.getElementById("fname");
		var lname = document.getElementById("lname");
		var pass1 = document.getElementById("pass1");
		var pass2 = document.getElementById("pass2");
		var email = document.getElementById("email");
		alert("fname = " + fname);
		if (email.value == "" || fname.value == "" || lname.value == ""
				|| pass1.value == "" || pass2.value == "") {
			alert("Enter data in all the fields")
			return false;
		}
		alert("You are Successfully registered, please login in");

	}
</script>
<script type="text/javascript" src="stscode.js"></script>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="addtemplatemo_content_1">

		<img alt="Gallery Image" src="images/signup.png" width="150"
			height="150"
			style="border-width: 10px; border-style: solid; margin: 10px 10px 10px 10px; float: right;" />
		<h1 align="center">New User? Sign Up</h1>
		<br />
		<form action="${pageContext.request.contextPath}/signUp.htm"
			method="post" id="register" onsubmit="return validateForm()"
			name="signUpForm">

			<table border="0" align="center">

				<tr>
					<td><font color="black"><b>Email Address</b></font></td>
					<td><input type="text" id="email" name="email" /></td>
				</tr>

				<tr>
					<td><font color="black"><b>First Name</b></font></td>
					<td><input type="text" id="fname" name="firstName" /></td>
				</tr>

				<tr>
					<td><font color="black"><b>Last Name</b></font></td>
					<td><input type="text" id="lname" name="lastName" /></td>
				</tr>

				<tr>
					<td><font color="black"><b>Password</b></font></td>
					<td><input type="password" id="pass1" name="password" /></td>
				</tr>

				<tr>
					<td><font color="black"><b>Retype Password</b></font></td>
					<td><input type="password" id="pass2" name="rpassword" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="reset" value="Clear" /> <input type="submit"
						value="Register" /></td>
				</tr>


			</table>
		</form>

		<div class="clear">&nbsp;</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>