/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import Model.Level;
import Model.Square.Square;
import Graphics.Texture;

/**
 *
 * @author q95
 */
public abstract class Characters {

    //ATTRIBUTS
    protected int powerCount;
    protected int position[][];

    //GETTER
    protected float x, y;
    protected boolean removed = false;
    protected Texture texture;
    protected Level level;

    protected float friction;
    protected float mass;

    //protected Vector2f shootPoint;
    //protected Vector2f mouseDirection;
    public Characters(int x, int y) {
        this.x = x * 16;
        this.y = y * 16;
    }

    public abstract void init(Level level);

    public abstract void update();

    public abstract void render();

    public boolean isApple() {

        if (level.getAppleSquare((int) (x + 4.6f) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }

        return false;
    }

    public boolean isLadder() {

        if (level.getLadderSquare((int) (x + 4.6f) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }

        return false;
    }

    public boolean isSolidSquare(float xa, float ya) {

        //taille bordure
        int x0 = (int) (x + xa + 3.8f) / 16;
        int x1 = (int) (x + xa + 13) / 16;
        int y0 = (int) (y + ya + 2) / 16;
        int y1 = (int) (y + ya + 15.8) / 16;

        if (level.getSolidSquare(x0, y0) != null) {
            return true;
        }
        if (level.getSolidSquare(x1, y0) != null) {
            return true;
        }
        if (level.getSolidSquare(x0, y1) != null) {
            return true;
        }
        if (level.getSolidSquare(x1, y1) != null) {
            return true;
        }

        return false;

    }

    public boolean isFreezeSquare(float xa, float ya) {

        //taille bordure
        int x0 = (int) (x + xa + 3.8f) / 16;
        int x1 = (int) (x + xa + 13) / 16;
        int y0 = (int) (y + ya + 2) / 16;
        int y1 = (int) (y + ya + 15.8) / 16;

        if (level.getFreezeSquare(x0, y0) != null) {
            return true;
        }
        if (level.getFreezeSquare(x1, y0) != null) {
            return true;
        }
        if (level.getFreezeSquare(x0, y1) != null) {
            return true;
        }
        if (level.getFreezeSquare(x1, y1) != null) {
            return true;
        }

        return false;

    }

    public boolean isFreezed() {

        if (level.getFreezeSquare((int) (x + 3.8f) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }
        if (level.getFreezeSquare((int) (x + 12) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }
        if (level.getFreezeSquare((int) (x + 4.6f) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }

        return false;
    }

    public boolean isGrounded() {

        if (level.getSolidSquare((int) (x + 3.8f) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }
        if (level.getSolidSquare((int) (x + 12) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }

        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean getRemoved() {
        return removed;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getPowerCount() {
        return this.powerCount;
    }

    public int[][] getPosition() {
        return this.position;
    }

    //SETTER
    public void setPowerCount() {
        this.powerCount++;
    }

    //OTHERS
    /* public void move(Square square){
        switch(square.getID()){
            case 1:
                setPowerCount();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                //freeze
                break;
            case 5:
                //goal
                break;
            case 6:
                //hyper
                break;
            case 7:
                //ladder
                break;
            default:
                break;
        }
    }*/
}
