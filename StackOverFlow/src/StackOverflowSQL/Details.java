package StackOverflowSQL;

import java.io.IOException;
import java.util.ArrayList;

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




@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

//	protected  Details getEntry(int id) {
//		
//		ArrayList <DetialsM> candidates =((ArrayList <DetialsM>) getServletContext().getAttribute(""));
//			
//			  for (DetialsM entry : candidates) {
//				  
//				  if (entry.getId()==id)
//			 
//			               return entry;
//			  }
//			
//			  return null;
		//}
			

	
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	int id =Integer.parseInt(request.getParameter("id"));
		
		
	
		List<DetialsM> details = new ArrayList<DetialsM>();
        Connection c = null;
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            c = DriverManager.getConnection( url, username, password );
            String sql="Select * from  Details  where  q_id=?";
         
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1, id );

            
            ResultSet rs =pstmt.executeQuery();
            

            
            while( rs.next() ){
            	details.add( new  DetialsM( 
            		rs.getInt( "id" ),
                    rs.getString("name"), 
                    rs.getInt( "q_id" ) 
                    ));
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
          
       getServletContext().setAttribute( "details", details );

       getServletContext().setAttribute( "name", request.getParameter("n") );
       getServletContext().setAttribute( "dt", request.getParameter("dt") );
       
       
       // save it for using it in ADD Answer
       getServletContext().setAttribute( "id", id );
		
       request.getRequestDispatcher("/WEB-INF/Answers.jsp").forward(request, response);
		
			
		
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
