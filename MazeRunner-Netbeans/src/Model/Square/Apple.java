/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Square;

import java.awt.Image;

/**
 *
 * @author q95
 */
public class Apple extends Square{
    
    private boolean appleHere = true;
    
    public Apple(){
        super(1, null);
        this.setImage(image);
        this.id = 1;
    }
    
    public Apple(boolean _appleHere){
        super(1, null);
        this.setImage(image);
        this.appleHere = _appleHere;
    }

    public void setAppleHere(boolean appleHere) {
        this.appleHere = appleHere;
    }
    
    
    
}
