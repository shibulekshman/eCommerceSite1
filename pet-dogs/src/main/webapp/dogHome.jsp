<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.pets.dog.web.model.DogForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dog Home Page</title>
<meta name="keywords"
	content="free website templates, Dog Website, XHTML CSS" />
<meta name="description"
	content="Dog Website - free website template, Free XHTML CSS Layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<script type="text/javascript">
  var ccontextPath="${pageContext.request.contextPath}";
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/petdog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/photoZoom.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	  $("#imageContainer").photoZoom();
	  // alert(contextPath);
});
</script>
<script type="text/javascript">

function popup(){
  cuteLittleWindow = window.open("shoppingPage.htm", "littleWindow", "location=no,width=800,height=600"); 
}

</script>
</head>
<body>
	<%@ include file="header.jsp"%>
		
			<div class="templatemo_content_1">
			
			<!-- <a href="javascript:popup()">Here is a popup window.</a> This is for pop up testing -->
			
			
				<h1>Dog News</h1>
				<div class="contents">
					<c:forEach var="item" items="${dogs}" varStatus="cStatus">
						<div class="news">
							<div id="imageContainer${item.did}">
								<img alt="Dog"
									src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${item.did}"
									height="60" width="60"
									onmouseover="applyZoom('#imageContainer${item.did}');" />
								<%
									DogForm dogForm = (DogForm) pageContext.getAttribute("item");

										String redirectURL = request.getContextPath()
												+ "/miniEditDogByDid.htm?did=" + dogForm.getDid();
								%>
								<button onclick=function(){alert(redirectURL};>Edit</button>
							</div>
							<div class="textarea">
								<h2>${item.title}</h2>
								<p>${item.description}.</p>
							</div>
						</div>
					</c:forEach>
					<a href="http://www.templatemo.com"><img alt="Readmore"
						src="images/templatemo_more.gif" /> </a>
				</div>
			</div>
			<div class="templatemo_content_2">
				<h1>Sign In</h1>
				<div class="contents">
					<h2>Click on<a href="${pageContext.request.contextPath}/signUp.htm"><font color="blue"><u>Register</u></font></a> to Sign up</h2>
					<form action="${pageContext.request.contextPath}/login.htm" 
						  method="post"
						  id="signIn"
						  name="loginForm">
							
						
						<table>
							<caption><font color="black"><b>Sign in</b></font></caption>
							<tr>
								<td><p>Email</p></td>
								<td><input type="text" id="email" name="email"/></td>
							</tr>
							<tr>
								<td><p>Password</p></td>
								<td><input type="password" id="password" name="password"/></td>
							</tr>
							<tr>
								<td><input type="submit" value="Login"/></td>
							</tr>
						</table>
						
					</form>
					<a href="http://www.templatemo.com"><img alt="Readmore"
						src="images/templatemo_more.gif" /> </a>
				</div>
			</div>
			<div class="templatemo_gallery">
				<div class="title">
					<h1>Photo Gallery</h1>
				</div>
				<div class="prev">
			<!-- 		<a><img src="images/templatemo_gallery_prev.jpg" alt="Previous"
						border="0" onclick="prevImage()" /></a> -->
						<form name="preForm" action="${pageContext.request.contextPath}/preImage.htm?cpi=${cpi}" method="get">
						 <input  type="hidden" name="cpi" id="cpi" value="${cpi}"/>
						<a href="javascript:jpreImage()" id="previousId"><img src="images/templatemo_gallery_prev.jpg" alt="Previous"
						border="0" /></a>
						</form>
				</div>
				<div class="images">
					<div id="imageCarouselContainer${item.did}">
						<img alt="DogInvisible" src="" height="0" width="0" id="picTemp" />
						<c:forEach var="item" items="${dogsInCarousel}"
							varStatus="cStatus">
							<span id="ppic${cStatus.count}">
							<img alt="Dog" 	src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${item.did}"
								height="120" width="120" id="pic${cStatus.count}" />
							</span>	
						</c:forEach>
					</div>
				</div>
				<div class="next">
					<!-- <a><img src="images/templatemo_gallery_next.jpg" alt="Previous"
						border="0" onclick="nextImage()" /></a> -->
						<a href="javascript:jnextImage();" id="nextId"  ><img src="images/templatemo_gallery_next.jpg" alt="Previous"
						border="0" /></a>
						 <input  type="hidden" name="cni" id="cni" value="${cni}"/>
				</div>

			</div>
			<div class="templatemo_validate"></div>
			<div class="clear">&nbsp;</div>
		
		
		<%@ include file="footer.jsp"%>
		
	
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>