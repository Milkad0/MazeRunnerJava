/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Square;


import Controller.Component;
import Controller.Game;
import java.awt.Image;
import java.util.Random;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author asus
 */
public class Square {
    
    public int x,y;
    int xo=0,yo=0;
    boolean hasSquareSet = false;
    protected int size = 16;
    public int halfsize = size/2;
    
    float [] color = new float []{1,1,1,1};
    
    public int[] squareSprite = new int[]{1,1,1,1,1,1,1,1};
    
    public int id;
    protected Image image;
    
    Squares square;
    
    
    public Square (){
        
    }
    
    public enum Squares {
        BRICK,EMPTY,FREEZE 
    }
    
    public Square(int x,int y,Squares square){     
        this.x = x;
        this.y = y;
        this.square = square;
        
        if(square == Squares.BRICK) {
            xo = 0;
            hasSquareSet = true;
        }else if(square == Squares.EMPTY){
            xo = 1;
        }else if(square == Squares.FREEZE){
            xo = 2;
        }
        
        if(hasSquareSet)squareSprite = new int[]{1,1,1,1,1,1,1,1};
    }
    
     public static void quadData(int x,int y,int w,int h,float[] color,int xo, int yo){
        glColor4f(color[0],color[1],color[2],color[3]);
        glTexCoord2f((0 + xo)/32.0f,(0 + yo)/32.0f); glVertex2f(x,y);
        glTexCoord2f((1 + xo)/32.0f,(0 + yo)/32.0f); glVertex2f(x + w,y);
        glTexCoord2f((1 + xo)/32.0f,(1 + yo)/32.0f); glVertex2f(x+w,y+h);
        glTexCoord2f((0 + xo)/32.0f,(1 + yo)/32.0f); glVertex2f(x,y+h);
    }
    
    public static void renderQuad(int x,int y,int w,int h, float[] color, int xo, int yo){
        glBegin(GL_QUADS);
        quadData(x,y,w,h,color, xo , yo);
        glEnd();
    }
    
    public void setSquare(boolean vr,boolean vl,boolean vd,boolean vu,boolean vur,boolean vul,boolean vdr,boolean vdl ){
        if (!hasSquareSet) return;
        if (vl) {
            squareSprite[0] = 0;
            squareSprite[1] = 1;
            squareSprite[6] = 0;
            squareSprite[7] = 1;
        }
        if (vr) {
            squareSprite[2] = 2;
            squareSprite[3] = 1;
            squareSprite[4] = 2;
            squareSprite[5] = 1;
        }
        if (vu) {
            squareSprite[0] = 1;
            squareSprite[1] = 0;
            squareSprite[2] = 1;
            squareSprite[3] = 0;
            if (vr) { 
                squareSprite[2] = 2; 
                squareSprite[3] = 0;
            }
            if (vl) { 
                squareSprite[0] = 0; 
                squareSprite[1] = 0;
            }
       }
    if (vd) {
        squareSprite[4] = 1;
        squareSprite[5] = 2;
        squareSprite[6] = 1;
        squareSprite[7] = 2;
            if (vr) { 
                squareSprite[4] = 2; 
                squareSprite[5] = 2;
            }
            if (vl) { 
                squareSprite[6] = 0; 
                squareSprite[7] = 2;
            }
    }

    if (vd && vr) {
        squareSprite[4] = 2;
        squareSprite[5] = 2;
    }
    if (vd && vl) {
        squareSprite[6] = 0;
        squareSprite[7] = 2;
    }

    if (vur && !vu && !vr) {
        squareSprite[2] = 3;
        squareSprite[3] = 1;
    }
    if (vdr && !vd && !vr) {
        squareSprite[4] = 3;
        squareSprite[5] = 0;
    }
    if (vul && !vu && !vl) {
        squareSprite[0] = 4;
        squareSprite[1] = 1;
    }
    if (vdl && !vd && !vl) {
        squareSprite[6] = 4;
        squareSprite[7] = 0;
    }
   }
    
    
    public void render(){
        float x0 = x+Game.xScroll/16;
        float y0 = y+Game.yScroll/16;
        
        if (x0+1 < 0 || y0+1 < 0 || x0 > Component.width/16|| y0 > Component.height/16) return;
        Texture.squares.bind();
        glBegin(GL_QUADS);
        quadData(this.x*size,this.y*size,this.halfsize,this.halfsize,this.color,xo+squareSprite[0],yo);
        quadData(this.x*size+8,this.y*size,this.halfsize,this.halfsize,this.color,xo+squareSprite[1],yo);
        quadData(this.x*size+8,this.y*size+8,this.halfsize,this.halfsize,this.color,xo+squareSprite[2],yo);
        quadData(this.x*size,this.y*size+8,this.halfsize,this.halfsize,this.color,xo+squareSprite[3],yo);
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
    
    public Square(int _id, Image _image){
        this.id = _id;
        this.image = _image;
    }
    
    
    
}
