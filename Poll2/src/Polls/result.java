package Polls;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


@WebServlet("/result")
public class result extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected Polls getEntry(int id) {
		
		
		ArrayList <Polls> candidates =((ArrayList <Polls>) getServletContext().getAttribute("entries"));
				
				  for (Polls entry : candidates) {
					  
					  if (entry.getId()==id)
				 
				               return entry;
				  }
				
				  return null;
			}
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int id =Integer.parseInt(request.getParameter("id"));  
		//System.out.println("Result"+id);
			
		Polls E1=getEntry(id);
		getServletContext().setAttribute( "E1", E1);
						
		getServletContext().setAttribute( "id", id);	
		
		
		
		
		
		List<pollResult> Result = new ArrayList<pollResult>();
        Connection c = null;
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from Presult where p_id="+id );

            while( rs.next() ){
            	Result.add( new pollResult(rs.getInt( "A1" ),rs.getInt( "A2" ),rs.getInt( "A3" )) );
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
                                                
        getServletContext().setAttribute( "Result", Result );

		
//        for (int i=0;i<Result.size();i++) {
//        	
//        	System.out.println(Result.get(i));
//        	
//        }
		
        request.getRequestDispatcher( "/WEB-INF/Result.jsp" ).forward( request, response );	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
