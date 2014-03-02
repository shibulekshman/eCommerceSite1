<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shopping</title>
<meta name="keywords"
	content="free website templates, Dog Website, XHTML CSS" />
<meta name="description"
	content="Dog Website - free website template, Free XHTML CSS Layout" />
<link href="${pageContext.request.contextPath}/templatemo_style.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
.auto-style1 {
	margin-left: 21px;
	margin-top: 23px;
}

.favourite {
	background: orange;
}

.select-page {
	border: orange;
}

.auto-style2 {
	margin-left: 231px;
}

.auto-style3 {
	margin-left: 480px;
	height: 30px;
}

.bottom-page-numbers {
	color: blue;
}

.page-selector-list li {
	display: inline;
	color: blue;
	border: white;
}

.page-selector-list-selected li {
	display: inline;
	color: orange;
}
</style>

<script type="text/javascript">
  var ccontextPath="${pageContext.request.contextPath}";
</script>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>

<script>
$(document).ready(function() {
	
	//This is invoked when button is clicked
	 $("input[id*='addToCartButton']").click(function(){
		 	var pDogId=$(this).attr("dogid");
		 	 $.post(ccontextPath+"/jaddToCart.htm",{dogId:pDogId},function(result){
		 	      alert(result);
		 	    });//end of ajax post method.
	 });//end of add to cart button action.
	
	 $(document).on('mouseover mouseout', '.bottom-page-numbers', function(){
			$(this).toggleClass('favourite');
	    });///Mouse over on bottom numbers ends
});//toggle function ends

	function loadNextPage(pindexNo){
		//alert(pindexNo)
		$.ajax({url:ccontextPath+"/jshoppingPage.htm?indexNo="+pindexNo,success:function(sdata) {
			var imageDids = sdata.split(",") // Delimiter is a string
			var length = imageDids[0]
			//alert(length);
			var loopCount = 1;
			for (var i = 1; i < imageDids.length; i+=4) {		
				//alert(i);
				var newImage="<img  class=\"auto-style1\" height=\"100\" style=\"float: left\" width=\"100\"	src=\""+ccontextPath+"/loadImageBydid.htm?did="+imageDids[i]+"\"/>";
			    var newOnClick="addToCart(" + imageDids[i] + ")";
			    //alert(newOnClick);
				var newTitle="Title: " + imageDids[i+1];
			    var newPrice="Price: " + imageDids[i+2];
			    var newDesc="Description: " + imageDids[i+3];
				
				var imageid="#ppic"+(loopCount);
			    var titleid="#title"+(loopCount);
			    var priceid="#price"+(loopCount);
			    var descid="#desc"+(loopCount);
			    var addtocartid="#addToCartButton"+(loopCount);
			    //alert(addtocartid);
			    
			    var rowid="#imageRow"+(loopCount);
			    $(rowid).show();
			    
			    
				$(imageid).html(newImage);
				$(titleid).html(newTitle);
				$(priceid).html(newPrice);
				$(descid).html(newDesc);
				
				//setting the value for the attribute dogid =??? when next page is clicked 
				$(addtocartid).attr( "dogid",imageDids[i]);
				//alert("addtocartid = "+addtocartid);
			//	alert($(addtocartid).attr( "dogid"));
				//$(addtocartid).attr("onclick",newOnClick); ///This is not working see more about the bug here: http://bugs.jquery.com/ticket/4281#comment:2
				//alert("success");
				
				loopCount++;
			}
			//hiding some rows.
			var loopmax = 3 - length;
			for(var hc=0;hc<(3-length);hc++) {
			  var rowid="#imageRow"+(3-hc);
			  $(rowid).hide();
			}  
		} //end of callback method
	   });  //end of ajax call
	} //end of the method
	

/* 	function addToCart() {
		 var bid=$(this);
		 alert(bid);
		 var addtocartid="#addToCartButton1";
		 alert($(addtocartid).attr( "dogid"));
		
	} *///end of addToCart method
	
</script>



<!--  This website template is designed by TemplateMo.com  -->
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="addtemplatemo_content_1" style="color: black">

		<%-- <input type="hidden" name="numberOfDogs" id="numberOfDogs"
					value="${dogs.size()}" />  --%>

		<input type="hidden" name="remainder" id="remainder" value="" />


		<h1 align="center" id="pages"></h1>
		
		<h1>Welcome <c:out value="${sessionScope.userLoggedIn.firstName}" />!</h1>

		<table align="left" border="0">
			<c:forEach var="item" items="${dogs}" varStatus="cStatus" end="2">
				<tr style="color: black" id="imageRow${cStatus.count}">
					<td><span id="ppic${cStatus.count}"> <img alt=""
							class="auto-style1" height="100" style="float: left" width="100"
							src="${pageContext.request.contextPath}/loadImageBydid.htm?did=${item.did}" />
					</span>
						<p class="auto-style2" id="title${cStatus.count}"
							style="width: 458px; height: 21px;">Title: ${item.title}</p>
						<form action="" method="post" style="float: right">
							<input id="addToCartButton${cStatus.count}" class="auto-style3"
								style="width: 168px" type="button" value="Add to Cart"
								onclick="addToCart();" dogid="${item.did}" />
						</form>
						<p class="auto-style2" id="price${cStatus.count}"
							style="width: 456px">Price: $${item.price}</p>
						<p class="auto-style2" id="desc${cStatus.count}"
							style="width: 456px; height: 74px;">Description:
							${item.description}</p></td>
				</tr>
			</c:forEach>
		</table>


		<br /> <br /> <br />
		<div class="pageSelector" align="center">
			<ul class="page-selector-list">
				<%
					Integer pages = (Integer) request
							.getAttribute("totalNumberOfPages");
					for (int x = 1; x <= pages; x++) {
				%>
				<li id="page_<%=x%>"><a
					href="javascript:loadNextPage('<%=x%>')"
					id="bottom-page-number<%=x%>" class="bottom-page-numbers"><b><%=x%></b></a>
					&nbsp;&nbsp;&nbsp;&nbsp</li>
				<%
					}
				%>

			</ul>



			<%-- <c:forEach var="item" items="${Integer.parseInt(totalNumberOfPages)}" varStatus="cStatus">
						<a href="">${cStatus}</a>  <!-- Having trouble knowing the capabilities and limitations of jstl -->
					</c:forEach>  <!-- Having trouble knowing the capabilities and limitations of ajax --> --%>

		</div>

		<div class="clear">&nbsp;</div>
	</div>
	</div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
<!--  This website template is designed by TemplateMo.com  -->
</html>

