package pospi;
import java.util.*;
import java.text.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Author: Angelo Romel Lopez
 * <br>Description: Constructs and initializes the components and graphical user interface
 * of the pos-pi sales screen
 * */

public class PointOfSaleView {
	//gui components declaration.
	private JFrame mainFrame;
	
	private JTextField barcodeTextField;
	private JTextField totalTextField;
	private JTextArea itemDisplayTextArea;
	private JScrollPane scrollPane;

	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton xButton;
	private JButton zeroButton;
	private JButton enterBarcodeButton;
	
	private JButton cashButton;
	private JButton cardButton;
	private JButton cancelSaleButton;
	private JButton cancelItemButton;
	private JButton otherItemButton;
	
	/**
	 * Constructor.
	 */
	public PointOfSaleView() {
		initialize();
	}//end constructor
	
	/*
	 * Getters.
	 * */
	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JTextField getBarcodeTextField() {
		return barcodeTextField;
	}

	public JTextField getTotalTextField() {
		return totalTextField;
	}

	public JTextArea getItemDisplayTextArea() {
		return itemDisplayTextArea;
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

	public JButton getFourButton() {
		return fourButton;
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

	public JButton getxButton() {
		return xButton;
	}

	public JButton getZeroButton() {
		return zeroButton;
	}

	public JButton getEnterBarcodeButton() {
		return enterBarcodeButton;
	}

	public JButton getCashButton() {
		return cashButton;
	}

	public JButton getCardButton() {
		return cardButton;
	}

	public JButton getCancelSaleButton() {
		return cancelSaleButton;
	}

	public JButton getCancelItemButton() {
		return cancelItemButton;
	}

	public JButton getOtherItemButton() {
		return otherItemButton;
	}
	
	public JScrollPane getScrollPane(){
			return scrollPane;
	}

	/*
	 * Setters.
	 * */
	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setBarcodeTextField(JTextField barcodeTextField) {
		this.barcodeTextField = barcodeTextField;
	}

	public void setTotalTextField(JTextField totalTextField) {
		this.totalTextField = totalTextField;
	}

	public void setItemDisplayTextArea(JTextArea itemDisplayTextArea) {
		this.itemDisplayTextArea = itemDisplayTextArea;
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

	public void setFourButton(JButton fourButton) {
		this.fourButton = fourButton;
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

	public void setxButton(JButton xButton) {
		this.xButton = xButton;
	}

	public void setZeroButton(JButton zeroButton) {
		this.zeroButton = zeroButton;
	}

	public void setEnterBarcodeButton(JButton backSpaceButton) {
		this.enterBarcodeButton = backSpaceButton;
	}

	public void setCashButton(JButton cashButton) {
		this.cashButton = cashButton;
	}

	public void setCardButton(JButton cardButton) {
		this.cardButton = cardButton;
	}

	public void setCancelSaleButton(JButton cancelSaleButton) {
		this.cancelSaleButton = cancelSaleButton;
	}

	public void setCancelItemButton(JButton cancelItemButton) {
		this.cancelItemButton = cancelItemButton;
	}

	public void setOtherItemButton(JButton otherItemButton) {
		this.otherItemButton = otherItemButton;
	}
	
	public void setScrollPane(JScrollPane scrollPane){
		this.scrollPane = scrollPane;
	}

	/**
	 * Initialize the gui components of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setForeground(Color.BLACK);
		mainFrame.setBounds(50, 50, 320, 240);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		totalTextField = new JTextField();
		totalTextField.setForeground(Color.WHITE);
		totalTextField.setBackground(Color.BLACK);
		totalTextField.setHorizontalAlignment(SwingConstants.CENTER);
		totalTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalTextField.setColumns(10);
		totalTextField.setText("0.00");
		totalTextField.setFocusable(false);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		scrollPane = new JScrollPane();
		
		sevenButton = new JButton("7");
		sevenButton.setForeground(Color.BLACK);
		sevenButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sevenButton.setFocusable(false);
		
		eightButton = new JButton("8");
		eightButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		eightButton.setFocusable(false);
		
		nineButton = new JButton("9");
		nineButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nineButton.setFocusable(false);
		
		fourButton = new JButton("4");
		fourButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fourButton.setFocusable(false);
		
		barcodeTextField = new JTextField();
		barcodeTextField.setColumns(10);
		
		fiveButton = new JButton("5");
		fiveButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fiveButton.setFocusable(false);
		
		sixButton = new JButton("6");
		sixButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sixButton.setFocusable(false);
		
		oneButton = new JButton("1");
		oneButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		oneButton.setFocusable(false);
		
		twoButton = new JButton("2");
		twoButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		twoButton.setFocusable(false);
		
		threeButton = new JButton("3");
		threeButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		threeButton.setFocusable(false);
		
		xButton = new JButton("x");
		xButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		xButton.setFocusable(false);
		
		zeroButton = new JButton("0");
		zeroButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		zeroButton.setFocusable(false);
		
		enterBarcodeButton = new JButton("<");
		enterBarcodeButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		enterBarcodeButton.setFocusable(false);
		
		cashButton = new JButton("cash");
		cashButton.setForeground(Color.BLACK);
		cashButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cashButton.setFocusable(false);
		
		cardButton = new JButton("card");
		cardButton.setForeground(Color.BLACK);
		cardButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cardButton.setFocusable(false);
		
		cancelSaleButton = new JButton("cancel sale");
		cancelSaleButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cancelSaleButton.setFocusable(false);
		
		/*
		 * Layout the components using the GroupLayout manager.
		 * */
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(barcodeTextField, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(fourButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(sevenButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(eightButton)
									.addGap(5)
									.addComponent(nineButton))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(fiveButton)
									.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
									.addComponent(sixButton))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(oneButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(twoButton)
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
							.addComponent(threeButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(xButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(zeroButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(enterBarcodeButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cashButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cardButton, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
						.addComponent(cancelSaleButton, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(barcodeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(sevenButton)
						.addComponent(nineButton)
						.addComponent(eightButton))
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
						.addComponent(xButton)
						.addComponent(zeroButton)
						.addComponent(enterBarcodeButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cashButton)
						.addComponent(cardButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cancelSaleButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		cancelItemButton = new JButton("cancel (i)");
		cancelItemButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cancelItemButton.setFocusable(false);
		
		otherItemButton = new JButton("other (i)");
		otherItemButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		otherItemButton.setFocusable(false);
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTotal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(totalTextField, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cancelItemButton)
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addComponent(otherItemButton)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotal))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cancelItemButton)
								.addComponent(otherItemButton))
							.addContainerGap())))
		);
		
		itemDisplayTextArea = new JTextArea();
		itemDisplayTextArea.setWrapStyleWord(true);
		itemDisplayTextArea.setLineWrap(true);
		itemDisplayTextArea.setEditable(false);
		itemDisplayTextArea.setFocusable(false);
		scrollPane.setViewportView(itemDisplayTextArea);
		mainFrame.getContentPane().setLayout(groupLayout);
	}//end initialize()
	
	/**
	 * Makes the frame visible.
	 **/
	public void showGUI(){
		Date currentDate = new Date();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.setTitle("Sale Date: " + getFormattedDate(currentDate));
		mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}//end showGUI
	
	/**
	 * Returns the formatted date as a String using the MM-DD-YYYY format.
	 * @param date Date
	 * @return String
	 **/
	public String getFormattedDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(date);
	}//		
	
}//end class
