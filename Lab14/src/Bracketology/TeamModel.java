package Bracketology;

public class TeamModel {
	
public  String team1;
public  String  team2;

int id;
static int count =1;

public TeamModel(String team1, String team2) {
	super();
	this.team1 = team1;
	this.team2 = team2;
	this.id=count++;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTeam1() {
	return team1;
}
public void setTeam1(String team1) {
	this.team1 = team1;
}
public String getTeam2() {
	return team2;
}
public void setTeam2(String team2) {
	this.team2 = team2;
}







}
