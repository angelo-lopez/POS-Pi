package pospi;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.text.DecimalFormat;
/**
 * Author: Angelo Romel Lopez 
 * <br>Description: <br>[1] Constructs and initializes the components and graphical user interface
 * of the cash payment custom dialog screen.<br>[2] Handle the logic and events of the cash payment custom dialog screen.
 * */

@SuppressWarnings("serial")
public class PayByCashDialog extends JDialog implements ActionListener{
    DecimalFormat format;
    private double saleAmount;
    private double paymentAmount;
    private boolean dialogOk;
    
    private final JPanel contentPanel = new JPanel();   
    private JTextField saleAmountTextField;
    private JTextField paymentTextField;
    
    private JButton fourButton;
    private JButton sevenButton;
    private JButton fiveButton;
    private JButton eightButton;
    private JButton nineButton;
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
     * @param saleAmount double
     **/
    public PayByCashDialog(JFrame frame, boolean modal, double saleAmount) {
        super(frame, "Cash Payment", modal);
        this.setSaleAmount(saleAmount);
        this.format = new DecimalFormat("###,###.00");
        
        setBounds(100, 100, 307, 201);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setBorder(null);
        
        fourButton = new JButton("4");
        fourButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        sevenButton = new JButton("7");
        sevenButton.setForeground(Color.BLACK);
        sevenButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        fiveButton = new JButton("5");
        fiveButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        eightButton = new JButton("8");
        eightButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
        nineButton = new JButton("9");
        nineButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
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
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGap(0, 138, Short.MAX_VALUE)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_panel.createSequentialGroup()
                                    .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(fourButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sevenButton, Alignment.LEADING))
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(fiveButton)
                                        .addComponent(eightButton))
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(nineButton)
                                        .addComponent(sixButton)))
                                .addGroup(gl_panel.createSequentialGroup()
                                    .addComponent(oneButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(twoButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(threeButton))
                                .addGroup(gl_panel.createSequentialGroup()
                                    .addComponent(dotButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(zeroButton)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(clearButton)))))
                    .addContainerGap())
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGap(0, 119, Short.MAX_VALUE)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(sevenButton)
                        .addComponent(eightButton)
                        .addComponent(nineButton))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(fourButton)
                        .addComponent(fiveButton)
                        .addComponent(sixButton))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(oneButton)
                        .addComponent(twoButton)
                        .addComponent(threeButton))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(dotButton)
                        .addComponent(zeroButton)
                        .addComponent(clearButton))
                    .addGap(59)
                    //.addComponent(button)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(
            gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPanel.createSequentialGroup()
                    .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
        );
        gl_contentPanel.setVerticalGroup(
            gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPanel.createSequentialGroup()
                    .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                    .addContainerGap())
        );
        
        JLabel lblNewLabel = new JLabel("Sale Amount:");
        
        saleAmountTextField = new JTextField();
        saleAmountTextField.setEditable(false);
        saleAmountTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
        saleAmountTextField.setForeground(Color.WHITE);
        saleAmountTextField.setBackground(Color.BLACK);
        saleAmountTextField.setHorizontalAlignment(SwingConstants.CENTER);
        saleAmountTextField.setText("\u00A30.00");
        saleAmountTextField.setColumns(10);
        saleAmountTextField.setText(format.format(this.saleAmount));
        
        JLabel lblNewLabel_1 = new JLabel("Payment:");
        
        paymentTextField = new JTextField();
        paymentTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
        paymentTextField.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addComponent(lblNewLabel)
                    .addContainerGap(81, Short.MAX_VALUE))
                .addComponent(saleAmountTextField, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addComponent(lblNewLabel_1)
                    .addContainerGap())
                .addComponent(paymentTextField, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        gl_panel_1.setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addComponent(lblNewLabel)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(saleAmountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblNewLabel_1)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(paymentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        contentPanel.setLayout(gl_contentPanel);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                okButton = new JButton("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                cancelButton = new JButton("Cancel");
                buttonPane.add(cancelButton);
            }
        }
        initialize();
    }//end construtor.
    
    //Getters.
    public double getSaleAmount() {
        return saleAmount;
    }



    public double getPaymentAmount() {
        return paymentAmount;
    }



    public JTextField getSaleAmountTextField() {
        return saleAmountTextField;
    }



    public JTextField getPaymentTextField() {
        return paymentTextField;
    }



    public JButton getFourButton() {
        return fourButton;
    }



    public JButton getSevenButton() {
        return sevenButton;
    }



    public JButton getFiveButton() {
        return fiveButton;
    }



    public JButton getEightButton() {
        return eightButton;
    }



    public JButton getNineButton() {
        return nineButton;
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



    public JButton getOkButton() {
        return okButton;
    }



    public JButton getCancelButton() {
        return cancelButton;
    }    

    //Setters.
    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }



    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }



    public void setSaleAmountTextField(JTextField saleAmountTextField) {
        this.saleAmountTextField = saleAmountTextField;
    }



    public void setPaymentTextField(JTextField paymentTextField) {
        this.paymentTextField = paymentTextField;
    }



    public void setFourButton(JButton fourButton) {
        this.fourButton = fourButton;
    }



    public void setSevenButton(JButton sevenButton) {
        this.sevenButton = sevenButton;
    }



    public void setFiveButton(JButton fiveButton) {
        this.fiveButton = fiveButton;
    }



    public void setEightButton(JButton eightButton) {
        this.eightButton = eightButton;
    }



    public void setNineButton(JButton nineButton) {
        this.nineButton = nineButton;
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



    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }



    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }
    
    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }
    
    public void setDialogOk(boolean dialogOk){
        this.dialogOk = dialogOk;
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
                    this.getPaymentTextField().requestFocusInWindow();                  
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_7);
                    robot.keyRelease(KeyEvent.VK_7);
                    break;
                case "eight":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_8);
                    robot.keyRelease(KeyEvent.VK_8);
                    break;
                case "nine":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_9);
                    robot.keyRelease(KeyEvent.VK_9);
                    break;
                case "four":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_4);
                    robot.keyRelease(KeyEvent.VK_4);
                    break;
                case "five":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    break;
                case "six":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_6);
                    robot.keyRelease(KeyEvent.VK_6);
                    break;
                case "one":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    break;
                case "two":
                     this.getPaymentTextField().requestFocusInWindow();
                     //Simulate a key press
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    break;
                case "three":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_3);
                    robot.keyRelease(KeyEvent.VK_3);
                    break;
                case "zero":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                    break;
                case "clear":
                    this.getPaymentTextField().requestFocusInWindow();
                    this.getPaymentTextField().setText("");
                    break;  
                case "dot":
                    this.getPaymentTextField().requestFocusInWindow();
                    //Simulate a key press
                    robot.keyPress(KeyEvent.VK_PERIOD);
                    robot.keyRelease(KeyEvent.VK_PERIOD);
                    break;
                case "ok":
                    /*
                     * Set a boolean attribute to true if the payment is valid and indicate to the calling class 
                     * to proceed to checkout.
                     * */
                    if(isValidNumber(this.getPaymentTextField().getText())){
                        this.paymentAmount = (Double.valueOf(this.getPaymentTextField().getText()));
                        if(isPaymentEnough(this.paymentAmount) == true){
                            double changeAmount = (this.paymentAmount - this.saleAmount);
                            dialogOk = true;
                            JOptionPane.showMessageDialog(null, "Cash Tendered:\n" + this.format.format(this.paymentAmount) +
                                                          "\n-----------------------\nChange:\n" + 
                                                          this.format.format(changeAmount),
                                                          "POS-Pi",
                                                          JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible(false);
                        }
                        else{//Show message if payment is less than sale amount.
                            JOptionPane.showMessageDialog(null, "Sorry. Insufficient payment amount.",
                                      "POS-Pi",
                                      JOptionPane.WARNING_MESSAGE);
                            this.paymentTextField.setText("");
                        }//end if
                    }
                    else{//Show message if payment is not in a valid number format.
                        JOptionPane.showMessageDialog(null, "Sorry. Invalid payment amount.",
                                  "POS-Pi",
                                  JOptionPane.WARNING_MESSAGE);
                        this.paymentTextField.setText("");
                    }//end if
                    break;
                case "cancel":
                    dialogOk = false;
                    JOptionPane.showMessageDialog(null, "Cash payment cancelled.",
                              "POS-Pi",
                              JOptionPane.INFORMATION_MESSAGE);
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
    
    /**
     * Returns true if payment is equal to or greater than total amount to be paid.
     * Return false otherwise.
     * @param paymentAmount double
     * @return boolean
     **/
    public boolean isPaymentEnough(double paymentAmount){
        if(paymentAmount >= this.saleAmount){
            return true;
        }
        else{
            return false;
        }//end if
    }//end isPaymentEnough
    
    /**
     * User had pressed the ok button.
     * @return boolean
     **/
    public boolean isDialogOk(){
        return this.dialogOk;
    }
	
}//end class.

