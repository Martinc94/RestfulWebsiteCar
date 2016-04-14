package ie.gmit.sw.car;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Car {
	private int id;
	private String reg;
	private String make;
	private String model;
	private String colour;
	private String price;
	private String description;
	private File picture;
	
	public Car() {
		//Default Constructor for new Car
		
		
	}
	
	public Car(int id, String make, String model,String reg, String colour, String price, String description,File picture) {
		//Constructor for Existing Car
		this.id = id;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		this.picture = picture;
		
	}
	
	public Car(String make, String model,String reg, String colour, String price, String description,File picture) {
		//Constructor for new Car
		//for new car 0 gets assigned a new id in database
		this.id = 0;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		this.picture = picture;
		
	}
	
	public Car(String make, String model,String reg, String colour, String price, String description) {
		//for new car 0 gets assigned a new id in database
		////Constructor for new car for no picture
		this.id = 0;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		
	}
	
	public Car(int id, String make, String model,String reg, String colour, String price, String description) {
		//Constructor for Existing Car no pic
		this.id = id;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "<p>"+make+" "+" "+model+" "+reg+" "+colour+" "+price+" "+description+"</p>";
	}
	
	
	public String toTable() {
		return "<tr><td>"+make+" "+"</td> <td>"+model+"</td> <td>"+reg+"</td> <td>"+colour+"</td> <td>"+price+"</td> <td>"+description+"</td></tr>";
	}
	
	
	
	public String ToHtml(String SearchName){
		String Smake=SearchName;
		ResultSet rs;
		String Result="";
	
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cardb","root","");
			Statement stmt = conn.createStatement();
			
			String qry = "select * from car where make like '%"+Smake+"%'";

			rs = stmt.executeQuery(qry);
			
			//conn.close();
			if (rs.next()) {
			 make = rs.getString("make");
			 model = rs.getString("model");
			 reg = rs.getString("reg");
			 colour = rs.getString("colour");
			 price = rs.getString("price");
			 description = rs.getString("description");
			}
		} catch (SQLException e) {
			System.out.println("Error Connection to Database" );
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(make+model+reg);
		Result="<h1>"+make+"</h1>"+"<h1>"+model+"</h1>";
		
		
		return Result;

}
	
	
}

