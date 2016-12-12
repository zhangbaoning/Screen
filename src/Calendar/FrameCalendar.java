package Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by zhangbaoning on 2016/12/12.
 */
public class FrameCalendar extends JFrame {

    JLabel yearAndMonth;
    JLabel[] days = new JLabel[7 * 6];
    PCalendar model;

    public FrameCalendar(PCalendar model) throws HeadlessException {

        this.model = model;
        this.model.setView(this);
        setTitle("万年历");    //设置标题
        setSize(400, 350);   //设置尺寸
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置默认关闭
        setLocationRelativeTo(null);    //设置窗体居中
        setResizable(false);    //设置不能最大化
    }

    public void showCalendar() {
        //清空面板上的内容
        for (int i = 0; i < days.length; i++) {
            days[i].setText("");
        }
        //获取数据
        String str = model.getYearAndMonth();
        yearAndMonth.setText(str);
        //开始位置
        int firstDayOfWeek = model.getFirstDayofWeek();
        int maxDay = model.getMaxDay();
        for (int i = 0; i < maxDay; i++) {
            days[firstDayOfWeek - 1+i].setText(i + 1 + "");
        }
    }

    public void init() {
        Container pane = getContentPane();  //获取系统面板
        pane.setLayout(null);//设置布局为null,自由布局
        JLabel decMonth = new JLabel("<<");//按钮：减小
        //设置位置
        decMonth.setBounds(130, 20, 20, 20);
        pane.add(decMonth); //添加到面板
        yearAndMonth = new JLabel("XXXX年XX月");
        yearAndMonth.setBounds(165, 20, 80, 20);
        pane.add(yearAndMonth);
        JLabel incMonth = new JLabel(">>");
        incMonth.setBounds(250, 20, 20, 20);
        pane.add(incMonth);
        JLabel[] weeks = {
                new JLabel("日"),
                new JLabel("一"),
                new JLabel("二"),
                new JLabel("三"),
                new JLabel("四"),
                new JLabel("五"),
                new JLabel("六"),
        };
        for (int i = 0; i < weeks.length; i++) {
            weeks[i].setBounds(40 + i * 50, 50, 50, 30);
            pane.add(weeks[i]);
        }
        //初始化每一天
        for (int i = 0; i < days.length; i++) {
            days[i] = new JLabel("1");//初始化
            /**
             *  x=40+(i%7)*50;
             *  y=90+(i/7)*30
             */
            days[i].setBounds(40 + (i % 7) * 50, 90 + (i / 7) * 30, 50, 30);
            pane.add(days[i]);
        }
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Component c = e.getComponent();
               JLabel lab = (JLabel) c;
               String str = lab.getText();
               if (str.equals(str)){
                    model.decMonth();
                   System.out.println("<<");
               }else {
                    model.incMonth();
                   System.out.println(">>");
               }
            }
        };
        incMonth.addMouseListener(ma);
        decMonth.addMouseListener(ma);
    }

    public static void main(String[] args) {

        FrameCalendar view = new FrameCalendar(new PCalendar());
        view.setVisible(true);
        view.init();
        view.showCalendar();
    }
}
