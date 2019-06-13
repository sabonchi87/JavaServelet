package Faculty;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddFacultyServ")
public class AddFacultyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Department> depts = (List<Department>)getServletContext().getAttribute("dep");
		 Faculty fac;
	   	 String dept = request.getParameter("department");
	   	 String name = request.getParameter("name");
	   	 String chair = request.getParameter("chair");
	  	 System.out.println(chair);
	   	 
	   	 if (chair !=null) {
	        fac = new Faculty(name,dept,true);
	   	 
	   	 }
	   	 
	   	else {
	   		 
	   	     fac = new Faculty(name,dept,false);
	   	 }
	   	 
	   	System.out.println(dept);
	   	System.out.println(name);
	   	System.out.println(chair);
	   	System.out.println("depts.size"+depts.get(0).getFaculty());
	   	
	   	
		 for(int i=0;i<depts.size();i++)
	   	 {
			//System.out.println(depts.get(i).getName().equals(dept));
			 
	   		 if (depts.get(i).getName().equals(dept))
	   		 {
	   			System.out.println("Departmrnt Selected "+depts.get(i).getName().equals(dept));
	   			//System.out.println("depts.size"+depts.size());
	   			depts.get(i).getFaculty().add(fac);
	   			
	   		 }
	   	 }
	   	
	   	response.sendRedirect( "FacultyServ" );

	   	
	   	
	   	
		
	}

}
