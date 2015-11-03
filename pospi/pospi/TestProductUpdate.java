package pospi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestProductUpdate {
	
	private static boolean isProductUpdated(){
		Connection dbConnection;
		PreparedStatement updateProduct = null, 
						  updateStock = null;
		try{
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/test_pos_pi", 
					"root", "raspberry");			
			//Indicate manual transaction.
			dbConnection.setAutoCommit(false);
			//Start transaction.
			updateProduct = dbConnection.prepareStatement("UPDATE products SET barcode = ?, uom_id = ?" + 
														", description = ?, price = ?, vat_code = ? " +
														"WHERE product_id = ?");
			updateProduct.setString(1, "27607381");			
			updateProduct.setInt(2, 6);			
			updateProduct.setString(3, "Whole Fresh Milk 12 pints");			
			updateProduct.setDouble(4, 2.00);			
			updateProduct.setString(5, "v0");		
			updateProduct.setInt(6, 2);	
				
			updateStock = dbConnection.prepareStatement("UPDATE product_inventory SET quantity_in_stock = ? " +
														"WHERE product_id = ?");			
			updateStock.setDouble(1, 100);
			updateStock.setInt(2, 2);		
			//Update product table.
			updateProduct.executeUpdate();
			//Update product_inventory table.
			updateStock.executeUpdate();
			//Commit transaction
			dbConnection.commit();
			return true;
			
		}//end try
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}//end catch
		finally{
			//Do some clean-up.
			dbConnection = null;
			updateProduct = null;
			updateStock = null;
		}//end finally
	}//end isProductUpdated().

	public static void main(String[] args) {
		System.out.println("Existing product information will be updated from tables: products and product_inventory.");
		if(isProductUpdated()){
			System.out.println("Product was successfully updated!!!");
		}
		else{
			System.out.println("Product update failed!!!");
		}//end if
	}//end main.

}//end class.
