//lagging when change x dir at the first time;
//can run outside the screen

import java.awt.*;

public class MyFish {
    Image img = Utilities.mfl;

    int x = 500;
    int y = 300;
    int width = 50;
    int height = 50;

    int speed = 20;

    int level = 1;

    public void logic(){
        if(Utilities.UP){
            y = y-speed;
        }
        if(Utilities.DOWN){
            y = y+speed;
        }
        if(Utilities.LEFT){
            img = Utilities.mfl;
            x = x-speed;
        }
        if(Utilities.RIGHT){
            img = Utilities.mfr;
            x = x+speed;
        }
        this.changeSize();
    }

    public void paintSelf(Graphics g){
        logic();
        g.drawImage(img,x,y,width,height,null);
    }

    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }

    public void changeSize(){
        switch(this.level){
            case 1:
                this.width = 50;
                this.height = 50;
                break;
            case 2:
                this.width = 75;
                this.height = 75;
                break;
            case 3:
                this.width = 130;
                this.height = 130;
                break;
            default:
                break;

        }
    }
}
