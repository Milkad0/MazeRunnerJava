/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.StateManager.val;
import Graphics.UI;
import static Graphics.View.*;
import org.newdawn.slick.opengl.Texture;


/**
 *
 * @author Vincent
 */
public class WinMenu {
    
    //Level mainLevel;
    public static Texture background;
    private UI menuUI;
     private int width = 200;
    private int height = 300;
    private int testVal=0;
    
    public WinMenu(){
      //mainLevel = new Level("Map 2");
      background = QuickLoadMenuTexture("mainmenu");
      menuUI = new UI();
      menuUI.addButton("Play","PlayButton", 237, 130, 80,30);//30
      menuUI.addButton("Quit","QuitButton", 0, 50, 80,30);
      
      
      
    }
    
     public void init() {
       // mainLevel.init();
    }
    public void update() {
       updateButtons();
        //mainLevel.update();
        
    }
    

    public void render() {
        renderBackground(background,0,0,width,height);
        menuUI.draw();
        
        //GL11.glTranslatef(xScroll, yScroll, 0);
        //mainLevel.render();

    }
    
    
    
    public void updateButtons(){
        
       
        
        
            
        
        
    }
}
    

