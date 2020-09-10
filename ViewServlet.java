package com.test.assignment;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Car</a>");
		out.println("<h1>CarDetails List</h1>");
		
		List<Car> list=CarDao.getAllCars();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Company</th><th>Model</th><th>Color</th><th>Dateofpurchase</th><th>Price</th><th>EngineCapacity</th><th>LicencePlateNumber</th><th>SeatingCapacity</th><th>Edit</th><th>Delete</th></tr>");
		for(Car e:list){
			out.print("<tr><td>"+e.getCompany()+"</td><td>"+e.getModel()+"</td><td>"+e.getColor()+"</td><td>"+e.getDateofpurchase()+"</td><td>"+e.getPrice()+"</td><td>"+e.getEngineCapacity()+"</td><td>"+e.getLicencePlateNumber()+"</td><td>"+e.getSeatingCapacity()+"</td><td><a href='EditServlet?id="+e.getModel()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getModel()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
