package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.State;

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
					State.ShowErrors(e, "LoginView - main");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		//System.setProperty("java.rmi.server.hostname","localhost");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Color primaryColor = Color.decode("#114B5F");
		Color buttonColor = Color.decode("#456990");
		Color secondaryColor = Color.decode("#70C1B3");

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setBounds(100, 100, 623, 533);
		frame.setBackground(secondaryColor);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 168, 254, 185, 30};
		gridBagLayout.rowHeights = new int[]{79, 58, 241, 77, 0, 16, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		panel.setBackground(primaryColor);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);

		JLabel lblNewLabel = new JLabel("Shared White Board");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 272, 54);
		panel.add(lblNewLabel);

		JPanel subPanel = new JPanel();
		GridBagConstraints gbc_subPanel = new GridBagConstraints();
		gbc_subPanel.anchor = GridBagConstraints.NORTH;
		gbc_subPanel.fill = GridBagConstraints.BOTH;
		gbc_subPanel.insets = new Insets(0, 0, 5, 5);
		gbc_subPanel.gridx = 2;
		gbc_subPanel.gridy = 2;
		frame.getContentPane().add(subPanel, gbc_subPanel);
		GridBagLayout gbl_subPanel = new GridBagLayout();
		gbl_subPanel.columnWidths = new int[]{50, 73, 146, 33, 0};
		gbl_subPanel.rowHeights = new int[]{18, 37, 37, 26, 29, 23};
		gbl_subPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_subPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		subPanel.setLayout(gbl_subPanel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		subPanel.add(lblUsername, gbc_lblUsername);

		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 240));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		subPanel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 3;
		gbc_label.gridy = 1;
		subPanel.add(label, gbc_label);

		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		subPanel.add(lblPassword, gbc_lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 240));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		subPanel.add(passwordField, gbc_passwordField);

		JLabel label_1 = new JLabel(" ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 4;
		subPanel.add(label_1, gbc_label_1);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(buttonColor);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 4;
		subPanel.add(btnLogin, gbc_btnLogin);
		btnLogin.setBackground(buttonColor);





		Color buttonHover = Color.decode("#FF1654");
		btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
									  public void mouseEntered(java.awt.event.MouseEvent evt) {
										  btnLogin.setBackground(buttonHover);
									  }

									  public void mouseExited(java.awt.event.MouseEvent evt) {
										  btnLogin.setBackground(buttonColor);
									  }

								  }
		);
		subPanel.setBackground(secondaryColor);

		JButton registerButton = new JButton("Register");
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.fill = GridBagConstraints.BOTH;
		gbc_registerButton.gridwidth = 2;
		gbc_registerButton.insets = new Insets(0, 0, 0, 5);
		gbc_registerButton.gridx = 1;
		gbc_registerButton.gridy = 5;
		subPanel.add(registerButton, gbc_registerButton);
		registerButton.setBackground(new Color(69, 105, 144));

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.fill = GridBagConstraints.BOTH;
		gbc_lblError.gridx = 2;
		gbc_lblError.gridy = 5;
		frame.getContentPane().add(lblError, gbc_lblError);


		//
		//  Event Handler
		//


		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String uname = textField.getText();
				String pwd = textField.getText();


				if(uname.equals("")) { lblError.setText("Please enter User Name"); return;}
				if(pwd.equals("") || pwd==null)   { lblError.setText("Please enter Password"); return;}

				Boolean auth =  true; //DataBase.Login(uname, pwd);

				if(auth!=null && auth)
				{
					State.Log("Authorized");
					//MainView mainView = new MainView();
					//mainView.frame.setVisible(true);
					//frame.setVisible(false);

					ModeSelect view = new ModeSelect(uname);
					view.frame.setVisible(true);
					frame.setVisible(false);
				}
				else
				{
					lblError.setText("Wrong User Name or Password");
				}

			}
		});


		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterView registerView = new RegisterView();
				registerView.frame.setVisible(true);
				frame.setVisible(false);

			}
		});
	}
}
