package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorSelector extends JPanel
{
	private static String clrWheelImgPath = "clrWheel.png";
	private BufferedImage clrWheelImg;
	
	public ColorSelector()
	{
	}
	
	public void LoadImage()
	{

		try {
			
			clrWheelImg = ImageIO.read(this.getClass().getResource(clrWheelImgPath));
			Image tmp = clrWheelImg.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		    clrWheelImg = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		   
		    
		    Graphics2D g2d = clrWheelImg.createGraphics();
		    g2d.drawImage(tmp, 0, 0, null);
			this.repaint();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(clrWheelImg, 0, 0, this); 
        //g.drawImage(clrWheelImg, 0, 0, this.getWidth(),this.getHeight(), this); 
    }


	public Color GetColor(Point point)
	{
		int clr = clrWheelImg.getRGB(point.x, point.y);
		int red   = (clr & 0x00ff0000) >> 16;
		int green = (clr & 0x0000ff00) >> 8;
		int blue  =  clr & 0x000000ff;
		
		return new Color(red,green,blue);
	}
}
