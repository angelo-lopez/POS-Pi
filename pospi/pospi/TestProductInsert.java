package pospi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestProductInsert {
	//Insert product information with a value for the barcode.
	private static boolean isProductWithBarcodeInserted(){
		Connection dbConnection = null;
		Statement insertProduct = null;
		PreparedStatement insertStock = null;
		ResultSet rs = null;//For holding auto-generated keys.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int productPK;
		try{
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/test_pos_pi", 
					"root", "raspberry");			
			//Indicate manual transaction.
			dbConnection.setAutoCommit(false);			
			//Start transaction.
			insertProduct = dbConnection.createStatement();
			insertProduct.executeUpdate("INSERT INTO products (barcode, uom_id, description, price, vat_code) VALUES ('27607381', "
			+ "'6', 'Whole Fresh Milk 6 pints', 1.30, 'v0')", Statement.RETURN_GENERATED_KEYS);
			
			rs = insertProduct.getGeneratedKeys();//Retrieve the auto-number primary key.
			if(rs.next()){
			productPK = rs.getInt(1);
			insertStock = dbConnection.prepareStatement("INSERT INTO product_inventory (product_id,  inventory_date, " + 
														"quantity_in_stock, reorder_level) VALUES (?, ?, ?, ?)");
			insertStock.setInt(1, productPK);
			insertStock.setString(2, dateFormat.format(new Date()));
			insertStock.setDouble(3, 50);
			insertStock.setInt(4, 10);
			insertStock.executeUpdate();
			//Commit transaction.
			dbConnection.commit();
			}
			else{//Error in generating primary key, throw exception to rollback changes.
				throw new SQLException();
			}
			return true;
		}//end try.
		catch(SQLException se){
			try {
				dbConnection.rollback();//Rollback changes if transaction fails.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			se.printStackTrace();
			return false;
		}
		catch(Exception e){
			try {
				dbConnection.rollback();//Rollback changes if transaction fails.
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}//end catch.
		finally{
			//Do some clean-up.
			dbConnection = null;
			insertProduct = null;
			insertStock = null;
		}//end finally.
	}//end insertProduct().

	public static void main(String[] args) {
		System.out.println("New product information will be inserted into tables: products and product_inventory.");
		if(isProductWithBarcodeInserted()){
			System.out.println("Product was successfully inserted!!!");
		}
		else{
			System.out.println("Product insertion failed!!!");
		}//end if
	}//end main

}//end class
