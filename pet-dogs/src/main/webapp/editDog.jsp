<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Edit Dog Form</title>
<meta name="keywords"
	content="free website templates, Dog Website, XHTML CSS" />
<meta name="description"
	content="Dog Website - free website template, Free XHTML CSS Layout" />
<link href="${pageContext.request.contextPath}/templatemo_style.css"
	rel="stylesheet" type="text/css" />
<!--  This website template is designed by TemplateMo.com  -->
</head>

<body>
	<%@ include file="header.jsp"%>
			<div class="addtemplatemo_content_1">
				<h1>Edit Dog Form</h1>
				<br />
				<ff:form action="${pageContext.request.contextPath}/uploadDog.htm"
					method="post" commandName="dogForm" enctype="multipart/form-data">
					<input type="hidden" name="did" value="${dog.did}"/>
					<table border="0" align="center">
						<tr><td><img src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${dog.did}" alt="picture of dog" width="50" height="50" /></td></tr>
					</table>
					
					
					<table border="0" align="center">
					
						<tr>
							<td><font color="black"><b>Name :</b></font></td>
							<td><input type="text" name="name" value="${dog.name}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Title :</b></font></td>
							<td><input type="text" name="title" value="${dog.title}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Email :</b></font></td>
							<td><input type="text" name="email" value="${dog.email}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Color :</b></font></td>
							<td><input type="text" name="color" value="${dog.color}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Owner :</b></font></td>
							<td><input type="text" name="owner" value="${dog.owner}"/></td>
						</tr>


						<tr>
							<td><font color="black"><b>Address :</b></font></td>
							<td><input type="text" name="adress" value="${dog.address}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>DOB :</b></font></td>
							<td><input type="text" name="dob1" value="${dog.dob}"/></td>
						</tr>


						<tr>
							<td><font color="black"><b>Breed :</b></font></td>
							<td><input type="text" name="breed" value="${dog.breed}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Sex :</b></font></td>
							<td><input type="text" name="sex" value="${dog.sex}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Description :</b></font></td>
							<td><input type="text" name="description" value="${dog.description}"/></td>
						</tr>

						<tr>
							<td><font color="black"><b>Price :</b></font></td>
							<td><input type="text" name="price" value="${dog.price}"/></td>
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