package pospi;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Robot;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: <br>[1] Constructs and initializes the components and graphical user interface
 * of the unit-sale custom dialog screen.<br>[2] Handles the logic and events of the unit-sale custom dialog screen.
 * */

@SuppressWarnings("serial")
public class UnitSaleDialog extends JDialog implements ActionListener, ItemListener{
    private String dataConnection;
    private String dataUser;
    private String dataPassword;
    private boolean dialogOk;
    private double quantity;
    private ArrayList <Integer> productID;
    private ArrayList <String> uomDescription;
    
    private final JPanel contentPanel = new JPanel();
    private JTextField quantityTextField;
    @SuppressWarnings("rawtypes")
    private JComboBox productCombo;
    private JLabel quantityLabel;
    
    private JButton fourButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton dotButton;
    private JButton zeroButton;
    private JButton clearButton;

    private JButton okButton;
    private JButton cancelButton;

    /**
     * Constructor.
     * @param frame JFrame
     * @param modal boolean
     * @param connection String
     * @param user String
     * @param password String
     **/
    @SuppressWarnings("rawtypes")
    public UnitSaleDialog(JFrame frame, boolean modal, String connection, String user, String password) {
        super(frame, "Select Product", modal);
        this.dataConnection = connection;
        this.dataPassword = password;
        this.dataUser = user;
        productID = new ArrayList <Integer>();
        uomDescription = new ArrayList <String>();
        //setTitle("Select Product");
        setBounds(100, 100, 316, 212);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("Button.background"));
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(null);
        fourButton = new JButton("4");
        fourButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        sevenButton = new JButton("7");
        sevenButton.setForeground(Color.BLACK);
        sevenButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        eightButton = new JButton("8");
        eightButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        nineButton = new JButton("9");
        nineButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        fiveButton = new JButton("5");
        fiveButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        sixButton = new JButton("6");
        sixButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        oneButton = new JButton("1");
        oneButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        twoButton = new JButton("2");
        twoButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        threeButton = new JButton("3");
        threeButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        dotButton = new JButton(".");
        dotButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        zeroButton = new JButton("0");
        zeroButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        clearButton = new JButton("x");
        clearButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_panel_1.createSequentialGroup()
                                    .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(fourButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sevenButton, Alignment.LEADING))
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(fiveButton)
                                        .addComponent(eightButton))
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(nineButton)
                                        .addComponent(sixButton)))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                    .addComponent(oneButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(twoButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(threeButton))
                                .addGroup(gl_panel_1.createSequentialGroup()
                                    .addComponent(dotButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(zeroButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(clearButton)))))
                    .addContainerGap())
        );
        gl_panel_1.setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(sevenButton)
                        .addComponent(eightButton)
                        .addComponent(nineButton))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(fourButton)
                        .addComponent(fiveButton)
                        .addComponent(sixButton))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(oneButton)
                        .addComponent(twoButton)
                        .addComponent(threeButton))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(dotButton)
                        .addComponent(zeroButton)
                        .addComponent(clearButton))
                    .addGap(59)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
            gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPanel.createSequentialGroup()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 138, Short.MAX_VALUE)
                    .addContainerGap())
        );
        gl_contentPanel.setVerticalGroup(
            gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                        .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE))
                    .addContainerGap())
        );
        
        JLabel lblProducts = new JLabel("Products");
        
        productCombo = new JComboBox();
        
        quantityLabel = new JLabel("Enter quantity in: ");
        
        quantityTextField = new JTextField();
        quantityTextField.setForeground(Color.BLACK);
        quantityTextField.setBackground(Color.WHITE);
        quantityTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
        quantityTextField.setColumns(10);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                    .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblProducts, Alignment.LEADING)
                        .addComponent(quantityLabel, Alignment.LEADING))
                    .addContainerGap(87, Short.MAX_VALUE))
                .addComponent(productCombo, 0, 147, Short.MAX_VALUE)
                .addComponent(quantityTextField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addComponent(lblProducts)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(productCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(quantityLabel)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(quantityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        contentPanel.setLayout(gl_contentPanel);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {               
                buttonPane.add(okButton);
                //getRootPane().setDefaultButton(okButton);
            }
            {
                buttonPane.add(cancelButton);
            }
        }       
        initialize();
        getItemWithUOM();
    }//end constructor

    //Getters.
    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    @SuppressWarnings("rawtypes")
    public JComboBox getProductCombo() {
        return productCombo;
    }

    public JButton getFourButton() {
        return fourButton;
    }

    public JButton getSevenButton() {
        return sevenButton;
    }

    public JButton getEightButton() {
        return eightButton;
    }

    public JButton getNineButton() {
        return nineButton;
    }

    public JButton getFiveButton() {
        return fiveButton;
    }

    public JButton getSixButton() {
        return sixButton;
    }

    public JButton getOneButton() {
        return oneButton;
    }

    public JButton getTwoButton() {
        return twoButton;
    }

    public JButton getThreeButton() {
        return threeButton;
    }

    public JButton getDotButton() {
        return dotButton;
    }

    public JButton getZeroButton() {
        return zeroButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
    
    public JButton getOkButton(){
        return okButton;
    }
    
    public JButton getCancelButton(){
        return cancelButton;
    }
    
    public boolean isDialogOk() {
        return dialogOk;
    }
    
    public double getQuantity(){
        return this.quantity;
    }
    
    public JLabel getQuantityLabel(){
        return this.quantityLabel;
    }
    
    public int getProductID(){
        return this.productID.get(getProductCombo().getSelectedIndex());
    }

    //Setters
    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public void setProductCombo(@SuppressWarnings("rawtypes") JComboBox productCombo) {
        this.productCombo = productCombo;
    }

    public void setFourButton(JButton fourButton) {
        this.fourButton = fourButton;
    }

    public void setSevenButton(JButton sevenButton) {
        this.sevenButton = sevenButton;
    }

    public void setEightButton(JButton eightButton) {
        this.eightButton = eightButton;
    }

    public void setNineButton(JButton nineButton) {
        this.nineButton = nineButton;
    }

    public void setFiveButton(JButton fiveButton) {
        this.fiveButton = fiveButton;
    }

    public void setSixButton(JButton sixButton) {
        this.sixButton = sixButton;
    }

    public void setOneButton(JButton oneButton) {
        this.oneButton = oneButton;
    }

    public void setTwoButton(JButton twoButton) {
        this.twoButton = twoButton;
    }

    public void setThreeButton(JButton threeButton) {
        this.threeButton = threeButton;
    }

    public void setDotButton(JButton dotButton) {
        this.dotButton = dotButton;
    }

    public void setZeroButton(JButton zeroButton) {
        this.zeroButton = zeroButton;
    }

    public void setClearButton(JButton backButton) {
        this.clearButton = backButton;
    }
    
    public void setOkButton(JButton okButton){
        this.okButton = okButton;
    }
    
    public void setCancelButton(JButton cancelButton){
        this.cancelButton = cancelButton;
    }
    
    public void setDialogOk(boolean dialogOk) {
        this.dialogOk = dialogOk;
    }
    
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }
    
    public void setQuantityLabel(JLabel quantityLabel){
        this.quantityLabel = quantityLabel;
    }
    
    /**
     * Initialize the event listener of the components.
     **/
    public void initialize(){       
        getSevenButton().addActionListener(this);
        getSevenButton().setActionCommand("seven");
        getSevenButton().setFocusable(false);
        
        getEightButton().addActionListener(this);
        getEightButton().setActionCommand("eight");
        getEightButton().setFocusable(false);
        
        getNineButton().addActionListener(this);
        getNineButton().setActionCommand("nine");
        getNineButton().setFocusable(false);
        
        getFourButton().addActionListener(this);
        getFourButton().setActionCommand("four");
        getFourButton().setFocusable(false);
        
        getFiveButton().addActionListener(this);
        getFiveButton().setActionCommand("five");
        getFiveButton().setFocusable(false);
        
        getSixButton().addActionListener(this);
        getSixButton().setActionCommand("six");
        getSixButton().setFocusable(false);
        
        getOneButton().addActionListener(this);
        getOneButton().setActionCommand("one");
        getOneButton().setFocusable(false);
        
        getTwoButton().addActionListener(this);
        getTwoButton().setActionCommand("two");
        getTwoButton().setFocusable(false);
        
        getThreeButton().addActionListener(this);
        getThreeButton().setActionCommand("three");
        getThreeButton().setFocusable(false);
        
        getZeroButton().addActionListener(this);
        getZeroButton().setActionCommand("zero");
        getZeroButton().setFocusable(false);
        
        getClearButton().addActionListener(this);
        getClearButton().setActionCommand("clear");
        getClearButton().setFocusable(false);
        
        getDotButton().addActionListener(this);
        getDotButton().setActionCommand("dot");
        getDotButton().setFocusable(false);
        
        getOkButton().addActionListener(this);
        getOkButton().setActionCommand("ok");
        //getOkButton().setFocusable(false);
        
        getCancelButton().addActionListener(this);
        getCancelButton().setActionCommand("cancel");
        //getCancelButton().setFocusable(false);
        
        getProductCombo().addItemListener(this);
    }//end initialize
    
    /**
     * Implemented ActionListener abstract methods.<br>Handles the events when a button is pressed.
     * @param e ActionEvent
     **/
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        try{
            Robot robot = new Robot();
            switch(command){
                case "seven":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_7);
                    robot.keyRelease(KeyEvent.VK_7);
                    break;
                case "eight":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_8);
                    robot.keyRelease(KeyEvent.VK_8);
                    break;
                case "nine":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_9);
                    robot.keyRelease(KeyEvent.VK_9);
                    break;
                case "four":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_4);
                    robot.keyRelease(KeyEvent.VK_4);
                    break;
                case "five":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    break;
                case "six":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_6);
                    robot.keyRelease(KeyEvent.VK_6);
                    break;
                case "one":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    break;
                case "two":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    break;
                case "three":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_3);
                    robot.keyRelease(KeyEvent.VK_3);
                    break;
                case "zero":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                    break;
                case "clear":
                    getQuantityTextField().requestFocusInWindow();
                    getQuantityTextField().setText("");             
                    break;  
                case "dot":
                    getQuantityTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_PERIOD);
                    robot.keyRelease(KeyEvent.VK_PERIOD);
                    break;
                case "ok":
                    /*
                     * There are no selected items in the ComboBox, or the ComboBox is empty.
                     * */
                    if(getProductCombo().getSelectedIndex() == -1){
                        JOptionPane.showMessageDialog(null, "You have pressed ok.\nNo item was selected\n" + 
                                                      "Please press cancel.",
                                                      "POS-Pi",
                                                      JOptionPane.WARNING_MESSAGE);
                        dialogOk = false;
                        this.setVisible(false);
                    }
                    else{
                        /*
                         * An item was selected in the ComboBox. Set a boolean attribute to true to
                         * indicate to the calling class that an item was selected and the ok button 
                         * was pressed.
                         * */
                        if(isValidNumber(getQuantityTextField().getText())){
                            this.quantity = Double.valueOf(getQuantityTextField().getText());
                            dialogOk = true;
                            this.setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "The quantity is not\na valid number.",
                                    "POS-Pi",
                                    JOptionPane.WARNING_MESSAGE);
                        }//end if
                    }//end if
                    break;
                case "cancel":
                    dialogOk = false;
                    this.setVisible(false);
                    break;
            }//end switch
            robot = null;
        }//end try
        catch(Exception ex){
            ex.printStackTrace();
        }//end catch
    }//end actionPerformed
    
    /**
     * Implemented ItemListener abstract methods.<br>Handles the event when an item is selected from the combobox.
     * @param e ItemEvent
     **/
    public void itemStateChanged(ItemEvent e){
        if(e.getSource() == getProductCombo()){
            //Display the appropriate unit of measurement description.
            getQuantityLabel().setText("Enter quantity in: " + uomDescription.get(getProductCombo().getSelectedIndex()));
        }//end if
    }//end itemStateChanged
    
    /**
     *  Executes a  select query on the database to fetch records that has a uom_id instead of a barcode.
     * @param selectStatement String
     * @return ResultSet
     **/
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
     * Retrieves items from the products table that has a unit of measurement.
     **/
     @SuppressWarnings("unchecked")
    public void getItemWithUOM(){
        ResultSet rs;
        String selectStatement = "SELECT products.product_id, " +
                                 "products.uom_id, " +
                                 "unit_of_measurement.description as uom_description, " + 
                                 "unit_of_measurement.uom_code as uom_code, " + 
                                 "products.description as product_description " +
                                 "FROM products LEFT JOIN unit_of_measurement " + 
                                 "ON products.uom_id = unit_of_measurement.uom_id " + 
                                 "WHERE uom_code != 'N/A'";
        try{
            rs = runSelect(selectStatement);
            //if ResultSet is not before the first result, then ResultSet is empty.
            if(! rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Sorry, there are no items to show.", 
                        "POS-Pi",
                        JOptionPane.WARNING_MESSAGE);
            }
            //ResultSet is before the first result, record/s found.
            else{               
                while(rs.next()){
                    /*
                     * Populate the ArrayLists and the ComboBox with values from the result set.
                     * */
                    productID.add(rs.getInt("product_id"));
                    uomDescription.add(rs.getString("uom_description"));
                    getProductCombo().addItem(rs.getString("product_description"));
                }//end while    
                //Display the appropriate unit of measurement description.
                getQuantityLabel().setText("Enter quantity in: " + uomDescription.get(0));
            }//end if
        }//end try
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), 
                    "Error in fetching records.",
                    JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
        }//end catch
    }//end getItemWithUOM
    
    /**
     * Test if a String value is a valid double. Return true if it is, false otherwise.
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
	
}//end class
