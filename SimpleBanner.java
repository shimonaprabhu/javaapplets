import java.awt.*; 
import java.applet.*;
//<APPLET code="SimpleBanner" width=300 height=50> </APPLET>
public class SimpleBanner extends Applet implements Runnable 
{ 
    String msg = " Watch me run!"; Thread t = null; int state; boolean stopFlag;
// Set colors and initialize thread. 
    public void init() 
    { 
        setBackground(Color.green); 
        setForeground(Color.black); 
    }
    // Start thread 
    public void start() 
    { 
        t = new Thread(this); 
        stopFlag = false; t.start();
    }
    // Entry point for the thread that runs the banner. 
    public void run() 
    { 
        char ch; 
        for( ; ; ) 
        { 
            try 
            { 
                repaint(); 
                Thread.sleep(250); 
                ch = msg.charAt(0); 
                msg = msg.substring(1, msg.length()); 
                msg += ch; 
                if(stopFlag) 
                    break; 
                } 
            catch(InterruptedException e) 
            {
            } 
        }
    }
    // Pause the banner. 
    public void stop() 
    { 
        stopFlag = true; 
        t = null; 
    }
    // Display the banner.
    public void paint(Graphics g) 
    { 
        g.drawString(msg, 50, 30); 
    }
}
