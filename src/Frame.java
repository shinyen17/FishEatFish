//mouse movement - change direction

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
    //background
    static int state = 0;
    int width = 1000;
    int height = 600;
    Background bg = new Background();
    Image offScreenImage;

    //enemy fish
    Enemy enemy;
    Double random;
    int time = 0;

    //My Fish
    MyFish myFish = new MyFish();
    public void launch(){
        this.setVisible(true);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Fish Eat Fish");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Click any key to start
        /*this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (state == 0) {
                    state = 1;
                    repaint();
                }
            }
        });*/

        //Click anywhere to start
        /*this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1&&state==0){
                    state=1;
                    repaint();
                }
            }
        });*/



        //mouse movement
        /*this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                myFish.x = e.getX();
                myFish.y = e.getY();
            }
        });*/

        //keyboard movement
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    Utilities.UP = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                    Utilities.DOWN = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                    Utilities.LEFT = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                    Utilities.RIGHT = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    Utilities.UP = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                    Utilities.DOWN = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                    Utilities.LEFT = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                    Utilities.RIGHT = false;
                }
                if(e.getKeyCode() == 32){
                    switch (state){
                        case 0:
                            state = 1;
                            break;
                        case 1:
                            state = 4;
                            break;
                        case 2:
                            restart();
                            state = 1;
                        case 3:
                            restart();
                            state = 1;
                        case 4:
                            state = 1;
                            break;
                    }
                }
            }
        });

        //refresh rate
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g){
        //double buffering
        offScreenImage = createImage(width,height);
        Graphics gImage = offScreenImage.getGraphics(); //draw on offScreenImage first
        bg.paintBG(gImage);

        switch(state){
            case 0: //start
                gImage.setFont(FontManager.getBSF(150f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Fish Eat Fish",145,255);
                gImage.setColor(new Color(255, 129, 13));
                gImage.drawString("Fish Eat Fish",140,250);

                gImage.setFont(FontManager.getBSF(35f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Press space bar to Start...",337,332);
                gImage.setColor(new Color(0, 81, 115));
                gImage.drawString("Press space bar to Start...",335,330);

                break;

            case 1: //game
                gImage.setFont(FontManager.getBSF(35f).deriveFont(Font.BOLD, 35f));
                gImage.setColor(new Color(255, 129, 13));
                gImage.drawString("Score  " + Utilities.point, 150,90);
                gImage.setFont(FontManager.getBSF(35f).deriveFont(Font.BOLD, 35f));
                gImage.setColor(new Color(255, 129, 13));
                gImage.drawString("Difficulty  " + Utilities.level, 425,90);
                gImage.setFont(FontManager.getBSF(35f).deriveFont(Font.BOLD, 35f));
                gImage.setColor(new Color(255, 129, 13));
                gImage.drawString("Level  " + myFish.level, 750,90);


                myFish.paintSelf(gImage);

                logic();
                for(Enemy enemy : Utilities.EnemyList){
                    enemy.paintSelf(gImage);
                }
                break;
            case 2: //lose
                myFish.paintSelf(gImage);

                gImage.setFont(FontManager.getBSF(150f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Defeat...",285,305);
                gImage.setColor(new Color(159, 83, 21));
                gImage.drawString("Defeat...",280,300);

                gImage.setFont(FontManager.getBSF(35f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Press space bar to Restart...",327,362);
                gImage.setColor(new Color(0, 81, 115));
                gImage.drawString("Press space bar to Restart...",325,360);

                gImage.setFont(FontManager.getBSF(30f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Score:  " + Utilities.point,427,412);
                gImage.setColor(new Color(0, 81, 115));
                gImage.drawString("Score:  " + Utilities.point,425,410);

                gImage.setColor(new Color(0, 0, 0, 100));
                gImage.fillRect(0, 0, getWidth(), getHeight());
                break;
            case 3: //win
                myFish.paintSelf(gImage);

                gImage.setFont(FontManager.getBSF(150f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Victory!",285,285);
                gImage.setColor(new Color(255, 129, 13));
                gImage.drawString("Victory!",280,280);

                gImage.setFont(FontManager.getBSF(35f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Press space bar to Restart...",327,362);
                gImage.setColor(new Color(0, 81, 115));
                gImage.drawString("Press space bar to Restart...",325,360);

                gImage.setFont(FontManager.getBSF(30f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Score:  " + Utilities.point,427,412);
                gImage.setColor(new Color(0, 81, 115));
                gImage.drawString("Score:  " + Utilities.point,425,410);

                break;
            case 4: //pause
                gImage.setColor(new Color(0, 0, 0, 100));
                gImage.fillRect(0, 0, getWidth(), getHeight());

                gImage.setFont(FontManager.getBSF(50f));
                gImage.setColor(new Color(0, 0, 0, 80));
                gImage.drawString("Press space bar to Resume...",247,322);
                gImage.setColor(new Color(255, 129, 13));
                gImage.drawString("Press space bar to Resume...",245,320);

                break;
            default:
                break;
        }

        //double buffering
        g.drawImage(offScreenImage,0,0,width,height,null); //display offScreenImage, g=main graphic
    }


    //add many fish
    int speed = 10;
    public void logic(){
        //small myFish
        if(Utilities.point<20){
            myFish.level = 1;
            Utilities.level = 1;
        }else if(Utilities.point<=40){
            myFish.level = 1;
            Utilities.level =2;
        //medium myFish
        }else if(Utilities.point<=60){
            myFish.level = 2;
            Utilities.level = 3;
        }else if(Utilities.point<=80){
            myFish.level = 2;
            Utilities.level = 4;
        //large myFish
        }else if(Utilities.point<=100){
            myFish.level = 3;
            Utilities.level = 5;
        }else if(Utilities.point<120){
            myFish.level = 3;
            Utilities.level = 6;
        }else {
            state = 3; //win
        }

        //production of fish
        random = Math.random();
        switch(Utilities.level){
            case 0:
                if(time%50==0){
                    if(random>0.5){
                        enemy = new SmallEnemyLeft();
                    }else{
                        enemy = new SmallEnemyRight();
                    }

                    Utilities.EnemyList.add(enemy);
                }
                break;
            case 1:
                if(time%speed==0){
                    if(random>0.5){
                        enemy = new SmallEnemyLeft();
                    }else{
                        enemy = new SmallEnemyRight();
                    }

                    Utilities.EnemyList.add(enemy);
                }
                break;
            case 2:
                if(time%speed==0){
                    if(random>0.9){
                        enemy = new MediumEnemyLeft();
                    }else if(random>0.8){
                        enemy = new MediumEnemyRight();
                    }else if(random>0.4){
                        enemy = new SmallEnemyLeft();
                    }else{
                        enemy = new SmallEnemyRight();
                    }

                    Utilities.EnemyList.add(enemy);
                }
                break;
            case 3:
                if(time%speed==0){
                    if(random>0.75){
                        enemy = new MediumEnemyLeft();
                    }else if(random>0.5){
                        enemy = new MediumEnemyRight();
                    }else if(random>0.25){
                        enemy = new SmallEnemyLeft();
                    }else{
                        enemy = new SmallEnemyRight();
                    }

                    Utilities.EnemyList.add(enemy);
                }
                break;
            case 4:
                if(time%speed==0){
                    if(random>0.9){
                        enemy = new LargeEnemyLeft();
                    }else if(random>0.8){
                        enemy = new LargeEnemyRight();
                    }else if(random>0.6){
                        enemy = new MediumEnemyLeft();
                    }else if(random>0.4){
                        enemy = new MediumEnemyRight();
                    }else if(random>0.2){
                        enemy = new SmallEnemyLeft();
                    }else{
                        enemy = new SmallEnemyRight();
                    }

                    Utilities.EnemyList.add(enemy);
                }
                break;
            case 5:
                if(time%speed==0){
                    if(random>0.8){
                        enemy = new LargeEnemyLeft();
                    }else if(random>0.6){
                        enemy = new LargeEnemyRight();
                    }else if(random>0.4){
                        enemy = new MediumEnemyLeft();
                    }else if(random>0.2){
                        enemy = new MediumEnemyRight();
                    }else if(random>0.1){
                        enemy = new SmallEnemyLeft();
                    }else{
                        enemy = new SmallEnemyRight();
                    }

                    Utilities.EnemyList.add(enemy);
                }
                break;
            case 6:
                if(time%speed==0){
                    if(random>0.8){
                        enemy = new BossLeft();
                    }else if(random>0.6){
                        enemy = new BossRight();
                    }else if(random>0.5){
                        enemy = new LargeEnemyLeft();
                    }else if(random>0.4){
                        enemy = new LargeEnemyRight();
                    }else if(random>0.3){
                        enemy = new MediumEnemyLeft();
                    }else if(random>0.2){
                        enemy = new MediumEnemyRight();
                    }else if(random>0.1){
                        enemy = new SmallEnemyLeft();
                    }else{
                        enemy = new SmallEnemyRight();
                    }

                    Utilities.EnemyList.add(enemy);
                }
                break;
            default:
                break;
        }


        //direction of fish
        for(Enemy enemy: Utilities.EnemyList){
            enemy.x = enemy.x + (enemy.speed*enemy.dir);

            if(myFish.getRec().intersects(enemy.getRec())){
                if(myFish.level>=enemy.type){
                    //System.out.println("Collides");
                    enemy.x = -200;
                    enemy.y = -200;
                    Utilities.point += enemy.point;
                }else{
                    state = 2;
                }


            }

        }
    }

    public void restart(){
        Utilities.EnemyList.clear();
        Utilities.point = 0;
        time = 0;
        myFish.level = 1;
        myFish.x = 500;
        myFish.y = 300;
        myFish.width = 50;
        myFish.height = 50;
        myFish.level = 1;
    }

}
