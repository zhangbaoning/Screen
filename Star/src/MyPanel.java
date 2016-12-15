import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

/**
 * 自定义面板
 * Created by zhangbaoning on 2016/12/9.
 */
public class MyPanel  extends JPanel{
    //添加构造方法
    int starNum = 200;
    int []x = new int[starNum];
    int []y = new int[starNum];
    Random r = new Random();
    public MyPanel() {

        //设置面板为黑色
        setBackground(Color.BLACK);
    }
    //重写绘制方法

    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类paint（）方法
        g.setColor(Color.YELLOW);//设置画笔颜色
        g.fillOval(800,100,100,100);
        g.setColor(Color.BLACK);
        g.fillOval(750,100,100,100);
        for (int i =0;i<starNum;i++){
            x[i] = r.nextInt(Star.dimension.width);
            y[i] = r.nextInt(Star.dimension.height);
        }
        for (int i =0;i<starNum;i++){
            int starSize = r.nextInt(50);
            //设置字体
            Font font = new Font("宋体",Font.BOLD,starSize);
            //设置颜色
            Color color = new Color(r.nextInt(0xFFFFFF));
            //设置颜色Graphics的颜色和字体样式
            g.setFont(font);
            g.setColor(color);
            g.drawString("*",x[i],y[i]);
        }

    }


    public void move() {
        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 300, 300);
    }
}
