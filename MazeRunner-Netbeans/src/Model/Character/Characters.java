/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;
import Model.Level;
import Model.Square.Square;
import Model.Square.Texture;

/**
 *
 * @author q95
 */
public abstract class Characters {
    
    //ATTRIBUTS
    protected int powerCount;
    protected int position[][];
    
    //GETTER
    
    protected int x, y;
	protected boolean removed = false;
	protected Texture texture;
	protected Level level;
	
	protected float drag;
	protected float mass;
	
	//protected Vector2f shootPoint;
	//protected Vector2f mouseDirection;
	
	public Characters(int x, int y) {
		this.x = x * 16;
		this.y = y * 16;
	}
	
	public abstract void init(Level level);
	public abstract void update();
	public abstract void render();
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getRemoved() {
		return removed;
	}
	
	public Texture getTexture() {
		return texture;
	}
        
    public int getPowerCount(){
        return this.powerCount;
    }
    public int[][] getPosition(){
        return this.position;
    }
    
    //SETTER
    public void setPowerCount(){
        this.powerCount++;
    }
    
    //OTHERS
   /* public void move(Square square){
        switch(square.getID()){
            case 1:
                setPowerCount();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                //freeze
                break;
            case 5:
                //goal
                break;
            case 6:
                //hyper
                break;
            case 7:
                //ladder
                break;
            default:
                break;
        }
    }*/
}
