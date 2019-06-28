/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.io.IOException;
import java.io.InputStream;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Vincent
 */
public class View {

    public static void quadData(float x, float y, int width, int height, float[] color, int xo, int yo) {
        glColor4f(color[0], color[1], color[2], color[3]);
        glTexCoord2f((0 + xo) / 32.0f, (0 + yo) / 32.0f);
        glVertex2f(x, y);
        glTexCoord2f((1 + xo) / 32.0f, (0 + yo) / 32.0f);
        glVertex2f(x + width, y);
        glTexCoord2f((1 + xo) / 32.0f, (1 + yo) / 32.0f);
        glVertex2f(x + width, y + height);
        glTexCoord2f((0 + xo) / 32.0f, (1 + yo) / 32.0f);
        glVertex2f(x, y + height);
    }

    public static void renderQuad(float x, float y, int width, int height, float[] color, int xo, int yo) {
        glBegin(GL_QUADS);
        quadData(x, y, width, height, color, xo, yo);
        glEnd();
    }

    public static void renderCharacters(float x, float y, int width, int height, float[] color, float size, int xo, int yo) {
        glBegin(GL_QUADS);
        glColor4f(color[0], color[1], color[2], color[3]);
        glTexCoord2f((0 + xo) / size, (0 + yo) / size);
        glVertex2f(x, y);
        glTexCoord2f((1 + xo) / size, (0 + yo) / size);
        glVertex2f(x + width, y);
        glTexCoord2f((1 + xo) / size, (1 + yo) / size);
        glVertex2f(x + width, y + height);
        glTexCoord2f((0 + xo) / size, (1 + yo) / size);
        glVertex2f(x, y + height);
        glEnd();
    }
    
    public static void renderBackground (org.newdawn.slick.opengl.Texture tex, int x, int y, int width, int height){
        
        tex.bind();
        glTranslatef(x,y,0);
        glBegin(GL_QUADS);
        glTexCoord2f(0 ,0);
        glVertex2f(0,0);
        glTexCoord2f(1,0);
        glVertex2f(width,0);
        glTexCoord2f(1,1);
        glVertex2f(width,height);
        glTexCoord2f(0,1);
        glVertex2f(0,height);
        glLoadIdentity();
        glEnd();
    
    }
    
      public static Texture loadTextureMenu(String path, String fileType){
        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try{
            tex = TextureLoader.getTexture(fileType, in);
        }catch(IOException e){
            e.printStackTrace();
        }
        return tex;
    }
      
      public static Texture QuickLoadMenuTexture(String name){
        Texture tex = null;
        tex = loadTextureMenu("Texture/"+name+".png","PNG");
        return tex;
    }
}
