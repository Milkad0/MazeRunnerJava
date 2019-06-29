/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Vincent
 */
public class Button {

    private String name;
    private Texture texture;
    private int x,y,width,height;
    
    public Button(String name, Texture texture, int x, int y, int width, int height) {
        
        this.name = name;
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
    }

    public Texture getTexture() {
        return texture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public Button(String name, Texture texture, int x, int y){
        
        this.name = name;
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = texture.getImageWidth();
        this.height = texture.getImageHeight();
    }
    
    public void replaceTexture(Texture texture){
        this.texture = texture;
        
    }

    public String getName() {
        return name;
    }
    
    
}
