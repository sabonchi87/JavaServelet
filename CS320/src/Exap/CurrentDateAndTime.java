package Exap;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns="/Intro/CurrentDateAndTime",loadOnStartup=1)
public class CurrentDateAndTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		// get a refrence to the serverlet context
		@SuppressWarnings("unused")
		ServletContext context= this.getServletContext();
		// add out counter to the context
		context.setAttribute("DateAndTimeCounter", 0);
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get a refrence to the serverlet context
		@SuppressWarnings("unused")
		ServletContext context= this.getServletContext();
		// get the counter as an object ,cast
		int count= (int)context.getAttribute("DateAndTimeCounter");
		// increment
		count++;
		// set it back
		context.setAttribute("DateAndTimeCounter", count);	
				
				
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	out.println("	<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Current Date & Timet</title>");
	out.println("</head>");	
	out.println("<body>");
	out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">");
	out.println("<div class=\"container\"> ");
	out.println("<h1> Thecurrent Date and &amp;Time is:"+new Date()+"</h1>");
	
	out.println(("<a href=\"DateAndTimeMatrics\"> Server </h2>"));
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
