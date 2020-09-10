package com.test.assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CarEdit")
public class CarEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("serial")
	@WebServlet("/EditServlet")
	public class EditServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h1>Update CarDetails</h1>");
			
			
			
			String sid=request.getParameter("Model");
			Car e=CarDao.getCarByModel(sid);
			
			out.print("<form action='EditServlet2' method='post'>");
			out.print("<table>");
			
			out.print("<tr><td></td><td><input type='text' name='Company' value='"+e.getCompany()+"'/></td></tr>");
			out.print("<tr><td>Name:</td><td><input type='text' name='Model' value='"+e.getModel()+"'/></td></tr>");
			out.print("<tr><td>Password:</td><td><input type='text' name='Color' value='"+e.getColor()+"'/></td></tr>");
			out.print("<tr><td>Email:</td><td><input type='text' name='Dateofpurchase' value='"+e.getDateofpurchase()+"'/></td></tr>");
			out.print("<tr><td></td><td><input type='text' name='Price' value='"+e.getPrice()+"'/></td></tr>");
			out.print("<tr><td>Name:</td><td><input type='text' name='EngineCapacity' value='"+e.getEngineCapacity()+"'/></td></tr>");
			out.print("<tr><td>Password:</td><td><input type='text' name='LicencePlateNumber' value='"+e.getLicencePlateNumber()+"'/></td></tr>");
			out.print("<tr><td>Email:</td><td><input type='text' name='SeatingCapacity' value='"+e.getSeatingCapacity()+"'/></td></tr>");
			out.print("<tr><td>Country:</td><td>");
			out.print("<select name='country' style='width:150px'>");
			out.print("<option>India</option>");
			out.print("<option>USA</option>");
			out.print("<option>UK</option>");
			out.print("<option>Other</option>");
			out.print("</select>");
			out.print("</td></tr>");
			out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
			out.print("</table>");
			out.print("</form>");
			
			out.close();
		}
	}
}
