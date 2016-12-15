import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhangbaoning on 2016/12/13.
 */
public class CatchFish extends JPanel {
    BufferedImage background;   //背景图片
    Fish[] fishs;
    Net net;
    int score;

    public CatchFish() {
        try {
            background = ImageIO.read(new File("C:\\Users\\zhangbaoning\\IdeaProjects\\Screen\\CatchFish\\pic\\bg.jpg"));
            net = new Net();    //初始化鱼
            fishs = new Fish[9];
            for (int i = 1; i <= fishs.length; i++) {
                fishs[i - 1] = new Fish("fish0" + i + "_0" + i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        if (net.show) {
            g.drawImage(net.image, net.x - net.width / 2, net.y - net.height / 2, null);
            for (int i = 0; i < fishs.length; i++) {
                Fish fish = fishs[i];
                g.drawImage(fish.image, fish.x - fish.width / 2, fish.y - fish.height / 2, null);
                //画分数
                Font font = new Font(Font.SANS_SERIF, Font.BOLD, 25);
                g.drawString("" + score, 20, 30);
                g.setColor(Color.WHITE);
                g.drawString("" + score, 20 - 2, 30 - 2);

            }
        }
    }

    public void mouseAction() {
        //创建监听器对象，并添加到面板
        MouseAdapter ma = new MouseAdapter() {
            //鼠标的移入和移出
            public void mouseEntered(MouseEvent e) {
                //当鼠标移入窗体
                net.show = true;
            }

            public void mouseExited(MouseEvent e) {
                //当鼠标移出
                net.show = false;
            }

            //鼠标移动，让渔网跟鼠标一块动
            public void mouseMoved(MouseEvent e) {
                //通过MouseEvent对象获取鼠标位置
                int x = e.getX();
                int y = e.getY();
                net.moved(x, y);//渔网定义移动方法
            }

            //当鼠标按下可以捕鱼
            public void mousePressed(MouseEvent e) {
                //捕鱼
                catchFish();

            }

        };//监听结束
        this.addMouseListener(ma);
        this.addMouseMotionListener(ma);
    }

    public void action() {
        mouseAction();//监听
        //更改数据
        while (true) {
            for (int i = 0; i < fishs.length; i++) {
                //通过循环拿到所有鱼
                fishs[i].move();
            }
            //使用线程控制
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
            //数据更改后，及时更新界面
            repaint();
        }
    }

    public void catchFish() {
        //遍历鱼的数组
        for (int i = 0; i < fishs.length; i++) {
            Fish f = fishs[i];
            //捕到鱼
            f.getOut();
            score += f.width / 2;


        }

    }

}

