package Faculty;

import java.util.ArrayList;
import java.util.List;

public class Department {	
	
	public String name;
	public  List<Faculty> faculty;
	public int size;
	
		 
	public int getSize() {
		return this.faculty.size();
	}

	public void setSize(int size) {
		this.size = size;
	}
	
public Department(String name, List<Faculty> faculty) {
		super();
		this.name = name;
		this.faculty = faculty;
	}
 
 public Department(String name) {
		super();
		this.name = name;
		this.faculty = new ArrayList<Faculty>();
	}


public String getName() {
	
	return name;
}


public void setName(String name) {
	this.name = name;
}


public List<Faculty> getFaculty() {
	return faculty;
}


public void setFaculty(List<Faculty> faculty) {
	this.faculty = faculty;
}


}
