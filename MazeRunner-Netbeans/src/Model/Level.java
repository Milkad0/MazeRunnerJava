/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Square.Square;
import Model.Square.Square.Squares;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author q95
 */
public class Level {
    
    public int width,height;
    
    List<Square> Square = new ArrayList<Square>();
    Square[][] solidSquare;
    Square[][] noneSolidSquare;
    
    public Level(int width, int height){
        this.width = width;
        this.height = height;
        solidSquare = new Square [width][height];
        noneSolidSquare = new Square [width][height];
        setSquares();
        
    }
    
    public void setSquares(){
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){

          if(x-1<0||y-1<0||x+1>=width||y+1>height) continue;
          boolean vu=false, vd=false, vl=false, vr=false;
          boolean vur=false, vdr=false, vul=false, vdl=false;
          
          if(solidSquare[x+1][y]==null){
              vr = true;
          }
          if(solidSquare[x-1][y]==null){
              vl = true;
          }
          if(solidSquare[x][y+1]==null){
              vd = true;
          }
          if(solidSquare[x][y-1]==null){
              vu = true;
          }
           if(solidSquare[x+1][y+1]==null){
              vdr = true;
          }
          if(solidSquare[x-1][y-1]==null){
              vul = true;
          }
          if(solidSquare[x-1][y+1]==null){
              vdl = true;
          }
          if(solidSquare[x+1][y-1]==null){
              vur = true;
          }
          
          if(solidSquare[x][y]!=null){
              solidSquare[x][y].setSquare(vr, vl, vd, vu, vur, vul, vdr, vdl);
          }
            }
        }
        for (int x = 0;x<width;x++){
            for (int y = 0; y<height;y++){
                
                Square.add(solidSquare[x][y]);
                //Square.add(noneSolidSquares[x][y]);
                
            }
        }
        
    }
    
    public void addSquares (int x, int y){
        
    }
    
    public void init(){
        
    }
    
    public void update(){
        
    }
    
    public void render(){
     for (Square square: Square){ //for each
         square.render();
     }
    }
}
