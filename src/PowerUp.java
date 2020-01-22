
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 *
 * @author Pawan Suryavanshi
 */
public class PowerUp {
    private BufferedImage img;
    private int speed,x,y;
    private long timer = 0;
    private final int W = 40,H = 40;
    private boolean collision = false;
    private Rectangle bounds;
    
    public PowerUp(BufferedImage img,int speed,int x){
        this.img = img;
        this.speed = speed;
        this.x = x;
        y = -H;
        bounds = new Rectangle(x,y,W,H);
    }
    
    public void tick(long time){
        if(collision){
            bounds.setBounds(0, 0, 0, 0);
            this.timer += time;
            if((timer/1000000000)%10 == 0){
                y = -H;
                timer = 0;
            }
        }
        else{
            y += speed;
            bounds.setBounds(x, y, W, H);
        }
    }
    public void render(Graphics g){
        if(!collision)
        g.drawImage(img, x, y, W, H, null);
    }

    public Rectangle getBounds() {
        return bounds;
    }
    
}
