/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.StateManager.mainMenu;
import Graphics.UI;
import static Graphics.UI.initFont;
import static Graphics.UI.initGL;
import static Graphics.View.QuickLoadMenuTexture;
import static Graphics.View.renderBackground;
import static Model.Character.Human.numberkey;
import static Model.Character.Human.power;
import Model.Level;
import static Model.Level.minute;
import static Model.Level.seconde;
import Model.Square.Square;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Vincent
 */
public class Game {

    public static Level level;
    String Map1;
    UI gameUI;
    public static float xScroll, yScroll;

    public Game(String Map) {
       
        this.Map1 = Map;
        level = new Level(Map1);
        gameUI = new UI();
        xScroll = level.getBounds(0);
        yScroll = level.getBounds(1);
        
    }

    public void init() {

         level.init();
         gameUI.initGL();
         gameUI.initFont(15, false, false);
         
      
        
    }

    public void translateView(float xa, float ya) {
        //xScroll += xa;
        //yScroll += ya;
    }
    
    public void updateUI(){
       
       //gameUI.drawString(0,0,"Tesstttttt");
        
    }

    public void update() {
        //translateView(-0.5f, -0.5f);
        //System.out.println(Level.getPlayer().getX());
        
        
        
        if (!level.finish&&!level.succeed){
            level.update();
                       
            
        }
        
    }

    public void render() {
   
            
           GL11.glTranslatef(xScroll, yScroll, 0);
        level.render();
        
         gameUI.drawString(515, 109, " : "+ power); 
         gameUI.drawString(515, 140, " : "+ numberkey);
         gameUI.drawString(510, 190, minute+":"+seconde);  
        

        //updateUI();
        
        

    }
}
