/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Square;

import java.awt.Image;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author asus
 */
public class Square {
    
    protected int x;
    protected int y;
    
    protected int id;
    protected Image image;
    
    public Square(){     
    }
    
     public static void quadData(int x,int y,int w,int h,float[] color){
        glColor4f(color[0],color[1],color[2],color[3]);
        glVertex2f(x,y);
        glVertex2f(x + w,y);
        glVertex2f(x+w,y+h);
        glVertex2f(x,y+h);
    }
    
    public static void renderQuad(int x,int y,int w,int h, float[] color){
        glBegin(GL_QUADS);
        quadData(x,y,w,h,color);
        glEnd();
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
