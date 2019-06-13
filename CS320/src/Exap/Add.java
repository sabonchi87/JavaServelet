package Exap;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int sum;
		String	str1;
		String	str2;
		
			str1=request.getParameter("num1");
		    str2=request.getParameter("num2");
		 if(str1== null||str2==null||str1.trim().length()==0||str2.trim().length()==0){
			 
		response.sendRedirect("404.html");
		//you need to add return statment to terminate the program
		 return;
		 }
		 
		    sum=Integer.parseInt(str1)+Integer.parseInt(str2); 	
		    response.setContentType("text/html");
		    PrintWriter out=response.getWriter();
		    
		    
		    out.print("<html><head> <title>Add</title> </head> <body>");
		    out.println("<p> the sum of"+str1+"and"+str2+ "is"+sum+"</p>");
		    out.print(" </body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
