package Submarines;

import java.util.*;

public class SpriteBatch {
	
	protected ArrayList <BachItem> toDraw;
	protected int width;
	protected int hight;
	public SpriteBatch(int width, int hight) {
		toDraw = new ArrayList<BachItem>();
		this.width = width;
		this.hight = hight;
	}
	
	public void Draw(ISprite sprite, int[] position, int deapth){
		toDraw.add(new BachItem(sprite,position, deapth));
	}
	
	public void Clear(){
		toDraw.clear();
	}
	
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
	
	public int getBackBufferWidth(){
		return width;
	}
	
	public int getBackBufferHight(){
		return hight;
	}
	
}
