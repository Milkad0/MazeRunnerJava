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
public class MainMenu {
    
    //Level mainLevel;
    public static Texture background;
    private UI menuUI;
     private int width = 600;
    private int height = 580;
    private int testVal=0;
    
    public MainMenu(){
      //mainLevel = new Level("Map 2");
      background = QuickLoadMenuTexture("mainmenu");
      menuUI = new UI();
      menuUI.addButton("Play","PlayButton3", 237, 130, 80,30);//30
      menuUI.addButton("Quit","QuitButton4", 0, 50, 80,30);
      
      
      
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
        
        if(val==0){
            testVal=0;
            
        StateManager.setState(UI.isKeyMenuConfirmed());
        
        if(UI.isKeyMenu()==1){
            menuUI.replaceButton("Play", "PlayButton3");
            menuUI.replaceButton("Quit", "QuitButton4"); //Choix
         
    
      }else{
            menuUI.replaceButton("Quit", "QuitButton3");
            menuUI.replaceButton("Play", "PlayButton4"); //Choix
           
        }
        }else if(val==1){
            if(testVal==0){
            menuUI.removeButton();
            
      menuUI.addButton("Level1","Level1Select", 158,130, 35,30);//30
      menuUI.addButton("Level2","Level1", 50, 0, 35,30);
      menuUI.addButton("Level3","Level1", 50, 0, 35,30);
      menuUI.addButton("Level4","Level1", 50, 0, 35,30);
      menuUI.addButton("Level5","Level1", 50, 0, 35,30);
      //
      menuUI.addButton("Level6","Level1", -200,50, 35,30);//30
      menuUI.addButton("Level7","Level1", 50, 0, 35,30);
      menuUI.addButton("Level8","Level1", 50, 0, 35,30);
      menuUI.addButton("Level9","Level1", 50, 0, 35,30);
      menuUI.addButton("Level10","Level1", 50, 0, 35,30);
            testVal=1;
        }
            
        LevelManager.setLevel(UI.isKeyLevelMenuConfirmed());
        
        if(UI.isKeyLevelMenu()==0){
            menuUI.replaceButton("Level1","Level1Select");
            menuUI.replaceButton("Level2","Level2");
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
         
    
        }else if(UI.isKeyLevelMenu()==1){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2Select");
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
            

        }else if(UI.isKeyLevelMenu()==2){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2");
            menuUI.replaceButton("Level3","Level3Select");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
           
        }else if(UI.isKeyLevelMenu()==3){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2"); 
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4Select");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
           
        }else if(UI.isKeyLevelMenu()==4){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2"); 
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5Select");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
           
        }else if(UI.isKeyLevelMenu()==5){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2"); 
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6Select");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
           
        }else if(UI.isKeyLevelMenu()==6){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2"); 
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7Select"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
           
        }else if(UI.isKeyLevelMenu()==7){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2"); 
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8Select");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10");
           
        }else if(UI.isKeyLevelMenu()==8){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2"); 
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9Select");
            menuUI.replaceButton("Level10","Level10");
           
        }else if(UI.isKeyLevelMenu()==9){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2"); 
            menuUI.replaceButton("Level3","Level3");
            menuUI.replaceButton("Level4","Level4");
            menuUI.replaceButton("Level5","Level5");
            menuUI.replaceButton("Level6","Level6");
            menuUI.replaceButton("Level7","Level7"); 
            menuUI.replaceButton("Level8","Level8");
            menuUI.replaceButton("Level9","Level9");
            menuUI.replaceButton("Level10","Level10Select");
           
        }
        
        
            
        }
        
    }
}
    

