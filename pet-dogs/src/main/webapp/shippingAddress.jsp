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
			<h1>Enter the Shipping Address</h1>
				<br />
				
				<img alt="Gallery Image" src="images/Shipping-Labels.jpg" width="150"
				height="150" style="border-width:10px; border-style:solid; margin:10px 10px 10px 10px; float:right;"/>
				
				<form action="${pageContext.request.contextPath}/shipping.htm"
					method="post" onsubmit="return validateForm()" name="contactForm">

					<table border="0" align="center">

						<tr>
							<td><font color="black"><b>Full Name:</b></font></td>
							<td><input type="text" name="name" value="" required="true"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Address Line 1:</b></font></td>
							<td><input type="text" name="addr1" value="" required="true"/></td>
						</tr>
						
						<tr>
							<td><font color="black"><b>Address Line 2:</b></font></td>
							<td><input type="text" name="addr2" value="" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>City:</b></font></td>
							<td><input type="text" name="city" value="" required="true"/></td>
						</tr>
						
						<tr>
							<td><font color="black"><b>State:</b></font></td>
							<td><input type="text" name="state" value="" required="true"/></td>
						</tr>
						
						<tr>
							<td><font color="black"><b>Zip:</b></font></td>
							<td><input type="text" name="zip" value="" required="true"/></td>
						</tr>
						
						<tr>
							<td><font color="black"><b>Country:</b></font></td>
							<td><input type="text" name="country" value="" required="true"/></td>
						</tr>
						
						<tr>
							<td><font color="black"><b>Mobile Number*:</b></font></td>
							<td><input type="text" name="mobileNumber" value="" required="true"/></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="reset" value="Clear" /> <input
								type="submit" value="submit" /></td>
						</tr>


					</table>
				</form>

				<div class="clear">&nbsp;</div>
			</div>
	

</body>
</html>