package Lab18;

import java.util.Date;

public class Users {
	
	int id;
	String name;
	Date date;
	int rating;
	
	
	
	public Users(int id, String name,Date date,int rating) {
		super();
		this.id = id;
		this.name = name;
		this.date=date;
		this.rating=rating;
		
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
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	


	
	

}
