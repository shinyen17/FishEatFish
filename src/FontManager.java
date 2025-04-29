import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontManager {
    private static Font bubblegumSans;

    static {
        try {
            bubblegumSans = Font.createFont(Font.TRUETYPE_FONT, new File("Font/BubblegumSans-Regular.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            bubblegumSans = new Font("Comic Sans MS", Font.BOLD, 100);
        }
    }

    public static Font getBSF(float size) {
        return bubblegumSans.deriveFont(size);
    }
}
