package pospi;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Handles the logic and events, constructs and initializes the components and graphical user interface
 * of the PosPiMenu class.
 * */


public class PosPiMenu implements ActionListener{
	private String dataConnection;
	private String dataUser;
	private String dataPassword;
	private JFrame mainFrame;
	private JButton sellButton;
	private JButton updateButton;

	/**
	 * Constructor.
	 * @param connection String
	 * @param user String
	 * @param password String
	 */
	public PosPiMenu(String connection, String user, String password) {
		this.dataConnection = connection;
		this.dataUser = user;
		this.dataPassword = password;
		initialize();
	}

	/**
	 * Initialize the components and gui of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		mainFrame.setBounds(100, 100, 282, 204);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setWrapStyleWord(true);
		textArea.setText("Press on the Update button to update product information. Press on the Sell button to start the Point of Sale application.");
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBackground(UIManager.getColor("Button.background"));
		panel_2.add(textArea, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		//sellButton = new JButton("Sell");
		sellButton = new JButton("Point of Sale");
		sellButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		sellButton.addActionListener(this);
		sellButton.setActionCommand("sell");
		panel_1.add(sellButton, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		//updateButton = new JButton("Update");
		updateButton = new JButton("Update Products");
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateButton.addActionListener(this);
		updateButton.setActionCommand("update");
		panel.add(updateButton, BorderLayout.CENTER);
		mainFrame.getContentPane().setLayout(groupLayout);		
	}//end initialize.
	
	/**
	 * Makes the frame visible.
	 */
	public void showGUI(){
		//mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		//mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}//end showGUI.
	
	/**
	 * Implemented ActionListener abstract methods.<br>Handles the events when a button is pressed.
	 * @param e ActionEvent
	 */
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		switch(command){
		case "update":
			@SuppressWarnings("unused")
			ProductController pControl = new ProductController(new ProductView(), this.dataConnection, this.dataUser, this.dataPassword);
			break;
		case "sell":
			SaleStartScreen saleStart = new SaleStartScreen(this.dataConnection, this.dataUser, this.dataPassword);
			saleStart.showGUI();
			break;
		}
	}//end actionPerformed().
	
}//end class.
