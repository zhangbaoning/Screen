import javax.swing.*;
    import java.awt.*;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;

    /**
     * Created by zhangbaoning on 2016/12/9.
     */

    //通过继承，使自定义类具有窗体功能
    public class Star  extends JFrame{
        //添加属性，让窗体可见
        //定义构造方法，与类同名，不能有返回值
        public static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        public Star() throws HeadlessException {
            //将面板添加到窗体
            MyPanel panel = new MyPanel();
            panel.move();
            add(panel);

            //添加尺寸,使用API，程序运行中的屏幕的尺寸
            setSize(dimension.width,dimension.height);
            //去掉窗体边框
            setUndecorated(true);
            //显示界面
            setVisible(true);
            //添加监听器，用于交互
            //参数是监听适配器
            MouseAdapter ma = new MouseAdapter() {
                //监听动作
                @Override
                public void mousePressed(MouseEvent e) {
                    //执行逻辑
                    System.exit(0);
                }
            };
            addMouseListener(ma);
        }

        public static void main(String[] args) {
           Star star =  new Star();
        }
    }
