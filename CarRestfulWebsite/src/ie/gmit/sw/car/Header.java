package ie.gmit.sw.car;

public class Header {
	String Searchtitle="<h1 align=\"center\">Search Page</h1>";
	String ListTitle="<h1 align=\"center\">List Of All Cars</h1>";
	String links="<li><a href=\"/CarRestfulWebsite/Home.html\">Home Page</a></li> <li><a href=\"/CarRestfulWebsite/Search.html\">Search Page</a></li><li><a href=\"/CarRestfulWebsite/rest/listAll\">List All Page</a></li>";
	

	public String SearchHeader(){
		String header="";
		
		header=Searchtitle+links;
		
		return header;
	}
	
	public String ListAllHeader(){
		String header="";
		
		header=ListTitle+links;
		
		return header;
	}
}
