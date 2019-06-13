package DrivingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static int i=0;
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		List <Question> Ques= new ArrayList <Question>();
		
  
		 String  description, answerA, answerB, answerC;
	    int correctAnswer;
	    	
   
		try {
			File file = new File(getServletContext().getRealPath(("/WEB-INF/DrivingTest.txt")));
			 Scanner in = new Scanner(file);
			
			 //This method simply returns true if there is another line on the scanner input, otherwise this method returns false
			while(in.hasNextLine()) {
				
			        description=in.nextLine();
                	answerA=in.nextLine();
                	answerB=in.nextLine();
                	answerC=in.nextLine();
                	String num=in.nextLine();
                	correctAnswer=Integer.parseInt(num);
                	//in.nextLine();  
                	   
                	//System.out.println(description);
			    	//System.out.println(answerA);
			    	//System.out.println(answerB);       
			    	//System.out.println(answerC);
                	Ques.add(new Question (description,answerA,answerB,answerC, correctAnswer));
			    	//System.out.println(correctAnswer);
			    	
			    	//NoSuchElementException - if no line was found
		    	if (in.hasNextLine()) {
			    		in.nextLine();              		
                	}	    				    	
			    	
			    	
	    	} 
			in.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
     getServletContext().setAttribute( "Ques", Ques );
     getServletContext().setAttribute("index", 0);
		
		
	}

	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Question> Ques = (List<Question>) getServletContext().getAttribute("Ques");
		 int index=0;
       
		String[] TrackAns=new String[10];
		 
		int[] corAnswer=new int[10];
		
		 
		 Question Q=Ques.get(index);
		  
		 //index++;
		 // it's not required
		 getServletContext().setAttribute("Q", Q);
		 
		 getServletContext().setAttribute("index",index);
		 request.getSession().setAttribute("TrackAns",TrackAns );
		 request.getSession().setAttribute("corAnswer",corAnswer ); 
		 
		
		 
		 
		 request.getRequestDispatcher("viewQuestion.jsp").forward(request, response);
		
		
		 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
