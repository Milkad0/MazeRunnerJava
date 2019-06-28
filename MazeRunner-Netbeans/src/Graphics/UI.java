/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import static Graphics.View.QuickLoadMenuTexture;
import static Graphics.View.renderBackground;
import java.awt.Font;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;


/**
 *
 * @author Vincent
 */
public class UI {
    
   // private ArrayList<Menu> menuList;
    private ArrayList<Button> buttonList;
    private TrueTypeFont font;
    private Font awtFont;
    public static int Choice=0;
    public static int ChoiceConfirmed=0;
    
    
    
    public UI(){
        buttonList = new ArrayList<Button>();
        
        //menuList = newArrayList<Menu>();
        awtFont = new Font("Times New Roman", Font.BOLD, 24);
        font = new TrueTypeFont(awtFont,false);
        
    }
    
    public void addButton(String name, String texture, int x, int y, int width, int height){
        System.out.println(x);
        
       buttonList.add(new Button(name,QuickLoadMenuTexture(texture), x, y, width, height));
       
    }
    
    public void replaceButton(String name, String texture){
        
        for(Button b: buttonList){
            if(b.getName().equals(name)){
                 b.replaceTexture(QuickLoadMenuTexture(texture));
            }
        }
   
    }
    
    public static int isKey(){
        
        if ((Keyboard.isKeyDown(Keyboard.KEY_S))||(Keyboard.isKeyDown(Keyboard.KEY_DOWN))){  
            Choice=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Z) || Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)){
            Choice=0;
        }
        return Choice;
    }
    
    public static int isKeyConfirmed(){
        
        
        if (Choice==0&&Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            
            ChoiceConfirmed = 1;
        }
        if(Choice==1&&Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            
            ChoiceConfirmed = 2;
        }
        return ChoiceConfirmed;
    }
    
    
    public void draw(){
        for(Button b: buttonList){
            renderBackground(b.getTexture(), b.getX(), b.getY(),b.getWidth(),b.getHeight());
        }
    }
    
    public void drawString(int x, int y, String text){
        font.drawString(x,y,text);
    }
    
    
}
