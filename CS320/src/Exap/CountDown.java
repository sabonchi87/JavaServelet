package Exap;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountDown
 */
@WebServlet("/CountDown")
public class CountDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
      int count=10;
    
    public CountDown() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
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
		
		if(count==0){
			out.println("<h3> Booom</h3>");	
			
		}
		
		
		else{
			out.println("<h3>"+count +"</h3>");
			//refresh the page automaticlly
			response.setHeader("refresh","1");
			count--;
			
			
		}
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

	
	

}
