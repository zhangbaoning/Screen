import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by zhangbaoning on 2016/12/13.
 */
public class Fish {
    BufferedImage image;
    BufferedImage images[];
    int x, y;
    int width, height;
    int step = 2;
    int index;
    Random r = new Random();

    public Fish(String name) {

        images = new BufferedImage[10];
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = ImageIO.read(new File("C:\\Users\\zhangbaoning\\IdeaProjects\\Screen\\CatchFish\\pic\\" + name + ".png"));
                image = images[i];
                width = image.getWidth();
                height = image.getHeight();
                x = r.nextInt(700) + width / 2;
                y = r.nextInt(500) + height / 2;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //动画
    public void move() {
        image = images[index++ % images.length];
        x -= step;
        if (x == -width / 2) {
            //表示越界
            getOut();//重置坐标

        }
    }

    public void getOut() {
        x = 700 + width / 2;
        y = r.nextInt(500);
        step = r.nextInt(5) + 2;
    }


}
