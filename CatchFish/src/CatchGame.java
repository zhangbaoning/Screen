import javax.swing.*;

/**
 * Created by zhangbaoning on 2016/12/13.
 */
public class CatchGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("捕鱼");
        CatchFish game = new CatchFish();
        frame.add(game);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  //设置居中
        frame.setResizable(false);  //禁止调整大小
        frame.setVisible(true);
        game.action();
    }
}
