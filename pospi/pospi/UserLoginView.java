package pospi;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.util.Date;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Constructs and initializes the components and graphical user interface
 * of the user login screen.
 **/

@SuppressWarnings("unused")
public class UserLoginView {

	private JFrame mainFrame;
	private JTextField userNameTextField;
	private JPasswordField userPasswordField;
	private JButton loginButton;

	/**
	 * Constructor.
	 */
	public UserLoginView() {
		initialize();
	}

	/**
	 * Initialize the gui components of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 291, 171);		
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		mainFrame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		loginButton = new JButton("Login");
		panel.add(loginButton);
		
		JPanel panel_1 = new JPanel();
		mainFrame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		userPasswordField = new JPasswordField();
		
		JLabel titleLabel = new JLabel("POS-Pi");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setOpaque(true);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userPasswordField))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
				.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		mainFrame.getRootPane().setDefaultButton(loginButton);
	}//end initialize().
	
	//Getters.	
	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JTextField getUserNameTextField() {
		return userNameTextField;
	}

	public JPasswordField getUserPasswordField() {
		return userPasswordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	//Setters.
	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setUserNameTextField(JTextField userNameTextField) {
		this.userNameTextField = userNameTextField;
	}

	public void setUserPasswordField(JPasswordField userPasswordField) {
		this.userPasswordField = userPasswordField;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	/**
	 * Makes the frame visible.
	 */
	public void showGUI(){
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
	}//end showGUI
	
}//end class.
