package Submarines;
/**
 * a projectile that speeds to the right 
 * @author Daniil
 *
 */
public class Torpedo extends MovebalObject implements IComandListener, IColidebal{
	Animation torpidoAnim;
	/**
	 * constructs a torpedo 
	 * @param posX
	 * initial vertical position 
	 * @param posY
	 * initial horizontal position 
	 * @param e
	 * ponter to GameEngine 
	 */
	public Torpedo(float posX, float posY, GameEngine e) {
		super(posX, posY, Submarines.Drag, e);
		
		//submarinPic = new Sprite
		
		char[][] face = new char[][]{new char[]{'×', '<', '>'}};
		char[][] face2 = new char[][]{new char[]{'+', '<', '>'}};
		
		
		torpidoAnim = new Animation();
		torpidoAnim.addFrame(new Sprite(face[0].length, face.length, face));
		torpidoAnim.addFrame(new Sprite(face2[0].length, face2.length, face2));	
		torpidoAnim.setLoop(true);
		torpidoAnim.Play();
		this.velX = 10;
		this.accX = 100;
	}

	@Override
	public void ExComand(String Comand) {
		// TODO Auto-generated method stub
		if(Comand.equals("DET")){
			engine.RemoveComp(this);
		}
		
	}
	
	@Override
	public void Update(float elipcedTime) {
		super.Update(elipcedTime);
		torpidoAnim.Update( elipcedTime);
		
		if(this.posX > (engine.getFrameBufferWidth()+3)){
			//engine.RemoveComp(this);
		}
		
		IColidebal hit = engine.getHit(this);
		if(hit!=null)
			if(hit.getTag()!="Submarin")
				engine.RemoveComp(this);
		
	}
	
	

	@Override
	public void Draw(SpriteBatch batch) {
		batch.Draw(torpidoAnim, new int[]{this.getPositionX(), this.getPositionY()}, 1);
	
	}
	
	@Override
	public String getTag(){
		return "Torpedo";
	}
	public int[] getAABB(){
		return new int[]{ this.getPositionX(), this.getPositionY(), 
						torpidoAnim.getWidth(), torpidoAnim.getHiht()
				           };
	}
	
	public boolean[][] getBody(){
		return null;
	}

}
