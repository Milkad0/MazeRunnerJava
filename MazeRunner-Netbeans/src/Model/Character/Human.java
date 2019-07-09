/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character;

import Controller.Component;
import static Controller.LevelManager.totalpower;
import Graphics.Animation;
import Graphics.Color;
import static Graphics.View.renderCharacters;
import Model.Level;
import Model.Square.Square;
import Graphics.MyTexture;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author q95
 */
public class Human extends Characters {

    Animation run, jump, climb, freeze,finTeleportation;

    int dir = 0;
    float speed = 1.5f;
    boolean freezed = false;
    int testFreeze = 0;
    boolean teleport = false;
    boolean teleportEnd = false;
    public boolean apple = false;
    char lastKey;
    public static int power =0;
    public static int numberkey = 0;
    public int  posX;
    public int posY;
    boolean key = false;
    
    public Human(int x, int y) {
        super(x, y);
        texture = MyTexture.human;
        run = new Animation(1, 2, 4, 5, true,false);
        jump = new Animation(1, 1, 1, 5, true,false);
        climb = new Animation(1, 2, 3, 5, true,false);
        freeze = new Animation(5, 5, 5, 5, true,false);
        finTeleportation = new Animation(1,5,5,2,false,true);
        
        mass = 0.1f;
        friction = 0.95f;
    }
    float xa, ya;
    
    @Override
    public void run(){
        while(level.finish==false){
            try {
                update();
                sleep(15);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public void update() {
            posX = (int) getPositionX()/16;
            posY = (int) (getPositionY()/16);
        
        if (!isLadder()) {
            ya += level.gravity * mass;
        }
        if(isPacer(this.x,this.y)){
            level.finish = true;
            power = 0;
            key = false;
            numberkey=0;
        }
        
        if(isDoor(posX,posY)&&key){
            level.succeed = true;
            power = 0;
            key = false;
            numberkey=0;
        }
       
        
        run.update();
        run.pause();
        climb.update();
        climb.pause();
        freeze.update();
        finTeleportation.update();
        finTeleportation.pause();

        if (Keyboard.isKeyDown(Keyboard.KEY_Z) || Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            if (isGrounded()||isTeleport()) {
                ya -= 3.8f;
                dir = 2;
                run.play();

            } else if (isLadder()) {
                ya -= 0.6f;
                dir = 2;
                climb.play();

            }
            lastKey = 'W';

        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            ya += 0;
            if (isLadder()) {
                ya += 0.6f;
                dir = 2;
                climb.play();
            }
            lastKey = 'S';
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_Q) || Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            //System.out.println("A Key Pressed");
            xa -= speed;
            dir = 1;
            run.play();

            if (isLadder()) {
                ya -= 0.1f;

            }
            lastKey = 'A';

        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {

            //System.out.println("D Key Pressed");

            xa += speed;
            dir = 0;
            run.play();

            if (isLadder()) {
                ya -= 0.1f;
            }
            lastKey = 'D';

        }

        if (isFreezed() && freezed == false) {
            if(lastKey=='A'){
            dir = 1;
            }else{
            dir = 0;
            }

            long timerBefore = System.currentTimeMillis();
            long duration = 0;
            int random_duration = (int) (1 + (Math.random() * (3 - 1)));
            freeze.play();
            testFreeze++;

            if (testFreeze == 2) {
                freezed = true;
                testFreeze = 0;

                while ((duration < random_duration * 1000) && (freeze.getPlaying())) {

                    duration = System.currentTimeMillis() - timerBefore;
                }

            }

        } else if (!isFreezed()) {
            freeze.pause();
            freezed = false;
        } else {
            xa *= 0.5 + friction;
            freeze.pause();
        }

        int xStep = (int) Math.abs(xa * 1000);
        for (int i = 0; i < xStep; i++) {
            if (!isSolidSquare(xa / xStep, 0) && !isFreezeSquare(xa / xStep, 0) && !isHyperSquare(xa / xStep, 0) && !isPacer(xa / xStep, 0)) {
                x += xa / xStep;
            } else {
                xa = 0;
            }
        }

        int yStep = (int) Math.abs(ya * 1000);
        for (int i = 0; i < yStep; i++) {
            if (!isSolidSquare(0, ya / yStep) && !isFreezeSquare(0, ya / yStep) && !isHyperSquare(0, ya / yStep) && !isPacer(0,ya / yStep)) {
                y += ya / yStep;
            } else {
                ya = 0;
            }
        }

        xa = 0;
        if (!isLadder()) {
            ya *= friction;
        } else {
            ya = 0;
        }
        
        if (isTeleport()){
           // teleportEnd = false;
            int posX = (int) getPositionX()/16;
            int posY = (int) (getPositionY()/16)+1;
            int numFuturHyperSquare = -2;
            
            for (int numHyperSquare = 0; numHyperSquare < 9; numHyperSquare++) {
                if((level.getXHyperSquare(numHyperSquare)==posX)&&(level.getYHyperSquare(numHyperSquare)==posY)){
                    
                    if(level.getXHyperSquare(numHyperSquare+1)==-1){
                    numFuturHyperSquare = 0;  
                    }else{
                    numFuturHyperSquare = numHyperSquare+1;
                    }
                    break;
                 }
            }
            
            if(numFuturHyperSquare != -2){
                int x = level.getXHyperSquare(numFuturHyperSquare);
                int y = level.getYHyperSquare(numFuturHyperSquare)-1;
         
                if((teleport==false)&&(x>0)&&(y>0)){
                 setPosition(x,y);
                 teleport=true;
                 teleportEnd = true;
                }
              finTeleportation.play();
                    dir = 3;
                
                
            }
        }else if(isBrick()){
            teleport=false;
        }
        

           if(level.removeSquareApple(posX, posY)){
               totalpower++;
               power++;
           }
           
           if(level.removeSquareKey(posX, posY)){
               key=true;
               numberkey=1;
           }
           
           
        
        
       
    }

    @Override
    public void render() {
        texture.bind();
        float sizeSpriteSheet = 7.0f;
        if (climb.getPlaying()) {
            renderCharacters(x, y, 16, 16, Color.WHITE, sizeSpriteSheet, climb.getCurrentFrame(), 0 + dir);
        } else if (freeze.getPlaying()) {
            renderCharacters(x, y, 16, 16, Color.WHITE, sizeSpriteSheet, freeze.getCurrentFrame(), 0 + dir);

        } else if (finTeleportation.getPlaying()) {
            renderCharacters(x, y, 16, 16, Color.WHITE, sizeSpriteSheet, finTeleportation.getCurrentFrame(), 0 + dir);

        }
        else {

            renderCharacters(x, y, 16, 16, Color.WHITE, sizeSpriteSheet, run.getCurrentFrame(), 0 + dir);
        }
        texture.unbind();
    }

    @Override
    public void init(Level level) {
        this.level = level; //To change body of generated methods, choose Tools | Templates.
    }
    
}
