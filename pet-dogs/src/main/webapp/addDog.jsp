<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Add Dog Form</title>
<meta name="keywords"
	content="free website templates, Dog Website, XHTML CSS" />
<meta name="description"
	content="Dog Website - free website template, Free XHTML CSS Layout" />
<link href="${pageContext.request.contextPath}/templatemo_style.css"
	rel="stylesheet" type="text/css" />
<!--  This website template is designed by TemplateMo.com  -->
</head>

<body>
	<%@ include file="adminLoggedInHeader.jsp"%>
			<div class="addtemplatemo_content_1">
				<h1>Upload Dog Form</h1>
				<br />
				<img src="images/addDog.jpg" align="right"  vspace="30px" height="200" width="200"/>
				<ff:form action="${pageContext.request.contextPath}/uploadDog.htm"
					method="post" commandName="dogForm" enctype="multipart/form-data">
					<table border="0" align="center">
						<tr>
							<td><font color="black"><b>Name :</b></font></td>
							<td><input type="text" name="name" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>Title :</b></font></td>
							<td><input type="text" name="title" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>Email :</b></font></td>
							<td><input type="text" name="email" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>Color :</b></font></td>
							<td><input type="text" name="color" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>Owner :</b></font></td>
							<td><input type="text" name="owner" /></td>
						</tr>


						<tr>
							<td><font color="black"><b>Address :</b></font></td>
							<td><textarea  name="address" cols="20" rows="3"></textarea></td>
						</tr>

						<tr>
							<td><font color="black"><b>DOB :</b></font></td>
							<td><input type="text" name="dob1" /></td>
						</tr>


						<tr>
							<td><font color="black"><b>Breed :</b></font></td>
							<td><input type="text" name="breed" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>Sex :</b></font></td>
							<td><input type="text" name="sex" /></td>
						</tr>

						<tr>
							<td><font color="black"><b>Description :</b></font></td>
							<td><textarea  name="description" cols="20" rows="3"></textarea></td>
						</tr>

						<tr>
							<td><font color="black"><b>Price :</b></font></td>
							<td><input type="text" name="price" /></td>
						</tr>
						 <tr>	
							<td><font color="black"><b>Upload Photo:</b></font></td>
							<td> <input type="file" name="image"/></td>
						</tr>
						<tr>
							<td><input type="reset" value="Clear" /></td>
							<td><input type="submit" value="upload" /></td>
						</tr>


					</table>
			</ff:form>

				<div class="clear">&nbsp;</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>