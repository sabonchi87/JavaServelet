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

/**
 * Servlet implementation class DateAndTimeMatrics
 */
@WebServlet("/Intro/DateAndTimeMatrics")
public class DateAndTimeMatrics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DateAndTimeMatrics() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get a refrence to the serverlet context
		@SuppressWarnings("unused")
		ServletContext context= this.getServletContext();
		// get the counter as an object ,cast
		int count= (int)context.getAttribute("DateAndTimeCounter");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("	<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Server</title>");
		out.println("</head>");	
		out.println("<body>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">");
		out.println("<div class=\"container\"> ");
		out.println("<h1> Server :"+"</h1>");
		
		
		out.println("<p class=\"container-fluid\">The Date and Time has been viwed:"+count+ "times"+"</p>");
		out.println("</div>");
		out.println(("<a href=\"CurrentDateAndTime\"> CurrentDateAndTime </a>"));
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
