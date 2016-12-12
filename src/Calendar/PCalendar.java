package Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import Calendar.FrameCalendar;

/**
 * Created by zhangbaoning on 2016/12/10.
 */
public class PCalendar {
    //构造方法初始化

    public PCalendar() {
        calendar = Calendar.getInstance();
    }
    FrameCalendar view;

    public FrameCalendar getView() {
        return view;
    }

    public void setView(FrameCalendar view) {
        this.view = view;
    }

    Calendar calendar;//方法共享
    public String getYearAndMonth(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        return sdf.format(calendar.getTime());
    }
    public void incMonth(){
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH,month+1);
        view.showCalendar();
    }
    public void decMonth(){
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH,month-1);
        view.showCalendar();
    }
    //获取开始位置，即每月的一号是周几
    public int getFirstDayofWeek(){
        calendar.set(calendar.DATE,1);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    public int getMaxDay(){
        return calendar.getActualMaximum(Calendar.DATE);
    }
}
