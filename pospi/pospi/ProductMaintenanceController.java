package pospi;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Handles the logic and events of the ProductMaintenanceView class.
 * */
 
public class ProductMaintenanceController implements ActionListener {
	private ProductMaintenanceView pmView;
	private String dataConnection;
	private String dataUser;
	private String dataPassword;
	private boolean isUpdate;//if update is true then record is updated, otherwise record is inserted.
	private int productID;
	
	/**
	 * Constructor for the ProductMaintenanceController class. Called if product is to be updated, isUpdate is set to true.
	 * @param view (instance of ProductMaintenanceView class)
	 * @param connection (database connection string.)
	 * @param user (user name to connect to the database.)
	 * @param password (password for the supplied user name.)
	 * @param productID (product ID of the product to be updated)
	 **/
	public ProductMaintenanceController(ProductMaintenanceView view, String connection, String user, String password, int productID){
		this.pmView = view;
		this.dataConnection = connection;
		this.dataUser = user;
		this.dataPassword = password;
		this.isUpdate = true;
		this.productID = productID;
		this.pmView.showGUI();
		initialize();
		//Populate the comboboxes.
		populateUomComboBox();
		populateVatComboBox();
		this.pmView.getUomCombo().setSelectedItem("N/A");
		//Display product information if product is to be updated.
		if(this.isUpdate){
			fetchRecord();
		}
	}//end constructor.
	
	/**
	 * Constructor for the ProductMaintenanceController class. Called if product is to be inserted, isUpdate is set to false.
	 * @param view (instance of ProductMaintenanceView class)
	 * @param connection (database connection string.)
	 * @param user (user name to connect to the database.)
	 * @param password (password for the supplied user name.)
	 **/
	public ProductMaintenanceController(ProductMaintenanceView view, String connection, String user, String password){
		this.pmView = view;
		this.dataConnection = connection;
		this.dataUser = user;
		this.dataPassword = password;
		this.isUpdate = false;
		initialize();
		this.pmView.showGUI();
		//Populate the comboboxes.
		populateUomComboBox();
		populateVatComboBox();
		this.pmView.getUomCombo().setSelectedItem("N/A");
	}//end constructor.

	//Getters.
	public ProductMaintenanceView getPmView() {
		return pmView;
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
	
	public boolean getIsUpdate(){
		return this.isUpdate;
	}

	//Setters.
	public void setPmView(ProductMaintenanceView pmView) {
		this.pmView = pmView;
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
	
	public void setIsUpdate(boolean isUpdate){
		this.isUpdate = isUpdate;
	}
	
	/**
	 * Initialize component's event-listeners.
	 **/
	public void initialize(){
		this.pmView.getSaveButton().addActionListener(this);
		this.pmView.getSaveButton().setActionCommand("save");
		
		this.pmView.getCancelButton().addActionListener(this);
		this.pmView.getCancelButton().setActionCommand("cancel");			
	}//end initialize().
	
	/**
	 * Implemented ActionListener abstract method.<br>Handles the events when a button is pressed.
	 * @param e ActionEvent
	 **/
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		switch(command){
		case "save":
			//Record is to be updated.
			if(isUpdate == true){
				if(updateProduct() == true){
					JOptionPane.showMessageDialog(null, "Product information was\nupdated successfully.", 
							"POS-Pi",
							JOptionPane.WARNING_MESSAGE);
					
					this.pmView.getMainFrame().dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Unable to update product\ninformation.", 
							"POS-Pi",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			//Record is to be inserted.
			else{
				//A product either have a barcode or a unit-of-measurement code, but not both.
				if(!this.pmView.getBarCodeTextField().getText().equals("") && !this.pmView.getUomCombo().getSelectedItem().equals("N/A")){
					JOptionPane.showMessageDialog(null, "Sorry, cannot have a\nvalue for both barcode\nand UOM", 
							"POS-Pi",
							JOptionPane.WARNING_MESSAGE);
				}
				else{
					String reorderLevel = JOptionPane.showInputDialog(null, "Please enter the reorder\nlevel for this product:", 
																	  "POS-Pi", JOptionPane.QUESTION_MESSAGE);
					if(isValidNumber(reorderLevel) == true){
						if(insertProduct(Integer.valueOf(reorderLevel)) == true){
							JOptionPane.showMessageDialog(null, "Product information was\nadded successfully.", 
									"POS-Pi.",
									JOptionPane.WARNING_MESSAGE);
							
							this.pmView.getMainFrame().dispose();
						}
						else{
							JOptionPane.showMessageDialog(null, "Unable to update product\ninformation.", 
									"POS-Pi",
									JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid number,\nplease try again.", 
								"Invalid number format.",
								JOptionPane.WARNING_MESSAGE);
					}//end if
				}
			}//end if
			break;
		case "cancel":
			this.pmView.getMainFrame().dispose();
			break;
		}
	}//end actionPerformed().
	
	/**
	 * Gets the record to be updated and displays it on the frame.
	 **/
	public void fetchRecord(){
		String sql = "SELECT products.product_id, products.barcode, products.uom_id, unit_of_measurement.uom_code, " +
					 "products.description, products.price, products.vat_code, product_inventory.quantity_in_stock " + 
					 "FROM products LEFT JOIN unit_of_measurement " +
					 "ON products.uom_id = unit_of_measurement.uom_id LEFT JOIN " +
					 "product_inventory ON products.product_id = product_inventory.product_id " +
					 "WHERE products.product_id = " + this.productID + ";";
		displayProducts(getProductSet(sql));
	}//end fetchRecord().
	
	/**
	 * Retrieves records from the products table.
	 * @param sql String
	 * @return ResultSet
	 **/
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
	}//end displayProduct().
	
	/**
	 * Displays a list of products on a JTable
	 * @param rs ResultSet
	 **/
	public void displayProducts(ResultSet rs){
		try{
			this.pmView.getUomCombo().setSelectedItem("(None)");
			this.pmView.getVatCombo().setSelectedItem("(None)");
			if(rs.next()){
				this.pmView.getBarCodeTextField().setText(rs.getString("products.barcode"));
				this.pmView.getDescriptionTextField().setText(rs.getString("products.description"));
				this.pmView.getPriceTextField().setText(rs.getString("products.price"));
				this.pmView.getUomCombo().setSelectedItem(rs.getString("unit_of_measurement.uom_code"));
				this.pmView.getVatCombo().setSelectedItem(rs.getString("products.vat_code"));
				this.pmView.getQuantityTextField().setText(rs.getString("product_inventory.quantity_in_stock"));
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
	 * Populates the unit-of-measurement combobox with values from the table.
	 **/
	@SuppressWarnings("unchecked")
	public void populateUomComboBox(){
		ResultSet rs = getProductSet("SELECT uom_code FROM unit_of_measurement;");
		try {
			while(rs.next()){
				this.pmView.getUomCombo().addItem(rs.getString("uom_code"));
			}//end while.
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}//end catch.
	}//end populateUomComboBox().
	
	/**
	 * Populates the VAT combobox with values from the table.
	 **/
	@SuppressWarnings("unchecked")
	public void populateVatComboBox(){
		ResultSet rs = getProductSet("SELECT vat_code FROM vat;");
		try {
			while(rs.next()){
				this.pmView.getVatCombo().addItem(rs.getString("vat_code"));
			}//end while.
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}//end catch.
	}//end populateVatComboBox().
	
	/**
	 * Retrieves the uom_id from the unit_of_measurement given the uom_code.
	 * @param uomCode String
	 * @return int uom_id
	 **/
	public int getUomID(String uomCode){		
		ResultSet rs = getProductSet("SELECT uom_id FROM unit_of_measurement WHERE uom_code = '" + 
									 uomCode + "'");
		try {
			if(!rs.isBeforeFirst()){
				//if ResultSet is not before the first result, then ResultSet is empty. Return -1.
				return -1;
			}
			else{	
				rs.next();		
				return rs.getInt("uom_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}//end catch.
	}//end getUomID()
	
	/**
	 * Updates the product record.
	 * @return boolean true if the update operation was successful, false otherwise.
	 **/
	public boolean updateProduct(){
		Connection dbConnection;
		PreparedStatement updateProduct = null, 
						  updateStock = null;
		try{
			dbConnection = DriverManager.getConnection(this.dataConnection, this.dataUser, this.dataPassword);			
			//Indicate manual transaction.
			dbConnection.setAutoCommit(false);
			//Start transaction.
			//Insert a value for the barcode if a value was specified, insert null otherwise.
			if(!this.pmView.getBarCodeTextField().getText().equals("")){
				updateProduct = dbConnection.prepareStatement("UPDATE products SET barcode = ?, uom_id = ?" + 
															  ", description = ?, price = ?, vat_code = ? " +
															  "WHERE product_id = ?");
				updateProduct.setString(1, this.pmView.getBarCodeTextField().getText());			
				updateProduct.setInt(2, getUomID(this.pmView.getUomCombo().getSelectedItem().toString()));			
				updateProduct.setString(3, this.pmView.getDescriptionTextField().getText());			
				updateProduct.setDouble(4, Double.valueOf(this.pmView.getPriceTextField().getText()));			
				updateProduct.setString(5, this.pmView.getVatCombo().getSelectedItem().toString());		
				updateProduct.setInt(6, this.productID);		
			}
			else{
				updateProduct = dbConnection.prepareStatement("UPDATE products SET uom_id = ?" + 
						  ", description = ?, price = ?, vat_code = ? " +
						  "WHERE product_id = ?");		
				updateProduct.setInt(1, getUomID(this.pmView.getUomCombo().getSelectedItem().toString()));			
				updateProduct.setString(2, this.pmView.getDescriptionTextField().getText());			
				updateProduct.setDouble(3, Double.valueOf(this.pmView.getPriceTextField().getText()));			
				updateProduct.setString(4, this.pmView.getVatCombo().getSelectedItem().toString());		
				updateProduct.setInt(5, this.productID);
			}
			updateStock = dbConnection.prepareStatement("UPDATE product_inventory SET quantity_in_stock = ? " +
														"WHERE product_id = ?");			
			updateStock.setDouble(1, Double.valueOf(this.pmView.getQuantityTextField().getText()));
			updateStock.setInt(2, this.productID);		
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
	}//end updateProduct().
	
	/**
	 * Inserts a new record to the products and product inventory table.
	 * @return boolean true if the insert operation was successful, false otherwise.
	 **/
	public boolean insertProduct(int reorderLevel){
		Connection dbConnection = null;
		Statement insertProduct = null;
		PreparedStatement insertStock = null;
		ResultSet rs = null;//For holding auto-generated keys.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int productPK;
		try{
			dbConnection = DriverManager.getConnection(this.dataConnection, this.dataUser, this.dataPassword);			
			//Indicate manual transaction.
			dbConnection.setAutoCommit(false);			
			//Start transaction.
			//Insert a value for the barcode if a value was specified, insert null otherwise.
			if(!this.pmView.getBarCodeTextField().getText().equals("")){
				insertProduct = dbConnection.createStatement();
				insertProduct.executeUpdate("INSERT INTO products (barcode, uom_id, description, price, vat_code) VALUES ('" +
						this.pmView.getBarCodeTextField().getText() + "', " +
						getUomID(this.pmView.getUomCombo().getSelectedItem().toString()) + ", '" +
						this.pmView.getDescriptionTextField().getText() + "', " +
						Double.valueOf(this.pmView.getPriceTextField().getText()) + ", '" +
						this.pmView.getVatCombo().getSelectedItem().toString() + "')", Statement.RETURN_GENERATED_KEYS);
			}
			else{//Inserts null for the barcode.
				insertProduct = dbConnection.createStatement();
				insertProduct.executeUpdate("INSERT INTO products (uom_id, description, price, vat_code) VALUES (" +
						getUomID(this.pmView.getUomCombo().getSelectedItem().toString()) + ", '" +
						this.pmView.getDescriptionTextField().getText() + "', " +
						Double.valueOf(this.pmView.getPriceTextField().getText()) + ", '" +
						this.pmView.getVatCombo().getSelectedItem().toString() + "')", Statement.RETURN_GENERATED_KEYS);
			}	
			rs = insertProduct.getGeneratedKeys();//Retrieve the auto-number primary key.
			if(rs.next()){
			productPK = rs.getInt(1);
			insertStock = dbConnection.prepareStatement("INSERT INTO product_inventory (product_id,  inventory_date, " + 
														"quantity_in_stock, reorder_level) VALUES (?, ?, ?, ?)");
			insertStock.setInt(1, productPK);
			insertStock.setString(2, dateFormat.format(new Date()));
			insertStock.setDouble(3, Double.valueOf(this.pmView.getQuantityTextField().getText()));
			insertStock.setInt(4, reorderLevel);
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
	
	/**
	 * Returns true for a valid number, false otherwise.
	 * @param number String
	 * @return boolean
	 **/
	public boolean isValidNumber(String number){
		try{
			Double.parseDouble(number);
			return true;
		}
		catch(NumberFormatException ex){
			return false;
		}//end try/catch
	}//end isValidNumber
	
}//end class.
