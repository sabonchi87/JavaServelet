package DrivingTest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	 int score=0;
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> Ques1 = (List<Question>) getServletContext().getAttribute("Ques"); 
		int index;
		String[] TrackAns= (String[]) request.getSession().getAttribute("TrackAns");	
		int[]corAnswer = (int[]) request.getSession().getAttribute("corAnswer");	
		 
		index= (Integer)getServletContext().getAttribute("index");
		
		 // System.out.println( "Inddex from url "+Integer.parseInt(request.getParameter("z")));

		
		
		int correctAn;
		 String[] languages = request.getParameterValues("q");
		 for(int i=0;i<languages.length;i++) {
			 
			   if(languages[i]!=""){
				    correctAn=Ques1.get(index).getCorrectAnswer();
				   System.out.println(Integer.parseInt(languages[i]));
				   
					   if(Integer.parseInt(languages[i])!=correctAn) {
						   TrackAns[index]=languages[i]+"  Incorrect ";
						   corAnswer[index]=correctAn;
						   System.out.println( TrackAns[index]);
					   }
					   
					   else {		   
						   score++;
						   TrackAns[index]=""+correctAn;
						   corAnswer[index]=correctAn;
					     }
					   
			   }
		        }
		 
		 
		    index++;
		
		 
		
		 System.out.println("Index" +index);
		 if(index==Ques1.size()) {
			 getServletContext().setAttribute("Ques1",Ques1 );
			 getServletContext().setAttribute("score",score );
			 getServletContext().setAttribute("TrackAns",TrackAns );
			 getServletContext().setAttribute("corAnswer",corAnswer ); 
			 request.getSession().setAttribute("score", score); 
			 request.getRequestDispatcher("ResultDrTest.jsp").forward(request, response);
			 

			return; 
		 }
		 

		 
		 
		 
		 Question Q1=Ques1.get(index);
		 
		 // it's not required
		 getServletContext().setAttribute("Q", Q1);
		 getServletContext().setAttribute("corAnswer",corAnswer );
		 
		 getServletContext().setAttribute("index",index);
		 getServletContext().setAttribute("TrackAns",TrackAns ); 
		 request.getSession().setAttribute("score", score);
		 request.getRequestDispatcher("viewQuestion.jsp").forward(request, response);
		 	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
