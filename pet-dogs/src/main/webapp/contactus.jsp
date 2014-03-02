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
function validateForm()
{
var x1=document.forms["contactForm"]["name"].value;
if (x1==null || x1=="")
  {
  alert("Name must be filled out");
  return false;
  }
var x2=document.forms["contactForm"]["name"].value;
if (x2==null || x2=="")
  {
  alert("Mobile number must be filled out");
  return false;
  }
}
</script>	
<script type="text/javascript" src="stscode.js"></script>
<!--  This website template is designed by TemplateMo.com  -->
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="header.jsp"%>
			<div class="addtemplatemo_content_1">
				<h1>Contact Us</h1>
				<br />
				
				<img alt="Gallery Image" src="images/template2.jpg" width="150"
				height="150" style="border-width:10px; border-style:solid; margin:10px 10px 10px 10px; float:right;"/>
				
				<form action="${pageContext.request.contextPath}/contactUs.htm"
					method="post" onsubmit="return validateForm()" name="contactForm">

					<table border="0" align="center">

						<tr>
							<td><font color="black"><b>Name*:</b></font></td>
							<td><input type="text" name="name" value="" required="true"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Email :</b></font></td>
							<td><input type="text" name="email" value="" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>Mobile Number*:</b></font></td>
							<td><input type="text" name="mobileNumber" value="" required="true"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Purpose :</b></font></td>
							<td><textarea name="purpose" maxlength="1000" cols="17"
									rows="6"></textarea></td>
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
		
		<%@ include file="footer.jsp"%>
	
</body>
<!--  Designed by w w w . t e m p l a t e m o . c o m  -->
</html>