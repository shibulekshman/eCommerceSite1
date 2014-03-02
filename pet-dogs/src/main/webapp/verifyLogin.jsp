<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Dog Checkout</title>
</head>
<body>
	<%@ include file="checkoutHeader.jsp"%>
	<div class="addtemplatemo_content_1">
				<h1>Please Verify Login</h1>
				<br />
				
				<img alt="Gallery Image" src="images/verify.jpg" width="150"
				height="150" style="border-width:10px; border-style:solid; margin:10px 10px 10px 10px; float:right;"/>
				
				<form action="${pageContext.request.contextPath}/startCheckout.htm" method="post">

					<table border="0" align="center">

						<tr>
							<td><font color="black"><b>Email:</b></font></td>
							<td><input type="text" name="email" value="" required="true"/></td>
						</tr>
						<tr>
							<td><input type="radio" value="guest" name="userType">Continue as Guest</td>
						</tr>
						<tr>
							<td><input type="radio" value="user" name="userType">Sign in as User</td>
						</tr>
						<tr>
							<td><input type="submit" value="Continue" /></td>
						</tr>


					</table>
				</form>

				<div class="clear">&nbsp;</div>
			</div>
	

</body>
</html>