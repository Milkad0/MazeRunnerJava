/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Square;

import Graphics.Texture;
import Controller.Component;
import Controller.Game;
import static Graphics.View.quadData;
import java.awt.Image;
import java.util.Random;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author asus
 */
public class Square {

    public int x, y;
    int xo = 0, yo = 0;
    boolean hasSquareSet = false;
    protected int size = 16;
    protected int halfsize = size / 2;

    float[] color = new float[]{1, 1, 1, 1};

    public int[] squareSprite = new int[]{0, 0, 0, 0, 0, 0, 0, 0};

    public int id;
    protected Image image;

    Squares square;

    public Square() {

    }
   

    public enum Squares {
        BRICK, EMPTY, FREEZE, APPLE, LADDER, GOAL, HYPER
    }

    public Square(int x, int y, Squares square) {
        this.x = x;
        this.y = y;
        this.square = square;

        if (square == Squares.BRICK) {
            yo = 0;
            xo = 0;
            hasSquareSet = true;
        } else if (square == Squares.EMPTY) {
            yo = 0;
            xo = 1;
        } else if (square == Squares.FREEZE) {
            yo = 0;
            xo = 2;
        } else if (square == Squares.APPLE) {
            yo = 0;
            xo = 3;
        } else if (square == Squares.LADDER) {
            yo = 0;
            xo = 4;
        }

        if (hasSquareSet) {
            squareSprite = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        }
    }

    public void setSquare() {

        squareSprite[0] = -2;
        squareSprite[1] = -2;
        squareSprite[2] = 0;
        squareSprite[3] = -2;

    }

    public void render() {
        float x0 = x + Game.xScroll / 16;
        float y0 = y + Game.yScroll / 16;

        if (x0 + 1 < 0 || y0 + 1 < 0 || x0 > Component.width / 16 || y0 > Component.height / 16) {
            return;
        }
        Texture.squares.bind();
        glBegin(GL_QUADS);

        if ((xo == 3 || xo == 0) && yo == 0) {
            quadData(this.x * size, this.y * size, this.halfsize, this.halfsize, this.color, xo + squareSprite[0], yo);
            quadData(this.x * size + 8, this.y * size, this.halfsize, this.halfsize, this.color, xo + squareSprite[1], yo);
            quadData(this.x * size + 8, this.y * size + 8, this.halfsize, this.halfsize, this.color, xo + squareSprite[2], yo);
            quadData(this.x * size, this.y * size + 8, this.halfsize, this.halfsize, this.color, xo + squareSprite[3], yo);
        } else {

            quadData(this.x * size, this.y * size, this.size, this.size, this.color, xo, yo);
        }

        glEnd();
        Texture.squares.unbind();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Square(int _id, Image _image) {
        this.id = _id;
        this.image = _image;
    }

}
