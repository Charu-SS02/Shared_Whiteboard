package view;

import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ServerInfoPanel extends JPanel implements Serializable{
	
	

	    public int width, height;

	    public JLabel[] msgLabels = new JLabel[5];      // there are only 5 user can connect

	    private static final long serialVersionUID = 20120731125410L;

	    public ServerInfoPanel(){}

	    public void Initialize(int width, int height){
	       
	        // initialize message labels to blank string
	        for(int i=0;i<5;i++)
	            msgLabels[i] = new JLabel("test");

	        // add message labels into the panel
	        for(int i=0;i<5;i++){
	            this.add(msgLabels[i]);
	        }
	    }

	    public void addUser(String message){
	        boolean found = false;
	      

	        // find empty jLabel
	        for(int i=0;i<5;i++){
	            if(msgLabels[i].getText() == ""){
	                msgLabels[i].setText(message);
	                found = true;
	                break;
	            }
	        }

	        if(!found){
	            // move the next label to the current label
	            for(int i =0;i<4;i++){
	                msgLabels[i] = msgLabels[i+1];
	            }
	            // add the new msg in to the last label
	            msgLabels[4].setText(message);
	        }
	        // refresh the page
	        repaint();
	    }

	    public int getWidth(){ return width; }
	    public int getHeight(){ return height; }
	}


