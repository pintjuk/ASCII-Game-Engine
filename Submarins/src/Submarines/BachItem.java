package Submarines;
/**
 * An item to hold the sprite and aditional information in the colection of the spritebatch
 * @author Daniil
 * 
 */
public class BachItem {
	protected ISprite Sprite;
	protected int deapth;
	protected int[] position;
	
	/**
	 * constructs batchItem object
	 * @param sprite
	 * the sprite to be randerd
	 * @param position
	 * the position on the framebuffer 
	 * @param deapth
	 * the deapth higher values will owerlap lower ones 
	 */
	public BachItem(ISprite sprite, int[] position, int deapth) {
		this.Sprite = sprite;
		this.deapth = deapth;
		this.position = position;
	}
	
	/** returns volue of deapth */
	public int getDeapth(){
		return this.deapth;
	}
	
	/** returns the sprite*/
	public ISprite getSprite(){
		return this.Sprite;
	}
	
	/** returns the horisontal position */
	public int getPosX(){
		return this.position[0];
	}
	
	/** returnns the vertical position */
	public int getPosY(){
		return this.position[1];
	}
}
