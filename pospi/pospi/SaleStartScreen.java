package pospi;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Handles the logic and events, constructs and initializes the components and graphical user interface
 * of the SaleStartScreen class.
 * */

public class SaleStartScreen implements ActionListener{
	private String dataConnection;
	private String dataUser;
	private String dataPassword;
	
	
	private JFrame mainFrame;
	private JButton startSaleButton;	

	/**
	 * Constructor.
	 * @param connection String
	 * @param user String
	 * @param password String
	 */
	public SaleStartScreen(String connection, String user, String password){
		this.dataConnection = connection;
		this.dataUser = user;
		this.dataPassword = password;
		initialize();
	}//end SaleStartScreen.

	/**
	 * Initialize the gui components of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("POS-Pi");
		mainFrame.setBounds(100, 100, 320, 240);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		startSaleButton = new JButton("Tap Screen To Start Sale");
		startSaleButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		startSaleButton.addActionListener(this);
		startSaleButton.setActionCommand("start sale");
		mainFrame.getContentPane().add(startSaleButton, BorderLayout.CENTER);
		mainFrame.getRootPane().setDefaultButton(startSaleButton);
	}//end initialize().
	
	/**
	 * Implemented ActionListener abstract methods.<br>Handles the events when a button is pressed.
	 * @param e ActionEvent
	 */
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if(command == "start sale"){	
			@SuppressWarnings("unused")
			PointOfSaleController posControl = new PointOfSaleController(new PointOfSaleView(), this.dataConnection,
																		this.dataUser, this.dataPassword);
		}//end if
	}//end actionPerformed();
	
	/**
	 * Makes the frame visible.
	 */
	public void showGUI(){
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);;		
		mainFrame.setVisible(true);
		mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}//end showGUI

	//Getters.
	public String getDataConnection() {
		return dataConnection;
	}

	public String getDataUser() {
		return dataUser;
	}

	public String getDataPassword() {
		return dataPassword;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JButton getStartSaleButton() {
		return startSaleButton;
	}

	//Setters.
	public void setDataConnection(String dataConnection) {
		this.dataConnection = dataConnection;
	}

	public void setDataUser(String dataUser) {
		this.dataUser = dataUser;
	}

	public void setDataPassword(String dataPassword) {
		this.dataPassword = dataPassword;
	}

	public void setMainFrame(JFrame frmPospi) {
		this.mainFrame = frmPospi;
	}

	public void setStartSaleButton(JButton startSaleButton) {
		this.startSaleButton = startSaleButton;
	}	

}//end class
