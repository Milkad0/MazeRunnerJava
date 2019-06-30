/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.StateManager.mainMenu;


/**
 *
 * @author Vincent
 */
public class LevelManager {
    
   public static enum LevelState {
        LevelMenu, MAP1, MAP2, MAP3, MAP4, MAP5, MAP6, MAP7, MAP8, MAP9, MAP10
    }
    
    public static int val = 0;
    public static Game game;
    public static LevelSelectMenu LevelMenu;
    public static LevelState[] choiceLevel ={LevelState.LevelMenu,LevelState.MAP1,LevelState.MAP2,LevelState.MAP3,LevelState.MAP4,LevelState.MAP5,LevelState.MAP6,LevelState.MAP7,LevelState.MAP8,LevelState.MAP9,LevelState.MAP10};
    //public static Editor editor;
    
    
    
    
    public static void init() {
        switch(choiceLevel[val]){
            
            case LevelMenu:
                
               /* if(LevelMenu==null){
                LevelMenu = new LevelSelectMenu();
                    LevelMenu.init();
                }*/
                if(mainMenu == null){
                    mainMenu = new MainMenu();
                    mainMenu.init();
                }
                break;
            
            case MAP1:
                if(game == null){
                    game = new Game("Map 1");
                    game.init();
                }
                
                    
                    break;
            case MAP2:
               if(game == null){
                    game = new Game("Map 2");
                    game.init();
                }
                
                 
                    
                break;
            case MAP3:
               if(game == null){
                    game = new Game("Map 3");
                    game.init();
                }
                
                
                break;
        }
    }
    
    public static void update(){
        switch(choiceLevel[val]){
            case LevelMenu:
            //LevelMenu.update();
                mainMenu.update();
            break;
            
            default:
                   if(game!=null){
                    game.update();
                   }
                break;
        }
    }
    
     public static void render() {
         switch(choiceLevel[val]){
            
            case LevelMenu:
                
                if(mainMenu!=null){
                    mainMenu.render();
                }
                break;
            
            case MAP1:
                if(game != null){
                game.render();
                }
                    
                    break;
            case MAP2:
               if(game != null){
                game.render();
                }
                 
                    
                break;
            case MAP3:
               if(game != null){
                game.render();
                }
                
                break;
        }
              
        

    }
     
     
     public static void setLevel (int choice){
         val = choice;
        
     }
}
 
    
    

