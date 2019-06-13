package Faculty;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FacultyServ")
public class FacultyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
        
		ArrayList<Department> dep=  new ArrayList<Department>();
		ArrayList<Faculty> faculty=  new ArrayList<Faculty>();
		
		faculty.add(new Faculty("Raj Pamula","Computer Science",true));
		faculty.add(new Faculty("Sun","Computer Science",false));
		
		dep.add(new Department("Computer Science",faculty));
		
		//faculty.forEach(x-> System.out.println(x));
		System.out.println(faculty.get(0).getName());
		
		
		ServletContext context = this.getServletContext();
		context.setAttribute("dep", dep);
		context.setAttribute("faculty", faculty);	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
		request.getRequestDispatcher("FacultyInfo.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
