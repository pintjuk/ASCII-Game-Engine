package Submarines;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Window extends JFrame
					implements KeyListener{
	protected String buffer="";
	protected String input="";
	
	protected JTextArea Display;
	
	
	
	public Window(KeyListener engine)
	{
		this(engine, 800, 600, new Font("courier new", Font.BOLD, 11), new Color(0, 0, 0), new Color(0, 255, 0));
	}
	
	public Window (KeyListener engine,int Width, int Hight, Font font, Color bgColor, Color fgColor){
		Display = new JTextArea();
		this.setSize(Width, Hight);
		Display.setBackground(bgColor);
		Display.setForeground(fgColor);
		Display.setFont(font);
		Display.setEditable(false);
		Display.addKeyListener(engine);
		this.add(Display);
		//rederectSystemOutput();
	}
	
	public void println(char[] output){
		println(String.copyValueOf(output));
	}
	
	public void println(String output){
		buffer = buffer+"\n"+output;
	}
	
	public void Update(){
		Display.setText(buffer);
	}
	
	/**does what the title says*/
	private void rederectSystemOutput(){
		OutputStream out = new OutputStream() {
		    @Override
		    public void write(int b) throws IOException {
		      updateTextBuffer(String.valueOf((char) b));
		    }
		 
		    @Override
		    public void write(byte[] b, int off, int len) throws IOException {
		      updateTextBuffer(new String(b, off, len));
		    }
		 
		    @Override
		    public void write(byte[] b) throws IOException {
		      write(b, 0, b.length);
		    }
		  };
		 
		  System.setOut(new PrintStream(out, true));
		  System.setErr(new PrintStream(out, true));
	}
	/** Handle the key Typed event from the text field. */
	public void keyTyped(KeyEvent e) {
		int id = e.getID();
        if (id == KeyEvent.KEY_TYPED) {
            String c = String.valueOf(e.getKeyChar());
            input = input+c.toUpperCase();
        }
       // map[0][0]=e.getKeyChar();
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
    	 if(e.getKeyCode() == 20){
    		 if(input.length()>0){
    			 input = input.substring(0, input.length()-1);
    		 }
    	 }
    }
    
    private void updateTextBuffer(final String text) {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      
		    		buffer = buffer+text;
		    	
		    }
		  });
		}
    
    /**removes all text from the buffer*/
    public void Clear(){
    	buffer = "";
    }
    
    /**returns input*/
    public String getInput(){
    	return input;
    }
    
    
}
