package Submarines;

public class Submarines {
	//global constants 
	public static final float Drag = 0.6f;
	public static Window win;


	/**
	 * @param args
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
