package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.State;
import model.db.DataBase;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(6, 6, 611, 79);
		frame.getContentPane().add(panel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(109, 200, 87, 16);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(109, 233, 87, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(225, 195, 254, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 228, 254, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(362, 266, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(109, 461, 449, 16);
		frame.getContentPane().add(lblError);
		
		
		
		//
		//  Event Handler
		//
		

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = textField.getText();
				String pwd = passwordField.getText();
				
				
				if(uname.equals("")) { lblError.setText("Please enter User Name"); return;}
				if(pwd.equals("") || pwd==null)   { lblError.setText("Please enter Password"); return;}

				Boolean auth = DataBase.Login(uname, pwd);

				if(auth!=null && auth)
				{
					State.Log("Authorized");
					MainView mainView = new MainView();
					mainView.frame.setVisible(true);
					frame.setVisible(false);
				}
				else
				{
					lblError.setText("Wrong User Name or Password");
				}
				
			}
		});
	}
}
