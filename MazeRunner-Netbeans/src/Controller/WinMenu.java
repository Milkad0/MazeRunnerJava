/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LevelManager.totalpower;
import static Controller.StateManager.val;
import Graphics.UI;
import static Graphics.View.*;
import static Model.Character.Human.numberkey;
import static Model.Character.Human.power;
import static Model.Level.minute;
import static Model.Level.seconde;
import org.newdawn.slick.opengl.Texture;


/**
 *
 * @author Vincent
 */
public class WinMenu {
    
    //Level mainLevel;
    public static Texture backgroundw;
    private UI menuUII;
     private int width = 590;
    private int height = 580;
    private int testVal=0;
    
    public WinMenu(){
      //mainLevel = new Level("Map 2");
      backgroundw = QuickLoadMenuTexture("WinMenu");
      menuUII = new UI();
      menuUII.addButton("Back","BackButton", 190, 225, 80,30);
      menuUII.addButton("Next","NextButton", 90, 0, 80,30);
      
      
      
    }
    
     public void init() {
         
         menuUII.initGL();
         menuUII.initFont(25, false, false);
               
    }
    public void update() {
       updateButtons();
        
        
    }
    

    public void render() {
        
        
        renderBackground(backgroundw,0,0,width,height);
        menuUII.draw();
        menuUII.drawString(-50, -117, ":   "+totalpower);
        if(Controller.LevelManager.lastminute==0){
        menuUII.drawString(-50, -70, ":   "+ Controller.LevelManager.lastseconde+"s");   
        }else{
        menuUII.drawString(-50, -70, ":   "+Controller.LevelManager.lastminute+"m"+ Controller.LevelManager.lastseconde+"s"); 
        }
        
        
        
        //GL11.glTranslatef(xScroll, yScroll, 0);
        //mainLevel.render();

    }
    
    
    
    public void updateButtons(){
        
       LevelManager.setLevel(UI.isKeyWinMenuConfirmed());
        
        if(UI.isKeyWinMenu()==1){
            menuUII.replaceButton("Back", "BackButton");
            menuUII.replaceButton("Next", "NextButton2"); //Choix
         
    
      }else{
            menuUII.replaceButton("Back", "BackButton2");
            menuUII.replaceButton("Next", "NextButton"); //Choix
           
        }
        
        
            
        
        
    }
}
    

