package view;

import javax.swing.*;

import java.awt.Component;
import java.io.Serializable;

import controller.Message;
import controller.State;

public class ChatPanel extends JPanel implements Serializable {

   

    int maxMessages = 10;
    public JLabel[] msgLabels;

    private static final long serialVersionUID = 20120731125410L;

    public ChatPanel()
    {
    	
    }

    public void Initialize(int maxMessages)
    {
    	State.Log("Initializing");
        this.maxMessages = maxMessages;
        
        msgLabels = new JLabel[maxMessages];
        for(int i=0;i<maxMessages;i++)
    		msgLabels[i] = null;

		State.Log(" 3.1 ");
        LoadLabels();
    }
    
    public void AddLabel(JLabel label)
    {
    	State.Log("Adding labels");
    	for(int i=0;i<maxMessages;i++)
    		if(msgLabels[i]==null)
    		{
    			msgLabels[i] = label;
    			msgLabels[i].setText("");
    			State.Log("ADDED");
    			return;
    		}
    }
    public void LoadLabels()
    {

		State.Log(" 3.2 ");
    	Component[] components = this.getComponents();
    	int count = components.length;
    	for (int i = count-1;i>=0;i--) 
    	{
    		Component field = components[i];
    	    if (field instanceof JLabel) 
    	    {
    			State.Log(" 3.3 ");
    	    	AddLabel((JLabel)field);
    			State.Log(" 3.4 ");
    	    }
    		State.Log(" 3.5 ");
    	}
    }
    
    public void addMessage(Message message, boolean broadcast){
    	
    	State.Log("Message To Display ---> "+message.getText());
    	
    	State.Log("M 1 ");
    	
    	if(msgLabels[0]!=null)
    	{
        	State.Log("M 2 ");
	    	String tmp = msgLabels[0].getText();
	    	for(int i=1;i<maxMessages-1;i++)
	    	{

	        	State.Log("M 3 ");
	    		if(msgLabels[i]==null) break;
	    		String tmp2 = msgLabels[i].getText();
    			msgLabels[i].setText(tmp);
    			tmp = tmp2;
	    	}
    	}
    	State.Log("M END");
    	msgLabels[0].setText(FormatMessage(message));
    	
        // refresh the page
        repaint();
    }
    
    String FormatMessage(Message message)
    {
    	String m = "<html>";
    			
    	m += "<strong>"+message.getUsername()+"</strong><br>";
    	m += "  "+message.getText()+"  <br>";
    	m += "<font size=\"-3\">  "+message.getTime()+"  </font>";
    	m += "</html>";
    	return m;
    }

}
