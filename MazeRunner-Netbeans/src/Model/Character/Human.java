/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import static Controller.View.renderCharacters;
import Model.Level;
import Model.Square.Square;
import Model.Square.Texture;

/**
 *
 * @author q95
 */
public  class Human extends Characters{
    
    //OTHERS
    public Human (int x,int y){
        super(x,y);
        texture = Texture.human;
    }
    @Override
    public void update(){
        
    }
    @Override
    public void render(){
        texture.bind();
        renderCharacters(x,y,16,16,new float[]{1,1,1,1},4.0f,0,0);
        texture.unbind();
    }

    @Override
    public void init(Level level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
