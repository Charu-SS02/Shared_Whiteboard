package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controller.Tool;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel
{
	public int width, height;
	private BufferedImage bImage; 

	public DrawPanel()
	{
		
	}
	public void Initialize(int width,int height)
	{
		this.width = width;
		this.height = height;
		bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bImage.getGraphics();
		g.setColor(new Color(255,255,255));
	    g.fillRect(0, 0, width, height);
	    g.dispose();
	}

	@Override
    protected void paintComponent(Graphics g) 
	{
       super.paintComponent(g);
       g.drawImage(bImage, 0, 0, null);
    }
	
	public void Draw(Tool tool)
	{
		switch(tool.type)
		{
			case Tool.LINE:
				DrawLine(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				return;
			
			case Tool.CIRCLE:
				DrawCircle(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				return;
				
			case Tool.OVAL:
				DrawOval(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				return;
				
			case Tool.RECTANGLE:
				DrawRectangle(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				return;
			
			case Tool.PENCIL:
				DrawLine(tool.Point(0),tool.Point(1),tool.clr,tool.width);
				return;
		}
	}
	
	public void DrawLine(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = bImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
		repaint();
	}
	
	public void DrawCircle(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = bImage.createGraphics();
		
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
		Graphics2D g2 = bImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    g2.drawOval(p1.x, p1.y, Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
		repaint();
	}
	public void DrawRectangle(Point p1, Point p2, Color clr, int width)
	{
		Graphics2D g2 = bImage.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	    g2.setColor(clr);
	    
	    Point p = new Point((p1.x<p2.x)?p1.x:p2.x,(p1.y<p2.y)?p1.y:p2.y);
	    g2.drawRect(p.x, p.y, Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
		repaint();
	}
	
}
