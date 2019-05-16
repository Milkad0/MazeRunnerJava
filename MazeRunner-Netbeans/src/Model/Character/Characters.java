/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;
import Model.Square.Square;

/**
 *
 * @author q95
 */
public class Characters {
    
    //ATTRIBUTS
    protected int powerCount;
    protected int position[][];
    
    //GETTER
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
    public void move(Square square){
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
    }
}
