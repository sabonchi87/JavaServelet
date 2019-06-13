package ADDMVC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GuestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
    
		
		List<GuestBookEntry> entry = new ArrayList<GuestBookEntry>();
		entry.add(new GuestBookEntry("hassan","AslamWkikem"));
		entry.add(new GuestBookEntry("Haj mh","hi"));
		
		

        // stored the data somewhere that can be accessed by this servlet
        // and other servlets.
        //getServletContext().setAttribute( "entries", entries );
		getServletContext().setAttribute( "entry", entry );
		//request.setAttribute( "entry", entry );
		
		
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/GusetbookView.jsp").forward(request, response);
		//request.getRequestDispatcher( "/WEB-INF/View.jsp").forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
