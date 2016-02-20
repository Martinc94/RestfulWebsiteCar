package ie.gmit.sw.car;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import javax.ws.rs.Consumes;
//import javax.ws.rs.Produces;

@Path("/search")
public class SearchCar {
	
private String carName="test";
	
	
@GET
@Produces(MediaType.TEXT_HTML)
public String getCarName(){
	
	return carName;	
}
}
