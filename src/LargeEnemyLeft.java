import java.awt.*;

public class LargeEnemyLeft extends Enemy{
    public LargeEnemyLeft(){
        this.x = 1050;
        this.y = (int)(Math.random()*400+120);
        this.width = 180;
        this.height = 120;
        this.speed = 20;
        this.dir = -1;
        this.point = 3;
        this.type = 3;
        this.img = Utilities.lel;
    }

    public Rectangle getRec(){
        return new Rectangle(x+50,y+30,width-100,height-60);
    }
}
