package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controller.ColorSelector;
import controller.SaveLoad;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test1 {
	SaveLoad saveload = new SaveLoad(); 

	private JFrame frame;
	DrawPanel drawPanel = new DrawPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test1 window = new test1();
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
	public test1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 828, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Color buttonHover = Color.decode("#FF1654");
		
		JPanel titlePanel = new JPanel();
		Color myColor = Color.decode("#114B5F");
		Color buttonColor = Color.decode("#456990");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		titlePanel.setBackground(myColor);
		titlePanel.setLayout(null);
		frame.getContentPane().add(titlePanel, BorderLayout.NORTH);
		
		JLabel lblShareWhiteBoard = new JLabel("Shared White Board");
		lblShareWhiteBoard.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblShareWhiteBoard.setForeground(new Color(255, 255, 255));
		lblShareWhiteBoard.setBounds(10, 10, 228, 41);
		lblShareWhiteBoard.setVerticalAlignment(SwingConstants.BOTTOM);
		titlePanel.add(lblShareWhiteBoard);
		
		JPanel leftPanel = new JPanel();
		Color myColorLeftPanel = Color.decode("#028090");
		
		leftPanel.setBackground(myColorLeftPanel);
		frame.getContentPane().add(leftPanel, BorderLayout.WEST);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{80, 80, 0};
		gbl_leftPanel.rowHeights = new int[]{0, 39, 40, 40, 40, 40, 40, 40, 146, 40, 39, 40, 0};
		gbl_leftPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		JButton btnPencil = new JButton("Pencil");
		btnPencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPencil.setBackground(buttonColor);
		btnPencil.setForeground(Color.white);
		GridBagConstraints gbc_btnPencil = new GridBagConstraints();
		gbc_btnPencil.fill = GridBagConstraints.BOTH;
		gbc_btnPencil.insets = new Insets(0, 0, 5, 0);
		gbc_btnPencil.gridwidth = 2;
		gbc_btnPencil.gridx = 0;
		gbc_btnPencil.gridy = 2;
		leftPanel.add(btnPencil, gbc_btnPencil);
		
		// ON hover
		btnPencil.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnPencil.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnPencil.setBackground(buttonColor);
			    }
			
		}
		);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.setBackground(buttonColor);
		btnCircle.setForeground(Color.white);
		GridBagConstraints gbc_btnCircle = new GridBagConstraints();
		gbc_btnCircle.fill = GridBagConstraints.BOTH;
		gbc_btnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCircle.gridx = 0;
		gbc_btnCircle.gridy = 3;
		leftPanel.add(btnCircle, gbc_btnCircle);
		
		btnCircle.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnCircle.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnCircle.setBackground(buttonColor);
			    }
			
		}
		);
		
		JButton btnOval = new JButton("Oval");
		btnOval.setBackground(buttonColor);
		btnOval.setForeground(Color.white);
		GridBagConstraints gbc_btnOval = new GridBagConstraints();
		gbc_btnOval.fill = GridBagConstraints.BOTH;
		gbc_btnOval.insets = new Insets(0, 0, 5, 0);
		gbc_btnOval.gridx = 1;
		gbc_btnOval.gridy = 3;
		leftPanel.add(btnOval, gbc_btnOval);
		btnOval.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnOval.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnOval.setBackground(buttonColor);
			    }
			
		}
		);
		
		JButton btnLine = new JButton("Line");
		btnLine.setBackground(buttonColor);
		btnLine.setForeground(Color.white);
		GridBagConstraints gbc_btnLine = new GridBagConstraints();
		gbc_btnLine.fill = GridBagConstraints.BOTH;
		gbc_btnLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnLine.gridx = 0;
		gbc_btnLine.gridy = 4;
		leftPanel.add(btnLine, gbc_btnLine);
		btnLine.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnLine.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnLine.setBackground(buttonColor);
			    }
			
		}
		);
		
		JButton btnRectangle = new JButton("Rect");
		btnRectangle.setBackground(buttonColor);
		btnRectangle.setForeground(Color.white);
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_btnRectangle.gridx = 1;
		gbc_btnRectangle.gridy = 4;
		leftPanel.add(btnRectangle, gbc_btnRectangle);
		btnRectangle.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnRectangle.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnRectangle.setBackground(buttonColor);
			    }
			
		}
		);
		
		JLabel lblStrokeSize = new JLabel("Stroke Size: 2");
		GridBagConstraints gbc_lblStrokeSize = new GridBagConstraints();
		gbc_lblStrokeSize.fill = GridBagConstraints.BOTH;
		gbc_lblStrokeSize.insets = new Insets(0, 0, 5, 0);
		gbc_lblStrokeSize.gridwidth = 2;
		gbc_lblStrokeSize.gridx = 0;
		gbc_lblStrokeSize.gridy = 5;
		leftPanel.add(lblStrokeSize, gbc_lblStrokeSize);
		
		JPanel panel_2 = new JPanel();
		
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 6;
		leftPanel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.setPreferredSize(new Dimension(160,40));
		
		JSlider sldStrokeSize = new JSlider();
		panel_2.add(sldStrokeSize);
		sldStrokeSize.setValue(2);
		sldStrokeSize.setMinorTickSpacing(1);
		sldStrokeSize.setMaximum(20);
		sldStrokeSize.setMinimum(1);
		
		JLabel lblColor = new JLabel("Color");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.NORTH;
		gbc_lblColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 7;
		leftPanel.add(lblColor, gbc_lblColor);
		
		JPanel pnlColorView = new JPanel();
		pnlColorView.setBackground(Color.BLACK);
		GridBagConstraints gbc_pnlColorView = new GridBagConstraints();
		gbc_pnlColorView.fill = GridBagConstraints.BOTH;
		gbc_pnlColorView.insets = new Insets(0, 0, 5, 0);
		gbc_pnlColorView.gridx = 1;
		gbc_pnlColorView.gridy = 7;
		leftPanel.add(pnlColorView, gbc_pnlColorView);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(myColorLeftPanel);
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 8;
		leftPanel.add(panel_1, gbc_panel_1);
		
		ColorSelector colorWheel = new ColorSelector();
		colorWheel.setBounds(0, 0, 157, 143);
		panel_1.add(colorWheel);
		colorWheel.LoadImage();
		
		JButton btnUndo = new JButton("Undo");
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		btnUndo.setBackground(buttonColor);
		btnUndo.setForeground(Color.white);
		gbc_btnUndo.fill = GridBagConstraints.BOTH;
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 9;
		leftPanel.add(btnUndo, gbc_btnUndo);
		btnUndo.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnUndo.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnUndo.setBackground(buttonColor);
			    }
			
		}
		);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setBackground(buttonColor);
		btnRedo.setForeground(Color.white);
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.fill = GridBagConstraints.BOTH;
		gbc_btnRedo.insets = new Insets(0, 0, 5, 0);
		gbc_btnRedo.gridx = 1;
		gbc_btnRedo.gridy = 9;
		leftPanel.add(btnRedo, gbc_btnRedo);
		btnRedo.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnRedo.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnRedo.setBackground(buttonColor);
			    }
			
		}
		);
		
		JLabel label_2 = new JLabel(" ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 10;
		leftPanel.add(label_2, gbc_label_2);
		
		JButton btnEraser = new JButton("Eraser");
		btnEraser.setBackground(buttonColor);
		btnEraser.setForeground(Color.white);
		GridBagConstraints gbc_btnEraser = new GridBagConstraints();
		gbc_btnEraser.fill = GridBagConstraints.BOTH;
		gbc_btnEraser.gridwidth = 2;
		gbc_btnEraser.gridx = 0;
		gbc_btnEraser.gridy = 11;
		leftPanel.add(btnEraser, gbc_btnEraser);
		btnEraser.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnEraser.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnEraser.setBackground(buttonColor);
			    }
			
		}
		);
		
		JPanel rightPanel = new JPanel();
		frame.getContentPane().add(rightPanel, BorderLayout.EAST);
		rightPanel.setBackground(myColorLeftPanel);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[] {200};
		gbl_rightPanel.rowHeights = new int[]{0};
		gbl_rightPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_rightPanel.rowWeights = new double[]{Double.MIN_VALUE};
		rightPanel.setLayout(gbl_rightPanel);
		frame.getContentPane().add(drawPanel, BorderLayout.CENTER);
		drawPanel.width = 1200;
		drawPanel.height = 1200;
		
		
		
		drawPanel.setBackground(Color.WHITE);
		drawPanel.setLayout(null);
		drawPanel.Initialize(drawPanel.height, drawPanel.width);
		
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
		
		
		
	}

}
