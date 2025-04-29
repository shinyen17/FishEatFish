public class MediumEnemyLeft extends Enemy {
    public MediumEnemyLeft(){
        this.x = 1050;
        this.y = (int)(Math.random()*400+100);
        this.width = 100;
        this.height = 70;
        this.speed = 15;
        this.dir = -1;
        this.point = 2;
        this.type = 2;
        this.img = Utilities.mel;
    }
}
