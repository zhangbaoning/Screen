import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhangbaoning on 2016/12/16.
 */
public class Bird {
    BufferedImage image;
    int x, y;
    int width, height;
    int size;   //小鸟的尺寸

    public Bird() {
        try {
            image = ImageIO.read(new File("C:\\Users\\zhangbaoning\\IdeaProjects\\Screen\\FlappyBird\\pic\\0.png")
            );
            width = image.getWidth();
            height = image.getHeight();
            x = 132;
            y = 280;
            size = 40;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
