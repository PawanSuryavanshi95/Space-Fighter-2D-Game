
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


class Obstacle{
        
        private int OB_WIDTH = 50 ,OB_HEIGHT = 50;
        private boolean direction,collision = false;
        private float x ,y;
        private int speedX = 0,speedY = 0;
        private BufferedImage img;
        private Rectangle bounds;
        private int tick = 0;
        
        public Obstacle(boolean b ,float x ,float y ,int speedX ,int speedY ,BufferedImage img){
            direction = b;
            this.x = x;
            this.y = y;
            this.speedX = speedX;
            this.speedY = speedY+2;
            this.img = img;
            int i = new Random().nextInt(2);
            OB_WIDTH = OB_WIDTH + (i*10);
            OB_HEIGHT = OB_HEIGHT + (i*10);
            bounds = new Rectangle((int) this.x,(int) this.y,OB_WIDTH,OB_HEIGHT);
        }
        
        public void tick(Rectangle playerBounds,int width){
            if(direction){
                if(x >= 0){
                    x -= speedX;
                }
                else{
                    direction = false;
                }
            }
            else{
                if(x <= (width-OB_WIDTH)){
                    x += speedX;
                }
                else{
                    direction = true;
                }
            }
            tick++;
            
            y += speedY;
            bounds.setBounds((int) (x + 10),(int) (y + 10),OB_WIDTH-20 ,OB_HEIGHT-20);
        }
        public void render(Graphics g){
            g.drawImage(img ,(int) x ,(int) y ,OB_WIDTH ,OB_HEIGHT ,null);
        }
        
        public float getX(){
            return x;
        }
        
        public float getY(){
            return y;
        }
        
        public boolean getDirection(){
            return direction;
        }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isCollision() {
        return collision;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
    
    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }
    
    }