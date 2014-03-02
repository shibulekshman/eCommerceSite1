<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>

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
<style type="text/css">
.addtemplatemo_content_1 {
	background-color: black;
}
</style>
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="addtemplatemo_content_1">

		<c:set var="Total" scope="page" value="0" />

		<c:if test="${not empty dogsInCart}">


			<table border="0" width="860">
				<tr bgcolor="#193543" style="color: #FFFFFF; font-weight: bold;"
					align="center">
					<th width="30%" align="center">Photo</th>
					<th width="30%" align="center">Name</th>
					<th width="30%" align="center">price</th>
					<th width="10%" align="center">Edit</th>

				</tr>


				<c:forEach var="dogsInCart" items="${dogsInCart}"
					varStatus="cStatus">
					<c:choose>
						<c:when test="${cStatus.index % 2 == 0 }">
							<tr bgcolor="#f3ce7d" style="color: black;">
								<td align="center"><img
									src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${dogsInCart.did}"
									width="30" height="30" /></td>
								<td align="center">${dogsInCart.name}</td>
								<td align="center">$${dogsInCart.price}</td>
								<td align="center"><a
									href="${pageContext.request.contextPath}/deleteFromCart.htm?did=${dogsInCart.did}"><img
										src="${pageContext.request.contextPath}/images/delete.png"
										width="20" height="20" /></a></td>

								<c:set var="Total" value="${Total+dogsInCart.price}" />
							</tr>
						</c:when>
						<c:otherwise>
							<tr bgcolor="white" style="color: black;">
								<td align="center"><img
									src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${dogsInCart.did}"
									width="30" height="30" /></td>
								<td align="center">${dogsInCart.name}</td>
								<td align="center">$${dogsInCart.price}</td>
								<td align="center"><a
									href="${pageContext.request.contextPath}/deleteFromCart.htm?did=${dogsInCart.did}"><img
										src="${pageContext.request.contextPath}/images/delete.png"
										width="20" height="20" /></a></td>

								<c:set var="Total" value="${Total+dogsInCart.price}" />
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>


				<c:if test="${fn:length(dogsInCart) gt 0}">
					<tr bgcolor="#f3ce7d" style="color: black;">
						<td align="center"><a href="shoppingPage.htm"><img
								style="border: 0;"
								src="${pageContext.request.contextPath}/images/continue-shopping.jpg"
								width="100" height="50"></a></td>
						<td align="center"><a href="verifyLogin.jsp"><img style="border: 0;"
								src="${pageContext.request.contextPath}/images/buy-now.png"
								width="100" height="50"></a></td>
						<td align="center">Total = $${Total}</td>
					</tr>
				</c:if>

			</table>

		</c:if>

		<c:if test="${empty dogsInCart}">
			<img alt="Gallery Image" src="images/empty_cart.jpg" width="300"
				height="150"
				style="border-width: 10px; border-style: solid; margin: 10px 10px 10px 260px;" />
		</c:if>


		<div class="clear">&nbsp;</div>
	</div>

	</div>
	<%@ include file="footer.jsp"%>
	</div>
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>