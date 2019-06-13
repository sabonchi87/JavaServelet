package Exap;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		//read image from disk
		// write image to the response beacuse image is a binary file we can use inputstream
		//FileInputStream is meant for reading streams of raw bytes such as image data
		
		FileInputStream in = new FileInputStream ("/Users/hasanainalsabonchi/Desktop/ABET.png");
		// it read 2 k byts each time into buffer array
		byte [] buffer= new byte[2048];
		int byteRead;
		OutputStream  out=response.getOutputStream();
		
		//Reads up to b.length bytes of data from this input stream into an array of bytes.
		while((byteRead=in.read(buffer))>0){
			
			// write img to response
			out.write(buffer,0,byteRead);
			
			in.close();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
