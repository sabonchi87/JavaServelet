package ADDMVC;

import java.util.Date;

public class GuestBookEntry {
	
static int count=0;
int id;
String name;
String Message;
Date date;

public GuestBookEntry(String name, String message) {

	this.id=count++;
	this.name = name;
	this.Message = message;
	this.date=new Date();
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public static int getCount() {
	return count;
}

public static void setCount(int count) {
	GuestBookEntry.count = count;
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

public String getMessage() {
	return Message;
}

public void setMessage(String message) {
	Message = message;
}







}
