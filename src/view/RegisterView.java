package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.State;
import model.db.DataBase;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView {

    public JFrame frame;
    private JTextField textField;
    private JTextField userName;
    private JPasswordField password;
    private JPasswordField confirmPassword;

    /**
     * Launch the application.
     */

    public RegisterView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        Color primaryColor = Color.decode("#114B5F");
        Color buttonColor = Color.decode("#456990");
        Color secondaryColor = Color.decode("#70C1B3");

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(240, 255, 255));
        frame.setBounds(100, 100, 623, 533);
        frame.setBackground(secondaryColor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 168, 254, 185, 0};
        gridBagLayout.rowHeights = new int[]{79, 58, 241, 77, 16, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
        gbl_subPanel.columnWidths = new int[]{23, 105, 146, 33, 0};
        gbl_subPanel.rowHeights = new int[]{18, 30, 30, 30, 29, 30, 28, 0};
        gbl_subPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_subPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        subPanel.setLayout(gbl_subPanel);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.fill = GridBagConstraints.BOTH;
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.gridx = 1;
        gbc_lblUsername.gridy = 1;
        subPanel.add(lblUsername, gbc_lblUsername);

        userName = new JTextField();
        userName.setBackground(SystemColor.controlLtHighlight);
        GridBagConstraints gbc_userName = new GridBagConstraints();
        gbc_userName.fill = GridBagConstraints.BOTH;
        gbc_userName.insets = new Insets(0, 0, 5, 5);
        gbc_userName.gridx = 2;
        gbc_userName.gridy = 1;
        subPanel.add(userName, gbc_userName);
        userName.setColumns(10);

        textField = new JTextField();
        GridBagConstraints gbc_textField1 = new GridBagConstraints();
        gbc_textField1.insets = new Insets(0, 0, 5, 5);
        gbc_textField1.fill = GridBagConstraints.BOTH;
        gbc_textField1.gridx = 2;
        gbc_textField1.gridy = 1;
        subPanel.add(textField, gbc_textField1);
        textField.setColumns(10);

        JLabel label = new JLabel(" ");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.VERTICAL;
        gbc_label.insets = new Insets(0, 0, 5, 0);
        gbc_label.gridx = 3;
        gbc_label.gridy = 1;
        subPanel.add(label, gbc_label);

        JLabel lblPassword = new JLabel("Password");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.fill = GridBagConstraints.BOTH;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 1;
        gbc_lblPassword.gridy = 2;
        subPanel.add(lblPassword, gbc_lblPassword);

//		passwordField = new JPasswordField();
//		passwordField.setBackground(new Color(255, 250, 240));
//		GridBagConstraints gbc_passwordField = new GridBagConstraints();
//		gbc_passwordField.fill = GridBagConstraints.BOTH;
//		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
//		gbc_passwordField.gridx = 2;
//		gbc_passwordField.gridy = 2;
//		subPanel.add(passwordField, gbc_passwordField);

        password = new JPasswordField();
        GridBagConstraints gbc_password = new GridBagConstraints();
        gbc_password.insets = new Insets(0, 0, 5, 5);
        gbc_password.fill = GridBagConstraints.BOTH;
        gbc_password.gridx = 2;
        gbc_password.gridy = 2;
        subPanel.add(password, gbc_password);
        password.setColumns(10);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
        gbc_lblConfirmPassword.fill = GridBagConstraints.BOTH;
        gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblConfirmPassword.gridx = 1;
        gbc_lblConfirmPassword.gridy = 3;
        subPanel.add(lblConfirmPassword, gbc_lblConfirmPassword);

        confirmPassword = new JPasswordField();
        confirmPassword.setColumns(10);
        GridBagConstraints gbc_confirmPassword = new GridBagConstraints();
        gbc_confirmPassword.insets = new Insets(0, 0, 5, 5);
        gbc_confirmPassword.fill = GridBagConstraints.BOTH;
        gbc_confirmPassword.gridx = 2;
        gbc_confirmPassword.gridy = 3;
        subPanel.add(confirmPassword, gbc_confirmPassword);

        JLabel label_1 = new JLabel(" ");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 4;
        subPanel.add(label_1, gbc_label_1);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBackground(buttonColor);
        GridBagConstraints gbc_btnRegister = new GridBagConstraints();
        gbc_btnRegister.insets = new Insets(0, 0, 5, 5);
        gbc_btnRegister.fill = GridBagConstraints.BOTH;
        gbc_btnRegister.gridx = 2;
        gbc_btnRegister.gridy = 5;
        subPanel.add(btnRegister, gbc_btnRegister);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(69, 105, 144));
        GridBagConstraints gbc_btnLogin = new GridBagConstraints();
        gbc_btnLogin.fill = GridBagConstraints.BOTH;
        gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
        gbc_btnLogin.gridx = 2;
        gbc_btnLogin.gridy = 6;
        subPanel.add(btnLogin, gbc_btnLogin);
        Color buttonHover = Color.decode("#FF1654");

        JLabel lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        GridBagConstraints gbc_lblError = new GridBagConstraints();
        gbc_lblError.insets = new Insets(0, 0, 0, 5);
        gbc_lblError.fill = GridBagConstraints.BOTH;
        gbc_lblError.gridx = 2;
        gbc_lblError.gridy = 5;
        frame.getContentPane().add(lblError, gbc_lblError);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginView loginView = new LoginView();
                loginView.frame.setVisible(true);
                frame.setVisible(false);

            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String uname = userName.getText();
                String pwd = password.getText();
                String confirmPasswordText = confirmPassword.getText();


                if(uname.equals("")) { lblError.setText("Please enter User Name"); return;}
                if(pwd.equals("") || pwd==null)   { lblError.setText("Please enter Password"); return;}
                if(confirmPasswordText.equals("") || pwd==null)   { lblError.setText("Please enter Confirm Password"); return;}
                if(!pwd.equals(confirmPasswordText))   { lblError.setText("Confirm Password and Password dont match"); return;}

                //Boolean registered =  true;
                Boolean registered = DataBase.AddLogin(uname, pwd);

                if(registered!=null && registered)
                {
                    State.Log("Registered");
                    //MainView mainView = new MainView();
                    //mainView.frame.setVisible(true);
                    //frame.setVisible(false);
                    JOptionPane.showMessageDialog(frame, "User created succesfully!");
                    LoginView view = new LoginView();
                    view.frame.setVisible(true);
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
