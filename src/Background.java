import java.awt.*;

public class Background {
    int width = 1000;
    int height = 600;

    public void paintBG(Graphics g){
        g.drawImage(Utilities.bg, 0, 0, width, height, null);
    }
}
