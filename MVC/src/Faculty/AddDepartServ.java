package Faculty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AddDepartServ")
public class AddDepartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddDepartServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Department> dep                = (ArrayList<Department>)getServletContext().getAttribute("dep");
		//ArrayList<hiringfFculty> FaccultyEntries = (ArrayList<hiringfFculty>) getServletContext().getAttribute("FaccultyEntries");
		
	   	 String dept = request.getParameter("department");
	     //ArrayList<Faculty> faculty=  new ArrayList<Faculty>();
	   	   
	   	//new Department(dept).getFaculty().get(index)
	
	   	
	   	dep.add(new Department(dept));
	   	getServletContext().setAttribute("dep", dep);
	   	response.sendRedirect( "FacultyServ" );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
