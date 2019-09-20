package view;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.State;
import controller.Tool;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class MainView{

	private JFrame frame;
	DrawPanel drawPanel = new DrawPanel();
	
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
		frame.setBounds(100, 100, 827, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 98, 567);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.setBounds(6, 97, 86, 39);
		leftPanel.add(btnCircle);
		
		JButton btnLine = new JButton("Line");
		btnLine.setBounds(6, 136, 86, 39);
		leftPanel.add(btnLine);
		
		JButton btnOval = new JButton("Oval");
		btnOval.setBounds(6, 175, 86, 39);
		leftPanel.add(btnOval);
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.setBounds(6, 214, 86, 39);
		leftPanel.add(btnRectangle);
		
		JButton btnEraser = new JButton("Eraser");
		btnEraser.setBounds(6, 522, 86, 39);
		leftPanel.add(btnEraser);
		
		JButton btnPencil = new JButton("Pencil");
		btnPencil.setBounds(6, 50, 86, 39);
		leftPanel.add(btnPencil);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(713, 0, 113, 567);
		rightPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(rightPanel);
		
		
		
		
		drawPanel.setBackground(Color.WHITE);
		drawPanel.setBounds(111, 6, 590, 561);
		frame.getContentPane().add(drawPanel);
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
		drawPanel.Draw(tool);
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
				drawPanel.Draw(tool);
			}
			
			State.preMouse = State.currMouse;
			State.currMouse = mousePoint;
		}
	}
}
