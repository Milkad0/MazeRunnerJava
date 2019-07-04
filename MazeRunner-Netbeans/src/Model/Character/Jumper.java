/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import Graphics.Animation;
import Graphics.Color;
import Graphics.MyTexture;
import static Graphics.View.renderCharacters;
import Model.Level;
import static java.lang.Thread.sleep;

/**
 *
 * @author q95
 */
public class Jumper extends Enemies{

    Animation tempo, jump, freeze;
    
    float speedX = 3f;
    float speedY = 12f;
    int test = 0;
    boolean freezed = false;
    int testFreeze = 0;

    public Jumper(int x, int y) {
        super(x, y);
        texture = MyTexture.jumper;
        jump = new Animation(1, 1, 3, 2, true,false);
        freeze = new Animation(5, 5, 5, 5, true,false);
        tempo = new Animation(1, 1, 1, 2, true,false);

        mass = 0.1f;
        friction = 0.95f;
    }
    float xa, ya;
    
    public void update() {
        
        int minPause = 3;
        int maxPause = 8;
        int randomPause = minPause + (int)(Math.random() * ((maxPause - minPause) + 1));
        int minSpeedY = 3;
        int maxSpeedY = 10;
        int randomSpeedY = minSpeedY + (int)(Math.random() * ((maxSpeedY - minSpeedY) + 1));
        int minSpeedX = 1;
        int maxSpeedX = 4;
        int randomSpeedX = minSpeedX + (int)(Math.random() * ((maxSpeedX - minSpeedX) + 1));
        
        
        ya += level.gravity * mass;

        jump.update();
        jump.pause();
        freeze.update();
        freeze.pause();
        tempo.update();
        tempo.pause();

        if (dir == 1){
            xa = -randomSpeedX;
            if (isGrounded()) {
                try {
                    jump.pause();
                    tempo.play();
                    sleep(randomPause*1000);
                } catch (InterruptedException ex) {
                }
                ya -= randomSpeedY;
            }
            jump.play();
        }else if (dir == 0){
            xa = randomSpeedX;
            if (isGrounded()) {
                try {
                    jump.pause();
                    tempo.play();
                    sleep(randomPause*1000);
                } catch (InterruptedException ex) {
                }
                ya -= randomSpeedY;
            }
            jump.play();
        }

        if (isFreezed() && freezed == false) {
            long timerBefore = System.currentTimeMillis();
            long duration = 0;
            int random_duration = (int) (1 + (Math.random() * (3 - 1)));
            freeze.play();
            testFreeze++;
            if (testFreeze == 2) {
                freezed = true;
                testFreeze = 0;
                while ((duration < random_duration * 1000) && (freeze.getPlaying())) {

                    duration = System.currentTimeMillis() - timerBefore;
                }
            }

        } else if (!isFreezed()) {
            freeze.pause();
            freezed = false;
        } else {
            xa *= 0.5 + friction;
            freeze.pause();
        }

        int xStep = (int) Math.abs(xa * 1000);
        for (int i = 0; i < xStep; i++) {
            if (!isSolidSquare(xa / xStep, 0) && !isFreezeSquare(xa / xStep, 0) && !isHyperSquare(xa / xStep, 0)) {
                x += xa / xStep;
            } else {
                xa = 0;
                if(dir == 0){
                    dir = 1;
                }else{
                    dir = 0;
                }
            }
        }

        int yStep = (int) Math.abs(ya * 1000);
        for (int i = 0; i < yStep; i++) {
            if (!isSolidSquare(0, ya / yStep) && !isFreezeSquare(0, ya / yStep) && !isHyperSquare(0, ya / yStep)) {
                y += ya / yStep;
            } else {
                ya = 0;
            }
        }

    }
    
    
    @Override
    public void run(){
        while(level.finish==false){
            try {
                update();
                sleep(15);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public void render() {
        texture.bind();
        float sizeSpriteSheet = 7.0f;
        renderCharacters(x, y, 16, 16, Color.WHITE, sizeSpriteSheet, jump.getCurrentFrame(), 0 + dir);
        texture.unbind();
    }

    @Override
    public void init(Level level) {
        this.level = level; //To change body of generated methods, choose Tools | Templates.
    }
}
