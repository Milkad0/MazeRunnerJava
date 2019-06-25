/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Component;
import Model.Character.Characters;
import Model.Character.*;
import java.awt.image.BufferedImage;
import Model.Square.Square;
import Model.Square.Square.Squares;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.Display;

/**
 *
 * @author q95
 */
public class Level {

    public float gravity = 1.8f;

    public int width, height;
    
    public boolean finish,succeed;

    private int[] bounds = new int[4];

    List<Square> Square = new ArrayList<Square>();
    Square[][] solidSquare;
    Square[][] noneSolidSquare;
    Square[][] ladderSquare;
    Square[][] appleSquare;
    Square[][] freezeSquare;
    Square[][] hyperSquare;
    Square[][] doorSquare;
    Square[][] keySquare;

    List<Characters> tab_character = new ArrayList<Characters>();
    List<Square> tab_apple = new ArrayList<Square>();
    List<Square> tab_key = new ArrayList<Square>();
    
    static int tab_XHyperSquare[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    static int tab_YHyperSquare[]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    static int posX_Door = -1;
    static int posY_Door = -1;
    
    
    private static Human player;
    private static Pacer pacer;

    public Level(int width, int height) {

        loadLevel("Map 1");
        spawner();
        startThread();
    }

    public void spawner() {
        player = new Human(2, 5);
        pacer = new Pacer(17, 17);
        this.init();
        player.init(this);
        pacer.init(this);
        addCharacters(player);
        addCharacters(pacer);

    }

    public void loadLevel(String name) {

        int[] pixels;
        BufferedImage image = null;
        try {
            image = ImageIO.read(Level.class.getResource("/Levels/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = image.getWidth();
        height = image.getHeight();
        finish=false;

        bounds[0] = -16;
        bounds[1] = -16;
        bounds[2] = (int) (-width * 16 + 16 + Display.getWidth() / Component.scale);
        bounds[3] = (int) (-height * 16 + 16 + Display.getHeight() / Component.scale);

        pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);

        solidSquare = new Square[width][height];
        noneSolidSquare = new Square[width][height];
        ladderSquare = new Square[width][height];
        appleSquare = new Square[width][height];
        freezeSquare = new Square[width][height];
        hyperSquare = new Square[width][height];
        doorSquare = new Square [width][height];
        keySquare = new Square [width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (pixels[x + y * width] == 0xFFffffff) {
                    solidSquare[x][y] = new Square(x, y, Squares.BRICK);
                }
                if (pixels[x + y * width] == 0xFF000000) {
                    noneSolidSquare[x][y] = new Square(x, y, Squares.EMPTY);
                }
                if (pixels[x + y * width] == 0xFFff6A00) {
                    ladderSquare[x][y] = new Square(x, y, Squares.LADDER);
                }
                if (pixels[x + y * width] == 0xFFff0000) {
                    appleSquare[x][y] = new Square(x, y, Squares.APPLE);
                    noneSolidSquare[x][y] = new Square(x, y, Squares.EMPTY);
                }
                if (pixels[x + y * width] == 0xFF00ffff) {
                    freezeSquare[x][y] = new Square(x, y, Squares.FREEZE);
                }
                if (pixels[x + y * width] == 0xFFffD800) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_0);
                    tab_XHyperSquare[0]=x;
                    tab_YHyperSquare[0]=y;
                }
                if (pixels[x + y * width] == 0xFFffD801) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_1);
                    tab_XHyperSquare[1]=x;
                    tab_YHyperSquare[1]=y;
                }
                if (pixels[x + y * width] == 0xFFffD802) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_2);
                    tab_XHyperSquare[2]=x;
                    tab_YHyperSquare[2]=y;
                }
                if (pixels[x + y * width] == 0xFFffD803) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_3);
                    tab_XHyperSquare[3]=x;
                    tab_YHyperSquare[3]=y;
                }
                if (pixels[x + y * width] == 0xFFffD804) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_4);
                    tab_XHyperSquare[4]=x;
                    tab_YHyperSquare[4]=y;
                }
                if (pixels[x + y * width] == 0xFFffD805) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_5);
                    tab_XHyperSquare[5]=x;
                    tab_YHyperSquare[5]=y;
                }
                if (pixels[x + y * width] == 0xFFffD806) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_6);
                    tab_XHyperSquare[6]=x;
                    tab_YHyperSquare[6]=y;
                }
                if (pixels[x + y * width] == 0xFFffD807) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_7);
                    tab_XHyperSquare[7]=x;
                    tab_YHyperSquare[7]=y;
                }
                if (pixels[x + y * width] == 0xFFffD808) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_8);
                    tab_XHyperSquare[8]=x;
                    tab_YHyperSquare[8]=y;
                }
                if (pixels[x + y * width] == 0xFFffD809) {
                    hyperSquare[x][y] = new Square(x, y, Squares.HYPER_9);
                    tab_XHyperSquare[9]=x;
                    tab_YHyperSquare[9]=y;
                }
                if (pixels[x + y * width] == 0xFF0026FF) {
                    doorSquare[x][y] = new Square(x, y, Squares.DOOR);
                    posX_Door = x;
                    posY_Door = y;
                }
                if (pixels[x + y * width] == 0xFFff00DC) {
                    keySquare[x][y] = new Square(x, y, Squares.KEY);
                    noneSolidSquare[x][y] = new Square(x, y, Squares.EMPTY);
                }
            }
        }

        setSquares();
    }

    public void setSquares() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                if (x - 1< 0 || y - 1 < 0 || x + 1 >= width || y  >= height) {
                    continue;
                }
                if (appleSquare[x][y] != null) {
                    appleSquare[x][y].setSquareApple();
                }
                if(keySquare[x][y] !=null){
                    keySquare[x][y].setSquareKey();
                }
                addSquares(x, y);
            }
        }

    }



    public void addSquares(int x, int y) {
        if (solidSquare[x][y] != null) {
            Square.add(solidSquare[x][y]);
        } else if (noneSolidSquare[x][y] != null&&appleSquare[x][y] == null&&keySquare[x][y] ==null) {
            Square.add(noneSolidSquare[x][y]);
        } else if (ladderSquare[x][y] != null) {
            Square.add(ladderSquare[x][y]);
        } else if (appleSquare[x][y] != null) {
            Square.add(noneSolidSquare[x][y]);
            tab_apple.add(appleSquare[x][y]);
        } else if (freezeSquare[x][y] != null) {
            Square.add(freezeSquare[x][y]);
        } else if (hyperSquare[x][y] != null) {
            Square.add(hyperSquare[x][y]);
        }else if (doorSquare[x][y] != null) {
            Square.add(doorSquare[x][y]);
        }else if (keySquare[x][y] != null) {
            Square.add(noneSolidSquare[x][y]);
            tab_key.add(keySquare[x][y]);
        }
    }

    public void init() {
        player.setPositionStart();
        pacer.setPositionStart();
    }



    public void addCharacters(Characters e) {
        tab_character.add(e);

    }

    public void removeCharacters(Characters e) {
        tab_character.remove(e);

    }
    public boolean removeSquareApple(int x, int y) {
        
        boolean test = false;
        
       if (appleSquare[x][y] != null) { 
            tab_apple.remove(appleSquare[x][y]);
            appleSquare[x][y] = null;
            test = true;
        }else{
           test = false;
       }
       
       return test;

    }
    
    public boolean removeSquareKey(int x, int y) {
        
        boolean test = false;
        
       if (keySquare[x][y] != null) { 
            tab_key.remove(keySquare[x][y]);
            keySquare[x][y] = null;
            test = true;
        }else{
           test = false;
       }
       
       return test;

    }
    
    public boolean addSquareApple(int x, int y) {
        
        boolean test = false;
        
       if (appleSquare[x][y] == null) { 
            appleSquare[x][y] = new Square(x, y, Squares.APPLE) ;
            appleSquare[x][y].setSquareApple();
            tab_apple.add(appleSquare[x][y]);
            
            test = true;
        }else{
           test = false;
       }
       
       return test;

    }
    
    public void update() {
        for (int i = 0; i < tab_character.size(); i++) {
            Characters e = tab_character.get(i);
            if (e.getRemoved()) {
                tab_character.remove(e);
            }
            if(e instanceof Pacer == false && e instanceof Human == false){
                e.update();
            }
        }       
    }

    public void render() {
       
        for (Square square : Square) { //for each
            square.render();
        }
         for (Square squareApple : tab_apple){
            squareApple.render();
        }
         for (Square squareKey : tab_key){
            squareKey.render();
        }
        
        

        for (int i = 0; i < tab_character.size(); i++) {
            Characters e = tab_character.get(i);
            e.render();
        }
    }

//GETTER
    
    public static Human getPlayer() {
        return player;
    }
    
    public Pacer getPacer() {
        return pacer;
    }   
         
    public List<Characters> getTabCharacter(){
        return tab_character;
    }
    
    public boolean getFinish(){
        return finish;
    }
    
    public int getBounds(int index) {
        return bounds[index];
    }
     
    public Square getSolidSquare(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        }
        return solidSquare[x][y];
    }

    public Square getLadderSquare(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        }
        return ladderSquare[x][y];
    }

    public Square getAppleSquare(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        }
        return appleSquare[x][y];
    }
    
    public Square getKeySquare(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        }
        return keySquare[x][y];
    }

    public Square getFreezeSquare(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        }
        return freezeSquare[x][y];
    }

    public Square getHyperSquare(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        }
        return hyperSquare[x][y];
    }
     
    public  int getXHyperSquare(int x){

        return tab_XHyperSquare[x];
    }
    
    public  int getYHyperSquare(int y){

        return tab_YHyperSquare[y];
    } 
    
    public  int getYDoor(){

        return posY_Door ;
    } 
    
    public  int getXDoor(){

        return posX_Door ;
    } 
    
    public void startThread(){
        pacer.start();
        player.start();
        pacer.setName("Pacer Thread");
        player.setName("Player Thread");
    }
}
