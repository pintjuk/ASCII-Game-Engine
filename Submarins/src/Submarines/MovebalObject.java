package Submarines;

public class MovebalObject extends GameObject {
	
	protected float posX, posY;//position
	protected float velX, velY;//vellocity
	protected float accX, accY;//acceleration
	protected float drag;
	
	public int getPositionX(){
		return (int)(posX+0.5f);
	}
	
	public int getPositionY(){
		return (int)(posY+0.5f);
	}
	
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
