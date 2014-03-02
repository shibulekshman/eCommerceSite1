<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dog Website</title>
<meta name="keywords"
	content="free website templates, Dog Website, XHTML CSS" />
<meta name="description"
	content="Dog Website - free website template, Free XHTML CSS Layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="adminLoggedInHeader.jsp"%>
	<br/>
		<h1 style="color: orange">
			Welcome
			<c:out value="${sessionScope.adminLoggedIn.adminName}" />
			!
		</h1>
		<div class="contents"><h2 style="color: green">Sales Report</h2></div>
	

	<img src="images/adminhome.jpg" align="right" vspace="30px"
		height="200" width="200" />



	<div class="clear">&nbsp;</div>
	</div>
	<%@ include file="footer.jsp"%>
	</div>
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>

