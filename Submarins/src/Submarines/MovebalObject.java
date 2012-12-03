package Submarines;
/**
 * game object with with simpal acceliration and velocity intergation  
 * @author Daniil
 *
 */

public class MovebalObject extends GameObject {
	
	protected float posX, posY;//position
	protected float velX, velY;//vellocity
	protected float accX, accY;//acceleration
	protected float drag;
	
	/**
	 * returns vertical position
	 * @return
	 */
	public int getPositionX(){
		return (int)(posX+0.5f);
	}
	
	/**
	 * returns horzontal position
	 * @return
	 */
	public int getPositionY(){
		return (int)(posY+0.5f);
	}
	
	/**
	 * constructs object 
	 * @param posX
	 * horizontal position
	 * @param posY
	 * vertical position
	 * @param drag
	 * velosity damping factor 
	 * @param engine
	 * ponter to GameEngine
	 */
	public MovebalObject(float posX, float posY, float drag, GameEngine engine){
		super(engine);
		this.posX = posX;
		this.posY = posY;
		this.drag = drag;
	}
	
	@Override
	public void Update(float elipcedTime) {
		super.Update(elipcedTime);
		//integrete vellocity over time
		posX += velX*elipcedTime;
		posY += velY*elipcedTime;
		//integrate acceleration over time
		velX += accX*elipcedTime;
		velY += accY*elipcedTime;
		//dampen vellocity
		velX*=drag;
		velY*=drag;
		
	}

	@Override
	public void Draw(SpriteBatch batch) {
		// TODO Auto-generated method stub

	}
	
	

}
