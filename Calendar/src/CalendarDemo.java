import sun.util.calendar.CalendarDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhangbaoning on 2016/12/10.
 */
public class CalendarDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        //将日历格式化成字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = sdf.format(date);
        System.out.println(str);
        //将字符串转成日期
        //source必须要和SimpleDateFormat的格式化类型相同
        date = sdf.parse("2012-08-08 08:08:08");
        System.out.println(date);
        //根据语言环境
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        //时间计算
        System.out.println(sdf.format(calendar.getTime()));
        calendar.set(Calendar.YEAR,2008);
        calendar.set(Calendar.MONTH,Calendar.AUGUST);
        calendar.set(Calendar.DATE,8);
        System.out.println(calendar.getTime());

    }
}
