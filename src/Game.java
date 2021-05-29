/*
               Made ENTIRELY by  .:: Pawan Suryavanshi 'The Great' ::.
 */


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Pawan Suryavanshi
 */
public class Game implements Runnable ,MouseListener ,MouseMotionListener{
    int width ,height ,ticks ,obs_speed = 2 ,subWidth ,score = 0 ,secCount = 0 ,
            enKills = 0;
    long time = 0;
    String title;
    JFrame frame;
    Canvas canvas;
    BufferStrategy bs;
    Graphics g;
    boolean GameRunning = false ,moveRight = false ,moveLeft = false;
    Thread t;
    public int mouseX ,mouseY;
    ArrayList<Enemy> enemies;
    ArrayList<Obstacle> obstacles;
    Random ran = new Random();
    boolean bool = true;
    BufferedImage playerIMG,asteroidSprite ,currentAsteroid ,enemy,bgIMG,repair;
    BufferedImage[] asteroids;
    Rectangle playerBounds;
    ArrayList <Rectangle> bullets;
    BackGround BG;
    Player player;
    PowerUp PU;
    int lastFPS;

    public Game(String title ,int width ,int height ,int subWidth){
        this.title = title;
        this.height = height;
        this.width = width;
        this.subWidth = subWidth;
    }
    
    public void init(){
        createDisplay();
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        
        loadImages();
        
        enemies = new ArrayList<>();
        obstacles = new ArrayList<>(); 
        BG = new BackGround(width,height,bgIMG);
        player = new Player(mouseX, mouseY, playerIMG);
        bullets = new ArrayList<>();
    }
    
    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width + subWidth,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setEnabled(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width  + subWidth,height));
        canvas.setMaximumSize(new Dimension(width  + subWidth,height));
        canvas.setMinimumSize(new Dimension(width  + subWidth,height));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.pack();   
        
        //   Hiding Cursor
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
        cursorImg, new Point(0, 0), "blank cursor");
        frame.getContentPane().setCursor(blankCursor);
    }
    
    public void loadImages(){
        try {
            
            playerIMG = ImageIO.read(this.getClass().getResource("/img/Player_Shuttle.png"));
            enemy = ImageIO.read(this.getClass().getResource("/img/Enemy_Shuttle.png"));
            bgIMG = ImageIO.read(this.getClass().getResource("/img/BG.png"));
            repair = ImageIO.read(this.getClass().getResource("/img/repair.png"));
            asteroids = new BufferedImage[16];

            for(int i=0;i<16;i++){
                asteroids[i] = ImageIO.read(this.getClass().getResource("/img/asteroids_"+(i+1)+".png"));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createEnemy(){
        if(enemies.isEmpty())
            enemies.add(new Enemy(ran.nextInt(width - 50) ,-100,enemy));
        
        if(enemies.get(enemies.size() - 1).getY() >= height/2)
            enemies.add(new Enemy(ran.nextInt(width - 50) ,-50,enemy));
    }
    
    public void createObstacles() {
        
        if(!enemies.isEmpty()){
            if((obstacles.isEmpty()) && (enemies.get(enemies.size() - 1).getY() >= height/4)){
                obstacles.add(new Obstacle(bool , ran.nextInt(width - 60) ,-60 ,ran.nextInt(5)+obs_speed,ran.nextInt(5)+obs_speed,asteroids[ran.nextInt(16)]));
                int x;
                x = (int) obstacles.get(obstacles.size()-1).getX() + width/2;
                if(x > width - 60){
                    x -= width;
                }
                obstacles.add(new Obstacle(bool , x ,-30 ,ran.nextInt(5)+obs_speed,ran.nextInt(3)+obs_speed,asteroids[ran.nextInt(16)]));
            }
        
            if(!obstacles.isEmpty())
                if(obstacles.get(obstacles.size() - 2).getY() >= height/4){
                    if(obstacles.size()%2 == 0)
                        bool = true;
                    else
                        bool = false;
                obstacles.add(new Obstacle(bool ,ran.nextInt(width - 30) ,-30 ,ran.nextInt(5)+obs_speed,ran.nextInt(5)+obs_speed,asteroids[ran.nextInt(16)]));
            }
        }
        
    }
    
    public void tick(){
        playerBounds = player.getPlayerBounds();
        bullets = player.getBullets();
        
        createEnemy();
        createObstacles();
        
        player.tick(mouseX,mouseY,width,height);
        
        // Updating BackGround
        BG.tick();
        
        try{
        // Updating Enemies and their Bullets
        
        for(int i = 0 ;i < enemies.size();i++){
            enemies.get(i).tick(player.getX(),player.getY(),playerBounds);
            if(enemies.get(i).getBounds().intersects(playerBounds)){
                if(!enemies.get(i).isCollision()){
                    enemies.get(i).setCollision(player.checkCollision(enemies.get(i).getEB()));
                }
            }
            else{
                enemies.get(i).setCollision(false);
            }
            for(int j = 0;j < enemies.get(i).getBullets().size();j++){
                if(enemies.get(i).getBullets().get(j).intersects(playerBounds)){
                    if(player.checkCollision(enemies.get(i).getBullets().get(j),"Enemy Bullet")){
                        enemies.get(i).getBullets().remove(j);
                        if(j >= enemies.get(i).getBullets().size()) break;
                    }
                }
            }
            if(enemies.get(i).isAlive())
            for(int j = 0;j < bullets.size();j++){
                if(bullets.get(j).intersects(enemies.get(i).getBounds())){
                    if(enemies.get(i).checkCollision(bullets.get(j))){
                        bullets.remove(bullets.get(j));
                        if(j >= bullets.size()) break;
                    }
                }
                if(bullets.get(j).getY()>=height){
                    bullets.remove(bullets.get(j));
                    if(j >= bullets.size()) break;
                }
            }
            if(enemies.get(i).getHealth() <= 0 && enemies.get(i).isAlive()){
                enemies.get(i).setAlive(false);
                enKills++;
            }
            if(enemies.get(i).getY() > height){
                enemies.remove(i);
                if(i >= enemies.size()) break;
            }
        }
        
        player.setBullets(bullets);
        
        for(int i = 0;i < enemies.size(); i++){
            if(enemies.get(i).getBullets().isEmpty()&&(!enemies.get(i).isAlive())){
                enemies.remove(i);
                if(i >= enemies.size()) break;
            }
        }
        
        // Updating Obstacles
        
        for(int i = 0 ;i < obstacles.size();i++){
            obstacles.get(i).tick(playerBounds,width);
            if(obstacles.get(i).getBounds().intersects(playerBounds)){
                if(!obstacles.get(i).isCollision()){
                    obstacles.get(i).setCollision(player.checkCollision(obstacles.get(i).getBounds(),"Obstacle"));
                }
            }else{
                obstacles.get(i).setCollision(false);
            }
            if(obstacles.get(i).getY() > height){
                obstacles.remove(i);
                if(i >= obstacles.size()) break;
            }
                
            for(Obstacle o : obstacles){
                if(o.getBounds().intersects(obstacles.get(i).getBounds()) && o!=obstacles.get(i)){
                    int speedX = o.getSpeedX(),speedY = o.getSpeedY();
                    boolean dir = o.getDirection();
                    o.setSpeedX(obstacles.get(i).getSpeedX());
                    o.setSpeedY(obstacles.get(i).getSpeedY());
                    obstacles.get(i).setSpeedX(speedX);
                    obstacles.get(i).setSpeedY(speedY);
                    o.setDirection(obstacles.get(i).getDirection());
                    obstacles.get(i).setDirection(dir);
                }
            }
        }
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    
//        if(time >= 10000000000){
//            
//        }
    }
    
    public void render(){
        bs = canvas.getBufferStrategy();
        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        
        //  ---------------------  Draw Here  ----------------------------------
        
        // Drawing BackGround and Player
        BG.render(g);
        player.render(g);
        
        // Drawing Enemies and their bullets
        g.setColor(Color.GREEN);
        for(Enemy e : enemies){
            e.render(g);
        }
        
        // Drawing Obstacles
        for(Obstacle O : obstacles){
            O.render(g);
        }
        
        // Drawing Sub Screen
        g.setColor(Color.ORANGE);
        g.fillRect(width, 0, subWidth, height);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(width, 0, 9, height);
        g.fillRect(frame.getWidth()-15, 0, 10, height);
        g.fillRect(width, 0, subWidth, 9);
        g.fillRect(width, frame.getHeight()-35, subWidth, 10);
        g.setFont(new Font("IMPACT" ,Font.PLAIN , 20));
        g.drawString("Score    :", width + 30, 50);
        g.drawString("" + score, width + 30, 100);
        g.drawString("Enemies ", width + 30, 150);
        g.drawString("Dead     :", width + 30, 180);
        g.drawString("" + enKills, width + 30, 230);
        g.drawString("Health   :   " + player.getHealth(), width + 30, 280);
        
        g.drawString("FPS   :   "+lastFPS, width +30, 400);
        
        //  -----------------------  End Drawing  ------------------------------
        
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        
        int fps = 60 ;
        long timer = 0;
        long lastTime = System.nanoTime();
        long now;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long scoreTimer = 0;
        ticks = 0;
        
        while(GameRunning){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            scoreTimer += now - lastTime;
            time += (now - lastTime);
            lastTime = now;
            
            if(delta >= 1){
                delta--;
                ticks++;
                tick();
                render();
                if(player.getHealth() <= 0){
                    GameRunning = false;
                }
            }
            if(scoreTimer >= 500000000){
                score++;
                scoreTimer = 0;
            }
            if(timer >= 1000000000){
                lastFPS = ticks;
                timer = 0;
                ticks = 0;
            }
        }
        
        stop();
    }
    
    public synchronized void start(){
        if(GameRunning)
           return;
        
        GameRunning = true;
        t = new Thread(this);
        t.start();
    }
    
    public synchronized void stop(){
        System.out.println("hey");
        if(!GameRunning){
            frame.setFocusable(false);
            frame.dispose();
            GameOver gameOver = new GameOver(score);
            gameOver.setVisible(true);
            gameOver.setLocationRelativeTo(null);
            return;
        }
        else
            System.out.println("game is running");
        
        GameRunning = false;

        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Input Methods

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        player.shoot();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public boolean isGameRunning() {
        return GameRunning;
    }
    
    public int getScore() {
        return score;
    }
    
    
}
