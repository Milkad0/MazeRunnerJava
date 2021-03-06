/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Vincent
 */
public class MyTexture {

    public static MyTexture squares = loadTexture("/Texture/blocks1.png");
    public static MyTexture human = loadTexture("/Characters/Player/Human.png");
    public static MyTexture pacer = loadTexture("/Characters/Pacer/Pacer.png");
    public static MyTexture rover = loadTexture("/Characters/Rover/Rover.png");
    public static MyTexture jumper = loadTexture("/Characters/Jumper/Jumper.png");
    
    int width, height;
    int id;

    public MyTexture(int width, int height, int id) {
        this.width = width;
        this.height = height;
        this.id = id;

    }

    public static MyTexture loadTexture(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(MyTexture.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int w = image.getWidth();
        int h = image.getHeight();

        int pixels[] = new int[w * h];
        image.getRGB(0, 0, w, h, pixels, 0, w);

        ByteBuffer buffer = BufferUtils.createByteBuffer(w * h * 4);//3 color + alpha

        for (int y = 0; y < w; y++) {
            for (int x = 0; x < h; x++) {
                int i = pixels[x + y * w]; //Chercher pixel indiduellement dans arraylist
                buffer.put((byte) ((i >> 16) & 0xFF)); //R
                buffer.put((byte) ((i >> 8) & 0xFF)); //G
                buffer.put((byte) ((i) & 0xFF)); //B
                buffer.put((byte) ((i >> 24) & 0xFF)); //Alpha
            }
        }
        buffer.flip();

        int id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, w, h, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

        return new MyTexture(w, h, id);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }

    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }
}
