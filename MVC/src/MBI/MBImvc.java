package MBI;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MBImvc
 */
@WebServlet("/MBImvc")
public class MBImvc extends HttpServlet {
	static String status;
	private static final long serialVersionUID = 1L;
       
   
    public MBImvc() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public double BodymassCalculator(double weight,double height) {
   	 final double KILOGRAMS_PER_POUND = 0.4536; // Constant
   	 
   	  double METERS_PER_fett = 0.3048; // Constant
   	 
   	  double weightInKilograms = weight * KILOGRAMS_PER_POUND;
   	 
   	 
   	  double heightInMeters = height * METERS_PER_fett;
   	  
   	  double bmi = (weightInKilograms /(heightInMeters * heightInMeters));
   	
   	 System.out.println("weightInKilograms"+weightInKilograms);
   	 System.out.println("METERS_PER_fett"+METERS_PER_fett);
   	  
		return bmi;
      
      
   }
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/MBIView.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String H=request.getParameter("H_f");
		 String H_Inch=request.getParameter("H_in");
		 String W=request.getParameter("w");
		
		  double Height_feet=Double.parseDouble(H);
		  double H_Ich=Double.parseDouble(H_Inch);
		  double Weight=Double.parseDouble(W);
		  //prin
		  
		  System.out.println("Height_feet"+Height_feet);
		  System.out.println("H_Ich" +H_Ich);
		  System.out.println("Weight"+Weight);
		  
		  
		  //convert to Inches
		  Height_feet+=(H_Ich/12);
		  double BMI =BodymassCalculator(Weight,Height_feet);
		  BMI=Math.round(BMI * 10) / 10.0;
		  System.out.println("BMI"+BMI);
		  if (BMI < 18.5)
			  status= "Underweight";
		   else if (BMI >=18.5 && BMI  < 25.0)
			   status= "Normal";
			else if (BMI <= 30 && BMI>=25 )
				  status="Overweight";
				  
			  else if (BMI <= 30 )
				  status="Obese";
		  
		  request.setAttribute( "BMI", BMI );
		  request.setAttribute( "status", status );
		  
		  request.getRequestDispatcher( "/WEB-INF/MBIResult.jsp" ) .forward( request, response );
		
		  
		
		
	}

}
