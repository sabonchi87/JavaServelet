package Polls;

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


@WebServlet("/CreatePoll")
public class CreatePoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher( "/WEB-INF/CreatePoll.jsp" ).forward( request, response );
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String name=request.getParameter( "name" );
		
		PreparedStatement pstmt;
		Connection c = null;
        try
        {
          	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            String sql = "INSERT INTO `Polls` (`name`, `A1`, `A2`, `A3`)\n" + 
            		"VALUES (?, ?, ?, ?)";

            c = DriverManager.getConnection( url, username, password );
            pstmt = c.prepareStatement( sql );
            pstmt.setString( 1,name  );
            pstmt.setString( 2, request.getParameter( "A1" ) );
            pstmt.setString( 3, request.getParameter( "A2" ) );
            pstmt.setString( 4, request.getParameter( "A3" ) );
            pstmt.executeUpdate();
            
            
            // Get the Id of the newly  inserted  item  to use it as a refrence for p_id
            String sql2="select id from  Polls	 where name=?"; 
            pstmt = c.prepareStatement( sql2 );
            
            pstmt.setString( 1, name);
            ResultSet rs = pstmt.executeQuery( );
            
            // the id of the Question  will be p_id of the   Presult for refrence 
            
            
            int idRes=0;
            while( rs.next()){
            	idRes=rs.getInt( "id" );
            	
            	}
            
            // Each time a new question get inserted into Polls  a new record  of Presult  with default value
            
            String sql3 = "insert into  Presult  (A1,A2,A3,p_id)  values (0,0,0,?)";
            pstmt = c.prepareStatement( sql3 ); 
            pstmt.setInt( 1, idRes );
            
                
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

        	response.sendRedirect( "ListPolls" );
    }

		
		
		
		
		
		
		
		
	}


