package Submarines;
/**
 * an interface fore Classes that suport Collusion 
 * @author Daniil
 *
 */
public interface IColidebal {
	/**
	 * returns a axis-aligend-bounding-box 
	 * @return
	 * format: int[]{horisontal position, vertical position, width, hight}
	 */
	public int[] getAABB();
	
	/**
	 * not suported yet  
	 * @return
	 */
	public boolean[][] getBody();
	
	/**
	 * returns a string for identification 
	 * @return
	 */
	public String getTag();
}
