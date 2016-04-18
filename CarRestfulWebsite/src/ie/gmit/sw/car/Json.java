package ie.gmit.sw.car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import db.DBconnector;

@Path("/json/")
public class Json {
private int id;
private String make;
private String model;
private String reg;
private String colour;
private String price;
private String description;


@GET
@Produces(MediaType.TEXT_HTML)
public String GetJson(@QueryParam("reg") String SearchName) {
	String Json="";
	String Sreg = SearchName;  
	Html h=new Html();
	ResultSet rs;
	String Result="";
	
	Result = h.Style();	
		
	//search method for car name
	//return list of cars 
	DBconnector dbc = new DBconnector();
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = dbc.getConn();
		Statement stmt = conn.createStatement();
		
		String qry = "select * from car where reg = '"+Sreg+"'";
		rs = stmt.executeQuery(qry);
		//if car found
		if(rs.first()){
			//points to first car
			rs.beforeFirst();
			while (rs.next()) {
				 id = rs.getInt("id");
				 make = rs.getString("make");
				 model = rs.getString("model");
				 reg = rs.getString("reg");
				 colour = rs.getString("colour");
				 price = rs.getString("price");
				 description = rs.getString("description");
				//create new car from Database
				 
				 Json="{\"make\":\""+make+"\",\"model\":\""+model+"\",\"reg\":\""+reg+"\",\"colour\":\""+colour+"\",\"price\":\""+price+"\",\"description\":\""+description+"\"}";
			}//end while
		}//end if
		else{
			Json="<p>No Matching Car Found</p>";
		}
	} catch (SQLException e) {
		System.out.println("Error Connection to Database" );
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		System.out.println("JDBC Error");
		
	}	

	
	
	return Json;
}




}
