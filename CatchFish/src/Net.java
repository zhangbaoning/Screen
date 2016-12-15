import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhangbaoning on 2016/12/13.
 */
public class Net extends JPanel {
    BufferedImage image;
    int x, y;
    int width, height;
    boolean show;

    public Net() {
        try {
            image = ImageIO.read(new File("C:\\Users\\zhangbaoning\\IdeaProjects\\Screen\\CatchFish\\pic\\net09.png"));
            width = image.getWidth();
            height = image.getHeight();
            x = y = 0;
            show = true;    //渔网可见
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, x, y, null);
        System.out.println(x + " " + y);
    }

    //渔网随着鼠标移动
    public void moved(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean catchFish(Fish fish) {
        int dx1 = x - width / 2;
        int dx2 = x + width / 2;
        int dy1 = y - height / 2;
        int dy2 = y + height / 2;
        if (fish.x > dx1 && fish.x < dx2 && fish.y > dy1 && fish.y < dy2) {
            return true;
        } else {
            return false;
        }

    }
}
