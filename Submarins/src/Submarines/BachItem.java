package Submarines;

public class BachItem {
	protected ISprite Sprite;
	protected int deapth;
	protected int[] position;
	
	public BachItem(ISprite sprite, int[] position, int deapth) {
		this.Sprite = sprite;
		this.deapth = deapth;
		this.position = position;
	}
	
	public int getDeapth(){
		return this.deapth;
	}
	
	public ISprite getSprite(){
		return this.Sprite;
	}
	public int getPosX(){
		return this.position[0];
	}
	public int getPosY(){
		return this.position[1];
	}
}
