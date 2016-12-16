import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhangbaoning on 2016/12/16.
 */
public class Ground {
    BufferedImage image;
    int x, y;
    int width, height;

    public Ground() {
        try {
            image = ImageIO.read(new File("C:\\Users\\zhangbaoning\\IdeaProjects\\Screen\\FlappyBird\\pic\\ground.png"));
            width = image.getWidth();
            height = image.getHeight();
            x = 0;
            y = 500;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
