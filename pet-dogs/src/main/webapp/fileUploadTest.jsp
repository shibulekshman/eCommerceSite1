<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Add File Form</title>
<meta name="keywords"
	content="free website templates, Dog Website, XHTML CSS" />
<meta name="description"
	content="Dog Website - free website template, Free XHTML CSS Layout" />
<link href="${pageContext.request.contextPath}/templatemo_style.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="adminLoggedInHeader.jsp"%>
	<div class="addtemplatemo_content_1">
		<h1>Upload Dog Form</h1>
		<br /> <img src="images/addDog.jpg" align="right" vspace="30px"
			height="200" width="200" />
		<ff:form
			action="${pageContext.request.contextPath}/fileUploadTest.htm"
			method="post" commandName="uploadFile" enctype="multipart/form-data">
			<table border="0" align="center">
				<tr>
					<td><font color="black"><b>Upload File:</b></font></td>
					<td><input type="file" name="file" /></td>
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