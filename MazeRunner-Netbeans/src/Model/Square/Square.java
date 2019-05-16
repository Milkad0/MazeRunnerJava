/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Square;

import java.awt.Image;

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
