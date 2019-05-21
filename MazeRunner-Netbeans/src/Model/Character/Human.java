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
public class Human extends Characters {

    Animation run, jump, climb, freeze;

    int dir = 0;
    float speed = 1.5f;
    boolean freezed = false;

    public Human(int x, int y) {
        super(x, y);
        texture = Texture.human;
        run = new Animation(1, 1, 4, 5, true);
        jump = new Animation(1, 1, 1, 5, true);
        climb = new Animation(1, 2, 3, 5, true);
        freeze = new Animation(4, 4, 4, 5, true);

        mass = 0.1f;
        friction = 0.95f;
    }
    float xa, ya;

    public void update() {

        if (!isLadder()) {
            ya += level.gravity * mass;
        }
        run.update();
        run.pause();
        climb.update();
        climb.pause();
        //freeze.update();
        

        if (Keyboard.isKeyDown(Keyboard.KEY_Z) || Keyboard.isKeyDown(Keyboard.KEY_W)) {
            if (isGrounded()) {
                ya -= 3.8f;
                dir = 2;
                run.play();

            } else if (isLadder()) {
                ya -= 0.6f;
                dir = 2;
                climb.play();

            }

        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            ya += 0;
            if (isLadder()) {
                ya += 0.6f;
                dir = 2;
                climb.play();
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_Q) || Keyboard.isKeyDown(Keyboard.KEY_A)) {
            xa -= speed;
            dir = 1;
            run.play();

            if (isLadder()) {
                ya -= 0.1f;

            }

        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {

            xa += speed;
            dir = 0;
            run.play();

            if (isLadder()) {
                ya -= 0.1f;
            }

        }

        if (isFreezed() && freezed == false) {
            dir = 2;
            xa *= -0.5 + friction;
            
           
            long timerBefore = System.currentTimeMillis();
            long duration = 0;

                freeze.play();
                freeze.update();
                render();
            
            while ((duration < 3000)&&(freeze.getPlaying())) {
                
                duration = System.currentTimeMillis() - timerBefore;
            }
            freezed = true;
        } else {
            freeze.pause();
        }
        
        
        
        int xStep = (int) Math.abs(xa * 1000);
        for (int i = 0; i < xStep; i++) {
            if (!isSolidSquare(xa / xStep, 0) && !isFreezeSquare(xa / xStep, 0)) {
                x += xa / xStep;
            } else {
                xa = 0;
            }
        }

        int yStep = (int) Math.abs(ya * 1000);
        for (int i = 0; i < yStep; i++) {
            if (!isSolidSquare(0, ya / yStep) && !isFreezeSquare(0, ya / yStep)) {
                y += ya / yStep;
            } else {
                ya = 0;

            }
        }

        xa = 0;
        if (!isLadder()) {
            ya *= friction;
        } else {
            ya = 0;
        }
    }

    @Override
    public void render() {
        texture.bind();

        if (climb.getPlaying()) {
            renderCharacters(x, y, 16, 16, Color.WHITE, 4.0f, climb.getCurrentFrame(), 0 + dir);
        } else if (freeze.getPlaying()) {
            renderCharacters(x, y, 16, 16, Color.WHITE, 4.0f, freeze.getCurrentFrame(), 0 + dir);

        } else {

            renderCharacters(x, y, 16, 16, Color.WHITE, 4.0f, run.getCurrentFrame(), 0 + dir);
        }
        texture.unbind();
    }

    @Override
    public void init(Level level) {
        this.level = level; //To change body of generated methods, choose Tools | Templates.
    }
}
