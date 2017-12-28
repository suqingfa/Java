package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        // 日期调整器

        // 一下个周三
        System.out.println(date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)));
        // 上一个周三
        System.out.println(date.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY)));

        System.out.println(date.with(w ->
        {
            // 计算下一个号数是3的周日
            LocalDate localDate = (LocalDate) w;
            do
            {
                localDate = localDate.plusDays(1);
            }
            while (localDate.getDayOfMonth() != 3 || localDate.getDayOfWeek() != DayOfWeek.SUNDAY);
            return localDate;
        }));

    }
}
