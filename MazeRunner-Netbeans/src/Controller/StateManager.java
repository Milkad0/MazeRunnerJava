/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Game.xScroll;
import static Controller.Game.yScroll;
import static Controller.LevelManager.val;
import Graphics.UI;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Vincent
 */
public class StateManager {
    
    public static enum GameState {
        MAINMENU, GAME, EXIT
    }
    
    public static int val = 0;
    public static MainMenu mainMenu;
    public static LevelManager LevelManag;
    public static Game game;
    public static GameState[] choiceMenu ={GameState.MAINMENU,GameState.GAME,GameState.EXIT};
    //public static Editor editor;
    
    
    
    
    public static void init() {
        switch(choiceMenu[val]){
            
            case MAINMENU:
                if(mainMenu == null)
                    mainMenu = new MainMenu();
                    mainMenu.init();
                    break;
            case GAME:
 
                    
                break;
            case EXIT:
               
                
                break;
        }
    }
    
    public static void update() throws Exception{
        switch(choiceMenu[val]){
            case MAINMENU:
                    mainMenu.update();
                    break;
            case GAME:
               
                
                if(LevelManag==null){
                    LevelManag.init();
                }
                
                LevelManag.update();
                if(LevelManager.val ==-1){
                    val=0;
                    LevelManag = null;
                }
                
                
                break;
            case EXIT:
                
                 Component.stop();
                Component.exit();
                
                break;
        }
    }
    
     public static void render() {
        switch(choiceMenu[val]){
            case MAINMENU:
                    mainMenu.render();
                    break;
            case GAME:
                 
               
                LevelManag.render();
                break;
            case EXIT:
                
                break;

    }
     }
     
     public static void setState (int choice){
         val = choice;
         
         
     
     }
    
}
