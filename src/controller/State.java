package controller;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class State {

	public static ArrayList<Point> mousePoints;
	public static Point currMouse;
	public static Point preMouse;
	public static Color bgColor;
	public static Tool tool;
	
	public static void Initialize()
	{
		//ArrayList<Point> mousePoints = new ArrayList<Point>();
		bgColor = Color.white;
		currMouse = new Point();
		preMouse = new Point();
		tool = new Tool();
	}
	
	public static void Log(String msg)
	{
		System.out.println(msg);
	}
	public static void ErrorLog(String msg)
	{
		System.err.println(msg);
	}
}


/*
	----------- TODO List --------------
	
	- Add Transition for all tools
	- Add Undo Redo feature
	- Fix Circle and Rectangle







*/