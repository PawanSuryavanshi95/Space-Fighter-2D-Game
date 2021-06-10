package com.spacefighter.game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Pawan Suryavanshi
 */
public class BackGround {
    private Rectangle r1,r2;
    private final int width,height;
    private final BufferedImage img;
    private final int speed = 2;
    
    public BackGround(int w ,int h,BufferedImage img){
        width = w;
        height = (int) (h*2.5);
        r1 = new Rectangle(0, (int) (-height*0.5),width, height);
        r2 = new Rectangle(0, (int) (r1.getY()-height),width, height);
        this.img = img;
    }
    
    public void tick(){
        r1.setLocation((int) r1.getX(),(int) r1.getY()+speed);
        r2.setLocation((int) r2.getX(),(int) r2.getY()+speed);
        if(r1.getY()>=height){
            r1.setLocation((int) r1.getX(), (int) (r1.getY()-height*2));
        }
        if(r2.getY()>=height){
            r2.setLocation((int) r2.getX(), (int) (r2.getY()-height*2));
        }
    }
    
    public void render(Graphics g){
        g.drawImage(img,(int) r1.getX(),(int) r1.getY() , width, height, null);
        g.drawImage(img,(int) r2.getX(),(int) r2.getY() , width, height, null);
    }

    public int getSpeed() {
        return speed;
    }
    
}
