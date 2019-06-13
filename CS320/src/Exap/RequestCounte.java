package Exap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestCounte
 */
@WebServlet("/RequestCounte")
public class RequestCounte extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	// check box all they have the same name getParameterName
	//
	// user agent tells the  server type of  browser
	//Creating scope ,common area  Application scope, request ,session differnet server can share data
	    public void init( ServletConfig config ) throws ServletException
	    {
	        // When you override init(), don't forget to call the super class
	        // init() first.
	        super.init( config );// remember to do this
	        
	        

	        // Note that Java automatically converts between int and Integer
	        // (i.e. the "Autoboxing and Unboxing" feature since JDK 1.5.
	        int counter = 0;
	        // put counter in Application Scope, as a map
	        getServletContext().setAttribute( "counter", counter );
	    }

	    protected void doGet( HttpServletRequest request,
	        HttpServletResponse response ) throws ServletException, IOException
	    {
	        ServletContext servletContext = getServletContext();

	        // get the counter, because it return an object
	        Integer counter = (Integer) servletContext.getAttribute( "counter" );

	        // increment the counter
	        ++counter;

	        // save it back the application scope
	        servletContext.setAttribute( "counter", counter );

	        // display the message "the counter is incremented"
	        PrintWriter out = response.getWriter();

	        response.setContentType( "text/html" );
	        out.println( "<html><head><title>Request Counter</title></head><body>" );
	        out.println( "<p>The counter is incremented.</p>" );
	        out.println( "</body></html>" );
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
