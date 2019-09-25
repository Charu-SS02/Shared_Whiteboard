package view;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ColorSelector;
import controller.SaveLoad;
import controller.State;
import controller.Tool;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MainView{

	private JFrame frame;
	DrawPanel drawPanel = new DrawPanel();
	SaveLoad saveload = new SaveLoad();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
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
		frame.setBounds(100, 100, 828, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 146, 567);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.setBounds(6, 97, 65, 39);
		leftPanel.add(btnCircle);
		
		JButton btnLine = new JButton("Line");
		btnLine.setBounds(6, 136, 65, 39);
		leftPanel.add(btnLine);
		
		JButton btnOval = new JButton("Oval");
		btnOval.setBounds(75, 97, 65, 39);
		leftPanel.add(btnOval);
		
		JButton btnRectangle = new JButton("Rect");
		btnRectangle.setBounds(75, 136, 65, 39);
		leftPanel.add(btnRectangle);
		
		JButton btnEraser = new JButton("Eraser");
		btnEraser.setBounds(6, 522, 134, 39);
		leftPanel.add(btnEraser);
		
		JButton btnPencil = new JButton("Pencil");
		btnPencil.setBounds(6, 55, 134, 39);
		leftPanel.add(btnPencil);
		
		JSlider sldStrokeSize = new JSlider();
		sldStrokeSize.setValue(2);
		sldStrokeSize.setMinorTickSpacing(1);
		sldStrokeSize.setMaximum(20);
		sldStrokeSize.setMinimum(1);
		sldStrokeSize.setBounds(6, 249, 134, 29);
		leftPanel.add(sldStrokeSize);
		
		JLabel lblStrokeSize = new JLabel("Stroke Size: 2");
		lblStrokeSize.setBounds(12, 230, 134, 16);
		leftPanel.add(lblStrokeSize);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 323, 61, 16);
		leftPanel.add(lblColor);
		
		ColorSelector colorWheel = new ColorSelector();
		colorWheel.setBounds(6, 351, 134, 134);
		leftPanel.add(colorWheel);
		
		JPanel pnlColorView = new JPanel();
		pnlColorView.setBackground(Color.BLACK);
		pnlColorView.setBounds(75, 315, 65, 29);
		leftPanel.add(pnlColorView);
		colorWheel.LoadImage();
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(713, 0, 113, 567);
		rightPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(rightPanel);
		
		
		
		drawPanel.setBackground(Color.WHITE);
		drawPanel.setBounds(162, 6, 539, 561);
		frame.getContentPane().add(drawPanel);
		
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
		drawPanel.Initialize(drawPanel.getHeight(), drawPanel.getWidth());
		
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
		if(State.tool.type == Tool.PENCIL || State.tool.type == Tool.ERASER)
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
