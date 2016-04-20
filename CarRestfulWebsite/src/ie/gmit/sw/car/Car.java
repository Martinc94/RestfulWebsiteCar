package ie.gmit.sw.car;

public class Car {
	private int id;
	private String reg;
	private String make;
	private String model;
	private String colour;
	private String price;
	private String description;
	
	public Car() {
		//Default Constructor for new Car		
	}
	
	public Car(String make, String model,String reg, String colour, String price, String description) {
		//for new car 0 gets assigned a new id in database
		////Constructor for new car
		this.id = 0;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.price = price;
		this.description = description;
		
	}
	
	public Car(int id, String make, String model,String reg, String colour, String price, String description) {
		//Constructor for Existing Car
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

	public String getReg() {
		return reg;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColour() {
		return colour;
	}

	public String getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
	
	public String toTable() {
		return "<tr><td>"+make+" "+"</td> <td>"+model+"</td> <td>"+reg+"</td> <td>"+colour+"</td> <td>"+price+"</td> <td>"+description+"</td></tr>";
	}

	public String carJsonInfo(){
		String info;	
		info="\"Make:\"\""+make+"\",\"Model:\"\""+model+"\",\"Reg:\"\""+reg+"\",\"Colour:\"\""+colour+"\",\"Price\"\""+price+"\",\"Description\"\""+description;
		return info;	
	}
	
}//end Car

