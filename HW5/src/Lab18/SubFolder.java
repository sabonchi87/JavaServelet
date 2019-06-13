package Lab18;

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


@WebServlet("/SubFolder")
public class SubFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		List<Files> SubFolder = new ArrayList<Files>();
        Connection c = null;
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            c = DriverManager.getConnection( url, username, password );
            
            String sql="select * from files where parent_id=?" ;
            PreparedStatement pstmt = c.prepareStatement( sql);
            pstmt.setInt( 1, Integer.parseInt(request.getParameter("id")) );
            ResultSet rs= pstmt.executeQuery();
            
            
            while( rs.next() ){
            	SubFolder.add( new Files( rs.getInt( "id" ),
                    rs.getString( "name" ), rs.getInt( "is_folder" ),
                    rs.getInt( "parent_id" ),rs.getInt( "owner_id" ) ) );
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
         
       getServletContext().setAttribute( "SubFolder", SubFolder );

       request.getRequestDispatcher( "/WEB-INF/DisplaySubfolder.jsp" ).forward( request, response );
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
