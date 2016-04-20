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

@Path("/searchbymodel")
public class SearchCarByModel {
private int id;
private String make;
private String model;
private String reg;
private String colour;
private String price;
private String description;

/**
 * Searches for cars that match or partially match searched Model
 */
//pass parameters from Web page with name"Model" and return results page
@GET
@Produces(MediaType.TEXT_HTML)
public String getCarByModel(@QueryParam("model") String SearchName){
	String SModel = SearchName;  
	Html h=new Html();
	ResultSet rs;
	String Result="";
	
	Result = h.SearchHeader()+h.Style();
	Result+=h.getTable();
	Result+=h.getTableHeader();
			
	//search method for car model
	DBconnector dbc = new DBconnector();
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = dbc.getConn();
		Statement stmt = conn.createStatement();
		//Selects cars from the database where their model matches or partially matches the search model
		String qry = "select * from car where model like '%"+SModel+"%'";
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
	//returns page to web browser 
	return Result;	
	
}//end getCarByModel


}//End SearchCarByModel