/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Game.xScroll;
import static Controller.Game.yScroll;
import Graphics.UI;
import static Graphics.View.*;
import Model.Level;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import static sun.util.locale.UnicodeLocaleExtension.isKey;


/**
 *
 * @author Vincent
 */
public class MainMenu {
    
    //Level mainLevel;
    private Texture background;
    private UI menuUI;
     private int width = 600;
    private int height = 580;
    
    public MainMenu(){
      //mainLevel = new Level("Map 2");
      background = QuickLoadMenuTexture("mainmenu");
      menuUI = new UI();
      menuUI.addButton("Play","PlayButton", 237, 130, 70,30);
      menuUI.addButton("Quit","QuitButton", 0, 50, 70,30);
      
      
      
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
        if (UI.isKeyConfirmed()==1){
            StateManager.setState(1);
        }
        if (UI.isKeyConfirmed()==2){
            StateManager.setState(2);
        }
        if(UI.isKey()==1){
            menuUI.replaceButton("Play", "PlayButton");
            menuUI.replaceButton("Quit", "QuitButton2"); //Choix
         
    
      }else{
            menuUI.replaceButton("Quit", "QuitButton");
            menuUI.replaceButton("Play", "PlayButton2"); //Choix
           
        }
        
    }
    
    
}
