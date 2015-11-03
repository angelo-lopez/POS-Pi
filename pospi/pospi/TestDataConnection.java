package pospi;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDataConnection {
	
	private static boolean isConnectionValid(){
		try{
			//Register JDBC driver (done once for the entire application).
			Class.forName("com.mysql.odbc.Driver");
			//Test connection to database
			@SuppressWarnings("unused")
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test_pos_pi", 
					"root", "raspberry");
			
			return true;
		}//end try
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}//end catch
	}//isConnectionValid

	public static void main(String[] args) {
		if(isConnectionValid()){
			System.out.println("Database registration and connection successful!!!");
		}
		else{
			System.out.println("Database registration and connection unsuccessful!!!");
		}
	}//end main

}//end class
