package controller;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import view.DrawPanel;

public class SaveLoad 
{
	private final String fileExtension = ".jpg";
	private final String extensionConst = "JPG";
	private String savePath = "";
	
	public void New(DrawPanel draw, Component parent)
	{
		draw.Initialize(draw.getWidth(),draw.getHeight());
		draw.repaint();
		savePath = "";
		
		UndoRedo.Clear();
	}
	
	public void Load(DrawPanel draw, Component parent)
	{
		if(OpenLoadFileChooser(parent))
		{
			File loadFile = new File(savePath);
			State.Log("Loading Image: "+savePath);
			try 
			{
				//draw.mainImage = ImageIO.read(loadFile);
				draw.UpdateMainImage(ImageIO.read(loadFile));
				draw.repaint();
			} 
			catch (IOException e) { State.ErrorLog(e.getMessage()); }
			

			UndoRedo.Clear();
		}
	}
	
	public void Save(BufferedImage bImage, Component parent)
	{
		if(savePath=="") if(!OpenSaveFileChooser(parent)) return;
    	SaveImage(bImage);
	}
	
	public void SaveAs(BufferedImage bImage, Component parent)
	{
		if(!OpenSaveFileChooser(parent)) return;
    	SaveImage(bImage);
	}
	
	private Boolean OpenSaveFileChooser(Component parent)
	{

		JFileChooser fc = new JFileChooser();
	    fc.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);

	    if( fc.showSaveDialog( parent ) == JFileChooser.APPROVE_OPTION )
	    {
	        try 
	        {
	        	savePath = fc.getSelectedFile().getCanonicalPath();
	        	savePath+=fileExtension;
	        	return true;
			} catch (IOException e) 
	        {
				e.printStackTrace();
			}
	    }
	    return false;
	}
	
	void SaveImage(BufferedImage bImage)
	{
		File saveFile = new File(savePath);
	    try 
	    {
	        State.Log("Exporting Image As: "+ savePath);
			ImageIO.write(bImage,extensionConst, saveFile);
			State.Log("File Saved Successfully");
		} 
	    catch (IOException e) { State.ErrorLog(e.getMessage()); }
	}

	private Boolean OpenLoadFileChooser(Component parent)
	{

		JFileChooser fc = new JFileChooser();
	    fc.setFileSelectionMode( JFileChooser.FILES_ONLY);

	    if( fc.showOpenDialog(parent)  == JFileChooser.APPROVE_OPTION )
	    {
	        try 
	        {
	        	savePath = fc.getSelectedFile().getCanonicalPath();
	        	return true;
			} catch (IOException e) 
	        {
				e.printStackTrace();
			}
	    }
	    return false;
	}
	
}
