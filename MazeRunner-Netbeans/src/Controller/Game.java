/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Level;
import Model.Square.Square;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Vincent
 */
public class Game {

    Level level;

    public static float xScroll, yScroll;

    public Game() {
        level = new Level(Component.width / 16, Component.height / 16);
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
        level.update();

    }

    public void render() {
        //GL11.glTranslatef(xScroll, yScroll, 0);
        level.render();

    }

}
