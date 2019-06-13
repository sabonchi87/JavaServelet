package Surveys;

import java.util.ArrayList;
import java.util.List;

public class QuestionsModel {
	

int size=0;
String description;

public List<String> choices;

public QuestionsModel(String description,List<String> choices) {
	
	this.description=description;
	// not new ArrayList
	this.choices= choices;
		
}

public QuestionsModel(String description) {
	
	this.description=description;
	this.choices= choices;
		
}



public List<String> getChoices() {
	return choices;
}

public void setChoices(List<String> choices) {
	this.choices = choices;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


	



}
