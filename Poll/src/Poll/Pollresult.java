package Poll;

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




@WebServlet("/Pollresult")
public class Pollresult extends HttpServlet {
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
		

		Poll ent=getEntry(id);
		//System.out.println(ent.name);
		getServletContext().setAttribute( "ent", ent);
		getServletContext().setAttribute( "id", id );
		
		
		
		
		List<Result> result = new ArrayList<Result>();
        Connection c = null;
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            c = DriverManager.getConnection( url, username, password );
            String  sql="select * from records where a_id=?" ;
            
            
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1,  id);
            ResultSet rs =pstmt.executeQuery();

            while( rs.next() )
            	result.add( new Result( rs.getInt( "id" ),rs.getInt( "a" ),rs.getInt( "b"),rs.getInt( "c" ),rs.getInt( "a_id" )));

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
        
        
        for(int i=0;i<result.size();i++ ) {
        	System.out.println(result.get(i).b);
        	
        	
        }
                       
        
        getServletContext().setAttribute( "result",result);

         request.getRequestDispatcher( "/WEB-INF/Pollresult.jsp" ).forward( request, response );

		
		
		
		
		
		
		
		
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
