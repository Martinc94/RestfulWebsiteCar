package ie.gmit.sw.car;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestCar {
	
	private int id;
	private String reg;
	private String make;
	private String model;
	private String colour;
	private String price;
	private String description;
	
	
	public TestCar( String reg, String make, String model, String colour, String price, String description) {
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
	@XmlElement
	public String getReg() {
		return reg;
	}
	@XmlElement
	public String getMake() {
		return make;
	}	
	@XmlElement
	public String getModel() {
		return model;
	}
	@XmlElement
	public String getColour() {
		return colour;
	}
	@XmlElement
	public String getPrice() {
		return price;
	}	
	@XmlElement
	public String getDescription() {
		return description;
	}

	public void GetInfo(){
		
	}
	
	
	

}
