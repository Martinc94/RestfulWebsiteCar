package db;
import java.sql.*;

public class DBconnector {
	String user="Martin";
	String password="Martin";
	
	/**
	 * Returns a connection to the database
	 */
	
	//returns a connection to the database
	public Connection getConn() throws SQLException{
		Connection conn;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://CarDatabase.cloudapp.net:3306/cardb",user,password);
		} catch (Exception e) {
			System.out.println("Error connecting to Azure.");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/cardb","root","");
		}
		return conn;		
	}//end getConn

}//end DBconnector
