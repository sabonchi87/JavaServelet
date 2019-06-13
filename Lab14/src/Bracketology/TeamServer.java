package Bracketology;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TeamServer")
public class TeamServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	

	public void init(ServletConfig config) throws ServletException {
		  super.init( config );
		
		  // A List that holds  a Teams (Matchs) 
		 ArrayList <TeamModel> Team = new  ArrayList <TeamModel>();

	        try
	        {
	            // read file
	            Scanner in;
	            in = new Scanner( new File(getServletContext().getRealPath( "/WEB-INF/teams.txt" ) ) );
	            //Returns true if there is another line in the input of this scanner.
	            while( in.hasNextLine() )
	            {
	               
	            String Team1=in.nextLine();
	            System.out.println(Team1);
	            String Team2=in.nextLine();
	            System.out.println(Team2);
	            	
	            Team.add(new TeamModel (Team1,Team2) );
	            }
	            in.close();
	        }
	        catch( FileNotFoundException e )
	        {
	            throw new ServletException( e );
	        }

	        
	        for (int i=0;i<Team.size();i+=2) {
	        	
	        	//System.out.println(Team.get(i).team1 +" "+Team.get(i).team2);
	        }
	        
	        
	        // save it in the Application scope
	        getServletContext().setAttribute( "Team", Team );		
		
	}

	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     // ArrayList <TeamModel>  Team=(ArrayList <TeamModel>)getServletContext().getAttribute("Team");
		
		         ArrayList <TeamModel> newTeam = new  ArrayList <TeamModel>();
		         
		        //key is the name and the value is the team name
		         Map <String,String[]> map =request.getParameterMap() ;
		         
		         // print map
		         //map.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));
		
		      // convert the keySet() into string array
				    String[] keys = map.keySet().toArray(new String[map.size()]);
		            
		         
		         for (int i=0;i<keys.length;i+=2) {
		        	 
			        	 if(keys.length==1) {
					    		//Returns the value to which the specified key is mapped, 
					    		//or null if this map contains no mapping for the key.
						    	System.out.println(map.get(keys[i])[0]);
						    	
						    	String winer=map.get(keys[i])[0];
						    	
						    	request.getSession().setAttribute("x",winer);
						    	request.getRequestDispatcher( "/WEB-INF/FinalRound.jsp").forward( request, response );
						    	return ;   	
					    	}
		        	 
		        	 
			        	System.out.println(map.get(keys[i])[0]);
			        	
			        	//  i want to poll out 2  teams  as an object for the next round
			        	
			        							  //p.get(keys[i])[0],p.get(keys[i+1])[0])
			        	newTeam.add(new TeamModel(map.get(keys[i])[0],map.get(keys[i+1])[0]));
		        	
		               }
		         
		            getServletContext().setAttribute( "newTeam", newTeam );	
		         
		         request.getRequestDispatcher("/WEB-INF/SecondRound.jsp").forward(request, response);
		
	}

}
