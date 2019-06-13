package Poll;

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


@WebServlet("/CreatePollServ")
public class CreatePollServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//System.out.println("Im on the get ");
		
		
		request.getRequestDispatcher( "/WEB-INF/CreatePoll.jsp" ).forward( request, response );
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("q"));
		
	
		  request.getParameter("ch1");

		  request.getParameter("ch3");
		  
		  
		  
		  
		  Connection c = null;
	        try
	        {
	          	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
		            String username = "cs3220stu01";
		            String password = "!mDz8Pt3";

		         c = DriverManager.getConnection( url, username, password );
	            String sql = "insert into  poll (name,choice1,choice2,choice3)  values (?, ?, ?,?)";

	            
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            pstmt.setString( 1,   request.getParameter("q") );
	            pstmt.setString( 2,  request.getParameter("ch1"));
	            pstmt.setString( 3,  request.getParameter("ch2"));
	            pstmt.setString( 4,  request.getParameter("ch3"));
	            pstmt.executeUpdate();
	            
	              
	            String sql1="select id from poll where name=?";
	            		
	            pstmt = c.prepareStatement( sql1);
	            pstmt.setString( 1,   request.getParameter("q") );
	            
	             int id=-1;
	            
	            ResultSet rs= pstmt.executeQuery();
	               
	               while( rs.next() )	{
		            	
	            	   id=rs.getInt("id");
		            }

	               //System.out.println("newly inserted element"+id);
	            
	            
	           
            String sql2="INSERT INTO records (`a`, `b`, `c`, `a_id`) VALUES (0, 0, 0, ?)";
	          pstmt = c.prepareStatement( sql2 );
	          pstmt.setInt( 1, id  );
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

	        response.sendRedirect( "PollsServ" );
	    }

		  
		  
		  
		  
		  
		  
		  
		  
		  
		
		
		
		
	

}
