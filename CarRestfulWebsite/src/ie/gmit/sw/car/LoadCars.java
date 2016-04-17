package ie.gmit.sw.car;



import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/xml")
public class LoadCars extends Application {

	
	
	
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public TestCar getCarInXML()  {

		TestCar car = new TestCar("toyota", "corolla", "12g123", "red", "4000", "desc of car ");
		

		return car;

	}
	
	
	//get by param
	/*@GET
	@Path("/{pin}")
	@Produces(MediaType.APPLICATION_XML)
	public TestCar getCustomerInXML(@PathParam("pin") int pin) {

		TestCar car = new TestCar("", "", "", "", "", "");
		car.setName("mkyong");
		car.setPin(pin);

		return car;

	}*/
	
}
