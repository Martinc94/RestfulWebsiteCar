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

@Path("/search")
public class SearchCar {
private int id;
private String make;
private String model;
private String reg;
private String colour;
private String price;
private String description;

//pass parameters from Web page with name"make"
@GET
@Produces(MediaType.TEXT_HTML)
public String getCarByModel(@QueryParam("make") String SearchName){
	String Smake = SearchName;  
	Header h=new Header();
	ResultSet rs;
	String Result="";
	
	Result = h.SearchHeader();
	
	Result+="<table align=\"center\" border=\"1\">";
	Result+=" <tr><th>Make</th><th>Model</th><th>Registration</th><th>Colour</th><th>Price</th><th>Description</th></tr>";
		
		
	//search method for car name
	//return list of cars 
	DBconnector dbc = new DBconnector();
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = dbc.getConn();
		Statement stmt = conn.createStatement();
		
		String qry = "select * from car where make like '%"+Smake+"%'";
		//String qry = "select * from car";
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
				 
				 Car c = new Car(id, make, model, reg, colour, price, description);
				 Result+=c.toTable();
			}//end while
		}//end if
		else{
			Result="<p>No Matching Car Found</p>";
		}
	} catch (SQLException e) {
		System.out.println("Error Connection to Database" );
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		System.out.println("JDBC Error");
		
	}	

	Result+="</table>";

	
	return Result;	
	
}//end getCarByModel


}//End SearchCar