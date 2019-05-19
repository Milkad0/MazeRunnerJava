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
    private boolean loop = false;
    
    private boolean playing = false;
    private int time = 0;
    
    public Animation (int length, int speed, boolean loop){
        
        this.length = length;
        this.speed = speed;
        this.loop = loop;
    }
    
    public void update(){
        if(playing){
            time++;
            if(time>speed){
                frame++;
                if(frame>=length){
                    if(loop) frame=1;
                    else frame = length;
                }
                time = 0;
            }
        }else{
            frame=0;
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
    
    public int getCurrentFrame(){
        return frame;
    }
}
