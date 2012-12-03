package Submarines;
/**
 * common Interface Fore all objects that are suposed to be randerd bay the Spritebatch
 * ex: Sprites and animations 
 * @author Daniil
 *
 */
public interface ISprite {
	/**
	 * returns the color of a pixel
	 * @param x
	 * vertical position
	 * @param y
	 * horizontal position
	 * @return
	 * color
	 */
	char getPixel(int x, int y);
	
	/**
	 * returns the size
	 * @return
	 * format: int[]{width, hight}
	 */
	int[] getSize();
	
	/**
	 * returns width
	 * @return
	 */
	int   getWidth();
	
	/**
	 * returns hight
	 * @return
	 */
	int   getHiht();
}
