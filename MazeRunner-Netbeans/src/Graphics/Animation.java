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

    private int frame;
    private int length;
    private int speed;
    private int firstFrame;
    private int resetFrame;
    private int fakeFrame=0;
    private boolean reverse = false;
    private boolean loop = false;

    private boolean playing = false;
    private int time = 0;

    public Animation(int resetFrame, int firstFrame, int lastFrame, int speed, boolean loop, boolean reverse) {

        this.firstFrame = firstFrame;
        this.length = lastFrame;
        this.speed = speed;
        this.loop = loop;
        this.resetFrame = resetFrame;
        this.reverse = reverse;
    }

    public void update() {

        if (playing) {
            time++;
            if (time > speed) {
                
                if(reverse){
                    if(frame==0){
                        frame=firstFrame-1;
                    }
                    frame --;
                    fakeFrame++;
                    if (fakeFrame >= length) {
                    if (loop) {
                        frame = firstFrame - 1;
                        fakeFrame = 0;
                    } else {
                        fakeFrame = length;
                        frame = resetFrame-1;
                    }
                }
                }else{
                
                frame++;
                if (frame >= length) {
                    if (loop) {
                        frame = firstFrame - 1;
                    } else {
                        frame = length;
                    }
                }
                }
                time = 0;
            }
        } else {
            frame = resetFrame - 1;
            fakeFrame = 0;
        }

    }

    public void play() {
        playing = true;
    }

    public void pause() {
        playing = false;
    }

    public void stop() {
        playing = false;
        frame = 0;
    }

    public boolean getPlaying() {
        return playing;
    }

    public int getCurrentFrame() {
        return frame;
    }
}
