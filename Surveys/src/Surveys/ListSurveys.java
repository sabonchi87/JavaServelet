package Surveys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListSurveys")
public class ListSurveys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//List of surveys
		List <SurveysModel> surveys = new ArrayList <SurveysModel>();
		 
		
		//List of Questions for the surveys
		List<QuestionsModel> Questions=new ArrayList <QuestionsModel>();
		
		List <String> choices = new ArrayList <String>();
		choices.add( new String("yes"));
		choices.add( new String("choices.add( new String(\"yes\"));"));
		choices.add( new String("no"));
		
		
		Questions.add( new QuestionsModel("Have you completed all the following prerequisite CS courses with minimum C grade: CS3035, CS3112, CS3186, CS3220, CS3337, and CS3801? \n" + 
				"\n" + 
				"",choices));
		
		
		surveys.add(new SurveysModel("CS 4961 Readiness Survey for Fall 2019",Questions));
		
		
		
		
		getServletContext().setAttribute("surveys", surveys);
		
		
		
			
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/ListSurvey.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
