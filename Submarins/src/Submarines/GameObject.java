package Submarines;

/**
 * Represents a component that is drawebal and updatebal
 * @author Daniil
 *
 */
public class GameObject implements IDrawebal, IUpdatebal {
	protected GameEngine engine;
	public GameObject(GameEngine engine) {
		this.engine = engine;
	}

	@Override
	public void Update(float elipcedTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Draw(SpriteBatch batch) {
		// TODO Auto-generated method stub

	}

}
