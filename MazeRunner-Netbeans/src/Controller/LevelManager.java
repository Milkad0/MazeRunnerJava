/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Component.LevelCheck;
import static Controller.Game.level;
import static Controller.StateManager.mainMenu;
import static Controller.StateManager.val;
import Graphics.UI;
import static Graphics.View.QuickLoadMenuTexture;
import static Graphics.View.renderBackground;


/**
 *
 * @author Vincent
 */
public class LevelManager {
    
   
   
  
    public static int totalpower=0;
    public static int lastminute=0;
    public static int lastseconde =0;
    public static int val = 0;
    public static int valLv;
    public static Game game;
    public static WinMenu winmenu;
    public static GameOverMenu gameovermenu;
    
    public static LevelState[] choiceLevel ={LevelState.LevelMenu,LevelState.MAP1,LevelState.MAP2,LevelState.MAP3,LevelState.MAP4,LevelState.MAP5,LevelState.MAP6,LevelState.MAP7,LevelState.MAP8,LevelState.MAP9,LevelState.MAP10, LevelState.WinMenu,LevelState.GameOverMenu};
    //public static Editor editor;
    
    public static enum LevelState {
        LevelMenu, MAP1, MAP2, MAP3, MAP4, MAP5, MAP6, MAP7, MAP8, MAP9, MAP10, WinMenu, GameOverMenu
    }
    
    
     public void initValLevelManager(){
       val=0;
       game = null;
       
   }
    
    
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
                
                if(game == null&&LevelCheck[val-1]){
                    
                    game = new Game("Map 1");
                    game.init();  
                }
                    break;
            case MAP2:
               if(game == null&&LevelCheck[val-1]){
                  
                    game = new Game("Map 2");
                    game.init();
                }  
                break;
            case MAP3:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 3");
                    game.init();
                }
                break;
                
            case MAP4:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 4");
                    game.init();
                }
                break;
                
            case MAP5:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 5");
                    game.init();
                }
                break;
                
            case MAP6:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 6");
                    game.init();
                }
                break;
                
            case MAP7:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 7");
                    game.init();
                }
                break;
                
            case MAP8:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 8");
                    game.init();
                }
                break;
                
            case MAP9:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 9");
                    game.init();
                }
                break;
                
            case MAP10:
               if(game == null&&LevelCheck[val-1]){
                    game = new Game("Map 10");
                    game.init();
                }
                break;
                
            case WinMenu:
               if(winmenu == null){
                   winmenu = new WinMenu();
                    winmenu.init();
                }
                break;  
                
            case GameOverMenu:
               if(gameovermenu == null){
                    
                    gameovermenu = new GameOverMenu();
                    gameovermenu.init();
                }
                break; 
        }
    }
    
    public static void update(){
        switch(choiceLevel[val]){
            case LevelMenu:
            //LevelMenu.update();
                mainMenu.update();
                if(winmenu != null){
                winmenu =null;
                }
                if(gameovermenu != null){
                        gameovermenu =null;
                    }
            break;
            
            case WinMenu:
                if(winmenu == null){
                   winmenu = new WinMenu();
                   winmenu.init();
                }
                winmenu.update();
                break;
                
            case GameOverMenu:
                if(gameovermenu == null){
                   gameovermenu = new GameOverMenu();
                   gameovermenu.init();
                }
                gameovermenu.update();
                
                
                break;
            
            default:
                
                   if(game!=null){
                    if(winmenu != null){
                        winmenu =null;
                    }
                    if(gameovermenu != null){
                        gameovermenu =null;
                    }
                    winmenu =null;
                    if(level.succeed){
                       
                        LevelCheck[val]=true;
                        game = null;
                        valLv = val;
                        val = 11;
                        UI.resetKeyLevelMenu();   
                    }
                    
                    if(level.finish){  
                        game = null;
                        valLv = val;
                        val = 12;
                        UI.resetKeyLevelMenu();   
                    }
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
            
                
            case WinMenu:
                if(winmenu!=null){
                winmenu.render();
                }
                
                break;
                
            case GameOverMenu:
                if(gameovermenu!=null){
                gameovermenu.render();
                }
                break;
                
            default :
                if(game != null){
                game.render();
                }else if(!LevelCheck[val-1]){
                   mainMenu.render();
                   val=0;
                }
                break;
                
        }
         
              
        

    }
     
     
     public static void setLevel (int choice){
         
         if(choice==-1){
             StateManager.val = 0;
         }else{
             val = choice;
         }
         
      
        
     }
}
 
    
    

