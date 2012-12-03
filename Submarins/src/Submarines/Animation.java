package Submarines;

import java.util.*;

public class Animation implements ISprite, IUpdatebal{
	
	protected ArrayList<Sprite> frames= new ArrayList<Sprite>();
	protected int curentframe = 1;
	protected float fps = 3;
	protected boolean playing = false;
	protected boolean loop = false;
	protected float timer = 0;
	
	public Animation() {
		
	}
	
	public void setfps(float fps){
		this.fps = fps;
	}
	
	public void setLoop( boolean loop){
		this.loop = loop;
	}
	
	public void Play(){
		playing = true;
	}
	
	public void Pouse(){
		playing = false;
	}
	
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
