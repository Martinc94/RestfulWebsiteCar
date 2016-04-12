package ie.gmit.sw.car;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/search/")
public class SearchCar {
	
private String name="Toyota";
private String model=" Corolla";
	
@GET
@Produces(MediaType.TEXT_HTML)
public String getCarName(){
	String str;
	
	str=name+" "+model;
	
	return str;	
}//end getCarName

//pass parameters from Web page with name

@GET@Path("{SearchName}")
@Produces(MediaType.TEXT_HTML)

public String getCarName(@PathParam("SearchName") String SearchName){
	String str;
	
	//search method for car name
	//return list of cars 
	
	str=SearchName;
	
	return str;	
	
}//end getCarName


}
