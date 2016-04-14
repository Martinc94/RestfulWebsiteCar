package ie.gmit.sw.car;

public class Header {
	String Searchtitle="<h1 align=\"center\">Search Page</h1>";
	String links="<li><a href=\"/CarRestfulWebsite/Home.html\">Home Page</a></li> <li><a href=\"/CarRestfulWebsite/Search.html\">Search Page</a></li>";
	

	public String SearchHeader(){
		String header="";
		
		header=Searchtitle+links;
		
		return header;
	}
}
