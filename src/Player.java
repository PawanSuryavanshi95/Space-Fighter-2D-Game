
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Player {
    private final int P_WIDTH = 60,P_HEIGHT = 60;
    private int x, y, health = 10, bulletSpeed = 6;
    private BufferedImage img;
    private ArrayList<Rectangle> bullets;
    private Rectangle playerBounds;
    private Rectangle[] PB;
    
    public Player(int x,int y,BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
        playerBounds = new Rectangle(x,y,P_WIDTH,P_HEIGHT);
        bullets = new ArrayList<Rectangle>();
        PB = new Rectangle[7];
        PB[0] = new Rectangle();
        PB[1] = new Rectangle();
        PB[2] = new Rectangle();
        PB[3] = new Rectangle();
        PB[4] = new Rectangle();
        PB[5] = new Rectangle();
        PB[6] = new Rectangle();
    }
    
    public void tick(int mouseX,int mouseY,int width,int height){
        if(mouseY < height/5)
            y = height/5;
        else if(mouseY > height - 60)
            y = height - 60;
        else
            y = mouseY;
        
        if(mouseX > width - 30)
            x = width - 60;
        else if(mouseX <= 30)
            x = 0;
        else
            x = mouseX - 30;
        
        playerBounds.setBounds(x, y, P_WIDTH, P_HEIGHT);
        PB[0].setBounds(x + 18, y + 29, 23, 30);
        PB[1].setBounds(x + 21, y + 13, 17, 16);
        PB[2].setBounds(x + 26, y + 1, 8, 12);
        PB[3].setBounds(x + 10, y + 31, 8, 24);
        PB[4].setBounds(x + 42, y + 31, 8, 24);
        PB[5].setBounds(x + 0, y + 43, 10, 8);
        PB[6].setBounds(x + 50, y + 43, 10, 8);
        
        for(int i = 0;i < bullets.size(); i++){
            bullets.get(i).setLocation((int) bullets.get(i).getX(),(int) bullets.get(i).getY() - bulletSpeed);
            if(bullets.get(i).getY() <= -10)
                bullets.remove(i);
        }
    }
    
    public void shoot(){
        bullets.add(new Rectangle(x + 27, y, 5, 10));
    }
    
    public boolean checkCollision(Rectangle[] rect){
        for(Rectangle PB : PB){
            for(Rectangle r : rect){
                if(r.intersects(PB)){
                    health--;
                    System.out.println("Enemy");
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkCollision(Rectangle r,String s){
        for(Rectangle PB : PB){
            if(r.intersects(PB)){
                health--;
                System.out.println(""+s);
                return true;
            }
        }
        return false;
    }
    
    public void render(Graphics g){
        g.drawImage(img, x, y, P_WIDTH, P_HEIGHT, null);
        g.setColor(Color.PINK);
        try{
            for(Rectangle b : bullets){
                g.fillRect((int) b.getX(),(int) b.getY(),(int) b.getWidth(),(int) b.getHeight());
            }
        }
        catch(ConcurrentModificationException e){
            System.out.println("Error aaya.");
            System.out.println("Han toh !");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getPlayerBounds() {
        return playerBounds;
    }

    public ArrayList<Rectangle> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<Rectangle> bullets) {
        this.bullets = bullets;
    }

    public int getHealth() {
        return health;
    }

    public Rectangle[] getPB() {
        return PB;
    }

    public void setPB(Rectangle[] PB) {
        this.PB = PB;
    }
    
}
