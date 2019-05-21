/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

/**
 *
 * @author Vincent
 */
public class Animation {
    private int frame =0;
    private int length;
    private int speed;
    private int firstFrame;
    private int resetFrame;
    private boolean loop = false;
    
    private boolean playing = false;
    private int time = 0;
    
    public Animation (int resetFrame, int firstFrame, int lastFrame, int speed, boolean loop){
        
        this.firstFrame = firstFrame;
        this.length = lastFrame;
        this.speed = speed;
        this.loop = loop;
        this.resetFrame = resetFrame;
    }
    
    public void update(){
        
        if(playing){
            time++;
            if(time>speed){
                frame++;
                if(frame>=length){
                    if(loop) frame=firstFrame-1;
                    else frame = length;
                }
                time = 0;
            }
        }else{
            frame=resetFrame-1;
        }
       
        
    }
    
    public void play(){
        playing = true;
    }
    
    public void pause(){
        playing = false;
    }
    
    public void stop(){
        playing=false;
        frame=0;
    }
    
    public boolean getPlaying(){
        return playing;
    }
    
    public int getCurrentFrame(){
        return frame;
    }
}
