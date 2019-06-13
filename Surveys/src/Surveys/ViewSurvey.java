package Surveys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewSurvey")
public class ViewSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	protected SurveysModel  getId(int id) {
     List<SurveysModel>  surveys= (List<SurveysModel>)  getServletContext().getAttribute("surveys");

     for (SurveysModel entry:surveys) {
    	 
    	 
			       if (entry.getId()==id) {
			    	   
			    	   return entry;
			    	 
			       	}

     	}
    
		 
     return null;
	}
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
         int id=Integer.parseInt(request.getParameter("id"));
		 
		 SurveysModel entry= getId(id);
		 System.out.println(entry.id);
		 getServletContext().setAttribute("entry", entry);
		 
		 ArrayList<QuestionsModel> questions = (ArrayList<QuestionsModel>) entry.getQuestions();
		 
		 System.out.println(questions.get(0).getDescription());
		 getServletContext().setAttribute("questions", questions);
		 
		 request.getRequestDispatcher("/WEB-INF/ViewSurvey.jsp").forward(request, response);
		  
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
