/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Graphics.UI;
import Model.Level;
import Model.Square.Square;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Vincent
 */
public class Game {

    Level level;
    String[] Map ={"Map 1","Map 2","Map 3"};
   

    public static float xScroll, yScroll;

    public Game() {
        level = new Level(Map[2]);
        xScroll = level.getBounds(0);
        yScroll = level.getBounds(1);
    }

    public void init() {
        level.init();
    }

    public void translateView(float xa, float ya) {
        //xScroll += xa;
        //yScroll += ya;
    }

    public void update() {
        //translateView(-0.5f, -0.5f);
        //System.out.println(Level.getPlayer().getX());
        
        if (level.finish == false){
            level.update();
        }else{
            level = new Level(Map[2]);
        }
    }

    public void render() {
        GL11.glTranslatef(xScroll, yScroll, 0);
        level.render();

    }
}
