/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Model.Square.Square;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;
/**
 *
 * @author Vincent
 */
public class Component {

    public static boolean running = false;
    
    public static String title = "MazeRunner";
    public static float scale = 1 ;
    public static int width = Toolkit.getDefaultToolkit().getScreenSize().width /*(int) (Display.getWidth()/scale)*/;
    public static int height = Toolkit.getDefaultToolkit().getScreenSize().height /*(int) (Display.getHeight()/scale)*/;
    public static int realWidth = width;
    public static int realHeigth = height;
    public static boolean[] LevelCheck={true,false,false,false,false,false,false,false,false,false,false};
    
    int time = 0;
    
    public static boolean tick = false;
    public static boolean render = false;
    
    DisplayMode mode = new DisplayMode((int) (width*scale), (int) (height*scale));
   
         
    Game game;
    
      public  Component () {
      display();
      //game = new Game();
}
      
   
      
    public void start() throws IOException, Exception{
        LevelCheck = Charger_level();
        running = true;
        loop();
    }  
    
    public static void stop(){
        running = false;
    }
    
    public static void exit () throws Exception{
        Sauvegarder(LevelCheck);
        Display.destroy();
        System.exit(0);
    }
    
    public void loop() throws Exception{
        
        //game.init();
        StateManager.init();
        scale = (Display.getWidth()*3.54f)/1920;
        
        long timer = System.currentTimeMillis();
        
        long timeBeforeTick = System.nanoTime();
        long timeBeforeFrame = System.nanoTime();
        double elapsedTick = 0;
        double elapsedFrame = 0;
        double nanoSeconds = 1000000000.0/60.0; //update 60 per 1 seconde
       
        int ticks = 0;
        int frames = 0;
        
        while(running){
            if(Display.isCloseRequested()){
                stop();
            }
           
            width = (int) (Display.getWidth()/scale);
            height = (int) (Display.getHeight()/scale);
            tick = false;
            render = false;
            
            long timeNow = System.nanoTime();
            elapsedTick = timeNow-timeBeforeTick;
            elapsedFrame = timeNow-timeBeforeFrame;
            if(elapsedTick>nanoSeconds){
                timeBeforeTick += nanoSeconds;
                tick = true;
                ticks++;
            }else if(elapsedFrame>nanoSeconds){
                timeBeforeFrame += nanoSeconds;
                render = true;
                frames++;
                 Display.update();
            }
            if (tick) update();
            if (render) render();
            
            //Get time in secondes
            if (System.currentTimeMillis()-timer>1000){
                timer +=1000;
                Display.setTitle(title+" FPS : "+frames);
                ticks = 0;
                frames = 0;
            }
        }
        exit();
    }
    
    public void update (){
      time++;  
      
       StateManager.update();
      //game.update();
    }
    
    public void render(){
        
        view2D(width,height);  
        glClear(GL_COLOR_BUFFER_BIT);
        
        StateManager.render();
        //game.render();
    }
    
     public void display(){
        try{  
        Display.setDisplayMode(mode);
        //Display.setDisplayModeAndFullscreen(Display.getDesktopDisplayMode());
        Display.setResizable(false);
        Display.setFullscreen(true);
        Display.setLocation(-3, 0);
        Display.setTitle(title);
        Display.create();
        
        view2D(width,height);
      }catch (LWJGLException e){  
          e.printStackTrace();    
      }    
    }
    private void view2D(int width,int height){ 
        
        glViewport(0,0,(int) (width*scale), (int) (height*scale));
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluOrtho2D(0,width,height,0);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        
        glEnable(GL_TEXTURE_2D);
        
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        
    }
    
    public static void Sauvegarder(boolean[] Level) throws Exception {
        String  monFichier = "Save\\level.dat";
        FileOutputStream fos;
        ObjectOutputStream oos;
        fos = new FileOutputStream(monFichier);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(Level);
        oos.flush();
        oos.close();
    }
    
        public static boolean[] Charger_level() throws FileNotFoundException, IOException {
        boolean[] TabLevel={true,false,false,false,false,false,false,false,false,false,false};
        String Chemin_fichier = "Save\\level.dat";
        File f = new File(Chemin_fichier);

        if(!f.exists()){
            
        }else{
                FileInputStream fis;
                ObjectInputStream ois;
                fis = new FileInputStream(f);
                System.out.println("1"+fis);
                ois = new ObjectInputStream(fis);
                System.out.println("2"+ois);
                ois.close();

        }
            
     

        return TabLevel;
    }


    
    public static void main(String[] args) throws Exception {
        Component main = new Component();
        
        main.start();
    }
  
    
  
    
    
}
