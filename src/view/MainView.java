package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ColorSelector;
import controller.SaveLoad;
import controller.State;
import controller.Tool;
import controller.UndoRedo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MainView{

	public JFrame frame;
	DrawPanel drawPanel = new DrawPanel();
	SaveLoad saveload = new SaveLoad(); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MainView window = new MainView();
					//window.frame.setVisible(true);
					
					LoginView login = new LoginView();
					login.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		State.Initialize();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 828, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{146, 498, 162};
		gridBagLayout.rowHeights = new int[] {96, 567, 80, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
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
		gbl_leftPanel.columnWidths = new int[]{34, 71, 65, 26, 0};
		gbl_leftPanel.rowHeights = new int[]{0, 39, 39, 39, 16, 29, 29, 134, 39, 52, 39, 0};
		gbl_leftPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		leftPanel.add(label, gbc_label);
		
		JButton btnPencil = new JButton("Pencil");
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
		btnCircle.setBackground(buttonColor);
		btnCircle.setForeground(Color.white);
		GridBagConstraints gbc_btnCircle = new GridBagConstraints();
		gbc_btnCircle.fill = GridBagConstraints.BOTH;
		gbc_btnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCircle.gridx = 1;
		gbc_btnCircle.gridy = 2;
		leftPanel.add(btnCircle, gbc_btnCircle);
		
		JButton btnOval = new JButton("Oval");
		btnOval.setBackground(buttonColor);
		btnOval.setForeground(Color.white);
		GridBagConstraints gbc_btnOval = new GridBagConstraints();
		gbc_btnOval.fill = GridBagConstraints.BOTH;
		gbc_btnOval.insets = new Insets(0, 0, 5, 5);
		gbc_btnOval.gridx = 2;
		gbc_btnOval.gridy = 2;
		leftPanel.add(btnOval, gbc_btnOval);
		
		JButton btnLine = new JButton("Line");
		btnLine.setBackground(buttonColor);
		btnLine.setForeground(Color.white);
		GridBagConstraints gbc_btnLine = new GridBagConstraints();
		gbc_btnLine.fill = GridBagConstraints.BOTH;
		gbc_btnLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnLine.gridx = 1;
		gbc_btnLine.gridy = 3;
		leftPanel.add(btnLine, gbc_btnLine);
		
		JButton btnRectangle = new JButton("Rect");
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
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		btnUndo.setBackground(buttonColor);
		btnUndo.setForeground(Color.white);
		gbc_btnUndo.fill = GridBagConstraints.BOTH;
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 1;
		gbc_btnUndo.gridy = 8;
		leftPanel.add(btnUndo, gbc_btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setBackground(buttonColor);
		btnRedo.setForeground(Color.white);
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.fill = GridBagConstraints.BOTH;
		gbc_btnRedo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRedo.gridx = 2;
		gbc_btnRedo.gridy = 8;
		leftPanel.add(btnRedo, gbc_btnRedo);
		
		JButton btnEraser = new JButton("Eraser");
		btnEraser.setBackground(buttonColor);
		btnEraser.setForeground(Color.white);
		GridBagConstraints gbc_btnEraser = new GridBagConstraints();
		gbc_btnEraser.insets = new Insets(0, 0, 5, 5);
		gbc_btnEraser.fill = GridBagConstraints.BOTH;
		gbc_btnEraser.gridwidth = 2;
		gbc_btnEraser.gridx = 1;
		gbc_btnEraser.gridy = 9;
		leftPanel.add(btnEraser, gbc_btnEraser);
		
		JLabel label_2 = new JLabel(" ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 10;
		leftPanel.add(label_2, gbc_label_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		drawPanel.setBounds(-33, 0, 575, 561);
		panel.add(drawPanel);
		drawPanel.width = 1200;
		drawPanel.height = 1200;
		
		
		
		drawPanel.setBackground(Color.WHITE);
		drawPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		drawPanel.Initialize(drawPanel.getHeight(), drawPanel.getWidth());
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(myColorLeftPanel);
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.insets = new Insets(0, 0, 5, 0);
		gbc_rightPanel.fill = GridBagConstraints.BOTH;
		gbc_rightPanel.gridx = 2;
		gbc_rightPanel.gridy = 1;
		frame.getContentPane().add(rightPanel, gbc_rightPanel);
		
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
		
		btnCircle.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnCircle.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnCircle.setBackground(buttonColor);
			    }
			
		}
		);
		btnOval.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnOval.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnOval.setBackground(buttonColor);
			    }
			
		}
		);
		btnLine.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnLine.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnLine.setBackground(buttonColor);
			    }
			
		}
		);
		btnRectangle.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnRectangle.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnRectangle.setBackground(buttonColor);
			    }
			
		}
		);
		btnRedo.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnRedo.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnRedo.setBackground(buttonColor);
			    }
			
		}
		);
		btnUndo.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnUndo.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnUndo.setBackground(buttonColor);
			    }
			
		}
		);
		btnEraser.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 btnEraser.setBackground(buttonHover);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnEraser.setBackground(buttonColor);
			    }
			
		}
		);
		
		// --------------------------------------------
		//               Event Handlers
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
				lblStrokeSize.setText("Stroke Size: "+strokeVal);
			}
		});
		
		// Mouse Drag on Color Wheel
		colorWheel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// Added exception because if the user click and drag the mouse
				// outside of the panel then it will throw exception
				try{Color clr = colorWheel.GetColor(e.getPoint());
				State.tool.clr = clr;
				pnlColorView.setBackground(clr);}
				catch(Exception exp) {return;}
			}
		});
		
		// Mouse Clicked on Color Wheel
		colorWheel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Added exception because if the user click and drag the mouse
				// outside of the panel then it will throw exception
				try{Color clr = colorWheel.GetColor(e.getPoint());
				State.tool.clr = clr;
				pnlColorView.setBackground(clr);}
				catch(Exception exp) {return;}
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
				saveload.SaveAs(drawPanel.mainImage,frame);
			}
		});
		
	
	}
	
	
	// Mouse Button Pressed on DrawPanel
	void MousePressed(MouseEvent e)
	{
		Point mousePoint = e.getPoint();
		State.preMouse = mousePoint;
		
		if(State.tool.type == Tool.PENCIL || State.tool.type == Tool.ERASER)
		{
			State.preMouse = null;
			State.currMouse = mousePoint;
		}
		UndoRedo.Update(drawPanel.DeepCopyOfMainImage());
	}
	
	// Mouse Button Released on DrawPanel
	void MouseReleased(MouseEvent e)
	{
		if(State.preMouse==null) return;
		
		Point mousePoint = e.getPoint();
		State.currMouse = mousePoint;
		
		Tool tool = new Tool(State.tool);
		
		tool.AddPoints(State.preMouse, State.currMouse);
		drawPanel.Draw(tool,true);
	}

	// Mouse Dragged on DrawPanel
	void MouseDragged(MouseEvent e)
	{
		if(State.tool.IsContinuesTool())
		{
			Point mousePoint = e.getPoint();
			
			if(State.preMouse!=null)
			{
				Tool tool = new Tool(State.tool);
				tool.AddPoints(State.preMouse, State.currMouse);
				drawPanel.Draw(tool,true);
			}
			
			State.preMouse = State.currMouse;
			State.currMouse = mousePoint;
		}
		else
		{
			// Animation
			// Code same as Mouse Release with Complete of Draw = false
			if(State.preMouse==null) return;
			
			Point mousePoint = e.getPoint();
			State.currMouse = mousePoint;
			
			Tool tool = new Tool(State.tool);
			
			tool.AddPoints(State.preMouse, State.currMouse);
			drawPanel.Draw(tool,false);
		}
	}
}
