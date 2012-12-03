package Submarines;
/**
 * a playebal submarin. it can move around the screen and fire torpidos 
 * @author Daniil
 *
 */
public class Submarin extends MovebalObject
					  implements IComandListener, 
					  			 IColidebal{
	
	
	Animation sub;
	
	public Submarin(GameEngine engine) {
		super(10, 7,Submarines.Drag, engine);
		//submarinPic = new Sprite
		
		sub = new Animation();
		sub.addFrame(engine.loadSprite("sub1"));
		sub.addFrame(engine.loadSprite("sub2"));	
		sub.setLoop(true);
		sub.Play();
		
		
		ContentLoader loader = new ContentLoader("Content");
		Sprite rock = loader.Load("rock");
		
		//engine.AddComponent(new Rock(19, 20, engine));
		engine.AddComponent(new ScrolingObject(150, 10,engine, engine.loadSprite("GameOverSign"), "Rock"));
		engine.AddComponent(new ScrolingObject(70, 5,engine, engine.loadSprite("scotaloo"), "Rock"));
		
	}
	
	@Override
	public void Update(float elipcedTime) {
		super.Update(elipcedTime);
		sub.Update( elipcedTime);
		
		if(engine.getHit(this)!=null){
			System.out.println("hit");
		}

	}
	
	@Override
	public String getTag(){
		return "Submarin";
	}

	@Override
	public void Draw(SpriteBatch batch) {
		batch.Draw(sub, new int[]{this.getPositionX(), this.getPositionY()}, 2);

	}
	
	@Override
	public void ExComand(String Comand){
		if(Comand.replace(" ", "").equals("HALT")){
			this.velX = this.velY = this.accX = this.accY= 0;
		}
		
		if(Comand.replace(" ", "").equals("ASS")){
			this.accY = -10;
		}
		
		if(Comand.replace(" ", "").equals("SUB")){
			this.accY = 10;
		}
		
		if(Comand.replace(" ", "").equals("FOR")){
			this.accX = 10;
		}
		
		if(Comand.replace(" ", "").equals("BAC")){
			this.accX = -10;
		}
		
		if(Comand.replace(" ", "").equals("FIRE")){
			engine.AddComponent(new Torpedo(this.getPositionX(), this.getPositionY()+1, engine));
		}
	}
	@Override 
	public int[] getAABB(){
		return new int[]{ this.getPositionX(), this.getPositionY(), 
				           sub.getWidth(), sub.getHiht()
				           };
	}
	@Override
	public boolean[][] getBody(){
		return null;
	}

}
