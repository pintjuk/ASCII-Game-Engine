package Submarines;

/**
 * currently not used 
 * @author Daniil
 *
 */

public class Rock extends MovebalObject 
				  implements IColidebal{
	protected Sprite rockTex;
	protected Animation Gras;
	public Rock(float posX, float posY, GameEngine engine) {
		super(posX, posY, Submarines.Drag, engine);
		char[][] face = new char[][]{new char[]{(char)0, ' ', '_', '_', (char)182, '_', '_', ' '},
				 					 new char[]{'×', '<', '_', '_',      '_', '±', '_', ')'}};
		rockTex = engine.loadSprite("rock");
		this.makeGras();
		
	}
	
	@Override
	public void Update(float elipcedTime) {
		super.Update(elipcedTime);
		Gras.Update(elipcedTime);

	}
	
	@Override 
	public String getTag(){
		return "Rock";
	}

	@Override
	public void Draw(SpriteBatch batch) {
		batch.Draw(rockTex, new int[]{this.getPositionX(), this.getPositionY()}, 2);
		//batch.Draw(Gras, new int[]{this.getPositionX()+4, this.getPositionY()-}, 2);
	}
	
	public void makeGras(){
		Gras = new Animation();

		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{'|'}}));
		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{'('}}));
		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{'\\'}}));
		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{'('}}));
		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{'|'}}));
		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{')'}}));
		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{'/'}}));
		Gras.addFrame(new Sprite(1, 1, new char[][]{new char[]{')'}}));
		Gras.setLoop(true);
		Gras.Play();
	}
	
	public int[] getAABB(){
		return new int[]{ this.getPositionX(), this.getPositionY(), 
				           rockTex.getWidth(), rockTex.getHiht()
				           };
	}
	
	public boolean[][] getBody(){
		return null;
	}
}
