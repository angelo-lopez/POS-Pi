package pospi;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Constructs and initializes the components and graphical user interface
 * of the user product maintenancer view screen.
 * */


public class ProductMaintenanceView {
	private JFrame mainFrame;
	private JTextField barCodeTextField;
	private JTextField descriptionTextField;
	private JTextField priceTextField;
	private JTextField quantityTextField;
	private JButton saveButton;
	private JButton cancelButton;
	@SuppressWarnings("rawtypes")
	private JComboBox uomCombo;
	@SuppressWarnings("rawtypes")
	private JComboBox vatCombo;

	/**
	 * Constructor.
	 */
	public ProductMaintenanceView() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 **/	
	 @SuppressWarnings("rawtypes")
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Product Info");
		mainFrame.setBounds(100, 100, 320, 233);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_1.add(saveButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_1.add(cancelButton);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{83, 189, 0};
		gbl_panel.rowHeights = new int[]{19, 19, 19, 19, 19, 19, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Barcode:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		barCodeTextField = new JTextField();
		barCodeTextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_barCodeTextField = new GridBagConstraints();
		gbc_barCodeTextField.anchor = GridBagConstraints.NORTH;
		gbc_barCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_barCodeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_barCodeTextField.gridx = 1;
		gbc_barCodeTextField.gridy = 0;
		panel.add(barCodeTextField, gbc_barCodeTextField);
		barCodeTextField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		panel.add(lblDescription, gbc_lblDescription);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_descriptionTextField = new GridBagConstraints();
		gbc_descriptionTextField.anchor = GridBagConstraints.NORTH;
		gbc_descriptionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descriptionTextField.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionTextField.gridx = 1;
		gbc_descriptionTextField.gridy = 1;
		panel.add(descriptionTextField, gbc_descriptionTextField);
		descriptionTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_priceTextField = new GridBagConstraints();
		gbc_priceTextField.anchor = GridBagConstraints.NORTH;
		gbc_priceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceTextField.insets = new Insets(0, 0, 5, 0);
		gbc_priceTextField.gridx = 1;
		gbc_priceTextField.gridy = 2;
		panel.add(priceTextField, gbc_priceTextField);
		priceTextField.setColumns(10);
		
		JLabel lblUom = new JLabel("UOM:");
		lblUom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblUom = new GridBagConstraints();
		gbc_lblUom.anchor = GridBagConstraints.EAST;
		gbc_lblUom.insets = new Insets(0, 0, 5, 5);
		gbc_lblUom.gridx = 0;
		gbc_lblUom.gridy = 3;
		panel.add(lblUom, gbc_lblUom);
		
		uomCombo = new JComboBox();
		uomCombo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_uomCombo = new GridBagConstraints();
		gbc_uomCombo.anchor = GridBagConstraints.NORTH;
		gbc_uomCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_uomCombo.insets = new Insets(0, 0, 5, 0);
		gbc_uomCombo.gridx = 1;
		gbc_uomCombo.gridy = 3;
		panel.add(uomCombo, gbc_uomCombo);
		
		JLabel lblVat = new JLabel("VAT:");
		lblVat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblVat = new GridBagConstraints();
		gbc_lblVat.anchor = GridBagConstraints.EAST;
		gbc_lblVat.insets = new Insets(0, 0, 5, 5);
		gbc_lblVat.gridx = 0;
		gbc_lblVat.gridy = 4;
		panel.add(lblVat, gbc_lblVat);
		
		vatCombo = new JComboBox();
		vatCombo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_vatCombo = new GridBagConstraints();
		gbc_vatCombo.anchor = GridBagConstraints.NORTH;
		gbc_vatCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_vatCombo.insets = new Insets(0, 0, 5, 0);
		gbc_vatCombo.gridx = 1;
		gbc_vatCombo.gridy = 4;
		panel.add(vatCombo, gbc_vatCombo);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity in Stock:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		quantityTextField = new JTextField();
		quantityTextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_quantityTextField = new GridBagConstraints();
		gbc_quantityTextField.anchor = GridBagConstraints.NORTH;
		gbc_quantityTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_quantityTextField.gridx = 1;
		gbc_quantityTextField.gridy = 5;
		panel.add(quantityTextField, gbc_quantityTextField);
		quantityTextField.setColumns(10);
		mainFrame.getContentPane().setLayout(groupLayout);
	}

	//Getters.
	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JTextField getBarCodeTextField() {
		return barCodeTextField;
	}

	public JTextField getDescriptionTextField() {
		return descriptionTextField;
	}

	public JTextField getPriceTextField() {
		return priceTextField;
	}

	public JTextField getQuantityTextField() {
		return quantityTextField;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getUomCombo() {
		return uomCombo;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getVatCombo() {
		return vatCombo;
	}

	//Setters.
	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setBarCodeTextField(JTextField barCodeTextField) {
		this.barCodeTextField = barCodeTextField;
	}

	public void setDescriptionTextField(JTextField descriptionTextField) {
		this.descriptionTextField = descriptionTextField;
	}

	public void setPriceTextField(JTextField priceTextField) {
		this.priceTextField = priceTextField;
	}

	public void setQuantityTextField(JTextField quantityTextField) {
		this.quantityTextField = quantityTextField;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	@SuppressWarnings("rawtypes")
	public void setUomCombo(JComboBox uomCombo) {
		this.uomCombo = uomCombo;
	}

	@SuppressWarnings("rawtypes")
	public void setVatCombo(JComboBox vatCombo) {
		this.vatCombo = vatCombo;
	}
	
	/**
	 * Make the frame visible.
	 **/
	public void showGUI(){
		this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mainFrame.pack();
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		this.mainFrame.setVisible(true);
	}//end showGUI().
	
}
