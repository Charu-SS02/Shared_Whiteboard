package controller;

import java.awt.Point;
import java.util.ArrayList;

public class State {

	public static ArrayList<Point> mousePoints;
	public static Point currMouse;
	public static Point preMouse;
	public static Tool tool;
	
	public static void Initialize()
	{
		ArrayList<Point> mousePoints = new ArrayList<Point>();
		currMouse = new Point();
		preMouse = new Point();
		tool = new Tool();
	}
	
	public static void Log(String msg)
	{
		System.out.println(msg);
	}
}
