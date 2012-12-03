package Submarines;

import java.util.*;
/**
 * a class that creates an animation 
 * @author Daniil
 *
 */
public class Animation implements ISprite, IUpdatebal{
	
	protected ArrayList<Sprite> frames= new ArrayList<Sprite>();
	protected int curentframe = 1;
	protected float fps = 3;
	protected boolean playing = false;
	protected boolean loop = false;
	protected float timer = 0;
	
	/**
	 * default constructor  
	 */
	public Animation() {
		
	}
	
	/**
	 * set the speed of the animaation mesured in frames/second 
	 * @param fps
	 * frames per second 
	 */
	public void setfps(float fps){
		this.fps = fps;
	}
	
	/**
	 * set wether the animation should loop
	 * @param loop
	 * set to true to loop. set to fals to stop at the end of animation
	 */
	public void setLoop( boolean loop){
		this.loop = loop;
	}
	
	/**
	 * start playing the animation
	 */
	public void Play(){
		playing = true;
	}
	
	/**
	 * pause the animation at curent frame
	 */
	public void Pouse(){
		playing = false;
	}
	
	/**
	 * stop animation and go to start of the animation
	 */
	public void Stop(){
		playing = false;
		curentframe = 0;
	}
	
	@Override
	public void Update(float elipcedTime){
		if(playing){
			timer+=elipcedTime;
			if(timer>= (1/fps)){
				if(curentframe< (frames.size()-1)){
					curentframe++;
				}
				else{
					if(loop){
						curentframe = 0;
					}else{
						Pouse();
					}
				}
			}
		}
	}
	
	@Override
	public char getPixel(int x, int y) {
		// TODO Auto-generated method stub
		return frames.get(curentframe).getPixel(x, y);
	}

	@Override
	public int[] getSize() {
		return frames.get(curentframe).getSize();
	}
	
	@Override
	public int getWidth() {
		return frames.get(curentframe)!=null?frames.get(curentframe).getWidth():0;
	}
	
	@Override
	public int getHiht() {
		return frames.get(curentframe)!=null?frames.get(curentframe).getHiht():0;
	}
	
	public void addFrame(Sprite sprite){
		this.frames.add(sprite);
	}
	
	public void addFrame(char[][] sprite){
		this.addFrame(new Sprite(sprite[0].length,sprite.length, sprite ) );
	}

}
