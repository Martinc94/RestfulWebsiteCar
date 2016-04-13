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
import javax.ws.rs.core.MediaType;

@Path("/search/")
public class SearchCar {
	
private String make;
private String model;
private String reg;
private String colour;
private String price;
private String description;
	
@GET
@Produces(MediaType.TEXT_HTML)
public String getCarName(){
	String str;
	
	str=make+" "+model;
	
	return str;	
}//end getCarName

//pass parameters from Web page with name

/*@GET@Path("{SearchName}")
@Produces(MediaType.TEXT_HTML)

public String getCarName(@PathParam("SearchName") String SearchName){
	String str;
	
	//search method for car name
	//return list of cars 
	
	str=SearchName;
	
	return str;	
	
}//end getCarName*/

@GET@Path("{SearchName}")
@Produces(MediaType.TEXT_HTML)

public String getCarName(@PathParam("SearchName") String SearchName){
	String Smake=SearchName;
	ResultSet rs;
	String Result="";
	
	//search method for car name
	//return list of cars 
	//Driver d = new Driver();
	
	/*try {
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
	Result="<h1>"+make+"</h1>"+"<h1>"+model+"</h1>";*/
	
	Car c = new Car();
	
	Result = c.ToHtml(SearchName);
	
	
	
	
	
	
	return Result;	
	
}//end getCarName


}
