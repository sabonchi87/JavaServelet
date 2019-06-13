package Poll;

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




@WebServlet("/Takepoll")
public class Takepoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected  Poll getEntry(int id) {
		
		
		ArrayList <Poll> candidates =((ArrayList <Poll>) getServletContext().getAttribute("entries"));
			
			  for ( Poll entry : candidates) {
				  
				  if (entry.getId()==id)
			 
			               return entry;
			  }
			
			  return null;
		}
		
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println(request.getParameter("id"));
		int id =Integer.parseInt(request.getParameter("id"));  
		

		Poll c=getEntry(id);
		System.out.println(c.name);
		getServletContext().setAttribute( "c", c );
		getServletContext().setAttribute( "id", id );
		request.getRequestDispatcher("/WEB-INF/TakePoll.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Poll entry=  (Poll) getServletContext().getAttribute( "c");
		
		int id= (int) getServletContext().getAttribute( "id" );
		System.out.println(id);
		
int  ans=0;
		
		for(int i=1;i<=3;i++) {
			
					if (request.getParameter("ch"+i)!=null) {
						ans=i;
						
					}
					
		    }
		
		
		//System.out.println("Answer"+ans);
		
			 
		  Connection c = null;
	        try
	        {
	          	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
		            String username = "cs3220stu01";
		            String password = "!mDz8Pt3";


		       	 	PreparedStatement pstmt;
		       	 	String sql;
		       	 	c = DriverManager.getConnection( url, username, password );

	            
	            
	            if (ans==1) {
	   			 
	   			
	   			 sql = " Update records set a=a+1  where a_id="+id;
	   			  pstmt = c.prepareStatement( sql );

		           //System.out.println(sql);
	   			 pstmt.executeUpdate();
	   		 }
	   		
	   		
	   		 else if (ans==2) {
	   						 
	   			 sql = " Update records set b=b+1  where a_id=?";
	   			  pstmt = c.prepareStatement( sql );
	   			  pstmt.setInt( 1,  id ); 
	   			 
		          
	   			 pstmt.executeUpdate();
	   						 
	   					 }
	   		 	 	   		 else {
	   		 	 	   	 sql = " Update records set c=c+1  where a_id=?";
	   	   			  pstmt = c.prepareStatement( sql );
	   	   			  pstmt.setInt( 1,  id ); 
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

	        response.sendRedirect( "PollsServ" );
	    }

		  
		  
		  
		  
		 
		 
		 
		 
		 
		 
		 
		
	

}
