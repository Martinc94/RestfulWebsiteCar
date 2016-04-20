package ie.gmit.sw.car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import db.DBconnector;

@Path("/listAll")
public class AllCars {
	private int id;
	private String make;
	private String model;
	private String reg;
	private String colour;
	private String price;
	private String description;
	
	/**
	 * Returns all cars in a HTML Table
	 */
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getAllCars(){
		Html h=new Html();
		ResultSet rs;
		String Result="";
		//initialise HTML
		Result = h.ListAllHeader()+h.Style();
		Result+=h.getTable();
		Result+=h.getTableHeader();		
			
		//search method for all cars
		//return list of cars 
		DBconnector dbc = new DBconnector();
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = dbc.getConn();
			Statement stmt = conn.createStatement();
			//selects all cars in the database
			String qry = "select * from car";
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
					 //Add to table
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
		
	}//end getAllCars

}//end AllCars
