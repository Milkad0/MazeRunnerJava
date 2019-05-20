/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Character.Characters;
import Model.Character.Human;
import java.awt.image.BufferedImage;
import Model.Square.Square;
import Model.Square.Square.Squares;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author q95
 */
public class Level {
    
    public float gravity = 1.8f;
    
    public int width,height;
    
    List<Square> Square = new ArrayList<Square>();
    Square[][] solidSquare;
    Square[][] noneSolidSquare;
    Square[][] ladderSquare;
    Square[][] appleSquare;
    
    List<Characters> tab_character = new ArrayList<Characters>();
    private static Human player = new Human(2,5);
    public Level(int width, int height){
      
        
        
        
        loadLevel("Map 1");
        spawner();
    }
    
    public void spawner(){
        player.init(this);
        addCharacters(player);
       
    }
    
    public void loadLevel (String name){
        
        int[] pixels;
        BufferedImage image = null;
        try{
        image = ImageIO.read(Level.class.getResource("/Levels/"+name+".png"));
        }catch(IOException e){
            e.printStackTrace();
        }
          width = image.getWidth();
          height = image.getHeight();
          pixels = new int[width*height];
          image.getRGB(0, 0, width, height, pixels, 0, width);
          
          solidSquare = new Square [width][height];
          noneSolidSquare = new Square [width][height];
          ladderSquare = new Square [width][height];
          appleSquare = new Square [width][height];
          
          for (int x=0;x<width;x++){
              for(int y=0;y<height;y++){
                  if(pixels[x+y*width]==0xFFffffff){
                      solidSquare[x][y] = new Square(x,y,Squares.BRICK);
                  }
                  if(pixels[x+y*width]==0xFF000000){
                      noneSolidSquare[x][y] = new Square(x,y,Squares.EMPTY);
                  }
                  if(pixels[x+y*width]==0xFFff6A00){
                      ladderSquare[x][y] = new Square(x,y,Squares.LADDER);
                  }
                  if(pixels[x+y*width]==0xFFff0000){
                      appleSquare[x][y] = new Square(x,y,Squares.APPLE);
                  }
              }
          }
          
      setSquares();  
    }
    
    public void setSquares(){
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){

          if(x-1<0||y-1<0||x+1>=width||y+1>=height){
              continue;
          }
        if(appleSquare[x][y]!=null){
            appleSquare[x][y].setSquare();
        }
          addSquares(x,y);
            }
        }
        
        
    }
    
    
    public Square getSolidSquare(int x, int y){
         if(x<0||y<0||x>=width||y>=height){
              return null;
          }
        return solidSquare[x][y];
    }
    
     public Square getLadderSquare(int x, int y){
         if(x<0||y<0||x>=width||y>=height){
              return null;
          }
        return ladderSquare[x][y];
    }
     
     public Square getAppleSquare(int x, int y){
         if(x<0||y<0||x>=width||y>=height){
              return null;
          }
        return appleSquare[x][y];
    }
    
    
    public  void addSquares (int x, int y){
          if (solidSquare[x][y] != null){
                Square.add(solidSquare[x][y]);
                } else if(noneSolidSquare[x][y] != null){
                    Square.add(noneSolidSquare[x][y]);
                }else if(ladderSquare[x][y] != null){
                    Square.add(ladderSquare[x][y]);
                }else if(appleSquare[x][y] != null){
                    Square.add(appleSquare[x][y]);
                }
    }
   
    
    public void init(){
        
    }
    
    public void addCharacters (Characters e){
        tab_character.add(e);
        
    }
    
    public void removeCharacters (Characters e){
        tab_character.remove(e);
        
    }
    
    public void update(){
         for (int i=0;i<tab_character.size();i++){
         Characters e = tab_character.get(i);
         if(e.getRemoved()) tab_character.remove(e);
         e.update();
     }
    }
    
    public void render(){
     for (Square square: Square){ //for each
         square.render();
     }
     
     for (int i=0;i<tab_character.size();i++){
         Characters e = tab_character.get(i);
         e.render();
     }
    }
    
    public static Human getPlayer(){
        return player;
    }
}
