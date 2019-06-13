package Files;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/subFolder")
public class subFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		List<Files> entries2 = new ArrayList<Files>();
		
		// save this Id as parent ID
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		 Connection c = null;
	        try
	        {
	           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
		            String username = "cs3220stu01";
		            String password = "!mDz8Pt3";


	            c = DriverManager.getConnection( url, username, password );
	          
	            String sql="select * from files where parent_id=?";
	            PreparedStatement pstmt = c.prepareStatement( sql );
		        pstmt.setInt( 1, id);
		        ResultSet rs =pstmt.executeQuery();


	            while( rs.next() ){
	                entries2.add( new Files( 
	                	rs.getInt( "id" ),
	                    rs.getString( "name" ), 
	                    rs.getInt( "is_folder" ),
	                    rs.getInt( "parent_id" ),
	                    rs.getInt( "owner_id" ) ) );
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
	        
		
		
	        getServletContext().setAttribute( "entries2", entries2 );
	        getServletContext().setAttribute( "subId", id );
	        
	        

	       request.getRequestDispatcher("/WEB-INF/subDisplay.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
