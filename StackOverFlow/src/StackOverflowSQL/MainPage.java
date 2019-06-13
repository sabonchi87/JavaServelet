package StackOverflowSQL;

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


@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		List<Integer> sum = new ArrayList<Integer>();
		
		List<Questions> entries = new ArrayList<Questions>();
		
		ResultSet rs;
        Connection c = null;
        
        
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
          rs = stmt.executeQuery( "Select * from Questions" );

            while( rs.next() ){
                entries.add( new Questions( rs.getInt( "id" ),
                    rs.getString( "name" ), rs.getString( "details" ) ) );
		}
            
            
            String sql="Select  q.id , count(d.q_id) as sum from Questions q left join Details d on q.id=d.q_id  group by q.id order by q.id ";
            
           rs = stmt.executeQuery( sql );
           while( rs.next() ){
        	   sum.add( new Integer( rs.getInt( "sum" )
                    ) );
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
                     
       getServletContext().setAttribute( "entries", entries );

       
       
       getServletContext().setAttribute( "sum", sum );
		
       request.getRequestDispatcher( "/WEB-INF/dispQues.jsp").forward( request, response );

		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
