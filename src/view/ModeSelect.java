package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.awt.event.ActionEvent;

public class ModeSelect {

	public JFrame frame;
	private JTextField txtCreatePort;
	private JTextField txtJoinPort;
	private JTextField txtIP;
	public String uname;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public ModeSelect(String uname) {
		this.uname = uname;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(158, 69, 358, 423);
		frame.getContentPane().add(tabbedPane);
		
		JPanel pnlCreateMaster = new JPanel();
		tabbedPane.addTab("Create Master", null, pnlCreateMaster, null);
		pnlCreateMaster.setLayout(null);
		
		JLabel lblPortNumber = new JLabel("Port Number");
		lblPortNumber.setBounds(16, 70, 94, 16);
		pnlCreateMaster.add(lblPortNumber);
		
		txtCreatePort = new JTextField();
		txtCreatePort.setText("12345");
		txtCreatePort.setBounds(112, 65, 169, 26);
		pnlCreateMaster.add(txtCreatePort);
		txtCreatePort.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(112, 248, 117, 29);
		pnlCreateMaster.add(btnCreate);
		
		JPanel pnlJoinMaster = new JPanel();
		tabbedPane.addTab("Join Master", null, pnlJoinMaster, null);
		pnlJoinMaster.setLayout(null);
		
		JLabel label = new JLabel("Port Number");
		label.setBounds(26, 98, 94, 16);
		pnlJoinMaster.add(label);
		
		txtJoinPort = new JTextField();
		txtJoinPort.setText("12345");
		txtJoinPort.setColumns(10);
		txtJoinPort.setBounds(122, 93, 169, 26);
		pnlJoinMaster.add(txtJoinPort);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.setBounds(122, 261, 117, 29);
		pnlJoinMaster.add(btnJoin);
		
		JLabel lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setBounds(26, 65, 94, 16);
		pnlJoinMaster.add(lblIpAddress);
		
		txtIP = new JTextField();
		txtIP.setText("localhost");
		txtIP.setColumns(10);
		txtIP.setBounds(122, 60, 169, 26);
		pnlJoinMaster.add(txtIP);
		
		
		
		//
		// Event Handler
		//
		
		//
		// Master Create Button
		//
		btnCreate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String port = txtCreatePort.getText();
				String connectionStatus = "1";
				String ConnectionLevel = "master";
				String hostID = "localHost";
				
				MainViewMaster masterView;
				try {
					masterView = new MainViewMaster();
					masterView.frame.setVisible(true);
					frame.setVisible(false);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		//
		// Client Join Button
		//
		btnJoin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String ip = txtIP.getText();
				String port = txtJoinPort.getText();
				
				MainViewClient clientView;
				try {
					clientView = new MainViewClient(ip,port);
					clientView.frame.setVisible(true);
					frame.setVisible(false);
				} catch (MalformedURLException | AlreadyBoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
}
