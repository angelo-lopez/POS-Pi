package pospi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class TestOrderInsert {
	
	private static boolean isSaleTransactionCommitted(){
        Connection dbConnection = null;
        Statement insertStatement = null;
        PreparedStatement updateStatement = null;
        int orderPK;//Store auto-generated primary key value.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs = null;//For holding auto-generated keys.
        try{
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/test_pos_pi", 
					"root", "raspberry");
            //Indicate manual transaction.
            dbConnection.setAutoCommit(false);
            //----------------Start of transaction.----------------
            insertStatement = dbConnection.createStatement();
            insertStatement.executeUpdate("INSERT INTO orders " + 
                    " (order_date) VALUES ('" + dateFormat.format(new Date()) + "')", Statement.RETURN_GENERATED_KEYS);
            //Get the auto-increment primary key value.
            rs = insertStatement.getGeneratedKeys();
            if(rs.next()){
                orderPK = rs.getInt(1);//Store PK value.
                //Insert a new record in the order_products table.
                insertStatement = dbConnection.createStatement();
                insertStatement.executeUpdate("INSERT INTO order_products " +
                            "(order_id, product_id) VALUES (" + orderPK + ", 3)");
                //Update inventory table.
                updateStatement = dbConnection.prepareStatement("UPDATE product_inventory " +
                                                                    "SET quantity_in_stock = (quantity_in_stock - ?)" +
                                                                    " WHERE product_id = ?");
                updateStatement.setDouble(1, 1);
                updateStatement.setInt(2, 3);
                updateStatement.executeUpdate();
                //Commit transaction.
                dbConnection.commit();
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to retrieve orders\nPK value.", 
                        "Error PK retrieval.",
                        JOptionPane.WARNING_MESSAGE);
                throw new SQLException();//Throw an exception and rollback changes.
            }//end if           
        }//end try
        catch(SQLException sqlEx){
        	sqlEx.printStackTrace();
            return false;
        }//end catch
        catch(Exception eEx){
        	eEx.printStackTrace();
            return false;
        }//end catch    
        finally{
            //Do some clean-up.
            dbConnection = null;
            insertStatement = null;
            updateStatement = null;
        }//end finally
    }//end isSaleTransactionCommitted()
    

	public static void main(String[] args) {
		System.out.println("A new record will be inserted in the following tables:\n" + ""
				+ "1. orders\n2.order_details.\nRecords will be updated in the product_inventory table.\n");
		if(isSaleTransactionCommitted()){
			System.out.println("Rercord/s were successfully inserted!!!");
		}
		else{
			System.out.println("Record insertion failed!!!");
		}//end if
	}//end main().

}//end class.
