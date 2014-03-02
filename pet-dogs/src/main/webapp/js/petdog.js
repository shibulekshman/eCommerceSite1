
/**
 *  This method will be called when zoom in/out functionality 
 *   is performed on images
 * @param imageId
 */
function applyZoom(imageId){
	 			$(imageId).photoZoom();
}


/**
 *  This method will be called when next button is clicked
 *  from sliding image component
 */
function jpreImage() {
		//alert("Hello jpreImage");
		var hpni =$("#cpi").val();
		  if(hpni<=0){
			  alert("Previous  record does not exist!");
			  return;
		  }
		$.ajax({url:ccontextPath+"/jpreImage.htm?cpi="+hpni,	success:function(sdata) {
			//alert(sdata);
			if(sdata=="nc") {
				alert("Previous  record does not exist!");
				return;
			}
			var newImage="<img	  id=\"pic1\" src=\""+ccontextPath+"/loadImageBydid.htm?did="+sdata+"\" 	alt=\"center\"  width=\"120\"	height=\"120\" />";
		    var txt1=document.getElementById("pic1").src;
			var txt2=document.getElementById("pic2").src;
			var txt3=document.getElementById("pic3").src;
			var txt4=document.getElementById("pic4").src;
			var txt5=document.getElementById("pic5").src;
			
			 $("#ppic1").html(newImage);
			//document.getElementById("pic1").src=txt2;
			document.getElementById("pic2").src=txt1;
			document.getElementById("pic3").src=txt2;
			document.getElementById("pic4").src=txt3;
			document.getElementById("pic5").src=txt4;
	    	$("#cni").val(parseInt(hpni)+3);
			$("#cpi").val(parseInt(hpni)-1);
		}
   });  
}

/**
 *  This method will be called when previous button is clicked
 *  from sliding image component
 */
function jnextImage() {
    var hcni =$("#cni").val();
    //alert("hcni = "+hcni);
	$.ajax({url:ccontextPath+"/jnextImage.htm?cni="+hcni,	success:function(sdata) {
		if(sdata=="nc") {
			alert("Next record does not exist!");
			return;
		}
	    var newImage="<img	 id=\"pic5\" src=\""+ccontextPath+"/loadImageBydid.htm?did="+sdata+"\" 	alt=\"center\"  width=\"120\"	height=\"120\" />";
		 //$("img[id=#viewPhoto]").attr('src', newSrc);
		 var txt1=document.getElementById("pic1").src;
		 var txt2=document.getElementById("pic2").src;
		 var txt3=document.getElementById("pic3").src;
	  	 var txt4=document.getElementById("pic4").src
	  	 var txt5=document.getElementById("pic5").src;
	  	 
		 $("#ppic5").html(newImage);
	  	document.getElementById("pic1").src=txt2;
		document.getElementById("pic2").src=txt3;
		document.getElementById("pic3").src=txt4;
		document.getElementById("pic4").src=txt5;
		//here we have to update the next and pre index
		$("#cni").val(parseInt(hcni)+1);
		$("#cpi").val(parseInt(hcni)-3);
	}
});  
}