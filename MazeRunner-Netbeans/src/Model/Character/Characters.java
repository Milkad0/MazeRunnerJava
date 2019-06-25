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
    protected float xStart, yStart;
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
        this.xStart = this.x;
        this.yStart = this.y;
    }

    public abstract void init(Level level);

    public abstract void update();

    public abstract void render();

    public boolean isApple() {

        if (level.getAppleSquare((int) (x + 8.9f) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }

        return false;
    }
    
    public void setPositionStart(){
        this.x = this.xStart;
        this.y = this.xStart;
    }
    
    public boolean isPacer(float xa, float ya) {
        
        //à checker
        int x0 = (int) (xa + 0) / 16;
        int x1 = (int) (xa + 13) / 16;
        int y0 = (int) (ya + 0) / 16;
        int y1 = (int) (ya + 13) / 16;
        
        if (((int)level.getPacer().getPositionX()/16 == x0) && ((int)level.getPacer().getPositionY()/16 == y0)) {
            return true;
        }else if (((int)level.getPacer().getPositionX()/16 == x1) && ((int)level.getPacer().getPositionY()/16 == y0)) {
            return true;
        }else if (((int)level.getPacer().getPositionX()/16 == x0) && ((int)level.getPacer().getPositionY()/16 == y1)) {
            return true;
        }else if (((int)level.getPacer().getPositionX()/16 == x1) && ((int)level.getPacer().getPositionY()/16 == y1)) {
            return true;
        }else{
            return false;    
        }
    }

    public boolean isLadder() {

        if ((level.getLadderSquare((int) (x + 3.8f) / 16, (int) (y + 16) / 16) != null)&&(level.getLadderSquare((int) (x + 8.9f) / 16, (int) (y + 16) / 16) != null)&&(level.getLadderSquare((int) (x + 13) / 16, (int) (y + 16) / 16) != null)) {//gauche && milieu && droite
            return true;
        }

        return false;
    }

    public boolean isSolidSquare(float xa, float ya) {

        //taille bordure
        int x0 = (int) (x + xa + 3.8f) / 16;
        int x1 = (int) (x + xa + 14) / 16;
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

        if (level.getFreezeSquare((int) (x + 3.8f) / 16, (int) (y + 16) / 16) != null) { //gauche
            return true;
        }
        if (level.getFreezeSquare((int) (x + 13) / 16, (int) (y + 16) / 16) != null) { //droite
            return true;
        }
        if (level.getFreezeSquare((int) (x + 8.9f) / 16, (int) (y + 16) / 16) != null) {//milieu
            return true;
        }

        return false;
    }

    public boolean isHyperSquare(float xa, float ya) {

        int x0 = (int) (x + xa + 3.8f) / 16;
        int x1 = (int) (x + xa + 13) / 16;
        int y0 = (int) (y + ya + 2) / 16;
        int y1 = (int) (y + ya + 15.8) / 16;

        if (level.getHyperSquare(x0, y0) != null) {
            return true;
        }
        if (level.getHyperSquare(x1, y0) != null) {
            return true;
        }
        if (level.getHyperSquare(x0, y1) != null) {
            return true;
        }
        if (level.getHyperSquare(x1, y1) != null) {
            return true;
        }

        return false;
    }
    
     public boolean isTeleport() {

        if ((level.getHyperSquare((int) (x + 3.8f) / 16, (int) (y + 16) / 16) != null)&&(level.getHyperSquare((int) (x + 8.9f) / 16, (int) (y + 16) / 16) != null)&&(level.getHyperSquare((int) (x + 13) / 16, (int) (y + 16) / 16) != null)) {//gauche && milieu && droite
            return true;
        }

        return false;
    }
     
     public boolean isBrick() {

         if ((level.getSolidSquare((int) (x + 3.8f) / 16, (int) (y + 16) / 16) != null)&&(level.getSolidSquare((int) (x + 8.9f) / 16, (int) (y + 16) / 16) != null)&&(level.getSolidSquare((int) (x + 13) / 16, (int) (y + 16) / 16) != null)) {//gauche && milieu && droite
            return true;
        }

        return false;
    }
    
    public boolean isGrounded() {

        if (level.getSolidSquare((int) (x + 3.8f) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }
        if (level.getSolidSquare((int) (x + 13) / 16, (int) (y + 16) / 16) != null) {
            return true;
        }

        return false;
    }
    
    //GETTER

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

    public float getPositionX() {
        return this.x;
    }
    
    public float getPositionY() {
        return this.y;
    }

    //SETTER
    public void setPowerCount() {
        this.powerCount++;
    }
    
    public void setPosition(float x, float y){
        this.x = x*16;
        this.y = y*16;
    }

    //OTHERS
   
}
