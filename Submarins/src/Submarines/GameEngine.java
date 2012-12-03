package Submarines;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class GameEngine implements KeyListener {
	private HashSet<Object> components = new HashSet<Object>() ;
	protected String input="";
	protected SpriteBatch batch;
	protected ContentLoader content;
	
	public GameEngine(SpriteBatch batch) {
		System.nanoTime();
		
		content = new ContentLoader("Content");
		this.batch = batch;
	}
	
	
	public void AddComponent(Object component){
		components.add( component);
	}
	
	public void RemoveComp(Object toremove){
		components.remove(toremove);
	}
	
	public void Update(){
		HashSet<IUpdatebal> updatebals= new HashSet<IUpdatebal>();
		for(Object component: components){
			if(component instanceof IUpdatebal){
				updatebals.add((IUpdatebal) component);
			}
		}
		for(IUpdatebal component: updatebals){
			component.Update((float)0.1f);
		}
	}
	
	public void ExComand(String Comand){
		for(Object component: components){
			if(component instanceof IComandListener){
				((IComandListener) component).ExComand(Comand);
			}
		}
	}
	public void Draw(){
		batch.Clear();
		
		for(Object component: components){
			if(component instanceof IDrawebal){
				((IDrawebal) component).Draw(batch);
			}
		}
		
		batch.Rander(/*(char)127*/'.');
		Submarines.win.println(">"+input);
	}
	/** Handle the key Typed event from the text field. */
	public void keyTyped(KeyEvent e) {
		int id = e.getID();
        if (id == KeyEvent.KEY_TYPED) {
            String c = String.valueOf(e.getKeyChar());
            input = input+c.toUpperCase().replace("\n", "");
        }
        
        
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode() == 10){
    		this.ExComand(input);
    		input="";
    	}
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
    	 if(e.getKeyCode() == 20){
    		 if(input.length()>0){
    			 input = input.substring(0, input.length()-1);
    		 }
    	 }
    }
    
    public int getFrameBufferWidth(){
    	return batch.getBackBufferWidth();
    }
    
    public int getFrameBufferHight(){
    	return batch.getBackBufferHight();
    }
    
    public Sprite loadSprite(String name){
		return content.Load(name);
    }
    public IColidebal getHit(IColidebal colider){
    	ArrayList<IColidebal> colidebals = new ArrayList<IColidebal>();
    	
		for(Object component: components){
			if(component instanceof IColidebal&&colider!=component){
				colidebals.add((IColidebal)component);
			}
		}
		colidebals = this.ColisionColing(colider, colidebals);
		if(colidebals.size()>0){
			return colidebals.get(0);
		}
		return null;
    	
    }
    private ArrayList<IColidebal> ColisionColing(IColidebal colider,ArrayList<IColidebal> colidebals){
    	ArrayList<IColidebal> result = new ArrayList<IColidebal>();
    	for(IColidebal colidebal: colidebals){
    		if(AABBHitTest(colider, colidebal)){
    			result.add(colidebal);
    		}
    	}
    	return result;
    }
    
    private boolean AABBHitTest(IColidebal colider, IColidebal colidie){
		//if colider left edg is withen the san of the colidie
		if((colider.getAABB()[0]+colider.getAABB()[2]>colidie.getAABB()[0])&&
		   (colider.getAABB()[0]+colider.getAABB()[2]<colidie.getAABB()[0]+colidie.getAABB()[2])){
			
			if((colider.getAABB()[1]+colider.getAABB()[3]>colidie.getAABB()[1])&&
		       (colider.getAABB()[1]+colider.getAABB()[3]<colidie.getAABB()[1]+colidie.getAABB()[3])){
				//hit from right benith
				return true;
			}
			
			if((colider.getAABB()[1]>colidie.getAABB()[1])&&
		       (colider.getAABB()[1]<colidie.getAABB()[1]+colidie.getAABB()[3])){
				//hit from right benith
				return true;
			}
		}
		
		if((colider.getAABB()[0]>colidie.getAABB()[0])&&
		   (colider.getAABB()[0]<colidie.getAABB()[0]+colidie.getAABB()[2])){
			
			if((colider.getAABB()[1]+colider.getAABB()[3]>colidie.getAABB()[1])&&
		       (colider.getAABB()[1]+colider.getAABB()[3]<colidie.getAABB()[1]+colidie.getAABB()[3])){
				//hit from right benith
				return true;
			}
			
			if((colider.getAABB()[1]>colidie.getAABB()[1])&&
		       (colider.getAABB()[1]<colidie.getAABB()[1]+colidie.getAABB()[3])){
				//hit from right benith
				return true;
			}
    		
    	}
    	return false;
    }
    
    private boolean perPixelHitTest(IColidebal colider, IColidebal colidie){
    	
    	return false;
    }
    
}
