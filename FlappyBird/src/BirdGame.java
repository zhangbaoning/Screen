import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhangbaoning on 2016/12/16.
 */
public class BirdGame extends JPanel {
    private static final long serialVersionUID = 2589405364206865880L;
    Bird bird;  //鸟
    Ground ground;  //地面
    Column column1, column2; //柱子
    BufferedImage background;   //背景

    public BirdGame() {
        column1 = new Column(1);
        column2 = new Column(2);
        bird = new Bird();
        ground = new Ground();
        try {
            background = ImageIO.read(new File("C:\\Users\\zhangbaoning\\IdeaProjects\\Screen\\FlappyBird\\pic\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(column1.image, column1.x - column1.width, column1.y - column1.height, null);
        g.drawImage(column2.image, column2.x - column1.width, column2.y - column2.height, null);

        g.drawImage(bird.image, bird.x - bird.width, bird.y - bird.height, null);
        g.drawImage(ground.image, ground.x, ground.y, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("fly");
        BirdGame game = new BirdGame();
        frame.add(game);
        frame.setSize(440, 670);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
