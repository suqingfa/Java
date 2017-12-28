package time;

import java.time.ZoneId;

public class ZoneDemo
{
    public static void main(String[] args)
    {
        ZoneId.getAvailableZoneIds()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }
}
