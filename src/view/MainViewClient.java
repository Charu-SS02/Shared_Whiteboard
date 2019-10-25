package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ColorSelector;
import controller.Message;
import controller.SaveLoad;
import controller.State;
import controller.Tool;
import controller.UndoRedo; 
import model.client.ClientDraw;
import model.remote.IRemoteDraw;
import model.remote.IRemoteDrawClient;
import model.remote.IRemoteDrawServer;

public class MainViewClient {

	public JFrame frame;
	DrawPanel drawPanel = new DrawPanel();
	ChatPanel chatPanel = new ChatPanel();
	SaveLoad saveload = new SaveLoad();

	String ip;
	String port;
	String uname = "Unknow Client";
	private GridBagConstraints gbc_chatPanel;
	int maxMessages = 10;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// MainView window = new MainView();
					// window.frame.setVisible(true);

					LoginView login = new LoginView();
					login.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// TODO ip addr and port no. to RMI

	/**
	 * @wbp.parser.entryPoint
	 */
	public MainViewClient(String ip, String port, String uname) throws MalformedURLException, AlreadyBoundException {
		
		drawPanel.n = "Client"; 
		
		initialize();
		this.ip = ip;
		this.port = port;
		this.uname = uname;
		try {
			ClientDraw clientDraw = new ClientDraw(drawPanel,chatPanel, ip, port,uname);
			//ClientChat clientChat = new ClientChat(chatPanel, ip, port);
		} catch (NotBoundException e) {
			State.ShowErrors(e, "MainViewClient - constructor");
		}
	}

	private void initialize() {
		State.Initialize();

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 828, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 157, 461, 163 };
		gridBagLayout.rowHeights = new int[] { 96, 567, 80, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel titlePanel = new JPanel();
		Color myColor = Color.decode("#114B5F");
		Color buttonColor = Color.decode("#456990");

		titlePanel.setBackground(myColor);
		titlePanel.setLayout(null);

		GridBagConstraints gbc_titlePanel = new GridBagConstraints();
		gbc_titlePanel.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel.gridwidth = 3;
		gbc_titlePanel.fill = GridBagConstraints.BOTH;
		gbc_titlePanel.gridx = 0;
		gbc_titlePanel.gridy = 0;
		frame.getContentPane().add(titlePanel, gbc_titlePanel);

		JLabel lblShareWhiteBoard = new JLabel("Shared White Board");
		lblShareWhiteBoard.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblShareWhiteBoard.setForeground(new Color(255, 255, 255));
		lblShareWhiteBoard.setBounds(10, 10, 228, 41);
		lblShareWhiteBoard.setVerticalAlignment(SwingConstants.BOTTOM);
		titlePanel.add(lblShareWhiteBoard);

		JPanel leftPanel = new JPanel();
		Color myColorLeftPanel = Color.decode("#028090");

		leftPanel.setBackground(myColorLeftPanel);
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.insets = new Insets(0, 0, 5, 5);
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 1;
		frame.getContentPane().add(leftPanel, gbc_leftPanel);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[] { 13, 71, 65, 10, 0 };
		gbl_leftPanel.rowHeights = new int[] { 0, 39, 39, 39, 16, 29, 29, 134, 39, 52, 39, 0 };
		gbl_leftPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_leftPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		leftPanel.setLayout(gbl_leftPanel);

		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		leftPanel.add(label, gbc_label);

		JButton btnPencil = new JButton("Pencil");
		btnPencil.setBorderPainted(false);
		btnPencil.setOpaque(true);
		btnPencil.setBackground(buttonColor);
		btnPencil.setForeground(Color.white);
		GridBagConstraints gbc_btnPencil = new GridBagConstraints();
		gbc_btnPencil.fill = GridBagConstraints.BOTH;
		gbc_btnPencil.insets = new Insets(0, 0, 5, 5);
		gbc_btnPencil.gridwidth = 2;
		gbc_btnPencil.gridx = 1;
		gbc_btnPencil.gridy = 1;
		leftPanel.add(btnPencil, gbc_btnPencil);

		JLabel label_1 = new JLabel(" ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 1;
		leftPanel.add(label_1, gbc_label_1);

		JButton btnCircle = new JButton("Circle");
		btnCircle.setBorderPainted(false);
		btnCircle.setOpaque(true);
		btnCircle.setBackground(buttonColor);
		btnCircle.setForeground(Color.white);
		GridBagConstraints gbc_btnCircle = new GridBagConstraints();
		gbc_btnCircle.fill = GridBagConstraints.BOTH;
		gbc_btnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCircle.gridx = 1;
		gbc_btnCircle.gridy = 2;
		leftPanel.add(btnCircle, gbc_btnCircle);

		JButton btnOval = new JButton("Oval");
		btnOval.setBorderPainted(false);
		btnOval.setOpaque(true);
		btnOval.setBackground(buttonColor);
		btnOval.setForeground(Color.white);
		GridBagConstraints gbc_btnOval = new GridBagConstraints();
		gbc_btnOval.fill = GridBagConstraints.BOTH;
		gbc_btnOval.insets = new Insets(0, 0, 5, 5);
		gbc_btnOval.gridx = 2;
		gbc_btnOval.gridy = 2;
		leftPanel.add(btnOval, gbc_btnOval);

		JButton btnLine = new JButton("Line");
		btnLine.setBorderPainted(false);
		btnLine.setOpaque(true);
		btnLine.setBackground(buttonColor);
		btnLine.setForeground(Color.white);
		GridBagConstraints gbc_btnLine = new GridBagConstraints();
		gbc_btnLine.fill = GridBagConstraints.BOTH;
		gbc_btnLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnLine.gridx = 1;
		gbc_btnLine.gridy = 3;
		leftPanel.add(btnLine, gbc_btnLine);

		JButton btnRectangle = new JButton("Rect");
		btnRectangle.setBorderPainted(false);
		btnRectangle.setOpaque(true);
		btnRectangle.setBackground(buttonColor);
		btnRectangle.setForeground(Color.white);
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRectangle.gridx = 2;
		gbc_btnRectangle.gridy = 3;
		leftPanel.add(btnRectangle, gbc_btnRectangle);

		JLabel lblStrokeSize = new JLabel("Stroke Size: 2");
		GridBagConstraints gbc_lblStrokeSize = new GridBagConstraints();
		gbc_lblStrokeSize.fill = GridBagConstraints.BOTH;
		gbc_lblStrokeSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrokeSize.gridwidth = 2;
		gbc_lblStrokeSize.gridx = 1;
		gbc_lblStrokeSize.gridy = 4;
		leftPanel.add(lblStrokeSize, gbc_lblStrokeSize);

		JSlider sldStrokeSize = new JSlider();
		sldStrokeSize.setValue(2);
		sldStrokeSize.setMinorTickSpacing(1);
		sldStrokeSize.setMaximum(20);
		sldStrokeSize.setMinimum(1);
		GridBagConstraints gbc_sldStrokeSize = new GridBagConstraints();
		gbc_sldStrokeSize.fill = GridBagConstraints.BOTH;
		gbc_sldStrokeSize.insets = new Insets(0, 0, 5, 5);
		gbc_sldStrokeSize.gridwidth = 2;
		gbc_sldStrokeSize.gridx = 1;
		gbc_sldStrokeSize.gridy = 5;
		leftPanel.add(sldStrokeSize, gbc_sldStrokeSize);

		JLabel lblColor = new JLabel("Color");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.NORTH;
		gbc_lblColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 1;
		gbc_lblColor.gridy = 6;
		leftPanel.add(lblColor, gbc_lblColor);

		JPanel pnlColorView = new JPanel();
		pnlColorView.setBackground(Color.BLACK);
		GridBagConstraints gbc_pnlColorView = new GridBagConstraints();
		gbc_pnlColorView.fill = GridBagConstraints.BOTH;
		gbc_pnlColorView.insets = new Insets(0, 0, 5, 5);
		gbc_pnlColorView.gridx = 2;
		gbc_pnlColorView.gridy = 6;
		leftPanel.add(pnlColorView, gbc_pnlColorView);

		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(myColorLeftPanel);
		colorPanel.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 7;
		leftPanel.add(colorPanel, gbc_panel_1);

		ColorSelector colorWheel = new ColorSelector();
		colorWheel.setBounds(0, 0, 125, 143);
		colorPanel.add(colorWheel);
		colorWheel.LoadImage();

		JButton btnUndo = new JButton("Undo");
		btnUndo.setBorderPainted(false);
		btnUndo.setOpaque(true);
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		btnUndo.setBackground(buttonColor);
		btnUndo.setForeground(Color.white);
		gbc_btnUndo.fill = GridBagConstraints.BOTH;
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 1;
		gbc_btnUndo.gridy = 8;
		leftPanel.add(btnUndo, gbc_btnUndo);

		JButton btnRedo = new JButton("Redo");
		btnRedo.setBorderPainted(false);
		btnRedo.setOpaque(true);
		btnRedo.setBackground(buttonColor);
		btnRedo.setForeground(Color.white);
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.fill = GridBagConstraints.BOTH;
		gbc_btnRedo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRedo.gridx = 2;
		gbc_btnRedo.gridy = 8;
		leftPanel.add(btnRedo, gbc_btnRedo);

		JButton btnEraser = new JButton("Eraser");
		btnEraser.setBorderPainted(false);
		btnEraser.setOpaque(true);
		btnEraser.setBackground(buttonColor);
		btnEraser.setForeground(Color.white);
		GridBagConstraints gbc_btnEraser = new GridBagConstraints();
		gbc_btnEraser.insets = new Insets(0, 0, 5, 5);
		gbc_btnEraser.fill = GridBagConstraints.BOTH;
		gbc_btnEraser.gridwidth = 2;
		gbc_btnEraser.gridx = 1;
		gbc_btnEraser.gridy = 9;
		leftPanel.add(btnEraser, gbc_btnEraser);
		
		JButton btnSync = new JButton("Sync");
		GridBagConstraints gbc_btnSync = new GridBagConstraints();
		gbc_btnSync.insets = new Insets(0, 0, 0, 5);
		gbc_btnSync.gridx = 1;
		gbc_btnSync.gridy = 10;
		leftPanel.add(btnSync, gbc_btnSync);
		
		JButton btnReqSync = new JButton("Req Sync");
		GridBagConstraints gbc_btnReqSync = new GridBagConstraints();
		gbc_btnReqSync.insets = new Insets(0, 0, 0, 5);
		gbc_btnReqSync.gridx = 2;
		gbc_btnReqSync.gridy = 10;
		leftPanel.add(btnReqSync, gbc_btnReqSync);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(myColorLeftPanel);
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.insets = new Insets(0, 0, 5, 0);
		gbc_rightPanel.fill = GridBagConstraints.BOTH;
		gbc_rightPanel.gridx = 2;
		gbc_rightPanel.gridy = 1;
		frame.getContentPane().add(rightPanel, gbc_rightPanel);
		gbc_panel.gridy = 0;
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[] { 157, 0 };
		gbl_rightPanel.rowHeights = new int[] { 23, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_rightPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_rightPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		rightPanel.setLayout(gbl_rightPanel);
		GridBagLayout gbl_chatPanel = new GridBagLayout();
		gbl_chatPanel.columnWidths = new int[] { 170, 0 };
		gbl_chatPanel.rowHeights = new int[] { 29, 0 };
		gbl_chatPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_chatPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_chatPanel);
		drawPanel.setBounds(-33, 0, 575, 561);
		GridBagConstraints gbc_drawPanel = new GridBagConstraints();
		gbc_drawPanel.fill = GridBagConstraints.BOTH;
		gbc_drawPanel.gridx = 0;
		gbc_drawPanel.gridheight = 4;
		gbc_drawPanel.gridy = 0;
		panel.add(drawPanel, gbc_drawPanel);
		drawPanel.width = 1200;
		drawPanel.height = 1200;

		drawPanel.setBackground(Color.WHITE);
		drawPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		drawPanel.Initialize(drawPanel.getHeight(), drawPanel.getWidth());

		// --------------------------------------------
		// Event Handlers
		// --------------------------------------------

		// Mouse Press / Released
		drawPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MousePressed(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				MouseReleased(e);
			}
		});

		// Mouse Dragged
		drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				MouseDragged(e);
			}
		});
		GridBagConstraints gbc_chatPanel = new GridBagConstraints();
		gbc_chatPanel.anchor = GridBagConstraints.NORTH;
		gbc_chatPanel.gridy = 0;
		gbc_chatPanel.insets = new Insets(0, 0, 5, 0);
		gbc_chatPanel.fill = GridBagConstraints.BOTH;
		gbc_chatPanel.gridx = 0;
		GridBagConstraints gbc_panel_4_1 = new GridBagConstraints();
		gbc_panel_4_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_4_1.fill = GridBagConstraints.BOTH;
		gbc_panel_4_1.gridx = 0;
		gbc_panel_4_1.gridy = 1;

		GridBagConstraints gbc_panel_11;
		gbc_chatPanel = new GridBagConstraints();
		gbc_chatPanel.gridheight = 11;
		gbc_chatPanel.insets = new Insets(0, 0, 5, 0);
		gbc_chatPanel.fill = GridBagConstraints.BOTH;
		gbc_chatPanel.gridx = 0;
		gbc_chatPanel.gridy = 0;
		rightPanel.add(chatPanel, gbc_chatPanel);
		GridBagLayout gbl_chatPanel1 = new GridBagLayout();
		gbl_chatPanel1.columnWidths = new int[] { 46, 0 };
		gbl_chatPanel1.rowHeights = new int[] { 39, 34, 44, 46, 40, 42, 44, 31, 0 };
		gbl_chatPanel1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_chatPanel1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		chatPanel.setLayout(gbl_chatPanel1);

		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		chatPanel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		chatPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel label_3 = new JLabel("New label");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 2;
		chatPanel.add(label_3, gbc_label_3);

		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		chatPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		chatPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		chatPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		chatPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		chatPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_21.gridx = 0;
		gbc_lblNewLabel_21.gridy = 0;

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 11;
		rightPanel.add(panel_2, gbc_panel_2);

		JTextField msgTextField = new JTextField("hello world");
		panel_2.add(msgTextField);
		msgTextField.setBounds(0, 0, 150, 26);
		// panel_3.add(msgTextField);
		msgTextField.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get message in textfield and send to RMI server
				String str = msgTextField.getText();
				Message msg = new Message(uname, str);

				addMessage(msg, true);
			}
		});
		btnSend.setBounds(75, 38, 75, 29);
		panel_2.add(btnSend);
		btnSend.setHorizontalAlignment(SwingConstants.RIGHT);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);

		JMenuItem mntmLoad = new JMenuItem("Load");
		mnFile.add(mntmLoad);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);

		Color buttonHover = Color.decode("#FF1654");

		

		chatPanel.Initialize(maxMessages);
		
		
		
		// ON hover
		btnPencil.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnPencil.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPencil.setBackground(buttonColor);
			}

		});

		btnCircle.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnCircle.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnCircle.setBackground(buttonColor);
			}

		});
		btnOval.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnOval.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnOval.setBackground(buttonColor);
			}

		});
		btnLine.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnLine.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnLine.setBackground(buttonColor);
			}

		});
		btnRectangle.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnRectangle.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnRectangle.setBackground(buttonColor);
			}

		});
		btnRedo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnRedo.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnRedo.setBackground(buttonColor);
			}

		});
		btnUndo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnUndo.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnUndo.setBackground(buttonColor);
			}

		});
		btnEraser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEraser.setBackground(buttonHover);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEraser.setBackground(buttonColor);
			}

		});

		//
		// ------------ Tool Box Buttons -------------
		//

		// Circle Button Click
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				State.tool.type = Tool.CIRCLE;
			}
		});

		// Line Button Click
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.tool.type = Tool.LINE;
			}
		});

		// Oval Button Click
		btnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.tool.type = Tool.OVAL;
			}
		});

		// Rectangle Button Click
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.tool.type = Tool.RECTANGLE;
			}
		});

		// Eraser Button Click
		btnEraser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.tool.type = Tool.ERASER;
			}
		});

		// Pencil Button Click
		btnPencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.tool.type = Tool.PENCIL;
			}
		});

		// Stroke Size Slider Changed
		sldStrokeSize.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int strokeVal = sldStrokeSize.getValue();
				State.tool.width = strokeVal;
				lblStrokeSize.setText("Stroke Size: " + strokeVal);
			}
		});
		
		
		// Request Sync Button Clicked
		btnReqSync.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestSync(true);
			}
		});

		// Sync Button Clicked
		btnSync.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sync(true);
			}
		});

		// Mouse Drag on Color Wheel
		colorWheel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// Added exception because if the user click and drag the mouse
				// outside of the panel then it will throw exception
				try {
					Color clr = colorWheel.GetColor(e.getPoint());
					State.tool.clr = clr;
					pnlColorView.setBackground(clr);
				} catch (Exception exp) {
					return;
				}
			}
		});

		// Mouse Clicked on Color Wheel
		colorWheel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Added exception because if the user click and drag the mouse
				// outside of the panel then it will throw exception
				try {
					Color clr = colorWheel.GetColor(e.getPoint());
					State.tool.clr = clr;
					pnlColorView.setBackground(clr);
				} catch (Exception exp) {
					return;
				}
			}
		});

		// Mouse Clicked on Undo Button
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UndoRedo.Undo(drawPanel);
			}
		});

		// Mouse Clicked on Redo Button
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UndoRedo.Redo(drawPanel);
			}
		});

		//
		// --------------- Menu Buttons ---------------
		//

		// Menu New Button Click
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveload.New(drawPanel, frame);
			}
		});

		// Menu Load Button Click
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveload.Load(drawPanel, frame);
			}
		});

		// Menu Save Button Click
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveload.Save(drawPanel.mainImage, frame);
			}
		});

		// Menu Save As Button Click
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveload.SaveAs(drawPanel.mainImage, frame);
			}
		});

	}

	// Mouse Button Pressed on DrawPanel
	void MousePressed(MouseEvent e) {
		Point mousePoint = e.getPoint();
		State.preMouse = mousePoint;

		if (State.tool.type == Tool.PENCIL || State.tool.type == Tool.ERASER) {
			State.preMouse = null;
			State.currMouse = mousePoint;
		}
		UndoRedo.Update(drawPanel.DeepCopyOfMainImage());
	}

	// Mouse Button Released on DrawPanel
	void MouseReleased(MouseEvent e) {
		if (State.preMouse == null)
			return;

		Point mousePoint = e.getPoint();
		State.currMouse = mousePoint;

		Tool tool = new Tool(State.tool);

		tool.AddPoints(State.preMouse, State.currMouse);
		Draw(tool, true, true);
	}

	// Mouse Dragged on DrawPanel
	void MouseDragged(MouseEvent e) {
		if (State.tool.IsContinuesTool()) {
			Point mousePoint = e.getPoint();

			if (State.preMouse != null) {
				Tool tool = new Tool(State.tool);
				tool.AddPoints(State.preMouse, State.currMouse);
				Draw(tool, true, true);
			}

			State.preMouse = State.currMouse;
			State.currMouse = mousePoint;
		} else {
			// Animation
			// Code same as Mouse Release with Complete of Draw = false
			if (State.preMouse == null)
				return;

			Point mousePoint = e.getPoint();
			State.currMouse = mousePoint;

			Tool tool = new Tool(State.tool);

			tool.AddPoints(State.preMouse, State.currMouse);
			Draw(tool, false, false);
		}
	}

	public void Draw(Tool tool, Boolean complete, Boolean broadCast) {
		if (broadCast) {
			Registry registry;
			try {
				int portInt = Integer.parseInt(port);
				registry = LocateRegistry.getRegistry(ip, portInt);

				IRemoteDrawServer remoteDraw = (IRemoteDrawServer) registry.lookup("DrawMethod");

				remoteDraw.Draw(tool, complete, broadCast);

			} catch (RemoteException | NotBoundException e) {
				State.ShowErrors(e, "MainViewClient - Draw");
			}
		}
		drawPanel.Draw(tool, complete, false);
	}
	public void RequestSync(Boolean broadCast) {
		if (broadCast) {
			Registry registry;
			try {
				int portInt = Integer.parseInt(port);
				registry = LocateRegistry.getRegistry(ip, portInt);

				System.out.println("Request Image Sync Called");
				IRemoteDrawServer remoteDraw = (IRemoteDrawServer) registry.lookup("DrawMethod");
				
				remoteDraw.RequestSync(true);
				
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
		}
	}
	public void Sync(Boolean broadCast) {
		if (broadCast) {
			Registry registry;
			try {
				int portInt = Integer.parseInt(port);
				registry = LocateRegistry.getRegistry(ip, portInt);

				System.out.println("Request Image Sync Called");
				IRemoteDrawServer remoteDraw = (IRemoteDrawServer) registry.lookup("DrawMethod");
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			    try {
					ImageIO.write(drawPanel.buffImage, "jpg", outputStream);
				} catch (IOException e) {
					State.Log("In Image syn client");
					State.Log(e.getMessage());
				}
			    
				remoteDraw.Sync(outputStream.toByteArray(),true);
				
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
		}
	}
	public void addMessage(Message message, boolean broadcast) {
		// broadcast should be always be true
		
		State.Log("Broadcasting message");
		Registry registry;
		try {
			int portInt = Integer.parseInt(port);
			registry = LocateRegistry.getRegistry(ip, portInt);

			State.Log("Server sending a message");
			IRemoteDrawServer remort = (IRemoteDrawServer) registry.lookup("DrawMethod");

			remort.addMessage(message, broadcast);
		} catch (Exception e) {
			State.ErrorLog(e.getMessage());
			State.ShowErrors(e, "MainViewMaster - addMessage");
		}
	}
}
