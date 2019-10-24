package controller;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Message implements Serializable {
    //    public static int id;
    private static final long serialVersionUID = 20120731125400L;
    private String username;
    private String text;
    private String time;          // temporary

    public Message(String username, String text) {
        this.username = username;
        this.text = text;

        // fetch current date time and transform it into particular pattern
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        time = dateFormatter.format(date);
    }

    public String getUsername(){ return username; }
    public String getText(){ return text; }
    public String getTime(){ return time; }
}
