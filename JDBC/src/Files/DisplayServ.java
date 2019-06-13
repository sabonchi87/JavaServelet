package Files;

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



@WebServlet(name = "DisplaysServ", urlPatterns = { "/DisplaysServ" })
public class DisplayServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		List<Files> entries = new ArrayList<Files>();
        Connection c = null;
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "  select *  from files as f,users as u \n" + 
            		"    where u.id=f.owner_id \n" + 
            		"    and u.name='cysun' \n" + 
            		"    and f.parent_id is null\n" + 
            		"    order by is_folder Desc " );
            

            while( rs.next() )
                entries.add( new Files ( rs.getInt( "id" ),rs.getString( "name" ), rs.getBoolean( "is_folder" ),rs.getInt( "parent_id" ),rs.getInt( "owner_id" )) );

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

        request.getRequestDispatcher( "/WEB-INF/ViewFiles.jsp" )
            .								forward( request, response );

		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
