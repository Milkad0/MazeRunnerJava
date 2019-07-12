/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LevelManager.LevelCheck;
import static Controller.StateManager.val;
import Graphics.UI;
import static Graphics.UI.resetKeyLevelMenu;
import static Graphics.UI.resetValtest;
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
     private int width = 590;
    private int height = 580;
    private int testVal=0;
    private int testVal2=0;
    
    public MainMenu(){
      //mainLevel = new Level("Map 2");
      background = QuickLoadMenuTexture("mainmenu");
      menuUI = new UI();
      menuUI.addButton("Play","PlayButton3", 230, 130, 80,30);//30
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
            if(testVal2==0){
               resetValtest(); 
            menuUI.removeButton();
            menuUI.addButton("Play","PlayButton3", 230, 130, 80,30);//30
            menuUI.addButton("Quit","QuitButton4", 0, 50, 80,30);  
      
            testVal2=1;
        }

        StateManager.setState(UI.isKeyMenuConfirmed());
        
        if(UI.isKeyMenu()==1){
            menuUI.replaceButton("Play", "PlayButton3");
            menuUI.replaceButton("Quit", "QuitButton4"); //Choix
         
    
      }else{
            menuUI.replaceButton("Quit", "QuitButton3");
            menuUI.replaceButton("Play", "PlayButton4"); //Choix
           
        }
        }else if(val==1){
            testVal2=0;
            if(testVal==0){
                resetValtest();
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
      
      menuUI.addButton("Menu","MenuButton", -300, -50, 80,30); 
            testVal=1;
        }
        LevelManager.setLevel(UI.isKeyLevelMenuConfirmed());
        
        //System.out.println(UI.isKeyLevelMenuConfirmed());
        
        if(UI.isKeyLevelMenu()==-1){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            }
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
            
            menuUI.replaceButton("Menu","MenuButton2"); 
         
    
        }else if(UI.isKeyLevelMenu()==0){
            menuUI.replaceButton("Level1","Level1Select");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            }
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
            menuUI.replaceButton("Menu","MenuButton"); 
         
    
        }else if(UI.isKeyLevelMenu()==1){
            menuUI.replaceButton("Level1","Level1");
            menuUI.replaceButton("Level2","Level2Select");
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
            
            

        }else if(UI.isKeyLevelMenu()==2){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            }
            menuUI.replaceButton("Level3","Level3Select");
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
            
           
        }else if(UI.isKeyLevelMenu()==3){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            } 
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            //
            menuUI.replaceButton("Level4","Level4Select");      
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
           
        }else if(UI.isKeyLevelMenu()==4){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            } 
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            //
            menuUI.replaceButton("Level5","Level5Select");
            //
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
           
        }else if(UI.isKeyLevelMenu()==5){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            } 
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            //
            menuUI.replaceButton("Level6","Level6Select");
            //
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
           
        }else if(UI.isKeyLevelMenu()==6){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            }
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }

            //
            menuUI.replaceButton("Level7","Level7Select"); 
            //

            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
           
        }else if(UI.isKeyLevelMenu()==7){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            } 
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            //
            menuUI.replaceButton("Level8","Level8Select");
            //
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
           
        }else if(UI.isKeyLevelMenu()==8){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            } 
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            //
            menuUI.replaceButton("Level9","Level9Select");
            //
            if(LevelCheck[9]){
            menuUI.replaceButton("Level10","Level10");
            }else{
            menuUI.replaceButton("Level10","Level10NotAv");    
            }
           
        }else if(UI.isKeyLevelMenu()==9){
            menuUI.replaceButton("Level1","Level1");
            if(LevelCheck[1]){
            menuUI.replaceButton("Level2","Level2");
            }else{
            menuUI.replaceButton("Level2","Level2NotAv");    
            } 
            if(LevelCheck[2]){
            menuUI.replaceButton("Level3","Level3");
            }else{
            menuUI.replaceButton("Level3","Level3NotAv");    
            }
            
            if(LevelCheck[3]){
            menuUI.replaceButton("Level4","Level4");
            }else{
            menuUI.replaceButton("Level4","Level4NotAv");    
            }
            
            if(LevelCheck[4]){
            menuUI.replaceButton("Level5","Level5");
            }else{
            menuUI.replaceButton("Level5","Level5NotAv");    
            }
            
            if(LevelCheck[5]){
            menuUI.replaceButton("Level6","Level6");
            }else{
            menuUI.replaceButton("Level6","Level6NotAv");    
            }
            
            if(LevelCheck[6]){
            menuUI.replaceButton("Level7","Level7");
            }else{
            menuUI.replaceButton("Level7","Level7NotAv");    
            }
            
            if(LevelCheck[7]){
            menuUI.replaceButton("Level8","Level8");
            }else{
            menuUI.replaceButton("Level8","Level8NotAv");    
            }
            
            if(LevelCheck[8]){
            menuUI.replaceButton("Level9","Level9");
            }else{
            menuUI.replaceButton("Level9","Level9NotAv");    
            }
            menuUI.replaceButton("Level10","Level10Select");
           
        }
        
        
            
        }
        
    }
}
    

