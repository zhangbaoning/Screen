/**
 * Created by zhangbaoning on 2016/12/10.
 */
public class PCalendarTest {

    public void getYearAndMonth() throws Exception {
        PCalendar pc = new PCalendar();
        String str = pc.getYearAndMonth();
        System.out.println(str);
        int firstday = pc.getFirstDayofWeek();
        System.out.println("一号是周:"+(firstday==0?"日":firstday-1));
        int maxDay = pc.getMaxDay();
        System.out.println("每月最大天数为"+maxDay);
    }

}