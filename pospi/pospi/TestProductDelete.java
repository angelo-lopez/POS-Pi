package pospi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestProductDelete {
	
	private static boolean isProductDeleted(){
		Connection dbConnection = null;
		Statement deleteStatement = null;
		try{						
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/test_pos_pi", 
					"root", "raspberry");
			//Indicate manual transaction.
			dbConnection.setAutoCommit(false);
			deleteStatement = dbConnection.createStatement();			
			deleteStatement.execute("DELETE FROM product_inventory WHERE product_id = 2");
			deleteStatement.execute("DELETE FROM products WHERE product_id = 2");
			//commit changes.
			dbConnection.commit();
			return true;
		}//end try.
		catch(SQLException se){
			try {
				dbConnection.rollback();//Rollback changes if transaction fails.
			} catch (SQLException e) {
				e.printStackTrace();
			}
			se.printStackTrace();
			return false;
		}//end catch.
		catch(Exception e){
			try {
				dbConnection.rollback();//Rollback changes if transaction fails.
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}//end catch.
		finally{
			//Do some clean-up.
			dbConnection = null;
			deleteStatement = null;
		}//end finally.
	}//end isProductDeleted()

	public static void main(String[] args) {
		System.out.println("Existing product information will be deleted from tables: products and product_inventory.");
		if(isProductDeleted()){
			System.out.println("Product was successfully deleted!!!");
		}
		else{
			System.out.println("Product deletion failed!!!");
		}//end if
	}//end main().

}//end class.
