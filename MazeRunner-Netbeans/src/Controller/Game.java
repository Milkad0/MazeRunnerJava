/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Level;
import Model.Square.Square;

/**
 *
 * @author Vincent
 */
public class Game {
    
    Level level;
    
    public Game(){
        level = new Level(10,10);
    }
    
    public void init(){
        level.init();
    }
    
    public void update(){
        level.update();
        
    }
    
    public void render(){
        level.render();
     
    }
    
    
}

