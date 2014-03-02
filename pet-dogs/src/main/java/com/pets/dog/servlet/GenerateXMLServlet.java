package com.pets.dog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author ADMIN-2
 *
 */
public class GenerateXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//This is local variable so I am using here StringBuilder
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("<customers>");
		
		stringBuilder.append("<customer>");
		stringBuilder.append("<firstName>Dave</firstName>");
		stringBuilder.append("<lastName>TATA</lastName>");
		stringBuilder.append("<email>dave@gmail.com</email>");
		stringBuilder.append("<address>New Delhi</address>");
		stringBuilder.append("<mobile>8348484848</mobile>");
		stringBuilder.append("</customer>");
		
		stringBuilder.append("<customer>");
		stringBuilder.append("<firstName>Jhon</firstName>");
		stringBuilder.append("<lastName>Singh</lastName>");
		stringBuilder.append("<email>jhon@gmail.com</email>");
		stringBuilder.append("<address>Canada</address>");
		stringBuilder.append("<mobile>111111</mobile>");
		stringBuilder.append("</customer>");
		
		
		stringBuilder.append("<customer>");
		stringBuilder.append("<firstName>akash</firstName>");
		stringBuilder.append("<lastName>Singh</lastName>");
		stringBuilder.append("<email>akash@gmail.com</email>");
		stringBuilder.append("<address>Fremont</address>");
		stringBuilder.append("<mobile>838383838</mobile>");
		stringBuilder.append("</customer>");
		
		stringBuilder.append("</customers>");
		
		System.out.println(stringBuilder.toString());
		
		//Writting above xml into the response
		response.setContentType("text/xml");
		PrintWriter pw=response.getWriter();
		pw.println(stringBuilder.toString());
	}

}
