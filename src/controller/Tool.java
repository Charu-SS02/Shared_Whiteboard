package controller;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Tool 
{
	public static final int ERASER 		= 0000;
	public static final int LINE 		= 0001;
	public static final int RECTANGLE 	= 0002;
	public static final int BOX 		= 0003;
	public static final int OVAL 		= 0004;
	public static final int CIRCLE 		= 0005;
	public static final int PENCIL		= 0006;
	
	public ArrayList<Point> points;
	public Color clr;
	public int width;
	public int type;
	
	public Tool()
	{
		this.type = LINE;
		this.width = 1;
		this.clr = Color.BLACK;
		points = new ArrayList<Point>();
	}
	public Tool(int type, Color clr, int width)
	{
		this.type = type;
		this.clr = clr;
		this.width = width;
		points = new ArrayList<Point>();
	}
	@SuppressWarnings("unchecked")
	public Tool(Tool tool)
	{
		type = tool.type;
		clr = tool.clr;
		width = tool.width;
		points = (ArrayList<Point>)tool.points.clone();
	}

	
	public void AddPoint(Point p1)
	{
		points.add(p1);
	}
	public void AddPoints(Point p1, Point p2)
	{
		points.add(p1);
		points.add(p2);
	}
	
	
	public Point Point(int index)
	{
		return points.get(index);
	}
	
}
