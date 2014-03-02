<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dogs</title>
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
			<img
				src="${pageContext.request.contextPath}/images/header_dog-bites.jpg"
				width="860" /> <br />
				
				<h1>Welcome <c:out value="${sessionScope.adminLoggedIn.adminName}" />!</h1>

			<table border="0" width="860">
				<tr bgcolor="#193543" style="color: #FFFFFF; font-weight: bold;"
					align="center">
					<th width="30%">Name</th>
					<th width="30%">Email<a href="sortAscending.htm"><img
							src="${pageContext.request.contextPath}/images/sort_ascend.png"
							width="15" height="15" /></a> <a href="sortDescending.htm"><img
							src="${pageContext.request.contextPath}/images/sort_descend.png"
							width="15" height="15" /></a></th>
					<th width="20%">Color</th>
					<th width="20%">Photo</th>
						<th width="20%">Edit</th>
						<th width="20%">Delete</th>
				</tr>

				<c:forEach var="item" items="${dogs}" varStatus="cStatus">
					<c:choose>
						<c:when test="${cStatus.index % 2 == 0 }">
							<tr bgcolor="#f3ce7d" style="color: black;">
								<td align="center">${item.name}</td>
								<td align="center">${item.email}</td>
								<td align="center">${item.color}</td>
								<td align="center"><img
									src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${item.did}"
									width="30" height="30" /></td>
								<td align="center"><a href="editDogByDid.htm?did=${item.did}"><img
										src="${pageContext.request.contextPath}/images/edit.png"
										width="30" height="30" /></a></td>
								<td align="center"><a href="deleteDogByDid.htm?did=${item.did}"><img
										src="${pageContext.request.contextPath}/images/delete.png"
										width="30" height="30" /></a></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr bgcolor="white" style="color: black;">
								<td align="center">${item.name}</td>
								<td align="center">${item.email}</td>
								<td align="center">${item.color}</td>
								<td align="center"><img
									src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${item.did}"
									width="30" height="30" /></td>
								<td align="center"><a href="editDogByDid.htm?did=${item.did}"><img
										src="${pageContext.request.contextPath}/images/edit.png"
										width="30" height="30" /></a></td>
								<td align="center"><a href="deleteDogByDid.htm?did=${item.did}"><img
										src="${pageContext.request.contextPath}/images/delete.png"
										width="30" height="30" /></a></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>

			<div class="clear">&nbsp;</div>
		</div>
		
	</div>
	<%@ include file="footer.jsp"%>
	</div>
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>