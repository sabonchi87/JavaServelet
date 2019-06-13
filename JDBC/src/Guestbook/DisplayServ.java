package Guestbook;



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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayServ")
public class DisplayServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Guestbook> entries = new ArrayList<Guestbook>();

		
		 Connection c = null;
	        try
	        {
	        	   
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            
	           
                 String sql = "select * from Guestbook ";
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            
	   	           
	            ResultSet rs =pstmt.executeQuery();
	            
	            while( rs.next() )
	                entries.add( new Guestbook( rs.getInt( "id" ),
	                    rs.getString( "name" ), rs.getString( "message" )));

	            	            
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
		
		

		
		
		
	        getServletContext().setAttribute( "entries", entries );
	       
		
		
		
	        request.getRequestDispatcher( "/WEB-INF/ViewGuestBook.jsp" )
            .forward( request, response );
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
