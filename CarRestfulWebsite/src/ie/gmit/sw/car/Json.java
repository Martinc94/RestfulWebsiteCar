package ie.gmit.sw.car;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/json")
public class Json {
/*private int id;
private String make;
private String model;
private String reg;
private String colour;
private String price;
private String description;*/


@GET
@Produces(MediaType.APPLICATION_JSON)
public String GetJson() {
	String Json="";
	
	return Json;
}

}
