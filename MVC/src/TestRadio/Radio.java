package TestRadio;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Radio
 */
@WebServlet("/Radio")
public class Radio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Radio() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/radio.jsp" ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String q1 = request.getParameter("1");
		//System.out.print(q1+" q1");
		int a=Integer.parseInt(request.getParameter("a"));
				
		System.out.println(" == a====="+ a );
		
		String[] RadioArr = request.getParameterValues("foo");
		for(int i=0;i<RadioArr.length;i++) {
			 System.out.println(RadioArr[i]); 
		}
		
		
	}

}
