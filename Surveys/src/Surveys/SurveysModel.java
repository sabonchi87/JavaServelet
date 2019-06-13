package Surveys;

import java.util.ArrayList;
import java.util.List;

public class SurveysModel {
	
static int count =1;
int id;

String name;

public List<QuestionsModel> Questions;


public SurveysModel( String name) {
	
	this.name=name;
	this.Questions= new ArrayList<QuestionsModel> ();
	id=count++;
}


public SurveysModel( String name, List<QuestionsModel> Questions) {
	
	this.name=name;
	this.Questions= Questions;
	id=count++;
}



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<QuestionsModel> getQuestions() {
	return Questions;
}

public void setQuestions(List<QuestionsModel> questions) {
	Questions = questions;
}




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}







	
	

}
