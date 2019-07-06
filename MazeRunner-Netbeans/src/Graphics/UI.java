/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;


import static Graphics.View.QuickLoadMenuTexture;
import static Graphics.View.renderBackground;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import static org.lwjgl.input.Keyboard.enableRepeatEvents;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;


/**
 *
 * @author Vincent
 */
public class UI implements KeyListener{
    
   // private ArrayList<Menu> menuList;
    private ArrayList<Button> buttonList;
   // private TrueTypeFont font;
    static UnicodeFont uf = null;
   // private Font awtFont;
    public static int Choice=0;
    public static int ChoiceLevel=0;
    public static int ChoiceConfirmed=0;
    public static int ChoiceLevelConfirmed=0;
    static int addUn = 1;
    static int addCinq= 5;
    public static boolean valtest = false;
    static int i = 0;
    public static int ChoiceWinMenu=0;
    public static int ChoiceWinMenuConfirmed=11;

    
    
    
    public UI(){
        buttonList = new ArrayList<Button>();
        //awtFont = new Font("Times New Roman", Font.BOLD, 20);
        //font = new TrueTypeFont(awtFont,true);
         
        
         addKeyListener(this);
         enableRepeatEvents(false);
         
    }
    
 
    
    
    public void addButton(String name, String texture, int x, int y, int width, int height){
        
        
       buttonList.add(new Button(name,QuickLoadMenuTexture(texture), x, y, width, height));
       
    }
    
    public void removeButton(){
        
        
       buttonList.removeAll(buttonList);
       
    }
    
    
    public void replaceButton(String name, String texture){
        
        for(Button b: buttonList){
            if(b.getName().equals(name)){
                 b.replaceTexture(QuickLoadMenuTexture(texture));
            }
        }
   
    }
    
   
    public static void resetKeyLevelMenu(){
        ChoiceLevel=0;
    }
    
    public static int isKeyWinMenu(){
        
        if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            ChoiceWinMenu = 1;
        }
        
        if (Keyboard.isKeyDown(Keyboard.KEY_Q) || Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            
             ChoiceWinMenu = 0; 
        }      
        return ChoiceWinMenu;
        
    }
    
    public static int isKeyWinMenuConfirmed(){
        
        if (ChoiceWinMenu==0&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
             
            ChoiceWinMenuConfirmed = 0;
  
        }
        if(ChoiceWinMenu==1&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceWinMenuConfirmed = 1;
        }
        return ChoiceWinMenuConfirmed;
    }

     public static int isKeyLevelMenu(){
         int tailleMax = 9;
         int key;
         
        // System.out.println(Keyboard.getEventKey());
       Keyboard.next();
       
        if ((Keyboard.isKeyDown(Keyboard.KEY_S))||(Keyboard.isKeyDown(Keyboard.KEY_DOWN))){ 
            if(ChoiceLevel+5<=tailleMax){
            ChoiceLevel=ChoiceLevel+addCinq;
            addCinq=0;
            }
        
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Z) || Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)){
            if(ChoiceLevel-5>=0){
            ChoiceLevel=ChoiceLevel-addCinq;
            addCinq=0;
            }
        }
        
        if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            if(ChoiceLevel+1<=tailleMax){
            ChoiceLevel=ChoiceLevel+addUn;
            addUn=0;
            }   
        }
        
        if (Keyboard.isKeyDown(Keyboard.KEY_Q) || Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            
            if(ChoiceLevel-1>=0){
           ChoiceLevel=ChoiceLevel-addUn;
            addUn=0;
            }   
        }
        
        
        //System.out.println(Keyboard.getEventKeyState());
        if(!Keyboard.getEventKeyState()){
           
            addUn=1;
            addCinq=5;
        }
        
        return ChoiceLevel;
    }
    
    public static int isKeyLevelMenuConfirmed(){
        ChoiceLevelConfirmed=0;
         Keyboard.next();
         if(!Keyboard.getEventKeyState()){
           
          valtest = true;
        }
       
     
        if (valtest&&ChoiceLevel==0&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
             
            ChoiceLevelConfirmed = 1;
  
        }
        if(ChoiceLevel==1&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 2;
        }
        if (ChoiceLevel==2&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 3;
        }
        if(ChoiceLevel==3&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 4;
        }
        if (ChoiceLevel==4&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 5;
        }
        if(ChoiceLevel==5&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 6;
        }
        if (ChoiceLevel==6&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 7;
        }
        if(ChoiceLevel==7&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 8;
        }
        if(ChoiceLevel==8&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 9;
        }
        if (ChoiceLevel==9&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceLevelConfirmed = 10;
        }
        
        
        return ChoiceLevelConfirmed;
    }
    
    public static int isKeyMenu(){
        
        if ((Keyboard.isKeyDown(Keyboard.KEY_S))||(Keyboard.isKeyDown(Keyboard.KEY_DOWN))){  
            Choice=1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Z) || Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)){
            Choice=0;
        }
        return Choice;
    }
    
    public static int isKeyMenuConfirmed(){
        ChoiceConfirmed = 0;
        
        if (Choice==0&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceConfirmed = 1;
        }
        if(Choice==1&&Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            
            ChoiceConfirmed = 2;
        }
        return ChoiceConfirmed;
        
    }
    
    
    public void draw(){
        for(Button b: buttonList){
            renderBackground(b.getTexture(), b.getX(), b.getY(),b.getWidth(),b.getHeight());
        }
    }
    
    public static void initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);

        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }
    
    public static void initFont(int size, boolean bold, boolean italic) {
        try {
            uf = new UnicodeFont("/src/Font/OpenSans/OpenSans-Bold.ttf", size, bold, italic);
            uf.addAsciiGlyphs();
            uf.getEffects().add(new ColorEffect(java.awt.Color.BLACK));
            uf.loadGlyphs();
        } catch (SlickException e) {

        }
    }
    
    public void drawString(int x, int y, String text){
         
        uf.drawString(x,y,text);
        
    }

    @Override
public void keyPressed(KeyEvent e)
{
//System.out.println("Key Pressed: " + e.getKeyCode() + "\n");
}
@Override
public void keyReleased(KeyEvent e)
{
//System.out.println("Key Released: " + e.getKeyCode() + "\n");
}
@Override
public void keyTyped(KeyEvent e)
{
//The getKeyModifiers method is a handy
//way to get a String representing the
//modifier key.
//System.out.println("Key Typed: " + e.getKeyCode() + "\n");
}
    
    
}
