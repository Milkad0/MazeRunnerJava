/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import Graphics.Animation;
import Graphics.Color;
import Graphics.Texture;
import static Graphics.View.renderCharacters;
import Model.Level;

/**
 *
 * @author q95
 */
public class Pacer extends Enemies{

    public Animation run, freeze;

    int dir = 0;
    float speed = 2.0f;
    int test = 0;

    public Pacer(int x, int y) {
        super(x, y);
        texture = Texture.pacer;
        run = new Animation(1, 1, 2, 5, true,false);
        freeze = new Animation(1, 1, 1, 5, true,false);

        mass = 1f;
        friction = 0.95f;
    }
    float xa, ya;

    public void update() {

        ya += level.gravity * mass;
        
        run.update();
        run.pause();
        freeze.update();
        freeze.stop();
        
        if (dir == 1){
            xa = -speed;
            run.play();
        }else if (dir == 0){
            xa = speed;
            run.play();
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
    public void render() {
        texture.bind();
        float sizeSpriteSheet = 7.0f;
        renderCharacters(x, y, 16, 16, Color.WHITE, sizeSpriteSheet, run.getCurrentFrame(), 0 + dir);
        texture.unbind();
    }

    @Override
    public void init(Level level) {
        this.level = level; //To change body of generated methods, choose Tools | Templates.
    }
}
