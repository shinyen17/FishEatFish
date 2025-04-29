import java.awt.*;

public class Enemy {
    Image img;
    int x;
    int y;
    int width;
    int height;
    int speed;
    int dir;
    int type;
    int point;

    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }

    //get the matrices of the enemy fish
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }

}
