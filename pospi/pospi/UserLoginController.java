package pospi;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * Author: Angelo Romel Lopez
 * <br>Description: Handles the logic and events of the UserLoginView class.
 * */

public class UserLoginController implements ActionListener{
	private UserLoginView loginView;
	private String dataConnection;
	private String dataUser;
	private String dataPassword;
	/**
	 * Constructor.
	 * @param loginView UserLoginView
	 * @param connection String
	 * @param user String
	 * @param password String
	 * */
	public UserLoginController(UserLoginView loginView, String connection, String user, String password){
		this.loginView = loginView;
		this.dataConnection = connection;
		this.dataUser = user;
		this.dataPassword = password;
		initialize();
		this.loginView.showGUI();
	}
	
	//Getters.
	public UserLoginView getLoginView() {
		return loginView;
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
	public void setLoginView(UserLoginView loginView) {
		this.loginView = loginView;
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
		this.loginView.getLoginButton().addActionListener(this);
		this.loginView.getLoginButton().setActionCommand("login");
	}//end initialize().
	
	/**
	 * Implemented ActionListener abstract methods.<br>Handles the events when a button is pressed.
	 * @param e ActionEvent
	 */
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if(command == "login"){
			if(isUserValid(loginView.getUserNameTextField().getText(),
						   loginView.getUserPasswordField().getPassword())){
				PosPiMenu posMenu = new PosPiMenu(this.dataConnection, this.dataUser, this.dataPassword);
				posMenu.showGUI();
				this.loginView.getMainFrame().dispose();
			}
		}//end if
	}//end actionPerformed().
	
	/**
	 * Checks the database if username and password is valid.
	 * @param userName String
	 * @param password char[]
	 * @return boolean
	 */
	public boolean isUserValid(String userName, char[] password){
		Connection dbConnection = null;
		PreparedStatement selectStatement = null;	
		ResultSet rs = null;
		try{
			dbConnection = DriverManager.getConnection(dataConnection, dataUser, dataPassword);
			selectStatement = dbConnection.prepareStatement("SELECT password FROM users WHERE user_name = ?");
			selectStatement.setString(1, userName);
			rs = selectStatement.executeQuery();			
			if(rs.next()){
				if(Arrays.equals(password, rs.getString("password").toCharArray())){
					return true;
				}
				else{
					JOptionPane.showMessageDialog(null, "Sorry, incorrect password.", 
							"Invalid password.",
							JOptionPane.WARNING_MESSAGE);
					return false;
				}//end if
			}
			else{
				JOptionPane.showMessageDialog(null, "Sorry, the username is not recognised.", 
						"Invalid username.",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}//end if
		}//end try
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null, sqlEx.toString(), 
					"Error in connecting to database.",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}//end catch
		catch(Exception eEx){
			JOptionPane.showMessageDialog(null, eEx.toString(),
					"Error in connecting to database",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}//end catch
		finally{
			dbConnection = null;
			selectStatement = null;
			rs = null;
		}//end finally
	}//end isUserValid()
	
}//end class
