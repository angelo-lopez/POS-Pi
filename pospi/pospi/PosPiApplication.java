package pospi;
import javax.swing.*;

import java.sql.*;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: This class has the static main method which is the main entry point for the POS-Pi application. 
 * <br>It's main task is to register the MySQL database driver and test for connection to the database.
 * <br>MySQL Connector/J is the official JDBC driver for MySQL. You can download it from this site:
 * <br>http://dev.mysql.com/downloads/connector/j/
 **/
public class PosPiApplication {
    //MySQL driver
	private static final String DATA_DRIVER = "com.mysql.jdbc.Driver";
	//Database URL
	private static final String DATA_CONNECTION = "jdbc:mysql://localhost/pos_pi";
	//User credentials for MySQL, user name and password
	private static final String DATA_USER = "root";
	private static final String DATA_PASSWORD = "raspberry";
	
	/**
	 * Main entry point of the application.
	 * <br>[1] Registers the MySQL database connection driver
	 * <br>[2] Test connection to MySQL database
	 * <br>[3] Clean-up (closes) connection object
	 * @param args[] String
	 **/
	@SuppressWarnings("unused")
	public static void main(String[] args) {		
		Connection conn = null;
		try{
			//Register JDBC driver (done once for the entire application).
			Class.forName(DATA_DRIVER);
			//Test connection to database
			conn = DriverManager.getConnection(DATA_CONNECTION, DATA_USER, DATA_PASSWORD);
			
			JOptionPane.showMessageDialog(null, "Database driver regristration and database\nconnection successful.\n" + 
					"Welcome to the POS-Pi Application!", 
					"***POS-Pi***", JOptionPane.INFORMATION_MESSAGE);
			UserLoginController loginController = new UserLoginController(new UserLoginView(), getDataConnection(),
																			getDataUser(), getDataPassword());
		}//end try
		/*Catch errors if MySQL database driver registration is unsuccessful, or database connection
		 * cannot be established.
		 * */
		catch(ClassNotFoundException cnfEx){
			JOptionPane.showMessageDialog(null, cnfEx.toString(), 
					"Error in connecting to database.",
					JOptionPane.WARNING_MESSAGE);
		}//end catch		
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null, sqlEx.toString(), 
					"Error in connecting to database.",
					JOptionPane.WARNING_MESSAGE);
		}//end catch
		catch(Exception eEx){
			JOptionPane.showMessageDialog(null, eEx.toString(),
					"Error in connecting to database",
					JOptionPane.WARNING_MESSAGE);
		}//end catch	
		//perform clean-up. Close database connection
		finally{
			if(conn != null){
			    //Close database object.
				try{
				conn.close();	
				}//end try
				catch(SQLException sqlEx){
					JOptionPane.showMessageDialog(null, sqlEx.toString(), 
							"Error in closing the database.",
							JOptionPane.WARNING_MESSAGE);
				}//end catch
			}//end if
		}//end finally
		
	}//end main

	/*
	 * Getters.
	 * */
	public static String getDataDriver() {
		return DATA_DRIVER;
	}

	public static String getDataConnection() {
		return DATA_CONNECTION;
	}

	public static String getDataUser() {
		return DATA_USER;
	}

	public static String getDataPassword() {
		return DATA_PASSWORD;
	}

}//end class
