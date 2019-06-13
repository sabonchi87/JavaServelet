package Guestbook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServ")
public class EditServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected Guestbook getEntry(int id) {
		
		ArrayList <Guestbook> candidates =((ArrayList <Guestbook>) getServletContext().getAttribute("entries"));
			
			  for ( Guestbook entry : candidates) {
				  
				  if (entry.getId()==id)
			 
			               return entry;
			  }
			
			  return null;
		}

	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
		int id =Integer.parseInt(request.getParameter("id"));  
		System.out.println(id);

		Guestbook	c=getEntry(id);
		
		getServletContext().setAttribute( "id", id );
		getServletContext().setAttribute( "c", c );
		
		request.getRequestDispatcher("/WEB-INF/EditGuestBook.jsp").forward(request, response);


		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		
		 Connection c = null;
	        try
	        {
	        	   
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c = DriverManager.getConnection( url, username, password );
	            //Statement stmt = c.createStatement();
	            
	            
           String sql = "UPDATE  Guestbook set name=? ,message=? where id=?";
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );
	           pstmt.setString( 1, request.getParameter("name"));
	           pstmt.setString( 2, request.getParameter("message"));
	  
	           // must be an Integer
	           pstmt.setInt( 3,  (int) getServletContext().getAttribute( "id" ));
	           
	            pstmt.executeUpdate();
	            
	         

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
		
		
		
		
		
		String candidateName=request.getParameter("name");
		String Specia=request.getParameter("message");
		
		
		
//		System.out.println(" ID "+request.getParameter("id"));
//		System.out.println(" candidateName "+candidateName);
//		System.out.println(" Specia "+Specia);
//		System.out.println(" Present "+Present);
		
		
		    // entry=getEntry(id);
		
	
		
		response.sendRedirect("DisplayServ");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
