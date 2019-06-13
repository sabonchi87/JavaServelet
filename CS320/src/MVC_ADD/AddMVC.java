package MVC_ADD;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddMVC")
public class AddMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMVC() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter( "a" );
        String b = request.getParameter( "b" );

        if( a == null || a.trim().length() == 0 || b == null
            || b.trim().length() == 0 )
        {
            response.sendRedirect( "AddMVC" );
            return;
        }

        int sum = Integer.parseInt( a ) + Integer.parseInt( b );

        request.setAttribute( "a", a );
        request.setAttribute( "b", b );
        request.setAttribute( "sum", sum );
		
		
		
		
		
	}

}
