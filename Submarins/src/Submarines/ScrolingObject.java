package Submarines;

public class ScrolingObject extends GraphicObject {
	public ScrolingObject(float posX, float posY, GameEngine engine,
			ISprite image, String Tag) {
		super(posX, posY, engine, image, Tag);
		// TODO Auto-generated constructor stub
	}


	protected float xscroloffset = 0;
	
	
	@Override
	public int getPositionX(){
		return (int)(posX-xscroloffset+0.5f);
	}
	

	@Override
	public void Update(float elipcedTime) {
		super.Update(elipcedTime);
		xscroloffset+=elipcedTime*3;
	}
	
	
}
