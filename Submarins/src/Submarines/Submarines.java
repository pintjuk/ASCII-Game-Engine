package Submarines;
/**
 * a class thet holds the program entry point and some global constants 
 * @author Daniil
 *
 */
public class Submarines {
	//global constants 
	/**
	 * the amount moving objects reduse speed every second
	 */
	public static final float Drag = 0.6f;
	
	/**
	 * window that displays graphics
	 */
	public static Window win;


	/**
	 * entry point
	 * @param args
	 * none   
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		SpriteBatch batch = new SpriteBatch(110, 30);
		GameEngine Engine = new GameEngine(batch);
		
		win = new Window(Engine);
		win.show();
		
		
	
	    Submarin player = new Submarin(Engine);
	    Engine.AddComponent(player);
		
		//keep updating the game while the window is showing 
		while(win.isShowing()){
			
			Engine.Update();
			Engine.Draw();
			System.out.println(win.getInput());
			Thread.sleep(100);
			win.Update();
			win.Clear();
			
		}
		System.exit(0);
		

	}
	
	


}
