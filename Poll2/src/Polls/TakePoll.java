package Polls;

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


@WebServlet("/TakePoll")
public class TakePoll extends HttpServlet {
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
		System.out.println(id);
			
		Polls E=getEntry(id);
		getServletContext().setAttribute( "E", E);
						
		getServletContext().setAttribute( "id", id);	
		request.getRequestDispatcher("/WEB-INF/TakePoll.jsp").forward(request, response);

			
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =(int) getServletContext().getAttribute("id");
		
		
		int Answer=0;
		for(int i=1;i<=3;i++) {
			
			if (request.getParameter("A"+i)!=null) {
				Answer=i;	
			}
			
		}
			System.out.println("Answer "+Answer);
			
			Connection c = null;
	        try
	        {
	        	   
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c = DriverManager.getConnection( url, username, password );
	            //Statement stmt = c.createStatement();
	            
	            
	            if(Answer==1) {
	            
	            
	            
                String sql = "UPDATE  Presult set A1=A1+1 where p_id=? ";
	            PreparedStatement pstmt = c.prepareStatement( sql ); 
	            pstmt.setInt( 1,  (int) getServletContext().getAttribute( "id" ));
	           
	            pstmt.executeUpdate();
	            }
	         
	            
	            else if(Answer==2) {
		            
		            
		            
	                String sql = "UPDATE  Presult set A2=A2+1 where p_id=? ";
		            PreparedStatement pstmt = c.prepareStatement( sql ); 
		           pstmt.setInt( 1,  (int) getServletContext().getAttribute( "id" ));
		           
		            pstmt.executeUpdate();
		            }
		         
	            
	            else {
	            	
	            	    String sql = "UPDATE  Presult set A3=A3+1 where p_id=? ";
			            PreparedStatement pstmt = c.prepareStatement( sql ); 
			            pstmt.setInt( 1,  (int) getServletContext().getAttribute( "id" ));
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

			
			
			
			
			
			
			
			
	        response.sendRedirect("ListPolls");
			
			
			
			
			
			
			
			
			
			
			
    }
		
		
		
		
		
		
		
		
		
	}


