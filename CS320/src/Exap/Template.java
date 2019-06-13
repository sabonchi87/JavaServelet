package Exap;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Template
 */
@WebServlet( urlPatterns={"/Template"})
public class Template extends HttpServlet {
	private static final long serialVersionUID = 1L;
     static int count=0;  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set My content type
				response.setContentType("text/html");
				
				PrintWriter out= response.getWriter();
				
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("  <meta charset=\"UTF-8\">" );
				out.println("<title>Insert title here</title>");
				out.println("  <link rel=\"stylesheet\"  href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\"> ");
				out.println("</head>");
				out.println("<body>");
				
				out.println("<div class=\"container\">");
				
				out.println("<u> Hi there"+  ++count +"</u>");
				
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
