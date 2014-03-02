<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					method="post" commandName="dogForm" enctype="multipart/form-data" type="hidden">
					<input type="hidden" name="did" value="${dog.did}" />
					<input type="hidden" name="name" value="${dog.name}" />
					<input type="hidden" name="email" value="${dog.email}" />
					<input type="hidden" name="email" value="${dog.color}" />
					<input type="hidden" name="owner" value="${dog.owner}" />
					<input type="hidden" name="adress" value="${dog.address}" />
					<input type="hidden" name="dob1" value="${dog.dob}" />
					<input type="hidden" name="breed" value="${dog.breed}" />
					<input type="hidden" name="sex" value="${dog.sex}" />
					<input type="hidden" name="price" value="${dog.price}" />
					<input type="file" type="hidden" name="image" value="${dog.image}" />
					<table border="0" align="center">
						<tr>
							<td><img
								src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${dog.did}"
								alt="picture of dog" width="50" height="50" /></td>
						</tr>
					</table>
					<%-- I am stuck here!!!!! --%>
					<%-- <%request.setAttribute("did", "${dog.did}");%> --%>

					<table border="0" align="center">

						<tr>
							<td><font color="black"><b>Title :</b></font></td>
							<td><input type="text" name="title" value="${dog.title}" /></td>
						</tr>


						<tr>
							<td><font color="black"><b>Description :</b></font></td>
							<td><input type="text" name="description"
								value="${dog.description}" /></td>
						</tr>

						<tr>
							<td><input type="reset" value="Clear" /></td>
							<td><input type="submit" value="upload" /></td>
						</tr>


					</table>
				</ff:form>

				<div class="clear">&nbsp;</div>

			</div>
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>