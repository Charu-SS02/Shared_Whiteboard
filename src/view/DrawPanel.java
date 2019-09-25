package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controller.State;
import controller.Tool;
import controller.UndoRedo;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel
{
	public int width, height;
	public BufferedImage mainImage; 
	public BufferedImage drawImage; 
	public BufferedImage buffImage; 

	public DrawPanel()
	{
		
	}
	public void Initialize(int width,int height)
	{
		this.width = width;
		this.height = height;
		mainImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		drawImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		buffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		SetBackgroundColor(mainImage);
		SetBackgroundColor(drawImage);
		SetBackgroundColor(buffImage);
	}

	@Override
    protected void paintComponent(Graphics g) 
	{
       super.paintComponent(g);
       g.drawImage(drawImage, 0, 0, null);
    }
	
	public void Draw(Tool tool, Boolean complete)
	{

		if(complete) drawImage = mainImage;
		else drawImage = buffImage; 
		
		switch(tool.type)
		{
			case Tool.LINE:
				DrawLine(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				break;
			
			case Tool.CIRCLE:
				DrawCircle(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				break;
				
			case Tool.OVAL:
				DrawOval(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				break;
				
			case Tool.RECTANGLE:
				DrawRectangle(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				break;
			
			case Tool.PENCIL:
				DrawLine(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				break;
				
			case Tool.ERASER:
				ApplyEraser(tool.Point(0),tool.Point(1),State.bgColor,tool.width);
				break;
		}
		
		// Deep Copy Here
		//if(!complete) 
		buffImage = DeepCopy(mainImage);
		UndoRedo.ResetRedo();
	}
	
	
	//
	// Drawing Function
	//
	public void DrawLine(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = drawImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
	    
		repaint();
	}
	
	public void DrawCircle(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = drawImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    
	    //Point p = new Point((p1.x>p2.x)?p1.x:p2.x,(p1.y>p2.y)?p1.y:p2.y);
	    Point centre = p1;
	    int radius = (int)Math.sqrt(Math.pow(Math.abs(p1.x-p2.x), 2)+Math.pow(Math.abs(p1.y-p2.y), 2));
	    
	    
	    g2.drawOval((int)(centre.x-radius), (int)(centre.y-radius), radius*2, radius*2);
	    
	    
		repaint();
	}
	public void DrawOval(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = drawImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    
	    Point p = new Point((p1.x<p2.x)?p1.x:p2.x,(p1.y<p2.y)?p1.y:p2.y);
	    g2.drawOval(p.x, p.y, Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
		repaint();
	}
	public void DrawRectangle(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = drawImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    
	    Point p = new Point((p1.x<p2.x)?p1.x:p2.x,(p1.y<p2.y)?p1.y:p2.y);
	    g2.drawRect(p.x, p.y, Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
		repaint();
	}
	
	public void ApplyEraser(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = drawImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
		repaint();
	}
	
	public void SetBackgroundColor(BufferedImage bImage)
	{
		Graphics g = bImage.getGraphics();
		g.setColor(State.bgColor);
	    g.fillRect(0, 0, width, height);
	    g.dispose();
	}
	
	
	//
	// Image Management Functions
	//
	public BufferedImage DeepCopyOfMainImage()
	{
		return DeepCopy(mainImage);
	}
	
	private BufferedImage DeepCopy(BufferedImage source)
	{
	    BufferedImage destination = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = destination.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return destination;
	}
	public void UpdateMainImage(BufferedImage newMain)
	{
		mainImage = newMain;
		drawImage = DeepCopyOfMainImage();
		buffImage = DeepCopyOfMainImage();
		repaint();
	}
}
