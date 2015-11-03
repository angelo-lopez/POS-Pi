package pospi;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/**
 * Author: Angelo Romel Lopez
 * <br>Description: Handles the logic and events of the PointOfSaleView class.
 * */

public class PointOfSaleController implements KeyListener, ActionListener, Printable{
    private PointOfSaleView posView;//Declare the view class to attach the controller class to.
    private String dataConnection;
    private String dataUser;
    private String dataPassword;
    private ArrayList <ProductOrder> productOrderList;
    private double totalPrice;
    
    /**
     * Constructor.
     */
    public PointOfSaleController(){
        posView = new PointOfSaleView();
        dataConnection = "";
        dataUser = "";
        dataPassword = "";
        productOrderList = new ArrayList <ProductOrder>();
        totalPrice = 0d;
        initialize();
        posView = new PointOfSaleView();
        posView.showGUI();
    }//end constructor.
    
    /**
     * Constructor, overloaded.
     * @param view PointOfSaleView
     * @param connection String
     * @param user String
     * @param password String
     */
    public PointOfSaleController(PointOfSaleView view, String connection, String user, String password){
        posView = view;
        dataConnection = connection;
        dataUser = user;
        dataPassword = password;
        productOrderList = new ArrayList <ProductOrder>();
        totalPrice = 0d;
        initialize();
        posView.showGUI();
    }//end constructor.
    
    /**
     * Initialize the event listener of the components.
     */
    public void initialize(){
        posView.getBarcodeTextField().addKeyListener(this);
        
        posView.getSevenButton().addActionListener(this);
        posView.getSevenButton().setActionCommand("seven");
        
        posView.getEightButton().addActionListener(this);
        posView.getEightButton().setActionCommand("eight");
        
        posView.getNineButton().addActionListener(this);
        posView.getNineButton().setActionCommand("nine");
        
        posView.getFourButton().addActionListener(this);
        posView.getFourButton().setActionCommand("four");
        
        posView.getFiveButton().addActionListener(this);
        posView.getFiveButton().setActionCommand("five");
        
        posView.getSixButton().addActionListener(this);
        posView.getSixButton().setActionCommand("six");
        
        posView.getOneButton().addActionListener(this);
        posView.getOneButton().setActionCommand("one");
        
        posView.getTwoButton().addActionListener(this);
        posView.getTwoButton().setActionCommand("two");
        
        posView.getThreeButton().addActionListener(this);
        posView.getThreeButton().setActionCommand("three");
        
        posView.getZeroButton().addActionListener(this);
        posView.getZeroButton().setActionCommand("zero");
        
        posView.getxButton().addActionListener(this);
        posView.getxButton().setActionCommand("x");
        
        posView.getEnterBarcodeButton().addActionListener(this);
        posView.getEnterBarcodeButton().setActionCommand("enter");
        
        posView.getCashButton().addActionListener(this);
        posView.getCashButton().setActionCommand("cash");
        
        posView.getCardButton().addActionListener(this);
        posView.getCardButton().setActionCommand("card");       
        
        posView.getCancelSaleButton().addActionListener(this);
        posView.getCancelSaleButton().setActionCommand("cancel sale");
        
        posView.getCancelItemButton().addActionListener(this);
        posView.getCancelItemButton().setActionCommand("cancel item");
        
        posView.getOtherItemButton().addActionListener(this);
        posView.getOtherItemButton().setActionCommand("other item");
    }//end initialize
    
    //Getters.  
    public ArrayList<ProductOrder> getProductOrderList() {
        return productOrderList;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    
    //Setters.
    public void setProductOrderList(ArrayList<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    /**
     * Implemented KeyListener abstract methods.
     * @param e KeyEvent
     * */
    public void keyTyped(KeyEvent e){};
    
    public void keyReleased(KeyEvent e){};
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ENTER){//barcode suffix encountered. Retrieve barcode from database.
            getItemFromBarcode();
            posView.getBarcodeTextField().setText("");
        }
    }//end keyPressed()
    
    /**
     * Implemented ActionListener abstract methods.
     * Handles the events when a button is pressed.
     * @param e ActionEvent
     */
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        try{
            Robot robot = new Robot();
            switch(command){
                case "seven":                    
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_7);
                    /*
                     *keyRelease is needed for linux based systems for the keyPress
                     *to work properly. This is not needed on a Microsoft Windows system.
                     */
                    robot.keyRelease(KeyEvent.VK_7);
                    break;
                case "eight":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_8);
                    robot.keyRelease(KeyEvent.VK_8);
                    break;
                case "nine":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_9);
                    robot.keyRelease(KeyEvent.VK_9);
                    break;
                case "four":
                    //Simulate a key press
                   robot.keyPress(KeyEvent.VK_4);
                   robot.keyRelease(KeyEvent.VK_4);
                    break;
                case "five":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    break;
                case "six":                        
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_6);
                    robot.keyRelease(KeyEvent.VK_6);
                    break;
                case "one":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    break;
                case "two":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    break;
                case "three":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_3);
                    robot.keyRelease(KeyEvent.VK_3);
                    break;
                case "zero":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                    break;
                case "x":
                    posView.getBarcodeTextField().setText("");              
                    break;
                case "enter":
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    break;
                case "cash":
                    //Process cash sale.
                    DecimalFormat format = new DecimalFormat("#####.00");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    if(posView.getItemDisplayTextArea().getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Your basket is empty.\nThere are no items to checkout.", 
                                                        "POS-Pi", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        int replyCash = JOptionPane.showConfirmDialog(null, "Proceed to cash checkout?", "POS-Pi",
                                  JOptionPane.YES_NO_OPTION);
                        if(replyCash == JOptionPane.YES_OPTION){
                            PayByCashDialog cash = new PayByCashDialog(posView.getMainFrame(), true, getTotalPrice());
                            cash.setLocationRelativeTo(null);
                            cash.setVisible(true);
                            if(cash.isDialogOk()){
                                if(commitSaleTransaction()){
                                    JOptionPane.showMessageDialog(null,"Checkout was successful!!!", 
                                            "POS-Pi", JOptionPane.INFORMATION_MESSAGE);
                                    //Add title to the TextArea.
                                    posView.getItemDisplayTextArea().insert("POS-Pi\nTransaction Date: " + dateFormat.format(new Date()) + "\n", 0);
                                    //Append total price to the item display TextArea.
                                    posView.getItemDisplayTextArea().append("Total Price: " + format.format(this.totalPrice));
                                    //Print receipt.
                                    printReceipt();
                                    clearAllDisplay();
                                    posView.getMainFrame().dispose();                               
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"An error was encountered\n" +
                                                                 "during the checkout process.\n" +
                                                                 "Sale transaction was cancelled.", 
                                                                 "POS-Pi", JOptionPane.WARNING_MESSAGE);
                                    clearAllDisplay();
                                }//end if
                            }//end if
                            cash.dispose();
                        }//end if
                    }//end if
                    
                    break;
                case "card":
                    JOptionPane.showMessageDialog(null,"Payment by card is not \n"+
                                                  "currently available.\n" +
                                                  "Only cash payment is allowed.", 
                            "POS-Pi", JOptionPane.WARNING_MESSAGE);
                    break;
                case "cancel sale":
                    //Cancel the sale and close the POS window.
                    int replyCancelSale = JOptionPane.showConfirmDialog(null, "Do you wish to\ncancel/close the sale?", "POS-Pi", 
                            JOptionPane.YES_NO_OPTION);
                    if(replyCancelSale == JOptionPane.YES_OPTION){
                        clearAllDisplay();
                        posView.getMainFrame().dispose();
                    }//end if
                    break;
                case "cancel item":
                    //Removes an item from the sale.
                    if(posView.getItemDisplayTextArea().getText().equals("")){
                        JOptionPane.showMessageDialog(null,"The product list is empty.\nThere are no items to delete.", 
                                                        "POS-Pi", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        //Get the item position to be deleted.
                        int itemPosition = getDeleteItemPosition();
                        if(itemPosition != 0){
                            //Delete the item from the product list in the TextArea.
                            deleteItemOrdered(itemPosition - 1);
                            //Update the items ordered TextArea.
                            displayItemsOrdered();
                        }//end if
                    }//end if
                    break;
                case "other item":
                    //Create an instance of the custom dialog and set it to modal.
                    UnitSaleDialog usd = new UnitSaleDialog(posView.getMainFrame(), true,
                                                                        this.dataConnection,
                                                                        this.dataUser,
                                                                        this.dataPassword);
                    usd.setLocationRelativeTo(null);
                    usd.setVisible(true);
                    if(usd.isDialogOk()){
                        getItemFromUOM(usd.getProductID(), usd.getQuantity());
                    }//end if
                    usd.dispose();//Dispose the custom dialog.
                    break;           
            }//end switch
            robot = null;
        }//end try
        catch(Exception ex){
            ex.printStackTrace();
        }//end catch
    }//end actionPerformed
    
    /**
     * Retrieves the item from the database using the barcode attribute and displays it in the TextArea.
     */
    public void getItemFromBarcode(){
        ResultSet rs = null;
        String selectStatement = "SELECT products.product_id, " +
                                 "products.barcode, " +
                                 "products.uom_id, " +
                                 "products.description, " +
                                 "products.price, " + 
                                 "products.vat_code, " +
                                 "vat.rate " + "FROM products LEFT JOIN vat " + 
                                 "ON products.vat_code = vat.vat_code " + 
                                 "WHERE products.barcode = '" + posView.getBarcodeTextField().getText() + "'";
        try{
            rs = runSelect(selectStatement);
            //if ResultSet is not before the first result, then ResultSet is empty.
            if(! rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Sorry, the barcode is\nnot recognized.", 
                        "POS-Pi",
                        JOptionPane.WARNING_MESSAGE);
            }
            //ResultSet is before the first result, record is found.
            else{
                rs.next();
                //Create a new object to hold the product information and store it
                //in an ArrayList.
                ProductOrder product = new ProductOrder();
                product.setProductID(rs.getInt("product_id"));
                product.setBarcode(rs.getString("barcode"));
                product.setUomID(rs.getInt("uom_id"));
                product.setUomCode("");
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setVatRate(rs.getByte("rate"));
                product.setQuantity(1);
                //Add product to the ArrayList.
                productOrderList.add(product);
                //Display the contents of the ArrayList.
                displayItemsOrdered();              
                //Show the most recent item on the text area by scrolling all the way down to the bottom.
                JScrollBar scrollBar = posView.getScrollPane().getVerticalScrollBar();
                scrollBar.setValue(scrollBar.getMaximum());
            }//end if
        }//end try
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), 
                    "Error in connecting to database.",
                    JOptionPane.WARNING_MESSAGE);
        }//end catch
    }//end getItem()
    
    /**
     * Retrieves an item from the database that have a unit-of-measurement code and displays it in the TextArea.
     * @param productID int
     * @param quantity double
     */
    public void getItemFromUOM(int productID, double quantity){
        ResultSet rs = null;
        String selectStatement = "SELECT products.product_id, products.barcode, products.uom_id, " +
                "products.description, products.price, products.vat_code, vat.rate, " +
                "unit_of_measurement.uom_code " +
                "FROM products LEFT JOIN vat " + 
                "ON products.vat_code = vat.vat_code " +
                "LEFT JOIN unit_of_measurement " +
                "ON products.uom_id = unit_of_measurement.uom_id " +
                "WHERE products.product_id = " + productID + ";";       
        try{
            rs = runSelect(selectStatement);
            //if ResultSet is not before the first result, then ResultSet is empty.
            if(! rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Sorry, the product\nis not recognized.", 
                        "POS-Pi",
                        JOptionPane.WARNING_MESSAGE);
            }
            //ResultSet is before the first result, record is found.
            else{
                rs.next();
                //Create a new object to hold the product information and store it
                //in an ArrayList.
                ProductOrder product = new ProductOrder();
                product.setProductID(rs.getInt("product_id"));
                product.setBarcode(rs.getString("barcode"));
                product.setUomID(rs.getInt("uom_id"));
                product.setUomCode(rs.getString("uom_code"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setVatRate(rs.getByte("rate"));
                product.setQuantity(quantity);              
                //Add product to the ArrayList.
                productOrderList.add(product);
                //Display the contents of the ArrayList.
                displayItemsOrdered();              
                //Show the most recent item on the text area by scrolling all the way down to the bottom.
                JScrollBar scrollBar = posView.getScrollPane().getVerticalScrollBar();
                scrollBar.setValue(scrollBar.getMaximum());
            }//end if
        }//end try
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), 
                    "Error in connecting to database.",
                    JOptionPane.WARNING_MESSAGE);
        }//end catch
    }//end getItemFromUOM
    
    /**
     * Executes a  select query on the database.
     * @param selectStatement
     * @return ResultSet
     */
    public ResultSet runSelect(String selectStatement){
        Connection dbConnection = null;
        Statement dbStatement = null;   
        ResultSet rs = null;
        try{
            dbConnection = DriverManager.getConnection(dataConnection, dataUser, dataPassword);
            dbStatement = dbConnection.createStatement();
            rs = dbStatement.executeQuery(selectStatement);         
        }//end try
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
        finally{
            dbConnection = null;
            dbStatement = null;
        }//end finally
        return rs;
    }//end runSelect
    
    /**
     * Displays the contents of the Product ArrayList on the TextArea.
     */
    public void displayItemsOrdered(){
        DecimalFormat format = new DecimalFormat("#####.00");
        double grossAmount = 0d;
        totalPrice = 0d; 
        //Clear the TextArea before re-populating it with values from the Product ArrayList.
        posView.getItemDisplayTextArea().setText("");
        //Iterate through the ArrayList and display objects on the TextArea.
        int i = 0;//For displaying line number.
        for(ProductOrder prod:productOrderList){
            i++;
            //Calculate VAT.
            grossAmount = (prod.getQuantity() * (prod.getPrice() + (prod.getVatRate() / 100.0) * prod.getPrice()));
            //Display product in the TextArea item list.
            posView.getItemDisplayTextArea().append(i + " > " + prod.getDescription() + 
                                                    " Qty: " + prod.getQuantity() + 
                                                    " " + prod.getUomCode() + " (" +
                                                    format.format(prod.getPrice()) + 
                                                    " + " + prod.getVatRate() + "% VAT) = " + 
                                                    format.format(grossAmount) + 
                                                    "\n"); //+
                                                    //"- - - - - - - - - - - - - - - - - - - -" + "\n");
            totalPrice += grossAmount;
        }//end for
        //Display total price.
        posView.getTotalTextField().setText(format.format(totalPrice));
    }//displayProductOrder
    
    /**
     * Clears the ArrayList, TextArea and TextFields.
     */
    public void clearAllDisplay(){      
        productOrderList.clear();
        posView.getBarcodeTextField().setText("");
        posView.getItemDisplayTextArea().setText("");
        posView.getTotalTextField().setText("�0.00");
    }//end clearAll
    
    /**
     * Returns the line number of an item from the TextArea by making the user choose from a dropdown list.
     * @return int
     */
    public int getDeleteItemPosition(){
        String [] itemPosition = new String [productOrderList.size()];
        //Populate the array with the position of the products.
        for(int x = 0; x < itemPosition.length; x ++){
            itemPosition[x] = String.valueOf(x + 1);
        }//end for
        //Prompt user to choose the position of the item to delete.
        String input = (String)JOptionPane.showInputDialog(null, "Please select the position of\nthe item you wish to delete.", 
                                                "POS-Pi", JOptionPane.QUESTION_MESSAGE, null, 
                                                itemPosition, itemPosition[0]);
        if(input != null){
            return Integer.valueOf(input);//Return the position of the item.
        }
        else{
            return 0;//No item was selected. The user chose cancel.
        }//end if
            
    }//end getItemPosition
    
    /**
     * Deletes the item from the TextArea of items ordered.
     * @param itemPos int
     */
    public void deleteItemOrdered(int itemPos){
        productOrderList.remove(itemPos);
    }//end deleteItemOrdered
    
    /**
     * Save changes to database: [1] insert new order record. [2] update product inventory table.
     * Use manual transaction to commit changes. Return true if changes to database was successful,
     * return false otherwise.
     * @return boolean
     */
    public boolean commitSaleTransaction(){
        Connection dbConnection = null;
        Statement insertStatement = null;
        PreparedStatement updateStatement = null;
        int orderPK;//Store auto-generated primary key value.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs = null;//For holding auto-generated keys.
        try{
            dbConnection = DriverManager.getConnection(dataConnection, dataUser, dataPassword);
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
                //Navigate thru entire list of products ordered (Product ArrayList) and update database.
                for(ProductOrder prod:productOrderList){
                    //Insert a new record in the order_products table.
                	insertStatement = dbConnection.createStatement();
                    insertStatement.executeUpdate("INSERT INTO order_products " +
                            "(order_id, product_id) VALUES (" + orderPK + ", " + prod.getProductID() +")");
                    //Update inventory table.
                    updateStatement = dbConnection.prepareStatement("UPDATE product_inventory " +
                                                                    "SET quantity_in_stock = (quantity_in_stock - ?)" +
                                                                    " WHERE product_id = ?");
                    updateStatement.setDouble(1, prod.getQuantity());
                    updateStatement.setInt(2, prod.getProductID());
                    updateStatement.executeUpdate();
                }//end for
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
            JOptionPane.showMessageDialog(null, sqlEx.toString(), 
                    "Error in connecting to database.",
                    JOptionPane.WARNING_MESSAGE);
            try {
                dbConnection.rollback();//Rollback changes if an exception was thrown.
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }//end catch
        catch(Exception eEx){
            JOptionPane.showMessageDialog(null, eEx.toString(),
                    "Error in connecting to database",
                    JOptionPane.WARNING_MESSAGE);
            try {
                dbConnection.rollback();//Rollback changes if an exception was thrown.
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }//end catch    
        finally{
            //Do some clean-up.
            dbConnection = null;
            insertStatement = null;
            updateStatement = null;
        }//end finally
    }//end commitSaleTransaction
    
    /**
     * Format the page/s to be printed to setPrintable.
     */
    public void printReceipt(){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        try{
            printerJob.print();
        }//end try
        catch(PrinterException pe){
            JOptionPane.showMessageDialog(null, "No printer found.",
                    "Error in printing receipt.",
                    JOptionPane.WARNING_MESSAGE);
        }//end catch
    }//end printReceipt().
    
    /**
     * Implemented abstract Printable.print() method. Print the actual contents of the TextArea.
     * @param graphics Graphics
     * @param pageFormat PageFormat
     * @param pageIndex int
     * @return int
     * @throws PrinterException
     */
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException{
        try{
            Font oldFont = graphics.getFont();//Store current font, to be restored after printing the receipt.
            Font font = new Font("", Font.PLAIN, 6);//Specify the font to be used for printing the receipt.
            graphics.setFont(font);//Set the font.
            
            String receipt;
            int lineStart,
                lineEnd,
                lineNumber,
                lineCount;
            
            if(pageIndex >= 1) return Printable.NO_SUCH_PAGE;
            graphics.translate((int)(pageFormat.getImageableX()), (int)(pageFormat.getImageableY()));
            graphics.setColor(Color.BLACK);
            lineNumber = 0;
            lineCount = posView.getItemDisplayTextArea().getLineCount();
            receipt = posView.getItemDisplayTextArea().getText();
            while(lineNumber < lineCount){
                try{
                    lineStart = posView.getItemDisplayTextArea().getLineStartOffset(lineNumber);
                    lineEnd = posView.getItemDisplayTextArea().getLineEndOffset(lineNumber);
                    receipt = posView.getItemDisplayTextArea().getText(lineStart, lineEnd-lineStart);
                }//end try
                catch(Exception ex){
                    ex.printStackTrace();
                }//end catch.
                graphics.drawString(receipt, 0, (lineNumber + 1) * 20);
                lineNumber = lineNumber + 1;
            }//end while.
            graphics.setFont(oldFont);
            return Printable.PAGE_EXISTS;
        }//end try
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No printer found.",
                    "Error in printing receipt.",
                    JOptionPane.WARNING_MESSAGE);
            return Printable.NO_SUCH_PAGE;
        }//end catch
    }//end print().
    
}//end class
