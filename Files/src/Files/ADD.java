package Files;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ADD")
public class ADD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//save to reuse it later
		 getServletContext().setAttribute( "id", Integer.parseInt(request.getParameter("id")) );
		
		
		
		request.getRequestDispatcher("/WEB-INF/ADD.jsp").forward(request, response);	
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id=(int) getServletContext().getAttribute("id");
		
		
		//int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);	
		
		Connection c = null;
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

            c = DriverManager.getConnection( url, username, password );
            if(id==-1) {
          
            String sql="insert into files (name,is_folder,parent_id,owner_id) values (?,1,null,1)";
            PreparedStatement pstmt = c.prepareStatement( sql );
	        pstmt.setString( 1, request.getParameter("name"));
	        pstmt.executeUpdate();
            }

            
            else {
            	
            	
            	 String sql="insert into files (name,is_folder,parent_id,owner_id) values (?,1,?,1)";
                PreparedStatement pstmt = c.prepareStatement( sql );
     	        pstmt.setString( 1, request.getParameter("name"));
     	        pstmt.setInt( 2, id);
     	        pstmt.executeUpdate();
            	
            	 	
            }

            

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
		
		
		response.sendRedirect("Maindisplay");
		
	}

}
