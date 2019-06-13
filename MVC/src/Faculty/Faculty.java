package Faculty;

public class Faculty {
	
public String name;
public String department;
public boolean ischair;

static int size=0;




public Faculty(String name, String department, boolean chair) {
	super();
	this.name = name;
	this.department = department;
	this.ischair = chair;
	size++;
}


public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public boolean isIschair() {
	return ischair;
}

public void setIschair(boolean ischair) {
	this.ischair = ischair;
}







}
