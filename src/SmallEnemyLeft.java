public class SmallEnemyLeft extends Enemy{
    public SmallEnemyLeft(){
            this.x = 1050;
            this.y = (int)(Math.random()*400+100);
            this.width = 70;
            this.height = 49;
            this.speed = 10;
            this.dir = -1;
            this.point = 1;
            this.type = 1;
            this.img = Utilities.sel;
    }
}

