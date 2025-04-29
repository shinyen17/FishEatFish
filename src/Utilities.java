import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static Image bg = Toolkit.getDefaultToolkit().createImage("Image/Sea.jpg");

    public static Image mfr = Toolkit.getDefaultToolkit().createImage("Image/MyFishRight.png");
    public static Image mfl = Toolkit.getDefaultToolkit().createImage("Image/MyFishLeft.png");

    static boolean UP = false;
    static boolean DOWN = false;
    static boolean LEFT = false;
    static boolean RIGHT = false;

    public static Image sel = Toolkit.getDefaultToolkit().createImage("Image/SmallEnemyLeft.png");
    public static Image ser = Toolkit.getDefaultToolkit().createImage("Image/SmallEnemyRight.png");
    public static Image mel = Toolkit.getDefaultToolkit().createImage("Image/MediumEnemyLeft.png");
    public static Image mer = Toolkit.getDefaultToolkit().createImage("Image/MediumEnemyRight.png");
    public static Image lel = Toolkit.getDefaultToolkit().createImage("Image/LargeEnemyLeft.png");
    public static Image ler = Toolkit.getDefaultToolkit().createImage("Image/LargeEnemyRight.png");
    public static Image bossl = Toolkit.getDefaultToolkit().createImage("Image/BossLeft.png");
    public static Image bossr = Toolkit.getDefaultToolkit().createImage("Image/BossRight.png");

    public static List<Enemy> EnemyList = new ArrayList<>();

    public static int point = 0  ;
    public static int level = 1;

}
