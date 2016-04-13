package ie.gmit.sw.car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import db.DBconnector;

@Path("/search")
public class SearchCar {
	
private String make;
private String model;
private String reg;
private String colour;
private String price;
private String description;
	
/*@GET
@Produces(MediaType.TEXT_HTML)
public String getCarName(){
	String str;
	
	str=make+" + "+model;
	
	return str;	
}//end getCarName*/


/*
@GET@Path("{SearchName}")
@Produces(MediaType.TEXT_HTML)

public String getCarName(@PathParam("SearchName") String SearchName){
	 String Smake = new String(SearchName);
	 System.out.println("search "+SearchName);
     
    Smake=Smake.substring(2,Smake.length()-1);
    System.out.println(Smake);
	ResultSet rs;
	String Result="";
	
	//search method for car name
	//return list of cars 
	//Driver d = new Driver();
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cardb","root","");
		Statement stmt = conn.createStatement();
		
		String qry = "select * from car where make like '%"+Smake+"%'";

		rs = stmt.executeQuery(qry);
		
		conn.close();
		
		 make = rs.getString("make");
		 model = rs.getString("model");
		 reg = rs.getString("reg");
		 colour = rs.getString("colour");
		 price = rs.getString("price");
		 description = rs.getString("description");
	} catch (SQLException e) {
		System.out.println("Error Connection to Database" );
		e.printStackTrace();
	}
	
	System.out.println(make+model+reg);
	Result="<h1>"+make+"</h1>"+"<h1>"+model+"</h1>";
	
	Car c = new Car();
	
	Result = c.ToHtml(Smake);
	
	
	
	
	
	
	return Result;	
	
}//end getCarName*/


//pass parameters from Web page with name"make"
@GET
@Produces(MediaType.TEXT_HTML)
public String getCarName2(@QueryParam("make") String SearchName){
	String Smake = SearchName;  
	ResultSet rs;
	String Result="";
	
	//search method for car name
	//return list of cars 
	DBconnector dbc = new DBconnector();
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = dbc.getConn();
		Statement stmt = conn.createStatement();
		
		String qry = "select * from car where make like '%"+Smake+"%'";

		rs = stmt.executeQuery(qry);
		
		//add to car object array create html page from array
		if (rs.next()) {
		 make = rs.getString("make");
		 model = rs.getString("model");
		 reg = rs.getString("reg");
		 colour = rs.getString("colour");
		 price = rs.getString("price");
		 description = rs.getString("description");
		 conn.close();
		}
	} catch (SQLException e) {
		System.out.println("Error Connection to Database" );
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		System.out.println("JDBC Error");
		
	}
	
	Result="<h1>"+make+"</h1>"+"<h1>"+model+"</h1>";
	
	return Result;	
	
}//end getCarName

}
