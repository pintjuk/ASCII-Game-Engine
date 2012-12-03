package Submarines;

public class Sprite implements ISprite {
	protected char[][] data;
	protected int width;
	protected int hight;
	
	public Sprite(int width, int hight) {
		this.width = width;		
		this.hight = hight;
		data = new char[hight][width];
	}
	
	public Sprite(int width, int hight, char[][] data){
		this(width, hight);
		for(int y = 0; y<hight; y++)
			for(int x = 0; x<width; x++)
				this.data[y][x] = data[y][x];
	}

	@Override
	public char getPixel(int x, int y) {
		// TODO Auto-generated method stub
		if(x<width&&y<hight)
			return data[y][x];
		return 0;
	}

	@Override
	public int[] getSize() {
		return new int[] {hight, width};
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHiht() {
		return hight;
	}

}
