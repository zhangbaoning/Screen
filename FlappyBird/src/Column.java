import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by zhangbaoning on 2016/12/16.
 */
public class Column {
    BufferedImage image;
    Random r = new Random();
    int x, y;
    int width, height;
    int gap;    //间隙
    int distance;   //两根柱子之间的距离

    public Column(int n) {
        try {
            image = ImageIO.read(new File("C:\\Users\\zhangbaoning\\IdeaProjects\\Screen\\FlappyBird\\pic\\column.png"));
            width = image.getWidth();
            height = image.getHeight();
            gap = 144;
            distance = 245;
            x = 550 + (n - 1) * distance;
            y = 800 + r.nextInt(218);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
