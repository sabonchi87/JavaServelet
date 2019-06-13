package Guestbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




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



@WebServlet("/DeleteServ")
public class DeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		

Connection c = null;
try
{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
				String username = "cs3220stu01";
				String password = "!mDz8Pt3";


					String sql = "delete from Guestbook  where id=?";

				c = DriverManager.getConnection( url, username, password );
				PreparedStatement pstmt = c.prepareStatement( sql );
				pstmt.setInt( 1, Integer.parseInt(request.getParameter("id")));
				
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
				
				response.sendRedirect( "DisplayServ" );
}

		
		
		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
