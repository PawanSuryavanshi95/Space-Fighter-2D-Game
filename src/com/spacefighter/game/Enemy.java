package com.spacefighter.game;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class Enemy{
        
        public static final int EN_WIDTH = 70 ,EN_HEIGHT = 70,speedy = 4 ,speedx = 2 ,bulletSpeed = 6;
        private float x ,y;
        private ArrayList<Rectangle> bullets;
        private int ticks = 0;
        private Rectangle bounds ;
        private int health = 3;
        private BufferedImage enemy;
        private boolean alive = true,collision = false;
        private Rectangle[] EB;
        
        public Enemy(float x ,float y,BufferedImage enemy){
            this.x = x;
            this.y = y;
            bounds = new Rectangle((int) this.x +10,(int) this.y +10,EN_WIDTH ,EN_HEIGHT);
            EB = new Rectangle[6];
            EB[0] = new Rectangle((int) x+10,(int) y+17,49,25);
            EB[1] = new Rectangle((int) x+9,(int) y+3,14,14);
            EB[2] = new Rectangle((int) x+47,(int) y+3,14,14);
            EB[3] = new Rectangle((int) x+30,(int) y+42,9,28);
            EB[4] = new Rectangle((int) x+0,(int) y+0,10,8);
            EB[5] = new Rectangle((int) x+60,(int) y+0,10,8);
            bullets = new ArrayList<Rectangle>();
            this.enemy = enemy;
        }
        
        public void tick(int playerX,int playerY,Rectangle playerBounds){
            y += speedy;
            if((Math.abs(this.x - playerX) > 0) && (playerY - this.y) < 300 && (playerY - this.y)>0){
                if((this.x - (playerX-5))<0)
                    x += speedx;
                else
                    x -= speedx;
            }
            bounds.setBounds((int)x  + 10,(int)y + 10,EN_WIDTH,EN_HEIGHT);
            EB[0].setBounds((int) x+10,(int) y+17,49,25);
            EB[1].setBounds((int) x+9,(int) y+3,14,14);
            EB[2].setBounds((int) x+47,(int) y+3,14,14);
            EB[3].setBounds((int) x+30,(int) y+42,9,28);
            EB[4].setBounds((int) x+0,(int) y+0,10,8);
            EB[5].setBounds((int) x+60,(int) y+0,10,8);
            ticks++;
            if(alive)
            if(Math.abs(this.x - playerX)<=60 && ticks>=45){
                if(ticks >= 45){
                    ticks -= 45;
                }
                bullets.add(new Rectangle((int) x + (EN_WIDTH-5)/2,(int) y + (EN_HEIGHT-10)/2,5 ,10));
            }
            
            for(int i = 0 ;i < bullets.size();i++){
                bullets.get(i).setLocation((int) bullets.get(i).getX(),(int) bullets.get(i).getY() + bulletSpeed);
                if(bullets.get(i).getY() < -10)
                    bullets.remove(i);
            }
        }
        
        public boolean checkCollision(Rectangle r){
            for(Rectangle EB : EB){
                if(r.intersects(EB)){
                    health--;
                    return true;
                }
            }
            return false;
        }
        
        public void render(Graphics g){
            if(alive)
            g.drawImage(enemy ,(int)x, (int)y, EN_WIDTH, EN_HEIGHT,null);
            g.setColor(Color.ORANGE);
            for(int i = 0;i < bullets.size();i++){
                g.fillRect((int) bullets.get(i).getX() ,(int) bullets.get(i).getY() ,(int) bullets.get(i).getWidth() ,(int) bullets.get(i).getHeight());
            }
//            g.setColor(Color.red);
//            for(Rectangle r : EB){
//                g.fillRect((int) r.getX(),(int) r.getY(),(int) r.getWidth(),(int) r.getHeight());
//            }
        }
        
        public float getX(){
            return x;
        }
        
        public float getY(){
            return y;
        }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public ArrayList<Rectangle> getBullets() {
        return bullets;
    }

    public Rectangle[] getEB() {
        return EB;
    }

    public void setEB(Rectangle[] EB) {
        this.EB = EB;
    }

    public int getHealth() {
        return health;
    }
    
}
