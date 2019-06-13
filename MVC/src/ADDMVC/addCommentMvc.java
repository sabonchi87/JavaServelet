package ADDMVC;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addCommentMvc
 */
@WebServlet("/addCommentMvc")
public class addCommentMvc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addCommentMvc() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/addComment.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<GuestBookEntry> entries = ((List <GuestBookEntry>) getServletContext().getAttribute( "entry" ));
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entry");
		
		String name=request.getParameter("name");
		String mess=request.getParameter("message");
		System.out.println("NAME"+name);
		System.out.println(mess);
		//GuestBookEntry entry= new GuestBookEntry (name,mess);
		
		//ArrayList <GuestBookEntry> entries= (ArrayList <GuestBookEntry>) getServletContext().getAttribute("entry");
		//System.out.println(entry);
		entries.add(new GuestBookEntry(name,mess));
		// send the user back to the GuestBook page
		response.sendRedirect("GuestBook");	
		
		
		
	}

}
