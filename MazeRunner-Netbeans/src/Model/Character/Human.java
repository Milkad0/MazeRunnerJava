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
    float speed = 2f;
    
    public Human (int x,int y){
        super(x,y);
        texture = Texture.human;
        anim = new Animation(4, 5, true);
        
        mass = 0.1f;
        friction = 0.95f;
    }
    float xa,ya;
    public void update(){
        
        ya += level.gravity*mass;
        
        anim.update();
        anim.pause();
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)||Keyboard.isKeyDown(Keyboard.KEY_W)){
            if (isGrounded())
            ya -= 3.8f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            ya += 0;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)||Keyboard.isKeyDown(Keyboard.KEY_A)){
            xa -= speed;
            dir = 1;
            anim.play();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            xa += speed;
            dir = 0;
            anim.play();
        }
        int xStep = (int) Math.abs(xa*1000);
        for (int i=0;i<xStep;i++){
            if(!isSolidSquare(xa/xStep,0)){
                x+=xa/xStep;
            }else{
                xa=0;
            }
        }
        int yStep = (int) Math.abs(ya*1000);
        for (int i=0; i<yStep; i++){
            if(!isSolidSquare(0,ya/yStep)){
                y+=ya/yStep;
            }else{
                ya=0;
            }
        }
        
        xa = 0;
        ya *= friction;
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
