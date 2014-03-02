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
<!--  This website template is designed by TemplateMo.com  -->
</head>

<body>
	<%@ include file="adminLoggedInHeader.jsp"%>
			<div class="templatemo_content_1">
				<h1>Welcome <c:out value="${sessionScope.adminLoggedIn.adminName}" />!</h1>
				<div class="contents">
					<div class="news">
						<a href="${pageContext.request.contextPath}/uploadDog.htm" class="current"><b>New Dog</b></a><br />
						<br /> <a href="${pageContext.request.contextPath}/dogs.htm" class="current"><b>View Dogs</b></a>

					</div>
					<div class="news"></div>
					<a href="http://www.templatemo.com"><img alt="Readmore"
						src="images/templatemo_more.gif" /></a>
				
				</div>
			
			</div>
		
		
				<img src="images/adminhome.jpg" align="right"  vspace="30px" height="200" width="200"/>
		


			<div class="clear">&nbsp;</div>
		</div>
											<a href="reports.jsp">View Reports</a>
		
		<%@ include file="footer.jsp"%>
	</div>
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>

