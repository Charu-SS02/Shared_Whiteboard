package view;

import javax.swing.*;
import java.io.Serializable;

import controller.Message;

public class ChatPanel extends JPanel implements Serializable {

    public int width, height;

    public JLabel[] msgLabels = new JLabel[5];      // there are only five labels in message panel

    private static final long serialVersionUID = 20120731125410L;

    public ChatPanel(){}

    public void Initialize(int width, int height){
        this.width = width;
        this.height = height;

        // initialize message labels to blank string
        for(int i=0;i<5;i++)
            msgLabels[i] = new JLabel("test");

        // add message labels into the panel
        for(int i=0;i<5;i++){
            this.add(msgLabels[i]);
        }
    }

    public void addMessage(Message message, boolean broadcast){
        boolean found = false;
        String msg = message.getUsername() + " >> " + message.getText();

        // find empty jLabel
        for(int i=0;i<5;i++){
            if(msgLabels[i].getText() == ""){
                msgLabels[i].setText(msg);
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
            msgLabels[4].setText(msg);
        }
        // refresh the page
        repaint();
    }

    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
}
