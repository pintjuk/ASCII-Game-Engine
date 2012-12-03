package Submarines;

import java.util.*;
/**
 * a class that renders ISprites to A frame Buffer 
 * @author Daniil
 *
 */
public class SpriteBatch {
	
	protected ArrayList <BachItem> toDraw;
	protected int width;
	protected int hight;
	/**
	 * constructs Sprite Batch object
	 * @param width
	 * width of frame buffer
	 * @param hight
	 * hight of frame buffer 
	 */
	public SpriteBatch(int width, int hight) {
		toDraw = new ArrayList<BachItem>();
		this.width = width;
		this.hight = hight;
	}
	
	/**
	 * adds an ISprite to be Drawn
	 * @param sprite
	 * the graphic
	 * @param position
	 * position, format: int[]{horzontal position, vertical position}
	 * @param deapth
	 * deapth of the graphic, higher values overlap lower ones 
	 */
	public void Draw(ISprite sprite, int[] position, int deapth){
		toDraw.add(new BachItem(sprite,position, deapth));
	}
	
	/**
	 * removes all objects set to be drawn
	 */
	public void Clear(){
		toDraw.clear();
	}
	
	/**
	 * renders all objects to the frame buffer and returns it 
	 * @param bgfill
	 * bacgorund fill color
	 * @return
	 * final frame buffer 
	 */
	public char[][] Rander(char bgfill){
		int[][] deapthStencile = new int[hight][width];
		char[][] frameBuffer = new char[hight][width];
		
		Fill(frameBuffer, width, hight, bgfill);
		
		for(BachItem i: toDraw){
			RanderSprite(i.getSprite(), frameBuffer, deapthStencile, 
						 i.getPosX(), i.getPosY(), i.getDeapth());
		}
		
		for(char[] y: frameBuffer ){
			
			Submarines.win.println(y);
		}
		
		
		return frameBuffer;
	}
	
	protected void RanderSprite(ISprite sprite, 
							  	char[][] fBuffer, 
							  	int[][] dStencile,  int pX, int pY, int depth){
		//sY are the object space y cordinates
		for(int sY= 0; sY<sprite.getHiht(); sY++){
			//sX are the object space x cordinates
			for(int sX= 0; sX<sprite.getWidth(); sX++){
				int fX = pX+sX; //fX are the frame space X cordinates
				int fY = pY+sY;	//fX are the frame space Y cordinates
				
				if(checkIfCordIsLeagal(fX, fY)){
					//draw the pixel if it is not coverd by another object
					if(dStencile[fY][fX]<= depth ){
						if(sprite.getPixel(sX, sY)!=(char)0){
							fBuffer[fY][fX]=sprite.getPixel(sX, sY);
							dStencile[fY][fX]=depth;
						}
					}
				}
			}
		}
		
	}
	private boolean checkIfCordIsLeagal(int x, int y){
		return (x<width)&&(x>=0)&&(y<hight)&&(y>=0);
	}
	private void  Fill(char[][] frameBuffer, int width, int hight, char bgfill){
		for(int y=0; y<hight; y++){
			for(int x=0; x<width; x++){
				frameBuffer[y][x]=bgfill;
			}
		}
			
	}
	/**
	 * returns framebuffer width
	 * @return
	 */
	public int getBackBufferWidth(){
		return width;
	}
	/**
	 * return framebuffer width
	 * @return
	 */
	public int getBackBufferHight(){
		return hight;
	}
	
}
