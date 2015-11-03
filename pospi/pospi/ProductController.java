package pospi;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Handles the logic and events of the ProductView class.
 * */

public class ProductController implements ActionListener{
	private ProductView pView;
	private String dataConnection;
	private String dataUser;
	private String dataPassword;
	
	/**
	 * Constructor. Calls the displayProducts() method.
	 * @param view ProductView
	 * @param connection String
	 * @param user String
	 * @param password String
	 */
	public ProductController(ProductView view, String connection, String user, String password){
		this.pView = view;
		this.dataConnection = connection;
		this.dataUser = user;
		this.dataPassword = password;
		initialize();
		this.pView.showGUI();
		displayProducts(getProductSet("SELECT product_id, description FROM products " + 
				  "ORDER BY description;"));
	}//end constructor.

	//Getters.
	public ProductView getpView() {
		return pView;
	}

	public String getDataConnection() {
		return dataConnection;
	}

	public String getDataUser() {
		return dataUser;
	}

	public String getDataPassword() {
		return dataPassword;
	}

	//Setters.
	public void setpView(ProductView pView) {
		this.pView = pView;
	}

	public void setDataConnection(String dataConnection) {
		this.dataConnection = dataConnection;
	}

	public void setDataUser(String dataUser) {
		this.dataUser = dataUser;
	}

	public void setDataPassword(String dataPassword) {
		this.dataPassword = dataPassword;
	}
	
	/**
	 * Initialize component's event-listeners.
	 */
	public void initialize(){
		this.pView.getInsertButton().addActionListener(this);
		this.pView.getInsertButton().setActionCommand("insert");
		
		this.pView.getUpdateButton().addActionListener(this);
		this.pView.getUpdateButton().setActionCommand("update");
		
		this.pView.getDeleteButton().addActionListener(this);
		this.pView.getDeleteButton().setActionCommand("delete");
		
	}//end initialize().
	
	/**
	 * Implemented ActionListener abstract method.<br>Handles the events when a button is pressed.
	 * @param e ActionEvent
	 */
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		switch(command){
		case "insert":
			@SuppressWarnings("unused")
			ProductMaintenanceController pmControlI = new ProductMaintenanceController(new ProductMaintenanceView(), this.dataConnection,
																					  this.dataUser, this.dataPassword);
			break;
		case "update":
			ProductMaintenanceView pmView = new ProductMaintenanceView();
			@SuppressWarnings("unused")
			ProductMaintenanceController pmControl = new ProductMaintenanceController(pmView, this.dataConnection, this.dataUser,
			this.dataPassword, 
			//Gets the product_id from the currently selected row on the JTable.
			Integer.valueOf(this.pView.getProductViewTable().getModel().getValueAt(this.pView.getProductViewTable().getSelectedRow(), 0).toString()));
			pmView.showGUI();
			break;
		case "delete":
			if(deleteProduct(Integer.valueOf(this.pView.getProductViewTable().getModel().getValueAt(this.pView.getProductViewTable().getSelectedRow(), 0).toString())) == true){
				JOptionPane.showMessageDialog(null, "Product was successfully\ndeleted.", 
						"POS-Pi",
						JOptionPane.WARNING_MESSAGE);
				displayProducts(getProductSet("SELECT product_id, description FROM products " + 
						  "ORDER BY description;"));
			}
			else{
				JOptionPane.showMessageDialog(null, "An error was encountered\nin deleting the product.", 
						"POS-Pi",
						JOptionPane.WARNING_MESSAGE);				
			}
			break;
		}
	}//end actionPerformed()
	
	/**
	 * Retrieves records for the products table.
	 * @param sql String
	 * @return ResultSet
	 */
	public ResultSet getProductSet(String sql){
		Connection connection;
		Statement statement;
		try{
			connection = DriverManager.getConnection(this.dataConnection, this.dataUser, this.dataPassword);
			statement = connection.createStatement();
			return statement.executeQuery(sql);
		}//end try
		catch(SQLException se){
			se.printStackTrace();
			return null;
		}//end catch.
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}//end catch.
		finally{
			//Do some clean up.
			statement = null;
			connection = null;
		}//end finally
	}//end getProductSet().
	
	/**
	 * Gets the total number of records in the product table to set the number of rows of the JTable.
	 * @return int total number of records.
	 */
	public int getTotalRows(){
		ResultSet rs = getProductSet("SELECT COUNT(*) AS total_number FROM products;");
		int totalRows = 0;
		try{
			if(rs.next()){
				totalRows = rs.getInt("total_number");
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}//end catch.
		catch(Exception ex){
			ex.printStackTrace();
		}//end catch.
		return totalRows;
	}//
	
	/**
	 * Displays the records of the products table in a JTable
	 * @param rs ResultSet
	 */
	public void displayProducts(ResultSet rs){
		int row = 0;
		pView.createTable(getTotalRows());//Construct JTable with specified number of rows.
		try{
			while(rs.next()){
				pView.getProductViewTable().setValueAt(rs.getString("product_id"), row, 0);
				pView.getProductViewTable().setValueAt(rs.getString("description"), row, 1);
				row ++;
			}//end while
		}//end try
		catch(SQLException se){
			se.printStackTrace();
		}//end catch
		catch(Exception ex){
			ex.printStackTrace();
		}//end catch
	}//end displayProduct();
	
	/**
	 * Deletes a product from the products table.
	 * @param productID int
	 * @return boolean true if delete was successful, false otherwise.
	 */
	public boolean deleteProduct(int productID){
		Connection dbConnection = null;
		Statement deleteStatement = null;
		try{
			//Indicate manual transaction.			
			dbConnection = DriverManager.getConnection(this.dataConnection, this.dataUser, this.dataPassword);
			dbConnection.setAutoCommit(false);
			deleteStatement = dbConnection.createStatement();			
			deleteStatement.execute("DELETE FROM product_inventory WHERE product_id = " + productID);
			deleteStatement.execute("DELETE FROM products WHERE product_id = " + productID);
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
	}//end deleteProduct()

}//end class.
