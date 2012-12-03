package Submarines;
/**
 * Class with a graphic and colision, reprisents a physical, visebal object in the game 
 * @author Daniil
 *
 */
public class GraphicObject extends MovebalObject implements IColidebal {
	protected ISprite image;
	protected String tag;
	
	/**
	 * constructs a GraphicObject object
	 * @param posX
	 * vertical position
	 * @param posY
	 * horizontal position
	 * @param engine
	 * ponter to GameEngine
	 * @param image
	 * the Graphic
	 * @param Tag
	 * a tag for collusion handling purposes
	 */
	public GraphicObject(float posX, float posY, GameEngine engine, ISprite image,String Tag) {
		super(posX, posY, Submarines.Drag, engine);
		this.image = image;
	}
	/**
	 * constructs a GraphicObject object
	 * @param posX
	 * vertical position
	 * @param posY
	 * horizontal position
	 * @param engine
	 *  ponter to GameEngine
	 * @param image
	 * the Graphic
	 */
	public GraphicObject(float posX, float posY,  GameEngine engine, ISprite image) {
		super(posX, posY, Submarines.Drag, engine);
		tag = "MovebalObject";
		this.image = image;
	}
	
	@Override
	public void Update(float elipcedTime) {
		super.Update(elipcedTime);
		if(image instanceof Animation){
			((Animation)image).Update(elipcedTime);
		}
		
		
		if(this.getAABB()[0]+this.getAABB()[2]<0){
			engine.RemoveComp(this);
		}
	}
	
	@Override
	public void Draw(SpriteBatch batch) {
		batch.Draw(image, new int[]{this.getPositionX(), this.getPositionY()}, 2);
		
	}

	@Override
	public int[] getAABB() {
		return new int[]{ this.getPositionX(), this.getPositionY(), 
		           image.getWidth(), image.getHiht()
		           };
	}

	@Override
	public boolean[][] getBody() {
		return null;
	}
	
	
	@Override 
	public String getTag(){
		return tag;
	}

}
