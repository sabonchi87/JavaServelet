package Poll;

public class Poll {
	
int id;
String name;
String choice1;
String choice2;
String choice3;

int Tchoice1=0;
int Tchoice2=0;
int Tchoice3=0;

public Poll(int id, String name, String choice1, String choice2, String choice3) {
	super();
	this.id = id;
	this.name = name;
	this.choice1 = choice1;
	this.choice2 = choice2;
	this.choice3 = choice3;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getChoice1() {
	return choice1;
}



public void setChoice1(String choice1) {
	this.choice1 = choice1;
}



public String getChoice2() {
	return choice2;
}



public void setChoice2(String choice2) {
	this.choice2 = choice2;
}



public String getChoice3() {
	return choice3;
}



public void setChoice3(String choice3) {
	this.choice3 = choice3;
}



public int getTchoice1() {
	return Tchoice1;
}



public void setTchoice1(int tchoice1) {
	Tchoice1 = tchoice1;
}



public int getTchoice2() {
	return Tchoice2;
}



public void setTchoice2(int tchoice2) {
	Tchoice2 = tchoice2;
}



public int getTchoice3() {
	return Tchoice3;
}



public void setTchoice3(int tchoice3) {
	Tchoice3 = tchoice3;
}












	

}
