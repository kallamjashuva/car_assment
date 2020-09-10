package com.test.assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*
		 * Company Model Color Dateofpurchase Price EngineCapacity LicencePlateNumber SeatingCapacity
		 *  
		 */
		String Company = request.getParameter("Company");
		String Model = request.getParameter("Model");
		String Color = request.getParameter("Color");
		String Dateofpurchase = request.getParameter("Dateofpurchase");
		String Price = request.getParameter("Price");
		String EngineCapacity = request.getParameter("EngineCapacity");
		String LicencePlateNumber = request.getParameter("LicencePlateNumber");
		String SeatingCapacity = request.getParameter("SeatingCapacity");
		
		Car e = new Car();
		e.setCompany(Company);
		e.setModel(Model);
		e.setColor(Color);
		e.setDateofpurchase(Dateofpurchase);
		e.setPrice(Price);
		e.setEngineCapacity(EngineCapacity);
		e.setLicencePlateNumber(LicencePlateNumber);
		e.setSeatingCapacity(SeatingCapacity);
		int status = CarDao.update(e);
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
