package ADDMVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addServer
 */
@WebServlet("/addServer")
public class addServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public addServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//Forword the request to jsp  is one request
		// redirect involved 2 request
		request.getRequestDispatcher( "addmvc.jsp").forward( request, response );	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// Processing the form
		
		String str1=request.getParameter("a");
		String str2=request.getParameter("b");
		 if(str1== null||str2==null||str1.trim().length()==0||str2.trim().length()==0){
				
			 	// send back to the same page and do get will handle the request
				response.sendRedirect("addServer");
				//you need to add return statment to terminate the program
				 return;
		 }
		 
		int a =Integer.parseInt(str1);
		int b=Integer.parseInt(str2);
		 
		 int sum=a+b; 
		 
		        request.setAttribute("a", a);
		        request.setAttribute("b", b);
		        request.setAttribute("sum", sum);	
		        
		        request.getRequestDispatcher( "/WEB-INF/View.jsp").forward( request, response );
	}	
		
	}


