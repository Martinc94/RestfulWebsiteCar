package ie.gmit.sw.car;
/**
 *Class that returns html 
 */
public class Html {
	String Searchtitle="<h1 align=\"center\">Search Page</h1>";
	String ListTitle="<h1 align=\"center\">List Of All Cars</h1>";
	String links="<li><a href=\"/CarRestfulWebsite/Home.html\">Home Page</a></li> <li><a href=\"/CarRestfulWebsite/Search.html\">Search Page</a></li><li><a href=\"/CarRestfulWebsite/rest/listAll\">List All Page</a></li><li><a href=\"/CarRestfulWebsite/SearchJson.html\">Json Search Page</a></li>";
	String style="<style>body {background-color:lightgrey;}h1{color:blue;}p{color:green;}</style>";
	String Table="<table align=\"center\" border=\"1\">";
	String TableHeader="<tr><th>Make</th><th>Model</th><th>Registration</th><th>Colour</th><th>Price</th><th>Description</th></tr>";

	public String getTable() {
		return Table;
	}

	public String getTableHeader() {
		return TableHeader;
	}

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
	
	public String Style(){
		return style;
	}
}
