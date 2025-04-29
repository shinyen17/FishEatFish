public class BossLeft extends Enemy{
    public BossLeft(){
        this.x = 1050;
        this.y = (int)(Math.random()*150+100);
        this.width = 300;
        this.height = 300;
        this.speed = 50;
        this.dir = -1;
        this.point = 0;
        this.type = 10;
        this.img = Utilities.bossl;
    }
}
