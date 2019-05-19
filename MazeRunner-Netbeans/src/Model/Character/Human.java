/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import Graphics.Animation;
import Graphics.Color;
import static Graphics.View.renderCharacters;
import Model.Level;
import Model.Square.Square;
import Graphics.Texture;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author q95
 */
public  class Human extends Characters{
    
    Animation anim;
    int dir = 0;
    
    public Human (int x,int y){
        super(x,y);
        texture = Texture.human;
        anim = new Animation(4, 5, true);
    }
    float xa,ya;
    public void update(){
        anim.update();
        anim.pause();
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)||Keyboard.isKeyDown(Keyboard.KEY_W)){
            ya = -1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            ya = 1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)||Keyboard.isKeyDown(Keyboard.KEY_A)){
            xa = -1;
            dir = 1;
            anim.play();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            xa = 1;
            dir = 0;
            anim.play();
        }
        
        if(!isSolidSquare(xa,0)){
        x+=xa;
        xa=0;
        }
        if(!isSolidSquare(0,ya)){
        y+=ya;
        ya=0;
        }
        xa=0;
        ya=0;
    }
    @Override
    public void render(){
        texture.bind();
        renderCharacters(x,y,16,16,Color.WHITE,4.0f,anim.getCurrentFrame(),0+dir);
        texture.unbind();
    }

    @Override
    public void init(Level level) {
        this.level = level; //To change body of generated methods, choose Tools | Templates.
    }
}
