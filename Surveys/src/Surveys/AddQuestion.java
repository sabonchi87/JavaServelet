package Surveys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Surveys.SurveysModel;


@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/AddQuestion.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//List<SurveysModel>  surveys= (List<SurveysModel>)  getServletContext().getAttribute("surveys");
		
		 String name=request.getParameter("ques");
		 
		 SurveysModel entry= (SurveysModel)getServletContext().getAttribute("entry");
		 
		 
		  List <String> ch= new ArrayList<String>();
		  
		 
		 
		 for(int i=1;i<=10;i++) {
			 
			String choices=request.getParameter("choice"+i);
			if(choices != null && choices.trim().length()>0) {
				
				ch.add(choices);
				
			 }
			
		 }
		 
		 entry.Questions.add( new QuestionsModel(name,ch));
		 
		 response.sendRedirect("ListSurveys");
		
		
		
	}

}
