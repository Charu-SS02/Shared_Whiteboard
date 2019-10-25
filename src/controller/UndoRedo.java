package controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Stack;

import view.DrawPanel;

public class UndoRedo {

	private static Stack<BufferedImage> redoStack = new Stack<BufferedImage>();
	private static Stack<BufferedImage> undoStack = new Stack<BufferedImage>();
	
	public static void Update(BufferedImage image)
	{
		undoStack.add(image);
		//State.Log("Undo Stack Size: "+undoStack.size());
	}
	
	public static void Undo(DrawPanel panel)
	{
		//State.Log("Called Undo "+undoStack.size());
		if(undoStack.empty()) return;

		redoStack.push(DeepCopy(panel.mainImage));
		BufferedImage tmp = undoStack.pop();
		panel.UpdateMainImage(tmp);
		
		//State.Log("Undo Stack Size: "+undoStack.size());
		//State.Log("Redo Stack Size: "+redoStack.size());
	}
	
	public static void Redo(DrawPanel panel)
	{
		//State.Log("Called Redo");
		if(redoStack.empty()) return;

		Update(panel.mainImage);
		BufferedImage tmp = redoStack.pop();
		panel.UpdateMainImage(tmp);

		//State.Log("Undo Stack Size: "+undoStack.size());
		//State.Log("Redo Stack Size: "+redoStack.size());
	}
	
	public static void ResetRedo()
	{
		redoStack.clear();
	}
	
	public static void Clear()
	{
		undoStack.clear();
		redoStack.clear();
	}
	
	private static BufferedImage DeepCopy(BufferedImage source)
	{
	    BufferedImage destination = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = destination.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return destination;
	}
	
}
